package com.ziyu.jvm.ch06.classfile.classpath;

import org.springframework.util.StringUtils;

import java.io.File;

/**
 * @ClassName ClassPath
 * @Date
 * @Author
 * @Description TODO
 **/
public class ClassPath {

    public ClassPath() {
    }

    private final String PATH_SEPARATOR = ":";

    private static final String bootstrapPath = System.getenv("JAVA_HOME") + "\\jre\\lib";
    private static final String extensionPath = System.getenv("JAVA_HOME") + "\\jre\\lib\\ext";
    private static final String userPath = "";

    Entry bootClasspath;
    Entry extClasspath;
    Entry userClasspath;

    public void parse(String path){
        String jreDir = getJreDir(path);
        String jreLibDir = jreDir + Entry.pathListSeparator + "lib" + Entry.pathListSeparator + "*";
        bootClasspath = new WildcardEntry(jreLibDir);
        String jreExtDir = jreDir + Entry.pathListSeparator + "lib" + Entry.pathListSeparator  + Entry.pathListSeparator + "ext" + "*";
        extClasspath = new WildcardEntry(jreExtDir);
        userClasspath = new Entry().newEntry("");
    }

    public String getJreDir(String path){
        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            return path;
        }
        path = path + "./jre";
        file = new File(path);
        if (file.exists() && file.isDirectory()) {
            return path;
        }
        if (!StringUtils.isEmpty(System.getenv("JAVA_HOME"))) {
            return System.getenv("JAVA_HOME") + Entry.pathListSeparator + "jre";
        }
        throw new RuntimeException("Can not find jre folder!");
    }

    public byte[] readClass(String className) {
        if (bootClasspath == null && extClasspath == null && userClasspath == null) {
            parse("");
        }
        className = className + ".class";
        byte[] bytes = bootClasspath.readClass(className);
        if (bytes != null && bytes.length > 0) {
            return bytes;
        }
        bytes = extClasspath.readClass(className);
        if (bytes != null && bytes.length > 0) {
            return bytes;
        }
        bytes = userClasspath.readClass(className);
        if (bytes != null && bytes.length > 0) {
            return bytes;
        }
        return null;
    }

}
