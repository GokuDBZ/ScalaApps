

object Equal {
    def main(args:Array[String]){
        /*
            In scala == is alias to equals which is final and cannot be overriden
        */

        class A(val i:Int,  val j:String)
        val a = new A(1, "suraj")
        val b = new A(2, "yadav")

        println( a == b)  // == is just alias to equals both are doing smae stuff
        println( a.equals(b)) //result will be false as refernces are compared


        /*
          We cannot override == but we can override the alias i.e equals

        */

        val suraj1 = new Person(27, "suraj")
        val suraj2 = new Person(27, "suraj")

        println(  suraj1 == suraj2)  // will return true
        println( suraj1.equals(suraj2) ) // will return true

        // overriding becomes difficult when we use inheritence
        val ob1 = new Apple("suraj" ,"blue")
        val ob2 = new Apple("suraj", "blue")
        val ob3 = new Apple("suraj", "green")

        println(  ob1 == ob2) // true
        println( ob2 == ob3)  // false as color is diff in both objects

       

        /*

          If we don't want to override equals and hashCode then we can use case classes
            But case classes cannot extend other classes and technically they should be marked as final

        */   


    }

    class Person(val age:Int, val name:String) {

        // we cannot override == but we can override equals
        override def equals(other:Any):Boolean = other match {
            // we look for object of type Person
            case that:Person => {
                this.age == that.age && this.name == that.name
            }
            case _ => false
        }

        override def hashCode():Int = this.name.hashCode
    }


    class Fruit(val name:String) {
      override def equals(other:Any):Boolean = other match {
          case that:Fruit => {
              this.name == that.name
          }
          case _ => false
      }

      override def hashCode:Int = name.hashCode
    }

    // class Apple1(override val name:String,
    //             brand:String,
    //             color:String) extends Fruit(name)


    // we can declare class as above as well
    class Apple(val brand:String, val color:String) extends Fruit("apple") {
        override def equals(other:Any):Boolean = other match {
          case that:Apple => {
              super.equals(that) && this.brand == that.brand && this.color == that.color
          }
          case _ => false
        }


      override def hashCode:Int = {
          // we should prime no to calculate hashCode
          41 * {
              41 * {
              super.hashCode
          }
        } * brand.hashCode * color.hashCode 
      }

    } 
    
}