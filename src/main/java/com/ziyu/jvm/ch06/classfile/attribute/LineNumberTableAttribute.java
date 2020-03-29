package com.ziyu.jvm.ch06.classfile.attribute;

import com.ziyu.jvm.ch06.classfile.Attribute;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LineNumberTableAttribute
 * @Date
 * @Author
 * @Description TODO
 **/
public class LineNumberTableAttribute extends Attribute {

    int attributeLength;
    short lineNumberTableLength;
    List<LineNumberInfo> lineNumberInfos;

    public LineNumberTableAttribute(DataInputStream is) throws IOException {
        this.attributeLength = is.readInt();
        this.lineNumberTableLength = is.readShort();
        this.lineNumberInfos = new ArrayList<>();
        if (this.lineNumberTableLength > 0){
            for (int i = 0; i < this.lineNumberTableLength; i++){
                lineNumberInfos.add(new LineNumberInfo(is));
            }
        }
    }
}

class LineNumberInfo{
    short startPc;
    short lineNumber;

    public LineNumberInfo(DataInputStream is) throws IOException {
        this.startPc = is.readShort();
        this.lineNumber = is.readShort();
    }
}
