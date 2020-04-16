package com.ziyu.jvm.ch07;

import com.ziyu.jvm.ch07.classfile.Attribute;
import com.ziyu.jvm.ch07.classfile.ClassFile;
import com.ziyu.jvm.ch07.classfile.MethodInfo;
import com.ziyu.jvm.ch07.classfile.attribute.CodeAttribute;
import com.ziyu.jvm.ch07.classfile.cp.ContantPool;
import com.ziyu.jvm.ch07.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch07.instructions.base.Instruction;
import com.ziyu.jvm.ch07.instructions.base.Return;
import com.ziyu.jvm.ch07.instructions.factory;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.Thread;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;

import java.util.List;

/**
 * @ClassName interpreter
 * @Date
 * @Author
 * @Description TODO
 **/
public class Interpreter {

    public void interpret(ClassFile classFile){
        List<MethodInfo> methods = classFile.getMethods().getMethod();
        List<ContantPool> value = classFile.getConstantPool().getValue();
        for (MethodInfo method : methods) {
            String s = method.getName();
            if (!s.equals("main"))
                continue;
            List<Attribute> attributeInfo = method.getAttributeInfo();
            for (Attribute attribute : attributeInfo) {
                if (attribute instanceof CodeAttribute) {
                    CodeAttribute codeAttribute = (CodeAttribute) attribute;
                    Thread thread = new Thread();
                    thread.pushFrame(thread.newFrame(codeAttribute.getMaxLocals(), codeAttribute.getMaxStack()));
                        loop(thread, codeAttribute.getCode());

                }
            }
        }
    }

    public static void interpret(Method method){
        Thread thread = new Thread();
        Frame frame = thread.newFrame(method);
        thread.pushFrame(frame);
        loop(thread, method.getCode());

    }

    public static void loop(Thread thread, byte[] code){
        while (true) {
            Frame frame = thread.currentFrame();
            int pc = 0;
            BytecodeReader bytecodeReader = new BytecodeReader();
            pc = frame.getNextPC();
            thread.setPc(pc);
            bytecodeReader.reset(frame.getMethod().getCode(), pc);
            int i = bytecodeReader.readUnsignedInt8();
            Instruction instruction = factory.getInstruction(i);

            instruction.fetchOperands(bytecodeReader);
            frame.setNextPC(bytecodeReader.getPc());
            instruction.execute(frame);
/*            System.out.printf("%s.%s() pc:%d, inst:%s", frame.getMethod().getAClass().getName(),  frame.getMethod().getName(),
                    pc, instruction);
            System.out.println();
            System.out.println(frame.getLocalVars());
            System.out.println(frame.getOperandStack());
            System.out.println();*/
            if (thread.isStackEmpty()) {
                break;
            }
        }
    }

}
