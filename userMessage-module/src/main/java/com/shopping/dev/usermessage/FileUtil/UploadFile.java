package com.shopping.dev.usermessage.FileUtil;


import org.csource.fastdfs.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class UploadFile {

    public static String[] uploadFile(MultipartFile file) throws Exception {


        ClientGlobal.initByProperties("fastdfs.properties");
        System.out.println(ClientGlobal.configInfo());
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);

        StorageClient storageClient = new StorageClient(trackerServer, storageServer);

        byte[] bytes = file.getBytes();
        String originalFilename = file.getOriginalFilename();

        String s = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).trim().toLowerCase();


        String[] strings = storageClient.upload_file(bytes, 0, bytes.length, s, null);
        System.out.println(Arrays.toString(strings));

        return strings;

    }

}

