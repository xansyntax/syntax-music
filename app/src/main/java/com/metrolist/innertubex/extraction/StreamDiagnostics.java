package com.metrolist.innertubex.extraction;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StreamDiagnostics {
    public final List attempts;
    public final boolean usedAuthenticatedWatchPage;

    public StreamDiagnostics(List list, boolean z) {
        this.attempts = list;
        this.usedAuthenticatedWatchPage = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreamDiagnostics)) {
            return false;
        }
        StreamDiagnostics streamDiagnostics = (StreamDiagnostics) obj;
        return this.attempts.equals(streamDiagnostics.attempts) && this.usedAuthenticatedWatchPage == streamDiagnostics.usedAuthenticatedWatchPage;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.usedAuthenticatedWatchPage) + (this.attempts.hashCode() * 31);
    }

    public final String toString() {
        return "StreamDiagnostics(attempts=" + this.attempts + ", usedAuthenticatedWatchPage=" + this.usedAuthenticatedWatchPage + ")";
    }
}
