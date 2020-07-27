

object AbstractMore {
	def main(args:Array[String]){
		var muchtange:ICar = new ICar("Sally", "Ford", "mushtange", 2000)
		println( muchtange )
	}
}

//////////////////
abstract class Vehicle(val name:String, val age:Int){
	override def toString:String = s"$name , $age yeard old"
}

class  ICar(override val name:String, // if we don't use override here then it will cause ambiguity as name is present in Vehicle as well so with override we tell that we are using name and age from abstract class
	       val make: String,
	       val model: String,
	       override val age: Int
           ) extends Vehicle(name, age) {
            // while extending any class we must provide the constructer fields 
            // Vehicle expects two constructor fileds if we don't provide same
            // then compiler will throw error

    // calling toString of base class with help of super
    override def toString:String = {
    	s" make of $make and model is $model,  ${super.toString}"
    }
}
//////////////



abstract class SuperClass {
	def blip:String
	val blop:String
	def op(x: Int, y: Int):Int 
}

class SubClass extends SuperClass{
	override def blip:String = "blip"
	override val blop = "blop"

	override def op(x: Int, y: Int):Int ={
		x + y
	}

}


// try running this it will throw error as,  == is a final method and can be overriden 

// class OverRideEquals{

// 	override def ==(ob:Any):Boolean = {
// 		println("overriding")
// 		false
// 	}

// }

