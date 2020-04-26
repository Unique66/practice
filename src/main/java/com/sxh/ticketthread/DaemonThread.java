//package com.sxh.ticketthread;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.Scanner;
//
///**
// * Created by SXH on 2018/7/22.
// *
// */
//class DaemonThreadDemo implements Runnable{
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName()+"开始运行Run()...");
//        try {
//            write();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+"结束运行Run()...");
//    }
//    private void write() throws Exception{
//        File file = new File("D:"+File.separator+"DaemonThread.txt");
//        int count = 0;
//        //创建写操作流
//        while (count < 999) {
//            FileOutputStream fos = new FileOutputStream(file, true);
//            fos.write(("\r\n word" + count).getBytes());
//            System.out.println(Thread.currentThread().getName() + "写入word" + count++);
//            Thread.sleep(1000);//输出完成需要999秒
//        }
//    }
//}
//public class DaemonThread {
//
//    /**
//     * 链接url下载图片
//     * @param urlList 下载路径
//     * @param path		存储路径
//     */
//    public static void downloadPicture(final String urlList,final String path){
//        URL url = null;
//        DataInputStream dataInputStream = null;
//        FileOutputStream fileOutputStream = null;
//        try {
//            url = new URL(urlList);
//            dataInputStream = new DataInputStream(url.openStream());
//            fileOutputStream = new FileOutputStream(new File(path));
//            ByteArrayOutputStream output = new ByteArrayOutputStream();
//
//            byte[] buffer = new byte[1024];
//            int length;
//
//            while ((length = dataInputStream.read(buffer)) > 0) {
//                output.write(buffer, 0, length);
//            }
//            fileOutputStream.write(output.toByteArray());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (dataInputStream != null) {
//                try {
//                    dataInputStream.close();
//                } catch (IOException e) {
//                }
//            }
//            if (fileOutputStream != null) {
//                try {
//                    fileOutputStream.close();
//                } catch (IOException e) {
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        System.out.println("主线程开始："+Thread.currentThread().getName());
//        DaemonThreadDemo dtd = new DaemonThreadDemo();
//        Thread th = new Thread(dtd,"myThread:");
//        th.setDaemon(true);//设置为守护线程
//        th.start();
//        Scanner sc = new Scanner(System.in);
//        sc.next();//主线程结束，守护线程也会结束
//        System.out.println("主线程结束："+Thread.currentThread().getName());
//
//
//        String url = "http://sbzxlp-1256837708.cos.ap-shanghai.myqcloud.com/024EeD419A664BD1B5604D53a962084B.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDlV8gnXXfCaovGR5ZigS6nOo8PyMaEPRH%26q-sign-time%3D1550219659%3B1550221459%26q-key-time%3D1550219659%3B1550221459%26q-header-list%3D%26q-url-param-list%3D%26q-signature%3D8b3ebcd4280ce227bf210d4adb399f4012a56c58";
////    	 String url = "http://img.coocaa.com/www/attachment/forum/201602/16/085938u86ewu4l8z6flr6w.jpg";
//        String path = "D://test/1.jpg";
//        PubFun.downloadPicture(url, path);
//    }
//
//}
