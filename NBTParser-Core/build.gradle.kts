plugins {
    id("java")
}

group = "dev.badbird"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(project(":NBTParser-MCNBT")) // NBT base code that should be platform independent

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("com.google.code.gson:gson:2.10")

    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
