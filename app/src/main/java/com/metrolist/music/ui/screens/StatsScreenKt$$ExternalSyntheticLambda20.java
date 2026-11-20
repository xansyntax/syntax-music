package com.metrolist.music.ui.screens;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
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
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.metrolist.music.ui.component.HideOnScrollFABKt$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.SettingsSleepTimerDialogKt$$ExternalSyntheticLambda34;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda26;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda7;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.websocket.RawWebSocketCommonKt$$ExternalSyntheticLambda0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgressionIterator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StatsScreenKt$$ExternalSyntheticLambda20 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ MutableState f$2;
    public final /* synthetic */ MutableState f$3;

    public /* synthetic */ StatsScreenKt$$ExternalSyntheticLambda20(List list, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = mutableState;
        this.f$2 = mutableState2;
        this.f$3 = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i;
        boolean z;
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        MutableState mutableState = this.f$3;
        MutableState mutableState2 = this.f$2;
        MutableState mutableState3 = this.f$1;
        List list = this.f$0;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                    gapComposer.startReplaceGroup(1943512174);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new StatsScreenKt$$ExternalSyntheticLambda6((byte) 27);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.Checkbox(true, (Function1) objRememberedValue, null, false, null, gapComposer, 54);
                    boolean z2 = !list.isEmpty();
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new LoginScreenKt$$ExternalSyntheticLambda4((byte) 12);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    CardKt.IconButton((Function0) objRememberedValue2, null, z2, null, null, AlbumScreenKt.f323lambda$391607906, gapComposer, 1572870, 58);
                    gapComposer.end(false);
                } else if (((Boolean) mutableState3.getValue()).booleanValue()) {
                    gapComposer.startReplaceGroup(1944748299);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(1944077521);
                    boolean zChanged = gapComposer.changed(mutableState3);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new PlayerKt$$ExternalSyntheticLambda7(mutableState3, (byte) 11);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.IconButton((Function0) objRememberedValue3, null, false, null, null, AlbumScreenKt.lambda$1304232917, gapComposer, 1572864, 62);
                    boolean zChanged2 = gapComposer.changed(mutableState2);
                    Object objRememberedValue4 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new PlayerKt$$ExternalSyntheticLambda7(mutableState2, (byte) 12);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    Function0 function0 = (Function0) objRememberedValue4;
                    boolean zChanged3 = gapComposer.changed(mutableState2);
                    Object objRememberedValue5 = gapComposer.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new PlayerKt$$ExternalSyntheticLambda7(mutableState2, (byte) 13);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    }
                    MenuKt.IconButton(function0, (Function0) objRememberedValue5, null, false, null, null, AlbumScreenKt.lambda$917816766, gapComposer, 1572864);
                    gapComposer.end(false);
                }
                return unit;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    CardKt.OutlinedCard(OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 4.0f), null, null, null, null, Expect_jvmKt.rememberComposableLambda(530880507, new StatsScreenKt$$ExternalSyntheticLambda20(this.f$0, this.f$1, this.f$2, this.f$3, (byte) 2), gapComposer2), gapComposer2, 196614, 30);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                boolean z3 = true;
                BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
                Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                    return unit;
                }
                Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer3, 0);
                int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, modifierFillMaxWidth);
                ComposeUiNode.Companion.getClass();
                gapComposer3.startReusableNode();
                boolean z4 = gapComposer3.inserting;
                TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                if (z4) {
                    gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer3.useNode();
                }
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                Stack.m390setimpl(gapComposer3, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                gapComposer3.startReplaceGroup(-436303171);
                Iterator it = CollectionsKt__IterablesKt.getIndices(list).iterator();
                while (((IntProgressionIterator) it).hasNext) {
                    int iNextInt = ((IntIterator) it).nextInt();
                    Unit unit2 = unit;
                    MutableState mutableState4 = mutableState2;
                    boolean zContains = ((List) mutableState3.getValue()).contains(Integer.valueOf(iNextInt));
                    MutableState mutableState5 = mutableState;
                    Pair pair = (Pair) ((Map) mutableState4.getValue()).get(Integer.valueOf(iNextInt));
                    if (pair == null) {
                        pair = new Pair("22:00", "06:00");
                    }
                    if (iNextInt > 0) {
                        gapComposer3.startReplaceGroup(-657282697);
                        CardKt.m261HorizontalDivider9IZ8Weo(OffsetKt.m137paddingVpY3zN4$default(companion, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), CropImageView.DEFAULT_ASPECT_RATIO, 0L, gapComposer3, 6, 6);
                        i = 0;
                        gapComposer3.end(false);
                    } else {
                        i = 0;
                        gapComposer3.startReplaceGroup(-657157767);
                        gapComposer3.end(false);
                    }
                    List list2 = list;
                    Modifier modifierM136paddingVpY3zN4 = OffsetKt.m136paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, 4.0f);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, gapComposer3, i);
                    MutableState mutableState6 = mutableState3;
                    int iHashCode2 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM136paddingVpY3zN4);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    Arrangement$Top$1 arrangement$Top$2 = arrangement$Top$1;
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, columnMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged4 = gapComposer3.changed(iNextInt);
                    Object objRememberedValue6 = gapComposer3.rememberedValue();
                    if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                        z = false;
                        objRememberedValue6 = new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda34(iNextInt, mutableState6, (byte) 0);
                        gapComposer3.updateRememberedValue(objRememberedValue6);
                    } else {
                        z = false;
                    }
                    BiasAlignment.Horizontal horizontal2 = horizontal;
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, z, null, (Function0) objRememberedValue6, 15), CropImageView.DEFAULT_ASPECT_RATIO, 6.0f, z3 ? 1 : 0);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer3, 48);
                    int iHashCode3 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM137paddingVpY3zN4$default);
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(((Number) list2.get(iNextInt)).intValue(), gapComposer3), new LayoutWeightElement(1.0f, true), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer3, 0, 0, 131068);
                    Modifier modifierScale = ClipKt.scale();
                    boolean zChanged5 = gapComposer3.changed(iNextInt);
                    Object objRememberedValue7 = gapComposer3.rememberedValue();
                    if (zChanged5 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new RawWebSocketCommonKt$$ExternalSyntheticLambda0(iNextInt, mutableState6, (byte) 5);
                        gapComposer3.updateRememberedValue(objRememberedValue7);
                    }
                    MenuKt.Switch(zContains, (Function1) objRememberedValue7, modifierScale, Expect_jvmKt.rememberComposableLambda(2084926119, new SongMenuKt$$ExternalSyntheticLambda26((byte) 2, zContains), gapComposer3), false, null, gapComposer3, 3456, 112);
                    gapComposer3.end(true);
                    CrossfadeKt.AnimatedVisibility(ColumnScopeInstance.INSTANCE, zContains, null, EnterExitTransitionKt.expandVertically$default(ArcSplineKt.spring$default(0.5f, 1500.0f, null, 4), 14).plus(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), EnterExitTransitionKt.shrinkVertically$default(ArcSplineKt.spring$default(0.5f, 1500.0f, null, 4), 14).plus(EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), null, Expect_jvmKt.rememberComposableLambda(873976279, new HideOnScrollFABKt$$ExternalSyntheticLambda1(pair, iNextInt, mutableState5, (byte) 1), gapComposer3), gapComposer3, 1600518, 18);
                    gapComposer3.end(true);
                    mutableState3 = mutableState6;
                    mutableState = mutableState5;
                    z3 = true;
                    unit = unit2;
                    mutableState2 = mutableState4;
                    list = list2;
                    arrangement$Top$1 = arrangement$Top$2;
                    horizontal = horizontal2;
                }
                Unit unit3 = unit;
                gapComposer3.end(false);
                gapComposer3.end(z3);
                return unit3;
        }
    }
}
