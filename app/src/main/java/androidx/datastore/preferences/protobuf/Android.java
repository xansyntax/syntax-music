package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Android {
    public static final boolean IS_ROBOLECTRIC;
    public static final Class MEMORY_CLASS;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        MEMORY_CLASS = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        IS_ROBOLECTRIC = cls2 != null;
    }

    public static boolean isOnAndroidDevice() {
        return (MEMORY_CLASS == null || IS_ROBOLECTRIC) ? false : true;
    }
}
