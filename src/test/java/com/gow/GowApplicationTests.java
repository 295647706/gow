package com.gow;

import com.gow.beau.util.ImageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GowApplicationTests {

    /**
     * 压缩图片
     */
    @Test
    public void reduceImage(){
        String path = "C:/Users/Administrator/Desktop/image/";
        String[] names = {"m2.jpg","m3.jpg","m4.jpg"};
        if(null != names && names.length > 0) {
            for(String name : names) {
                if (name instanceof String) {
                    String url = path + name;
                    ImageUtil.reduceImage(url, null, 1080, 460);
                }
            }
        }
    }

}

