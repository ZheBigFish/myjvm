package com.ziyu.jvm.ch07.instructions.references;

import com.ziyu.jvm.ch07.instructions.base.ClassInitLogic;
import com.ziyu.jvm.ch07.instructions.base.Index16Instruction;
import com.ziyu.jvm.ch07.rtda.Frame;
import com.ziyu.jvm.ch07.rtda.Slots;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Field;
import com.ziyu.jvm.ch07.rtda.heap.kclass.KClass;
import com.ziyu.jvm.ch07.rtda.heap.kclass.Method;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.HeapConstantPool;
import com.ziyu.jvm.ch07.rtda.heap.kclass.constantpool.ref.FieldRef;

/**
 * @ClassName PutStatic
 * @Date
 * @Author
 * @Description TODO
 **/
public class PutStatic extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        HeapConstantPool contantPool = frame.getMethod().getAClass().getContantPool();
        FieldRef fieldRef = (FieldRef) contantPool.getConstant(this.index);
        Method currentMethod = frame.getMethod();
        KClass currentClass = currentMethod.getAClass();
        Field field = fieldRef.resolvedField();
        KClass aClass = field.getAClass();
        if (!aClass.initStarted) {
            frame.revertNextPc();
            ClassInitLogic.initClass(frame.getThread(), aClass);
            return;
        }
        if (!field.isStatic()){
            throw new RuntimeException();
        }
        if (field.isFinal()){
            if (currentClass != aClass || !currentMethod.getName().equals("<clinit>")){
                throw new RuntimeException();
            }
        }
        String descriptor = field.getDescriptor().substring(0, 1);
        int slotId = field.getSlotId();
        Slots staticVars = field.getAClass().getStaticVars();
        switch (descriptor){
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                staticVars.setInt(slotId, frame.getOperandStack().popInt());
                break;
            case "F":
                staticVars.setFloat(slotId, frame.getOperandStack().popFloat());
                break;
            case "J":
                staticVars.setLong(slotId, frame.getOperandStack().popLong());
                break;
            case "D":
                staticVars.setDouble(slotId, frame.getOperandStack().popDouble());
                break;
            case "L":
                staticVars.setRef(slotId, frame.getOperandStack().popRef());
                break;

        }
    }
}
