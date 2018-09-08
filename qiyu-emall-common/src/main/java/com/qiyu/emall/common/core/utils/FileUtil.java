package com.qiyu.emall.common.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FileUtil {
	protected static Logger logger = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * 获得文件列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<File> getFileList(String path) throws Exception {
		List<File> list = new ArrayList<File>();
		File[] filearr = null;

		File file = new File(path);
		if (file.exists()) {
			filearr = file.listFiles();
			for (int i = 0; i < filearr.length; i++) {
				if (filearr[i].isDirectory()) {
					continue;
				} else {
					list.add(filearr[i]);
				}
			}
			return list;
		} else
			return null;
	}

	/**
	 * 生成图片文件名
	 * 
	 * @param userType
	 * @param orderType
	 * @return
	 */
	public static String generateFileName() {
		String date = DateTool.getCurrentDateYYMMDD();
		String hmssss = DateTool.getCurrentHMSSSS();
		Random random = new Random();
		int hzrandom = random.nextInt(10);
		String name = date + hmssss + hzrandom;
		return name;
	}

	/**
	 * 下载文件到本地
	 * 
	 * @param urlString
	 *            被下载的文件地址
	 * @param filename
	 *            本地文件名
	 * @throws Exception
	 *             各种异常
	 */
	public static String download(String urlString, String localPath) throws Exception {
		String filename = "";
		if (urlString.lastIndexOf(".") > -1) {
			filename = FileUtil.generateFileName() + urlString.substring(urlString.lastIndexOf("."), urlString.length());
		} else {
			throw new Exception("远程图片路径有异常！");
		}
		// 构造URL
		URL url = new URL(urlString);
		// 打开连接
		URLConnection con = url.openConnection();
		// 输入流
		InputStream is = con.getInputStream();
		// 1K的数据缓冲
		byte[] bs = new byte[1024];
		// 读取到的数据长度
		int len;
		// 输出的文件流
		OutputStream os = new FileOutputStream(localPath + filename);
		// 开始读取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完毕，关闭所有链接
		os.close();
		is.close();
		return filename;
	}

	/**
	 * 删除单个文件
	 * 
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			flag = file.delete();
//			flag = true;
		} else {
			System.out.println(sPath + ">>>文件不存在");
		}
		return flag;
	}

	public static boolean upload(String urlString, String localPath) throws Exception {
		logger.info("urlString:"+urlString + ";\n localPath:" + localPath);
		OutputStream os =null;
		FileInputStream fis =null;
		try {
			File f = new File(localPath);
			if (!f.exists()) {
				throw new RuntimeException(localPath+"不存在");
//				return false;
			}
			String fileName = localPath.substring(localPath.lastIndexOf("/")+1);
			URL url = new URL(urlString);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			String BOUNDARY = "---------------------------41184676334";

			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Charsert", "UTF-8");
			conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:12.0) Gecko/20100101 Firefox/12.0"); // 可以不指定
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

			conn.setAllowUserInteraction(false); // 无需用户交互，即弹出https等的对话框。
			conn.setChunkedStreamingMode(1024); // 告诉HttpUrlConnection,我们需要采用流方式上传数据，无需本地缓存数据。HttpUrlConnection默认是将所有数据读到本地缓存，然后再发送给服务器，这样上传大文件时就会导致内存溢出。

			byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
			StringBuffer sb = new StringBuffer();

			sb.append("--").append(BOUNDARY).append("\r\n");

			sb.append("Content-Disposition: form-data; name=\"upload\"; filename=\""+fileName+"\"\r\n");
			sb.append("Content-Type: application/octet-stream\r\n\r\n");

			byte[] data = sb.toString().getBytes();
			long fLen = f.length();
			long contentLen = data.length + fLen + end_data.length;
			conn.setRequestProperty("Content-Length", String.valueOf(contentLen)); // 不清楚长度，可以不写
			os = conn.getOutputStream();
			os.write(data); // 发送非文件数据

			fis = new FileInputStream(f); // 读取文件内容，发送数据，数据要一点点发送，不能一下全部读取发送，否则会内存溢出。
			int rn;
			byte[] buf = new byte[1024];
			logger.info("开始写数据");
			int index_ = 0;
			while ((rn = fis.read(buf, 0, 1024)) > 0) {
				if(index_ % 5000 == 0) {
					logger.info("   index:"+index_);
				}
				os.write(buf, 0, rn);
				index_++;
			}
			os.write(end_data);
			os.flush();
			logger.info("数据写成功");
			Integer status = conn.getResponseCode();
			logger.info("status:"+status);			
			if(status==2000){
				return true;
			}
			if(status == 5000){
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			if(os!=null){
				os.close();
			}
			if(fis!=null){
				fis.close();
			}
		}
	}
	
	public static void main(String args[]){
		try {
			upload("http://localhost:8080/mallCmsApi/uploadMallActivitiesFile.action","E:\\627大宁宣传片.mp4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
