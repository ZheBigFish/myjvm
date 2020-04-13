package com.ziyu.jvm.ch07.classfile;

import com.ziyu.jvm.ch07.classfile.cp.ContantPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName MemberRefInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public class MemberRefInfo extends ContantPool {

    public ContantPool contantPool;
    public short classInfoIndex;
    public short nameAndTypeIndex;

    public void readInfo(DataInputStream is) throws IOException {
        this.classInfoIndex = is.readShort();
        this.nameAndTypeIndex = is.readShort();
    }

    public String className(){
        return this.contantPool.getStringValue(this.classInfoIndex);
    }

    public String nameAndDescriptor(){
        if (this.nameAndTypeIndex == 248){
            System.out.println();
        }
        return this.contantPool.getStringValue(this.nameAndTypeIndex);
    }

}
