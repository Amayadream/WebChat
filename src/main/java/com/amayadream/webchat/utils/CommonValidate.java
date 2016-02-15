package com.amayadream.webchat.utils;

import java.io.File;

/**
 * 公共验证工具类
 * @author :  Amayadream
 * @time :  2016.02.01 16:20
 */
public class CommonValidate {

    /**
     * 判断字符串是否为空
     * @param str   字符串
     * @return  非空返回true,空返回false
     */
    public static boolean validateEmpty(String str){
        try{
            return str != null && str.length() != 0;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断字符串长度是否长于或者等于指定值
     * @param str   字符串
     * @param n     预期长度
     * @return  大于或者等于返回true, 小于返回false
     */
    public static boolean validateLonth(String str, int n){
        try {
            return str.length() >= n;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 补全路径尾部/
     * @param path  路径
     * @return  path
     */
    public String checkPathEnd(String path){
        return path.endsWith("\\") ? path : path + "\\";
    }

    /**
     * 补全字符串后缀斜杠
     * @param str    字符串
     * @return
     */
    public String checkStringEnd(String str){
        return str.endsWith("/") ? str : str + "/";
    }

    /**
     * 判断文件是否存在
     * @param path  路径
     * @param fileName  文件名
     * @return  true|false
     */
    public boolean validateFileExist(String path, String fileName){
        return new File(checkPathEnd(path) + fileName).exists();
    }

    /**
     * 判断文件是否存在
     * @param path  路径+文件名
     * @return  true|false
     */
    public boolean validateFileExist(String path){
        return new File(path).exists();
    }

    /**
     * 循环判断文件是否存在,如果存在则给文件后面加上特定标记
     * @param path      文件路径
     * @param fileName  文件名
     * @param mark      标记
     * @return  返回可用的文件名
     */
    public String validateRepeatFileName(String path, String fileName, String mark){
        if(fileName.contains(".")){    //如果文件有后缀名
            while(validateFileExist(path,fileName)){
                String name = fileName.substring(0, fileName.lastIndexOf("."));
                String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
                fileName = name + mark + "." + prefix;
                validateRepeatFileName(path, fileName, mark);
            }
        }else{      //如果没有后缀名
            while(validateFileExist(path, fileName)){
                fileName = fileName + mark;
                validateRepeatFileName(path, fileName, mark);
            }
        }
        return fileName;
    }


}
