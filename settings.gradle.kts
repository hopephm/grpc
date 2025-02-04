rootProject.name = "grpc"

include(
    "ui:grpc",
    "util:protobuf",
    "protocol",
    "domain",
)

makeProjectDir(rootProject, "subprojects")

fun makeProjectDir(
    project: ProjectDescriptor,
    group: String,
) {
    project.children.forEach {
        println("$group -> ${it.name}")

        it.projectDir = file("$group/${it.name}")
        makeProjectDir(it, "$group/${it.name}")
    }
}
