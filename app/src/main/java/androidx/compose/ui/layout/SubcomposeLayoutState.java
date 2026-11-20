package androidx.compose.ui.layout;

import androidx.collection.MutableScatterMap;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.navigation.NavGraphNavigator$$ExternalSyntheticLambda0;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SubcomposeLayoutState {
    public LayoutNodeSubcompositionsState _state;
    public final SubcomposeLayoutState$$ExternalSyntheticLambda0 setCompositionContext;
    public final SubcomposeLayoutState$$ExternalSyntheticLambda0 setMeasurePolicy;
    public final SubcomposeLayoutState$$ExternalSyntheticLambda0 setRoot;
    public final SubcomposeSlotReusePolicy slotReusePolicy;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface PausedPrecomposition {
        PrecomposedSlotHandle apply();

        void cancel();

        boolean isComplete();

        boolean resume(TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda10);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.layout.SubcomposeLayoutState$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.layout.SubcomposeLayoutState$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.layout.SubcomposeLayoutState$$ExternalSyntheticLambda0] */
    public SubcomposeLayoutState(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.slotReusePolicy = subcomposeSlotReusePolicy;
        final byte b = 0;
        this.setRoot = new Function2(this) { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$$ExternalSyntheticLambda0
            public final /* synthetic */ SubcomposeLayoutState f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                byte b2 = b;
                Unit unit = Unit.INSTANCE;
                SubcomposeLayoutState subcomposeLayoutState = this.f$0;
                switch (b2) {
                    case 0:
                        SubcomposeSlotReusePolicy subcomposeSlotReusePolicy2 = subcomposeLayoutState.slotReusePolicy;
                        LayoutNode layoutNode = (LayoutNode) obj;
                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = layoutNode.subcompositionsState;
                        if (layoutNodeSubcompositionsState == null) {
                            layoutNodeSubcompositionsState = new LayoutNodeSubcompositionsState(layoutNode, subcomposeSlotReusePolicy2);
                            layoutNode.subcompositionsState = layoutNodeSubcompositionsState;
                        }
                        subcomposeLayoutState._state = layoutNodeSubcompositionsState;
                        subcomposeLayoutState.getState().makeSureStateIsConsistent();
                        LayoutNodeSubcompositionsState state = subcomposeLayoutState.getState();
                        if (state.slotReusePolicy != subcomposeSlotReusePolicy2) {
                            state.slotReusePolicy = subcomposeSlotReusePolicy2;
                            state.markActiveNodesAsReused(false);
                            LayoutNode.requestRemeasure$ui$default(state.root, false, 7);
                        }
                        break;
                    case 1:
                        subcomposeLayoutState.getState().compositionContext = (CompositionContext) obj2;
                        break;
                    default:
                        final Function2 function2 = (Function2) obj2;
                        final LayoutNodeSubcompositionsState state2 = subcomposeLayoutState.getState();
                        final String str = state2.NoIntrinsicsMessage;
                        ((LayoutNode) obj).setMeasurePolicy(new LayoutNode.NoIntrinsicsMeasurePolicy(str) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
                                final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = state2;
                                LayoutNodeSubcompositionsState.Scope scope = layoutNodeSubcompositionsState2.scope;
                                scope.layoutDirection = measureScope.getLayoutDirection();
                                scope.density = measureScope.getDensity();
                                scope.fontScale = measureScope.getFontScale();
                                boolean zIsLookingAhead = measureScope.isLookingAhead();
                                Function2 function3 = function2;
                                if (zIsLookingAhead || layoutNodeSubcompositionsState2.root.lookaheadRoot == null) {
                                    layoutNodeSubcompositionsState2.currentIndex = 0;
                                    final MeasureResult measureResult = (MeasureResult) function3.invoke(scope, new Constraints(j));
                                    final int i = layoutNodeSubcompositionsState2.currentIndex;
                                    final byte b3 = 1;
                                    return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Map getAlignmentLines() {
                                            switch (b3) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getAlignmentLines();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final int getHeight() {
                                            switch (b3) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getHeight();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Function2 getRulerProvider() {
                                            switch (b3) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getRulerProvider();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Function1 getRulers() {
                                            switch (b3) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getRulers();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final int getWidth() {
                                            switch (b3) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getWidth();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Function1 isRulerProvided() {
                                            switch (b3) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.isRulerProvided();
                                        }

                                        /* JADX WARN: Code duplicated, block: B:28:0x0089  */
                                        /* JADX WARN: Code duplicated, block: B:32:0x0095 A[DONT_INVERT] */
                                        /* JADX WARN: Code duplicated, block: B:33:0x0097 A[LOOP:0: B:11:0x002f->B:33:0x0097, LOOP_END] */
                                        /* JADX WARN: Code duplicated, block: B:36:0x009a A[SYNTHETIC] */
                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final void placeChildren() {
                                            byte b4 = b3;
                                            MeasureResult measureResult2 = measureResult;
                                            int i2 = i;
                                            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                                            switch (b4) {
                                                case 0:
                                                    layoutNodeSubcompositionsState3.currentApproachIndex = i2;
                                                    measureResult2.placeChildren();
                                                    MutableVector mutableVector = layoutNodeSubcompositionsState3.slotIdsOfCompositionsNeededInApproach;
                                                    MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState3.approachPrecomposeSlotHandleMap;
                                                    long[] jArr = mutableScatterMap.metadata;
                                                    int length = jArr.length - 2;
                                                    if (length >= 0) {
                                                        int i3 = 0;
                                                        while (true) {
                                                            long j2 = jArr[i3];
                                                            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                int i4 = 8;
                                                                int i5 = 8 - ((~(i3 - length)) >>> 31);
                                                                int i6 = 0;
                                                                while (i6 < i5) {
                                                                    if ((255 & j2) < 128) {
                                                                        int i7 = (i3 << 3) + i6;
                                                                        Object obj3 = mutableScatterMap.keys[i7];
                                                                        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i7];
                                                                        int iIndexOf = mutableVector.indexOf(obj3);
                                                                        if (iIndexOf < 0 || iIndexOf >= layoutNodeSubcompositionsState3.currentApproachIndex) {
                                                                            if (iIndexOf >= 0) {
                                                                                Object obj4 = RulerKt.UnspecifiedSlotId;
                                                                                Object[] objArr = mutableVector.content;
                                                                                Object obj5 = objArr[iIndexOf];
                                                                                objArr[iIndexOf] = obj4;
                                                                            }
                                                                            if (layoutNodeSubcompositionsState3.precomposeMap.contains(obj3)) {
                                                                                precomposedSlotHandle.dispose();
                                                                            }
                                                                            mutableScatterMap.removeValueAt(i7);
                                                                        } else {
                                                                            i4 = i4;
                                                                        }
                                                                    } else {
                                                                        i4 = i4;
                                                                    }
                                                                    j2 >>= i4;
                                                                    i6++;
                                                                    i4 = i4;
                                                                }
                                                                if (i5 == i4) {
                                                                    if (i3 != length) {
                                                                        i3++;
                                                                    }
                                                                }
                                                            } else if (i3 != length) {
                                                                i3++;
                                                            }
                                                        }
                                                    }
                                                    layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                    break;
                                                default:
                                                    layoutNodeSubcompositionsState3.currentIndex = i2;
                                                    measureResult2.placeChildren();
                                                    if (layoutNodeSubcompositionsState3.root.lookaheadRoot == null) {
                                                        layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                    }
                                                    break;
                                            }
                                        }
                                    };
                                }
                                layoutNodeSubcompositionsState2.currentApproachIndex = 0;
                                final MeasureResult measureResult2 = (MeasureResult) function3.invoke(layoutNodeSubcompositionsState2.approachMeasureScope, new Constraints(j));
                                final int i2 = layoutNodeSubcompositionsState2.currentApproachIndex;
                                final byte b4 = 0;
                                return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Map getAlignmentLines() {
                                        switch (b4) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getAlignmentLines();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final int getHeight() {
                                        switch (b4) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getHeight();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Function2 getRulerProvider() {
                                        switch (b4) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getRulerProvider();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Function1 getRulers() {
                                        switch (b4) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getRulers();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final int getWidth() {
                                        switch (b4) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getWidth();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Function1 isRulerProvided() {
                                        switch (b4) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.isRulerProvided();
                                    }

                                    /* JADX WARN: Code duplicated, block: B:28:0x0089  */
                                    /* JADX WARN: Code duplicated, block: B:32:0x0095 A[DONT_INVERT] */
                                    /* JADX WARN: Code duplicated, block: B:33:0x0097 A[LOOP:0: B:11:0x002f->B:33:0x0097, LOOP_END] */
                                    /* JADX WARN: Code duplicated, block: B:36:0x009a A[SYNTHETIC] */
                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final void placeChildren() {
                                        byte b5 = b4;
                                        MeasureResult measureResult3 = measureResult2;
                                        int i3 = i2;
                                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                                        switch (b5) {
                                            case 0:
                                                layoutNodeSubcompositionsState3.currentApproachIndex = i3;
                                                measureResult3.placeChildren();
                                                MutableVector mutableVector = layoutNodeSubcompositionsState3.slotIdsOfCompositionsNeededInApproach;
                                                MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState3.approachPrecomposeSlotHandleMap;
                                                long[] jArr = mutableScatterMap.metadata;
                                                int length = jArr.length - 2;
                                                if (length >= 0) {
                                                    int i4 = 0;
                                                    while (true) {
                                                        long j2 = jArr[i4];
                                                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            int i5 = 8;
                                                            int i6 = 8 - ((~(i4 - length)) >>> 31);
                                                            int i7 = 0;
                                                            while (i7 < i6) {
                                                                if ((255 & j2) < 128) {
                                                                    int i8 = (i4 << 3) + i7;
                                                                    Object obj3 = mutableScatterMap.keys[i8];
                                                                    SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i8];
                                                                    int iIndexOf = mutableVector.indexOf(obj3);
                                                                    if (iIndexOf < 0 || iIndexOf >= layoutNodeSubcompositionsState3.currentApproachIndex) {
                                                                        if (iIndexOf >= 0) {
                                                                            Object obj4 = RulerKt.UnspecifiedSlotId;
                                                                            Object[] objArr = mutableVector.content;
                                                                            Object obj5 = objArr[iIndexOf];
                                                                            objArr[iIndexOf] = obj4;
                                                                        }
                                                                        if (layoutNodeSubcompositionsState3.precomposeMap.contains(obj3)) {
                                                                            precomposedSlotHandle.dispose();
                                                                        }
                                                                        mutableScatterMap.removeValueAt(i8);
                                                                    } else {
                                                                        i5 = i5;
                                                                    }
                                                                } else {
                                                                    i5 = i5;
                                                                }
                                                                j2 >>= i5;
                                                                i7++;
                                                                i5 = i5;
                                                            }
                                                            if (i6 == i5) {
                                                                if (i4 != length) {
                                                                    i4++;
                                                                }
                                                            }
                                                        } else if (i4 != length) {
                                                            i4++;
                                                        }
                                                    }
                                                }
                                                layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                break;
                                            default:
                                                layoutNodeSubcompositionsState3.currentIndex = i3;
                                                measureResult3.placeChildren();
                                                if (layoutNodeSubcompositionsState3.root.lookaheadRoot == null) {
                                                    layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                }
                                                break;
                                        }
                                    }
                                };
                            }
                        });
                        break;
                }
                return unit;
            }
        };
        final byte b2 = 1;
        this.setCompositionContext = new Function2(this) { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$$ExternalSyntheticLambda0
            public final /* synthetic */ SubcomposeLayoutState f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                byte b3 = b2;
                Unit unit = Unit.INSTANCE;
                SubcomposeLayoutState subcomposeLayoutState = this.f$0;
                switch (b3) {
                    case 0:
                        SubcomposeSlotReusePolicy subcomposeSlotReusePolicy2 = subcomposeLayoutState.slotReusePolicy;
                        LayoutNode layoutNode = (LayoutNode) obj;
                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = layoutNode.subcompositionsState;
                        if (layoutNodeSubcompositionsState == null) {
                            layoutNodeSubcompositionsState = new LayoutNodeSubcompositionsState(layoutNode, subcomposeSlotReusePolicy2);
                            layoutNode.subcompositionsState = layoutNodeSubcompositionsState;
                        }
                        subcomposeLayoutState._state = layoutNodeSubcompositionsState;
                        subcomposeLayoutState.getState().makeSureStateIsConsistent();
                        LayoutNodeSubcompositionsState state = subcomposeLayoutState.getState();
                        if (state.slotReusePolicy != subcomposeSlotReusePolicy2) {
                            state.slotReusePolicy = subcomposeSlotReusePolicy2;
                            state.markActiveNodesAsReused(false);
                            LayoutNode.requestRemeasure$ui$default(state.root, false, 7);
                        }
                        break;
                    case 1:
                        subcomposeLayoutState.getState().compositionContext = (CompositionContext) obj2;
                        break;
                    default:
                        final Function2 function2 = (Function2) obj2;
                        final LayoutNodeSubcompositionsState state2 = subcomposeLayoutState.getState();
                        final String str = state2.NoIntrinsicsMessage;
                        ((LayoutNode) obj).setMeasurePolicy(new LayoutNode.NoIntrinsicsMeasurePolicy(str) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
                                final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = state2;
                                LayoutNodeSubcompositionsState.Scope scope = layoutNodeSubcompositionsState2.scope;
                                scope.layoutDirection = measureScope.getLayoutDirection();
                                scope.density = measureScope.getDensity();
                                scope.fontScale = measureScope.getFontScale();
                                boolean zIsLookingAhead = measureScope.isLookingAhead();
                                Function2 function3 = function2;
                                if (zIsLookingAhead || layoutNodeSubcompositionsState2.root.lookaheadRoot == null) {
                                    layoutNodeSubcompositionsState2.currentIndex = 0;
                                    final MeasureResult measureResult = (MeasureResult) function3.invoke(scope, new Constraints(j));
                                    final int i = layoutNodeSubcompositionsState2.currentIndex;
                                    final byte b4 = 1;
                                    return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Map getAlignmentLines() {
                                            switch (b4) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getAlignmentLines();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final int getHeight() {
                                            switch (b4) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getHeight();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Function2 getRulerProvider() {
                                            switch (b4) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getRulerProvider();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Function1 getRulers() {
                                            switch (b4) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getRulers();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final int getWidth() {
                                            switch (b4) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getWidth();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Function1 isRulerProvided() {
                                            switch (b4) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.isRulerProvided();
                                        }

                                        /* JADX WARN: Code duplicated, block: B:28:0x0089  */
                                        /* JADX WARN: Code duplicated, block: B:32:0x0095 A[DONT_INVERT] */
                                        /* JADX WARN: Code duplicated, block: B:33:0x0097 A[LOOP:0: B:11:0x002f->B:33:0x0097, LOOP_END] */
                                        /* JADX WARN: Code duplicated, block: B:36:0x009a A[SYNTHETIC] */
                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final void placeChildren() {
                                            byte b5 = b4;
                                            MeasureResult measureResult3 = measureResult;
                                            int i3 = i;
                                            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                                            switch (b5) {
                                                case 0:
                                                    layoutNodeSubcompositionsState3.currentApproachIndex = i3;
                                                    measureResult3.placeChildren();
                                                    MutableVector mutableVector = layoutNodeSubcompositionsState3.slotIdsOfCompositionsNeededInApproach;
                                                    MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState3.approachPrecomposeSlotHandleMap;
                                                    long[] jArr = mutableScatterMap.metadata;
                                                    int length = jArr.length - 2;
                                                    if (length >= 0) {
                                                        int i4 = 0;
                                                        while (true) {
                                                            long j2 = jArr[i4];
                                                            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                int i5 = 8;
                                                                int i6 = 8 - ((~(i4 - length)) >>> 31);
                                                                int i7 = 0;
                                                                while (i7 < i6) {
                                                                    if ((255 & j2) < 128) {
                                                                        int i8 = (i4 << 3) + i7;
                                                                        Object obj3 = mutableScatterMap.keys[i8];
                                                                        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i8];
                                                                        int iIndexOf = mutableVector.indexOf(obj3);
                                                                        if (iIndexOf < 0 || iIndexOf >= layoutNodeSubcompositionsState3.currentApproachIndex) {
                                                                            if (iIndexOf >= 0) {
                                                                                Object obj4 = RulerKt.UnspecifiedSlotId;
                                                                                Object[] objArr = mutableVector.content;
                                                                                Object obj5 = objArr[iIndexOf];
                                                                                objArr[iIndexOf] = obj4;
                                                                            }
                                                                            if (layoutNodeSubcompositionsState3.precomposeMap.contains(obj3)) {
                                                                                precomposedSlotHandle.dispose();
                                                                            }
                                                                            mutableScatterMap.removeValueAt(i8);
                                                                        } else {
                                                                            i5 = i5;
                                                                        }
                                                                    } else {
                                                                        i5 = i5;
                                                                    }
                                                                    j2 >>= i5;
                                                                    i7++;
                                                                    i5 = i5;
                                                                }
                                                                if (i6 == i5) {
                                                                    if (i4 != length) {
                                                                        i4++;
                                                                    }
                                                                }
                                                            } else if (i4 != length) {
                                                                i4++;
                                                            }
                                                        }
                                                    }
                                                    layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                    break;
                                                default:
                                                    layoutNodeSubcompositionsState3.currentIndex = i3;
                                                    measureResult3.placeChildren();
                                                    if (layoutNodeSubcompositionsState3.root.lookaheadRoot == null) {
                                                        layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                    }
                                                    break;
                                            }
                                        }
                                    };
                                }
                                layoutNodeSubcompositionsState2.currentApproachIndex = 0;
                                final MeasureResult measureResult2 = (MeasureResult) function3.invoke(layoutNodeSubcompositionsState2.approachMeasureScope, new Constraints(j));
                                final int i2 = layoutNodeSubcompositionsState2.currentApproachIndex;
                                final byte b5 = 0;
                                return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Map getAlignmentLines() {
                                        switch (b5) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getAlignmentLines();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final int getHeight() {
                                        switch (b5) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getHeight();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Function2 getRulerProvider() {
                                        switch (b5) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getRulerProvider();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Function1 getRulers() {
                                        switch (b5) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getRulers();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final int getWidth() {
                                        switch (b5) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getWidth();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Function1 isRulerProvided() {
                                        switch (b5) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.isRulerProvided();
                                    }

                                    /* JADX WARN: Code duplicated, block: B:28:0x0089  */
                                    /* JADX WARN: Code duplicated, block: B:32:0x0095 A[DONT_INVERT] */
                                    /* JADX WARN: Code duplicated, block: B:33:0x0097 A[LOOP:0: B:11:0x002f->B:33:0x0097, LOOP_END] */
                                    /* JADX WARN: Code duplicated, block: B:36:0x009a A[SYNTHETIC] */
                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final void placeChildren() {
                                        byte b6 = b5;
                                        MeasureResult measureResult3 = measureResult2;
                                        int i3 = i2;
                                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                                        switch (b6) {
                                            case 0:
                                                layoutNodeSubcompositionsState3.currentApproachIndex = i3;
                                                measureResult3.placeChildren();
                                                MutableVector mutableVector = layoutNodeSubcompositionsState3.slotIdsOfCompositionsNeededInApproach;
                                                MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState3.approachPrecomposeSlotHandleMap;
                                                long[] jArr = mutableScatterMap.metadata;
                                                int length = jArr.length - 2;
                                                if (length >= 0) {
                                                    int i4 = 0;
                                                    while (true) {
                                                        long j2 = jArr[i4];
                                                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            int i5 = 8;
                                                            int i6 = 8 - ((~(i4 - length)) >>> 31);
                                                            int i7 = 0;
                                                            while (i7 < i6) {
                                                                if ((255 & j2) < 128) {
                                                                    int i8 = (i4 << 3) + i7;
                                                                    Object obj3 = mutableScatterMap.keys[i8];
                                                                    SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i8];
                                                                    int iIndexOf = mutableVector.indexOf(obj3);
                                                                    if (iIndexOf < 0 || iIndexOf >= layoutNodeSubcompositionsState3.currentApproachIndex) {
                                                                        if (iIndexOf >= 0) {
                                                                            Object obj4 = RulerKt.UnspecifiedSlotId;
                                                                            Object[] objArr = mutableVector.content;
                                                                            Object obj5 = objArr[iIndexOf];
                                                                            objArr[iIndexOf] = obj4;
                                                                        }
                                                                        if (layoutNodeSubcompositionsState3.precomposeMap.contains(obj3)) {
                                                                            precomposedSlotHandle.dispose();
                                                                        }
                                                                        mutableScatterMap.removeValueAt(i8);
                                                                    } else {
                                                                        i5 = i5;
                                                                    }
                                                                } else {
                                                                    i5 = i5;
                                                                }
                                                                j2 >>= i5;
                                                                i7++;
                                                                i5 = i5;
                                                            }
                                                            if (i6 == i5) {
                                                                if (i4 != length) {
                                                                    i4++;
                                                                }
                                                            }
                                                        } else if (i4 != length) {
                                                            i4++;
                                                        }
                                                    }
                                                }
                                                layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                break;
                                            default:
                                                layoutNodeSubcompositionsState3.currentIndex = i3;
                                                measureResult3.placeChildren();
                                                if (layoutNodeSubcompositionsState3.root.lookaheadRoot == null) {
                                                    layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                }
                                                break;
                                        }
                                    }
                                };
                            }
                        });
                        break;
                }
                return unit;
            }
        };
        final byte b3 = 2;
        this.setMeasurePolicy = new Function2(this) { // from class: androidx.compose.ui.layout.SubcomposeLayoutState$$ExternalSyntheticLambda0
            public final /* synthetic */ SubcomposeLayoutState f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                byte b4 = b3;
                Unit unit = Unit.INSTANCE;
                SubcomposeLayoutState subcomposeLayoutState = this.f$0;
                switch (b4) {
                    case 0:
                        SubcomposeSlotReusePolicy subcomposeSlotReusePolicy2 = subcomposeLayoutState.slotReusePolicy;
                        LayoutNode layoutNode = (LayoutNode) obj;
                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = layoutNode.subcompositionsState;
                        if (layoutNodeSubcompositionsState == null) {
                            layoutNodeSubcompositionsState = new LayoutNodeSubcompositionsState(layoutNode, subcomposeSlotReusePolicy2);
                            layoutNode.subcompositionsState = layoutNodeSubcompositionsState;
                        }
                        subcomposeLayoutState._state = layoutNodeSubcompositionsState;
                        subcomposeLayoutState.getState().makeSureStateIsConsistent();
                        LayoutNodeSubcompositionsState state = subcomposeLayoutState.getState();
                        if (state.slotReusePolicy != subcomposeSlotReusePolicy2) {
                            state.slotReusePolicy = subcomposeSlotReusePolicy2;
                            state.markActiveNodesAsReused(false);
                            LayoutNode.requestRemeasure$ui$default(state.root, false, 7);
                        }
                        break;
                    case 1:
                        subcomposeLayoutState.getState().compositionContext = (CompositionContext) obj2;
                        break;
                    default:
                        final Function2 function2 = (Function2) obj2;
                        final LayoutNodeSubcompositionsState state2 = subcomposeLayoutState.getState();
                        final String str = state2.NoIntrinsicsMessage;
                        ((LayoutNode) obj).setMeasurePolicy(new LayoutNode.NoIntrinsicsMeasurePolicy(str) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
                                final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = state2;
                                LayoutNodeSubcompositionsState.Scope scope = layoutNodeSubcompositionsState2.scope;
                                scope.layoutDirection = measureScope.getLayoutDirection();
                                scope.density = measureScope.getDensity();
                                scope.fontScale = measureScope.getFontScale();
                                boolean zIsLookingAhead = measureScope.isLookingAhead();
                                Function2 function3 = function2;
                                if (zIsLookingAhead || layoutNodeSubcompositionsState2.root.lookaheadRoot == null) {
                                    layoutNodeSubcompositionsState2.currentIndex = 0;
                                    final MeasureResult measureResult = (MeasureResult) function3.invoke(scope, new Constraints(j));
                                    final int i = layoutNodeSubcompositionsState2.currentIndex;
                                    final byte b5 = 1;
                                    return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Map getAlignmentLines() {
                                            switch (b5) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getAlignmentLines();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final int getHeight() {
                                            switch (b5) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getHeight();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Function2 getRulerProvider() {
                                            switch (b5) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getRulerProvider();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Function1 getRulers() {
                                            switch (b5) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getRulers();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final int getWidth() {
                                            switch (b5) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.getWidth();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final Function1 isRulerProvided() {
                                            switch (b5) {
                                                case 0:
                                                    break;
                                            }
                                            return measureResult.isRulerProvided();
                                        }

                                        /* JADX WARN: Code duplicated, block: B:28:0x0089  */
                                        /* JADX WARN: Code duplicated, block: B:32:0x0095 A[DONT_INVERT] */
                                        /* JADX WARN: Code duplicated, block: B:33:0x0097 A[LOOP:0: B:11:0x002f->B:33:0x0097, LOOP_END] */
                                        /* JADX WARN: Code duplicated, block: B:36:0x009a A[SYNTHETIC] */
                                        @Override // androidx.compose.ui.layout.MeasureResult
                                        public final void placeChildren() {
                                            byte b6 = b5;
                                            MeasureResult measureResult3 = measureResult;
                                            int i3 = i;
                                            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                                            switch (b6) {
                                                case 0:
                                                    layoutNodeSubcompositionsState3.currentApproachIndex = i3;
                                                    measureResult3.placeChildren();
                                                    MutableVector mutableVector = layoutNodeSubcompositionsState3.slotIdsOfCompositionsNeededInApproach;
                                                    MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState3.approachPrecomposeSlotHandleMap;
                                                    long[] jArr = mutableScatterMap.metadata;
                                                    int length = jArr.length - 2;
                                                    if (length >= 0) {
                                                        int i4 = 0;
                                                        while (true) {
                                                            long j2 = jArr[i4];
                                                            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                int i5 = 8;
                                                                int i6 = 8 - ((~(i4 - length)) >>> 31);
                                                                int i7 = 0;
                                                                while (i7 < i6) {
                                                                    if ((255 & j2) < 128) {
                                                                        int i8 = (i4 << 3) + i7;
                                                                        Object obj3 = mutableScatterMap.keys[i8];
                                                                        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i8];
                                                                        int iIndexOf = mutableVector.indexOf(obj3);
                                                                        if (iIndexOf < 0 || iIndexOf >= layoutNodeSubcompositionsState3.currentApproachIndex) {
                                                                            if (iIndexOf >= 0) {
                                                                                Object obj4 = RulerKt.UnspecifiedSlotId;
                                                                                Object[] objArr = mutableVector.content;
                                                                                Object obj5 = objArr[iIndexOf];
                                                                                objArr[iIndexOf] = obj4;
                                                                            }
                                                                            if (layoutNodeSubcompositionsState3.precomposeMap.contains(obj3)) {
                                                                                precomposedSlotHandle.dispose();
                                                                            }
                                                                            mutableScatterMap.removeValueAt(i8);
                                                                        } else {
                                                                            i5 = i5;
                                                                        }
                                                                    } else {
                                                                        i5 = i5;
                                                                    }
                                                                    j2 >>= i5;
                                                                    i7++;
                                                                    i5 = i5;
                                                                }
                                                                if (i6 == i5) {
                                                                    if (i4 != length) {
                                                                        i4++;
                                                                    }
                                                                }
                                                            } else if (i4 != length) {
                                                                i4++;
                                                            }
                                                        }
                                                    }
                                                    layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                    break;
                                                default:
                                                    layoutNodeSubcompositionsState3.currentIndex = i3;
                                                    measureResult3.placeChildren();
                                                    if (layoutNodeSubcompositionsState3.root.lookaheadRoot == null) {
                                                        layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                    }
                                                    break;
                                            }
                                        }
                                    };
                                }
                                layoutNodeSubcompositionsState2.currentApproachIndex = 0;
                                final MeasureResult measureResult2 = (MeasureResult) function3.invoke(layoutNodeSubcompositionsState2.approachMeasureScope, new Constraints(j));
                                final int i2 = layoutNodeSubcompositionsState2.currentApproachIndex;
                                final byte b6 = 0;
                                return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Map getAlignmentLines() {
                                        switch (b6) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getAlignmentLines();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final int getHeight() {
                                        switch (b6) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getHeight();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Function2 getRulerProvider() {
                                        switch (b6) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getRulerProvider();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Function1 getRulers() {
                                        switch (b6) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getRulers();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final int getWidth() {
                                        switch (b6) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.getWidth();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final Function1 isRulerProvided() {
                                        switch (b6) {
                                            case 0:
                                                break;
                                        }
                                        return measureResult2.isRulerProvided();
                                    }

                                    /* JADX WARN: Code duplicated, block: B:28:0x0089  */
                                    /* JADX WARN: Code duplicated, block: B:32:0x0095 A[DONT_INVERT] */
                                    /* JADX WARN: Code duplicated, block: B:33:0x0097 A[LOOP:0: B:11:0x002f->B:33:0x0097, LOOP_END] */
                                    /* JADX WARN: Code duplicated, block: B:36:0x009a A[SYNTHETIC] */
                                    @Override // androidx.compose.ui.layout.MeasureResult
                                    public final void placeChildren() {
                                        byte b7 = b6;
                                        MeasureResult measureResult3 = measureResult2;
                                        int i3 = i2;
                                        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState3 = layoutNodeSubcompositionsState2;
                                        switch (b7) {
                                            case 0:
                                                layoutNodeSubcompositionsState3.currentApproachIndex = i3;
                                                measureResult3.placeChildren();
                                                MutableVector mutableVector = layoutNodeSubcompositionsState3.slotIdsOfCompositionsNeededInApproach;
                                                MutableScatterMap mutableScatterMap = layoutNodeSubcompositionsState3.approachPrecomposeSlotHandleMap;
                                                long[] jArr = mutableScatterMap.metadata;
                                                int length = jArr.length - 2;
                                                if (length >= 0) {
                                                    int i4 = 0;
                                                    while (true) {
                                                        long j2 = jArr[i4];
                                                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            int i5 = 8;
                                                            int i6 = 8 - ((~(i4 - length)) >>> 31);
                                                            int i7 = 0;
                                                            while (i7 < i6) {
                                                                if ((255 & j2) < 128) {
                                                                    int i8 = (i4 << 3) + i7;
                                                                    Object obj3 = mutableScatterMap.keys[i8];
                                                                    SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i8];
                                                                    int iIndexOf = mutableVector.indexOf(obj3);
                                                                    if (iIndexOf < 0 || iIndexOf >= layoutNodeSubcompositionsState3.currentApproachIndex) {
                                                                        if (iIndexOf >= 0) {
                                                                            Object obj4 = RulerKt.UnspecifiedSlotId;
                                                                            Object[] objArr = mutableVector.content;
                                                                            Object obj5 = objArr[iIndexOf];
                                                                            objArr[iIndexOf] = obj4;
                                                                        }
                                                                        if (layoutNodeSubcompositionsState3.precomposeMap.contains(obj3)) {
                                                                            precomposedSlotHandle.dispose();
                                                                        }
                                                                        mutableScatterMap.removeValueAt(i8);
                                                                    } else {
                                                                        i5 = i5;
                                                                    }
                                                                } else {
                                                                    i5 = i5;
                                                                }
                                                                j2 >>= i5;
                                                                i7++;
                                                                i5 = i5;
                                                            }
                                                            if (i6 == i5) {
                                                                if (i4 != length) {
                                                                    i4++;
                                                                }
                                                            }
                                                        } else if (i4 != length) {
                                                            i4++;
                                                        }
                                                    }
                                                }
                                                layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                break;
                                            default:
                                                layoutNodeSubcompositionsState3.currentIndex = i3;
                                                measureResult3.placeChildren();
                                                if (layoutNodeSubcompositionsState3.root.lookaheadRoot == null) {
                                                    layoutNodeSubcompositionsState3.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState3.currentIndex);
                                                }
                                                break;
                                        }
                                    }
                                };
                            }
                        });
                        break;
                }
                return unit;
            }
        };
    }

    public final LayoutNodeSubcompositionsState getState() {
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this._state;
        if (layoutNodeSubcompositionsState != null) {
            return layoutNodeSubcompositionsState;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("SubcomposeLayoutState is not attached to SubcomposeLayout");
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface PrecomposedSlotHandle {
        void dispose();

        default int getPlaceablesCount() {
            return 0;
        }

        /* JADX INFO: renamed from: getSize-YEO4UFw */
        default long mo613getSizeYEO4UFw(int i) {
            return 0L;
        }

        default void traverseDescendants(NavGraphNavigator$$ExternalSyntheticLambda0 navGraphNavigator$$ExternalSyntheticLambda0) {
        }

        /* JADX INFO: renamed from: premeasure-0kLqBqw */
        default void mo614premeasure0kLqBqw(int i, long j) {
        }
    }
}
