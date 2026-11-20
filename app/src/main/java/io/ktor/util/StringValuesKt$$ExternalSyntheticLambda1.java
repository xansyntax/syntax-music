package io.ktor.util;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SegmentedButtonDefaults;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.navigation.NavHostController;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.YouTubeAccount;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.lyrics.LyricsUtils$$ExternalSyntheticLambda0;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda120;
import com.metrolist.music.ui.player.QueueKt;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt;
import com.metrolist.music.ui.screens.equalizer.wizard.EQProfileVariant;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt;
import com.metrolist.music.ui.screens.settings.ContentSettingsKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.screens.settings.ThemePalette;
import com.metrolist.music.ui.screens.settings.ThemeScreenKt;
import com.metrolist.music.ui.theme.ThemeKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StringValuesKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ StringValuesKt$$ExternalSyntheticLambda1(ColorScheme colorScheme, boolean z, ComposableLambdaImpl composableLambdaImpl) {
        this.$r8$classId = (byte) 14;
        this.f$1 = colorScheme;
        this.f$0 = z;
        this.f$2 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean z;
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        byte b2 = 6;
        boolean z2 = this.f$0;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        switch (b) {
            case 0:
                return StringValuesKt.appendFiltered$lambda$0(z2, (StringValuesBuilder) obj4, (Function2) obj3, (String) obj, (List) obj2);
            case 1:
                ((Integer) obj2).getClass();
                ((TextFieldDefaults) obj4).TrailingIcon(z2, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(385));
                return unit;
            case 2:
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj4;
                ComposableLambdaImpl composableLambdaImpl2 = (ComposableLambdaImpl) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    boolean z3 = this.f$0;
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SizeKt.m154sizeInqDBjuR0$default(companion, z3 ? 80.0f : 56.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), z3 ? 16.0f : 0.0f, CropImageView.DEFAULT_ASPECT_RATIO, z3 ? 20.0f : 0.0f, CropImageView.DEFAULT_ASPECT_RATIO, 10);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(z3 ? OffsetKt.Start : OffsetKt.Center, Alignment.Companion.CenterVertically, gapComposer, 48);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM139paddingqDBjuR0$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    composableLambdaImpl.invoke((Object) gapComposer, (Object) 0);
                    EnterTransitionImpl enterTransitionImplFadeIn$default = EnterExitTransitionKt.fadeIn$default(CardKt.m272valueyDoVZcs(3, gapComposer), CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs = CardKt.m272valueyDoVZcs(1, gapComposer);
                    BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
                    CrossfadeKt.AnimatedVisibility(z3, null, enterTransitionImplFadeIn$default.plus(EnterExitTransitionKt.expandHorizontally$default(finiteAnimationSpecM272valueyDoVZcs, horizontal, 12)), EnterExitTransitionKt.fadeOut$default(CardKt.m272valueyDoVZcs(4, gapComposer), CropImageView.DEFAULT_ASPECT_RATIO, 2).plus(EnterExitTransitionKt.shrinkHorizontally$default(CardKt.m272valueyDoVZcs(0, gapComposer), horizontal, 12)), null, Expect_jvmKt.rememberComposableLambda(-660008666, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl2, (byte) 1), gapComposer), gapComposer, 1572870);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 3:
                ((Integer) obj2).getClass();
                ((SegmentedButtonDefaults) obj4).Icon(z2, (Function2) obj3, (Composer) obj, Stack.updateChangedFlags(3073));
                return unit;
            case 4:
                HapticFeedback hapticFeedback = (HapticFeedback) obj4;
                Function1 function1 = (Function1) obj3;
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                float fFloatValue = ((Float) obj2).floatValue();
                pointerInputChange.getClass();
                pointerInputChange.consume();
                if (fFloatValue > 4.0f && !z2) {
                    ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(6);
                    if (function1 != null) {
                        function1.invoke(Boolean.TRUE);
                    }
                } else if (fFloatValue < -4.0f && z2) {
                    ((PlatformHapticFeedback) hapticFeedback).m578performHapticFeedbackCdsT49E(6);
                    if (function1 != null) {
                        function1.invoke(Boolean.FALSE);
                    }
                }
                return unit;
            case 5:
                ((Integer) obj2).getClass();
                MenuKt.RandomizeGridItem(Stack.updateChangedFlags(1), (Composer) obj, (Modifier) obj3, (Function0) obj4, z2);
                return unit;
            case 6:
                Listentogether.RoomState roomState = (Listentogether.RoomState) obj4;
                Context context = (Context) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 16.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer2, 48);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    String strStringResource = MathKt.stringResource(R.string.room_code, gapComposer2);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    androidx.compose.material3.TextKt.m352TextNvy7gAk(strStringResource, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.labelMedium, gapComposer2, 0, 0, 131066);
                    OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 4.0f));
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    FlowRowOverflow flowRowOverflow = OffsetKt.Center;
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer2, 54);
                    int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    String roomCode = roomState.getRoomCode();
                    roomCode.getClass();
                    androidx.compose.material3.TextKt.m352TextNvy7gAk(roomCode, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary, 0L, null, FontWeight.Bold, null, IntMath.getSp(6), null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.headlineLarge, gapComposer2, 102236160, 0, 130746);
                    gapComposer2.end(true);
                    if (z2) {
                        gapComposer2.startReplaceGroup(-487727823);
                        OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 12.0f));
                        boolean zChanged = gapComposer2.changed(roomState.getRoomCode());
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = "https://metrolist.cc/listen?code=" + roomState.getRoomCode();
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        String str = (String) objRememberedValue;
                        RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer2, 54);
                        int iHashCode4 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, rowMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer2, updater$$ExternalSyntheticLambda1, gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                        boolean zChangedInstance = gapComposer2.changedInstance(context) | gapComposer2.changed(str);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new PlayerMenuKt$$ExternalSyntheticLambda120(context, str, (byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        CardKt.FilledTonalButton((Function0) objRememberedValue2, null, false, null, null, null, null, AlbumMenuKt.f100lambda$1471054987, gapComposer2, 805306368, 510);
                        OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, 8.0f));
                        boolean zChangedInstance2 = gapComposer2.changedInstance(context) | gapComposer2.changed(roomState);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) context, (Object) roomState, (byte) 16);
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        CardKt.FilledTonalButton((Function0) objRememberedValue3, null, false, null, null, null, null, AlbumMenuKt.f172lambda$2075267732, gapComposer2, 805306368, 510);
                        z = true;
                        gapComposer2.end(true);
                        gapComposer2.end(false);
                    } else {
                        z = true;
                        gapComposer2.startReplaceGroup(-484424866);
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 7:
                ((Integer) obj2).getClass();
                QueueKt.LegacyMiniMediaInfo((MediaMetadata) obj4, z2, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(385));
                return unit;
            case 8:
                ((Integer) obj2).getClass();
                QueueKt.BottomSheetPlayer((BottomSheetState) obj4, (NavHostController) obj3, Modifier.Companion.$$INSTANCE, this.f$0, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 9:
                ((Integer) obj2).getClass();
                ListenTogetherScreenKt.RoomStatusCard((String) obj4, z2, (Context) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 10:
                ((Integer) obj2).getClass();
                AlbumScreenKt.YouTubeAccountPickerItem((YouTubeAccount) obj4, z2, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 11:
                ((Integer) obj2).getClass();
                WizardScreenKt.VariantItem((EQProfileVariant) obj4, z2, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Function1 function2 = (Function1) obj4;
                MutableState mutableState = (MutableState) obj3;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    boolean z4 = this.f$0;
                    boolean zChanged2 = gapComposer3.changed(z4) | gapComposer3.changed(function2);
                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new LyricsUtils$$ExternalSyntheticLambda0(z4, (Object) function2, (Object) mutableState, (byte) 10);
                        gapComposer3.updateRememberedValue(objRememberedValue4);
                    }
                    MenuKt.Switch(z4, (Function1) objRememberedValue4, null, Expect_jvmKt.rememberComposableLambda(-1116029347, new ContentSettingsKt$$ExternalSyntheticLambda82(b2, z4), gapComposer3), false, null, gapComposer3, 3072, 116);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 13:
                ((Integer) obj2).getClass();
                ThemeScreenKt.PaletteItem((ThemePalette) obj4, z2, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            default:
                ColorScheme colorScheme = (ColorScheme) obj4;
                ComposableLambdaImpl composableLambdaImpl3 = (ComposableLambdaImpl) obj3;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    MaterialThemeKt.MaterialTheme(colorScheme, z2 ? ThemeKt.GlassShapes : ThemeKt.EditorialShapes, z2 ? ThemeKt.GlassTypography : ThemeKt.EditorialTypography, composableLambdaImpl3, gapComposer4, 0);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ StringValuesKt$$ExternalSyntheticLambda1(int i, Modifier modifier, Function0 function0, boolean z) {
        this.$r8$classId = (byte) 5;
        this.f$0 = z;
        this.f$1 = function0;
        this.f$2 = modifier;
    }

    public /* synthetic */ StringValuesKt$$ExternalSyntheticLambda1(BottomSheetState bottomSheetState, NavHostController navHostController, boolean z, int i) {
        this.$r8$classId = (byte) 8;
        this.f$1 = bottomSheetState;
        this.f$2 = navHostController;
        this.f$0 = z;
    }

    public /* synthetic */ StringValuesKt$$ExternalSyntheticLambda1(Object obj, boolean z, Object obj2, int i, byte b) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$0 = z;
        this.f$2 = obj2;
    }

    public /* synthetic */ StringValuesKt$$ExternalSyntheticLambda1(boolean z, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = obj;
        this.f$2 = obj2;
    }
}
