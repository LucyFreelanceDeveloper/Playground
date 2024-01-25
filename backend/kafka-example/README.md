# Spring kafka
A sample application using Apache Kafka in Spring. It is a terminal application that receives messages to the kafka topic via the rest api
and displays incoming messages in the console.

## What is Kafka
Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.

**Kafka usages**
* Messaging
* Website Activity Tracking
* Metrics
* Log Aggregation
* Stream Processing
* Event Sourcing
* Commit Log

[Kafka Intro](https://kafka.apache.org/intro)

## How to run

### How to install Kafka
```bash
cd ~
mkdir App
cd App

# Download last Kafka version from https://www.apache.org/dyn/closer.cgi?path=/kafka/3.6.1/kafka_2.13-3.6.1.tgz
tar -xzf kafka_2.13-3.6.1.tgz
cd kafka_2.13-3.6.1
```
### Run Kafka
```bash
# Start the ZooKeeper service
bin/zookeeper-server-start.sh config/zookeeper.properties

# Start the Kafka broker service
bin/kafka-server-start.sh config/server.properties
```
### Run app
```bash
mvn spring-boot:run
```

### Send POST request
Send POST request and verify display message in application log.
```
POST localhost:8080/api/v1/messages
Body: ContentType: JSON
{
    "message":"test message"
}
```