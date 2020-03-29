package com.ziyu.jvm.ch06.classfile.classpath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarFile;

/**
 * @ClassName DirEntry
 * @Date
 * @Author
 * @Description TODO
 **/
public class ZipEntry extends Entry {

    String absDir;

    public ZipEntry(String path) {
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        this.absDir = absolutePath;
    }

    @Override
    public byte[] readClass(String className) {

        JarFile jarFile = null;
        try {
            jarFile = new JarFile(new File(absDir));
        } catch (IOException e) {
            e.printStackTrace();
        }

        java.util.jar.JarEntry jarEntry = jarFile.getJarEntry(className);

        if (jarEntry == null) {
            return null;
        }

        byte[] b = new byte[10240];
        try {
            InputStream inputStream = jarFile.getInputStream(jarEntry);
            inputStream.read(b);
        } catch (FileNotFoundException e) {
            System.out.println("Class Not Found!");
            b = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

}
