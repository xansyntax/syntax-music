package androidx.compose.ui.text.font;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GenericFontFamily extends SystemFontFamily {
    public final String fontFamilyName;
    public final String name;

    public GenericFontFamily(String str, String str2) {
        this.name = str;
        this.fontFamilyName = str2;
    }

    public final String toString() {
        return this.fontFamilyName;
    }
}
