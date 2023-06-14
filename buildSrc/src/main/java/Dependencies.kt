object Versions {
    const val koinVersion = "3.1.2"
    const val composeVersion = "1.4.3"
    const val composeActivity = "1.7.2"
    const val androidCore = "1.10.1"
    const val lifecycle = "2.6.1"
    const val roomVersion = "2.4.3"
    const val junitVersion = "4.13.2"
    const val extJunitVersion = "1.1.5"
    const val espressoVersion = "3.5.1"
    const val coroutineTestVersion = "1.6.2"
    const val mockkVersion = "1.13.5"
    const val coreTestingVersion = "2.2.0"
    const val stdlibVersion = "1.8.10"

    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33
    const val versionCode = 1
}

object Deps {

    // Android Core
    const val android_core = "androidx.core:core-ktx:${Versions.androidCore}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.stdlibVersion}"

    // Koin
    const val koin_core = "io.insert-koin:koin-core:${Versions.koinVersion}"
    const val koin_work_manager = "io.insert-koin:koin-androidx-workmanager:${Versions.koinVersion}"
    const val koin_compose = "io.insert-koin:koin-androidx-compose:${Versions.koinVersion}"

    // Compose
    const val compose_activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val compose_material = "androidx.compose.material:material:${Versions.composeVersion}"
    const val compose_ui = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val compose_ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    const val compose_runtime = "androidx.compose.runtime:runtime-livedata:${Versions.composeVersion}"
    const val compose_ui_test = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val compose_ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val compose_ui_test_manifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeVersion}"

    // Room
    const val room_runtime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.roomVersion}"

    // Test Implementation
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val ext_junit = "androidx.test.ext:junit:${Versions.extJunitVersion}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
    const val coroutine_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutineTestVersion}"
    const val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
    const val core_testing = "androidx.arch.core:core-testing:${Versions.coreTestingVersion}"

}