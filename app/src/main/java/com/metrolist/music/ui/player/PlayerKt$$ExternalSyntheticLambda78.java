package com.metrolist.music.ui.player;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda46;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.TextFieldValue;
import com.metrolist.innertube.models.YouTubeAccount;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.SettingsSleepTimerDialogKt;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda29;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda73;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.LoginJsInterface;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda18;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.LyricsPosition;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.viewmodels.CsvImportState;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.net.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda78 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda78(MutableState mutableState, MutableState mutableState2, Proxy.Type type, Function1 function1, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5) {
        this.$r8$classId = (byte) 8;
        this.f$6 = mutableState;
        this.f$0 = mutableState2;
        this.f$1 = type;
        this.f$2 = function1;
        this.f$3 = mutableState3;
        this.f$4 = mutableState4;
        this.f$5 = mutableState5;
    }

    private final Object invoke$com$metrolist$music$ui$screens$playlist$LocalPlaylistScreenKt$$ExternalSyntheticLambda6(Object obj, Object obj2) {
        SnapshotStateList snapshotStateList = (SnapshotStateList) this.f$0;
        FocusRequester focusRequester = (FocusRequester) this.f$1;
        MutableState mutableState = (MutableState) this.f$6;
        MutableState mutableState2 = (MutableState) this.f$2;
        MutableState mutableState3 = (MutableState) this.f$3;
        State state = (State) this.f$5;
        MutableState mutableState4 = (MutableState) this.f$4;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        GapComposer gapComposer = (GapComposer) composer;
        if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            gapComposer.skipToGroupEnd();
        } else if (LocalPlaylistScreenKt.LocalPlaylistScreen$lambda$21(mutableState2)) {
            gapComposer.startReplaceGroup(31871286);
            TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.n_selected, snapshotStateList.size(), new Object[]{Integer.valueOf(snapshotStateList.size())}, gapComposer), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
            gapComposer.end(false);
        } else if (((Boolean) mutableState3.getValue()).booleanValue()) {
            gapComposer.startReplaceGroup(32071391);
            TextFieldValue textFieldValue = (TextFieldValue) mutableState.getValue();
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge;
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, 3, 119);
            TextFieldColors textFieldColorsM348colors0hiis_0 = TextFieldDefaults.m348colors0hiis_0(0L, 0L, 0L, 0L, gapComposer, 2147469263);
            Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), focusRequester);
            boolean zChanged = gapComposer.changed(mutableState);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 8);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ScrimKt.TextField(textFieldValue, (Function1) objRememberedValue, modifierFocusRequester, false, textStyle, TopPlaylistScreenKt.f388lambda$1545132235, null, keyboardOptions, null, true, 0, 0, null, textFieldColorsM348colors0hiis_0, gapComposer, 12582912, 12779520, 4030296);
            gapComposer.end(false);
        } else if (((Boolean) state.getValue()).booleanValue()) {
            gapComposer.startReplaceGroup(33363006);
            Playlist playlist = (Playlist) mutableState4.getValue();
            String str = playlist != null ? playlist.playlist.name : null;
            if (str == null) {
                str = "";
            }
            TextKt.m352TextNvy7gAk(str, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(33439886);
            gapComposer.end(false);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b;
        BiasAlignment.Vertical vertical;
        List list;
        Modifier.Companion companion;
        MutableState mutableState;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState3;
        Iterator it;
        boolean z;
        int i;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal;
        long j;
        boolean z2;
        boolean z3;
        byte b2 = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$5;
        Object obj4 = this.f$4;
        Object obj5 = this.f$3;
        Object obj6 = this.f$2;
        Object obj7 = this.f$1;
        Object obj8 = this.f$0;
        Object obj9 = this.f$6;
        switch (b2) {
            case 0:
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj8;
                CoroutineScope coroutineScope = (CoroutineScope) obj7;
                Context context = (Context) obj6;
                String str = (String) obj5;
                PlayerConnection playerConnection = (PlayerConnection) obj4;
                State state = (State) obj3;
                MutableState mutableState2 = (MutableState) obj9;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, horizontal, gapComposer, 48);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, companion2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    String strPluralStringResource = MathKt.pluralStringResource(R.plurals.minute, MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()), new Object[]{Integer.valueOf(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()))}, gapComposer);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strPluralStringResource, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).typography.bodyLarge, gapComposer, 0, 0, 131070);
                    float floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new PlayerKt$$ExternalSyntheticLambda1(parcelableSnapshotMutableFloatState, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    SliderKt.Slider(floatValue, (Function1) objRememberedValue, null, false, new ClosedFloatRange(5.0f, 120.0f), 22, null, null, gapComposer, 196656, 460);
                    ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), horizontal, gapComposer, 54);
                    int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, companion2);
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda1, gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    if (((Boolean) state.getValue()).booleanValue()) {
                        gapComposer.startReplaceGroup(208405398);
                        boolean zChangedInstance = gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(context) | gapComposer.changed(str);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                            PlayerKt$$ExternalSyntheticLambda2 playerKt$$ExternalSyntheticLambda2 = new PlayerKt$$ExternalSyntheticLambda2(coroutineScope, context, str, parcelableSnapshotMutableFloatState, (byte) 0);
                            gapComposer.updateRememberedValue(playerKt$$ExternalSyntheticLambda2);
                            objRememberedValue2 = playerKt$$ExternalSyntheticLambda2;
                        }
                        Function0 function0 = (Function0) objRememberedValue2;
                        long j2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.primary;
                        long j3 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme.onPrimary;
                        Rgb rgb = ColorSpaces.Unspecified;
                        long jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
                        long jColor2 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
                        ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme;
                        IconButtonColors iconButtonColors = colorScheme.defaultFilledIconButtonColorsCached;
                        if (iconButtonColors == null) {
                            long jM284fromToken_Htp75A = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 25);
                            long jM284fromToken_Htp75A2 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 9);
                            long jM284fromToken_Htp75A3 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                            long jColor3 = ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A3), Color.m484getGreenimpl(jM284fromToken_Htp75A3), Color.m482getBlueimpl(jM284fromToken_Htp75A3), 0.1f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A3));
                            long jM284fromToken_Htp75A4 = ColorSchemeKt.m284fromToken_Htp75A(colorScheme, 17);
                            iconButtonColors = new IconButtonColors(jM284fromToken_Htp75A, jM284fromToken_Htp75A2, jColor3, ColorKt.Color(Color.m485getRedimpl(jM284fromToken_Htp75A4), Color.m484getGreenimpl(jM284fromToken_Htp75A4), Color.m482getBlueimpl(jM284fromToken_Htp75A4), 0.38f, Color.m483getColorSpaceimpl(jM284fromToken_Htp75A4)));
                            colorScheme.defaultFilledIconButtonColorsCached = iconButtonColors;
                        }
                        CardKt.FilledIconButton(function0, null, false, null, iconButtonColors.m289copyjRlVdoo(j2, j3, jColor, jColor2), gapComposer, 1572864);
                        b = 0;
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(209604571);
                        boolean zChangedInstance2 = gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(context) | gapComposer.changed(str);
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new PlayerKt$$ExternalSyntheticLambda2(coroutineScope, context, str, parcelableSnapshotMutableFloatState, (byte) 1);
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        CardKt.OutlinedIconButton((Function0) objRememberedValue3, null, false, null, null, null, QueueKt.lambda$293011627, gapComposer, 12582912);
                        b = 0;
                        gapComposer.end(false);
                    }
                    boolean zChangedInstance3 = gapComposer.changedInstance(playerConnection);
                    Object objRememberedValue4 = gapComposer.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new PlayerKt$$ExternalSyntheticLambda4(playerConnection, mutableState2, b);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.OutlinedIconButton((Function0) objRememberedValue4, null, false, null, null, null, QueueKt.f292lambda$365013809, gapComposer, 12582912);
                    gapComposer.end(true);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                String str2 = (String) obj5;
                String str3 = (String) obj8;
                String str4 = (String) obj7;
                String str5 = (String) obj4;
                Context context2 = (Context) obj6;
                Function0 function1 = (Function0) obj3;
                Function0 function2 = (Function0) obj9;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    CardKt.Card(SizeKt.fillMaxWidth(OffsetKt.m135padding3ABfNKs(companion2, 16.0f), 0.85f), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).shapes.medium, CardKt.m267cardColorsro_MJ88(((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).colorScheme.surface, 0L, gapComposer2, 14), CardKt.m268cardElevationaqJV_2Y(CropImageView.DEFAULT_ASPECT_RATIO), null, Expect_jvmKt.rememberComposableLambda(1258023999, new SongMenuKt$$ExternalSyntheticLambda8(str2, str3, str4, str5, context2, function1, function2), gapComposer2), gapComposer2, 196614, 16);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                ((Integer) obj2).getClass();
                MenuKt.LyricsColorPickerDialog((String) obj5, (String) obj8, (String) obj7, (String) obj6, (LyricsPosition) obj4, (Function0) obj3, (Function4) obj9, (Composer) obj, Stack.updateChangedFlags(196609));
                return unit;
            case 3:
                ((Integer) obj2).getClass();
                SettingsSleepTimerDialogKt.SleepTimerDialog((Function0) obj8, (Function5) obj7, (String) obj5, (String) obj6, (String) obj4, (List) obj3, (Map) obj9, (Composer) obj, Stack.updateChangedFlags(55));
                return unit;
            case 4:
                CsvImportState csvImportState = (CsvImportState) obj8;
                MutableState mutableState3 = (MutableState) obj9;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState4 = (ParcelableSnapshotMutableIntState) obj7;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState5 = (ParcelableSnapshotMutableIntState) obj6;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState6 = (ParcelableSnapshotMutableIntState) obj5;
                Function0 function3 = (Function0) obj4;
                Function1 function4 = (Function1) obj3;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                BiasAlignment.Vertical vertical2 = Alignment.Companion.Top;
                BiasAlignment.Horizontal horizontal2 = Alignment.Companion.Start;
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    Modifier modifierClip = ClipKt.clip(SizeKt.fillMaxWidth(companion2, 0.95f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(16.0f));
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                    long j4 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal4)).colorScheme.surface;
                    RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = ColorKt.RectangleShape;
                    Modifier modifierScroll$default = ImageKt.scroll$default(OffsetKt.m135padding3ABfNKs(ImageKt.m39backgroundbw27NRU(modifierClip, j4, rectangleShapeKt$RectangleShape$1), 24.0f), ImageKt.rememberScrollState(gapComposer3), true);
                    ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), horizontal2, gapComposer3, 6);
                    int iHashCode3 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierScroll$default);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, columnMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.map_csv_columns, gapComposer3), null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal4)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal4)).typography.headlineSmall, gapComposer3, 0, 0, 131066);
                    List list2 = csvImportState.previewRows;
                    if (list2.isEmpty()) {
                        vertical = vertical2;
                        list = list2;
                        companion = companion2;
                        gapComposer3.startReplaceGroup(94845568);
                        gapComposer3.end(false);
                    } else {
                        gapComposer3.startReplaceGroup(91700215);
                        companion = companion2;
                        Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f)), ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal4)).colorScheme.surfaceVariant, rectangleShapeKt$RectangleShape$1), 12.0f);
                        ColumnMeasurePolicy columnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), horizontal2, gapComposer3, 6);
                        int iHashCode4 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM135padding3ABfNKs);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m390setimpl(gapComposer3, columnMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                        TextKt.m352TextNvy7gAk("Preview", null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal4)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal4)).typography.labelMedium, gapComposer3, 6, 0, 131066);
                        gapComposer3 = gapComposer3;
                        Modifier modifierScroll$default2 = ImageKt.scroll$default(SizeKt.fillMaxWidth(companion, 1.0f), ImageKt.rememberScrollState(gapComposer3), false);
                        BiasAlignment.Vertical vertical3 = vertical2;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(4.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), vertical3, gapComposer3, 6);
                        int iHashCode5 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope5 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier5 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierScroll$default2);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m390setimpl(gapComposer3, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope5, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode5, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                        Stack.m390setimpl(gapComposer3, modifierMaterializeModifier5, updater$$ExternalSyntheticLambda0);
                        gapComposer3.startReplaceGroup(749372302);
                        Iterator it2 = CollectionsKt.take(list2, 5).iterator();
                        int i2 = 0;
                        while (it2.hasNext()) {
                            Object next = it2.next();
                            int i3 = i2 + 1;
                            if (i2 < 0) {
                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                throw null;
                            }
                            List list3 = (List) next;
                            Iterator it3 = it2;
                            List list4 = list2;
                            int i4 = i2;
                            ColumnMeasurePolicy columnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(4.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), horizontal2, gapComposer3, 6);
                            BiasAlignment.Horizontal horizontal3 = horizontal2;
                            int iHashCode6 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope6 = gapComposer3.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier6 = ZIndexModifierKt.materializeModifier(gapComposer3, companion);
                            ComposeUiNode.Companion.getClass();
                            gapComposer3.startReusableNode();
                            if (gapComposer3.inserting) {
                                gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                            } else {
                                gapComposer3.useNode();
                            }
                            Stack.m390setimpl(gapComposer3, columnMeasurePolicy5, updater$$ExternalSyntheticLambda3);
                            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope6, updater$$ExternalSyntheticLambda2);
                            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode6, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier6, updater$$ExternalSyntheticLambda0);
                            gapComposer3.startReplaceGroup(-920490412);
                            Iterator it4 = list3.iterator();
                            int i5 = 0;
                            while (it4.hasNext()) {
                                Object next2 = it4.next();
                                int i6 = i5 + 1;
                                if (i5 < 0) {
                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                    throw null;
                                }
                                String str6 = (String) next2;
                                Modifier modifierClip2 = ClipKt.clip(SizeKt.m155width3ABfNKs(companion, 120.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(4.0f));
                                if (i4 == 0 && ((Boolean) mutableState3.getValue()).booleanValue()) {
                                    gapComposer3.startReplaceGroup(215638716);
                                    StaticProvidableCompositionLocal staticProvidableCompositionLocal5 = MaterialThemeKt._localMaterialTheme;
                                    it = it4;
                                    long j5 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal5)).colorScheme.primaryContainer;
                                    gapComposer3.end(false);
                                    i = i3;
                                    z = false;
                                    j = j5;
                                    staticProvidableCompositionLocal = staticProvidableCompositionLocal5;
                                } else {
                                    it = it4;
                                    if (i5 == parcelableSnapshotMutableIntState4.getIntValue()) {
                                        gapComposer3.startReplaceGroup(215642941);
                                        StaticProvidableCompositionLocal staticProvidableCompositionLocal6 = MaterialThemeKt._localMaterialTheme;
                                        long j6 = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal6)).colorScheme.tertiaryContainer;
                                        z = false;
                                        gapComposer3.end(false);
                                        i = i3;
                                        staticProvidableCompositionLocal = staticProvidableCompositionLocal6;
                                        j = j6;
                                    } else {
                                        z = false;
                                        if (i5 == parcelableSnapshotMutableIntState5.getIntValue()) {
                                            gapComposer3.startReplaceGroup(215647166);
                                            staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                            i = i3;
                                            j = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.secondaryContainer;
                                            gapComposer3.end(false);
                                        } else {
                                            i = i3;
                                            if (i5 != parcelableSnapshotMutableIntState6.getIntValue() || parcelableSnapshotMutableIntState6.getIntValue() < 0) {
                                                z = false;
                                                gapComposer3.startReplaceGroup(215655542);
                                                staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                                j = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.background;
                                                gapComposer3.end(false);
                                            } else {
                                                gapComposer3.startReplaceGroup(215652093);
                                                staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                                j = ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.tertiaryContainer;
                                                z = false;
                                                gapComposer3.end(false);
                                            }
                                        }
                                    }
                                }
                                Modifier modifierM135padding3ABfNKs2 = OffsetKt.m135padding3ABfNKs(ImageKt.m39backgroundbw27NRU(modifierClip2, j, rectangleShapeKt$RectangleShape$1), 6.0f);
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, z);
                                BiasAlignment.Vertical vertical4 = vertical3;
                                RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$2 = rectangleShapeKt$RectangleShape$1;
                                int iHashCode7 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope7 = gapComposer3.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier7 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM135padding3ABfNKs2);
                                ComposeUiNode.Companion.getClass();
                                gapComposer3.startReusableNode();
                                if (gapComposer3.inserting) {
                                    gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                                } else {
                                    gapComposer3.useNode();
                                }
                                Stack.m390setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                                Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope7, updater$$ExternalSyntheticLambda2);
                                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode7, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                                Stack.m390setimpl(gapComposer3, modifierMaterializeModifier7, updater$$ExternalSyntheticLambda0);
                                TextKt.m352TextNvy7gAk(StringsKt.take(18, str6), null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, 0L, null, null, FontFamily.Monospace, 0L, null, 0L, 2, false, 2, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer3, 0, 24960, 110458);
                                gapComposer3.end(true);
                                i5 = i6;
                                vertical3 = vertical4;
                                it4 = it;
                                i3 = i;
                                rectangleShapeKt$RectangleShape$1 = rectangleShapeKt$RectangleShape$2;
                            }
                            gapComposer3.end(false);
                            gapComposer3.end(true);
                            it2 = it3;
                            list2 = list4;
                            horizontal2 = horizontal3;
                            i2 = i3;
                        }
                        list = list2;
                        vertical = vertical3;
                        gapComposer3.end(false);
                        gapComposer3.end(true);
                        gapComposer3.end(true);
                        gapComposer3.end(false);
                    }
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer3, 54);
                    int iHashCode8 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope8 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier8 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierFillMaxWidth);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope8, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode8, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier8, updater$$ExternalSyntheticLambda0);
                    boolean zBooleanValue = ((Boolean) mutableState3.getValue()).booleanValue();
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (objRememberedValue5 == neverEqualPolicy) {
                        mutableState = mutableState3;
                        objRememberedValue5 = new TooltipKt$$ExternalSyntheticLambda5(mutableState, (byte) 15);
                        gapComposer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        mutableState = mutableState3;
                    }
                    CardKt.Checkbox(zBooleanValue, (Function1) objRememberedValue5, null, false, null, gapComposer3, 48);
                    String strStringResource = MathKt.stringResource(R.string.first_row_is_header, gapComposer3);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal7 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal7)).colorScheme.onSurface, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal7)).typography.bodyMedium, gapComposer3, 0, 0, 131066);
                    gapComposer3.end(true);
                    String strStringResource2 = MathKt.stringResource(R.string.artist_name_column, gapComposer3);
                    int intValue = parcelableSnapshotMutableIntState4.getIntValue();
                    List list5 = (List) CollectionsKt.firstOrNull(list);
                    int size = list5 != null ? list5.size() : 0;
                    Object objRememberedValue6 = gapComposer3.rememberedValue();
                    if (objRememberedValue6 == neverEqualPolicy) {
                        parcelableSnapshotMutableIntState = parcelableSnapshotMutableIntState4;
                        objRememberedValue6 = new BottomSheetKt$$ExternalSyntheticLambda9(parcelableSnapshotMutableIntState, (byte) 4);
                        gapComposer3.updateRememberedValue(objRememberedValue6);
                    } else {
                        parcelableSnapshotMutableIntState = parcelableSnapshotMutableIntState4;
                    }
                    AlbumMenuKt.ColumnSelector(strStringResource2, intValue, size, false, (Function1) objRememberedValue6, gapComposer3, 24576, 8);
                    String strStringResource3 = MathKt.stringResource(R.string.song_title_column, gapComposer3);
                    int intValue2 = parcelableSnapshotMutableIntState5.getIntValue();
                    List list6 = (List) CollectionsKt.firstOrNull(list);
                    int size2 = list6 != null ? list6.size() : 0;
                    Object objRememberedValue7 = gapComposer3.rememberedValue();
                    if (objRememberedValue7 == neverEqualPolicy) {
                        parcelableSnapshotMutableIntState2 = parcelableSnapshotMutableIntState5;
                        objRememberedValue7 = new BottomSheetKt$$ExternalSyntheticLambda9(parcelableSnapshotMutableIntState2, (byte) 5);
                        gapComposer3.updateRememberedValue(objRememberedValue7);
                    } else {
                        parcelableSnapshotMutableIntState2 = parcelableSnapshotMutableIntState5;
                    }
                    AlbumMenuKt.ColumnSelector(strStringResource3, intValue2, size2, false, (Function1) objRememberedValue7, gapComposer3, 24576, 8);
                    String strStringResource4 = MathKt.stringResource(R.string.youtube_url_column, gapComposer3);
                    int intValue3 = parcelableSnapshotMutableIntState6.getIntValue();
                    List list7 = (List) CollectionsKt.firstOrNull(list);
                    int size3 = list7 != null ? list7.size() : 0;
                    Object objRememberedValue8 = gapComposer3.rememberedValue();
                    if (objRememberedValue8 == neverEqualPolicy) {
                        parcelableSnapshotMutableIntState3 = parcelableSnapshotMutableIntState6;
                        objRememberedValue8 = new BottomSheetKt$$ExternalSyntheticLambda9(parcelableSnapshotMutableIntState3, (byte) 3);
                        gapComposer3.updateRememberedValue(objRememberedValue8);
                    } else {
                        parcelableSnapshotMutableIntState3 = parcelableSnapshotMutableIntState6;
                    }
                    AlbumMenuKt.ColumnSelector(strStringResource4, intValue3, size3, true, (Function1) objRememberedValue8, gapComposer3, 27648, 0);
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13);
                    ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState7 = parcelableSnapshotMutableIntState2;
                    MutableState mutableState4 = mutableState;
                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 2, Alignment.Companion.End)), vertical, gapComposer3, 6);
                    int iHashCode9 = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope9 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier9 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierM139paddingqDBjuR0$default);
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, rowMeasurePolicy3, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope9, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode9, gapComposer3, updater$$ExternalSyntheticLambda1, gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier9, updater$$ExternalSyntheticLambda0);
                    GapComposer gapComposer4 = gapComposer3;
                    CardKt.OutlinedButton(function3, null, false, null, null, null, null, AlbumMenuKt.lambda$654868271, gapComposer4, 805306368, 510);
                    boolean zChanged = gapComposer4.changed(function4) | gapComposer4.changedInstance(csvImportState);
                    Object objRememberedValue9 = gapComposer4.rememberedValue();
                    if (zChanged || objRememberedValue9 == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda73 = new SongMenuKt$$ExternalSyntheticLambda73((Object) function4, (Object) csvImportState, (Object) parcelableSnapshotMutableIntState, (Object) parcelableSnapshotMutableIntState7, (State) parcelableSnapshotMutableIntState3, mutableState4, (byte) 8);
                        gapComposer4.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda73);
                        objRememberedValue9 = songMenuKt$$ExternalSyntheticLambda73;
                    }
                    CardKt.Button((Function0) objRememberedValue9, null, false, null, null, null, null, null, null, AlbumMenuKt.f138lambda$1827369299, gapComposer4, 805306368, 510);
                    gapComposer4.end(true);
                    gapComposer4.end(true);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 5:
                CoroutineScope coroutineScope2 = (CoroutineScope) obj7;
                LoginJsInterface loginJsInterface = (LoginJsInterface) obj8;
                Context context3 = (Context) obj6;
                MutableState mutableState5 = (MutableState) obj9;
                MutableState mutableState6 = (MutableState) obj5;
                MutableState mutableState7 = (MutableState) obj4;
                MutableState mutableState8 = (MutableState) obj3;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer4;
                if (gapComposer5.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    YouTubeAccount youTubeAccount = (YouTubeAccount) mutableState5.getValue();
                    boolean z4 = youTubeAccount != null && (youTubeAccount.isSelected || youTubeAccount.signinUrl != null);
                    boolean zChangedInstance4 = gapComposer5.changedInstance(coroutineScope2) | gapComposer5.changedInstance(loginJsInterface) | gapComposer5.changedInstance(context3);
                    Object objRememberedValue10 = gapComposer5.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue10 == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda29 songMenuKt$$ExternalSyntheticLambda29 = new SongMenuKt$$ExternalSyntheticLambda29(context3, mutableState5, mutableState6, mutableState7, mutableState8, loginJsInterface, coroutineScope2);
                        gapComposer5.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda29);
                        objRememberedValue10 = songMenuKt$$ExternalSyntheticLambda29;
                    }
                    CardKt.Button((Function0) objRememberedValue10, null, z4, null, null, null, null, null, null, AlbumScreenKt.lambda$738343358, gapComposer5, 805306368, 506);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 6:
                List list8 = (List) obj8;
                MutableState mutableState9 = (MutableState) obj9;
                MutableState mutableState10 = (MutableState) obj7;
                FocusRequester focusRequester = (FocusRequester) obj6;
                MutableState mutableState11 = (MutableState) obj5;
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj4;
                Function0 function5 = (Function0) obj3;
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer5;
                if (!gapComposer6.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else if (((Boolean) mutableState9.getValue()).booleanValue()) {
                    gapComposer6.startReplaceGroup(58055430);
                    TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.n_selected, list8.size(), new Object[]{Integer.valueOf(list8.size())}, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262142);
                    gapComposer6.end(false);
                } else if (((Boolean) mutableState10.getValue()).booleanValue()) {
                    gapComposer6.startReplaceGroup(58246576);
                    RowMeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.Top, gapComposer6, 0);
                    int iHashCode10 = Long.hashCode(gapComposer6.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope10 = gapComposer6.currentCompositionLocalScope();
                    Modifier modifierGlass = Modifier.Companion.$$INSTANCE;
                    Modifier modifierMaterializeModifier10 = ZIndexModifierKt.materializeModifier(gapComposer6, modifierGlass);
                    ComposeUiNode.Companion.getClass();
                    gapComposer6.startReusableNode();
                    if (gapComposer6.inserting) {
                        gapComposer6.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer6.useNode();
                    }
                    Stack.m390setimpl(gapComposer6, rowMeasurePolicy4, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer6, persistentCompositionLocalHashMapCurrentCompositionLocalScope10, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer6, Integer.valueOf(iHashCode10), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer6);
                    Stack.m390setimpl(gapComposer6, modifierMaterializeModifier10, updater$$ExternalSyntheticLambda0);
                    TextFieldValue textFieldValue = (TextFieldValue) mutableState11.getValue();
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge;
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, 3, 119);
                    TextFieldColors textFieldColorsM348colors0hiis_0 = TextFieldDefaults.m348colors0hiis_0(0L, 0L, 0L, 0L, gapComposer6, 2147469263);
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    if (UiStyleKt.isGlassStyle(gapComposer6)) {
                        gapComposer6.startReplaceGroup(-355565679);
                        modifierGlass = GlassComponentsKt.glass(modifierGlass, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer6, 6, 2);
                        z2 = false;
                    } else {
                        z2 = false;
                        gapComposer6.startReplaceGroup(-355564580);
                    }
                    gapComposer6.end(z2);
                    Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(layoutWeightElement.then(modifierGlass), focusRequester);
                    boolean zChanged2 = gapComposer6.changed(mutableState11);
                    Object objRememberedValue11 = gapComposer6.rememberedValue();
                    if (zChanged2 || objRememberedValue11 == neverEqualPolicy) {
                        objRememberedValue11 = new TooltipKt$$ExternalSyntheticLambda5(mutableState11, (byte) 29);
                        gapComposer6.updateRememberedValue(objRememberedValue11);
                    }
                    ScrimKt.TextField(textFieldValue, (Function1) objRememberedValue11, modifierFocusRequester, false, textStyle, AlbumScreenKt.lambda$202720367, null, keyboardOptions, null, true, 0, 0, null, textFieldColorsM348colors0hiis_0, gapComposer6, 12582912, 12779520, 4030296);
                    if (snapshotStateList.isEmpty()) {
                        z3 = false;
                        gapComposer6.startReplaceGroup(1862972046);
                        gapComposer6.end(false);
                    } else {
                        gapComposer6.startReplaceGroup(1862556894);
                        CardKt.IconButton(function5, null, false, null, null, AlbumScreenKt.lambda$31896045, gapComposer6, 1572864, 62);
                        z3 = false;
                        gapComposer6.end(false);
                    }
                    gapComposer6.end(true);
                    gapComposer6.end(z3);
                } else {
                    gapComposer6.startReplaceGroup(60136274);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.stats, gapComposer6), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer6, 0, 0, 262142);
                    gapComposer6.end(false);
                }
                return unit;
            case 7:
                return invoke$com$metrolist$music$ui$screens$playlist$LocalPlaylistScreenKt$$ExternalSyntheticLambda6(obj, obj2);
            default:
                MutableState mutableState12 = (MutableState) obj9;
                MutableState mutableState13 = (MutableState) obj8;
                Proxy.Type type = (Proxy.Type) obj7;
                Function1 function6 = (Function1) obj6;
                MutableState mutableState14 = (MutableState) obj5;
                MutableState mutableState15 = (MutableState) obj4;
                MutableState mutableState16 = (MutableState) obj3;
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer6;
                if (gapComposer7.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    Modifier modifierScroll$default3 = ImageKt.scroll$default(SizeKt.fillMaxWidth(companion2, 1.0f), ImageKt.rememberScrollState(gapComposer7), true);
                    ColumnMeasurePolicy columnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(12.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Start, gapComposer7, 6);
                    int iHashCode11 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope11 = gapComposer7.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier11 = ZIndexModifierKt.materializeModifier(gapComposer7, modifierScroll$default3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer7.startReusableNode();
                    if (gapComposer7.inserting) {
                        gapComposer7.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer7.useNode();
                    }
                    Stack.m390setimpl(gapComposer7, columnMeasurePolicy6, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope11, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer7, Integer.valueOf(iHashCode11), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer7);
                    Stack.m390setimpl(gapComposer7, modifierMaterializeModifier11, updater$$ExternalSyntheticLambda0);
                    boolean zBooleanValue2 = ((Boolean) mutableState13.getValue()).booleanValue();
                    Object objRememberedValue12 = gapComposer7.rememberedValue();
                    if (objRememberedValue12 == neverEqualPolicy) {
                        objRememberedValue12 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState13, (byte) 25);
                        gapComposer7.updateRememberedValue(objRememberedValue12);
                    }
                    CardKt.ExposedDropdownMenuBox(zBooleanValue2, (Function1) objRememberedValue12, SizeKt.fillMaxWidth(companion2, 1.0f), Expect_jvmKt.rememberComposableLambda(-3205046, new PlayerKt$$ExternalSyntheticLambda82(type, mutableState13, function6, (byte) 20), gapComposer7), gapComposer7, 3504);
                    String str7 = (String) mutableState12.getValue();
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion2, 1.0f);
                    boolean zChanged3 = gapComposer7.changed(mutableState12);
                    Object objRememberedValue13 = gapComposer7.rememberedValue();
                    if (zChanged3 || objRememberedValue13 == neverEqualPolicy) {
                        objRememberedValue13 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState12, (byte) 26);
                        gapComposer7.updateRememberedValue(objRememberedValue13);
                    }
                    ScrimKt.OutlinedTextField(str7, (Function1) objRememberedValue13, modifierFillMaxWidth2, false, false, null, AiSettingsKt.lambda$912482638, null, null, null, null, null, null, null, false, 0, 0, null, null, gapComposer7, 1573248, 0, 8388536);
                    Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion2, 1.0f);
                    RowMeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(OffsetKt.SpaceBetween, Alignment.Companion.CenterVertically, gapComposer7, 54);
                    int iHashCode12 = Long.hashCode(gapComposer7.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope12 = gapComposer7.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier12 = ZIndexModifierKt.materializeModifier(gapComposer7, modifierFillMaxWidth3);
                    gapComposer7.startReusableNode();
                    if (gapComposer7.inserting) {
                        gapComposer7.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer7.useNode();
                    }
                    Stack.m390setimpl(gapComposer7, rowMeasurePolicy5, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer7, persistentCompositionLocalHashMapCurrentCompositionLocalScope12, updater$$ExternalSyntheticLambda2);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode12, gapComposer7, updater$$ExternalSyntheticLambda1, gapComposer7);
                    Stack.m390setimpl(gapComposer7, modifierMaterializeModifier12, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.enable_authentication, gapComposer7), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                    boolean zBooleanValue3 = ((Boolean) mutableState14.getValue()).booleanValue();
                    boolean zChanged4 = gapComposer7.changed(mutableState14) | gapComposer7.changed(mutableState15) | gapComposer7.changed(mutableState16);
                    Object objRememberedValue14 = gapComposer7.rememberedValue();
                    if (zChanged4 || objRememberedValue14 == neverEqualPolicy) {
                        objRememberedValue14 = new TimePickerKt$$ExternalSyntheticLambda46(mutableState14, mutableState15, mutableState16, (byte) 3);
                        gapComposer7.updateRememberedValue(objRememberedValue14);
                    }
                    MenuKt.Switch(zBooleanValue3, (Function1) objRememberedValue14, null, null, false, null, gapComposer7, 0, 124);
                    gapComposer7.end(true);
                    CrossfadeKt.AnimatedVisibility(ColumnScopeInstance.INSTANCE, ((Boolean) mutableState14.getValue()).booleanValue(), null, null, null, null, Expect_jvmKt.rememberComposableLambda(497890060, new SearchScreenKt$$ExternalSyntheticLambda18(mutableState15, mutableState16, (byte) 1), gapComposer7), gapComposer7, 1572870, 30);
                    gapComposer7.end(true);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda78(Context context, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, LoginJsInterface loginJsInterface, CoroutineScope coroutineScope) {
        this.$r8$classId = (byte) 5;
        this.f$1 = coroutineScope;
        this.f$0 = loginJsInterface;
        this.f$2 = context;
        this.f$6 = mutableState;
        this.f$3 = mutableState2;
        this.f$4 = mutableState3;
        this.f$5 = mutableState4;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda78(ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, CoroutineScope coroutineScope, Context context, String str, PlayerConnection playerConnection, State state, MutableState mutableState) {
        this.$r8$classId = (byte) 0;
        this.f$0 = parcelableSnapshotMutableFloatState;
        this.f$1 = coroutineScope;
        this.f$2 = context;
        this.f$3 = str;
        this.f$4 = playerConnection;
        this.f$5 = state;
        this.f$6 = mutableState;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda78(SnapshotStateList snapshotStateList, FocusRequester focusRequester, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, State state, MutableState mutableState4) {
        this.$r8$classId = (byte) 7;
        this.f$0 = snapshotStateList;
        this.f$1 = focusRequester;
        this.f$6 = mutableState;
        this.f$2 = mutableState2;
        this.f$3 = mutableState3;
        this.f$5 = state;
        this.f$4 = mutableState4;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda78(Object obj, MutableState mutableState, MutableState mutableState2, Object obj2, MutableState mutableState3, Object obj3, Function function, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$6 = mutableState;
        this.f$1 = mutableState2;
        this.f$2 = obj2;
        this.f$3 = mutableState3;
        this.f$4 = obj3;
        this.f$5 = function;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda78(String str, String str2, String str3, String str4, Context context, Function0 function0, Function0 function1) {
        this.$r8$classId = (byte) 1;
        this.f$3 = str;
        this.f$0 = str2;
        this.f$1 = str3;
        this.f$4 = str4;
        this.f$2 = context;
        this.f$5 = function0;
        this.f$6 = function1;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda78(String str, String str2, String str3, String str4, LyricsPosition lyricsPosition, Function0 function0, Function4 function4, int i) {
        this.$r8$classId = (byte) 2;
        this.f$3 = str;
        this.f$0 = str2;
        this.f$1 = str3;
        this.f$2 = str4;
        this.f$4 = lyricsPosition;
        this.f$5 = function0;
        this.f$6 = function4;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda78(Function0 function0, Function5 function5, String str, String str2, String str3, List list, Map map, int i) {
        this.$r8$classId = (byte) 3;
        this.f$0 = function0;
        this.f$1 = function5;
        this.f$3 = str;
        this.f$2 = str2;
        this.f$4 = str3;
        this.f$5 = list;
        this.f$6 = map;
    }
}
