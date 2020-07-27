


// this is how packaginf happens in C#(sharp)
package demo{
    package api {
        trait Desert

        case class Food(name:String) extends Desert
    }
}

// can also be written as this
package demo.api {
    trait Desert1

    case class Food1(name:String) extends Desert
}


// but in scala
