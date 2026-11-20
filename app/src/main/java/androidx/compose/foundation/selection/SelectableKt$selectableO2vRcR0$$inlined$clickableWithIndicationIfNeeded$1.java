package androidx.compose.foundation.selection;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: androidx.compose.foundation.selection.SelectableKt$selectable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SelectableKt$selectableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1 implements Function3 {
    public final /* synthetic */ boolean $enabled$inlined;
    public final /* synthetic */ IndicationNodeFactory $indication;
    public final /* synthetic */ Function $onClick$inlined;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Role $role$inlined;
    public final /* synthetic */ boolean $selected$inlined;

    public /* synthetic */ SelectableKt$selectableO2vRcR0$$inlined$clickableWithIndicationIfNeeded$1(IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, Role role, Function function, byte b) {
        this.$r8$classId = b;
        this.$indication = indicationNodeFactory;
        this.$selected$inlined = z;
        this.$enabled$inlined = z2;
        this.$role$inlined = role;
        this.$onClick$inlined = function;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Function function = this.$onClick$inlined;
        IndicationNodeFactory indicationNodeFactory = this.$indication;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        switch (b) {
            case 0:
                ((Number) obj3).intValue();
                GapComposer gapComposer = (GapComposer) ((Composer) obj2);
                gapComposer.startReplaceGroup(-1525724089);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
                }
                MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                Modifier modifierThen = IndicationKt.indication(companion, mutableInteractionSourceImpl, indicationNodeFactory).then(new SelectableElement(this.$selected$inlined, mutableInteractionSourceImpl, null, this.$enabled$inlined, this.$role$inlined, (Function0) function));
                gapComposer.end(false);
                return modifierThen;
            default:
                ((Number) obj3).intValue();
                GapComposer gapComposer2 = (GapComposer) ((Composer) obj2);
                gapComposer2.startReplaceGroup(-1525724089);
                Object objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer2);
                }
                MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue2;
                Modifier modifierThen2 = IndicationKt.indication(companion, mutableInteractionSourceImpl2, indicationNodeFactory).then(new ToggleableElement(this.$selected$inlined, mutableInteractionSourceImpl2, null, this.$enabled$inlined, this.$role$inlined, (Function1) function));
                gapComposer2.end(false);
                return modifierThen2;
        }
    }
}
