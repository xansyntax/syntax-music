package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.node.UiApplier;
import coil3.RealImageLoader;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.R;
import dagger.hilt.EntryPoints;
import kotlin.Function;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Wrapper_androidKt {
    public static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    /* JADX INFO: renamed from: androidx.compose.ui.platform.Wrapper_androidKt$setContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final /* synthetic */ class AnonymousClass1 implements LifecycleRetainedValuesStoreOwner.FrameEndScheduler, FunctionAdapter {
        public final /* synthetic */ CompositionContext $tmp0;

        public AnonymousClass1(CompositionContext compositionContext) {
            this.$tmp0 = compositionContext;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof LifecycleRetainedValuesStoreOwner.FrameEndScheduler) && (obj instanceof FunctionAdapter)) {
                return getFunctionDelegate().equals(((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return new FunctionReferenceImpl(1, this.$tmp0, CompositionContext.class, "scheduleFrameEndCallback", "scheduleFrameEndCallback(Lkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/CancellationHandle;", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005f  */
    /* JADX WARN: Code duplicated, block: B:26:0x007a  */
    /* JADX WARN: Code duplicated, block: B:29:0x008b  */
    /* JADX WARN: Code duplicated, block: B:31:0x0090  */
    public static final WrappedComposition setContent(AbstractComposeView abstractComposeView, ComposeViewContext composeViewContext, ComposableLambdaImpl composableLambdaImpl) {
        AndroidComposeView androidComposeView;
        WrappedComposition wrappedComposition;
        if (GlobalSnapshotManager.started.compareAndSet(false, true)) {
            BufferedChannel bufferedChannelChannel$default = EntryPoints.Channel$default(1, 6, null);
            AwaitKt.launch$default(AwaitKt.CoroutineScope((CoroutineContext) AndroidUiDispatcher.Main$delegate.getValue()), null, null, new RealImageLoader.AnonymousClass2(bufferedChannelChannel$default, null, (byte) 22), 3);
            DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0 = new DiskLruCache$$ExternalSyntheticLambda0((byte) 1, bufferedChannelChannel$default);
            synchronized (SnapshotKt.lock) {
                SnapshotKt.globalWriteObservers = CollectionsKt.plus(diskLruCache$$ExternalSyntheticLambda0, SnapshotKt.globalWriteObservers);
            }
            SnapshotKt.advanceGlobalSnapshot();
        }
        if (abstractComposeView.getChildCount() > 0) {
            View childAt = abstractComposeView.getChildAt(0);
            androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
            if (androidComposeView != null) {
                androidComposeView.setComposeViewContext(composeViewContext);
            }
            if (androidComposeView == null) {
                androidComposeView = new AndroidComposeView(abstractComposeView.getContext(), composeViewContext);
                abstractComposeView.addView(androidComposeView.getView(), DefaultLayoutParams);
            }
            androidComposeView.setComposeViewContext(composeViewContext);
            if (abstractComposeView.getComposeViewContext$ui() != null) {
                composeViewContext.incrementViewCount$ui();
                androidComposeView.setComposeViewContextIncrementedDuringInit$ui(true);
            }
            Object tag = androidComposeView.getTag(R.id.wrapped_composition_tag);
            wrappedComposition = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
            if (wrappedComposition == null) {
                wrappedComposition = new WrappedComposition(androidComposeView, new CompositionImpl(composeViewContext.getCompositionContext$ui(), new UiApplier(androidComposeView.getRoot())));
                androidComposeView.setTag(R.id.wrapped_composition_tag, wrappedComposition);
            }
            wrappedComposition.setContent(composableLambdaImpl);
            androidComposeView.setFrameEndScheduler$ui(new AnonymousClass1(composeViewContext.getCompositionContext$ui()));
            return wrappedComposition;
        }
        abstractComposeView.removeAllViews();
        androidComposeView = null;
        if (androidComposeView == null) {
            androidComposeView = new AndroidComposeView(abstractComposeView.getContext(), composeViewContext);
            abstractComposeView.addView(androidComposeView.getView(), DefaultLayoutParams);
        }
        androidComposeView.setComposeViewContext(composeViewContext);
        if (abstractComposeView.getComposeViewContext$ui() != null) {
            composeViewContext.incrementViewCount$ui();
            androidComposeView.setComposeViewContextIncrementedDuringInit$ui(true);
        }
        Object tag2 = androidComposeView.getTag(R.id.wrapped_composition_tag);
        if (tag2 instanceof WrappedComposition) {
        }
        if (wrappedComposition == null) {
            wrappedComposition = new WrappedComposition(androidComposeView, new CompositionImpl(composeViewContext.getCompositionContext$ui(), new UiApplier(androidComposeView.getRoot())));
            androidComposeView.setTag(R.id.wrapped_composition_tag, wrappedComposition);
        }
        wrappedComposition.setContent(composableLambdaImpl);
        androidComposeView.setFrameEndScheduler$ui(new AnonymousClass1(composeViewContext.getCompositionContext$ui()));
        return wrappedComposition;
    }
}
