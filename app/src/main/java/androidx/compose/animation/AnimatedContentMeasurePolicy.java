package androidx.compose.animation;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatedContentMeasurePolicy implements MeasurePolicy {
    public int approachMaxHeight;
    public int approachMaxWidth;
    public Placeable[] approachPlaceables;
    public final AnimatedContentMeasurePolicy$$ExternalSyntheticLambda0 approachPlacementBlock;
    public int lookaheadMaxHeight;
    public int lookaheadMaxWidth;
    public Placeable[] lookaheadPlaceables;
    public final AnimatedContentMeasurePolicy$$ExternalSyntheticLambda0 lookaheadPlacementBlock;
    public final AnimatedContentTransitionScopeImpl rootScope;

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.animation.AnimatedContentMeasurePolicy$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.animation.AnimatedContentMeasurePolicy$$ExternalSyntheticLambda0] */
    public AnimatedContentMeasurePolicy(AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
        this.rootScope = animatedContentTransitionScopeImpl;
        final byte b = 0;
        this.lookaheadPlacementBlock = new Function1(this) { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$$ExternalSyntheticLambda0
            public final /* synthetic */ AnimatedContentMeasurePolicy f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                byte b2 = b;
                Unit unit = Unit.INSTANCE;
                int i = 0;
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy = this.f$0;
                switch (b2) {
                    case 0:
                        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                        Placeable[] placeableArr = animatedContentMeasurePolicy.lookaheadPlaceables;
                        placeableArr.getClass();
                        int i2 = animatedContentMeasurePolicy.lookaheadMaxWidth;
                        int i3 = animatedContentMeasurePolicy.lookaheadMaxHeight;
                        int length = placeableArr.length;
                        while (i < length) {
                            Placeable placeable = placeableArr[i];
                            if (placeable != null) {
                                long jMo397alignKFBX0sM = animatedContentMeasurePolicy.rootScope.contentAlignment.mo397alignKFBX0sM((((long) placeable.width) << 32) | (((long) placeable.height) & 4294967295L), (((long) i2) << 32) | (((long) i3) & 4294967295L), LayoutDirection.Ltr);
                                placementScope.place(placeable, (int) (jMo397alignKFBX0sM >> 32), (int) (jMo397alignKFBX0sM & 4294967295L), CropImageView.DEFAULT_ASPECT_RATIO);
                            }
                            i++;
                            placeableArr = placeableArr;
                        }
                        break;
                    default:
                        Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                        Placeable[] placeableArr2 = animatedContentMeasurePolicy.approachPlaceables;
                        placeableArr2.getClass();
                        int i4 = animatedContentMeasurePolicy.approachMaxWidth;
                        int i5 = animatedContentMeasurePolicy.approachMaxHeight;
                        int length2 = placeableArr2.length;
                        while (i < length2) {
                            Placeable placeable2 = placeableArr2[i];
                            if (placeable2 != null) {
                                Alignment alignment = animatedContentMeasurePolicy.rootScope.contentAlignment;
                                int i6 = placeable2.width;
                                long jMo397alignKFBX0sM2 = alignment.mo397alignKFBX0sM((((long) placeable2.height) & 4294967295L) | (((long) i6) << 32), (((long) i4) << 32) | (((long) i5) & 4294967295L), LayoutDirection.Ltr);
                                placementScope2.place(placeable2, (int) (jMo397alignKFBX0sM2 >> 32), (int) (jMo397alignKFBX0sM2 & 4294967295L), CropImageView.DEFAULT_ASPECT_RATIO);
                            }
                            i++;
                            unit = unit;
                        }
                        break;
                }
                return unit;
            }
        };
        final byte b2 = 1;
        this.approachPlacementBlock = new Function1(this) { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$$ExternalSyntheticLambda0
            public final /* synthetic */ AnimatedContentMeasurePolicy f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                byte b3 = b2;
                Unit unit = Unit.INSTANCE;
                int i = 0;
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy = this.f$0;
                switch (b3) {
                    case 0:
                        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                        Placeable[] placeableArr = animatedContentMeasurePolicy.lookaheadPlaceables;
                        placeableArr.getClass();
                        int i2 = animatedContentMeasurePolicy.lookaheadMaxWidth;
                        int i3 = animatedContentMeasurePolicy.lookaheadMaxHeight;
                        int length = placeableArr.length;
                        while (i < length) {
                            Placeable placeable = placeableArr[i];
                            if (placeable != null) {
                                long jMo397alignKFBX0sM = animatedContentMeasurePolicy.rootScope.contentAlignment.mo397alignKFBX0sM((((long) placeable.width) << 32) | (((long) placeable.height) & 4294967295L), (((long) i2) << 32) | (((long) i3) & 4294967295L), LayoutDirection.Ltr);
                                placementScope.place(placeable, (int) (jMo397alignKFBX0sM >> 32), (int) (jMo397alignKFBX0sM & 4294967295L), CropImageView.DEFAULT_ASPECT_RATIO);
                            }
                            i++;
                            placeableArr = placeableArr;
                        }
                        break;
                    default:
                        Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                        Placeable[] placeableArr2 = animatedContentMeasurePolicy.approachPlaceables;
                        placeableArr2.getClass();
                        int i4 = animatedContentMeasurePolicy.approachMaxWidth;
                        int i5 = animatedContentMeasurePolicy.approachMaxHeight;
                        int length2 = placeableArr2.length;
                        while (i < length2) {
                            Placeable placeable2 = placeableArr2[i];
                            if (placeable2 != null) {
                                Alignment alignment = animatedContentMeasurePolicy.rootScope.contentAlignment;
                                int i6 = placeable2.width;
                                long jMo397alignKFBX0sM2 = alignment.mo397alignKFBX0sM((((long) placeable2.height) & 4294967295L) | (((long) i6) << 32), (((long) i4) << 32) | (((long) i5) & 4294967295L), LayoutDirection.Ltr);
                                placementScope2.place(placeable2, (int) (jMo397alignKFBX0sM2 >> 32), (int) (jMo397alignKFBX0sM2 & 4294967295L), CropImageView.DEFAULT_ASPECT_RATIO);
                            }
                            i++;
                            unit = unit;
                        }
                        break;
                }
                return unit;
            }
        };
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        Integer numValueOf;
        if (!list.isEmpty()) {
            numValueOf = Integer.valueOf(((Measurable) list.get(0)).maxIntrinsicHeight(i));
            int i2 = 1;
            int size = list.size() - 1;
            if (1 <= size) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((Measurable) list.get(i2)).maxIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        Integer numValueOf;
        if (!list.isEmpty()) {
            numValueOf = Integer.valueOf(((Measurable) list.get(0)).maxIntrinsicWidth(i));
            int i2 = 1;
            int size = list.size() - 1;
            if (1 <= size) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((Measurable) list.get(i2)).maxIntrinsicWidth(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
        Pair pair;
        int size = list.size();
        Placeable[] placeableArr = new Placeable[size];
        int size2 = list.size();
        long j2 = 0;
        for (int i = 0; i < size2; i++) {
            Measurable measurable = (Measurable) list.get(i);
            Object parentData = measurable.getParentData();
            AnimatedContentTransitionScopeImpl.ChildData childData = parentData instanceof AnimatedContentTransitionScopeImpl.ChildData ? (AnimatedContentTransitionScopeImpl.ChildData) parentData : null;
            if (childData != null && ((Boolean) childData.isTarget$delegate.getValue()).booleanValue()) {
                Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
                long j3 = (((long) placeableMo598measureBRTryo0.height) & 4294967295L) | (((long) placeableMo598measureBRTryo0.width) << 32);
                placeableArr[i] = placeableMo598measureBRTryo0;
                j2 = j3;
            }
        }
        int size3 = list.size();
        for (int i2 = 0; i2 < size3; i2++) {
            Measurable measurable2 = (Measurable) list.get(i2);
            if (placeableArr[i2] == null) {
                placeableArr[i2] = measurable2.mo598measureBRTryo0(j);
            }
        }
        if (measureScope.isLookingAhead()) {
            pair = new Pair(Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) (j2 & 4294967295L)));
        } else {
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                Placeable placeable = placeableArr[i5];
                if (placeable != null) {
                    Object parentData2 = ((Measurable) list.get(i5)).getParentData();
                    AnimatedContentTransitionScopeImpl.ChildData childData2 = parentData2 instanceof AnimatedContentTransitionScopeImpl.ChildData ? (AnimatedContentTransitionScopeImpl.ChildData) parentData2 : null;
                    if (childData2 == null || !((Boolean) childData2.isPendingTarget$delegate.getValue()).booleanValue()) {
                        int i6 = placeable.width;
                        if (i6 > i3) {
                            i3 = i6;
                        }
                        int i7 = placeable.height;
                        if (i7 > i4) {
                            i4 = i7;
                        }
                    }
                }
            }
            pair = new Pair(Integer.valueOf(i3), Integer.valueOf(i4));
        }
        int iIntValue = ((Number) pair.first).intValue();
        int iIntValue2 = ((Number) pair.second).intValue();
        boolean zIsLookingAhead = measureScope.isLookingAhead();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (zIsLookingAhead) {
            this.lookaheadPlaceables = placeableArr;
            this.lookaheadMaxWidth = iIntValue;
            this.lookaheadMaxHeight = iIntValue2;
            return measureScope.layout(iIntValue, iIntValue2, emptyMap, this.lookaheadPlacementBlock);
        }
        this.rootScope.measuredSize$delegate.setValue(new IntSize((((long) iIntValue) << 32) | (((long) iIntValue2) & 4294967295L)));
        this.approachPlaceables = placeableArr;
        this.approachMaxWidth = iIntValue;
        this.approachMaxHeight = iIntValue2;
        return measureScope.layout(iIntValue, iIntValue2, emptyMap, this.approachPlacementBlock);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        Integer numValueOf;
        if (!list.isEmpty()) {
            numValueOf = Integer.valueOf(((Measurable) list.get(0)).minIntrinsicHeight(i));
            int i2 = 1;
            int size = list.size() - 1;
            if (1 <= size) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((Measurable) list.get(i2)).minIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        Integer numValueOf;
        if (!list.isEmpty()) {
            numValueOf = Integer.valueOf(((Measurable) list.get(0)).minIntrinsicWidth(i));
            int i2 = 1;
            int size = list.size() - 1;
            if (1 <= size) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((Measurable) list.get(i2)).minIntrinsicWidth(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }
}
