package androidx.media3.exoplayer.analytics;

import android.media.metrics.LogSessionId;
import android.os.Build;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import io.ktor.http.LinkHeader;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerId {
    public static final PlayerId PRELOAD;
    public final ScrollCapture logSessionIdApi31;
    public final String name;

    static {
        new PlayerId("");
        PRELOAD = new PlayerId(LinkHeader.Rel.PreLoad);
    }

    public PlayerId(String str) {
        this.name = str;
        this.logSessionIdApi31 = Build.VERSION.SDK_INT >= 31 ? new ScrollCapture((byte) 3) : null;
    }

    public final synchronized LogSessionId getLogSessionId() {
        ScrollCapture scrollCapture;
        scrollCapture = this.logSessionIdApi31;
        scrollCapture.getClass();
        return (LogSessionId) scrollCapture.scrollCaptureInProgress$delegate;
    }
}
