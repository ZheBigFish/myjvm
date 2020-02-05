package com.ziyu.jvm.ch05.instructions;

import com.ziyu.jvm.ch05.instructions.base.Instruction;
import com.ziyu.jvm.ch05.instructions.base.Return;
import com.ziyu.jvm.ch05.instructions.comparisons.IfIcmpgt;
import com.ziyu.jvm.ch05.instructions.constants.*;
import com.ziyu.jvm.ch05.instructions.control.Goto;
import com.ziyu.jvm.ch05.instructions.loads.ILoad1;
import com.ziyu.jvm.ch05.instructions.loads.ILoad2;
import com.ziyu.jvm.ch05.instructions.math.IAdd;
import com.ziyu.jvm.ch05.instructions.math.IInc;
import com.ziyu.jvm.ch05.instructions.stores.IStore1;
import com.ziyu.jvm.ch05.instructions.stores.IStore2;

/**
 * @ClassName factory
 * @Date
 * @Author
 * @Description TODO
 **/
public class factory {

    public static Instruction getInstruction(int b){
        switch (b){
            case 0x00: return new Nop();
            case 0x01: return new AconstNull();
            case 0x03: return new Iconst0();
            case 0x04: return new Iconst1();
            case 0x10: return new BiPush();
            case 0x1b: return new ILoad1();
            case 0x1c: return new ILoad2();
            case 0xa3: return new IfIcmpgt();
            case 0xa7: return new Goto();
            case 0x3c: return new IStore1();
            case 0x3d: return new IStore2();
            case 0x60: return new IAdd();
            case 0x84: return new IInc();
            case 0xb1: return new Return();
            default:
                System.out.println("not found");;
        }
        return null;
    }

}
