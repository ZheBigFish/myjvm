package com.ziyu.jvm.ch06.classfile.cp;

import com.ziyu.jvm.ch06.classfile.MethodInfo;
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
            return new StringBuilder(new String(value.get(nameAndTypeInfo.getNameIndex()).getBytes())).append("~")
                    .append(new String(value.get(nameAndTypeInfo.getDepictIndex()).getBytes())).toString();
        }
        return new String(value.get(index).getBytes());
    }

}
