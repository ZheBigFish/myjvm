package com.ziyu.jvm.ch05.classfile.cp;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ContantPool
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class ContantPool {

    public static final byte Utf8 = 1;
    public static final byte Integer = 3;
    public static final byte Float = 4;
    public static final byte Long = 5;
    public static final byte Double = 6;
    public static final byte Class = 7;
    public static final byte String = 8;
    public static final byte Fieldref = 9;
    public static final byte InterfaceMethod = 11;
    public static final byte InvokeDynamic = 18;
    public static final byte MethodHandle = 15;
    public static final byte Methodref = 10;
    public static final byte MethodType = 16;
    public static final byte NameAndType = 12;

    List<ContantPool> value;

    byte[] bytes;

    short size;

}
