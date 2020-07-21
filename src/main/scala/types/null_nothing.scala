

object NullNothing {
    def main(args:Array[String]){
        var name:String = "suraj"

        println(  name.isInstanceOf[String] )

        // Null


        

         val n = null // or val n:Null =nil

        // println( n.isInstanceOf[Null] )  // null cannot be used with isInstanceOf(Null)

        val xs = List(1,2,3)

        val xs1:List[AnyVal] = xs // List[AnyRef] can hold the instance of List[Int] as AnyRef is parent class of Int


        val emptyList = List.empty  // it return list of Nothing i.e List[Nothing] = List()

        println( 1 :: emptyList) // it returns list of int

        println( "suraj" :: emptyList)


        val emptyStringList:List[String] = List.empty

        println(  emptyStringList )

        try{
            fail("this is exception")
        }
        catch{
            case e:Exception => println("error occured")
        }

        def fail(msg: String):Nothing = {
            throw new Exception(msg)
        }

    }
}