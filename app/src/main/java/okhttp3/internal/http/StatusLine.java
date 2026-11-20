package okhttp3.internal.http;

import android.os.Handler;
import android.util.SparseArray;
import android.view.MotionEvent;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.DefaultLazyKey;
import androidx.compose.foundation.lazy.layout.IntervalList$Interval;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.spatial.RectListKt;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.exoplayer.source.MediaSourceEventListener$EventDispatcher$ListenerAndHandler;
import androidx.media3.extractor.BinarySearchSeeker$TimestampSearchResult;
import androidx.media3.extractor.BinarySearchSeeker$TimestampSeeker;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.session.MediaLibrarySessionImpl;
import androidx.media3.session.MediaNotificationManager$$ExternalSyntheticLambda8;
import androidx.media3.session.MediaSession$ControllerInfo;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder$DuplicateKey;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableMap;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import okhttp3.Protocol;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class StatusLine implements BinarySearchSeeker$TimestampSeeker, FutureCallback {
    public final /* synthetic */ byte $r8$classId;
    public int code;
    public Object message;
    public Object protocol;

    /* JADX WARN: Code duplicated, block: B:30:0x00de  */
    public StatusLine(IntRange intRange, LazyLayoutKt lazyLayoutKt) {
        Object defaultLazyKey;
        this.$r8$classId = (byte) 2;
        StatusLine intervals = lazyLayoutKt.getIntervals();
        int i = intRange.first;
        if (i < 0) {
            InlineClassHelperKt.throwIllegalStateException("negative nearestRange.first");
        }
        int iMin = Math.min(intRange.last, intervals.code - 1);
        if (iMin < i) {
            MutableObjectIntMap mutableObjectIntMap = ObjectIntMapKt.EmptyObjectIntMap;
            mutableObjectIntMap.getClass();
            this.protocol = mutableObjectIntMap;
            this.message = new Object[0];
            this.code = 0;
            return;
        }
        int i2 = (iMin - i) + 1;
        this.message = new Object[i2];
        this.code = i;
        MutableObjectIntMap mutableObjectIntMap2 = new MutableObjectIntMap(i2);
        MutableVector mutableVector = (MutableVector) intervals.protocol;
        if (i < 0 || i >= intervals.code) {
            InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + i + ", size " + intervals.code);
        }
        if (iMin < 0 || iMin >= intervals.code) {
            InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + iMin + ", size " + intervals.code);
        }
        if (iMin < i) {
            InlineClassHelperKt.throwIllegalArgumentException("toIndex (" + iMin + ") should be not smaller than fromIndex (" + i + ")");
        }
        int iBinarySearch = LazyLayoutKt.binarySearch(i, mutableVector);
        int i3 = ((IntervalList$Interval) mutableVector.content[iBinarySearch]).startIndex;
        while (i3 <= iMin) {
            IntervalList$Interval intervalList$Interval = (IntervalList$Interval) mutableVector.content[iBinarySearch];
            Function1 key = intervalList$Interval.value.getKey();
            int i4 = intervalList$Interval.startIndex;
            int iMax = Math.max(i, i4);
            int iMin2 = Math.min(iMin, (intervalList$Interval.size + i4) - 1);
            if (iMax <= iMin2) {
                while (true) {
                    if (key != null) {
                        defaultLazyKey = key.invoke(Integer.valueOf(iMax - i4));
                        defaultLazyKey = defaultLazyKey == null ? new DefaultLazyKey(iMax) : defaultLazyKey;
                    }
                    mutableObjectIntMap2.set(iMax, defaultLazyKey);
                    ((Object[]) this.message)[iMax - this.code] = defaultLazyKey;
                    iMax = iMax != iMin2 ? iMax + 1 : iMax;
                }
            }
            i3 += intervalList$Interval.size;
            iBinarySearch++;
        }
        this.protocol = mutableObjectIntMap2;
    }

    public void addInterval(int i, LazyLayoutIntervalContent$Interval lazyLayoutIntervalContent$Interval) {
        if (i < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("size should be >=0");
        }
        if (i == 0) {
            return;
        }
        IntervalList$Interval intervalList$Interval = new IntervalList$Interval(this.code, i, lazyLayoutIntervalContent$Interval);
        this.code += i;
        ((MutableVector) this.protocol).add(intervalList$Interval);
    }

    public RegularImmutableMap build(boolean z) {
        ImmutableMap$Builder$DuplicateKey immutableMap$Builder$DuplicateKey;
        ImmutableMap$Builder$DuplicateKey immutableMap$Builder$DuplicateKey2;
        if (z && (immutableMap$Builder$DuplicateKey2 = (ImmutableMap$Builder$DuplicateKey) this.message) != null) {
            throw immutableMap$Builder$DuplicateKey2.exception();
        }
        RegularImmutableMap regularImmutableMapCreate = RegularImmutableMap.create(this.code, (Object[]) this.protocol, this);
        if (!z || (immutableMap$Builder$DuplicateKey = (ImmutableMap$Builder$DuplicateKey) this.message) == null) {
            return regularImmutableMapCreate;
        }
        throw immutableMap$Builder$DuplicateKey.exception();
    }

    public ImmutableMap buildKeepingLast() {
        return build(false);
    }

    public void dispatchEvent(Consumer consumer) {
        for (MediaSourceEventListener$EventDispatcher$ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler : (CopyOnWriteArrayList) this.message) {
            Util.postOrRun(mediaSourceEventListener$EventDispatcher$ListenerAndHandler.handler, new ComponentActivity$$ExternalSyntheticLambda10(consumer, mediaSourceEventListener$EventDispatcher$ListenerAndHandler.listener, (byte) 27));
        }
    }

    public IntervalList$Interval get(int i) {
        if (i < 0 || i >= this.code) {
            InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + i + ", size " + this.code);
        }
        IntervalList$Interval intervalList$Interval = (IntervalList$Interval) this.message;
        if (intervalList$Interval != null) {
            int i2 = intervalList$Interval.startIndex;
            if (i < intervalList$Interval.size + i2 && i2 <= i) {
                return intervalList$Interval;
            }
        }
        MutableVector mutableVector = (MutableVector) this.protocol;
        IntervalList$Interval intervalList$Interval2 = (IntervalList$Interval) mutableVector.content[LazyLayoutKt.binarySearch(i, mutableVector)];
        this.message = intervalList$Interval2;
        return intervalList$Interval2;
    }

    public int getIndex(Object obj) {
        MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) this.protocol;
        int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(obj);
        if (iFindKeyIndex >= 0) {
            return mutableObjectIntMap.values[iFindKeyIndex];
        }
        return -1;
    }

    public Object getKey(int i) {
        Object[] objArr = (Object[]) this.message;
        int i2 = i - this.code;
        if (i2 < 0 || i2 >= objArr.length) {
            return null;
        }
        return objArr[i2];
    }

    public int getRoleFlags() {
        int i = this.code;
        if (i != 2) {
            return i != 3 ? 0 : 512;
        }
        return 2048;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int insert(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2, boolean z3) {
        int i8 = i & 33554431;
        long[] jArr = (long[]) this.protocol;
        int i9 = this.code;
        int i10 = i9 + 3;
        this.code = i10;
        int length = jArr.length;
        if (length <= i10) {
            int iMax = Math.max(length * 2, i10);
            this.protocol = Arrays.copyOf(jArr, iMax);
            this.message = Arrays.copyOf((long[]) this.message, iMax);
        }
        long[] jArr2 = (long[]) this.protocol;
        jArr2[i9] = (((long) i2) << 32) | (((long) i3) & 4294967295L);
        jArr2[i9 + 1] = (((long) i4) << 32) | (((long) i5) & 4294967295L);
        int i11 = i6 & 33554431;
        jArr2[i9 + 2] = ((z3 ? 1L : 0L) << 63) | ((z2 ? 1L : 0L) << 62) | ((z ? 1L : 0L) << 61) | 1152921504606846976L | (((long) Math.min(0, 1023)) << 50) | (((long) i11) << 25) | ((long) (i & 33554431));
        if (i6 == -1) {
            return i9;
        }
        if ((i7 != -4) == false) {
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("Inserted child " + i8 + " without valid parent index");
        }
        int i12 = i7 + 2;
        long j = jArr2[i12];
        if (!((33554431 & ((int) j)) == i11)) {
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("Inserted child " + i8 + " without valid parent index or parent " + i11 + " not found");
        }
        int i13 = RectListKt.$r8$clinit;
        jArr2[i12] = ((-1151795604700004353L) & j) | (((long) Math.min((i9 - i7) / 3, 1023)) << 50);
        return i9;
    }

    @Override // androidx.media3.extractor.BinarySearchSeeker$TimestampSeeker
    public void onSeekFinished() {
        ParsableByteArray parsableByteArray = (ParsableByteArray) this.message;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        parsableByteArray.reset(bArr, bArr.length);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onSuccess(Object obj) {
        List list = (List) obj;
        MediaLibrarySessionImpl mediaLibrarySessionImpl = ((MediaSessionLegacyStub) this.message).sessionImpl;
        Handler handler = mediaLibrarySessionImpl.applicationHandler;
        MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) this.protocol;
        Util.postOrRun(handler, new TransactionExecutor$$ExternalSyntheticLambda0(mediaLibrarySessionImpl, mediaSession$ControllerInfo, new MediaNotificationManager$$ExternalSyntheticLambda8((byte) 1, this.code, this, list, mediaSession$ControllerInfo)));
    }

    public StatusLine put(Object obj, Object obj2) {
        int i = (this.code + 1) * 2;
        Object[] objArr = (Object[]) this.protocol;
        if (i > objArr.length) {
            this.protocol = Arrays.copyOf(objArr, ImmutableCollection.Builder.expandedCapacity(objArr.length, i));
        }
        Maps.checkEntryNotNull(obj, obj2);
        Object[] objArr2 = (Object[]) this.protocol;
        int i2 = this.code;
        int i3 = i2 * 2;
        objArr2[i3] = obj;
        objArr2[i3 + 1] = obj2;
        this.code = i2 + 1;
        return this;
    }

    public StatusLine putAll(Iterable iterable) {
        if (iterable instanceof Collection) {
            int size = (((Collection) iterable).size() + this.code) * 2;
            Object[] objArr = (Object[]) this.protocol;
            if (size > objArr.length) {
                this.protocol = Arrays.copyOf(objArr, ImmutableCollection.Builder.expandedCapacity(objArr.length, size));
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // androidx.media3.extractor.BinarySearchSeeker$TimestampSeeker
    public BinarySearchSeeker$TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) {
        long j2;
        long position = extractorInput.getPosition();
        int iMin = (int) Math.min(112800L, extractorInput.getLength() - position);
        ParsableByteArray parsableByteArray = (ParsableByteArray) this.message;
        parsableByteArray.reset(iMin);
        extractorInput.peekFully(parsableByteArray.data, 0, iMin);
        int i = parsableByteArray.limit;
        long j3 = -1;
        long j4 = -1;
        long j5 = -9223372036854775807L;
        while (true) {
            if (parsableByteArray.bytesLeft() < 188) {
                j2 = -9223372036854775807L;
                break;
            }
            byte[] bArr = parsableByteArray.data;
            int i2 = parsableByteArray.position;
            while (true) {
                if (i2 >= i) {
                    j2 = -9223372036854775807L;
                    break;
                }
                j2 = -9223372036854775807L;
                if (bArr[i2] == 71) {
                    break;
                }
                i2++;
            }
            int i3 = i2 + 188;
            if (i3 > i) {
                break;
            }
            long pcrFromPacket = MathKt.readPcrFromPacket(parsableByteArray, i2, this.code);
            if (pcrFromPacket != j2) {
                long jAdjustTsTimestamp = ((TimestampAdjuster) this.protocol).adjustTsTimestamp(pcrFromPacket);
                if (jAdjustTsTimestamp > j) {
                    return j5 == j2 ? new BinarySearchSeeker$TimestampSearchResult(-1, jAdjustTsTimestamp, position) : new BinarySearchSeeker$TimestampSearchResult(0, -9223372036854775807L, position + j4);
                }
                j5 = jAdjustTsTimestamp;
                if (100000 + j5 > j) {
                    return new BinarySearchSeeker$TimestampSearchResult(0, -9223372036854775807L, position + ((long) i2));
                }
                j4 = i2;
            }
            parsableByteArray.setPosition(i3);
            j3 = i3;
        }
        return j5 != j2 ? new BinarySearchSeeker$TimestampSearchResult(-2, j5, position + j3) : BinarySearchSeeker$TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                StringBuilder sb = new StringBuilder();
                if (((Protocol) this.protocol) == Protocol.HTTP_1_0) {
                    sb.append("HTTP/1.0");
                } else {
                    sb.append("HTTP/1.1");
                }
                sb.append(' ');
                sb.append(this.code);
                sb.append(' ');
                sb.append((String) this.message);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public void updateSubhierarchy(int i, int i2, int i3, long j) {
        long j2;
        char c;
        int i4;
        char c2 = '2';
        if ((((int) (j >> 50)) & 1023) > 0) {
            int i5 = RectListKt.$r8$clinit;
            long j3 = -1125899873288193L;
            int i6 = 33554431;
            char c3 = 25;
            long[] jArr = (long[]) this.protocol;
            long[] jArr2 = (long[]) this.message;
            int i7 = this.code;
            jArr2[0] = (j & (-1125899873288193L)) | (((long) (i & 33554431)) << 25);
            int i8 = 1;
            while (i8 > 0) {
                i8--;
                long j4 = jArr2[i8];
                int i9 = ((int) j4) & i6;
                int i10 = ((int) (j4 >> c3)) & i6;
                int i11 = ((int) (j4 >> c2)) & 1023;
                int i12 = i11 == 1023 ? i7 : (i11 * 3) + i10;
                if (i10 < 0) {
                    return;
                }
                while (i10 < i7 - 2 && i10 <= i12) {
                    int i13 = i10 + 2;
                    long j5 = jArr[i13];
                    char c4 = c2;
                    int i14 = i6;
                    if ((((int) (j5 >> c3)) & i14) == i9) {
                        long j6 = jArr[i10];
                        int i15 = i10 + 1;
                        j2 = j3;
                        long j7 = jArr[i15];
                        c = c3;
                        i4 = i12;
                        jArr[i10] = (((long) (((int) j6) + i3)) & 4294967295L) | (((long) (((int) (j6 >> 32)) + i2)) << 32);
                        jArr[i15] = (((long) (((int) j7) + i3)) & 4294967295L) | (((long) (((int) (j7 >> 32)) + i2)) << 32);
                        jArr[i13] = (((j5 >> 63) & 1) << 60) | j5;
                        if ((((int) (j5 >> c4)) & 1023) > 0) {
                            int i16 = RectListKt.$r8$clinit;
                            jArr2[i8] = (j5 & j2) | (((long) ((i10 + 3) & i14)) << c);
                            i8++;
                        }
                    } else {
                        j2 = j3;
                        c = c3;
                        i4 = i12;
                    }
                    i10 += 3;
                    i12 = i4;
                    c3 = c;
                    i6 = i14;
                    c2 = c4;
                    j3 = j2;
                }
                c3 = c3;
                i6 = i6;
                c2 = c2;
                j3 = j3;
            }
        }
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onFailure(Throwable th) {
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public Object m1910get(int i) {
        SparseArray sparseArray = (SparseArray) this.protocol;
        if (this.code == -1) {
            this.code = 0;
        }
        while (true) {
            int i2 = this.code;
            if (i2 <= 0 || i >= sparseArray.keyAt(i2)) {
                break;
            }
            this.code--;
        }
        while (this.code < sparseArray.size() - 1 && i >= sparseArray.keyAt(this.code + 1)) {
            this.code++;
        }
        return sparseArray.valueAt(this.code);
    }

    public StatusLine(Protocol protocol, int i, String str) {
        this.$r8$classId = (byte) 0;
        this.protocol = protocol;
        this.code = i;
        this.message = str;
    }

    public StatusLine(ArrayList arrayList, int i, MotionEvent motionEvent) {
        this.$r8$classId = (byte) 5;
        this.protocol = arrayList;
        this.code = i;
        this.message = motionEvent;
        if (arrayList.isEmpty()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("changes cannot be empty");
            throw null;
        }
    }

    public /* synthetic */ StatusLine(byte b) {
        this.$r8$classId = b;
    }

    public StatusLine(FrameworkMediaDrm$$ExternalSyntheticLambda0 frameworkMediaDrm$$ExternalSyntheticLambda0) {
        this.$r8$classId = (byte) 8;
        this.protocol = new SparseArray();
        this.message = frameworkMediaDrm$$ExternalSyntheticLambda0;
        this.code = -1;
    }

    public StatusLine(int i, TimestampAdjuster timestampAdjuster) {
        this.$r8$classId = (byte) 9;
        this.code = i;
        this.protocol = timestampAdjuster;
        this.message = new ParsableByteArray();
    }

    public StatusLine() {
        this.$r8$classId = (byte) 1;
        this.protocol = new MutableVector(new IntervalList$Interval[16]);
    }

    public StatusLine(int i, String str, int i2, ArrayList arrayList, byte[] bArr) {
        List listUnmodifiableList;
        this.$r8$classId = (byte) 10;
        this.code = i2;
        if (arrayList == null) {
            listUnmodifiableList = Collections.EMPTY_LIST;
        } else {
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
        }
        this.protocol = listUnmodifiableList;
        this.message = bArr;
    }

    public StatusLine(CopyOnWriteArrayList copyOnWriteArrayList, int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        this.$r8$classId = (byte) 7;
        this.message = copyOnWriteArrayList;
        this.code = i;
        this.protocol = mediaSource$MediaPeriodId;
    }

    public StatusLine(ViewConfiguration viewConfiguration) {
        this.$r8$classId = (byte) 3;
        this.protocol = viewConfiguration;
    }

    public StatusLine(int i) {
        this.$r8$classId = (byte) 12;
        this.protocol = new Object[i * 2];
        this.code = 0;
    }

    public StatusLine(MediaSessionLegacyStub mediaSessionLegacyStub, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i) {
        this.$r8$classId = (byte) 11;
        this.message = mediaSessionLegacyStub;
        this.protocol = mediaSession$ControllerInfo;
        this.code = i;
    }
}
