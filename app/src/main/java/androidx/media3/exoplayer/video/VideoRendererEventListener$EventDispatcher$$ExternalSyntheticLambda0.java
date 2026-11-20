package androidx.media3.exoplayer.video;

import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector$$ExternalSyntheticLambda4;
import androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AudioRendererEventListener$EventDispatcher f$0;

    public /* synthetic */ VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(int i, long j, AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher) {
        this.$r8$classId = (byte) 3;
        this.f$0 = audioRendererEventListener$EventDispatcher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.f$0;
        switch (b) {
            case 0:
                ExoPlayerImpl.ComponentListener componentListener = audioRendererEventListener$EventDispatcher.listener;
                String str = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector.sendEvent(defaultAnalyticsCollector.generateReadingMediaPeriodEventTime(), 1016, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 1));
                break;
            case 1:
                ExoPlayerImpl.ComponentListener componentListener2 = audioRendererEventListener$EventDispatcher.listener;
                String str2 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector2 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector2.sendEvent(defaultAnalyticsCollector2.generateReadingMediaPeriodEventTime(), 1030, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 6));
                break;
            case 2:
                ExoPlayerImpl.ComponentListener componentListener3 = audioRendererEventListener$EventDispatcher.listener;
                String str3 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector3 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector3.sendEvent(defaultAnalyticsCollector3.generateReadingMediaPeriodEventTime(), 1019, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 14));
                break;
            case 3:
                ExoPlayerImpl.ComponentListener componentListener4 = audioRendererEventListener$EventDispatcher.listener;
                String str4 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector4 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector4.sendEvent(defaultAnalyticsCollector4.generateEventTime((MediaSource$MediaPeriodId) defaultAnalyticsCollector4.mediaPeriodQueueTracker.moments), 1021, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 7));
                break;
            case 4:
                ExoPlayerImpl.ComponentListener componentListener5 = audioRendererEventListener$EventDispatcher.listener;
                String str5 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector5 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector5.sendEvent(defaultAnalyticsCollector5.generateReadingMediaPeriodEventTime(), 1015, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 14));
                break;
            default:
                ExoPlayerImpl.ComponentListener componentListener6 = audioRendererEventListener$EventDispatcher.listener;
                String str6 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector6 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector6.sendEvent(defaultAnalyticsCollector6.generateReadingMediaPeriodEventTime(), 1017, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 11));
                break;
        }
    }

    public /* synthetic */ VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.$r8$classId = (byte) 5;
        this.f$0 = audioRendererEventListener$EventDispatcher;
    }

    public /* synthetic */ VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$0 = audioRendererEventListener$EventDispatcher;
    }

    public /* synthetic */ VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, String str, long j, long j2) {
        this.$r8$classId = (byte) 0;
        this.f$0 = audioRendererEventListener$EventDispatcher;
    }
}
