package com.ziyu.jvm.ch04;

/**
 * @ClassName thread
 * @Date
 * @Author
 * @Description TODO
 **/
public class Thread {

    int pc;
    Stack stack;

    public Thread(){
        stack = new Stack(1024);
    }

    public void pushFrame(Frame frame){
        stack.push(frame);
    }

    public Frame popFrame(){
        return stack.pop();
    }

    public Frame currentFrame(){
        return stack.top;
    }

}
