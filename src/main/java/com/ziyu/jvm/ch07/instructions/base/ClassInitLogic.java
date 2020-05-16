package com.ziyu.jvm.ch07.instructions.base;

import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.Thread;
import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;

/**
 * @ClassName ClassInitLogic
 * @Date
 * @Author
 * @Description TODO
 **/
public class ClassInitLogic {

    public static void initClass(Thread thread, KClass kClass) {
        kClass.startInit();
        scheduleClinit(thread, kClass);
        initSuperClass(thread, kClass);
    }

    private static void scheduleClinit(Thread thread, KClass kClass) {
        Method method = kClass.GetClinitMethod();
        if (null != method) {
            //执行初始化方法
            Frame newFrame = thread.newFrame(method);
            thread.pushFrame(newFrame);
        }
    }

    private static void initSuperClass(Thread thread, KClass kClass) {
        if (!kClass.isInterface()) {
            KClass superClass = kClass.getSuperClass();
            if (null != superClass && !superClass.initStarted) {
                initClass(thread, superClass);
            }
        }
    }

}
