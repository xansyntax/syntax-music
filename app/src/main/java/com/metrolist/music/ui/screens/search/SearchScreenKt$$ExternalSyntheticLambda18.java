package com.metrolist.music.ui.screens.search;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import com.google.common.math.IntMath;
import com.metrolist.music.constants.SearchSource;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.ui.screens.settings.integrations.ListenTogetherSettingsKt$$ExternalSyntheticLambda45;
import com.yalantis.ucrop.R;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SearchScreenKt$$ExternalSyntheticLambda18 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ SearchScreenKt$$ExternalSyntheticLambda18(MutableState mutableState, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i;
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        MutableState mutableState2 = this.f$0;
        switch (b) {
            case 0:
                Function2 function2 = (Function2) obj;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                function2.getClass();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= ((GapComposer) composer).changedInstance(function2) ? 4 : 2;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                    gapComposer.skipToGroupEnd();
                    return unit;
                }
                if (((TextFieldValue) mutableState2.getValue()).annotatedString.text.length() == 0) {
                    gapComposer.startReplaceGroup(210690200);
                    int iOrdinal = ((SearchSource) mutableState.getValue()).ordinal();
                    if (iOrdinal == 0) {
                        i = R.string.search_library;
                    } else {
                        if (iOrdinal != 1) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        i = R.string.search_yt_music;
                    }
                    String strStringResource = MathKt.stringResource(i, gapComposer);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleLarge, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, IntMath.getSp(20), null, null, null, null, 0L, 0L, null, null, 16777212), gapComposer, 0, 0, 131070);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(211588735);
                    gapComposer.end(false);
                }
                function2.invoke(gapComposer, Integer.valueOf(iIntValue & 14));
                return unit;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Start, gapComposer2, 6);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    String str = (String) mutableState2.getValue();
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged = gapComposer2.changed(mutableState2);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState2, (byte) 23);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    ScrimKt.OutlinedTextField(str, (Function1) objRememberedValue, modifierFillMaxWidth, false, false, null, AiSettingsKt.lambda$521334172, null, null, null, null, null, null, null, false, 0, 0, null, null, gapComposer2, 1573248, 0, 8388536);
                    String str2 = (String) mutableState.getValue();
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged2 = gapComposer2.changed(mutableState);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 24);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    ScrimKt.OutlinedTextField(str2, (Function1) objRememberedValue2, modifierFillMaxWidth2, false, false, null, AiSettingsKt.f579lambda$908840109, null, null, null, null, null, null, null, false, 0, 0, null, null, gapComposer2, 1573248, 0, 8388536);
                    gapComposer2.end(true);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Start, gapComposer3, 6);
                    int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    String str3 = (String) mutableState2.getValue();
                    Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged3 = gapComposer3.changed(mutableState2);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new ListenTogetherSettingsKt$$ExternalSyntheticLambda45(mutableState2, (byte) 0);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    ScrimKt.OutlinedTextField(str3, (Function1) objRememberedValue3, modifierFillMaxWidth3, false, false, null, LastFMSettingsKt.f634lambda$944673349, null, LastFMSettingsKt.lambda$1506658237, null, null, null, null, null, true, 0, 0, null, null, gapComposer3, 102236544, 12582912, 8257208);
                    String str4 = (String) mutableState.getValue();
                    Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged4 = gapComposer3.changed(mutableState);
                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new ListenTogetherSettingsKt$$ExternalSyntheticLambda45(mutableState, (byte) 1);
                        gapComposer3.updateRememberedValue(objRememberedValue4);
                    }
                    ScrimKt.OutlinedTextField(str4, (Function1) objRememberedValue4, modifierFillMaxWidth4, false, false, null, LastFMSettingsKt.f611lambda$1715606620, null, LastFMSettingsKt.lambda$371969318, null, null, null, null, null, true, 0, 0, null, null, gapComposer3, 102236544, 12582912, 8257208);
                    gapComposer3.end(true);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
        }
    }
}
