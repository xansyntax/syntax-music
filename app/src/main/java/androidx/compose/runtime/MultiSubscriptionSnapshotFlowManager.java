package androidx.compose.runtime;

import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.media3.extractor.flv.TagPayloadReader;
import coil3.network.HttpException;
import com.google.common.math.IntMath;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiSubscriptionSnapshotFlowManager extends TagPayloadReader {
    public final ArrayList pendingChanges;
    public final MutableScatterMap readObserverCache;
    public final MutableScatterMap subscriptions;
    public final OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 unregisterApplyObserver;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Add implements SubscriptionChange {
        public final SendChannel channel;
        public final Object obj;

        public Add(Object obj, SendChannel sendChannel) {
            this.obj = obj;
            this.channel = sendChannel;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RemoveScope implements SubscriptionChange {
        public final SendChannel channel;

        public RemoveScope(SendChannel sendChannel) {
            this.channel = sendChannel;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SubscriptionChange {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiSubscriptionSnapshotFlowManager() {
        super((byte) 3);
        byte b = 3;
        this.subscriptions = IntMath.m899constructorimpl$default();
        this.pendingChanges = new ArrayList();
        this.readObserverCache = new MutableScatterMap();
        ComposerKt$$ExternalSyntheticLambda0 composerKt$$ExternalSyntheticLambda0 = new ComposerKt$$ExternalSyntheticLambda0((byte) 20, this);
        SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
        synchronized (SnapshotKt.lock) {
            SnapshotKt.applyObservers = CollectionsKt.plus(composerKt$$ExternalSyntheticLambda0, SnapshotKt.applyObservers);
        }
        this.unregisterApplyObserver = new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(b, composerKt$$ExternalSyntheticLambda0);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final void clearWatchSet$runtime(SendChannel sendChannel) {
        this.pendingChanges.add(new RemoveScope(sendChannel));
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final void commitSubscriptionChanges$runtime() {
        synchronized (this.output) {
            try {
                ArrayList arrayList = this.pendingChanges;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    SubscriptionChange subscriptionChange = (SubscriptionChange) arrayList.get(i);
                    if (subscriptionChange instanceof Add) {
                        IntMath.m897addimpl(this.subscriptions, ((Add) subscriptionChange).obj, ((Add) subscriptionChange).channel);
                    } else {
                        if (!(subscriptionChange instanceof RemoveScope)) {
                            throw new HttpException();
                        }
                        IntMath.m903removeScopeimpl(this.subscriptions, ((RemoveScope) subscriptionChange).channel);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.pendingChanges.clear();
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final void dispose$runtime() {
        this.unregisterApplyObserver.dispose();
        this.pendingChanges.clear();
        this.readObserverCache.clear();
        synchronized (this.output) {
            this.subscriptions.clear();
        }
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final Function1 readObserverFor$runtime(SendChannel sendChannel) {
        MutableScatterMap mutableScatterMap = this.readObserverCache;
        Function1 zIndexNode$$ExternalSyntheticLambda0 = (Function1) mutableScatterMap.get(sendChannel);
        if (zIndexNode$$ExternalSyntheticLambda0 == null) {
            zIndexNode$$ExternalSyntheticLambda0 = new ZIndexNode$$ExternalSyntheticLambda0((Object) this, (Object) sendChannel, (byte) 21);
            int iFindInsertIndex = mutableScatterMap.findInsertIndex(sendChannel);
            if (iFindInsertIndex < 0) {
                iFindInsertIndex = ~iFindInsertIndex;
            }
            Object[] objArr = mutableScatterMap.values;
            Object obj = objArr[iFindInsertIndex];
            mutableScatterMap.keys[iFindInsertIndex] = sendChannel;
            objArr[iFindInsertIndex] = zIndexNode$$ExternalSyntheticLambda0;
        }
        return zIndexNode$$ExternalSyntheticLambda0;
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final void reportSnapshotFlowCancellation$runtime(Channel channel) {
        this.readObserverCache.remove(channel);
        clearWatchSet$runtime(channel);
        commitSubscriptionChanges$runtime();
    }
}
