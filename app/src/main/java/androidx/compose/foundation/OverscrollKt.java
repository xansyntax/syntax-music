package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComputedProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OverscrollKt {
    public static final ComputedProvidableCompositionLocal LocalOverscrollFactory = new ComputedProvidableCompositionLocal(new BorderKt$$ExternalSyntheticLambda1((byte) 16));

    public static final Modifier overscroll(Modifier modifier) {
        return modifier.then(new OverscrollModifierElement());
    }

    public static final AndroidEdgeEffectOverscrollEffect rememberOverscrollEffect(Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(282942128);
        AndroidEdgeEffectOverscrollFactory androidEdgeEffectOverscrollFactory = (AndroidEdgeEffectOverscrollFactory) gapComposer.consume(LocalOverscrollFactory);
        if (androidEdgeEffectOverscrollFactory == null) {
            gapComposer.end(false);
            return null;
        }
        boolean zChanged = gapComposer.changed(androidEdgeEffectOverscrollFactory);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new AndroidEdgeEffectOverscrollEffect(androidEdgeEffectOverscrollFactory.context, androidEdgeEffectOverscrollFactory.density, androidEdgeEffectOverscrollFactory.glowDrawPadding);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = (AndroidEdgeEffectOverscrollEffect) objRememberedValue;
        gapComposer.end(false);
        return androidEdgeEffectOverscrollEffect;
    }
}
