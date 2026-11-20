package androidx.compose.ui.text.input;

import androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.AnnotatedString;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface VisualTransformation {
    TransformedText filter(AnnotatedString annotatedString);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion implements OffsetMapping {
        public static final ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 None = new ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0(26);

        @Override // androidx.compose.ui.text.input.OffsetMapping
        public int originalToTransformed(int i) {
            return i;
        }

        @Override // androidx.compose.ui.text.input.OffsetMapping
        public int transformedToOriginal(int i) {
            return i;
        }
    }
}
