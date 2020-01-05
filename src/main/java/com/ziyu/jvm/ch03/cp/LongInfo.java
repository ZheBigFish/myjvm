package com.ziyu.jvm.ch03.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName LongInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class LongInfo extends ContantPool{

    long val;

    public LongInfo(DataInputStream is) throws IOException {
        this.val = is.readLong();
    }

}
