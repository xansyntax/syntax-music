package io.ktor.openapi;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.ui.component.shimmer.ShimmerHostKt;
import com.metrolist.music.ui.utils.AppBarKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Responses$Companion$Serializer$$ExternalSyntheticLambda2 implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ Responses$Companion$Serializer$$ExternalSyntheticLambda2(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0127  */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i;
        int i2;
        int i3;
        int i4;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                return Responses.Companion.Serializer._init_$lambda$2((Responses) obj, (Map) obj2, (Map) obj3);
            case 1:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.clear, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer2), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 3:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer3), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 4:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 5:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.listen_together_use_custom_server, gapComposer5), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 6:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.ok, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262142);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 7:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.unblock, gapComposer7), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 8:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer8), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer8, 0, 0, 262142);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 9:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(android.R.string.cancel, gapComposer9), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer9, 0, 0, 262142);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 10:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.join, gapComposer10), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer10, 0, 0, 262142);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 11:
                String str = (String) obj;
                ((Integer) obj3).getClass();
                str.getClass();
                GapComposer gapComposer11 = (GapComposer) ((Composer) obj2);
                gapComposer11.startReplaceGroup(-426923669);
                if (str.equals("idle")) {
                    i = 2043216855;
                    i2 = R.string.discord_status_idle;
                } else if (str.equals("dnd")) {
                    i = 2043219222;
                    i2 = R.string.discord_status_dnd;
                } else {
                    i = 2043221529;
                    i2 = R.string.discord_status_online;
                }
                String strM = Format$$ExternalSyntheticOutline0.m(gapComposer11, i, i2, gapComposer11, false);
                gapComposer11.end(false);
                return strM;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                String str2 = (String) obj;
                ((Integer) obj3).getClass();
                str2.getClass();
                GapComposer gapComposer12 = (GapComposer) ((Composer) obj2);
                gapComposer12.startReplaceGroup(1453680749);
                int iHashCode = str2.hashCode();
                if (iHashCode != 48) {
                    if (iHashCode != 51) {
                        if (iHashCode == 53 && str2.equals("5")) {
                            i3 = 1122835808;
                            i4 = R.string.discord_activity_competing;
                        } else {
                            i3 = 1122838368;
                            i4 = R.string.discord_activity_listening;
                        }
                    } else if (str2.equals("3")) {
                        i3 = 1122833311;
                        i4 = R.string.discord_activity_watching;
                    } else {
                        i3 = 1122838368;
                        i4 = R.string.discord_activity_listening;
                    }
                } else if (str2.equals("0")) {
                    i3 = 1122830846;
                    i4 = R.string.discord_activity_playing;
                } else {
                    i3 = 1122838368;
                    i4 = R.string.discord_activity_listening;
                }
                String strM2 = Format$$ExternalSyntheticOutline0.m(gapComposer12, i3, i4, gapComposer12, false);
                gapComposer12.end(false);
                return strM2;
            case 13:
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer11;
                if (gapComposer13.shouldExecute(iIntValue11 & 1, (iIntValue11 & 17) != 16)) {
                    FlowRowOverflow flowRowOverflow = OffsetKt.Center;
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 16.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer13, 54);
                    int iHashCode2 = Long.hashCode(gapComposer13.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer13.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer13, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer13.startReusableNode();
                    if (gapComposer13.inserting) {
                        gapComposer13.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer13.useNode();
                    }
                    Stack.m390setimpl(gapComposer13, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer13, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer13, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer13);
                    Stack.m390setimpl(gapComposer13, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    UuidKt.m1896TextPlaceholderuFdPcIQ(null, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer13, 0, 7);
                    gapComposer13.end(true);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer12;
                if (gapComposer14.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    ShimmerHostKt.ShimmerHost(null, null, null, false, AppBarKt.f638lambda$330885606, gapComposer14, 24576, 15);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
        }
    }
}
