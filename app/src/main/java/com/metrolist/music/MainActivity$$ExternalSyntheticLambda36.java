package com.metrolist.music;

import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.ui.menu.YouTubeSongMenuKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda36 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SongItem f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda36(SongItem songItem, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = songItem;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        MutableState mutableState = this.f$1;
        byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i = MainActivity.$r8$clinit;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    SurfaceKt.m337SurfaceT9BRK9s(OffsetKt.m135padding3ABfNKs(companion, 24.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f), ColorSchemeKt.getValue(37, gapComposer), 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-295574406, new MainActivity$$ExternalSyntheticLambda36(this.f$0, mutableState, b2), gapComposer), gapComposer, 12582918, 104);
                }
                break;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                int i2 = MainActivity.$r8$clinit;
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer2, 48);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
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
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new MainActivity$$ExternalSyntheticLambda29(mutableState, (byte) 13);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    YouTubeSongMenuKt.YouTubeSongMenu(this.f$0, (Function0) objRememberedValue, null, gapComposer2, 48, 4);
                    gapComposer2.end(true);
                }
                break;
        }
        return unit;
    }
}
