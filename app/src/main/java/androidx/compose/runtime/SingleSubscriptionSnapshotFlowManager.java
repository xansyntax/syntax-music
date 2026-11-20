package androidx.compose.runtime;

import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.media3.extractor.flv.TagPayloadReader;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SingleSubscriptionSnapshotFlowManager extends TagPayloadReader {
    public final TextKt$$ExternalSyntheticLambda2 readObserverCache;
    public Object soleWatchedObject;
    public SendChannel subscribedChannel;
    public final OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 unregisterApplyObserver;
    public MutableScatterSet watchSet;
    public Object workingSoleWatchedObject;
    public MutableScatterSet workingWatchSet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleSubscriptionSnapshotFlowManager() {
        super((byte) 3);
        byte b = 3;
        this.readObserverCache = new TextKt$$ExternalSyntheticLambda2((byte) 12, this);
        ComposerKt$$ExternalSyntheticLambda0 composerKt$$ExternalSyntheticLambda0 = new ComposerKt$$ExternalSyntheticLambda0((byte) 22, this);
        SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
        synchronized (SnapshotKt.lock) {
            SnapshotKt.applyObservers = CollectionsKt.plus(composerKt$$ExternalSyntheticLambda0, SnapshotKt.applyObservers);
        }
        this.unregisterApplyObserver = new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(b, composerKt$$ExternalSyntheticLambda0);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final void clearWatchSet$runtime(SendChannel sendChannel) {
        this.workingSoleWatchedObject = null;
        this.workingWatchSet = null;
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final void commitSubscriptionChanges$runtime() {
        synchronized (this.output) {
            try {
                this.soleWatchedObject = this.workingSoleWatchedObject;
                if (this.workingWatchSet == null) {
                    this.watchSet = null;
                } else {
                    MutableScatterSet mutableScatterSet = this.watchSet;
                    if (mutableScatterSet == null) {
                        MutableScatterSet mutableScatterSet2 = ScatterSetKt.EmptyScatterSet;
                        mutableScatterSet = new MutableScatterSet();
                        this.watchSet = mutableScatterSet;
                    }
                    this.watchSet = this.workingWatchSet;
                    this.workingWatchSet = mutableScatterSet;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final void dispose$runtime() {
        this.unregisterApplyObserver.dispose();
        this.workingSoleWatchedObject = null;
        this.workingWatchSet = null;
        synchronized (this.output) {
            this.subscribedChannel = null;
            this.soleWatchedObject = null;
            this.watchSet = null;
        }
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final Function1 readObserverFor$runtime(SendChannel sendChannel) {
        SendChannel sendChannel2 = this.subscribedChannel;
        if (sendChannel2 != null && !sendChannel2.equals(sendChannel)) {
            PreconditionsKt.throwIllegalStateException("Requested a SingleSubscriptionSnapshotFlowManager to manage multiple subscriptions");
        }
        this.subscribedChannel = sendChannel;
        return this.readObserverCache;
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final void reportSnapshotFlowCancellation$runtime(Channel channel) {
        this.subscribedChannel = null;
        this.workingSoleWatchedObject = null;
        this.workingWatchSet = null;
        commitSubscriptionChanges$runtime();
    }
}
