package androidx.compose.animation;

import android.view.ViewConfiguration;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SplineBasedFloatDecayAnimationSpec_androidKt {
    public static final float platformFlingScrollFriction = ViewConfiguration.getScrollFriction();

    public static final DecayAnimationSpecImpl rememberSplineBasedDecay(Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
        boolean zChanged = gapComposer.changed(density.getDensity());
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new DecayAnimationSpecImpl(new DrawResult(density));
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (DecayAnimationSpecImpl) objRememberedValue;
    }
}
