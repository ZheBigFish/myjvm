package com.ziyu.jvm.ch07.classfile;

import com.ziyu.jvm.ch07.classfile.cp.ContantPool;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName ClassFile
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
@ToString
public class ClassFile {

    int magic;
    short minorVersion;
    short majorVersion;
    ContantPool constantPool;
    short accessFlags;
    short thisClass;
    short superClass;
    short interfacesSize;
    short[] interfaces;
    Fields fields;
    Methods methods;
    Object attributes;
    String ClassName;
    String superClassName;
    String[] interfaceName;

}
