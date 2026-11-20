package androidx.activity.compose;

import androidx.activity.compose.internal.BackHandlerCompat$navigationEventHandler$1;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BackHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1 {
    public final /* synthetic */ BaseMenuWrapper $handler$inlined;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ BackHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1(LifecycleStartStopEffectScope lifecycleStartStopEffectScope, BaseMenuWrapper baseMenuWrapper, byte b) {
        this.$r8$classId = b;
        this.$handler$inlined = baseMenuWrapper;
    }

    public final void runStopOrDisposeEffect() {
        byte b = this.$r8$classId;
        BaseMenuWrapper baseMenuWrapper = this.$handler$inlined;
        switch (b) {
            case 0:
                ComposeBackHandler composeBackHandler = (ComposeBackHandler) baseMenuWrapper;
                ((FragmentManager.AnonymousClass1) composeBackHandler.mContext).setEnabled(false);
                ((BackHandlerCompat$navigationEventHandler$1) composeBackHandler.mMenuItems).setBackEnabled(false);
                break;
            default:
                ((ComposePredictiveBackHandler) baseMenuWrapper).setBackEnabled(false);
                break;
        }
    }
}
