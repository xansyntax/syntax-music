package androidx.compose.ui.text.font;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FontWeightAdjustmentHelperApi31 {
    public static final FontWeightAdjustmentHelperApi31 INSTANCE = new FontWeightAdjustmentHelperApi31();

    public final int fontWeightAdjustment(Context context) {
        return context.getResources().getConfiguration().fontWeightAdjustment;
    }
}
