package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Alignment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ColumnKt {
    public static final ColumnMeasurePolicy DefaultColumnMeasurePolicy = new ColumnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start);

    public static final ColumnMeasurePolicy columnMeasurePolicy(Arrangement$Vertical arrangement$Vertical, Alignment.Horizontal horizontal, Composer composer, int i) {
        if (arrangement$Vertical.equals(OffsetKt.Top) && Intrinsics.areEqual(horizontal, Alignment.Companion.Start)) {
            GapComposer gapComposer = (GapComposer) composer;
            gapComposer.startReplaceGroup(-1446604504);
            gapComposer.end(false);
            return DefaultColumnMeasurePolicy;
        }
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startReplaceGroup(-1446550657);
        boolean z = true;
        boolean z2 = (((i & 14) ^ 6) > 4 && gapComposer2.changed(arrangement$Vertical)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !gapComposer2.changed(horizontal)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = gapComposer2.rememberedValue();
        if (z3 || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new ColumnMeasurePolicy(arrangement$Vertical, horizontal);
            gapComposer2.updateRememberedValue(objRememberedValue);
        }
        ColumnMeasurePolicy columnMeasurePolicy = (ColumnMeasurePolicy) objRememberedValue;
        gapComposer2.end(false);
        return columnMeasurePolicy;
    }
}
