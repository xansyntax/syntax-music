package androidx.media3.exoplayer.video;

import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ AudioRendererEventListener$EventDispatcher f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda2(AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher, Object obj, long j) {
        this.f$0 = audioRendererEventListener$EventDispatcher;
        this.f$1 = obj;
        this.f$2 = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExoPlayerImpl.ComponentListener componentListener = this.f$0.listener;
        String str = Util.DEVICE_DEBUG_INFO;
        ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
        DefaultAnalyticsCollector defaultAnalyticsCollector = exoPlayerImpl.analyticsCollector;
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = defaultAnalyticsCollector.generateReadingMediaPeriodEventTime();
        Object obj = this.f$1;
        defaultAnalyticsCollector.sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, 26, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(eventTimeGenerateReadingMediaPeriodEventTime, obj, this.f$2));
        if (exoPlayerImpl.videoOutput == obj) {
            exoPlayerImpl.listeners.sendEvent(26, new DifferentialMotionFlingController$$ExternalSyntheticLambda0((byte) 29));
        }
    }
}
