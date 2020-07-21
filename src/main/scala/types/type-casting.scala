

object TypeCasting {
    def main(args:Array[String]){
        val flag = true

        // return type of this expression will be Double
          // as Double + Unit = AnyVal as they belong they both inherits AnyVal
        val r1 = if(flag) 1.0 else () //  () is unit instance and scala maitains only on e instance of unit

       //*********************
        val r2 = if(flag) 1.0
        // this expression is evaluated as if(flag) 1.0 else ()
        // so its return type will be AnyVal as Double + Unit = AnyVal , both inherits AnyVal

      //******************** 

      //*********************
        val r3 = if(flag) "hii"
        // this expression is evaluated as if(flag) "hii" else ()
        // so its return type will be Any as String + Unit = Any , both inherits Any

      //******************** 
    

      //*********************
        val r4 = if(flag) "hii" else null
        // so its return type will be String as String comes first than null in hierarchy

      //******************** 
     

     //*********************
        val r5 = if(flag) 2.0 else null
        // so its return type will be Any as Double and null both inherits Any

      //********************


      

      //*********************

      def fail(msg:String):Nothing ={
          throw new IllegalStateException
      }
      
       val r6 = if(flag) "hello" else fail("wow")
       r6
        // so its return type will be String as String falls first than Nothing in heirarchy

      //********************

      List(new Banana("banana"), new Mango("mango")) 
      // it will return list of type Product with Fruit with Serializable

      if(flag) new Banana("banana") else new Mango("mango")
      // it will return banana object wiht type Prodcut with Fruit and Serializable
    }


    abstract class Fruit // by default it extends Product with Serializable

    case class Banana(name: String) extends Fruit // case class also inherts Product with Serializable
    case class Mango(name: String) extends Fruit // case class also inherts Product with Serializable 


}