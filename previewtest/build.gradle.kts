plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.androidLint)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    // Target declarations - add or remove as needed below. These define
    // which platforms this KMP module supports.
    // See: https://kotlinlang.org/docs/multiplatform-discover-project.html#targets
    androidLibrary {
        namespace = "com.test.previewtest"
        compileSdk = 36
        minSdk = 24

        withHostTestBuilder {
        }

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    // For iOS targets, this is also where you should
    // configure native binary output. For more information, see:
    // https://kotlinlang.org/docs/multiplatform-build-native-binaries.html#build-xcframeworks

    // A step-by-step guide on how to include this library in an XCode
    // project can be found here:
    // https://developer.android.com/kotlin/multiplatform/migrate
    val xcfName = "previewtestKit"

    iosX64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    iosSimulatorArm64 {
        binaries.framework {
            baseName = xcfName
        }
    }

    // Source set declarations.
    // Declaring a target automatically creates a source set with the same name. By default, the
    // Kotlin Gradle Plugin creates additional source sets that depend on each other, since it is
    // common to share sources between related targets.
    // See: https://kotlinlang.org/docs/multiplatform-hierarchy.html
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)

                implementation(libs.jetbrains.compose.foundation)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.material3.adaptive)
                implementation(libs.jetbrains.compose.ui)
//
                implementation(libs.jetbrains.compose.material3)


            }
        }


        androidMain {
            dependencies {
                implementation(compose.components.uiToolingPreview) // annotation
                implementation("androidx.compose.ui:ui-tooling-preview:1.9.0")
                //debugImplementation("androidx.compose.ui:ui-tooling:1.9.0") // <- put here, not top-level          }
            }


            getByName("androidDeviceTest") {
                dependencies {
                    implementation(libs.androidx.runner)
                    implementation(libs.androidx.core)
                    implementation(libs.androidx.testExt.junit)
                }
            }

            iosMain {
                dependencies {
                    // Add iOS-specific dependencies here. This a source set created by Kotlin Gradle
                    // Plugin (KGP) that each specific iOS target (e.g., iosX64) depends on as
                }
            }
            }
        }

    }