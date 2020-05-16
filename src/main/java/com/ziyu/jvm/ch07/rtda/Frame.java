package com.ziyu.jvm.ch07.rtda;

import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;
import lombok.Data;

/**
 * @ClassName Frame
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class Frame {

    Frame lower;
    LocalVars localVars;
    OperandStack operandStack;
    Thread thread;
    int nextPC;
    Method method;

    public Frame(Thread thread, int local, int stack){
        this.thread = thread;
        this.localVars = new LocalVars(local);
        this.operandStack = new OperandStack(stack);
    }

    public Frame(Thread thread, int local, int stack, Method method){
        this.thread = thread;
        this.localVars = new LocalVars(local);
        this.operandStack = new OperandStack(stack);
        this.method = method;
    }

    public Frame(Thread thread, Method method){
        this.thread = thread;
        this.localVars = new LocalVars(method.getMaxLocals());
        this.operandStack = new OperandStack(method.getMaxStack());
        this.method = method;
    }

    public void revertNextPc() {
        this.nextPC = this.thread.pc;
    }

}
