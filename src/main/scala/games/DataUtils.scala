package games

import org.apache.spark.sql.SparkSession

import java.io.File
import java.nio.file.Paths

class DataUtils {
  val spark: SparkSession = SparkSession
    .builder()
    .appName(name = "Playtime Viewership Evaluation")
    .master("local[*]")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  def getListOfFiles(dir: String):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }
}
