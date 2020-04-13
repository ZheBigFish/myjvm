package com.ziyu.jvm.ch07.classfile.attribute;

import com.ziyu.jvm.ch07.classfile.Attribute;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName SourceFile
 * @Date
 * @Author
 * @Description TODO
 **/
public class SourceFile extends Attribute {

    int length;
    short sourceFileIndex;

    public SourceFile(DataInputStream is) throws IOException {
        this.length = is.readInt();
        this.sourceFileIndex = is.readShort();
    }

}
