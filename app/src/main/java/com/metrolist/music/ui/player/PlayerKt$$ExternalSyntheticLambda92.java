package com.metrolist.music.ui.player;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda5;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.TextAlign;
import coil3.compose.AsyncImagePainter;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda6;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.menu.PlayerMenuKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda25;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda26;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda37;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt;
import com.metrolist.music.ui.screens.settings.integrations.ListenTogetherSettingsKt;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda92 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda92(FocusRequester focusRequester, MutableState mutableState, LazyListState lazyListState, MutableState mutableState2, MutableState mutableState3) {
        this.$r8$classId = (byte) 9;
        this.f$0 = focusRequester;
        this.f$1 = mutableState;
        this.f$3 = lazyListState;
        this.f$2 = mutableState2;
        this.f$4 = mutableState3;
    }

    /* JADX WARN: Code duplicated, block: B:89:0x033d  */
    /* JADX WARN: Code duplicated, block: B:90:0x033f  */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean z;
        SongEntity songEntity;
        boolean z2;
        SongEntity songEntity2;
        String str;
        Context context;
        Object albumMenuKt$$ExternalSyntheticLambda40;
        Mutex mutex;
        MutableState mutableState;
        MusicAlarmEntry musicAlarmEntry;
        byte b = this.$r8$classId;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$4;
        Object obj4 = this.f$3;
        Object obj5 = this.f$2;
        Object obj6 = this.f$1;
        Object obj7 = this.f$0;
        switch (b) {
            case 0:
                PlayerConnection playerConnection = (PlayerConnection) obj7;
                MutableState mutableState2 = (MutableState) obj6;
                MutableState mutableState3 = (MutableState) obj5;
                MutableState mutableState4 = (MutableState) obj4;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChangedInstance = gapComposer.changedInstance(playerConnection) | gapComposer.changed(mutableState2) | gapComposer.changed(mutableState3);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        QueueKt$$ExternalSyntheticLambda15 queueKt$$ExternalSyntheticLambda15 = new QueueKt$$ExternalSyntheticLambda15(playerConnection, mutableState4, parcelableSnapshotMutableFloatState, mutableState2, mutableState3, (byte) 1);
                        gapComposer.updateRememberedValue(queueKt$$ExternalSyntheticLambda15);
                        objRememberedValue = queueKt$$ExternalSyntheticLambda15;
                    }
                    CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, QueueKt.lambda$1811824324, gapComposer, 805306368, 510);
                }
                break;
            case 1:
                Modifier modifier = (Modifier) obj7;
                MutableState mutableState5 = (MutableState) obj6;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj5;
                BasicTextContextMenuProvider basicTextContextMenuProvider = (BasicTextContextMenuProvider) obj4;
                Function0 function0 = (Function0) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda5(mutableState5, (byte) 7);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(modifier, (Function1) objRememberedValue2);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierOnGloballyPositioned);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer2);
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    composableLambdaImpl.invoke((Object) gapComposer2, (Object) 0);
                    basicTextContextMenuProvider.ContextMenu(function0, gapComposer2, 6);
                    gapComposer2.end(true);
                }
                break;
            case 2:
                ((Integer) obj2).getClass();
                MenuKt.LocalArtistsGrid((String) obj7, (String) obj6, (Function3) obj5, (String) obj4, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 3:
                CoroutineScope coroutineScope = (CoroutineScope) obj7;
                State state = (State) obj6;
                MusicDatabase musicDatabase = (MusicDatabase) obj5;
                Artist artist = (Artist) obj4;
                Function0 function1 = (Function0) obj3;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                    boolean zChanged = gapComposer3.changed(state) | gapComposer3.changedInstance(musicDatabase) | gapComposer3.changed(artist);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    Continuation continuation = null;
                    if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                        AsyncImagePainter.AnonymousClass1 anonymousClass1 = new AsyncImagePainter.AnonymousClass1(musicDatabase, artist, state, continuation, (byte) 15);
                        gapComposer3.updateRememberedValue(anonymousClass1);
                        objRememberedValue3 = anonymousClass1;
                    }
                    AwaitKt.launch$default(coroutineScope, defaultIoScheduler, null, (Function2) objRememberedValue3, 2);
                    function1.invoke();
                }
                break;
            case 4:
                MutableState mutableState6 = (MutableState) obj6;
                MutableState mutableState7 = (MutableState) obj5;
                MutableState mutableState8 = (MutableState) obj4;
                String str2 = (String) obj7;
                MutableState mutableState9 = (MutableState) obj3;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 20.0f);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.Start, gapComposer4, 6);
                    int iHashCode2 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierM135padding3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer4.startReusableNode();
                    if (gapComposer4.inserting) {
                        gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer4.useNode();
                    }
                    Stack.m390setimpl(gapComposer4, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer4, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer4);
                    Stack.m390setimpl(gapComposer4, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.listen_together_description, gapComposer4), null, CardKt.getColorScheme(gapComposer4).onSurfaceVariant, 0L, null, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer4).bodyMedium, gapComposer4, 0, 0, 130042);
                    String str3 = (String) mutableState6.getValue();
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
                    TextFieldColors textFieldColorsM347colors0hiis_0 = TextFieldDefaults.m347colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, CardKt.getColorScheme(gapComposer4).primary, CardKt.getColorScheme(gapComposer4).outline, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, CardKt.getColorScheme(gapComposer4).primary, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, gapComposer4, 3072, 2139088895, 4095);
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged2 = gapComposer4.changed(mutableState6);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new TooltipKt$$ExternalSyntheticLambda5(mutableState6, (byte) 18);
                        gapComposer4.updateRememberedValue(objRememberedValue4);
                    }
                    ScrimKt.OutlinedTextField(str3, (Function1) objRememberedValue4, modifierFillMaxWidth, false, false, null, AlbumMenuKt.f156lambda$1952796218, AlbumMenuKt.f251lambda$718731931, AlbumMenuKt.lambda$515332356, Expect_jvmKt.rememberComposableLambda(1749396643, new SongMenuKt$$ExternalSyntheticLambda37(mutableState6, (byte) 13), gapComposer4), null, null, null, null, true, 0, 0, roundedCornerShapeM185RoundedCornerShape0680j_4, textFieldColorsM347colors0hiis_0, gapComposer4, 920125824, 12582912, 1965112);
                    CardKt.m261HorizontalDivider9IZ8Weo(null, CropImageView.DEFAULT_ASPECT_RATIO, 0L, gapComposer4, 0, 7);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.join_existing_room, gapComposer4), null, CardKt.getColorScheme(gapComposer4).primary, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer4).titleSmall, gapComposer4, 1572864, 0, 131002);
                    String str4 = (String) mutableState7.getValue();
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
                    TextFieldColors textFieldColorsM347colors0hiis_1 = TextFieldDefaults.m347colors0hiis_0(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, CardKt.getColorScheme(gapComposer4).primary, CardKt.getColorScheme(gapComposer4).outline, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, CardKt.getColorScheme(gapComposer4).primary, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, gapComposer4, 3072, 2139088895, 4095);
                    Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                    boolean zChanged3 = gapComposer4.changed(mutableState7);
                    Object objRememberedValue5 = gapComposer4.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new TooltipKt$$ExternalSyntheticLambda5(mutableState7, (byte) 19);
                        gapComposer4.updateRememberedValue(objRememberedValue5);
                    }
                    ScrimKt.OutlinedTextField(str4, (Function1) objRememberedValue5, modifierFillMaxWidth2, false, false, null, AlbumMenuKt.f253lambda$730577539, AlbumMenuKt.f169lambda$205771428, AlbumMenuKt.lambda$319034683, null, Expect_jvmKt.rememberComposableLambda(1635480266, new SongMenuKt$$ExternalSyntheticLambda37(mutableState7, (byte) 14), gapComposer4), null, null, null, true, 0, 0, roundedCornerShapeM185RoundedCornerShape0680j_5, textFieldColorsM347colors0hiis_1, gapComposer4, 114819456, 12583296, 1961528);
                    if (((Boolean) mutableState8.getValue()).booleanValue()) {
                        gapComposer4.startReplaceGroup(-1072038956);
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        FlowRowOverflow flowRowOverflow = OffsetKt.Center;
                        Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer4, 54);
                        int iHashCode3 = Long.hashCode(gapComposer4.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer4.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer4, modifierFillMaxWidth3);
                        gapComposer4.startReusableNode();
                        if (gapComposer4.inserting) {
                            gapComposer4.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer4.useNode();
                        }
                        Stack.m390setimpl(gapComposer4, rowMeasurePolicy, updater$$ExternalSyntheticLambda3);
                        Stack.m390setimpl(gapComposer4, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer4, updater$$ExternalSyntheticLambda1, gapComposer4);
                        Stack.m390setimpl(gapComposer4, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                        DialogKt.m1464CircularProgressIndicatorLxG7B9w(2.0f, 0, 390, 24, CardKt.getColorScheme(gapComposer4).primary, 0L, gapComposer4, SizeKt.m151size3ABfNKs(companion, 18.0f));
                        OffsetKt.Spacer(gapComposer4, SizeKt.m155width3ABfNKs(companion, 8.0f));
                        TextKt.m352TextNvy7gAk(str2, null, CardKt.getColorScheme(gapComposer4).primary, 0L, null, FontWeight.Medium, null, 0L, null, 0L, 0, false, 0, 0, CardKt.getTypography(gapComposer4).bodyMedium, gapComposer4, 1572864, 0, 131002);
                        gapComposer4.end(true);
                        z = false;
                        gapComposer4.end(false);
                    } else {
                        z = false;
                        gapComposer4.startReplaceGroup(-1071027178);
                        gapComposer4.end(false);
                    }
                    String str5 = (String) mutableState9.getValue();
                    if (str5 == null) {
                        gapComposer4.startReplaceGroup(-1070936194);
                        gapComposer4.end(z);
                    } else {
                        gapComposer4.startReplaceGroup(-1070936193);
                        Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(companion, 1.0f);
                        RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_6 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f);
                        long j = CardKt.getColorScheme(gapComposer4).error;
                        SurfaceKt.m337SurfaceT9BRK9s(modifierFillMaxWidth4, roundedCornerShapeM185RoundedCornerShape0680j_6, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.1f, Color.m483getColorSpaceimpl(j)), 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(-936443661, new MainActivity$$ExternalSyntheticLambda6(str5, (byte) 17), gapComposer4), gapComposer4, 12582918, 120);
                        gapComposer4.end(false);
                    }
                    gapComposer4.end(true);
                }
                break;
            case 5:
                ((Integer) obj2).getClass();
                PlayerMenuKt.PlayerMenu((MediaMetadata) obj7, (BottomSheetState) obj6, (Boolean) obj5, (Function0) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 6:
                CoroutineScope coroutineScope2 = (CoroutineScope) obj7;
                State state2 = (State) obj6;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj5;
                ArtistItem artistItem = (ArtistItem) obj4;
                Function0 function2 = (Function0) obj3;
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                    DefaultIoScheduler defaultIoScheduler2 = DefaultIoScheduler.INSTANCE;
                    boolean zChanged4 = gapComposer5.changed(state2) | gapComposer5.changedInstance(musicDatabase2) | gapComposer5.changedInstance(artistItem);
                    Object objRememberedValue6 = gapComposer5.rememberedValue();
                    Continuation continuation2 = null;
                    if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                        AsyncImagePainter.AnonymousClass1 anonymousClass2 = new AsyncImagePainter.AnonymousClass1(musicDatabase2, artistItem, state2, continuation2, (byte) 20);
                        gapComposer5.updateRememberedValue(anonymousClass2);
                        objRememberedValue6 = anonymousClass2;
                    }
                    AwaitKt.launch$default(coroutineScope2, defaultIoScheduler2, null, (Function2) objRememberedValue6, 2);
                    function2.invoke();
                }
                break;
            case 7:
                SongItem songItem = (SongItem) obj7;
                State state3 = (State) obj6;
                MusicDatabase musicDatabase3 = (MusicDatabase) obj5;
                CoroutineScope coroutineScope3 = (CoroutineScope) obj4;
                SyncUtils syncUtils = (SyncUtils) obj3;
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    boolean z3 = songItem.isEpisode;
                    if (z3) {
                        Song song = (Song) state3.getValue();
                        if (((song == null || (songEntity2 = song.song) == null) ? null : songEntity2.inLibrary) != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        Song song2 = (Song) state3.getValue();
                        if (song2 == null || (songEntity = song2.song) == null || !songEntity.liked) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                    }
                    boolean zChanged5 = gapComposer6.changed(z3) | gapComposer6.changed(state3) | gapComposer6.changedInstance(musicDatabase3) | gapComposer6.changedInstance(songItem) | gapComposer6.changedInstance(coroutineScope3) | gapComposer6.changedInstance(syncUtils);
                    Object objRememberedValue7 = gapComposer6.rememberedValue();
                    if (zChanged5 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new SongMenuKt$$ExternalSyntheticLambda25(z3, musicDatabase3, coroutineScope3, state3, songItem, syncUtils);
                        gapComposer6.updateRememberedValue(objRememberedValue7);
                    }
                    CardKt.IconButton((Function0) objRememberedValue7, null, false, null, null, Expect_jvmKt.rememberComposableLambda(-1349840533, new SongMenuKt$$ExternalSyntheticLambda26((byte) 14, z2), gapComposer6), gapComposer6, 1572864, 62);
                }
                break;
            case 8:
                ((Integer) obj2).getClass();
                ListenTogetherScreenKt.UserActionDialog((String) obj7, (Function0) obj6, (Function0) obj5, (Function0) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 9:
                FocusRequester focusRequester = (FocusRequester) obj7;
                MutableState mutableState10 = (MutableState) obj6;
                LazyListState lazyListState = (LazyListState) obj4;
                MutableState mutableState11 = (MutableState) obj5;
                State state4 = (State) obj3;
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else if (((Boolean) mutableState11.getValue()).booleanValue()) {
                    gapComposer7.startReplaceGroup(1767004641);
                    TextFieldValue textFieldValue = (TextFieldValue) mutableState10.getValue();
                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer7.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge;
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, 3, 119);
                    TextFieldColors textFieldColorsM348colors0hiis_0 = TextFieldDefaults.m348colors0hiis_0(0L, 0L, 0L, 0L, gapComposer7, 2147469263);
                    Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(SizeKt.fillMaxWidth(companion, 1.0f), focusRequester);
                    boolean zChanged6 = gapComposer7.changed(mutableState10);
                    Object objRememberedValue8 = gapComposer7.rememberedValue();
                    if (zChanged6 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState10, (byte) 13);
                        gapComposer7.updateRememberedValue(objRememberedValue8);
                    }
                    ScrimKt.TextField(textFieldValue, (Function1) objRememberedValue8, modifierFocusRequester, false, textStyle, OnlinePodcastScreenKt.lambda$1117783938, null, keyboardOptions, null, true, 0, 0, null, textFieldColorsM348colors0hiis_0, gapComposer7, 12582912, 12779520, 4030296);
                    gapComposer7.end(false);
                } else if (lazyListState.getFirstVisibleItemIndex() <= 0) {
                    gapComposer7.startReplaceGroup(1768296566);
                    gapComposer7.end(false);
                } else {
                    gapComposer7.startReplaceGroup(1768233140);
                    PodcastItem podcastItem = (PodcastItem) state4.getValue();
                    if (podcastItem == null || (str = podcastItem.title) == null) {
                        str = "";
                    }
                    TextKt.m352TextNvy7gAk(str, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 0, 0, 262142);
                    gapComposer7.end(false);
                }
                break;
            case 10:
                ((Integer) obj2).getClass();
                AlarmSettingsKt.AlarmEditorDialog((MusicAlarmEntry) obj7, (List) obj6, (List) obj5, (Function0) obj4, (Function1) obj3, (Composer) obj, Stack.updateChangedFlags(3073));
                break;
            case 11:
                MusicAlarmEntry musicAlarmEntry2 = (MusicAlarmEntry) obj7;
                CoroutineScope coroutineScope4 = (CoroutineScope) obj5;
                Mutex mutex2 = (Mutex) obj4;
                Context context2 = (Context) obj3;
                MutableState mutableState12 = (MutableState) obj6;
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer8, 48);
                    int iHashCode4 = Long.hashCode(gapComposer8.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope4 = gapComposer8.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier4 = ZIndexModifierKt.materializeModifier(gapComposer8, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer8.startReusableNode();
                    if (gapComposer8.inserting) {
                        gapComposer8.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer8.useNode();
                    }
                    Stack.m390setimpl(gapComposer8, rowMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer8, persistentCompositionLocalHashMapCurrentCompositionLocalScope4, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer8, Integer.valueOf(iHashCode4), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer8);
                    Stack.m390setimpl(gapComposer8, modifierMaterializeModifier4, updater$$ExternalSyntheticLambda0);
                    boolean z4 = musicAlarmEntry2.enabled;
                    boolean zChangedInstance2 = gapComposer8.changedInstance(coroutineScope4) | gapComposer8.changedInstance(mutex2) | gapComposer8.changedInstance(context2) | gapComposer8.changedInstance(musicAlarmEntry2);
                    Object objRememberedValue9 = gapComposer8.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue9 == neverEqualPolicy) {
                        context = context2;
                        mutex = mutex2;
                        mutableState = mutableState12;
                        musicAlarmEntry = musicAlarmEntry2;
                        albumMenuKt$$ExternalSyntheticLambda40 = new AlbumMenuKt$$ExternalSyntheticLambda40(musicAlarmEntry, coroutineScope4, mutex, context, mutableState);
                        gapComposer8.updateRememberedValue(albumMenuKt$$ExternalSyntheticLambda40);
                    } else {
                        context = context2;
                        albumMenuKt$$ExternalSyntheticLambda40 = objRememberedValue9;
                        mutex = mutex2;
                        mutableState = mutableState12;
                        musicAlarmEntry = musicAlarmEntry2;
                    }
                    AlarmSettingsKt.AlarmSwitch(z4, (Function1) albumMenuKt$$ExternalSyntheticLambda40, false, gapComposer8, 0);
                    boolean zChangedInstance3 = gapComposer8.changedInstance(coroutineScope4) | gapComposer8.changedInstance(mutex) | gapComposer8.changedInstance(context) | gapComposer8.changedInstance(musicAlarmEntry);
                    Object objRememberedValue10 = gapComposer8.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue10 == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40((Object) musicAlarmEntry, (Object) coroutineScope4, (Object) mutex, (Object) context, (Object) mutableState, (byte) 28);
                        gapComposer8.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                        objRememberedValue10 = songMenuKt$$ExternalSyntheticLambda40;
                    }
                    CardKt.IconButton((Function0) objRememberedValue10, null, false, null, null, AiSettingsKt.f541lambda$289769226, gapComposer8, 1572864, 62);
                    gapComposer8.end(true);
                }
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ArrayList arrayList = (ArrayList) obj7;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj5;
                String str6 = (String) obj4;
                QueueKt$$ExternalSyntheticLambda21 queueKt$$ExternalSyntheticLambda21 = (QueueKt$$ExternalSyntheticLambda21) obj3;
                MutableState mutableState13 = (MutableState) obj6;
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (!gapComposer9.shouldExecute(1 & iIntValue9, (iIntValue9 & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    boolean zChangedInstance4 = gapComposer9.changedInstance(arrayList) | gapComposer9.changed(mimesKt$$ExternalSyntheticLambda0) | gapComposer9.changed(str6) | gapComposer9.changed(queueKt$$ExternalSyntheticLambda21);
                    Object objRememberedValue11 = gapComposer9.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue11 == neverEqualPolicy) {
                        AlbumMenuKt$$ExternalSyntheticLambda40 albumMenuKt$$ExternalSyntheticLambda41 = new AlbumMenuKt$$ExternalSyntheticLambda40((Object) arrayList, (Object) mimesKt$$ExternalSyntheticLambda0, mutableState13, str6, (Object) queueKt$$ExternalSyntheticLambda21, (byte) 16);
                        gapComposer9.updateRememberedValue(albumMenuKt$$ExternalSyntheticLambda41);
                        objRememberedValue11 = albumMenuKt$$ExternalSyntheticLambda41;
                    }
                    IntMath.LazyColumn(null, null, null, null, null, null, false, null, (Function1) objRememberedValue11, gapComposer9, 0, 511);
                }
                break;
            default:
                ((Integer) obj2).getClass();
                ListenTogetherSettingsKt.ServerChooserDialog((List) obj7, (String) obj6, (Function1) obj5, (Function1) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda92(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, String str, MutableState mutableState4) {
        this.$r8$classId = (byte) 4;
        this.f$1 = mutableState;
        this.f$2 = mutableState2;
        this.f$3 = mutableState3;
        this.f$0 = str;
        this.f$4 = mutableState4;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda92(Object obj, State state, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = state;
        this.f$2 = obj2;
        this.f$3 = obj3;
        this.f$4 = obj4;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda92(Object obj, Object obj2, Object obj3, Object obj4, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$2 = obj2;
        this.f$3 = obj3;
        this.f$4 = obj4;
        this.f$1 = mutableState;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda92(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = obj5;
    }
}
