package com.ziyu.jvm.ch03.cp;

import com.ziyu.jvm.ch03.ClassReader;

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
