package androidx.compose.ui.text.android.selection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface SegmentFinder {
    int nextEndBoundary(int i);

    int nextStartBoundary(int i);

    int previousEndBoundary(int i);

    int previousStartBoundary(int i);
}
