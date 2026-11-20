package androidx.compose.ui.text.style;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LineHeightStyle {
    public static final LineHeightStyle Default;
    public final float alignment;
    public final int mode;
    public final int trim;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Alignment {
        public final float topRatio;

        public /* synthetic */ Alignment(float f) {
            this.topRatio = f;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static void m771constructorimpl(float f) {
            if ((CropImageView.DEFAULT_ASPECT_RATIO > f || f > 1.0f) && f != -1.0f) {
                InlineClassHelperKt.throwIllegalStateException("topRatio should be in [0..1] range or -1");
            }
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m772toStringimpl(float f) {
            m771constructorimpl(CropImageView.DEFAULT_ASPECT_RATIO);
            if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
                return "LineHeightStyle.Alignment.Top";
            }
            m771constructorimpl(0.5f);
            if (f == 0.5f) {
                return "LineHeightStyle.Alignment.Center";
            }
            m771constructorimpl(-1.0f);
            if (f == -1.0f) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            m771constructorimpl(1.0f);
            return f == 1.0f ? "LineHeightStyle.Alignment.Bottom" : IntIntPair$$ExternalSyntheticOutline0.m("LineHeightStyle.Alignment(topPercentage = ", f, ")");
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Alignment) {
                return Float.compare(this.topRatio, ((Alignment) obj).topRatio) == 0;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.topRatio);
        }

        public final String toString() {
            return m772toStringimpl(this.topRatio);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Mode {
        public final int value;

        public /* synthetic */ Mode(int i) {
            this.value = i;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Mode) {
                return this.value == ((Mode) obj).value;
            }
            return false;
        }

        public final int hashCode() {
            return Integer.hashCode(this.value);
        }

        public final String toString() {
            int i = this.value;
            if (i == 0) {
                return "LineHeightStyle.Mode.Fixed";
            }
            if (i == 1) {
                return "LineHeightStyle.Mode.Minimum";
            }
            return i == 2 ? "LineHeightStyle.Mode.Tight" : "Invalid";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Trim {
        public final int value;

        public /* synthetic */ Trim(int i) {
            this.value = i;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Trim) {
                return this.value == ((Trim) obj).value;
            }
            return false;
        }

        public final int hashCode() {
            return Integer.hashCode(this.value);
        }

        public final String toString() {
            int i = this.value;
            if (i == 1) {
                return "LineHeightStyle.Trim.FirstLineTop";
            }
            if (i == 16) {
                return "LineHeightStyle.Trim.LastLineBottom";
            }
            if (i == 17) {
                return "LineHeightStyle.Trim.Both";
            }
            return i == 0 ? "LineHeightStyle.Trim.None" : "Invalid";
        }
    }

    static {
        Alignment.m771constructorimpl(-1.0f);
        Default = new LineHeightStyle(-1.0f, 17, 0);
    }

    public LineHeightStyle(float f, int i, int i2) {
        this.alignment = f;
        this.trim = i;
        this.mode = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) obj;
        return Float.compare(this.alignment, lineHeightStyle.alignment) == 0 && this.trim == lineHeightStyle.trim && this.mode == lineHeightStyle.mode;
    }

    public final int hashCode() {
        return Integer.hashCode(this.mode) + IntIntPair$$ExternalSyntheticOutline0.m(this.trim, Float.hashCode(this.alignment) * 31, 31);
    }

    public final String toString() {
        String str;
        String strM772toStringimpl = Alignment.m772toStringimpl(this.alignment);
        String str2 = "Invalid";
        int i = this.trim;
        if (i == 1) {
            str = "LineHeightStyle.Trim.FirstLineTop";
        } else if (i == 16) {
            str = "LineHeightStyle.Trim.LastLineBottom";
        } else if (i == 17) {
            str = "LineHeightStyle.Trim.Both";
        } else {
            str = i == 0 ? "LineHeightStyle.Trim.None" : "Invalid";
        }
        int i2 = this.mode;
        if (i2 == 0) {
            str2 = "LineHeightStyle.Mode.Fixed";
        } else if (i2 == 1) {
            str2 = "LineHeightStyle.Mode.Minimum";
        } else if (i2 == 2) {
            str2 = "LineHeightStyle.Mode.Tight";
        }
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("LineHeightStyle(alignment=", strM772toStringimpl, ", trim=", str, ",mode="), str2, ")");
    }
}
