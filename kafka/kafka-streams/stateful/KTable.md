# Ktable

## GroupBy

* GroupBy allows you to perform more aggregations within a KTable
* It triggers a repartition because the key changes

```java
// group the table by a new key and key and key type
KGroupedTable<String, Integer> groupedTable = table.groupBy(
	(key, value) -> KeyValue.pair(value, value.length()),
	Serdes.String(),
	Serdes.Integer())
```

