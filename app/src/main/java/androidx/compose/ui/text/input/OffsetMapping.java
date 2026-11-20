package androidx.compose.ui.text.input;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface OffsetMapping {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
        public static final VisualTransformation.Companion Identity = new VisualTransformation.Companion();
    }

    int originalToTransformed(int i);

    int transformedToOriginal(int i);
}
