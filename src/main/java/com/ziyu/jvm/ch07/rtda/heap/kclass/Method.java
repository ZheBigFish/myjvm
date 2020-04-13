package com.ziyu.jvm.ch07.rtda.heap.kclass;

import com.ziyu.jvm.ch07.classfile.MethodInfo;
import com.ziyu.jvm.ch07.rtda.heap.MethodDescriptor;
import com.ziyu.jvm.ch07.rtda.heap.MethodDescriptorParser;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Method
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class Method extends ClassMember {

    int maxStack;
    int maxLocals;
    byte[] code;
    int argSlotCount;

    public static List<Method> newMethods(KClass aClass, List<MethodInfo> methodInfos){
        List<Method> methods = new ArrayList<>();
        methodInfos.forEach(a -> {
            Method method = new Method();
            method.aClass = aClass;
            method.copyMemberInfo(a);
            method.calcArgSlotCount();
            copyAttributes(method, a);
            methods.add(method);
        });
        return methods;
    }

    public static void copyAttributes(Method method, MethodInfo methodInfo){
        if (methodInfo.getAttributesCount() > 0 && null != methodInfo.getCodeAttribute()){
            method.maxStack = methodInfo.getCodeAttribute().getMaxStack();
            method.maxLocals = methodInfo.getCodeAttribute().getMaxLocals();
            method.code = methodInfo.getCodeAttribute().getCode();
        }
    }

    public int calcArgSlotCount() {
        MethodDescriptor methodDescriptor = MethodDescriptorParser.parseMethodDescriptor(this.descriptor);
        for (String s : methodDescriptor.getParameterTypes()) {
            this.argSlotCount++;
            if ("J".equals(s) || "D".equals(s)) {
                this.argSlotCount++;
            }
        }
        //非静态方法隐含this参数
        if (!this.isStatic()) {
            this.argSlotCount++;
        }
        return this.argSlotCount;
    }

}
