package com.ziyu.jvm.Util;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;

/**
 * @ClassName InputStreamUtil
 * @Date
 * @Author
 * @Description TODO
 **/
public class InputStreamUtil {

    public static byte[] readNBytes(DataInputStream dataInputStream, int length) throws IOException {
        byte[] bytes = new byte[length];
        for(int i = 0; i < length; i++) {
            byte b = dataInputStream.readByte();
            bytes[i] = b;
        }
        return bytes;
    }

}
