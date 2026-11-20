package androidx.compose.material3.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.internal.DeterminateLinearWavyProgressNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\"\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/material3/internal/BaseLinearWavyProgressElement;", "Landroidx/compose/material3/internal/DeterminateLinearWavyProgressNode;", "N", "Landroidx/compose/ui/node/ModifierNodeElement;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
abstract class BaseLinearWavyProgressElement<N extends DeterminateLinearWavyProgressNode> extends ModifierNodeElement {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseLinearWavyProgressElement)) {
            return false;
        }
        DeterminateLinearWavyProgressElement determinateLinearWavyProgressElement = (DeterminateLinearWavyProgressElement) this;
        DeterminateLinearWavyProgressElement determinateLinearWavyProgressElement2 = (DeterminateLinearWavyProgressElement) ((BaseLinearWavyProgressElement) obj);
        return ULong.m1869equalsimpl0(determinateLinearWavyProgressElement.color, determinateLinearWavyProgressElement2.color) && ULong.m1869equalsimpl0(determinateLinearWavyProgressElement.trackColor, determinateLinearWavyProgressElement2.trackColor) && Intrinsics.areEqual(determinateLinearWavyProgressElement.stroke, determinateLinearWavyProgressElement2.stroke) && Intrinsics.areEqual(determinateLinearWavyProgressElement.trackStroke, determinateLinearWavyProgressElement2.trackStroke) && Dp.m796equalsimpl0(determinateLinearWavyProgressElement.gapSize, determinateLinearWavyProgressElement2.gapSize) && Dp.m796equalsimpl0(determinateLinearWavyProgressElement.wavelength, determinateLinearWavyProgressElement2.wavelength) && Dp.m796equalsimpl0(determinateLinearWavyProgressElement.waveSpeed, determinateLinearWavyProgressElement2.waveSpeed);
    }

    public int hashCode() {
        DeterminateLinearWavyProgressElement determinateLinearWavyProgressElement = (DeterminateLinearWavyProgressElement) this;
        return Float.hashCode(determinateLinearWavyProgressElement.waveSpeed) + IntIntPair$$ExternalSyntheticOutline0.m(determinateLinearWavyProgressElement.wavelength, IntIntPair$$ExternalSyntheticOutline0.m(determinateLinearWavyProgressElement.gapSize, (determinateLinearWavyProgressElement.trackStroke.hashCode() + ((determinateLinearWavyProgressElement.stroke.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(Long.hashCode(determinateLinearWavyProgressElement.color) * 31, 31, determinateLinearWavyProgressElement.trackColor)) * 31)) * 31, 31), 31);
    }
}
