package androidx.navigationevent;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavigationEvent {
    public final long frameTimeMillis;
    public final float progress;
    public final int swipeEdge;
    public final float touchX;
    public final float touchY;

    public NavigationEvent(int i, float f, float f2, float f3, long j) {
        this.swipeEdge = i;
        this.progress = f;
        this.touchX = f2;
        this.touchY = f3;
        this.frameTimeMillis = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && NavigationEvent.class == obj.getClass()) {
            NavigationEvent navigationEvent = (NavigationEvent) obj;
            return this.touchX == navigationEvent.touchX && this.touchY == navigationEvent.touchY && this.progress == navigationEvent.progress && this.swipeEdge == navigationEvent.swipeEdge && this.frameTimeMillis == navigationEvent.frameTimeMillis;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.frameTimeMillis) + IntIntPair$$ExternalSyntheticOutline0.m(this.swipeEdge, IntIntPair$$ExternalSyntheticOutline0.m(this.progress, IntIntPair$$ExternalSyntheticOutline0.m(this.touchY, Float.hashCode(this.touchX) * 31, 31), 31), 31);
    }

    public final String toString() {
        return "NavigationEvent(touchX=" + this.touchX + ", touchY=" + this.touchY + ", progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + ", frameTimeMillis=" + this.frameTimeMillis + ')';
    }
}
