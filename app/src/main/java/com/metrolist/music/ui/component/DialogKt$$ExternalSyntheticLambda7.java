package com.metrolist.music.ui.component;

import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda9;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DialogKt$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ Alignment.Horizontal f$1;
    public final /* synthetic */ Function2 f$2;
    public final /* synthetic */ Function2 f$3;
    public final /* synthetic */ ComposableLambdaImpl f$4;
    public final /* synthetic */ Function3 f$5;

    public /* synthetic */ DialogKt$$ExternalSyntheticLambda7(Modifier modifier, Alignment.Horizontal horizontal, Function2 function2, Function2 function3, ComposableLambdaImpl composableLambdaImpl, Function3 function4, byte b) {
        this.$r8$classId = b;
        this.f$0 = modifier;
        this.f$1 = horizontal;
        this.f$2 = function2;
        this.f$3 = function3;
        this.f$4 = composableLambdaImpl;
        this.f$5 = function4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    SurfaceKt.m337SurfaceT9BRK9s(GlassComponentsKt.m1479glassOverlay6a0pyJM(OffsetKt.m135padding3ABfNKs(companion, 24.0f), GlassComponentsKt.m1480glassShapeixp7dh8(32.0f, 16.0f, gapComposer), gapComposer), GlassComponentsKt.m1480glassShapeixp7dh8(32.0f, 16.0f, gapComposer), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(1425029102, new DialogKt$$ExternalSyntheticLambda7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (byte) 1), gapComposer), gapComposer, 12607872, 104);
                }
                break;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(this.f$0, 24.0f, 20.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, this.f$1, gapComposer2, 0);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM136paddingVpY3zN4);
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
                    Function2 function2 = this.f$2;
                    if (function2 != null) {
                        gapComposer2.startReplaceGroup(363705265);
                        Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(ColorSchemeKt.getValue(30, gapComposer2), ContentColorKt.LocalContentColor), Expect_jvmKt.rememberComposableLambda(-2071851137, new StringValuesKt$$ExternalSyntheticLambda0(function2, (byte) 7), gapComposer2), gapComposer2, 56);
                        OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 16.0f));
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(364086782);
                        gapComposer2.end(false);
                    }
                    Function2 function3 = this.f$3;
                    if (function3 != null) {
                        gapComposer2.startReplaceGroup(364142861);
                        Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(ColorSchemeKt.getValue(17, gapComposer2), ContentColorKt.LocalContentColor), Expect_jvmKt.rememberComposableLambda(782437878, new AlertDialogKt$$ExternalSyntheticLambda9(function2, function3, b2), gapComposer2), gapComposer2, 56);
                        OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 16.0f));
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(364774238);
                        gapComposer2.end(false);
                    }
                    ComposableLambdaImpl composableLambdaImpl = this.f$4;
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    composableLambdaImpl.invoke((Object) columnScopeInstance, (Object) gapComposer2, (Object) 6);
                    Function3 function4 = this.f$5;
                    if (function4 != null) {
                        gapComposer2.startReplaceGroup(364859643);
                        OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 24.0f));
                        OffsetKt.FlowRow(columnScopeInstance.align(companion, Alignment.Companion.End), null, null, null, 0, 0, Expect_jvmKt.rememberComposableLambda(-992081572, new ListItemKt$$ExternalSyntheticLambda17((byte) 5, (Object) function4), gapComposer2), gapComposer2, 1572864, 62);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(365477566);
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(true);
                }
                break;
        }
        return unit;
    }
}
