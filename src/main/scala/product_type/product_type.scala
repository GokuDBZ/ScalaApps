

object ProductType {
    def main(args:Array[String]){
      /*
         case classes and tuples both are Product types. Techinically both inherits Product Class
         Due to this they inhert three methods
           i.e 1- productArity  -> which tells you how many variables are there in class
               2- productElement(index) ->index starts from 0 . it will give u element present in a list at particular index
               3- productIterator -> it will reutrn an iterator over which u can iterate to fetch elements of class
               4- productPrefix  -> it will return name of class in string format

         Tuples are created as case classes in scala
      */

      (1,2,3 ) == (1,2,3) // true
      (1, "suraj", 2) == (1, "suraj" , 2) // true

    }
}