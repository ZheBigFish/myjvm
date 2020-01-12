package com.ziyu.jvm.ch04;

/**
 * @ClassName Frame
 * @Date
 * @Author
 * @Description TODO
 **/
public class Frame {

    Frame lower;
    public LocalVars localVars;
    public OperandStack operandStack;

    public Frame(int local, int stack){
        this.localVars = new LocalVars(local);
        this.operandStack = new OperandStack(stack);
    }

}
