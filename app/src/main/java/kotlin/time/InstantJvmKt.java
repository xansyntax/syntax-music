package kotlin.time;

import kotlin.internal.jdk8.JDK8PlatformImplementations$ReflectSdkVersion;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class InstantJvmKt {
    public static final Path.Companion systemClock;

    static {
        Integer num = JDK8PlatformImplementations$ReflectSdkVersion.sdkVersion;
        systemClock = num == null || num.intValue() >= 26 ? new Path.Companion((byte) 8) : new Path.Companion((byte) 9);
    }
}
