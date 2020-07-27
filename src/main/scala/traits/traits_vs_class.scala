
package traits
      /*
        In TRAIT, IF ANY VAL IS CALCULATED FROM ANOTHER VAL THEN MAKE THAT VAL LAZY ELSE WE WILL FACE INTITIALIZATION PROBLEM.
        Problem is given below with diff solutions
      */
 object TraitVsClass {
     def main(args:Array[String]){

         // we need to focus here properly
         // we can instantiate class Coords but not CoordsT as that is s trait
         val coor = new Coords(2,3)
         println(coor.distToOrigin) // it will print result

         // we cannot instantiate trait so we can extend that into some class

         case class CaseCoor(val x:Int, val y:Int) extends CoordsT // trait expects x and y so we will pass them in class construcor parameter

         val caseCoor  = new CaseCoor(3, 4)
         println(coor.distToOrigin) // it will print result



         // we can also extend trait just in time while creating a anonymous class

         val myTrait = new CoordsT {           
             val x:Int = 3
             val y:Int = 4                  
          }

         println(myTrait.distToOrigin) // result will be zero 
         // this is because by time new values reaches to object our calculations are already done

         /*Problem here is initialization order

             In background it does it like
            new Anyref extends CoordsT


             when we do `new Trait` then x and y inside trait both are inititalized to 0 and everthing is calculated with default values
             and values being passed in the body of class reaches later
            
            varialbles in traits are by default initialized to zero, so by time new value 3 and 4 reaches calculations are already done 

            problem here is we are creating object first which extends trait and then passing values (normally we pass values in constructor params which asigns value but not possible with traits)


             new Trait is like calling default constructor which initializes x and y with 0 
         */
            
         



        // One of the solution for this problem is early initilization
            /*
                We will create the object first and then extend the trait to class

            */

             val earyInitialization = new {               
                 val x:Int = 3
                 val y:Int  = 4
             } with CoordsT // we can't use extends here with traits

             println( earyInitialization.distToOrigin )

             /*
               In background scala does it like
                 new AnyRef {

                 } extends  CoordsT

                 so here we have values in advance and when we inherit Coordst they have value available
             */ 

            
            /*
              if we don't want that 0 iniitalization problem then we can declare distToOrigin as lazy val instead of val
              so due to this it won't we evaluated by default when instance is created , it will only  be evaulated when it is called from object

              so instead of val distToOrigin: Double  = math.sqrt((x*x) + (y*y))

              just declare it as lazy val distToOrigin: Double  = math.sqrt((x*x) + (y*y))

              then we don't need early initialization
            */

     }

     class Coords(val x:Int, val y:Int) {
         override def toString:String= s"$x , $y"

         val distToOrigin: Double  = math.sqrt((x*x) + (y*y))   
     }

     // we can try above class functionality with trait as well

     trait CoordsT {  // we cannot pass constructor parameters in traits like trait CoordsT(val x:Int, val y:Iny ) this is possible only with classes
         // we can specify everthing inside trait
         val x:Int  // by default it is intialized to 0
         val y:Int  // by default it is intialized to 0

         override def toString:String = s"$x , $y"

         val distToOrigin: Double  = math.sqrt((x*x) + (y*y))
     }
 }