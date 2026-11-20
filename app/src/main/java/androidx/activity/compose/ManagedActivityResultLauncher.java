package androidx.activity.compose;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ManagedActivityResultLauncher extends ActivityResultLauncher {
    public final ActivityResultLauncherHolder launcher;

    public ManagedActivityResultLauncher(ActivityResultLauncherHolder activityResultLauncherHolder) {
        this.launcher = activityResultLauncherHolder;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public final void launch(Object obj) {
        ActivityResultRegistry.AnonymousClass2 anonymousClass2 = this.launcher.launcher;
        if (anonymousClass2 != null) {
            anonymousClass2.launch(obj);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Launcher has not been initialized");
        }
    }
}
