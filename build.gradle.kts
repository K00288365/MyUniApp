// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
    id("com.android.library") version "8.1.4" apply false
}

buildscript {
    extra.apply {
        set("room_version", "2.6.0")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}