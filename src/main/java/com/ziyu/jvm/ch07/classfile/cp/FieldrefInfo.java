package com.ziyu.jvm.ch07.classfile.cp;

import com.ziyu.jvm.ch07.classfile.MemberRefInfo;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName FieldrefInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class FieldrefInfo extends MemberRefInfo {

    public FieldrefInfo(DataInputStream is, ContantPool contantPool) throws IOException {
        this.contantPool = contantPool;
        this.classInfoIndex = is.readShort();
        this.nameAndTypeIndex = is.readShort();
    }
}
