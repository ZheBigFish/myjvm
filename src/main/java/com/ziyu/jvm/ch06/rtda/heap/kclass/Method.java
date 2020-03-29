package com.ziyu.jvm.ch06.rtda.heap.kclass;

import com.ziyu.jvm.ch06.classfile.MethodInfo;
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

    public static List<Method> newMethods(KClass aClass, List<MethodInfo> methodInfos){
        List<Method> fields1 = new ArrayList<>();
        methodInfos.forEach(a -> {
            Method field = new Method();
            field.aClass = aClass;
            field.aClass = aClass;
            field.copyMemberInfo(a);
            copyAttributes(field, a);
            fields1.add(field);
        });
        return fields1;
    }

    public static void copyAttributes(Method method, MethodInfo methodInfo){
        if (methodInfo.getAttributesCount() > 0){
            method.maxStack = methodInfo.getCodeAttribute().getMaxStack();
            method.maxLocals = methodInfo.getCodeAttribute().getMaxLocals();
            method.code = methodInfo.getCodeAttribute().getCode();
        }
    }

}
