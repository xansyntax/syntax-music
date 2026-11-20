package androidx.compose.animation.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.media3.extractor.flv.TagPayloadReader;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableTransitionState extends TagPayloadReader {
    public final ParcelableSnapshotMutableState currentState$delegate;
    public final ParcelableSnapshotMutableState targetState$delegate;

    public MutableTransitionState(Object obj) {
        super((byte) 1);
        this.currentState$delegate = Stack.mutableStateOf$default(obj);
        this.targetState$delegate = Stack.mutableStateOf$default(obj);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final Object getCurrentState() {
        return this.currentState$delegate.getValue();
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final Object getTargetState() {
        return this.targetState$delegate.getValue();
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final void setCurrentState$animation_core(Object obj) {
        this.currentState$delegate.setValue(obj);
    }
}
