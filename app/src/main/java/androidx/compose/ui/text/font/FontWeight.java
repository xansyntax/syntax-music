package androidx.compose.ui.text.font;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FontWeight implements Comparable {
    public static final FontWeight Black;
    public static final FontWeight Bold;
    public static final FontWeight ExtraBold;
    public static final FontWeight Medium;
    public static final FontWeight Normal;
    public static final FontWeight SemiBold;
    public static final FontWeight W400;
    public static final FontWeight W500;
    public static final FontWeight W600;
    public final int weight;

    static {
        FontWeight fontWeight = new FontWeight(100);
        FontWeight fontWeight2 = new FontWeight(200);
        FontWeight fontWeight3 = new FontWeight(300);
        FontWeight fontWeight4 = new FontWeight(400);
        W400 = fontWeight4;
        FontWeight fontWeight5 = new FontWeight(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
        W500 = fontWeight5;
        FontWeight fontWeight6 = new FontWeight(600);
        W600 = fontWeight6;
        FontWeight fontWeight7 = new FontWeight(700);
        FontWeight fontWeight8 = new FontWeight(800);
        FontWeight fontWeight9 = new FontWeight(900);
        Normal = fontWeight4;
        Medium = fontWeight5;
        SemiBold = fontWeight6;
        Bold = fontWeight7;
        ExtraBold = fontWeight8;
        Black = fontWeight9;
        CollectionsKt__IterablesKt.listOf((Object[]) new FontWeight[]{fontWeight, fontWeight2, fontWeight3, fontWeight4, fontWeight5, fontWeight6, fontWeight7, fontWeight8, fontWeight9});
    }

    public FontWeight(int i) {
        this.weight = i;
        boolean z = false;
        if (1 <= i && i < 1001) {
            z = true;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Font weight can be in range [1, 1000]. Current value: " + i);
    }

    @Override // java.lang.Comparable
    public final int compareTo(FontWeight fontWeight) {
        return Intrinsics.compare(this.weight, fontWeight.weight);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FontWeight) {
            return this.weight == ((FontWeight) obj).weight;
        }
        return false;
    }

    public final int hashCode() {
        return this.weight;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.weight, "FontWeight(weight=", ")");
    }
}
