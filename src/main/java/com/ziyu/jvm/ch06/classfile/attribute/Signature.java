package com.ziyu.jvm.ch06.classfile.attribute;

import com.ziyu.jvm.ch06.classfile.Attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName Signature
 * @Date
 * @Author
 * @Description TODO
 **/
public class Signature extends Attribute {

    int length;
    short signatureLength;

    public Signature(DataInputStream is) throws IOException {
        this.length = is.readInt();
        this.signatureLength = is.readShort();
    }
}
