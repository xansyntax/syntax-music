package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ZIndexModifierKt {
    public static final BiasAbsoluteAlignment TopLeft = new BiasAbsoluteAlignment(-1.0f);
    public static final BiasAbsoluteAlignment TopRight = new BiasAbsoluteAlignment(1.0f);
    public static final BiasAbsoluteAlignment.Horizontal Left = new BiasAbsoluteAlignment.Horizontal(-1.0f);
    public static final BiasAbsoluteAlignment.Horizontal Right = new BiasAbsoluteAlignment.Horizontal(1.0f);

    public static final Modifier materializeImpl(Composer composer, Modifier modifier) {
        if (modifier.all(new ComposedModifierKt$$ExternalSyntheticLambda0((byte) 0))) {
            return modifier;
        }
        ((GapComposer) composer).m384startAzEfcrM(1219399079, 0, null, null);
        Modifier modifier2 = (Modifier) modifier.foldIn(Modifier.Companion.$$INSTANCE, new ComposerKt$$ExternalSyntheticLambda0((byte) 25, composer));
        ((GapComposer) composer).end(false);
        return modifier2;
    }

    public static final Modifier materializeModifier(Composer composer, Modifier modifier) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(439770924);
        Modifier modifierMaterializeImpl = materializeImpl(gapComposer, modifier);
        gapComposer.end(false);
        return modifierMaterializeImpl;
    }

    public static final Modifier zIndex(Modifier modifier, float f) {
        return modifier.then(new ZIndexElement(f));
    }
}
