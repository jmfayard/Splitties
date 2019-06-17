/*
 * Copyright 2019 Louis Cognault Ayeva Derman. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    kotlin("multiplatform")
    `maven-publish`
}

kotlin {
    jvm()
    js()
    macos()
    ios()
    configure(targets) { configureMavenPublication() }
    setupNativeSourceSets()
    sourceSets {
        getByName("commonMain").dependencies {
            api(kotlin("stdlib-common"))
        }
        getByName("jvmMain").dependencies {
            api(kotlin("stdlib-jdk7"))
        }
        getByName("jsMain").dependencies {
            api(kotlin("stdlib-js"))
        }
    }
}

publishing {
    setupAllPublications(project)
}
