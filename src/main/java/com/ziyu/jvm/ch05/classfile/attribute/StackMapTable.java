package com.ziyu.jvm.ch05.classfile.attribute;

import com.ziyu.jvm.ch05.classfile.Attribute;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @ClassName StackMapTable
 * @Date
 * @Author
 * @Description TODO
 **/
public class StackMapTable extends Attribute {

    int length;
    short numberOfEntryies;
    byte[] content;

    public StackMapTable(DataInputStream is) throws IOException {
        this.length = is.readInt();
//        this.numberOfEntryies = is.readShort();
        content = new byte[length];
        is.read(content);

    }

}
