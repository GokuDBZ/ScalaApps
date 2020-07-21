

object NegativeTypes{
    def main(arsg:Array[String]){


        // Scala has several negative types

        // Nil represents empty list and also is the termination of every list

        val ob = List.empty
        // it returns List() which is of type List[Nothing]
        
        println(ob == Nil) // it will return true

        println( List() == Nil) // this is also true


        //Null and its single instance null represent absence of AnyRef reference

        // Nothing is a type with no instance and implies an exception being thrown

        // None is the absence of of Some in the Option type and is safer alternative to null
    }
}