package com.ziyu.jvm.ch06.classfile;

/**
 * @ClassName ConstantInfo
 * @Date
 * @Author
 * @Description TODO
 **/
public enum  ConstantInfo {

    CONSTANT_Class(7),
    CONSTANT_Fieldref(9),
    CONSTANT_Methodref(10),
    CONSTANT_InterfaceMethodref(11),
    CONSTANT_String(8),
    CONSTANT_Integer(3),
    CONSTANT_Float(4),
    CONSTANT_Long(5),
    CONSTANT_Double(6),
    CONSTANT_NameAndType(12),
    CONSTANT_Utf8(1),
    CONSTANT_MethodHandle(15),
    CONSTANT_MethodType(16),
    CONSTANT_InvokeDynamic(18),
    ;

    private int value;

    ConstantInfo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
