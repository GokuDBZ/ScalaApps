
package companion_objects

object CompanionObject {
    def main(args: Array[String]){
      val ship = ShippingContainer("a", "b", "c")
      println(ship.items)
  
      val isFull = ShippingContainer.isContainerFull(ship)

      println(isFull)
    }
}


class ShippingContainer[T] private(val items: Seq[T]){
  
  private[this] val maxCount = 5

  private def getMaxItems:Int = this.maxCount

  private def isFull:Boolean = items.length > maxCount

  override def toString:String= s"my class"
}

object ShippingContainer {
    def apply[T](items: T*)={
      new ShippingContainer(items)
    }
    
    /*
    def maxShipCount(container: ShippingCOntainer[_]):Int = container.maxCount // this will throw error as we are trying to access private[this] variable
    */

    // even if isFull is private but we can access private methods inside object
    def isContainerFull(container: ShippingContainer[_]):Boolean = container.isFull // this will work
}






/*
   T <:AnyRef means that it can accept variables which is of type AnyRef like string 

   M <:AnyVal means it can accept variables which is of type AnyVal like Int
*/

class MyTypeClass[T <:AnyRef, M <:AnyVal] (item1: T, item2: M) {
    def getItem1:T ={
        item1
    }

    def getItem2:M = {
        item2
    }
}