package com.ziyu.jvm.ch03;

import com.ziyu.jvm.ch03.attribute.CodeAttribute;
import com.ziyu.jvm.ch03.attribute.LineNumberTableAttribute;
import com.ziyu.jvm.ch03.cp.*;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * @ClassName ClassReader
 * @Date
 * @Author
 * @Description TODO
 **/
public class ClassReader {

    byte[] data;

    public static ClassFile read(Path path) throws IOException {

        try (InputStream is = Files.newInputStream(path);
             BufferedInputStream bis = new BufferedInputStream(is);
             DataInputStream stream = new DataInputStream(bis)) {
            System.out.println(parse(stream));
            return null;
        }
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
        classFile.fields = readFields(is, classFile.constantPool);
        classFile.methods = readMethods(is, classFile.constantPool);
        return classFile;
    }

    public static ContantPool readConstantPool(DataInputStream is) throws IOException {

        ContantPool contantPool = new ContantPool();
        short length = is.readShort();
        ArrayList<ContantPool> contantPools = new ArrayList<ContantPool>();
        contantPools.add(null);

        for (int i = 0; i < length - 1; i++) {
            byte b = is.readByte();
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
                    contantPools.add(new FieldrefInfo(is));
                    break;
                case ContantPool.Methodref:
                    contantPools.add(new MethodrefInfo(is));
                    break;
                case ContantPool.InterfaceMethod:
                    contantPools.add(new InterfaceMethodrefInfo((is)));
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
        }
        contantPool.setValue(contantPools);
        contantPool.setSize(length);

        return contantPool;
    }

    public static Fields readFields(DataInputStream is, ContantPool contantPool) throws IOException {

        Fields fields = new Fields();
        fields.fieldCount = is.readShort();
        ArrayList<Field> fieldList = new ArrayList<>();
        for (int i = 0; i < fields.fieldCount; i++) {
            Field field = new Field();
            field.accessFlags = is.readShort();
            field.nameIndex = is.readShort();
            field.descriptorIndex = is.readShort();
            field.attributesCount = is.readShort();
            if (field.attributesCount > 0) {
                field.attributeInfo = readAttribute(is, contantPool);
            }
            fieldList.add(field);
        }
        fields.field = fieldList;

        return fields;

    }

    public static Methods readMethods(DataInputStream is, ContantPool contantPool) throws IOException {

        Methods methods = new Methods();
        methods.methodCount = is.readShort();
        ArrayList<Method> methodList = new ArrayList<>();
        for (int i = 0; i < methods.methodCount; i++) {
            Method method = new Method();
            method.accessFlags = is.readShort();
            method.nameIndex = is.readShort();
            method.descriptorIndex = is.readShort();
            method.attributesCount = is.readShort();
            if (method.attributesCount > 0) {
                method.attributeInfo = new ArrayList<>();
                method.attributeInfo.add(readAttribute(is, contantPool));
            }
            methodList.add(method);
        }
        methods.method = methodList;

        return methods;

    }

    public static Attribute readAttribute(DataInputStream is, ContantPool contantPool) throws IOException {

        short attributeNameIndex = is.readShort();
        System.out.println(new String(String.valueOf(attributeNameIndex)));
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

        }
        attribute.attributeNameIndex = attributeNameIndex;

        return attribute;
    }

}
