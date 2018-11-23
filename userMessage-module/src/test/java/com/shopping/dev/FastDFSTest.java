package com.shopping.dev;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.config.SpringDataAnnotationBeanNameGenerator;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 创建人: 武奇
 * 创建事件: 2018/11/7
 */

public class FastDFSTest {

    @Test
    public void test() throws IOException, MyException {
///front-module/src/main/resources/static/images/defaultImgs/1.jpg
        String path = "C:/Users/Administrator/Desktop/17.jpg";
        ClientGlobal.initByProperties("fastdfs.properties");
        System.out.println(ClientGlobal.configInfo());
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);

        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        File file = new File(path);

        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int l = -1;
        while ((l = fileInputStream.read(buff)) != -1) {
            out.write(buff, 0, l);
        }
        byte[] bytes1 = out.toByteArray();

        String name = file.getName();
        String s = name.substring(name.lastIndexOf(".") + 1).trim().toLowerCase();
        System.out.println(s);

        String[] strings = storageClient.upload_file(bytes1, 0, bytes1.length, "jpg", null);

        System.out.println(strings[0]);
        System.out.println(strings[1]);

    }

}
