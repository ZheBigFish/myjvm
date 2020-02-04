package com.ziyu.jvm.ch05.classfile.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName NameAndTypeInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class NameAndTypeInfo extends ContantPool {

    short nameIndex;
    short depictIndex;

    public NameAndTypeInfo(DataInputStream is) throws IOException {
        this.nameIndex = is.readShort();
        this.depictIndex = is.readShort();
    }
}
