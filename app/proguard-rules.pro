
# Keep Media3 & MediaSession for System Media Controls (QS / Lockscreen Widget)
-keep class androidx.media3.session.** { *; }
-keep class androidx.media3.exoplayer.** { *; }
-keep class androidx.media3.common.** { *; }
-keep class androidx.media.app.NotificationCompat$MediaStyle { *; }
-keep class android.support.v4.media.** { *; }
-keepclassmembers class * extends androidx.media3.session.MediaSessionService {
    public *;
}
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod


# Syntax Music R8/ProGuard Keep Rules
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod
-keep class com.metrolist.music.BuildConfig { *; }
-keep class com.metrolist.innertube.** { *; }
-keep class com.metrolist.kugou.** { *; }
-keep class com.metrolist.lrclib.** { *; }
-keepclassmembers class * {
    @kotlinx.serialization.Serializable <fields>;
}
-keep,includedescriptorclasses class com.metrolist.music.**$$serializer { *; }
-keepclassmembers class com.metrolist.music.** {
    *** Companion;
}
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn org.conscrypt.**
-dontwarn org.bouncycastle.**
-dontwarn org.openjsse.**
-dontwarn javax.annotation.**


-keepnames class kotlinx.coroutines.android.AndroidDispatcherFactory
-keepnames class kotlinx.coroutines.android.AndroidExceptionPreHandler
-dontwarn kotlinx.coroutines.**
