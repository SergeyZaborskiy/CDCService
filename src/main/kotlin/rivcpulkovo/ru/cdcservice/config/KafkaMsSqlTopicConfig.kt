package rivcpulkovo.ru.cdcservice.config

import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer

@Configuration
@EnableKafka
class KafkaMsSqlTopicConfig {

}