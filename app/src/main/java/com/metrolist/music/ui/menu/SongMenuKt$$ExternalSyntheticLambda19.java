package com.metrolist.music.ui.menu;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.YouTubeAccount;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda19 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda19(MutableState mutableState, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        MutableState mutableState;
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState2 = this.f$1;
        MutableState mutableState3 = this.f$0;
        switch (b) {
            case 0:
                int iIntValue = ((Integer) obj).intValue();
                TextFieldValue textFieldValue = (TextFieldValue) obj2;
                textFieldValue.getClass();
                if (iIntValue == 0) {
                    mutableState3.setValue(textFieldValue);
                } else {
                    mutableState2.setValue(textFieldValue);
                }
                break;
            case 1:
                String str = (String) obj;
                Boolean bool = (Boolean) obj2;
                bool.booleanValue();
                str.getClass();
                mutableState3.setValue(str);
                mutableState2.setValue(bool);
                break;
            case 2:
                Composer composer = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierM147heightInVpY3zN4$default = SizeKt.m147heightInVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, 1);
                    Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
                    BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer, 0);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM147heightInVpY3zN4$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    boolean z = gapComposer.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    String strStringResource = MathKt.stringResource(R.string.choose_youtube_channel_description, gapComposer);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    MutableState mutableState4 = mutableState2;
                    TextKt.m352TextNvy7gAk(strStringResource, null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer, 0, 0, 131066);
                    OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 16.0f));
                    Modifier modifierScroll$default = ImageKt.scroll$default(SizeKt.fillMaxWidth(companion, 1.0f), ImageKt.rememberScrollState(gapComposer), true);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer, 0);
                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierScroll$default);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    gapComposer.startReplaceGroup(1182467838);
                    for (YouTubeAccount youTubeAccount : (List) mutableState3.getValue()) {
                        boolean zAreEqual = Intrinsics.areEqual(youTubeAccount, (YouTubeAccount) mutableState4.getValue());
                        boolean zChangedInstance = gapComposer.changedInstance(youTubeAccount);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                            mutableState = mutableState4;
                            objRememberedValue = new QueueKt$$ExternalSyntheticLambda16(youTubeAccount, mutableState, (byte) 9);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        } else {
                            mutableState = mutableState4;
                        }
                        AlbumScreenKt.YouTubeAccountPickerItem(youTubeAccount, zAreEqual, (Function0) objRememberedValue, gapComposer, 0);
                        OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 8.0f));
                        mutableState4 = mutableState;
                    }
                    Fragment$5$$ExternalSyntheticOutline0.m(gapComposer, false, true, true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 3:
                Composer composer2 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda2(mutableState3, mutableState2, (byte) 7);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.Button((Function0) objRememberedValue2, null, false, null, null, null, null, null, null, AlbumScreenKt.lambda$1772293205, gapComposer2, 805306374, 510);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 4:
                Composer composer3 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new TooltipKt$$ExternalSyntheticLambda2(mutableState3, mutableState2, (byte) 18);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, AiSettingsKt.lambda$987003673, gapComposer3, 805306374, 510);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
            case 5:
                Composer composer4 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else if (((Boolean) mutableState3.getValue()).booleanValue()) {
                    gapComposer4.startReplaceGroup(1436497619);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.checking_for_updates, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                    gapComposer4.end(false);
                } else if (((String) mutableState2.getValue()) != null) {
                    gapComposer4.startReplaceGroup(1436644993);
                    String str2 = (String) mutableState2.getValue();
                    str2.getClass();
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.latest_version_format, new Object[]{str2}, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                    gapComposer4.end(false);
                } else {
                    gapComposer4.startReplaceGroup(1436782447);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.check_for_updates_button, gapComposer4), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                    gapComposer4.end(false);
                }
                break;
            default:
                Composer composer5 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else if (((Boolean) mutableState3.getValue()).booleanValue()) {
                    gapComposer5.startReplaceGroup(-1004955738);
                    DialogKt.m1464CircularProgressIndicatorLxG7B9w(2.0f, 0, 390, 26, 0L, 0L, gapComposer5, OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 11));
                    gapComposer5.end(false);
                } else if (((Boolean) mutableState2.getValue()).booleanValue()) {
                    gapComposer5.startReplaceGroup(-1004669515);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.download, 0, gapComposer5), MathKt.stringResource(R.string.update_available_title, gapComposer5), (Modifier) null, ((MaterialTheme$Values) gapComposer5.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary, gapComposer5, 8, 4);
                    gapComposer5.end(false);
                } else {
                    gapComposer5.startReplaceGroup(-1004312984);
                    gapComposer5.end(false);
                }
                break;
        }
        return unit;
    }
}
