# What is Kafka Streams ?
* Easy **data processing and transformation library** within Kafka

* Standard Java Application

* No need to create a separate cluster

* Highly scalable, elastic and fault tolerant

* Exactly Once Capabilities

* One record at a time processing (no batching)

* Works for any application size

  ![image-20210823163250040](/home/muhdlaziem/Workspace/notes/kafka/kafka-streams/assets/image-20210823163250040.png)

## Kafka Streams Architecture Design

![image-20210823164010947](/home/muhdlaziem/Workspace/notes/kafka/kafka-streams/assets/image-20210823164010947.png)

## Kafka Streams history

* This API / Library was introduced as part of Kafka 0.10 (XX 2016) and is fully mature as part of Kafka 0.11.0.0 (June 2017)
* It's the only library at this time of writing that can leverage the new exactly once capabilities from Kafka 0.11
* It is a serious contender to other processing frameworks such as Apache Spark, Flink, or NiFi
* New library so prone to some changes in the future