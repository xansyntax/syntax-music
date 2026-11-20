package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformTypefacesApi28 implements PlatformTypefaces {
    /* JADX INFO: renamed from: createAndroidTypefaceApi28-RetOiIg, reason: not valid java name */
    public static Typeface m757createAndroidTypefaceApi28RetOiIg(String str, FontWeight fontWeight, int i) {
        if (i == 0 && Intrinsics.areEqual(fontWeight, FontWeight.Normal) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT;
        }
        if (i == 0 && Intrinsics.areEqual(fontWeight, FontWeight.Bold) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT_BOLD;
        }
        return Typeface.create(str == null ? Typeface.DEFAULT : Typeface.create(str, 0), fontWeight.weight, i == 1);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createDefault-FO1MlWM */
    public final Typeface mo755createDefaultFO1MlWM(FontWeight fontWeight, int i) {
        return m757createAndroidTypefaceApi28RetOiIg(null, fontWeight, i);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createNamed-RetOiIg */
    public final Typeface mo756createNamedRetOiIg(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i) {
        return m757createAndroidTypefaceApi28RetOiIg(genericFontFamily.name, fontWeight, i);
    }
}
