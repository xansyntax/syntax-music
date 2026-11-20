package androidx.compose.ui.draw;

import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.size.SizeKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CacheDrawModifierNodeImpl extends Modifier.Node implements ObserverModifierNode, BuildDrawCacheParams, DrawModifierNode {
    public Function1 block;
    public final CacheDrawScope cacheDrawScope;
    public boolean isCacheValid;

    public CacheDrawModifierNodeImpl(CacheDrawScope cacheDrawScope, Function1 function1) {
        this.cacheDrawScope = cacheDrawScope;
        this.block = function1;
        cacheDrawScope.cacheParams = this;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        boolean z = this.isCacheValid;
        CacheDrawScope cacheDrawScope = this.cacheDrawScope;
        if (!z) {
            cacheDrawScope.drawResult = null;
            HitTestResultKt.observeReads(this, new Recomposer$$ExternalSyntheticLambda6((Object) this, (Object) cacheDrawScope, (byte) 25));
            if (cacheDrawScope.drawResult == null) {
                throw Fragment$5$$ExternalSyntheticOutline0.m$2("DrawResult not defined, did you forget to call onDraw?");
            }
            this.isCacheValid = true;
        }
        DrawResult drawResult = cacheDrawScope.drawResult;
        drawResult.getClass();
        ((Function1) drawResult.block).invoke(layoutNodeDrawScope);
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public final Density getDensity() {
        return HitTestResultKt.requireLayoutNode(this).density;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public final LayoutDirection getLayoutDirection() {
        return HitTestResultKt.requireLayoutNode(this).layoutDirection;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    /* JADX INFO: renamed from: getSize-NH-jbRc */
    public final long mo398getSizeNHjbRc() {
        return SizeKt.m876toSizeozmzZPI(HitTestResultKt.m646requireCoordinator64DMado(this, 4).measuredSize);
    }

    public final void invalidateDrawCache() {
        this.isCacheValid = false;
        this.cacheDrawScope.drawResult = null;
        HitTestResultKt.invalidateDraw(this);
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public final void onDensityChange() {
        invalidateDrawCache();
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public final void onLayoutDirectionChange() {
        invalidateDrawCache();
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void onMeasureResultChanged() {
        invalidateDrawCache();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        invalidateDrawCache();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        invalidateDrawCache();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
    }
}
