package com.ziyu.jvm.ch05.rtda;

import lombok.Data;

/**
 * @ClassName thread
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
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

    public Frame newFrame(int local, int stack){
        return new Frame(this, local, stack);
    }

}
