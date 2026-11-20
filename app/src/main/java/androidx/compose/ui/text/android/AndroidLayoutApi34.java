package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.GraphemeClusterSegmentFinder;
import android.text.Layout;
import android.text.SegmentFinder;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.core.provider.CallbackWrapper;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidLayoutApi34 {
    public static int[] getRangeForRect$ui_text(TextLayout textLayout, RectF rectF, int i, final ComposerKt$$ExternalSyntheticLambda0 composerKt$$ExternalSyntheticLambda0) {
        SegmentFinder graphemeClusterSegmentFinder;
        if (i == 1) {
            final CallbackWrapper callbackWrapper = new CallbackWrapper(textLayout.layout.getText(), textLayout.getWordIterator(), (byte) 12);
            graphemeClusterSegmentFinder = new SegmentFinder() { // from class: androidx.compose.ui.text.android.selection.Api34SegmentFinder$toAndroidSegmentFinder$1
                public final int nextEndBoundary(int i2) {
                    return callbackWrapper.nextEndBoundary(i2);
                }

                public final int nextStartBoundary(int i2) {
                    return callbackWrapper.nextStartBoundary(i2);
                }

                public final int previousEndBoundary(int i2) {
                    return callbackWrapper.previousEndBoundary(i2);
                }

                public final int previousStartBoundary(int i2) {
                    return callbackWrapper.previousStartBoundary(i2);
                }
            };
        } else {
            graphemeClusterSegmentFinder = new GraphemeClusterSegmentFinder(textLayout.layout.getText(), textLayout.textPaint);
        }
        return textLayout.layout.getRangeForRect(rectF, graphemeClusterSegmentFinder, new Layout.TextInclusionStrategy() { // from class: androidx.compose.ui.text.android.AndroidLayoutApi34$$ExternalSyntheticLambda2
            @Override // android.text.Layout.TextInclusionStrategy
            public final boolean isSegmentInside(RectF rectF2, RectF rectF3) {
                return ((Boolean) composerKt$$ExternalSyntheticLambda0.invoke(rectF2, rectF3)).booleanValue();
            }
        });
    }
}
