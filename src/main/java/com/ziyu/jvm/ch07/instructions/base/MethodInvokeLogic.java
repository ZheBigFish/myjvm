package com.ziyu.jvm.ch07.instructions.base;

import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.Slot;
import com.ziyu.jvm.ch07.rtda.Thread;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;

/**
 * @ClassName methodInvokeLogic
 * @Date
 * @Author
 * @Description TODO
 **/
public class MethodInvokeLogic {

    public static void invokeMethod(Frame frame, Method method) {
        Thread thread = frame.getThread();
        Frame newFrame = thread.newFrame(method);
        thread.pushFrame(newFrame);
        int argSlotCount = method.getArgSlotCount();
        if (argSlotCount > 0) {
            for (int i = argSlotCount; i > 0; i--) {
                Slot slot = frame.getOperandStack().popSlot();
                newFrame.getLocalVars().setSlot(i - 1, slot);
            }
        }
    }

}
