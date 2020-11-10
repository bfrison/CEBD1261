package dataset
import org.apache.log4j._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

object Exercise2 {
  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val spark =
      SparkSession
        .builder()
        .master("local[2]")
        .appName("Exercise2")
        .getOrCreate()
    import spark.implicits._    // Create a tiny Dataset of integers
    val df = spark.read.options(Map("header"->"true", "inferSchema"->"true")).csv("insurance.csv")
    println(s"The table has ${df.count} rows")
    df.groupBy($"sex").count.show()
    println("Only smokers:")
    df.where($"smoker" === "yes").groupBy($"sex").count.show()
    df.groupBy($"region").sum("charges").sort(desc("sum(charges)")).show()
    spark.stop()
  }
}
