package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.compose.internal.BackHandlerCompat$navigationEventHandler$1;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.compose.material3.SliderState;
import androidx.fragment.app.FragmentManager;
import com.metrolist.music.App$Companion$forgetAccount$2;
import dagger.hilt.EntryPoints;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposePredictiveBackHandler extends BaseMenuWrapper {
    public BufferedChannel activeChannel;
    public StandaloneCoroutine activeJob;
    public Function2 currentOnBack;
    public boolean isPredictiveBack;
    public final CoroutineScope scope;

    public ComposePredictiveBackHandler(CoroutineScope coroutineScope, PredictiveBackHandlerInfo predictiveBackHandlerInfo) {
        super(predictiveBackHandlerInfo);
        this.scope = coroutineScope;
        this.currentOnBack = new App$Companion$forgetAccount$2(2, null, (byte) 1);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final void onBackCancelled() {
        BufferedChannel bufferedChannel = this.activeChannel;
        if (bufferedChannel != null) {
            bufferedChannel.closeOrCancelImpl(new CancellationException("onBack cancelled"), true);
        }
        StandaloneCoroutine standaloneCoroutine = this.activeJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.activeChannel = null;
        this.activeJob = null;
        this.isPredictiveBack = false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final void onBackCompleted() {
        if (this.activeChannel != null && !this.isPredictiveBack) {
            onBackCancelled();
        }
        Continuation continuation = null;
        if (this.activeChannel == null) {
            this.isPredictiveBack = false;
            this.activeChannel = EntryPoints.Channel$default(-2, 4, BufferOverflow.SUSPEND);
            this.activeJob = AwaitKt.launch$default(this.scope, null, null, new SliderState.AnonymousClass2(this, continuation, (byte) 1), 3);
        }
        BufferedChannel bufferedChannel = this.activeChannel;
        if (bufferedChannel != null) {
            bufferedChannel.close(null);
        }
        this.isPredictiveBack = false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final void onBackProgressed(BackEventCompat backEventCompat) {
        BufferedChannel bufferedChannel = this.activeChannel;
        if (bufferedChannel != null) {
            bufferedChannel.mo1712trySendJP2dKIU(backEventCompat);
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final void onBackStarted() {
        onBackCancelled();
        if (super.isBackEnabled()) {
            this.isPredictiveBack = true;
            this.activeChannel = EntryPoints.Channel$default(-2, 4, BufferOverflow.SUSPEND);
            this.activeJob = AwaitKt.launch$default(this.scope, null, null, new SliderState.AnonymousClass2(this, null, (byte) 1), 3);
        }
    }

    public final void setBackEnabled(boolean z) {
        StandaloneCoroutine standaloneCoroutine;
        if (!z && super.isBackEnabled() && (standaloneCoroutine = this.activeJob) != null && !standaloneCoroutine.isActive()) {
            onBackCancelled();
        }
        ((FragmentManager.AnonymousClass1) this.mContext).setEnabled(z);
        ((BackHandlerCompat$navigationEventHandler$1) this.mMenuItems).setBackEnabled(z);
    }
}
