package androidx.media3.exoplayer.upstream;

import android.os.Handler;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener {
    public final Handler handler;
    public final DefaultAnalyticsCollector listener;
    public boolean released;

    public BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener(Handler handler, DefaultAnalyticsCollector defaultAnalyticsCollector) {
        this.handler = handler;
        this.listener = defaultAnalyticsCollector;
    }
}
