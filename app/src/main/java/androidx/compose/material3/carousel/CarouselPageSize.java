package androidx.compose.material3.carousel;

import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CarouselPageSize implements PageSize {
    public final float afterContentPadding;
    public final float beforeContentPadding;
    public final Function2 keylineList;
    public final ParcelableSnapshotMutableState strategyState$delegate = Stack.mutableStateOf$default(Strategy.Empty);

    public CarouselPageSize(Function2 function2, float f, float f2) {
        this.keylineList = function2;
        this.beforeContentPadding = f;
        this.afterContentPadding = f2;
    }

    @Override // androidx.compose.foundation.pager.PageSize
    public final int calculateMainAxisPageSize(int i, int i2) {
        float f;
        KeylineList keylineList;
        float f2;
        Object next;
        ArrayList arrayList;
        ArrayList arrayList2;
        List list;
        ArrayList arrayList3;
        int iIntValue;
        Object next2;
        float f3 = i;
        float f4 = i2;
        KeylineList keylineList2 = (KeylineList) this.keylineList.invoke(Float.valueOf(f3), Float.valueOf(f4));
        List list2 = keylineList2.$$delegate_0;
        List list3 = keylineList2.$$delegate_0;
        int i3 = keylineList2.firstNonAnchorIndex;
        boolean zIsEmpty = list2.isEmpty();
        float f5 = this.beforeContentPadding;
        EmptyList emptyList = EmptyList.INSTANCE;
        float f6 = CropImageView.DEFAULT_ASPECT_RATIO;
        int i4 = 1;
        if (zIsEmpty) {
            keylineList = keylineList2;
            f5 = f5;
            list = emptyList;
            f2 = 0.0f;
            f = 2.0f;
        } else {
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(keylineList2);
            f = 2.0f;
            if (keylineList2.getFirstFocal().offset - (keylineList2.getFirstFocal().size / 2.0f) < CropImageView.DEFAULT_ASPECT_RATIO || !keylineList2.getFirstFocal().equals(keylineList2.get(i3))) {
                keylineList = keylineList2;
                ArrayList arrayList5 = arrayList4;
                int i5 = keylineList.firstFocalIndex - i3;
                if (i5 > 0 || keylineList.getFirstFocal().cutoff <= CropImageView.DEFAULT_ASPECT_RATIO) {
                    int i6 = 0;
                    while (i6 < i5) {
                        float f7 = f6;
                        KeylineList keylineList3 = (KeylineList) CollectionsKt.last(arrayList5);
                        int i7 = i3 + i6;
                        int size = list3.size() - 1;
                        if (i7 > 0) {
                            float f8 = keylineList.get(i7 - 1).size;
                            int i8 = i4;
                            int i9 = keylineList3.lastFocalIndex;
                            List list4 = keylineList3.$$delegate_0;
                            Iterator it = new IntRange(i9, list4.size() - 1, i8).iterator();
                            do {
                                if (!((IntProgressionIterator) it).hasNext) {
                                    next = null;
                                    break;
                                }
                                next = ((IntIterator) it).next();
                            } while (keylineList3.get(((Number) next).intValue()).size != f8);
                            Integer num = (Integer) next;
                            size = (num != null ? num.intValue() : list4.size() - 1) - 1;
                        }
                        arrayList5.add(DatabaseDao_Impl.AnonymousClass17.moveKeylineAndCreateShiftedKeylineList(keylineList3, i3, size, f3, f4));
                        i6++;
                        f6 = f7;
                        i5 = i5;
                        f5 = f5;
                        i4 = 1;
                    }
                    f5 = f5;
                    f2 = f6;
                    list = arrayList5;
                    if (f5 != f2) {
                        arrayList5.set(arrayList5.size() - 1, DatabaseDao_Impl.AnonymousClass17.createShiftedKeylineListForContentPadding((KeylineList) CollectionsKt.last(arrayList5), f3, f4, f5, ((KeylineList) CollectionsKt.last(arrayList5)).getFirstFocal(), ((KeylineList) CollectionsKt.last(arrayList5)).firstFocalIndex));
                        list = arrayList5;
                    }
                } else {
                    arrayList5.add(DatabaseDao_Impl.AnonymousClass17.moveKeylineAndCreateShiftedKeylineList(keylineList, 0, 0, f3, f4));
                    arrayList = arrayList5;
                }
            } else {
                if (f5 == CropImageView.DEFAULT_ASPECT_RATIO) {
                    keylineList = keylineList2;
                    arrayList2 = arrayList4;
                } else {
                    ArrayList arrayList6 = arrayList4;
                    keylineList = keylineList2;
                    arrayList6.add(DatabaseDao_Impl.AnonymousClass17.createShiftedKeylineListForContentPadding(keylineList2, f3, f4, f5, keylineList2.getFirstFocal(), keylineList2.firstFocalIndex));
                    arrayList = arrayList6;
                }
                f2 = 0.0f;
                list = arrayList2;
            }
            arrayList2 = arrayList;
            f2 = 0.0f;
            list = arrayList2;
        }
        int i10 = keylineList.lastNonAnchorIndex;
        boolean zIsEmpty2 = list3.isEmpty();
        List list5 = list3;
        float f9 = this.afterContentPadding;
        List list6 = emptyList;
        if (!zIsEmpty2) {
            arrayList3 = new ArrayList();
            arrayList3.add(keylineList);
            if ((keylineList.getLastFocal().size / f) + keylineList.getLastFocal().offset > f3 || !keylineList.getLastFocal().equals(keylineList.get(i10))) {
                int i11 = i10 - keylineList.lastFocalIndex;
                if (i11 > 0 || keylineList.getLastFocal().cutoff <= f2) {
                    int i12 = 0;
                    while (i12 < i11) {
                        KeylineList keylineList4 = (KeylineList) CollectionsKt.last(arrayList3);
                        int i13 = i10 - i12;
                        if (i13 < list5.size() - 1) {
                            float f10 = keylineList.get(i13 + 1).size;
                            int i14 = keylineList4.firstFocalIndex - 1;
                            IntProgressionIterator intProgressionIterator = new IntProgressionIterator(i14, UuidKt.getProgressionLastElement(i14, 0, -1), -1);
                            do {
                                if (!intProgressionIterator.hasNext) {
                                    next2 = null;
                                    break;
                                }
                                next2 = intProgressionIterator.next();
                            } while (keylineList4.get(((Number) next2).intValue()).size != f10);
                            Integer num2 = (Integer) next2;
                            iIntValue = (num2 != null ? num2.intValue() : 0) + 1;
                        } else {
                            iIntValue = 0;
                        }
                        arrayList3.add(DatabaseDao_Impl.AnonymousClass17.moveKeylineAndCreateShiftedKeylineList(keylineList4, i10, iIntValue, f3, f4));
                        i12++;
                        i11 = i11;
                        list5 = list5;
                    }
                    list6 = arrayList3;
                    if (f9 != f2) {
                        arrayList3.set(arrayList3.size() - 1, DatabaseDao_Impl.AnonymousClass17.createShiftedKeylineListForContentPadding((KeylineList) CollectionsKt.last(arrayList3), f3, f4, -f9, ((KeylineList) CollectionsKt.last(arrayList3)).getLastFocal(), ((KeylineList) CollectionsKt.last(arrayList3)).lastFocalIndex));
                        list6 = arrayList3;
                    }
                } else {
                    arrayList3.add(DatabaseDao_Impl.AnonymousClass17.moveKeylineAndCreateShiftedKeylineList(keylineList, 0, 0, f3, f4));
                    list6 = arrayList3;
                }
            } else if (f9 != f2) {
                list6 = arrayList3;
                arrayList3.add(DatabaseDao_Impl.AnonymousClass17.createShiftedKeylineListForContentPadding(keylineList, f3, f4, -f9, keylineList.getLastFocal(), keylineList.lastFocalIndex));
                list6 = arrayList3;
            }
        }
        list6 = arrayList3;
        this.strategyState$delegate.setValue(new Strategy(keylineList, list, list6, f3, f4, f5, f9));
        return getStrategyState().isValid ? MathKt.roundToInt(getStrategyState().getItemMainAxisSize()) : i;
    }

    public final Strategy getStrategyState() {
        return (Strategy) this.strategyState$delegate.getValue();
    }
}
