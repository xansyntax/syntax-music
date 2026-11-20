package androidx.media3.exoplayer.source;

import android.util.SparseArray;
import androidx.compose.ui.platform.WeakCache;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.image.ImageRenderer;
import androidx.media3.exoplayer.upstream.Allocation;
import androidx.media3.extractor.TrackOutput;
import coil3.memory.RealStrongMemoryCache$cache$1;
import coil3.util.UtilsKt;
import io.ktor.client.utils.CIOKt;
import java.io.EOFException;
import java.util.Objects;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SampleQueue implements TrackOutput {
    public int absoluteFirstIndex;
    public DrmSession currentDrmSession;
    public Format downstreamFormat;
    public final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    public final DrmSessionManager drmSessionManager;
    public boolean isLastSampleQueued;
    public int length;
    public boolean loggedUnexpectedNonSyncSample;
    public int readPosition;
    public int relativeFirstIndex;
    public final SampleDataQueue sampleDataQueue;
    public Format upstreamFormat;
    public ProgressiveMediaPeriod upstreamFormatChangeListener;
    public final ImageRenderer.TileInfo extrasHolder = new ImageRenderer.TileInfo();
    public int capacity = CIOKt.DEFAULT_HTTP_POOL_SIZE;
    public long[] sourceIds = new long[CIOKt.DEFAULT_HTTP_POOL_SIZE];
    public long[] offsets = new long[CIOKt.DEFAULT_HTTP_POOL_SIZE];
    public long[] timesUs = new long[CIOKt.DEFAULT_HTTP_POOL_SIZE];
    public int[] flags = new int[CIOKt.DEFAULT_HTTP_POOL_SIZE];
    public int[] sizes = new int[CIOKt.DEFAULT_HTTP_POOL_SIZE];
    public TrackOutput.CryptoData[] cryptoDatas = new TrackOutput.CryptoData[CIOKt.DEFAULT_HTTP_POOL_SIZE];
    public final StatusLine sharedSampleMetadata = new StatusLine(new FrameworkMediaDrm$$ExternalSyntheticLambda0(11));
    public long startTimeUs = Long.MIN_VALUE;
    public long largestDiscardedTimestampUs = Long.MIN_VALUE;
    public long largestQueuedTimestampUs = Long.MIN_VALUE;
    public boolean upstreamFormatRequired = true;
    public boolean upstreamKeyframeRequired = true;
    public boolean discardAllSamplesToStartTime = true;
    public long readEndTimeUs = Long.MIN_VALUE;
    public int readEndTimeAbsoluteIndex = -1;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SharedSampleMetadata {
        public final DrmSessionManager.DrmSessionReference drmSessionReference;
        public final Format format;

        public SharedSampleMetadata(Format format, DrmSessionManager.DrmSessionReference drmSessionReference) {
            this.format = format;
            this.drmSessionReference = drmSessionReference;
        }
    }

    public SampleQueue(EmojiProcessor emojiProcessor, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.drmSessionManager = drmSessionManager;
        this.drmEventDispatcher = eventDispatcher;
        this.sampleDataQueue = new SampleDataQueue(emojiProcessor);
    }

    public final long discardSamples(int i) {
        long j = this.largestDiscardedTimestampUs;
        int i2 = 0;
        long jMax = Long.MIN_VALUE;
        if (i != 0) {
            int relativeIndex = getRelativeIndex(i - 1);
            for (int i3 = 0; i3 < i; i3++) {
                jMax = Math.max(jMax, this.timesUs[relativeIndex]);
                if ((this.flags[relativeIndex] & 1) != 0) {
                    break;
                }
                relativeIndex--;
                if (relativeIndex == -1) {
                    relativeIndex = this.capacity - 1;
                }
            }
        }
        this.largestDiscardedTimestampUs = Math.max(j, jMax);
        this.length -= i;
        int i4 = this.absoluteFirstIndex + i;
        this.absoluteFirstIndex = i4;
        int i5 = this.relativeFirstIndex + i;
        this.relativeFirstIndex = i5;
        int i6 = this.capacity;
        if (i5 >= i6) {
            this.relativeFirstIndex = i5 - i6;
        }
        int i7 = this.readPosition - i;
        this.readPosition = i7;
        if (i7 < 0) {
            this.readPosition = 0;
        }
        StatusLine statusLine = this.sharedSampleMetadata;
        SparseArray sparseArray = (SparseArray) statusLine.protocol;
        while (i2 < sparseArray.size() - 1) {
            int i8 = i2 + 1;
            if (i4 < sparseArray.keyAt(i8)) {
                break;
            }
            ((FrameworkMediaDrm$$ExternalSyntheticLambda0) statusLine.message).accept(sparseArray.valueAt(i2));
            sparseArray.removeAt(i2);
            int i9 = statusLine.code;
            if (i9 > 0) {
                statusLine.code = i9 - 1;
            }
            i2 = i8;
        }
        if (this.length != 0) {
            return this.offsets[this.relativeFirstIndex];
        }
        int i10 = this.relativeFirstIndex;
        if (i10 == 0) {
            i10 = this.capacity;
        }
        int i11 = i10 - 1;
        return this.offsets[i11] + ((long) this.sizes[i11]);
    }

    public final void discardToEnd() {
        long jDiscardSamples;
        SampleDataQueue sampleDataQueue = this.sampleDataQueue;
        synchronized (this) {
            int i = this.length;
            jDiscardSamples = i == 0 ? -1L : discardSamples(i);
        }
        sampleDataQueue.discardDownstreamTo(jDiscardSamples);
    }

    public final int findSampleAfter(int i, int i2, long j, boolean z) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.timesUs[i] >= j) {
                return i3;
            }
            i++;
            if (i == this.capacity) {
                i = 0;
            }
        }
        if (z) {
            return i2;
        }
        return -1;
    }

    public final int findSampleBefore(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.timesUs[i];
            if (j2 > j) {
                break;
            }
            if (!z || (this.flags[i] & 1) != 0) {
                if (j2 == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.capacity) {
                i = 0;
            }
        }
        return i3;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0051 A[Catch: all -> 0x004f, TryCatch #0 {all -> 0x004f, blocks: (B:4:0x0002, B:8:0x000e, B:13:0x0020, B:15:0x0039, B:19:0x0053, B:21:0x005f, B:25:0x0068, B:18:0x0051), top: B:35:0x0002 }] */
    @Override // androidx.media3.extractor.TrackOutput
    public final void format(Format format) {
        boolean z;
        synchronized (this) {
            z = false;
            try {
                this.upstreamFormatRequired = false;
                if (!Objects.equals(format, this.upstreamFormat)) {
                    if (((SparseArray) this.sharedSampleMetadata.protocol).size() == 0) {
                        this.upstreamFormat = format;
                    } else {
                        SparseArray sparseArray = (SparseArray) this.sharedSampleMetadata.protocol;
                        if (((SharedSampleMetadata) sparseArray.valueAt(sparseArray.size() - 1)).format.equals(format)) {
                            SparseArray sparseArray2 = (SparseArray) this.sharedSampleMetadata.protocol;
                            format = ((SharedSampleMetadata) sparseArray2.valueAt(sparseArray2.size() - 1)).format;
                            this.upstreamFormat = format;
                        } else {
                            this.upstreamFormat = format;
                        }
                    }
                    boolean z2 = this.discardAllSamplesToStartTime;
                    String str = format.sampleMimeType;
                    this.discardAllSamplesToStartTime = (MimeTypes.getTrackType(str) == 1 && MimeTypes.allSamplesAreSyncSamples(str, format.codecs)) & z2;
                    this.loggedUnexpectedNonSyncSample = false;
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ProgressiveMediaPeriod progressiveMediaPeriod = this.upstreamFormatChangeListener;
        if (progressiveMediaPeriod == null || !z) {
            return;
        }
        progressiveMediaPeriod.handler.post(progressiveMediaPeriod.maybeFinishPrepareRunnable);
    }

    public final int getRelativeIndex(int i) {
        int i2 = this.relativeFirstIndex + i;
        int i3 = this.capacity;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final synchronized Format getUpstreamFormat() {
        return this.upstreamFormatRequired ? null : this.upstreamFormat;
    }

    public final synchronized boolean isReady(boolean z) {
        Format format;
        int i = this.absoluteFirstIndex;
        int i2 = this.readPosition;
        int i3 = i + i2;
        int i4 = this.readEndTimeAbsoluteIndex;
        boolean z2 = true;
        if (i4 != -1 && i3 >= i4) {
            return true;
        }
        if (i2 != this.length) {
            if (((SharedSampleMetadata) this.sharedSampleMetadata.m1910get(i3)).format != this.downstreamFormat) {
                return true;
            }
            return mayReadSample(getRelativeIndex(this.readPosition));
        }
        if (!z && !this.isLastSampleQueued && ((format = this.upstreamFormat) == null || format == this.downstreamFormat)) {
            z2 = false;
        }
        return z2;
    }

    public final boolean mayReadSample(int i) {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession == null || drmSession.getState() == 4) {
            return true;
        }
        return (this.flags[i] & 1073741824) == 0 && this.currentDrmSession.playClearSamplesWithoutKeys();
    }

    public final void onFormatResult(Format format, WeakCache weakCache) {
        Format format2 = this.downstreamFormat;
        boolean z = format2 == null;
        DrmInitData drmInitData = format2 == null ? null : format2.drmInitData;
        this.downstreamFormat = format;
        DrmInitData drmInitData2 = format.drmInitData;
        DrmSessionManager drmSessionManager = this.drmSessionManager;
        int cryptoType = drmSessionManager.getCryptoType(format);
        Format.Builder builderBuildUpon = format.buildUpon();
        builderBuildUpon.cryptoType = cryptoType;
        weakCache.referenceQueue = new Format(builderBuildUpon);
        weakCache.values = this.currentDrmSession;
        if (z || !Objects.equals(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.currentDrmSession;
            DrmSessionEventListener.EventDispatcher eventDispatcher = this.drmEventDispatcher;
            DrmSession drmSessionAcquireSession = drmSessionManager.acquireSession(eventDispatcher, format);
            this.currentDrmSession = drmSessionAcquireSession;
            weakCache.values = drmSessionAcquireSession;
            if (drmSession != null) {
                drmSession.release(eventDispatcher);
            }
        }
    }

    public final void reset(boolean z) {
        SampleDataQueue sampleDataQueue = this.sampleDataQueue;
        EmojiProcessor emojiProcessor = sampleDataQueue.allocator;
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = sampleDataQueue.firstAllocationNode;
        if (((Allocation) realStrongMemoryCache$cache$1.map) != null) {
            synchronized (emojiProcessor) {
                ((DefaultLoadControl) emojiProcessor.mGlyphChecker).allocator.release(realStrongMemoryCache$cache$1);
                RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$2 = realStrongMemoryCache$cache$1;
                while (realStrongMemoryCache$cache$2 != null) {
                    Allocation allocation = (Allocation) realStrongMemoryCache$cache$2.map;
                    allocation.getClass();
                    emojiProcessor.releaseInternal(allocation);
                    realStrongMemoryCache$cache$2 = (RealStrongMemoryCache$cache$1) realStrongMemoryCache$cache$2.this$0;
                    if (realStrongMemoryCache$cache$2 == null || ((Allocation) realStrongMemoryCache$cache$2.map) == null) {
                        realStrongMemoryCache$cache$2 = null;
                    }
                }
            }
            realStrongMemoryCache$cache$1.map = null;
            realStrongMemoryCache$cache$1.this$0 = null;
        }
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$3 = sampleDataQueue.firstAllocationNode;
        int i = sampleDataQueue.allocationLength;
        UtilsKt.checkState(((Allocation) realStrongMemoryCache$cache$3.map) == null);
        realStrongMemoryCache$cache$3.maxSize = 0L;
        realStrongMemoryCache$cache$3.size = i;
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$4 = sampleDataQueue.firstAllocationNode;
        sampleDataQueue.readAllocationNode = realStrongMemoryCache$cache$4;
        sampleDataQueue.writeAllocationNode = realStrongMemoryCache$cache$4;
        sampleDataQueue.totalBytesWritten = 0L;
        synchronized (emojiProcessor) {
            ((DefaultLoadControl) emojiProcessor.mGlyphChecker).allocator.trim();
        }
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.readEndTimeAbsoluteIndex = -1;
        this.upstreamKeyframeRequired = true;
        this.startTimeUs = Long.MIN_VALUE;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.isLastSampleQueued = false;
        StatusLine statusLine = this.sharedSampleMetadata;
        SparseArray sparseArray = (SparseArray) statusLine.protocol;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            ((FrameworkMediaDrm$$ExternalSyntheticLambda0) statusLine.message).accept(sparseArray.valueAt(i2));
        }
        statusLine.code = -1;
        sparseArray.clear();
        if (z) {
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
            this.discardAllSamplesToStartTime = true;
        }
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
        while (i > 0) {
            SampleDataQueue sampleDataQueue = this.sampleDataQueue;
            int iPreAppend = sampleDataQueue.preAppend(i);
            RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = sampleDataQueue.writeAllocationNode;
            Allocation allocation = (Allocation) realStrongMemoryCache$cache$1.map;
            parsableByteArray.readBytes(allocation.data, ((int) (sampleDataQueue.totalBytesWritten - realStrongMemoryCache$cache$1.maxSize)) + allocation.offset, iPreAppend);
            i -= iPreAppend;
            long j = sampleDataQueue.totalBytesWritten + ((long) iPreAppend);
            sampleDataQueue.totalBytesWritten = j;
            RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$2 = sampleDataQueue.writeAllocationNode;
            if (j == realStrongMemoryCache$cache$2.size) {
                sampleDataQueue.writeAllocationNode = (RealStrongMemoryCache$cache$1) realStrongMemoryCache$cache$2.this$0;
            }
        }
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final int sampleData$1(DataReader dataReader, int i, boolean z) throws EOFException {
        SampleDataQueue sampleDataQueue = this.sampleDataQueue;
        int iPreAppend = sampleDataQueue.preAppend(i);
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = sampleDataQueue.writeAllocationNode;
        Allocation allocation = (Allocation) realStrongMemoryCache$cache$1.map;
        int i2 = dataReader.read(allocation.data, ((int) (sampleDataQueue.totalBytesWritten - realStrongMemoryCache$cache$1.maxSize)) + allocation.offset, iPreAppend);
        if (i2 == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        long j = sampleDataQueue.totalBytesWritten + ((long) i2);
        sampleDataQueue.totalBytesWritten = j;
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$2 = sampleDataQueue.writeAllocationNode;
        if (j == realStrongMemoryCache$cache$2.size) {
            sampleDataQueue.writeAllocationNode = (RealStrongMemoryCache$cache$1) realStrongMemoryCache$cache$2.this$0;
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00dc A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:23:0x0045, B:25:0x0049, B:29:0x005f, B:32:0x0066, B:36:0x006e, B:38:0x0081, B:42:0x0089, B:43:0x0090, B:48:0x00c1, B:67:0x0137, B:69:0x0140, B:50:0x00dc, B:52:0x00fd, B:56:0x0106, B:57:0x010b, B:59:0x0111, B:63:0x011f, B:65:0x0124, B:66:0x0134), top: B:74:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00fd A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:23:0x0045, B:25:0x0049, B:29:0x005f, B:32:0x0066, B:36:0x006e, B:38:0x0081, B:42:0x0089, B:43:0x0090, B:48:0x00c1, B:67:0x0137, B:69:0x0140, B:50:0x00dc, B:52:0x00fd, B:56:0x0106, B:57:0x010b, B:59:0x0111, B:63:0x011f, B:65:0x0124, B:66:0x0134), top: B:74:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0103  */
    /* JADX WARN: Code duplicated, block: B:55:0x0105  */
    /* JADX WARN: Code duplicated, block: B:59:0x0111 A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:23:0x0045, B:25:0x0049, B:29:0x005f, B:32:0x0066, B:36:0x006e, B:38:0x0081, B:42:0x0089, B:43:0x0090, B:48:0x00c1, B:67:0x0137, B:69:0x0140, B:50:0x00dc, B:52:0x00fd, B:56:0x0106, B:57:0x010b, B:59:0x0111, B:63:0x011f, B:65:0x0124, B:66:0x0134), top: B:74:0x0045 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x011c  */
    /* JADX WARN: Code duplicated, block: B:62:0x011e  */
    /* JADX WARN: Code duplicated, block: B:65:0x0124 A[Catch: all -> 0x0063, TryCatch #0 {all -> 0x0063, blocks: (B:23:0x0045, B:25:0x0049, B:29:0x005f, B:32:0x0066, B:36:0x006e, B:38:0x0081, B:42:0x0089, B:43:0x0090, B:48:0x00c1, B:67:0x0137, B:69:0x0140, B:50:0x00dc, B:52:0x00fd, B:56:0x0106, B:57:0x010b, B:59:0x0111, B:63:0x011f, B:65:0x0124, B:66:0x0134), top: B:74:0x0045 }] */
    @Override // androidx.media3.extractor.TrackOutput
    public final void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
        StatusLine statusLine;
        int i4;
        SparseArray sparseArray;
        int iKeyAt;
        boolean z;
        boolean z2;
        int i5 = i & 1;
        boolean z3 = i5 != 0;
        if (this.upstreamKeyframeRequired) {
            if (!z3) {
                return;
            } else {
                this.upstreamKeyframeRequired = false;
            }
        }
        if (this.discardAllSamplesToStartTime) {
            if (j < this.startTimeUs) {
                return;
            }
            if (i5 == 0) {
                if (!this.loggedUnexpectedNonSyncSample) {
                    Log.w("SampleQueue", "Overriding unexpected non-sync sample for format: " + this.upstreamFormat);
                    this.loggedUnexpectedNonSyncSample = true;
                }
                i |= 1;
            }
        }
        long j2 = (this.sampleDataQueue.totalBytesWritten - ((long) i2)) - ((long) i3);
        synchronized (this) {
            try {
                int i6 = this.length;
                if (i6 > 0) {
                    int relativeIndex = getRelativeIndex(i6 - 1);
                    UtilsKt.checkArgument(this.offsets[relativeIndex] + ((long) this.sizes[relativeIndex]) <= j2);
                }
                this.isLastSampleQueued = (536870912 & i) != 0;
                this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j);
                long j3 = this.readEndTimeUs;
                if (j3 != Long.MIN_VALUE && this.readEndTimeAbsoluteIndex == -1 && j >= j3) {
                    this.readEndTimeAbsoluteIndex = this.absoluteFirstIndex + this.length;
                }
                int relativeIndex2 = getRelativeIndex(this.length);
                this.timesUs[relativeIndex2] = j;
                this.offsets[relativeIndex2] = j2;
                this.sizes[relativeIndex2] = i2;
                this.flags[relativeIndex2] = i;
                this.cryptoDatas[relativeIndex2] = cryptoData;
                this.sourceIds[relativeIndex2] = 0;
                if (((SparseArray) this.sharedSampleMetadata.protocol).size() == 0) {
                    Format format = this.upstreamFormat;
                    format.getClass();
                    DrmSessionManager.DrmSessionReference drmSessionReferencePreacquireSession = this.drmSessionManager.preacquireSession(this.drmEventDispatcher, format);
                    statusLine = this.sharedSampleMetadata;
                    i4 = this.absoluteFirstIndex + this.length;
                    SharedSampleMetadata sharedSampleMetadata = new SharedSampleMetadata(format, drmSessionReferencePreacquireSession);
                    sparseArray = (SparseArray) statusLine.protocol;
                    if (statusLine.code == -1) {
                        if (sparseArray.size() == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        UtilsKt.checkState(z2);
                        statusLine.code = 0;
                    }
                    if (sparseArray.size() > 0) {
                        iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
                        if (i4 >= iKeyAt) {
                            z = true;
                        } else {
                            z = false;
                        }
                        UtilsKt.checkArgument(z);
                        if (iKeyAt == i4) {
                            ((FrameworkMediaDrm$$ExternalSyntheticLambda0) statusLine.message).accept(sparseArray.valueAt(sparseArray.size() - 1));
                        }
                    }
                    sparseArray.append(i4, sharedSampleMetadata);
                } else {
                    SparseArray sparseArray2 = (SparseArray) this.sharedSampleMetadata.protocol;
                    if (!((SharedSampleMetadata) sparseArray2.valueAt(sparseArray2.size() - 1)).format.equals(this.upstreamFormat)) {
                        Format format2 = this.upstreamFormat;
                        format2.getClass();
                        DrmSessionManager.DrmSessionReference drmSessionReferencePreacquireSession2 = this.drmSessionManager.preacquireSession(this.drmEventDispatcher, format2);
                        statusLine = this.sharedSampleMetadata;
                        i4 = this.absoluteFirstIndex + this.length;
                        SharedSampleMetadata sharedSampleMetadata2 = new SharedSampleMetadata(format2, drmSessionReferencePreacquireSession2);
                        sparseArray = (SparseArray) statusLine.protocol;
                        if (statusLine.code == -1) {
                            if (sparseArray.size() == 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            UtilsKt.checkState(z2);
                            statusLine.code = 0;
                        }
                        if (sparseArray.size() > 0) {
                            iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
                            if (i4 >= iKeyAt) {
                                z = true;
                            } else {
                                z = false;
                            }
                            UtilsKt.checkArgument(z);
                            if (iKeyAt == i4) {
                                ((FrameworkMediaDrm$$ExternalSyntheticLambda0) statusLine.message).accept(sparseArray.valueAt(sparseArray.size() - 1));
                            }
                        }
                        sparseArray.append(i4, sharedSampleMetadata2);
                    }
                }
                int i7 = this.length + 1;
                this.length = i7;
                int i8 = this.capacity;
                if (i7 == i8) {
                    int i9 = i8 + CIOKt.DEFAULT_HTTP_POOL_SIZE;
                    long[] jArr = new long[i9];
                    long[] jArr2 = new long[i9];
                    long[] jArr3 = new long[i9];
                    int[] iArr = new int[i9];
                    int[] iArr2 = new int[i9];
                    TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i9];
                    int i10 = this.relativeFirstIndex;
                    int i11 = i8 - i10;
                    System.arraycopy(this.offsets, i10, jArr2, 0, i11);
                    System.arraycopy(this.timesUs, this.relativeFirstIndex, jArr3, 0, i11);
                    System.arraycopy(this.flags, this.relativeFirstIndex, iArr, 0, i11);
                    System.arraycopy(this.sizes, this.relativeFirstIndex, iArr2, 0, i11);
                    System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, cryptoDataArr, 0, i11);
                    System.arraycopy(this.sourceIds, this.relativeFirstIndex, jArr, 0, i11);
                    int i12 = this.relativeFirstIndex;
                    System.arraycopy(this.offsets, 0, jArr2, i11, i12);
                    System.arraycopy(this.timesUs, 0, jArr3, i11, i12);
                    System.arraycopy(this.flags, 0, iArr, i11, i12);
                    System.arraycopy(this.sizes, 0, iArr2, i11, i12);
                    System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i11, i12);
                    System.arraycopy(this.sourceIds, 0, jArr, i11, i12);
                    this.offsets = jArr2;
                    this.timesUs = jArr3;
                    this.flags = iArr;
                    this.sizes = iArr2;
                    this.cryptoDatas = cryptoDataArr;
                    this.sourceIds = jArr;
                    this.relativeFirstIndex = 0;
                    this.capacity = i9;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean seekTo(long j, boolean z) {
        Throwable th;
        SampleQueue sampleQueue;
        long j2;
        int iFindSampleBefore;
        try {
            synchronized (this) {
                try {
                    try {
                        synchronized (this) {
                            try {
                                this.readPosition = 0;
                                SampleDataQueue sampleDataQueue = this.sampleDataQueue;
                                sampleDataQueue.readAllocationNode = sampleDataQueue.firstAllocationNode;
                                try {
                                } catch (Throwable th2) {
                                    th = th2;
                                    th = th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                while (true) {
                                    try {
                                        throw th;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        th = th;
                                        throw th;
                                    }
                                }
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            int relativeIndex = getRelativeIndex(0);
            long j3 = this.readEndTimeUs;
            long jMin = this.largestQueuedTimestampUs;
            if (j3 != Long.MIN_VALUE) {
                try {
                    jMin = Math.min(jMin, j3);
                } catch (Throwable th7) {
                    th = th7;
                    this = this;
                }
            }
            int i = this.readPosition;
            int i2 = this.length;
            if (!(i != i2) || j < this.timesUs[relativeIndex] || (j > jMin && !z)) {
                return false;
            }
            if (this.discardAllSamplesToStartTime) {
                sampleQueue = this;
                j2 = j;
                iFindSampleBefore = sampleQueue.findSampleAfter(relativeIndex, i2 - i, j2, z);
            } else {
                sampleQueue = this;
                j2 = j;
                iFindSampleBefore = sampleQueue.findSampleBefore(relativeIndex, i2 - i, j2, true);
            }
            if (iFindSampleBefore == -1) {
                return false;
            }
            sampleQueue.startTimeUs = j2;
            sampleQueue.readPosition += iFindSampleBefore;
            return true;
        } catch (Throwable th8) {
            th = th8;
            this = this;
            th = th;
        }
        throw th;
    }
}
