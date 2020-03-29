package com.ziyu.jvm.ch06.rtda;

import com.ziyu.jvm.ch06.rtda.heap.Object;
import lombok.Data;
import lombok.ToString;

/**
 * @ClassName Slot
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
@ToString
public class Slot {

    public int num;
    public Object ref;

    public Slot(int num) {
        this.num = num;
    }

    public Slot(Object ref) {
        this.ref = ref;
    }

    public Slot(){}
}
