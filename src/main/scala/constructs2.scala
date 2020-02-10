
import scala.collection._

object Constructs {


  /* Topics covered in this program (code starts from main method)
    1 -  Val Hiding
    2 -  Ternary
    3- Loops
    4- Statements
    5 -  Data Structures (Seq (Array, List, Vector) and  Set)
   */

/* Purely Functinal Code avoids side effects and pays attention to side values.
   When any method is not returning any value then it means, it has any "side-effects".
   that method might be mutating any variable or might be printing any value.
   Eg -  if a method has return type Unit i.e def add(val i:Int, val j:Int):Unit  , it means this method has side effects.
   these type of functions are also called procedures.
   In scala, we should try to write program that are side-effects free.

   If a function has side effects then it must do something useful rather than returning any value
 */


 /*
   Expressions return values but statement does not
   eq -  2*3 is an expression but printf("hello") is not
  */

  /*
    Exception Handling

    try{

    }
    catch{
      case ae:StandardException => e
    }
    finally{

    }
    -  Scala opts for expression over statements in exception handling.
    -  If any exception occurs, a value may be returned to recover
    -  We can also re-throw an captured exception(or throw another).
       eq - case ae:ArithmeticException => new RunTimeException("Cannot divide by zero")

    - finally block does not return any value so it does side effect stuff
   */

    /*
       - Scala has only one true loop construct i.e while(and the associated do..while)
       - while is a statement with no return type
       -  while is non-functional and is replaced by foreach or map functions over collections.
       - while must have a side-effect to do something useful
       - In Scala there is no void.
       - Unit is provided as a retunr type for statements, it has one instance: ()
       -  while(predicate) predicate is condition
     */



  /*
    There are two ways we can run a scala file.
       - Make a file named first.sc with some loop code into it.
      -  Open the terminal into file scope.
      - first way - 1  sbt console
                    2 :load first.sc

      - second way - scala first.sc

    If we just write code straight away in scala file without main method then on compiling scala will do it for your self in back ground
    It will put your code inside main method.

   */

/*
     In Scala type can be inferred which means that scala can interpret the type by itself.

     Scala can infer the return type of a method but cannot infer its parameter so we have to specify that explicitly.

     Eq- `def sum(a, b)=  x+y` will throw error as it won't be able to infer the typ eof parameter
        but `def sum(a:Int, b:Int)=  x+y` will work as parameter type is present and return type will be inferred by scala itself.

        '=' is important in method definition

 */

  /*
      - In scala , every method and variable has a type, there is no void.
      - The rough equivalent of which is UNIT, of which there is only one instance: () also called empty tupple.
      - Any method with return type 'Unit' must have side-effect in order to do something useful.

   */


  /*
     - In scala , if , try.. catch, for and other commom constructs are expressions
     - while and do while loop are few constructs whose return type is Unit.
   */

  /*
    - What if our method want to return tuple which includes two integrer element
           def operations(i:Int, j:Int): (Int, Int) = {
              (1,2)
           }
   */

  /*    * Tuples - var  = Tuple(1,2, "suraj")
          Tuple can have atmost 22 elements of same or diff data type
          var (a, b) = (1,2)

        * Array   var arr:Array[Int] = Array(1,2,3)
             when we do Array(1,2,3) then implicitly it does Array.apply(1,2,3)

          * Array is a reference of a class

          arr.apply(0) -  It will return first element in the array.


           Rewriting
             Array has methods apply and update which ar being used while fetching and update the value

             We have an array var arr = Array("suraj", "yadav")

             To fetch first element we do arr(0)
             On arr(0) , it implicilty calls apply method i.e arr.apply(0)

             To update first element we do arr(0) = "prem"
             On arr(0) , it implicilty calls apply method i.e arr.update(0, "prem")


   */


  /*
      * Array is mutable but Lists are immutable
      * var arr = Array(1,2,3)
      * or
      * var arr = Array.apply(1,2,3)
      *
      * It has a type parameter as well on it
      * var arr  = Array.apply[Int](1,2,3)
      *
   */


  /*
      * Array, List and Vector are sub type (child) of Seq.
      * List and Vector are abstract class hence cannot be instantiated
      * Seq is an ordered collection of homogeneous elements which can be repeated
   */

  /*
      Set is unordered collection of homogeneous elements which cannot be repeated
      eq -  Set(1,2,3,3,4,4,55) becomes Set(1,2,3,4,5) after initialization.
   */

  /*
     Maps

     - Maps are like collection of associative tuples.
     - Maps has both mutable and immutable implementations.
     - Map('a'->1, 'b'->2)
     -

   */


def main(args: Array[String]) {

// ******************************************************************
// val hiding

// val cannot be re-initialized but similar can be acheived with "val hiding"
  val x = 10;
  println(x)

  // here we ae creating a new scope
  {
    val x = 20;
    println(x);
  }

  println(x); // It will print 10 not 20
// *******************************************************************



// ***************************************************************

  // Ternary (var a  =  (3 > 2) ? 3 : 2)
  // Ternary cannnot be achieved in scala but similar can be achieved using scala

  var any = if (3 > 2) 3 else 2
  println(any)
// ***************************************************************

  // Exception Handling
 // **************************************************************

    // try catch block can also return value
    var value = try{
      10/0
    }
    catch{
      case ae:ArithmeticException => 0
    }
    finally{
      println("we are in finally");
      42 // even if we retunr any value from finally that won't happen
      // finally can be used for side effects.
    }
    println(value)
  // **************************************************************


  //While loop
  // **********************************************************

  // while checks for the predicate first before running the body of the loop
  var i:Int = 0
   while(i < 10){
     println(s"value of y is ${i}")
     i+=1
   }
  //**********************************************************



  //do while loop
  // **********************************************************

          /* do while runs the  body of the loop and then checks for predicate
          in this way do while will exceute loops's body atleast once
           */
    var z:Int = 0

     do {
      println(s"value of y is ${z}")
      z+=1
      } while(z < 10)
   // String interpolation  s("hello ${}")
  //**********************************************************


  var a:Int  = 34
  println(a)

  try{
    // In scala if u assign some value to a variable that is diff from its type then it will throw error
    //a = "suraj"
  }
  catch{
    case e:Exception => {
      println("exception is handled")
      println(e)
    }
  }

  // while and do while are among constructs wose return type is Unit

  var doIt:Boolean = true

  var b:Unit = while(doIt){
    printf("we are in loop")
    doIt = false
  }

  printf(b.toString())

  // variables also have their return type and in this case y will have return type Unit
  var m = 10;
  val n = m = 5;

  /*
    We should not end our method block with val . If we do so then method will return Unit

   */
  println(MyMethods.sum(1))

  // method sumAndDiff returns a tuple which includes summition and addition
  val (sum, diff) =  MyMethods.sumAndDiff(4,5);
  printf(s"sum is ${sum}")


  // String
  var str:String = "Suraj"
  println(s"char at 0 ${str.charAt(0)}")


  // Infix

  1+2
  // 1 is an Integer object which has a method +, this practice is known as infix
  1.+(2)

  // but infix does not work with println
  //println "suraj" // it will throw error
  // It should be like
  println("hello")

  // arrays
  Collections.arrays

  // Lists
  Collections.lists

  // Vector
  Collections.vectors

  // Using array, list and vector
  Collections.mixedCollections


  // Set
  Collections.sets()

  // Maps
  Collections.maps()

  // How to read a file in scala

  ReadFile.readFiles()


}


}


object MyMethods {
  def sum(i:Int) ={
    val a = i+i
  }

  // return type is a tuple ( ) which includes two integer
  def sumAndDiff(i:Int, j:Int):(Int, Int) = {
    (i+j, i-j)
  }

  def squareRootOfAll(input:Seq[Int]):Seq[Double]={
    input.map((x) => math.sqrt(x))
  }

  def squareRootOfAllSecondWay(input:Seq[Int]):Seq[Double]={
    input.map(math.sqrt(_))
  }

}


object Collections {

  def arrays: Unit ={
    //Array
    // - Arrays are mutable

    var arr = Array("Suraj", "Yadav")
    // it implicitly works as Array.apply("Suraj", "Yadav")

    arr(0)        //  this is a way to fetch first element
    // or
    arr.apply(0)  // this is how it works implicitly

    // Now if we want to update the value at any index in array

    arr(0)  = "Prem"
    // arr(0) = "Prem"  , here impliclitly arr.update(0,"Prem") is called

    // Array Continued

    var arr1 = Array(1,2,3)
    var arr2 = Array.apply(1,2,3)
    var arr3 = Array.apply[Int](1,2,3)
    // logically arr1, arr2, arr3 are same but arr3 shows how internally it works
  }

  def lists: Unit ={
    // Diff syntax of declaring List

    var lists = Nil //  it assigns an empty list

    Nil.::(1).::(2) // it will create a list i.e List(2,1)

    1::2::3::Nil // It creates a list i.e List(1,2,3)

    // How to join two list
    var l1 = List(1,2,3)
    var l2 = 4::5::6::Nil

    println(l1 ::: l2)
    println( l1 :: l2) // it will not concatenate but it will create a new List
    // List((1,2,3), 4,5,6)
    println(Nil.::(1).::(2) ::: 3::4::5::Nil) // this is also joining two lists

    // :: is right associative, i.e it applies the parameter on the left side to the item on the right

  }

  def vectors():Unit={
    /*
     - List, Array and Vector are sub type of Sequence i.e 'Seq' or we can say Seq is parent of List , Arrrya and Vector
     - List and  Vector are abstract class they cannot be instantiated. like new List(1,2,3) . It wont work
      - But array can be instantiated new Array[Int](1)
  * */
    var vec  = Vector(1,2,3)
  }

  def mixedCollections: Unit ={
    // parent can hold reference of its child
    var list1:Seq[Int] = List(1,2,3)
    var array1:Seq[Int] = Array(1,2,3)
    var vector1:Vector[Int] = Vector(1,2,3)

    var output1 = MyMethods.squareRootOfAll(List(1,2,3))
    var output2 = MyMethods.squareRootOfAll(Array(1,2,3))
    var output3 = MyMethods.squareRootOfAll(Vector(1,2,3))

    println(output1)
    println(output2)
    println(output3)

    println(MyMethods.squareRootOfAllSecondWay(List(1,2,3)))
    println(MyMethods.squareRootOfAllSecondWay(Array(1,2,3)))
    println(MyMethods.squareRootOfAllSecondWay(Vector(1,2,3)))
  }


  // Array is mutable but List and Vector are not
  // Array can be grown but List and Vector can't

  // But Set can be mutable and immutable both
  // It is not required(not recommended ) to use var and a mutable collection together.

  def sets():Unit={


    var s1 = immutable.Set(1,2,3, 3)
    var s2 = mutable.Set(1,2,3)

    println(s1)
    println(s2)

    s1+=4
    s2+=4
    println(s1)
    println(s2)

  }

  def maps():Unit={
    val m1 = Map('a'->2, 'b'->3)

    var m2 = immutable.Map('c'->4, 'd'-> 5)

    println(m1++m2) // since m1 is immutable m1++m2 returns new map
    println(m2)

    // ways to update Map
    m2+= 'e'-> 6
    m2+= ('f'-> 7)

    println(m2)

    // -> is not arrow operator in scala but it is a extension method

    var ob = 'd' -> 5
    /*
       It works like 'd'.->(5) which returns a tuple which include both values
       If we go bit more deeper it works like ArrowAssoc('d').->(5)

       No such method -> exists on any type  but an implicit called ArrowAssoc provides it just in time.
     */

    var ob1 = ArrowAssoc('a')->(1)

    // iterating a map

    // (key, value) unpacks the tuple2 from the sequence in the map
    // tuple created in maps are of type Tuple2
    for((key, value)<- m2){
      println(s"keys is ${key} and value is ${value}")
    }

   // Map does not guarantee order like Set


  }

}

object ReadFile {
  def readFiles():Unit={
    import scala.io.Source
    // Source is not recommended to be used on production, this is just for demo and experiment.
    val file = Source.fromFile("./src/main/source_file.txt")

    // getLines return the iterator over the lines in the file
    for(lines <- file.getLines()){
      println(lines)
    }
  }
}



