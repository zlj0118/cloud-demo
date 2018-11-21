import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
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

        ClientGlobal.initByProperties("fastdfs.properties");
        System.out.println(ClientGlobal.configInfo());
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
//        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//        byte[] bytes = "HelloFastDFS".getBytes();
        String srcPath = "C:\\Users\\Administrator\\Desktop\\psb.jpg";
        FileInputStream fis = new FileInputStream(srcPath);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] buff = new byte[1024];
        int length = -1;

        while ((length = fis.read(buff)) != -1) {
            out.write(buff, 0, length);
        }
        byte[] bytes = out.toByteArray();

        String[] strings = storageClient.upload_file(bytes, 0, bytes.length, "txt", null);
        System.out.println(Arrays.toString(strings));

    }

}
