package androidx.media3.common.text;

import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceSpan {
    public static final String FIELD_NAME;
    public final String name;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_NAME = Integer.toString(0, 36);
    }

    public VoiceSpan(String str) {
        this.name = str;
    }
}
