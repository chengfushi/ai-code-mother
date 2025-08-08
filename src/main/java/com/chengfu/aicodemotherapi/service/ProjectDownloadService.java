package com.chengfu.aicodemotherapi.service;

import jakarta.servlet.http.HttpServletResponse;

/**
 * @Author: Chengfu Shi
 * @Description: 文件下载服务
 **/
public interface ProjectDownloadService {
    void downloadProjectAsZip(String projectPath, String downloadFileName, HttpServletResponse response);
}
