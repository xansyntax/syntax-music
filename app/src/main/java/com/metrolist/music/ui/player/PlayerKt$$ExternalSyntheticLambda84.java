package com.metrolist.music.ui.player;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.navigation.NavHostController;
import com.metrolist.music.eq.data.SavedEQProfile;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.PlayerMenuKt;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda78;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.metrolist.music.ui.screens.settings.AiSettingsKt$$ExternalSyntheticLambda66;
import com.metrolist.music.ui.screens.settings.integrations.DiscordSettingsKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.viewmodels.LyricsViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda84 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$3;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda84(BottomSheetState bottomSheetState, NavHostController navHostController, Modifier modifier, boolean z, int i) {
        this.$r8$classId = (byte) 0;
        this.f$0 = bottomSheetState;
        this.f$1 = navHostController;
        this.f$2 = modifier;
        this.f$3 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        boolean z = this.f$3;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                QueueKt.BottomSheetPlayer((BottomSheetState) obj5, (NavHostController) obj4, (Modifier) obj3, this.f$3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                CardKt.ExposedDropdownMenuBox(this.f$3, (Function1) obj5, (Modifier) obj3, (ComposableLambdaImpl) obj4, (Composer) obj, Stack.updateChangedFlags(3505));
                break;
            case 2:
                InteractionSource interactionSource = (InteractionSource) obj5;
                TextFieldColors textFieldColors = (TextFieldColors) obj4;
                Shape shape = (Shape) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    TextFieldDefaults.INSTANCE.m349Container4EFweAY(this.f$3, interactionSource, textFieldColors, shape, gapComposer, 114822144);
                }
                break;
            case 3:
                ((Integer) obj2).getClass();
                MenuKt.Lyrics((Function0) obj5, (Modifier) obj3, this.f$3, (LyricsViewModel) obj4, (Composer) obj, Stack.updateChangedFlags(49));
                break;
            case 4:
                ((Integer) obj2).getClass();
                AlbumMenuKt.ImportPlaylistDialog(this.f$3, (Function1) obj5, (String) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 5:
                Function0 function0 = (Function0) obj5;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj4;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, 0);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    if (z) {
                        gapComposer2.startReplaceGroup(1951562600);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(1951042699);
                        Float fValueOf = Float.valueOf(parcelableSnapshotMutableFloatState.getFloatValue());
                        IntRange intRange = new IntRange(0, 35, 1);
                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10));
                        Iterator it = intRange.iterator();
                        while (((IntProgressionIterator) it).hasNext) {
                            arrayList.add(Float.valueOf(((float) Math.rint(((((IntIterator) it).nextInt() * 0.05f) + 0.25f) * 100.0f)) / 100.0f));
                        }
                        boolean zChanged = gapComposer2.changed(function0);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new PlayerMenuKt$$ExternalSyntheticLambda78(function0, parcelableSnapshotMutableFloatState, (byte) 1);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        Function1 function1 = (Function1) objRememberedValue;
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 5);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        PlayerMenuKt.ValueAdjuster(R.drawable.speed, fValueOf, arrayList, function1, (Function1) objRememberedValue2, OffsetKt.m139paddingqDBjuR0$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 7), gapComposer2, 221184, 0);
                        gapComposer2.end(false);
                    }
                    Integer numValueOf = Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue());
                    List list = CollectionsKt.toList(new IntRange(-12, 12, 1));
                    boolean zChanged2 = gapComposer2.changed(function0);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new SongMenuKt$$ExternalSyntheticLambda4((Object) function0, (Object) parcelableSnapshotMutableIntState, (byte) 3);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    Function1 function2 = (Function1) objRememberedValue3;
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new SongMenuKt$$ExternalSyntheticLambda16((byte) 6);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    PlayerMenuKt.ValueAdjuster(R.drawable.discover_tune, numValueOf, list, function2, (Function1) objRememberedValue4, null, gapComposer2, 24576, 32);
                    gapComposer2.end(true);
                }
                break;
            case 6:
                String str = (String) obj5;
                MutableState mutableState = (MutableState) obj4;
                MutableState mutableState2 = (MutableState) obj3;
                String str2 = (String) obj;
                String str3 = (String) obj2;
                str2.getClass();
                str3.getClass();
                if (z && !str2.equals(str)) {
                    mutableState.setValue(str2);
                    mutableState2.setValue(str3);
                }
                break;
            case 7:
                ((Integer) obj2).getClass();
                ListenTogetherScreenKt.ConnectedUsersSection((ArrayList) obj5, this.f$3, (String) obj4, (Function2) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 8:
                ((Integer) obj2).getClass();
                EqScreenKt.EQProfileItem((SavedEQProfile) obj5, this.f$3, (Function0) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(9));
                break;
            default:
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = (DataStoreKt$rememberPreference$1$1) obj5;
                MutableState mutableState3 = (MutableState) obj4;
                MutableState mutableState4 = (MutableState) obj3;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else if (!z) {
                    gapComposer3.startReplaceGroup(1654104450);
                    boolean zChanged3 = gapComposer3.changed(mutableState4);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new DiscordSettingsKt$$ExternalSyntheticLambda5(mutableState4, (byte) 12);
                        gapComposer3.updateRememberedValue(objRememberedValue5);
                    }
                    CardKt.OutlinedButton((Function0) objRememberedValue5, null, false, null, null, null, null, LastFMSettingsKt.lambda$2020479006, gapComposer3, 805306368, 510);
                    gapComposer3.end(false);
                } else {
                    gapComposer3.startReplaceGroup(1653779477);
                    boolean zChanged4 = gapComposer3.changed(dataStoreKt$rememberPreference$1$1) | gapComposer3.changed(mutableState3);
                    Object objRememberedValue6 = gapComposer3.rememberedValue();
                    if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new AiSettingsKt$$ExternalSyntheticLambda66(dataStoreKt$rememberPreference$1$1, mutableState3, (byte) 1);
                        gapComposer3.updateRememberedValue(objRememberedValue6);
                    }
                    CardKt.OutlinedButton((Function0) objRememberedValue6, null, false, null, null, null, null, LastFMSettingsKt.lambda$746400085, gapComposer3, 805306368, 510);
                    gapComposer3.end(false);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda84(byte b, Object obj, Object obj2, Object obj3, boolean z) {
        this.$r8$classId = b;
        this.f$3 = z;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda84(Object obj, boolean z, Object obj2, Function function, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$3 = z;
        this.f$1 = obj2;
        this.f$2 = function;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda84(Function0 function0, Modifier modifier, boolean z, LyricsViewModel lyricsViewModel, int i) {
        this.$r8$classId = (byte) 3;
        this.f$0 = function0;
        this.f$2 = modifier;
        this.f$3 = z;
        this.f$1 = lyricsViewModel;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda84(boolean z, Function1 function1, Modifier modifier, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.$r8$classId = (byte) 1;
        this.f$3 = z;
        this.f$0 = function1;
        this.f$2 = modifier;
        this.f$1 = composableLambdaImpl;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda84(boolean z, Function1 function1, String str, Function0 function0, int i) {
        this.$r8$classId = (byte) 4;
        this.f$3 = z;
        this.f$0 = function1;
        this.f$1 = str;
        this.f$2 = function0;
    }
}
