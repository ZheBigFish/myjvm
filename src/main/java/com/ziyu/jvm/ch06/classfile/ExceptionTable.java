package com.ziyu.jvm.ch06.classfile;

import lombok.Data;

/**
 * @ClassName ExceptionTablel
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class ExceptionTable {

    short startPC;
    short endPC;
    short handlerPC;
    short catchType;

}
