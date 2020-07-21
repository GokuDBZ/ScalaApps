

object Opt {
    def main(args:Array[String]){

        // Options can be used on place on null to prevent null pointer exception
        // null is safer than None as null fails on run time but you will get to know about None at compile time itself.

        val s1:Option[String] = Some("suraj")
        // Some is child of Option thats why Option can hold reference of  Some
        // val s1:Some[String] = Some("suraj") // it will work same way as above

        val s2:Option[String] = None

        println( s1.map(_.length) ) // it will return Some(5)
        println( s2.map(_.length) ) // it will return None
        

        // s2 = null
        // println( s2.map(_.length) ) it will break on run time which if not good
        // thats why we should use None instead of Null

        // if we fetch value from Map using get,  get returns value in Some object

        val map:Map[Int, String] = Map(1 -> "suraj", 2 -> "yadav")

        map.get(1) // it will return "suraj" as Some object Some("suraj")
        map.get(2) // it will return "yadav" as Some object Some("yadav")
        map.get(3) // it will return None

        map(1) // it will directly return value i.e "suraj"
        map(2) // it will directly return value i.e "yadav"
        //map(3) // it will throw exception


        val a:Option[A] = Some(new A(Some(1)));
        println(a);

        // SOme will work with pattern match as well

        val word1 = map.get(1)
        val word2 = map.get(4)

        word1 match {
            case Some(word) => word // inside we can expect 
            case None => println("not found")
        }

        println(  word2.getOrElse("unknown")) // if value will be None then unknown will be returned



        // Using headOptions

        println(List(1,2,3).head ) // it will print head value i.e 1

        println("suraj".head) // it will print head value i.e 's'

        // but what if my list or string is empty
         // "".head => will raise error as string is empty

         // List().head => will raise error as list is empty

         // to prevent this situation we can use headOption
         // it will return result as Option object and even if object is empty it will reurn None

         println("".headOption) // will return None

         println(List(1).headOption) // will return None

         println(List(1,2,3).headOption ) // will return Some(1)
         println("suraj".headOption) // Will print Some(s)



        // Working with options

        def fourthLetter(i:Int): Any = for {
            word <- map.get(i)
            char <- word.drop(4).headOption // it will drop first 4 characters from string
        } yield char


        // in seq we will pass the indexes of map
        def fourthLetters(seq:Seq[Int]):Seq[Option[Char]] =  for{
            key  <- seq       // key <- List
            word <- map.get(key) // on each iteration we will fetch key
            char <- word.drop(4).headOption  // and then fetch the char we need
        } yield Option(char)  // here we will put char in Option object


        def fourthLetters2(seq:Seq[Int]):Seq[Char] =  for{
            key  <- seq       // key <- List
            word <- map.get(key) // on each iteration we will fetch key
            char <- word.drop(4).headOption  // and then fetch the char we need
        } yield char  // here we will put char in Option object



        println( fourthLetter(1) ) // 1-> "suraj" in map
        println( fourthLetters( List(1,2) ) ) 
        println( fourthLetters2( List(1,2) ))



    }



      
}

class A(i: Option[Int])
