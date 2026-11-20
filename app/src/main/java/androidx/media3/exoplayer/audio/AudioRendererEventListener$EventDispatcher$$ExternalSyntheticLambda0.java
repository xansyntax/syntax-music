package androidx.media3.exoplayer.audio;

import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector$$ExternalSyntheticLambda4;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AudioRendererEventListener$EventDispatcher f$0;

    public /* synthetic */ AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.$r8$classId = (byte) 9;
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
                defaultAnalyticsCollector.sendEvent(defaultAnalyticsCollector.generateReadingMediaPeriodEventTime(), 1029, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 29));
                break;
            case 1:
                ExoPlayerImpl.ComponentListener componentListener2 = audioRendererEventListener$EventDispatcher.listener;
                String str2 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector2 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector2.sendEvent(defaultAnalyticsCollector2.generateReadingMediaPeriodEventTime(), 1011, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 17));
                break;
            case 2:
                ExoPlayerImpl.ComponentListener componentListener3 = audioRendererEventListener$EventDispatcher.listener;
                String str3 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector3 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector3.sendEvent(defaultAnalyticsCollector3.generateReadingMediaPeriodEventTime(), 1010, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 18));
                break;
            case 3:
                ExoPlayerImpl.ComponentListener componentListener4 = audioRendererEventListener$EventDispatcher.listener;
                String str4 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector4 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector4.sendEvent(defaultAnalyticsCollector4.generateReadingMediaPeriodEventTime(), 1032, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 23));
                break;
            case 4:
                ExoPlayerImpl.ComponentListener componentListener5 = audioRendererEventListener$EventDispatcher.listener;
                String str5 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector5 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector5.sendEvent(defaultAnalyticsCollector5.generateReadingMediaPeriodEventTime(), 1008, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 12));
                break;
            case 5:
                ExoPlayerImpl.ComponentListener componentListener6 = audioRendererEventListener$EventDispatcher.listener;
                String str6 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector6 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector6.sendEvent(defaultAnalyticsCollector6.generateReadingMediaPeriodEventTime(), 1012, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 27));
                break;
            case 6:
                ExoPlayerImpl.ComponentListener componentListener7 = audioRendererEventListener$EventDispatcher.listener;
                String str7 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector7 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector7.sendEvent(defaultAnalyticsCollector7.generateReadingMediaPeriodEventTime(), 1007, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 6));
                break;
            case 7:
                ExoPlayerImpl.ComponentListener componentListener8 = audioRendererEventListener$EventDispatcher.listener;
                String str8 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector8 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector8.sendEvent(defaultAnalyticsCollector8.generateReadingMediaPeriodEventTime(), 1031, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 12));
                break;
            case 8:
                ExoPlayerImpl.ComponentListener componentListener9 = audioRendererEventListener$EventDispatcher.listener;
                String str9 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector9 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector9.sendEvent(defaultAnalyticsCollector9.generateReadingMediaPeriodEventTime(), 1014, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 16));
                break;
            default:
                ExoPlayerImpl.ComponentListener componentListener10 = audioRendererEventListener$EventDispatcher.listener;
                String str10 = Util.DEVICE_DEBUG_INFO;
                DefaultAnalyticsCollector defaultAnalyticsCollector10 = ExoPlayerImpl.this.analyticsCollector;
                defaultAnalyticsCollector10.sendEvent(defaultAnalyticsCollector10.generateReadingMediaPeriodEventTime(), 1009, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 13));
                break;
        }
    }

    public /* synthetic */ AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, long j) {
        this.$r8$classId = (byte) 2;
        this.f$0 = audioRendererEventListener$EventDispatcher;
    }

    public /* synthetic */ AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, int i, long j, long j2) {
        this.$r8$classId = (byte) 1;
        this.f$0 = audioRendererEventListener$EventDispatcher;
    }

    public /* synthetic */ AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$0 = audioRendererEventListener$EventDispatcher;
    }

    public /* synthetic */ AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, String str, long j, long j2) {
        this.$r8$classId = (byte) 4;
        this.f$0 = audioRendererEventListener$EventDispatcher;
    }
}
