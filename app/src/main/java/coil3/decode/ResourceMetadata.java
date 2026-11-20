package coil3.decode;

import com.google.common.math.IntMath;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ResourceMetadata extends IntMath {
    public final String packageName;
    public final int resId;

    public ResourceMetadata(String str, int i) {
        this.packageName = str;
        this.resId = i;
    }
}
