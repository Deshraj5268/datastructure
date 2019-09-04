package strings;

abstract class A{
    public A(){
        System.out.println("indirect invocation i m in A");
    }
}




public class AbtractInstantiation extends A{

    public AbtractInstantiation(){
        System.out.println("i m in AbtractInstantiation");

    }

    public static void main(String[] args) {
        A a = new AbtractInstantiation();
    }
}
