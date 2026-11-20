package com.metrolist.music.ui.player;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MiniPlayerKt$$ExternalSyntheticLambda21 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ State f$3;

    public /* synthetic */ MiniPlayerKt$$ExternalSyntheticLambda21(boolean z, int i, boolean z2, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = i;
        this.f$2 = z2;
        this.f$3 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i;
        int i2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        State state = this.f$3;
        boolean z = this.f$2;
        int i3 = this.f$1;
        boolean z2 = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    if (z2) {
                        i = ((Boolean) state.getValue()).booleanValue() ? R.drawable.volume_off : R.drawable.volume_up;
                    } else if (i3 == 4) {
                        i = R.drawable.replay;
                    } else {
                        i = z ? R.drawable.pause : R.drawable.play;
                    }
                    Modifier modifierM1481glassTintedFNF3uiM = GlassComponentsKt.m1481glassTintedFNF3uiM(SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 38.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(19.0f, 12.0f, gapComposer)), gapComposer);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM1481glassTintedFNF3uiM);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    Integer numValueOf = Integer.valueOf(i);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new SongMenuKt$$ExternalSyntheticLambda16((byte) 22);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CrossfadeKt.AnimatedContent(numValueOf, null, (Function1) objRememberedValue, null, "miniPlayGlyph", null, QueueKt.lambda$307408888, gapComposer, 1597824, 42);
                    gapComposer.end(true);
                }
                break;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    if (z2) {
                        i2 = ((Boolean) state.getValue()).booleanValue() ? R.drawable.volume_off : R.drawable.volume_up;
                    } else if (i3 == 4) {
                        i2 = R.drawable.replay;
                    } else {
                        i2 = z ? R.drawable.pause : R.drawable.play;
                    }
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(i2, 0, gapComposer2), (String) null, (Modifier) null, 0L, gapComposer2, 56, 12);
                }
                break;
        }
        return unit;
    }
}
