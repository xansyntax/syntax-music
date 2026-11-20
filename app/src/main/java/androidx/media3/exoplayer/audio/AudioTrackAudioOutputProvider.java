package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.util.SpatializerWrapper;
import androidx.media3.extractor.AacUtil;
import androidx.sqlite.SQLite;
import coil3.util.UtilsKt;
import com.google.common.collect.RegularImmutableList;
import com.google.common.math.IntMath;
import com.metrolist.music.playback.MusicService$audioDeviceCallback$1;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioTrackAudioOutputProvider implements AudioOutputProvider {
    public AudioCapabilities audioCapabilities;
    public AudioCapabilitiesReceiver audioCapabilitiesReceiver;
    public final DefaultAudioOffloadSupportProvider audioOffloadSupportProvider;
    public final AudioSink.AudioTrackConfig audioTrackBufferSizeProvider;
    public final AtomicInt capabilityChangeListener;
    public SystemClock clock;
    public final Context context;
    public Context contextWithDeviceId;
    public ListenerSet listeners;
    public Looper playbackLooper;

    public AudioTrackAudioOutputProvider(Dispatcher dispatcher) {
        Context context = (Context) dispatcher.executorServiceOrNull;
        this.context = context;
        DefaultAudioOffloadSupportProvider defaultAudioOffloadSupportProvider = (DefaultAudioOffloadSupportProvider) dispatcher.readyAsyncCalls;
        defaultAudioOffloadSupportProvider.getClass();
        this.audioOffloadSupportProvider = defaultAudioOffloadSupportProvider;
        this.audioTrackBufferSizeProvider = (AudioSink.AudioTrackConfig) dispatcher.runningAsyncCalls;
        this.audioCapabilities = (AudioCapabilities) dispatcher.runningSyncCalls;
        this.capabilityChangeListener = context == null ? null : new AtomicInt(this);
        this.clock = SystemClock.DEFAULT;
    }

    public final AudioTrackAudioOutput getAudioOutput(AudioOutputProvider.OutputConfig outputConfig) throws AudioOutputProvider.InitializationException {
        Context context;
        Context context2;
        try {
            int i = outputConfig.audioSessionId;
            int i2 = outputConfig.virtualDeviceId;
            if (i2 == -1 || (context2 = this.context) == null || Build.VERSION.SDK_INT < 34) {
                context = null;
            } else {
                Context context3 = this.contextWithDeviceId;
                if (context3 == null || context3.getDeviceId() != i2) {
                    this.contextWithDeviceId = context2.createDeviceContext(i2);
                }
                context = this.contextWithDeviceId;
                i = 0;
            }
            try {
                AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(outputConfig.isTunneling ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : outputConfig.audioAttributes.getPlatformAudioAttributes()).setAudioFormat(new AudioFormat.Builder().setSampleRate(outputConfig.sampleRate).setChannelMask(outputConfig.channelMask).setEncoding(outputConfig.encoding).build()).setTransferMode(1).setBufferSizeInBytes(outputConfig.bufferSize).setSessionId(i);
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 29) {
                    sessionId.setOffloadedPlayback(outputConfig.isOffload);
                }
                if (i3 >= 34 && context != null) {
                    sessionId.setContext(context);
                }
                AudioTrack audioTrackBuild = sessionId.build();
                if (audioTrackBuild.getState() == 1) {
                    return new AudioTrackAudioOutput(audioTrackBuild, outputConfig, this.capabilityChangeListener, this.clock);
                }
                try {
                    audioTrackBuild.release();
                } catch (Exception unused) {
                }
                throw new AudioOutputProvider.InitializationException();
            } catch (IllegalArgumentException e) {
                e = e;
                throw new AudioOutputProvider.InitializationException(e);
            }
        } catch (IllegalArgumentException | UnsupportedOperationException e2) {
            e = e2;
        }
    }

    public final AudioOutputProvider.FormatSupport getFormatSupport(AudioOutputProvider.FormatConfig formatConfig) {
        updateAudioCapabilitiesReceiver(formatConfig);
        Format format = formatConfig.format;
        androidx.media3.common.AudioAttributes audioAttributes = formatConfig.audioAttributes;
        AudioOffloadSupport audioOffloadSupport = this.audioOffloadSupportProvider.getAudioOffloadSupport(audioAttributes, format);
        AudioOutputProvider.FormatSupport formatSupport = new AudioOutputProvider.FormatSupport();
        int i = 0;
        formatSupport.supportLevel = 0;
        String str = format.sampleMimeType;
        int i2 = format.pcmEncoding;
        if (!Objects.equals(str, "audio/raw") ? this.audioCapabilities.getEncodingAndChannelConfigForPassthrough(audioAttributes, format) != null : i2 == 2) {
            i = 2;
        }
        formatSupport.supportLevel = i;
        boolean z = audioOffloadSupport.isFormatSupported;
        formatSupport.isFormatSupportedForOffload = z;
        boolean z2 = audioOffloadSupport.isGaplessSupported;
        formatSupport.isGaplessSupportedForOffload = z2;
        boolean z3 = audioOffloadSupport.isSpeedChangeSupported;
        formatSupport.isSpeedChangeSupportedForOffload = z3;
        if (!z && (z2 || z3)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Secondary offload attribute fields are true but primary isFormatSupportedForOffload is false");
            return null;
        }
        AudioOutputProvider.FormatSupport formatSupport2 = new AudioOutputProvider.FormatSupport();
        formatSupport2.isFormatSupportedForOffload = formatSupport.isFormatSupportedForOffload;
        formatSupport2.isGaplessSupportedForOffload = formatSupport.isGaplessSupportedForOffload;
        formatSupport2.isSpeedChangeSupportedForOffload = formatSupport.isSpeedChangeSupportedForOffload;
        formatSupport2.supportLevel = formatSupport.supportLevel;
        return formatSupport2;
    }

    public final AudioOutputProvider.OutputConfig getOutputConfig(AudioOutputProvider.FormatConfig formatConfig) {
        int iIntValue;
        char c;
        int byteDepth;
        boolean z;
        boolean z2;
        int iConstrainValue;
        int i;
        int iDivide;
        Format format = formatConfig.format;
        boolean z3 = formatConfig.enableOffload;
        boolean z4 = formatConfig.enablePlaybackParameters;
        androidx.media3.common.AudioAttributes audioAttributes = formatConfig.audioAttributes;
        updateAudioCapabilitiesReceiver(formatConfig);
        String str = format.sampleMimeType;
        int i2 = format.sampleRate;
        int iIntValue2 = format.pcmEncoding;
        int i3 = format.channelCount;
        if (Objects.equals(str, "audio/raw")) {
            UtilsKt.checkArgument(Util.isEncodingLinearPcm(iIntValue2));
            iIntValue = Util.getAudioTrackChannelConfig(i3);
            byteDepth = Util.getByteDepth(iIntValue2) * i3;
            z = false;
            c = 0;
        } else {
            AudioOffloadSupport audioOffloadSupport = z3 ? this.audioOffloadSupportProvider.getAudioOffloadSupport(audioAttributes, format) : AudioOffloadSupport.DEFAULT_UNSUPPORTED;
            if (z3 && audioOffloadSupport.isFormatSupported) {
                str.getClass();
                int encoding = MimeTypes.getEncoding(str, format.codecs);
                int audioTrackChannelConfig = Util.getAudioTrackChannelConfig(i3);
                z = audioOffloadSupport.isGaplessSupported;
                byteDepth = -1;
                c = 1;
                iIntValue2 = encoding;
                iIntValue = audioTrackChannelConfig;
                z4 = true;
            } else {
                Pair encodingAndChannelConfigForPassthrough = this.audioCapabilities.getEncodingAndChannelConfigForPassthrough(audioAttributes, format);
                if (encodingAndChannelConfigForPassthrough == null) {
                    throw new AudioOutputProvider.ConfigurationException("Unable to configure passthrough for: " + format);
                }
                iIntValue2 = ((Integer) encodingAndChannelConfigForPassthrough.first).intValue();
                iIntValue = ((Integer) encodingAndChannelConfigForPassthrough.second).intValue();
                c = 2;
                byteDepth = -1;
                z = false;
            }
        }
        int i4 = format.bitrate;
        if (Objects.equals(str, "audio/vnd.dts.hd;profile=lbr") && i4 == -1) {
            i4 = 768000;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i2, iIntValue, iIntValue2);
        UtilsKt.checkState(minBufferSize != -2);
        if (byteDepth == -1) {
            byteDepth = 1;
        }
        double d = z4 ? 8.0d : 1.0d;
        this.audioTrackBufferSizeProvider.getClass();
        if (c == 0) {
            z2 = true;
            long j = i2;
            long j2 = 250000 * j;
            long j3 = byteDepth;
            iConstrainValue = Util.constrainValue(minBufferSize * 4, StringsKt__IndentKt.checkedCast((j2 * j3) / 1000000), StringsKt__IndentKt.checkedCast(((750000 * j) * j3) / 1000000));
        } else if (c == 1) {
            z2 = true;
            int maximumEncodedRateBytesPerSecond = AacUtil.getMaximumEncodedRateBytesPerSecond(iIntValue2);
            UtilsKt.checkState(maximumEncodedRateBytesPerSecond != -2147483647);
            iConstrainValue = StringsKt__IndentKt.checkedCast((50000000 * ((long) maximumEncodedRateBytesPerSecond)) / 1000000);
        } else {
            if (c != 2) {
                Path$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            if (iIntValue2 == 5) {
                i = 500000;
            } else {
                i = iIntValue2 == 8 ? 1000000 : 250000;
            }
            if (i4 != -1) {
                RoundingMode roundingMode = RoundingMode.CEILING;
                iDivide = IntMath.divide(i4, 8);
            } else {
                int maximumEncodedRateBytesPerSecond2 = AacUtil.getMaximumEncodedRateBytesPerSecond(iIntValue2);
                UtilsKt.checkState(maximumEncodedRateBytesPerSecond2 != -2147483647);
                iDivide = maximumEncodedRateBytesPerSecond2;
            }
            z2 = true;
            iConstrainValue = StringsKt__IndentKt.checkedCast((((long) i) * ((long) iDivide)) / 1000000);
        }
        int iMax = (((Math.max(minBufferSize, (int) (((double) iConstrainValue) * d)) + byteDepth) - 1) / byteDepth) * byteDepth;
        AudioOutputProvider.OutputConfig.Builder builder = new AudioOutputProvider.OutputConfig.Builder();
        androidx.media3.common.AudioAttributes audioAttributes2 = androidx.media3.common.AudioAttributes.DEFAULT;
        builder.virtualDeviceId = -1;
        builder.sampleRate = i2;
        builder.channelMask = iIntValue;
        builder.encoding = iIntValue2;
        builder.bufferSize = iMax;
        builder.audioSessionId = formatConfig.audioSessionId;
        builder.audioAttributes = audioAttributes;
        boolean z5 = z2;
        builder.isOffload = c == z5 ? z5 : false;
        builder.isTunneling = formatConfig.enableTunneling;
        builder.usePlaybackParameters = z4;
        builder.useOffloadGapless = z;
        builder.virtualDeviceId = formatConfig.virtualDeviceId;
        return new AudioOutputProvider.OutputConfig(builder);
    }

    public final void release() {
        SpatializerWrapper spatializerWrapper;
        ListenerSet listenerSet = this.listeners;
        if (listenerSet != null) {
            listenerSet.release();
        }
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.audioCapabilitiesReceiver;
        if (audioCapabilitiesReceiver != null) {
            Context context = audioCapabilitiesReceiver.context;
            if (audioCapabilitiesReceiver.registered) {
                audioCapabilitiesReceiver.audioCapabilities = null;
                HandlerCompat$Api28Impl.getAudioManager(context).unregisterAudioDeviceCallback(audioCapabilitiesReceiver.audioDeviceCallback);
                if (Build.VERSION.SDK_INT >= 32 && (spatializerWrapper = audioCapabilitiesReceiver.spatializer) != null) {
                    spatializerWrapper.release();
                    audioCapabilitiesReceiver.spatializer = null;
                }
                context.unregisterReceiver(audioCapabilitiesReceiver.hdmiAudioPlugBroadcastReceiver);
                AudioCapabilitiesReceiver.ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = audioCapabilitiesReceiver.externalSurroundSoundSettingObserver;
                if (externalSurroundSoundSettingObserver != null) {
                    externalSurroundSoundSettingObserver.resolver.unregisterContentObserver(externalSurroundSoundSettingObserver);
                }
                audioCapabilitiesReceiver.registered = false;
            }
        }
    }

    public final void updateAudioCapabilitiesReceiver(AudioOutputProvider.FormatConfig formatConfig) {
        Context context;
        AudioCapabilities capabilitiesInternal;
        AudioDeviceInfo audioDeviceInfo = formatConfig.preferredDevice;
        androidx.media3.common.AudioAttributes audioAttributes = formatConfig.audioAttributes;
        verifySinglePlaybackLooper();
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.audioCapabilitiesReceiver;
        if (audioCapabilitiesReceiver == null && (context = this.context) != null) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver2 = new AudioCapabilitiesReceiver(context, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 15, this), audioAttributes, audioDeviceInfo);
            this.audioCapabilitiesReceiver = audioCapabilitiesReceiver2;
            if (audioCapabilitiesReceiver2.registered) {
                capabilitiesInternal = audioCapabilitiesReceiver2.audioCapabilities;
                capabilitiesInternal.getClass();
            } else {
                audioCapabilitiesReceiver2.registered = true;
                AudioCapabilitiesReceiver.ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = audioCapabilitiesReceiver2.externalSurroundSoundSettingObserver;
                if (externalSurroundSoundSettingObserver != null) {
                    externalSurroundSoundSettingObserver.resolver.registerContentObserver(externalSurroundSoundSettingObserver.settingUri, false, externalSurroundSoundSettingObserver);
                }
                Context context2 = audioCapabilitiesReceiver2.context;
                AudioManager audioManager = HandlerCompat$Api28Impl.getAudioManager(context2);
                MusicService$audioDeviceCallback$1 musicService$audioDeviceCallback$1 = audioCapabilitiesReceiver2.audioDeviceCallback;
                Handler handler = audioCapabilitiesReceiver2.handler;
                audioManager.registerAudioDeviceCallback(musicService$audioDeviceCallback$1, handler);
                if (Build.VERSION.SDK_INT >= 32 && audioCapabilitiesReceiver2.spatializer == null) {
                    audioCapabilitiesReceiver2.spatializer = new SpatializerWrapper(context2, new ActivityCompat$$ExternalSyntheticLambda0((byte) 20, (Object) audioCapabilitiesReceiver2), Boolean.valueOf(Util.isTv(context2)));
                }
                capabilitiesInternal = AudioCapabilities.getCapabilitiesInternal(context2, context2.registerReceiver(audioCapabilitiesReceiver2.hdmiAudioPlugBroadcastReceiver, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, handler), audioCapabilitiesReceiver2.audioAttributes, audioCapabilitiesReceiver2.routedDevice, audioCapabilitiesReceiver2.getSpatializerChannelMasks());
                audioCapabilitiesReceiver2.audioCapabilities = capabilitiesInternal;
            }
            this.audioCapabilities = capabilitiesInternal;
        } else if (audioCapabilitiesReceiver != null) {
            if (audioDeviceInfo != null && !audioDeviceInfo.equals(audioCapabilitiesReceiver.routedDevice)) {
                audioCapabilitiesReceiver.routedDevice = audioDeviceInfo;
                Context context3 = audioCapabilitiesReceiver.context;
                androidx.media3.common.AudioAttributes audioAttributes2 = audioCapabilitiesReceiver.audioAttributes;
                List spatializerChannelMasks = audioCapabilitiesReceiver.getSpatializerChannelMasks();
                RegularImmutableList regularImmutableList = AudioCapabilities.DEFAULT_SPEAKER_LAYOUT_CHANNEL_MASKS;
                audioCapabilitiesReceiver.onNewAudioCapabilities(AudioCapabilities.getCapabilitiesInternal(context3, context3.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), audioAttributes2, audioDeviceInfo, spatializerChannelMasks));
            }
            AudioCapabilitiesReceiver audioCapabilitiesReceiver3 = this.audioCapabilitiesReceiver;
            if (!Objects.equals(audioAttributes, audioCapabilitiesReceiver3.audioAttributes)) {
                audioCapabilitiesReceiver3.audioAttributes = audioAttributes;
                Context context4 = audioCapabilitiesReceiver3.context;
                AudioDeviceInfo audioDeviceInfo2 = audioCapabilitiesReceiver3.routedDevice;
                List spatializerChannelMasks2 = audioCapabilitiesReceiver3.getSpatializerChannelMasks();
                RegularImmutableList regularImmutableList2 = AudioCapabilities.DEFAULT_SPEAKER_LAYOUT_CHANNEL_MASKS;
                audioCapabilitiesReceiver3.onNewAudioCapabilities(AudioCapabilities.getCapabilitiesInternal(context4, context4.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), audioAttributes, audioDeviceInfo2, spatializerChannelMasks2));
            }
        }
        this.audioCapabilities.getClass();
    }

    public final void verifySinglePlaybackLooper() {
        if (this.context == null) {
            return;
        }
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.playbackLooper;
        boolean z = looper == null || looper == looperMyLooper;
        String name = looper == null ? "null" : looper.getThread().getName();
        String name2 = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null";
        if (z) {
            this.playbackLooper = looperMyLooper;
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(SQLite.lenientFormat("AudioTrackAudioOutputProvider accessed on multiple threads: %s and %s", name, name2));
        }
    }
}
