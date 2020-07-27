

package packages.parent.models.api

import packages.parent.models.api.internal.Dessert

import scala.collection.mutable

/*
  private[models] means this class is private but this class will be accessible till models package
*/
private[models] class Food{

    private[this] val desserts = mutable.Map.empty[String, Dessert]

    private[models] def addDessert(name: String, dessert: Dessert):Unit = {
        desserts.put(name, dessert)
    }

    def lookUpFood(name:String): Option[Dessert] ={
        desserts.get(name)// it will return deser in Some object, if key not present it will return None
    }
     
}


private[api] class Log // in private i have given api which means this class will only be availbale till api package not after that