package com.ziyu.jvm.ch05.instructions.base;

import lombok.Data;

/**
 * @ClassName BytecodeReader
 * @Date
 * @Author
 * @Description TODO
 **/
@Data
public class BytecodeReader {

    byte[] code;
    int pc;

    public void reset(byte[] code, int pc){
        this.code = code;
        this.pc = pc;
    }

    public byte readUint8(){
        byte b = code[pc];
        pc++;
        return b;
    }

    public int readUnsignedInt8(){
        byte b = code[pc];
        pc++;
        return b & 0xff;
    }

    public int readInt8(){
        return readUint8();
    }

    public short readUint16(){
        byte high = readUint8();
        byte low = readUint8();
        short s = (short)(((high & 0x00FF) << 8) | (0x00FF & low));
        return s;
    }

    public int readUint32(){
        return 1;
    }

    public void SkipPadding(){

    }

}
