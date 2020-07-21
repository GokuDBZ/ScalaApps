

object ExtensionMethods {
    def main(args:Array[String]){
        // Extension ExtensionMethods

        math.abs(-2)   
        
        -2.abs // both are doing same stuff but abs here is extension method

        2 min 3 // min is extension method

        3 max 2 // max is extension method

        List(5,4,3,2,1).reduceLeft((x,y)=> x min y) // find min in list

        List(5,4,3,2,1).reduceLeft((x,y)=> x max y) // find max in list

        println("suraj".reverse)

        println("suraj".toSeq)

        println("suraj".slice(2,4))

    }
}