object CompanionObjects {
  def main(args:Array[String]): Unit ={
     var r1 = Rational1(1,2)
    var r2 = Rational1(3)
    println(r1.add(r2))

    // if we try to do
    // new Rational(1,2) it will throw error as primary cons is private
  }
}


// We have made primary constructor as private now it cannot be initialized as `new Rational`. So we need companion object
// to initialize its instances. Companion objects can access the private functions of class

class Rational1 private(val a:Int, val b:Int){
  // every class has a toString method but here we will override it

  // require method is like pre condition in primary constructor
  require(b!=0,"Cannot divide by zero")

  override def toString():String = {
    s"Rational($a/$b)"
  }

  // returning bigger rational number
  def min(other: Rational1):Rational1={
    if((this.a.toDouble/this.b) < (other.a.toDouble/other.b)) this else other
  }

  def add(other: Rational1):Rational1={
    new Rational1(
      (a * other.b)+(b * other.a),
      b * other.b)
  }

  def this(i:Int){
    this(i,1)
  }

}

 // companion object for class Rational

  object Rational1{

    def apply(i:Int,j:Int):Rational1 ={
      // primary cons of Rational class is private but we can still use `new` here as we we are inside companion object
      new Rational1(1,j)
    }

    def apply(i:Int):Rational1={
      new Rational1(i,1)
    }
  }