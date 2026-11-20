package com.metrolist.music.ui.component;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MenuState {
    public final ParcelableSnapshotMutableState content$delegate;
    public final ParcelableSnapshotMutableState isVisible$delegate;

    public MenuState() {
        ComposableLambdaImpl composableLambdaImpl = DialogKt.lambda$2028033804;
        this.isVisible$delegate = Stack.mutableStateOf$default(false);
        this.content$delegate = Stack.mutableStateOf$default(composableLambdaImpl);
    }

    public final void setVisible(boolean z) {
        this.isVisible$delegate.setValue(Boolean.valueOf(z));
    }

    public final void show(ComposableLambdaImpl composableLambdaImpl) {
        setVisible(true);
        this.content$delegate.setValue(composableLambdaImpl);
    }
}
