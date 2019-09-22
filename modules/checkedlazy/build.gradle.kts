/*
 * Copyright 2019 Louis Cognault Ayeva Derman. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    `maven-publish`
}

android {
    setDefaults()
}

kotlin {
    android()
    configure(targets) { configureMavenPublication() }
    sourceSets {
        androidMain.dependencies {
            api(splitties("mainthread"))
            api(splitties("exceptions"))
            api(Libs.kotlin.stdlibJdk7)
        }
        commonTest {
            dependencies {
                implementation(project(":test-helpers"))
            }
        }
    }
}

dependencies {
    androidTestImplementation(Libs.androidX.test.runner)
    testImplementation(Libs.roboElectric)
}

afterEvaluate {
    publishing {
        setupAllPublications(project)
    }
}
