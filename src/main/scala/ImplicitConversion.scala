object ImplicitConversion {

  def main(args:Array[String]): Unit ={

    // here 5 is integer which i being added to rational object
    // Now scala will look for imlicit method to handle it
    // Scala will look for method which is declared as implicit and taking integer as parameter and Rational Object as its return type
    // When such  method is encountered then `5 ` is passed as parameter in that method.

    var result:Rational2 = 5 + Rational2(2,3)
    println("Implicit Conversion")

    println(result)


    // Implicit as parameter in methods

    implicit var defaultRate:BigDecimal = 0.01

    // here we are not passing second parameter but since second parameter is declared as implicit
    //  then complier will look for a variable which is declares as implicit and of same type i.e BigDecimal
    //   that variable is defaultRate. so compiler will pass that variable into parameter in this case
    println(  getAmountWithRate(5)    )


    // here we are passing the parameter then compiler won't look for
    println(  getAmountWithRate(5)(2.0)    )




    // what if i give a default value to a implicit parameter
     // so in this case if implicit definition is present then complier will pass that implicit variable
     //  if not present then it will pass default value


    // in this case implicit value i.e 0.01 will be passed
    // if u want default value to be passed then remove the implicit definition above i.e implicit var defaultRate:BigDecimal = 0.01
    // or just comment that out
    println(   getAmountWithRateWithDefaultValue(6)  )


  }

  def getAmountWithRate(amount:Int)(implicit rate:BigDecimal):BigDecimal ={
    return amount * rate
  }


  def getAmountWithRateWithDefaultValue(amount:Int)(implicit rate:BigDecimal  = 0.03):BigDecimal ={
    return amount * rate
  }

}


// We have made primary constructor as private now it cannot be initialized as `new Rational`. So we need companion object
// to initialize its instances. Companion objects can access the private functions of class

class Rational2 private(val a:Int, val b:Int){
  // every class has a toString method but here we will override it

  // require method is like pre condition in primary constructor
  require(b!=0,"Cannot divide by zero")

  override def toString():String = {
    s"Rational($a/$b)"
  }

  // returning bigger rational number
  def min(other: Rational2):Rational2={
    if((this.a.toDouble/this.b) < (other.a.toDouble/other.b)) this else other
  }

  def add(other: Rational2):Rational2={
    new Rational2(
      (a * other.b)+(b * other.a),
      b * other.b)
  }

  def +(other: Rational2):Rational2={
    new Rational2(
      (a * other.b)+(b * other.a),
      b * other.b)
  }

  def this(i:Int){
    this(i,1)
  }

}

// companion object for class Rational

object Rational2{

  def apply(i:Int,j:Int):Rational2 ={
    // primary cons of Rational class is private but we can still use `new` here as we we are inside companion object
    new Rational2(1,j)
  }

  implicit def apply(i:Int):Rational2={
    new Rational2(i,1)
  }
}


