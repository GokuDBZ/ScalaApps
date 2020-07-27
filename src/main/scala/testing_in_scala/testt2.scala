

package testing_in_scala

object Test2 {
    def main(args: Array[String]){

        /*

           Since assert and assume can be disabled so we can use require and requireState


           
        */
        try{
            require(2 > 3, "error")
            // if predicate satisfies then it returns nothing and execution will continue
        }
        catch{
            case error: java.lang.IllegalArgumentException => println("illegal argument exception")
        }


        // import org.scalactic.Requirements._
        // val x = 2
        // requireState(x < 0, "x must be negative")



        
    }
}