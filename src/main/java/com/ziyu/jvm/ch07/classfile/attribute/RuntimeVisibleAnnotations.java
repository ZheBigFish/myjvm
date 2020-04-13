package com.ziyu.jvm.ch07.classfile.attribute;

import com.ziyu.jvm.ch07.classfile.Attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName RuntimeVisibleAnnotations
 * @Date
 * @Author
 * @Description TODO 属性表待实现
 **/
public class RuntimeVisibleAnnotations extends Attribute {

    int length;
    short numAnnotations;

    public RuntimeVisibleAnnotations(DataInputStream is) throws IOException {
        this.length = is.readInt();
        byte[] bytes = new byte[this.length];
        is.read(bytes);
    }
}
