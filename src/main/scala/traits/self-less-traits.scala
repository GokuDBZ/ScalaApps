
package traits

object SelfLessTraits {
    /*
      A trait can be selfless if it has methods inside it with definition and it has a companion object extending the trait
      
      Selfless traits can be used in two ways with composition and by importing it.

      Basically with help of slefless traits we define helper methods
    */
    def main(args:Array[String]){
        // one way to using   selfless trait is with composition
        (new MyLog()).doLog

        // other way is to use importing
        ObLog.doLog
    }
    
    // trait
    trait Logger{ 
        def log(msg:String): Unit = println( msg )
    }

    // companion object
    object Logger extends Logger
    // when a trait is mixed with an object then it becomed selfless trait 


    // first way of using Selfless traits, 
    class MyLog extends Logger {
        def doLog:Unit = log("hello guys")
    }

    // Second way by imporing Logger
    object ObLog {
        import Logger._
        def doLog:Unit = log("hello guys")

    }
}