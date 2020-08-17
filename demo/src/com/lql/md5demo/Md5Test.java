package com.lql.md5demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class Md5Test {
    private static String passwordValue = "ISMvKXpXpadDiUoOSoAfww==";
    public static void main(String[] args) {
        md5("admin");
        Scanner sc = new Scanner(System.in);
        if(login(sc.nextLine())){
            System.out.println("密码正确登录成功！");
        }else{
            System.out.println("密码错误，登录失败！");
        }
    }

    public static Boolean login(String password){
        if (passwordValue.equals(md5(password))){
//
            return true;
        }else{
            return false;
            //
        }

    }

    public static String md5(String password){
        try {
            //获取MD5
            MessageDigest md = MessageDigest.getInstance("md5");
            //通过MD5计算获取摘要
            byte[] bytes = md.digest(password.getBytes());
//            System.out.println(bytes);
            //BASE64算法
            String str = Base64.getEncoder().encodeToString(bytes);
//            System.out.println(str);
            return str;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
