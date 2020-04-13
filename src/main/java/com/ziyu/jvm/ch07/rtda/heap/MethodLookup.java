package com.ziyu.jvm.ch07.rtda.heap;

import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;

/**
 * @ClassName methodLookup
 * @Date
 * @Author
 * @Description TODO
 **/
public class MethodLookup {

    public static Method lookUpMethodInClass(KClass kClass, String name, String descriptor) {
        for (KClass kClass1 = kClass; kClass1 != null; kClass1 = kClass1.superClass) {
            for (Method method : kClass1.getMethods()) {
                if (name.equals(method.name) && descriptor.equals(method.descriptor)) {
                    return method;
                }
            }
        }
        return null;
    }

    public static Method lookupMethodInInterfaces(KClass[] kClass, String name, String descriptor) {
        for (KClass aClass : kClass) {
            for (Method method : aClass.getMethods()) {
                if (name.equals(method.name) && descriptor.equals(method.descriptor)) {
                    return method;
                }
            }
            Method method = lookupMethodInInterfaces(aClass.interfaces, name, descriptor);
            if (method != null) {
                return method;
            }
        }

        return null;
    }

}
