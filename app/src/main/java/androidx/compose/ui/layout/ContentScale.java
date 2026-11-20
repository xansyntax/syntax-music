package androidx.compose.ui.layout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ContentScale {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
        public static final ContentScale$Companion$Fit$1 Crop = new ContentScale$Companion$Fit$1(2);
        public static final ContentScale$Companion$Fit$1 Fit = new ContentScale$Companion$Fit$1(0);
        public static final ContentScale$Companion$Fit$1 Inside = new ContentScale$Companion$Fit$1(3);
        public static final FixedScale None = new FixedScale();
    }

    /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA, reason: not valid java name */
    long mo597computeScaleFactorH7hwNQA(long j, long j2);
}
