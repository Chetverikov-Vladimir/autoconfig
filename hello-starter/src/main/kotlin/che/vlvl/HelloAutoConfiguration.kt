package che.vlvl

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
// При исключении класса из зависимости (exclude), автоконфигурация не будет выполняться
@ConditionalOnClass(HelloService::class)
@EnableConfigurationProperties(Config::class)
class HelloAutoConfiguration(private val config: Config) {

    private val logger = KotlinLogging.logger { }

    @Bean
    @ConditionalOnMissingBean
    fun helloConfig(): HelloConfig {
        val message: String = if (config.message != null) {
            config.message!!
        } else {
            // Если параметр hello.message не определен в application.yaml модуля demo, будет
            // указано значение по умолчанию
            "default message"
        }
        logger.info("Autoconfiguration. Create HelloConfig. Message: $message")
        return HelloConfig(message)
    }

    @Bean
    @ConditionalOnMissingBean
    fun helloService(helloConfig: HelloConfig): HelloService {
        logger.info("Autoconfiguration. Create HelloService.")
        return HelloService(helloConfig)
    }
}