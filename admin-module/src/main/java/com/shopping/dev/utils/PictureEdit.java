package com.shopping.dev.utils;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGDecodeParam;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public class PictureEdit {
    private final static String WATER = "water.png";

    public static byte[] edit(MultipartFile uploadFile) {
        try {
            InputStream uploadFileInputStream = uploadFile.getInputStream();
            // .toFile也可替换为下面两个方法转换成流.asBufferedImage().toOutputStream()
            BufferedImage jpg = Thumbnails.of(uploadFileInputStream)
                    // 按宽高比进行缩或放
                    .size(500, 500)
                    // 不保持原有比例,与.size()配合使用,默认值为true
//                .keepAspectRatio(false)
                    // 添加水印,参数分别为位置,水印图片与水印透明度
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(WATER)), 1F)
                    // 按比例进行缩放
//                .scale(0.5)
                    // 旋转角度:正数顺时针
//                .rotate(90)
                    // 按比例缩放,图片占用内存变化与比例不对应(在不设置outputQuality时,压缩量会很大)
//                    .scale(0.25)
                    // 裁剪图片,x,y表示图片左上角为坐标,指定裁剪大小,坐标也可以用Positions.进行指定
                    // 宽高加上width与height设置超出图片会抛出IllegalArgumentException
//                .sourceRegion(50,0,100,200)
                    // 设置输出图片质量
//                .outputQuality(1)
                    // 设置输出图片格式
                    .outputFormat("jpg")
                    // 输出文件需要指定size属性,.scale()与.size()这两个方法可以添加size属性
//                    .toFile(EDIT_PATH);
                    .asBufferedImage();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(jpg, "jpg", out);
            return out.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

    public static void getMessage(MultipartFile uploadFile) throws IOException, JpegProcessingException {
        InputStream inputStream = uploadFile.getInputStream();
        OutputStream outputStream = new FileOutputStream("test-msg.jpg");
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) > 0) {
            outputStream.write(bytes, 0, bytes.length);
        }
        Metadata metadata = JpegMetadataReader.readMetadata(new File("test-msg.jpg"));
        for (Directory next : metadata.getDirectories()) {
            for (Tag tag : next.getTags()) {
                System.out.println(tag);
            }
        }
    }
}
