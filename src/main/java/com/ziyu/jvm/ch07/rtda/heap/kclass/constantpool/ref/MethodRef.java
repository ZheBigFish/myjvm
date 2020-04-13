package com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref;

import com.ziyu.jvm.ch07.classfile.MemberRefInfo;
import com.ziyu.jvm.ch07.rtda.heap.MethodLookup;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Field;
import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.HeapConstantPool;
import lombok.Data;

/**
 * @ClassName MethodRef
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class MethodRef extends MemberRef {

    Method method;

    public static MethodRef newMethodRef(HeapConstantPool heapConstantPool, MemberRefInfo constantMemberRef) {
        MethodRef methodRef = new MethodRef();
        methodRef.heapConstantPool = heapConstantPool;
        methodRef.copyMemberRefInfo(constantMemberRef);
        return methodRef;
    }

    public Method resolvedMethod() {
        if (this.method == null) {
            this.resolveMethodRef();
        }
        return this.method;
    }

    public void resolveMethodRef() {
        KClass d = this.heapConstantPool.aClass;
        KClass c = this.resolvedClass();
        if (c.isInterface()) {
            throw new RuntimeException("java.lang.IncompatibleClassChangeError");
        }
        Method method = lookupMethod(c, this.name, this.descriptor);
        if (method == null) {
            throw new RuntimeException("java.lang.IllegalAccessError");
        }
        if (!method.isAccessibleTo(d)) {
            throw new RuntimeException("java.lang.IllegalAccessError");
        }
        this.method = method;

    }

    public Method lookupMethod(KClass kClass, String name, String descriptor) {
        Method method = MethodLookup.lookUpMethodInClass(kClass, name, descriptor);
        if (method == null) {
            method = MethodLookup.lookupMethodInInterfaces(kClass.interfaces, name, descriptor);
        }
        return method;
    }

}
