

object Specialized{
    def main(args:Array[String]){

    }

    def pair[@specialized T, @specialized U](t:T, u: U): (T, U) = (t, u)
    // methos above is going to create about 100 methods on the basis of combinataion we have provided

    // (9 Primitives + Any Ref) * (9 primitives + Any Ref)
    /**
        Int           Float           Double ...   till (9 Primitives + Any Ref)
       ***********************************************
Int    * (Int, Int)    * (Int, Float)    *  (Int, Double)
       * ************************************************              *                 *
Float  * (Float, Int)  * (Float, Float)  * (Float, Double)
       ****************************************************               *                 *
Double * (Double, Int) *  (Double, FLoat)* (Double, Double)
        *****************************************************
...
till (9 Primitives + Any Ref)    about 100 combinations this way
      
      So specialized creates a matrix on no of paramters specified with specialized

      We need to be careful with this while using it

      def pair[Int, Int](t:Int, u:Int)

      def pair[Int, Float](t:Int, u:Float)

      def pair(Int, Double)(t:int, d:Double)

      ....

      methods upto 100 combinations


    */   
}