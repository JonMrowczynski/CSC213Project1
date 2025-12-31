plugins {
    id("java") // Gradle can work with other languages, not just Java! So want to specify we have a Java project.
    // To find which languages are supported: https://docs.gradle.org/current/userguide/userguide.html
}

java { // Want to explicitly state which Java version we are using in this project for the programmer and Gradle!
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral() // Where to look for external (3rd-party) dependencies.
    // What libraries are in this repository can be found here: https://mvnrepository.com/repos/central
}

dependencies {

    // These dependencies are for the testing code to compile. /////////////////////////////////////////////////////////

    // We'll be using the JUnit testing framework to help us run the unit tests, so pull the necessary dependencies
    // from Maven Central.
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.1")
    // Which can be found here: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/6.0.1

    // This is for the parameterized tests, which is one of the more powerful tools in the JUnit Testing Framework.
    testImplementation("org.junit.jupiter:junit-jupiter-params:6.0.1")
    // Which can be found here: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params/6.0.1

    // These dependencies are for the testing code to run. /////////////////////////////////////////////////////////////

    // Need a testing framework launcher to actually run the tests.
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // Need to specify to the launcher which engine to use when launching.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:6.0.1")

}

tasks.test {
    useJUnitPlatform() // Declare that we are using the JUnit Testing Framework for our tests.
}

tasks.jar {
    archiveBaseName.set("UniqueHandsProject")
    manifest {
        attributes["Main-Class"] = "edu.canisius.csc213.project1.UniqueHands"
    }
}