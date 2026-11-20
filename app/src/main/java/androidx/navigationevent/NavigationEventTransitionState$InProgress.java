package androidx.navigationevent;

import androidx.sqlite.SQLite;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavigationEventTransitionState$InProgress extends SQLite {
    public final NavigationEvent latestEvent;

    public NavigationEventTransitionState$InProgress(NavigationEvent navigationEvent) {
        navigationEvent.getClass();
        this.latestEvent = navigationEvent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && NavigationEventTransitionState$InProgress.class == obj.getClass() && Intrinsics.areEqual(this.latestEvent, ((NavigationEventTransitionState$InProgress) obj).latestEvent);
    }

    public final int hashCode() {
        return this.latestEvent.hashCode() - 31;
    }

    public final String toString() {
        return "InProgress(latestEvent=" + this.latestEvent + ", direction=-1)";
    }
}
