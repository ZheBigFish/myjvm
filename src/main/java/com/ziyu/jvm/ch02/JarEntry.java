package com.ziyu.jvm.ch02;

import java.io.*;
import java.util.jar.JarFile;

/**
 * @ClassName DirEntry
 * @Date
 * @Author
 * @Description TODO
 **/
public class JarEntry implements Entry {

    private String abspath;

    public JarEntry(String path) {
        this.abspath = path;
    }

    public byte[] readClass(String className) {

        JarFile jarFile = null;
        try {
            jarFile = new JarFile(new File(abspath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        java.util.jar.JarEntry jarEntry = jarFile.getJarEntry(className);

        byte[] b = new byte[10240];
        try {
            InputStream inputStream = jarFile.getInputStream(jarEntry);
            inputStream.read(b);
        } catch (FileNotFoundException e) {
            System.out.println("Class Not Found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

}
