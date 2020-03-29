package com.ziyu.jvm.ch06.classfile.attribute;

import com.ziyu.jvm.ch06.classfile.Attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName Deprecated
 * @Date
 * @Author
 * @Description TODO
 **/
public class Deprecated extends Attribute {

    int length;

    public Deprecated(DataInputStream is) throws IOException {
        this.length = is.readInt();
    }
}
