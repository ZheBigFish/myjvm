package com.ziyu.jvm.ch03.attribute;

import com.ziyu.jvm.ch03.Attribute;
import com.ziyu.jvm.ch03.ClassReader;
import com.ziyu.jvm.ch03.ExceptionTablel;
import com.ziyu.jvm.ch03.cp.ContantPool;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CodeAttribute
 * @Date
 * @Author
 * @Description TODO
 **/
public class CodeAttribute extends Attribute {

    int attributeLength;
    short maxStack;
    short maxLocals;
    int codeLength;
    byte[] code;
    short exceptionTableLength;
    ExceptionTablel exceptionTablel;
    short attributeCount;
    List<Attribute> attribute;
    ContantPool contantPool;

    public CodeAttribute(DataInputStream is, ContantPool contantPool) throws IOException {

        this.contantPool = contantPool;
        this.attributeLength = is.readInt();
        this.maxStack = is.readShort();
        this.maxLocals = is.readShort();
        this.codeLength = is.readInt();
        this.attribute = new ArrayList<>();
        this.code = new byte[this.codeLength];
        is.read(this.code);
        this.exceptionTableLength = is.readShort();
        if(this.exceptionTableLength > 0){

        }
        this.attributeCount = is.readShort();
        if (this.attributeCount > 0){
            for (int i = 0; i < this.attributeCount; i++){
                this.attribute.add(ClassReader.readAttribute(is, this.contantPool));
            }
        }

    }
}
