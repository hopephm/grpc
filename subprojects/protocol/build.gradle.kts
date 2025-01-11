import com.google.protobuf.gradle.id

val grpcVersion: String by project
val protoCompileVersion: String by project
val jakartaAnnotationVersion: String by project

/**
 * @see https://github.com/grpc/grpc-java
 */

plugins {
    val protobufPluginVersion = "0.9.4"

    id("java-library")
    id("com.google.protobuf") version protobufPluginVersion
}

dependencies {
    api("io.grpc:grpc-protobuf:$grpcVersion")
    api("io.grpc:grpc-stub:$grpcVersion")
    compileOnly("jakarta.annotation:jakarta.annotation-api:$jakartaAnnotationVersion")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protoCompileVersion"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
    }

    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
            }
        }
    }
}
