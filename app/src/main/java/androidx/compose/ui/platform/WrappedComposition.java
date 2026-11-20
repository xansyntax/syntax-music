package androidx.compose.ui.platform;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.yalantis.ucrop.R;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WrappedComposition implements Composition, LifecycleEventObserver {
    public Lifecycle addedToLifecycle;
    public boolean disposed;
    public ComposableLambdaImpl lastContent = InvertMatrixKt.f6lambda$1759434350;
    public final CompositionImpl original;
    public final AndroidComposeView owner;

    public WrappedComposition(AndroidComposeView androidComposeView, CompositionImpl compositionImpl) {
        this.owner = androidComposeView;
        this.original = compositionImpl;
    }

    public final void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            AndroidComposeView androidComposeView = this.owner;
            androidComposeView.getView().setTag(R.id.wrapped_composition_tag, null);
            Lifecycle lifecycle = this.addedToLifecycle;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
            }
            this.addedToLifecycle = null;
            DisposableSaveableStateRegistry disposableSaveableStateRegistry = androidComposeView._savedStateRegistry;
            if (disposableSaveableStateRegistry != null) {
                disposableSaveableStateRegistry.onDispose.invoke();
            }
            androidComposeView._savedStateRegistry = null;
        }
        this.original.dispose();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            dispose();
        } else {
            if (event != Lifecycle.Event.ON_CREATE || this.disposed) {
                return;
            }
            setContent(this.lastContent);
        }
    }

    public final void setContent(Function2 function2) {
        this.owner.setOnReadyForComposition(new ZIndexNode$$ExternalSyntheticLambda0((Object) this, function2, (byte) 29));
    }
}
