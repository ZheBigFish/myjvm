package com.ziyu.jvm.ch05.classfile.classpath;

/**
 * @InterfaceName Entry
 * @Date
 * @Author
 * @Description TODO
 **/
public interface Entry {

    byte[] readClass(String className);

}
