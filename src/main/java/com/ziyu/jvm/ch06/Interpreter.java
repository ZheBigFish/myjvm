package com.ziyu.jvm.ch06;

import com.ziyu.jvm.ch06.classfile.Attribute;
import com.ziyu.jvm.ch06.classfile.ClassFile;
import com.ziyu.jvm.ch06.classfile.MethodInfo;
import com.ziyu.jvm.ch06.classfile.attribute.CodeAttribute;
import com.ziyu.jvm.ch06.classfile.cp.ContantPool;
import com.ziyu.jvm.ch06.instructions.base.BytecodeReader;
import com.ziyu.jvm.ch06.instructions.base.Instruction;
import com.ziyu.jvm.ch06.instructions.base.Return;
import com.ziyu.jvm.ch06.instructions.factory;
import com.ziyu.jvm.ch06.rtda.Frame;
import com.ziyu.jvm.ch06.rtda.Thread;
import com.ziyu.jvm.ch06.rtda.heap.kclass.Method;

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
        Frame frame = thread.popFrame();
        BytecodeReader bytecodeReader = new BytecodeReader();
        int pc = 0;
        while (true) {
            pc = frame.getNextPC();
            thread.setPc(pc);
            bytecodeReader.reset(code, pc);
            int i = bytecodeReader.readUnsignedInt8();
            Instruction instruction = factory.getInstruction(i);

            if (instruction instanceof Return){
                break;
            }

            instruction.fetchOperands(bytecodeReader);
            frame.setNextPC(bytecodeReader.getPc());
            instruction.execute(frame);
            System.out.printf("pc:%d, inst:%s", pc, instruction);
            System.out.println();
            System.out.println(frame.getLocalVars());
            System.out.println(frame.getOperandStack());
            System.out.println();
        }
    }

}
