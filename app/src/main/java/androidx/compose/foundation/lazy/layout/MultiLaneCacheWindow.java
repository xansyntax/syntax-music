package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntIntMapKt;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.foundation.ScrollKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.DerivedSnapshotState$$ExternalSyntheticLambda0;
import androidx.compose.ui.unit.Density;
import androidx.tracing.TraceApi29Impl;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda88;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.math.MathKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiLaneCacheWindow implements CacheWindowLogic {
    public final LazyLayoutCacheWindow cacheWindow;
    public boolean hasLookaheadOccurred;
    public boolean hasUpdatedVisibleItemsOnce;
    public final MutableIntSet indicesToRemove;
    public int itemsCount;
    public int[] perLaneCacheWindowEndItemIndex;
    public int[] perLaneCacheWindowEndSpace;
    public int[] perLaneCacheWindowStartIndex;
    public int[] perLaneCacheWindowStartSpace;
    public int[] perLaneFirstVisibleItemIndex;
    public int[] perLaneLastVisibleItemIndex;
    public int[] perLaneMainAxisExtraEndSpace;
    public int[] perLaneMainAxisExtraStartSpace;
    public final MutableIntObjectMap prefetchWindowHandles;
    public int previousLaneCount;
    public float previousPassDelta;
    public int previousPassItemCount;
    public boolean shouldRefillWindow;
    public final MutableIntIntMap windowCache;
    public final MutableIntObjectMap windowCacheWithItems;

    public MultiLaneCacheWindow(LazyLayoutCacheWindow lazyLayoutCacheWindow, ScrollKt$$ExternalSyntheticLambda0 scrollKt$$ExternalSyntheticLambda0) {
        this.cacheWindow = lazyLayoutCacheWindow;
        MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        this.prefetchWindowHandles = new MutableIntObjectMap();
        this.indicesToRemove = new MutableIntSet();
        int i = IntIntMapKt.$r8$clinit;
        this.windowCache = new MutableIntIntMap();
        this.windowCacheWithItems = new MutableIntObjectMap();
        this.previousPassItemCount = -1;
        Integer num = 1;
        int iMax = Math.max(1, num.intValue());
        this.previousLaneCount = iMax;
        int[] iArr = new int[iMax];
        for (int i2 = 0; i2 < iMax; i2++) {
            iArr[i2] = Integer.MAX_VALUE;
        }
        this.perLaneCacheWindowStartIndex = iArr;
        int i3 = this.previousLaneCount;
        int[] iArr2 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            iArr2[i4] = Integer.MIN_VALUE;
        }
        this.perLaneCacheWindowEndItemIndex = iArr2;
        int i5 = this.previousLaneCount;
        this.perLaneCacheWindowStartSpace = new int[i5];
        this.perLaneCacheWindowEndSpace = new int[i5];
        this.perLaneFirstVisibleItemIndex = new int[i5];
        this.perLaneLastVisibleItemIndex = new int[i5];
        this.perLaneMainAxisExtraStartSpace = new int[i5];
        this.perLaneMainAxisExtraEndSpace = new int[i5];
    }

    public final int getItemSizeOrPrefetch(CacheWindowScope cacheWindowScope, int i, boolean z, int i2) {
        List list;
        List list2;
        MutableIntObjectMap mutableIntObjectMap = this.windowCacheWithItems;
        if (mutableIntObjectMap.containsKey(i2)) {
            Object obj = mutableIntObjectMap.get(i2);
            obj.getClass();
            return ((CachedItem) obj).mainAxisSize;
        }
        MutableIntObjectMap mutableIntObjectMap2 = this.prefetchWindowHandles;
        int i3 = 0;
        if (mutableIntObjectMap2.containsKey(i2)) {
            if (!z || (list2 = (List) mutableIntObjectMap2.get(i2)) == null) {
                return -1;
            }
            int size = list2.size();
            while (i3 < size) {
                ((LazyLayoutPrefetchState.PrefetchHandle) list2.get(i3)).markAsUrgent();
                i3++;
            }
            return -1;
        }
        mutableIntObjectMap2.set(i2, cacheWindowScope.schedulePrefetch(i2, new DatabaseDao_Impl$$ExternalSyntheticLambda88(this, cacheWindowScope, i, i2)));
        if (!z || (list = (List) mutableIntObjectMap2.get(i2)) == null) {
            return -1;
        }
        int size2 = list.size();
        while (i3 < size2) {
            ((LazyLayoutPrefetchState.PrefetchHandle) list.get(i3)).markAsUrgent();
            i3++;
        }
        return -1;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowLogic
    public final int[] getPerLaneCacheWindowEndItemIndex() {
        return this.perLaneCacheWindowEndItemIndex;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowLogic
    public final int[] getPerLaneCacheWindowStartIndex() {
        return this.perLaneCacheWindowStartIndex;
    }

    public final void handleLaneResize() {
        Integer num = 1;
        if (this.previousLaneCount != Math.max(1, num.intValue())) {
            resetStrategy();
            this.shouldRefillWindow = true;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowLogic
    public final boolean hasValidBounds() {
        handleLaneResize();
        int length = this.perLaneCacheWindowStartIndex.length;
        for (int i = 0; i < length; i++) {
            if (this.perLaneCacheWindowStartIndex[i] == Integer.MAX_VALUE || this.perLaneCacheWindowEndItemIndex[i] == Integer.MIN_VALUE) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onItemPrefetched(CacheWindowScope cacheWindowScope, int i, int i2, int i3) {
        int i4;
        MultiLaneCacheWindow multiLaneCacheWindow;
        MutableIntObjectMap mutableIntObjectMap = this.windowCacheWithItems;
        CachedItem cachedItem = (CachedItem) mutableIntObjectMap.get(i2);
        CachedItem.NoKey noKey = CachedItem.NoKey;
        if (cachedItem != null) {
            cachedItem.mainAxisSize = i3;
            cachedItem.key = noKey;
        } else {
            cachedItem = new CachedItem();
            cachedItem.key = noKey;
            cachedItem.mainAxisSize = i3;
        }
        mutableIntObjectMap.set(i2, cachedItem);
        if (i2 > this.perLaneCacheWindowEndItemIndex[i]) {
            updateEndCacheWindowsState(cacheWindowScope, i, i2, i3);
        } else if (i2 < this.perLaneCacheWindowStartIndex[i]) {
            updateStartCacheWindowsState(cacheWindowScope, i, i2, i3);
        }
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = -1;
        if (Math.signum(this.previousPassDelta) > CropImageView.DEFAULT_ASPECT_RATIO) {
            while (true) {
                int iIndexOfMaxValue = LazyLayoutKt.indexOfMaxValue(this.perLaneCacheWindowStartSpace);
                ref$IntRef.element = iIndexOfMaxValue;
                if (iIndexOfMaxValue != -1) {
                    int[] iArr = this.perLaneCacheWindowStartSpace;
                    if (iArr[iIndexOfMaxValue] > 0) {
                        int i5 = this.perLaneCacheWindowStartIndex[iIndexOfMaxValue];
                        if (i5 > 0) {
                            int i6 = i5 - 1;
                            if (cacheWindowScope.lastItemIndexInLine(i6) != -1) {
                                i4 = i6;
                                break;
                            }
                            this.perLaneCacheWindowStartSpace[ref$IntRef.element] = 0;
                        } else {
                            iArr[iIndexOfMaxValue] = 0;
                        }
                    }
                }
                i4 = -1;
                break;
            }
        }
        while (true) {
            int iIndexOfMaxValue2 = LazyLayoutKt.indexOfMaxValue(this.perLaneCacheWindowEndSpace);
            ref$IntRef.element = iIndexOfMaxValue2;
            if (iIndexOfMaxValue2 != -1 && this.perLaneCacheWindowEndSpace[iIndexOfMaxValue2] > 0) {
                int i7 = this.perLaneCacheWindowEndItemIndex[iIndexOfMaxValue2] + 1;
                int iLastItemIndexInLine = cacheWindowScope.lastItemIndexInLine(i7);
                if (iLastItemIndexInLine != -1 && iLastItemIndexInLine < this.itemsCount) {
                    i4 = i7;
                    break;
                }
                this.perLaneCacheWindowEndSpace[ref$IntRef.element] = 0;
            } else {
                i4 = -1;
                break;
            }
        }
        if (i4 >= 0) {
            multiLaneCacheWindow = this;
            multiLaneCacheWindow.prefetchWindowHandles.set(i4, cacheWindowScope.schedulePrefetch(i4, new DerivedSnapshotState$$ExternalSyntheticLambda0((byte) 2, i4, multiLaneCacheWindow, cacheWindowScope, ref$IntRef)));
        } else {
            multiLaneCacheWindow = this;
        }
        multiLaneCacheWindow.traceWindowInfo$1();
    }

    public final void onPrefetchForward(CacheWindowScope cacheWindowScope, int i, float f, boolean z) {
        boolean z2 = Math.signum(f) == Math.signum(this.previousPassDelta);
        if (z) {
            cacheWindowScope.updatePerLaneLastVisibleItemIndexes(this.perLaneLastVisibleItemIndex);
            cacheWindowScope.updatePerLaneMainAxisExtraEndSpace(this.perLaneMainAxisExtraEndSpace);
            int length = this.perLaneCacheWindowStartIndex.length;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i - this.perLaneMainAxisExtraEndSpace[i2];
                if (!z2 || this.shouldRefillWindow) {
                    this.perLaneCacheWindowEndItemIndex[i2] = this.perLaneLastVisibleItemIndex[i2];
                    this.perLaneCacheWindowEndSpace[i2] = i3;
                } else {
                    int[] iArr = this.perLaneCacheWindowEndSpace;
                    int iRoundToInt = MathKt.roundToInt(Math.abs(f)) + iArr[i2];
                    if (iRoundToInt <= i3) {
                        i3 = iRoundToInt;
                    }
                    iArr[i2] = i3;
                }
            }
            while (true) {
                int iIndexOfMaxValue = LazyLayoutKt.indexOfMaxValue(this.perLaneCacheWindowEndSpace);
                if (iIndexOfMaxValue == -1 || this.perLaneCacheWindowEndSpace[iIndexOfMaxValue] <= 0) {
                    return;
                }
                int iLastItemIndexInLine = cacheWindowScope.lastItemIndexInLine(this.perLaneCacheWindowEndItemIndex[iIndexOfMaxValue]);
                if (iLastItemIndexInLine == -1 || iLastItemIndexInLine >= this.itemsCount - 1) {
                    this.perLaneCacheWindowEndSpace[iIndexOfMaxValue] = 0;
                } else {
                    int i4 = this.perLaneCacheWindowEndItemIndex[iIndexOfMaxValue] + 1;
                    int itemSizeOrPrefetch = getItemSizeOrPrefetch(cacheWindowScope, iIndexOfMaxValue, i4 == this.perLaneLastVisibleItemIndex[iIndexOfMaxValue] + 1 && f != CropImageView.DEFAULT_ASPECT_RATIO && Math.abs(f) >= ((float) this.perLaneMainAxisExtraEndSpace[iIndexOfMaxValue]), i4);
                    if (itemSizeOrPrefetch == -1) {
                        return;
                    } else {
                        updateEndCacheWindowsState(cacheWindowScope, iIndexOfMaxValue, i4, itemSizeOrPrefetch);
                    }
                }
            }
        } else {
            cacheWindowScope.updatePerLaneFirstVisibleItemIndex(this.perLaneFirstVisibleItemIndex);
            cacheWindowScope.updatePerLaneMainAxisExtraStartSpace(this.perLaneMainAxisExtraStartSpace);
            int length2 = this.perLaneCacheWindowStartIndex.length;
            for (int i5 = 0; i5 < length2; i5++) {
                int i6 = i - this.perLaneMainAxisExtraStartSpace[i5];
                if (!z2 || this.shouldRefillWindow) {
                    this.perLaneCacheWindowStartSpace[i5] = i6;
                    this.perLaneCacheWindowStartIndex[i5] = this.perLaneFirstVisibleItemIndex[i5];
                } else {
                    int[] iArr2 = this.perLaneCacheWindowStartSpace;
                    int iRoundToInt2 = MathKt.roundToInt(Math.abs(f)) + iArr2[i5];
                    if (iRoundToInt2 <= i6) {
                        i6 = iRoundToInt2;
                    }
                    iArr2[i5] = i6;
                }
            }
            while (true) {
                int iIndexOfMaxValue2 = LazyLayoutKt.indexOfMaxValue(this.perLaneCacheWindowStartSpace);
                if (iIndexOfMaxValue2 == -1) {
                    return;
                }
                int[] iArr3 = this.perLaneCacheWindowStartSpace;
                if (iArr3[iIndexOfMaxValue2] <= 0) {
                    return;
                }
                int i7 = this.perLaneCacheWindowStartIndex[iIndexOfMaxValue2];
                if (i7 <= 0) {
                    iArr3[iIndexOfMaxValue2] = 0;
                } else {
                    int i8 = i7 - 1;
                    int itemSizeOrPrefetch2 = getItemSizeOrPrefetch(cacheWindowScope, iIndexOfMaxValue2, i8 == this.perLaneFirstVisibleItemIndex[iIndexOfMaxValue2] - 1 && f != CropImageView.DEFAULT_ASPECT_RATIO && Math.abs(f) >= ((float) this.perLaneMainAxisExtraStartSpace[iIndexOfMaxValue2]), i8);
                    if (itemSizeOrPrefetch2 == -1) {
                        return;
                    } else {
                        updateStartCacheWindowsState(cacheWindowScope, iIndexOfMaxValue2, i8, itemSizeOrPrefetch2);
                    }
                }
            }
        }
    }

    public final void onScroll(CacheWindowScope cacheWindowScope, float f) {
        handleLaneResize();
        traceWindowInfo$1();
        boolean hasVisibleItems = cacheWindowScope.getHasVisibleItems();
        LazyLayoutCacheWindow lazyLayoutCacheWindow = this.cacheWindow;
        if (hasVisibleItems) {
            int mainAxisViewportSize = cacheWindowScope.getMainAxisViewportSize();
            Density density = cacheWindowScope.getDensity();
            int iCalculateBehindWindow = density != null ? lazyLayoutCacheWindow.calculateBehindWindow(density, mainAxisViewportSize) : 0;
            this.itemsCount = cacheWindowScope.getTotalItemsCount();
            int totalItemsCount = cacheWindowScope.getTotalItemsCount();
            MutableIntObjectMap mutableIntObjectMap = this.windowCacheWithItems;
            if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
                cacheWindowScope.updatePerLaneFirstVisibleItemIndex(this.perLaneFirstVisibleItemIndex);
                cacheWindowScope.updatePerLaneMainAxisExtraStartSpace(this.perLaneMainAxisExtraStartSpace);
                int length = this.perLaneCacheWindowStartIndex.length;
                for (int i = 0; i < length; i++) {
                    this.perLaneCacheWindowStartSpace[i] = iCalculateBehindWindow - this.perLaneMainAxisExtraStartSpace[i];
                    this.perLaneCacheWindowStartIndex[i] = this.perLaneFirstVisibleItemIndex[i];
                }
                while (true) {
                    int iIndexOfMaxValue = LazyLayoutKt.indexOfMaxValue(this.perLaneCacheWindowStartSpace);
                    if (iIndexOfMaxValue == -1) {
                        break;
                    }
                    int[] iArr = this.perLaneCacheWindowStartSpace;
                    if (iArr[iIndexOfMaxValue] <= 0) {
                        break;
                    }
                    int i2 = this.perLaneCacheWindowStartIndex[iIndexOfMaxValue] - 1;
                    if (i2 == -1) {
                        iArr[iIndexOfMaxValue] = 0;
                    } else if (mutableIntObjectMap.containsKey(i2)) {
                        Object obj = mutableIntObjectMap.get(i2);
                        obj.getClass();
                        updateStartCacheWindowsState(cacheWindowScope, iIndexOfMaxValue, i2, ((CachedItem) obj).mainAxisSize);
                    } else {
                        this.perLaneCacheWindowStartSpace[iIndexOfMaxValue] = 0;
                    }
                }
                int[] iArr2 = this.perLaneCacheWindowStartIndex;
                if (iArr2.length == 0) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return;
                }
                int i3 = iArr2[0];
                int length2 = iArr2.length - 1;
                if (1 <= length2) {
                    int i4 = 1;
                    while (true) {
                        int i5 = iArr2[i4];
                        if (i3 > i5) {
                            i3 = i5;
                        }
                        if (i4 == length2) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                removeOutOfBoundsItems$1(0, i3 - 1);
            } else {
                cacheWindowScope.updatePerLaneLastVisibleItemIndexes(this.perLaneLastVisibleItemIndex);
                cacheWindowScope.updatePerLaneMainAxisExtraEndSpace(this.perLaneMainAxisExtraEndSpace);
                int length3 = this.perLaneCacheWindowStartIndex.length;
                for (int i6 = 0; i6 < length3; i6++) {
                    this.perLaneCacheWindowEndSpace[i6] = iCalculateBehindWindow - this.perLaneMainAxisExtraEndSpace[i6];
                    this.perLaneCacheWindowEndItemIndex[i6] = this.perLaneLastVisibleItemIndex[i6];
                }
                while (true) {
                    int iIndexOfMaxValue2 = LazyLayoutKt.indexOfMaxValue(this.perLaneCacheWindowEndSpace);
                    if (iIndexOfMaxValue2 == -1 || this.perLaneCacheWindowEndSpace[iIndexOfMaxValue2] <= 0) {
                        break;
                    }
                    int i7 = this.perLaneCacheWindowEndItemIndex[iIndexOfMaxValue2];
                    int i8 = i7 + 1;
                    if (i8 == -1 || cacheWindowScope.lastItemIndexInLine(i7) >= totalItemsCount - 1) {
                        this.perLaneCacheWindowEndSpace[iIndexOfMaxValue2] = 0;
                    } else if (mutableIntObjectMap.containsKey(i8)) {
                        Object obj2 = mutableIntObjectMap.get(i8);
                        obj2.getClass();
                        updateEndCacheWindowsState(cacheWindowScope, iIndexOfMaxValue2, i8, ((CachedItem) obj2).mainAxisSize);
                    } else {
                        this.perLaneCacheWindowEndSpace[iIndexOfMaxValue2] = 0;
                    }
                }
                removeOutOfBoundsItems$1(ArraysKt.maxOrThrow(this.perLaneCacheWindowEndItemIndex) + 1, totalItemsCount - 1);
            }
        }
        if (cacheWindowScope.getHasVisibleItems()) {
            int mainAxisViewportSize2 = cacheWindowScope.getMainAxisViewportSize();
            Density density2 = cacheWindowScope.getDensity();
            onPrefetchForward(cacheWindowScope, density2 != null ? lazyLayoutCacheWindow.calculateAheadWindow(density2, mainAxisViewportSize2) : 0, f, f <= CropImageView.DEFAULT_ASPECT_RATIO);
        }
        this.previousPassDelta = f;
        traceWindowInfo$1();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onVisibleItemsUpdated(CacheWindowScope cacheWindowScope) {
        Density density;
        handleLaneResize();
        if (!this.hasUpdatedVisibleItemsOnce) {
            this.shouldRefillWindow = true;
            this.hasUpdatedVisibleItemsOnce = true;
        }
        int i = this.previousPassItemCount;
        if (i != -1 && i != cacheWindowScope.getTotalItemsCount()) {
            this.shouldRefillWindow = true;
            if (cacheWindowScope.getHasVisibleItems()) {
                int lastItemIndex = cacheWindowScope.getLastItemIndex();
                int length = this.perLaneCacheWindowStartIndex.length;
                for (int i2 = 0; i2 < length; i2++) {
                    int[] iArr = this.perLaneCacheWindowStartIndex;
                    int i3 = iArr[i2];
                    if (i3 < 0) {
                        i3 = 0;
                    }
                    iArr[i2] = i3;
                    if (lastItemIndex != -1) {
                        int[] iArr2 = this.perLaneCacheWindowEndItemIndex;
                        int i4 = iArr2[i2];
                        if (i4 > lastItemIndex) {
                            i4 = lastItemIndex;
                        }
                        iArr2[i2] = i4;
                    }
                }
                if (this.previousPassDelta <= CropImageView.DEFAULT_ASPECT_RATIO) {
                    removeOutOfBoundsItems$1(cacheWindowScope.getLastVisibleItemIndex() + 1, this.itemsCount - 1);
                } else {
                    removeOutOfBoundsItems$1(0, cacheWindowScope.getFirstVisibleItemIndex() - 1);
                }
            }
        }
        this.itemsCount = cacheWindowScope.getTotalItemsCount();
        if (cacheWindowScope.getHasVisibleItems()) {
            int visibleItemsCount = cacheWindowScope.getVisibleItemsCount();
            for (int i5 = 0; i5 < visibleItemsCount; i5++) {
                int visibleItemIndex = cacheWindowScope.getVisibleItemIndex(i5);
                Object visibleItemKey = cacheWindowScope.getVisibleItemKey(i5);
                int visibleItemSize = cacheWindowScope.getVisibleItemSize(i5);
                if (visibleItemIndex != -1) {
                    MutableIntObjectMap mutableIntObjectMap = this.windowCacheWithItems;
                    if (mutableIntObjectMap.containsKey(visibleItemIndex)) {
                        Object obj = mutableIntObjectMap.get(visibleItemIndex);
                        obj.getClass();
                        int i6 = ((CachedItem) obj).mainAxisSize;
                        Object obj2 = mutableIntObjectMap.get(visibleItemIndex);
                        obj2.getClass();
                        Object obj3 = ((CachedItem) obj2).key;
                        if (i6 != visibleItemSize || !Intrinsics.areEqual(obj3, visibleItemKey)) {
                            this.shouldRefillWindow = true;
                        }
                    }
                    CachedItem cachedItem = (CachedItem) mutableIntObjectMap.get(visibleItemIndex);
                    if (cachedItem != null) {
                        cachedItem.mainAxisSize = visibleItemSize;
                        cachedItem.key = visibleItemKey;
                    } else {
                        cachedItem = new CachedItem();
                        cachedItem.key = visibleItemKey;
                        cachedItem.mainAxisSize = visibleItemSize;
                    }
                    mutableIntObjectMap.set(visibleItemIndex, cachedItem);
                    int[] iArr3 = this.perLaneCacheWindowStartIndex;
                    iArr3[0] = Math.min(iArr3[0], visibleItemIndex);
                    int[] iArr4 = this.perLaneCacheWindowEndItemIndex;
                    iArr4[0] = Math.max(iArr4[0], visibleItemIndex);
                    List list = (List) this.prefetchWindowHandles.remove(visibleItemIndex);
                    if (list != null) {
                        int size = list.size();
                        for (int i7 = 0; i7 < size; i7++) {
                            ((LazyLayoutPrefetchState.PrefetchHandle) list.get(i7)).cancel();
                        }
                    }
                }
            }
            if (this.hasLookaheadOccurred) {
                this.shouldRefillWindow = true;
                this.hasLookaheadOccurred = false;
            }
            if (this.shouldRefillWindow) {
                int mainAxisViewportSize = cacheWindowScope.getMainAxisViewportSize();
                LazyLayoutCacheWindow lazyLayoutCacheWindow = this.cacheWindow;
                onPrefetchForward(cacheWindowScope, (!lazyLayoutCacheWindow.isNonScrollCachingEnabled() || (density = cacheWindowScope.getDensity()) == null) ? 0 : lazyLayoutCacheWindow.calculateAheadWindow(density, mainAxisViewportSize), CropImageView.DEFAULT_ASPECT_RATIO, this.previousPassDelta <= CropImageView.DEFAULT_ASPECT_RATIO);
                this.shouldRefillWindow = false;
            }
        } else {
            resetStrategy();
        }
        this.previousPassItemCount = cacheWindowScope.getTotalItemsCount();
    }

    /* JADX WARN: Code duplicated, block: B:102:0x00f5 A[EDGE_INSN: B:102:0x00f5->B:59:0x00f5 BREAK  A[LOOP:4: B:45:0x00c1->B:58:0x00f2], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x0054 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0056 A[LOOP:0: B:5:0x0020->B:18:0x0056, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00f2 A[LOOP:4: B:45:0x00c1->B:58:0x00f2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:88:0x0063 A[EDGE_INSN: B:88:0x0063->B:20:0x0063 BREAK  A[LOOP:0: B:5:0x0020->B:18:0x0056], SYNTHETIC] */
    public final void removeOutOfBoundsItems$1(int i, int i2) {
        char c;
        long j;
        long j2;
        long j3;
        char c2;
        int[] iArr;
        long[] jArr;
        int i3;
        char c3;
        int i4;
        MutableIntSet mutableIntSet = this.indicesToRemove;
        mutableIntSet.clear();
        MutableIntObjectMap mutableIntObjectMap = this.prefetchWindowHandles;
        int[] iArr2 = mutableIntObjectMap.keys;
        long[] jArr2 = mutableIntObjectMap.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i5 = 0;
            j = 128;
            j2 = 255;
            while (true) {
                long j4 = jArr2[i5];
                c = 7;
                j3 = -9187201950435737472L;
                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i5 != length) {
                        break;
                        break;
                    }
                    i5++;
                } else {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((j4 & 255) < 128 && i <= (i4 = iArr2[(i5 << 3) + i7]) && i4 <= i2) {
                            mutableIntSet.add(i4);
                        }
                        j4 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    } else if (i5 != length) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
        } else {
            c = 7;
            j = 128;
            j2 = 255;
            j3 = -9187201950435737472L;
        }
        MutableIntIntMap mutableIntIntMap = this.windowCache;
        int[] iArr3 = mutableIntIntMap.keys;
        long[] jArr3 = mutableIntIntMap.metadata;
        int length2 = jArr3.length - 2;
        if (length2 >= 0) {
            int i8 = 0;
            while (true) {
                long j5 = jArr3[i8];
                if ((((~j5) << c) & j5 & j3) != j3) {
                    int i9 = 8 - ((~(i8 - length2)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & j2) < j) {
                            c3 = c;
                            int i11 = iArr3[(i8 << 3) + i10];
                            if (i <= i11 && i11 <= i2) {
                                mutableIntSet.add(i11);
                            }
                        } else {
                            c3 = c;
                        }
                        j5 >>= 8;
                        i10++;
                        c = c3;
                    }
                    c2 = c;
                    if (i9 != 8) {
                        break;
                    }
                } else {
                    c2 = c;
                }
                if (i8 == length2) {
                    break;
                }
                i8++;
                c = c2;
            }
        } else {
            c2 = c;
        }
        MutableIntObjectMap mutableIntObjectMap2 = this.windowCacheWithItems;
        int[] iArr4 = mutableIntObjectMap2.keys;
        long[] jArr4 = mutableIntObjectMap2.metadata;
        int length3 = jArr4.length - 2;
        if (length3 >= 0) {
            int i12 = 0;
            while (true) {
                long j6 = jArr4[i12];
                if ((((~j6) << c2) & j6 & j3) == j3) {
                    if (i12 != length3) {
                        break;
                        break;
                    }
                    i12++;
                } else {
                    int i13 = 8 - ((~(i12 - length3)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((j6 & j2) < j && i <= (i3 = iArr4[(i12 << 3) + i14]) && i3 <= i2) {
                            mutableIntSet.add(i3);
                        }
                        j6 >>= 8;
                    }
                    if (i13 != 8) {
                        break;
                    } else if (i12 != length3) {
                        break;
                    } else {
                        i12++;
                    }
                }
            }
        }
        int[] iArr5 = mutableIntSet.elements;
        long[] jArr5 = mutableIntSet.metadata;
        int length4 = jArr5.length - 2;
        if (length4 < 0) {
            return;
        }
        int i15 = 0;
        while (true) {
            long j7 = jArr5[i15];
            if ((((~j7) << c2) & j7 & j3) != j3) {
                int i16 = 8 - ((~(i15 - length4)) >>> 31);
                int i17 = 0;
                while (i17 < i16) {
                    if ((j7 & j2) < j) {
                        int i18 = iArr5[(i15 << 3) + i17];
                        List list = (List) mutableIntObjectMap.remove(i18);
                        if (list != null) {
                            int size = list.size();
                            for (int i19 = 0; i19 < size; i19++) {
                                ((LazyLayoutPrefetchState.PrefetchHandle) list.get(i19)).cancel();
                            }
                        }
                        int iFindKeyIndex = mutableIntIntMap.findKeyIndex(i18);
                        if (iFindKeyIndex >= 0) {
                            mutableIntIntMap._size--;
                            long[] jArr6 = mutableIntIntMap.metadata;
                            int i20 = mutableIntIntMap._capacity;
                            int i21 = iFindKeyIndex >> 3;
                            int i22 = (iFindKeyIndex & 7) << 3;
                            long j8 = (jArr6[i21] & (~(j2 << i22))) | (254 << i22);
                            jArr6[i21] = j8;
                            jArr6[(((iFindKeyIndex - 7) & i20) + (i20 & 7)) >> 3] = j8;
                        }
                        mutableIntObjectMap2.remove(i18);
                    } else {
                        iArr5 = iArr5;
                        jArr5 = jArr5;
                    }
                    j7 >>= 8;
                    i17++;
                    iArr5 = iArr5;
                    jArr5 = jArr5;
                }
                iArr = iArr5;
                jArr = jArr5;
                if (i16 != 8) {
                    return;
                }
            } else {
                iArr = iArr5;
                jArr = jArr5;
            }
            if (i15 == length4) {
                return;
            }
            i15++;
            iArr5 = iArr;
            jArr5 = jArr;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowLogic
    public final void resetStrategy() {
        Integer num = 1;
        int iMax = Math.max(1, num.intValue());
        this.previousLaneCount = iMax;
        int[] iArr = this.perLaneCacheWindowStartIndex;
        if (iArr.length != iMax) {
            int[] iArr2 = new int[iMax];
            for (int i = 0; i < iMax; i++) {
                iArr2[i] = Integer.MAX_VALUE;
            }
            this.perLaneCacheWindowStartIndex = iArr2;
            int[] iArr3 = new int[iMax];
            for (int i2 = 0; i2 < iMax; i2++) {
                iArr3[i2] = Integer.MIN_VALUE;
            }
            this.perLaneCacheWindowEndItemIndex = iArr3;
            this.perLaneCacheWindowStartSpace = new int[iMax];
            this.perLaneCacheWindowEndSpace = new int[iMax];
            this.perLaneFirstVisibleItemIndex = new int[iMax];
            this.perLaneLastVisibleItemIndex = new int[iMax];
            this.perLaneMainAxisExtraStartSpace = new int[iMax];
            this.perLaneMainAxisExtraEndSpace = new int[iMax];
        } else {
            Arrays.fill(iArr, 0, iArr.length, Integer.MAX_VALUE);
            int[] iArr4 = this.perLaneCacheWindowEndItemIndex;
            Arrays.fill(iArr4, 0, iArr4.length, Integer.MIN_VALUE);
            int[] iArr5 = this.perLaneCacheWindowStartSpace;
            Arrays.fill(iArr5, 0, iArr5.length, 0);
            int[] iArr6 = this.perLaneCacheWindowEndSpace;
            Arrays.fill(iArr6, 0, iArr6.length, 0);
        }
        this.shouldRefillWindow = false;
        this.windowCache.clear();
        this.windowCacheWithItems.clear();
        MutableIntObjectMap mutableIntObjectMap = this.prefetchWindowHandles;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j = jArr[i3];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j) < 128) {
                        int i6 = (i3 << 3) + i5;
                        int i7 = mutableIntObjectMap.keys[i6];
                        List list = (List) mutableIntObjectMap.values[i6];
                        int size = list.size();
                        for (int i8 = 0; i8 < size; i8++) {
                            ((LazyLayoutPrefetchState.PrefetchHandle) list.get(i8)).cancel();
                        }
                        mutableIntObjectMap.removeValueAt(i6);
                    }
                    j >>= 8;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowLogic
    public final void setHasLookaheadOccurred() {
        this.hasLookaheadOccurred = true;
    }

    public final void traceWindowInfo$1() {
        int length = this.perLaneCacheWindowStartIndex.length;
        for (int i = 0; i < length; i++) {
            TraceApi29Impl.traceValue(this.perLaneCacheWindowStartSpace[i], IntIntPair$$ExternalSyntheticOutline0.m(i, "perLaneCacheWindowStartSpace lane="));
            TraceApi29Impl.traceValue(this.perLaneCacheWindowEndSpace[i], "perLaneCacheWindowEndSpace lane=" + i);
            TraceApi29Impl.traceValue(this.perLaneCacheWindowStartIndex[i], "perLaneCacheWindowStartIndex lane=" + i);
            TraceApi29Impl.traceValue(this.perLaneCacheWindowEndItemIndex[i], "perLaneCacheWindowEndItemIndex lane=" + i);
        }
    }

    public final void updateEndCacheWindowsState(CacheWindowScope cacheWindowScope, int i, int i2, int i3) {
        this.perLaneCacheWindowEndItemIndex[i] = i2;
        int[] iArr = this.perLaneCacheWindowEndSpace;
        iArr[i] = iArr[i] - i3;
    }

    public final void updateStartCacheWindowsState(CacheWindowScope cacheWindowScope, int i, int i2, int i3) {
        this.perLaneCacheWindowStartIndex[i] = i2;
        int[] iArr = this.perLaneCacheWindowStartSpace;
        iArr[i] = iArr[i] - i3;
    }
}
