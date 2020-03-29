package com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.ref;

import com.ziyu.jvm.ch06.classfile.cp.FieldrefInfo;
import com.ziyu.jvm.ch06.rtda.heap.kclass.Field;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.HeapConstantPool;
import com.ziyu.jvm.ch06.rtda.heap.kclass.KClass;

/**
 * @ClassName FieldRef
 * @Date
 * @Author
 * @Description TODO
 **/
public class FieldRef extends MemberRef {

    Field field;

    public static FieldRef newFieldRef(HeapConstantPool heapConstantPool, FieldrefInfo fieldrefInfo) {
        FieldRef fieldRef = new FieldRef();
        fieldRef.heapConstantPool = heapConstantPool;
        fieldRef.copyMemberRefInfo(fieldrefInfo);
        return fieldRef;
    }

    public Field resolvedField() {
        if (this.field == null) {
            this.resolveFieldRef();
        }
        return this.field;
    }

    public void resolveFieldRef() {
        KClass a = this.heapConstantPool.aClass;
        KClass b = this.resolvedClass();
        Field field = lookupField(b, this.name, this.descriptor);
        if (field == null){
            throw new RuntimeException("java.lang.NoSuchFieldError");
        }
        if (!field.isAccessibleTo(a)){
            throw new RuntimeException("java.lang.IllegalAccessError");
        }
        this.field = field;

    }

    public Field lookupField(KClass aClass, String name, String descriptor) {
        for (int i = 0; i < aClass.getFields().size(); i++) {
            Field field = aClass.getFields().get(i);
            if (field.name.equals(name) && field.descriptor.equals(descriptor)){
                return field;
            }
        }

        for (int i = 0; i < aClass.getInterfaceNames().length; i++) {
            Field field = lookupField(aClass.getInterfaces()[i], name, descriptor);
            if (field != null){
                return field;
            }
        }

        if (aClass.getSuperClass() != null) {
            return lookupField(aClass.getSuperClass(), name, descriptor);
        }

        return null;

    }

}
