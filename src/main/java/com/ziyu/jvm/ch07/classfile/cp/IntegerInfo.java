package com.ziyu.jvm.ch07.classfile.cp;

import lombok.Data;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName IntegerInfo
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class IntegerInfo extends ContantPool {

    int val;

    public IntegerInfo(DataInputStream is) throws IOException {
        this.val = is.readInt();
    }

}
