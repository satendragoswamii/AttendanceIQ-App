# Proguard rules for AttendanceIQ App

# Keep WebView JavaScript interface
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# Keep app classes
-keep class com.attendanceiq.app.** { *; }
