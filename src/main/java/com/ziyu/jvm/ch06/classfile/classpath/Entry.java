package com.ziyu.jvm.ch06.classfile.classpath;

import java.util.Map;

/**
 * @InterfaceName Entry
 * @Date
 * @Author
 * @Description TODO
 **/
public class Entry {

    static final String pathListSeparator = "\\";
    byte[] readClass(String className){
        return null;
    }

    public Entry newEntry(String path){
        if (path.contains(pathListSeparator)) {
            return new CompositeEntry(path);
        }
        if (path.endsWith("*")) {

        }
        if (path.endsWith(".jar") || path.endsWith(".JAR") || path.endsWith(".ZIP") || path.endsWith(".zip")) {
            return new ZipEntry(path);
        }
        return new DirEntry(path);
    }

}
