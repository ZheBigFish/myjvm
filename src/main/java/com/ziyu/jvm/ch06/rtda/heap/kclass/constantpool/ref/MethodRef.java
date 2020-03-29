package com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.ref;

import com.ziyu.jvm.ch06.classfile.MemberRefInfo;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.HeapConstantPool;
import lombok.Data;

/**
 * @ClassName MethodRef
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class MethodRef extends MemberRef {

    public static MethodRef newMethodRef(HeapConstantPool heapConstantPool, MemberRefInfo constantMemberRef){
        MethodRef methodRef = new MethodRef();
        methodRef.heapConstantPool = heapConstantPool;
        methodRef.copyMemberRefInfo(constantMemberRef);
        return methodRef;
    }

}
