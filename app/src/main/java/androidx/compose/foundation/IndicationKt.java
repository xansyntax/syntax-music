package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.Modifier;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IndicationKt {
    public static final StaticProvidableCompositionLocal LocalIndication = new StaticProvidableCompositionLocal(new ScrollKt$$ExternalSyntheticLambda0((byte) 13), (byte) 1);

    public static final Modifier indication(Modifier modifier, InteractionSource interactionSource, IndicationNodeFactory indicationNodeFactory) {
        return indicationNodeFactory == null ? modifier : modifier.then(new IndicationModifierElement(interactionSource, indicationNodeFactory));
    }
}
