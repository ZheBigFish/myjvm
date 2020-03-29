package com.ziyu.jvm.ch06.classfile.classpath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @ClassName DirEntry
 * @Date
 * @Author
 * @Description TODO
 **/
public class DirEntry extends Entry {

    String absDir;

    public DirEntry(String path) {
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        this.absDir = absolutePath;
    }

    @Override
    public byte[] readClass(String className) {
        byte[] b = new byte[10240];
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(absDir + Entry.pathListSeparator + className));
            fileInputStream.read(b);
        } catch (FileNotFoundException e) {
            System.out.println("Class Not Found!");
            b = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

}
