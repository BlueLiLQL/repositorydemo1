package com.lql.zipdemo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 文件压缩
 */
public class CompressionDecopressionDemo {

    /**
     * 压缩文件
     */
    private  static  void compression(String zipFileName, File targetFile) throws IOException{
        System.out.println("正在压缩");
        //要生成的压缩文件
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        BufferedOutputStream bos = new BufferedOutputStream(out);
        zip(out,targetFile,targetFile.getName(),bos);
    }

    /**
     *     zip
     */
    private  static void zip(ZipOutputStream zOut, File targetFile, String name, BufferedOutputStream bos) throws IOException{
        if(targetFile.isDirectory()){
            File[] files = targetFile.listFiles();
            if (files.length==0){ //空文件夹
                zOut.putNextEntry(new ZipEntry(name+"/"));  //处理空目录
            }
            for(File f : files){
                zip(zOut,f,name + "/" + f.getName(),bos);
            }
        }else{
            zOut.putNextEntry(new ZipEntry(name));
            InputStream in = new FileInputStream(targetFile);
            BufferedInputStream bis = new BufferedInputStream(in);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes))!= -1){
                bos.write(bytes,0,len);
            }
            /*bis.close();
            bos.close();*/
        }
    }

    /**
     * 解压
     */
    private  static  void deCompression(String zipFileName, File targetFile) throws IOException{
        System.out.println("正在解压缩");

    }

    public static void main(String[] args) throws IOException{
        long s = System.currentTimeMillis();
        compression("C:\\Users\\BalalaEnergy\\Desktop\\test.zip",new File("C:\\Users\\BalalaEnergy\\Desktop\\repositorys"));
        long e = System.currentTimeMillis();
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss SSS");
        System.out.println("总共耗时：" + sf.format(e-s));
    }
}
