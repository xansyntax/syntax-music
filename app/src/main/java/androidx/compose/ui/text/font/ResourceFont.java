package androidx.compose.ui.text.font;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ResourceFont {
    public final int resId;
    public final boolean style;
    public final FontVariation.Settings variationSettings;
    public final FontWeight weight;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceFont(int i, FontWeight fontWeight, int i2, FontVariation.Settings settings) {
        this.resId = i;
        this.weight = fontWeight;
        this.style = i2;
        this.variationSettings = settings;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourceFont)) {
            return false;
        }
        ResourceFont resourceFont = (ResourceFont) obj;
        return this.resId == resourceFont.resId && Intrinsics.areEqual(this.weight, resourceFont.weight) && this.style == resourceFont.style && this.variationSettings.equals(resourceFont.variationSettings);
    }

    public final int hashCode() {
        return this.variationSettings.settings.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(0, IntIntPair$$ExternalSyntheticOutline0.m(this.style ? 1 : 0, ((this.resId * 31) + this.weight.weight) * 31, 31), 31);
    }

    public final String toString() {
        String str;
        boolean z = this.style;
        if (z) {
            str = z ? "Italic" : "Invalid";
        } else {
            str = "Normal";
        }
        StringBuilder sb = new StringBuilder("ResourceFont(resId=");
        sb.append(this.resId);
        sb.append(", weight=");
        sb.append(this.weight);
        sb.append(", style=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, str, ", loadingStrategy=Blocking)");
    }
}
