package com.ziyu.jvm.ch04;

/**
 * @ClassName OperandStack
 * @Date
 * @Author
 * @Description TODO
 **/
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
        int val = slots[size].num;
        size--;
        return val;
    }

    public void pushFloat(Float val){
        slots[size].num = val.intValue();
        size++;
    }

    public Float popFloat(){
        int val = slots[size].num;
        size--;
        return Float.parseFloat(String.valueOf(val));
    }

    public void pushLong(Long val){
        slots[size].num = (int) (val & 0xffff);
        slots[size + 1].num = (int) ((val >> 32) & 0xffffffffL);
        size += 2;
    }

    public Long popLong(){
        int low = slots[size - 2].num;
        int high = slots[size - 1].num;
        size -= 2;
        return (long) (high << 32 | low);
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
        Object val = slots[size].ref;
        size--;
        return val;
    }

}
