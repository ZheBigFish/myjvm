package com.ziyu.jvm.ch05.classfile.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName StringInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class StringInfo extends ContantPool {

    short index;

    public StringInfo(DataInputStream is) throws IOException {
        this.index = is.readShort();
    }
}
