
object Trait {
    def main(args:Array[String]){


        /* Trait is like interfaces with no state and behaviour
      both methods don't have body
       */

        // new Car it will throw error

        // new Car1 it will throw error as trait behaves like abstract class

        val ob = new Car2() {
           // we are providing body here
        }

        val ob1 = new Car2(){
            val model:Int = 2000
        }

        //  it will work, as behind the screen scala creates a anonymous class extending trait Car2

        // traits don't accept constructor parameters
        // we can define abstract val in trait


    /*
       Only a trait can go after the with keyword not class
    */



      val ob2 = new ActualCar("blue", "mushtang")
      println(ob2.name)
      println(ob2.color)
    }

    // Trait is like interfaces with no state and behaviour
     // both methods don't have body

    trait Car {
        def name:String
        def color:String
    }


    // traits can have defined methods as well but in this case it behaves as a abstract class
    trait Car1 {
        def name:String
        def color:String = s"$name"
    }

    // traits can have defined methods as well but in this case it behaves as a abstract class

    trait Car2 {
        def name:String = "suraj"
        def color:String = s" $name"
    }

     trait Car4 {
        val model:Int 
        def name:String = "suraj"
        def color:String = s" $name"
    }

    trait Car3 {
        val color:String
        def description:String = s" $color"
    }
                  // overriding color as it belongs to trait

    class ActualCar(val color:String, val name:String) extends Car3   // since Car3 has 1 defined method that will behave as 
    //  this class definition is re written as class AcutalCar extends AnyRef with trait
    // only trait can go afterwards with `with` 
}