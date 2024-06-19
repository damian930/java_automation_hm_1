plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.register("checkFileExistence") {
    doLast {
        val filePath = "task_file.txt"
        val file = file(filePath)
        if (file.exists()) {
            println("File exists: $filePath")
        }
        else {
            println("File does not exist: $filePath")
        }
    }
}

tasks.register("createZip", Zip::class) {
    description = "Zip current project and put it in the root directory of this project"

    archiveFileName.set("hm_3.zip")
    destinationDirectory.set(project.rootDir)

    from(project.projectDir) {
        include("*")
    }
}

tasks.test {
    useJUnitPlatform()
}