package com.metrolist.music.ui.component;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.music.constants.DimensionsKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda44 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ YTItem f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ boolean f$5;

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda44(YTItem yTItem, boolean z, Modifier modifier, boolean z2, boolean z3, int i) {
        this.f$2 = yTItem;
        this.f$1 = z;
        this.f$0 = modifier;
        this.f$3 = z2;
        this.f$5 = z3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        GapComposer gapComposer;
        long j;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                Integer num = (Integer) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer;
                if (!gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    boolean z = this.f$1;
                    if (num != null) {
                        gapComposer2.startReplaceGroup(175852163);
                        String strValueOf = String.valueOf(num.intValue());
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.labelSmall;
                        if (z) {
                            gapComposer2.startReplaceGroup(698415747);
                            j = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary;
                        } else {
                            gapComposer2.startReplaceGroup(698417004);
                            j = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant;
                        }
                        gapComposer2.end(false);
                        TextKt.m352TextNvy7gAk(strValueOf, SizeKt.m155width3ABfNKs(companion, 22.0f), j, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer2, 48, 0, 131064);
                        gapComposer = gapComposer2;
                        gapComposer.end(false);
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.startReplaceGroup(176215142);
                        gapComposer.end(false);
                    }
                    String thumbnail = this.f$2.getThumbnail();
                    SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                    MenuKt.ItemThumbnail(thumbnail, z, this.f$3, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(10.0f), SizeKt.m151size3ABfNKs(companion, 48.0f), null, this.f$5, CropImageView.DEFAULT_ASPECT_RATIO, 168, gapComposer, 100663296, 128);
                    gapComposer.end(true);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                MenuKt.SpeedDialGridItem(this.f$2, this.f$1, (Modifier) obj3, this.f$3, this.f$5, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda44(Integer num, boolean z, YTItem yTItem, boolean z2, boolean z3) {
        this.f$0 = num;
        this.f$1 = z;
        this.f$2 = yTItem;
        this.f$3 = z2;
        this.f$5 = z3;
    }
}
