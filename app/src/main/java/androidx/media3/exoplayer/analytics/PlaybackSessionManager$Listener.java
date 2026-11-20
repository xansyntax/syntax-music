package androidx.media3.exoplayer.analytics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface PlaybackSessionManager$Listener {
    void onAdPlaybackStarted(String str);

    void onSessionActive(AnalyticsListener.EventTime eventTime, String str);

    void onSessionCreated(AnalyticsListener.EventTime eventTime, String str);

    void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z);
}
