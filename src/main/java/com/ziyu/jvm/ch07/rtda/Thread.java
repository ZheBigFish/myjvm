package com.ziyu.jvm.ch07.rtda;

import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;
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

    public Frame topFrame(){
        return stack.top;
    }

    public Frame newFrame(int local, int stack){
        return new Frame(this, local, stack);
    }

    public Frame newFrame(Method method){return new Frame(this, method);}

    public boolean isStackEmpty() {
        return this.stack.isEmpty();
    }

}
