package com.ziyu.jvm;

import com.ziyu.jvm.ch04.Frame;
import com.ziyu.jvm.ch04.LocalVars;
import com.ziyu.jvm.ch04.OperandStack;
import com.ziyu.jvm.ch05.Interpreter;
import com.ziyu.jvm.ch05.classfile.ClassFile;
import com.ziyu.jvm.ch06.classfile.ClassReader;
import com.ziyu.jvm.ch06.classfile.classpath.ClassPath;
import com.ziyu.jvm.ch06.rtda.Slot;
import com.ziyu.jvm.ch06.rtda.heap.ClassLoader;
import com.ziyu.jvm.ch06.rtda.heap.Object;
import com.ziyu.jvm.ch06.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch06.rtda.heap.kclass.Method;
import com.ziyu.jvm.ch06.rtda.heap.kclass.constantpool.HeapConstantPool;
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

//        Path path = Paths.get("D:\\niubi\\mini-jvm\\target\\tt.class");
//        com.ziyu.jvm.ch05.classfile.ClassReader.read(path);

        String s = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
        System.out.println(s.hashCode());
        System.out.println(s.hashCode());
        Slot slot = new Slot();
        Slot slot1 = new Slot();
        slot.setNum(44);
        slot1.setNum(11);
        slot1.setRef(new Object(new KClass()));
        System.out.println(slot1);

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

    @Test
    public void ch05() throws IOException {

        Path path = Paths.get("D:\\niubi\\mini-jvm\\target\\tt.class");
        ClassFile read = com.ziyu.jvm.ch05.classfile.ClassReader.read(path);
        Interpreter interpreter = new Interpreter();
        interpreter.interpret(read);

    }

    @Test
    public void ch06() throws IOException {

        String[] a = new String[1];
        a[0] = "d";

        String path = "jj";
        ClassLoader classLoader = ClassLoader.newClassLoader(new ClassPath());
        KClass kClass = classLoader.loadClass(path);
        Method mainMethod = kClass.getMainMethod();
        if (mainMethod != null) {
            com.ziyu.jvm.ch06.Interpreter.interpret(mainMethod);
        } else {
            System.out.println("no main method!");
        }

    }

}
