package com.ziyu.jvm.ch06.rtda.heap.kclass;

import com.ziyu.jvm.ch06.classfile.ClassFile;
import com.ziyu.jvm.ch06.rtda.Slots;
import com.ziyu.jvm.ch06.rtda.heap.*;
import com.ziyu.jvm.ch06.rtda.heap.ClassLoader;
import com.ziyu.jvm.ch06.rtda.heap.Object;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.HeapConstantPool;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName Class
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
@ToString
public class KClass {

    public short accessFlags;
    public String name;
    public String superClassName;
    public String[] interfaceNames;
    public HeapConstantPool contantPool;
    public List<Field> fields;
    public List<Method> methods;
    public ClassLoader classLoader;
    public KClass superClass;
    public KClass[] interfaces;
    public int instanceSlotCount;
    public int staticSlotCount;
    public Slots staticVars;

    public static KClass newClass(ClassFile classFile) {

        KClass aClass = new KClass();
        aClass.setAccessFlags(classFile.getAccessFlags());
        aClass.setName(classFile.getClassName());
        aClass.setSuperClassName(classFile.getSuperClassName());
        aClass.setInterfaceNames(classFile.getInterfaceName());
        aClass.setContantPool(HeapConstantPool.newConstantPool(aClass, classFile.getConstantPool()));
        aClass.setFields(Field.newFields(aClass, classFile));
        aClass.setMethods(Method.newMethods(aClass, classFile.getMethods().getMethod()));

        return aClass;

    }

    public boolean isPublic() {
        return 0 != (this.accessFlags & AccessFlags.ACC_PUBLIC);
    }

    public boolean isFinal() {
        return 0 != (this.accessFlags & AccessFlags.ACC_FINAL);
    }

    public boolean isSynthetic() {
        return 0 != (this.accessFlags & AccessFlags.ACC_SYNTHETIC);
    }

    public boolean isSuper() {
        return 0 != (this.accessFlags & AccessFlags.ACC_SUPER);
    }

    public boolean isInterface() {
        return 0 != (this.accessFlags & AccessFlags.ACC_INTERFACE);
    }

    public boolean isAnnotation() {
        return 0 != (this.accessFlags & AccessFlags.ACC_ANNOTATION);
    }

    public boolean isEnum() {
        return 0 != (this.accessFlags & AccessFlags.ACC_ENUM);
    }

    public boolean isAbstract() {
        return 0 != (this.accessFlags & AccessFlags.ACC_ABSTRACT);
    }

    /**
     * 功能描述：C是public，或者C和D在同一个运行时包内
     * @author ZiYu
     * @date 2020/3/15
     *
     * @return
     **/
    public boolean isAccessibleTo(KClass aClass){
        return this.isPublic() || this.getPackageName() == aClass.getPackageName();
    }

    public String getPackageName(){
        String[] split = this.name.split("//");
        if (split.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < split.length - 1; i++) {
                stringBuilder.append(split[i]);
            }
            return stringBuilder.toString();
        }
        return "";
    }

    public boolean isSubClassOf(KClass aClass){
        boolean result = false;
        do {
            result = aClass.getSuperClass() == this;
            aClass = aClass.getSuperClass();
        }while (aClass != null);
        return result;
    }

    public boolean isImplements(KClass aClass){
        boolean result = false;
        do {
            result = aClass.isSubInterfaceOf(aClass);
            aClass = aClass.getSuperClass();
        }while (aClass != null);
        return result;
    }

    public boolean isSubInterfaceOf(KClass aClass){
        for (int i = 0; i < aClass.interfaces.length; i++){
            if (aClass.getInterfaces()[i] == aClass || aClass.getInterfaces()[i].isSubInterfaceOf(aClass)){
                return true;
            }
        }
        return false;
    }

    public Object newObject() {return newObject(this);}

    public Object newObject(KClass kClass) {
        return new Object(kClass);
    }

    public boolean isAssignableFrom(KClass s){
        KClass t = this;
        if (s == t){
            return true;
        }
        if (!t.isInterface()){
            return s.isSubClassOf(t);
        }else{
            return s.isImplements(t);
        }
    }

    public Method getMainMethod(){
        return this.getStaticMethod("main", "([Ljava/lang/String;)V");
    }

    public Method getStaticMethod(String name, String descriptor){

        for (Method method : this.getMethods()) {
            if (method.isStatic() && method.getName().equals(name) && method.getDescriptor().equals(descriptor)) {
                return method;
            }
        }
        return null;

    }

}
