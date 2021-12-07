package com.sunsheng.modules.commCode;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Scanner;

public class GetMac {
    public static void main(String[] args) throws Exception {
        System.out.println("-------------------------------");
        f1();
        f2();
        System.out.println("-------------------------------");
        //cmd命令获取cpu序列号  wmic cpu get ProcessorId
    }

    private static void f2() throws IOException {
//        long start = System.currentTimeMillis();
        Process process = Runtime.getRuntime().exec(new String[] { "wmic", "cpu", "get", "ProcessorId" });
        process.getOutputStream().close();
        Scanner sc = new Scanner(process.getInputStream());
        String property = sc.next();
        String serial = sc.next();
        System.out.println(property + ": " + serial);

//        System.out.println("time:" + (System.currentTimeMillis() - start));
    }

    private static void f1() throws Exception {
        InetAddress ia = InetAddress.getLocalHost();
//        System.out.println(ia);
        getLocalMac(ia);
    }
    private static void getLocalMac(InetAddress ia) throws SocketException{
        // TODO Auto-generated method stub
        //获取网卡，获取地址
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
//        System.out.println("mac数组长度："+mac.length);
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<mac.length; i++) {
            if(i!=0) {
                sb.append("-");
            }
            //字节转换为整数
            int temp = mac[i]&0xff;
            String str = Integer.toHexString(temp);
//            System.out.println("每8位:"+str);
            if(str.length()==1) {
                sb.append("0"+str);
            }else {
                sb.append(str);
            }
        }
        System.out.println("本机MAC地址:"+sb.toString().toUpperCase());
    }
}
