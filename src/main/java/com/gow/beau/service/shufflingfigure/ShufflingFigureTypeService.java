package com.gow.beau.service.shufflingfigure;

/**
 * @ClassName ShufflingFigureTypeService
 * @Author lzn
 * @DATE 2019/9/24 11:29
 */
public class ShufflingFigureTypeService {

    /**
     * 处理类型名称
     * */
    public static String getTypeText(String type){
        //类型（1：移动端首页轮播图，2：PC端）
        String typeF = "";
        if(type instanceof String) {
            switch (type) {
                case "1":
                    typeF = "移动端首页轮播图";
                    break;
                case "2":
                    typeF = "PC端首页轮播图";
                    break;
            }
        }
        return typeF;
    }
}
