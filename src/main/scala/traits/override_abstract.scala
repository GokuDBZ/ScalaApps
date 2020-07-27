package traits

object OverrideAbstract {
  def main(args:Array[String]){
     println(  (new ConvertibeCar("blue", 2000, "ford")).describe  )
  }
}

abstract class Vehicle {
    override def toString:String = "vehicle"
    def describe:String
}

trait Vintage extends Vehicle {
    val vintage:Int
    /*
      We need to mark describe method as override abstract becuase
      we are calling super in it and and our super class does not have any concrete definition of describe yet
      so with abstract override we tell scala compiler that we are still waiting for complete definition 
      of describe method or a method which is not calling super.describe inside it
    */
    abstract override def describe:String= s"vintage car $vintage  ${super.describe}"
}

trait Car extends Vehicle {
    val color:String
    // in this trait we are giving proper definition to method describe and not calling any super in it
    override def describe:String= s"car color $color"
}

class ConvertibeCar(override val color:String,
                    override val vintage:Int,
                    val name:String) extends Car with Vintage



