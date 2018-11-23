package com.shopping.dev;

//import org.csource.common.MyException;
//import org.csource.fastdfs.*;
//import org.junit.Test;

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

//    @Test
//    public void test() throws IOException, MyException {
//
//        ClientGlobal.initByProperties("fastdfs.properties");
//        System.out.println(ClientGlobal.configInfo());
//        TrackerClient trackerClient = new TrackerClient();
//        TrackerServer trackerServer = trackerClient.getConnection();
//        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
////        StorageServer storageServer = null;
//        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//
////        byte[] bytes = "kobe".getBytes();
//        String path= "C:/Users/Administrator/Desktop/back.png";
//        try {
//            File file = new File(path);
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            FileInputStream in = new FileInputStream(file);
//            byte[] buff = new byte[1024];
//            int  length= -1;
//            while ((length=in.read(buff))!=-1){
//                outputStream.write(buff,0,length);
//            }
//            in.close();
//            byte[] array = outputStream.toByteArray();
//            outputStream.close();  String[] strings = storageClient.upload_file(array, 0, array.length, "txt", null);
//            System.out.println("strings"+Arrays.toString(strings));
//            String str = "/";
//            for (String s : strings) {
////                System.out.println(s);
//                str += (s + "/");
//            }
//            String string = str.substring(0, str.lastIndexOf("/"));
//            System.out.println(str);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }|

}
