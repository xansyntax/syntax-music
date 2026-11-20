package com.metrolist.music.ui.component;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SegmentedButtonDefaults;
import androidx.compose.material3.SingleChoiceSegmentedButtonScopeWrapper;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.compose.AsyncImageKt;
import com.google.common.math.IntMath;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda65;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.viewmodels.BackupPreviewInfo;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
        this.f$2 = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0;
        boolean z;
        boolean z2;
        boolean z3;
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$2;
        MutableState mutableState2 = this.f$1;
        MutableState mutableState3 = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                byte b2 = 1;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    ScrimKt.m320SingleChoiceSegmentedButtonRowuFdPcIQ(OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 8.0f), CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(68078209, new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9(mutableState3, mutableState2, mutableState, b2), gapComposer), gapComposer, 390);
                }
                break;
            case 1:
                SingleChoiceSegmentedButtonScopeWrapper singleChoiceSegmentedButtonScopeWrapper = (SingleChoiceSegmentedButtonScopeWrapper) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                singleChoiceSegmentedButtonScopeWrapper.getClass();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= ((GapComposer) composer2).changed(singleChoiceSegmentedButtonScopeWrapper) ? 4 : 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    boolean zAreEqual = Intrinsics.areEqual((String) mutableState3.getValue(), "daily");
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new MainActivity$$ExternalSyntheticLambda29(mutableState3, (byte) 22);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    SegmentedButtonDefaults segmentedButtonDefaults = SegmentedButtonDefaults.INSTANCE;
                    int i2 = (iIntValue2 & 14) | 384;
                    ScrimKt.SegmentedButton(singleChoiceSegmentedButtonScopeWrapper, zAreEqual, function0, SegmentedButtonDefaults.itemShape(0, gapComposer2), null, false, null, null, null, null, DialogKt.lambda$1743127747, gapComposer2, i2);
                    boolean zAreEqual2 = Intrinsics.areEqual((String) mutableState3.getValue(), "weekdays_weekends");
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        i = 1;
                        objRememberedValue2 = new PlayerMenuKt$$ExternalSyntheticLambda65(mutableState3, mutableState2, mutableState, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        i = 1;
                    }
                    ScrimKt.SegmentedButton(singleChoiceSegmentedButtonScopeWrapper, zAreEqual2, (Function0) objRememberedValue2, SegmentedButtonDefaults.itemShape(i, gapComposer2), null, false, null, null, null, null, DialogKt.f19lambda$1382044806, gapComposer2, i2);
                    boolean zAreEqual3 = Intrinsics.areEqual((String) mutableState3.getValue(), "custom");
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new MainActivity$$ExternalSyntheticLambda29(mutableState3, (byte) 23);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    ScrimKt.SegmentedButton(singleChoiceSegmentedButtonScopeWrapper, zAreEqual3, (Function0) objRememberedValue3, SegmentedButtonDefaults.itemShape(2, gapComposer2), null, false, null, null, null, null, DialogKt.lambda$1421683131, gapComposer2, i2);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    CardKt.OutlinedCard(OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 4.0f), null, null, null, null, Expect_jvmKt.rememberComposableLambda(285072633, new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9(mutableState3, mutableState2, mutableState, (byte) 3), gapComposer3), gapComposer3, 196614, 30);
                }
                break;
            case 3:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(1 & iIntValue4, (iIntValue4 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    String str = (String) mutableState3.getValue();
                    String str2 = (String) mutableState2.getValue();
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new MainActivity$$ExternalSyntheticLambda29(mutableState, (byte) 26);
                        gapComposer4.updateRememberedValue(objRememberedValue4);
                    }
                    Function0 function1 = (Function0) objRememberedValue4;
                    Object objRememberedValue5 = gapComposer4.rememberedValue();
                    if (objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new MainActivity$$ExternalSyntheticLambda29(mutableState, (byte) 27);
                        gapComposer4.updateRememberedValue(objRememberedValue5);
                    }
                    SettingsSleepTimerDialogKt.TimeRangeRow(str, str2, function1, (Function0) objRememberedValue5, null, gapComposer4, 3456, 16);
                }
                break;
            case 4:
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    String str3 = (String) mutableState3.getValue();
                    String str4 = (String) mutableState2.getValue();
                    Object objRememberedValue6 = gapComposer5.rememberedValue();
                    if (objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState, (byte) 1);
                        gapComposer5.updateRememberedValue(objRememberedValue6);
                    }
                    Function0 function2 = (Function0) objRememberedValue6;
                    Object objRememberedValue7 = gapComposer5.rememberedValue();
                    if (objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState, (byte) 2);
                        gapComposer5.updateRememberedValue(objRememberedValue7);
                    }
                    SettingsSleepTimerDialogKt.TimeRangeRow(str3, str4, function2, (Function0) objRememberedValue7, OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 7), gapComposer5, 28032, 0);
                }
                break;
            case 5:
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(1 & iIntValue6, (iIntValue6 & 17) != 16)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    String str5 = (String) mutableState3.getValue();
                    String str6 = (String) mutableState2.getValue();
                    Object objRememberedValue8 = gapComposer6.rememberedValue();
                    if (objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new MainActivity$$ExternalSyntheticLambda29(mutableState, (byte) 28);
                        gapComposer6.updateRememberedValue(objRememberedValue8);
                    }
                    Function0 function3 = (Function0) objRememberedValue8;
                    Object objRememberedValue9 = gapComposer6.rememberedValue();
                    if (objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new MainActivity$$ExternalSyntheticLambda29(mutableState, (byte) 29);
                        gapComposer6.updateRememberedValue(objRememberedValue9);
                    }
                    SettingsSleepTimerDialogKt.TimeRangeRow(str5, str6, function3, (Function0) objRememberedValue9, OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 7), gapComposer6, 28032, 0);
                }
                break;
            case 6:
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(1 & iIntValue7, (iIntValue7 & 17) != 16)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    Object objRememberedValue10 = gapComposer7.rememberedValue();
                    if (objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = new PlayerMenuKt$$ExternalSyntheticLambda65(mutableState3, mutableState2, mutableState, (byte) 2);
                        gapComposer7.updateRememberedValue(objRememberedValue10);
                    }
                    CardKt.TextButton((Function0) objRememberedValue10, null, false, null, null, null, LibraryScreenKt.f374lambda$1928926927, gapComposer7, 805306374, 510);
                }
                break;
            case 7:
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(1 & iIntValue8, (iIntValue8 & 17) != 16)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    Object objRememberedValue11 = gapComposer8.rememberedValue();
                    if (objRememberedValue11 == neverEqualPolicy) {
                        objRememberedValue11 = new PlayerMenuKt$$ExternalSyntheticLambda65(mutableState3, mutableState2, mutableState, (byte) 4);
                        gapComposer8.updateRememberedValue(objRememberedValue11);
                    }
                    CardKt.TextButton((Function0) objRememberedValue11, null, false, null, null, null, TopPlaylistScreenKt.f405lambda$842704500, gapComposer8, 805306374, 510);
                }
                break;
            case 8:
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.restore_confirm_message, gapComposer9), null, CardKt.getColorScheme(gapComposer9).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer9).bodyMedium, gapComposer9, 0, 0, 131066);
                    BackupPreviewInfo backupPreviewInfo = (BackupPreviewInfo) mutableState3.getValue();
                    if ((backupPreviewInfo != null ? backupPreviewInfo.accountName : null) != null) {
                        gapComposer9.startReplaceGroup(664159025);
                        OffsetKt.Spacer(gapComposer9, SizeKt.m145height3ABfNKs(companion, 16.0f));
                        TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.restore_account_warning, gapComposer9), null, CardKt.getColorScheme(gapComposer9).onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer9).titleSmall, gapComposer9, 0, 0, 131066);
                        gapComposer9.end(false);
                    } else {
                        gapComposer9.startReplaceGroup(664466545);
                        gapComposer9.end(false);
                    }
                    boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetModifier;
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda4 = ComposeUiNode.Companion.SetMeasurePolicy;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (zBooleanValue) {
                        gapComposer9.startReplaceGroup(664582361);
                        OffsetKt.Spacer(gapComposer9, SizeKt.m145height3ABfNKs(companion, 16.0f));
                        CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, CardKt.getColorScheme(gapComposer9).outlineVariant, gapComposer9, 0, 3);
                        OffsetKt.Spacer(gapComposer9, SizeKt.m145height3ABfNKs(companion, 16.0f));
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer9, 48);
                        int iHashCode = Long.hashCode(gapComposer9.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer9.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer9, modifierFillMaxWidth);
                        ComposeUiNode.Companion.getClass();
                        gapComposer9.startReusableNode();
                        if (gapComposer9.inserting) {
                            gapComposer9.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer9.useNode();
                        }
                        Stack.m390setimpl(gapComposer9, rowMeasurePolicy, updater$$ExternalSyntheticLambda4);
                        Stack.m390setimpl(gapComposer9, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda3);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode, gapComposer9, updater$$ExternalSyntheticLambda2, gapComposer9);
                        updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda1;
                        Stack.m390setimpl(gapComposer9, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                        DialogKt.m1464CircularProgressIndicatorLxG7B9w(2.0f, 0, 390, 26, 0L, 0L, gapComposer9, SizeKt.m151size3ABfNKs(companion, 24.0f));
                        gapComposer9 = gapComposer9;
                        OffsetKt.Spacer(gapComposer9, SizeKt.m151size3ABfNKs(companion, 16.0f));
                        TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.checking_previous_account, gapComposer9), null, CardKt.getColorScheme(gapComposer9).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer9).bodyMedium, gapComposer9, 0, 0, 131066);
                        gapComposer9.end(true);
                        OffsetKt.Spacer(gapComposer9, SizeKt.m145height3ABfNKs(companion, 16.0f));
                        CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, CardKt.getColorScheme(gapComposer9).outlineVariant, gapComposer9, 0, 3);
                        gapComposer9.end(false);
                    } else {
                        updater$$ExternalSyntheticLambda0 = updater$$ExternalSyntheticLambda1;
                        gapComposer9.startReplaceGroup(665589489);
                        gapComposer9.end(false);
                    }
                    BackupPreviewInfo backupPreviewInfo2 = (BackupPreviewInfo) mutableState3.getValue();
                    boolean z4 = backupPreviewInfo2 != null && (!(z3 = backupPreviewInfo2.hasAuthData) || (z3 && backupPreviewInfo2.accountName == null && !((Boolean) mutableState2.getValue()).booleanValue()));
                    if (((Boolean) mutableState2.getValue()).booleanValue() || !(((Boolean) mutableState.getValue()).booleanValue() || z4)) {
                        z = false;
                        gapComposer9.startReplaceGroup(666556689);
                        gapComposer9.end(false);
                    } else {
                        gapComposer9.startReplaceGroup(665974323);
                        OffsetKt.Spacer(gapComposer9, SizeKt.m145height3ABfNKs(companion, 16.0f));
                        CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, CardKt.getColorScheme(gapComposer9).outlineVariant, gapComposer9, 0, 3);
                        TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m$1(companion, 16.0f, gapComposer9, R.string.no_account_found, gapComposer9), null, CardKt.getColorScheme(gapComposer9).onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer9).bodyMedium, gapComposer9, 0, 0, 131066);
                        OffsetKt.Spacer(gapComposer9, SizeKt.m145height3ABfNKs(companion, 16.0f));
                        CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, CardKt.getColorScheme(gapComposer9).outlineVariant, gapComposer9, 0, 3);
                        z = false;
                        gapComposer9.end(false);
                    }
                    BackupPreviewInfo backupPreviewInfo3 = (BackupPreviewInfo) mutableState3.getValue();
                    if (backupPreviewInfo3 != null) {
                        String str7 = backupPreviewInfo3.accountName;
                        gapComposer9.startReplaceGroup(666758716);
                        if (((Boolean) mutableState2.getValue()).booleanValue() || !backupPreviewInfo3.hasAuthData || str7 == null) {
                            z2 = false;
                            gapComposer9.startReplaceGroup(1980753120);
                            gapComposer9.end(false);
                        } else {
                            gapComposer9.startReplaceGroup(1978395787);
                            OffsetKt.Spacer(gapComposer9, SizeKt.m145height3ABfNKs(companion, 16.0f));
                            CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, CardKt.getColorScheme(gapComposer9).outlineVariant, gapComposer9, 0, 3);
                            OffsetKt.Spacer(gapComposer9, SizeKt.m145height3ABfNKs(companion, 16.0f));
                            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer9, 48);
                            int iHashCode2 = Long.hashCode(gapComposer9.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer9.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer9, modifierFillMaxWidth2);
                            ComposeUiNode.Companion.getClass();
                            gapComposer9.startReusableNode();
                            if (gapComposer9.inserting) {
                                gapComposer9.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer9.useNode();
                            }
                            Stack.m390setimpl(gapComposer9, rowMeasurePolicy2, updater$$ExternalSyntheticLambda4);
                            Stack.m390setimpl(gapComposer9, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda3);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer9, updater$$ExternalSyntheticLambda2, gapComposer9);
                            Stack.m390setimpl(gapComposer9, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                            if (backupPreviewInfo3.accountImageUrl != null) {
                                gapComposer9.startReplaceGroup(1964649719);
                                AsyncImageKt.m849AsyncImage10Xjiaw(backupPreviewInfo3.accountImageUrl, ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 40.0f), RoundedCornerShapeKt.CircleShape), ContentScale.Companion.Crop, gapComposer9, 1572912, 1976);
                                gapComposer9.end(false);
                            } else {
                                gapComposer9.startReplaceGroup(1965151516);
                                Modifier modifierM39backgroundbw27NRU = ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 40.0f), RoundedCornerShapeKt.CircleShape), CardKt.getColorScheme(gapComposer9).secondaryContainer, ColorKt.RectangleShape);
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                                int iHashCode3 = Long.hashCode(gapComposer9.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer9.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer9, modifierM39backgroundbw27NRU);
                                gapComposer9.startReusableNode();
                                if (gapComposer9.inserting) {
                                    gapComposer9.createNode(textKt$$ExternalSyntheticLambda3);
                                } else {
                                    gapComposer9.useNode();
                                }
                                Stack.m390setimpl(gapComposer9, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda4);
                                Stack.m390setimpl(gapComposer9, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda3);
                                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer9, updater$$ExternalSyntheticLambda2, gapComposer9);
                                Stack.m390setimpl(gapComposer9, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                                IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.person, 0, gapComposer9), (String) null, SizeKt.m151size3ABfNKs(companion, 24.0f), CardKt.getColorScheme(gapComposer9).onSecondaryContainer, gapComposer9, 440, 0);
                                gapComposer9.end(true);
                                gapComposer9.end(false);
                            }
                            OffsetKt.Spacer(gapComposer9, SizeKt.m151size3ABfNKs(companion, 16.0f));
                            String str8 = backupPreviewInfo3.accountEmail;
                            TextKt.m352TextNvy7gAk(str8 == null ? str7 : str8, null, CardKt.getColorScheme(gapComposer9).onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer9).bodyLarge, gapComposer9, 0, 0, 131066);
                            gapComposer9.end(true);
                            OffsetKt.Spacer(gapComposer9, SizeKt.m145height3ABfNKs(companion, 16.0f));
                            CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, CardKt.getColorScheme(gapComposer9).outlineVariant, gapComposer9, 0, 3);
                            z2 = false;
                            gapComposer9.end(false);
                        }
                        gapComposer9.end(z2);
                    } else {
                        gapComposer9.startReplaceGroup(666758715);
                        gapComposer9.end(z);
                    }
                }
                break;
            default:
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (!gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    gapComposer10.skipToGroupEnd();
                } else {
                    boolean zChanged = gapComposer10.changed(mutableState3) | gapComposer10.changed(mutableState2);
                    Object objRememberedValue12 = gapComposer10.rememberedValue();
                    if (zChanged || objRememberedValue12 == neverEqualPolicy) {
                        objRememberedValue12 = new TooltipKt$$ExternalSyntheticLambda2(mutableState3, mutableState2, (byte) 19);
                        gapComposer10.updateRememberedValue(objRememberedValue12);
                    }
                    CardKt.TextButton((Function0) objRememberedValue12, null, false, null, null, null, LastFMSettingsKt.lambda$1945138736, gapComposer10, 805306368, 510);
                    OffsetKt.Spacer(gapComposer10, SizeKt.m155width3ABfNKs(companion, 8.0f));
                    boolean zChanged2 = gapComposer10.changed(mutableState3) | gapComposer10.changed(mutableState) | gapComposer10.changed(mutableState2);
                    Object objRememberedValue13 = gapComposer10.rememberedValue();
                    if (zChanged2 || objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new PlayerMenuKt$$ExternalSyntheticLambda65(mutableState, mutableState3, mutableState2, (byte) 8);
                        gapComposer10.updateRememberedValue(objRememberedValue13);
                    }
                    CardKt.Button((Function0) objRememberedValue13, null, false, null, null, null, null, null, null, LastFMSettingsKt.f609lambda$1509905053, gapComposer10, 805306368, 510);
                }
                break;
        }
        return unit;
    }
}
