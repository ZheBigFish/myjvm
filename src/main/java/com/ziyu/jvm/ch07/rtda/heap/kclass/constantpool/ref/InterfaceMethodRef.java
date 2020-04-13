package com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref;

import com.ziyu.jvm.ch07.classfile.MemberRefInfo;
import com.ziyu.jvm.ch07.rtda.heap.MethodLookup;
import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.HeapConstantPool;

/**
 * @ClassName InterfaceMethodRef
 * @Date
 * @Author
 * @Description TODO
 **/
public class InterfaceMethodRef extends MemberRef {

    Method method;

    public static InterfaceMethodRef newInterfaceMethodRef(HeapConstantPool heapConstantPool, MemberRefInfo constantMemberRef){
        InterfaceMethodRef interfaceMethodrefInfo = new InterfaceMethodRef();
        interfaceMethodrefInfo.heapConstantPool = heapConstantPool;
        interfaceMethodrefInfo.copyMemberRefInfo(constantMemberRef);
        return interfaceMethodrefInfo;
    }

    public Method resolvedInterfaceMethod() {
        if (this.method == null) {
            this.resolveInterfaceMethodRef();
        }
        return this.method;
    }

    public void resolveInterfaceMethodRef() {
        KClass d = this.heapConstantPool.aClass;
        KClass c = this.resolvedClass();
        if (!c.isInterface()) {
            throw new RuntimeException("java.lang.IncompatibleClassChangeError");
        }
        Method method = lookupInterfaceMethod(c, this.name, this.descriptor);
        if (method == null) {
            throw new RuntimeException("java.lang.IllegalAccessError");
        }
        if (!method.isAccessibleTo(d)) {
            throw new RuntimeException("java.lang.IllegalAccessError");
        }
        this.method = method;

    }

    public Method lookupInterfaceMethod(KClass kClass, String name, String descriptor) {
        for (Method method : kClass.methods) {
            if (name.equals(method.name) && descriptor.equals(method.descriptor)) {
                return method;
            }
        }
        return MethodLookup.lookupMethodInInterfaces(kClass.interfaces, name, descriptor);
    }

}
