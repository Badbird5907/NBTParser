plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "dev.badbird"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(project(":NBTParser-MCNBT")) // Stripped down mc nbt
    implementation(project(":NBTParser-Core"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks {
    shadowJar {
        archiveBaseName.set("NBTParser-Generic")
        archiveClassifier.set("")
    }
    jar {
        archiveClassifier.set("sources")
        dependsOn("shadowJar")
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
