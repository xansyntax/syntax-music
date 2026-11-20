package androidx.media3.exoplayer.mediacodec;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.view.DisplayCompat;
import androidx.datastore.core.AtomicInt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.Util;
import androidx.media3.container.OpusUtil;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.CodecParameters;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.OggOpusAudioPacketizer;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.FrameworkCryptoConfig;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.exoplayer.source.SampleStream;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.materialkolor.quantize.QuantizerWu;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt__IterablesKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaCodecRenderer extends BaseRenderer {
    public static final byte[] ADAPTATION_WORKAROUND_BUFFER = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public CodecParameters activeCodecParameters;
    public final float assumedMinimumCodecOperatingRate;
    public ArrayDeque availableCodecInfos;
    public final DecoderInputBuffer buffer;
    public final BatchBuffer bypassBatchBuffer;
    public boolean bypassDrainAndReinitialize;
    public boolean bypassEnabled;
    public final DecoderInputBuffer bypassSampleBuffer;
    public boolean bypassSampleBufferPending;
    public MediaCodecAdapter codec;
    public final MediaCodecAdapter.Factory codecAdapterFactory;
    public byte codecDrainAction;
    public byte codecDrainState;
    public DrmSession codecDrmSession;
    public boolean codecHasOutputMediaFormat;
    public long codecHotswapDeadlineMs;
    public MediaCodecInfo codecInfo;
    public Format codecInputFormat;
    public boolean codecNeedsAdaptationWorkaroundBuffer;
    public boolean codecNeedsEosPropagation;
    public boolean codecNeedsSosFlushWorkaround;
    public float codecOperatingRate;
    public MediaFormat codecOutputMediaFormat;
    public boolean codecOutputMediaFormatChanged;
    public boolean codecReceivedBuffers;
    public boolean codecReceivedEos;
    public byte codecReconfigurationState;
    public boolean codecReconfigured;
    public boolean codecRegisteredOnBufferAvailableListener;
    public final Context context;
    public float currentPlaybackSpeed;
    public DecoderCounters decoderCounters;
    public boolean experimentalEnableProcessedStreamChangedAtStart;
    public boolean hasSkippedFlushAndWaitingForQueueInputBuffer;
    public Format inputFormat;
    public int inputIndex;
    public boolean inputStreamEnded;
    public boolean isLastOutputBuffer;
    public long largestQueuedPresentationTimeUs;
    public CodecParameters lastDispatchedCodecParameters;
    public long lastOutputBufferProcessedRealtimeMs;
    public long lastProcessedOutputBufferTimeUs;
    public MediaCrypto mediaCrypto;
    public boolean needToNotifyOutputFormatChangeAfterStreamChange;
    public final DecoderInputBuffer noDataBuffer;
    public final OggOpusAudioPacketizer oggOpusAudioPacketizer;
    public ByteBuffer outputBuffer;
    public final MediaCodec.BufferInfo outputBufferInfo;
    public Format outputFormat;
    public int outputIndex;
    public boolean outputStreamEnded;
    public OutputStreamInfo outputStreamInfo;
    public boolean pendingOutputEndOfStream;
    public final ArrayDeque pendingOutputStreamChanges;
    public ExoPlaybackException pendingPlaybackException;
    public DecoderInitializationException preferredDecoderInitializationException;
    public final AtomicInteger readDataResultHolder;
    public boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    public long skippedFlushOffsetUs;
    public DrmSession sourceDrmSession;
    public ImmutableSet subscribedCodecParameterKeys;
    public float targetPlaybackSpeed;
    public boolean waitingForFirstSampleInFormat;
    public ExoPlayerImplInternal.AnonymousClass1 wakeupListener;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class OutputStreamInfo {
        public static final OutputStreamInfo UNSET = new OutputStreamInfo(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L);
        public final TimedValueQueue formatQueue = new TimedValueQueue((byte) 0);
        public long lastBufferTimeUs = -9223372036854775807L;
        public final long previousStreamLastBufferTimeUs;
        public boolean queuedBufferAfterReset;
        public final long startPositionUs;
        public final long streamOffsetUs;

        public OutputStreamInfo(long j, long j2, long j3) {
            this.previousStreamLastBufferTimeUs = j;
            this.startPositionUs = j2;
            this.streamOffsetUs = j3;
        }
    }

    public MediaCodecRenderer(Context context, int i, MediaCodecAdapter.Factory factory, float f) {
        super(i);
        this.context = context.getApplicationContext();
        this.codecAdapterFactory = factory;
        this.assumedMinimumCodecOperatingRate = f;
        this.readDataResultHolder = new AtomicInteger();
        this.noDataBuffer = new DecoderInputBuffer(0);
        this.buffer = new DecoderInputBuffer(0);
        this.bypassSampleBuffer = new DecoderInputBuffer(2);
        BatchBuffer batchBuffer = new BatchBuffer(2);
        batchBuffer.maxSampleCount = (byte) 32;
        this.bypassBatchBuffer = batchBuffer;
        this.outputBufferInfo = new MediaCodec.BufferInfo();
        this.currentPlaybackSpeed = 1.0f;
        this.targetPlaybackSpeed = 1.0f;
        this.pendingOutputStreamChanges = new ArrayDeque();
        this.outputStreamInfo = OutputStreamInfo.UNSET;
        batchBuffer.ensureSpaceForWrite(0);
        batchBuffer.data.order(ByteOrder.nativeOrder());
        OggOpusAudioPacketizer oggOpusAudioPacketizer = new OggOpusAudioPacketizer();
        oggOpusAudioPacketizer.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        oggOpusAudioPacketizer.granulePosition = 0;
        oggOpusAudioPacketizer.pageSequenceNumber = 2;
        this.oggOpusAudioPacketizer = oggOpusAudioPacketizer;
        this.codecOperatingRate = -1.0f;
        this.codecReconfigurationState = (byte) 0;
        this.inputIndex = -1;
        this.outputIndex = -1;
        this.codecHotswapDeadlineMs = -9223372036854775807L;
        this.largestQueuedPresentationTimeUs = -9223372036854775807L;
        this.lastProcessedOutputBufferTimeUs = -9223372036854775807L;
        this.lastOutputBufferProcessedRealtimeMs = -9223372036854775807L;
        this.codecDrainState = (byte) 0;
        this.codecDrainAction = (byte) 0;
        this.decoderCounters = new DecoderCounters();
        this.hasSkippedFlushAndWaitingForQueueInputBuffer = false;
        this.skippedFlushOffsetUs = 0L;
        int i2 = ImmutableSet.$r8$clinit;
        this.subscribedCodecParameterKeys = RegularImmutableSet.EMPTY;
        CodecParameters codecParameters = CodecParameters.EMPTY;
        this.activeCodecParameters = codecParameters;
        this.lastDispatchedCodecParameters = codecParameters;
    }

    public final void applyCodecParametersToMediaFormat(MediaFormat mediaFormat) {
        if (Build.VERSION.SDK_INT >= 29) {
            for (Map.Entry entry : this.activeCodecParameters.params.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    mediaFormat.setString(str, null);
                } else if (value instanceof Integer) {
                    mediaFormat.setInteger(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    mediaFormat.setLong(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    mediaFormat.setFloat(str, ((Float) value).floatValue());
                } else if (value instanceof String) {
                    mediaFormat.setString(str, (String) value);
                } else if (value instanceof ByteBuffer) {
                    mediaFormat.setByteBuffer(str, (ByteBuffer) value);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:114:0x0306  */
    /* JADX WARN: Code duplicated, block: B:117:0x030e A[LOOP:0: B:25:0x0090->B:117:0x030e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:136:0x030c A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r24v0, types: [androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.mediacodec.MediaCodecRenderer] */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r28v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r4v22, types: [int] */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v32, types: [java.util.List] */
    public final boolean bypassRender(long j, long j2) {
        BatchBuffer batchBuffer;
        ?? r4;
        ?? r28;
        UtilsKt.checkState(!this.outputStreamEnded);
        BatchBuffer batchBuffer2 = this.bypassBatchBuffer;
        if (batchBuffer2.hasSamples()) {
            ByteBuffer byteBuffer = batchBuffer2.data;
            int i = this.outputIndex;
            int i2 = batchBuffer2.sampleCount;
            long j3 = batchBuffer2.timeUs;
            boolean zIsDecodeOnly = isDecodeOnly(this.lastResetPositionUs, batchBuffer2.lastSampleTimeUs);
            boolean flag = batchBuffer2.getFlag(4);
            Format format = this.outputFormat;
            format.getClass();
            batchBuffer = batchBuffer2;
            if (processOutputBuffer(j, j2, null, byteBuffer, i, 0, i2, j3, zIsDecodeOnly, flag, format)) {
                onProcessedOutputBuffer$1(batchBuffer.lastSampleTimeUs);
                batchBuffer.clear();
            }
        }
        batchBuffer = batchBuffer2;
        if (this.inputStreamEnded) {
            this.outputStreamEnded = true;
            return false;
        }
        ?? r2 = 0;
        boolean z = this.bypassSampleBufferPending;
        DecoderInputBuffer decoderInputBuffer = this.bypassSampleBuffer;
        if (z) {
            UtilsKt.checkState(batchBuffer.append(decoderInputBuffer));
            this.bypassSampleBufferPending = false;
        }
        if (this.bypassDrainAndReinitialize) {
            if (batchBuffer.hasSamples()) {
                return true;
            }
            this.bypassEnabled = false;
            resetBypassState();
            this.bypassDrainAndReinitialize = false;
            maybeInitCodecOrBypass();
            if (!this.bypassEnabled) {
                return false;
            }
        }
        UtilsKt.checkState(!this.inputStreamEnded);
        WeakCache weakCache = this.formatHolder;
        weakCache.clear();
        decoderInputBuffer.clear();
        while (true) {
            decoderInputBuffer.clear();
            int source = readSource(weakCache, decoderInputBuffer, r2);
            if (source == -5) {
                onInputFormatChanged(weakCache);
            } else if (source != -4) {
                if (source != -3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return r2;
                }
                if (hasReadStreamToEnd()) {
                    getLastOutputStreamInfo().lastBufferTimeUs = this.largestQueuedPresentationTimeUs;
                }
            } else if (decoderInputBuffer.getFlag(4)) {
                this.inputStreamEnded = true;
                getLastOutputStreamInfo().lastBufferTimeUs = this.largestQueuedPresentationTimeUs;
            } else {
                this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, decoderInputBuffer.timeUs);
                if (hasReadStreamToEnd() || this.buffer.getFlag(536870912)) {
                    getLastOutputStreamInfo().lastBufferTimeUs = this.largestQueuedPresentationTimeUs;
                }
                byte[] bArr = null;
                if (this.waitingForFirstSampleInFormat) {
                    Format format2 = this.inputFormat;
                    format2.getClass();
                    this.outputFormat = format2;
                    if (Objects.equals(format2.sampleMimeType, "audio/opus") && !this.outputFormat.initializationData.isEmpty()) {
                        byte[] bArr2 = (byte[]) this.outputFormat.initializationData.get(r2);
                        int i3 = (bArr2[10] & 255) | ((bArr2[11] & 255) << 8);
                        Format.Builder builderBuildUpon = this.outputFormat.buildUpon();
                        builderBuildUpon.encoderDelay = i3;
                        this.outputFormat = new Format(builderBuildUpon);
                    }
                    onOutputFormatChanged(this.outputFormat, null);
                    this.waitingForFirstSampleInFormat = r2;
                }
                decoderInputBuffer.flip();
                Format format3 = this.outputFormat;
                if (format3 != null && Objects.equals(format3.sampleMimeType, "audio/opus")) {
                    if (decoderInputBuffer.getFlag(WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE)) {
                        decoderInputBuffer.format = this.outputFormat;
                        handleInputBufferSupplementalData(decoderInputBuffer);
                    }
                    if (this.lastResetPositionUs - decoderInputBuffer.timeUs <= 80000) {
                        ?? r5 = this.outputFormat.initializationData;
                        decoderInputBuffer.data.getClass();
                        if (decoderInputBuffer.data.limit() - decoderInputBuffer.data.position() != 0) {
                            OggOpusAudioPacketizer oggOpusAudioPacketizer = this.oggOpusAudioPacketizer;
                            if (oggOpusAudioPacketizer.pageSequenceNumber == 2 && (r5.size() == 1 || r5.size() == 3)) {
                                bArr = (byte[]) r5.get(r2);
                            }
                            ByteBuffer byteBuffer2 = decoderInputBuffer.data;
                            int iPosition = byteBuffer2.position();
                            int iLimit = byteBuffer2.limit();
                            int i4 = iLimit - iPosition;
                            int i5 = (i4 + 255) / 255;
                            int i6 = i5 + 27 + i4;
                            if (oggOpusAudioPacketizer.pageSequenceNumber == 2) {
                                int length = bArr != null ? bArr.length + 28 : 47;
                                i6 = (length == true ? 1 : 0) + 44 + i6;
                                r4 = length;
                            } else {
                                r4 = r2;
                            }
                            if (oggOpusAudioPacketizer.outputBuffer.capacity() < i6) {
                                oggOpusAudioPacketizer.outputBuffer = ByteBuffer.allocate(i6).order(ByteOrder.LITTLE_ENDIAN);
                            } else {
                                oggOpusAudioPacketizer.outputBuffer.clear();
                            }
                            ByteBuffer byteBuffer3 = oggOpusAudioPacketizer.outputBuffer;
                            if (oggOpusAudioPacketizer.pageSequenceNumber == 2) {
                                if (bArr != null) {
                                    OggOpusAudioPacketizer.writeOggPacketHeader(byteBuffer3, 0L, 0, 1, true);
                                    byteBuffer3.put(CollectionsKt__IterablesKt.checkedCast(bArr.length));
                                    byteBuffer3.put(bArr);
                                    byteBuffer3.putInt(22, Util.crc32(byteBuffer3.arrayOffset(), bArr.length + 28, 0, byteBuffer3.array()));
                                    byteBuffer3.position(bArr.length + 28);
                                } else {
                                    byteBuffer3.put(OggOpusAudioPacketizer.OGG_DEFAULT_ID_HEADER_PAGE);
                                }
                                byteBuffer3.put(OggOpusAudioPacketizer.OGG_DEFAULT_COMMENT_HEADER_PAGE);
                                r28 = r4;
                            } else {
                                r28 = r4 == true ? 1 : 0;
                                iLimit = iLimit;
                            }
                            int packetDurationUs = oggOpusAudioPacketizer.granulePosition + ((int) ((OpusUtil.getPacketDurationUs(byteBuffer2.get(0), byteBuffer2.limit() > 1 ? byteBuffer2.get(1) : (byte) 0) * 48000) / 1000000));
                            oggOpusAudioPacketizer.granulePosition = packetDurationUs;
                            OggOpusAudioPacketizer.writeOggPacketHeader(byteBuffer3, packetDurationUs, oggOpusAudioPacketizer.pageSequenceNumber, i5, false);
                            for (int i7 = 0; i7 < i5; i7++) {
                                if (i4 >= 255) {
                                    byteBuffer3.put((byte) -1);
                                    i4 -= 255;
                                } else {
                                    byteBuffer3.put((byte) i4);
                                    i4 = 0;
                                }
                            }
                            int i8 = iLimit;
                            while (iPosition < i8) {
                                byteBuffer3.put(byteBuffer2.get(iPosition));
                                iPosition++;
                            }
                            byteBuffer2.position(byteBuffer2.limit());
                            byteBuffer3.flip();
                            if (oggOpusAudioPacketizer.pageSequenceNumber == 2) {
                                byteBuffer3.putInt(r28 + 66, Util.crc32(byteBuffer3.arrayOffset() + r28 + 44, byteBuffer3.limit() - byteBuffer3.position(), 0, byteBuffer3.array()));
                            } else {
                                byteBuffer3.putInt(22, Util.crc32(byteBuffer3.arrayOffset(), byteBuffer3.limit() - byteBuffer3.position(), 0, byteBuffer3.array()));
                            }
                            oggOpusAudioPacketizer.pageSequenceNumber++;
                            oggOpusAudioPacketizer.outputBuffer = byteBuffer3;
                            decoderInputBuffer.clear();
                            decoderInputBuffer.ensureSpaceForWrite(oggOpusAudioPacketizer.outputBuffer.remaining());
                            decoderInputBuffer.data.put(oggOpusAudioPacketizer.outputBuffer);
                            decoderInputBuffer.flip();
                        }
                    }
                }
                if (batchBuffer.hasSamples()) {
                    long j4 = this.lastResetPositionUs;
                    if (isDecodeOnly(j4, batchBuffer.lastSampleTimeUs) == isDecodeOnly(j4, decoderInputBuffer.timeUs)) {
                        if (!batchBuffer.append(decoderInputBuffer)) {
                            r2 = 0;
                        }
                    }
                } else if (!batchBuffer.append(decoderInputBuffer)) {
                    r2 = 0;
                }
                this.bypassSampleBufferPending = true;
            }
            if (batchBuffer.hasSamples()) {
                batchBuffer.flip();
            }
            return batchBuffer.hasSamples() || this.inputStreamEnded || this.bypassDrainAndReinitialize;
        }
    }

    public abstract DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2, boolean z);

    public MediaCodecDecoderException createDecoderException(IllegalStateException illegalStateException, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(illegalStateException, mediaCodecInfo);
    }

    public final boolean drainOutputBuffer(long j, long j2) throws ExoPlaybackException {
        MediaCodecAdapter mediaCodecAdapter = this.codec;
        mediaCodecAdapter.getClass();
        int i = this.outputIndex;
        MediaCodec.BufferInfo bufferInfo = this.outputBufferInfo;
        if (i < 0) {
            int iDequeueOutputBufferIndex = mediaCodecAdapter.dequeueOutputBufferIndex(bufferInfo);
            if (iDequeueOutputBufferIndex < 0) {
                if (iDequeueOutputBufferIndex != -2) {
                    if (this.codecNeedsEosPropagation && (this.inputStreamEnded || this.codecDrainState == 2)) {
                        processEndOfStream();
                    }
                    long j3 = this.lastOutputBufferProcessedRealtimeMs;
                    if (j3 != -9223372036854775807L) {
                        long j4 = j3 + 100;
                        this.clock.getClass();
                        if (j4 < System.currentTimeMillis()) {
                            processEndOfStream();
                            return false;
                        }
                    }
                    return false;
                }
                this.codecHasOutputMediaFormat = true;
                MediaCodecAdapter mediaCodecAdapter2 = this.codec;
                mediaCodecAdapter2.getClass();
                MediaFormat outputFormat = mediaCodecAdapter2.getOutputFormat();
                if (Build.VERSION.SDK_INT >= 29 && !this.subscribedCodecParameterKeys.isEmpty()) {
                    CodecParameters codecParameters = new CodecParameters((HashMap) CodecParameters.createFrom(outputFormat, this.subscribedCodecParameterKeys).delegate);
                    if (!codecParameters.equals(this.lastDispatchedCodecParameters)) {
                        this.lastDispatchedCodecParameters = codecParameters;
                        onCodecParametersChanged(codecParameters);
                    }
                }
                this.codecOutputMediaFormat = outputFormat;
                this.codecOutputMediaFormatChanged = true;
                return true;
            }
            bufferInfo.presentationTimeUs -= this.skippedFlushOffsetUs;
            if (this.shouldSkipAdaptationWorkaroundOutputBuffer) {
                this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
                mediaCodecAdapter.releaseOutputBuffer(iDequeueOutputBufferIndex);
                return true;
            }
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                processEndOfStream();
                return false;
            }
            this.outputIndex = iDequeueOutputBufferIndex;
            ByteBuffer outputBuffer = mediaCodecAdapter.getOutputBuffer(iDequeueOutputBufferIndex);
            this.outputBuffer = outputBuffer;
            if (outputBuffer != null) {
                outputBuffer.position(bufferInfo.offset);
                this.outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
            }
            updateOutputFormatForTime(bufferInfo.presentationTimeUs);
        }
        boolean z = this.hasSkippedFlushAndWaitingForQueueInputBuffer || bufferInfo.presentationTimeUs < this.lastResetPositionUs;
        long j5 = this.outputStreamInfo.lastBufferTimeUs;
        boolean z2 = j5 != -9223372036854775807L && j5 <= bufferInfo.presentationTimeUs;
        this.isLastOutputBuffer = z2;
        ByteBuffer byteBuffer = this.outputBuffer;
        int i2 = this.outputIndex;
        int i3 = bufferInfo.flags;
        long j6 = bufferInfo.presentationTimeUs;
        Format format = this.outputFormat;
        format.getClass();
        if (!processOutputBuffer(j, j2, mediaCodecAdapter, byteBuffer, i2, i3, 1, j6, z, z2, format)) {
            return false;
        }
        onProcessedOutputBuffer$1(bufferInfo.presentationTimeUs);
        boolean z3 = (bufferInfo.flags & 4) != 0;
        if (!z3 && this.codecReceivedEos && this.isLastOutputBuffer) {
            this.clock.getClass();
            this.lastOutputBufferProcessedRealtimeMs = System.currentTimeMillis();
        }
        this.outputIndex = -1;
        this.outputBuffer = null;
        if (!z3) {
            return true;
        }
        processEndOfStream();
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:102:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:111:0x0093 A[EDGE_INSN: B:111:0x0093->B:33:0x0093 BREAK  A[LOOP:0: B:30:0x0071->B:32:0x007e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:20:0x0039  */
    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:25:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x006c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0070  */
    /* JADX WARN: Code duplicated, block: B:32:0x007e A[LOOP:0: B:30:0x0071->B:32:0x007e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:38:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:63:0x010d  */
    /* JADX WARN: Code duplicated, block: B:71:0x0121  */
    /* JADX WARN: Code duplicated, block: B:74:0x012a  */
    /* JADX WARN: Code duplicated, block: B:76:0x0132 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:80:0x0139  */
    /* JADX WARN: Code duplicated, block: B:84:0x014a  */
    /* JADX WARN: Code duplicated, block: B:87:0x016a  */
    /* JADX WARN: Code duplicated, block: B:89:0x0172  */
    /* JADX WARN: Code duplicated, block: B:92:0x0185  */
    /* JADX WARN: Code duplicated, block: B:95:0x018c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0192  */
    public final boolean feedInputBuffer() throws ExoPlaybackException {
        int iPosition;
        WeakCache weakCache;
        int i;
        long j;
        boolean flag;
        int codecBufferFlags;
        long j2;
        int i2;
        long j3;
        int[] iArr;
        int i3;
        Format format;
        DecoderInputBuffer decoderInputBuffer = this.buffer;
        CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
        MediaCodecAdapter mediaCodecAdapter = this.codec;
        if (mediaCodecAdapter != null && this.codecDrainState != 2 && !this.inputStreamEnded) {
            if (this.inputIndex < 0) {
                int iDequeueInputBufferIndex = mediaCodecAdapter.dequeueInputBufferIndex();
                this.inputIndex = iDequeueInputBufferIndex;
                if (iDequeueInputBufferIndex >= 0) {
                    decoderInputBuffer.data = mediaCodecAdapter.getInputBuffer(iDequeueInputBufferIndex);
                    decoderInputBuffer.clear();
                    if (this.codecDrainState == 1) {
                        if (!this.codecNeedsEosPropagation) {
                            this.codecReceivedEos = true;
                            mediaCodecAdapter.queueInputBuffer(this.inputIndex, 0, 4, 0L);
                            this.inputIndex = -1;
                            decoderInputBuffer.data = null;
                        }
                        this.codecDrainState = (byte) 2;
                        return false;
                    }
                    if (this.codecNeedsAdaptationWorkaroundBuffer) {
                        this.codecNeedsAdaptationWorkaroundBuffer = false;
                        ByteBuffer byteBuffer = decoderInputBuffer.data;
                        byteBuffer.getClass();
                        byteBuffer.put(ADAPTATION_WORKAROUND_BUFFER);
                        mediaCodecAdapter.queueInputBuffer(this.inputIndex, 38, 0, 0L);
                        this.inputIndex = -1;
                        decoderInputBuffer.data = null;
                        this.codecReceivedBuffers = true;
                        return true;
                    }
                    if (this.codecReconfigurationState == 1) {
                        i3 = 0;
                        while (true) {
                            format = this.codecInputFormat;
                            format.getClass();
                            if (i3 < format.initializationData.size()) {
                                break;
                            }
                            byte[] bArr = (byte[]) this.codecInputFormat.initializationData.get(i3);
                            ByteBuffer byteBuffer2 = decoderInputBuffer.data;
                            byteBuffer2.getClass();
                            byteBuffer2.put(bArr);
                            i3++;
                        }
                        this.codecReconfigurationState = (byte) 2;
                    }
                    ByteBuffer byteBuffer3 = decoderInputBuffer.data;
                    byteBuffer3.getClass();
                    iPosition = byteBuffer3.position();
                    weakCache = this.formatHolder;
                    weakCache.clear();
                    try {
                        mediaCodecAdapter.useInputBuffer(new ComponentActivity$$ExternalSyntheticLambda10(this, weakCache, (byte) 25));
                        i = this.readDataResultHolder.get();
                        if (i == -3) {
                            if (hasReadStreamToEnd()) {
                                getLastOutputStreamInfo().lastBufferTimeUs = this.largestQueuedPresentationTimeUs;
                                return false;
                            }
                        } else {
                            if (i == -5) {
                                if (this.codecReconfigurationState == 2) {
                                    decoderInputBuffer.clear();
                                    this.codecReconfigurationState = (byte) 1;
                                }
                                onInputFormatChanged(weakCache);
                                return true;
                            }
                            if (decoderInputBuffer.getFlag(4)) {
                                if (!this.codecReceivedBuffers || decoderInputBuffer.getFlag(1)) {
                                    j = decoderInputBuffer.timeUs;
                                    if (!shouldDiscardDecoderInputBuffer(decoderInputBuffer)) {
                                        flag = decoderInputBuffer.getFlag(1073741824);
                                        if (flag && iPosition != 0) {
                                            iArr = cryptoInfo.numBytesOfClearData;
                                            if (iArr == null) {
                                                iArr = new int[1];
                                                cryptoInfo.numBytesOfClearData = iArr;
                                                cryptoInfo.frameworkCryptoInfo.numBytesOfClearData = iArr;
                                            }
                                            iArr[0] = iArr[0] + iPosition;
                                        }
                                        if (this.waitingForFirstSampleInFormat) {
                                            OutputStreamInfo lastOutputStreamInfo = getLastOutputStreamInfo();
                                            TimedValueQueue timedValueQueue = lastOutputStreamInfo.formatQueue;
                                            Format format2 = this.inputFormat;
                                            format2.getClass();
                                            timedValueQueue.add(j, format2);
                                            lastOutputStreamInfo.queuedBufferAfterReset = true;
                                            this.waitingForFirstSampleInFormat = false;
                                        }
                                        this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, j);
                                        if (hasReadStreamToEnd() || decoderInputBuffer.getFlag(536870912)) {
                                            getLastOutputStreamInfo().lastBufferTimeUs = this.largestQueuedPresentationTimeUs;
                                        }
                                        decoderInputBuffer.flip();
                                        if (decoderInputBuffer.getFlag(WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE)) {
                                            handleInputBufferSupplementalData(decoderInputBuffer);
                                        }
                                        if (this.hasSkippedFlushAndWaitingForQueueInputBuffer) {
                                            j3 = this.largestQueuedPresentationTimeUs;
                                            if (j <= j3) {
                                                this.skippedFlushOffsetUs = (j3 - j) + 1 + this.skippedFlushOffsetUs;
                                            }
                                            this.largestQueuedPresentationTimeUs = j;
                                            this.hasSkippedFlushAndWaitingForQueueInputBuffer = false;
                                        }
                                        onQueueInputBuffer(decoderInputBuffer);
                                        codecBufferFlags = getCodecBufferFlags(decoderInputBuffer);
                                        j2 = this.skippedFlushOffsetUs + j;
                                        i2 = this.inputIndex;
                                        if (flag) {
                                            mediaCodecAdapter.queueSecureInputBuffer(i2, cryptoInfo, j2, codecBufferFlags);
                                        } else {
                                            ByteBuffer byteBuffer4 = decoderInputBuffer.data;
                                            byteBuffer4.getClass();
                                            mediaCodecAdapter.queueInputBuffer(i2, byteBuffer4.limit(), codecBufferFlags, j2);
                                        }
                                        this.inputIndex = -1;
                                        decoderInputBuffer.data = null;
                                        this.codecReceivedBuffers = true;
                                        this.codecReconfigurationState = (byte) 0;
                                        this.decoderCounters.queuedInputBufferCount++;
                                        return true;
                                    }
                                } else {
                                    decoderInputBuffer.clear();
                                    if (this.codecReconfigurationState == 2) {
                                        this.codecReconfigurationState = (byte) 1;
                                        return true;
                                    }
                                }
                                return true;
                            }
                            getLastOutputStreamInfo().lastBufferTimeUs = this.largestQueuedPresentationTimeUs;
                            if (this.codecReconfigurationState == 2) {
                                decoderInputBuffer.clear();
                                this.codecReconfigurationState = (byte) 1;
                            }
                            this.inputStreamEnded = true;
                            if (!this.codecReceivedBuffers) {
                                processEndOfStream();
                                return false;
                            }
                            if (!this.codecNeedsEosPropagation) {
                                this.codecReceivedEos = true;
                                mediaCodecAdapter.queueInputBuffer(this.inputIndex, 0, 4, 0L);
                                this.inputIndex = -1;
                                decoderInputBuffer.data = null;
                                return false;
                            }
                        }
                    } catch (DecoderInputBuffer.InsufficientCapacityException e) {
                        onCodecError(e);
                        readSourceOmittingSampleData(0);
                        flushCodec();
                        return true;
                    }
                }
            } else {
                if (this.codecDrainState == 1) {
                    if (!this.codecNeedsEosPropagation) {
                        this.codecReceivedEos = true;
                        mediaCodecAdapter.queueInputBuffer(this.inputIndex, 0, 4, 0L);
                        this.inputIndex = -1;
                        decoderInputBuffer.data = null;
                    }
                    this.codecDrainState = (byte) 2;
                    return false;
                }
                if (this.codecNeedsAdaptationWorkaroundBuffer) {
                    this.codecNeedsAdaptationWorkaroundBuffer = false;
                    ByteBuffer byteBuffer5 = decoderInputBuffer.data;
                    byteBuffer5.getClass();
                    byteBuffer5.put(ADAPTATION_WORKAROUND_BUFFER);
                    mediaCodecAdapter.queueInputBuffer(this.inputIndex, 38, 0, 0L);
                    this.inputIndex = -1;
                    decoderInputBuffer.data = null;
                    this.codecReceivedBuffers = true;
                    return true;
                }
                if (this.codecReconfigurationState == 1) {
                    i3 = 0;
                    while (true) {
                        format = this.codecInputFormat;
                        format.getClass();
                        if (i3 < format.initializationData.size()) {
                            break;
                            break;
                        }
                        byte[] bArr2 = (byte[]) this.codecInputFormat.initializationData.get(i3);
                        ByteBuffer byteBuffer6 = decoderInputBuffer.data;
                        byteBuffer6.getClass();
                        byteBuffer6.put(bArr2);
                        i3++;
                    }
                    this.codecReconfigurationState = (byte) 2;
                }
                ByteBuffer byteBuffer7 = decoderInputBuffer.data;
                byteBuffer7.getClass();
                iPosition = byteBuffer7.position();
                weakCache = this.formatHolder;
                weakCache.clear();
                mediaCodecAdapter.useInputBuffer(new ComponentActivity$$ExternalSyntheticLambda10(this, weakCache, (byte) 25));
                i = this.readDataResultHolder.get();
                if (i == -3) {
                    if (hasReadStreamToEnd()) {
                        getLastOutputStreamInfo().lastBufferTimeUs = this.largestQueuedPresentationTimeUs;
                        return false;
                    }
                } else {
                    if (i == -5) {
                        if (this.codecReconfigurationState == 2) {
                            decoderInputBuffer.clear();
                            this.codecReconfigurationState = (byte) 1;
                        }
                        onInputFormatChanged(weakCache);
                        return true;
                    }
                    if (decoderInputBuffer.getFlag(4)) {
                        if (this.codecReceivedBuffers) {
                            j = decoderInputBuffer.timeUs;
                            if (!shouldDiscardDecoderInputBuffer(decoderInputBuffer)) {
                                flag = decoderInputBuffer.getFlag(1073741824);
                                if (flag) {
                                    iArr = cryptoInfo.numBytesOfClearData;
                                    if (iArr == null) {
                                        iArr = new int[1];
                                        cryptoInfo.numBytesOfClearData = iArr;
                                        cryptoInfo.frameworkCryptoInfo.numBytesOfClearData = iArr;
                                    }
                                    iArr[0] = iArr[0] + iPosition;
                                }
                                if (this.waitingForFirstSampleInFormat) {
                                    OutputStreamInfo lastOutputStreamInfo2 = getLastOutputStreamInfo();
                                    TimedValueQueue timedValueQueue2 = lastOutputStreamInfo2.formatQueue;
                                    Format format3 = this.inputFormat;
                                    format3.getClass();
                                    timedValueQueue2.add(j, format3);
                                    lastOutputStreamInfo2.queuedBufferAfterReset = true;
                                    this.waitingForFirstSampleInFormat = false;
                                }
                                this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, j);
                                if (hasReadStreamToEnd()) {
                                    getLastOutputStreamInfo().lastBufferTimeUs = this.largestQueuedPresentationTimeUs;
                                } else {
                                    getLastOutputStreamInfo().lastBufferTimeUs = this.largestQueuedPresentationTimeUs;
                                }
                                decoderInputBuffer.flip();
                                if (decoderInputBuffer.getFlag(WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE)) {
                                    handleInputBufferSupplementalData(decoderInputBuffer);
                                }
                                if (this.hasSkippedFlushAndWaitingForQueueInputBuffer) {
                                    j3 = this.largestQueuedPresentationTimeUs;
                                    if (j <= j3) {
                                        this.skippedFlushOffsetUs = (j3 - j) + 1 + this.skippedFlushOffsetUs;
                                    }
                                    this.largestQueuedPresentationTimeUs = j;
                                    this.hasSkippedFlushAndWaitingForQueueInputBuffer = false;
                                }
                                onQueueInputBuffer(decoderInputBuffer);
                                codecBufferFlags = getCodecBufferFlags(decoderInputBuffer);
                                j2 = this.skippedFlushOffsetUs + j;
                                i2 = this.inputIndex;
                                if (flag) {
                                    mediaCodecAdapter.queueSecureInputBuffer(i2, cryptoInfo, j2, codecBufferFlags);
                                } else {
                                    ByteBuffer byteBuffer8 = decoderInputBuffer.data;
                                    byteBuffer8.getClass();
                                    mediaCodecAdapter.queueInputBuffer(i2, byteBuffer8.limit(), codecBufferFlags, j2);
                                }
                                this.inputIndex = -1;
                                decoderInputBuffer.data = null;
                                this.codecReceivedBuffers = true;
                                this.codecReconfigurationState = (byte) 0;
                                this.decoderCounters.queuedInputBufferCount++;
                                return true;
                            }
                        } else {
                            j = decoderInputBuffer.timeUs;
                            if (!shouldDiscardDecoderInputBuffer(decoderInputBuffer)) {
                                flag = decoderInputBuffer.getFlag(1073741824);
                                if (flag) {
                                    iArr = cryptoInfo.numBytesOfClearData;
                                    if (iArr == null) {
                                        iArr = new int[1];
                                        cryptoInfo.numBytesOfClearData = iArr;
                                        cryptoInfo.frameworkCryptoInfo.numBytesOfClearData = iArr;
                                    }
                                    iArr[0] = iArr[0] + iPosition;
                                }
                                if (this.waitingForFirstSampleInFormat) {
                                    OutputStreamInfo lastOutputStreamInfo3 = getLastOutputStreamInfo();
                                    TimedValueQueue timedValueQueue3 = lastOutputStreamInfo3.formatQueue;
                                    Format format4 = this.inputFormat;
                                    format4.getClass();
                                    timedValueQueue3.add(j, format4);
                                    lastOutputStreamInfo3.queuedBufferAfterReset = true;
                                    this.waitingForFirstSampleInFormat = false;
                                }
                                this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, j);
                                if (hasReadStreamToEnd()) {
                                    getLastOutputStreamInfo().lastBufferTimeUs = this.largestQueuedPresentationTimeUs;
                                } else {
                                    getLastOutputStreamInfo().lastBufferTimeUs = this.largestQueuedPresentationTimeUs;
                                }
                                decoderInputBuffer.flip();
                                if (decoderInputBuffer.getFlag(WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE)) {
                                    handleInputBufferSupplementalData(decoderInputBuffer);
                                }
                                if (this.hasSkippedFlushAndWaitingForQueueInputBuffer) {
                                    j3 = this.largestQueuedPresentationTimeUs;
                                    if (j <= j3) {
                                        this.skippedFlushOffsetUs = (j3 - j) + 1 + this.skippedFlushOffsetUs;
                                    }
                                    this.largestQueuedPresentationTimeUs = j;
                                    this.hasSkippedFlushAndWaitingForQueueInputBuffer = false;
                                }
                                onQueueInputBuffer(decoderInputBuffer);
                                codecBufferFlags = getCodecBufferFlags(decoderInputBuffer);
                                j2 = this.skippedFlushOffsetUs + j;
                                i2 = this.inputIndex;
                                if (flag) {
                                    mediaCodecAdapter.queueSecureInputBuffer(i2, cryptoInfo, j2, codecBufferFlags);
                                } else {
                                    ByteBuffer byteBuffer9 = decoderInputBuffer.data;
                                    byteBuffer9.getClass();
                                    mediaCodecAdapter.queueInputBuffer(i2, byteBuffer9.limit(), codecBufferFlags, j2);
                                }
                                this.inputIndex = -1;
                                decoderInputBuffer.data = null;
                                this.codecReceivedBuffers = true;
                                this.codecReconfigurationState = (byte) 0;
                                this.decoderCounters.queuedInputBufferCount++;
                                return true;
                            }
                        }
                        return true;
                    }
                    getLastOutputStreamInfo().lastBufferTimeUs = this.largestQueuedPresentationTimeUs;
                    if (this.codecReconfigurationState == 2) {
                        decoderInputBuffer.clear();
                        this.codecReconfigurationState = (byte) 1;
                    }
                    this.inputStreamEnded = true;
                    if (!this.codecReceivedBuffers) {
                        processEndOfStream();
                        return false;
                    }
                    if (!this.codecNeedsEosPropagation) {
                        this.codecReceivedEos = true;
                        mediaCodecAdapter.queueInputBuffer(this.inputIndex, 0, 4, 0L);
                        this.inputIndex = -1;
                        decoderInputBuffer.data = null;
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public final void flushCodec() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.codec;
            mediaCodecAdapter.getClass();
            mediaCodecAdapter.flush();
        } finally {
            resetCodecStateForFlush();
        }
    }

    public final List getAvailableCodecInfos(boolean z) {
        Format format = this.inputFormat;
        format.getClass();
        ArrayList decoderInfos = getDecoderInfos(format, z);
        if (!decoderInfos.isEmpty() || !z) {
            return decoderInfos;
        }
        ArrayList decoderInfos2 = getDecoderInfos(format, false);
        if (!decoderInfos2.isEmpty()) {
            Log.w("MediaCodecRenderer", "Drm session requires secure decoder for " + format.sampleMimeType + ", but no secure decoder available. Trying to proceed with " + decoderInfos2 + ".");
        }
        return decoderInfos2;
    }

    public int getCodecBufferFlags(DecoderInputBuffer decoderInputBuffer) {
        return 0;
    }

    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        int iMax = -1;
        for (Format format2 : formatArr) {
            int i = format2.sampleRate;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f;
    }

    public abstract ArrayList getDecoderInfos(Format format, boolean z);

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final long getDurationToProgressUs(long j, long j2) {
        return getDurationToProgressUs(j, j2, this.codecRegisteredOnBufferAvailableListener);
    }

    public final OutputStreamInfo getLastOutputStreamInfo() {
        ArrayDeque arrayDeque = this.pendingOutputStreamChanges;
        return !arrayDeque.isEmpty() ? (OutputStreamInfo) arrayDeque.getLast() : this.outputStreamInfo;
    }

    public abstract QuantizerWu getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f);

    public abstract void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer);

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void handleMessage(int i, Object obj) {
        int i2;
        if (i == 11) {
            ExoPlayerImplInternal.AnonymousClass1 anonymousClass1 = (ExoPlayerImplInternal.AnonymousClass1) obj;
            anonymousClass1.getClass();
            this.wakeupListener = anonymousClass1;
            return;
        }
        if (i != 21) {
            if (i == 22 && (i2 = Build.VERSION.SDK_INT) >= 29) {
                obj.getClass();
                ImmutableSet immutableSet = (ImmutableSet) obj;
                if (this.subscribedCodecParameterKeys.equals(immutableSet)) {
                    return;
                }
                if (i2 >= 31) {
                    HashSet hashSet = new HashSet(immutableSet);
                    HashSet hashSet2 = new HashSet();
                    UnmodifiableIterator it = this.subscribedCodecParameterKeys.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!hashSet.remove(str)) {
                            hashSet2.add(str);
                        }
                    }
                    MediaCodecAdapter mediaCodecAdapter = this.codec;
                    if (mediaCodecAdapter != null) {
                        if (!hashSet2.isEmpty()) {
                            mediaCodecAdapter.unsubscribeFromVendorParameters(new ArrayList(hashSet2));
                        }
                        if (!hashSet.isEmpty()) {
                            mediaCodecAdapter.subscribeToVendorParameters(new ArrayList(hashSet));
                        }
                    }
                }
                this.subscribedCodecParameterKeys = immutableSet;
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            obj.getClass();
            CodecParameters codecParameters = (CodecParameters) obj;
            this.activeCodecParameters = codecParameters;
            MediaCodecAdapter mediaCodecAdapter2 = this.codec;
            if (mediaCodecAdapter2 != null) {
                Bundle bundle = new Bundle();
                for (Map.Entry entry : codecParameters.params.entrySet()) {
                    String str2 = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value != null) {
                        if (value instanceof Integer) {
                            bundle.putInt(str2, ((Integer) value).intValue());
                        } else if (value instanceof Long) {
                            bundle.putLong(str2, ((Long) value).longValue());
                        } else if (value instanceof Float) {
                            bundle.putFloat(str2, ((Float) value).floatValue());
                        } else if (value instanceof String) {
                            bundle.putString(str2, (String) value);
                        } else if (value instanceof ByteBuffer) {
                            ByteBuffer byteBuffer = (ByteBuffer) value;
                            byte[] bArr = new byte[byteBuffer.remaining()];
                            byteBuffer.duplicate().get(bArr);
                            bundle.putByteArray(str2, bArr);
                        }
                    }
                }
                mediaCodecAdapter2.setParameters(bundle);
            }
        }
    }

    public final void initCodec(MediaCodecInfo mediaCodecInfo, MediaCrypto mediaCrypto) {
        this.codecInfo = mediaCodecInfo;
        Format format = this.inputFormat;
        format.getClass();
        String str = mediaCodecInfo.name;
        float f = this.targetPlaybackSpeed;
        Format[] formatArr = this.streamFormats;
        formatArr.getClass();
        float codecOperatingRateV23 = getCodecOperatingRateV23(f, format, formatArr);
        if (codecOperatingRateV23 <= this.assumedMinimumCodecOperatingRate) {
            codecOperatingRateV23 = -1.0f;
        }
        this.clock.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        QuantizerWu mediaCodecConfiguration = getMediaCodecConfiguration(mediaCodecInfo, format, mediaCrypto, codecOperatingRateV23);
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            PlayerId playerId = this.playerId;
            playerId.getClass();
            DisplayCompat.setLogSessionIdToMediaCodecFormat(mediaCodecConfiguration, playerId);
        }
        try {
            Trace.beginSection("createCodec:" + str);
            MediaCodecAdapter mediaCodecAdapterCreateAdapter = this.codecAdapterFactory.createAdapter(mediaCodecConfiguration);
            this.codec = mediaCodecAdapterCreateAdapter;
            this.codecRegisteredOnBufferAvailableListener = mediaCodecAdapterCreateAdapter.registerOnBufferAvailableListener(new AtomicInt(this));
            Trace.endSection();
            this.clock.getClass();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            if (!mediaCodecInfo.isFormatSupported(this.context, format)) {
                String logString = Format.toLogString(format);
                Locale locale = Locale.US;
                Log.w("MediaCodecRenderer", Fragment$5$$ExternalSyntheticOutline0.m("Format exceeds selected codec's capabilities [", logString, ", ", str, "]"));
            }
            this.codecOperatingRate = codecOperatingRateV23;
            this.codecInputFormat = format;
            boolean z = false;
            this.codecNeedsSosFlushWorkaround = i == 29 && "c2.android.aac.decoder".equals(str);
            String str2 = mediaCodecInfo.name;
            if ((i <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str2) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str2) || "OMX.bcm.vdec.avc.tunnel".equals(str2) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str2) || "OMX.bcm.vdec.hevc.tunnel".equals(str2) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str2))) || ("Amazon".equals(Build.MANUFACTURER) && "AFTS".equals(Build.MODEL) && mediaCodecInfo.secure)) {
                z = true;
            }
            this.codecNeedsEosPropagation = z;
            this.codec.getClass();
            if (this.state == 2) {
                this.clock.getClass();
                this.codecHotswapDeadlineMs = SystemClock.elapsedRealtime() + 1000;
            }
            this.decoderCounters.decoderInitCount++;
            long j = jElapsedRealtime2 - jElapsedRealtime;
            if (i >= 31 && !this.subscribedCodecParameterKeys.isEmpty()) {
                MediaCodecAdapter mediaCodecAdapter = this.codec;
                mediaCodecAdapter.getClass();
                mediaCodecAdapter.subscribeToVendorParameters(new ArrayList(this.subscribedCodecParameterKeys));
            }
            onCodecInitialized(jElapsedRealtime2, j, str);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final boolean isDecodeOnly(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        Format format = this.outputFormat;
        return format == null || !Objects.equals(format.sampleMimeType, "audio/opus") || j - j2 > 80000;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a1 A[Catch: DecoderInitializationException -> 0x00b1, TryCatch #0 {DecoderInitializationException -> 0x00b1, blocks: (B:47:0x009d, B:49:0x00a1, B:51:0x00a8, B:56:0x00b3, B:60:0x00c0), top: B:70:0x009d }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void maybeInitCodecOrBypass() {
        Format format;
        DrmSession drmSession;
        if (this.codec != null || this.bypassEnabled || (format = this.inputFormat) == null) {
            return;
        }
        String str = format.sampleMimeType;
        boolean z = true;
        if (this.sourceDrmSession == null && shouldUseBypass(format)) {
            this.bypassEnabled = false;
            resetBypassState();
            boolean zEquals = "audio/mp4a-latm".equals(str);
            BatchBuffer batchBuffer = this.bypassBatchBuffer;
            if (zEquals || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
                batchBuffer.maxSampleCount = (byte) 32;
            } else {
                batchBuffer.maxSampleCount = (byte) 1;
            }
            this.bypassEnabled = true;
            return;
        }
        setCodecDrmSession(this.sourceDrmSession);
        if (this.codecDrmSession == null) {
            try {
                drmSession = this.codecDrmSession;
                if (drmSession == null && (drmSession.getState() == 3 || this.codecDrmSession.getState() == 4)) {
                    DrmSession drmSession2 = this.codecDrmSession;
                    str.getClass();
                    if (!drmSession2.requiresSecureDecoder(str)) {
                        z = false;
                    }
                } else {
                    z = false;
                }
                maybeInitCodecWithFallback(this.mediaCrypto, z);
            } catch (DecoderInitializationException e) {
                throw createRendererException(e, format, false, 4001);
            }
        } else {
            UtilsKt.checkState(this.mediaCrypto == null);
            DrmSession drmSession3 = this.codecDrmSession;
            FrameworkCryptoConfig cryptoConfig = drmSession3.getCryptoConfig();
            if (!FrameworkCryptoConfig.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC || cryptoConfig == null) {
                if (cryptoConfig == null) {
                    try {
                        this.mediaCrypto = new MediaCrypto(cryptoConfig.uuid, cryptoConfig.sessionId);
                    } catch (MediaCryptoException e2) {
                        throw createRendererException(e2, this.inputFormat, false, 6006);
                    }
                } else if (drmSession3.getError() != null) {
                }
                drmSession = this.codecDrmSession;
                if (drmSession == null) {
                    z = false;
                } else {
                    z = false;
                }
                maybeInitCodecWithFallback(this.mediaCrypto, z);
            } else {
                int state = drmSession3.getState();
                if (state == 1) {
                    DrmSession.DrmSessionException error = drmSession3.getError();
                    error.getClass();
                    throw createRendererException(error, this.inputFormat, false, error.errorCode);
                }
                if (state == 4) {
                    if (cryptoConfig == null) {
                        this.mediaCrypto = new MediaCrypto(cryptoConfig.uuid, cryptoConfig.sessionId);
                    } else if (drmSession3.getError() != null) {
                    }
                    drmSession = this.codecDrmSession;
                    if (drmSession == null) {
                        z = false;
                    } else {
                        z = false;
                    }
                    maybeInitCodecWithFallback(this.mediaCrypto, z);
                }
            }
        }
        MediaCrypto mediaCrypto = this.mediaCrypto;
        if (mediaCrypto == null || this.codec != null) {
            return;
        }
        mediaCrypto.release();
        this.mediaCrypto = null;
    }

    public final void maybeInitCodecWithFallback(MediaCrypto mediaCrypto, boolean z) throws DecoderInitializationException {
        Format format = this.inputFormat;
        format.getClass();
        if (this.availableCodecInfos == null) {
            try {
                List availableCodecInfos = getAvailableCodecInfos(z);
                this.availableCodecInfos = new ArrayDeque();
                ArrayList arrayList = (ArrayList) availableCodecInfos;
                if (!arrayList.isEmpty()) {
                    this.availableCodecInfos.add((MediaCodecInfo) arrayList.get(0));
                }
                this.preferredDecoderInitializationException = null;
            } catch (MediaCodecUtil.DecoderQueryException e) {
                throw new DecoderInitializationException(format, e, z, -49998);
            }
        }
        if (this.availableCodecInfos.isEmpty()) {
            throw new DecoderInitializationException(format, null, z, -49999);
        }
        ArrayDeque arrayDeque = this.availableCodecInfos;
        arrayDeque.getClass();
        while (this.codec == null) {
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) arrayDeque.peekFirst();
            mediaCodecInfo.getClass();
            if (!maybeInitializeProcessingPipeline(format) || !shouldInitCodec(mediaCodecInfo)) {
                return;
            }
            try {
                initCodec(mediaCodecInfo, mediaCrypto);
            } catch (Exception e2) {
                Log.w("MediaCodecRenderer", "Failed to initialize decoder: " + mediaCodecInfo, e2);
                arrayDeque.removeFirst();
                DecoderInitializationException decoderInitializationException = new DecoderInitializationException("Decoder init failed: " + mediaCodecInfo.name + ", " + format, e2, format.sampleMimeType, z, mediaCodecInfo, e2 instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) e2).getDiagnosticInfo() : null);
                onCodecError(decoderInitializationException);
                DecoderInitializationException decoderInitializationException2 = this.preferredDecoderInitializationException;
                if (decoderInitializationException2 == null) {
                    this.preferredDecoderInitializationException = decoderInitializationException;
                } else {
                    this.preferredDecoderInitializationException = new DecoderInitializationException(decoderInitializationException2.getMessage(), decoderInitializationException2.getCause(), decoderInitializationException2.mimeType, decoderInitializationException2.secureDecoderRequired, decoderInitializationException2.codecInfo, decoderInitializationException2.diagnosticInfo);
                }
                if (arrayDeque.isEmpty()) {
                    throw this.preferredDecoderInitializationException;
                }
            }
        }
        this.availableCodecInfos = null;
    }

    public boolean maybeInitializeProcessingPipeline(Format format) {
        return true;
    }

    public abstract void onCodecError(Exception exc);

    public abstract void onCodecInitialized(long j, long j2, String str);

    public abstract void onCodecParametersChanged(CodecParameters codecParameters);

    public abstract void onCodecReleased(String str);

    @Override // androidx.media3.exoplayer.BaseRenderer
    public void onDisabled() {
        this.inputFormat = null;
        setOutputStreamInfo(OutputStreamInfo.UNSET);
        this.pendingOutputStreamChanges.clear();
        if (this.bypassEnabled) {
            this.bypassEnabled = false;
            resetBypassState();
        } else {
            if (this.codec == null) {
                return;
            }
            if (shouldReleaseCodecInsteadOfFlushing()) {
                releaseCodec();
            } else if (shouldFlushCodec()) {
                flushCodec();
            } else {
                this.hasSkippedFlushAndWaitingForQueueInputBuffer = true;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0035  */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:34:0x0070  */
    /* JADX WARN: Code duplicated, block: B:95:0x0147  */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0120, code lost:
    
        if (r4.requiresSecureDecoder(r2) != false) goto L136;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DecoderReuseEvaluation onInputFormatChanged(WeakCache weakCache) {
        Format format;
        int i;
        Pair codecProfileAndLevel;
        String str;
        this.waitingForFirstSampleInFormat = true;
        Format format2 = (Format) weakCache.referenceQueue;
        format2.getClass();
        String str2 = format2.sampleMimeType;
        if (str2 == null) {
            throw createRendererException(new IllegalArgumentException("Sample MIME type is null."), format2, false, 4005);
        }
        if (!str2.equals("video/av01") && !str2.equals("video/x-vnd.on2.vp9")) {
            if (str2.equals("video/dolby-vision")) {
                byte[] bArr = CodecSpecificDataUtil.NAL_START_CODE;
                if (str2.equals("video/dolby-vision") && (codecProfileAndLevel = CodecSpecificDataUtil.getCodecProfileAndLevel(format2)) != null) {
                    int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
                    if (iIntValue == 16 || iIntValue == 32 || iIntValue == 256) {
                        str = "video/hevc";
                    } else if (iIntValue == 512) {
                        str = "video/avc";
                    } else if (iIntValue != 1024) {
                        str = null;
                    } else {
                        str = "video/av01";
                    }
                } else {
                    str = null;
                }
                if (Objects.equals(str, "video/av01")) {
                    if (format2.initializationData.isEmpty()) {
                        Format.Builder builderBuildUpon = format2.buildUpon();
                        builderBuildUpon.initializationData = null;
                        format = new Format(builderBuildUpon);
                    }
                }
            }
            format = format2;
        } else if (format2.initializationData.isEmpty()) {
            format = format2;
        } else {
            Format.Builder builderBuildUpon2 = format2.buildUpon();
            builderBuildUpon2.initializationData = null;
            format = new Format(builderBuildUpon2);
        }
        DrmSession drmSession = (DrmSession) weakCache.values;
        DrmSession drmSession2 = this.sourceDrmSession;
        if (drmSession2 != drmSession) {
            if (drmSession != null) {
                drmSession.acquire(null);
            }
            if (drmSession2 != null) {
                drmSession2.release(null);
            }
        }
        this.sourceDrmSession = drmSession;
        this.inputFormat = format;
        if (this.bypassEnabled) {
            this.bypassDrainAndReinitialize = true;
            return null;
        }
        MediaCodecAdapter mediaCodecAdapter = this.codec;
        if (mediaCodecAdapter == null) {
            this.availableCodecInfos = null;
            maybeInitCodecOrBypass();
            return null;
        }
        MediaCodecInfo mediaCodecInfo = this.codecInfo;
        mediaCodecInfo.getClass();
        Format format3 = this.codecInputFormat;
        format3.getClass();
        DrmSession drmSession3 = this.codecDrmSession;
        DrmSession drmSession4 = this.sourceDrmSession;
        if (drmSession3 != drmSession4) {
            if (drmSession4 != null && drmSession3 != null && drmSession4.getCryptoConfig() != null && drmSession3.getCryptoConfig() != null && FrameworkCryptoConfig.class.equals(FrameworkCryptoConfig.class) && drmSession4.getSchemeUuid().equals(drmSession3.getSchemeUuid())) {
                UUID uuid = C.PLAYREADY_UUID;
                if (!uuid.equals(drmSession3.getSchemeUuid()) && !uuid.equals(drmSession4.getSchemeUuid())) {
                    if (!mediaCodecInfo.secure) {
                        if (drmSession4.getState() != 2) {
                            if (drmSession4.getState() == 3 || drmSession4.getState() == 4) {
                                String str3 = format.sampleMimeType;
                                str3.getClass();
                            }
                        }
                    }
                }
            }
            if (this.codecReceivedBuffers) {
                this.codecDrainState = (byte) 1;
                this.codecDrainAction = (byte) 3;
            } else {
                releaseCodec();
                maybeInitCodecOrBypass();
            }
            return new DecoderReuseEvaluation(mediaCodecInfo.name, format3, format, 0, 128);
        }
        boolean z = this.sourceDrmSession != this.codecDrmSession;
        DecoderReuseEvaluation decoderReuseEvaluationCanReuseCodec = canReuseCodec(mediaCodecInfo, format3, format, getLastOutputStreamInfo().queuedBufferAfterReset);
        int i2 = decoderReuseEvaluationCanReuseCodec.result;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m();
                        return null;
                    }
                    if (updateCodecOperatingRate(format)) {
                        this.codecInputFormat = format;
                        if (z) {
                            if (this.codecReceivedBuffers) {
                                this.codecDrainState = (byte) 1;
                                this.codecDrainAction = (byte) 2;
                            } else {
                                updateDrmSession();
                            }
                        }
                    } else {
                        i = 16;
                    }
                } else if (updateCodecOperatingRate(format)) {
                    this.codecReconfigured = true;
                    this.codecReconfigurationState = (byte) 1;
                    this.codecNeedsAdaptationWorkaroundBuffer = false;
                    this.codecInputFormat = format;
                    if (z) {
                        if (this.codecReceivedBuffers) {
                            this.codecDrainState = (byte) 1;
                            this.codecDrainAction = (byte) 2;
                        } else {
                            updateDrmSession();
                        }
                    }
                } else {
                    i = 16;
                }
            } else if (updateCodecOperatingRate(format)) {
                this.codecInputFormat = format;
                boolean z2 = this.codecReceivedBuffers;
                if (z) {
                    if (z2) {
                        this.codecDrainState = (byte) 1;
                        this.codecDrainAction = (byte) 2;
                    } else {
                        updateDrmSession();
                    }
                } else if (z2) {
                    this.codecDrainState = (byte) 1;
                    this.codecDrainAction = (byte) 1;
                }
            } else {
                i = 16;
            }
            return (i2 != 0 || (this.codec == mediaCodecAdapter && this.codecDrainAction != 3)) ? decoderReuseEvaluationCanReuseCodec : new DecoderReuseEvaluation(mediaCodecInfo.name, format3, format, 0, i);
        }
        if (this.codecReceivedBuffers) {
            this.codecDrainState = (byte) 1;
            this.codecDrainAction = (byte) 3;
        } else {
            releaseCodec();
            maybeInitCodecOrBypass();
        }
        i = 0;
        if (i2 != 0) {
        }
    }

    public abstract void onOutputFormatChanged(Format format, MediaFormat mediaFormat);

    @Override // androidx.media3.exoplayer.BaseRenderer
    public void onPositionReset(long j, boolean z, boolean z2) {
        ArrayDeque arrayDeque = this.pendingOutputStreamChanges;
        if (!arrayDeque.isEmpty()) {
            this.outputStreamInfo = (OutputStreamInfo) arrayDeque.getLast();
        }
        arrayDeque.clear();
        if (z2) {
            this.inputStreamEnded = false;
            this.outputStreamEnded = false;
            this.pendingOutputEndOfStream = false;
            if (this.bypassEnabled) {
                resetBypassState();
            } else if (this.codec != null) {
                if (shouldReleaseCodecInsteadOfFlushing()) {
                    releaseCodec();
                    maybeInitCodecOrBypass();
                } else if (shouldFlushCodec()) {
                    flushCodec();
                } else {
                    this.hasSkippedFlushAndWaitingForQueueInputBuffer = true;
                }
            }
            if (this.outputStreamInfo.formatQueue.size() > 0) {
                this.waitingForFirstSampleInFormat = true;
            }
            TimedValueQueue timedValueQueue = this.outputStreamInfo.formatQueue;
            synchronized (timedValueQueue) {
                timedValueQueue.first = 0;
                timedValueQueue.size = 0;
                Arrays.fill((Object[]) timedValueQueue.values, (Object) null);
            }
            this.outputStreamInfo.queuedBufferAfterReset = false;
        }
    }

    public void onProcessedOutputBuffer$1(long j) {
        this.lastProcessedOutputBufferTimeUs = j;
        while (true) {
            ArrayDeque arrayDeque = this.pendingOutputStreamChanges;
            if (arrayDeque.isEmpty() || j < ((OutputStreamInfo) arrayDeque.peek()).previousStreamLastBufferTimeUs) {
                return;
            }
            OutputStreamInfo outputStreamInfo = (OutputStreamInfo) arrayDeque.poll();
            outputStreamInfo.getClass();
            setOutputStreamInfo(outputStreamInfo);
            onProcessedStreamChange();
        }
    }

    public abstract void onProcessedStreamChange();

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // androidx.media3.exoplayer.BaseRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        if (this.outputStreamInfo.streamOffsetUs == -9223372036854775807L) {
            setOutputStreamInfo(new OutputStreamInfo(-9223372036854775807L, j, j2));
            if (this.experimentalEnableProcessedStreamChangedAtStart) {
                onProcessedStreamChange();
                return;
            }
            return;
        }
        ArrayDeque arrayDeque = this.pendingOutputStreamChanges;
        if (arrayDeque.isEmpty()) {
            long j3 = this.largestQueuedPresentationTimeUs;
            if (j3 != -9223372036854775807L) {
                long j4 = this.lastProcessedOutputBufferTimeUs;
                if (j4 != -9223372036854775807L) {
                }
            }
            setOutputStreamInfo(new OutputStreamInfo(-9223372036854775807L, j, j2));
            if (this.outputStreamInfo.streamOffsetUs != -9223372036854775807L) {
                onProcessedStreamChange();
                return;
            }
            return;
        }
        arrayDeque.add(new OutputStreamInfo(this.largestQueuedPresentationTimeUs, j, j2));
    }

    public final void processEndOfStream() throws ExoPlaybackException {
        byte b = this.codecDrainAction;
        if (b == 1) {
            flushCodec();
            return;
        }
        if (b == 2) {
            flushCodec();
            updateDrmSession();
        } else if (b != 3) {
            this.outputStreamEnded = true;
            renderToEndOfStream();
        } else {
            releaseCodec();
            maybeInitCodecOrBypass();
        }
    }

    public abstract boolean processOutputBuffer(long j, long j2, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format);

    public final boolean readSourceOmittingSampleData(int i) throws ExoPlaybackException {
        WeakCache weakCache = this.formatHolder;
        weakCache.clear();
        DecoderInputBuffer decoderInputBuffer = this.noDataBuffer;
        decoderInputBuffer.clear();
        int source = readSource(weakCache, decoderInputBuffer, i | 4);
        if (source == -5) {
            onInputFormatChanged(weakCache);
            return true;
        }
        if (source != -4 || !decoderInputBuffer.getFlag(4)) {
            return false;
        }
        this.inputStreamEnded = true;
        processEndOfStream();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void releaseCodec() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.codec;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
                this.decoderCounters.decoderReleaseCount++;
                MediaCodecInfo mediaCodecInfo = this.codecInfo;
                mediaCodecInfo.getClass();
                onCodecReleased(mediaCodecInfo.name);
            }
            this.codec = null;
            try {
                MediaCrypto mediaCrypto = this.mediaCrypto;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.mediaCrypto = null;
                setCodecDrmSession(null);
                resetCodecStateForRelease();
            }
        } catch (Throwable th) {
            this.codec = null;
            try {
                MediaCrypto mediaCrypto2 = this.mediaCrypto;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
                this.mediaCrypto = null;
                setCodecDrmSession(null);
                resetCodecStateForRelease();
            }
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public void render(long j, long j2) {
        boolean z = false;
        if (this.pendingOutputEndOfStream) {
            this.pendingOutputEndOfStream = false;
            processEndOfStream();
        }
        ExoPlaybackException exoPlaybackException = this.pendingPlaybackException;
        if (exoPlaybackException != null) {
            this.pendingPlaybackException = null;
            throw exoPlaybackException;
        }
        try {
            if (this.outputStreamEnded) {
                renderToEndOfStream();
                return;
            }
            if (this.inputFormat != null || readSourceOmittingSampleData(2)) {
                maybeInitCodecOrBypass();
                if (this.bypassEnabled) {
                    Trace.beginSection("bypassRender");
                    while (bypassRender(j, j2)) {
                    }
                    Trace.endSection();
                } else if (this.codec != null) {
                    this.clock.getClass();
                    SystemClock.elapsedRealtime();
                    Trace.beginSection("drainAndFeed");
                    while (drainOutputBuffer(j, j2)) {
                    }
                    while (feedInputBuffer()) {
                    }
                    Trace.endSection();
                } else {
                    DecoderCounters decoderCounters = this.decoderCounters;
                    int i = decoderCounters.skippedInputBufferCount;
                    SampleStream sampleStream = this.stream;
                    sampleStream.getClass();
                    decoderCounters.skippedInputBufferCount = i + sampleStream.skipData(j - this.streamOffsetUs);
                    readSourceOmittingSampleData(1);
                }
                synchronized (this.decoderCounters) {
                }
            }
        } catch (MediaCodec.CryptoException e) {
            throw createRendererException(e, this.inputFormat, false, Util.getErrorCodeForMediaDrmErrorCode(e.getErrorCode()));
        } catch (IllegalStateException e2) {
            boolean z2 = e2 instanceof MediaCodec.CodecException;
            if (!z2) {
                StackTraceElement[] stackTrace = e2.getStackTrace();
                if (stackTrace.length <= 0 || !stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
                    throw e2;
                }
            }
            onCodecError(e2);
            if (z2 && ((MediaCodec.CodecException) e2).isRecoverable()) {
                z = true;
            }
            if (z) {
                releaseCodec();
            }
            MediaCodecDecoderException mediaCodecDecoderExceptionCreateDecoderException = createDecoderException(e2, this.codecInfo);
            throw createRendererException(mediaCodecDecoderExceptionCreateDecoderException, this.inputFormat, z, mediaCodecDecoderExceptionCreateDecoderException.errorCode == 1101 ? 4006 : 4003);
        }
    }

    public abstract void renderToEndOfStream();

    public final void resetBypassState() {
        this.largestQueuedPresentationTimeUs = -9223372036854775807L;
        getLastOutputStreamInfo().lastBufferTimeUs = -9223372036854775807L;
        this.lastProcessedOutputBufferTimeUs = -9223372036854775807L;
        this.bypassDrainAndReinitialize = false;
        this.bypassBatchBuffer.clear();
        this.bypassSampleBuffer.clear();
        this.bypassSampleBufferPending = false;
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        OggOpusAudioPacketizer oggOpusAudioPacketizer = this.oggOpusAudioPacketizer;
        oggOpusAudioPacketizer.outputBuffer = byteBuffer;
        oggOpusAudioPacketizer.granulePosition = 0;
        oggOpusAudioPacketizer.pageSequenceNumber = 2;
    }

    public void resetCodecStateForFlush() {
        this.inputIndex = -1;
        this.buffer.data = null;
        this.outputIndex = -1;
        this.outputBuffer = null;
        this.largestQueuedPresentationTimeUs = -9223372036854775807L;
        getLastOutputStreamInfo().lastBufferTimeUs = -9223372036854775807L;
        this.lastProcessedOutputBufferTimeUs = -9223372036854775807L;
        this.codecHotswapDeadlineMs = -9223372036854775807L;
        this.codecReceivedEos = false;
        this.lastOutputBufferProcessedRealtimeMs = -9223372036854775807L;
        this.codecReceivedBuffers = false;
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        this.isLastOutputBuffer = false;
        this.codecDrainState = (byte) 0;
        this.codecDrainAction = (byte) 0;
        this.codecReconfigurationState = this.codecReconfigured ? (byte) 1 : (byte) 0;
        this.hasSkippedFlushAndWaitingForQueueInputBuffer = false;
        this.skippedFlushOffsetUs = 0L;
    }

    public final void resetCodecStateForRelease() {
        resetCodecStateForFlush();
        this.pendingPlaybackException = null;
        this.availableCodecInfos = null;
        this.codecInfo = null;
        this.codecInputFormat = null;
        this.codecOutputMediaFormat = null;
        this.codecOutputMediaFormatChanged = false;
        this.codecHasOutputMediaFormat = false;
        this.codecOperatingRate = -1.0f;
        this.codecNeedsSosFlushWorkaround = false;
        this.codecNeedsEosPropagation = false;
        this.codecRegisteredOnBufferAvailableListener = false;
        this.codecReconfigured = false;
        this.codecReconfigurationState = (byte) 0;
    }

    public final void setCodecDrmSession(DrmSession drmSession) {
        DrmSession drmSession2 = this.codecDrmSession;
        if (drmSession2 != drmSession) {
            if (drmSession != null) {
                drmSession.acquire(null);
            }
            if (drmSession2 != null) {
                drmSession2.release(null);
            }
        }
        this.codecDrmSession = drmSession;
    }

    public final void setOutputStreamInfo(OutputStreamInfo outputStreamInfo) {
        this.outputStreamInfo = outputStreamInfo;
        if (outputStreamInfo.streamOffsetUs != -9223372036854775807L) {
            this.needToNotifyOutputFormatChangeAfterStreamChange = true;
            onOutputStreamOffsetUsChanged();
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public void setPlaybackSpeed(float f, float f2) {
        this.currentPlaybackSpeed = f;
        this.targetPlaybackSpeed = f2;
        updateCodecOperatingRate(this.codecInputFormat);
    }

    public boolean shouldDiscardDecoderInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        return false;
    }

    public boolean shouldFlushCodec() {
        return true;
    }

    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    public boolean shouldReleaseCodecInsteadOfFlushing() {
        byte b = this.codecDrainAction;
        if (b == 3 || (this.codecNeedsSosFlushWorkaround && !this.codecHasOutputMediaFormat)) {
            return true;
        }
        if (b != 2) {
            return false;
        }
        try {
            updateDrmSession();
            return false;
        } catch (ExoPlaybackException e) {
            Log.w("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
            return true;
        }
    }

    public boolean shouldUseBypass(Format format) {
        return false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final int supportsFormat(Format format) throws ExoPlaybackException {
        try {
            return supportsFormat$1(format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw createRendererException(e, format, false, 4002);
        }
    }

    public abstract int supportsFormat$1(Format format);

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public final boolean updateCodecOperatingRate(Format format) {
        if (this.codec != null && this.codecDrainAction != 3 && this.state != 0) {
            float f = this.targetPlaybackSpeed;
            format.getClass();
            Format[] formatArr = this.streamFormats;
            formatArr.getClass();
            float codecOperatingRateV23 = getCodecOperatingRateV23(f, format, formatArr);
            float f2 = this.codecOperatingRate;
            if (f2 != codecOperatingRateV23) {
                if (codecOperatingRateV23 == -1.0f) {
                    if (this.codecReceivedBuffers) {
                        this.codecDrainState = (byte) 1;
                        this.codecDrainAction = (byte) 3;
                        return false;
                    }
                    releaseCodec();
                    maybeInitCodecOrBypass();
                    return false;
                }
                if (f2 != -1.0f || codecOperatingRateV23 > this.assumedMinimumCodecOperatingRate) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", codecOperatingRateV23);
                    MediaCodecAdapter mediaCodecAdapter = this.codec;
                    mediaCodecAdapter.getClass();
                    mediaCodecAdapter.setParameters(bundle);
                    this.codecOperatingRate = codecOperatingRateV23;
                }
            }
        }
        return true;
    }

    public final void updateDrmSession() throws ExoPlaybackException {
        DrmSession drmSession = this.sourceDrmSession;
        drmSession.getClass();
        FrameworkCryptoConfig cryptoConfig = drmSession.getCryptoConfig();
        if (cryptoConfig != null) {
            try {
                MediaCrypto mediaCrypto = this.mediaCrypto;
                mediaCrypto.getClass();
                mediaCrypto.setMediaDrmSession(cryptoConfig.sessionId);
            } catch (MediaCryptoException e) {
                throw createRendererException(e, this.inputFormat, false, 6006);
            }
        }
        setCodecDrmSession(this.sourceDrmSession);
        this.codecDrainState = (byte) 0;
        this.codecDrainAction = (byte) 0;
    }

    public final void updateOutputFormatForTime(long j) {
        Format format = (Format) this.outputStreamInfo.formatQueue.pollFloor(j);
        if (format == null && this.needToNotifyOutputFormatChangeAfterStreamChange && this.codecOutputMediaFormat != null) {
            format = (Format) this.outputStreamInfo.formatQueue.pollFirst();
        }
        if (format != null) {
            this.outputFormat = format;
        } else if (!this.codecOutputMediaFormatChanged || (format = this.outputFormat) == null) {
            return;
        }
        onOutputFormatChanged(format, this.codecOutputMediaFormat);
        this.codecOutputMediaFormatChanged = false;
        this.needToNotifyOutputFormatChangeAfterStreamChange = false;
    }

    public long getDurationToProgressUs(long j, long j2, boolean z) {
        return super.getDurationToProgressUs(j, j2);
    }

    public void onOutputStreamOffsetUsChanged() {
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DecoderInitializationException extends Exception {
        public final MediaCodecInfo codecInfo;
        public final String diagnosticInfo;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, MediaCodecUtil.DecoderQueryException decoderQueryException, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + format, decoderQueryException, format.sampleMimeType, z, null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i));
        }

        public DecoderInitializationException(String str, Throwable th, String str2, boolean z, MediaCodecInfo mediaCodecInfo, String str3) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z;
            this.codecInfo = mediaCodecInfo;
            this.diagnosticInfo = str3;
        }
    }
}
