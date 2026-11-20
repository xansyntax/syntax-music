package androidx.compose.ui.text.font;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontResolveInterceptor implements PlatformResolveInterceptor {
    public final int fontWeightAdjustment;

    public AndroidFontResolveInterceptor(int i) {
        this.fontWeightAdjustment = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AndroidFontResolveInterceptor) && this.fontWeightAdjustment == ((AndroidFontResolveInterceptor) obj).fontWeightAdjustment;
    }

    public final int hashCode() {
        return Integer.hashCode(this.fontWeightAdjustment);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.fontWeightAdjustment, "AndroidFontResolveInterceptor(fontWeightAdjustment=", ")");
    }
}
