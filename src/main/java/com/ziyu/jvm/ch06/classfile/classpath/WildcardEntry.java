package com.ziyu.jvm.ch06.classfile.classpath;

import com.ziyu.jvm.Util.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WildcardEntry
 * @Date
 * @Author
 * @Description TODO
 **/
public class WildcardEntry extends Entry {

    String baseDir;
    List<Entry> entries = new ArrayList<>();

    WildcardEntry(String path){
        baseDir = path.substring(0, path.length() - 1);
        ArrayList<File> listFiles = FileUtils.getListFiles(baseDir);
        for (File listFile : listFiles) {
            walk(listFile);
        }
    }

    @Override
    byte[] readClass(String className) {
        for (Entry entry : this.entries) {
            byte[] bytes = entry.readClass(className);
            if (bytes != null){
                return bytes;
            }
        }
        return null;
    }

    public void walk(Object path){
        File file;
        if (path instanceof File) {
            file = (File) path;
        } else {
            file = new File(path.toString());
        }
        if (file.isDirectory() && !path.equals(baseDir)) {
            return;
        }
        if (file.getAbsolutePath().endsWith(".jar") || file.getAbsolutePath().endsWith(".JAR")) {
            entries.add(new ZipEntry(file.getAbsolutePath()));
        }
    }

}
