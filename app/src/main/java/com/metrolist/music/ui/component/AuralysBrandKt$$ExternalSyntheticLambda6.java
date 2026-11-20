package com.metrolist.music.ui.component;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.DpSize;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AuralysBrandKt$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ AuralysBrandKt$$ExternalSyntheticLambda6(int i, long j, Modifier modifier) {
        this.f$0 = modifier;
        this.f$1 = j;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        long j = this.f$1;
        Composer composer = (Composer) obj;
        Integer num = (Integer) obj2;
        switch (b) {
            case 0:
                num.getClass();
                DialogKt.m1468LoadingIndicatoriJQMabo(Stack.updateChangedFlags(7), j, composer, this.f$0);
                break;
            default:
                int iIntValue = num.intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Modifier modifier = this.f$0;
                    if (j == 9205357640488583168L) {
                        gapComposer.startReplaceGroup(-1243644858);
                        BasicTextKt.DefaultCursorHandle(modifier, gapComposer, 0, 0);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-1244013944);
                        Modifier modifierThen = modifier.then(new SizeElement(DpSize.m802getWidthD9Ej5fM(j), (12 & 2) != 0 ? Float.NaN : DpSize.m801getHeightD9Ej5fM(j), (12 & 4) != 0 ? Float.NaN : CropImageView.DEFAULT_ASPECT_RATIO, (12 & 8) != 0 ? Float.NaN : CropImageView.DEFAULT_ASPECT_RATIO, false));
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopCenter, false);
                        int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
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
                        BasicTextKt.DefaultCursorHandle(null, gapComposer, 0, 1);
                        gapComposer.end(true);
                        gapComposer.end(false);
                    }
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ AuralysBrandKt$$ExternalSyntheticLambda6(long j, Modifier modifier) {
        this.f$1 = j;
        this.f$0 = modifier;
    }
}
