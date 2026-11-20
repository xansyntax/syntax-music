package androidx.compose.ui.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.PlaceableResult;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OuterPlacementScope extends Placeable.PlacementScope {
    public final /* synthetic */ byte $r8$classId;
    public final Object owner;

    public /* synthetic */ OuterPlacementScope(byte b, Object obj) {
        this.$r8$classId = b;
        this.owner = obj;
    }

    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    public float current(VerticalRuler verticalRuler, float f) {
        Function1 function1;
        int iIndexOf;
        OwnerSnapshotObserver snapshotObserver;
        int iIndexOf2;
        switch (this.$r8$classId) {
            case 1:
                Function2 function2 = verticalRuler.calculate;
                if (function2 != null) {
                    return ((Number) function2.invoke(this, Float.valueOf(f))).floatValue();
                }
                LookaheadCapablePlaceable lookaheadCapablePlaceable = (LookaheadCapablePlaceable) this.owner;
                if (lookaheadCapablePlaceable.isPlacingForAlignment) {
                    return f;
                }
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = lookaheadCapablePlaceable;
                while (true) {
                    RulerTrackingMap rulerTrackingMap = ((LookaheadCapablePlaceable) ref$ObjectRef.element).rulerValues;
                    float f2 = Float.NaN;
                    float f3 = (rulerTrackingMap == null || (iIndexOf2 = ArraysKt.indexOf((VerticalRuler[]) rulerTrackingMap.rulers, verticalRuler)) < 0) ? Float.NaN : ((float[]) rulerTrackingMap.values)[iIndexOf2];
                    boolean zIsNaN = Float.isNaN(f3);
                    Object obj = ref$ObjectRef.element;
                    if (!zIsNaN) {
                        ((LookaheadCapablePlaceable) obj).addRulerReader(lookaheadCapablePlaceable.getLayoutNode(), verticalRuler);
                        return verticalRuler.calculateCoordinate$ui(f3, ((LookaheadCapablePlaceable) ref$ObjectRef.element).getCoordinates(), lookaheadCapablePlaceable.getCoordinates());
                    }
                    LookaheadCapablePlaceable lookaheadCapablePlaceable2 = (LookaheadCapablePlaceable) obj;
                    Function2 function3 = lookaheadCapablePlaceable2.rulerProvider;
                    if (function3 != null && (function1 = lookaheadCapablePlaceable2.providedRulers) != null && ((Boolean) function1.invoke(verticalRuler)).booleanValue()) {
                        LookaheadCapablePlaceable lookaheadCapablePlaceable3 = (LookaheadCapablePlaceable) ref$ObjectRef.element;
                        MutableScatterMap mutableScatterMap = lookaheadCapablePlaceable3.cachedRulerPlaceableResults;
                        if (mutableScatterMap == null) {
                            long[] jArr = ScatterMapKt.EmptyGroup;
                            mutableScatterMap = new MutableScatterMap();
                            lookaheadCapablePlaceable3.cachedRulerPlaceableResults = mutableScatterMap;
                        }
                        Object placeableResult = mutableScatterMap.get(verticalRuler);
                        if (placeableResult == null) {
                            placeableResult = new PlaceableResult(lookaheadCapablePlaceable3.getMeasureResult$ui(), lookaheadCapablePlaceable3, verticalRuler);
                            mutableScatterMap.set(verticalRuler, placeableResult);
                        }
                        PlaceableResult placeableResult2 = (PlaceableResult) placeableResult;
                        placeableResult2.result = lookaheadCapablePlaceable3.getMeasureResult$ui();
                        Owner owner = lookaheadCapablePlaceable.getLayoutNode().owner;
                        if (owner != null && (snapshotObserver = ((AndroidComposeView) owner).getSnapshotObserver()) != null) {
                            snapshotObserver.observer.observeReads(placeableResult2, LookaheadCapablePlaceable.onCommitAffectingSingleRuler, new GapComposer$$ExternalSyntheticLambda0(function3, ref$ObjectRef, verticalRuler, (byte) 10));
                        }
                        ((LookaheadCapablePlaceable) ref$ObjectRef.element).addRulerReader(lookaheadCapablePlaceable.getLayoutNode(), verticalRuler);
                        RulerTrackingMap rulerTrackingMap2 = ((LookaheadCapablePlaceable) ref$ObjectRef.element).rulerValues;
                        if (rulerTrackingMap2 != null && (iIndexOf = ArraysKt.indexOf((VerticalRuler[]) rulerTrackingMap2.rulers, verticalRuler)) >= 0) {
                            f2 = ((float[]) rulerTrackingMap2.values)[iIndexOf];
                        }
                        if (!Float.isNaN(f2)) {
                            return verticalRuler.calculateCoordinate$ui(f2, ((LookaheadCapablePlaceable) ref$ObjectRef.element).getCoordinates(), lookaheadCapablePlaceable.getCoordinates());
                        }
                    }
                    LookaheadCapablePlaceable parent = ((LookaheadCapablePlaceable) ref$ObjectRef.element).getParent();
                    if (parent == null) {
                        ((LookaheadCapablePlaceable) ref$ObjectRef.element).addRulerReader(lookaheadCapablePlaceable.getLayoutNode(), verticalRuler);
                        return f;
                    }
                    ref$ObjectRef.element = parent;
                }
                break;
            default:
                return f;
        }
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        byte b = this.$r8$classId;
        Object obj = this.owner;
        switch (b) {
            case 0:
                return ((AndroidComposeView) obj).getDensity().getDensity();
            default:
                return ((LookaheadCapablePlaceable) obj).getDensity();
        }
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        byte b = this.$r8$classId;
        Object obj = this.owner;
        switch (b) {
            case 0:
                return ((AndroidComposeView) obj).getDensity().getFontScale();
            default:
                return ((LookaheadCapablePlaceable) obj).getFontScale();
        }
    }

    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    public final LayoutDirection getParentLayoutDirection() {
        byte b = this.$r8$classId;
        Object obj = this.owner;
        switch (b) {
            case 0:
                return ((AndroidComposeView) obj).getLayoutDirection();
            default:
                return ((LookaheadCapablePlaceable) obj).getLayoutDirection();
        }
    }

    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    public final int getParentWidth() {
        byte b = this.$r8$classId;
        Object obj = this.owner;
        switch (b) {
            case 0:
                return ((AndroidComposeView) obj).getRoot().layoutDelegate.measurePassDelegate.width;
            default:
                return ((LookaheadCapablePlaceable) obj).getMeasuredWidth();
        }
    }
}
