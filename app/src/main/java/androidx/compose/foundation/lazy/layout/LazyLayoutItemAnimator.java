package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.AbstractClickableNode$handlePressInteractionRelease$1$1;
import androidx.compose.material3.SliderState$$ExternalSyntheticLambda0;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.Arrays;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutItemAnimator {
    public final ArrayList disappearingItems;
    public DisplayingDisappearingItemsNode displayingNode;
    public int firstVisibleIndex;
    public StatusLine keyIndexMap;
    public final MutableScatterMap keyToItemInfoMap;
    public final MutableScatterSet movingAwayKeys;
    public final ArrayList movingAwayToEndBound;
    public final ArrayList movingAwayToStartBound;
    public final ArrayList movingInFromEndBound;
    public final ArrayList movingInFromStartBound;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ItemInfo {
        public Constraints constraints;
        public int crossAxisOffset;
        public int lane;
        public int layoutMaxOffset;
        public int layoutMinOffset;
        public LazyLayoutItemAnimation[] animations = LazyLayoutKt.EmptyArray;
        public int span = 1;

        public ItemInfo() {
        }

        public static void updateAnimation$default(ItemInfo itemInfo, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int i, int i2, boolean z) {
            LazyLayoutItemAnimator.this.getClass();
            long jMo165getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo165getOffsetBjo55l4(0);
            itemInfo.updateAnimation(lazyLayoutMeasuredItem, coroutineScope, graphicsContext, i, i2, (int) (!z ? jMo165getOffsetBjo55l4 & 4294967295L : jMo165getOffsetBjo55l4 >> 32));
        }

        public final void updateAnimation(LazyLayoutMeasuredItem lazyLayoutMeasuredItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int i, int i2, int i3) {
            LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr;
            LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr2 = this.animations;
            int length = lazyLayoutItemAnimationArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    this.layoutMinOffset = i;
                    this.layoutMaxOffset = i2;
                    break;
                } else {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation = lazyLayoutItemAnimationArr2[i4];
                    if (lazyLayoutItemAnimation != null && lazyLayoutItemAnimation.isRunningMovingAwayAnimation) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            int size = lazyLayoutMeasuredItem.getPlaceables().size();
            int length2 = this.animations.length;
            while (true) {
                lazyLayoutItemAnimationArr = this.animations;
                if (size >= length2) {
                    break;
                }
                LazyLayoutItemAnimation lazyLayoutItemAnimation2 = lazyLayoutItemAnimationArr[size];
                if (lazyLayoutItemAnimation2 != null) {
                    lazyLayoutItemAnimation2.release();
                }
                size++;
            }
            if (lazyLayoutItemAnimationArr.length != lazyLayoutMeasuredItem.getPlaceables().size()) {
                this.animations = (LazyLayoutItemAnimation[]) Arrays.copyOf(this.animations, lazyLayoutMeasuredItem.getPlaceables().size());
            }
            this.constraints = new Constraints(lazyLayoutMeasuredItem.mo163getConstraintsmsEJaDk());
            this.crossAxisOffset = i3;
            this.lane = lazyLayoutMeasuredItem.getLane();
            this.span = lazyLayoutMeasuredItem.getSpan();
            int size2 = lazyLayoutMeasuredItem.getPlaceables().size();
            for (int i5 = 0; i5 < size2; i5++) {
                Object parentData = ((Placeable) lazyLayoutMeasuredItem.getPlaceables().get(i5)).getParentData();
                LazyLayoutAnimationSpecsNode lazyLayoutAnimationSpecsNode = parentData instanceof LazyLayoutAnimationSpecsNode ? (LazyLayoutAnimationSpecsNode) parentData : null;
                LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr3 = this.animations;
                if (lazyLayoutAnimationSpecsNode == null) {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation3 = lazyLayoutItemAnimationArr3[i5];
                    if (lazyLayoutItemAnimation3 != null) {
                        lazyLayoutItemAnimation3.release();
                    }
                    this.animations[i5] = null;
                } else {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation4 = lazyLayoutItemAnimationArr3[i5];
                    if (lazyLayoutItemAnimation4 == null) {
                        lazyLayoutItemAnimation4 = new LazyLayoutItemAnimation(coroutineScope, graphicsContext, new SliderState$$ExternalSyntheticLambda0((byte) 9, LazyLayoutItemAnimator.this));
                        this.animations[i5] = lazyLayoutItemAnimation4;
                    }
                    lazyLayoutItemAnimation4.fadeInSpec = lazyLayoutAnimationSpecsNode.fadeInSpec;
                    lazyLayoutItemAnimation4.placementSpec = lazyLayoutAnimationSpecsNode.placementSpec;
                    lazyLayoutItemAnimation4.fadeOutSpec = lazyLayoutAnimationSpecsNode.fadeOutSpec;
                }
            }
        }
    }

    public LazyLayoutItemAnimator() {
        long[] jArr = ScatterMapKt.EmptyGroup;
        this.keyToItemInfoMap = new MutableScatterMap();
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        this.movingAwayKeys = new MutableScatterSet();
        this.movingInFromStartBound = new ArrayList();
        this.movingInFromEndBound = new ArrayList();
        this.movingAwayToStartBound = new ArrayList();
        this.movingAwayToEndBound = new ArrayList();
        this.disappearingItems = new ArrayList();
    }

    public static void initializeAnimation(LazyLayoutMeasuredItem lazyLayoutMeasuredItem, int i, ItemInfo itemInfo, boolean z) {
        int i2 = 0;
        long jMo165getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo165getOffsetBjo55l4(0);
        long jM803copyiSbpLlY$default = z ? IntOffset.m803copyiSbpLlY$default(0, i, 1, jMo165getOffsetBjo55l4) : IntOffset.m803copyiSbpLlY$default(i, 0, 2, jMo165getOffsetBjo55l4);
        LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr = itemInfo.animations;
        int length = lazyLayoutItemAnimationArr.length;
        int i3 = 0;
        while (i2 < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = lazyLayoutItemAnimationArr[i2];
            int i4 = i3 + 1;
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.targetOffset = IntOffset.m806plusqkQi6aY(jM803copyiSbpLlY$default, IntOffset.m805minusqkQi6aY(lazyLayoutMeasuredItem.mo165getOffsetBjo55l4(i3), jMo165getOffsetBjo55l4));
            }
            i2++;
            i3 = i4;
        }
    }

    public static int updateAndReturnOffsetFor(int[] iArr, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, boolean z) {
        int lane = lazyLayoutMeasuredItem.getLane();
        int span = lazyLayoutMeasuredItem.getSpan() + lane;
        int iMax = 0;
        while (lane < span) {
            int iMainAxisSizeWithSpacings = LazyLayoutKt.mainAxisSizeWithSpacings(lazyLayoutMeasuredItem, z) + iArr[lane];
            iArr[lane] = iMainAxisSizeWithSpacings;
            iMax = Math.max(iMax, iMainAxisSizeWithSpacings);
            lane++;
        }
        return iMax;
    }

    public final LazyLayoutItemAnimation getAnimation(int i, Object obj) {
        ItemInfo itemInfo = (ItemInfo) this.keyToItemInfoMap.get(obj);
        if (itemInfo != null) {
            return itemInfo.animations[i];
        }
        return null;
    }

    /* JADX INFO: renamed from: getMinSizeToFitDisappearingItems-YbymL2g, reason: not valid java name */
    public final long m173getMinSizeToFitDisappearingItemsYbymL2g() {
        ArrayList arrayList = this.disappearingItems;
        int size = arrayList.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) arrayList.get(i);
            GraphicsLayer graphicsLayer = lazyLayoutItemAnimation.layer;
            if (graphicsLayer != null) {
                int iMax = Math.max((int) (jMax >> 32), ((int) (lazyLayoutItemAnimation.targetOffset >> 32)) + ((int) (graphicsLayer.size >> 32)));
                jMax = (((long) Math.max((int) (jMax & 4294967295L), ((int) (lazyLayoutItemAnimation.targetOffset & 4294967295L)) + ((int) (graphicsLayer.size & 4294967295L)))) & 4294967295L) | (((long) iMax) << 32);
            }
        }
        return jMax;
    }

    /* JADX WARN: Code duplicated, block: B:177:0x03de  */
    /* JADX WARN: Code duplicated, block: B:212:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:259:0x00d7 A[EDGE_INSN: B:259:0x00d7->B:49:0x00d7 BREAK  A[LOOP:2: B:35:0x0097->B:47:0x00d0], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00ce A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00d0 A[LOOP:2: B:35:0x0097->B:47:0x00d0, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22, types: [kotlin.coroutines.CoroutineContext, kotlinx.coroutines.CoroutineStart] */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r3v33, types: [androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[]] */
    /* JADX WARN: Type inference failed for: r6v50, types: [androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[]] */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.getSVar()" because "result" is null
        	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:118)
        	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:85)
        */
    public final void onMeasured(int r53, int r54, int r55, java.util.ArrayList r56, okhttp3.internal.http.StatusLine r57, androidx.media3.extractor.flv.TagPayloadReader r58, boolean r59, boolean r60, int r61, boolean r62, int r63, int r64, kotlinx.coroutines.CoroutineScope r65, androidx.compose.ui.graphics.GraphicsContext r66, boolean r67) {
        /*
            Method dump skipped, instruction units count: 1577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.onMeasured(int, int, int, java.util.ArrayList, okhttp3.internal.http.StatusLine, androidx.media3.extractor.flv.TagPayloadReader, boolean, boolean, int, boolean, int, int, kotlinx.coroutines.CoroutineScope, androidx.compose.ui.graphics.GraphicsContext, boolean):void");
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x0055 A[LOOP:0: B:7:0x0011->B:22:0x0055, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0058 A[EDGE_INSN: B:26:0x0058->B:23:0x0058 BREAK  A[LOOP:0: B:7:0x0011->B:22:0x0055], SYNTHETIC] */
    public final void releaseAnimations() {
        MutableScatterMap mutableScatterMap = this.keyToItemInfoMap;
        if (mutableScatterMap._size != 0) {
            Object[] objArr = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                for (LazyLayoutItemAnimation lazyLayoutItemAnimation : ((ItemInfo) objArr[(i << 3) + i3]).animations) {
                                    if (lazyLayoutItemAnimation != null) {
                                        lazyLayoutItemAnimation.release();
                                    }
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            mutableScatterMap.clear();
        }
    }

    public final void removeInfoForKey(Object obj) {
        ItemInfo itemInfo = (ItemInfo) this.keyToItemInfoMap.remove(obj);
        if (itemInfo != null) {
            for (LazyLayoutItemAnimation lazyLayoutItemAnimation : itemInfo.animations) {
                if (lazyLayoutItemAnimation != null) {
                    lazyLayoutItemAnimation.release();
                }
            }
        }
    }

    public final void startPlacementAnimationsIfNeeded(LazyLayoutMeasuredItem lazyLayoutMeasuredItem, boolean z) {
        Object obj = this.keyToItemInfoMap.get(lazyLayoutMeasuredItem.getKey());
        obj.getClass();
        LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr = ((ItemInfo) obj).animations;
        int length = lazyLayoutItemAnimationArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = lazyLayoutItemAnimationArr[i];
            int i3 = i2 + 1;
            if (lazyLayoutItemAnimation != null) {
                long jMo165getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo165getOffsetBjo55l4(i2);
                long j = lazyLayoutItemAnimation.targetOffset;
                if (!IntOffset.m804equalsimpl0(j, 9223372034707292159L) && !IntOffset.m804equalsimpl0(j, jMo165getOffsetBjo55l4)) {
                    long jM805minusqkQi6aY = IntOffset.m805minusqkQi6aY(jMo165getOffsetBjo55l4, j);
                    FiniteAnimationSpec finiteAnimationSpec = lazyLayoutItemAnimation.placementSpec;
                    if (finiteAnimationSpec != null) {
                        long jM805minusqkQi6aY2 = IntOffset.m805minusqkQi6aY(((IntOffset) lazyLayoutItemAnimation.placementDelta$delegate.getValue()).packedValue, jM805minusqkQi6aY);
                        lazyLayoutItemAnimation.m172setPlacementDeltagyyYBs(jM805minusqkQi6aY2);
                        lazyLayoutItemAnimation.isPlacementAnimationInProgress$delegate.setValue(Boolean.TRUE);
                        lazyLayoutItemAnimation.isRunningMovingAwayAnimation = z;
                        AwaitKt.launch$default(lazyLayoutItemAnimation.coroutineScope, null, null, new AbstractClickableNode$handlePressInteractionRelease$1$1(lazyLayoutItemAnimation, finiteAnimationSpec, jM805minusqkQi6aY2, null), 3);
                    }
                }
                lazyLayoutItemAnimation.targetOffset = jMo165getOffsetBjo55l4;
            }
            i++;
            i2 = i3;
        }
    }
}
