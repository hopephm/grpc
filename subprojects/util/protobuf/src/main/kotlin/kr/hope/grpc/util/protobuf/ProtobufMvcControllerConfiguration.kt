package kr.hope.grpc.util.protobuf

import com.google.protobuf.util.JsonFormat
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class ProtobufMvcControllerConfiguration : WebMvcConfigurer {
    override fun configureContentNegotiation(configurer: ContentNegotiationConfigurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON)
    }

    @Bean
    fun createProtobufHttpMessageConverter(): ProtobufHttpMessageConverter {
        return ProtobufJsonFormatHttpMessageConverter(
            JsonFormat.parser().ignoringUnknownFields(),
            JsonFormat.printer().omittingInsignificantWhitespace().includingDefaultValueFields(),
        )
    }
}
