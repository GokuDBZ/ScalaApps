



object LazyValDef{

  def main(args:Array[String]): Unit ={



    // lazy val def
    var ob:Demos = new Demos();

    println( ob.a  )

    println(  ob.b  )

    println( ob.b )

    println( ob.c )

    println( ob.c )
   //

   // more on abtracts

   println(  (new Orange("orange")).name  )

  }
}


class Demos {

  // it will be evaluated once when object will be created and get value 10
  val a: Int = {
    println("Evaluation a")
    10 // return 10
  }

  // this is a method and will be evaluated when ever called from object
  def b: Int = {
    println("Evaluation b")
    20 // return 10
  }


  // this is lazy val and will be evalauted only once when called from object and then gets value 30
  // no matter how many times u call it after first evaluation it won't print and will just return 30
  lazy val c: Int = {
    println("Evaluation c")
    30 // return 30
  }
}


abstract class Food {
  def name:String
}


// since Fruit class is not overriding getName method then we need to declare it as abstract
abstract class Fruit extends Food

            // val name in parametric field is like giving definition of def name:String in
class Orange(val name:String) extends Fruit

