package com.ziyu.jvm.ch05.classfile.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName ClassInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class ClassInfo extends ContantPool {

    short nameIndex;

    public ClassInfo (DataInputStream is) throws IOException {
        this.nameIndex = is.readShort();
    }

}
