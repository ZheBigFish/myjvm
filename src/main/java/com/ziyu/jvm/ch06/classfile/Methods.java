package com.ziyu.jvm.ch06.classfile;

import lombok.Data;

import java.util.List;

/**
 * @ClassName Methods
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class Methods {

    short methodCount;
    List<MethodInfo> method;
}
