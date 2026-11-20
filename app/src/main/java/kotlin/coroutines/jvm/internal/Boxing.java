package kotlin.coroutines.jvm.internal;

import androidx.navigation.NavDeepLinkRequest;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Boxing {
    public static NavDeepLinkRequest cache;
    public static final NavDeepLinkRequest notOnJava9;

    static {
        Object obj = null;
        notOnJava9 = new NavDeepLinkRequest(obj, obj, obj, (byte) 8);
    }

    public static final Integer boxInt(int i) {
        return new Integer(i);
    }

    public static final void boxLong(long j) {
        new Long(j);
    }
}
