package inheritence;

class Polygon{

  def area :Double = 0.0
 }


object Poly{

  def main(args: Array[String]){
    val ob = new Polygon();
    println(ob.area)

    val rec = new Rectangle(1,2);
    println(rec.area)
  }


}