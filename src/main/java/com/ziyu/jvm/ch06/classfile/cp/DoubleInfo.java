package com.ziyu.jvm.ch06.classfile.cp;

import lombok.Data;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName DoubleInfo
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class DoubleInfo extends ContantPool {

    double val;

    public DoubleInfo(DataInputStream is) throws IOException {
        this.val = is.readDouble();
    }
}
