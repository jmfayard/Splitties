@file:Suppress("SpellCheckingInspection")

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
        getByName("androidMain").dependencies {
            api(project(":fun-packs:android-appcompat"))
            listOf(
                "material-lists",
                "snackbar",
                "views-cardview",
                "views-coroutines-material",
                "views-material"
            ).forEach { api(splitties(it)) }
        }
    }
}

afterEvaluate {
    publishing {
        setupAllPublications(project)
    }
}
