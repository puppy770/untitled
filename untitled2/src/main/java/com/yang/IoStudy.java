package com.yang;

import java.io.*;

public class IoStudy {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        File file = new File("杨.txt");
        boolean newFile = file.createNewFile();
        System.out.println(file.getAbsolutePath());
        InputStream inputStream = new FileInputStream(file);
        int len=1;
        byte[] buffer=new byte[10];
        while((len=inputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer,0,len));
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(75);
        fileOutputStream.write(buffer);
        fileOutputStream.close();
        inputStream.close();

    }
}
