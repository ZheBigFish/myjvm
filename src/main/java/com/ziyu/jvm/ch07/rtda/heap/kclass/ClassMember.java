package com.ziyu.jvm.ch07.rtda.heap.kclass;

import com.ziyu.jvm.ch07.classfile.ConstantMemberRef;
import com.ziyu.jvm.ch07.rtda.heap.AccessFlags;
import lombok.Data;

/**
 * @ClassName ClassMember
 * @Date
 * @Author
 * @Description Class成员信息
 **/
@Data
public class ClassMember {

    short accessFlags;
    public String name;
    public String descriptor;
    KClass aClass;

    public void copyMemberInfo(ConstantMemberRef method){
        this.accessFlags = method.getAccessFlags();
        this.name = method.getName();
        this.descriptor = method.getDescriptorIndex();
    }

    public boolean isPublic() {
        return 0 != (this.accessFlags & AccessFlags.ACC_PUBLIC);
    }

    public boolean isFinal() {
        return 0 != (this.accessFlags & AccessFlags.ACC_FINAL);
    }
    public boolean isProtected() {
        return 0 != (this.accessFlags & AccessFlags.ACC_PROTECTED);
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
    public boolean isPrivate() {
        return 0 != (this.accessFlags & AccessFlags.ACC_PRIVATE);
    }

    public boolean isEnum() {
        return 0 != (this.accessFlags & AccessFlags.ACC_ENUM);
    }

    public boolean isAbstract() {
        return 0 != (this.accessFlags & AccessFlags.ACC_ABSTRACT);
    }

    public boolean isStatic() {
        return 0 != (this.accessFlags & AccessFlags.ACC_STATIC);
    }

    public boolean isLongOrDouble(){
        return "J".equals(this.descriptor) || "D".equals(this.descriptor);
    }

    public boolean isAccessibleTo(KClass d){
        if (this.isPublic()){
            return true;
        }
        KClass c = this.aClass;
        if (this.isProtected()){
            return d == c || d.isSubClassOf(c) || c.getPackageName().equals(d.getPackageName());
        }

        if (!this.isPrivate()){
            return c.getPackageName().equals(d.getPackageName());
        }
        return d == c;
    }
}
