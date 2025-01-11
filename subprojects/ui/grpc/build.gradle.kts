val grpcStarterVersion: String by project
val grpcApiVersion: String by project

/**
 * @see https://yidongnan.github.io/grpc-spring-boot-starter/en/
 */
dependencies {
    implementation(project(":protocol"))
    implementation(project(":domain"))
    implementation("net.devh:grpc-server-spring-boot-starter:$grpcStarterVersion")
    implementation("io.grpc:grpc-api:$grpcApiVersion")
}
