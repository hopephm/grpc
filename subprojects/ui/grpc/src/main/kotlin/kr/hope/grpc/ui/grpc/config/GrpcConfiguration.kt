package kr.hope.grpc.ui.grpc.config

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.context.annotation.Configuration

@Configuration
@ImportAutoConfiguration(
    classes = [
        net.devh.boot.grpc.common.autoconfigure.GrpcCommonCodecAutoConfiguration::class,
        net.devh.boot.grpc.server.autoconfigure.GrpcAdviceAutoConfiguration::class,
        net.devh.boot.grpc.server.autoconfigure.GrpcHealthServiceAutoConfiguration::class,
        net.devh.boot.grpc.server.autoconfigure.GrpcMetadataConsulConfiguration::class,
        net.devh.boot.grpc.server.autoconfigure.GrpcMetadataEurekaConfiguration::class,
        net.devh.boot.grpc.server.autoconfigure.GrpcMetadataNacosConfiguration::class,
        net.devh.boot.grpc.server.autoconfigure.GrpcMetadataZookeeperConfiguration::class,
        net.devh.boot.grpc.server.autoconfigure.GrpcReflectionServiceAutoConfiguration::class,
        net.devh.boot.grpc.server.autoconfigure.GrpcServerAutoConfiguration::class,
        net.devh.boot.grpc.server.autoconfigure.GrpcServerFactoryAutoConfiguration::class,
        net.devh.boot.grpc.server.autoconfigure.GrpcServerMetricAutoConfiguration::class,
        net.devh.boot.grpc.server.autoconfigure.GrpcServerMetricAutoConfiguration::class,
        net.devh.boot.grpc.server.autoconfigure.GrpcServerSecurityAutoConfiguration::class,
    ],
)
class GrpcConfiguration
