/**
 * Created by julia on 27-Jan-17.
 */
public class CastingExample {
    public static void main(String... args) {
        A a0 = new A();
        B b0 = new B();
        C c0 = new C();
        I i0 = new B();


        A a1 = a0;
        A a2 = b0;
        A a3 = c0;
        //A a4 = i0; CTE
        A a5 = (A) i0;

        //B b1=a0; CTE
        B b2 = (B) a0; //RTE
        B b3 = b0;
        B b4 = c0;
        //B b5=i0; CTE
        B b6 = (B) i0;

        //C c1 = a0; CTE
        C c2 = (C) a0;
        //C c3 = b0;CTE
        C c4 = (C) b0;
        C c5 = c0;
        //C c6 = i0;CTE
        C c7 = (C) i0;

        //I i1 = a0;CTE
        I i2 = (I)a0;//RTE
        I i3=b0;
        I i4=c0;
        I i5=i0;

    }
    static class A{}
    interface I{}
    static class B extends A implements I{}
    static class C extends B{}
}