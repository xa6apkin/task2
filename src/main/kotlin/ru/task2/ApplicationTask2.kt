package ru.task2

import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class ApplicationTask2 {

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder.build()


    @Bean
     fun run(restTemplate: RestTemplate)=CommandLineRunner {

        val quote: Quote? = restTemplate.getForObject(
            "https://gturnquist-quoters.cfapps.io/api/random",
            Quote::class.java
        )
        logger.info { quote.toString() }

    }
    companion object{
        val logger = KotlinLogging.logger {}
    }
}
fun main(args: Array<String>) {

    SpringApplication.run(ApplicationTask2::class.java, *args)
}
