package com.ziyu.jvm.ch07.classfile.cp;

import lombok.Data;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName StringInfo
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class StringInfo extends ContantPool {

    short index;

    public StringInfo(DataInputStream is) throws IOException {
        this.index = (short) is.readUnsignedShort();
    }
}
