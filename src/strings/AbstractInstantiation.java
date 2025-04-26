package strings;

abstract class A{
    public A(){
        System.out.println("indirect invocation i m in A");
    }
}




public class AbstractInstantiation extends A{

    public AbstractInstantiation(){
        System.out.println("i m in AbstractInstantiation");

    }

    public static void main(String[] args) {
        A a = new AbstractInstantiation();
    }
}
