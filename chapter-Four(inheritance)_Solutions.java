package com.company;

import static com.company.Print.print;

public class Chapter_four {
}

class Ex_1{
    String str= new String("ss");
    Ex_1(){
        System.out.println("yousif is my name");
    }
}
class composed{
    Ex_1 ex_1;
    public void fn(){
        if(ex_1 == null) //Delay initialization
            ex_1 = new Ex_1();
    }
}

class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute(); x.apply(); x.scrub();
        print(x);
    }
}
class Detergent extends Cleanser {
    // Change a method:
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub(); // Call base-class version
    }
    // Add methods to the interface:
    public void foam() { append(" foam()"); }
    // Test the new class:
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base class:");
        Cleanser.main(args);
    }
}
class DelegatedDetergent{
    Cleanser cleanser = new Cleanser();
    public void append(String a){
        cleanser.append(a);
    }
    public void dilute(){
        cleanser.dilute();
    }
    //............
}
class Washing extends Detergent{
    @Override
    public void scrub() {
        super.scrub();
        append("Washing.scrub()");
    }
    public void sterilize(){
        print("sterilize");
    }
}

class Art{
    Art(){print("Art constructor");}
}
class Drawing extends Art{
    Drawing(){print("Drawing constructor");}
}
class Cartoon extends Drawing{
    public static void main(String[] args){
        Cartoon cartoon = new Cartoon();
    }
}

class A{
    int i;
    A(int i){
        print("A");
    }
}
class B{
    int b;
    B(int b){
        this.b =b;
        print("B");
    }
    public static void main(String[] args){
        C c = new C(5);
    }
}
class C extends A{
    C(int i){
        super(i);
    }
    B b = new B(5);
}

class Base{
    Base(int x){
        print("base class");
    }
}

class Derived extends Base{
    Derived(int c){
        super(c);
    }
    Derived(){
        super(5);
    }
}

//Q13
class Ex_13{
    String over_load(){
        return "first overloaded function";
    }

    String over_load(int i){
        return "second overloaded function";
    }

    String over_load(int i, int j){
        return "Third overloaded function";
    }
}

class Ex_13_Derived extends Ex_13{
    String over_load(float a) {
        return "redefining the function in the derived class";
    }
    public static void main(String [] args){
        Ex_13_Derived ex_13_derived = new Ex_13_Derived();
        print(ex_13_derived.over_load());
        print(ex_13_derived.over_load(1));
        print(ex_13_derived.over_load(1,1));
        print(ex_13_derived.over_load(10f));
    }
}

//Q14
class Engine {
    public void start() {}
    public void rev() {}
    public void stop() {}
    void service(){}
}
class Wheel {
    public void inflate(int psi) {}
}
class Window {
    public void rollup() {}
    public void rolldown() {}
}
class Door {
    public Window window = new Window();
    public void open() {}
    public void close() {}
}
class Car {
    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door
            left = new Door(),
            right = new Door(); // 2-door

    public Car() {
        for (int i = 0; i < 4; i++)
            wheel[i] = new Wheel();
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
        car.engine.service();
    }
}

//Q15
class Area{
    //If you try to call this method outside the package you will face error
    //because the visibility of protected  accessM is inside the package and to the derived classes;
    protected double calculateArea(){
        return 0d;
    }
}

class Square extends Area{
    double side;
    Square(double side){
        this.side = side;
    }
    @Override
    public double calculateArea(){
        return side*side;
    }
}

//Q16 , 17
class Amphibian{
    protected static void swim(){
        print("Swimming");
    }

    protected void walk(){
        print("Walking");
    }
}

class Frog extends Amphibian{
    public void jump(){
        print("jumping");
    }
    public void walk(){
        print("Frog walk!!");
    }

    public static void main(String [] args){
        Amphibian frog = new Frog();
        Frog.swim(); //Access by Frog class
        frog.walk();
        Frog frog2 = new Frog();
        frog2.walk();
    }
}

//Q18
//static final : part of the class (can access by the name of the class )declared once , can not be changed
//final : instance field , declared once , can not be changed

//Q19
class FinalBlank{
    final int i;

    //Default constructor
    public FinalBlank(){
        i= 5;
    }

    //Parametrized constructor
    public FinalBlank(int i){
        this.i = i;
    }

}

//Q20 @Override annotation will throw an error if you want to override private method
//Q21
class FinalMethod{
    final void over(){

    }
}

class OverrideFinalMethod extends FinalMethod{
    //void over(){}
    //over()' cannot override 'over()' in 'com.company.FinalMethod'; overridden method is final
}

//Q22 you will get error: Cannot extend final class ‘ClassName’
