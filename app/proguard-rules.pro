
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
