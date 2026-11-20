package androidx.media3.extractor.avi;

import androidx.media3.common.Format;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StreamFormatChunk implements AviChunk {
    public final Format format;

    public StreamFormatChunk(Format format) {
        this.format = format;
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public final int getType() {
        return 1718776947;
    }
}
