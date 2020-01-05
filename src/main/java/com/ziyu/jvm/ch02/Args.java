package com.ziyu.jvm.ch02;

/**
 * @ClassName Args
 * @Date
 * @Author
 * @Description TODO
 **/
public class Args {

    private static final String ARGS_VERSION = "-version";
    private static final String ARGS_HELP = "-help";
    private static final String ARGS_VERBOSE = "-verbose";
    private static final String ARGS_CP = "-cp";
    private static final String ARGS_XJRE = "-Xjre";

    public static void paseArgs(String... args) {

        if (args.length == 0) {
            System.out.println("Hello!");
            return;
        }

        if (ARGS_VERSION.equals(args[0])) {
            System.out.println("myjvm version is no version");
        }

    }

}
