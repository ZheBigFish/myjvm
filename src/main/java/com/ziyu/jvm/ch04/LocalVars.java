package com.ziyu.jvm.ch04;

/**
 * @ClassName LocalVars
 * @Date
 * @Author
 * @Description TODO
 **/
public class LocalVars {

    Slot[] slots = null;

    public LocalVars(int maxLocals){
        if (maxLocals > 0){
            make(maxLocals);
        }
    }

    private void make(int maxLocals){
        slots = new Slot[maxLocals];
        for (int i = 0; i < maxLocals; i++){
            slots[i] = new Slot();
        }
    }

    public void setInt(int index, int val){
        this.slots[index].num = val;
    }

    public int getInt(int index){
        return slots[index].num;
    }

    public void setFloat(int index, Float val){
        this.slots[index].num = val.intValue();
    }

    public Float getFloat(int index){
        return Float.parseFloat(String.valueOf(slots[index].num));
    }

    public void setLong(int index, Long val){
        slots[index].num = (int) (val & 0xffff);
        slots[index + 1].num = (int) ((val >> 32) & 0xffffffffL);
    }

    public Long getLong(int index){
        int low = slots[index].num;
        int high = slots[index + 1].num;

        return (long) (high << 32 | low);
    }

    public void setDouble(int index, Double val){
        setLong(index, new Double(val).longValue());
    }

    public Double getDouble(int index){
        return (double) getLong(index);
    }

    public void setRef(int index, Object val){
        slots[index].ref = val;
    }

    public Object getRef(int index){
        return slots[index].ref;
    }

}