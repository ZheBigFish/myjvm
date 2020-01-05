package com.ziyu.jvm.ch02;

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
public class DirEntry implements Entry {

    public byte[] readClass(String className) {
        byte[] b = new byte[10240];
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(className));
            fileInputStream.read(b);
        } catch (FileNotFoundException e) {
            System.out.println("Class Not Found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

}
