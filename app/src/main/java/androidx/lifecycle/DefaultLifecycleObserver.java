package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface DefaultLifecycleObserver extends LifecycleObserver {
    default void onCreate(LifecycleOwner lifecycleOwner) {
    }

    default void onDestroy(LifecycleOwner lifecycleOwner) {
    }

    default void onPause(LifecycleOwner lifecycleOwner) {
    }

    default void onResume(LifecycleOwner lifecycleOwner) {
    }

    default void onStart(LifecycleOwner lifecycleOwner) {
    }

    default void onStop(LifecycleOwner lifecycleOwner) {
    }
}
