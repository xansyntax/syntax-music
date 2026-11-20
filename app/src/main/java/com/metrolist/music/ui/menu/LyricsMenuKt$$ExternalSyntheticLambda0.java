package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement$End$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda12;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.metrolist.music.constants.AddToPlaylistPosition;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.sse.ServerSentEventKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LyricsMenuKt$$ExternalSyntheticLambda0 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 2;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ MutableState f$7;
    public final /* synthetic */ State f$8;

    public /* synthetic */ LyricsMenuKt$$ExternalSyntheticLambda0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, AddToPlaylistPosition addToPlaylistPosition, MusicDatabase musicDatabase, SyncUtils syncUtils, Function0 function0, CoroutineScope coroutineScope) {
        this.f$2 = coroutineScope;
        this.f$3 = musicDatabase;
        this.f$4 = addToPlaylistPosition;
        this.f$5 = syncUtils;
        this.f$1 = function0;
        this.f$0 = mutableState;
        this.f$7 = mutableState2;
        this.f$6 = mutableState3;
        this.f$8 = mutableState4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v56 */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        TextFieldValue textFieldValue;
        MutableState mutableState;
        MutableState mutableState2;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3;
        MutableState mutableState3;
        MutableState mutableState4;
        MutableState mutableState5;
        ?? r4;
        boolean z;
        Material3MenuItemData material3MenuItemData;
        boolean z2;
        Function0 function0;
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        MutableState mutableState6 = this.f$7;
        MutableState mutableState7 = this.f$0;
        State state = this.f$8;
        Object obj4 = this.f$6;
        Unit unit = Unit.INSTANCE;
        Object obj5 = Composer.Companion.Empty;
        Object obj6 = this.f$5;
        Object obj7 = this.f$4;
        Object obj8 = this.f$2;
        Object obj9 = this.f$3;
        Object obj10 = this.f$1;
        byte b2 = 1;
        switch (b) {
            case 0:
                Function0 function1 = (Function0) obj10;
                Context context = (Context) obj8;
                TextFieldValue textFieldValue2 = (TextFieldValue) obj9;
                TextFieldValue textFieldValue3 = (TextFieldValue) obj7;
                LyricsMenuViewModel lyricsMenuViewModel = (LyricsMenuViewModel) obj6;
                MediaMetadata mediaMetadata = (MediaMetadata) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    MutableState mutableState8 = this.f$0;
                    boolean zChanged = gapComposer.changed(mutableState8);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == obj5) {
                        objRememberedValue = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState8, (byte) 21);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, AlbumMenuKt.f134lambda$1802438338, gapComposer, 805306368, 510);
                    OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 8.0f));
                    boolean zChanged2 = gapComposer.changed(mutableState8) | gapComposer.changed(function1) | gapComposer.changedInstance(context) | gapComposer.changed(textFieldValue2) | gapComposer.changed(textFieldValue3);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == obj5) {
                        SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40(function1, (Object) context, mutableState8, (Object) textFieldValue2, (Object) textFieldValue3, (byte) 5);
                        context = context;
                        textFieldValue = textFieldValue3;
                        gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                        objRememberedValue2 = songMenuKt$$ExternalSyntheticLambda40;
                    } else {
                        textFieldValue = textFieldValue3;
                    }
                    CardKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, AlbumMenuKt.f193lambda$358202905, gapComposer, 805306368, 510);
                    OffsetKt.Spacer(gapComposer, SizeKt.m155width3ABfNKs(companion, 8.0f));
                    boolean zChangedInstance = gapComposer.changedInstance(lyricsMenuViewModel) | gapComposer.changed(mediaMetadata) | gapComposer.changed(textFieldValue) | gapComposer.changed(textFieldValue2);
                    MutableState mutableState9 = this.f$7;
                    boolean zChanged3 = zChangedInstance | gapComposer.changed(mutableState9);
                    State state2 = this.f$8;
                    boolean zChanged4 = zChanged3 | gapComposer.changed(state2) | gapComposer.changedInstance(context);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged4 || objRememberedValue3 == obj5) {
                        objRememberedValue3 = new SongMenuKt$$ExternalSyntheticLambda29(lyricsMenuViewModel, mediaMetadata, textFieldValue, textFieldValue2, context, mutableState9, state2);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.TextButton((Function0) objRememberedValue3, null, false, null, null, null, AlbumMenuKt.f90lambda$1395213306, gapComposer, 805306368, 510);
                }
                break;
            case 1:
                String str = (String) obj10;
                String str2 = (String) obj9;
                String str3 = (String) obj7;
                Context context2 = (Context) obj8;
                String str4 = (String) obj6;
                MutableState mutableState10 = (MutableState) obj4;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 20.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer2, 0);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    boolean z3 = gapComposer2.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda4 = LayoutNode.Constructor;
                    if (z3) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda4);
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
                    String strStringResource = MathKt.stringResource(R.string.share_lyrics, gapComposer2);
                    FontWeight fontWeight = FontWeight.Bold;
                    long sp = IntMath.getSp(20);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strStringResource, null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, sp, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 1597440, 0, 262058);
                    OffsetKt.Spacer(gapComposer2, SizeKt.m145height3ABfNKs(companion, 16.0f));
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    State state3 = this.f$8;
                    boolean zChanged5 = gapComposer2.changed(state3) | gapComposer2.changed(str) | gapComposer2.changed(str2) | gapComposer2.changed(str3) | gapComposer2.changedInstance(context2) | gapComposer2.changed(str4);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    MutableState mutableState11 = this.f$0;
                    if (zChanged5 || objRememberedValue4 == obj5) {
                        objRememberedValue4 = new SongMenuKt$$ExternalSyntheticLambda29(context2, str4, str, str2, str3, state3, mutableState11);
                        mutableState = mutableState11;
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        mutableState = mutableState11;
                    }
                    MutableState mutableState12 = mutableState;
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth, false, null, (Function0) objRememberedValue4, 15), CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 1);
                    BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                    Arrangement$End$1 arrangement$End$1 = OffsetKt.Start;
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer2, 48);
                    int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda4);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.share, 0, gapComposer2), (String) null, (Modifier) null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer2, 56, 4);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 12.0f, gapComposer2, R.string.share_as_text, gapComposer2), null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, IntMath.getSp(16), null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 24576, 0, 262122);
                    gapComposer2.end(true);
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged6 = gapComposer2.changed(r24) | gapComposer2.changed(r25) | gapComposer2.changed(str3);
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    if (zChanged6 || objRememberedValue5 == obj5) {
                        objRememberedValue5 = new SongMenuKt$$ExternalSyntheticLambda73((Object) str, (Object) str2, (Object) str3, this.f$7, mutableState10, mutableState12, (byte) 7);
                        mutableState2 = mutableState12;
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    } else {
                        mutableState2 = mutableState12;
                    }
                    Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(ImageKt.m46clickableoSLSa3U$default(modifierFillMaxWidth2, false, null, (Function0) objRememberedValue5, 15), CropImageView.DEFAULT_ASPECT_RATIO, 12.0f, 1);
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$End$1, vertical, gapComposer2, 48);
                    int iHashCode3 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM137paddingVpY3zN4$default2);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        textKt$$ExternalSyntheticLambda3 = textKt$$ExternalSyntheticLambda4;
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.share, 0, gapComposer2), (String) null, (Modifier) null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.primary, gapComposer2, 56, 4);
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(companion, 12.0f, gapComposer2, R.string.share_as_image, gapComposer2), null, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.onSurface, IntMath.getSp(16), null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 24576, 0, 262122);
                    gapComposer2.end(true);
                    Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 5);
                    RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(OffsetKt.End, Alignment.Companion.Top, gapComposer2, 6);
                    int iHashCode4 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM139paddingqDBjuR0$default);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, rowMeasurePolicy3, updater$$ExternalSyntheticLambda0);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda1);
                    IntIntPair$$ExternalSyntheticOutline0.m(iHashCode4, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda3);
                    String strStringResource2 = MathKt.stringResource(R.string.cancel, gapComposer2);
                    long sp2 = IntMath.getSp(16);
                    long j = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme.error;
                    FontWeight fontWeight2 = FontWeight.Medium;
                    Object objRememberedValue6 = gapComposer2.rememberedValue();
                    if (objRememberedValue6 == obj5) {
                        objRememberedValue6 = new MainActivity$$ExternalSyntheticLambda29(mutableState2, (byte) 20);
                        gapComposer2.updateRememberedValue(objRememberedValue6);
                    }
                    TextKt.m352TextNvy7gAk(strStringResource2, OffsetKt.m136paddingVpY3zN4(ImageKt.m46clickableoSLSa3U$default(companion, false, null, (Function0) objRememberedValue6, 15), 12.0f, 8.0f), j, sp2, null, fontWeight2, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 1597440, 0, 262056);
                    gapComposer2.end(true);
                    gapComposer2.end(true);
                }
                break;
            case 2:
                CoroutineScope coroutineScope = (CoroutineScope) obj8;
                MusicDatabase musicDatabase = (MusicDatabase) obj9;
                AddToPlaylistPosition addToPlaylistPosition = (AddToPlaylistPosition) obj7;
                SyncUtils syncUtils = (SyncUtils) obj6;
                Function0 function2 = (Function0) obj10;
                MutableState mutableState13 = (MutableState) obj4;
                MutableState mutableState14 = (MutableState) state;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 17) != 16)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    boolean zChangedInstance2 = gapComposer3.changedInstance(coroutineScope) | gapComposer3.changedInstance(musicDatabase) | gapComposer3.changed(addToPlaylistPosition.ordinal()) | gapComposer3.changedInstance(syncUtils) | gapComposer3.changed(function2);
                    Object objRememberedValue7 = gapComposer3.rememberedValue();
                    MutableState mutableState15 = this.f$0;
                    MutableState mutableState16 = this.f$7;
                    if (zChangedInstance2 || objRememberedValue7 == obj5) {
                        mutableState3 = mutableState16;
                        mutableState4 = mutableState15;
                        objRememberedValue7 = new PlayerMenuKt$$ExternalSyntheticLambda106(mutableState4, mutableState3, mutableState13, mutableState14, addToPlaylistPosition, musicDatabase, syncUtils, function2, coroutineScope);
                        gapComposer3.updateRememberedValue(objRememberedValue7);
                    } else {
                        mutableState3 = mutableState16;
                        mutableState4 = mutableState15;
                    }
                    CardKt.TextButton((Function0) objRememberedValue7, null, false, null, null, null, AlbumMenuKt.lambda$55329440, gapComposer3, 805306368, 510);
                    boolean zChangedInstance3 = gapComposer3.changedInstance(coroutineScope) | gapComposer3.changedInstance(musicDatabase) | gapComposer3.changed(addToPlaylistPosition.ordinal()) | gapComposer3.changedInstance(syncUtils) | gapComposer3.changed(function2);
                    Object objRememberedValue8 = gapComposer3.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue8 == obj5) {
                        MutableState mutableState17 = mutableState3;
                        MutableState mutableState18 = mutableState4;
                        objRememberedValue8 = new AddToPlaylistDialogKt$$ExternalSyntheticLambda11(coroutineScope, mutableState18, mutableState17, mutableState13, musicDatabase, addToPlaylistPosition, syncUtils, function2, (byte) 0);
                        mutableState5 = mutableState18;
                        gapComposer3.updateRememberedValue(objRememberedValue8);
                    } else {
                        mutableState5 = mutableState4;
                    }
                    CardKt.TextButton((Function0) objRememberedValue8, null, false, null, null, null, AlbumMenuKt.lambda$1864769801, gapComposer3, 805306368, 510);
                    Object objRememberedValue9 = gapComposer3.rememberedValue();
                    if (objRememberedValue9 == obj5) {
                        objRememberedValue9 = new AlbumMenuKt$$ExternalSyntheticLambda6(mutableState5, (byte) 6);
                        gapComposer3.updateRememberedValue(objRememberedValue9);
                    }
                    CardKt.TextButton((Function0) objRememberedValue9, null, false, null, null, null, AlbumMenuKt.lambda$1693930344, gapComposer3, 805306374, 510);
                }
                break;
            case 3:
                Function0 function3 = (Function0) obj10;
                Function0 function4 = (Function0) obj9;
                Boolean bool = Boolean.FALSE;
                NavHostController navHostController = (NavHostController) obj7;
                PlayerConnection playerConnection = (PlayerConnection) obj6;
                Context context3 = (Context) obj8;
                ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) obj4;
                MutableState mutableState19 = (MutableState) state;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    gapComposer4.startReplaceGroup(1662064573);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.lambda$1210419695;
                    ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$2028315056;
                    ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f99lambda$1448756879;
                    boolean zChanged7 = gapComposer4.changed(function3) | gapComposer4.changed(function4);
                    Object objRememberedValue10 = gapComposer4.rememberedValue();
                    if (zChanged7 || objRememberedValue10 == obj5) {
                        objRememberedValue10 = new QueueMenuKt$$ExternalSyntheticLambda21(function3, function4, (byte) 4);
                        gapComposer4.updateRememberedValue(objRememberedValue10);
                    }
                    listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, composableLambdaImpl3, (Function0) objRememberedValue10, null, null, 48));
                    if (bool.equals(Boolean.TRUE)) {
                        r4 = 0;
                        gapComposer4.startReplaceGroup(1117233495);
                        gapComposer4.end(false);
                    } else {
                        gapComposer4.startReplaceGroup(1113446194);
                        ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.lambda$1413938676;
                        ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.lambda$1635850357;
                        ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.lambda$1857762038;
                        boolean zChangedInstance4 = gapComposer4.changedInstance(navHostController) | gapComposer4.changed(function4);
                        Object objRememberedValue11 = gapComposer4.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue11 == obj5) {
                            objRememberedValue11 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(navHostController, function4, (byte) 20);
                            gapComposer4.updateRememberedValue(objRememberedValue11);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl4, composableLambdaImpl5, composableLambdaImpl6, (Function0) objRememberedValue11, null, null, 48));
                        ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.lambda$448397917;
                        ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.f42lambda$1042841442;
                        ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.lambda$1760886495;
                        boolean zChangedInstance5 = gapComposer4.changedInstance(playerConnection) | gapComposer4.changedInstance(context3) | gapComposer4.changedInstance(managedActivityResultLauncher) | gapComposer4.changed(function4);
                        Object objRememberedValue12 = gapComposer4.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue12 == obj5) {
                            objRememberedValue12 = new SongMenuKt$$ExternalSyntheticLambda63((Object) playerConnection, (Object) context3, (Object) managedActivityResultLauncher, (Object) function4, (byte) 10);
                            gapComposer4.updateRememberedValue(objRememberedValue12);
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl7, composableLambdaImpl8, composableLambdaImpl9, (Function0) objRememberedValue12, null, null, 48));
                        ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.lambda$1869188220;
                        ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.lambda$377948861;
                        ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.f55lambda$1113290498;
                        boolean zChanged8 = gapComposer4.changed(mutableState7) | gapComposer4.changed(mutableState6) | gapComposer4.changed(mutableState19);
                        Object objRememberedValue13 = gapComposer4.rememberedValue();
                        if (zChanged8 || objRememberedValue13 == obj5) {
                            z = false;
                            objRememberedValue13 = new PlayerMenuKt$$ExternalSyntheticLambda65(mutableState7, mutableState6, mutableState19, (byte) 0);
                            gapComposer4.updateRememberedValue(objRememberedValue13);
                        } else {
                            z = false;
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl10, composableLambdaImpl11, composableLambdaImpl12, (Function0) objRememberedValue13, null, null, 48));
                        gapComposer4.end(z);
                        r4 = z;
                    }
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    gapComposer4.end(r4);
                    MenuKt.Material3MenuGroup(listBuilderBuild, gapComposer4, r4);
                }
                break;
            case 4:
                List list = (List) obj9;
                DownloadUtil downloadUtil = (DownloadUtil) obj7;
                PlaylistItem playlistItem = (PlaylistItem) obj6;
                Context context4 = (Context) obj8;
                Function0 function5 = (Function0) obj10;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) state;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    gapComposer5.startReplaceGroup(-252520815);
                    ListBuilder listBuilderCreateListBuilder2 = CollectionsKt__IterablesKt.createListBuilder();
                    if (list.isEmpty()) {
                        gapComposer5.startReplaceGroup(1355092758);
                        gapComposer5.end(false);
                    } else {
                        gapComposer5.startReplaceGroup(1352055037);
                        int intValue = parcelableSnapshotMutableIntState.getIntValue();
                        if (intValue == 0 || intValue == 2) {
                            gapComposer5.startReplaceGroup(1353232262);
                            ComposableLambdaImpl composableLambdaImpl13 = AlbumMenuKt.lambda$557940726;
                            ComposableLambdaImpl composableLambdaImpl14 = AlbumMenuKt.lambda$917355063;
                            Object objRememberedValue14 = gapComposer5.rememberedValue();
                            if (objRememberedValue14 == obj5) {
                                objRememberedValue14 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState7, (byte) 16);
                                gapComposer5.updateRememberedValue(objRememberedValue14);
                            }
                            material3MenuItemData = new Material3MenuItemData(composableLambdaImpl13, composableLambdaImpl14, null, (Function0) objRememberedValue14, null, null, 52);
                            z2 = false;
                            gapComposer5.end(false);
                        } else if (intValue != 3) {
                            gapComposer5.startReplaceGroup(1354091458);
                            ComposableLambdaImpl composableLambdaImpl15 = AlbumMenuKt.lambda$1522225558;
                            ComposableLambdaImpl composableLambdaImpl16 = AlbumMenuKt.lambda$874042455;
                            ComposableLambdaImpl composableLambdaImpl17 = AlbumMenuKt.lambda$225859352;
                            boolean zChangedInstance6 = gapComposer5.changedInstance(list) | gapComposer5.changedInstance(downloadUtil);
                            Object objRememberedValue15 = gapComposer5.rememberedValue();
                            if (zChangedInstance6 || objRememberedValue15 == obj5) {
                                objRememberedValue15 = new SelectionSongsMenuKt$$ExternalSyntheticLambda39(list, downloadUtil, (byte) 1);
                                gapComposer5.updateRememberedValue(objRememberedValue15);
                            }
                            material3MenuItemData = new Material3MenuItemData(composableLambdaImpl15, composableLambdaImpl16, composableLambdaImpl17, (Function0) objRememberedValue15, null, null, 48);
                            z2 = false;
                            gapComposer5.end(false);
                        } else {
                            gapComposer5.startReplaceGroup(1352141279);
                            ComposableLambdaImpl composableLambdaImpl18 = AlbumMenuKt.f44lambda$1049343475;
                            ComposableLambdaImpl composableLambdaImpl19 = AlbumMenuKt.f62lambda$1183047538;
                            Object objRememberedValue16 = gapComposer5.rememberedValue();
                            if (objRememberedValue16 == obj5) {
                                objRememberedValue16 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState7, (byte) 15);
                                gapComposer5.updateRememberedValue(objRememberedValue16);
                            }
                            material3MenuItemData = new Material3MenuItemData(composableLambdaImpl18, composableLambdaImpl19, null, (Function0) objRememberedValue16, null, null, 52);
                            z2 = false;
                            gapComposer5.end(false);
                        }
                        listBuilderCreateListBuilder2.add(material3MenuItemData);
                        gapComposer5.end(z2);
                    }
                    ComposableLambdaImpl composableLambdaImpl20 = AlbumMenuKt.lambda$76116112;
                    ComposableLambdaImpl composableLambdaImpl21 = AlbumMenuKt.f141lambda$1834410543;
                    Object objRememberedValue17 = gapComposer5.rememberedValue();
                    if (objRememberedValue17 == obj5) {
                        objRememberedValue17 = new SongMenuKt$$ExternalSyntheticLambda2(mutableState6, (byte) 17);
                        gapComposer5.updateRememberedValue(objRememberedValue17);
                    }
                    listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImpl20, composableLambdaImpl21, null, (Function0) objRememberedValue17, null, null, 52));
                    ComposableLambdaImpl composableLambdaImpl22 = AlbumMenuKt.lambda$1003799993;
                    ComposableLambdaImpl composableLambdaImpl23 = AlbumMenuKt.f47lambda$1061280070;
                    ComposableLambdaImpl composableLambdaImpl24 = AlbumMenuKt.lambda$1168607163;
                    boolean zChangedInstance7 = gapComposer5.changedInstance(playlistItem) | gapComposer5.changedInstance(context4) | gapComposer5.changed(function5);
                    Object objRememberedValue18 = gapComposer5.rememberedValue();
                    if (zChangedInstance7 || objRememberedValue18 == obj5) {
                        objRememberedValue18 = new GapComposer$$ExternalSyntheticLambda0(context4, function5, playlistItem, (byte) 28);
                        gapComposer5.updateRememberedValue(objRememberedValue18);
                    }
                    listBuilderCreateListBuilder2.add(new Material3MenuItemData(composableLambdaImpl22, composableLambdaImpl23, composableLambdaImpl24, (Function0) objRememberedValue18, null, null, 48));
                    gapComposer5.startReplaceGroup(1357762230);
                    gapComposer5.end(false);
                    ListBuilder listBuilderBuild2 = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder2);
                    gapComposer5.end(false);
                    MenuKt.Material3MenuGroup(listBuilderBuild2, gapComposer5, 0);
                }
                break;
            default:
                List list2 = (List) obj10;
                PlayerConnection playerConnection2 = (PlayerConnection) obj9;
                Context context5 = (Context) obj8;
                State state4 = (State) obj7;
                HapticFeedback hapticFeedback = (HapticFeedback) obj6;
                MenuState menuState = (MenuState) obj4;
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    MutableState mutableState20 = this.f$0;
                    String str5 = ((List) mutableState20.getValue()).size() + ServerSentEventKt.SPACE + MathKt.stringResource(R.string.songs, gapComposer6);
                    if (list2.isEmpty()) {
                        gapComposer6.startReplaceGroup(-2002587837);
                        gapComposer6.end(false);
                        function0 = null;
                    } else {
                        gapComposer6.startReplaceGroup(-2003088890);
                        boolean zChangedInstance8 = gapComposer6.changedInstance(playerConnection2) | gapComposer6.changedInstance(context5) | gapComposer6.changedInstance(list2);
                        Object objRememberedValue19 = gapComposer6.rememberedValue();
                        if (zChangedInstance8 || objRememberedValue19 == obj5) {
                            objRememberedValue19 = new StatsScreenKt$$ExternalSyntheticLambda17(playerConnection2, context5, list2, b2);
                            gapComposer6.updateRememberedValue(objRememberedValue19);
                        }
                        gapComposer6.end(false);
                        function0 = (Function0) objRememberedValue19;
                    }
                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                    MenuKt.NavigationTitle(str5, companion2, null, null, null, function0, gapComposer6, 48, 28);
                    boolean zChanged9 = gapComposer6.changed(mutableState20);
                    State state5 = this.f$8;
                    boolean zChanged10 = zChanged9 | gapComposer6.changed(state5) | gapComposer6.changed(state4);
                    MutableState mutableState21 = this.f$7;
                    boolean zChanged11 = zChanged10 | gapComposer6.changed(mutableState21) | gapComposer6.changedInstance(hapticFeedback) | gapComposer6.changed(menuState) | gapComposer6.changedInstance(playerConnection2);
                    Object objRememberedValue20 = gapComposer6.rememberedValue();
                    if (zChanged11 || objRememberedValue20 == obj5) {
                        objRememberedValue20 = new NavHostKt$$ExternalSyntheticLambda12(mutableState20, mutableState21, hapticFeedback, menuState, state5, playerConnection2, state4);
                        gapComposer6.updateRememberedValue(objRememberedValue20);
                    }
                    IntMath.LazyRow(companion2, null, null, null, null, null, false, null, (Function1) objRememberedValue20, gapComposer6, 6, 510);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ LyricsMenuKt$$ExternalSyntheticLambda0(MutableState mutableState, Function0 function0, Context context, TextFieldValue textFieldValue, TextFieldValue textFieldValue2, LyricsMenuViewModel lyricsMenuViewModel, MediaMetadata mediaMetadata, MutableState mutableState2, MutableState mutableState3) {
        this.f$0 = mutableState;
        this.f$1 = function0;
        this.f$2 = context;
        this.f$3 = textFieldValue;
        this.f$4 = textFieldValue2;
        this.f$5 = lyricsMenuViewModel;
        this.f$6 = mediaMetadata;
        this.f$7 = mutableState2;
        this.f$8 = mutableState3;
    }

    public /* synthetic */ LyricsMenuKt$$ExternalSyntheticLambda0(State state, String str, String str2, String str3, Context context, String str4, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        this.f$8 = state;
        this.f$1 = str;
        this.f$3 = str2;
        this.f$4 = str3;
        this.f$2 = context;
        this.f$5 = str4;
        this.f$0 = mutableState;
        this.f$7 = mutableState2;
        this.f$6 = mutableState3;
    }

    public /* synthetic */ LyricsMenuKt$$ExternalSyntheticLambda0(List list, DownloadUtil downloadUtil, PlaylistItem playlistItem, Context context, Function0 function0, Function0 function1, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState, MutableState mutableState2) {
        this.f$3 = list;
        this.f$4 = downloadUtil;
        this.f$5 = playlistItem;
        this.f$2 = context;
        this.f$1 = function0;
        this.f$6 = function1;
        this.f$8 = parcelableSnapshotMutableIntState;
        this.f$0 = mutableState;
        this.f$7 = mutableState2;
    }

    public /* synthetic */ LyricsMenuKt$$ExternalSyntheticLambda0(List list, PlayerConnection playerConnection, Context context, MutableState mutableState, State state, State state2, MutableState mutableState2, HapticFeedback hapticFeedback, MenuState menuState) {
        this.f$1 = list;
        this.f$3 = playerConnection;
        this.f$2 = context;
        this.f$0 = mutableState;
        this.f$8 = state;
        this.f$4 = state2;
        this.f$7 = mutableState2;
        this.f$5 = hapticFeedback;
        this.f$6 = menuState;
    }

    public /* synthetic */ LyricsMenuKt$$ExternalSyntheticLambda0(Function0 function0, Function0 function1, NavHostController navHostController, PlayerConnection playerConnection, Context context, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        this.f$1 = function0;
        this.f$3 = function1;
        this.f$4 = navHostController;
        this.f$5 = playerConnection;
        this.f$2 = context;
        this.f$6 = managedActivityResultLauncher;
        this.f$0 = mutableState;
        this.f$7 = mutableState2;
        this.f$8 = mutableState3;
    }
}
