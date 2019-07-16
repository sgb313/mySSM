package com.sgb.utils;

import java.util.UUID;

public class ImageName {

//    将下载的文件的名字设置为文件本身的名字
    public static String getImageName(String path){
        //       去掉路径
        String sub = path.substring(path.lastIndexOf("/") + 1);
//       去掉UUID
        int length = UUID.randomUUID().toString().length();
        String imageName = sub.substring(length);
        return imageName;
    }

}
