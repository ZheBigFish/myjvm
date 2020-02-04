package com.ziyu.jvm.ch05.rtda;

import lombok.ToString;

/**
 * @ClassName OperandStack
 * @Date
 * @Author
 * @Description TODO
 **/
@ToString
public class OperandStack {

    int size;
    Slot[] slots = null;

    public OperandStack(int maxStack){
        if (maxStack > 0){
            make(maxStack);
        }
    }

    private void make(int maxLocals){
        slots = new Slot[maxLocals];
        for (int i = 0; i < maxLocals; i++){
            slots[i] = new Slot();
        }
    }

    public void pushInt(int val){
        slots[size].num = val;
        size++;
    }

    public int popInt(){
        size--;
        int val = slots[size].num;
        return val;
    }

    public void pushFloat(Float val){
        slots[size].num = val.intValue();
        size++;
    }

    public Float popFloat(){
        size--;
        int val = slots[size].num;
        return Float.parseFloat(String.valueOf(val));
    }

    public void pushLong(Long val){
        slots[size].num = (int) (val & 0x000000ffffffffL);
        slots[size + 1].num = (int) (val >> 32);
        size += 2;
    }

    public Long popLong(){
        size--;
        int low = slots[size - 1].num;
        int high = slots[size].num;
        size--;
        return (long) ((high & 0x000000ffffffffL) << 32 | low & 0x00000000ffffffffL);
    }

    public void pushDouble(Double val){
        pushLong(new Double(val).longValue());
    }

    public Double popDouble(){
        return (double) popLong();
    }

    public void pushRef(Object val){
        slots[size].ref = val;
        size++;
    }

    public Object popRef(){
        size--;
        Object val = slots[size].ref;
        return val;
    }

    public void pushSlot(Slot slot){
        slots[size] = slot;
        size++;
    }

    public Slot popSlot(){
        size--;
        return slots[size];
    }

}
