

object Main{
    def main(args:Array[String]){
        val name:String = "suraj"

        val anyName:Any = name // since Any is a base class of String then Any can hold the reference of String
        println(anyName)
        
        val anyRefName:AnyRef = name // // since AnyRef is a base class of String then AnyRef can hold the reference of String

        println(anyName)

        // val anyVal:AnyVal = name  // it will throw error as AnyVal works with primitive data types.



        val num:Int = 10

        val anyNum:Any = num
        println(anyNum)

        val anyValNum:AnyVal = num

        println(anyValNum)

        // val anyRefNum:AnyRef = num It will give compile error

    }
}