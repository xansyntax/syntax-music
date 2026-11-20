package androidx.compose.foundation;

import androidx.collection.internal.Lock;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollNode extends Modifier.Node implements LayoutModifierNode, SemanticsModifierNode {
    public boolean isVertical;
    public ScrollState state;

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver);
        final byte b = 0;
        final byte b2 = 1;
        ScrollAxisRange scrollAxisRange = new ScrollAxisRange(new Function0(this) { // from class: androidx.compose.foundation.ScrollNode$$ExternalSyntheticLambda0
            public final /* synthetic */ ScrollNode f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int intValue;
                byte b3 = b;
                ScrollNode scrollNode = this.f$0;
                switch (b3) {
                    case 0:
                        intValue = scrollNode.state.value$delegate.getIntValue();
                        break;
                    default:
                        intValue = scrollNode.state._maxValueState.getIntValue();
                        break;
                }
                return Float.valueOf(intValue);
            }
        }, new Function0(this) { // from class: androidx.compose.foundation.ScrollNode$$ExternalSyntheticLambda0
            public final /* synthetic */ ScrollNode f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int intValue;
                byte b3 = b2;
                ScrollNode scrollNode = this.f$0;
                switch (b3) {
                    case 0:
                        intValue = scrollNode.state.value$delegate.getIntValue();
                        break;
                    default:
                        intValue = scrollNode.state._maxValueState.getIntValue();
                        break;
                }
                return Float.valueOf(intValue);
            }
        });
        if (this.isVertical) {
            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.VerticalScrollAxisRange;
            KProperty kProperty = SemanticsPropertiesKt.$$delegatedProperties[14];
            semanticsPropertyKey.getClass();
            semanticsPropertyReceiver.set(semanticsPropertyKey, scrollAxisRange);
            return;
        }
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.HorizontalScrollAxisRange;
        KProperty kProperty2 = SemanticsPropertiesKt.$$delegatedProperties[13];
        semanticsPropertyKey2.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey2, scrollAxisRange);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!this.isVertical) {
            i = Integer.MAX_VALUE;
        }
        return measurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (this.isVertical) {
            i = Integer.MAX_VALUE;
        }
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        ImageKt.m44checkScrollableContainerConstraintsK40F9xA(j, this.isVertical ? Orientation.Vertical : Orientation.Horizontal);
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, this.isVertical ? Constraints.m784getMaxWidthimpl(j) : Integer.MAX_VALUE, 0, this.isVertical ? Integer.MAX_VALUE : Constraints.m783getMaxHeightimpl(j), 5, j));
        int i = placeableMo598measureBRTryo0.width;
        int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
        if (i > iM784getMaxWidthimpl) {
            i = iM784getMaxWidthimpl;
        }
        int i2 = placeableMo598measureBRTryo0.height;
        int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
        if (i2 > iM783getMaxHeightimpl) {
            i2 = iM783getMaxHeightimpl;
        }
        int i3 = placeableMo598measureBRTryo0.height - i2;
        int i4 = placeableMo598measureBRTryo0.width - i;
        if (!this.isVertical) {
            i3 = i4;
        }
        ScrollState scrollState = this.state;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = scrollState._maxValueState;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = scrollState.value$delegate;
        parcelableSnapshotMutableIntState.setIntValue(i3);
        Snapshot currentThreadSnapshot = Lock.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = Lock.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (parcelableSnapshotMutableIntState2.getIntValue() > i3) {
                parcelableSnapshotMutableIntState2.setIntValue(i3);
            }
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            this.state.viewportSize$delegate.setIntValue(this.isVertical ? i2 : i);
            this.state.contentSize$delegate.setIntValue(this.isVertical ? placeableMo598measureBRTryo0.height : placeableMo598measureBRTryo0.width);
            this.state.reverseScrolling$delegate.setValue(Boolean.FALSE);
            return measureScope.layout(i, i2, EmptyMap.INSTANCE, new ScrollNode$$ExternalSyntheticLambda2((Object) this, i3, (Object) placeableMo598measureBRTryo0, (byte) 0));
        } catch (Throwable th) {
            Lock.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (!this.isVertical) {
            i = Integer.MAX_VALUE;
        }
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        if (this.isVertical) {
            i = Integer.MAX_VALUE;
        }
        return measurable.minIntrinsicWidth(i);
    }
}
