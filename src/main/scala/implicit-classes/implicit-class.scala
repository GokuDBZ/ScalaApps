


object ImplicitClass{

    def main(args:Array[String]){

       // 5.times will be evaluated as new A(5).times( println("hello") ) 
        5.times( println("hello"))
        
        
        // It will be evalauted as mentined below
        // A class is declared as implicit which expects an integer paramater
        // When compiler hits 5.times it looks for any implicit definition in its context
        // then it founds a class with implicit defintion which expects an integer value in its construcotr

        // 5.times is evaluated as A(5).times
        // A(5).times(()=> println("hello"))
    }


    // we should use implict classes only inisde package, object or class
    // else compiler will throw error
    // try putting this class out of object ImplicitClass , you will encounter an array

    // error will be `implicit` modifier cannot be used for top-level objects


    implicit class MyTimesDo(val a:Int){
        def times(func: => Unit):Unit = {
            for( i <- 1.to(a)){
                func
            }
         }        
   }

   // we cannot declare case class as implicit

    
}



//to extend any val we must specify one paramater in constructor else it will throw error


