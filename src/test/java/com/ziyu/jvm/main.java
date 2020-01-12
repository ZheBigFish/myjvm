package com.ziyu.jvm;

import com.ziyu.jvm.ch03.ClassReader;
import com.ziyu.jvm.ch04.Frame;
import com.ziyu.jvm.ch04.LocalVars;
import com.ziyu.jvm.ch04.OperandStack;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName main
 * @Date
 * @Author
 * @Description TODO
 **/
public class main {

    @Test
    public void ch03() throws IOException {

        Path path = Paths.get("D:\\niubi\\mini-jvm\\target\\tt.class");
        ClassReader.read(path);

    }

    @Test
    public void ch04(){
        Frame frame = new Frame(100, 100);
        testLocalVars(frame.localVars);
        testOperandStack(frame.operandStack);
    }

    public void testLocalVars(LocalVars vars){
        vars.setInt(0, 100);
        vars.setInt(1, -100);
        vars.setLong(2, 2997924580L);
        vars.setLong(4, -2997924580L);
        vars.setFloat(6, 3.14159F);
        vars.setDouble(7, 2.71828182845);
        vars.setRef(9, null);
        System.out.println(vars.getInt(0));
        System.out.println(vars.getInt(1));
        System.out.println(vars.getLong(2));
        System.out.println(vars.getLong(4));
        System.out.println(vars.getFloat(6));
        System.out.println(vars.getDouble(7));
        System.out.println(vars.getRef(9));
    }
    
    public void testOperandStack(OperandStack ops){
        ops.pushInt(100);
        ops.pushInt(-100);
        ops.pushLong(2997924580L);
        ops.pushLong(-2997924580L);
        ops.pushFloat(3.1415926F);
        ops.pushDouble(2.71828182845);
        ops.pushRef(null);
        System.out.println(ops.popRef());
        System.out.println(ops.popDouble());
        System.out.println(ops.popFloat());
        System.out.println(ops.popLong());
        System.out.println(ops.popLong());
        System.out.println(ops.popInt());
        System.out.println(ops.popInt());
    }

}
