package com.ziyu.jvm.ch05.classfile.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName MethodTypeInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class MethodTypeInfo extends ContantPool {

    short index;

    public MethodTypeInfo(DataInputStream is) throws IOException {
        this.index = is.readShort();
    }
}
