package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
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
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda82;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$$ExternalSyntheticLambda14;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$$ExternalSyntheticLambda30;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlinx.coroutines.channels.BufferedChannel$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SelectionSongsMenuKt$$ExternalSyntheticLambda22 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ MutableState f$10;
    public final /* synthetic */ MutableState f$11;
    public final /* synthetic */ MutableState f$12;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ List f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ boolean f$8;
    public final /* synthetic */ ParcelableSnapshotMutableIntState f$9;

    public /* synthetic */ SelectionSongsMenuKt$$ExternalSyntheticLambda22(ArrayList arrayList, DownloadUtil downloadUtil, Function0 function0, Function0 function1, MusicDatabase musicDatabase, SyncUtils syncUtils, List list, Function0 function2, boolean z, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        this.f$0 = arrayList;
        this.f$1 = downloadUtil;
        this.f$2 = function0;
        this.f$3 = function1;
        this.f$4 = musicDatabase;
        this.f$5 = syncUtils;
        this.f$6 = list;
        this.f$7 = function2;
        this.f$8 = z;
        this.f$9 = parcelableSnapshotMutableIntState;
        this.f$10 = mutableState;
        this.f$11 = mutableState2;
        this.f$12 = mutableState3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v12 */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Material3MenuItemData material3MenuItemData;
        boolean z;
        ?? r13;
        float f;
        float f2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj4 = Composer.Companion.Empty;
        Object obj5 = this.f$5;
        Object obj6 = this.f$4;
        Object obj7 = this.f$7;
        Object obj8 = this.f$3;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.f$9;
        Object obj9 = this.f$2;
        MutableState mutableState = this.f$11;
        MutableState mutableState2 = this.f$10;
        boolean z2 = this.f$8;
        Object obj10 = this.f$1;
        Object obj11 = this.f$0;
        switch (b) {
            case 0:
                ArrayList arrayList = (ArrayList) obj11;
                DownloadUtil downloadUtil = (DownloadUtil) obj10;
                Function0 function0 = (Function0) obj9;
                Function0 function1 = (Function0) obj8;
                MusicDatabase musicDatabase = (MusicDatabase) obj6;
                SyncUtils syncUtils = (SyncUtils) obj5;
                Function0 function2 = (Function0) obj7;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    gapComposer.startReplaceGroup(-2113162050);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    int intValue = parcelableSnapshotMutableIntState.getIntValue();
                    if (intValue == 0 || intValue == 2) {
                        gapComposer.startReplaceGroup(-1918307666);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.f212lambda$48174211;
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.f241lambda$635636482;
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == obj4) {
                            objRememberedValue = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState2, (byte) 28);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, null, (Function0) objRememberedValue, null, null, 52);
                        z = false;
                        gapComposer.end(false);
                    } else if (intValue != 3) {
                        gapComposer.startReplaceGroup(-1917507339);
                        ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.lambda$401442077;
                        ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.lambda$1839494942;
                        boolean zChangedInstance = gapComposer.changedInstance(arrayList) | gapComposer.changedInstance(downloadUtil);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == obj4) {
                            objRememberedValue2 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) arrayList, (Object) downloadUtil, (byte) 23);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl3, composableLambdaImpl4, null, (Function0) objRememberedValue2, null, null, 52);
                        z = false;
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-1919327721);
                        ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.f201lambda$403397548;
                        ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.f92lambda$1414063595;
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (objRememberedValue3 == obj4) {
                            objRememberedValue3 = new QueueMenuKt$$ExternalSyntheticLambda2(mutableState2, (byte) 27);
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl5, composableLambdaImpl6, null, (Function0) objRememberedValue3, null, null, 52);
                        z = false;
                        gapComposer.end(false);
                    }
                    listBuilderCreateListBuilder.add(material3MenuItemData);
                    byte b2 = 21;
                    if (function0 == null) {
                        gapComposer.startReplaceGroup(-1916621267);
                        gapComposer.end(z);
                    } else {
                        gapComposer.startReplaceGroup(-1916621266);
                        ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.f274lambda$90194931;
                        ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.f82lambda$1336102868;
                        boolean zChanged = gapComposer.changed(function1) | gapComposer.changed(function0) | gapComposer.changed(function2);
                        Object objRememberedValue4 = gapComposer.rememberedValue();
                        if (zChanged || objRememberedValue4 == obj4) {
                            objRememberedValue4 = new GapComposer$$ExternalSyntheticLambda0(function1, function0, function2, b2);
                            gapComposer.updateRememberedValue(objRememberedValue4);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl7, composableLambdaImpl8, null, (Function0) objRememberedValue4, null, null, 52));
                        gapComposer.end(false);
                    }
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Expect_jvmKt.rememberComposableLambda(708463493, new SongMenuKt$$ExternalSyntheticLambda37(mutableState, b2), gapComposer);
                    ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Expect_jvmKt.rememberComposableLambda(1541394054, new SongMenuKt$$ExternalSyntheticLambda37(mutableState, (byte) 22), gapComposer);
                    boolean zChangedInstance2 = gapComposer.changedInstance(arrayList) | gapComposer.changed(function1) | gapComposer.changedInstance(musicDatabase) | gapComposer.changedInstance(syncUtils);
                    Object objRememberedValue5 = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue5 == obj4) {
                        objRememberedValue5 = new SongMenuKt$$ExternalSyntheticLambda63((Object) arrayList, (Object) function1, musicDatabase, (Object) syncUtils, (byte) 15);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImplRememberComposableLambda, composableLambdaImplRememberComposableLambda2, null, (Function0) objRememberedValue5, null, null, 52));
                    List list = this.f$6;
                    if (list == null || !(!list.isEmpty())) {
                        gapComposer.startReplaceGroup(-1912592630);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-1913855384);
                        ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.f246lambda$666669599;
                        ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.lambda$771383266;
                        boolean zChanged2 = gapComposer.changed(function1) | gapComposer.changedInstance(musicDatabase) | gapComposer.changedInstance(list) | gapComposer.changed(function2);
                        Object objRememberedValue6 = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue6 == obj4) {
                            objRememberedValue6 = new SongMenuKt$$ExternalSyntheticLambda63((Object) function1, musicDatabase, (Object) function2, (Object) list, (byte) 16);
                            gapComposer.updateRememberedValue(objRememberedValue6);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl9, composableLambdaImpl10, null, (Function0) objRememberedValue6, null, null, 52));
                        gapComposer.end(false);
                    }
                    if (z2) {
                        gapComposer.startReplaceGroup(-1912519811);
                        ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.lambda$888399818;
                        ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.f68lambda$122266229;
                        Object objRememberedValue7 = gapComposer.rememberedValue();
                        if (objRememberedValue7 == obj4) {
                            objRememberedValue7 = new QueueMenuKt$$ExternalSyntheticLambda2(this.f$12, (byte) 29);
                            gapComposer.updateRememberedValue(objRememberedValue7);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl11, composableLambdaImpl12, null, (Function0) objRememberedValue7, null, null, 52));
                        r13 = 0;
                        gapComposer.end(false);
                    } else {
                        r13 = 0;
                        gapComposer.startReplaceGroup(-1911769270);
                        gapComposer.end(false);
                    }
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    gapComposer.end(r13);
                    MenuKt.Material3MenuGroup(listBuilderBuild, gapComposer, r13);
                }
                break;
            default:
                Context context = (Context) obj11;
                String str = (String) obj10;
                Locale locale = (Locale) obj9;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) obj8;
                Playlist playlist = (Playlist) obj7;
                String str2 = (String) obj6;
                MutableState mutableState3 = (MutableState) obj5;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(10.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Start, gapComposer2, 6);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    boolean z3 = gapComposer2.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z3) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer2, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer2);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer2, 48);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierFillMaxWidth);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    String strStringResource = MathKt.stringResource(R.string.alarm_enabled, gapComposer2);
                    if (1.0f <= 0.0d) {
                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                    }
                    if (1.0f > Float.MAX_VALUE) {
                        f2 = Float.MAX_VALUE;
                        f = Float.MAX_VALUE;
                    } else {
                        f = Float.MAX_VALUE;
                        f2 = 1.0f;
                    }
                    TextKt.m352TextNvy7gAk(strStringResource, new LayoutWeightElement(f2, true), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262140);
                    boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
                    Object objRememberedValue8 = gapComposer2.rememberedValue();
                    byte b3 = 19;
                    if (objRememberedValue8 == obj4) {
                        objRememberedValue8 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState2, b3);
                        gapComposer2.updateRememberedValue(objRememberedValue8);
                    }
                    AlarmSettingsKt.AlarmSwitch(zBooleanValue, (Function1) objRememberedValue8, false, gapComposer2, 48);
                    gapComposer2.end(true);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    Object objRememberedValue9 = gapComposer2.rememberedValue();
                    if (objRememberedValue9 == obj4) {
                        objRememberedValue9 = new AlarmSettingsKt$$ExternalSyntheticLambda14(mutableState, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue9);
                    }
                    CardKt.Button((Function0) objRememberedValue9, modifierFillMaxWidth2, false, roundedCornerShapeM185RoundedCornerShape0680j_4, null, null, null, null, null, Expect_jvmKt.rememberComposableLambda(1767107624, new PlayerKt$$ExternalSyntheticLambda82(locale, parcelableSnapshotMutableIntState, parcelableSnapshotMutableIntState2, (byte) 19), gapComposer2), gapComposer2, 805306422, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
                    CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, 0L, gapComposer2, 0, 7);
                    List list2 = this.f$6;
                    boolean z4 = !list2.isEmpty();
                    Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChangedInstance3 = gapComposer2.changedInstance(list2) | gapComposer2.changedInstance(context) | gapComposer2.changed(str);
                    Object objRememberedValue10 = gapComposer2.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue10 == obj4) {
                        objRememberedValue10 = new AlarmSettingsKt$$ExternalSyntheticLambda30(list2, context, str, this.f$12, (byte) 0);
                        gapComposer2.updateRememberedValue(objRememberedValue10);
                    }
                    CardKt.OutlinedButton((Function0) objRememberedValue10, modifierFillMaxWidth3, z4, null, null, null, null, Expect_jvmKt.rememberComposableLambda(-1664724054, new BufferedChannel$$ExternalSyntheticLambda1(playlist, str2, (byte) 1), gapComposer2), gapComposer2, 805306416, 504);
                    Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer2, 48);
                    int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierFillMaxWidth4);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                    String strStringResource2 = MathKt.stringResource(R.string.alarm_random_song, gapComposer2);
                    if (1.0f <= 0.0d) {
                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                    }
                    TextKt.m352TextNvy7gAk(strStringResource2, new LayoutWeightElement(1.0f > f ? f : 1.0f, true), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262140);
                    boolean zBooleanValue2 = ((Boolean) mutableState3.getValue()).booleanValue();
                    Object objRememberedValue11 = gapComposer2.rememberedValue();
                    if (objRememberedValue11 == obj4) {
                        objRememberedValue11 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState3, (byte) 20);
                        gapComposer2.updateRememberedValue(objRememberedValue11);
                    }
                    AlarmSettingsKt.AlarmSwitch(zBooleanValue2, (Function1) objRememberedValue11, false, gapComposer2, 48);
                    gapComposer2.end(true);
                    if (z2) {
                        gapComposer2.startReplaceGroup(625079493);
                        String strStringResource3 = MathKt.stringResource(R.string.alarm_duplicate_time_warning, gapComposer2);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextKt.m352TextNvy7gAk(strStringResource3, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.error, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer2, 0, 0, 131066);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(625313450);
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(true);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ SelectionSongsMenuKt$$ExternalSyntheticLambda22(List list, Context context, String str, boolean z, MutableState mutableState, MutableState mutableState2, Locale locale, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2, MutableState mutableState3, Playlist playlist, String str2, MutableState mutableState4) {
        this.f$6 = list;
        this.f$0 = context;
        this.f$1 = str;
        this.f$8 = z;
        this.f$10 = mutableState;
        this.f$11 = mutableState2;
        this.f$2 = locale;
        this.f$9 = parcelableSnapshotMutableIntState;
        this.f$3 = parcelableSnapshotMutableIntState2;
        this.f$12 = mutableState3;
        this.f$7 = playlist;
        this.f$4 = str2;
        this.f$5 = mutableState4;
    }
}
