package com.ziyu.jvm.ch05.classfile.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName InvokeDynamicInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class InvokeDynamicInfo extends ContantPool {

    short methodAttrIndex;
    short nameAndTypeIndex;

    public InvokeDynamicInfo(DataInputStream is) throws IOException {
        this.methodAttrIndex = is.readShort();
        this.nameAndTypeIndex = is.readShort();
    }
}
