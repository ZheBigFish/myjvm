package com.ziyu.jvm.ch07.classfile.attribute;

import com.ziyu.jvm.ch07.classfile.Attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName Exceptions
 * @Date
 * @Author
 * @Description TODO 属性表待实现
 **/
public class Exceptions extends Attribute {

    int attributeLength;
    short nunmberOfExceptinos;
    short exceptionIndexTable;

    public Exceptions(DataInputStream is) throws IOException {
        this.attributeLength = is.readInt();
        byte[] bytes = new byte[this.attributeLength];
        is.read(bytes);
    }
}
