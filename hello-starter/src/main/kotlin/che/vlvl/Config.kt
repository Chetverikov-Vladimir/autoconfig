package che.vlvl

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "hello")
class Config {
    //Пытается получить параметр hello.message из application.yaml
    var message: String? = null
}