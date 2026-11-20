package androidx.compose.runtime.composer.gapbuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyInfo {
    public final int key;
    public final int location;
    public final int nodes;
    public final Object objectKey;

    public KeyInfo(Object obj, int i, int i2, int i3) {
        this.key = i;
        this.objectKey = obj;
        this.location = i2;
        this.nodes = i3;
    }
}
