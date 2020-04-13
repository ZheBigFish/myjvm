package com.ziyu.jvm.ch07.classfile.cp;

import lombok.Data;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName FloatInfo
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class FloatInfo extends ContantPool {

    float val;

    public FloatInfo(DataInputStream is) throws IOException {
        this.val = is.readFloat();
    }
}
