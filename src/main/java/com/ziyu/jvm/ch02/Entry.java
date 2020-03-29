package com.ziyu.jvm.ch02;

/**
 * @InterfaceName Entry
 * @Date
 * @Author
 * @Description TODO
 **/
public interface Entry {

    public static String pathListSeparator = ";";
    byte[] readClass(String className);

}
