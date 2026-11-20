package androidx.activity;

import androidx.navigationevent.NavigationEvent;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BackEventCompat {
    public final long frameTimeMillis;
    public final float progress;
    public final int swipeEdge;
    public final float touchX;
    public final float touchY;

    public BackEventCompat(NavigationEvent navigationEvent) {
        navigationEvent.getClass();
        float f = navigationEvent.touchX;
        float f2 = navigationEvent.touchY;
        float f3 = navigationEvent.progress;
        int i = navigationEvent.swipeEdge;
        long j = navigationEvent.frameTimeMillis;
        this.touchX = f;
        this.touchY = f2;
        this.progress = f3;
        this.swipeEdge = i;
        this.frameTimeMillis = j;
    }

    public final String toString() {
        return "BackEventCompat(touchX=" + this.touchX + ", touchY=" + this.touchY + ", progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + ", frameTimeMillis=" + this.frameTimeMillis + ')';
    }
}
