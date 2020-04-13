package com.ziyu.jvm.ch07.classfile.cp;

import lombok.Data;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName LongInfo
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class LongInfo extends ContantPool {

    long val;

    public LongInfo(DataInputStream is) throws IOException {
        this.val = is.readLong();
    }

}
