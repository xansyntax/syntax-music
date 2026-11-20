package androidx.compose.ui;

import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Alignment {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion implements CoroutineContext.Key {
        public static final BiasAlignment TopStart = new BiasAlignment(-1.0f, -1.0f);
        public static final BiasAlignment TopCenter = new BiasAlignment(CropImageView.DEFAULT_ASPECT_RATIO, -1.0f);
        public static final BiasAlignment TopEnd = new BiasAlignment(1.0f, -1.0f);
        public static final BiasAlignment CenterStart = new BiasAlignment(-1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
        public static final BiasAlignment Center = new BiasAlignment(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        public static final BiasAlignment CenterEnd = new BiasAlignment(1.0f, CropImageView.DEFAULT_ASPECT_RATIO);
        public static final BiasAlignment BottomStart = new BiasAlignment(-1.0f, 1.0f);
        public static final BiasAlignment BottomCenter = new BiasAlignment(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        public static final BiasAlignment BottomEnd = new BiasAlignment(1.0f, 1.0f);
        public static final BiasAlignment.Vertical Top = new BiasAlignment.Vertical(-1.0f);
        public static final BiasAlignment.Vertical CenterVertically = new BiasAlignment.Vertical(CropImageView.DEFAULT_ASPECT_RATIO);
        public static final BiasAlignment.Vertical Bottom = new BiasAlignment.Vertical(1.0f);
        public static final BiasAlignment.Horizontal Start = new BiasAlignment.Horizontal(-1.0f);
        public static final BiasAlignment.Horizontal CenterHorizontally = new BiasAlignment.Horizontal(CropImageView.DEFAULT_ASPECT_RATIO);
        public static final BiasAlignment.Horizontal End = new BiasAlignment.Horizontal(1.0f);
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Horizontal {
        int align(int i, int i2, LayoutDirection layoutDirection);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Vertical {
        int align(int i, int i2);
    }

    /* JADX INFO: renamed from: align-KFBX0sM, reason: not valid java name */
    long mo397alignKFBX0sM(long j, long j2, LayoutDirection layoutDirection);
}
