plugins {
    id("java")
    id("io.qameta.allure") version ("2.11.2")
}

group = "ru.dolgovDavid"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.13.1")
    testImplementation("io.rest-assured:rest-assured:5.5.5")
    implementation("io.rest-assured:json-path:5.5.5")
    implementation("org.aeonbits.owner:owner:1.0.12")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.19.0")
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")

    testCompileOnly("org.projectlombok:lombok:1.18.38")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.38")

    implementation("org.postgresql:postgresql:42.7.7")

    implementation("com.github.javafaker:javafaker:1.0.2")

    testImplementation("io.qameta.allure:allure-junit5:2.29.1")

}

tasks.test {
    useJUnitPlatform()
}