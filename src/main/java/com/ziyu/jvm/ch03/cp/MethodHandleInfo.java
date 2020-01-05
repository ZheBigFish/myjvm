package com.ziyu.jvm.ch03.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName MethodHandleInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class MethodHandleInfo extends ContantPool{

    byte refKind;
    short refIndex;

    public MethodHandleInfo(DataInputStream is) throws IOException {
        this.refKind = is.readByte();
        this.refIndex = is.readShort();
    }

}
