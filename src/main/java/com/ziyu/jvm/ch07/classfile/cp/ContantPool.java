package com.ziyu.jvm.ch07.classfile.cp;

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

    public String getStringValue(int index){
        try {
            if (index == 248) {
                System.out.println();
            }
            if (index == 0) {
                return null;
            }
            ContantPool contantPool = value.get(index);
            if (contantPool instanceof ClassInfo) {
                ClassInfo classInfo = (ClassInfo) contantPool;
                return new String(value.get(classInfo.getNameIndex()).getBytes());
            }
            if (contantPool instanceof MethodrefInfo) {
                MethodrefInfo methodrefInfo = (MethodrefInfo) contantPool;
            }
            if (contantPool instanceof NameAndTypeInfo) {
                NameAndTypeInfo nameAndTypeInfo = (NameAndTypeInfo) contantPool;
                return new StringBuilder(getStringValue(nameAndTypeInfo.getNameIndex())).append("~")
                        .append(getStringValue(nameAndTypeInfo.getDepictIndex())).toString();
            }

            return new String(value.get(index).getBytes());
        }catch (Exception e) {
            System.out.println("error:" + index);
        }
        return new String(value.get(index).getBytes());
    }

}
