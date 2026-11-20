package androidx.compose.material3.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawModifierNodeImpl;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/material3/internal/DeterminateLinearWavyProgressElement;", "Landroidx/compose/material3/internal/BaseLinearWavyProgressElement;", "Landroidx/compose/material3/internal/DeterminateLinearWavyProgressNode;", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DeterminateLinearWavyProgressElement extends BaseLinearWavyProgressElement<DeterminateLinearWavyProgressNode> {
    public final Function1 amplitude;
    public final long color;
    public final float gapSize;
    public final Function0 progress;
    public final float stopSize;
    public final Stroke stroke;
    public final long trackColor;
    public final Stroke trackStroke;
    public final float waveSpeed;
    public final float wavelength;

    public DeterminateLinearWavyProgressElement(float f, float f2, float f3, float f4, long j, long j2, Stroke stroke, Stroke stroke2, Function0 function0, Function1 function1) {
        this.progress = function0;
        this.amplitude = function1;
        this.color = j;
        this.trackColor = j2;
        this.stroke = stroke;
        this.trackStroke = stroke2;
        this.gapSize = f;
        this.stopSize = f2;
        this.wavelength = f3;
        this.waveSpeed = f4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new DeterminateLinearWavyProgressNode(this.stopSize, this.gapSize, this.wavelength, this.waveSpeed, this.color, this.trackColor, this.stroke, this.trackStroke, this.progress, this.amplitude);
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement
    public final boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof DeterminateLinearWavyProgressElement)) {
            return false;
        }
        DeterminateLinearWavyProgressElement determinateLinearWavyProgressElement = (DeterminateLinearWavyProgressElement) obj;
        return Dp.m796equalsimpl0(this.stopSize, determinateLinearWavyProgressElement.stopSize) && this.progress == determinateLinearWavyProgressElement.progress && this.amplitude == determinateLinearWavyProgressElement.amplitude;
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressElement
    public final int hashCode() {
        return this.amplitude.hashCode() + ((this.progress.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.stopSize, super.hashCode() * 31, 31)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        DeterminateLinearWavyProgressNode determinateLinearWavyProgressNode = (DeterminateLinearWavyProgressNode) node;
        long j = determinateLinearWavyProgressNode.color;
        CacheDrawModifierNodeImpl cacheDrawModifierNodeImpl = determinateLinearWavyProgressNode.cacheDrawNodeDelegate;
        long j2 = this.color;
        if (!ULong.m1869equalsimpl0(j, j2)) {
            determinateLinearWavyProgressNode.color = j2;
            HitTestResultKt.invalidateDraw(cacheDrawModifierNodeImpl);
        }
        long j3 = determinateLinearWavyProgressNode.trackColor;
        long j4 = this.trackColor;
        if (!ULong.m1869equalsimpl0(j3, j4)) {
            determinateLinearWavyProgressNode.trackColor = j4;
            HitTestResultKt.invalidateDraw(cacheDrawModifierNodeImpl);
        }
        Stroke stroke = determinateLinearWavyProgressNode.stroke;
        Stroke stroke2 = this.stroke;
        if (!Intrinsics.areEqual(stroke, stroke2)) {
            determinateLinearWavyProgressNode.stroke = stroke2;
            cacheDrawModifierNodeImpl.invalidateDrawCache();
        }
        Stroke stroke3 = determinateLinearWavyProgressNode.trackStroke;
        Stroke stroke4 = this.trackStroke;
        if (!Intrinsics.areEqual(stroke3, stroke4)) {
            determinateLinearWavyProgressNode.trackStroke = stroke4;
            cacheDrawModifierNodeImpl.invalidateDrawCache();
        }
        float f = determinateLinearWavyProgressNode.gapSize;
        float f2 = this.gapSize;
        if (!Dp.m796equalsimpl0(f, f2)) {
            determinateLinearWavyProgressNode.gapSize = f2;
            cacheDrawModifierNodeImpl.invalidateDrawCache();
        }
        float f3 = determinateLinearWavyProgressNode.wavelength;
        float f4 = this.wavelength;
        if (!Dp.m796equalsimpl0(f3, f4)) {
            determinateLinearWavyProgressNode.wavelength = f4;
            determinateLinearWavyProgressNode.updateOffsetAnimation();
            cacheDrawModifierNodeImpl.invalidateDrawCache();
        }
        float f5 = determinateLinearWavyProgressNode.waveSpeed;
        float f6 = this.waveSpeed;
        if (!Dp.m796equalsimpl0(f5, f6)) {
            determinateLinearWavyProgressNode.waveSpeed = f6;
            determinateLinearWavyProgressNode.updateOffsetAnimation();
            cacheDrawModifierNodeImpl.invalidateDrawCache();
        }
        float f7 = determinateLinearWavyProgressNode.stopSize;
        float f8 = this.stopSize;
        if (!Dp.m796equalsimpl0(f7, f8)) {
            determinateLinearWavyProgressNode.stopSize = f8;
            HitTestResultKt.invalidateDraw(cacheDrawModifierNodeImpl);
        }
        Function0 function0 = determinateLinearWavyProgressNode.progress;
        Function1 function1 = this.amplitude;
        Function0 function2 = this.progress;
        if (function0 == function2 && determinateLinearWavyProgressNode.amplitude == function1) {
            return;
        }
        determinateLinearWavyProgressNode.progress = function2;
        determinateLinearWavyProgressNode.amplitude = function1;
        cacheDrawModifierNodeImpl.invalidateDrawCache();
    }
}
