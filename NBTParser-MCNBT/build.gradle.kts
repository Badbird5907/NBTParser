plugins {
    id("java")
}

group = "dev.badbird"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("com.mojang:authlib:1.5.25@jar")
    implementation("org.apache.logging.log4j:log4j-core:2.19.0")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.google.guava:guava:31.1-jre")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
