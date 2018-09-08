package com.qiyu.emall.common.core.utils;

import com.qiyu.emall.common.core.constants.BusinessExceptionEnum;
import com.qiyu.emall.common.core.entity.FTPHelper;
import com.qiyu.emall.common.core.exception.BusinessException;
import com.qiyu.emall.common.core.utils.FtpConfig;
import com.qiyu.emall.common.core.utils.StringUtils;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import org.apache.commons.net.ftp.FTPClient;

public class FtpUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FtpUtil.class);

    private static FTPClient ftp;

    /**
     * 获取ftp连接
     *
     * @param f 配置
     * @return boolean
     * @throws Exception
     */
    public static boolean connectFtp(FtpConfig f) throws Exception {
        ftp = new FTPClient();
        boolean flag;
        int reply;
        if (f.getPort() == null) {
            ftp.connect(f.getIpAddr(), 21);
        } else {
            ftp.connect(f.getIpAddr(), f.getPort());
        }
        ftp.login(f.getUserName(), f.getPwd());
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            flag = false;
        } else {
            ftp.changeWorkingDirectory(f.getPath());
            flag = true;
        }
        ftp.enterLocalPassiveMode();
        ftp.setRemoteVerificationEnabled(false);
        return flag;
    }

    /**
     * 关闭ftp连接
     */
    public static void closeFtp() {
        if (ftp != null && ftp.isConnected()) {
            try {
                ftp.logout();
                ftp.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ftp上传文件
     *
     * @param f 文件
     * @throws Exception
     */
    public static void upload(File f) throws Exception {
        if (f.isDirectory()) {
            ftp.makeDirectory(f.getName());
            ftp.changeWorkingDirectory(f.getName());
            String[] files = f.list();
            for (String fstr : files) {
                File file1 = new File(f.getPath() + "/" + fstr);
                if (file1.isDirectory()) {
                    upload(file1);
                    ftp.changeToParentDirectory();
                } else {
                    File file2 = new File(f.getPath() + "/" + fstr);
                    FileInputStream input = new FileInputStream(file2);
                    ftp.storeFile(file2.getName(), input);
                    input.close();
                }
            }
        } else {
            File file2 = new File(f.getPath());
            FileInputStream input = new FileInputStream(file2);
            ftp.storeFile(file2.getName(), input);
            input.close();
        }
    }

    /**
     * 下载链接配置
     *
     * @param f             ftp配置
     * @param fileName      要下载的文件名，不指定则下载所有文件
     * @param localBaseDir  本地目录
     * @param remoteBaseDir 远程目录
     * @throws Exception
     */
    public static void startDown(FtpConfig f, String fileName, String localBaseDir, String remoteBaseDir) throws Exception {
        if (FtpUtil.connectFtp(f)) {

            try {
                FTPFile[] files;
                boolean changedir = ftp.changeWorkingDirectory(remoteBaseDir);
                if (changedir) {
                    ftp.setControlEncoding("GBK");
                    files = ftp.listFiles();
                    for (FTPFile file : files) {
                        try {
                            if (StringUtils.isEmpty(fileName)) {
                                downloadFile(file, localBaseDir, remoteBaseDir);
                            } else if (file.getName().endsWith(fileName)) {
                                LOGGER.info("download file={},fileEndPath={}",file.getName(),fileName);
                                downloadFile(file, localBaseDir, remoteBaseDir);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            LOGGER.error("ftpConfig={},errMsg={}", f, e.getMessage());
                            throw new BusinessException(BusinessExceptionEnum.EXC_ERROR_PARAM_SYSTEM);
                        }
                    }
                } else {
                    LOGGER.error("下载目录不存在,ftpConfig={}", f);
                    throw new BusinessException(BusinessExceptionEnum.EXC_ERROR_PARAM_SYSTEM);
                }
            } catch (Exception e) {
                LOGGER.error("下载过程中出现异常,ftpConfig={},errMsg={}", f, e.getMessage());
                throw new BusinessException(BusinessExceptionEnum.EXC_ERROR_PARAM_SYSTEM);
            }
        } else {
            LOGGER.error("链接失败!ftpConfig={}", f);
            throw new BusinessException(BusinessExceptionEnum.EXC_ERROR_PARAM_SYSTEM);
        }

    }


    /**
     * 下载FTP文件
     * 当你需要下载FTP文件的时候，调用此方法
     * 根据<b>获取的文件名，本地地址，远程地址</b>进行下载
     *
     * @param ftpFile            要下载的文件
     * @param relativeLocalPath  本地路径
     * @param relativeRemotePath 远程路径
     */
    private static void downloadFile(FTPFile ftpFile, String relativeLocalPath, String relativeRemotePath) {
        if (ftpFile.isFile()) {
            if (!ftpFile.getName().contains("?")) {
                OutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(relativeLocalPath + ftpFile.getName());
                    ftp.retrieveFile(ftpFile.getName(), outputStream);
                    outputStream.flush();
                    outputStream.close();
                } catch (Exception e) {
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();
                } finally {
                    try {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    } catch (IOException e) {
                        LOGGER.error("输出文件流异常");
                    }
                }
            }
        } else {
            String newlocalRelatePath = relativeLocalPath + ftpFile.getName();
            String newRemote = relativeRemotePath + ftpFile.getName();
            File fl = new File(newlocalRelatePath);
            if (!fl.exists()) {
                fl.mkdirs();
            }
            try {
                newlocalRelatePath = newlocalRelatePath + '/';
                newRemote = newRemote + "/";
                String currentWorkDir = ftpFile.getName();
                boolean changedir = ftp.changeWorkingDirectory(currentWorkDir);
                if (changedir) {
                    FTPFile[] files;
                    files = ftp.listFiles();
                    for (FTPFile file : files) {
                        downloadFile(file, newlocalRelatePath, newRemote);
                    }
                }
                if (changedir) {
                    ftp.changeToParentDirectory();
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        try {
			
            FtpConfig f = new FtpConfig();
            f.setIpAddr("115.231.94.165");
            f.setUserName("jfuser");
            f.setPwd("GAmPckKIit6JDHqOafMA");
            f.setPath("/ftp");
            FtpUtil.connectFtp(f);
            File file = new File("C:/rongyi/work/test2.txt");
//            FtpUtil.upload(file);//把文件上传在ftp上
            FtpUtil.startDown(f, "text2.txt", "c:/data/", "/ftp");//下载ftp文件测试
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 需要在调用处负责关闭流
     * @param ftpHelper ftp帮助类
     * @param inputStream 输入流
     * @param fileName 文件名
     * @return 上传是否成功
     */
    public static boolean uploadFile(FTPHelper ftpHelper, InputStream inputStream, String fileName, String charSet) {
        FTPClient ftp = null;
        try {
            ftp = getConnection(ftpHelper.getUrl(), ftpHelper.getPort(), ftpHelper.getUsername(), ftpHelper.getPassword(), charSet);
            if(ftp == null){
                return false;
            }
            ftp.changeWorkingDirectory(ftpHelper.getRemotePath());
            ftp.storeFile(fileName, inputStream);
            inputStream.close();
        } catch (IOException e) {
            LOGGER.error("上传文件异常。 e: " + e.getMessage());
        } finally {
           disConnection(ftp);
        }
        return true;
    }

    /**
     * 需要在调用处负责关闭流
     * @param ftpHelper ftp帮助类
     * @param outputStream 输出流
     * @param fileName 文件名
     * @return 下载是否成功
     */
    public static boolean downFile(FTPHelper ftpHelper, OutputStream outputStream, String fileName, String charset) {
        FTPClient ftp = null;
        try {
            ftp = getConnection(ftpHelper.getUrl(), ftpHelper.getPort(), ftpHelper.getUsername(), ftpHelper.getPassword(), charset);
            if(ftp == null){
                return false;
            }
            ftp.changeWorkingDirectory(ftpHelper.getRemotePath());//转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            for(FTPFile ff:fs){
                if(ff.getName().equals(fileName)){
                    ftp.retrieveFile(ff.getName(), outputStream);
                }
            }
        } catch (IOException e) {
            LOGGER.error("下载文件异常。 e: " + e.getMessage());
        } finally {
            disConnection(ftp);
        }
        return true;
    }

    public static InputStream downloadInputStream(FTPHelper ftpHelper, String fileName, String charSet){
        FTPClient ftp = null;
        try {
            ftp = getConnection(ftpHelper.getUrl(), ftpHelper.getPort(), ftpHelper.getUsername(), ftpHelper.getPassword(), charSet);
            if(ftp == null){
                return null;
            }
            ftp.changeWorkingDirectory(ftpHelper.getRemotePath());//转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            for(FTPFile ff:fs){
                if(ff.getName().equals(fileName)){
                   return ftp.retrieveFileStream(ff.getName());
                }
            }
        } catch (IOException e) {
            LOGGER.error("下载文件异常。 e: " + e.getMessage());
        } finally {
            disConnection(ftp);
        }
        return null;
    }

    private static FTPClient getConnection(String url, int port, String username, String password, String charSet){
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.setControlEncoding(charSet);
            ftp.connect(url, port);//连接FTP服务器
            //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);//登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return null;
            }
            ftp.enterLocalPassiveMode();
            ftp.setRemoteVerificationEnabled(false);
        }catch (Exception e){
            LOGGER.error("FTP获取连接异常。 e: " + e.getMessage());
        }
        return ftp;
    }

    private static void disConnection(FTPClient ftp){
        if(ftp != null && ftp.isConnected()){
            try {
                ftp.logout();
                ftp.disconnect();
            } catch (IOException e) {
                LOGGER.error("断开连接失败。 e:" + e.getMessage());
            }
        }
    }

    public static byte[] stream2ByteArray(InputStream inputStream, String charsetName) throws Exception{
        StringBuilder sb = new StringBuilder();
        char[] chars = new char[1024];
        int size;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charsetName))){
            while((size = reader.read(chars)) != -1){
                sb.append(chars, 0, size);
            }
        }
        return sb.toString().getBytes();
    }
}