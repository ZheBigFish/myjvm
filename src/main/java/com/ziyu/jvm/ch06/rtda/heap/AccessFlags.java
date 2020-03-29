package com.ziyu.jvm.ch06.rtda.heap;

/**
 * @ClassName AccessFlags
 * @Date
 * @Author
 * @Description TODO
 **/
public class AccessFlags {

    //class field method
    public static final short ACC_PUBLIC = 0X0001;
    public static final short ACC_FINAL = 0X0010;
    public static final short ACC_SYNTHETIC = 0X1000;

    //field method
    public static final short ACC_PRIVATE = 0X0002;
    public static final short ACC_PROTECTED = 0X0004;
    public static final short ACC_STATIC = 0X0008;

    //class
    public static final short ACC_SUPER = 0X0020;
    public static final short ACC_INTERFACE = 0X0200;
    public static final short ACC_ANNOTATION = 0X2000;

    //class field
    public static final short ACC_ENUM = 0X4000;

    //class method
    public static final short ACC_ABSTRACT = 0X0400;

    //field
    public static final short ACC_VOLATILE = 0X0040;
    public static final short ACC_TRANSIENT = 0X0080;


    //method
    public static final short ACC_SYNCHRONIZED = 0X0020;
    public static final short ACC_BRIDGE = 0X0040;
    public static final short ACC_VARARGS = 0X0080;
    public static final short ACC_NATIVE = 0X0100;
    public static final short ACC_STRICT = 0X0800;

}
