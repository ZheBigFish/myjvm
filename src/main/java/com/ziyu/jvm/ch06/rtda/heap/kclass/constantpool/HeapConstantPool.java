package com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool;

import com.ziyu.jvm.ch06.classfile.cp.*;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.ref.ClassRef;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.ref.FieldRef;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.ref.InterfaceMethodRef;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.ref.MethodRef;
import com.ziyu.jvm.ch06.rtda.heap.kclass.KClass;

/**
 * @ClassName HeapConstantPool
 * @Date
 * @Author
 * @Description TODO
 **/
public class HeapConstantPool {

    public KClass aClass;
    Object[] constants;

    public HeapConstantPool(KClass aClass, Object[] constants) {
        this.aClass = aClass;
        this.constants = constants;
    }

    public static HeapConstantPool newConstantPool(KClass aClass, ContantPool contantPool) {
        int size = contantPool.getValue().size();
        Object[] constants = new Object[size];
        HeapConstantPool heapConstantPool = new HeapConstantPool(aClass, constants);
        for (int i = 1; i < size; i++) {
            ContantPool contantPool1 = contantPool.getValue().get(i);
            if (contantPool1 instanceof IntegerInfo) {
                IntegerInfo integerInfo = (IntegerInfo) contantPool1;
                constants[i] = integerInfo.getVal();
            }
            if (contantPool1 instanceof FloatInfo) {
                FloatInfo floatInfo = (FloatInfo) contantPool1;
                constants[i] = floatInfo.getVal();
            }
            if (contantPool1 instanceof LongInfo) {
                LongInfo longInfo = (LongInfo) contantPool1;
                constants[i] = longInfo.getVal();
                i++;
            }
            if (contantPool1 instanceof DoubleInfo) {
                DoubleInfo doubleInfo = (DoubleInfo) contantPool1;
                constants[i] = doubleInfo.getVal();
                i++;
            }
            if (contantPool1 instanceof Utf8Info) {
                constants[i] = contantPool1.getBytes().toString();
            }
            if (contantPool1 instanceof StringInfo) {
                StringInfo stringInfo = (StringInfo) contantPool1;
                constants[i] = contantPool.getStringValue(stringInfo.getIndex());
            }
            if (contantPool1 instanceof ClassInfo) {
                ClassInfo classInfo = (ClassInfo) contantPool1;
                constants[i] = ClassRef.newClassRef(heapConstantPool, contantPool.getStringValue(classInfo.getNameIndex()));
            }
            if (contantPool1 instanceof FieldrefInfo) {
                FieldrefInfo fieldInfo = (FieldrefInfo) contantPool1;
                constants[i] = FieldRef.newFieldRef(heapConstantPool, fieldInfo);
            }
            if (contantPool1 instanceof MethodrefInfo) {
                MethodrefInfo methodrefInfo = (MethodrefInfo) contantPool1;
                constants[i] = MethodRef.newMethodRef(heapConstantPool, methodrefInfo);
            }
            if (contantPool1 instanceof InterfaceMethodrefInfo) {
                InterfaceMethodrefInfo interfaceMethodrefInfo = (InterfaceMethodrefInfo) contantPool1;
                constants[i] = InterfaceMethodRef.newInterfaceMethodRef(heapConstantPool, interfaceMethodrefInfo);
            }
        }
        return heapConstantPool;
    }

    public Object getConstant(int index) {
        if (this.constants[index] != null) {
            return this.constants[index];
        }
        return null;
    }

}
