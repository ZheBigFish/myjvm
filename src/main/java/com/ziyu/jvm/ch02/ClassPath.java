package com.ziyu.jvm.ch02;

import java.nio.file.Paths;

/**
 * @ClassName ClassPath
 * @Date
 * @Author
 * @Description TODO
 **/
public class ClassPath {

    private final String PATH_SEPARATOR = ":";

    private static final String bootstrapPath = System.getenv("JAVA_HOME") + "\\jre\\lib";
    private static final String extensionPath = System.getenv("JAVA_HOME") + "\\jre\\lib\\ext";
    private static final String userPath = "";

    public static void readClass(String className){
        className.replaceAll("//", ".");
        Entry entry = new JarEntry(bootstrapPath + "\\rt.jar");
        byte[] bytes = entry.readClass(className + ".class");
        System.out.println(new String(bytes));
    }

    public static Entry parse(String path){
        Entry entry = null;
        return null;
    }

    public static boolean isDir(String path) {
        return Paths.get(path).toFile().isDirectory();
    }

    public static boolean isWildcard(String path) {
        return path.endsWith("*");
    }

    public static boolean isJar(String path) {
        return path.endsWith(".jar");
    }

}
