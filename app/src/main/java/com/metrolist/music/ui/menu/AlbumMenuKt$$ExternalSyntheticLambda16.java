package com.metrolist.music.ui.menu;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement$SpacedAligned;
import androidx.compose.foundation.layout.AspectRatioElement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.RippleNodeFactory;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import coil3.compose.AsyncImageKt;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import com.metrolist.music.constants.PlaylistSongSortType;
import com.metrolist.music.constants.SearchSource;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.queues.ListQueue;
import com.metrolist.music.playback.queues.YouTubeAlbumRadio;
import com.metrolist.music.playback.queues.YouTubeQueue;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.component.GlassComponentsKt;
import com.metrolist.music.ui.component.Material3MenuItemData;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.component.NewAction;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$2$1;
import com.metrolist.music.ui.component.SortHeaderKt$SortHeader$1$5;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.AlbumScreenKt$$ExternalSyntheticLambda8;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.library.LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.library.LibrarySongsScreenKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt;
import com.metrolist.music.ui.screens.search.OnlineSearchScreenKt;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.screens.search.SearchScreenKt$$ExternalSyntheticLambda11;
import com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.OnlinePlaylistViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.text.HexFormatKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlbumMenuKt$$ExternalSyntheticLambda16 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 9;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda16(Context context, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MusicDatabase musicDatabase, boolean z) {
        this.f$0 = z;
        this.f$1 = musicDatabase;
        this.f$4 = mutableState;
        this.f$2 = mutableState2;
        this.f$5 = context;
        this.f$3 = mutableState3;
    }

    private final Object invoke$com$metrolist$music$ui$screens$library$LibrarySongsScreenKt$$ExternalSyntheticLambda16(Object obj, Object obj2, Object obj3) {
        GapComposer gapComposer;
        Modifier modifierM137paddingVpY3zN4$default;
        int i;
        SongSortType songSortType = (SongSortType) this.f$1;
        Function1 function1 = (Function1) this.f$2;
        MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) this.f$3;
        ArrayList arrayList = (ArrayList) this.f$5;
        MutableState mutableState = (MutableState) this.f$4;
        RowScope rowScope = (RowScope) obj;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        rowScope.getClass();
        if ((iIntValue & 6) == 0) {
            iIntValue |= ((GapComposer) composer).changed(rowScope) ? 4 : 2;
        }
        GapComposer gapComposer2 = (GapComposer) composer;
        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, 1);
            if (UiStyleKt.isGlassStyle(gapComposer2)) {
                gapComposer2.startReplaceGroup(-2138758585);
                gapComposer = gapComposer2;
                modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(GlassComponentsKt.glass(companion, RoundedCornerShapeKt.RoundedCornerShape(50), false, gapComposer2, 6, 2), 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                gapComposer.end(false);
            } else {
                gapComposer = gapComposer2;
                gapComposer.startReplaceGroup(-2138602190);
                gapComposer.end(false);
                modifierM137paddingVpY3zN4$default = companion;
            }
            Modifier modifierThen = modifierM137paddingVpY3zN4$default2.then(modifierM137paddingVpY3zN4$default);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierThen);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            int iOrdinal = songSortType.ordinal();
            if (iOrdinal == 0) {
                i = R.string.sort_by_create_date;
            } else if (iOrdinal == 1) {
                i = R.string.sort_by_name;
            } else if (iOrdinal == 2) {
                i = R.string.sort_by_artist;
            } else {
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                i = R.string.sort_by_play_time;
            }
            String upperCase = MathKt.stringResource(i, gapComposer).toUpperCase(Locale.ROOT);
            upperCase.getClass();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            long j = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary;
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.labelMedium;
            FontWeight fontWeight = UiStyleKt.isGlassStyle(gapComposer) ? FontWeight.Bold : null;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue2;
            RippleNodeFactory rippleNodeFactoryM313rippleOu1YvPQ$default = RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 254);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new SortHeaderKt$SortHeader$1$2$1(mutableState2, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            TextKt.m352TextNvy7gAk(upperCase, OffsetKt.m136paddingVpY3zN4(ImageKt.m45clickableO2vRcR0$default(companion, mutableInteractionSourceImpl, rippleNodeFactoryM313rippleOu1YvPQ$default, false, null, (Function0) objRememberedValue3, 28), 4.0f, 8.0f), j, 0L, null, fontWeight, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 0, 0, 131000);
            boolean zM1492SortHeader$lambda1 = MenuKt.m1492SortHeader$lambda1(mutableState2);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new SortHeaderKt$SortHeader$1$2$1(mutableState2, (byte) 1);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            CardKt.m256DropdownMenuIlH_yew(zM1492SortHeader$lambda1, (Function0) objRememberedValue4, SizeKt.m157widthInVpY3zN4$default(companion, 172.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), 0L, null, null, null, 0L, CropImageView.DEFAULT_ASPECT_RATIO, Expect_jvmKt.rememberComposableLambda(-1229424361, new LibraryMixScreenKt$LibraryMixScreen$lambda$24$2$$inlined$SortHeader$1((byte) 6, mutableState2, songSortType, function1), gapComposer), gapComposer, 432, 2040);
            if (songSortType != PlaylistSongSortType.CUSTOM) {
                gapComposer.startReplaceGroup(-413182842);
                boolean z = this.f$0;
                MenuKt.m1491ResizableIconButtonFU0evQE(z ? R.drawable.arrow_downward : R.drawable.arrow_upward, OffsetKt.m135padding3ABfNKs(SizeKt.m151size3ABfNKs(companion, 32.0f), 8.0f), ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.primary, false, new SortHeaderKt$SortHeader$1$5(mimesKt$$ExternalSyntheticLambda0, z), gapComposer, 48);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-412803898);
                gapComposer.end(false);
            }
            gapComposer.end(true);
            OffsetKt.Spacer(gapComposer, rowScope.weight(companion, 1.0f, true));
            TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.n_song, arrayList.size(), new Object[]{Integer.valueOf(arrayList.size())}, gapComposer), null, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleSmall, gapComposer, 0, 0, 131066);
            boolean zChanged = gapComposer.changed(mutableState);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            CardKt.IconButton((Function0) objRememberedValue5, SizeKt.m151size3ABfNKs(OffsetKt.m139paddingqDBjuR0$default(companion, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 10), 40.0f), false, null, null, LibraryScreenKt.f369lambda$1218611378, gapComposer, 1572912, 60);
        } else {
            gapComposer2.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v26 */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        NewAction newAction;
        NewAction newAction2;
        ?? r4;
        Object obj4;
        boolean z;
        final PlayerConnection playerConnection;
        NewAction newAction3;
        NewAction newAction4;
        final Function0 function0;
        final AlbumItem albumItem;
        NewAction newAction5;
        NewAction newAction6;
        Material3MenuItemData material3MenuItemData;
        Material3MenuItemData material3MenuItemData2;
        int i;
        Material3MenuItemData material3MenuItemData3;
        boolean z2;
        Brush solidColor;
        long j;
        Modifier modifierM1481glassTintedFNF3uiM;
        boolean z3;
        long j2;
        BorderStroke borderStrokeM38BorderStrokecXLIe8U;
        boolean z4;
        long j3;
        BorderStroke borderStrokeM38BorderStrokecXLIe8U2;
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        boolean z5 = this.f$0;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        Object obj5 = this.f$5;
        Object obj6 = this.f$3;
        Object obj7 = this.f$2;
        Object obj8 = this.f$4;
        Object obj9 = this.f$1;
        switch (b) {
            case 0:
                Function0 function1 = (Function0) obj9;
                PlayerConnection playerConnection2 = (PlayerConnection) obj7;
                Album album = (Album) obj6;
                MutableState mutableState = (MutableState) obj8;
                Context context = (Context) obj5;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    if (z5) {
                        gapComposer.startReplaceGroup(558531642);
                        gapComposer.end(false);
                        newAction = null;
                    } else {
                        gapComposer.startReplaceGroup(555945467);
                        String strStringResource = MathKt.stringResource(R.string.play, gapComposer);
                        Expect_jvmKt.rememberComposableLambda(-1051310224, new AlbumMenuKt$$ExternalSyntheticLambda25(function1, playerConnection2, album, mutableState), gapComposer);
                        Rgb rgb = ColorSpaces.Unspecified;
                        ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
                        ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
                        strStringResource.getClass();
                        newAction = new NewAction(AlbumMenuKt.lambda$1974227365, MathKt.stringResource(R.string.shuffle, gapComposer), Expect_jvmKt.rememberComposableLambda(1337672743, new AlbumMenuKt$$ExternalSyntheticLambda25(function1, album, playerConnection2, mutableState), gapComposer));
                        gapComposer.end(false);
                    }
                    MenuKt.NewActionGrid(ArraysKt.filterNotNull(new NewAction[]{newAction, new NewAction(AlbumMenuKt.f211lambda$474136620, MathKt.stringResource(R.string.share, gapComposer), Expect_jvmKt.rememberComposableLambda(-1496160938, new MainActivity$$ExternalSyntheticLambda9(function1, context, album, (byte) 20), gapComposer))}), OffsetKt.m136paddingVpY3zN4(companion, 4.0f, 16.0f), z5 ? 1 : 3, gapComposer, 48, 0);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                Context context2 = (Context) obj5;
                PlayerConnection playerConnection3 = (PlayerConnection) obj7;
                Function0 function2 = (Function0) obj9;
                MutableState mutableState2 = (MutableState) obj8;
                MediaMetadata mediaMetadata = (MediaMetadata) obj6;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    String strStringResource2 = MathKt.stringResource(R.string.starting_radio, gapComposer2);
                    if (z5) {
                        gapComposer2.startReplaceGroup(-499156895);
                        gapComposer2.end(false);
                        newAction2 = null;
                    } else {
                        gapComposer2.startReplaceGroup(-500081501);
                        newAction2 = new NewAction(AlbumMenuKt.lambda$1620407107, MathKt.stringResource(R.string.start_radio, gapComposer2), Expect_jvmKt.rememberComposableLambda(657187201, new CrossfadeKt$$ExternalSyntheticLambda3(context2, strStringResource2, playerConnection3, function2, (byte) 7), gapComposer2));
                        gapComposer2.end(false);
                    }
                    MenuKt.NewActionGrid(ArraysKt.filterNotNull(new NewAction[]{newAction2, new NewAction(AlbumMenuKt.f65lambda$1199237219, MathKt.stringResource(R.string.add_to_playlist, gapComposer2), Expect_jvmKt.rememberComposableLambda(187079515, new SongMenuKt$$ExternalSyntheticLambda37(mutableState2, (byte) 15), gapComposer2)), new NewAction(AlbumMenuKt.f122lambda$1671234628, MathKt.stringResource(R.string.copy_link, gapComposer2), Expect_jvmKt.rememberComposableLambda(-284917894, new QueueMenuKt$$ExternalSyntheticLambda18(context2, mediaMetadata, function2, (byte) 1), gapComposer2)), new NewAction(AlbumMenuKt.f176lambda$2143232037, MathKt.stringResource(R.string.share_song_card, gapComposer2), Expect_jvmKt.rememberComposableLambda(-756915303, new QueueMenuKt$$ExternalSyntheticLambda18(context2, mediaMetadata, function2, (byte) 2), gapComposer2))}), OffsetKt.m136paddingVpY3zN4(companion, 4.0f, 16.0f), z5 ? 2 : 3, gapComposer2, 48, 0);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                Playlist playlist = (Playlist) obj6;
                CoroutineScope coroutineScope = (CoroutineScope) obj5;
                PlayerConnection playerConnection4 = (PlayerConnection) obj7;
                Function0 function3 = (Function0) obj9;
                MutableState mutableState3 = (MutableState) obj8;
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    gapComposer3.startReplaceGroup(-1837203555);
                    ListBuilder listBuilderCreateListBuilder = CollectionsKt__IterablesKt.createListBuilder();
                    if (z5) {
                        gapComposer3.startReplaceGroup(11051481);
                        gapComposer3.end(false);
                    } else {
                        gapComposer3.startReplaceGroup(1801419556);
                        String str = playlist.playlist.browseId;
                        if (str == null) {
                            gapComposer3.startReplaceGroup(9431389);
                            z = false;
                            gapComposer3.end(false);
                        } else {
                            gapComposer3.startReplaceGroup(9431390);
                            ComposableLambdaImpl composableLambdaImpl = AlbumMenuKt.lambda$965236602;
                            ComposableLambdaImpl composableLambdaImpl2 = AlbumMenuKt.lambda$1229257467;
                            ComposableLambdaImpl composableLambdaImpl3 = AlbumMenuKt.lambda$1493278332;
                            boolean zChangedInstance = gapComposer3.changedInstance(coroutineScope) | gapComposer3.changed(str) | gapComposer3.changedInstance(playerConnection4) | gapComposer3.changed(function3);
                            Object objRememberedValue = gapComposer3.rememberedValue();
                            if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                                SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda63 = new SongMenuKt$$ExternalSyntheticLambda63((Object) coroutineScope, (Object) function3, (Object) str, (Object) playerConnection4, (byte) 11);
                                gapComposer3.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda63);
                                objRememberedValue = songMenuKt$$ExternalSyntheticLambda63;
                            }
                            listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl, composableLambdaImpl2, composableLambdaImpl3, (Function0) objRememberedValue, null, null, 48));
                            z = false;
                            gapComposer3.end(false);
                        }
                        gapComposer3.end(z);
                    }
                    if (z5) {
                        gapComposer3.startReplaceGroup(12153593);
                        gapComposer3.end(false);
                    } else {
                        gapComposer3.startReplaceGroup(11123401);
                        ComposableLambdaImpl composableLambdaImpl4 = AlbumMenuKt.lambda$331093915;
                        ComposableLambdaImpl composableLambdaImpl5 = AlbumMenuKt.f59lambda$1160145444;
                        ComposableLambdaImpl composableLambdaImpl6 = AlbumMenuKt.lambda$1643582493;
                        boolean zChangedInstance2 = gapComposer3.changedInstance(coroutineScope) | gapComposer3.changedInstance(playerConnection4) | gapComposer3.changed(function3);
                        Object objRememberedValue2 = gapComposer3.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                            SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda64 = new SongMenuKt$$ExternalSyntheticLambda63((Object) coroutineScope, (Object) function3, (Object) playerConnection4, (Object) mutableState3, (byte) 12);
                            gapComposer3.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda64);
                            objRememberedValue2 = songMenuKt$$ExternalSyntheticLambda64;
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl4, composableLambdaImpl5, composableLambdaImpl6, (Function0) objRememberedValue2, null, null, 48));
                        gapComposer3.end(false);
                    }
                    if (z5) {
                        r4 = 0;
                        gapComposer3.startReplaceGroup(13152537);
                        gapComposer3.end(false);
                    } else {
                        gapComposer3.startReplaceGroup(12222289);
                        ComposableLambdaImpl composableLambdaImpl7 = AlbumMenuKt.lambda$1563225210;
                        ComposableLambdaImpl composableLambdaImpl8 = AlbumMenuKt.lambda$71985851;
                        ComposableLambdaImpl composableLambdaImpl9 = AlbumMenuKt.f93lambda$1419253508;
                        boolean zChanged = gapComposer3.changed(function3) | gapComposer3.changedInstance(playerConnection4);
                        Object objRememberedValue3 = gapComposer3.rememberedValue();
                        if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                            obj4 = objRememberedValue3;
                            AlbumMenuKt$$ExternalSyntheticLambda32 albumMenuKt$$ExternalSyntheticLambda32 = new AlbumMenuKt$$ExternalSyntheticLambda32(function3, playerConnection4, mutableState3, (byte) 2);
                            gapComposer3.updateRememberedValue(albumMenuKt$$ExternalSyntheticLambda32);
                            obj4 = albumMenuKt$$ExternalSyntheticLambda32;
                        }
                        listBuilderCreateListBuilder.add(new Material3MenuItemData(composableLambdaImpl7, composableLambdaImpl8, composableLambdaImpl9, (Function0) obj4, null, null, 48));
                        r4 = 0;
                        gapComposer3.end(false);
                    }
                    ListBuilder listBuilderBuild = CollectionsKt__IterablesKt.build(listBuilderCreateListBuilder);
                    gapComposer3.end(r4);
                    MenuKt.Material3MenuGroup(listBuilderBuild, gapComposer3, r4);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 3:
                final Function0 function4 = (Function0) obj9;
                PlayerConnection playerConnection5 = (PlayerConnection) obj7;
                final ArrayList arrayList = (ArrayList) obj6;
                final Function0 function5 = (Function0) obj5;
                MutableState mutableState4 = (MutableState) obj8;
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    if (z5) {
                        playerConnection = playerConnection5;
                        gapComposer4.startReplaceGroup(-2095549456);
                        gapComposer4.end(false);
                        newAction3 = null;
                    } else {
                        gapComposer4.startReplaceGroup(-2096678755);
                        final byte b2 = 0;
                        playerConnection = playerConnection5;
                        newAction3 = new NewAction(AlbumMenuKt.lambda$462768180, MathKt.stringResource(R.string.play, gapComposer4), Expect_jvmKt.rememberComposableLambda(-1045280398, new Function2() { // from class: com.metrolist.music.ui.menu.SelectionSongsMenuKt$$ExternalSyntheticLambda56
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj10, Object obj11) {
                                byte b3 = b2;
                                Unit unit2 = Unit.INSTANCE;
                                Function0 function6 = function5;
                                ArrayList arrayList2 = arrayList;
                                PlayerConnection playerConnection6 = playerConnection;
                                Function0 function7 = function4;
                                int i2 = 0;
                                switch (b3) {
                                    case 0:
                                        Composer composer5 = (Composer) obj10;
                                        int iIntValue5 = ((Integer) obj11).intValue();
                                        GapComposer gapComposer5 = (GapComposer) composer5;
                                        if (!gapComposer5.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                                            gapComposer5.skipToGroupEnd();
                                        } else {
                                            function7.invoke();
                                            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                                            int size = arrayList2.size();
                                            while (i2 < size) {
                                                Object obj12 = arrayList2.get(i2);
                                                i2++;
                                                arrayList3.add(UuidKt.toMediaItem((Song) obj12));
                                            }
                                            playerConnection6.playQueue(new ListQueue("Selection", arrayList3, 0, 0L, 12, null));
                                            function6.invoke();
                                        }
                                        break;
                                    default:
                                        Composer composer6 = (Composer) obj10;
                                        int iIntValue6 = ((Integer) obj11).intValue();
                                        GapComposer gapComposer6 = (GapComposer) composer6;
                                        if (!gapComposer6.shouldExecute(1 & iIntValue6, (iIntValue6 & 3) != 2)) {
                                            gapComposer6.skipToGroupEnd();
                                        } else {
                                            function7.invoke();
                                            List mutableList = CollectionsKt.toMutableList((Iterable) arrayList2);
                                            Collections.shuffle(mutableList);
                                            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mutableList, 10));
                                            ArrayList arrayList5 = (ArrayList) mutableList;
                                            int size2 = arrayList5.size();
                                            while (i2 < size2) {
                                                Object obj13 = arrayList5.get(i2);
                                                i2++;
                                                arrayList4.add(UuidKt.toMediaItem((Song) obj13));
                                            }
                                            playerConnection6.playQueue(new ListQueue("Selection", arrayList4, 0, 0L, 12, null));
                                            function6.invoke();
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        }, gapComposer4));
                        gapComposer4.end(false);
                    }
                    if (z5) {
                        gapComposer4.startReplaceGroup(-2094269776);
                        gapComposer4.end(false);
                        newAction4 = null;
                    } else {
                        gapComposer4.startReplaceGroup(-2095415412);
                        final byte b3 = 1;
                        newAction4 = new NewAction(AlbumMenuKt.f84lambda$1348799021, MathKt.stringResource(R.string.shuffle, gapComposer4), Expect_jvmKt.rememberComposableLambda(1438119697, new Function2() { // from class: com.metrolist.music.ui.menu.SelectionSongsMenuKt$$ExternalSyntheticLambda56
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj10, Object obj11) {
                                byte b4 = b3;
                                Unit unit2 = Unit.INSTANCE;
                                Function0 function6 = function5;
                                ArrayList arrayList2 = arrayList;
                                PlayerConnection playerConnection6 = playerConnection;
                                Function0 function7 = function4;
                                int i2 = 0;
                                switch (b4) {
                                    case 0:
                                        Composer composer5 = (Composer) obj10;
                                        int iIntValue5 = ((Integer) obj11).intValue();
                                        GapComposer gapComposer5 = (GapComposer) composer5;
                                        if (!gapComposer5.shouldExecute(1 & iIntValue5, (iIntValue5 & 3) != 2)) {
                                            gapComposer5.skipToGroupEnd();
                                        } else {
                                            function7.invoke();
                                            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                                            int size = arrayList2.size();
                                            while (i2 < size) {
                                                Object obj12 = arrayList2.get(i2);
                                                i2++;
                                                arrayList3.add(UuidKt.toMediaItem((Song) obj12));
                                            }
                                            playerConnection6.playQueue(new ListQueue("Selection", arrayList3, 0, 0L, 12, null));
                                            function6.invoke();
                                        }
                                        break;
                                    default:
                                        Composer composer6 = (Composer) obj10;
                                        int iIntValue6 = ((Integer) obj11).intValue();
                                        GapComposer gapComposer6 = (GapComposer) composer6;
                                        if (!gapComposer6.shouldExecute(1 & iIntValue6, (iIntValue6 & 3) != 2)) {
                                            gapComposer6.skipToGroupEnd();
                                        } else {
                                            function7.invoke();
                                            List mutableList = CollectionsKt.toMutableList((Iterable) arrayList2);
                                            Collections.shuffle(mutableList);
                                            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(mutableList, 10));
                                            ArrayList arrayList5 = (ArrayList) mutableList;
                                            int size2 = arrayList5.size();
                                            while (i2 < size2) {
                                                Object obj13 = arrayList5.get(i2);
                                                i2++;
                                                arrayList4.add(UuidKt.toMediaItem((Song) obj13));
                                            }
                                            playerConnection6.playQueue(new ListQueue("Selection", arrayList4, 0, 0L, 12, null));
                                            function6.invoke();
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        }, gapComposer4));
                        gapComposer4.end(false);
                    }
                    MenuKt.NewActionGrid(ArraysKt.filterNotNull(new NewAction[]{newAction3, newAction4, new NewAction(AlbumMenuKt.lambda$1665458989, MathKt.stringResource(R.string.add_to_playlist, gapComposer4), Expect_jvmKt.rememberComposableLambda(-570902037, new SongMenuKt$$ExternalSyntheticLambda37(mutableState4, (byte) 23), gapComposer4))}), OffsetKt.m136paddingVpY3zN4(companion, 4.0f, 16.0f), 0, gapComposer4, 48, 4);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 4:
                final Function0 function6 = (Function0) obj9;
                final MutableState mutableState5 = (MutableState) obj8;
                final PlayerConnection playerConnection6 = (PlayerConnection) obj7;
                final AlbumItem albumItem2 = (AlbumItem) obj6;
                Context context3 = (Context) obj5;
                Composer composer5 = (Composer) obj2;
                int iIntValue5 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 17) != 16)) {
                    if (z5) {
                        function0 = function6;
                        albumItem = albumItem2;
                        gapComposer5.startReplaceGroup(-552815909);
                        gapComposer5.end(false);
                        newAction5 = null;
                    } else {
                        gapComposer5.startReplaceGroup(-554892754);
                        String strStringResource3 = MathKt.stringResource(R.string.play, gapComposer5);
                        final byte b4 = 0;
                        Expect_jvmKt.rememberComposableLambda(924442031, new Function2() { // from class: com.metrolist.music.ui.menu.YouTubeAlbumMenuKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj10, Object obj11) {
                                byte b5 = b4;
                                Unit unit2 = Unit.INSTANCE;
                                AlbumItem albumItem3 = albumItem2;
                                PlayerConnection playerConnection7 = playerConnection6;
                                MutableState mutableState6 = mutableState5;
                                Function0 function7 = function6;
                                Composer composer6 = (Composer) obj10;
                                int iIntValue6 = ((Integer) obj11).intValue();
                                switch (b5) {
                                    case 0:
                                        GapComposer gapComposer6 = (GapComposer) composer6;
                                        if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                                            gapComposer6.skipToGroupEnd();
                                        } else {
                                            function7.invoke();
                                            AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState6.getValue();
                                            if (albumWithSongs != null && !albumWithSongs.songs.isEmpty()) {
                                                playerConnection7.playQueue(new YouTubeAlbumRadio(albumItem3.playlistId));
                                            }
                                        }
                                        break;
                                    default:
                                        GapComposer gapComposer7 = (GapComposer) composer6;
                                        if (!gapComposer7.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                                            gapComposer7.skipToGroupEnd();
                                        } else {
                                            function7.invoke();
                                            AlbumWithSongs albumWithSongs2 = (AlbumWithSongs) mutableState6.getValue();
                                            if (albumWithSongs2 != null && !albumWithSongs2.songs.isEmpty()) {
                                                playerConnection7.playQueue(new YouTubeAlbumRadio(albumItem3.playlistId));
                                            }
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        }, gapComposer5);
                        Rgb rgb2 = ColorSpaces.Unspecified;
                        ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb2);
                        ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb2);
                        strStringResource3.getClass();
                        final byte b5 = 1;
                        function0 = function6;
                        albumItem = albumItem2;
                        newAction5 = new NewAction(AlbumMenuKt.f189lambda$33053532, MathKt.stringResource(R.string.shuffle, gapComposer5), Expect_jvmKt.rememberComposableLambda(830716582, new Function2() { // from class: com.metrolist.music.ui.menu.YouTubeAlbumMenuKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj10, Object obj11) {
                                byte b6 = b5;
                                Unit unit2 = Unit.INSTANCE;
                                AlbumItem albumItem3 = albumItem;
                                PlayerConnection playerConnection7 = playerConnection6;
                                MutableState mutableState6 = mutableState5;
                                Function0 function7 = function0;
                                Composer composer6 = (Composer) obj10;
                                int iIntValue6 = ((Integer) obj11).intValue();
                                switch (b6) {
                                    case 0:
                                        GapComposer gapComposer6 = (GapComposer) composer6;
                                        if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                                            gapComposer6.skipToGroupEnd();
                                        } else {
                                            function7.invoke();
                                            AlbumWithSongs albumWithSongs = (AlbumWithSongs) mutableState6.getValue();
                                            if (albumWithSongs != null && !albumWithSongs.songs.isEmpty()) {
                                                playerConnection7.playQueue(new YouTubeAlbumRadio(albumItem3.playlistId));
                                            }
                                        }
                                        break;
                                    default:
                                        GapComposer gapComposer7 = (GapComposer) composer6;
                                        if (!gapComposer7.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                                            gapComposer7.skipToGroupEnd();
                                        } else {
                                            function7.invoke();
                                            AlbumWithSongs albumWithSongs2 = (AlbumWithSongs) mutableState6.getValue();
                                            if (albumWithSongs2 != null && !albumWithSongs2.songs.isEmpty()) {
                                                playerConnection7.playQueue(new YouTubeAlbumRadio(albumItem3.playlistId));
                                            }
                                        }
                                        break;
                                }
                                return unit2;
                            }
                        }, gapComposer5));
                        gapComposer5.end(false);
                    }
                    MenuKt.NewActionGrid(ArraysKt.filterNotNull(new NewAction[]{newAction5, new NewAction(AlbumMenuKt.lambda$826344723, MathKt.stringResource(R.string.share, gapComposer5), Expect_jvmKt.rememberComposableLambda(1237093909, new MainActivity$$ExternalSyntheticLambda9(function0, context3, albumItem, (byte) 29), gapComposer5))}), OffsetKt.m136paddingVpY3zN4(companion, 4.0f, 16.0f), z5 ? 1 : 3, gapComposer5, 48, 0);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 5:
                PlayerConnection playerConnection7 = (PlayerConnection) obj7;
                SongItem songItem = (SongItem) obj6;
                Function0 function7 = (Function0) obj9;
                MutableState mutableState6 = (MutableState) obj8;
                Context context4 = (Context) obj5;
                Composer composer6 = (Composer) obj2;
                int iIntValue6 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 17) != 16)) {
                    if (z5) {
                        gapComposer6.startReplaceGroup(-1428011396);
                        gapComposer6.end(false);
                        newAction6 = null;
                    } else {
                        gapComposer6.startReplaceGroup(-1428827594);
                        newAction6 = new NewAction(AlbumMenuKt.f112lambda$1586112513, MathKt.stringResource(R.string.play_next, gapComposer6), Expect_jvmKt.rememberComposableLambda(427249981, new AlbumScreenKt$$ExternalSyntheticLambda8((Object) playerConnection7, (Object) songItem, (Object) function7, (byte) 2), gapComposer6));
                        gapComposer6.end(false);
                    }
                    MenuKt.NewActionGrid(ArraysKt.filterNotNull(new NewAction[]{newAction6, new NewAction(AlbumMenuKt.lambda$1809558873, MathKt.stringResource(R.string.add_to_playlist, gapComposer6), Expect_jvmKt.rememberComposableLambda(2099903511, new SongMenuKt$$ExternalSyntheticLambda37(mutableState6, (byte) 29), gapComposer6)), new NewAction(AlbumMenuKt.f200lambda$389572872, MathKt.stringResource(R.string.share, gapComposer6), Expect_jvmKt.rememberComposableLambda(-99228234, new AlbumScreenKt$$ExternalSyntheticLambda8((Object) context4, (Object) function7, (Object) songItem, (byte) 3), gapComposer6))}), OffsetKt.m136paddingVpY3zN4(companion, 4.0f, 16.0f), z5 ? 2 : 3, gapComposer6, 48, 0);
                } else {
                    gapComposer6.skipToGroupEnd();
                }
                return unit;
            case 6:
                ListenTogetherManager listenTogetherManager = (ListenTogetherManager) obj6;
                final SongItem songItem2 = (SongItem) obj8;
                List list = (List) obj5;
                final Function0 function8 = (Function0) obj9;
                final PlayerConnection playerConnection8 = (PlayerConnection) obj7;
                Composer composer7 = (Composer) obj2;
                int iIntValue7 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 17) != 16)) {
                    if (listenTogetherManager == null || !listenTogetherManager.client.isInRoom() || listenTogetherManager.isHost()) {
                        gapComposer7.startReplaceGroup(-1649256219);
                        gapComposer7.end(false);
                        material3MenuItemData = null;
                    } else {
                        gapComposer7.startReplaceGroup(-1650523126);
                        ComposableLambdaImpl composableLambdaImpl10 = AlbumMenuKt.lambda$1415433964;
                        ComposableLambdaImpl composableLambdaImpl11 = AlbumMenuKt.f257lambda$790208403;
                        boolean zChangedInstance3 = gapComposer7.changedInstance(songItem2) | gapComposer7.changedInstance(list) | gapComposer7.changedInstance(listenTogetherManager) | gapComposer7.changed(function8);
                        Object objRememberedValue4 = gapComposer7.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue4 == neverEqualPolicy) {
                            SongMenuKt$$ExternalSyntheticLambda63 songMenuKt$$ExternalSyntheticLambda65 = new SongMenuKt$$ExternalSyntheticLambda63((Object) songItem2, (Object) list, (Object) listenTogetherManager, (Object) function8, (byte) 19);
                            gapComposer7.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda65);
                            objRememberedValue4 = songMenuKt$$ExternalSyntheticLambda65;
                        }
                        Material3MenuItemData material3MenuItemData4 = new Material3MenuItemData(composableLambdaImpl10, composableLambdaImpl11, null, (Function0) objRememberedValue4, null, null, 52);
                        gapComposer7.end(false);
                        material3MenuItemData = material3MenuItemData4;
                    }
                    if (z5) {
                        gapComposer7.startReplaceGroup(-1648426907);
                        gapComposer7.end(false);
                        material3MenuItemData2 = null;
                    } else {
                        gapComposer7.startReplaceGroup(-1649192172);
                        ComposableLambdaImpl composableLambdaImpl12 = AlbumMenuKt.f223lambda$526675091;
                        ComposableLambdaImpl composableLambdaImpl13 = AlbumMenuKt.lambda$1562649838;
                        ComposableLambdaImpl composableLambdaImpl14 = AlbumMenuKt.f242lambda$642992529;
                        boolean zChangedInstance4 = gapComposer7.changedInstance(playerConnection8) | gapComposer7.changedInstance(songItem2) | gapComposer7.changed(function8);
                        Object objRememberedValue5 = gapComposer7.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue5 == neverEqualPolicy) {
                            z2 = false;
                            final boolean z6 = false ? 1 : 0;
                            objRememberedValue5 = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeSongMenuKt$$ExternalSyntheticLambda25
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() throws Exception {
                                    byte b6 = z6;
                                    Unit unit2 = Unit.INSTANCE;
                                    Function0 function9 = function8;
                                    SongItem songItem3 = songItem2;
                                    PlayerConnection playerConnection9 = playerConnection8;
                                    switch (b6) {
                                        case 0:
                                            playerConnection9.playQueue(YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(songItem3)));
                                            function9.invoke();
                                            break;
                                        default:
                                            playerConnection9.addToQueue(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(songItem3)));
                                            function9.invoke();
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer7.updateRememberedValue(objRememberedValue5);
                        } else {
                            z2 = false;
                        }
                        Material3MenuItemData material3MenuItemData5 = new Material3MenuItemData(composableLambdaImpl12, composableLambdaImpl13, composableLambdaImpl14, (Function0) objRememberedValue5, null, null, 48);
                        gapComposer7.end(z2);
                        material3MenuItemData2 = material3MenuItemData5;
                    }
                    if (z5) {
                        i = 0;
                        gapComposer7.startReplaceGroup(-1647612475);
                        gapComposer7.end(false);
                        material3MenuItemData3 = null;
                    } else {
                        gapComposer7.startReplaceGroup(-1648363325);
                        ComposableLambdaImpl composableLambdaImpl15 = AlbumMenuKt.lambda$1826183150;
                        ComposableLambdaImpl composableLambdaImpl16 = AlbumMenuKt.f198lambda$379459217;
                        ComposableLambdaImpl composableLambdaImpl17 = AlbumMenuKt.lambda$1709865712;
                        boolean zChangedInstance5 = gapComposer7.changedInstance(playerConnection8) | gapComposer7.changedInstance(songItem2) | gapComposer7.changed(function8);
                        Object objRememberedValue6 = gapComposer7.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue6 == neverEqualPolicy) {
                            final byte b6 = 1;
                            objRememberedValue6 = new Function0() { // from class: com.metrolist.music.ui.menu.YouTubeSongMenuKt$$ExternalSyntheticLambda25
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() throws Exception {
                                    byte b7 = b6;
                                    Unit unit2 = Unit.INSTANCE;
                                    Function0 function9 = function8;
                                    SongItem songItem3 = songItem2;
                                    PlayerConnection playerConnection9 = playerConnection8;
                                    switch (b7) {
                                        case 0:
                                            playerConnection9.playQueue(YouTubeQueue.INSTANCE.radio(HexFormatKt.toMediaMetadata(songItem3)));
                                            function9.invoke();
                                            break;
                                        default:
                                            playerConnection9.addToQueue(CollectionsKt__IterablesKt.listOf(UuidKt.toMediaItem(songItem3)));
                                            function9.invoke();
                                            break;
                                    }
                                    return unit2;
                                }
                            };
                            gapComposer7.updateRememberedValue(objRememberedValue6);
                        }
                        Material3MenuItemData material3MenuItemData6 = new Material3MenuItemData(composableLambdaImpl15, composableLambdaImpl16, composableLambdaImpl17, (Function0) objRememberedValue6, null, null, 48);
                        i = 0;
                        gapComposer7.end(false);
                        material3MenuItemData3 = material3MenuItemData6;
                    }
                    MenuKt.Material3MenuGroup(ArraysKt.filterNotNull(new Material3MenuItemData[]{material3MenuItemData, material3MenuItemData2, material3MenuItemData3}), gapComposer7, i);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 7:
                AlbumWithSongs albumWithSongs = (AlbumWithSongs) obj9;
                PlayerConnection playerConnection9 = (PlayerConnection) obj7;
                State state = (State) obj6;
                MusicDatabase musicDatabase = (MusicDatabase) obj8;
                MenuState menuState = (MenuState) obj5;
                Composer composer8 = (Composer) obj2;
                int iIntValue8 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (!gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 17) != 16)) {
                    gapComposer8.skipToGroupEnd();
                    return unit;
                }
                Modifier modifierM139paddingqDBjuR0$default = OffsetKt.m139paddingqDBjuR0$default(OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(DialogKt.m1476riseInwH6b6FI$default(companion, 0), 1.0f), 20.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2), CropImageView.DEFAULT_ASPECT_RATIO, 8.0f, CropImageView.DEFAULT_ASPECT_RATIO, 20.0f, 5);
                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer8, 0);
                int iHashCode = Long.hashCode(gapComposer8.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer8.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer8, modifierM139paddingqDBjuR0$default);
                ComposeUiNode.Companion.getClass();
                gapComposer8.startReusableNode();
                boolean z7 = gapComposer8.inserting;
                TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                if (z7) {
                    gapComposer8.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer8.useNode();
                }
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                Stack.m390setimpl(gapComposer8, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Stack.m390setimpl(gapComposer8, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode, gapComposer8, updater$$ExternalSyntheticLambda2, gapComposer8);
                Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                Stack.m390setimpl(gapComposer8, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                AlbumEntity albumEntity = albumWithSongs.album;
                List list2 = albumWithSongs.songs;
                String str2 = albumEntity.thumbnailUrl;
                String strResize = str2 != null ? YouTubeUtilsKt.resize(str2, 544, 544) : null;
                Modifier modifierM = Format$$ExternalSyntheticOutline0.m(24.0f, 8.0f, gapComposer8, SizeKt.fillMaxWidth(companion, 0.62f).then(new AspectRatioElement(1.0f)));
                if (UiStyleKt.isGlassStyle(gapComposer8)) {
                    gapComposer8.startReplaceGroup(-856889444);
                    solidColor = GlassComponentsKt.glassRim(gapComposer8);
                    gapComposer8.end(false);
                } else {
                    gapComposer8.startReplaceGroup(-856888890);
                    solidColor = new SolidColor(((MaterialTheme$Values) gapComposer8.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.outlineVariant);
                    gapComposer8.end(false);
                }
                AsyncImageKt.m849AsyncImage10Xjiaw(strResize, ImageKt.m43borderziNgDLE(modifierM, 1.0f, solidColor, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(24.0f, 8.0f, gapComposer8))), ContentScale.Companion.Crop, gapComposer8, 1572912, 1976);
                OffsetKt.Spacer(gapComposer8, SizeKt.m145height3ABfNKs(companion, 20.0f));
                Iterator it = list2.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    i2 += ((Song) it.next()).song.duration;
                }
                String strPluralStringResource = MathKt.pluralStringResource(R.plurals.n_song, list2.size(), new Object[]{Integer.valueOf(list2.size())}, gapComposer8);
                StringBuilder sb = new StringBuilder();
                Integer num = albumEntity.year;
                if (num != null) {
                    sb.append(num.intValue());
                    sb.append("  •  ");
                }
                sb.append(strPluralStringResource);
                if (i2 > 0) {
                    sb.append("  •  ");
                    sb.append(UtilsKt.makeTimeString(Long.valueOf(((long) i2) * 1000)));
                }
                DialogKt.m1469MicroLabelFNF3uiM(sb.toString(), null, CardKt.getColorScheme(gapComposer8).primary, gapComposer8, 0, 2);
                OffsetKt.Spacer(gapComposer8, SizeKt.m145height3ABfNKs(companion, 6.0f));
                TextKt.m352TextNvy7gAk(albumEntity.title, null, CardKt.getColorScheme(gapComposer8).onSurface, 0L, null, null, null, 0L, null, 0L, 2, false, 3, 0, CardKt.getTypography(gapComposer8).headlineMedium, gapComposer8, 0, 24960, 110586);
                OffsetKt.Spacer(gapComposer8, SizeKt.m145height3ABfNKs(companion, 4.0f));
                MenuKt.ClickableArtistTextEntities(albumWithSongs.artists, SizeKt.fillMaxWidth(companion, 1.0f), TextStyle.m750copyp1EtxEg$default(CardKt.getTypography(gapComposer8).titleMedium, 0L, 0L, FontWeight.Normal, null, null, null, 0L, 0L, null, null, 16777211), CardKt.getColorScheme(gapComposer8).onSurfaceVariant, Integer.MAX_VALUE, 0, gapComposer8, 24624);
                OffsetKt.Spacer(gapComposer8, SizeKt.m145height3ABfNKs(companion, 20.0f));
                Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(new Arrangement$SpacedAligned(8.0f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5)), Alignment.Companion.CenterVertically, gapComposer8, 54);
                int iHashCode2 = Long.hashCode(gapComposer8.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer8.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer8, modifierFillMaxWidth);
                ComposeUiNode.Companion.getClass();
                gapComposer8.startReusableNode();
                if (gapComposer8.inserting) {
                    gapComposer8.createNode(textKt$$ExternalSyntheticLambda3);
                } else {
                    gapComposer8.useNode();
                }
                Stack.m390setimpl(gapComposer8, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
                Stack.m390setimpl(gapComposer8, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer8, updater$$ExternalSyntheticLambda2, gapComposer8);
                Stack.m390setimpl(gapComposer8, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                if (UiStyleKt.isGlassStyle(gapComposer8)) {
                    gapComposer8.startReplaceGroup(896906457);
                    gapComposer8.end(false);
                    j = 0;
                } else {
                    gapComposer8.startReplaceGroup(896907829);
                    long j4 = CardKt.getColorScheme(gapComposer8).primary;
                    gapComposer8.end(false);
                    j = j4;
                }
                long j5 = CardKt.getColorScheme(gapComposer8).onPrimary;
                RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer8));
                Modifier modifierPressScale = DialogKt.pressScale(SizeKt.m145height3ABfNKs(new LayoutWeightElement(1.0f, true), 48.0f), 0.96f);
                if (UiStyleKt.isGlassStyle(gapComposer8)) {
                    gapComposer8.startReplaceGroup(896916467);
                    modifierM1481glassTintedFNF3uiM = GlassComponentsKt.m1481glassTintedFNF3uiM(companion, RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer8)), gapComposer8);
                    gapComposer8.end(false);
                } else {
                    gapComposer8.startReplaceGroup(896917814);
                    gapComposer8.end(false);
                    modifierM1481glassTintedFNF3uiM = companion;
                }
                Modifier modifierThen = modifierPressScale.then(modifierM1481glassTintedFNF3uiM);
                boolean z8 = this.f$0;
                boolean zChanged2 = gapComposer8.changed(z8) | gapComposer8.changedInstance(playerConnection9) | gapComposer8.changed(state) | gapComposer8.changed(albumWithSongs);
                Object objRememberedValue7 = gapComposer8.rememberedValue();
                if (zChanged2 || objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = new SongMenuKt$$ExternalSyntheticLambda69(z8, playerConnection9, albumWithSongs, state, (byte) 2);
                    gapComposer8.updateRememberedValue(objRememberedValue7);
                }
                SurfaceKt.m339Surfaceo_FOJdg((Function0) objRememberedValue7, modifierThen, false, roundedCornerShapeM185RoundedCornerShape0680j_4, j, j5, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, null, AlbumScreenKt.lambda$1956443427, gapComposer8, 0, 964);
                RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer8));
                if (UiStyleKt.isGlassStyle(gapComposer8)) {
                    gapComposer8.startReplaceGroup(896963097);
                    z3 = false;
                    long jGlassFill = GlassComponentsKt.glassFill(false, gapComposer8, 1);
                    gapComposer8.end(false);
                    j2 = jGlassFill;
                } else {
                    z3 = false;
                    gapComposer8.startReplaceGroup(896963833);
                    gapComposer8.end(false);
                    j2 = 0;
                }
                if (UiStyleKt.isGlassStyle(gapComposer8)) {
                    gapComposer8.startReplaceGroup(896966028);
                    borderStrokeM38BorderStrokecXLIe8U = new BorderStroke(1.0f, GlassComponentsKt.glassRim(gapComposer8));
                } else {
                    gapComposer8.startReplaceGroup(896967210);
                    borderStrokeM38BorderStrokecXLIe8U = ImageKt.m38BorderStrokecXLIe8U(CardKt.getColorScheme(gapComposer8).outlineVariant, 1.0f);
                }
                gapComposer8.end(z3);
                BorderStroke borderStroke = borderStrokeM38BorderStrokecXLIe8U;
                Modifier modifierPressScale2 = DialogKt.pressScale(SizeKt.m151size3ABfNKs(companion, 48.0f), 0.96f);
                boolean zChangedInstance6 = gapComposer8.changedInstance(musicDatabase) | gapComposer8.changed(albumWithSongs);
                Object objRememberedValue8 = gapComposer8.rememberedValue();
                if (zChangedInstance6 || objRememberedValue8 == neverEqualPolicy) {
                    objRememberedValue8 = new QueueKt$$ExternalSyntheticLambda16(musicDatabase, albumWithSongs, (byte) 1);
                    gapComposer8.updateRememberedValue(objRememberedValue8);
                }
                SurfaceKt.m339Surfaceo_FOJdg((Function0) objRememberedValue8, modifierPressScale2, false, roundedCornerShapeM185RoundedCornerShape0680j_5, j2, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, borderStroke, null, Expect_jvmKt.rememberComposableLambda(678032652, new MainActivity$$ExternalSyntheticLambda0((byte) 12, albumWithSongs), gapComposer8), gapComposer8, 0, 740);
                RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_6 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(50.0f, 8.0f, gapComposer8));
                if (UiStyleKt.isGlassStyle(gapComposer8)) {
                    gapComposer8.startReplaceGroup(897039033);
                    z4 = false;
                    long jGlassFill2 = GlassComponentsKt.glassFill(false, gapComposer8, 1);
                    gapComposer8.end(false);
                    j3 = jGlassFill2;
                } else {
                    z4 = false;
                    gapComposer8.startReplaceGroup(897039769);
                    gapComposer8.end(false);
                    j3 = 0;
                }
                if (UiStyleKt.isGlassStyle(gapComposer8)) {
                    gapComposer8.startReplaceGroup(897041964);
                    borderStrokeM38BorderStrokecXLIe8U2 = new BorderStroke(1.0f, GlassComponentsKt.glassRim(gapComposer8));
                } else {
                    gapComposer8.startReplaceGroup(897043146);
                    borderStrokeM38BorderStrokecXLIe8U2 = ImageKt.m38BorderStrokecXLIe8U(CardKt.getColorScheme(gapComposer8).outlineVariant, 1.0f);
                }
                gapComposer8.end(z4);
                BorderStroke borderStroke2 = borderStrokeM38BorderStrokecXLIe8U2;
                Modifier modifierPressScale3 = DialogKt.pressScale(SizeKt.m151size3ABfNKs(companion, 48.0f), 0.96f);
                boolean zChanged3 = gapComposer8.changed(menuState) | gapComposer8.changed(albumWithSongs);
                Object objRememberedValue9 = gapComposer8.rememberedValue();
                if (zChanged3 || objRememberedValue9 == neverEqualPolicy) {
                    objRememberedValue9 = new QueueKt$$ExternalSyntheticLambda16(menuState, albumWithSongs, (byte) 2);
                    gapComposer8.updateRememberedValue(objRememberedValue9);
                }
                SurfaceKt.m339Surfaceo_FOJdg((Function0) objRememberedValue9, modifierPressScale3, false, roundedCornerShapeM185RoundedCornerShape0680j_6, j3, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, borderStroke2, null, AlbumScreenKt.lambda$1410208107, gapComposer8, 0, 740);
                gapComposer8.end(true);
                gapComposer8.end(true);
                return unit;
            case 8:
                return invoke$com$metrolist$music$ui$screens$library$LibrarySongsScreenKt$$ExternalSyntheticLambda16(obj, obj2, obj3);
            case 9:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj9;
                MutableState mutableState7 = (MutableState) obj8;
                MutableState mutableState8 = (MutableState) obj7;
                Context context5 = (Context) obj5;
                MutableState mutableState9 = (MutableState) obj6;
                Composer composer9 = (Composer) obj2;
                int iIntValue9 = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 17) != 16)) {
                    Object objRememberedValue10 = gapComposer9.rememberedValue();
                    if (objRememberedValue10 == neverEqualPolicy) {
                        objRememberedValue10 = new LibrarySongsScreenKt$$ExternalSyntheticLambda17(mutableState9, (byte) 12);
                        gapComposer9.updateRememberedValue(objRememberedValue10);
                    }
                    CardKt.TextButton((Function0) objRememberedValue10, null, false, null, null, null, TopPlaylistScreenKt.f397lambda$1928152716, gapComposer9, 805306374, 510);
                    boolean z9 = this.f$0;
                    boolean zChanged4 = gapComposer9.changed(z9) | gapComposer9.changedInstance(musicDatabase2) | gapComposer9.changed(mutableState7) | gapComposer9.changed(mutableState8) | gapComposer9.changedInstance(context5);
                    Object objRememberedValue11 = gapComposer9.rememberedValue();
                    if (zChanged4 || objRememberedValue11 == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda25 songMenuKt$$ExternalSyntheticLambda25 = new SongMenuKt$$ExternalSyntheticLambda25(context5, mutableState9, mutableState7, mutableState8, musicDatabase2, z9);
                        gapComposer9.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda25);
                        objRememberedValue11 = songMenuKt$$ExternalSyntheticLambda25;
                    }
                    CardKt.TextButton((Function0) objRememberedValue11, null, false, null, null, null, TopPlaylistScreenKt.f387lambda$1401595541, gapComposer9, 805306368, 510);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case 10:
                PlaylistItem playlistItem = (PlaylistItem) obj9;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj7;
                OnlinePlaylistViewModel onlinePlaylistViewModel = (OnlinePlaylistViewModel) obj6;
                MutableState mutableState10 = (MutableState) obj8;
                State state2 = (State) obj5;
                Composer composer10 = (Composer) obj2;
                int iIntValue10 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 17) != 16)) {
                    TopPlaylistScreenKt.OnlinePlaylistHeader(playlistItem, (List) mutableState10.getValue(), (Playlist) state2.getValue(), coroutineScope2, onlinePlaylistViewModel.continuation, this.f$0, DialogKt.m1476riseInwH6b6FI$default(companion, 0), gapComposer10, 0);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            default:
                NavHostController navHostController = (NavHostController) obj9;
                MutableState mutableState11 = (MutableState) obj8;
                Function1 function9 = (Function1) obj7;
                LazyListState lazyListState = (LazyListState) obj6;
                MutableState mutableState12 = (MutableState) obj5;
                PaddingValues paddingValues = (PaddingValues) obj;
                Composer composer11 = (Composer) obj2;
                int iIntValue11 = ((Integer) obj3).intValue();
                paddingValues.getClass();
                if ((iIntValue11 & 6) == 0) {
                    iIntValue11 |= ((GapComposer) composer11).changed(paddingValues) ? 4 : 2;
                }
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue11 & 1, (iIntValue11 & 19) != 18)) {
                    Modifier modifierThen2 = OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, CropImageView.DEFAULT_ASPECT_RATIO, paddingValues.mo125calculateTopPaddingD9Ej5fM(), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 13).then(SizeKt.FillWholeMaxSize);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode3 = Long.hashCode(gapComposer11.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer11.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer11, modifierThen2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer11.startReusableNode();
                    if (gapComposer11.inserting) {
                        gapComposer11.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer11.useNode();
                    }
                    Stack.m390setimpl(gapComposer11, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer11, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer11, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer11);
                    Stack.m390setimpl(gapComposer11, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                    int iOrdinal = ((SearchSource) mutableState12.getValue()).ordinal();
                    boolean z10 = this.f$0;
                    if (iOrdinal == 0) {
                        gapComposer11.startReplaceGroup(100223174);
                        String str3 = ((TextFieldValue) mutableState11.getValue()).annotatedString.text;
                        boolean zChangedInstance7 = gapComposer11.changedInstance(navHostController);
                        Object objRememberedValue12 = gapComposer11.rememberedValue();
                        if (zChangedInstance7 || objRememberedValue12 == neverEqualPolicy) {
                            objRememberedValue12 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, (byte) 0);
                            gapComposer11.updateRememberedValue(objRememberedValue12);
                        }
                        LocalSearchScreenKt.LocalSearchScreen(str3, (Function0) objRememberedValue12, z10, null, gapComposer11, 0);
                        gapComposer11.end(false);
                    } else {
                        if (iOrdinal != 1) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer11, -1659336405, false);
                        }
                        gapComposer11.startReplaceGroup(100505305);
                        String str4 = ((TextFieldValue) mutableState11.getValue()).annotatedString.text;
                        boolean zChanged5 = gapComposer11.changed(mutableState11);
                        Object objRememberedValue13 = gapComposer11.rememberedValue();
                        if (zChanged5 || objRememberedValue13 == neverEqualPolicy) {
                            objRememberedValue13 = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState11, (byte) 17);
                            gapComposer11.updateRememberedValue(objRememberedValue13);
                        }
                        Function1 function10 = (Function1) objRememberedValue13;
                        Object objRememberedValue14 = gapComposer11.rememberedValue();
                        if (objRememberedValue14 == neverEqualPolicy) {
                            objRememberedValue14 = new SearchScreenKt$$ExternalSyntheticLambda0((byte) 24);
                            gapComposer11.updateRememberedValue(objRememberedValue14);
                        }
                        OnlineSearchScreenKt.OnlineSearchScreen(str4, function10, function9, (Function0) objRememberedValue14, z10, null, gapComposer11, 3072);
                        gapComposer11.end(false);
                    }
                    boolean zChangedInstance8 = gapComposer11.changedInstance(navHostController);
                    Object objRememberedValue15 = gapComposer11.rememberedValue();
                    if (zChangedInstance8 || objRememberedValue15 == neverEqualPolicy) {
                        objRememberedValue15 = new SearchScreenKt$$ExternalSyntheticLambda11(navHostController, (byte) 11);
                        gapComposer11.updateRememberedValue(objRememberedValue15);
                    }
                    MenuKt.HideOnScrollFAB(BoxScopeInstance.INSTANCE, false, lazyListState, R.drawable.mic, (Function0) objRememberedValue15, null, gapComposer11, 6, 17);
                    gapComposer11.end(true);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda16(NavHostController navHostController, boolean z, MutableState mutableState, Function1 function1, LazyListState lazyListState, SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2 searchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2) {
        this.f$1 = navHostController;
        this.f$0 = z;
        this.f$4 = mutableState;
        this.f$2 = function1;
        this.f$3 = lazyListState;
        this.f$5 = searchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda16(PlaylistItem playlistItem, CoroutineScope coroutineScope, OnlinePlaylistViewModel onlinePlaylistViewModel, boolean z, MutableState mutableState, State state) {
        this.f$1 = playlistItem;
        this.f$2 = coroutineScope;
        this.f$3 = onlinePlaylistViewModel;
        this.f$0 = z;
        this.f$4 = mutableState;
        this.f$5 = state;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda16(SongSortType songSortType, boolean z, Function1 function1, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, ArrayList arrayList, MutableState mutableState) {
        this.f$1 = songSortType;
        this.f$0 = z;
        this.f$2 = function1;
        this.f$3 = mimesKt$$ExternalSyntheticLambda0;
        this.f$5 = arrayList;
        this.f$4 = mutableState;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda16(AlbumWithSongs albumWithSongs, boolean z, PlayerConnection playerConnection, State state, MusicDatabase musicDatabase, MenuState menuState) {
        this.f$1 = albumWithSongs;
        this.f$0 = z;
        this.f$2 = playerConnection;
        this.f$3 = state;
        this.f$4 = musicDatabase;
        this.f$5 = menuState;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda16(ListenTogetherManager listenTogetherManager, SongItem songItem, List list, Function0 function0, boolean z, PlayerConnection playerConnection) {
        this.f$3 = listenTogetherManager;
        this.f$4 = songItem;
        this.f$5 = list;
        this.f$1 = function0;
        this.f$0 = z;
        this.f$2 = playerConnection;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda16(boolean z, Context context, PlayerConnection playerConnection, Function0 function0, MutableState mutableState, MediaMetadata mediaMetadata) {
        this.f$0 = z;
        this.f$5 = context;
        this.f$2 = playerConnection;
        this.f$1 = function0;
        this.f$4 = mutableState;
        this.f$3 = mediaMetadata;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda16(boolean z, Playlist playlist, CoroutineScope coroutineScope, PlayerConnection playerConnection, Function0 function0, MutableState mutableState) {
        this.f$0 = z;
        this.f$3 = playlist;
        this.f$5 = coroutineScope;
        this.f$2 = playerConnection;
        this.f$1 = function0;
        this.f$4 = mutableState;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda16(boolean z, PlayerConnection playerConnection, SongItem songItem, Function0 function0, MutableState mutableState, Context context) {
        this.f$0 = z;
        this.f$2 = playerConnection;
        this.f$3 = songItem;
        this.f$1 = function0;
        this.f$4 = mutableState;
        this.f$5 = context;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda16(boolean z, Function0 function0, MutableState mutableState, PlayerConnection playerConnection, AlbumItem albumItem, Context context) {
        this.f$0 = z;
        this.f$1 = function0;
        this.f$4 = mutableState;
        this.f$2 = playerConnection;
        this.f$3 = albumItem;
        this.f$5 = context;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda16(boolean z, Function0 function0, PlayerConnection playerConnection, Album album, MutableState mutableState, Context context) {
        this.f$0 = z;
        this.f$1 = function0;
        this.f$2 = playerConnection;
        this.f$3 = album;
        this.f$4 = mutableState;
        this.f$5 = context;
    }

    public /* synthetic */ AlbumMenuKt$$ExternalSyntheticLambda16(boolean z, Function0 function0, PlayerConnection playerConnection, ArrayList arrayList, Function0 function1, MutableState mutableState) {
        this.f$0 = z;
        this.f$1 = function0;
        this.f$2 = playerConnection;
        this.f$3 = arrayList;
        this.f$5 = function1;
        this.f$4 = mutableState;
    }
}
