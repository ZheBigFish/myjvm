package com.ziyu.jvm.ch05.classfile.attribute;

import com.ziyu.jvm.Util.InputStreamUtil;
import com.ziyu.jvm.ch05.classfile.Attribute;
import com.ziyu.jvm.ch05.classfile.ClassReader;
import com.ziyu.jvm.ch05.classfile.ExceptionTablel;
import com.ziyu.jvm.ch05.classfile.cp.ContantPool;
import lombok.Data;

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
@Data
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
        this.code = InputStreamUtil.readNBytes(is, this.codeLength);
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
