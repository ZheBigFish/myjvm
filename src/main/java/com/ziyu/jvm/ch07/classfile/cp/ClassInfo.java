package com.ziyu.jvm.ch07.classfile.cp;

import lombok.Data;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName ClassInfo
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class ClassInfo extends ContantPool {

    short nameIndex;

    public ClassInfo (DataInputStream is) throws IOException {
        this.nameIndex = is.readShort();
    }

}
