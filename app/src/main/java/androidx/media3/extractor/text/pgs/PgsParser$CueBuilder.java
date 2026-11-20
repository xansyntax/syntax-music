package androidx.media3.extractor.text.pgs;

import androidx.media3.common.util.ParsableByteArray;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class PgsParser$CueBuilder {
    public int bitmapHeight;
    public int bitmapWidth;
    public int bitmapX;
    public int bitmapY;
    public boolean colorsSet;
    public int planeHeight;
    public int planeWidth;
    public final ParsableByteArray bitmapData = new ParsableByteArray();
    public final int[] colors = new int[256];
}
