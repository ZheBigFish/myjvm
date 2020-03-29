package com.ziyu.jvm.ch06.classfile.attribute;

import com.ziyu.jvm.ch06.classfile.Attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName StackMapTable
 * @Date
 * @Author
 * @Description TODO 属性表待实现
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
