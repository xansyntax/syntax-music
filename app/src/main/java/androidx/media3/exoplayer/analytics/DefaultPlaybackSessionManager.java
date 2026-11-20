package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda15;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultPlaybackSessionManager {
    public static final MediaSessionImpl$$ExternalSyntheticLambda15 DEFAULT_SESSION_ID_GENERATOR = new MediaSessionImpl$$ExternalSyntheticLambda15((byte) 3);
    public static final Random RANDOM = new Random();
    public String currentSessionId;
    public PlaybackSessionManager$Listener listener;
    public final Timeline.Window window = new Timeline.Window();
    public final Timeline.Period period = new Timeline.Period();
    public final HashMap sessions = new HashMap();
    public Timeline currentTimeline = Timeline.EMPTY;
    public long lastRemovedCurrentWindowSequenceNumber = -1;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SessionDescriptor {
        public final MediaSource$MediaPeriodId adMediaPeriodId;
        public boolean isActive;
        public boolean isCreated;
        public final String sessionId;
        public int windowIndex;
        public long windowSequenceNumber;

        public SessionDescriptor(String str, int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
            this.sessionId = str;
            this.windowIndex = i;
            this.windowSequenceNumber = mediaSource$MediaPeriodId == null ? -1L : mediaSource$MediaPeriodId.windowSequenceNumber;
            if (mediaSource$MediaPeriodId == null || !mediaSource$MediaPeriodId.isAd()) {
                return;
            }
            this.adMediaPeriodId = mediaSource$MediaPeriodId;
        }

        public final boolean belongsToSession(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
            if (mediaSource$MediaPeriodId != null) {
                long j = mediaSource$MediaPeriodId.windowSequenceNumber;
                if (j != -1) {
                    MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.adMediaPeriodId;
                    if (mediaSource$MediaPeriodId2 == null) {
                        return !mediaSource$MediaPeriodId.isAd() && j == this.windowSequenceNumber;
                    }
                    return j == mediaSource$MediaPeriodId2.windowSequenceNumber && mediaSource$MediaPeriodId.adGroupIndex == mediaSource$MediaPeriodId2.adGroupIndex && mediaSource$MediaPeriodId.adIndexInAdGroup == mediaSource$MediaPeriodId2.adIndexInAdGroup;
                }
            }
            return i == this.windowIndex;
        }

        public final boolean isFinishedAtEventTime(AnalyticsListener.EventTime eventTime) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = eventTime.mediaPeriodId;
            Timeline timeline = eventTime.timeline;
            if (mediaSource$MediaPeriodId == null) {
                return this.windowIndex != eventTime.windowIndex;
            }
            long j = this.windowSequenceNumber;
            if (j == -1) {
                return false;
            }
            if (mediaSource$MediaPeriodId.windowSequenceNumber > j) {
                return true;
            }
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.adMediaPeriodId;
            if (mediaSource$MediaPeriodId2 == null) {
                return false;
            }
            int i = mediaSource$MediaPeriodId2.adGroupIndex;
            int indexOfPeriod = timeline.getIndexOfPeriod(mediaSource$MediaPeriodId.periodUid);
            int indexOfPeriod2 = timeline.getIndexOfPeriod(mediaSource$MediaPeriodId2.periodUid);
            if (mediaSource$MediaPeriodId.windowSequenceNumber < mediaSource$MediaPeriodId2.windowSequenceNumber || indexOfPeriod < indexOfPeriod2) {
                return false;
            }
            if (indexOfPeriod > indexOfPeriod2) {
                return true;
            }
            if (!mediaSource$MediaPeriodId.isAd()) {
                int i2 = mediaSource$MediaPeriodId.nextAdGroupIndex;
                return i2 == -1 || i2 > i;
            }
            int i3 = mediaSource$MediaPeriodId.adGroupIndex;
            int i4 = mediaSource$MediaPeriodId.adIndexInAdGroup;
            if (i3 <= i) {
                return i3 == i && i4 > mediaSource$MediaPeriodId2.adIndexInAdGroup;
            }
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0025  */
        public final void maybeSetWindowSequenceNumber(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
            long j;
            if (this.windowSequenceNumber == -1 && i == this.windowIndex && mediaSource$MediaPeriodId != null) {
                long j2 = mediaSource$MediaPeriodId.windowSequenceNumber;
                DefaultPlaybackSessionManager defaultPlaybackSessionManager = DefaultPlaybackSessionManager.this;
                SessionDescriptor sessionDescriptor = (SessionDescriptor) defaultPlaybackSessionManager.sessions.get(defaultPlaybackSessionManager.currentSessionId);
                if (sessionDescriptor != null) {
                    j = sessionDescriptor.windowSequenceNumber;
                    if (j == -1) {
                        j = defaultPlaybackSessionManager.lastRemovedCurrentWindowSequenceNumber + 1;
                    }
                } else {
                    j = defaultPlaybackSessionManager.lastRemovedCurrentWindowSequenceNumber + 1;
                }
                if (j2 >= j) {
                    this.windowSequenceNumber = j2;
                }
            }
        }

        public final boolean tryResolvingToNewTimeline(Timeline timeline, Timeline timeline2) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
            int i = this.windowIndex;
            if (i < timeline.getWindowCount()) {
                DefaultPlaybackSessionManager defaultPlaybackSessionManager = DefaultPlaybackSessionManager.this;
                Timeline.Window window = defaultPlaybackSessionManager.window;
                timeline.getWindow(i, window);
                int i2 = window.firstPeriodIndex;
                while (true) {
                    if (i2 > window.lastPeriodIndex) {
                        i = -1;
                        break;
                    }
                    int indexOfPeriod = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i2));
                    if (indexOfPeriod != -1) {
                        i = timeline2.getPeriod(indexOfPeriod, defaultPlaybackSessionManager.period, false).windowIndex;
                        break;
                    }
                    i2++;
                }
            } else if (i >= timeline2.getWindowCount()) {
                i = -1;
                break;
            }
            this.windowIndex = i;
            return i != -1 && ((mediaSource$MediaPeriodId = this.adMediaPeriodId) == null || timeline2.getIndexOfPeriod(mediaSource$MediaPeriodId.periodUid) != -1);
        }
    }

    public final synchronized boolean belongsToSession(AnalyticsListener.EventTime eventTime, String str) {
        SessionDescriptor sessionDescriptor = (SessionDescriptor) this.sessions.get(str);
        if (sessionDescriptor == null) {
            return false;
        }
        sessionDescriptor.maybeSetWindowSequenceNumber(eventTime.windowIndex, eventTime.mediaPeriodId);
        return sessionDescriptor.belongsToSession(eventTime.windowIndex, eventTime.mediaPeriodId);
    }

    public final void clearCurrentSession(SessionDescriptor sessionDescriptor) {
        long j = sessionDescriptor.windowSequenceNumber;
        if (j != -1 && sessionDescriptor.isCreated) {
            this.lastRemovedCurrentWindowSequenceNumber = j;
        }
        this.currentSessionId = null;
    }

    public final synchronized void finishAllSessions(AnalyticsListener.EventTime eventTime) {
        PlaybackSessionManager$Listener playbackSessionManager$Listener;
        try {
            String str = this.currentSessionId;
            if (str != null) {
                SessionDescriptor sessionDescriptor = (SessionDescriptor) this.sessions.get(str);
                sessionDescriptor.getClass();
                clearCurrentSession(sessionDescriptor);
            }
            Iterator it = this.sessions.values().iterator();
            while (it.hasNext()) {
                SessionDescriptor sessionDescriptor2 = (SessionDescriptor) it.next();
                it.remove();
                if (sessionDescriptor2.isCreated && (playbackSessionManager$Listener = this.listener) != null) {
                    playbackSessionManager$Listener.onSessionFinished(eventTime, sessionDescriptor2.sessionId, false);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final SessionDescriptor getOrAddSession(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        HashMap map = this.sessions;
        SessionDescriptor sessionDescriptor = null;
        long j = Long.MAX_VALUE;
        for (SessionDescriptor sessionDescriptor2 : map.values()) {
            sessionDescriptor2.maybeSetWindowSequenceNumber(i, mediaSource$MediaPeriodId);
            if (sessionDescriptor2.belongsToSession(i, mediaSource$MediaPeriodId)) {
                long j2 = sessionDescriptor2.windowSequenceNumber;
                if (j2 == -1 || j2 < j) {
                    sessionDescriptor = sessionDescriptor2;
                    j = j2;
                } else if (j2 == j) {
                    String str = Util.DEVICE_DEBUG_INFO;
                    if (sessionDescriptor.adMediaPeriodId != null && sessionDescriptor2.adMediaPeriodId != null) {
                        sessionDescriptor = sessionDescriptor2;
                    }
                }
            }
        }
        if (sessionDescriptor != null) {
            return sessionDescriptor;
        }
        String str2 = (String) DEFAULT_SESSION_ID_GENERATOR.get();
        SessionDescriptor sessionDescriptor3 = new SessionDescriptor(str2, i, mediaSource$MediaPeriodId);
        map.put(str2, sessionDescriptor3);
        return sessionDescriptor3;
    }

    public final synchronized String getSessionForMediaPeriodId(Timeline timeline, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        return getOrAddSession(timeline.getPeriodByUid(mediaSource$MediaPeriodId.periodUid, this.period).windowIndex, mediaSource$MediaPeriodId).sessionId;
    }

    public final void updateCurrentSession(AnalyticsListener.EventTime eventTime) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
        Timeline timeline = eventTime.timeline;
        int i = eventTime.windowIndex;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = eventTime.mediaPeriodId;
        boolean zIsEmpty = timeline.isEmpty();
        String str = this.currentSessionId;
        HashMap map = this.sessions;
        if (zIsEmpty) {
            if (str != null) {
                SessionDescriptor sessionDescriptor = (SessionDescriptor) map.get(str);
                sessionDescriptor.getClass();
                clearCurrentSession(sessionDescriptor);
                return;
            }
            return;
        }
        SessionDescriptor sessionDescriptor2 = (SessionDescriptor) map.get(str);
        this.currentSessionId = getOrAddSession(i, mediaSource$MediaPeriodId2).sessionId;
        updateSessions(eventTime);
        if (mediaSource$MediaPeriodId2 != null) {
            long j = mediaSource$MediaPeriodId2.windowSequenceNumber;
            if (mediaSource$MediaPeriodId2.isAd()) {
                if (sessionDescriptor2 != null && sessionDescriptor2.windowSequenceNumber == j && (mediaSource$MediaPeriodId = sessionDescriptor2.adMediaPeriodId) != null && mediaSource$MediaPeriodId.adGroupIndex == mediaSource$MediaPeriodId2.adGroupIndex && mediaSource$MediaPeriodId.adIndexInAdGroup == mediaSource$MediaPeriodId2.adIndexInAdGroup) {
                    return;
                }
                this.listener.onAdPlaybackStarted(getOrAddSession(i, new MediaSource$MediaPeriodId(j, mediaSource$MediaPeriodId2.periodUid)).sessionId);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0033 A[Catch: all -> 0x0058, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:10:0x0018, B:12:0x0020, B:14:0x002c, B:17:0x0033, B:23:0x003e, B:25:0x004a, B:27:0x0050, B:33:0x005b, B:35:0x0067, B:36:0x006b, B:38:0x0070, B:40:0x0076, B:42:0x008d, B:43:0x00df, B:45:0x00e3, B:46:0x00ed, B:48:0x00f7, B:50:0x00fb), top: B:55:0x0005 }] */
    public final synchronized void updateSessions(AnalyticsListener.EventTime eventTime) {
        long j;
        this.listener.getClass();
        if (eventTime.timeline.isEmpty()) {
            return;
        }
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = eventTime.mediaPeriodId;
        if (mediaSource$MediaPeriodId != null) {
            long j2 = mediaSource$MediaPeriodId.windowSequenceNumber;
            if (j2 != -1) {
                SessionDescriptor sessionDescriptor = (SessionDescriptor) this.sessions.get(this.currentSessionId);
                if (sessionDescriptor != null) {
                    j = sessionDescriptor.windowSequenceNumber;
                    if (j == -1) {
                        j = this.lastRemovedCurrentWindowSequenceNumber + 1;
                    }
                } else {
                    j = this.lastRemovedCurrentWindowSequenceNumber + 1;
                }
                if (j2 < j) {
                    return;
                }
            }
            SessionDescriptor sessionDescriptor2 = (SessionDescriptor) this.sessions.get(this.currentSessionId);
            if (sessionDescriptor2 != null && sessionDescriptor2.windowSequenceNumber == -1 && sessionDescriptor2.windowIndex != eventTime.windowIndex) {
                return;
            }
        }
        SessionDescriptor orAddSession = getOrAddSession(eventTime.windowIndex, eventTime.mediaPeriodId);
        if (this.currentSessionId == null) {
            this.currentSessionId = orAddSession.sessionId;
        }
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = eventTime.mediaPeriodId;
        if (mediaSource$MediaPeriodId2 != null && mediaSource$MediaPeriodId2.isAd()) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId3 = eventTime.mediaPeriodId;
            Object obj = mediaSource$MediaPeriodId3.periodUid;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId4 = new MediaSource$MediaPeriodId(mediaSource$MediaPeriodId3.adGroupIndex, mediaSource$MediaPeriodId3.windowSequenceNumber, obj);
            SessionDescriptor orAddSession2 = getOrAddSession(eventTime.windowIndex, mediaSource$MediaPeriodId4);
            if (!orAddSession2.isCreated) {
                orAddSession2.isCreated = true;
                eventTime.timeline.getPeriodByUid(eventTime.mediaPeriodId.periodUid, this.period);
                this.listener.onSessionCreated(new AnalyticsListener.EventTime(eventTime.realtimeMs, eventTime.timeline, eventTime.windowIndex, mediaSource$MediaPeriodId4, Math.max(0L, Util.usToMs(this.period.getAdGroupTimeUs(eventTime.mediaPeriodId.adGroupIndex)) + Util.usToMs(this.period.positionInWindowUs)), eventTime.currentTimeline, eventTime.currentWindowIndex, eventTime.currentMediaPeriodId, eventTime.currentPlaybackPositionMs, eventTime.totalBufferedDurationMs), orAddSession2.sessionId);
            }
        }
        if (!orAddSession.isCreated) {
            orAddSession.isCreated = true;
            this.listener.onSessionCreated(eventTime, orAddSession.sessionId);
        }
        if (orAddSession.sessionId.equals(this.currentSessionId) && !orAddSession.isActive) {
            orAddSession.isActive = true;
            this.listener.onSessionActive(eventTime, orAddSession.sessionId);
        }
    }

    public final synchronized void updateSessionsWithDiscontinuity(int i, AnalyticsListener.EventTime eventTime) {
        try {
            this.listener.getClass();
            boolean z = i == 0;
            Iterator it = this.sessions.values().iterator();
            while (it.hasNext()) {
                SessionDescriptor sessionDescriptor = (SessionDescriptor) it.next();
                if (sessionDescriptor.isFinishedAtEventTime(eventTime)) {
                    it.remove();
                    boolean zEquals = sessionDescriptor.sessionId.equals(this.currentSessionId);
                    if (zEquals) {
                        clearCurrentSession(sessionDescriptor);
                    }
                    if (sessionDescriptor.isCreated) {
                        this.listener.onSessionFinished(eventTime, sessionDescriptor.sessionId, z && zEquals && sessionDescriptor.isActive);
                    }
                }
            }
            updateCurrentSession(eventTime);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void updateSessionsWithTimelineChange(AnalyticsListener.EventTime eventTime) {
        try {
            this.listener.getClass();
            Timeline timeline = this.currentTimeline;
            this.currentTimeline = eventTime.timeline;
            Iterator it = this.sessions.values().iterator();
            while (it.hasNext()) {
                SessionDescriptor sessionDescriptor = (SessionDescriptor) it.next();
                if (!sessionDescriptor.tryResolvingToNewTimeline(timeline, this.currentTimeline) || sessionDescriptor.isFinishedAtEventTime(eventTime)) {
                    it.remove();
                    if (sessionDescriptor.sessionId.equals(this.currentSessionId)) {
                        clearCurrentSession(sessionDescriptor);
                    }
                    if (sessionDescriptor.isCreated) {
                        this.listener.onSessionFinished(eventTime, sessionDescriptor.sessionId, false);
                    }
                }
            }
            updateCurrentSession(eventTime);
        } catch (Throwable th) {
            throw th;
        }
    }
}
