
import java.time.LocalDate

object ClassAndAbstract {
  def main(args:Array[String]): Unit ={

    // We cannnot create instance of abstract class
    try{
      //var car = new Car("suraj", 2000) // this code will throw error
    }
    catch{
      case e:Exception => {
        println(e)
      }
    }



    try {

      var aob1 = new Car("ford", 2000) {
        def isVintage:Boolean = {

          // here we are not able to access year because
          // we are creating an anonymous class which is extending abstract class Car behind the screen
          // and private members are not avialable to the child class



          // LocalDate.now().getYear - year > 20   try uncommenting this line

          // to fix this issue we need to declare parameteres as val in abstract class so that it can become public members

          false // comment this code while uncommenting other code
        }


      }
    }
    catch{
      case e:Exception => {
        println(e)
      }
    }


    var myCar = new MyCar("ford", 2000) {
      def isVintage:Boolean = {

       // here we are able to access year as it is declared as val in constructor
        LocalDate.now().getYear - year > 20
      }


    }

    }



}



abstract class Car(name:String, year:Int){
  // we can leave method without definition in abstract class
  // as class inheriting it will provide definition to it
  def isVintage:Boolean
}


abstract class MyCar(val name:String, val year:Int){
  // we can leave method without definition in abstract class
  // as class inheriting it will provide definition to it
  def isVintage:Boolean
}