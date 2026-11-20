package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.core.graphics.TypefaceCompat$$ExternalSyntheticApiModelOutline1;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BlendModeColorFilter {
    public final int blendMode;
    public final long color;
    public final ColorFilter nativeColorFilter;

    public BlendModeColorFilter(long j, int i) {
        ColorFilter porterDuffColorFilter;
        if (Build.VERSION.SDK_INT >= 29) {
            TypefaceCompat$$ExternalSyntheticApiModelOutline1.m828m();
            porterDuffColorFilter = TypefaceCompat$$ExternalSyntheticApiModelOutline1.m(ColorKt.m498toArgb8_81llA(j), CanvasZHelper.m476toAndroidBlendModes9anfk8(i));
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(ColorKt.m498toArgb8_81llA(j), CanvasZHelper.m477toPorterDuffModes9anfk8(i));
        }
        this.nativeColorFilter = porterDuffColorFilter;
        this.color = j;
        this.blendMode = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlendModeColorFilter)) {
            return false;
        }
        BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) obj;
        return ULong.m1869equalsimpl0(this.color, blendModeColorFilter.color) && this.blendMode == blendModeColorFilter.blendMode;
    }

    public final int hashCode() {
        return Integer.hashCode(this.blendMode) + (Long.hashCode(this.color) * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("BlendModeColorFilter(color=", Color.m486toStringimpl(this.color), ", blendMode=", ColorKt.m501toStringimpl(this.blendMode), ")");
    }
}
