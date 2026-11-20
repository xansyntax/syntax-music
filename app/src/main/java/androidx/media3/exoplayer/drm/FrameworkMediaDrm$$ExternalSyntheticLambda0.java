package androidx.media3.exoplayer.drm;

import android.media.AudioDescriptor;
import android.os.Handler;
import android.os.SystemClock;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher;
import androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.AudioTrackAudioOutput;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.flac.FlacExtractor;
import androidx.media3.extractor.flv.FlvExtractor;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.ogg.OggExtractor;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.extractor.ts.Ac3Extractor;
import androidx.media3.extractor.ts.Ac4Extractor;
import androidx.media3.extractor.ts.AdtsExtractor;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.extractor.wav.WavExtractor;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.MediaLibraryService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import okhttp3.Dispatcher$promoteAndExecute$Effects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FrameworkMediaDrm$$ExternalSyntheticLambda0 implements ListenerSet.Event, DrmSessionManager.DrmSessionReference, MediaCodecUtil.ScoreProvider, Consumer, ExtractorsFactory, DefaultMediaNotificationProvider.NotificationIdProvider {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ FrameworkMediaDrm$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    public static /* synthetic */ void m(int i, int i2) {
        throw new IndexOutOfBoundsException("position=" + i + ((Object) ", limit=") + i2);
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        switch (this.$r8$classId) {
            case 11:
                ((SampleQueue.SharedSampleMetadata) obj).drmSessionReference.release();
                break;
            default:
                ((ExecutorService) obj).shutdown();
                break;
        }
    }

    @Override // androidx.media3.extractor.ExtractorsFactory
    public Extractor[] createExtractors() {
        byte b = this.$r8$classId;
        CueDecoder cueDecoder = CueDecoder.UNSUPPORTED;
        switch (b) {
            case 16:
                return new Extractor[]{new FlacExtractor()};
            case 17:
                return new Extractor[]{new FlvExtractor()};
            case 18:
            case 19:
            default:
                return new Extractor[]{new WavExtractor()};
            case 20:
                return new Extractor[]{new Mp4Extractor(16, cueDecoder)};
            case 21:
                return new Extractor[]{new OggExtractor()};
            case 22:
                return new Extractor[]{new Ac3Extractor()};
            case 23:
                return new Extractor[]{new Ac4Extractor()};
            case 24:
                return new Extractor[]{new AdtsExtractor()};
            case 25:
                return new Extractor[]{new PsExtractor()};
            case 26:
                TimestampAdjuster timestampAdjuster = new TimestampAdjuster(0L);
                ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                return new Extractor[]{new TsExtractor(1, cueDecoder, timestampAdjuster, new Dispatcher$promoteAndExecute$Effects(RegularImmutableList.EMPTY))};
        }
    }

    public Constructor getConstructor() {
        switch (this.$r8$classId) {
            case 13:
                if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
                    return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(Integer.TYPE);
                }
                return null;
            default:
                return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(Extractor.class).getConstructor(null);
        }
    }

    @Override // androidx.media3.session.DefaultMediaNotificationProvider.NotificationIdProvider
    public int getNotificationId(MediaLibraryService.MediaLibrarySession mediaLibrarySession) {
        return 1001;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.ScoreProvider
    public int getScore(Object obj) {
        String str = ((MediaCodecInfo) obj).name;
        return (str.startsWith("OMX.google") || str.startsWith("c2.android")) ? 1 : 0;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        long jSampleCountToDurationUs;
        AtomicInt atomicInt;
        ExoPlayerImplInternal.AnonymousClass1 anonymousClass1;
        DefaultTrackSelector defaultTrackSelector;
        switch (this.$r8$classId) {
            case 2:
                DefaultAudioSink.AudioOutputListener audioOutputListener = (DefaultAudioSink.AudioOutputListener) obj;
                DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
                if (audioOutputListener == defaultAudioSink.audioOutputListener && defaultAudioSink.listener != null) {
                    DefaultAudioSink.Configuration configuration = defaultAudioSink.configuration;
                    int i = configuration.outputPcmFrameSize;
                    if (i != -1) {
                        long j = configuration.outputConfig.bufferSize / i;
                        AudioTrackAudioOutput audioTrackAudioOutput = defaultAudioSink.audioOutput;
                        audioTrackAudioOutput.getClass();
                        jSampleCountToDurationUs = Util.sampleCountToDurationUs(audioTrackAudioOutput.audioTrack.getSampleRate(), j);
                    } else {
                        jSampleCountToDurationUs = -9223372036854775807L;
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - defaultAudioSink.lastFeedElapsedRealtimeMs;
                    AtomicInt atomicInt2 = defaultAudioSink.listener;
                    int i2 = defaultAudioSink.configuration.outputConfig.bufferSize;
                    long jUsToMs = Util.usToMs(jSampleCountToDurationUs);
                    AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = ((MediaCodecAudioRenderer) atomicInt2.delegate).eventDispatcher;
                    Handler handler = audioRendererEventListener$EventDispatcher.handler;
                    if (handler != null) {
                        handler.post(new AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, i2, jUsToMs, jElapsedRealtime));
                        return;
                    }
                    return;
                }
                return;
            case 3:
                DefaultAudioSink.AudioOutputListener audioOutputListener2 = (DefaultAudioSink.AudioOutputListener) obj;
                audioOutputListener2.getClass();
                DefaultAudioSink.pendingReleaseCount.getAndDecrement();
                AtomicInt atomicInt3 = DefaultAudioSink.this.listener;
                if (atomicInt3 != null) {
                    AudioSink.AudioTrackConfig audioTrackConfig = new AudioSink.AudioTrackConfig();
                    AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher2 = ((MediaCodecAudioRenderer) atomicInt3.delegate).eventDispatcher;
                    Handler handler2 = audioRendererEventListener$EventDispatcher2.handler;
                    if (handler2 != null) {
                        handler2.post(new AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher2, (Object) audioTrackConfig, (byte) 3));
                        return;
                    }
                    return;
                }
                return;
            case 4:
                DefaultAudioSink.AudioOutputListener audioOutputListener3 = (DefaultAudioSink.AudioOutputListener) obj;
                DefaultAudioSink defaultAudioSink2 = DefaultAudioSink.this;
                if (audioOutputListener3 == defaultAudioSink2.audioOutputListener && (atomicInt = defaultAudioSink2.listener) != null && defaultAudioSink2.playing && (anonymousClass1 = ((MediaCodecAudioRenderer) atomicInt.delegate).wakeupListener) != null) {
                    anonymousClass1.onWakeup();
                    return;
                }
                return;
            case 5:
                DefaultAudioSink.AudioOutputListener audioOutputListener4 = (DefaultAudioSink.AudioOutputListener) obj;
                DefaultAudioSink defaultAudioSink3 = DefaultAudioSink.this;
                if (audioOutputListener4 == defaultAudioSink3.audioOutputListener && defaultAudioSink3.stoppedAudioOutput) {
                    defaultAudioSink3.handledOffloadOnPresentationEnded = true;
                    return;
                }
                return;
            default:
                AtomicInt atomicInt4 = ((DefaultAudioSink$$ExternalSyntheticLambda0) obj).f$0.listener;
                if (atomicInt4 != null) {
                    MediaCodecAudioRenderer mediaCodecAudioRenderer = (MediaCodecAudioRenderer) atomicInt4.delegate;
                    synchronized (mediaCodecAudioRenderer.lock) {
                        defaultTrackSelector = mediaCodecAudioRenderer.rendererCapabilitiesListener;
                        break;
                    }
                    if (defaultTrackSelector != null) {
                        synchronized (defaultTrackSelector.lock) {
                            defaultTrackSelector.parameters.getClass();
                            break;
                        }
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager.DrmSessionReference
    public void release() {
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint m837m(Object obj) {
        return (android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint) obj;
    }

    public static /* bridge */ /* synthetic */ AudioDescriptor m(Object obj) {
        return (AudioDescriptor) obj;
    }
}
