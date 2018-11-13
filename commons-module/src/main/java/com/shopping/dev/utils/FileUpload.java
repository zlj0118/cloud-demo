package com.shopping.dev.utils;


import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileUpload {

    public static String fileUpload(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        try {
            ClientGlobal.initByProperties("fastdfs.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            // 获取到上传文件的字节数组
            byte[] bytes = file.getBytes();
            String[] strings = storageClient.upload_file(bytes, 0, bytes.length, fileType, null);
            String str = "/";
            for (String s : strings) {
                str += (s + "/");
            }
            str = str.substring(0, str.lastIndexOf("/"));
            String path = "http://35.220.246.127:8080"+str;
            return path;
        } catch (MyException e) {
            throw new Exception();
        }

    }

}
