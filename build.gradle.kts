plugins {
    id("java")
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

}

tasks.test {
    useJUnitPlatform()
}