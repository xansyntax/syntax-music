package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LinkStateInteractionSourceObserver {
    public final InteractionSource interactionSource;
    public final ParcelableSnapshotMutableIntState interactionState = new ParcelableSnapshotMutableIntState(0);

    public LinkStateInteractionSourceObserver(MutableInteractionSourceImpl mutableInteractionSourceImpl) {
        this.interactionSource = mutableInteractionSourceImpl;
    }
}
