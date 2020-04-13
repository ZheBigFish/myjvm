public class jj implements Runnable {
    //    public static int staticVar;
//    public final int instanceVar = 6;
    public static void main(String[] args) {
        new jj().test();
    }

    public void test() {
        jj.staticMethod(); // invokestatic
        jj demo = new jj(); // invokespecial
        demo.instanceMethod(); // invokespecial
        super.equals(null); // invokespecial
        this.run(); // invokevirtual
        ((Runnable) demo).run(); // invokeinterface
    }

    public static void staticMethod() {
    }

    private void instanceMethod() {
    }

    @Override
    public void run() {
    }
}
