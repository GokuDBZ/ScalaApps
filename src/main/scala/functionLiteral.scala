object FunctionLiteral {

  def main(args:Array[String]): Unit ={
    // this is a functional literal and one more way to define methods
    // when such methods are created it returns lambda object
    val fn1:(Int,Int)  => Int = (i, j) => i+j

    println(  fn1(1,2)   )
      //or                       //both method calls will do same work
    println(  fn1.apply(1,2))

    // above function is rewritten by scala in this way
    val fn2 = new Function2[Int,Int,Int]{

      override def apply(a:Int, b:Int):Int = {
        a + b
      }
    }

    println(  fn2(1,2)   )
       //or
    println(  fn2(1,2)   )


    // we can also create lambda function in this way

    var fn3 = (a:Int,b:Int) => { a+b}

    println(  fn3(1,2)   )
    //or
    println(  fn3(1,2)   )



    HigherOrderFunctions


    // passing function
    println("higher order function")
    var result = HigherOrderFunctions.higherOrderfunc(List(1,2,3,4,5,6,7,8,9,10), (x,y) => x+y)

    var result2 = HigherOrderFunctions.higherOrderFunc2(List(1,2,3,4,5,6,7,8,9,10), (x,y) => x+y)


    /*  (x,y)=> x+y  is syntactic sugar to   new Function2[Int,Int,Int] {
                                                override def apply(a: Int, b: Int): Int = {
                                                               return a + b
                                                         }

    So instead of using Function2 every time we can use the syntactic sugar i.e (x,y) => x + y

    (x, y) => x +y  is converted into new Function2[Int,Int,Int]{
                                                                    .. code is given above
                                                                }

     */

    var result3 = HigherOrderFunctions.higherOrderFunc2(List(1,2,3,4,5,6,7,8,9,10), new Function2[Int,Int,Int] {
      override def apply(a: Int, b: Int): Int = {
        return a + b
      }
     }
    )

    println(result)
    println(result2)
    println(result3)


    // We can also use placeholder syntax instead of passing whole method as parameter
    var result4 = HigherOrderFunctions.higherOrderFunc2(List(1,2,3,4,5,6,7,8,9,10), _+_) // _+_ will work as (x,y) => x + y

    var result5 = HigherOrderFunctions.higherOrderFunc2(List(1,2,3,4,5,6,7,8,9,10), _-_) // _-_ will work as (x, y) => x - y
    println(result5)



    println(  List(1,2, 3, 4, 5).map( _ * 3)         )
    println(  List(1,2, 3, 4, 5).filter( _%2 == 0)   )

    // We can also pass parameter type place holder syntax

    println(  HigherOrderFunctions.higherOrderFunc2(List(1,2,3,4,5,6,7,8,9,10), (_:Int) - (_:Int))     )
    println(  HigherOrderFunctions.higherOrderFunc2(List(1,2,3,4,5,6,7,8,9,10), (_:Int) + (_:Int))     ) //  but here we need to pass it in the parenthesis

    // It is not necessary to define method while pasisng it as param

    val adder = (_: Int) + (_:Int) // it is equivalent to (x, y) => x + y
    println(  HigherOrderFunctions.higherOrderFunc2(List(1,2,3,4,5,6,7,8,9,10), adder))



    // Partially Applied Functions

    PartiallyAppliedFunctions

    // Closures
    ClosureFunctions


    // Partial Function
    PartialFunction

    // Var Args
    // What if we want to pass multiple values of same type into a single parameter method
    VarArgs


  }


  // If a class overrides apply method then apply will be invoked on every method call of that class



  // If a lambda function has mutliple parameterd then we can send the parameters in form of tuples
  // fn1.curried
  // fn2.tupled

  // Search for it on net

}


object HigherOrderFunctions{

  // Higher order functions are the functions which can take function as argument and can return a function as well.

  {

    // map, partition,  filter, span are higher order functions

    // If a method that does not take or return another function then that is called first order function.

    var ob = 1 to 10

    var obList  = ob.toList


    // span will return a list which contains two list one which is true and another which is false
    println(     obList.span((x)=> x%2==0) )


    // map will return a new List after performing specified operation in the lambda
    println(     obList.map((x)=> x*1) )

    // partition will split the list on the basis of specified condition in lambda
    println(     obList.partition((x)=> x%2!=0) )

    // filter will filter out the list elements which does not match the specified condition in lambda
    println(     obList.span((x)=> x%3==0) )



  }


  def higherOrderfunc(list:List[Int], compare: (Int, Int) => Int): List[Int] = {
    for{
      l <- list.sliding(2)
    }
      yield {
        compare(l(0), l(1))
      }
  }.toList

  def higherOrderFunc2(list:List[Int], compare: Function2[Int,Int,Int]): List[Int] = {
    for{
      l <- list.sliding(2)
    }
      yield {
        compare(l(0), l(1))
      }
  }.toList

}


object PartiallyAppliedFunctions {
  {
    val sum = (a:Int, b:Int, c:Int) => a +b +c

    val sum1 = sum(1,2,_) // or sum(1,2,(_:Int))

    val sum2 = sum(1,_,3) // or sum(1,(_:Int),3)

    println(sum1(3))
    println(sum2(3))

    /*
        Not only just 1 and 2 we can skip all the parameters initially
     */
    val allThree = sum(_,_,_) // here we are not passing any params
       //or
    // val allThree = sum _ just pass single place holder that will handlee all three params, but it should be without paranthesis
    // val allThree = sum(_) won't work

    val allThree1 = allThree(1,_,_) // here we pass only one params to allThree and return reference to allThree1

    val allThree2 = allThree1(2,_) // since allThree1 has 1 parameter with it now we need to work on two remaining params

    val allThree3 = allThree2(4) // allThree2 has now two params with it and now we need to deal with only 1 params

    println(allThree3)

  }
}


object ClosureFunctions {
  {
    val a = 10;

    // This is not a function literal as it is not accessing any variable from out side scope
    val func1:(Int)=>Int = (i)=>{ i + 10} // we specify all type first then method definition
    // or val fuc1=(i:Int)=> i+10
    println( func1(10))


    // Closure
    val func2:(Int)=>Int = (i)=>{ i + a} // This is a closure as it is using variable outside from this scope
    println(func2(10))


    // Its not necessary to always use val with closures, we can use var as well
    // but we should not exploit var by changing its value again and again

    var b = 10;
    val func3:(Int)=>Int = (i)=>{ i + b}

    // Now we chane value of b

    b = 30

    println(func3(10))

    // But it is not recommended to change value of var as it can affect further execution as well.




  }
}


// Don;t get confused partial function with partailly applied functions
// Any method which starts with case just after { then it is partial function
object PartialFunction {
  {

    // [Int, Int] means first parameter is type of input and second paramter is type of output.
    val func5: PartialFunction[Int, Int] = {
      case x: Int if x > 0 => x + x
      case x: Int if x < 0 => x * -1
    }

    println(func5(1))

    // we can also pass partial function definition as body to a another method
    // pasisng partial function as body to method is also known as upcast operation in scala
    val func6: (Int) => Int = func5

    println(func6(5))

    // partial function can also be used with higher order functions

    val result: List[Int] = (1 to 10).toList.map(func5)

    println(result)



    // Partial Function Deep Dive

    // When a partial function is defined it produces two methods


    /*

       val pf2 = PartialFunction[Int, Int]{
        case x:Int if x > 2 =>  x + x
       }

       partial functions pf2 produces two methods
       (1) isDefined (2) apply

        Inside isDefined method all the case in the partial function are put and one default case is also added in method
        by scala itself.

        (1)
        def isDefined(x:Int)=  x match {
          case x:Int if x > 0 => x + x
          case _ =>  false
        }
        (2)

        def apply(x:Int){
        }
     */

    // In partial function we can check if it is defined for particular value or not
    println("is Defined at")
    println(func5.isDefinedAt(2)) // it will return true
    println(func5.isDefinedAt(-2)) // it will return true

    /*
      try{
        1/0
      }
      catch { // this is also a partial function
       case ae:ArithMeticException
      }
   */

  }
}

  object VarArgs {
    {

      def sayHello(names:String*): Unit ={
        for(name <- names){
          println(s"Yo $name")
        }
      }

      sayHello();

      // Var args should be last paramter

      def sayHello1(greet:String, names:String*): Unit ={
        for(name <- names){
          println(s"$greet $name")
        }
      }

      sayHello1("YO", "Suraj", "Prem")

      // How to make lists and other Data Structure to behve like var args

      var names = List("suraj","yadav")
      sayHello1("YO", names:_*)
    }


  }



