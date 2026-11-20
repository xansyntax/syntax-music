package coil3.memory;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.upstream.Allocation;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.ogg.OggSeeker;
import coil3.util.UtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RealStrongMemoryCache$cache$1 implements VectorizedAnimationSpec, OggSeeker {
    public Object map;
    public long maxSize;
    public long size;
    public Object this$0;

    public RealStrongMemoryCache$cache$1(long j, int i) {
        UtilsKt.checkState(((Allocation) this.map) == null);
        this.maxSize = j;
        this.size = j + ((long) i);
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    public SeekMap createSeekMap() {
        UtilsKt.checkState(this.maxSize != -1);
        return new SeekMap.Unseekable((FlacStreamMetadata) this.map, this.maxSize, (byte) 1);
    }

    public void entryRemoved(Object obj, Object obj2, RealStrongMemoryCache.InternalValue internalValue) {
        RealStrongMemoryCache.InternalValue internalValue2 = (RealStrongMemoryCache.InternalValue) obj2;
        ((PriorityQueue) ((RealStrongMemoryCache) this.this$0).weakMemoryCache).set((MemoryCache$Key) obj, internalValue2.image, internalValue2.extras, internalValue2.size);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return Long.MAX_VALUE;
    }

    public long getSize() {
        long j = this.size;
        if (j != -1) {
            return j;
        }
        long jSafeSizeOf = 0;
        for (Map.Entry entry : ((LinkedHashMap) this.map).entrySet()) {
            jSafeSizeOf += safeSizeOf(entry.getKey(), entry.getValue());
        }
        this.size = jSafeSizeOf;
        return jSafeSizeOf;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return ((VectorizedDurationBasedAnimationSpec) this.map).getValueFromNanos(repetitionPlayTimeNanos$1(j), animationVector, animationVector2, repetitionStartVelocity$1(j, animationVector, animationVector3, animationVector2));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return ((VectorizedDurationBasedAnimationSpec) this.map).getVelocityFromNanos(repetitionPlayTimeNanos$1(j), animationVector, animationVector2, repetitionStartVelocity$1(j, animationVector, animationVector3, animationVector2));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean isInfinite() {
        return true;
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    public long read(ExtractorInput extractorInput) {
        long j = this.size;
        if (j < 0) {
            return -1L;
        }
        long j2 = -(j + 2);
        this.size = -1L;
        return j2;
    }

    public long repetitionPlayTimeNanos$1(long j) {
        long j2 = this.size;
        if (j + j2 <= 0) {
            return 0L;
        }
        long j3 = j + j2;
        long j4 = this.maxSize;
        long j5 = j3 / j4;
        return (((RepeatMode) this.this$0) == RepeatMode.Restart || j5 % 2 == 0) ? j3 - (j5 * j4) : ((j5 + 1) * j4) - j3;
    }

    public AnimationVector repetitionStartVelocity$1(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        long j2 = this.size;
        long j3 = j + j2;
        long j4 = this.maxSize;
        return j3 > j4 ? ((VectorizedDurationBasedAnimationSpec) this.map).getVelocityFromNanos(j4 - j2, animationVector, animationVector3, animationVector2) : animationVector2;
    }

    public long safeSizeOf(Object obj, Object obj2) throws Exception {
        try {
            long j = ((RealStrongMemoryCache.InternalValue) obj2).size;
            if (j >= 0) {
                return j;
            }
            throw new IllegalStateException(("sizeOf(" + obj + ", " + obj2 + ") returned a negative value: " + j).toString());
        } catch (Exception e) {
            this.size = -1L;
            throw e;
        }
    }

    @Override // androidx.media3.extractor.ogg.OggSeeker
    public void startSeek(long j) {
        long[] jArr = (long[]) ((CallbackWrapper) this.this$0).mCallback;
        this.size = jArr[Util.binarySearchFloor(jArr, j, true)];
    }

    public void trimToSize(long j) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.map;
        while (getSize() > j) {
            if (linkedHashMap.isEmpty()) {
                if (getSize() == 0) {
                    return;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("sizeOf() is returning inconsistent values");
                return;
            } else {
                Map.Entry entry = (Map.Entry) CollectionsKt.first(linkedHashMap.entrySet());
                Object key = entry.getKey();
                Object value = entry.getValue();
                linkedHashMap.remove(key);
                this.size = getSize() - safeSizeOf(key, value);
                entryRemoved(key, value, null);
            }
        }
    }

    public RealStrongMemoryCache$cache$1(String str, byte[] bArr, long j, long j2) {
        this.map = str;
        this.this$0 = bArr;
        this.maxSize = j;
        this.size = j2;
    }
}
