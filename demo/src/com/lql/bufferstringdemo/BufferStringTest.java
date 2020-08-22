package com.lql.bufferstringdemo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class BufferStringTest {
    public static void main(String[] args) {

    }

    //字节写入
    private static void byteWrite(){
        File file = new File("C:\\Users\\BalalaEnergy\\Desktop\\新建文本文档.txt");
        try{
            FileOutputStream out = new FileOutputStream(file);
            //构造一个字节缓冲流
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
            //
            String info = "大河向东流";
            bufferedOutputStream.write(info.getBytes());
            bufferedOutputStream.close();
//            out.close();
            //JDK 1.7之后新语法：
            //outputStream放在try语句块中，关闭BufferedOutputStream时会自动关闭out，不需要手动关闭
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
