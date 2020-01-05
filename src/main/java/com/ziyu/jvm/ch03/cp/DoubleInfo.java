package com.ziyu.jvm.ch03.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName DoubleInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class DoubleInfo extends ContantPool{

    double val;

    public DoubleInfo(DataInputStream is) throws IOException {
        this.val = is.readDouble();
    }
}
