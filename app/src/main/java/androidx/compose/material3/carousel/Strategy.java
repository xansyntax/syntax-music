package androidx.compose.material3.carousel;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableFloatList;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Strategy {
    public static final Strategy Empty;
    public final float afterContentPadding;
    public final float availableSpace;
    public final float beforeContentPadding;
    public KeylineList cachedKeylineList;
    public float cachedMaxScrollOffset;
    public float cachedScrollOffset;
    public final KeylineList defaultKeylines;
    public final List endKeylineSteps;
    public final float endShiftDistance;
    public final MutableFloatList endShiftPoints;
    public final boolean isValid;
    public final float itemSpacing;
    public List lastStartAndEndKeylineListSteps;
    public final float maxItemSize;
    public final float minItemSize;
    public final List startKeylineSteps;
    public final float startShiftDistance;
    public final MutableFloatList startShiftPoints;

    static {
        KeylineList keylineList = KeylineList.Empty;
        EmptyList emptyList = EmptyList.INSTANCE;
        Empty = new Strategy(keylineList, emptyList, emptyList, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public Strategy(KeylineList keylineList, List list, List list2, float f, float f2, float f3, float f4) {
        this.defaultKeylines = keylineList;
        this.startKeylineSteps = list;
        this.endKeylineSteps = list2;
        this.availableSpace = f;
        this.itemSpacing = f2;
        this.beforeContentPadding = f3;
        this.afterContentPadding = f4;
        float f5 = keylineList.minSize;
        float f6 = keylineList.maxSize;
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            KeylineList keylineList2 = (KeylineList) list.get(i);
            float f7 = keylineList2.minSize;
            f5 = f7 < f5 ? f7 : f5;
            float f8 = keylineList2.maxSize;
            if (f8 > f6) {
                f6 = f8;
            }
        }
        List list3 = this.endKeylineSteps;
        int size2 = list3.size();
        for (int i2 = 0; i2 < size2; i2++) {
            KeylineList keylineList3 = (KeylineList) list3.get(i2);
            float f9 = keylineList3.minSize;
            f5 = f9 < f5 ? f9 : f5;
            float f10 = keylineList3.maxSize;
            if (f10 > f6) {
                f6 = f10;
            }
        }
        this.minItemSize = f5;
        this.maxItemSize = f6;
        List list4 = this.startKeylineSteps;
        float fMax = list4.isEmpty() ? 0.0f : Math.max(((Keyline) CollectionsKt.first((List) CollectionsKt.last(list4))).unadjustedOffset - ((Keyline) CollectionsKt.first((List) CollectionsKt.first(list4))).unadjustedOffset, this.beforeContentPadding);
        this.startShiftDistance = fMax;
        List list5 = this.endKeylineSteps;
        float fMax2 = list5.isEmpty() ? 0.0f : Math.max(((Keyline) CollectionsKt.last((List) CollectionsKt.first(list5))).unadjustedOffset - ((Keyline) CollectionsKt.last((List) CollectionsKt.last(list5))).unadjustedOffset, this.afterContentPadding);
        this.endShiftDistance = fMax2;
        this.startShiftPoints = DatabaseDao_Impl.AnonymousClass17.getStepInterpolationPoints(fMax, this.startKeylineSteps, true);
        this.endShiftPoints = DatabaseDao_Impl.AnonymousClass17.getStepInterpolationPoints(fMax2, this.endKeylineSteps, false);
        if (!this.defaultKeylines.$$delegate_0.isEmpty() && this.availableSpace != CropImageView.DEFAULT_ASPECT_RATIO && getItemMainAxisSize() != CropImageView.DEFAULT_ASPECT_RATIO) {
            z = true;
        }
        this.isValid = z;
        this.cachedScrollOffset = -1.0f;
        this.cachedMaxScrollOffset = -1.0f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        boolean z = this.isValid;
        if (!z && !((Strategy) obj).isValid) {
            return true;
        }
        Strategy strategy = (Strategy) obj;
        return z == strategy.isValid && this.availableSpace == strategy.availableSpace && this.itemSpacing == strategy.itemSpacing && this.beforeContentPadding == strategy.beforeContentPadding && this.afterContentPadding == strategy.afterContentPadding && getItemMainAxisSize() == strategy.getItemMainAxisSize() && this.startShiftDistance == strategy.startShiftDistance && this.endShiftDistance == strategy.endShiftDistance && Intrinsics.areEqual(this.startShiftPoints, strategy.startShiftPoints) && Intrinsics.areEqual(this.endShiftPoints, strategy.endShiftPoints) && Intrinsics.areEqual(this.defaultKeylines, strategy.defaultKeylines);
    }

    public final float getItemMainAxisSize() {
        return this.defaultKeylines.getFirstFocal().size;
    }

    public final int hashCode() {
        boolean z = this.isValid;
        if (!z) {
            return Boolean.hashCode(z);
        }
        return this.defaultKeylines.hashCode() + ((this.endShiftPoints.hashCode() + ((this.startShiftPoints.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.endShiftDistance, IntIntPair$$ExternalSyntheticOutline0.m(this.startShiftDistance, (Float.hashCode(getItemMainAxisSize()) + IntIntPair$$ExternalSyntheticOutline0.m(this.afterContentPadding, IntIntPair$$ExternalSyntheticOutline0.m(this.beforeContentPadding, IntIntPair$$ExternalSyntheticOutline0.m(this.itemSpacing, IntIntPair$$ExternalSyntheticOutline0.m(this.availableSpace, Boolean.hashCode(z) * 31, 31), 31), 31), 31)) * 31, 31), 31)) * 31)) * 31);
    }
}
