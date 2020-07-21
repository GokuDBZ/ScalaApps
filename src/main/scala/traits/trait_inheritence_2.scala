
package traits
 
object TraitInheritence2 {
    def main(args: Array[String]){
        val ob = new VintageConvertible1(2000, false, "mushtang")

        //val ob = new VintageConvertible1("mushtang", 2000, false) try this by uncommenting  (2)

        println(ob.describe)
    }
}



trait Vintage1 {
    def model:Int
    def describe:String= s" This is Vintage model $model"

}

trait Convertibel1 {
    def fullPower:Boolean
    def describe:String= s" This is Convertibele model $fullPower "
}


// we have 3 ways of overiding def and val of parent

// we have to override model and full power as they don't have definiton
// we will override def color,  def model, def fullPower to val
class VintageConvertible1(override val model:Int,  override val fullPower:Boolean, val name:String) extends Vintage1 with Convertibel1 {
    override def describe:String = {
        s"Vintage Convertible $name and super ${super.describe}" // super will call describe of Convertible1 as it is first in linear chain
    }
}


  // we can also omit override while overriding but it is recommended to do so   (2)
// class VintageConvertible1(val model:Int,  val fullPower:Boolean, val name:String) extends Vintage1 with Convertibel1 {
//     override def describe:String = {
//         s"Vintage Convertible $name and super ${super.describe}"
//     }
// }



// class VintageConvertible1(val name:String, val model:Int,  val fullPower:Boolean ) extends Vintage1 with Convertibel1 {
//     override def describe:String = {
//         s"Vintage Convertible $name and super ${super.describe}"
//     }
// }

