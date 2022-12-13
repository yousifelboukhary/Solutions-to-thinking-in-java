package com.company;

import java.util.Random;

import static com.company.Print.print;

public class ChapterFive {
}
//Q1

//Q5 (1) Starting from Exercise 1, add a wheels( ) method in Cycle, which
//returns the number of wheels. Modify ride( ) to call wheels( ) and verify that
//polymorphism works.

//Q17 Using the Cycle hierarchy from Exercise 1, add a balance( ) method to
//Unicycle and Bicycle, but not to Tricycle. Create instances of all three types and upcast
//them to an array of Cycle. Try to call balance( ) on each element of the array and observe
//the results. Downcast and call balance( ) and observe what happens.
class Cycle{
    void ride(){
        print("ride a cycle");
        wheels();
    }
    public void wheels( ){}
}

class UniCycle extends Cycle{
    void ride(){
        wheels( );
        print("ride a Unicycle");
    }
    public void wheels( ){
        print(1);
    }
    //Q17
    public void balance( ){
        print("balance()");
    }
}
class BiCycle extends Cycle{
    void ride(){
        print("ride a Bicycle");
        wheels( );

    }
    public void wheels( ){
        print( 2);
    }

    //Q17
    public void balance( ){
        print("balance()");
    }
}
class TriCycle extends Cycle{
    void ride(){
        print("ride a Tricycle");
        wheels( );
    }
    public void wheels( ){
        print( 3);
    }
    void stop(){
        print("Stop the cycle");
    }
}
class MainClass{
    public static void main(String [] args){
        Cycle cycle = new TriCycle(); //UpCasting
        cycle.ride();
        Cycle [] cycles = {
                new UniCycle(),
                new BiCycle(),
                new TriCycle(),
        };
        ((UniCycle)cycles[0]).balance();
        ((BiCycle)cycles[1]).balance();
        //((TriCycle)cycles).balance(); //ClassCastException
    }
}

/////////////////////////////
//Q2 :(1) Add the @Override annotation to the shapes example.

//Q3 :(1) Add a new method in the base class of Shapes.java that prints a
//message, but don’t override it in the derived classes. -> I put the method resize()
// Explain what happens. If you want to access the method from one of the subclasses you access directly the base class resize method
// Now override it in one of the derived classes but not the others
// , and see what happens. if you want access it from that class you will get the derived class method, and you will get the base class method if you want to access it from any other subclasses
// Finally, override it in all the derived classes.

//Q4 (2) Add a new type of Shape to Shapes.java and verify in main( ) that
//polymorphism works for your new type as it does in the old types.
  //the output->
////Circle.draw()
////Circle.draw()
////Circle.draw()
////Square.draw()
////Square.draw()
////Rectangle.draw()    -->the new one
////Circle.draw()
////Circle.draw()
////Triangle.draw()
class Shape {
    public void draw() {}
    public void erase() {}
} ///:~
//: polymorphism/shape/Circle.java
class Circle extends Shape {
    @Override
    public void draw() { print("Circle.draw()"); }
    @Override
    public void erase() { print("Circle.erase()"); }
} ///:~
class square extends Shape {
    @Override
    public void draw() { print("Square.draw()"); }
    @Override
    public void erase() { print("Square.erase()"); }
} ///:~
class Triangle extends Shape {
    @Override
    public void draw() { print("Triangle.draw()"); }
    @Override
    public void erase() { print("Triangle.erase()"); }
} ///:~
class Rectangle extends Shape{
    @Override
    public void draw(){print("Rectangle.draw()");}
    @Override
    public void erase(){print("Rectangle.erase()");}
}
class RandomShapeGenerator {
    private Random rand = new Random(47);
    public Shape next() {
        switch(rand.nextInt(5)) {
            default:
            case 0: return new Circle();
            case 1: return new square();
            case 2: return new Triangle();
            case 4: return new Rectangle();
        }
    }
}
class Shapes {
    private static RandomShapeGenerator gen =
            new RandomShapeGenerator();
    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        // Fill up the array with shapes:
        for(int i = 0; i < s.length; i++)
            s[i] = gen.next();
        // Make polymorphic method calls:
        for(Shape shp : s)
            shp.draw();
    }
}
enum Note{
    MIDDLE_C, C_SHARP, B_FLAT;
}

class Instrument {
    void play(Note n) { print("Instrument.play() " + n); }
    String what() { return "Instrument"; }
    void adjust() { print("Adjusting Instrument"); }
}
class Wind extends Instrument {
    void play(Note n) { print("Wind.play() " + n); }
    String what() { return "Wind"; }
    void adjust() { print("Adjusting Wind"); }
}
class Percussion extends Instrument {
    void play(Note n) { print("Percussion.play() " + n); }
    String what() { return "Percussion"; }
    void adjust() { print("Adjusting Percussion"); }
}
class Stringed extends Instrument {
    void play(Note n) { print("Stringed.play() " + n); }
    String what() { return "Stringed"; }
    void adjust() { print("Adjusting Stringed"); }
}
class Brass extends Wind {
    void play(Note n) { print("Brass.play() " + n); }
    void adjust() { print("Adjusting Brass"); }
}
class Woodwind extends Wind {
    void play(Note n) { print("Woodwind.play() " + n); }
    String what() { return "Woodwind"; }
}

class Music3 {
    // Doesn’t care about type, so new types
    // added to the system still work right:
    private static Random random = new Random(20);


    public static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }
    public static void tuneAll(Instrument[] e) {
        for(Instrument i : e)
            tune(i);
    }
    public static void main(String[] args) {
 //Q8
        Instrument ie ;
        if(random.nextInt(5) == 1){
            ie= new Wind();
        }else if(random.nextInt(5) == 2){
            ie= new Brass();
        }
        else if(random.nextInt(5) ==3){
            ie = new Percussion();
        }
        else{
            ie = new Stringed();
        }
        // Upcasting during addition to the array:
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}

//Q9
class Rodent{
    public void eat(){}
}
class Mouse extends Rodent{
    @Override
    public void eat() {
        print("Mouse.eat()");
    }
}

class Gerbil extends Rodent{
    @Override
    public void eat() {
        print("Gerbil.eat()");
    }
}
class Hamster extends Rodent{
    @Override
    public void eat() {
        print("Hamster.eat()");
    }
}
class MainRodent{
    public static void main(String [] args){
        Rodent [] rodents = {
                new Gerbil(), new Hamster(), new Mouse()
        };
        for(Rodent r : rodents)
            r.eat();
    }
}

//Q10
class B_Class{
    public void m1(){
        m2();
    }

    public void m2() {
        print("m2 Base class");
    }
}
class D_Class extends B_Class{
    public void m2() {
        print("m2 Derived class");
    }
}
class MainB{
    public static void main(String [] args){
        B_Class d_class = new D_Class();
        d_class.m1();
    }
}

//Q16
class AlertStatus {
    protected void f(){
        print("AlertStatus()");
    }
}
class D1_AlertStatus extends AlertStatus{
    protected void f(){
        print("D1_AlertStatus()");
    }
}
class D2_AlertStatus extends AlertStatus{
    protected void f(){
    print("D2_AlertStatus()");
}}
class D3_AlertStatus extends AlertStatus{
    protected void f(){
        print("D3_AlertStatus()");
    }
}
class Starship {

    public static void fun(
            AlertStatus alertStatus
    ){
        alertStatus.f();
    }
    public static void main(String [] args){
        AlertStatus alertStatus = new D1_AlertStatus();
        AlertStatus alertStatus1 = new D2_AlertStatus();
        AlertStatus alertStatus2 = new D3_AlertStatus();
        fun(alertStatus);
        fun(alertStatus1);
        fun(alertStatus2);
    }
}