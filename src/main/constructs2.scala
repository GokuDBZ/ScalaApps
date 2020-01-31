object Constructs {


  /* Topics covered in this program (code starts from main method)
    1 -  Val Hiding
    2 -  Ternary
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
       - while is a statement which no return type
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
 */


def main(args: Array[String]): Unit ={

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
  var y:Int = 0
   while(y < 10){
     println(s"value of y is ${y}")
     y+=1
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
    a = "suraj"
  }
  catch{
    case e:Exception => {
      println("exception is handled")
      println(e)
    }
  }

}
}


