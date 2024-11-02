package com.smarthome.air.conditioner.service.configurations

import ch.qos.logback.classic.AsyncAppender
import ch.qos.logback.classic.LoggerContext
import net.logstash.logback.appender.LogstashTcpSocketAppender
import net.logstash.logback.encoder.LoggingEventCompositeJsonEncoder
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import jakarta.annotation.PostConstruct
import java.net.InetSocketAddress

@Configuration
class LoggingConfiguration {

    @PostConstruct
    fun setupLogging() {
        val context = LoggerFactory.getILoggerFactory() as LoggerContext
        val rootLogger = context.getLogger("ROOT")

        // Создаем и настраиваем Logstash аппендер
        val logstashAppender = LogstashTcpSocketAppender().apply {
            this.context = context
            this.name = "LOGSTASH"
            addDestinations(InetSocketAddress("localhost", 5044))  // Замените на ваш хост Logstash
        }

        // Настраиваем JSON-энкодер
        val jsonEncoder = LoggingEventCompositeJsonEncoder()
        jsonEncoder.context = context
        jsonEncoder.start()
        logstashAppender.encoder = jsonEncoder
        logstashAppender.start()

        // Настраиваем асинхронный аппендер для повышения производительности
        val asyncAppender = AsyncAppender()
        asyncAppender.context = context
        asyncAppender.addAppender(logstashAppender)
        asyncAppender.start()

        // Подключаем аппендер к корневому логгеру
        rootLogger.addAppender(asyncAppender)
    }
}