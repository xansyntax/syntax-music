package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableScatterMap;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.AnimatedVisibilityScopeImpl;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuPopupPositionProviderKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.FadeInFadeOutState;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListIterator;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerElement;
import androidx.compose.ui.graphics.LayerOutsets;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.exoplayer.offline.Download;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.room.RoomDatabase$closeBarrier$1;
import coil3.ComponentRegistry$Builder$$ExternalSyntheticLambda2;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.innertubex.cipher.QuickJsEngine$evaluate$3;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda21;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.ConnectionState;
import com.metrolist.music.lyrics.LyricsUtils$$ExternalSyntheticLambda0;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetPageState;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.component.SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda120;
import com.metrolist.music.ui.screens.HomeSection;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$12$1;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt$$ExternalSyntheticLambda37;
import com.metrolist.music.ui.screens.recognition.RecognitionHistoryScreenKt;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$$ExternalSyntheticLambda30;
import com.metrolist.music.ui.screens.settings.integrations.DiscordSettingsKt$$ExternalSyntheticLambda78;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.ui.utils.ShowMediaInfoKt$$ExternalSyntheticLambda0;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.viewmodels.CachePlaylistViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.reflect.KFunction;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda34 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda34(MutableState mutableState, MutableState mutableState2, State state, UriHandler uriHandler) {
        this.$r8$classId = (byte) 20;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
        this.f$3 = state;
        this.f$2 = uriHandler;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:60:0x01bb  */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [boolean, int] */
    private final Object invoke$com$metrolist$music$ui$screens$ListenTogetherScreenKt$$ExternalSyntheticLambda57(Object obj, Object obj2, Object obj3) {
        ?? r9;
        long j;
        int i;
        int i2;
        long j2;
        float f;
        boolean z;
        GapComposer gapComposer;
        ConnectionState connectionState = (ConnectionState) this.f$0;
        Function0 function0 = (Function0) this.f$1;
        Function0 function1 = (Function0) this.f$2;
        Function0 function2 = (Function0) this.f$3;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((ColumnScopeInstance) obj).getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM135padding3ABfNKs = OffsetKt.m135padding3ABfNKs(companion, 16.0f);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.CenterHorizontally, gapComposer2, 48);
            int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM135padding3ABfNKs);
            ComposeUiNode.Companion.getClass();
            gapComposer2.startReusableNode();
            boolean z2 = gapComposer2.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z2) {
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
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            FlowRowOverflow flowRowOverflow = OffsetKt.Center;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer2, 54);
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
            Modifier modifierClip = ClipKt.clip(SizeKt.m151size3ABfNKs(companion, 10.0f), RoundedCornerShapeKt.CircleShape);
            int iOrdinal = connectionState.ordinal();
            if (iOrdinal == 0) {
                r9 = 0;
                gapComposer2.startReplaceGroup(158369601);
                j = CardKt.getColorScheme(gapComposer2).outline;
                gapComposer2.end(false);
            } else if (iOrdinal == 1) {
                r9 = 0;
                gapComposer2.startReplaceGroup(158363074);
                j = CardKt.getColorScheme(gapComposer2).tertiary;
                gapComposer2.end(false);
            } else if (iOrdinal == 2) {
                r9 = 0;
                gapComposer2.startReplaceGroup(158358785);
                j = CardKt.getColorScheme(gapComposer2).primary;
                gapComposer2.end(false);
            } else if (iOrdinal == 3) {
                r9 = 0;
                gapComposer2.startReplaceGroup(158363074);
                j = CardKt.getColorScheme(gapComposer2).tertiary;
                gapComposer2.end(false);
            } else {
                if (iOrdinal != 4) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer2, 158355441, false);
                }
                gapComposer2.startReplaceGroup(158366271);
                j = CardKt.getColorScheme(gapComposer2).error;
                r9 = 0;
                gapComposer2.end(false);
            }
            BoxKt.Box(ImageKt.m39backgroundbw27NRU(modifierClip, j, ColorKt.RectangleShape), gapComposer2, r9);
            OffsetKt.Spacer(gapComposer2, SizeKt.m155width3ABfNKs(companion, 10.0f));
            int iOrdinal2 = connectionState.ordinal();
            if (iOrdinal2 == 0) {
                i = 158393423;
                i2 = R.string.listen_together_disconnected;
            } else if (iOrdinal2 == 1) {
                i = 158382989;
                i2 = R.string.listen_together_connecting;
            } else if (iOrdinal2 == 2) {
                i = 158379500;
                i2 = R.string.listen_together_connected;
            } else if (iOrdinal2 == 3) {
                i = 158386575;
                i2 = R.string.listen_together_reconnecting;
            } else {
                if (iOrdinal2 != 4) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer2, 158377422, (boolean) r9);
                }
                i = 158389992;
                i2 = R.string.listen_together_error;
            }
            String strM = Format$$ExternalSyntheticOutline0.m(gapComposer2, i, i2, gapComposer2, (boolean) r9);
            TextStyle textStyle = CardKt.getTypography(gapComposer2).titleMedium;
            FontWeight fontWeight = FontWeight.Bold;
            int iOrdinal3 = connectionState.ordinal();
            if (iOrdinal3 == 0) {
                gapComposer2.startReplaceGroup(158414474);
                j2 = CardKt.getColorScheme(gapComposer2).onSurfaceVariant;
                gapComposer2.end(false);
            } else if (iOrdinal3 == 1) {
                gapComposer2.startReplaceGroup(158408706);
                j2 = CardKt.getColorScheme(gapComposer2).tertiary;
                gapComposer2.end(false);
            } else if (iOrdinal3 == 2) {
                gapComposer2.startReplaceGroup(158404801);
                j2 = CardKt.getColorScheme(gapComposer2).primary;
                gapComposer2.end(false);
            } else if (iOrdinal3 == 3) {
                gapComposer2.startReplaceGroup(158408706);
                j2 = CardKt.getColorScheme(gapComposer2).tertiary;
                gapComposer2.end(false);
            } else {
                if (iOrdinal3 != 4) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer2, 158401790, false);
                }
                gapComposer2.startReplaceGroup(158411519);
                j2 = CardKt.getColorScheme(gapComposer2).error;
                gapComposer2.end(false);
            }
            TextKt.m352TextNvy7gAk(strM, null, j2, 0L, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer2, 1572864, 0, 131002);
            GapComposer gapComposer3 = gapComposer2;
            gapComposer3.end(true);
            if (connectionState == ConnectionState.CONNECTING || connectionState == ConnectionState.RECONNECTING) {
                gapComposer3.startReplaceGroup(-2145273408);
                OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(companion, 12.0f));
                f = 12.0f;
                ProgressIndicatorKt.m310LinearProgressIndicatorrIrjwxo(CropImageView.DEFAULT_ASPECT_RATIO, 0, 0, 28, CardKt.getColorScheme(gapComposer3).primary, 0L, gapComposer3, ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(8.0f)));
                gapComposer3 = gapComposer3;
                gapComposer3.end(false);
            } else {
                gapComposer3.startReplaceGroup(-2144923604);
                gapComposer3.end(false);
                f = 12.0f;
            }
            OffsetKt.Spacer(gapComposer3, SizeKt.m145height3ABfNKs(companion, f));
            Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
            Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$SpacedAligned, Alignment.Companion.Top, gapComposer3, 6);
            int iHashCode3 = Long.hashCode(gapComposer3.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer3, modifierFillMaxWidth2);
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer3.useNode();
            }
            Stack.m390setimpl(gapComposer3, rowMeasurePolicy2, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode3, gapComposer3, updater$$ExternalSyntheticLambda2, gapComposer3);
            Stack.m390setimpl(gapComposer3, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda3);
            ConnectionState connectionState2 = ConnectionState.DISCONNECTED;
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            if (connectionState == connectionState2 || connectionState == ConnectionState.ERROR) {
                float f2 = f;
                z = true;
                gapComposer3.startReplaceGroup(-1928628099);
                Modifier modifierWeight = rowScopeInstance.weight(companion, 1.0f, true);
                RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(f2);
                PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                GapComposer gapComposer4 = gapComposer3;
                gapComposer = gapComposer4;
                CardKt.Button(function0, modifierWeight, false, roundedCornerShapeM185RoundedCornerShape0680j_4, ButtonDefaults.m247buttonColorsro_MJ88(CardKt.getColorScheme(gapComposer3).primary, 0L, 0L, gapComposer4, 14), null, null, null, null, AlbumScreenKt.lambda$1837818492, gapComposer, 805306368, 484);
                gapComposer.end(false);
            } else {
                gapComposer3.startReplaceGroup(-1927775475);
                Modifier modifierWeight2 = rowScopeInstance.weight(companion, 1.0f, true);
                RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(f);
                PaddingValuesImpl paddingValuesImpl2 = ButtonDefaults.ContentPadding;
                GapComposer gapComposer5 = gapComposer3;
                z = true;
                CardKt.Button(function1, modifierWeight2, false, roundedCornerShapeM185RoundedCornerShape0680j_5, ButtonDefaults.m247buttonColorsro_MJ88(CardKt.getColorScheme(gapComposer3).primary, 0L, 0L, gapComposer5, 14), null, null, null, null, AlbumScreenKt.f300lambda$1194829499, gapComposer5, 805306368, 484);
                CardKt.Button(function2, rowScopeInstance.weight(companion, 1.0f, true), false, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(f), null, null, null, null, null, AlbumScreenKt.f336lambda$950224900, gapComposer5, 805306368, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
                gapComposer = gapComposer5;
                gapComposer.end(false);
            }
            gapComposer.end(z);
            gapComposer.end(z);
        } else {
            gapComposer2.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$playlist$CachePlaylistScreenKt$$ExternalSyntheticLambda30(Object obj, Object obj2, Object obj3) {
        PlayerConnection playerConnection = (PlayerConnection) this.f$0;
        List list = (List) this.f$1;
        DownloadUtil downloadUtil = (DownloadUtil) this.f$2;
        MenuState menuState = (MenuState) this.f$3;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((ColumnScopeInstance) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            boolean zChangedInstance = gapComposer.changedInstance(playerConnection) | gapComposer.changedInstance(list);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new TopPlaylistScreenKt$$ExternalSyntheticLambda37(playerConnection, list, (byte) 4);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            boolean zChangedInstance2 = gapComposer.changedInstance(list) | gapComposer.changedInstance(downloadUtil);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            byte b = 2;
            if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new SelectionSongsMenuKt$$ExternalSyntheticLambda39(list, downloadUtil, b);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function1 = (Function0) objRememberedValue2;
            boolean zChanged = gapComposer.changed(menuState);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new HomeScreenKt$$ExternalSyntheticLambda120(menuState, (byte) 2);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            AlbumMenuKt.CachePlaylistMenu(function0, function1, (Function0) objRememberedValue3, gapComposer, 6);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$playlist$LocalPlaylistScreenKt$$ExternalSyntheticLambda37(Object obj, Object obj2, Object obj3) {
        Object next;
        Object next2;
        SnapshotStateList snapshotStateList = (SnapshotStateList) this.f$0;
        MenuState menuState = (MenuState) this.f$1;
        Function0 function0 = (Function0) this.f$2;
        MutableState mutableState = (MutableState) this.f$3;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((ColumnScopeInstance) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            ArrayList arrayList = new ArrayList();
            ListIterator listIterator = snapshotStateList.listIterator();
            while (true) {
                StateListIterator stateListIterator = (StateListIterator) listIterator;
                if (!stateListIterator.hasNext()) {
                    break;
                }
                int iIntValue2 = ((Number) stateListIterator.next()).intValue();
                Iterator it = ((List) mutableState.getValue()).iterator();
                do {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                } while (((PlaylistSong) next2).map.id != iIntValue2);
                PlaylistSong playlistSong = (PlaylistSong) next2;
                Song song = playlistSong != null ? playlistSong.song : null;
                if (song != null) {
                    arrayList.add(song);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            ListIterator listIterator2 = snapshotStateList.listIterator();
            while (true) {
                StateListIterator stateListIterator2 = (StateListIterator) listIterator2;
                if (!stateListIterator2.hasNext()) {
                    break;
                }
                int iIntValue3 = ((Number) stateListIterator2.next()).intValue();
                Iterator it2 = ((List) mutableState.getValue()).iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (((PlaylistSong) next).map.id != iIntValue3);
                PlaylistSong playlistSong2 = (PlaylistSong) next;
                PlaylistSongMap playlistSongMap = playlistSong2 != null ? playlistSong2.map : null;
                if (playlistSongMap != null) {
                    arrayList2.add(playlistSongMap);
                }
            }
            boolean zChanged = gapComposer.changed(menuState);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 17);
                gapComposer.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$1);
                objRememberedValue = autoPlaylistScreenKt$AutoPlaylistScreen$12$1;
            }
            YouTubeAlbumMenuKt.SelectionSongMenu(arrayList, (Function0) ((KFunction) objRememberedValue), function0, arrayList2, false, null, gapComposer, 384, 48);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$playlist$OnlinePlaylistScreenKt$$ExternalSyntheticLambda30(Object obj, Object obj2, Object obj3) {
        PlaylistItem playlistItem = (PlaylistItem) this.f$0;
        List list = (List) this.f$1;
        CoroutineScope coroutineScope = (CoroutineScope) this.f$2;
        MenuState menuState = (MenuState) this.f$3;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((ColumnScopeInstance) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            boolean zChanged = gapComposer.changed(menuState);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 18);
                gapComposer.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$1);
                objRememberedValue = autoPlaylistScreenKt$AutoPlaylistScreen$12$1;
            }
            YouTubeAlbumMenuKt.YouTubePlaylistMenu(playlistItem, list, coroutineScope, (Function0) ((KFunction) objRememberedValue), null, gapComposer, 0, 48);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$recognition$RecognitionHistoryScreenKt$$ExternalSyntheticLambda3(Object obj, Object obj2, Object obj3) {
        CoroutineScope coroutineScope = (CoroutineScope) this.f$0;
        MusicDatabase musicDatabase = (MusicDatabase) this.f$1;
        RecognitionHistory recognitionHistory = (RecognitionHistory) this.f$2;
        MutableState mutableState = (MutableState) this.f$3;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((RowScope) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState, (byte) 27);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, RecognitionHistoryScreenKt.f423lambda$879373225, gapComposer, 805306374, 510);
            boolean zChangedInstance = gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(musicDatabase) | gapComposer.changedInstance(recognitionHistory);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new AlarmSettingsKt$$ExternalSyntheticLambda30(coroutineScope, musicDatabase, recognitionHistory, mutableState, (byte) 4);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            CardKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, RecognitionHistoryScreenKt.f418lambda$1971355648, gapComposer, 805306368, 510);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AlarmSettingsKt$$ExternalSyntheticLambda16(Object obj, Object obj2, Object obj3) {
        List list = (List) this.f$0;
        String str = (String) this.f$1;
        MutableState mutableState = (MutableState) this.f$2;
        MutableState mutableState2 = (MutableState) this.f$3;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((ColumnScopeInstance) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            gapComposer.skipToGroupEnd();
        } else if (list.isEmpty()) {
            gapComposer.startReplaceGroup(2139879005);
            TextKt.m352TextNvy7gAk(str, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(2140033137);
            Modifier modifierM147heightInVpY3zN4$default = SizeKt.m147heightInVpY3zN4$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), CropImageView.DEFAULT_ASPECT_RATIO, 380.0f, 1);
            boolean zChangedInstance = gapComposer.changedInstance(list);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new MainActivity$$ExternalSyntheticLambda21((Object) list, (Object) mutableState, (Object) mutableState2, (byte) 26);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            IntMath.LazyColumn(modifierM147heightInVpY3zN4$default, null, null, null, null, null, false, null, (Function1) objRememberedValue, gapComposer, 6, 510);
            gapComposer.end(false);
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$ChangelogScreenKt$$ExternalSyntheticLambda7(Object obj, Object obj2, Object obj3) {
        MutableState mutableState = (MutableState) this.f$0;
        MutableState mutableState2 = (MutableState) this.f$1;
        State state = (State) this.f$3;
        UriHandler uriHandler = (UriHandler) this.f$2;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((ColumnScopeInstance) obj).getClass();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM1479glassOverlay6a0pyJM = GlassComponentsKt.m1479glassOverlay6a0pyJM(SizeKt.fillMaxWidth(companion, 1.0f), GlassComponentsKt.m1482glassTopShapeixp7dh8(16.0f, gapComposer), gapComposer);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM1479glassOverlay6a0pyJM);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            Arrangement$SpacedAligned arrangement$SpacedAligned = new Arrangement$SpacedAligned(16.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
            byte b = 7;
            PaddingValuesImpl paddingValuesImplM128PaddingValuesa9UjIt4$default = OffsetKt.m128PaddingValuesa9UjIt4$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 80.0f, 7);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new AlbumMenuKt$$ExternalSyntheticLambda8(mutableState, mutableState2, b);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            IntMath.LazyColumn(modifierM137paddingVpY3zN4$default, null, paddingValuesImplM128PaddingValuesa9UjIt4$default, arrangement$SpacedAligned, null, null, false, null, (Function1) objRememberedValue, gapComposer, 805331334, 490);
            boolean zBooleanValue = ((Boolean) state.getValue()).booleanValue();
            EnterTransitionImpl enterTransitionImplFadeIn$default = EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 13);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            EnterTransitionImpl enterTransitionImplPlus = enterTransitionImplFadeIn$default.plus(EnterExitTransitionKt.slideInVertically$default(1, (Function1) objRememberedValue2));
            ExitTransitionImpl exitTransitionImplFadeOut$default = EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 13);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            CrossfadeKt.AnimatedVisibility(zBooleanValue, OffsetKt.m135padding3ABfNKs(BoxScopeInstance.INSTANCE.align(companion, Alignment.Companion.BottomEnd), 16.0f), enterTransitionImplPlus, exitTransitionImplFadeOut$default.plus(EnterExitTransitionKt.slideOutVertically$default(1, (Function1) objRememberedValue3)), null, Expect_jvmKt.rememberComposableLambda(-1629532149, new ListItemKt$$ExternalSyntheticLambda17((byte) 21, (Object) uriHandler), gapComposer), gapComposer, 200064, 16);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$integrations$DiscordSettingsKt$$ExternalSyntheticLambda34(Object obj, Object obj2, Object obj3) {
        Function1 function1 = (Function1) this.f$0;
        Function0 function0 = (Function0) this.f$1;
        MutableState mutableState = (MutableState) this.f$2;
        String str = (String) this.f$3;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        ((ColumnScopeInstance) obj).getClass();
        byte b = 0;
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
            String str2 = (String) mutableState.getValue();
            TextFieldColors textFieldColorsColors = TextFieldDefaults.colors(6, gapComposer);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, 7, 119);
            boolean zChanged = gapComposer.changed(function1) | gapComposer.changed(function0);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new MainActivity$$ExternalSyntheticLambda21((Object) function1, (Object) function0, (Object) mutableState, (byte) 29);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            KeyboardActions keyboardActions = new KeyboardActions((Function1) objRememberedValue, null, 62);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 28);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            ScrimKt.OutlinedTextField(str2, (Function1) objRememberedValue2, modifierFillMaxWidth, false, false, null, null, Expect_jvmKt.rememberComposableLambda(-1062327511, new ShowMediaInfoKt$$ExternalSyntheticLambda0(str, (byte) 12), gapComposer), null, null, null, null, keyboardOptions, keyboardActions, true, 0, 0, null, textFieldColorsColors, gapComposer, 12583344, 12779520, 3964792);
            OffsetKt.Spacer(gapComposer, SizeKt.m145height3ABfNKs(companion, 12.0f));
            OffsetKt.FlowRow(null, new Arrangement$SpacedAligned(6.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), new Arrangement$SpacedAligned(4.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), null, 0, 0, Expect_jvmKt.rememberComposableLambda(1617981181, new DiscordSettingsKt$$ExternalSyntheticLambda78(mutableState, b), gapComposer), gapComposer, 1573296, 57);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Material3MenuItemData material3MenuItemData;
        Modifier modifier;
        Object obj4;
        boolean z;
        final Function0 function0;
        final LazyItemScopeImpl lazyItemScopeImpl;
        Material3MenuItemData material3MenuItemData2;
        byte b = this.$r8$classId;
        byte b2 = 28;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        byte b3 = 19;
        byte b4 = 2;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.f$3;
        Object obj6 = this.f$2;
        Object obj7 = this.f$0;
        Object obj8 = this.f$1;
        switch (b) {
            case 0:
                final Context context = (Context) obj7;
                final Song song = (Song) obj8;
                DownloadUtil downloadUtil = (DownloadUtil) obj6;
                State state = (State) obj5;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    Download download = (Download) state.getValue();
                    Integer numValueOf = download != null ? Integer.valueOf(download.state) : null;
                    if (numValueOf != null && numValueOf.intValue() == 3) {
                        gapComposer.startReplaceGroup(-1363796327);
                        ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.f247lambda$67742123;
                        ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$566556886;
                        boolean zChangedInstance = gapComposer.changedInstance(context) | gapComposer.changed(song);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                            final byte b5 = false ? (byte) 1 : (byte) 0;
                            objRememberedValue = new Function0() { // from class: com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda52
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b6 = b5;
                                    Unit unit2 = Unit.INSTANCE;
                                    Song song2 = song;
                                    Context context2 = context;
                                    switch (b6) {
                                        case 0:
                                            DownloadService.sendRemoveDownload(context2, song2.song.id);
                                            break;
                                        default:
                                            DownloadService.sendRemoveDownload(context2, song2.song.id);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, null, (Function0) objRememberedValue, null, null, 52);
                        gapComposer.end(false);
                    } else if ((numValueOf != null && numValueOf.intValue() == 0) || (numValueOf != null && numValueOf.intValue() == 2)) {
                        gapComposer.startReplaceGroup(-1362570432);
                        ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.f115lambda$1588512706;
                        ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.f151lambda$1912521089;
                        boolean zChangedInstance2 = gapComposer.changedInstance(context) | gapComposer.changed(song);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                            final byte b6 = true ? (byte) 1 : (byte) 0;
                            objRememberedValue2 = new Function0() { // from class: com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda52
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b7 = b6;
                                    Unit unit2 = Unit.INSTANCE;
                                    Song song2 = song;
                                    Context context2 = context;
                                    switch (b7) {
                                        case 0:
                                            DownloadService.sendRemoveDownload(context2, song2.song.id);
                                            break;
                                        default:
                                            DownloadService.sendRemoveDownload(context2, song2.song.id);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl3, composableLambdaImpl4, null, (Function0) objRememberedValue2, null, null, 52);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-1361554965);
                        ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.lambda$215386590;
                        ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.lambda$792582303;
                        ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.lambda$1369778016;
                        boolean zChangedInstance3 = gapComposer.changedInstance(downloadUtil) | gapComposer.changed(song);
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) downloadUtil, (Object) song, (byte) 24);
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        material3MenuItemData = new Material3MenuItemData(composableLambdaImpl5, composableLambdaImpl6, composableLambdaImpl7, (Function0) objRememberedValue3, null, null, 48);
                        gapComposer.end(false);
                    }
                    MenuKt.Material3MenuGroup(CollectionsKt__IterablesKt.listOf(material3MenuItemData), gapComposer, 0);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj8;
                AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) obj6;
                ComposableLambdaImpl composableLambdaImpl8 = (ComposableLambdaImpl) obj5;
                AnimatedVisibilityScope animatedVisibilityScope = (AnimatedVisibilityScope) obj;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= (iIntValue2 & 8) == 0 ? ((GapComposer) composer2).changed(animatedVisibilityScope) : ((GapComposer) composer2).changedInstance(animatedVisibilityScope) ? (byte) 4 : (byte) 2;
                }
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    boolean zChanged = gapComposer2.changed(snapshotStateList) | gapComposer2.changedInstance(obj7) | gapComposer2.changedInstance(animatedContentTransitionScopeImpl);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new UtilsKt$$ExternalSyntheticLambda0(snapshotStateList, obj7, animatedContentTransitionScopeImpl, true ? (byte) 1 : (byte) 0);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    Stack.DisposableEffect(animatedVisibilityScope, obj7, (Function1) objRememberedValue4, gapComposer2);
                    MutableScatterMap mutableScatterMap = animatedContentTransitionScopeImpl.targetSizeMap;
                    animatedVisibilityScope.getClass();
                    mutableScatterMap.set(obj7, ((AnimatedVisibilityScopeImpl) animatedVisibilityScope).targetSize);
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    if (objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new AnimatedContentScopeImpl();
                        gapComposer2.updateRememberedValue(objRememberedValue5);
                    }
                    composableLambdaImpl8.invoke(objRememberedValue5, obj7, (Object) gapComposer2, (Object) 0);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                Function2 function2 = (Function2) obj7;
                ContextMenuScope contextMenuScope = (ContextMenuScope) obj8;
                Function3 function3 = (Function3) obj6;
                Function0 function1 = (Function0) obj5;
                ContextMenuColors contextMenuColors = (ContextMenuColors) obj;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                if ((iIntValue3 & 6) == 0) {
                    iIntValue3 |= ((GapComposer) composer3).changed(contextMenuColors) ? (byte) 4 : (byte) 2;
                }
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 19) != 18)) {
                    String str = (String) function2.invoke(gapComposer3, 0);
                    if (StringsKt.isBlank(str)) {
                        InlineClassHelperKt.throwIllegalStateException("Label must not be blank");
                    }
                    contextMenuScope.getClass();
                    ContextMenuPopupPositionProviderKt.f1lambda$1571120048.invoke(str, Boolean.TRUE, contextMenuColors, function3, function1, gapComposer3, Integer.valueOf((iIntValue3 << 9) & 7168));
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 3:
                SolidColor solidColor = (SolidColor) obj7;
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) obj8;
                TextFieldValue textFieldValue = (TextFieldValue) obj6;
                OffsetMapping offsetMapping = (OffsetMapping) obj5;
                Modifier modifier2 = (Modifier) obj;
                ((Integer) obj3).getClass();
                GapComposer gapComposer4 = (GapComposer) ((Composer) obj2);
                gapComposer4.startReplaceGroup(-84507373);
                boolean zBooleanValue = ((Boolean) gapComposer4.consume(CompositionLocalsKt.LocalCursorBlinkEnabled)).booleanValue();
                boolean zChanged2 = gapComposer4.changed(zBooleanValue);
                Object objRememberedValue6 = gapComposer4.rememberedValue();
                if (zChanged2 || objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = new CursorAnimationState(zBooleanValue);
                    gapComposer4.updateRememberedValue(objRememberedValue6);
                }
                CursorAnimationState cursorAnimationState = (CursorAnimationState) objRememberedValue6;
                boolean z2 = solidColor.value != 16;
                if (((LazyWindowInfo) ((WindowInfo) gapComposer4.consume(CompositionLocalsKt.LocalWindowInfo))).isWindowFocused() && legacyTextFieldState.getHasFocus() && TextRange.m741getCollapsedimpl(textFieldValue.selection) && z2) {
                    gapComposer4.startReplaceGroup(-707487962);
                    AnnotatedString annotatedString = textFieldValue.annotatedString;
                    TextRange textRange = new TextRange(textFieldValue.selection);
                    boolean zChangedInstance4 = gapComposer4.changedInstance(cursorAnimationState);
                    Object objRememberedValue7 = gapComposer4.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new SyncUtils.AnonymousClass2(cursorAnimationState, null, (byte) 7);
                        gapComposer4.updateRememberedValue(objRememberedValue7);
                    }
                    Stack.LaunchedEffect(annotatedString, textRange, (Function2) objRememberedValue7, gapComposer4);
                    boolean zChangedInstance5 = gapComposer4.changedInstance(cursorAnimationState) | gapComposer4.changedInstance(offsetMapping) | gapComposer4.changed(textFieldValue) | gapComposer4.changedInstance(legacyTextFieldState) | gapComposer4.changed(solidColor);
                    Object objRememberedValue8 = gapComposer4.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue8 == neverEqualPolicy) {
                        AlbumMenuKt$$ExternalSyntheticLambda40 albumMenuKt$$ExternalSyntheticLambda40 = new AlbumMenuKt$$ExternalSyntheticLambda40((Object) cursorAnimationState, (Object) offsetMapping, (Object) textFieldValue, (Object) legacyTextFieldState, (Object) solidColor, (byte) 3);
                        gapComposer4.updateRememberedValue(albumMenuKt$$ExternalSyntheticLambda40);
                        objRememberedValue8 = albumMenuKt$$ExternalSyntheticLambda40;
                    }
                    Modifier modifierDrawWithContent = ClipKt.drawWithContent(modifier2, (Function1) objRememberedValue8);
                    gapComposer4.end(false);
                    modifier = modifierDrawWithContent;
                } else {
                    gapComposer4.startReplaceGroup(-705473241);
                    gapComposer4.end(false);
                    modifier = companion;
                }
                gapComposer4.end(false);
                return modifier;
            case 4:
                float f = CropImageView.DEFAULT_ASPECT_RATIO;
                SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) obj7;
                SnackbarHostState.SnackbarDataImpl snackbarDataImpl2 = (SnackbarHostState.SnackbarDataImpl) obj8;
                FadeInFadeOutState fadeInFadeOutState = (FadeInFadeOutState) obj6;
                String str2 = (String) obj5;
                Function2 function4 = (Function2) obj;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                if ((iIntValue4 & 6) == 0) {
                    iIntValue4 |= ((GapComposer) composer4).changedInstance(function4) ? (byte) 4 : (byte) 2;
                }
                GapComposer gapComposer5 = (GapComposer) composer4;
                if (gapComposer5.shouldExecute(iIntValue4 & 1, (iIntValue4 & 19) != 18)) {
                    boolean zAreEqual = Intrinsics.areEqual(snackbarDataImpl, snackbarDataImpl2);
                    FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs = CardKt.m272valueyDoVZcs(4, gapComposer5);
                    boolean zChanged3 = gapComposer5.changed(snackbarDataImpl) | gapComposer5.changedInstance(fadeInFadeOutState);
                    Object objRememberedValue9 = gapComposer5.rememberedValue();
                    if (zChanged3 || objRememberedValue9 == neverEqualPolicy) {
                        obj4 = objRememberedValue9;
                        Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda6 = new Recomposer$$ExternalSyntheticLambda6(snackbarDataImpl, fadeInFadeOutState, b3);
                        gapComposer5.updateRememberedValue(recomposer$$ExternalSyntheticLambda6);
                        obj4 = recomposer$$ExternalSyntheticLambda6;
                    }
                    Function0 function5 = (Function0) obj4;
                    Object objRememberedValue10 = gapComposer5.rememberedValue();
                    Object obj9 = objRememberedValue10;
                    if (objRememberedValue10 == neverEqualPolicy) {
                        if (!zAreEqual) {
                            f = 1.0f;
                        }
                        Animatable animatableAnimatable$default = ArcSplineKt.Animatable$default(f);
                        gapComposer5.updateRememberedValue(animatableAnimatable$default);
                        obj9 = animatableAnimatable$default;
                    }
                    Animatable animatable = (Animatable) obj9;
                    Boolean boolValueOf = Boolean.valueOf(zAreEqual);
                    boolean zChangedInstance6 = gapComposer5.changedInstance(animatable) | gapComposer5.changed(zAreEqual) | gapComposer5.changedInstance(finiteAnimationSpecM272valueyDoVZcs) | gapComposer5.changed(function5);
                    Object objRememberedValue11 = gapComposer5.rememberedValue();
                    if (zChangedInstance6 || objRememberedValue11 == neverEqualPolicy) {
                        objRememberedValue11 = new QuickJsEngine$evaluate$3(animatable, zAreEqual, finiteAnimationSpecM272valueyDoVZcs, function5, (Continuation) null);
                        z = zAreEqual;
                        gapComposer5.updateRememberedValue(objRememberedValue11);
                    } else {
                        z = zAreEqual;
                    }
                    Stack.LaunchedEffect(gapComposer5, boolValueOf, (Function2) objRememberedValue11);
                    AnimationState animationState = animatable.internalState;
                    FiniteAnimationSpec finiteAnimationSpecM272valueyDoVZcs2 = CardKt.m272valueyDoVZcs(1, gapComposer5);
                    Object objRememberedValue12 = gapComposer5.rememberedValue();
                    Object obj10 = objRememberedValue12;
                    if (objRememberedValue12 == neverEqualPolicy) {
                        Animatable animatableAnimatable$default2 = ArcSplineKt.Animatable$default(!z ? 1.0f : 0.8f);
                        gapComposer5.updateRememberedValue(animatableAnimatable$default2);
                        obj10 = animatableAnimatable$default2;
                    }
                    Animatable animatable2 = (Animatable) obj10;
                    Boolean boolValueOf2 = Boolean.valueOf(z);
                    boolean zChangedInstance7 = gapComposer5.changedInstance(animatable2) | gapComposer5.changed(z) | gapComposer5.changedInstance(finiteAnimationSpecM272valueyDoVZcs2);
                    Object objRememberedValue13 = gapComposer5.rememberedValue();
                    Object obj11 = objRememberedValue13;
                    if (zChangedInstance7 || objRememberedValue13 == neverEqualPolicy) {
                        MusicService.C01701 c01701 = new MusicService.C01701(animatable2, z, finiteAnimationSpecM272valueyDoVZcs2, (Continuation) null);
                        gapComposer5.updateRememberedValue(c01701);
                        obj11 = c01701;
                    }
                    Stack.LaunchedEffect(gapComposer5, boolValueOf2, (Function2) obj11);
                    AnimationState animationState2 = animatable2.internalState;
                    Modifier modifierThen = Modifier.Companion.$$INSTANCE.then(new GraphicsLayerElement((1048319 & 1) != 0 ? 1.0f : ((Number) animationState2.value$delegate.getValue()).floatValue(), (1048319 & 2) != 0 ? 1.0f : ((Number) animationState2.value$delegate.getValue()).floatValue(), (1048319 & 4) != 0 ? 1.0f : ((Number) animationState.value$delegate.getValue()).floatValue(), (1048319 & 32) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 256) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, ColorKt.TransformOrigin(0.5f, 0.5f), (1048319 & 2048) != 0 ? ColorKt.RectangleShape : null, (1048319 & 4096) != 0 ? false : false, LayerOutsets.Zero));
                    boolean zChanged4 = gapComposer5.changed(z) | gapComposer5.changed(snackbarDataImpl) | gapComposer5.changed(str2);
                    Object objRememberedValue14 = gapComposer5.rememberedValue();
                    Object obj12 = objRememberedValue14;
                    if (zChanged4 || objRememberedValue14 == neverEqualPolicy) {
                        LyricsUtils$$ExternalSyntheticLambda0 lyricsUtils$$ExternalSyntheticLambda0 = new LyricsUtils$$ExternalSyntheticLambda0(z, str2, snackbarDataImpl);
                        gapComposer5.updateRememberedValue(lyricsUtils$$ExternalSyntheticLambda0);
                        obj12 = lyricsUtils$$ExternalSyntheticLambda0;
                    }
                    Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierThen, false, (Function1) obj12);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode = Long.hashCode(gapComposer5.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer5.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer5, modifierSemantics);
                    ComposeUiNode.Companion.getClass();
                    gapComposer5.startReusableNode();
                    if (gapComposer5.inserting) {
                        gapComposer5.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer5.useNode();
                    }
                    Stack.m390setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer5, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer5, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer5);
                    Stack.m390setimpl(gapComposer5, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    function4.invoke(gapComposer5, Integer.valueOf(iIntValue4 & 14));
                    gapComposer5.end(true);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 5:
                MutableState mutableState = (MutableState) obj7;
                MutableState mutableState2 = (MutableState) obj8;
                MutableState mutableState3 = (MutableState) obj6;
                MutableState mutableState4 = (MutableState) obj5;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer5;
                if (gapComposer6.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    CrossfadeKt.AnimatedVisibility(Intrinsics.areEqual((String) mutableState.getValue(), "daily"), null, EnterExitTransitionKt.expandVertically$default(ArcSplineKt.spring$default(0.5f, 1500.0f, null, 4), 14).plus(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), EnterExitTransitionKt.shrinkVertically$default(ArcSplineKt.spring$default(0.5f, 1500.0f, null, 4), 14).plus(EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3)), null, Expect_jvmKt.rememberComposableLambda(2006141829, new SettingsSleepTimerDialogKt$$ExternalSyntheticLambda9(mutableState2, mutableState3, mutableState4, b4), gapComposer6), gapComposer6, 200064, 18);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 6:
                TextFieldValue textFieldValue2 = (TextFieldValue) obj7;
                Function1 function6 = (Function1) obj8;
                TextFieldValue textFieldValue3 = (TextFieldValue) obj6;
                Function1 function7 = (Function1) obj5;
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer6;
                if (gapComposer7.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    ScrimKt.OutlinedTextField(textFieldValue2, function6, null, false, null, AlbumMenuKt.f91lambda$1400534241, null, null, null, null, null, null, true, 0, 0, null, null, gapComposer7, 1572864, 12582912, 8257468);
                    OffsetKt.Spacer(gapComposer7, SizeKt.m145height3ABfNKs(companion, 12.0f));
                    ScrimKt.OutlinedTextField(textFieldValue3, function7, null, false, null, AlbumMenuKt.lambda$338248342, null, null, null, null, null, null, true, 0, 0, null, null, gapComposer7, 1572864, 12582912, 8257468);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 7:
                Function0 function8 = (Function0) obj7;
                Function1 function9 = (Function1) obj8;
                String str3 = (String) obj6;
                Function1 function10 = (Function1) obj5;
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer7;
                if (gapComposer8.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    CardKt.TextButton(function8, null, false, null, null, null, AlbumMenuKt.f186lambda$307733056, gapComposer8, 805306368, 510);
                    boolean zChanged5 = gapComposer8.changed(function9) | gapComposer8.changed(str3);
                    Object objRememberedValue15 = gapComposer8.rememberedValue();
                    if (zChanged5 || objRememberedValue15 == neverEqualPolicy) {
                        objRememberedValue15 = new PlaylistScreenMenusKt$$ExternalSyntheticLambda3((byte) 0, str3, function9);
                        gapComposer8.updateRememberedValue(objRememberedValue15);
                    }
                    CardKt.TextButton((Function0) objRememberedValue15, null, false, null, null, null, AlbumMenuKt.f265lambda$825778007, gapComposer8, 805306368, 510);
                    boolean zChanged6 = gapComposer8.changed(function10) | gapComposer8.changed(str3);
                    Object objRememberedValue16 = gapComposer8.rememberedValue();
                    if (zChanged6 || objRememberedValue16 == neverEqualPolicy) {
                        objRememberedValue16 = new PlaylistScreenMenusKt$$ExternalSyntheticLambda3((byte) 1, str3, function10);
                        gapComposer8.updateRememberedValue(objRememberedValue16);
                    }
                    CardKt.TextButton((Function0) objRememberedValue16, null, false, null, null, null, AlbumMenuKt.f221lambda$522890616, gapComposer8, 805306368, 510);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 8:
                final Function0 function11 = (Function0) obj7;
                final MutableState mutableState5 = (MutableState) obj8;
                final PlayerConnection playerConnection = (PlayerConnection) obj6;
                final MediaMetadata mediaMetadata = (MediaMetadata) obj5;
                final LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                lazyItemScopeImpl2.getClass();
                if ((iIntValue8 & 6) == 0) {
                    iIntValue8 |= ((GapComposer) composer8).changed(lazyItemScopeImpl2) ? (byte) 4 : (byte) 2;
                }
                GapComposer gapComposer9 = (GapComposer) composer8;
                if (gapComposer9.shouldExecute(iIntValue8 & 1, (iIntValue8 & 19) != 18)) {
                    ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.f266lambda$828956727;
                    ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.lambda$1654443368;
                    ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.f110lambda$157123833;
                    int i = iIntValue8 & 14;
                    boolean zChanged7 = gapComposer9.changed(function11) | gapComposer9.changed(mutableState5) | gapComposer9.changedInstance(playerConnection) | (i == 4) | gapComposer9.changed(mediaMetadata);
                    Object objRememberedValue17 = gapComposer9.rememberedValue();
                    if (zChanged7 || objRememberedValue17 == neverEqualPolicy) {
                        final byte b7 = 0;
                        objRememberedValue17 = new Function0(function11, lazyItemScopeImpl2, mutableState5, playerConnection, mediaMetadata, b7) { // from class: com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda29
                            public final /* synthetic */ byte $r8$classId;
                            public final /* synthetic */ Function0 f$0;
                            public final /* synthetic */ MutableState f$2;
                            public final /* synthetic */ PlayerConnection f$3;
                            public final /* synthetic */ MediaMetadata f$4;

                            {
                                this.$r8$classId = b7;
                                this.f$2 = mutableState5;
                                this.f$3 = playerConnection;
                                this.f$4 = mediaMetadata;
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() throws Exception {
                                byte b8 = this.$r8$classId;
                                Unit unit2 = Unit.INSTANCE;
                                MediaMetadata mediaMetadata2 = this.f$4;
                                PlayerConnection playerConnection2 = this.f$3;
                                MutableState mutableState6 = this.f$2;
                                Function0 function12 = this.f$0;
                                switch (b8) {
                                    case 0:
                                        function12.invoke();
                                        Song song2 = (Song) mutableState6.getValue();
                                        if (song2 == null) {
                                            playerConnection2.playNext(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(mediaMetadata2)));
                                        } else {
                                            playerConnection2.playNext(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song2))));
                                        }
                                        break;
                                    default:
                                        function12.invoke();
                                        Song song3 = (Song) mutableState6.getValue();
                                        if (song3 == null) {
                                            playerConnection2.addToQueue(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(mediaMetadata2)));
                                        } else {
                                            playerConnection2.addToQueue(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song3))));
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        };
                        function0 = function11;
                        lazyItemScopeImpl = lazyItemScopeImpl2;
                        gapComposer9.updateRememberedValue(objRememberedValue17);
                    } else {
                        function0 = function11;
                        lazyItemScopeImpl = lazyItemScopeImpl2;
                    }
                    Material3MenuItemData material3MenuItemData3 = new Material3MenuItemData(composableLambdaImpl9, composableLambdaImpl10, composableLambdaImpl11, (Function0) objRememberedValue17, null, null, 48);
                    ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.f250lambda$695369816;
                    ComposableLambdaImpl composableLambdaImpl13 = AlbumMenuKt.lambda$1788030279;
                    ComposableLambdaImpl composableLambdaImpl14 = AlbumMenuKt.f180lambda$23536922;
                    boolean zChanged8 = gapComposer9.changed(function0) | gapComposer9.changed(mutableState5) | gapComposer9.changedInstance(playerConnection) | (i == 4) | gapComposer9.changed(mediaMetadata);
                    Object objRememberedValue18 = gapComposer9.rememberedValue();
                    if (zChanged8 || objRememberedValue18 == neverEqualPolicy) {
                        final byte b8 = 1;
                        Function0 function12 = new Function0(function0, lazyItemScopeImpl, mutableState5, playerConnection, mediaMetadata, b8) { // from class: com.metrolist.music.ui.menu.QueueMenuKt$$ExternalSyntheticLambda29
                            public final /* synthetic */ byte $r8$classId;
                            public final /* synthetic */ Function0 f$0;
                            public final /* synthetic */ MutableState f$2;
                            public final /* synthetic */ PlayerConnection f$3;
                            public final /* synthetic */ MediaMetadata f$4;

                            {
                                this.$r8$classId = b8;
                                this.f$2 = mutableState5;
                                this.f$3 = playerConnection;
                                this.f$4 = mediaMetadata;
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() throws Exception {
                                byte b9 = this.$r8$classId;
                                Unit unit2 = Unit.INSTANCE;
                                MediaMetadata mediaMetadata2 = this.f$4;
                                PlayerConnection playerConnection2 = this.f$3;
                                MutableState mutableState6 = this.f$2;
                                Function0 function13 = this.f$0;
                                switch (b9) {
                                    case 0:
                                        function13.invoke();
                                        Song song2 = (Song) mutableState6.getValue();
                                        if (song2 == null) {
                                            playerConnection2.playNext(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(mediaMetadata2)));
                                        } else {
                                            playerConnection2.playNext(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song2))));
                                        }
                                        break;
                                    default:
                                        function13.invoke();
                                        Song song3 = (Song) mutableState6.getValue();
                                        if (song3 == null) {
                                            playerConnection2.addToQueue(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(mediaMetadata2)));
                                        } else {
                                            playerConnection2.addToQueue(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(HexFormatKt.toMediaMetadata(song3))));
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        };
                        gapComposer9.updateRememberedValue(function12);
                        objRememberedValue18 = function12;
                    }
                    MenuKt.Material3MenuGroup(CollectionsKt__IterablesKt.listOf((Object[]) new Material3MenuItemData[]{material3MenuItemData3, new Material3MenuItemData(composableLambdaImpl12, composableLambdaImpl13, composableLambdaImpl14, (Function0) objRememberedValue18, null, null, 48)}), gapComposer9, 0);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 9:
                ArrayList arrayList = (ArrayList) obj7;
                MutableState mutableState6 = (MutableState) obj8;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj6;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = (ParcelableSnapshotMutableIntState) obj5;
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer9;
                if (!gapComposer10.shouldExecute(1 & iIntValue9, (iIntValue9 & 17) != 16)) {
                    gapComposer10.skipToGroupEnd();
                } else if (((Boolean) mutableState6.getValue()).booleanValue()) {
                    gapComposer10.startReplaceGroup(944505010);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.upload_progress, new Object[]{Integer.valueOf(parcelableSnapshotMutableIntState.getIntValue()), Integer.valueOf(parcelableSnapshotMutableIntState2.getIntValue())}, gapComposer10), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer10.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer10, 0, 0, 131070);
                    OffsetKt.Spacer(gapComposer10, SizeKt.m145height3ABfNKs(companion, 16.0f));
                    Object objRememberedValue19 = gapComposer10.rememberedValue();
                    if (objRememberedValue19 == neverEqualPolicy) {
                        objRememberedValue19 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) parcelableSnapshotMutableIntState2, (Object) parcelableSnapshotMutableIntState, (byte) 22);
                        gapComposer10.updateRememberedValue(objRememberedValue19);
                    }
                    ProgressIndicatorKt.m309LinearProgressIndicatorGJbTh5U((Function0) objRememberedValue19, SizeKt.fillMaxWidth(companion, 1.0f), 0L, 0L, 0, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer10, 54, 124);
                    gapComposer10.end(false);
                } else {
                    gapComposer10.startReplaceGroup(944999305);
                    TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.delete_uploaded_songs_confirm, new Object[]{Integer.valueOf(arrayList.size())}, gapComposer10), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer10.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer10, 0, 0, 131070);
                    gapComposer10.end(false);
                }
                return unit;
            case 10:
                final Context context2 = (Context) obj7;
                final SongItem songItem = (SongItem) obj8;
                DownloadUtil downloadUtil2 = (DownloadUtil) obj6;
                State state2 = (State) obj5;
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer11 = (GapComposer) composer10;
                if (gapComposer11.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    Download download2 = (Download) state2.getValue();
                    Integer numValueOf2 = download2 != null ? Integer.valueOf(download2.state) : null;
                    if (numValueOf2 != null && numValueOf2.intValue() == 3) {
                        gapComposer11.startReplaceGroup(-92516389);
                        ComposableLambdaImpl composableLambdaImpl15 = AlbumMenuKt.lambda$1322432622;
                        ComposableLambdaImpl composableLambdaImpl16 = AlbumMenuKt.f139lambda$1830187089;
                        boolean zChangedInstance8 = gapComposer11.changedInstance(context2) | gapComposer11.changedInstance(songItem);
                        Object objRememberedValue20 = gapComposer11.rememberedValue();
                        if (zChangedInstance8 || objRememberedValue20 == neverEqualPolicy) {
                            final byte b9 = false ? (byte) 1 : (byte) 0;
                            objRememberedValue20 = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeSongMenuKt$$ExternalSyntheticLambda45
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b10 = b9;
                                    Unit unit2 = Unit.INSTANCE;
                                    SongItem songItem2 = songItem;
                                    Context context3 = context2;
                                    switch (b10) {
                                        case 0:
                                            DownloadService.sendRemoveDownload(context3, songItem2.id);
                                            break;
                                        default:
                                            DownloadService.sendRemoveDownload(context3, songItem2.id);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer11.updateRememberedValue(objRememberedValue20);
                        }
                        material3MenuItemData2 = new Material3MenuItemData(composableLambdaImpl15, composableLambdaImpl16, null, (Function0) objRememberedValue20, null, null, 52);
                        gapComposer11.end(false);
                    } else if ((numValueOf2 != null && numValueOf2.intValue() == 0) || (numValueOf2 != null && numValueOf2.intValue() == 2)) {
                        gapComposer11.startReplaceGroup(-91385199);
                        ComposableLambdaImpl composableLambdaImpl17 = AlbumMenuKt.f39lambda$1026327273;
                        ComposableLambdaImpl composableLambdaImpl18 = AlbumMenuKt.lambda$1553041432;
                        boolean zChangedInstance9 = gapComposer11.changedInstance(context2) | gapComposer11.changedInstance(songItem);
                        Object objRememberedValue21 = gapComposer11.rememberedValue();
                        if (zChangedInstance9 || objRememberedValue21 == neverEqualPolicy) {
                            final byte b10 = true ? (byte) 1 : (byte) 0;
                            objRememberedValue21 = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeSongMenuKt$$ExternalSyntheticLambda45
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    byte b11 = b10;
                                    Unit unit2 = Unit.INSTANCE;
                                    SongItem songItem2 = songItem;
                                    Context context3 = context2;
                                    switch (b11) {
                                        case 0:
                                            DownloadService.sendRemoveDownload(context3, songItem2.id);
                                            break;
                                        default:
                                            DownloadService.sendRemoveDownload(context3, songItem2.id);
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer11.updateRememberedValue(objRememberedValue21);
                        }
                        material3MenuItemData2 = new Material3MenuItemData(composableLambdaImpl17, composableLambdaImpl18, null, (Function0) objRememberedValue21, null, null, 52);
                        gapComposer11.end(false);
                    } else {
                        gapComposer11.startReplaceGroup(-90447573);
                        ComposableLambdaImpl composableLambdaImpl19 = AlbumMenuKt.lambda$1251903159;
                        ComposableLambdaImpl composableLambdaImpl20 = AlbumMenuKt.lambda$1700018744;
                        ComposableLambdaImpl composableLambdaImpl21 = AlbumMenuKt.f177lambda$2146832967;
                        boolean zChangedInstance10 = gapComposer11.changedInstance(downloadUtil2) | gapComposer11.changedInstance(songItem);
                        Object objRememberedValue22 = gapComposer11.rememberedValue();
                        if (zChangedInstance10 || objRememberedValue22 == neverEqualPolicy) {
                            objRememberedValue22 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2((Object) downloadUtil2, (Object) songItem, (byte) 25);
                            gapComposer11.updateRememberedValue(objRememberedValue22);
                        }
                        material3MenuItemData2 = new Material3MenuItemData(composableLambdaImpl19, composableLambdaImpl20, composableLambdaImpl21, (Function0) objRememberedValue22, null, null, 48);
                        gapComposer11.end(false);
                    }
                    MenuKt.Material3MenuGroup(CollectionsKt__IterablesKt.listOf(material3MenuItemData2), gapComposer11, 0);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 11:
                MediaMetadata mediaMetadata2 = (MediaMetadata) obj7;
                BottomSheetState bottomSheetState = (BottomSheetState) obj8;
                BottomSheetPageState bottomSheetPageState = (BottomSheetPageState) obj6;
                MenuState menuState = (MenuState) obj5;
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer12 = (GapComposer) composer11;
                if (gapComposer12.shouldExecute(1 & iIntValue11, (iIntValue11 & 17) != 16)) {
                    boolean zChanged9 = gapComposer12.changed(mediaMetadata2) | gapComposer12.changed(bottomSheetPageState);
                    Object objRememberedValue23 = gapComposer12.rememberedValue();
                    if (zChanged9 || objRememberedValue23 == neverEqualPolicy) {
                        objRememberedValue23 = new ComponentRegistry$Builder$$ExternalSyntheticLambda2(mediaMetadata2, bottomSheetPageState, b2);
                        gapComposer12.updateRememberedValue(objRememberedValue23);
                    }
                    Function0 function13 = (Function0) objRememberedValue23;
                    boolean zChanged10 = gapComposer12.changed(menuState);
                    Object objRememberedValue24 = gapComposer12.rememberedValue();
                    if (zChanged10 || objRememberedValue24 == neverEqualPolicy) {
                        objRememberedValue24 = new RoomDatabase$closeBarrier$1(0, menuState, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 22);
                        gapComposer12.updateRememberedValue(objRememberedValue24);
                    }
                    PlayerMenuKt.PlayerMenu(mediaMetadata2, bottomSheetState, null, function13, (Function0) ((KFunction) objRememberedValue24), gapComposer12, 0);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) obj7;
                HomePage.Section section = (HomePage.Section) obj8;
                HomeSection.HomePageSection homePageSection = (HomeSection.HomePageSection) obj6;
                ComposableLambdaImpl composableLambdaImpl22 = (ComposableLambdaImpl) obj5;
                Composer composer12 = (Composer) obj2;
                int iIntValue12 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer13 = (GapComposer) composer12;
                if (gapComposer13.shouldExecute(iIntValue12 & 1, (iIntValue12 & 17) != 16)) {
                    boolean zChangedInstance11 = gapComposer13.changedInstance(section) | gapComposer13.changedInstance(homePageSection);
                    Object objRememberedValue25 = gapComposer13.rememberedValue();
                    if (zChangedInstance11 || objRememberedValue25 == neverEqualPolicy) {
                        objRememberedValue25 = new MainActivity$$ExternalSyntheticLambda21(section, homePageSection, composableLambdaImpl22, b3);
                        gapComposer13.updateRememberedValue(objRememberedValue25);
                    }
                    IntMath.LazyRow(null, null, paddingValuesImpl, null, null, null, false, null, (Function1) objRememberedValue25, gapComposer13, 0, 507);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 13:
                return invoke$com$metrolist$music$ui$screens$ListenTogetherScreenKt$$ExternalSyntheticLambda57(obj, obj2, obj3);
            case 14:
                ArrayList arrayList2 = (ArrayList) obj7;
                MenuState menuState2 = (MenuState) obj8;
                Function0 function14 = (Function0) obj6;
                CachePlaylistViewModel cachePlaylistViewModel = (CachePlaylistViewModel) obj5;
                Composer composer13 = (Composer) obj2;
                int iIntValue13 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer14 = (GapComposer) composer13;
                if (gapComposer14.shouldExecute(iIntValue13 & 1, (iIntValue13 & 17) != 16)) {
                    boolean zChanged11 = gapComposer14.changed(menuState2);
                    Object objRememberedValue26 = gapComposer14.rememberedValue();
                    if (zChanged11 || objRememberedValue26 == neverEqualPolicy) {
                        objRememberedValue26 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 13);
                        gapComposer14.updateRememberedValue(objRememberedValue26);
                    }
                    Function0 function15 = (Function0) ((KFunction) objRememberedValue26);
                    boolean zChangedInstance12 = gapComposer14.changedInstance(cachePlaylistViewModel) | gapComposer14.changedInstance(arrayList2);
                    Object objRememberedValue27 = gapComposer14.rememberedValue();
                    if (zChangedInstance12 || objRememberedValue27 == neverEqualPolicy) {
                        objRememberedValue27 = new QueueKt$$ExternalSyntheticLambda16(cachePlaylistViewModel, arrayList2, (byte) 17);
                        gapComposer14.updateRememberedValue(objRememberedValue27);
                    }
                    YouTubeAlbumMenuKt.SelectionSongMenu(arrayList2, function15, function14, null, false, (Function0) objRememberedValue27, gapComposer14, 0, 24);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 15:
                return invoke$com$metrolist$music$ui$screens$playlist$CachePlaylistScreenKt$$ExternalSyntheticLambda30(obj, obj2, obj3);
            case 16:
                return invoke$com$metrolist$music$ui$screens$playlist$LocalPlaylistScreenKt$$ExternalSyntheticLambda37(obj, obj2, obj3);
            case 17:
                return invoke$com$metrolist$music$ui$screens$playlist$OnlinePlaylistScreenKt$$ExternalSyntheticLambda30(obj, obj2, obj3);
            case 18:
                return invoke$com$metrolist$music$ui$screens$recognition$RecognitionHistoryScreenKt$$ExternalSyntheticLambda3(obj, obj2, obj3);
            case 19:
                return invoke$com$metrolist$music$ui$screens$settings$AlarmSettingsKt$$ExternalSyntheticLambda16(obj, obj2, obj3);
            case 20:
                return invoke$com$metrolist$music$ui$screens$settings$ChangelogScreenKt$$ExternalSyntheticLambda7(obj, obj2, obj3);
            case 21:
                return invoke$com$metrolist$music$ui$screens$settings$integrations$DiscordSettingsKt$$ExternalSyntheticLambda34(obj, obj2, obj3);
            default:
                List list = (List) obj8;
                Context context3 = (Context) obj7;
                Function0 function16 = (Function0) obj6;
                Function0 function17 = (Function0) obj5;
                Composer composer14 = (Composer) obj2;
                int iIntValue14 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer15 = (GapComposer) composer14;
                if (gapComposer15.shouldExecute(iIntValue14 & 1, (iIntValue14 & 17) != 16)) {
                    boolean zChangedInstance13 = gapComposer15.changedInstance(list) | gapComposer15.changedInstance(context3);
                    Object objRememberedValue28 = gapComposer15.rememberedValue();
                    if (zChangedInstance13 || objRememberedValue28 == neverEqualPolicy) {
                        objRememberedValue28 = new QueueKt$$ExternalSyntheticLambda16(list, context3, b2);
                        gapComposer15.updateRememberedValue(objRememberedValue28);
                    }
                    CardKt.TextButton((Function0) objRememberedValue28, null, !list.isEmpty(), null, null, null, LastFMSettingsKt.f606lambda$1445272912, gapComposer15, 805306368, 506);
                    CardKt.TextButton(function16, null, false, null, null, null, LastFMSettingsKt.lambda$47339993, gapComposer15, 805306368, 510);
                    OffsetKt.Spacer(gapComposer15, SizeKt.m155width3ABfNKs(companion, 8.0f));
                    CardKt.Button(function17, null, false, null, null, null, null, null, null, LastFMSettingsKt.f615lambda$1881017187, gapComposer15, 805306368, 510);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda34(Object obj, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda34(List list, Context context, Function0 function0, Function0 function1) {
        this.$r8$classId = (byte) 22;
        this.f$1 = list;
        this.f$0 = context;
        this.f$2 = function0;
        this.f$3 = function1;
    }

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda34(Function2 function2, ContextMenuScope contextMenuScope, Function3 function3, Function0 function0) {
        this.$r8$classId = (byte) 2;
        this.f$0 = function2;
        this.f$1 = contextMenuScope;
        this.f$2 = function3;
        this.f$3 = function0;
    }
}
