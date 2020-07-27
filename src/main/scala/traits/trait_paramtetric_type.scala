
package traits

object TraitParametricType {
    def main(args:Array[String]){
        val ford = MCar(1995)
        val ferrari = MCar(2000)
        println( getOlder(ford, ferrari))
    }

    def getOlder[T <: CompareAge[T]](item1: T, item2: T): T ={
        item1.older(item2)
    }

    /*
     This is not necessaary that we use only MCar , we can use any class as long as we are over riding older method inside that
    */
}


trait CompareAge[T] {
    def older(item1: T):T 
}

case class MCar(val age:Int) extends CompareAge[MCar] {
    override def older(other:MCar):MCar = {
        if(this.age > other.age) other else this
    }
}

