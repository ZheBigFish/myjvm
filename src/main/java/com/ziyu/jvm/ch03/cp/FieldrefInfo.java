package com.ziyu.jvm.ch03.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName FieldrefInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class FieldrefInfo extends ContantPool{

    short classInfoIndex;
    short nameAndTypeIndex;

    public FieldrefInfo(DataInputStream is) throws IOException {
        this.classInfoIndex = is.readShort();
        this.nameAndTypeIndex = is.readShort();
    }
}
