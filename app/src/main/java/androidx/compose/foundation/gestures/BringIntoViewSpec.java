package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface BringIntoViewSpec {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final SpringSpec DefaultScrollAnimationSpec = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, 7);
        public static final BringIntoViewSpec$Companion$DefaultBringIntoViewSpec$1 DefaultBringIntoViewSpec = new BringIntoViewSpec$Companion$DefaultBringIntoViewSpec$1();
    }

    default float calculateScrollDistance(float f, float f2, float f3) {
        Companion.getClass();
        float f4 = f2 + f;
        if ((f >= CropImageView.DEFAULT_ASPECT_RATIO && f4 <= f3) || (f < CropImageView.DEFAULT_ASPECT_RATIO && f4 > f3)) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float f5 = f4 - f3;
        return Math.abs(f) < Math.abs(f5) ? f : f5;
    }
}
