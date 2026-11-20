package androidx.media3.common;

import androidx.media3.common.util.Util;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Label {
    public static final String FIELD_LANGUAGE_INDEX;
    public static final String FIELD_VALUE_INDEX;
    public final String language;
    public final String value;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_LANGUAGE_INDEX = Integer.toString(0, 36);
        FIELD_VALUE_INDEX = Integer.toString(1, 36);
    }

    public Label(String str, String str2) {
        this.language = Util.normalizeLanguageCode(str);
        this.value = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Label.class == obj.getClass()) {
            Label label = (Label) obj;
            if (Objects.equals(this.language, label.language) && Objects.equals(this.value, label.value)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.value.hashCode() * 31;
        String str = this.language;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
