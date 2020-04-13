public class MyObject {
    public static int staticVar = 3;
    public int instanceVar;

    public MyObject() {
    }

    public void tt() {
        System.out.println("MyObject");
    }

    public static void main(String[] var0) {
/*        char var1 = 'd';
        MyObject var2 = new MyObject();
        staticVar = var1;
        int var4 = staticVar;
        var2.instanceVar = var4;
        var4 = var2.instanceVar;
        if (var2 instanceof MyObject) {
            var2 = (MyObject)var2;
            System.out.println(var2.instanceVar);
        }*/
        MyObject myObject = new jj();
        myObject.tt();

    }
}