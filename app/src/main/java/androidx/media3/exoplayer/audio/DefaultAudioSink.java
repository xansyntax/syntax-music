package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.audio.AudioProcessingPipeline;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.audio.ToInt16PcmAudioProcessor;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.media3.container.OpusUtil;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda14;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda1;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.mediacodec.LoudnessCodecController;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.VorbisBitArray;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.NonceKt$$ExternalSyntheticLambda0;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.FileMetadata;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultAudioSink implements AudioSink {
    public static final AtomicInteger pendingReleaseCount = new AtomicInteger();
    public long accumulatedSkippedSilenceDurationUs;
    public MediaPositionParameters afterDrainParameters;
    public AudioAttributes audioAttributes;
    public AudioTrackAudioOutput audioOutput;
    public AudioOutputListener audioOutputListener;
    public AudioOutputProvider audioOutputProvider;
    public DefaultAudioSink$$ExternalSyntheticLambda0 audioOutputProviderListener;
    public AudioProcessingPipeline audioProcessingPipeline;
    public final EmojiProcessor audioProcessorChain;
    public int audioSessionId;
    public AuxEffectInfo auxEffectInfo;
    public final RegularImmutableList availableAudioProcessors;
    public final ChannelMappingAudioProcessor channelMappingAudioProcessor;
    public Configuration configuration;
    public final Context context;
    public boolean externalAudioSessionIdProvided;
    public int framesPerEncodedSample;
    public boolean handledEndOfStream;
    public boolean handledOffloadOnPresentationEnded;
    public final PendingExceptionHolder initializationExceptionPendingExceptionHolder;
    public ByteBuffer inputBuffer;
    public int inputBufferAccessUnitCount;
    public boolean isWaitingForOffloadEndOfStreamHandled;
    public long lastFeedElapsedRealtimeMs;
    public AtomicInt listener;
    public MediaPositionParameters mediaPositionParameters;
    public final ArrayDeque mediaPositionParametersCheckpoints;
    public boolean offloadDisabledUntilNextConfiguration;
    public int offloadMode;
    public ByteBuffer outputBuffer;
    public boolean pendingAudioSessionIdChangeConfirmation;
    public Configuration pendingConfiguration;
    public PlaybackParameters playbackParameters;
    public PlayerId playerId;
    public boolean playing;
    public final boolean preferAudioOutputPlaybackParameters;
    public AudioDeviceInfo preferredDevice;
    public Handler reportSkippedSilenceHandler;
    public boolean skipSilenceEnabled;
    public long skippedOutputFrameCountAtLastPosition;
    public long startMediaTimeUs;
    public boolean startMediaTimeUsNeedsInit;
    public boolean startMediaTimeUsNeedsSync;
    public boolean stoppedAudioOutput;
    public long submittedEncodedFrames;
    public long submittedPcmBytes;
    public final ToFloatPcmAudioProcessor toFloatPcmAudioProcessor;
    public final ToInt16PcmAudioProcessor toInt16PcmAudioProcessor;
    public final TrimmingAudioProcessor trimmingAudioProcessor;
    public boolean tunneling;
    public int virtualDeviceId;
    public float volume;
    public final PendingExceptionHolder writeExceptionPendingExceptionHolder;
    public long writtenEncodedFrames;
    public long writtenPcmBytes;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AudioOutputListener {
        public AudioOutputListener(AudioOutputProvider.OutputConfig outputConfig) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Configuration {
        public final Format afterProcessingInputFormat;
        public final AudioProcessingPipeline audioProcessingPipeline;
        public final Format inputFormat;
        public final int inputPcmFrameSize;
        public final AudioOutputProvider.OutputConfig outputConfig;
        public final int outputPcmFrameSize;

        public Configuration(Format format, Format format2, int i, int i2, AudioOutputProvider.OutputConfig outputConfig, AudioProcessingPipeline audioProcessingPipeline) {
            this.inputFormat = format;
            this.afterProcessingInputFormat = format2;
            this.inputPcmFrameSize = i;
            this.outputPcmFrameSize = i2;
            this.outputConfig = outputConfig;
            this.audioProcessingPipeline = audioProcessingPipeline;
        }

        public final boolean isPcm() {
            return Objects.equals(this.inputFormat.sampleMimeType, "audio/raw");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaPositionParameters {
        public final long audioOutputPositionUs;
        public long mediaPositionDriftUs;
        public final long mediaTimeUs;
        public final PlaybackParameters playbackParameters;

        public MediaPositionParameters(PlaybackParameters playbackParameters, long j, long j2) {
            this.playbackParameters = playbackParameters;
            this.mediaTimeUs = j;
            this.audioOutputPositionUs = j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PendingExceptionHolder {
        public Exception pendingException;
        public long throwDeadlineMs = -9223372036854775807L;
        public long earliestNextRetryTimeMs = -9223372036854775807L;

        public final void throwExceptionIfDeadlineIsReached(Exception exc) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.pendingException == null) {
                this.pendingException = exc;
            }
            if (this.throwDeadlineMs == -9223372036854775807L && DefaultAudioSink.pendingReleaseCount.get() <= 0) {
                this.throwDeadlineMs = 200 + jElapsedRealtime;
            }
            long j = this.throwDeadlineMs;
            if (j == -9223372036854775807L || jElapsedRealtime < j) {
                this.earliestNextRetryTimeMs = jElapsedRealtime + 50;
                return;
            }
            Exception exc2 = this.pendingException;
            if (exc2 != exc) {
                exc2.addSuppressed(exc);
            }
            Exception exc3 = this.pendingException;
            this.pendingException = null;
            this.throwDeadlineMs = -9223372036854775807L;
            this.earliestNextRetryTimeMs = -9223372036854775807L;
            throw exc3;
        }
    }

    public DefaultAudioSink(FileMetadata fileMetadata) {
        int deviceId;
        Context context = (Context) fileMetadata.symlinkTarget;
        this.context = context == null ? null : context.getApplicationContext();
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.audioProcessorChain = (EmojiProcessor) fileMetadata.createdAtMillis;
        this.preferAudioOutputPlaybackParameters = fileMetadata.isRegularFile;
        this.offloadMode = 0;
        this.audioOutputProvider = (AudioTrackAudioOutputProvider) fileMetadata.lastAccessedAtMillis;
        ChannelMappingAudioProcessor channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.channelMappingAudioProcessor = channelMappingAudioProcessor;
        TrimmingAudioProcessor trimmingAudioProcessor = new TrimmingAudioProcessor();
        trimmingAudioProcessor.endBuffer = Util.EMPTY_BYTE_ARRAY;
        this.trimmingAudioProcessor = trimmingAudioProcessor;
        this.toInt16PcmAudioProcessor = new ToInt16PcmAudioProcessor();
        this.toFloatPcmAudioProcessor = new ToFloatPcmAudioProcessor();
        this.availableAudioProcessors = ImmutableList.of((Object) trimmingAudioProcessor, (Object) channelMappingAudioProcessor);
        this.volume = 1.0f;
        this.audioSessionId = 0;
        this.auxEffectInfo = new AuxEffectInfo();
        PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
        this.mediaPositionParameters = new MediaPositionParameters(playbackParameters, 0L, 0L);
        this.playbackParameters = playbackParameters;
        this.skipSilenceEnabled = false;
        this.mediaPositionParametersCheckpoints = new ArrayDeque();
        this.initializationExceptionPendingExceptionHolder = new PendingExceptionHolder();
        this.writeExceptionPendingExceptionHolder = new PendingExceptionHolder();
        int i = -1;
        if (Build.VERSION.SDK_INT >= 34 && context != null && (deviceId = context.getDeviceId()) != 0 && deviceId != -1) {
            i = deviceId;
        }
        this.virtualDeviceId = i;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00c0  */
    public static int getFramesPerEncodedSample(int i, ByteBuffer byteBuffer) {
        int i2;
        int i3;
        byte b;
        int i4;
        byte b2;
        int i5;
        int i6;
        int i7;
        int i8;
        if (i == 20) {
            if ((byteBuffer.get(5) & 2) == 0) {
                i2 = 0;
            } else {
                byte b3 = byteBuffer.get(26);
                int i9 = 28;
                int i10 = 28;
                for (int i11 = 0; i11 < b3; i11++) {
                    i10 += byteBuffer.get(i11 + 27);
                }
                byte b4 = byteBuffer.get(i10 + 26);
                for (int i12 = 0; i12 < b4; i12++) {
                    i9 += byteBuffer.get(i10 + 27 + i12);
                }
                i2 = i10 + i9;
            }
            int i13 = byteBuffer.get(i2 + 26) + 27 + i2;
            return (int) ((OpusUtil.getPacketDurationUs(byteBuffer.get(i13), byteBuffer.limit() - i13 > 1 ? byteBuffer.get(i13 + 1) : (byte) 0) * 48000) / 1000000);
        }
        if (i != 30) {
            switch (i) {
                case 5:
                case 6:
                    break;
                case 7:
                case 8:
                    break;
                case 9:
                    int iPosition = byteBuffer.position();
                    String str = Util.DEVICE_DEBUG_INFO;
                    int iReverseBytes = byteBuffer.getInt(iPosition);
                    if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
                        iReverseBytes = Integer.reverseBytes(iReverseBytes);
                    }
                    if ((iReverseBytes & (-2097152)) != -2097152 || (i6 = (iReverseBytes >>> 19) & 3) == 1 || (i7 = (iReverseBytes >>> 17) & 3) == 0) {
                        i5 = -1;
                    } else {
                        int i14 = (iReverseBytes >>> 12) & 15;
                        int i15 = (iReverseBytes >>> 10) & 3;
                        if (i14 == 0 || i14 == 15 || i15 == 3) {
                            i5 = -1;
                        } else {
                            i5 = 1152;
                            if (i7 != 1) {
                                if (i7 != 2) {
                                    if (i7 != 3) {
                                        Path$$ExternalSyntheticBUOutline0.m();
                                        return 0;
                                    }
                                    i5 = 384;
                                }
                            } else if (i6 != 3) {
                                i5 = 576;
                            }
                        }
                    }
                    if (i5 != -1) {
                        return i5;
                    }
                    Path$$ExternalSyntheticBUOutline0.m();
                    return 0;
                case 10:
                    return 1024;
                case 11:
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return 2048;
                default:
                    switch (i) {
                        case 14:
                            int iPosition2 = byteBuffer.position();
                            int iLimit = byteBuffer.limit() - 10;
                            int i16 = iPosition2;
                            while (true) {
                                if (i16 <= iLimit) {
                                    String str2 = Util.DEVICE_DEBUG_INFO;
                                    int iReverseBytes2 = byteBuffer.getInt(i16 + 4);
                                    if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
                                        iReverseBytes2 = Integer.reverseBytes(iReverseBytes2);
                                    }
                                    if ((iReverseBytes2 & (-2)) == -126718022) {
                                        i8 = i16 - iPosition2;
                                    } else {
                                        i16++;
                                    }
                                } else {
                                    i8 = -1;
                                }
                            }
                            if (i8 == -1) {
                                return 0;
                            }
                            return (40 << ((byteBuffer.get((byteBuffer.position() + i8) + (((byteBuffer.get((byteBuffer.position() + i8) + 7) & 255) == 187 ? (byte) 1 : (byte) 0) != 0 ? 9 : 8)) >> 4) & 7)) * 16;
                        case 15:
                            return 512;
                        case 16:
                            return 1024;
                        case 17:
                            byte[] bArr = new byte[16];
                            int iPosition3 = byteBuffer.position();
                            byteBuffer.get(bArr);
                            byteBuffer.position(iPosition3);
                            return AacUtil.parseAc4SyncframeInfo(new VorbisBitArray(bArr, 16)).sampleCount;
                        case 18:
                            break;
                        default:
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unexpected audio encoding: "));
                            return 0;
                    }
                    break;
            }
            if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
                return AacUtil.BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
            }
            return 1536;
        }
        if (byteBuffer.getInt(0) == -233094848 || byteBuffer.getInt(0) == -398277519) {
            return 1024;
        }
        if (byteBuffer.getInt(0) == 622876772) {
            return 4096;
        }
        int iPosition4 = byteBuffer.position();
        byte b5 = byteBuffer.get(iPosition4);
        if (b5 != -2) {
            if (b5 == -1) {
                i3 = (byteBuffer.get(iPosition4 + 4) & 7) << 4;
                b2 = byteBuffer.get(iPosition4 + 7);
            } else if (b5 != 31) {
                i3 = (byteBuffer.get(iPosition4 + 4) & 1) << 6;
                b = byteBuffer.get(iPosition4 + 5);
            } else {
                i3 = (byteBuffer.get(iPosition4 + 5) & 7) << 4;
                b2 = byteBuffer.get(iPosition4 + 6);
            }
            i4 = b2 & 60;
            return (((i4 >> 2) | i3) + 1) * 32;
        }
        i3 = (byteBuffer.get(iPosition4 + 5) & 1) << 6;
        b = byteBuffer.get(iPosition4 + 4);
        i4 = b & 252;
        return (((i4 >> 2) | i3) + 1) * 32;
    }

    public final void applyAudioProcessorPlaybackParametersAndSkipSilence(long j) {
        PlaybackParameters playbackParameters;
        boolean zUseAudioOutputPlaybackParams = useAudioOutputPlaybackParams();
        boolean z = false;
        EmojiProcessor emojiProcessor = this.audioProcessorChain;
        if (zUseAudioOutputPlaybackParams) {
            playbackParameters = PlaybackParameters.DEFAULT;
        } else {
            if (this.tunneling || !this.configuration.isPcm()) {
                playbackParameters = PlaybackParameters.DEFAULT;
            } else {
                int i = this.configuration.inputFormat.pcmEncoding;
                playbackParameters = this.playbackParameters;
                SonicAudioProcessor sonicAudioProcessor = (SonicAudioProcessor) emojiProcessor.mGlyphChecker;
                float f = playbackParameters.speed;
                UtilsKt.checkArgument(f > CropImageView.DEFAULT_ASPECT_RATIO);
                if (sonicAudioProcessor.speed != f) {
                    sonicAudioProcessor.speed = f;
                    sonicAudioProcessor.pendingSonicRecreation = true;
                }
                float f2 = playbackParameters.pitch;
                UtilsKt.checkArgument(f2 > CropImageView.DEFAULT_ASPECT_RATIO);
                if (sonicAudioProcessor.pitch != f2) {
                    sonicAudioProcessor.pitch = f2;
                    sonicAudioProcessor.pendingSonicRecreation = true;
                }
            }
            this.playbackParameters = playbackParameters;
        }
        PlaybackParameters playbackParameters2 = playbackParameters;
        if (!this.tunneling && this.configuration.isPcm()) {
            int i2 = this.configuration.inputFormat.pcmEncoding;
            z = this.skipSilenceEnabled;
            ((SilenceSkippingAudioProcessor) emojiProcessor.mMetadataRepo).enabled = z;
        }
        this.skipSilenceEnabled = z;
        this.mediaPositionParametersCheckpoints.add(new MediaPositionParameters(playbackParameters2, Math.max(0L, j), Util.sampleCountToDurationUs(this.configuration.outputConfig.sampleRate, getWrittenFrames())));
        AudioProcessingPipeline audioProcessingPipeline = this.configuration.audioProcessingPipeline;
        this.audioProcessingPipeline = audioProcessingPipeline;
        audioProcessingPipeline.flush();
        AtomicInt atomicInt = this.listener;
        if (atomicInt != null) {
            final boolean z2 = this.skipSilenceEnabled;
            final AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = ((MediaCodecAudioRenderer) atomicInt.delegate).eventDispatcher;
            Handler handler = audioRendererEventListener$EventDispatcher.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExoPlayerImpl.ComponentListener componentListener = audioRendererEventListener$EventDispatcher.listener;
                        String str = Util.DEVICE_DEBUG_INFO;
                        ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
                        boolean z3 = exoPlayerImpl.skipSilenceEnabled;
                        boolean z4 = z2;
                        if (z3 == z4) {
                            return;
                        }
                        exoPlayerImpl.skipSilenceEnabled = z4;
                        exoPlayerImpl.listeners.sendEvent(23, new ExoPlayerImpl$$ExternalSyntheticLambda14((byte) 2, z4));
                    }
                });
            }
        }
    }

    public final AudioTrackAudioOutput buildAudioOutput(AudioOutputProvider.OutputConfig outputConfig) throws AudioSink.InitializationException {
        try {
            return ((AudioTrackAudioOutputProvider) this.audioOutputProvider).getAudioOutput(outputConfig);
        } catch (AudioOutputProvider.InitializationException e) {
            AudioSink.InitializationException initializationException = new AudioSink.InitializationException(outputConfig.sampleRate, outputConfig.channelMask, outputConfig.encoding, outputConfig.bufferSize, this.configuration.inputFormat, outputConfig.isOffload, e);
            AtomicInt atomicInt = this.listener;
            if (atomicInt == null) {
                throw initializationException;
            }
            atomicInt.onAudioSinkError(initializationException);
            throw initializationException;
        }
    }

    public final void configure(Format format, int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessingPipeline audioProcessingPipeline;
        Format format2;
        int i;
        int byteDepth;
        if (this.audioOutputProviderListener == null && this.context != null) {
            DefaultAudioSink$$ExternalSyntheticLambda0 defaultAudioSink$$ExternalSyntheticLambda0 = new DefaultAudioSink$$ExternalSyntheticLambda0(this);
            this.audioOutputProviderListener = defaultAudioSink$$ExternalSyntheticLambda0;
            AudioTrackAudioOutputProvider audioTrackAudioOutputProvider = (AudioTrackAudioOutputProvider) this.audioOutputProvider;
            audioTrackAudioOutputProvider.verifySinglePlaybackLooper();
            ListenerSet listenerSet = audioTrackAudioOutputProvider.listeners;
            if (listenerSet == null) {
                listenerSet = new ListenerSet(Thread.currentThread());
                audioTrackAudioOutputProvider.listeners = listenerSet;
            }
            listenerSet.add(defaultAudioSink$$ExternalSyntheticLambda0);
        }
        String str = format.sampleMimeType;
        int i2 = format.channelCount;
        int i3 = format.pcmEncoding;
        if ("audio/raw".equals(str)) {
            UtilsKt.checkArgument(Util.isEncodingLinearPcm(i3));
            int byteDepth2 = Util.getByteDepth(i3) * i2;
            ImmutableList.Builder builder = new ImmutableList.Builder(4);
            builder.addAll(this.availableAudioProcessors);
            builder.add((Object) this.toInt16PcmAudioProcessor);
            AudioProcessor[] audioProcessorArr = (AudioProcessor[]) this.audioProcessorChain.mSpanFactory;
            int length = audioProcessorArr.length;
            Maps.checkElementsNotNull(length, audioProcessorArr);
            builder.ensureRoomFor(length);
            System.arraycopy(audioProcessorArr, 0, builder.contents, builder.size, length);
            builder.size += length;
            audioProcessingPipeline = new AudioProcessingPipeline(builder.build());
            if (audioProcessingPipeline.equals(this.audioProcessingPipeline)) {
                audioProcessingPipeline = this.audioProcessingPipeline;
            }
            int i4 = format.encoderDelay;
            int i5 = format.encoderPadding;
            TrimmingAudioProcessor trimmingAudioProcessor = this.trimmingAudioProcessor;
            trimmingAudioProcessor.trimStartFrames = i4;
            trimmingAudioProcessor.trimEndFrames = i5;
            this.channelMappingAudioProcessor.pendingOutputChannels = iArr;
            AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(format.sampleRate, i2, i3);
            try {
                ImmutableList immutableList = audioProcessingPipeline.audioProcessors;
                if (audioFormat.equals(AudioProcessor.AudioFormat.NOT_SET)) {
                    throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
                }
                for (int i6 = 0; i6 < immutableList.size(); i6++) {
                    AudioProcessor audioProcessor = (AudioProcessor) immutableList.get(i6);
                    AudioProcessor.AudioFormat audioFormatConfigure = audioProcessor.configure(audioFormat);
                    if (audioProcessor.isActive()) {
                        UtilsKt.checkState(!audioFormatConfigure.equals(AudioProcessor.AudioFormat.NOT_SET));
                        audioFormat = audioFormatConfigure;
                    }
                }
                int i7 = audioFormat.channelCount;
                int i8 = audioFormat.encoding;
                Format.Builder builderBuildUpon = format.buildUpon();
                builderBuildUpon.pcmEncoding = i8;
                builderBuildUpon.sampleRate = audioFormat.sampleRate;
                builderBuildUpon.channelCount = i7;
                format2 = new Format(builderBuildUpon);
                i = byteDepth2;
                byteDepth = Util.getByteDepth(i8) * i7;
            } catch (AudioProcessor.UnhandledAudioFormatException e) {
                throw new AudioSink.ConfigurationException(e, format);
            }
        } else {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            audioProcessingPipeline = new AudioProcessingPipeline(RegularImmutableList.EMPTY);
            format2 = format;
            i = -1;
            byteDepth = -1;
        }
        AudioProcessingPipeline audioProcessingPipeline2 = audioProcessingPipeline;
        AudioOutputProvider.FormatConfig formatConfig = getFormatConfig(format2);
        Format format3 = formatConfig.format;
        try {
            AudioOutputProvider.OutputConfig outputConfig = ((AudioTrackAudioOutputProvider) this.audioOutputProvider).getOutputConfig(formatConfig);
            boolean z = outputConfig.isOffload;
            if (outputConfig.encoding == 0) {
                throw new AudioSink.ConfigurationException("Invalid output encoding (isOffload=" + z + ")", format3);
            }
            if (outputConfig.channelMask == 0) {
                throw new AudioSink.ConfigurationException("Invalid output channel config (isOffload=" + z + ")", format3);
            }
            this.offloadDisabledUntilNextConfiguration = false;
            Configuration configuration = new Configuration(format, format2, i, byteDepth, outputConfig, audioProcessingPipeline2);
            if (isAudioOutputInitialized()) {
                this.pendingConfiguration = configuration;
            } else {
                this.configuration = configuration;
            }
        } catch (AudioOutputProvider.ConfigurationException e2) {
            throw new AudioSink.ConfigurationException(e2, format);
        }
    }

    public final void drainOutputBuffer(long j) throws Exception {
        AtomicInt atomicInt;
        ExoPlayerImplInternal.AnonymousClass1 anonymousClass1;
        if (this.outputBuffer == null) {
            return;
        }
        PendingExceptionHolder pendingExceptionHolder = this.writeExceptionPendingExceptionHolder;
        if (pendingExceptionHolder.pendingException != null && (pendingReleaseCount.get() > 0 || SystemClock.elapsedRealtime() < pendingExceptionHolder.earliestNextRetryTimeMs)) {
            return;
        }
        int iRemaining = this.outputBuffer.remaining();
        boolean z = false;
        try {
            boolean zWrite = this.audioOutput.write(this.inputBufferAccessUnitCount, j, this.outputBuffer);
            this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
            pendingExceptionHolder.pendingException = null;
            pendingExceptionHolder.throwDeadlineMs = -9223372036854775807L;
            pendingExceptionHolder.earliestNextRetryTimeMs = -9223372036854775807L;
            if (this.audioOutput.isOffloadedPlayback()) {
                if (this.writtenEncodedFrames > 0) {
                    this.isWaitingForOffloadEndOfStreamHandled = false;
                }
                if (this.playing && (atomicInt = this.listener) != null && !zWrite && !this.isWaitingForOffloadEndOfStreamHandled && (anonymousClass1 = ((MediaCodecAudioRenderer) atomicInt.delegate).wakeupListener) != null) {
                    ExoPlayerImplInternal.this.requestForRendererSleep = true;
                }
            }
            if (this.configuration.isPcm()) {
                this.writtenPcmBytes += (long) (iRemaining - this.outputBuffer.remaining());
            }
            if (zWrite) {
                if (!this.configuration.isPcm()) {
                    UtilsKt.checkState(this.outputBuffer == this.inputBuffer);
                    this.writtenEncodedFrames = (((long) this.framesPerEncodedSample) * ((long) this.inputBufferAccessUnitCount)) + this.writtenEncodedFrames;
                }
                this.outputBuffer = null;
            }
        } catch (AudioOutput$WriteException e) {
            boolean z2 = e.isRecoverable;
            if (z2) {
                if (getWrittenFrames() > 0) {
                    z = true;
                } else if (this.audioOutput.isOffloadedPlayback()) {
                    if (this.configuration.outputConfig.isOffload) {
                        this.offloadDisabledUntilNextConfiguration = true;
                    }
                    z = true;
                }
            }
            AudioSink.WriteException writeException = new AudioSink.WriteException(e.errorCode, this.configuration.inputFormat, z);
            AtomicInt atomicInt2 = this.listener;
            if (atomicInt2 != null) {
                atomicInt2.onAudioSinkError(writeException);
            }
            if (z2) {
                throw writeException;
            }
            pendingExceptionHolder.throwExceptionIfDeadlineIsReached(writeException);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0044 A[RETURN] */
    public final boolean drainToEndOfStream() throws Exception {
        ByteBuffer byteBuffer;
        if (!this.audioProcessingPipeline.isOperational()) {
            drainOutputBuffer(Long.MIN_VALUE);
            if (this.outputBuffer == null) {
                return true;
            }
            return false;
        }
        AudioProcessingPipeline audioProcessingPipeline = this.audioProcessingPipeline;
        if (audioProcessingPipeline.isOperational() && !audioProcessingPipeline.inputEnded) {
            audioProcessingPipeline.inputEnded = true;
            ((AudioProcessor) audioProcessingPipeline.activeAudioProcessors.get(0)).queueEndOfStream();
        }
        processBuffers(Long.MIN_VALUE);
        if (!this.audioProcessingPipeline.isEnded() || ((byteBuffer = this.outputBuffer) != null && byteBuffer.hasRemaining())) {
            return false;
        }
        return true;
    }

    public final void flush() {
        if (isAudioOutputInitialized()) {
            this.submittedPcmBytes = 0L;
            this.submittedEncodedFrames = 0L;
            this.writtenPcmBytes = 0L;
            this.writtenEncodedFrames = 0L;
            this.isWaitingForOffloadEndOfStreamHandled = false;
            this.framesPerEncodedSample = 0;
            this.mediaPositionParameters = new MediaPositionParameters(this.playbackParameters, 0L, 0L);
            this.startMediaTimeUs = 0L;
            this.afterDrainParameters = null;
            this.mediaPositionParametersCheckpoints.clear();
            this.inputBuffer = null;
            this.inputBufferAccessUnitCount = 0;
            this.outputBuffer = null;
            this.stoppedAudioOutput = false;
            this.handledEndOfStream = false;
            this.handledOffloadOnPresentationEnded = false;
            this.trimmingAudioProcessor.trimmedFrameCount = 0L;
            AudioProcessingPipeline audioProcessingPipeline = this.configuration.audioProcessingPipeline;
            this.audioProcessingPipeline = audioProcessingPipeline;
            audioProcessingPipeline.flush();
            this.audioOutputListener = null;
            Configuration configuration = this.pendingConfiguration;
            if (configuration != null) {
                this.configuration = configuration;
                this.pendingConfiguration = null;
            }
            pendingReleaseCount.incrementAndGet();
            AudioTrackAudioOutput audioTrackAudioOutput = this.audioOutput;
            if (audioTrackAudioOutput.audioTrackPositionTracker.audioTrack.getPlayState() == 3) {
                audioTrackAudioOutput.audioTrack.pause();
            }
            if (Build.VERSION.SDK_INT >= 29 && audioTrackAudioOutput.isOffloadedPlayback()) {
                AudioTrackAudioOutput.StreamEventCallbackV29 streamEventCallbackV29 = audioTrackAudioOutput.offloadStreamEventCallbackV29;
                streamEventCallbackV29.getClass();
                streamEventCallbackV29.unregister();
            }
            Dispatcher dispatcher = audioTrackAudioOutput.onRoutingChangedListener;
            if (dispatcher != null) {
                AudioTrack audioTrack = (AudioTrack) dispatcher.executorServiceOrNull;
                AudioTrackAudioOutput$OnRoutingChangedListenerApi24$$ExternalSyntheticLambda0 audioTrackAudioOutput$OnRoutingChangedListenerApi24$$ExternalSyntheticLambda0 = (AudioTrackAudioOutput$OnRoutingChangedListenerApi24$$ExternalSyntheticLambda0) dispatcher.runningSyncCalls;
                audioTrackAudioOutput$OnRoutingChangedListenerApi24$$ExternalSyntheticLambda0.getClass();
                audioTrack.removeOnRoutingChangedListener(audioTrackAudioOutput$OnRoutingChangedListenerApi24$$ExternalSyntheticLambda0);
                dispatcher.runningSyncCalls = null;
                audioTrackAudioOutput.onRoutingChangedListener = null;
            }
            AudioTrack audioTrack2 = audioTrackAudioOutput.audioTrack;
            ListenerSet listenerSet = audioTrackAudioOutput.listeners;
            Handler handlerCreateHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(null);
            synchronized (AudioTrackAudioOutput.releaseExecutorLock) {
                try {
                    ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = AudioTrackAudioOutput.releaseExecutor;
                    if (scheduledExecutorServiceNewSingleThreadScheduledExecutor == null) {
                        scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new NonceKt$$ExternalSyntheticLambda0((byte) 1));
                        AudioTrackAudioOutput.releaseExecutor = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
                    }
                    AudioTrackAudioOutput.pendingReleaseCount++;
                    scheduledExecutorServiceNewSingleThreadScheduledExecutor.schedule(new Util$$ExternalSyntheticLambda1((Object) audioTrack2, (Object) handlerCreateHandlerForCurrentLooper, (Object) listenerSet, (byte) 9), 20L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.audioOutput = null;
        }
        PendingExceptionHolder pendingExceptionHolder = this.writeExceptionPendingExceptionHolder;
        pendingExceptionHolder.pendingException = null;
        pendingExceptionHolder.throwDeadlineMs = -9223372036854775807L;
        pendingExceptionHolder.earliestNextRetryTimeMs = -9223372036854775807L;
        PendingExceptionHolder pendingExceptionHolder2 = this.initializationExceptionPendingExceptionHolder;
        pendingExceptionHolder2.pendingException = null;
        pendingExceptionHolder2.throwDeadlineMs = -9223372036854775807L;
        pendingExceptionHolder2.earliestNextRetryTimeMs = -9223372036854775807L;
        this.skippedOutputFrameCountAtLastPosition = 0L;
        this.accumulatedSkippedSilenceDurationUs = 0L;
        Handler handler = this.reportSkippedSilenceHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final AudioOutputProvider.FormatConfig getFormatConfig(Format format) {
        AudioOutputProvider.FormatConfig formatConfig = new AudioOutputProvider.FormatConfig(format);
        formatConfig.audioAttributes = this.audioAttributes;
        formatConfig.enablePlaybackParameters = this.preferAudioOutputPlaybackParameters;
        formatConfig.enableOffload = this.offloadMode != 0;
        formatConfig.preferredDevice = this.preferredDevice;
        formatConfig.audioSessionId = this.audioSessionId;
        formatConfig.enableTunneling = this.tunneling;
        formatConfig.virtualDeviceId = this.virtualDeviceId;
        return new AudioOutputProvider.FormatConfig(formatConfig);
    }

    public final int getFormatSupport(Format format) {
        boolean z;
        if (!Util.isEncodingLinearPcm(format.pcmEncoding) || format.pcmEncoding == 2) {
            z = false;
        } else {
            Format.Builder builderBuildUpon = format.buildUpon();
            builderBuildUpon.pcmEncoding = 2;
            format = new Format(builderBuildUpon);
            z = true;
        }
        int i = ((AudioTrackAudioOutputProvider) this.audioOutputProvider).getFormatSupport(getFormatConfig(format)).supportLevel;
        if (i != 1) {
            if (i != 2) {
                return 0;
            }
            if (!z) {
                return 2;
            }
        }
        return 1;
    }

    public final long getWrittenFrames() {
        if (!this.configuration.isPcm()) {
            return this.writtenEncodedFrames;
        }
        long j = this.writtenPcmBytes;
        long j2 = this.configuration.outputPcmFrameSize;
        return ((j + j2) - 1) / j2;
    }

    /* JADX WARN: Failed to calculate best type for var: r18v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r18v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r18v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v1 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v0 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public final boolean handleBuffer(int r21, long r22, java.nio.ByteBuffer r24) {
        /*
            Method dump skipped, instruction units count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.handleBuffer(int, long, java.nio.ByteBuffer):boolean");
    }

    public final boolean hasPendingData() {
        if (!isAudioOutputInitialized()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29 && this.audioOutput.isOffloadedPlayback() && this.handledOffloadOnPresentationEnded) {
            return false;
        }
        long writtenFrames = getWrittenFrames();
        long positionUs = this.audioOutput.getPositionUs();
        AudioTrackAudioOutput audioTrackAudioOutput = this.audioOutput;
        audioTrackAudioOutput.getClass();
        return writtenFrames > Util.scaleLargeValue(positionUs, (long) audioTrackAudioOutput.audioTrack.getSampleRate(), 1000000L, RoundingMode.UP);
    }

    public final boolean initializeAudioOutput() throws AudioSink.InitializationException {
        AudioTrackAudioOutput audioTrackAudioOutputBuildAudioOutput;
        LoudnessCodecController loudnessCodecController;
        PendingExceptionHolder pendingExceptionHolder = this.initializationExceptionPendingExceptionHolder;
        if (pendingExceptionHolder.pendingException != null && (pendingReleaseCount.get() > 0 || SystemClock.elapsedRealtime() < pendingExceptionHolder.earliestNextRetryTimeMs)) {
            return false;
        }
        try {
            audioTrackAudioOutputBuildAudioOutput = buildAudioOutput(this.configuration.outputConfig);
        } catch (AudioSink.InitializationException e) {
            int i = this.configuration.outputConfig.bufferSize;
            while (true) {
                Configuration configuration = this.configuration;
                if (i <= 1000000) {
                    if (!configuration.outputConfig.isOffload) {
                        throw e;
                    }
                    this.offloadDisabledUntilNextConfiguration = true;
                    throw e;
                }
                int i2 = i / 2;
                int i3 = configuration.outputPcmFrameSize;
                if (i3 == -1) {
                    i3 = 1;
                }
                int i4 = i2 % i3;
                int i5 = i4 != 0 ? (i3 - i4) + i2 : i2;
                AudioOutputProvider.OutputConfig.Builder builderBuildUpon = configuration.outputConfig.buildUpon();
                builderBuildUpon.bufferSize = i5;
                AudioOutputProvider.OutputConfig outputConfig = new AudioOutputProvider.OutputConfig(builderBuildUpon);
                try {
                    audioTrackAudioOutputBuildAudioOutput = buildAudioOutput(outputConfig);
                    Configuration configuration2 = this.configuration;
                    this.configuration = new Configuration(configuration2.inputFormat, configuration2.afterProcessingInputFormat, configuration2.inputPcmFrameSize, configuration2.outputPcmFrameSize, outputConfig, configuration2.audioProcessingPipeline);
                    break;
                } catch (AudioSink.InitializationException e2) {
                    e.addSuppressed(e2);
                    i = i5;
                }
            }
        }
        this.audioOutput = audioTrackAudioOutputBuildAudioOutput;
        AudioOutputListener audioOutputListener = new AudioOutputListener(this.configuration.outputConfig);
        this.audioOutputListener = audioOutputListener;
        audioTrackAudioOutputBuildAudioOutput.listeners.add(audioOutputListener);
        if (this.audioOutput.isOffloadedPlayback()) {
            Configuration configuration3 = this.configuration;
            if (configuration3.outputConfig.useOffloadGapless) {
                AudioTrackAudioOutput audioTrackAudioOutput = this.audioOutput;
                Format format = configuration3.inputFormat;
                audioTrackAudioOutput.setOffloadDelayPadding(format.encoderDelay, format.encoderPadding);
            }
        }
        PlayerId playerId = this.playerId;
        if (playerId != null) {
            this.audioOutput.setPlayerId(playerId);
        }
        if (isAudioOutputInitialized()) {
            this.audioOutput.audioTrack.setVolume(this.volume);
        }
        this.auxEffectInfo.getClass();
        AudioDeviceInfo audioDeviceInfo = this.preferredDevice;
        if (audioDeviceInfo != null) {
            this.audioOutput.audioTrack.setPreferredDevice(audioDeviceInfo);
        }
        this.startMediaTimeUsNeedsInit = true;
        int audioSessionId = this.audioOutput.audioTrack.getAudioSessionId();
        boolean z = audioSessionId != this.audioSessionId;
        this.audioSessionId = audioSessionId;
        AtomicInt atomicInt = this.listener;
        if (atomicInt != null) {
            AudioOutputProvider.OutputConfig outputConfig2 = this.configuration.outputConfig;
            AudioSink.AudioTrackConfig audioTrackConfig = new AudioSink.AudioTrackConfig();
            AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = ((MediaCodecAudioRenderer) atomicInt.delegate).eventDispatcher;
            Handler handler = audioRendererEventListener$EventDispatcher.handler;
            if (handler != null) {
                handler.post(new AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, (Object) audioTrackConfig, (byte) 7));
            }
            if (z) {
                this.pendingAudioSessionIdChangeConfirmation = true;
                Configuration configuration4 = this.configuration;
                AudioOutputProvider.OutputConfig.Builder builderBuildUpon2 = configuration4.outputConfig.buildUpon();
                int i6 = this.audioSessionId;
                builderBuildUpon2.audioSessionId = i6;
                this.configuration = new Configuration(configuration4.inputFormat, configuration4.afterProcessingInputFormat, configuration4.inputPcmFrameSize, configuration4.outputPcmFrameSize, new AudioOutputProvider.OutputConfig(builderBuildUpon2), configuration4.audioProcessingPipeline);
                Configuration configuration5 = this.pendingConfiguration;
                if (configuration5 != null) {
                    AudioOutputProvider.OutputConfig.Builder builderBuildUpon3 = configuration5.outputConfig.buildUpon();
                    i6 = this.audioSessionId;
                    builderBuildUpon3.audioSessionId = i6;
                    this.pendingConfiguration = new Configuration(configuration5.inputFormat, configuration5.afterProcessingInputFormat, configuration5.inputPcmFrameSize, configuration5.outputPcmFrameSize, new AudioOutputProvider.OutputConfig(builderBuildUpon3), configuration5.audioProcessingPipeline);
                }
                MediaCodecAudioRenderer mediaCodecAudioRenderer = (MediaCodecAudioRenderer) this.listener.delegate;
                if (Build.VERSION.SDK_INT >= 35 && (loudnessCodecController = mediaCodecAudioRenderer.loudnessCodecController) != null) {
                    loudnessCodecController.setAudioSessionId(i6);
                }
                AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher2 = mediaCodecAudioRenderer.eventDispatcher;
                Handler handler2 = audioRendererEventListener$EventDispatcher2.handler;
                if (handler2 != null) {
                    handler2.post(new StreamVolumeManager$$ExternalSyntheticLambda1(audioRendererEventListener$EventDispatcher2, i6, (byte) 2));
                }
            }
        }
        return true;
    }

    public final boolean isAudioOutputInitialized() {
        return this.audioOutput != null;
    }

    public final void play() {
        this.playing = true;
        if (isAudioOutputInitialized()) {
            AudioTrackAudioOutput audioTrackAudioOutput = this.audioOutput;
            AudioTrackPositionTracker audioTrackPositionTracker = audioTrackAudioOutput.audioTrackPositionTracker;
            if (audioTrackPositionTracker.stopTimestampUs != -9223372036854775807L) {
                audioTrackPositionTracker.clock.getClass();
                audioTrackPositionTracker.stopTimestampUs = Util.msToUs(SystemClock.elapsedRealtime());
            }
            audioTrackPositionTracker.onPositionAdvancingFromPositionUs = Util.sampleCountToDurationUs(audioTrackPositionTracker.outputSampleRate, audioTrackPositionTracker.getPlaybackHeadPosition());
            audioTrackPositionTracker.audioTimestampPoller.updateState(0);
            if (!audioTrackAudioOutput.hasBeenStopped || audioTrackAudioOutput.isOffloadedPlayback()) {
                audioTrackAudioOutput.audioTrack.play();
            }
        }
    }

    public final void playPendingData() {
        if (this.stoppedAudioOutput) {
            return;
        }
        this.stoppedAudioOutput = true;
        if (this.audioOutput.isOffloadedPlayback()) {
            this.handledOffloadOnPresentationEnded = false;
        }
        AudioTrackAudioOutput audioTrackAudioOutput = this.audioOutput;
        if (audioTrackAudioOutput.hasBeenStopped) {
            return;
        }
        audioTrackAudioOutput.hasBeenStopped = true;
        AudioTrackPositionTracker audioTrackPositionTracker = audioTrackAudioOutput.audioTrackPositionTracker;
        long writtenFrames = audioTrackAudioOutput.getWrittenFrames();
        audioTrackPositionTracker.stopPlaybackHeadPosition = audioTrackPositionTracker.getPlaybackHeadPosition();
        audioTrackPositionTracker.clock.getClass();
        audioTrackPositionTracker.stopTimestampUs = Util.msToUs(SystemClock.elapsedRealtime());
        audioTrackPositionTracker.endPlaybackHeadPosition = writtenFrames;
        audioTrackAudioOutput.audioTrack.stop();
    }

    public final void processBuffers(long j) throws Exception {
        ByteBuffer byteBuffer;
        drainOutputBuffer(j);
        if (this.outputBuffer != null) {
            return;
        }
        if (!this.audioProcessingPipeline.isOperational()) {
            ByteBuffer byteBuffer2 = this.inputBuffer;
            if (byteBuffer2 != null) {
                setOutputBuffer(byteBuffer2);
                drainOutputBuffer(j);
                return;
            }
            return;
        }
        while (!this.audioProcessingPipeline.isEnded()) {
            do {
                AudioProcessingPipeline audioProcessingPipeline = this.audioProcessingPipeline;
                if (audioProcessingPipeline.isOperational()) {
                    ByteBuffer byteBuffer3 = audioProcessingPipeline.outputBuffers[audioProcessingPipeline.getFinalOutputBufferIndex()];
                    if (byteBuffer3.hasRemaining()) {
                        byteBuffer = byteBuffer3;
                    } else {
                        audioProcessingPipeline.processData(AudioProcessor.EMPTY_BUFFER);
                        byteBuffer = audioProcessingPipeline.outputBuffers[audioProcessingPipeline.getFinalOutputBufferIndex()];
                    }
                } else {
                    byteBuffer = AudioProcessor.EMPTY_BUFFER;
                }
                if (byteBuffer.hasRemaining()) {
                    setOutputBuffer(byteBuffer);
                    drainOutputBuffer(j);
                } else {
                    ByteBuffer byteBuffer4 = this.inputBuffer;
                    if (byteBuffer4 == null || !byteBuffer4.hasRemaining()) {
                        return;
                    }
                    AudioProcessingPipeline audioProcessingPipeline2 = this.audioProcessingPipeline;
                    ByteBuffer byteBuffer5 = this.inputBuffer;
                    if (audioProcessingPipeline2.isOperational() && !audioProcessingPipeline2.inputEnded) {
                        audioProcessingPipeline2.processData(byteBuffer5);
                    }
                }
            } while (this.outputBuffer == null);
            return;
        }
    }

    public final void reconfigureAndFlush() {
        Configuration configuration = this.configuration;
        if (configuration != null) {
            Configuration configuration2 = this.pendingConfiguration;
            if (configuration2 != null) {
                this.configuration = configuration2;
                this.pendingConfiguration = null;
                configuration = configuration2;
            }
            try {
                AudioOutputProvider.OutputConfig outputConfig = ((AudioTrackAudioOutputProvider) this.audioOutputProvider).getOutputConfig(getFormatConfig(configuration.afterProcessingInputFormat));
                Configuration configuration3 = this.configuration;
                this.configuration = new Configuration(configuration3.inputFormat, configuration3.afterProcessingInputFormat, configuration3.inputPcmFrameSize, configuration3.outputPcmFrameSize, outputConfig, configuration3.audioProcessingPipeline);
            } catch (AudioOutputProvider.ConfigurationException e) {
                throw new IllegalStateException(new AudioSink.ConfigurationException(e, this.configuration.inputFormat));
            }
        }
        flush();
    }

    public final void reset() {
        flush();
        ImmutableList.Itr itrListIterator = this.availableAudioProcessors.listIterator(0);
        while (itrListIterator.hasNext()) {
            ((AudioProcessor) itrListIterator.next()).reset();
        }
        this.toInt16PcmAudioProcessor.reset();
        this.toFloatPcmAudioProcessor.reset();
        AudioProcessingPipeline audioProcessingPipeline = this.audioProcessingPipeline;
        if (audioProcessingPipeline != null) {
            ImmutableList immutableList = audioProcessingPipeline.audioProcessors;
            for (int i = 0; i < immutableList.size(); i++) {
                AudioProcessor audioProcessor = (AudioProcessor) immutableList.get(i);
                audioProcessor.flush(AudioProcessor.StreamMetadata.DEFAULT);
                audioProcessor.reset();
            }
            audioProcessingPipeline.activeAudioProcessors.clear();
            audioProcessingPipeline.outputBuffers = new ByteBuffer[0];
            AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.NOT_SET;
            audioProcessingPipeline.inputEnded = false;
        }
        this.playing = false;
        this.offloadDisabledUntilNextConfiguration = false;
    }

    public final void setAudioOutputPlaybackParameters() {
        if (isAudioOutputInitialized()) {
            AudioTrackAudioOutput audioTrackAudioOutput = this.audioOutput;
            PlaybackParameters playbackParameters = this.playbackParameters;
            AudioTrack audioTrack = audioTrackAudioOutput.audioTrack;
            try {
                audioTrack.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(Util.constrainValue(playbackParameters.speed, 0.1f, 8.0f)).setPitch(Util.constrainValue(playbackParameters.pitch, 0.1f, 8.0f)).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e) {
                Log.w("AudioTrackAudioOutput", "Failed to set playback params", e);
            }
            AudioTrackPositionTracker audioTrackPositionTracker = audioTrackAudioOutput.audioTrackPositionTracker;
            audioTrackPositionTracker.audioTrackPlaybackSpeed = audioTrack.getPlaybackParams().getSpeed();
            audioTrackPositionTracker.audioTimestampPoller.updateState(0);
            audioTrackPositionTracker.smoothedPlayheadOffsetUs = 0L;
            audioTrackPositionTracker.playheadOffsetCount = 0;
            audioTrackPositionTracker.nextPlayheadOffsetIndex = 0;
            audioTrackPositionTracker.lastPlayheadSampleTimeUs = 0L;
            audioTrackPositionTracker.lastPositionUs = -9223372036854775807L;
            audioTrackPositionTracker.lastSystemTimeUs = -9223372036854775807L;
            PlaybackParams playbackParams = this.audioOutput.audioTrack.getPlaybackParams();
            this.playbackParameters = new PlaybackParameters(playbackParams.getSpeed(), playbackParams.getPitch());
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003c  */
    /* JADX WARN: Code duplicated, block: B:54:0x016f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x0171  */
    /* JADX WARN: Code duplicated, block: B:57:0x0174  */
    /* JADX WARN: Code duplicated, block: B:59:0x0178  */
    /* JADX WARN: Code duplicated, block: B:61:0x017c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0180  */
    /* JADX WARN: Code duplicated, block: B:65:0x0184  */
    /* JADX WARN: Code duplicated, block: B:67:0x0188  */
    /* JADX WARN: Code duplicated, block: B:69:0x018c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x018e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0197  */
    /* JADX WARN: Code duplicated, block: B:74:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:75:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:76:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x01db  */
    /* JADX WARN: Code duplicated, block: B:78:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:79:0x0205 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x0207  */
    /* JADX WARN: Code duplicated, block: B:81:0x020f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0216  */
    /* JADX WARN: Code duplicated, block: B:83:0x021d  */
    /* JADX WARN: Code duplicated, block: B:93:0x019f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0231 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x005d A[SYNTHETIC] */
    public final void setOutputBuffer(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferOrder;
        int i;
        byte b;
        int i2;
        int i3;
        int i4;
        UtilsKt.checkState(this.outputBuffer == null);
        if (byteBuffer.hasRemaining()) {
            if (this.configuration.isPcm()) {
                int iScaleLargeValue = (int) Util.scaleLargeValue(Util.msToUs(20L), this.configuration.outputConfig.sampleRate, 1000000L, RoundingMode.UP);
                long writtenFrames = getWrittenFrames();
                long j = iScaleLargeValue;
                if (writtenFrames >= j) {
                    byteBufferOrder = byteBuffer;
                } else {
                    Configuration configuration = this.configuration;
                    int i5 = configuration.outputConfig.encoding;
                    int i6 = configuration.outputPcmFrameSize;
                    int i7 = (int) writtenFrames;
                    byteBufferOrder = ByteBuffer.allocateDirect(byteBuffer.remaining()).order(ByteOrder.nativeOrder());
                    int iPosition = byteBuffer.position();
                    while (byteBuffer.hasRemaining() && i7 < iScaleLargeValue) {
                        if (i5 != 2) {
                            if (i5 == 3) {
                                i3 = (byteBuffer.get() & 255) << 24;
                            } else if (i5 == 4) {
                                float fConstrainValue = Util.constrainValue(byteBuffer.getFloat(), -1.0f, 1.0f);
                                i3 = (int) (fConstrainValue < CropImageView.DEFAULT_ASPECT_RATIO ? (-fConstrainValue) * (-2.1474836E9f) : fConstrainValue * 2.1474836E9f);
                            } else if (i5 == 21) {
                                i = ((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 16);
                                b = byteBuffer.get();
                            } else if (i5 != 22) {
                                if (i5 == 268435456) {
                                    i = (byteBuffer.get() & 255) << 24;
                                    i2 = (byteBuffer.get() & 255) << 16;
                                } else if (i5 == 1342177280) {
                                    i = ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16);
                                    i2 = (byteBuffer.get() & 255) << 8;
                                } else if (i5 == 1610612736) {
                                    i = ((byteBuffer.get() & 255) << 24) | ((byteBuffer.get() & 255) << 16) | ((byteBuffer.get() & 255) << 8);
                                    i2 = byteBuffer.get() & 255;
                                } else if (i5 != 1879048192) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                    return;
                                } else {
                                    double dMax = Math.max(-1.0d, Math.min(byteBuffer.getDouble(), 1.0d));
                                    i3 = (int) (dMax < 0.0d ? (-dMax) * (-2.147483648E9d) : dMax * 2.147483647E9d);
                                }
                                i3 = i | i2;
                            } else {
                                i = (byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 8) | ((byteBuffer.get() & 255) << 16);
                                b = byteBuffer.get();
                            }
                            i4 = (int) ((((long) i3) * ((long) i7)) / j);
                            if (i5 != 2) {
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i5 != 3) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i5 != 4) {
                                if (i5 != 21) {
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                } else if (i5 != 22) {
                                    byteBufferOrder.put((byte) i4);
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                } else if (i5 != 268435456) {
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                } else if (i5 != 1342177280) {
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                } else if (i5 != 1610612736) {
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) i4);
                                } else if (i5 == 1879048192) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                    return;
                                } else if (i4 < 0) {
                                    byteBufferOrder.putDouble((-i4) / (-2.147483648E9d));
                                } else {
                                    byteBufferOrder.putDouble(((double) i4) / 2.147483647E9d);
                                }
                            } else if (i4 < 0) {
                                byteBufferOrder.putFloat((-i4) / (-2.1474836E9f));
                            } else {
                                byteBufferOrder.putFloat(i4 / 2.1474836E9f);
                            }
                            if (byteBuffer.position() == iPosition + i6) {
                                i7++;
                                iPosition = byteBuffer.position();
                            }
                        } else {
                            i = (byteBuffer.get() & 255) << 16;
                            b = byteBuffer.get();
                        }
                        i2 = (b & 255) << 24;
                        i3 = i | i2;
                        i4 = (int) ((((long) i3) * ((long) i7)) / j);
                        if (i5 != 2) {
                            byteBufferOrder.put((byte) (i4 >> 16));
                            byteBufferOrder.put((byte) (i4 >> 24));
                        } else if (i5 != 3) {
                            byteBufferOrder.put((byte) (i4 >> 24));
                        } else if (i5 != 4) {
                            if (i5 != 21) {
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i5 != 22) {
                                byteBufferOrder.put((byte) i4);
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i5 != 268435456) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                            } else if (i5 != 1342177280) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 8));
                            } else if (i5 != 1610612736) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) i4);
                            } else if (i5 == 1879048192) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                return;
                            } else if (i4 < 0) {
                                byteBufferOrder.putDouble((-i4) / (-2.147483648E9d));
                            } else {
                                byteBufferOrder.putDouble(((double) i4) / 2.147483647E9d);
                            }
                        } else if (i4 < 0) {
                            byteBufferOrder.putFloat((-i4) / (-2.1474836E9f));
                        } else {
                            byteBufferOrder.putFloat(i4 / 2.1474836E9f);
                        }
                        if (byteBuffer.position() == iPosition + i6) {
                            i7++;
                            iPosition = byteBuffer.position();
                        }
                    }
                    byteBufferOrder.put(byteBuffer);
                    byteBufferOrder.flip();
                }
            } else {
                byteBufferOrder = byteBuffer;
            }
            this.outputBuffer = byteBufferOrder;
        }
    }

    public final boolean useAudioOutputPlaybackParams() {
        Configuration configuration = this.configuration;
        return configuration != null && configuration.outputConfig.usePlaybackParameters;
    }
}
