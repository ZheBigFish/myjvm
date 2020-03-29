package com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.ref;

import com.ziyu.jvm.ch06.classfile.ClassFile;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.HeapConstantPool;

/**
 * @ClassName ClassRef
 * @Date
 * @Author
 * @Description TODO
 **/
public class ClassRef extends Symref {

    public ClassRef newClassRef(HeapConstantPool contantPool, ClassFile classFile){
        ClassRef classRef = new ClassRef();
        classRef.heapConstantPool = contantPool;
        classRef.className = classFile.getClassName();
        return classRef;
    }

    public static ClassRef newClassRef(HeapConstantPool contantPool, String className){
        ClassRef classRef = new ClassRef();
        classRef.heapConstantPool = contantPool;
        classRef.className = className;
        return classRef;
    }

}
