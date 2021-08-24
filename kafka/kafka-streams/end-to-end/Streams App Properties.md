# WordCount

## Streams App Properties

* A stream application, when communicating to Kafka, is leveraging the **Consumer** and **Producer** API.
* Therefore all the configurations we learned before are still applicable.
* `bootstrap.servers`: need to connect to kafka (usually port 9092)
* `auto.offset.reset.config`: set to `earliest` to consumer the topic from start
* `application.id`: specific to Streams application, will be used for
  * Consumer `group.id` = `application.id` (most important one to remember)
  * Default `client.id` prefix
  * Prefix to internal changelog topics
* `default.[key|value].serde` (for Serializatiom and Desearialization of data)