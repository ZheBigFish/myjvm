package com.ziyu.jvm.ch05.classfile;

import lombok.Data;

/**
 * @ClassName Attribute
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class Attribute {

    public short attributeNameIndex;
    int length;
    byte[] info;

}
