package com.gow.beau.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @ClassName Base64Utils
 * @Author lzn
 * @DATE 2019/9/12 14:42
 */
public class Base64Utils {

    /**
     * 图片转换成base64字符串
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     * @param imgFile	图片本地路径
     * @return
     */
    public static String imageToBase64ByLocal(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        return encoder.encode(data);
    }


    /**
     * base64字符串转换成图片
     * 对字节数组字符串进行Base64解码并生成图片
     * @param imgStr		base64字符串
     * @param imgFilePath	图片存放路径
     * @return
     */
    public static boolean base64ToImage(String imgStr,String imgFilePath) {

        // 图像数据为空
        if (StringUtils.isBlank(imgStr)) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }



    /**
     * 获取src 图片
     * */
    public static String imageToBase64BySrc(String imgFile){
        File file = new File(imgFile);
        if(file.exists()) {
            //文件格式
            String ext = org.thymeleaf.util.StringUtils.substringAfter(imgFile, ".");
            String base64Image = Base64Utils.imageToBase64ByLocal(imgFile);
            base64Image = "data:image/" + ext + ";base64," + base64Image;
            return base64Image;
        }
        return imgFile;
    }
}
