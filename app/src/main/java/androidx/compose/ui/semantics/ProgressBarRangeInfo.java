package androidx.compose.ui.semantics;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatRange;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ProgressBarRangeInfo {
    public static final ProgressBarRangeInfo Indeterminate = new ProgressBarRangeInfo(CropImageView.DEFAULT_ASPECT_RATIO, new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO), 0);
    public final float current;
    public final ClosedFloatRange range;
    public final int steps;

    public ProgressBarRangeInfo(float f, ClosedFloatRange closedFloatRange, int i) {
        this.current = f;
        this.range = closedFloatRange;
        this.steps = i;
        if (Float.isNaN(f)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("current must not be NaN");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressBarRangeInfo)) {
            return false;
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) obj;
        return this.current == progressBarRangeInfo.current && Intrinsics.areEqual(this.range, progressBarRangeInfo.range) && this.steps == progressBarRangeInfo.steps;
    }

    public final int hashCode() {
        return ((this.range.hashCode() + (Float.hashCode(this.current) * 31)) * 31) + this.steps;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ProgressBarRangeInfo(current=");
        sb.append(this.current);
        sb.append(", range=");
        sb.append(this.range);
        sb.append(", steps=");
        return Fragment$5$$ExternalSyntheticOutline0.m(sb, this.steps, ")");
    }
}
