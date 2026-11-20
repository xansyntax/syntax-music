package androidx.compose.animation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.Color;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SingleValueAnimationKt {
    public static final SpringSpec colorDefaultSpring = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, 7);

    /* JADX INFO: renamed from: animateColorAsState-euL9pac, reason: not valid java name */
    public static final AnimateAsState m17animateColorAsStateeuL9pac(long j, AnimationSpec animationSpec, String str, Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            animationSpec = colorDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "ColorAnimation";
        }
        String str2 = str;
        GapComposer gapComposer = (GapComposer) composer;
        boolean zChanged = gapComposer.changed(Color.m483getColorSpaceimpl(j));
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(ColorVectorConverterKt$ColorToVector$1$1.INSTANCE, new CallsKt$await$2$1((byte) 1, Color.m483getColorSpaceimpl(j)), gapComposer);
        }
        int i3 = i << 6;
        return AnimateAsStateKt.animateValueAsState(new Color(j), (TwoWayConverterImpl) objRememberedValue, animationSpec2, null, str2, gapComposer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
    }
}
