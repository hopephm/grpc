package kr.hope.grpc.ui.grpc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "kr.hope.grpc.ui.grpc",
        "kr.hope.grpc.domain",
    ]
)
class GrpcApplication

fun main(args: Array<String>) {
    runApplication<GrpcApplication>(*args)
}
