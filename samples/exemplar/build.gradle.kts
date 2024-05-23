plugins {
  kotlin("jvm")
  application
  id("com.squareup.wire")
}

val applicationMainClass = "com.squareup.exemplar.ExemplarServiceKt"
application {
  mainClass.set(applicationMainClass)
}

dependencies {
  implementation(libs.findbugsJsr305)
  implementation(libs.guava)
  implementation(libs.guice)
  implementation(libs.jakartaInject)
  implementation(libs.kotlinxHtml)
  implementation(libs.logbackClassic)
  implementation(libs.slf4jApi)
  implementation(libs.okHttp)
  implementation(libs.okio)
  implementation(project(":wisp:wisp-config"))
  implementation(project(":wisp:wisp-deployment"))
  implementation(project(":wisp:wisp-rate-limiting"))
  implementation(project(":wisp:wisp-token"))
  implementation(project(":misk"))
  implementation(project(":misk-actions"))
  implementation(project(":misk-admin"))
  implementation(project(":misk-config"))
  implementation(project(":misk-core"))
  implementation(project(":misk-inject"))
  implementation(project(":misk-hotwire"))
  implementation(project(":misk-prometheus"))

  testImplementation(libs.assertj)
  testImplementation(libs.awsDynamodb)
  testImplementation(libs.jedis)
  testImplementation(libs.junitApi)
  testImplementation(libs.micrometerCore)
  testImplementation(project(":misk-hibernate"))
  testImplementation(project(":misk-jdbc"))
  testImplementation(project(":misk-rate-limiting-bucket4j-dynamodb-v1"))
  testImplementation(project(":misk-rate-limiting-bucket4j-mysql"))
  testImplementation(project(":misk-rate-limiting-bucket4j-redis"))
  testImplementation(project(":misk-redis"))
  testImplementation(project(":misk-testing"))

  testImplementation(testFixtures(project(":misk-aws-dynamodb")))
  testImplementation(testFixtures(project(":misk-jdbc")))
  testImplementation(testFixtures(project(":misk-redis")))


}

val jar by tasks.getting(Jar::class) {
  manifest {
    attributes("Main-Class" to "com.squareup.exemplar.ExemplarServiceKt")
  }
  archiveClassifier.set("unshaded")
}

sourceSets {
  val main by getting {
    java.srcDir("$buildDir/generated/source/wire/")
  }
}

wire {
  sourcePath {
    srcDir("src/main/proto/")
  }

  kotlin {
    javaInterop = true
  }
}
