package com.github.muhdlaziem.udemy.kafka.streams

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.errors.StreamsException
import org.apache.kafka.streams.kstream.{KStream, KTable, Materialized, Produced}
import org.apache.kafka.streams.{KafkaStreams, StreamsBuilder, StreamsConfig}


import collection.JavaConverters._
import java.util.Properties
import java.lang

object StreamStarterApp {
  private val appID: String = "wordcount-application"
  def main(args: Array[String]): Unit = {
    val config: Properties = new Properties
    config.put(StreamsConfig.APPLICATION_ID_CONFIG, appID)
    config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String.getClass)
    config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String.getClass)
//    config.put(StreamsConfig.STATE_DIR_CONFIG, "/tmp/kafka-streams/wordcount-application1") // need to be
    /**
     * Topology using the High Level DSL
     *
     * 1. Stream from Kafka [null,"Kafka Kafka Streams"]
     * 2. MapValues lowercase [null, "kafka kafka streams"]
     * 3. FlatMapValues split by space [null,"kafka"],[null, "kafka"],[null,"streams"]
     * 4. SelectKey to apply a key ["kafka","kafka"],["kafka", "kafka"],["streams","streams"]
     * 5. GroupByKey before aggregation (["kafka","kafka"],["kafka", "kafka"]),(["streams","streams"])
     * 6. Count occurences in each group ["kafka", 2], ["streams", 1]
     * 7. To in order to write the results back to Kafka (data point is written to Kafka)
     */
    val builder: StreamsBuilder = new StreamsBuilder

    // 1)
    val wordCountInput: KStream[String ,String] = builder.stream[String, String]("word-count-input")
    // 2)
    val wordCounts: KTable[String, lang.Long] = wordCountInput
                                            .mapValues((textLine) => textLine.toLowerCase)
                                          // 3)
                                            .flatMapValues((lowerCasedTextLine) => lowerCasedTextLine.split("\\W+").toIterable.asJava)
                                          // 4)
                                            .selectKey((_, word) => word)
                                          // 5)
                                            .groupByKey()
                                          // 6)
                                            .count(Materialized.as("Counts"))
    wordCounts.toStream().to("word-count-output", Produced.`with`(Serdes.String, Serdes.Long))
    try {
      val streams: KafkaStreams =  new KafkaStreams(builder.build(), config)
      startStreaming(streams)
    }
    catch {
      case e: StreamsException => {
        val random = new scala.util.Random(31)
        val newStateDir: String = s"/tmp/kafka-streams/${appID}-${random.alphanumeric.take(10).mkString}"
        println(s"Changing state.dir by random postfix: ${newStateDir}")
        config.put(StreamsConfig.STATE_DIR_CONFIG, newStateDir)
        val streams: KafkaStreams =  new KafkaStreams(builder.build(), config)
        startStreaming(streams)
      }
    }

  }
  def startStreaming(streams: KafkaStreams): Unit ={
    sys.ShutdownHookThread {
      streams.close()
      println("exiting")
    }
    streams.start()
    // printed the topology
    while(true) {
      streams.localThreadsMetadata().forEach(t => println(s"Topology: ${t.toString}"))
      try {
        Thread.sleep(5000)
      }
      catch {
        case e: InterruptedException => println(s"Error on ${e}")

      }
    }

  }
}
