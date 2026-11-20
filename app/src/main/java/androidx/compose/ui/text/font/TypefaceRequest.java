package androidx.compose.ui.text.font;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TypefaceRequest {
    public final FontFamily fontFamily;
    public final int fontStyle;
    public final int fontSynthesis;
    public final FontWeight fontWeight;
    public final Object resourceLoaderCacheKey;

    public TypefaceRequest(FontFamily fontFamily, FontWeight fontWeight, int i, int i2, Object obj) {
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.fontStyle = i;
        this.fontSynthesis = i2;
        this.resourceLoaderCacheKey = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypefaceRequest)) {
            return false;
        }
        TypefaceRequest typefaceRequest = (TypefaceRequest) obj;
        return Intrinsics.areEqual(this.fontFamily, typefaceRequest.fontFamily) && Intrinsics.areEqual(this.fontWeight, typefaceRequest.fontWeight) && this.fontStyle == typefaceRequest.fontStyle && this.fontSynthesis == typefaceRequest.fontSynthesis && Intrinsics.areEqual(this.resourceLoaderCacheKey, typefaceRequest.resourceLoaderCacheKey);
    }

    public final int hashCode() {
        FontFamily fontFamily = this.fontFamily;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(this.fontSynthesis, IntIntPair$$ExternalSyntheticOutline0.m(this.fontStyle, (((fontFamily == null ? 0 : fontFamily.hashCode()) * 31) + this.fontWeight.weight) * 31, 31), 31);
        Object obj = this.resourceLoaderCacheKey;
        return iM + (obj != null ? obj.hashCode() : 0);
    }

    public final String toString() {
        String str;
        String str2 = "Invalid";
        int i = this.fontStyle;
        if (i == 0) {
            str = "Normal";
        } else {
            str = i == 1 ? "Italic" : "Invalid";
        }
        int i2 = this.fontSynthesis;
        if (i2 == 0) {
            str2 = "None";
        } else if (i2 == 1) {
            str2 = "Weight";
        } else if (i2 == 2) {
            str2 = "Style";
        } else if (i2 == 65535) {
            str2 = "All";
        }
        StringBuilder sb = new StringBuilder("TypefaceRequest(fontFamily=");
        sb.append(this.fontFamily);
        sb.append(", fontWeight=");
        sb.append(this.fontWeight);
        sb.append(", fontStyle=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, str, ", fontSynthesis=", str2, ", resourceLoaderCacheKey=");
        sb.append(this.resourceLoaderCacheKey);
        sb.append(")");
        return sb.toString();
    }
}
