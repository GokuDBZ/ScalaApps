object HelloWorld {

  def main(args: Array[String]) {
    println("hello world");
    val name = "suraj";
    val age = 25;

    val line:String = s"$name is $age years old";
    println(name +" is " + age + " years old");

    println(line);

    // line is not type safe as name is string and age is integer

    // this is type safe
    println("Type safe string");
    val line2:String = f"$name%s is $age%d years old"
    println(line2);

    // raw string

    print(raw"heyy \n");

    print(s"\n")


    var value1 = 1;
    var value = 2;

    val higher = if(1>2) "1>2" else "1 < 2";
    println(higher)
    println(if(1>2) "1>2" else "1 < 2")
    println("factorial of 3 is "+factorial(3));

    //nested loop
    Loops.nestedLoop();

    // condition in a loop
    conditionInForLoop;

    // how to use loops as a expression like map in ruby
    loopAsExpression();

    // switch case in ruby
    swtichOrMatchExpression();

    // Methods inside object are treated as static
    println(Methods.methodWithDefaultValues())
    println(Methods.methodWithDefaultValues(10))
    println(Methods.methodWithDefaultValues(10, 20))

    println(Methods.+(1,2))
    println(Methods.*(1,2))
    println(Methods.-(1,2))



    // AnonymousFunction.get is going to return a anonymous function
    println(AnonymousFunction.get("?")(0,0));

    // AnonymousFunction.get() returns an anonymous function
    println(AnonymousFunction.get("+")(1,2));
    println(AnonymousFunction.get("-")(3,2));
    println(AnonymousFunction.get("*")(3,2));


    // Higher Order Function
    HigherOrderFunction.perform(2, 3, operator = "+")
    HigherOrderFunction.perform(2, 3, operator = "-")
    HigherOrderFunction.perform(2, 3, operator = "*")
    HigherOrderFunction.perform(2, 3, operator = "/")

    println(HigherOrderFunction.perform(2, 3, 4, "/"))
    println(HigherOrderFunction.perform(2, 3, 4, "+"))
    println(HigherOrderFunction.perform(4, 3, 1, "-"))
    println(HigherOrderFunction.perform(2, 3, 4, "max"))
    println(HigherOrderFunction.perform(2, 3, 4, "min"))

    println(HigherOrderFunction.performWithWildCard(2, 3, 4, "/"))
    println(HigherOrderFunction.performWithWildCard(2, 3, 4, "+"))
    println(HigherOrderFunction.performWithWildCard(4, 3, 1, "-"))
    println(HigherOrderFunction.performWithWildCard(2, 3, 4, "max"))
    println(HigherOrderFunction.performWithWildCard(2, 3, 4, "min"))

    // there is expression inside object so that will be executed
    PartaillyAppliedFunction

    //Closures

    println(Closures.impureClosure(10))

    println(Closures.impureClosure(20))

    println(Closures.impureClosure(20))

    println(Closures.impureClosure(30))

    println(Closures.impureClosure(50))


    // Currying

    //Currying is a technique of converting a function which take multiple argument into a function
    // which takes one argument. This makes use of closure

    println(Currying.notCurriedName("Suraj", "Yadav"))

    println(Currying.curriedName("Suraj")("Yadav"))

    // Partailly Applied function with currying

    var fullName = Currying.curriedName("Suraj");

    println(fullName("Yadav"))

    // Scala also provides a way to define a currade function

    println(Currying.curriedFunc(1)(2))

    // here partial apply with scala curried signature is not working some how
    // var partialApplied = Currying.curriedFunc(1) should have been worked
    var partialApplied = Currying.curriedFunc(1)(_);
    println(partialApplied(2))



    // Arrays
    Arrays

    // Lists
    Lists

    // Sets
    Sets

    //Maps
    Maps

    //Tuples
    Tuples

    // options
    Options

    // Maps and filters
    MapAndFilter

    ReduceFoldOrScan


    //Class
    var user = new User1("suraj", 1)

    //          Getter?    Setter?
    // var      yes         yes
    // val      yes         no
    // default  no          no

    var ob = new AuxiliaryCons();
    println(ob.name);
    println(ob.age);

    val ob1 = new AuxiliaryCons("suraj", 25)
    println(ob1.name)
    println(ob1.age)
  }

  def factorial(n:Int):Int= {
    var fact = n;
    var temp = 1;
    if(fact <= 0 ) return 1;
    while(fact > 0){
      temp *= n;
      fact -= 1;
    }
    return temp;
  }
  object Loops{
    def nestedLoop(){
      // a belongs to parent loop and b is nested one.
      for(a <- 1.to(3); b <- 1.to(5)){
        println(s"a value is $a and b value is $b")
      }
    }
  }




  def conditionInForLoop: Unit ={
    var list = List(1,2,3,4,5,6,7,8,9,10);
    //Normal for Loop
    for(l <- list){
      println(l);
    }

    // For Loop with condition
    println("i got a condition in for loop")
    for(l <- list; if l > 2){
      println(l);
    }
  }

  def loopAsExpression() {
    var result = for(a <- 1.to(5); if a > 2) yield { a * a}
    println(result);

    // if we want multiple lines in for loop and don't want to sue semicolon
    var result1 = for { a <- 1.to(5)
                        if a > 2
    } yield { a * a}
    println(result1)
  }

  def swtichOrMatchExpression(){
    var value = 5;

    var result = value match {
      case 1 => println(value);
      case 2 => println(value);
      case 3 => println(value);
      case 4 => println(value);
      case 5 => println(value);
      case 6 => println(value);
      case 7 => println(value);
      // _ is default case
      case _ => println("Default Value");

    }
    println(s" first pattern match $result");

    var result1 = value match {
      case 1 |2 | 3| 4 => println(value);
      case 5 |6 |7 |8  => println(value);
    }
    println(s" first pattern match $result1");
  }
}

object Methods {
  def methodWithDefaultValues(a:Int = 10, b:Int =20) :Int = a + b

  def +(a:Int = 0 , b:Int = 0 ):Int = a + b
  def -(a:Int = 0 , b:Int = 0 ):Int = a - b
  def *(a:Int = 0 , b:Int = 0 ):Int = a * b
}

object AnonymousFunction {

  // we need to give = after get() else it will throw error
  def get(matchValue: String = "+"): (Int, Int) => Any = {

    // this is anonymous function
    matchValue match {
      case "+" => {
        (a: Int, b: Int) => {
          println(s"Operations is $matchValue")
          a + b
        }
      }
      case "-" => {
        (a: Int, b: Int) => {
          println(s"Operations is $matchValue")
          a - b
        }
      }
      case "*" => {
        (a: Int, b: Int) => {
          println(s"Operations is $matchValue")
          a - b
        }
      }
      case _ => (a: Int, b: Int) => {
        0
      }
    }

  }
}

object HigherOrderFunction {

  // Passing Anonymous function as parameter
  def operation(x: Int = 0 , y: Int = 0, z:Int = 0,func: (Int, Int) => Int): Int = {
    // Commenting it out as z:Int = null not working right now
    //if(z == null) func(x, y) else func(func(x,y), z)
    func(func(x,y), z)

  }

  def perform(x: Int = 1, y: Int = 1, z:Int = 0, operator: String): Any = {
    operator match {
      case "+" => operation(x, y, z, (x, y) => {
        x + y
      })
      case "-" => operation(x, y, z, (x, y) => {
        x - y
      })
      case "*" => operation(x, y, z, (x, y) => {
        x * y
      })
      case "min" => operation(x, y, z,(x, y) => {
        x min y
      })
      case "max" => operation(x, y, z, (x, y) => {
        x max y
      })
      case _ => println(f"Operation $operator is not valid");
    }
  }


  def performWithWildCard(x: Int = 1, y: Int = 1, z:Int = 0, operator: String): Any = {
    operator match {
      case "+" => operation(x, y, z, _ + _)
      case "-" => operation(x, y, z, _ - _)
      case "*" => operation(x, y, z, _ * _)
      case "min" => operation(x, y, z, _ min _)
      case "max" => operation(x, y, z, _ max _)
      case _ => println(f"Operation $operator is not valid");
    }
  }


  // Higher Order Functions


  //  def get()= {
  //    (a:Int, b:Int) =>{
  //
  //    }
  //  }
}

object PartaillyAppliedFunction {

  {
    var sum = (a: Int, b: Int, c: Int) => {
      a + b + c
    }

    var _sum = sum(1, 2, _: Int)

    _sum(3);
    _sum(4);
    _sum(6);
  }

  // Real Life example

  // lets say we need to log start time of some job and log some exception
  {
    import java.util.Date;

    def logger(date:Date, message:String): Unit ={
      println(s"date is $date and message is $message");
    }

    var date:Date = new Date;

    var log = logger(date, _:String)

    log("method_started");
    log("method_end");
  }


}

// A closure is a function which uses one or more variable declared outside the function.
object Closures{

  {
    var number = 10;
    // number is declared out of anonymous function but still we are using it in anonymous function
    val sum = (x:Int)=>{
      x+ number
    }

    // what if we reinitalize number

    val sum2 = (x:Int) => {
      number+=x;
    }

    println(sum2(20));
    // now value of number is also changed
    println(f"number is $number%d")

    println(sum2(30));

    println(f"number is $number%d")
  }

  var number = 10;
  // number is declared out of anonymous function but still we are using it in anonymous function
  val sum = (x:Int)=>{
    x+ number
  }

  // what if we reinitalize number
  // value f number can changed on basis of its scope
  // return type of anonymous function is Int i.e (Int){number += x}
  val sum2 = (x:Int) => { number+=x}



  def impureClosure(x:Int)  {
    var  number:Int = 10;
    println(s"number is $number")
    sum2(x)
  }

  def pureClosure(x:Int) {
    val number = 10;
    println(s"number is $number")
    sum2(x)
  }
}


object Currying {

  // this is a method which take two arguments
  def notCurriedName(firstName:String, lastName:String):String = {
    return f"$firstName%s $lastName%s"
  }


  def curriedName(firstName:String) =
    (lastName:String) =>{ println("This is curried function");
      f"$firstName%s $lastName%s"
    }


  // Scala provides its own syntax to define a currade function
  // we dont need to use closure
  def curriedFunc(x:Int)(y:Int): Int ={
    x + y
  }


}

object Arrays {
  {

    val myArray1:Array[Int] = new Array[Int](3);

    // or
    val myArray2:Array[Int] = new Array[Int](3);

    // or

    val myArray3 = Array(1,2,3,4,5);

    myArray1(0) = 1;
    myArray1(1) = 2;
    myArray1(2) = 3;

    for(a <- myArray1){ println(a); }
    for(a <- 0.to( myArray1.length - 1 )){ println(myArray1(a))}

    var count:Int = 0;
    for(a <- 0.to( myArray2.length - 1 ) ){ myArray2(a) = count; count+=1 }

    import Array._;
    println("Concatnation of both array");
    println(concat(myArray1, myArray2));

    for(a<- concat(myArray1, myArray2)){ println(a) }
  }
}

// Fundamental Diff between List and Array is that
// List is immutable but array is not
// List represent a Linked List but array is just flat
object Lists {


  {

    var list1 = List(1,2,3,4)
    var list2:List[String] = List("Suraj","Yadav")

    for(a <- list1){ println(a); }

    // to add something in beggining of linked list use cons i.e ::

    println( 0 :: list1); // it returns a new List as list is immutable

    // Whenever we use cons with Nil it returns a List
    var r  = 0::Nil;
    var r1 = 0::1::Nil;

    // Both r and r1 becomes a list.
    for(a <- r){ println(a); }
    for(a <- r1){ println(a); }

    println(r.head);
    // tails is what is left after removing first element, it returns a nee list after removing first element
    println(r.tail);
    println((0::Nil).isEmpty);

    println("this is for each");

    // whatever we are passing inside foreach thats going to be appied with every variable
    list1.foreach(println);
    list1.foreach(println _);

    var sum:Int = 0;

    list1.foreach(sum+=_);
    println(s"Sum is $sum");


  }
}

object Sets {
  {
    val mySet:Set[Int] = Set(1,2,3);
    val mySet2:Set[Int] = Set(3,4,5);
    println(mySet)
    // appends o with mySet elements and returns new set
    println(mySet + 0)

    // there is nothing like index in set

    println(mySet(1)) // it looks whether 1 is present in set or not
    // head, tail and isempty can be used with set as well.

    println(mySet ++ mySet2) // concatnated two sets

    println(mySet & mySet2) // common elements b/w two sets
    println(mySet.min)
    println(mySet.max)


    for(a <- mySet){ println(a); }
    for(a <- mySet2){ println(a); }

    mySet.foreach(println);
    mySet2.foreach(println _);
  }
}

object Maps {
  {
    // Map[key, value]
    var myMap: Map[Int, String] = Map(1-> "suraj", 2 -> "yadav" );

    var myMap2: Map[Int, List[Int]] = Map(1-> List(1,2), 2 -> List(2,3,4) )

    println(myMap(1));
    println(myMap(2));


    // prints the list at keys 1 and 2
    myMap(1).foreach(println);
    myMap2(2).foreach(println);


    println(myMap.keys);
    println(myMap.values);



    myMap.keys.foreach((key)=>{
      println("key" +key)
      println("value "+ myMap(key))
    })

    myMap.keys.foreach{ key=>{
      println("key" +key)
      println("value "+ myMap(key))
    }}

    // before fetching look whehter that key exist or not
    println(myMap.contains(1));
    println(myMap ++ myMap2);


  }
}

object Tuples{
  // Tuple can store elements of diff datatype
  // It is immutable
  // It can store only 22 elements
  // Tuple is not a keyword so we need to specify the size if we decalre tuple using Tuple class
  {
    val myTuple = (1, 2, 3, true, false, (1, 2))

    val myTuple2 = new Tuple2(1, 2); // Tuple2 means it can store 2 elements
  val myTuple3 = new Tuple3(1, 2, 3); // Tuple3 means it can store 3 elements

    println(myTuple._1);
    println(myTuple._2);
    println(myTuple._3);
    println(myTuple._4);

    // there is method avaialbel till _6 not after that

    myTuple.productIterator.foreach((value) => {
      println(value)
    });

    // It generates a tuple
    println(1 -> 2)

    println(myTuple._6._1)

  }
}

object Options{
  {
    val list = List(1,2,3);
    println(list.find(_ > 1));
    // find returns either Some or None
    println(list.find(_ > 1).get)
    val map = Map(1 -> "suraj", 2 -> "yadav");

    // get returns either some or none
    println(map.get(1))

    // how to get value from Some
    println(map.get(1).get)

    // What if value is not present

    println(map.get(1).getOrElse("Value Not Found"))

    // we can pass any value inside getOrElse


    val opt1:Option[Int] = Some(1);
    val opt2:Option[Int] = None;

    println(opt1.get);
    println(opt2.getOrElse("Its None"));

    println(opt1.isEmpty);
    println(opt2.isEmpty);
  }
}

object MapAndFilter {
  {
    val lst = List(1,2,3,4);

    var map = Map(1->"suraj", 2->"yadav")
    // It retuns new list after applying operation on each element

    // Three ways to use map, there can be others as well
    println(lst.map(_ * 2))

    println(lst.map( x => x *2 ))
    println(lst.map((x)=>{ x * 2}))
    println(lst.map((x) =>  "hii "* x)); // "hii" "hiihii" "hiihiihii" just like ruby

    println(map.map((x) => println(x)));


    // What if we want changes in values not key
    // It will return newe Map with each key having mapped values

    map.mapValues((x) => "hi" +x);

    //println(List(List(1,2),34).flatten)

    // flatMap
    // It maps each value of list and then in end flats the list of lists.

    println(lst.flatMap(x => List(x,x+1)))

    // Filter
    println(lst.filter(x => x%2 == 0))
    println(lst.filter(x => x%2 != 0))
  }
}

object ReduceFoldOrScan {
  {
    // reduceLeft, reduceRight, foldLeft, foldRight,scanLeft, scanRight

    val lst =  List(1,2,3);
    val lst1 = List("A","B","C")

    // it will perform binary operation on each pair
    // initially it takes 1 and 2 and then result goes into frist parameter on third iteration and so on

    //*****************************************************
    println(lst.reduceLeft(_+_));
    println(lst.reduceLeft((x, y)=>{ println(s"$x +$y"); x+y})) // these two methods performs operation from left to right
    //*****************************************************// these two methods do same thing

    //*****************************************************
    println(lst.reduceRight(_+_));
    println(lst.reduceRight((x, y)=>{ println(s"$x +$y"); x+y})) // these two methods performs operation from left to right
    //*****************************************************// these two methods do same thing

    //*****************************************************
    println(lst.reduceRight(_-_));
    println(lst.reduceRight((x, y)=>{ println(s"$x +$y"); x-y})) // these two methods performs operation from left to right
    //*****************************************************// these two methods do same thing

    //*****************************************************
    println(lst.reduceLeft(_-_));
    println(lst.reduceLeft((x, y)=>{ println(s"$x +$y"); x-y})) // these two methods performs operation from left to right
    //*****************************************************// these two methods do same thing


    // Basic Difference between reduce and fold is that , fold can tak initial argument.

    //*****************************************************
    println(lst.foldLeft(0)(_+_));
    println(lst.foldLeft(0)((x, y)=>{ println(s"$x +$y"); x+y})) // these two methods performs operation from left to right
    //*****************************************************// these two methods do same thing

    //*****************************************************
    println(lst.foldRight(0)(_+_));
    println(lst.foldRight(0)((x, y)=>{ println(s"$x +$y"); x+y})) // these two methods performs operation from left to right
    //*****************************************************// these two methods do same thing

    //*****************************************************
    println(lst.foldRight(0)(_-_));
    println(lst.foldRight(0)((x, y)=>{ println(s"$x +$y"); x-y})) // these two methods performs operation from left to right
    //*****************************************************// these two methods do same thing



    // scan method returns a list which includes map of each value
    //*****************************************************
    println(lst.scanRight(0)(_+_)); // it
    println(lst.scanRight(0)((x, y)=>{ println(s"$x +$y"); x+y})) // these two methods performs operation from left to right
    //*****************************************************// these two methods do same thing


  }
}

class User(var name:String, val age:Int); // class with a primary constructor
class User1(name:String, age:Int); // since we have not declared it with var and val, we won't be able to access

class User2(private var name:String, var age:Int);

class AuxiliaryCons(var name:String, var age:Int){
  // one auxiliary cons can call another but in end primary cons should be called
  def this(){
    this("suraj",1)
  }

  def this(age:Int){
    this("suraj",age);
  }

  def this(name:String){
    this(name, 2)
  }
  // We can define multiple constructors provided each cons has diff signature
}
