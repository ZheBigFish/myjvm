package com.ziyu.jvm.ch03;

import com.ziyu.jvm.ch03.cp.*;

import javax.sound.midi.Soundbank;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName ClassFile
 * @Date
 * @Author
 * @Description TODO
 **/
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
