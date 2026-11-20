package androidx.compose.animation.core;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyframesSpec implements DurationBasedAnimationSpec {
    public final KeyframesSpecConfig config;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class KeyframeEntity {
        public Easing easing;
        public final Float value;

        public KeyframeEntity(Float f, Easing easing) {
            this.value = f;
            this.easing = easing;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof KeyframeEntity)) {
                return false;
            }
            KeyframeEntity keyframeEntity = (KeyframeEntity) obj;
            return keyframeEntity.value.equals(this.value) && Intrinsics.areEqual(keyframeEntity.easing, this.easing);
        }

        public final int hashCode() {
            return this.easing.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(0, this.value.hashCode() * 31, 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class KeyframesSpecConfig {
        public int durationMillis = 300;
        public final MutableIntObjectMap keyframes;

        public KeyframesSpecConfig() {
            MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
            this.keyframes = new MutableIntObjectMap();
        }

        public final KeyframeEntity at(int i, Float f) {
            KeyframeEntity keyframeEntity = new KeyframeEntity(f, EasingKt.LinearEasing);
            this.keyframes.set(i, keyframeEntity);
            return keyframeEntity;
        }
    }

    public KeyframesSpec(KeyframesSpecConfig keyframesSpecConfig) {
        this.config = keyframesSpecConfig;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public final VectorizedKeyframesSpec vectorize(TwoWayConverterImpl twoWayConverterImpl) {
        int[] iArr;
        Object[] objArr;
        KeyframesSpecConfig keyframesSpecConfig = this.config;
        MutableIntObjectMap mutableIntObjectMap = keyframesSpecConfig.keyframes;
        MutableIntList mutableIntList = new MutableIntList(mutableIntObjectMap._size + 2);
        MutableIntObjectMap mutableIntObjectMap2 = new MutableIntObjectMap(mutableIntObjectMap._size);
        int[] iArr2 = mutableIntObjectMap.keys;
        Object[] objArr2 = mutableIntObjectMap.values;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8;
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    int i4 = 0;
                    while (i4 < i3) {
                        if ((255 & j) < 128) {
                            int i5 = (i << 3) + i4;
                            int i6 = iArr2[i5];
                            KeyframeEntity keyframeEntity = (KeyframeEntity) objArr2[i5];
                            mutableIntList.add(i6);
                            mutableIntObjectMap2.set(i6, new VectorizedKeyframeSpecElementInfo((AnimationVector) twoWayConverterImpl.convertToVector.invoke(keyframeEntity.value), keyframeEntity.easing));
                        }
                        j >>= i2;
                        i4++;
                        i2 = i2;
                        iArr2 = iArr2;
                        objArr2 = objArr2;
                    }
                    iArr = iArr2;
                    objArr = objArr2;
                    if (i3 != i2) {
                        break;
                    }
                } else {
                    iArr = iArr2;
                    objArr = objArr2;
                }
                if (i == length) {
                    break;
                }
                i++;
                iArr2 = iArr;
                objArr2 = objArr;
            }
        }
        if (!mutableIntObjectMap.containsKey(0)) {
            int i7 = mutableIntList._size;
            if (i7 < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
                return null;
            }
            mutableIntList.ensureCapacity(i7 + 1);
            int[] iArr3 = mutableIntList.content;
            int i8 = mutableIntList._size;
            if (i8 != 0) {
                ArraysKt.copyInto(1, 0, i8, iArr3, iArr3);
            }
            iArr3[0] = 0;
            mutableIntList._size++;
        }
        if (!mutableIntObjectMap.containsKey(keyframesSpecConfig.durationMillis)) {
            mutableIntList.add(keyframesSpecConfig.durationMillis);
        }
        int i9 = mutableIntList._size;
        if (i9 != 0) {
            int[] iArr4 = mutableIntList.content;
            iArr4.getClass();
            Arrays.sort(iArr4, 0, i9);
        }
        return new VectorizedKeyframesSpec(mutableIntList, mutableIntObjectMap2, keyframesSpecConfig.durationMillis, EasingKt.LinearEasing);
    }
}
