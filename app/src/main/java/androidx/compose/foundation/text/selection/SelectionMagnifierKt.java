package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3;
import androidx.compose.ui.geometry.Offset;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SelectionMagnifierKt {
    public static final SpringSpec MagnifierSpringSpec;
    public static final long OffsetDisplacementThreshold;
    public static final AnimationVector2D UnspecifiedAnimationVector2D = new AnimationVector2D(Float.NaN, Float.NaN);
    public static final TwoWayConverterImpl UnspecifiedSafeOffsetVectorConverter = new TwoWayConverterImpl(new ChipKt$$ExternalSyntheticLambda3((byte) 14), new ChipKt$$ExternalSyntheticLambda3((byte) 15));

    static {
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(0.01f)) << 32) | (((long) Float.floatToRawIntBits(0.01f)) & 4294967295L);
        OffsetDisplacementThreshold = jFloatToRawIntBits;
        MagnifierSpringSpec = new SpringSpec(3, new Offset(jFloatToRawIntBits));
    }
}
