package com.github.dragonet.java.basic.nio;

import java.io.*;

/**
 * @author xiaolong.qin
 * @date 2020/9/11 4:31 下午
 **/
public class InputStreamTest {



    public void method01() {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(new File(".").getAbsolutePath());

        File f1 = new File(this.getClass().getResource("/").getPath());
        System.out.println(f1);
        File f2 = new File(this.getClass().getResource("").getPath());
        System.out.println(f2);
        String currentClassPath = this.getClass().getResource("").getPath();
        System.out.println(currentClassPath);


    }

    public void method02() {
        InputStream in = null;
        try {
            String classPath = this.getClass().getResource("/").getPath();
            in = new BufferedInputStream(new FileInputStream(classPath +"/nomal_io.txt"));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        new InputStreamTest().method01();
    }
}
