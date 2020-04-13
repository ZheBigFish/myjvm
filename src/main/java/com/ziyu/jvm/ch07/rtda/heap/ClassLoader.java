package com.ziyu.jvm.ch07.rtda.heap;

import com.ziyu.jvm.ch07.classfile.ClassReader;
import com.ziyu.jvm.ch07.classfile.classpath.ClassPath;
import com.ziyu.jvm.ch07.rtda.Slots;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Field;
import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ClassLoader
 * @Date
 * @Author
 * @Description 类加载器，classMap字段可以当做是方法区
 **/
public class ClassLoader {

    ClassPath classPath;
    Map<String, java.lang.Object> classMap;

    public static ClassLoader newClassLoader(ClassPath classPath) {
        ClassLoader classLoader = new ClassLoader();
        classLoader.classMap = new HashMap<>();
        classLoader.classPath = classPath;
        return classLoader;
    }

    public KClass loadClass(String name) {
        if (classMap.containsKey(name)) {
            return (KClass) classMap.get(name);
        }
        return loadNonArrayClass(name);
    }

    public KClass loadNonArrayClass(String name) {
        byte[] bytes = this.readClass(name);
        try {
            KClass aClass = this.defineClass(bytes);
            link(aClass);
            System.out.printf("Loader %s from", name);
            return aClass;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] readClass(String name) {
        byte[] bytes = classPath.readClass(name);
        return bytes;
    }

    public KClass defineClass(byte[] data) throws IOException {
        KClass aClass = parseClass(data);
        aClass.classLoader = this;
        resolveSuperClass(aClass);
        resolveInterfaces(aClass);
        this.classMap.put(aClass.name, aClass);
        return aClass;
    }

    public KClass parseClass(byte[] data) throws IOException {
        return KClass.newClass(ClassReader.parse(new DataInputStream(new ByteArrayInputStream(data))));
    }

    public void resolveSuperClass(KClass aClass) {
        if (!"java/lang/Object".equals(aClass.getName())) {
            aClass.superClass = aClass.classLoader.loadClass(aClass.superClassName);
        }
    }

    public void resolveInterfaces(KClass aClass) {
        if (aClass.getInterfaceNames() != null) {
            KClass[] classes = new KClass[aClass.getInterfaceNames().length];
            for (int i = 0; i < aClass.getInterfaceNames().length; i++) {
                classes[i] = aClass.classLoader.loadClass(aClass.getInterfaceNames()[i]);
            }
            aClass.setInterfaces(classes);
        }
    }

    public void link(KClass aClass) {
        verify(aClass);
        prepare(aClass);
    }

    public void verify(KClass aClass) {
        // nothing to do
    }

    public void prepare(KClass aClass) {
        calcInstanceFieldSlotIds(aClass);
        calcStaticFieldSlotIds(aClass);
        allocAndInitStaticVars(aClass);
    }

    public void calcInstanceFieldSlotIds(KClass aClass) {
        int slotId = 0;
        if (aClass.getSuperClass() != null) {
            slotId = aClass.getSuperClass().instanceSlotCount;
        }
        for (int i = 0; i < aClass.fields.size(); i++) {
            if (!aClass.fields.get(i).isStatic()) {
                aClass.fields.get(i).slotId = slotId;
                slotId++;
                if (aClass.fields.get(i).isLongOrDouble()) {
                    slotId++;
                }
            }
        }
        aClass.instanceSlotCount = slotId;
    }

    public void calcStaticFieldSlotIds(KClass aClass) {
        int slotId = 0;

        for (int i = 0; i < aClass.fields.size(); i++) {
            if (aClass.fields.get(i).isStatic()) {
                aClass.fields.get(i).slotId = slotId;
                slotId++;
                if (aClass.fields.get(i).isLongOrDouble()) {
                    slotId++;
                }
            }
        }
        aClass.staticSlotCount = slotId;
    }

    public void allocAndInitStaticVars(KClass aClass) {
        aClass.staticVars = Slots.newSlots(aClass.staticSlotCount);
        aClass.getFields().forEach(field -> {
            //静态变量属于基本类型或String类型，有final修饰符，且它的值在编译期已知，则该值存储在class文件常量池中
            if (field.isStatic() && field.isFinal()) {
                initStaticFinalVar(aClass, field);
            }
        });
    }

    public void initStaticFinalVar(KClass aClass, Field field) {
        int constValueIndex = field.constValueIndex;
        int slotId = field.slotId;
        if (constValueIndex > 0) {
            switch (field.descriptor) {
                case "Z":
                case "B":
                case "C":
                case "S":
                case "I":
                    aClass.staticVars.setInt(slotId, (Integer) aClass.getContantPool().getConstant(constValueIndex));
                    break;
                case "J":
                    aClass.staticVars.setLong(slotId, (Long) aClass.getContantPool().getConstant(constValueIndex));
                    break;
                case "F":
                    aClass.staticVars.setFloat(slotId, (Float) aClass.getContantPool().getConstant(constValueIndex));
                    break;
                case "D":
                    aClass.staticVars.setDouble(slotId, (Double) aClass.getContantPool().getConstant(constValueIndex));
                    break;
                case "Ljava/lang/String":


            }
        }
    }

}
