package androidx.compose.foundation;

import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.layout.Arrangement$SpacingAlignmentCalculator;
import androidx.compose.material3.CheckboxStyle;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ConcurrentModificationException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MarqueeSpacing$Companion$$ExternalSyntheticLambda0 implements Easing, Arrangement$SpacingAlignmentCalculator, CheckboxStyle, CancellationHandle {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ MarqueeSpacing$Companion$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m52m() {
        throw new ConcurrentModificationException();
    }

    @Override // androidx.compose.foundation.layout.Arrangement$SpacingAlignmentCalculator
    public int align(int i, LayoutDirection layoutDirection) {
        return Math.round((1.0f + (layoutDirection == LayoutDirection.Ltr ? -1.0f : 1.0f)) * (i / 2.0f));
    }

    @Override // androidx.compose.runtime.CancellationHandle
    public void cancel() {
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float f) {
        return f;
    }
}
