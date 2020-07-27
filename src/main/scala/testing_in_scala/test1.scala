

package testing_in_scala

object Test1 {
    def main(args: Array[String]){

        /*
         assume
         assert
         ensuring

         all these three thows assertion error. But issue with them is they can be turned of at runtime by  a flag in JVM

         scala -Xdisable-assertions    but it disables assert , assume but not ensuring

         So assume and assert can be elided. Elided means they can be turned off in production.

         But ensuring will work
        */
        try{
            assert(1>2, "here is here")
            assume(1>2, "errror is here")
        }
        catch{
            case error: java.lang.AssertionError => println("assertion error")
        }
        

        1.ensuring(1>=1, "message")

        /*
          Ensuring will work on all expressions
        */

        def add(x:Int):Int ={
            x+x
        } ensuring (x > 1, "x should be freater than 1")

        "suraj".ensuring( _.length > 3, "my message")
    }
}