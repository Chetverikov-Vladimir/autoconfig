package che.vlvl

class HelloService(private val config: HelloConfig) {

    fun sayHello() = println("HelloService say hello message: ${config.message}")
}