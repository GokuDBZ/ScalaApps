

import java.io.File
import scala.io.Source

object ParameterType{

  def main(arsg:Array[String]): Unit ={


    fileContainsQuestions("./src/main/question_file.txt")

    fileWithContent("./src/main/question_file.txt")

    // both methods are doing almost same work except the return type

    // in this we can use parametric type in which initially we don;t know what type of parameter can be passed


    var result = withFileContent[Boolean]("./src/main/question_file.txt", x => x.trim.endsWith("?"), false)

    // even if we don't pass type here compiler will infer the type from values of paramter whose return type is specified as A

    println(result)

    var result2 = withFileContent("./src/main/question_file.txt", x => x.trim.endsWith("?"), false)




    var result3 = withFileContent[String]("./src/main/question_file.txt", x => x.trim.toUpperCase, "")

    println(result3)


    // it will work without passing type it self as it will infer the type for default parameter as that was declared with type A
    var result4 = withFileContent("./src/main/question_file.txt", x => x.trim.toUpperCase, "")

    println(result4)


  }


  def fileContainsQuestions(filePath:String):Boolean ={
    val file = Source.fromFile(filePath)

    //println(file.getLines().toSeq)
    try {
      file.getLines().toSeq.headOption.map { x =>
        x.trim.endsWith("?")
      }.getOrElse(false)
    }
//    for(line <- file.getLines()){
//      println(line)
//    }

  }


  def fileWithContent(filePath:String):String ={
    val file = Source.fromFile(filePath)

    //println(file.getLines().toSeq)

    // if headOption is empty then getOrElse will be executed and return ""
    try {
      file.getLines().toSeq.headOption.map { line =>
        line.trim.toUpperCase
      }.getOrElse("")
    }

  }


  // in this method we have added a parametric type A which we will be passing while method calling
  // passing f as a function having return type A
  // method also have return type A

  // above two methods will be covered in one method
  def withFileContent[A](filePath: String,  f: (String) => A, default: A):A ={
    val file = Source.fromFile(filePath)
    file.getLines().toSeq.headOption.map{ x => f(x)}.getOrElse(default)
  }


}