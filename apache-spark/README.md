# Spark Notes

## Components

* Spark Core
* Spark SQL
* Spark Streaming
* Spark MLlib
* GrahpX - Network related data

## Spark Key Features

* Fast Processing
  * contains Resilient Distributed Datasets\(RDD\)
* In-memory computing
  * data is stored in the RAM, so it can access the data quickly and accelerate the speed of analytics
* Flexible
  * supports Java, Scala, R, Python
* Fault Tolerance
  * RDD is designed to handle the failure of any worker node in the cluster. Thus, it ensures that the loss of data reduces to zero
* Better analytics
  * rich set of:
    * SQL queries
    * machine learning algos
    * complex analytics etc

### Spark Core

* Responsible for:
  * memory management
  * fault recovery
  * scheduling, distributing, monitoring jobs on a cluster
  * interacting with storage systems
* RDD
  * immutable fault-tolerant
  * distributed collection of objects that can be operated on in parallel
  * Ops:
    * Transformation
      * such as map, filter, join, union
      * performed on RDD that yields a new RDD containg the result
    * Action
      * such as reduce, first, count
      * return value after running a computation on an RDD

### Spark SQL

* use for both structed and semi-structured data processing
* Architecture
  * DataFrame DSL, Spark SQL and HQL \(Level 1\)
  * DataFrame API \(Level 2\)
  * Data Source API \(Level 3\)
  * CSV, JSON, JDBC \(Level 4\)

### Spark Streaming

* ligthweight API that allows developers to perform batch processing and real-time streaming of data with ease
* secure, reliable, fast processing of live data streams
* Input data stream -&gt; **Spark Streaming** -&gt; Batches of input data -&gt; **Spark Engine** -&gt; Batches of processed data

### Spark MLlib

* low-level machine learning library that is simple to use, is scalable.
* eases deployment and development of scalable machine learning algos
* clustering, classification, collaborative filtering

### GraphX

* Graph Computation Engine and data store
  * Provides a uniform tool for ETL \(Extract Transform Load\)
  * EDA
  * Interactive graph computations

## Spark Architecture

* uses a master-slave arch that consists of a driver, that runs on a master node, and multiple executors which run across the worker nodes in the cluster
* Arch:
  * Master node
    * Driver Program -&gt; Cluster Manager
      * SparkContext
* Every Spark application have driver program and Spark Context
  * run as independent sets of processes on a cluster
  * the driver program & spark context takes care of the job execution within the cluster
* Cluster Manager
  * Arch:
    * Worker Nodes
      * Executor
        * Cache
        * Tasks
  * A job is split into multiple tasks that are distributed over the worker node
  * When an RDD is created in Spark Context, it can be distributed accross various nodes
  * Worker nodes are slaves that run different tasks

### Spark Cluster Managers

* Standalone Mode
  * by default, apps submitted to the standalone noded cluster will run in FIFO order, and each app will try to use available nodes
* Apachee Mesos
  * open-source project to manage computer clusters, and can also run Hadoop apllications
* Hadoop Yarn
  * Apachee Yarn is the cluster resource manager of Hadoop 2. Spark can be run on YARN
* kubernetes
  * open-source system for automating deployment, scaling, and management of containerized apps

### Applications of Spark

* JPMORGAN CHASE & CO. \(Banking\)
  * uses Spark to detect fraudulent transactions, analyze the business spends of an individual to suggest offers, and identify patterns to decide how much to invest and where to invest
* Alibaba Group \(E-Commerce\)
  * uses Spark to analyze large sets of data such as real-time transaction details, browsing history, etc. in the form of Spark jobs and provides recommendations to its users
* IQVIA \(Healthcare\)
  * analyze patient's data, identify possible health issues, and diagnose it based on their medical history
* Netflix and RIOT GAMES \(Entertaiment\)
  * showcase relevant advertisements to their users based on the videos that they watch, share and like

### Spark Use Case

* Video Streaming
  * Conviva delivers a better quality of service to its customers by removing the screen buffering and learning in detail about the network conditions in real-time
  * This information is stored in the video player to manage live video traffic coming from 4 billion video feeds every month,  to ensure maximum retention
  * created an auto diagnostics alert
    * automatically detect anomalies along the video streaming pipeline and diagnoses the root cause of the issue
    * reduces waiting time before the video starts
    * avoids buffering and recovers the video from a technical error
    * maximize the viewer engagement

