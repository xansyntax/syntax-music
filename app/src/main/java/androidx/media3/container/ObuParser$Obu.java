package androidx.media3.container;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ObuParser$Obu {
    public final ByteBuffer payload;
    public final int type;

    public ObuParser$Obu(int i, ByteBuffer byteBuffer) {
        this.type = i;
        this.payload = byteBuffer;
    }
}
