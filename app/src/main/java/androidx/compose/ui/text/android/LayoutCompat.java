package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LayoutCompat {
    public static final Layout.Alignment DEFAULT_LAYOUT_ALIGNMENT = Layout.Alignment.ALIGN_NORMAL;

    static {
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
    }
}
