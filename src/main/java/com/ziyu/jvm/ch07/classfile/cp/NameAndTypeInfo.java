package com.ziyu.jvm.ch07.classfile.cp;

import lombok.Data;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName NameAndTypeInfo
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class NameAndTypeInfo extends ContantPool {

    short nameIndex;
    short depictIndex;

    public NameAndTypeInfo(DataInputStream is) throws IOException {
        this.nameIndex = is.readShort();
        this.depictIndex = is.readShort();
    }
}
