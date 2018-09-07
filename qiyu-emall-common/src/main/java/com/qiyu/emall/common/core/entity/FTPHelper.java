package com.qiyu.emall.common.core.entity;

/**
 * Created by WUH on 2017/3/8.
 * ftp 帮助类
 */
public class FTPHelper {

    private String url;
    private int port;
    private String username;
    private String password;

    private String remotePath;

    /**
     *
     * @param url url
     * @param port 端口号
     * @param username 用户名
     * @param password 密码
     * @param remotePath 远程路径
     */
    public FTPHelper(String url, int port, String username, String password, String remotePath){
        this.url = url;
        this.port = port;
        this.username = username;
        this.password = password;
        this.remotePath = remotePath;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

}
