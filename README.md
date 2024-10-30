## Spring Boot Kafka Events
This repository contains an Spring Boot Events Application which shows an event Producer/Consumer example implemented via Kafka.
The Producer/Consumer communicates via a single Topic 'product-dto-topic'.
The exchanged Event is JSON / DTO type.
The REST API via a POST call triggers the execution of the Producer.

### 🔧 Technology Stack

```
Java 17
Spring Boot 3 ( REST API )
Spring Kafka / Apache Kafka
Misc Libraries (  Maven  /  Docker  /  Lombok  /  SpringDoc OpenAPI  )
```

### ⚒️ Getting Started

```bash
# install Apache Kafka ( example for Ubuntu 24.04 )
wget https://downloads.apache.org/kafka/3.8.1/kafka_2.12-3.8.1.tgz;
tar xzf kafka_2.12-3.8.1.tgz;
sudo mv kafka_2.12-3.8.1 /opt/kafka;

# start the zookeeper server
nohup /opt/kafka/bin/zookeeper-server-start.sh /opt/kafka/config/zookeeper.properties &>/dev/null &

# start the kafka server
nohup /opt/kafka/bin/kafka-server-start.sh /opt/kafka/config/server.properties &>/dev/null &

# create the topic 'product-dto-topic'
/opt/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic product-dto-topic;

# clone the project
git clone https://github.com/rodrigobalazs/springboot-kafka.git;
cd springboot-kafka;

# compile and start the spring boot server
mvn clean install;
mvn spring-boot:run;
```

### 💡 API Examples

#### Sends a new JSON/DTO Event, this API call will trigger the execution of this particular Kafka Producer ProductDTOKafkaProducer.java =>
```
curl -X POST http://localhost:8080/events/sendProductDTO  \
     -H 'accept: application/json'  \
     -H 'Content-Type: application/json' -d \
'{
    "name": "Tablet",
    "availableQuantity": 100
}';
```

#### After the execution of the previous POST API call, the IDE console should display a log trace from the Kafka Consumer
#### ( ProductDTOKafkaConsumer.java ) similar to this one =>
```
c.r.e.consumer.ProductDTOKafkaConsumer : received a JSON/ProductDTO event with this content => name:Tablet | available_quantity: 100
```

### 🔍 API Documentation / Swagger

the API documentation could be accessed from => http://localhost:8080/swagger-ui/index.html

![](https://github.com/rodrigobalazs/springboot-kafka/blob/main/src/main/resources/static/events_api_swagger.png)