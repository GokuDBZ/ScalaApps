

class Strict {
  val e = {
    println("strict")
  }
}

class Lazy{
  lazy val e = {
    println("lazy")
  }
}



object LazyEval{

  def method1(num:Int): Unit ={
    println("method 1")
    println(num);
  }


  // second way to achive lazy evaluation
  def method2(num: => Int): Unit ={
    println("method 2")
    println(num);
  }

  def main(args:Array[String]){
    var ob =  new Strict;
    var ob1 = new Lazy;
    ob1.e;

    var sum = (x:Int,y:Int)=>{ println("SUM"); x+y}
    // until here only strict will be printed

    method1(sum(1,2))
    method2(sum(1,2))
  }
}