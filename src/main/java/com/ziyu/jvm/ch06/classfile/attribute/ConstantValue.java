package com.ziyu.jvm.ch06.classfile.attribute;

import com.ziyu.jvm.ch06.classfile.Attribute;
import lombok.Data;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * @ClassName ConstantValue
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class ConstantValue extends Attribute {

    int length;
    short constantValueIndex;

    public ConstantValue(DataInputStream is) throws IOException {
        this.length = is.readInt();
        this.constantValueIndex = is.readShort();
    }

}
