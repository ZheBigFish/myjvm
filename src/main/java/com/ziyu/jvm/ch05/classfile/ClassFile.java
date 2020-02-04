package com.ziyu.jvm.ch05.classfile;

import com.ziyu.jvm.ch05.classfile.cp.ContantPool;
import lombok.Data;

/**
 * @ClassName ClassFile
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class ClassFile {

    int magic;
    short minorVersion;
    short majorVersion;
    ContantPool constantPool;
    short accessFlags;
    short thisClass;
    short superClass;
    short interfacesSize;
    short interfaces;
    Fields fields;
    Methods methods;
    Object attributes;

    @Override
    public String toString() {
        return "ClassFile{" +
                "\n, magic=" + magic +
                "\n, minorVersion=" + minorVersion +
                "\n, majorVersion=" + majorVersion +
                "\n, accessFlags=" + accessFlags +
                "\n, thisClass=" + thisClass +
                "\n, superClass=" + superClass +
                "\n, interfaces=" + interfaces +
                "\n, fields=" + fields +
                "\n, methods=" + methods +
                "\n, attributes=" + attributes +
                "\n}";
    }

}
