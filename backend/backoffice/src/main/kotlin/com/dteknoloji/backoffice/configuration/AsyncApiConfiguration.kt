package com.dteknoloji.backoffice.configuration

import com.asyncapi.v2.model.info.Info
import com.asyncapi.v2.model.server.Server
import com.dteknoloji.springkafkadoc.configuration.AsyncApiDocket
import com.dteknoloji.springkafkadoc.configuration.EnableAsyncApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAsyncApi
class AsyncApiConfiguration {

    @Bean
    fun asyncApiDocket(): AsyncApiDocket {

        val info = Info.builder()
            .version(SERVICE_VERSION)
            .title(SERVICE_TITLE)
            .description(SERVICE_DESC)
            .build()

        val kafkaServer = Server.builder()
            .protocol("kafka")
            .url(BOOTSTRAP_SERVERS)
            .build()

        return AsyncApiDocket.builder()
            .producerBasePackage(PRODUCER_BASE_PACKAGE)
            .info(info)
            .server("kafka", kafkaServer)
            .build()
    }

    private companion object {
        const val SERVICE_TITLE = "Backoffice"
        const val SERVICE_VERSION = "1.0.0"
        const val SERVICE_DESC = "Nice, short desc"
        const val BOOTSTRAP_SERVERS = "ip-of-service:port"
        const val PRODUCER_BASE_PACKAGE = "com.dteknoloji.backoffice.producer"
    }
}