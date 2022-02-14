package javapractice.oops;

public class OverridingPractice {


    public static void main(String[] args) {

        A a = new B();
        a.m1();
        // a.m2();//correct a.m2(3);
        B b = new B();
        b.m2();  // due to inheritance
        b.m2(20);

       // B b1 = new A();
    }



}

class A{

    public void m1(){
        System.out.println("i am m1() method of class A");
    }

    public void m2(int x){
        System.out.println("i am m2(int x) method of class A");
    }
}

class B extends A{

    public void m1(){
        System.out.println(" i have overridden m1() method of class A  ");
    }

    public void m2(){
        System.out.println(" i am m2() method of class B ");
    }
}
