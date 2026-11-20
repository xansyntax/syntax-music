package com.metrolist.music.ui.player;

import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.DpSize;
import coil3.util.FileSystemsKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda33 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda33(int i, long j, String str, Function0 function0, boolean z) {
        this.f$0 = str;
        this.f$1 = j;
        this.f$2 = z;
        this.f$3 = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$3;
        Object obj4 = this.f$0;
        final byte b2 = 1;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                QueueKt.m1504PlayerCoverBackground3IgeMak(Stack.updateChangedFlags(1), this.f$1, (Composer) obj, (String) obj4, (Function0) obj3, this.f$2);
                break;
            default:
                Modifier modifier = (Modifier) obj4;
                final OffsetProvider offsetProvider = (OffsetProvider) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                final byte b3 = 0;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    long j = this.f$1;
                    boolean z = this.f$2;
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (j == 9205357640488583168L) {
                        gapComposer.startReplaceGroup(4389176);
                        boolean zChangedInstance = gapComposer.changedInstance(offsetProvider);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b4 = b2;
                                    OffsetProvider offsetProvider2 = offsetProvider;
                                    switch (b4) {
                                        case 0:
                                            return Boolean.valueOf((9223372034707292159L & offsetProvider2.mo194provideF1C5BW0()) != 9205357640488583168L);
                                        default:
                                            return Boolean.valueOf((9223372034707292159L & offsetProvider2.mo194provideF1C5BW0()) != 9205357640488583168L);
                                    }
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        FileSystemsKt.SelectionHandleIcon(0, gapComposer, modifier, (Function0) objRememberedValue, z);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(3458246);
                        Arrangement$End$1 arrangement$End$1 = z ? OffsetKt.Right : OffsetKt.Left;
                        Modifier modifierThen = modifier.then(new SizeElement(DpSize.m802getWidthD9Ej5fM(j), (12 & 2) != 0 ? Float.NaN : DpSize.m801getHeightD9Ej5fM(j), (12 & 4) != 0 ? Float.NaN : CropImageView.DEFAULT_ASPECT_RATIO, (12 & 8) != 0 ? Float.NaN : CropImageView.DEFAULT_ASPECT_RATIO, false));
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, Alignment.Companion.Top, gapComposer, 0);
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
                        Stack.m390setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m389reconcileimpl(gapComposer);
                        Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        boolean zChangedInstance2 = gapComposer.changedInstance(offsetProvider);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new Function0() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b4 = b3;
                                    OffsetProvider offsetProvider2 = offsetProvider;
                                    switch (b4) {
                                        case 0:
                                            return Boolean.valueOf((9223372034707292159L & offsetProvider2.mo194provideF1C5BW0()) != 9205357640488583168L);
                                        default:
                                            return Boolean.valueOf((9223372034707292159L & offsetProvider2.mo194provideF1C5BW0()) != 9205357640488583168L);
                                    }
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        FileSystemsKt.SelectionHandleIcon(6, gapComposer, Modifier.Companion.$$INSTANCE, (Function0) objRememberedValue2, z);
                        gapComposer.end(true);
                        gapComposer.end(false);
                    }
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda33(long j, boolean z, Modifier modifier, OffsetProvider offsetProvider) {
        this.f$1 = j;
        this.f$2 = z;
        this.f$0 = modifier;
        this.f$3 = offsetProvider;
    }
}
