package androidx.compose.foundation.text;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface TextDragObserver {
    void onCancel();

    /* JADX INFO: renamed from: onDown-k-4lQ0M, reason: not valid java name */
    void mo200onDownk4lQ0M();

    /* JADX INFO: renamed from: onDrag-k-4lQ0M, reason: not valid java name */
    void mo201onDragk4lQ0M(long j);

    /* JADX INFO: renamed from: onStart-3MmeM6k, reason: not valid java name */
    void mo202onStart3MmeM6k(long j, MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda0);

    void onStop();

    void onUp();
}
