package com.metrolist.music.ui.component;

import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DialogKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ DialogKt$$ExternalSyntheticLambda0(Function1 function1, byte b) {
        this.$r8$classId = b;
        this.f$1 = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Function1 function1 = this.f$1;
        Unit unit = Unit.INSTANCE;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        byte b2 = 2;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    SurfaceKt.m337SurfaceT9BRK9s(GlassComponentsKt.m1479glassOverlay6a0pyJM(OffsetKt.m135padding3ABfNKs(companion, 24.0f), GlassComponentsKt.m1480glassShapeixp7dh8(32.0f, 16.0f, gapComposer), gapComposer), GlassComponentsKt.m1480glassShapeixp7dh8(32.0f, 16.0f, gapComposer), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-1092386692, new DialogKt$$ExternalSyntheticLambda0(function1, b2), gapComposer), gapComposer, 12607872, 104);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                ((Integer) obj2).intValue();
                return (GridItemSpan) function1.invoke((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj);
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                    Modifier modifierWindowInsetsPadding = OffsetKt.windowInsetsPadding(OffsetKt.m137paddingVpY3zN4$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 24.0f, 1), OffsetKt.imeLambda);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal, gapComposer2, 48);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierWindowInsetsPadding);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    IntMath.LazyColumn(null, null, null, null, null, null, false, null, this.f$1, gapComposer2, 0, 511);
                    gapComposer2.end(true);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
        }
    }
}
