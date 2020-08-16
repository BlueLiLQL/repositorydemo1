package com.lql.filedemo;

import java.io.File;

/**
 * 文件操作之查找文件
 *
 */
public class Filedemo1 {

    public static void main(String[] args) {
        findFile(new File("C:\\Users\\BalalaEnergy\\Desktop"),".jpg");
    }

    /**
     * 查找文件
     * @param target 目标文件
     * @param ext    文件后缀名
     */
    private static void findFile(File target,String ext){

        //1、判断目标文件是否为文件夹
        if(target.isDirectory()){
            File[] files = target.listFiles();
            for (File file : files) {
                //递归判断时候为文件夹
                findFile(file,ext);
            }
        }else{
            String exName = target.getName().toLowerCase();
            if(exName.endsWith(ext)){
                //如果以ext结尾的文件，
                System.out.println(target.getAbsolutePath());
            }
        }

    }
}
