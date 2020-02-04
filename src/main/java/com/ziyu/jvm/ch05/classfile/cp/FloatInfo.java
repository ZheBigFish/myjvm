package com.ziyu.jvm.ch05.classfile.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName FloatInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class FloatInfo extends ContantPool {

    float val;

    public FloatInfo(DataInputStream is) throws IOException {
        this.val = is.readFloat();
    }
}
