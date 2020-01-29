plugins {
    id("org.jetbrains.kotlin.multiplatform") version "1.3.41"
    id("maven-publish")
    antlr
}

dependencies {
    antlr("org.antlr:antlr4:4.7.2")
}

repositories {
    mavenCentral()
}


group = "com.example"
version = "0.0.1"


kotlin {
    jvm()
    js {
        browser {
        }
        nodejs {
        }
    }

    sourceSets {
        val commonAntlr by creating {
        }
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }


        val commonTest by getting {
            dependencies {
                implementation( kotlin("test-common"))
                implementation( kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.antlr:antlr4-runtime:4.7.2")
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}
