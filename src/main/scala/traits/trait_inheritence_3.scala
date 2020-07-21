
package traits
 
object TraitInheritence3 {
    def main(args: Array[String]){
        // val ob = new VintageConvertible1(2000, false, "mushtang")
        val ob = new VintageConvertible2( 2000, false, "mushtang")
        println(ob.describe)
    }
}

trait Vintage2 {
    def model:Int
    def describe:String= s" This is Vintage model $model"
}

trait Convertibel2 extends Vintage2{
    def fullPower:Boolean
    // since it extends Vintage2 then we need to provide override here while changing body of describe
    override def describe:String= s" This is Convertibele model $fullPower ${super.describe}"
}

class VintageConvertible2(override val model:Int,  override val fullPower:Boolean, val name:String) extends Convertibel2 with Vintage2 {
                                                                                                    // here describe of Vintage won;t be called first as that won't have super inside that
                                                                                                    // scala will look for describe having super inside describe so in this case
                                                                                                    // extends Convertibel2 with Vintage2  OR extends Vintage2 with  Convertibel2
                                                                                                    // both will work same way. super gets complex only in diamond inheritence
    override def describe:String = {
        s"Vintage Convertible $name and super ${super.describe}"
    }
}

// we can also omit override while overriding but it is recommended to do so
// class VintageConvertible2(val model:Int,  val fullPower:Boolean, val name:String) extends Vintage2 with Convertibel2 {
//     override def describe:String = {
//         s"Vintage Convertible $name and super ${super.describe}"
//     }
// }

// class VintageConvertible2(val name:String, val model:Int,  val fullPower:Boolean ) extends Vintage2 with Convertibel2 {
//     override def describe:String = {
//         s"Vintage Convertible $name and super ${super.describe}"
//     }
// }

