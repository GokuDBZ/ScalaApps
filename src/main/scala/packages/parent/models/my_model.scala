// here we will access Food class which is public only till models scope

package packages.parent.models

import packages.parent.models.api._
import packages.parent.models.api.Log

import packages.parent.models.api.Domain.getName // object Domain is defined with packages and now its def and vals can be imported

object MyModel {
    def main(args:Array[String]){
        val food = new Food

        // we can also import Dessert here but wanted to show this way as well
        food.addDessert("rasbhari", new packages.parent.models.api.internal.Dessert("rashbhari", true))


        // we can also import objects. we have created instance above i.e food and we want to import that so that i don't need to use that object everytime to call its method and vals
        import food._
        addDessert("rasgulla", new packages.parent.models.api.internal.Dessert("rasgulla", true)) 

        

        //new Log  it will break as Log class i accessible till api package and after that it will act as private class
        println(food)


        // imported method
        println( getName)
        
    }
}