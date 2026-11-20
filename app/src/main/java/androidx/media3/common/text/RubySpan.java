package androidx.media3.common.text;

import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RubySpan {
    public static final String FIELD_POSITION;
    public static final String FIELD_TEXT;
    public final int position;
    public final String rubyText;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_TEXT = Integer.toString(0, 36);
        FIELD_POSITION = Integer.toString(1, 36);
    }

    public RubySpan(String str, int i) {
        this.rubyText = str;
        this.position = i;
    }
}
