package com.ziyu.jvm.ch03.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName InterfaceMethodrefInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class InterfaceMethodrefInfo extends ContantPool {

    short classInfoIndex;
    short nameAndTypeIndex;

    public InterfaceMethodrefInfo(DataInputStream is) throws IOException {
        this.classInfoIndex = is.readShort();
        this.nameAndTypeIndex = is.readShort();
    }
}
