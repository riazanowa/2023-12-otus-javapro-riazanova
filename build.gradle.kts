plugins {
    java
	id("io.spring.dependency-management")
	id("org.springframework.boot") apply false
}

allprojects {
    group = "ru.riazanova"
    version = "0.0.1-SNAPSHOT"

	repositories {
		mavenLocal()
		mavenCentral()
	}

    val guava: String by project

	apply(plugin = "io.spring.dependency-management")
	dependencyManagement {
		dependencies {
			dependency("com.google.guava:guava:$guava")
		}
	}
}

subprojects {
	apply(plugin = "java")
	apply(plugin = "org.springframework.boot")

    plugins.apply(JavaPlugin::class.java)
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

}

tasks.withType<Test> {
	useJUnitPlatform()
}