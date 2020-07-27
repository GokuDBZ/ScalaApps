
object VehicleCar {
	def main(args:Array[String]): Unit ={
		val ford = YCar("ford", Vector("1965 mustang", "1967 mustang"))

		val ferrari = YCar("Ferrari", Vector("1965 Lambo", "1967 Lambo"))

		println(ford.fullDescription)
		println(ferrari.fullDescription)

		// now we have two cars
		// now we will park both cars in our parking 

		val parking = ParkingStructure("Parking 1", Vector(ford, ferrari))

		println(parking.fullDescription)

		
	}
}



// this is abstract class of vehicle
abstract class MyVehicle {
	def name: String
	def description: Vector[String]

	def fullDescription: String={
		// "suraj" +: Vector("yadav") will return Vector("Suraj", "Yadav") 
		(name +: description).mkString(",")
	}

	override def toString: String ={
		s"Name is $name"
	} 
}


case class YCar(
	            name: String, // name is def in base class but still we can pass it as val (def can be overriden by def)
                description: Vector[String] // samw with it as well
              ) extends MyVehicle



// now we need to make model for storing vehciles in a parking


abstract class Storage {
	def name: String
	def vehicles: Vector[MyVehicle]

	def vehicleCount: Int = vehicles.size

	override def toString: String = s"$name has $vehicles  vehicles in garage"

}



case class ParkingStructure(
	                          name:String, // val name overrided def name of base class
                              vehicles: Vector[MyVehicle] // val vehicles overrided def vehicles of base class
                            ) extends Storage {


	def fullDescription:String = {
		s" $name containing ${vehicles.mkString(",")}"
	}
}







