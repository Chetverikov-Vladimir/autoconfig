package che.vlvl.demo

import che.vlvl.HelloConfig
import che.vlvl.HelloService
import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApp {
    val logger = KotlinLogging.logger { }

    /**
     * Если раскомментировать @Bean, будет перебивать определение соответствующего бина в HelloAutoConfiguration
     */
    //@Bean
    fun helloConfig(): HelloConfig {
        logger.info("Create HelloConfig from Demo")
        return HelloConfig("From Demo")
    }

    /**
     * Если раскомментировать @Bean, будет перебивать определение соответствующего бина в HelloAutoConfiguration
     */
    //@Bean
    fun helloService(config: HelloConfig): HelloService {
        logger.info("Create HelloService from Demo")
        return HelloService(config)
    }
}


fun main(args: Array<String>) {
    runApplication<DemoApp>(*args).apply {
        //Получаем бин типа HelloService и вызываем на нем метод
        this.getBean(HelloService::class.java).sayHello()
    }

}