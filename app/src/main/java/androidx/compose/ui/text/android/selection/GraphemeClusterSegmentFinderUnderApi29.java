package androidx.compose.ui.text.android.selection;

import coil3.util.LifecyclesKt;
import java.text.BreakIterator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GraphemeClusterSegmentFinderUnderApi29 extends LifecyclesKt {
    public final BreakIterator breakIterator;

    public GraphemeClusterSegmentFinderUnderApi29(CharSequence charSequence) {
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(charSequence.toString());
        this.breakIterator = characterInstance;
    }

    @Override // coil3.util.LifecyclesKt
    public final int next(int i) {
        return this.breakIterator.following(i);
    }

    @Override // coil3.util.LifecyclesKt
    public final int previous(int i) {
        return this.breakIterator.preceding(i);
    }
}
