package com.ziyu.jvm.ch07.classfile.cp;

import lombok.Data;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName Utf8Info
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class Utf8Info extends ContantPool {

    short length;
    byte[] bytes;

    public Utf8Info(DataInputStream is) throws IOException {
        this.length = is.readShort();
        bytes = new byte[this.length];
        is.read(bytes);
    }

}
