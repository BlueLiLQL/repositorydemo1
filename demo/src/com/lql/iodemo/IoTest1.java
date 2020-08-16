package com.lql.iodemo;

import java.io.*;

/**
 * 字节输入输出流
 * 输出流: 超类OutputStream，对文件的输出流使用子类FileOutputStream
 * 输入流：超类InputStream,对文件的输入流使用子类FileInputStream
 */
public class IoTest1 {
    //private static OutputStream outputStream;
    public static void main(String[] args) throws IOException {
        //out();
        in();
    }

    private static void out() throws IOException {
        OutputStream outputStream = null;
        //1、构建一个文件输出流对象
        try {
            //获取输出流
             outputStream = new FileOutputStream(new File("C:\\Users\\BalalaEnergy\\Desktop\\iotest.txt"),true);

            //输出内容
            String s = "emmmmmmmm\n";
            for(int i = 0; i< s.length(); i++){
                outputStream.write(s.getBytes());
            }
            System.out.println("输出成功！");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            outputStream.close();
        }

    }

    private static void in() throws IOException {
        InputStream inputStream = null;

        try {
//            inputStream = new FileInputStream(new File("C:\\Users\\BalalaEnergy\\Desktop\\iotest.txt"));
            inputStream = new FileInputStream(new File("C:\\Users\\BalalaEnergy\\Desktop\\图片测试\\80ac50e4a5c391192ab0fc7625dd8864.jpg"));

            byte[] bytes = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            int len =0;
            while ( (len=inputStream.read(bytes)) != -1){
                //inputStream.read(bytes);
                //根据读取到的字节数组，转化为String，再追加给StringBuilder
                stringBuilder.append(new String(bytes,0,len));
            }
            System.out.println(stringBuilder.toString());

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            inputStream.close();
        }

    }

}
