package androidx.media3.container;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.decoder.Buffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Mp4Box$LeafBox extends Buffer {
    public final ParsableByteArray data;

    public Mp4Box$LeafBox(int i, ParsableByteArray parsableByteArray) {
        super((byte) 1, i);
        this.data = parsableByteArray;
    }
}
