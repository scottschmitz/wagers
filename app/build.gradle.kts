plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.michiganlabs.wagers"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.michiganlabs.wagers"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.michiganlabs.wagers.test.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

println("Source Sets")
sourceSets.forEach {
    println(it.name)
}

tasks.register("cucumberCli") {
    dependsOn("compileDebugKotlin", "testDebugUnitTest")
    doLast {
        println("Source Sets:")
        sourceSets.forEach {
            println(it.name)
        }

//        javaexec {
//            mainClass = "com.michiganlabs.wagers.RunBetCalculatorTest"
//            classpath = configurations["cucumberRuntime"] + sourceSets.getByName("cucumber").output
//            args = listOf(
//                "--plugin", "pretty",
//                "--plugin", "html:target/cucumber-report.html",
//                "--glue", "com.michiganlabs.wagers",
//                "src/test/assets/features"
//            )
//        }
    }
}
tasks.withType<Test> {
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    testImplementation(libs.kotlin.test)
    testImplementation(platform(libs.junit.bom))
    testImplementation(platform(libs.cucumber.bom))
    testImplementation(libs.cucumber.junit)
    testImplementation(libs.cucumber.java)

    androidTestImplementation(libs.kotlin.test)
    androidTestImplementation(libs.cucumber.java)
    androidTestImplementation(libs.cucumber.junit)
    androidTestImplementation(libs.cucumber.android)
}