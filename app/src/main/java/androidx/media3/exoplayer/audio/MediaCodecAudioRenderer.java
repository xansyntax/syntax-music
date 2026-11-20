package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.compose.ui.platform.WeakCache;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.audio.Sonic;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.CodecParameters;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.MediaClock;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.mediacodec.LoudnessCodecController;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.mp4.BoxParser;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.materialkolor.quantize.QuantizerWu;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    public boolean allowPositionDiscontinuity;
    public final AudioSink audioSink;
    public boolean audioSinkNeedsReset;
    public int codecMaxInputSize;
    public boolean codecNeedsVorbisToAndroidChannelMappingWorkaround;
    public final Context context;
    public long currentPositionUs;
    public Format decryptOnlyCodecFormat;
    public final AudioRendererEventListener$EventDispatcher eventDispatcher;
    public boolean hasPendingReportedSkippedSilence;
    public boolean hasReportedAudioPositionAdvancing;
    public Format inputFormat;
    public boolean isStarted;
    public final LoudnessCodecController loudnessCodecController;
    public long nextBufferToWritePresentationTimeUs;
    public int rendererPriority;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaCodecAudioRenderer(Context context, MediaCodecAdapter.Factory factory, Handler handler, ExoPlayerImpl.ComponentListener componentListener, AudioSink audioSink) {
        super(context.getApplicationContext(), 1, factory, 44100.0f);
        LoudnessCodecController loudnessCodecController = Build.VERSION.SDK_INT >= 35 ? new LoudnessCodecController() : null;
        this.context = context.getApplicationContext();
        this.audioSink = audioSink;
        this.loudnessCodecController = loudnessCodecController;
        this.rendererPriority = -1000;
        this.eventDispatcher = new AudioRendererEventListener$EventDispatcher(handler, componentListener, (byte) 0);
        this.nextBufferToWritePresentationTimeUs = -9223372036854775807L;
    }

    public static RegularImmutableList getDecoderInfos(Format format, boolean z, AudioSink audioSink) {
        if (format.sampleMimeType == null) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            return RegularImmutableList.EMPTY;
        }
        if (((DefaultAudioSink) audioSink).getFormatSupport(format) != 0) {
            List decoderInfos = MediaCodecUtil.getDecoderInfos("audio/raw", false, false);
            MediaCodecInfo mediaCodecInfo = decoderInfos.isEmpty() ? null : (MediaCodecInfo) decoderInfos.get(0);
            if (mediaCodecInfo != null) {
                return ImmutableList.of((Object) mediaCodecInfo);
            }
        }
        return MediaCodecUtil.getDecoderInfosSoftMatch(format, z, false);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2, boolean z) {
        DecoderReuseEvaluation decoderReuseEvaluationCanReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i = decoderReuseEvaluationCanReuseCodec.discardReasons;
        if (this.sourceDrmSession == null && shouldUseBypass(format2)) {
            i |= 32768;
        }
        "OMX.google.raw.decoder".equals(mediaCodecInfo.name);
        if (format2.maxInputSize > this.codecMaxInputSize) {
            i |= 64;
        }
        int i2 = i;
        return new DecoderReuseEvaluation(mediaCodecInfo.name, format, format2, i2 != 0 ? 0 : decoderReuseEvaluationCanReuseCodec.result, i2);
    }

    public final int getAudioOffloadSupport(Format format) {
        AudioOffloadSupport audioOffloadSupportBuild;
        DefaultAudioSink defaultAudioSink = (DefaultAudioSink) this.audioSink;
        if (defaultAudioSink.offloadDisabledUntilNextConfiguration) {
            audioOffloadSupportBuild = AudioOffloadSupport.DEFAULT_UNSUPPORTED;
        } else {
            AudioOutputProvider.FormatSupport formatSupport = ((AudioTrackAudioOutputProvider) defaultAudioSink.audioOutputProvider).getFormatSupport(defaultAudioSink.getFormatConfig(format));
            BoxParser.StriData striData = new BoxParser.StriData();
            striData.hasLeftEyeView = formatSupport.isFormatSupportedForOffload;
            striData.hasRightEyeView = formatSupport.isGaplessSupportedForOffload;
            striData.eyeViewsReversed = formatSupport.isSpeedChangeSupportedForOffload;
            audioOffloadSupportBuild = striData.build();
        }
        if (!audioOffloadSupportBuild.isFormatSupported) {
            return 0;
        }
        int i = audioOffloadSupportBuild.isGaplessSupported ? 1536 : 512;
        return audioOffloadSupportBuild.isSpeedChangeSupported ? i | 2048 : i;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final long getDurationToProgressUs(long j, long j2, boolean z) {
        long jScaleLargeValue;
        DefaultAudioSink defaultAudioSink = (DefaultAudioSink) this.audioSink;
        boolean z2 = defaultAudioSink.hasPendingData() && this.nextBufferToWritePresentationTimeUs != -9223372036854775807L;
        if (this.isStarted) {
            if (!defaultAudioSink.isAudioOutputInitialized()) {
                jScaleLargeValue = -9223372036854775807L;
            } else if (defaultAudioSink.configuration.isPcm()) {
                jScaleLargeValue = Util.sampleCountToDurationUs(defaultAudioSink.configuration.outputConfig.sampleRate, defaultAudioSink.audioOutput.audioTrack.getBufferSizeInFrames());
            } else {
                long bufferSizeInFrames = defaultAudioSink.audioOutput.audioTrack.getBufferSizeInFrames();
                int maximumEncodedRateBytesPerSecond = AacUtil.getMaximumEncodedRateBytesPerSecond(defaultAudioSink.configuration.outputConfig.encoding);
                UtilsKt.checkState(maximumEncodedRateBytesPerSecond != -2147483647);
                jScaleLargeValue = Util.scaleLargeValue(bufferSizeInFrames, 1000000L, maximumEncodedRateBytesPerSecond, RoundingMode.DOWN);
            }
            if (this.hasReportedAudioPositionAdvancing && z2 && jScaleLargeValue != -9223372036854775807L) {
                return Math.max(10000L, (long) ((Math.min(jScaleLargeValue, this.nextBufferToWritePresentationTimeUs - j) / (getPlaybackParameters() != null ? getPlaybackParameters().speed : 1.0f)) / 2.0f));
            }
        } else if (z2 || this.outputStreamEnded) {
            return 1000000L;
        }
        return 10000L;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final QuantizerWu getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f) {
        int iIntValue;
        int i;
        Integer num;
        Format[] formatArr = this.streamFormats;
        formatArr.getClass();
        String str = mediaCodecInfo.name;
        "OMX.google.raw.decoder".equals(str);
        int iMax = format.maxInputSize;
        String str2 = format.sampleMimeType;
        int i2 = format.channelCount;
        int i3 = 0;
        if (formatArr.length != 1) {
            for (Format format2 : formatArr) {
                if (mediaCodecInfo.canReuseCodec(format, format2).result != 0) {
                    "OMX.google.raw.decoder".equals(str);
                    iMax = Math.max(iMax, format2.maxInputSize);
                }
            }
        }
        this.codecMaxInputSize = iMax;
        this.codecNeedsVorbisToAndroidChannelMappingWorkaround = str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
        String str3 = mediaCodecInfo.codecMimeType;
        int i4 = this.codecMaxInputSize;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str3);
        mediaFormat.setInteger("channel-count", i2);
        int i5 = format.sampleRate;
        mediaFormat.setInteger("sample-rate", i5);
        Log.setCsdBuffers(mediaFormat, format.initializationData);
        Log.maybeSetInteger(mediaFormat, "max-input-size", i4);
        mediaFormat.setInteger("priority", 0);
        if (f != -1.0f) {
            mediaFormat.setFloat("operating-rate", f);
        }
        if ("audio/ac4".equals(str2)) {
            Pair codecProfileAndLevel = CodecSpecificDataUtil.getCodecProfileAndLevel(format);
            if (codecProfileAndLevel != null) {
                Log.maybeSetInteger(mediaFormat, "profile", ((Integer) codecProfileAndLevel.first).intValue());
                Log.maybeSetInteger(mediaFormat, "level", ((Integer) codecProfileAndLevel.second).intValue());
            }
            if (Build.VERSION.SDK_INT <= 28) {
                mediaFormat.setInteger("ac4-is-sync", 1);
            }
        }
        Format.Builder builder = new Format.Builder();
        builder.sampleMimeType = MimeTypes.normalizeMimeType("audio/raw");
        builder.channelCount = i2;
        builder.sampleRate = i5;
        builder.pcmEncoding = 4;
        Format format3 = new Format(builder);
        DefaultAudioSink defaultAudioSink = (DefaultAudioSink) this.audioSink;
        if (defaultAudioSink.getFormatSupport(format3) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        if (i6 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.rendererPriority));
        }
        Format format4 = null;
        if (Objects.equals(str2, "audio/iamf")) {
            AudioOutputProvider audioOutputProvider = defaultAudioSink.audioOutputProvider;
            AudioCapabilities audioCapabilities = audioOutputProvider instanceof AudioTrackAudioOutputProvider ? ((AudioTrackAudioOutputProvider) audioOutputProvider).audioCapabilities : null;
            if (audioCapabilities == null) {
                Log.w("MediaCodecAudioRenderer", "AudioCapabilities from the AudioSink are null, using default stereo output layout.");
                mediaFormat.setInteger("channel-mask", 12);
                mediaFormat.setInteger("max-output-channel-count", 2);
            } else {
                ImmutableSet immutableSet = IamfUtil.IAMF_SUPPORTED_CHANNEL_MASKS;
                ImmutableList immutableList = audioCapabilities.spatializerChannelMasks;
                int size = immutableList.size();
                int i7 = 0;
                do {
                    if (i7 >= size) {
                        iIntValue = 0;
                        break;
                    }
                    Object obj = immutableList.get(i7);
                    i7++;
                    num = (Integer) obj;
                    iIntValue = num.intValue();
                } while (!IamfUtil.IAMF_SUPPORTED_CHANNEL_MASKS.contains(num));
                if (iIntValue != 0) {
                    i = iIntValue;
                } else {
                    ImmutableList immutableList2 = audioCapabilities.speakerLayoutChannelMasks;
                    int size2 = immutableList2.size();
                    int i8 = 0;
                    while (i8 < size2) {
                        Object obj2 = immutableList2.get(i8);
                        i8++;
                        Integer num2 = (Integer) obj2;
                        int iIntValue2 = num2.intValue();
                        if (IamfUtil.IAMF_SUPPORTED_CHANNEL_MASKS.contains(num2)) {
                            i3 = iIntValue2;
                            break;
                        }
                    }
                    i = i3 != 0 ? i3 : 12;
                }
                int iBitCount = Integer.bitCount(i);
                mediaFormat.setInteger("channel-mask", i);
                mediaFormat.setInteger("max-output-channel-count", iBitCount);
            }
        }
        applyCodecParametersToMediaFormat(mediaFormat);
        if ("audio/raw".equals(mediaCodecInfo.mimeType) && !"audio/raw".equals(str2)) {
            format4 = format;
        }
        this.decryptOnlyCodecFormat = format4;
        return new QuantizerWu(mediaCodecInfo, mediaFormat, format, (Surface) null, mediaCrypto, this.loudnessCodecController);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final PlaybackParameters getPlaybackParameters() {
        return ((DefaultAudioSink) this.audioSink).playbackParameters;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final long getPositionUs() {
        if (this.state == 2) {
            updateCurrentPosition();
        }
        return this.currentPositionUs;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) {
        Format format;
        DefaultAudioSink.Configuration configuration;
        if (Build.VERSION.SDK_INT < 29 || (format = decoderInputBuffer.format) == null || !Objects.equals(format.sampleMimeType, "audio/opus") || !this.bypassEnabled) {
            return;
        }
        ByteBuffer byteBuffer = decoderInputBuffer.supplementalData;
        byteBuffer.getClass();
        Format format2 = decoderInputBuffer.format;
        format2.getClass();
        int i = format2.encoderDelay;
        if (byteBuffer.remaining() == 8) {
            int i2 = (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000);
            DefaultAudioSink defaultAudioSink = (DefaultAudioSink) this.audioSink;
            AudioTrackAudioOutput audioTrackAudioOutput = defaultAudioSink.audioOutput;
            if (audioTrackAudioOutput == null || !audioTrackAudioOutput.isOffloadedPlayback() || (configuration = defaultAudioSink.configuration) == null || !configuration.outputConfig.useOffloadGapless) {
                return;
            }
            defaultAudioSink.audioOutput.setOffloadDelayPadding(i, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x009c  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public final void handleMessage(int i, Object obj) {
        LoudnessCodecController loudnessCodecController;
        AudioSink audioSink = this.audioSink;
        if (i == 2) {
            obj.getClass();
            float fFloatValue = ((Float) obj).floatValue();
            DefaultAudioSink defaultAudioSink = (DefaultAudioSink) audioSink;
            if (defaultAudioSink.volume != fFloatValue) {
                defaultAudioSink.volume = fFloatValue;
                if (defaultAudioSink.isAudioOutputInitialized()) {
                    defaultAudioSink.audioOutput.audioTrack.setVolume(defaultAudioSink.volume);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 3) {
            AudioAttributes audioAttributes = (AudioAttributes) obj;
            audioAttributes.getClass();
            DefaultAudioSink defaultAudioSink2 = (DefaultAudioSink) audioSink;
            if (defaultAudioSink2.audioAttributes.equals(audioAttributes)) {
                return;
            }
            defaultAudioSink2.audioAttributes = audioAttributes;
            if (defaultAudioSink2.tunneling) {
                return;
            }
            defaultAudioSink2.reconfigureAndFlush();
            return;
        }
        if (i == 6) {
            AuxEffectInfo auxEffectInfo = (AuxEffectInfo) obj;
            auxEffectInfo.getClass();
            DefaultAudioSink defaultAudioSink3 = (DefaultAudioSink) audioSink;
            if (defaultAudioSink3.auxEffectInfo.equals(auxEffectInfo)) {
                return;
            }
            if (defaultAudioSink3.audioOutput != null) {
                defaultAudioSink3.auxEffectInfo.getClass();
            }
            defaultAudioSink3.auxEffectInfo = auxEffectInfo;
            return;
        }
        if (i == 12) {
            AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) obj;
            DefaultAudioSink defaultAudioSink4 = (DefaultAudioSink) audioSink;
            defaultAudioSink4.preferredDevice = audioDeviceInfo;
            AudioTrackAudioOutput audioTrackAudioOutput = defaultAudioSink4.audioOutput;
            if (audioTrackAudioOutput != null) {
                audioTrackAudioOutput.audioTrack.setPreferredDevice(audioDeviceInfo);
                return;
            }
            return;
        }
        if (i == 16) {
            obj.getClass();
            this.rendererPriority = ((Integer) obj).intValue();
            MediaCodecAdapter mediaCodecAdapter = this.codec;
            if (mediaCodecAdapter != null && Build.VERSION.SDK_INT >= 35) {
                Bundle bundle = new Bundle();
                bundle.putInt("importance", Math.max(0, -this.rendererPriority));
                mediaCodecAdapter.setParameters(bundle);
                return;
            }
            return;
        }
        if (i == 9) {
            obj.getClass();
            DefaultAudioSink defaultAudioSink5 = (DefaultAudioSink) audioSink;
            defaultAudioSink5.skipSilenceEnabled = ((Boolean) obj).booleanValue();
            DefaultAudioSink.MediaPositionParameters mediaPositionParameters = new DefaultAudioSink.MediaPositionParameters(defaultAudioSink5.useAudioOutputPlaybackParams() ? PlaybackParameters.DEFAULT : defaultAudioSink5.playbackParameters, -9223372036854775807L, -9223372036854775807L);
            if (defaultAudioSink5.isAudioOutputInitialized()) {
                defaultAudioSink5.afterDrainParameters = mediaPositionParameters;
                return;
            } else {
                defaultAudioSink5.mediaPositionParameters = mediaPositionParameters;
                return;
            }
        }
        if (i == 10) {
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            DefaultAudioSink defaultAudioSink6 = (DefaultAudioSink) audioSink;
            if (defaultAudioSink6.pendingAudioSessionIdChangeConfirmation) {
                if (defaultAudioSink6.audioSessionId == iIntValue) {
                    defaultAudioSink6.pendingAudioSessionIdChangeConfirmation = false;
                    if (defaultAudioSink6.audioSessionId != iIntValue) {
                        defaultAudioSink6.audioSessionId = iIntValue;
                        defaultAudioSink6.externalAudioSessionIdProvided = iIntValue != 0;
                        defaultAudioSink6.reconfigureAndFlush();
                    }
                }
            } else if (defaultAudioSink6.audioSessionId != iIntValue) {
                defaultAudioSink6.audioSessionId = iIntValue;
                defaultAudioSink6.externalAudioSessionIdProvided = iIntValue != 0;
                defaultAudioSink6.reconfigureAndFlush();
            }
            if (Build.VERSION.SDK_INT < 35 || (loudnessCodecController = this.loudnessCodecController) == null) {
                return;
            }
            loudnessCodecController.setAudioSessionId(iIntValue);
            return;
        }
        if (i == 19) {
            obj.getClass();
            int iIntValue2 = ((Integer) obj).intValue();
            DefaultAudioSink defaultAudioSink7 = (DefaultAudioSink) audioSink;
            AtomicInteger atomicInteger = DefaultAudioSink.pendingReleaseCount;
            if (iIntValue2 == 0 || iIntValue2 == -1) {
                iIntValue2 = -1;
            }
            if (defaultAudioSink7.virtualDeviceId == iIntValue2) {
                return;
            }
            defaultAudioSink7.virtualDeviceId = iIntValue2;
            defaultAudioSink7.reconfigureAndFlush();
            return;
        }
        if (i != 20) {
            super.handleMessage(i, obj);
            return;
        }
        obj.getClass();
        AudioOutputProvider audioOutputProvider = (AudioOutputProvider) obj;
        DefaultAudioSink defaultAudioSink8 = (DefaultAudioSink) audioSink;
        if (audioOutputProvider.equals(defaultAudioSink8.audioOutputProvider)) {
            return;
        }
        ((AudioTrackAudioOutputProvider) defaultAudioSink8.audioOutputProvider).release();
        defaultAudioSink8.audioOutputProvider = audioOutputProvider;
        DefaultAudioSink$$ExternalSyntheticLambda0 defaultAudioSink$$ExternalSyntheticLambda0 = defaultAudioSink8.audioOutputProviderListener;
        if (defaultAudioSink$$ExternalSyntheticLambda0 != null) {
            AudioTrackAudioOutputProvider audioTrackAudioOutputProvider = (AudioTrackAudioOutputProvider) audioOutputProvider;
            audioTrackAudioOutputProvider.verifySinglePlaybackLooper();
            ListenerSet listenerSet = audioTrackAudioOutputProvider.listeners;
            if (listenerSet == null) {
                listenerSet = new ListenerSet(Thread.currentThread());
                audioTrackAudioOutputProvider.listeners = listenerSet;
            }
            listenerSet.add(defaultAudioSink$$ExternalSyntheticLambda0);
        }
        defaultAudioSink8.reconfigureAndFlush();
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final boolean hasSkippedSilenceSinceLastCall() {
        boolean z = this.hasPendingReportedSkippedSilence;
        this.hasPendingReportedSkippedSilence = false;
        return z;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final boolean isEnded() {
        if (!this.outputStreamEnded) {
            return false;
        }
        DefaultAudioSink defaultAudioSink = (DefaultAudioSink) this.audioSink;
        if (defaultAudioSink.isAudioOutputInitialized()) {
            return defaultAudioSink.handledEndOfStream && !defaultAudioSink.hasPendingData();
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final boolean isReady() {
        return ((DefaultAudioSink) this.audioSink).hasPendingData();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onCodecError(Exception exc) {
        Log.e("MediaCodecAudioRenderer", "Audio codec error", exc);
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            handler.post(new AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, (Object) exc, (byte) 0));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onCodecInitialized(long j, long j2, String str) {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            handler.post(new AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, str, j, j2));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onCodecParametersChanged(CodecParameters codecParameters) {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            handler.post(new ComponentActivity$$ExternalSyntheticLambda10(audioRendererEventListener$EventDispatcher, codecParameters, (byte) 20));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onCodecReleased(String str) {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            handler.post(new AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, (Object) str, (byte) 5));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void onDisabled() {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        this.audioSinkNeedsReset = true;
        this.inputFormat = null;
        this.nextBufferToWritePresentationTimeUs = -9223372036854775807L;
        this.hasReportedAudioPositionAdvancing = false;
        try {
            ((DefaultAudioSink) this.audioSink).flush();
            try {
                super.onDisabled();
            } finally {
                audioRendererEventListener$EventDispatcher.disabled(this.decoderCounters);
            }
        } catch (Throwable th) {
            try {
                super.onDisabled();
                throw th;
            } finally {
                audioRendererEventListener$EventDispatcher.disabled(this.decoderCounters);
            }
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onEnabled(boolean z, boolean z2) {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.decoderCounters = decoderCounters;
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            handler.post(new AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, (Object) decoderCounters, (byte) 6));
        }
        RendererConfiguration rendererConfiguration = this.configuration;
        rendererConfiguration.getClass();
        boolean z3 = rendererConfiguration.tunneling;
        AudioSink audioSink = this.audioSink;
        if (z3) {
            DefaultAudioSink defaultAudioSink = (DefaultAudioSink) audioSink;
            UtilsKt.checkState(defaultAudioSink.externalAudioSessionIdProvided);
            if (!defaultAudioSink.tunneling) {
                defaultAudioSink.tunneling = true;
                defaultAudioSink.reconfigureAndFlush();
            }
        } else {
            DefaultAudioSink defaultAudioSink2 = (DefaultAudioSink) audioSink;
            if (defaultAudioSink2.tunneling) {
                defaultAudioSink2.tunneling = false;
                defaultAudioSink2.reconfigureAndFlush();
            }
        }
        PlayerId playerId = this.playerId;
        playerId.getClass();
        DefaultAudioSink defaultAudioSink3 = (DefaultAudioSink) audioSink;
        defaultAudioSink3.playerId = playerId;
        SystemClock systemClock = this.clock;
        systemClock.getClass();
        ((AudioTrackAudioOutputProvider) defaultAudioSink3.audioOutputProvider).clock = systemClock;
        defaultAudioSink3.listener = new AtomicInt(this);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final DecoderReuseEvaluation onInputFormatChanged(WeakCache weakCache) {
        Format format = (Format) weakCache.referenceQueue;
        format.getClass();
        this.inputFormat = format;
        DecoderReuseEvaluation decoderReuseEvaluationOnInputFormatChanged = super.onInputFormatChanged(weakCache);
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            handler.post(new AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, format, decoderReuseEvaluationOnInputFormatChanged));
        }
        return decoderReuseEvaluationOnInputFormatChanged;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00eb A[Catch: ConfigurationException -> 0x00e9, TryCatch #0 {ConfigurationException -> 0x00e9, blocks: (B:36:0x00c0, B:39:0x00c8, B:41:0x00cc, B:43:0x00d5, B:47:0x00e3, B:50:0x00eb, B:54:0x00f2, B:55:0x00f7), top: B:59:0x00c0 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f1  */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onOutputFormatChanged(Format format, MediaFormat mediaFormat) throws ExoPlaybackException {
        int pcmEncoding;
        Format format2 = this.decryptOnlyCodecFormat;
        boolean z = true;
        int[] iArr = null;
        if (format2 != null) {
            format = format2;
        } else if (this.codec != null) {
            mediaFormat.getClass();
            if ("audio/raw".equals(format.sampleMimeType)) {
                pcmEncoding = format.pcmEncoding;
            } else if (mediaFormat.containsKey("pcm-encoding")) {
                pcmEncoding = mediaFormat.getInteger("pcm-encoding");
            } else {
                pcmEncoding = mediaFormat.containsKey("v-bits-per-sample") ? Util.getPcmEncoding(mediaFormat.getInteger("v-bits-per-sample"), ByteOrder.LITTLE_ENDIAN) : 2;
            }
            Format.Builder builder = new Format.Builder();
            builder.sampleMimeType = MimeTypes.normalizeMimeType("audio/raw");
            builder.pcmEncoding = pcmEncoding;
            builder.encoderDelay = format.encoderDelay;
            builder.encoderPadding = format.encoderPadding;
            builder.metadata = format.metadata;
            builder.id = format.id;
            builder.label = format.label;
            builder.labels = ImmutableList.copyOf((Collection) format.labels);
            builder.language = format.language;
            builder.selectionFlags = format.selectionFlags;
            builder.roleFlags = format.roleFlags;
            builder.channelCount = mediaFormat.getInteger("channel-count");
            builder.sampleRate = mediaFormat.getInteger("sample-rate");
            format = new Format(builder);
            if (this.codecNeedsVorbisToAndroidChannelMappingWorkaround) {
                int i = format.channelCount;
                if (i == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
            }
        }
        try {
            int i2 = Build.VERSION.SDK_INT;
            AudioSink audioSink = this.audioSink;
            if (i2 >= 29) {
                if (this.bypassEnabled) {
                    RendererConfiguration rendererConfiguration = this.configuration;
                    rendererConfiguration.getClass();
                    if (rendererConfiguration.offloadModePreferred != 0) {
                        RendererConfiguration rendererConfiguration2 = this.configuration;
                        rendererConfiguration2.getClass();
                        int i3 = rendererConfiguration2.offloadModePreferred;
                        DefaultAudioSink defaultAudioSink = (DefaultAudioSink) audioSink;
                        if (i2 < 29) {
                            z = false;
                        }
                        UtilsKt.checkState(z);
                        defaultAudioSink.offloadMode = i3;
                    } else {
                        DefaultAudioSink defaultAudioSink2 = (DefaultAudioSink) audioSink;
                        if (i2 >= 29) {
                            z = false;
                        }
                        UtilsKt.checkState(z);
                        defaultAudioSink2.offloadMode = 0;
                    }
                } else {
                    DefaultAudioSink defaultAudioSink3 = (DefaultAudioSink) audioSink;
                    if (i2 >= 29) {
                        z = false;
                    }
                    UtilsKt.checkState(z);
                    defaultAudioSink3.offloadMode = 0;
                }
            }
            ((DefaultAudioSink) audioSink).configure(format, iArr);
        } catch (AudioSink.ConfigurationException e) {
            throw createRendererException(e, e.format, false, 5001);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void onPositionReset(long j, boolean z, boolean z2) {
        super.onPositionReset(j, z, z2);
        ((DefaultAudioSink) this.audioSink).flush();
        this.currentPositionUs = j;
        this.nextBufferToWritePresentationTimeUs = -9223372036854775807L;
        this.hasPendingReportedSkippedSilence = false;
        this.hasReportedAudioPositionAdvancing = false;
        this.allowPositionDiscontinuity = true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onProcessedStreamChange() {
        ((DefaultAudioSink) this.audioSink).startMediaTimeUsNeedsSync = true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onRelease() {
        LoudnessCodecController loudnessCodecController;
        ((AudioTrackAudioOutputProvider) ((DefaultAudioSink) this.audioSink).audioOutputProvider).release();
        if (Build.VERSION.SDK_INT < 35 || (loudnessCodecController = this.loudnessCodecController) == null) {
            return;
        }
        loudnessCodecController.release();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onReset() {
        AudioSink audioSink = this.audioSink;
        this.hasPendingReportedSkippedSilence = false;
        this.hasReportedAudioPositionAdvancing = false;
        this.nextBufferToWritePresentationTimeUs = -9223372036854775807L;
        try {
            try {
                this.bypassEnabled = false;
                resetBypassState();
                releaseCodec();
                DrmSession drmSession = this.sourceDrmSession;
                if (drmSession != null) {
                    drmSession.release(null);
                }
                this.sourceDrmSession = null;
                if (this.audioSinkNeedsReset) {
                    this.audioSinkNeedsReset = false;
                    ((DefaultAudioSink) audioSink).reset();
                }
            } catch (Throwable th) {
                DrmSession drmSession2 = this.sourceDrmSession;
                if (drmSession2 != null) {
                    drmSession2.release(null);
                }
                this.sourceDrmSession = null;
                throw th;
            }
        } catch (Throwable th2) {
            if (this.audioSinkNeedsReset) {
                this.audioSinkNeedsReset = false;
                ((DefaultAudioSink) audioSink).reset();
            }
            throw th2;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onStarted() {
        ((DefaultAudioSink) this.audioSink).play();
        this.isStarted = true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void onStopped() {
        updateCurrentPosition();
        this.isStarted = false;
        DefaultAudioSink defaultAudioSink = (DefaultAudioSink) this.audioSink;
        defaultAudioSink.playing = false;
        if (defaultAudioSink.isAudioOutputInitialized()) {
            AudioTrackAudioOutput audioTrackAudioOutput = defaultAudioSink.audioOutput;
            AudioTrackPositionTracker audioTrackPositionTracker = audioTrackAudioOutput.audioTrackPositionTracker;
            audioTrackPositionTracker.smoothedPlayheadOffsetUs = 0L;
            audioTrackPositionTracker.playheadOffsetCount = 0;
            audioTrackPositionTracker.nextPlayheadOffsetIndex = 0;
            audioTrackPositionTracker.lastPlayheadSampleTimeUs = 0L;
            audioTrackPositionTracker.lastPositionUs = -9223372036854775807L;
            audioTrackPositionTracker.lastSystemTimeUs = -9223372036854775807L;
            if (audioTrackPositionTracker.stopTimestampUs == -9223372036854775807L) {
                audioTrackPositionTracker.audioTimestampPoller.updateState(0);
            }
            audioTrackPositionTracker.stopPlaybackHeadPosition = audioTrackPositionTracker.getPlaybackHeadPosition();
            if (!audioTrackAudioOutput.hasBeenStopped || audioTrackAudioOutput.isOffloadedPlayback()) {
                audioTrackAudioOutput.audioTrack.pause();
            }
        }
        this.hasReportedAudioPositionAdvancing = false;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final boolean processOutputBuffer(long j, long j2, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        int i4;
        int i5;
        byteBuffer.getClass();
        this.nextBufferToWritePresentationTimeUs = -9223372036854775807L;
        if (this.decryptOnlyCodecFormat != null && (i2 & 2) != 0) {
            mediaCodecAdapter.getClass();
            mediaCodecAdapter.releaseOutputBuffer(i);
            return true;
        }
        AudioSink audioSink = this.audioSink;
        if (z) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.releaseOutputBuffer(i);
            }
            this.decoderCounters.skippedOutputBufferCount += i3;
            ((DefaultAudioSink) audioSink).startMediaTimeUsNeedsSync = true;
            return true;
        }
        try {
            if (!((DefaultAudioSink) audioSink).handleBuffer(i3, j3, byteBuffer)) {
                this.nextBufferToWritePresentationTimeUs = j3;
                return false;
            }
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.releaseOutputBuffer(i);
            }
            this.decoderCounters.renderedOutputBufferCount += i3;
            return true;
        } catch (AudioSink.InitializationException e) {
            Format format2 = this.inputFormat;
            if (this.bypassEnabled) {
                RendererConfiguration rendererConfiguration = this.configuration;
                rendererConfiguration.getClass();
                if (rendererConfiguration.offloadModePreferred != 0) {
                    i5 = 5004;
                } else {
                    i5 = 5001;
                }
            } else {
                i5 = 5001;
            }
            throw createRendererException(e, format2, e.isRecoverable, i5);
        } catch (AudioSink.WriteException e2) {
            if (this.bypassEnabled) {
                RendererConfiguration rendererConfiguration2 = this.configuration;
                rendererConfiguration2.getClass();
                if (rendererConfiguration2.offloadModePreferred != 0) {
                    i4 = 5003;
                } else {
                    i4 = 5002;
                }
            } else {
                i4 = 5002;
            }
            throw createRendererException(e2, format, e2.isRecoverable, i4);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void renderToEndOfStream() throws ExoPlaybackException {
        try {
            DefaultAudioSink defaultAudioSink = (DefaultAudioSink) this.audioSink;
            if (!defaultAudioSink.handledEndOfStream && defaultAudioSink.isAudioOutputInitialized() && defaultAudioSink.drainToEndOfStream()) {
                defaultAudioSink.playPendingData();
                defaultAudioSink.handledEndOfStream = true;
            }
            long j = this.outputStreamInfo.lastBufferTimeUs;
            if (j != -9223372036854775807L) {
                this.nextBufferToWritePresentationTimeUs = j;
            }
        } catch (AudioSink.WriteException e) {
            throw createRendererException(e, e.format, e.isRecoverable, this.bypassEnabled ? 5003 : 5002);
        }
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        DefaultAudioSink defaultAudioSink = (DefaultAudioSink) this.audioSink;
        if (defaultAudioSink.useAudioOutputPlaybackParams()) {
            defaultAudioSink.playbackParameters = playbackParameters;
            defaultAudioSink.setAudioOutputPlaybackParameters();
            return;
        }
        PlaybackParameters playbackParameters2 = new PlaybackParameters(Util.constrainValue(playbackParameters.speed, 0.1f, 8.0f), Util.constrainValue(playbackParameters.pitch, 0.1f, 8.0f));
        defaultAudioSink.playbackParameters = playbackParameters2;
        DefaultAudioSink.MediaPositionParameters mediaPositionParameters = new DefaultAudioSink.MediaPositionParameters(playbackParameters2, -9223372036854775807L, -9223372036854775807L);
        if (defaultAudioSink.isAudioOutputInitialized()) {
            defaultAudioSink.afterDrainParameters = mediaPositionParameters;
        } else {
            defaultAudioSink.mediaPositionParameters = mediaPositionParameters;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final boolean shouldUseBypass(Format format) {
        RendererConfiguration rendererConfiguration = this.configuration;
        rendererConfiguration.getClass();
        if (rendererConfiguration.offloadModePreferred != 0) {
            int audioOffloadSupport = getAudioOffloadSupport(format);
            if ((audioOffloadSupport & 512) != 0) {
                RendererConfiguration rendererConfiguration2 = this.configuration;
                rendererConfiguration2.getClass();
                if (rendererConfiguration2.offloadModePreferred == 2 || (audioOffloadSupport & 1024) != 0 || (format.encoderDelay == 0 && format.encoderPadding == 0)) {
                    return true;
                }
            }
        }
        return ((DefaultAudioSink) this.audioSink).getFormatSupport(format) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final int supportsFormat$1(Format format) {
        int audioOffloadSupport;
        boolean z;
        boolean z2 = true;
        int iCreate = BaseRenderer.create(1, 0, 0, 0);
        if (!MimeTypes.isAudio(format.sampleMimeType)) {
            return BaseRenderer.create(0, 0, 0, 0);
        }
        int i = format.cryptoType;
        boolean z3 = i != 0;
        boolean z4 = i == 0 || i == 2;
        int i2 = 8;
        AudioSink audioSink = this.audioSink;
        if (z4) {
            if (z3) {
                List decoderInfos = MediaCodecUtil.getDecoderInfos("audio/raw", false, false);
                if ((decoderInfos.isEmpty() ? null : (MediaCodecInfo) decoderInfos.get(0)) == null) {
                    audioOffloadSupport = 0;
                }
            }
            audioOffloadSupport = getAudioOffloadSupport(format);
            if (((DefaultAudioSink) audioSink).getFormatSupport(format) != 0) {
                return BaseRenderer.create(4, 8, 32, audioOffloadSupport);
            }
        } else {
            audioOffloadSupport = 0;
        }
        if (!"audio/raw".equals(format.sampleMimeType) || ((DefaultAudioSink) audioSink).getFormatSupport(format) != 0) {
            int i3 = format.channelCount;
            int i4 = format.sampleRate;
            Format.Builder builder = new Format.Builder();
            builder.sampleMimeType = MimeTypes.normalizeMimeType("audio/raw");
            builder.channelCount = i3;
            builder.sampleRate = i4;
            builder.pcmEncoding = 2;
            if (((DefaultAudioSink) audioSink).getFormatSupport(new Format(builder)) != 0) {
                RegularImmutableList decoderInfos2 = getDecoderInfos(format, false, audioSink);
                if (!decoderInfos2.isEmpty()) {
                    if (!z4) {
                        return BaseRenderer.create(2, 0, 0, 0);
                    }
                    MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) decoderInfos2.get(0);
                    Context context = this.context;
                    boolean zIsFormatSupported = mediaCodecInfo.isFormatSupported(context, format);
                    if (!zIsFormatSupported) {
                        int i5 = 1;
                        while (true) {
                            if (i5 >= decoderInfos2.size) {
                                z = true;
                                z2 = zIsFormatSupported;
                                break;
                            }
                            MediaCodecInfo mediaCodecInfo2 = (MediaCodecInfo) decoderInfos2.get(i5);
                            if (mediaCodecInfo2.isFormatSupported(context, format)) {
                                z = false;
                                mediaCodecInfo = mediaCodecInfo2;
                                break;
                            }
                            i5++;
                        }
                    } else {
                        z = true;
                        z2 = zIsFormatSupported;
                        break;
                    }
                    int i6 = z2 ? 4 : 3;
                    if (z2 && mediaCodecInfo.isSeamlessAdaptationSupported(format)) {
                        i2 = 16;
                    }
                    return i6 | i2 | 32 | (mediaCodecInfo.hardwareAccelerated ? 64 : 0) | (z ? 128 : 0) | audioOffloadSupport;
                }
            }
        }
        return iCreate;
    }

    public final void updateCurrentPosition() {
        long j;
        long jMax;
        long j2;
        isEnded();
        DefaultAudioSink defaultAudioSink = (DefaultAudioSink) this.audioSink;
        EmojiProcessor emojiProcessor = defaultAudioSink.audioProcessorChain;
        if (!defaultAudioSink.isAudioOutputInitialized() || defaultAudioSink.startMediaTimeUsNeedsInit) {
            j = Long.MIN_VALUE;
            jMax = Long.MIN_VALUE;
        } else {
            long jMin = Math.min(defaultAudioSink.audioOutput.getPositionUs(), Util.sampleCountToDurationUs(defaultAudioSink.configuration.outputConfig.sampleRate, defaultAudioSink.getWrittenFrames()));
            ArrayDeque arrayDeque = defaultAudioSink.mediaPositionParametersCheckpoints;
            while (!arrayDeque.isEmpty() && jMin >= ((DefaultAudioSink.MediaPositionParameters) arrayDeque.getFirst()).audioOutputPositionUs) {
                defaultAudioSink.mediaPositionParameters = (DefaultAudioSink.MediaPositionParameters) arrayDeque.remove();
            }
            DefaultAudioSink.MediaPositionParameters mediaPositionParameters = defaultAudioSink.mediaPositionParameters;
            long jScaleLargeValue = jMin - mediaPositionParameters.audioOutputPositionUs;
            long mediaDurationForPlayoutDuration = Util.getMediaDurationForPlayoutDuration(jScaleLargeValue, mediaPositionParameters.playbackParameters.speed);
            if (arrayDeque.isEmpty()) {
                SonicAudioProcessor sonicAudioProcessor = (SonicAudioProcessor) emojiProcessor.mGlyphChecker;
                if (!sonicAudioProcessor.isActive()) {
                    j = Long.MIN_VALUE;
                } else if (sonicAudioProcessor.outputBytes >= 1024) {
                    long j3 = sonicAudioProcessor.inputBytes;
                    Sonic sonic = sonicAudioProcessor.sonic;
                    sonic.getClass();
                    long jBytesPerSample = j3 - ((long) (sonic.impl.bytesPerSample() * (sonic.inputFrameCount * sonic.channelCount)));
                    int i = sonicAudioProcessor.outputAudioFormat.sampleRate;
                    int i2 = sonicAudioProcessor.inputAudioFormat.sampleRate;
                    j = Long.MIN_VALUE;
                    long j4 = sonicAudioProcessor.outputBytes;
                    jScaleLargeValue = i == i2 ? Util.scaleLargeValue(jScaleLargeValue, jBytesPerSample, j4, RoundingMode.DOWN) : Util.scaleLargeValue(jScaleLargeValue, jBytesPerSample * ((long) i), j4 * ((long) i2), RoundingMode.DOWN);
                } else {
                    j = Long.MIN_VALUE;
                    jScaleLargeValue = (long) (((double) sonicAudioProcessor.speed) * jScaleLargeValue);
                }
                DefaultAudioSink.MediaPositionParameters mediaPositionParameters2 = defaultAudioSink.mediaPositionParameters;
                j2 = mediaPositionParameters2.mediaTimeUs + jScaleLargeValue;
                mediaPositionParameters2.mediaPositionDriftUs = jScaleLargeValue - mediaDurationForPlayoutDuration;
            } else {
                j = Long.MIN_VALUE;
                DefaultAudioSink.MediaPositionParameters mediaPositionParameters3 = defaultAudioSink.mediaPositionParameters;
                j2 = mediaPositionParameters3.mediaTimeUs + mediaDurationForPlayoutDuration + mediaPositionParameters3.mediaPositionDriftUs;
            }
            long j5 = ((SilenceSkippingAudioProcessor) emojiProcessor.mMetadataRepo).skippedFrames;
            jMax = Util.sampleCountToDurationUs(defaultAudioSink.configuration.outputConfig.sampleRate, j5) + j2;
            long j6 = defaultAudioSink.skippedOutputFrameCountAtLastPosition;
            if (j5 > j6) {
                long jSampleCountToDurationUs = Util.sampleCountToDurationUs(defaultAudioSink.configuration.outputConfig.sampleRate, j5 - j6);
                defaultAudioSink.skippedOutputFrameCountAtLastPosition = j5;
                defaultAudioSink.accumulatedSkippedSilenceDurationUs += jSampleCountToDurationUs;
                Handler handler = defaultAudioSink.reportSkippedSilenceHandler;
                if (handler == null) {
                    handler = new Handler(Looper.myLooper());
                    defaultAudioSink.reportSkippedSilenceHandler = handler;
                }
                handler.removeCallbacksAndMessages(null);
                defaultAudioSink.reportSkippedSilenceHandler.postDelayed(new ActivityCompat$$ExternalSyntheticLambda0((byte) 22, (Object) defaultAudioSink), 100L);
            }
        }
        if (jMax != j) {
            if (!this.allowPositionDiscontinuity) {
                jMax = Math.max(this.currentPositionUs, jMax);
            }
            this.currentPositionUs = jMax;
            this.allowPositionDiscontinuity = false;
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final MediaClock getMediaClock() {
        return this;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void onOutputStreamOffsetUsChanged() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final ArrayList getDecoderInfos(Format format, boolean z) {
        RegularImmutableList decoderInfos = getDecoderInfos(format, z, this.audioSink);
        HashMap map = MediaCodecUtil.decoderInfosCache;
        ArrayList arrayList = new ArrayList(decoderInfos);
        Collections.sort(arrayList, new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0((byte) 1, new TextLinkScope$$ExternalSyntheticLambda10((Object) this.context, (Object) format, (byte) 5)));
        return arrayList;
    }
}
