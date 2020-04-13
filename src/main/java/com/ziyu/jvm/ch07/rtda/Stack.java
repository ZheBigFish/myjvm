package com.ziyu.jvm.ch07.rtda;

/**
 * @ClassName Stack
 * @Date
 * @Author
 * @Description TODO
 **/
public class Stack {

    int maxSize;
    int size;
    Frame top;

    public Stack(int maxSize){
        this.maxSize = maxSize;
    }

    public void push(Frame frame){
        if (this.size >= this.maxSize){
            throw new RuntimeException("java.lang.StackOverflowError");
        }
        if (this.top != null){
            frame.lower = top;
        }
        this.top = frame;
        this.size++;
    }

    public Frame pop(){
        if (this.top == null){
            throw new RuntimeException("stack is null");
        }
        Frame pop = this.top;
        this.top = this.top.lower;
        this.size--;
        return pop;
    }

    public boolean isEmpty() {  return this.top == null;}

}
