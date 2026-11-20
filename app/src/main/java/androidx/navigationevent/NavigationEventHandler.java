package androidx.navigationevent;

import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavigationEventHandler {
    public UtilsKt currentInfo;
    public NavigationEventDispatcher dispatcher;
    public boolean isBackEnabled;

    public abstract void onBackCancelled();

    public abstract void onBackCompleted();

    public abstract void onBackProgressed(NavigationEvent navigationEvent);

    public abstract void onBackStarted(NavigationEvent navigationEvent);

    public final void remove() {
        NavigationEventDispatcher navigationEventDispatcher = this.dispatcher;
        if (navigationEventDispatcher == null || !navigationEventDispatcher.handlers.remove(this)) {
            return;
        }
        NavigationEventProcessor navigationEventProcessor = navigationEventDispatcher.sharedProcessor;
        if (equals(navigationEventProcessor.inProgressHandler)) {
            if (navigationEventProcessor.inProgressDirection == -1) {
                onBackCancelled();
            }
            navigationEventProcessor.inProgressHandler = null;
            navigationEventProcessor.inProgressDirection = 0;
            navigationEventProcessor.inProgressInput = null;
        }
        navigationEventProcessor.overlayHandlers.remove(this);
        navigationEventProcessor.defaultHandlers.remove(this);
        this.dispatcher = null;
        navigationEventProcessor.refreshEnabledHandlers();
    }

    public final void setBackEnabled(boolean z) {
        if (this.isBackEnabled == z) {
            return;
        }
        this.isBackEnabled = z;
        NavigationEventDispatcher navigationEventDispatcher = this.dispatcher;
        if (navigationEventDispatcher != null) {
            navigationEventDispatcher.sharedProcessor.refreshEnabledHandlers();
        }
    }
}
