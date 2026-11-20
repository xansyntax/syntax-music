package androidx.compose.ui.text;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformParagraphStyle {
    public static final PlatformParagraphStyle Default = new PlatformParagraphStyle(0, false);
    public final int emojiSupportMatch;
    public final boolean includeFontPadding;

    public PlatformParagraphStyle() {
        this.includeFontPadding = false;
        this.emojiSupportMatch = 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformParagraphStyle)) {
            return false;
        }
        PlatformParagraphStyle platformParagraphStyle = (PlatformParagraphStyle) obj;
        return this.includeFontPadding == platformParagraphStyle.includeFontPadding && this.emojiSupportMatch == platformParagraphStyle.emojiSupportMatch;
    }

    public final int hashCode() {
        return Integer.hashCode(this.emojiSupportMatch) + (Boolean.hashCode(this.includeFontPadding) * 31);
    }

    public final String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.includeFontPadding + ", emojiSupportMatch=" + EmojiSupportMatch.m727toStringimpl(this.emojiSupportMatch) + ")";
    }

    public PlatformParagraphStyle(int i, boolean z) {
        this.includeFontPadding = z;
        this.emojiSupportMatch = i;
    }
}
