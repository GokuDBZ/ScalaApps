
package traits
 
object TraitInheritence {
    def main(args: Array[String]){
        val ob = new VintageConvertible("blue", 2000, false)
        println(ob.describe)
    }
}


abstract class Car {
    def color:String
    def describe:String= s"this is Car color $color"
}

trait Vintage extends Car{
    def model:Int
    // we need to override as it is coming from base class
    override def describe:String= s" This is Vintage model $model ${super.describe}"

}

trait Convertibel extends Car{
    def fullPower:Boolean

    // we need to override as it is coming from base class
    override def describe:String= s" This is Convertibele model $fullPower ${super.describe}"
}

// we have to override color, model and full power as they don't have definiton
// we will override def color,  def model, def fullPower to val
class VintageConvertible(override val color:String, override val model:Int,  override val fullPower:Boolean) extends Car with Vintage with Convertibel



