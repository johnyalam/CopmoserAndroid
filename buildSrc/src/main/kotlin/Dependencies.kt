/**
 * To define dependencies
 */
object Deps {
    val core_ktx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}"}
    val activity_compose by lazy { "androidx.activity:activity-compose:${Versions.activity_compose}"}
    val compose_ui by lazy { "androidx.compose.ui:ui:${Versions.composeVersion}"}
    val ui_tooling_preview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"}

    val material3 by lazy { "androidx.compose.material3:material3:${Versions.material3}"}
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}"}
    val material by lazy { "com.google.android.material:material:${Versions.material}"}

    val junit by lazy { "junit:junit:${Versions.jUnit}"}
    val androidx_test_ext by lazy { "androidx.test.ext:junit:${Versions.androidxTestExt}"}
    val espresso_core by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}"}
    val ui_test_junit4 by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"}
    val ui_tooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"}
    val ui_test_manifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.composeVersion}"}

    val coil_compose by lazy { "io.coil-kt:coil-compose:${Versions.coil_compose}"}

    //Dagger - Hilt
    val hilt_android by lazy { "com.google.dagger:hilt-android:${Versions.hilt_android}"}
    val hilt_android_compiler by lazy {"com.google.dagger:hilt-android-compiler:${Versions.hilt_android}"}
    val hilt_compiler by lazy {"androidx.hilt:hilt-compiler:${Versions.hilt_compiler}"}
    val hilt_navigation_compose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hilt_navigation_compose}"}

    // Retrofit
    val retrofit2 by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}"}
    val converter_gson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"}
    val squareup_okhttp3 by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp}"}
    val logging_interceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"}

    // Coroutine Lifecycle Scopes
    val lifecycle_viewmodel_ktx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_viewmodel_ktx}"}
    val lifecycle_runtime_ktx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_viewmodel_ktx}"}

    // Coroutines
    val kotlinx_coroutines_core by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinx_coroutines_core}"}
    val kotlinx_coroutines_android by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinx_coroutines_core}"}

    // Compose dependencies
    val lifecycle_viewmodel_compose by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle_viewmodel_compose}"}
    val navigation_compose by lazy { "androidx.navigation:navigation-compose:${Versions.navigation_compose}"}
    val accompanist_flowlayout by lazy { "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist_flowlayout}"}
}