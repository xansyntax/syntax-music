package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.Animatable;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.core.provider.CallbackWrapper;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PullToRefreshStateImpl {
    public static final CallbackWrapper Saver = new CallbackWrapper(new Updater$$ExternalSyntheticLambda0((byte) 4), new TextKt$$ExternalSyntheticLambda0(25), 7);
    public final Animatable anim;

    public PullToRefreshStateImpl(Animatable animatable) {
        this.anim = animatable;
    }
}
