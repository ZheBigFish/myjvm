package com.ziyu.jvm.ch05.rtda;

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


    public Frame(Thread thread, int local, int stack){
        this.thread = thread;
        this.localVars = new LocalVars(local);
        this.operandStack = new OperandStack(stack);
    }

}
