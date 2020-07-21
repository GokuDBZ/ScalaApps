  object MyClass{

    def main(args:Array[String]):Unit={

      // Anything in a class without access specifier is public
      var a1:A1 = new A1;
      var a2:A2 = new A2("suraj");

      // println(a2.name) // since name is member of parametarized constructor then it won't be accessible directly from object as it becomes private
      println(a2.age)


      println("name is %s", a2.printName())

      a2.printInfo;


      // since we are specifying here val then name which is member of parametarized constructor becomes public
      var valClass = new ValClass("suraj");
      println(valClass.name)


      // Rational class where we will pe overiding def toString


      // how val makes parametarized fields public.
      var ob:NameClass = new NameClass("suraj")
      println(ob.name)


      // How to add preconditions in constructor
      var requireClass:RequireClass = new RequireClass(2,1);
      println(requireClass.i)
      println(requireClass.j)


      // Find bigger rational number between two
      var r1 = new Rational(1,2)
      var r2 = new Rational(1,5)



      val result:Rational = r1.min(r2)
      val result1:Rational = r1.add(r2)

      println(s"Bigger no is $result")



      // Add integer value to ratinal no
      // eq- 1+(1/2). But we need to make 1 in rational form so that we can add both
      // we can make auxiliiary constructor which will make integer value to rational

      var r3 = new Rational(1)

      val res:Rational = r1.min(r3)
      val res1:Rational = r1.add(r3)




      // Companion Objects
        // Companion objects are objects having same name as its class or trait defined in this same scope
        // It is also used as alternative to static in java
        //  Comapanion objects include factory methods.
        // For eq -List(1,23) . implicitly scala rewrites it to List.apply(1,2,3)
        // We will do similar with Rational using companion objects
        // Comapnion objects helps to remove new while initializing object
       // Eq - `Object Rational`  - Search for it in program


      //var r4 = Rational(1,2) // new is not required as we are doing it with help of companion object
      //var r5 = Rational(1,5)

      //println(r4.add(r5))
      //println(r4.min(r5))

      // We can also restrict the initialization of Rational instances with new with help of

        /* class Rational private(val i:Int, val j:Int){
              def this(i:Int){
                this(i, 1)
              }
           }

           once we do this we cannot instantitate it as `new Rational(1,2)`. Now we need companion object here
           which can access the private member of its corresponding class

           Object Rational{

            def apply(i:Int, j:Int):Rational ={
              new Rational(i,j)
            }

            def apply(i:Int):Rational ={
              new Rational(i,1)
            }
           }


         */

    }
  }

  class Demo // This is also a class and a way to make a class without body


  class A1 {
    // If there is anything that is not inside def then that will be executed whenever any object is instantiated
    println("we are in class A1")

  }

  class A2(name:String="Suraj") {  // here in class definition we are specifying parametarized constructor
    // parameters on the class definition becomes the primary constructor of the class
    // code in the class not in def becomes primary constructor code and runs when class is instantiated.
    // parameters in constructor are only accessible within the class.

    // We cannot access constructor patameters from object
    // eq var a = new A2("suraj")
    // a.name it will throw error

    // If there is anything that is not inside def then that will be executed whenever any object is instantiated





    val age:Int = 25
    val surName:String = "Yadav"
    val DOB:String = "1995/07/12"


    // Anything in a class without access specifier is public
    println(s"name is $name")

    def printName():String = name

    def printInfo:Unit={
      println(s"Name is $name $surName")
      println(s"Age is $age")
      println(s"DOB is $DOB")
    }
  }

  // There is private and protected keyword in scala , there is no public keyword present.
  // If not specified by default members are public.

  // public is default for val and def

  class ValClass(val name:String)

  class Rational(val a:Int, val b:Int){
    // every class has a toString method but here we will override it

    // require method is like pre condition in primary constructor
    require(b!=0,"Cannot divide by zero")

    override def toString():String = {
      s"Rational($a/$b)"
    }

    // returning bigger rational number
    def min(other: Rational):Rational={
      if((this.a.toDouble/this.b) < (other.a.toDouble/other.b)) this else other
    }

    def add(other: Rational):Rational={
      new Rational(
                    (a * other.b)+(b * other.a),
                     b * other.b)
    }

    def this(i:Int){
      this(i,1)
    }

  }


  // Comapanion object for Rational Class
//  object Rational{
//    def apply(i:Int,j:Int):Rational ={
//      new Rational(1,j)
//    }
//
//    def apply(i:Int):Rational={
//      new Rational(i,1)
//    }
//  }


  // If we want to make parametarized fields public then we need to declare them with val

  class NameClass(val name:String)



  // How scala makes val parametric fields as public
    // above NameClass is rewritten by scala something like down below
       /*
       class NameClass(_name:String){

        val name = _name
        }

       */


  // Lets say we want some conditions in our priamry constructor that we can use function `require` whihc is not functional

     class RequireClass(val i:Int, val j:Int){
       require(i>j, "We cannot go ahead");
     }



