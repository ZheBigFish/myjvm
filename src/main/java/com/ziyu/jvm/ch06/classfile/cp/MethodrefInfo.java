package com.ziyu.jvm.ch06.classfile.cp;

import com.ziyu.jvm.ch06.classfile.ConstantMemberRef;
import com.ziyu.jvm.ch06.classfile.MemberRefInfo;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName MethodrefInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class MethodrefInfo extends MemberRefInfo {
    public MethodrefInfo(DataInputStream is, ContantPool contantPool) throws IOException {
        this.contantPool = contantPool;
        this.classInfoIndex = is.readShort();
        this.nameAndTypeIndex = is.readShort();
    }
}
