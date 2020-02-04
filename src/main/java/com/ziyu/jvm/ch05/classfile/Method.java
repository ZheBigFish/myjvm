package com.ziyu.jvm.ch05.classfile;

import lombok.Data;

import java.util.List;

@Data
public class Method {

    short accessFlags;
    short nameIndex;
    short descriptorIndex;
    short attributesCount;
    List<Attribute> attributeInfo;

}