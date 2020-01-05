package com.ziyu.jvm.ch03.cp;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName IntegerInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class IntegerInfo extends ContantPool{

    int val;

    public IntegerInfo(DataInputStream is) throws IOException {
        this.val = is.readInt();
    }

}
