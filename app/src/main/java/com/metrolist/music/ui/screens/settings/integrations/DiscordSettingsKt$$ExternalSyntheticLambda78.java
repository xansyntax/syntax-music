package com.metrolist.music.ui.screens.settings.integrations;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowRowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.metrolist.music.discord.DiscordTemplateRenderer;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.settings.StorageSettingsKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.utils.ShowMediaInfoKt$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DiscordSettingsKt$$ExternalSyntheticLambda78 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ DiscordSettingsKt$$ExternalSyntheticLambda78(MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        MutableState mutableState = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((FlowRowScopeInstance) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    for (String str : DiscordTemplateRenderer.PLACEHOLDERS) {
                        boolean zChanged = gapComposer.changed(str);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new QueueKt$$ExternalSyntheticLambda16(str, mutableState, (byte) 27);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        ChipKt.SuggestionChip((Function0) objRememberedValue, Expect_jvmKt.rememberComposableLambda(-861651669, new ShowMediaInfoKt$$ExternalSyntheticLambda0(str, (byte) 13), gapComposer), null, false, null, null, null, null, null, null, gapComposer, 48);
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    String str2 = (String) mutableState.getValue();
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged2 = gapComposer2.changed(mutableState);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new ListenTogetherSettingsKt$$ExternalSyntheticLambda45(mutableState, (byte) 4);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    ScrimKt.OutlinedTextField(str2, (Function1) objRememberedValue2, modifierFillMaxWidth, false, false, null, LastFMSettingsKt.f602lambda$1306538129, null, LastFMSettingsKt.lambda$1799636593, Expect_jvmKt.rememberComposableLambda(-942243342, new StorageSettingsKt$$ExternalSyntheticLambda8(mutableState, (byte) 10), gapComposer2), null, null, null, null, true, 0, 0, null, null, gapComposer2, 907542912, 12582912, 8256696);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Start, gapComposer3, 6);
                    int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    String strStringResource = MathKt.stringResource(R.string.listen_together_create_room_desc, gapComposer3);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer3, 0, 0, 131066);
                    String str3 = (String) mutableState.getValue();
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged3 = gapComposer3.changed(mutableState);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new ListenTogetherSettingsKt$$ExternalSyntheticLambda45(mutableState, (byte) 3);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    ScrimKt.OutlinedTextField(str3, (Function1) objRememberedValue3, modifierFillMaxWidth2, false, false, null, LastFMSettingsKt.lambda$503333498, null, LastFMSettingsKt.f603lambda$1340302212, null, null, null, null, null, true, 0, 0, null, null, gapComposer3, 102236544, 12582912, 8257208);
                    gapComposer3.end(true);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }
}
