package com.ziyu.jvm.ch03.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName MethodrefInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class MethodrefInfo extends ContantPool{

    short classInfoIndex;
    short nameAndTypeIndex;

    public MethodrefInfo(DataInputStream is) throws IOException {
        this.classInfoIndex = is.readShort();
        this.nameAndTypeIndex = is.readShort();
    }
}
