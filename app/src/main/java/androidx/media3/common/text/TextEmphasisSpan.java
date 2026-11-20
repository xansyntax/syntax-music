package androidx.media3.common.text;

import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextEmphasisSpan {
    public static final String FIELD_MARK_FILL;
    public static final String FIELD_MARK_SHAPE;
    public static final String FIELD_POSITION;
    public final int markFill;
    public final int markShape;
    public final int position;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_MARK_SHAPE = Integer.toString(0, 36);
        FIELD_MARK_FILL = Integer.toString(1, 36);
        FIELD_POSITION = Integer.toString(2, 36);
    }

    public TextEmphasisSpan(int i, int i2, int i3) {
        this.markShape = i;
        this.markFill = i2;
        this.position = i3;
    }
}
