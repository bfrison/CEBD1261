import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession
object Exercise1_1 {
    def main(args: Array[String]) {
        Logger.getLogger("org").setLevel(Level.ERROR)
        val session = SparkSession
            .builder
            .master("local[2]")
            .appName("wordCount")
            .getOrCreate()
        val input = session.read.textFile("TheHungerGames.txt")
        import session.implicits._
        val words = input
            .flatMap(x => "\\W+".r.split(x))
            .map(x => x.toUpperCase)
        val wordCounts = words.rdd.countByValue()
        wordCounts
            .toSeq
            .toDS()
            .sort(desc("_2"))
            .foreach(row => println(row))
        session.stop()
    }
}
