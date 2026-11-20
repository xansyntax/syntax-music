package com.metrolist.music.ui.screens;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.google.common.math.IntMath;
import com.metrolist.music.ui.component.shimmer.ShimmerHostKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda4;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda37 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PaddingValuesImpl f$0;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda37(PaddingValuesImpl paddingValuesImpl, byte b) {
        this.$r8$classId = b;
        this.f$0 = paddingValuesImpl;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        PaddingValuesImpl paddingValuesImpl = this.f$0;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        byte b2 = 2;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, Expect_jvmKt.rememberComposableLambda(-595137493, new HomeScreenKt$$ExternalSyntheticLambda37(paddingValuesImpl, b2), gapComposer), gapComposer, 27648, 7);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, Expect_jvmKt.rememberComposableLambda(-1791513805, new HomeScreenKt$$ExternalSyntheticLambda37(paddingValuesImpl, (byte) 3), gapComposer2), gapComposer2, 24576, 15);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(companion, 16.0f, 8.0f);
                    Object objRememberedValue = gapComposer3.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new QueueKt$$ExternalSyntheticLambda4((byte) 20);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    }
                    IntMath.LazyRow(modifierM136paddingVpY3zN4, null, this.f$0, arrangement$SpacedAligned, null, null, false, null, (Function1) objRememberedValue, gapComposer3, 805330950, 490);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
            default:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer4.startReplaceGroup(637120766);
                    for (int i = 0; i < 2; i++) {
                        UuidKt.m1896TextPlaceholderuFdPcIQ(SizeKt.m155width3ABfNKs(OffsetKt.m135padding3ABfNKs(companion, 12.0f), 250.0f), 36.0f, null, gapComposer4, 54, 4);
                        Object objRememberedValue2 = gapComposer4.rememberedValue();
                        if (objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new QueueKt$$ExternalSyntheticLambda4((byte) 23);
                            gapComposer4.updateRememberedValue(objRememberedValue2);
                        }
                        GapComposer gapComposer5 = gapComposer4;
                        IntMath.LazyRow(null, null, this.f$0, null, null, null, false, null, (Function1) objRememberedValue2, gapComposer5, 805306368, 507);
                        gapComposer4 = gapComposer5;
                    }
                    gapComposer4.end(false);
                    UuidKt.m1896TextPlaceholderuFdPcIQ(SizeKt.m155width3ABfNKs(OffsetKt.m136paddingVpY3zN4(companion, 12.0f, 12.0f), 250.0f), 36.0f, null, gapComposer4, 48, 4);
                    for (int i2 = 0; i2 < 4; i2++) {
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer4, 0);
                        int iHashCode = Long.hashCode(gapComposer4.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer4, companion);
                        ComposeUiNode.Companion.getClass();
                        gapComposer4.startReusableNode();
                        if (gapComposer4.inserting) {
                            gapComposer4.createNode(LayoutNode.Constructor);
                        } else {
                            gapComposer4.useNode();
                        }
                        Stack.m390setimpl(gapComposer4, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m389reconcileimpl(gapComposer4);
                        Stack.m390setimpl(gapComposer4, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        gapComposer4.startReplaceGroup(1366836589);
                        for (int i3 = 0; i3 < 2; i3++) {
                            UuidKt.m1896TextPlaceholderuFdPcIQ(SizeKt.m155width3ABfNKs(OffsetKt.m137paddingVpY3zN4$default(companion, 12.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 200.0f), 48.0f, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f), gapComposer4, 6, 0);
                        }
                        gapComposer4.end(false);
                        gapComposer4.end(true);
                    }
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }
}
