// Databricks notebook source
val insurance = spark.read.format("csv")
  .option("header", "true")
  .option("inferSchema", "true")
  .load("/FileStore/tables/insurance-1.csv")

display(insurance)

// COMMAND ----------

println(s"The dataframe has ${insurance.count} rows")

// COMMAND ----------

println("For everyone:")
insurance.groupBy("sex").count.show()

// COMMAND ----------

println("For smokers:")
insurance.filter($"smoker" === "yes").groupBy("sex").count.show()

// COMMAND ----------

import org.apache.spark.sql.functions.desc
insurance.groupBy("region").sum("charges").sort(desc("sum(charges)")).show()
