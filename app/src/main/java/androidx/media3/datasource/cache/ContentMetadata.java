package androidx.media3.datasource.cache;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ContentMetadata {
    static long getContentLength(ContentMetadata contentMetadata) {
        byte[] bArr = (byte[]) ((DefaultContentMetadata) contentMetadata).metadata.get("exo_len");
        if (bArr != null) {
            return ByteBuffer.wrap(bArr).getLong();
        }
        return -1L;
    }
}
