package com.ziyu.jvm;

import com.sun.nio.zipfs.ZipPath;
import com.ziyu.jvm.ch03.ClassReader;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName main
 * @Date
 * @Author
 * @Description TODO
 **/
public class main {

    @Test
    public void test() throws IOException {

        Path path = Paths.get("D:\\niubi\\mini-jvm\\target\\tt.class");
        ClassReader.read(path);

    }

}
