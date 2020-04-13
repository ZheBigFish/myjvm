package com.ziyu.jvm.ch07.classfile.classpath;

import com.ziyu.jvm.ch07.classfile.ClassFile;
import com.ziyu.jvm.ch07.classfile.ClassReader;

import java.io.*;
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

        byte[] b = new byte[20480];
        try {
            InputStream inputStream = jarFile.getInputStream(jarEntry);
            int count = inputStream.available();
            b = new byte[count];
//            DataInputStream dataInputStream = new DataInputStream(inputStream);
//            ClassFile parse = ClassReader.parse(dataInputStream);
            int readCount = 0; // 已经成功读取的字节的个数
            while (readCount < count) {
                readCount += inputStream.read(b, readCount, count - readCount);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Class Not Found!");
            b = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

}
