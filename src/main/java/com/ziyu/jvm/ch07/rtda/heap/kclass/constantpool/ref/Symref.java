package com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref;

import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.HeapConstantPool;

/**
 * @ClassName Symref
 * @Date
 * @Author
 * @Description TODO
 **/
public class Symref {

    HeapConstantPool heapConstantPool;
    String className;
    KClass aClass;

    public KClass resolvedClass() {
        if (this.aClass == null) {
            this.resolvedClassRef();
        }
        return this.aClass;
    }

    public void resolvedClassRef() {
        KClass d = this.heapConstantPool.aClass;
        KClass c = d.getClassLoader().loadClass(this.className);
        if (!c.isAccessibleTo(d)){
            throw new RuntimeException();
        }
        this.aClass = c;
    }

}
