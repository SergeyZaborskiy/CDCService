package rivcpulkovo.ru.cdcservice.domain.kafka

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener

class KafkaNSIListner {

    @KafkaListener(
        id = "myGroup",
        topics = ["schema-changes.mssql", "schema-changes.NSI"]
    )
    fun listen(consumerRecord: ConsumerRecord<String, String>) {

    }
}