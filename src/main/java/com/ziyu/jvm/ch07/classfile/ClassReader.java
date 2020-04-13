package com.ziyu.jvm.ch07.classfile;

import com.ziyu.jvm.ch07.classfile.attribute.*;
import com.ziyu.jvm.ch07.classfile.attribute.Deprecated;
import com.ziyu.jvm.ch07.classfile.classpath.ClassPath;
import com.ziyu.jvm.ch07.classfile.cp.*;

import java.io.*;
import java.util.ArrayList;

/**
 * @ClassName ClassReader
 * @Date
 * @Author
 * @Description TODO
 **/
public class ClassReader {

    byte[] data;

    public static ClassFile read(String path) throws IOException {
        ClassPath classPath = new ClassPath();
        InputStream is = new ByteArrayInputStream(classPath.readClass(path));
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream stream = new DataInputStream(is);
        return parse(stream);
    }

    public static ClassFile read(String path, int i) throws IOException {
        InputStream is = new FileInputStream(new File(path));
        BufferedInputStream bis = new BufferedInputStream(is);
        return parse(new DataInputStream(bis));
    }

    public static ClassFile parse(DataInputStream is) throws IOException {
        ClassFile classFile = new ClassFile();
        classFile.magic = is.readInt();
        classFile.minorVersion = is.readShort();
        classFile.majorVersion = is.readShort();
        classFile.constantPool = readConstantPool(is);
        classFile.accessFlags = is.readShort();
        classFile.thisClass = is.readShort();
        classFile.superClass = is.readShort();
        classFile.interfacesSize = is.readShort();
        classFile.interfaces = readInterfaces(classFile, is);
        classFile.fields = readFields(is, classFile.constantPool);
        classFile.methods = readMethods(is, classFile.constantPool);
        classFile.setClassName(classFile.getConstantPool().getStringValue(classFile.getThisClass()));
        classFile.setSuperClassName(classFile.getConstantPool().getStringValue(classFile.getSuperClass()));
        return classFile;
    }

    public static short[] readInterfaces(ClassFile classFile, DataInputStream is) throws IOException {
        if (classFile.getInterfacesSize() > 0) {
            int interfacesSize = classFile.getInterfacesSize();
            short[] shorts = new short[interfacesSize];
            String[] s = new String[interfacesSize];
            for (int i = 0; i < interfacesSize; i++) {
                shorts[i] = is.readShort();
                ClassInfo classInfo = (ClassInfo) classFile.getConstantPool().getValue().get(shorts[i]);
                s[i] = classFile.getConstantPool().getStringValue(classInfo.getNameIndex());
            }
            return shorts;
        }
        classFile.setInterfaceName(new String[0]);
        return new short[0];
    }

    public static ContantPool readConstantPool(DataInputStream is) throws IOException {

        ContantPool contantPool = new ContantPool();
        int length = is.readUnsignedShort();
        ArrayList<ContantPool> contantPools = new ArrayList<ContantPool>();
        contantPools.add(null);

        for (int i = 0; i < length - 1; i++) {
            if (i == 9) {
                System.out.println();
            }
            byte b = (byte) is.readUnsignedByte();
            switch (b) {
                case ContantPool.Utf8:
                    contantPools.add(new Utf8Info(is));
                    break;
                case ContantPool.Integer:
                    contantPools.add(new IntegerInfo(is));
                    break;
                case ContantPool.Float:
                    contantPools.add(new FloatInfo(is));
                    break;
                case ContantPool.Long:
                    contantPools.add(new LongInfo(is));
                    break;
                case ContantPool.Double:
                    contantPools.add(new DoubleInfo(is));
                    break;
                case ContantPool.Class:
                    contantPools.add(new ClassInfo(is));
                    break;
                case ContantPool.String:
                    contantPools.add(new StringInfo(is));
                    break;
                case ContantPool.Fieldref:
                    contantPools.add(new FieldrefInfo(is, contantPool));
                    break;
                case ContantPool.Methodref:
                    contantPools.add(new MethodrefInfo(is, contantPool));
                    break;
                case ContantPool.InterfaceMethod:
                    contantPools.add(new InterfaceMethodrefInfo(is, contantPool));
                    break;
                case ContantPool.NameAndType:
                    contantPools.add(new NameAndTypeInfo(is));
                    break;
                case ContantPool.MethodHandle:
                    contantPools.add(new MethodHandleInfo(is));
                    break;
                case ContantPool.MethodType:
                    contantPools.add(new MethodTypeInfo(is));
                    break;
                case ContantPool.InvokeDynamic:
                    contantPools.add(new InvokeDynamicInfo(is));
                    break;
            }

            //如果是Long类型或者Doulbe类型，则占两个常量池位置
            //因为是arrayList存储，所以需要add一个null占位
            if(b == ContantPool.Long || b == ContantPool.Double) {
                contantPools.add(null);
                i++;
            }
        }
        contantPool.setValue(contantPools);
        contantPool.setSize((short) length);

        return contantPool;
    }

    public static Fields readFields(DataInputStream is, ContantPool contantPool) throws IOException {

        Fields fields = new Fields();
        fields.fieldCount = is.readShort();
        ArrayList<FieldInfo> fieldList = new ArrayList<>();
        for (int i = 0; i < fields.fieldCount; i++) {
            FieldInfo field = new FieldInfo();
            field.accessFlags = is.readShort();
            field.name = contantPool.getStringValue(is.readShort());
            field.descriptorIndex = contantPool.getStringValue(is.readShort());
            field.attributesCount = is.readShort();
            for (int j = 0; j < field.getAttributesCount(); j++) {
                field.attributeInfo = new ArrayList<>();
                field.attributeInfo.add(readAttribute(is, contantPool));
            }
            fieldList.add(field);
        }
        fields.field = fieldList;

        return fields;

    }

    public static Methods readMethods(DataInputStream is, ContantPool contantPool) throws IOException {

        Methods methods = new Methods();
        methods.methodCount = is.readShort();
        ArrayList<MethodInfo> methodList = new ArrayList<>();
        for (int i = 0; i < methods.methodCount; i++) {
            MethodInfo method = new MethodInfo();
            method.accessFlags = is.readShort();
            method.name = contantPool.getStringValue(is.readShort());
            method.descriptorIndex = contantPool.getStringValue(is.readShort());
            method.attributesCount = is.readShort();
            for (int j = 0; j < method.getAttributesCount(); j++) {
                method.attributeInfo = new ArrayList<>();
                Attribute attribute = readAttribute(is, contantPool);
                method.attributeInfo.add(attribute);
                if (attribute instanceof CodeAttribute) {
                    method.setCodeAttribute((CodeAttribute) attribute);
                }
            }
            methodList.add(method);
        }
        methods.method = methodList;

        return methods;

    }

    public static Attribute readAttribute(DataInputStream is, ContantPool contantPool) throws IOException {

        short attributeNameIndex = is.readShort();
        Utf8Info utf8Info = (Utf8Info) contantPool.getValue().get(attributeNameIndex);
        AttributeEnum attributeEnum = AttributeEnum.of(new String(utf8Info.getBytes()));
        Attribute attribute = null;
        switch (attributeEnum) {
            case Code:
                attribute = new CodeAttribute(is, contantPool);
                break;
            case LineNumberTable:
                attribute = new LineNumberTableAttribute(is);
                break;
            case StackMapTable:
                attribute = new StackMapTable(is);
                break;
            case SourceFile:
                attribute = new SourceFile(is);
                break;
            case ConstantValue:
                attribute = new ConstantValue(is);
                break;
            case Exceptions:
                attribute = new Exceptions(is);
                break;
            case Signature:
                attribute = new Signature(is);
                break;
            case Deprecated:
                attribute = new Deprecated(is);
                break;
            case RuntimeVisibleAnnotations:
                attribute = new RuntimeVisibleAnnotations(is);
                break;
        }
        if (attribute != null) {
            attribute.attributeNameIndex = attributeNameIndex;
        } else {
            System.out.println("暂时没有属性表的类:" + attributeEnum.getValue());
        }

        return attribute;
    }

}
