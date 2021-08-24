# KStreams & KTables

## Kstreams
* All **inserts**
* Similar to a log
* Infinite
* Unbounded data streams
  
  ![image-20210824234452908](../assets/image-20210824234452908.png)

## KTables

* All **upserts** on non null values
* Deletes on null values
* Similar to a table
* Parallel with log compacted topics

![image-20210824234822856](../assets/image-20210824234822856.png)

## When to use **KStreams** vs **KTable** ?

* **KStream** reading from a topic that's not compacted
* **KTable** reading from a topic that's log-compacted (aggregations)
* **KStream** if new data is partial information / transactional
* **KTable** more if you need a structure that's like a "database table", (think - total bank balance)

