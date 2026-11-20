package androidx.compose.foundation.selection;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.material3.RippleNodeFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SelectableKt {
    /* JADX INFO: renamed from: selectable-O2vRcR0, reason: not valid java name */
    public static final Modifier m181selectableO2vRcR0(Modifier modifier, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, RippleNodeFactory rippleNodeFactory, boolean z2, Role role, Function0 function0) {
        Modifier modifierThen;
        if (rippleNodeFactory != null) {
            modifierThen = new SelectableElement(z, mutableInteractionSourceImpl, rippleNodeFactory, z2, role, function0);
        } else if (rippleNodeFactory == null) {
            modifierThen = new SelectableElement(z, mutableInteractionSourceImpl, null, z2, role, function0);
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            modifierThen = mutableInteractionSourceImpl != null ? IndicationKt.indication(companion, mutableInteractionSourceImpl, rippleNodeFactory).then(new SelectableElement(z, mutableInteractionSourceImpl, null, z2, role, function0)) : companion.then(new ComposedModifier(new SelectableKt$selectableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(rippleNodeFactory, z, z2, role, function0, (byte) 0)));
        }
        return modifier.then(modifierThen);
    }

    /* JADX INFO: renamed from: toggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m182toggleableO2vRcR0(Modifier modifier, boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, RippleNodeFactory rippleNodeFactory, boolean z2, Role role, Function1 function1) {
        Modifier modifierThen;
        if (rippleNodeFactory != null) {
            modifierThen = new ToggleableElement(z, mutableInteractionSourceImpl, rippleNodeFactory, z2, role, function1);
        } else if (rippleNodeFactory == null) {
            modifierThen = new ToggleableElement(z, mutableInteractionSourceImpl, null, z2, role, function1);
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            modifierThen = mutableInteractionSourceImpl != null ? IndicationKt.indication(companion, mutableInteractionSourceImpl, rippleNodeFactory).then(new ToggleableElement(z, mutableInteractionSourceImpl, null, z2, role, function1)) : companion.then(new ComposedModifier(new SelectableKt$selectableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(rippleNodeFactory, z, z2, role, function1, (byte) 1)));
        }
        return modifier.then(modifierThen);
    }

    /* JADX INFO: renamed from: triStateToggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m183triStateToggleableO2vRcR0(Modifier.Companion companion, final ToggleableState toggleableState, final RippleNodeFactory rippleNodeFactory, final boolean z, final Role role, final Function0 function0) {
        if (rippleNodeFactory != null) {
            return new TriStateToggleableElement(toggleableState, null, rippleNodeFactory, z, role, function0);
        }
        if (rippleNodeFactory == null) {
            return new TriStateToggleableElement(toggleableState, null, null, z, role, function0);
        }
        return Modifier.Companion.$$INSTANCE.then(new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.selection.ToggleableKt$triStateToggleable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                ((Number) obj3).intValue();
                GapComposer gapComposer = (GapComposer) ((Composer) obj2);
                gapComposer.startReplaceGroup(-1525724089);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                }
                MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                Modifier modifierThen = IndicationKt.indication(Modifier.Companion.$$INSTANCE, mutableInteractionSourceImpl, rippleNodeFactory).then(new TriStateToggleableElement(toggleableState, mutableInteractionSourceImpl, null, z, role, function0));
                gapComposer.end(false);
                return modifierThen;
            }
        }));
    }
}
