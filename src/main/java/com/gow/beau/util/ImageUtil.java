package com.gow.beau.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.thymeleaf.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @ClassName ImageUtil
 * @Author lzn
 * @DATE 2019/9/26 11:22
 * 图片处理
 */
public class ImageUtil {

    /**
     * 按指定图片宽度和高度进行压缩
     * */
    public static void reduceImage(String imageFile,String imageNewFile,int width,int height){
        try{
            File file = new File(imageFile);
            //检查图片文件是否存在
            if(!file.exists()){
                System.err.println("文件不存在");
                return;
            }
            if(null == imageNewFile || imageNewFile.equals("")) {
                //文件格式
                String ext = org.thymeleaf.util.StringUtils.substringAfter(imageFile, ".");
                //文件名称
                String fileName = StringUtils.substringBefore(imageFile, ".");
                imageNewFile = fileName+"_2"+"."+ext;
            }
            //开始读取文件并进行压缩
            Image image = ImageIO.read(file);
            reduceImage(image,imageNewFile,width,height);
        }catch (Exception e){
            e.getMessage();
        }
    }

    /**
     * 压缩并输出
     * */
    public static void reduceImage(Image image,String imageNewFile,int width,int height){
        try {
            //构造一个类型为预定图片类型
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //绘制图像
            bufferedImage.getGraphics().drawImage(image.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
            //创建文件输出流
            FileOutputStream fileOutputStream = new FileOutputStream(imageNewFile);
            //将图片按JPEG压缩，保存到out中
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fileOutputStream);
            encoder.encode(bufferedImage);
            fileOutputStream.close();
        }catch (Exception e){
            e.getMessage();
        }
    }



    /**
     * 按比例对图片压缩
     * */
    public static void reduceImage(String imageFile,String imageNewFile,Double rate){
        if(null == rate || rate <= 0){
            rate = 0.8;
        }
        try{
            File file = new File(imageFile);
            //检查图片文件是否存在
            if(!file.exists()){
                System.err.println("文件不存在");
                return;
            }
            //获得图片宽高
            int[] results = getImageWidthHeight(file);
            if(null == results){
                return;
            }
            if(results[0] == 0 || results[1] == 0){
                return;
            }
            int width = (int)(results[0] * rate);
            int height = (int)(results[1] * rate);
            //压缩
            reduceImage(imageFile,imageNewFile,width,height);
        }catch (Exception e){
            e.getMessage();
        }
    }

    /**
     * @param file
     * 获取图片宽度和高度
     * */
    public static int[] getImageWidthHeight(File file){
        InputStream inputStream = null;
        int result[] = {0,0};
        try{
            //获取文件输入流
            inputStream = new FileInputStream(file);
            //输入流中将图片写入缓冲图片区
            result = getImageWidthHeight(inputStream);
            inputStream.close();
        }catch (Exception e){
            e.getMessage();
        }
        return result;
    }


    /**
     * @param inputStream
     * 获取图片宽度和高度
     * */
    public static int[] getImageWidthHeight(InputStream inputStream){
        BufferedImage bufferedImage = null;
        int result[] = {0,0};
        try{
            //输入流中将图片写入缓冲图片区
            bufferedImage = getBufferedImage(inputStream);
            //宽
            result[0] = bufferedImage.getWidth();
            //高
            result[1] = bufferedImage.getHeight();
            inputStream.close();
        }catch (Exception e){
            e.getMessage();
        }
        return result;
    }

    /**
     * @param file
     * 获取图片缓冲类
     * */
    public static BufferedImage getBufferedImage(File file){
        try{
            InputStream inputStream = new FileInputStream(file);
            return getBufferedImage(inputStream);
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    /**
     * @param inputStream
     * 获取图片缓冲类
     * */
    public static BufferedImage getBufferedImage(InputStream inputStream){
        try{
            //输入流中将图片写入缓冲图片区
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            return bufferedImage;
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }
}
