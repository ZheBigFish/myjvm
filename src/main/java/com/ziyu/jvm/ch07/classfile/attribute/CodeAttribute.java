package com.ziyu.jvm.ch07.classfile.attribute;

import com.ziyu.jvm.ch07.classfile.Attribute;
import com.ziyu.jvm.ch07.classfile.ClassReader;
import com.ziyu.jvm.ch07.classfile.ExceptionTable;
import com.ziyu.jvm.ch07.classfile.cp.ContantPool;
import com.ziyu.jvm.Util.InputStreamUtil;
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
    List<ExceptionTable> exceptionTablel;
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
            List<ExceptionTable> exceptionTables =  new ArrayList<>();
            for (int i = 0; i < this.exceptionTableLength; i++) {
                ExceptionTable exceptionTablel = new ExceptionTable();
                exceptionTablel.setStartPC(is.readShort());
                exceptionTablel.setEndPC(is.readShort());
                exceptionTablel.setHandlerPC(is.readShort());
                exceptionTablel.setCatchType(is.readShort());
                exceptionTables.add(exceptionTablel);
            }
            this.exceptionTablel = exceptionTables;
        }
        this.attributeCount = is.readShort();
        if (this.attributeCount > 0){
            for (int i = 0; i < this.attributeCount; i++){
                this.attribute.add(ClassReader.readAttribute(is, this.contantPool));
            }
        }

    }
}
