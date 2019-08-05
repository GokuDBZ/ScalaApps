package inheritence

class Rectangle(length:Double, breadth:Double) extends Polygon{
  // we need to specify override before def
  override def area(): Double ={
    length * breadth
  }
}


