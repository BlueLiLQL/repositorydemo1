package com.lql.changestrdemo;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.Charset;

public class ChangeStrtest {

    public static void main(String[] args) throws IOException {
        InputStream in = new FileInputStream("C:\\Users\\BalalaEnergy\\Desktop\\新建文本文档.txt");
        read(in);
        write(new FileOutputStream("C:\\Users\\BalalaEnergy\\Desktop\\新建文本文档1.txt"));
    }

    public static void read(InputStream in) throws IOException {
        Reader r = new InputStreamReader(in);
        char cs[] = new char[1024];
        int len =0;
        try {
            while ((len = r.read(cs))!=-1){
                System.out.println(new String(cs,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            r.close();
        }

    }

    private static void write(OutputStream out){
        Writer wr = new OutputStreamWriter(out, Charset.defaultCharset());
        try{
            wr.write("emmm,字节流转换为字符流");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                wr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
