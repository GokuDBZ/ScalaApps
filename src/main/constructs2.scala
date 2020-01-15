object Constructs {


  // Topics covered in this program
    //1 -  Val Hiding
    // 2 -  Ternary


  def main(args: Array[String]): Unit ={

    // ******************************************************************
    // val hiding

    // val cannot be re-initialized but similar can be acheived with "val hiding"
      val x = 10;
      println(x)

      // here we ae creating a new scope
      {
        val x = 20;
        println(x);
      }

      println(x); // It will print 10 not 20
    // *******************************************************************



    // ***************************************************************

      // Ternary (var a  =  (3 > 2) ? 3 : 2)
      // Ternary cannnot be achieved in scala but similar can be achieved using scala

      var any = if (3 > 2) 3 else 2
      println(any)
    // ***************************************************************

  }
}


