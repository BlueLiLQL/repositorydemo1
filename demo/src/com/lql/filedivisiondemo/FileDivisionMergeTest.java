package com.lql.filedivisiondemo;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class FileDivisionMergeTest {
    /**
     * 文件切割
     */
    private static void division(File targetFile,long cutSize){
        if(targetFile==null)return;

        //切割次数
        int num = targetFile.length()%cutSize==0?
                (int)(targetFile.length()/cutSize):(int)(targetFile.length()/cutSize+1);

        try {
            InputStream in = new BufferedInputStream(new FileInputStream(targetFile));
            OutputStream out = null;
            byte[] bytes = null;//每次要读取的字节数
            //=-1的状态为读取完毕
            int len =-1;//每次实际读取的长度
            //读取的次数
            int count = 0;//每一个文件要读取的次数（20M中要读取多少次）
            //生成num个切割文件
            for (int i = 0; i <num ; i++) {
                out = new BufferedOutputStream(new FileOutputStream(new
                        File(path +i+"-"+targetFile.getName())));

                //判断读取的次数：此步的操作时为了防止按照cutSize读取文件，不能读完，最后一次则需要单独处理
                if(cutSize>1024){
                    bytes = new byte[1024];
                    count = (int)cutSize/1024;
                }else{
                    bytes = new byte[(int)cutSize];
                    count=1;
                }
                //写入文件
                while (count > 0 && ((len=in.read(bytes))!=-1) ){
                    out.write(bytes,0,len);
                    out.flush();
                    count--;
                }
                //判断文件时候读完，如果没有，则需要再读取一次
                if(cutSize%1024!=0){
                    bytes = new byte[(int)cutSize%1024];
                    len = in.read(bytes);
                    out.write(bytes,0,len);
                    out.flush();
                }
            }
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 文件合并
     * 传入文件数组
     * @param elements
     */
    private static void merge(Enumeration<InputStream> elements){

        SequenceInputStream sis = new SequenceInputStream(elements);
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(path + "周杰伦《说好不哭》无水印MV"+"合并"+".mp4")));
            byte[] bytes = new byte[1024];
            int len= -1;
            while ((len = sis.read(bytes))!=-1){
                bos.write(bytes,0,len);
                bos.flush();
            }
            bos.close();
            sis.close();
            System.out.println("合并完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
//        File file = new File("D:\\迅雷下载\\video\\周杰伦《说好不哭》无水印MV.mp4");
//        division(file,1024*1024*20);


        try {
            FileInputStream fin = new FileInputStream(new File(path + "0-周杰伦《说好不哭》无水印MV.mp4"));
            FileInputStream fin1 = new FileInputStream(new File(path + "1-周杰伦《说好不哭》无水印MV.mp4"));
            FileInputStream fin2 = new FileInputStream(new File(path + "2-周杰伦《说好不哭》无水印MV.mp4"));
            FileInputStream fin3= new FileInputStream(new File(path + "3-周杰伦《说好不哭》无水印MV.mp4"));

            //集合工具类
            Vector<InputStream> v = new Vector();
            v.add(fin);
            v.add(fin1);
            v.add(fin2);
            v.add(fin3);
            Enumeration elements = v.elements();
            merge(elements);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
