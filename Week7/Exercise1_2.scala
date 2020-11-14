import org.apache.spark._
import org.apache.log4j._
import scala.io.Source
import java.nio.charset.CodingErrorAction
import scala.io.Codec
/** Our main function where the action happens */
object Exercise1_2 {
    def main(args: Array[String]) {
        // Set the log level to only print errors
        Logger.getLogger("org").setLevel(Level.ERROR)
        def loadMovieNames(): Map[Int, String] = {
            // Handle character encoding issues:
            implicit val codec = Codec("UTF-8")
            codec.onMalformedInput(CodingErrorAction.REPLACE)
            codec.onUnmappableCharacter(CodingErrorAction.REPLACE)
            // Create a Map of Ints to Strings, and populate it from u.item.
            var movieNames: Map[Int, String] = Map()
            val lines = Source.fromFile("ml-100k/u.item").getLines()
            for (line <- lines) {
                var fields = line.split('|')
                if (fields.length > 1) {
                movieNames += (fields(0).toInt -> fields(1))
                }
            }
            return movieNames
        }
        val conf = new SparkConf().setMaster("local[*]").setAppName("PopularMovies").set("spark.driver.host", "localhost");
        // Create a SparkContext using every core of the local machine, named PopularMovies
        //alternative: val sc = new SparkContext("local[*]", "PopularMovies")
        val sc = new SparkContext(conf)
        val nameDict = sc.broadcast(loadMovieNames)
        // Read in each rating line
        val lines = sc.textFile("ml-100k/u.data")
        val movies = lines
            .map(x => ("\\s+".r.split(x)(1).toInt, 1))
            .reduceByKey((x, y) => x + y)
            .map(x => (x._2, x._1))
            .sortByKey(ascending=false)
            .map(x => (nameDict.value(x._2), x._1))
        movies.foreach(println)
        sc.stop()
    }
}
