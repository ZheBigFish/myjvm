package com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.ref;

import com.ziyu.jvm.ch06.classfile.MemberRefInfo;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.HeapConstantPool;

/**
 * @ClassName InterfaceMethodRef
 * @Date
 * @Author
 * @Description TODO
 **/
public class InterfaceMethodRef extends MemberRef {

    public static InterfaceMethodRef newInterfaceMethodRef(HeapConstantPool heapConstantPool, MemberRefInfo constantMemberRef){
        InterfaceMethodRef interfaceMethodrefInfo = new InterfaceMethodRef();
        interfaceMethodrefInfo.heapConstantPool = heapConstantPool;
        interfaceMethodrefInfo.copyMemberRefInfo(constantMemberRef);
        return interfaceMethodrefInfo;
    }

}
