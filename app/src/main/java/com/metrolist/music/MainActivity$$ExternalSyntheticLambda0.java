package com.metrolist.music;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.window.PopupLayout;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.compose.DialogNavigator;
import androidx.sqlite.SQLite;
import coil3.compose.AsyncImageKt;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.request.ImageRequest;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.HistoryPage;
import com.metrolist.innertube.pages.SearchSummary;
import com.metrolist.music.constants.GridItemSize;
import com.metrolist.music.constants.LibraryFilter;
import com.metrolist.music.constants.LyricsAnimationStyle;
import com.metrolist.music.constants.PlayerBackgroundStyle;
import com.metrolist.music.constants.PlayerButtonsStyle;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.EventWithSong;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.listentogether.proto.Listentogether;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import com.metrolist.music.ui.component.Material3SettingsItem;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.screens.OptionStats;
import com.metrolist.music.ui.screens.settings.LyricsPosition;
import com.metrolist.music.ui.screens.settings.NavigationTab;
import com.metrolist.music.ui.theme.UiStyle;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.DateAgo;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.ParametersBuilder;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.MatcherMatchResult;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda116(Object obj, Object obj2) {
        int i;
        int i2;
        PlayerButtonsStyle playerButtonsStyle = (PlayerButtonsStyle) this.f$0;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            int iOrdinal = playerButtonsStyle.ordinal();
            if (iOrdinal == 0) {
                i = 1633919020;
                i2 = R.string.default_style;
            } else if (iOrdinal == 1) {
                i = 1633922386;
                i2 = R.string.primary_color_style;
            } else {
                if (iOrdinal != 2) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer, 1633916364, false);
                }
                i = 1633925971;
                i2 = R.string.tertiary_color_style;
            }
            TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer, i, i2, gapComposer, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda13(Object obj, Object obj2) {
        int i;
        int i2;
        LibraryFilter libraryFilter = (LibraryFilter) this.f$0;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            int iOrdinal = libraryFilter.ordinal();
            if (iOrdinal == 0) {
                i = -875302220;
                i2 = R.string.songs;
            } else if (iOrdinal == 1) {
                i = -875299274;
                i2 = R.string.artists;
            } else if (iOrdinal == 2) {
                i = -875296299;
                i2 = R.string.albums;
            } else if (iOrdinal == 3) {
                i = -875293256;
                i2 = R.string.playlists;
            } else if (iOrdinal == 4) {
                i = -875290146;
                i2 = R.string.filter_podcasts;
            } else {
                if (iOrdinal != 5) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer, -875304178, false);
                }
                i = -875286883;
                i2 = R.string.filter_library;
            }
            TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer, i, i2, gapComposer, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda133(Object obj, Object obj2) {
        int i;
        int i2;
        LyricsAnimationStyle lyricsAnimationStyle = (LyricsAnimationStyle) this.f$0;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            int iOrdinal = lyricsAnimationStyle.ordinal();
            if (iOrdinal == 0) {
                i = -1178126494;
                i2 = R.string.lyrics_animation_none;
            } else if (iOrdinal == 1) {
                i = -1178122654;
                i2 = R.string.lyrics_animation_fade;
            } else if (iOrdinal == 2) {
                i = -1178118814;
                i2 = R.string.lyrics_animation_glow;
            } else if (iOrdinal == 3) {
                i = -1178114941;
                i2 = R.string.lyrics_animation_slide;
            } else if (iOrdinal == 4) {
                i = -1178110971;
                i2 = R.string.lyrics_animation_karaoke;
            } else {
                if (iOrdinal != 5) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer, -1178129035, false);
                }
                i = -1178107005;
                i2 = R.string.lyrics_animation_apple;
            }
            TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer, i, i2, gapComposer, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda139(Object obj, Object obj2) {
        int i;
        int i2;
        LyricsPosition lyricsPosition = (LyricsPosition) this.f$0;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            int iOrdinal = lyricsPosition.ordinal();
            if (iOrdinal == 0) {
                i = -1638172362;
                i2 = R.string.left;
            } else if (iOrdinal == 1) {
                i = -1638169320;
                i2 = R.string.center;
            } else {
                if (iOrdinal != 2) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer, -1638174829, false);
                }
                i = -1638166249;
                i2 = R.string.right;
            }
            TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer, i, i2, gapComposer, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda26(Object obj, Object obj2) {
        int i;
        int i2;
        GridItemSize gridItemSize = (GridItemSize) this.f$0;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        GapComposer gapComposer = (GapComposer) composer;
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            int iOrdinal = gridItemSize.ordinal();
            if (iOrdinal == 0) {
                i = -527408648;
                i2 = R.string.big;
            } else {
                if (iOrdinal != 1) {
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer, -527410943, false);
                }
                i = -527405862;
                i2 = R.string.small;
            }
            TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer, i, i2, gapComposer, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:187:0x0570  */
    /* JADX WARN: Code duplicated, block: B:188:0x0574  */
    /* JADX WARN: Code duplicated, block: B:321:0x09ac  */
    /* JADX WARN: Code duplicated, block: B:322:0x09f4  */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws XmlPullParserException, IOException {
        String strStringResource;
        int i;
        int i2;
        String strResolve;
        String strJoinByBullet;
        String strResolve2;
        String strResolve3;
        String str;
        String strJoinToArtistString;
        long j;
        int i3;
        String str2;
        String str3;
        int iCompare;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        byte b = this.$r8$classId;
        Object obj3 = Composer.Companion.Empty;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetModifier;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
        Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetMeasurePolicy;
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
        int i12 = 2;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                MainActivity mainActivity = (MainActivity) obj4;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i13 = MainActivity.$r8$clinit;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else if (((Boolean) mainActivity.appReady$delegate.getValue()).booleanValue()) {
                    gapComposer.startReplaceGroup(-1296266529);
                    String str4 = (String) mainActivity.latestVersionName$delegate.getValue();
                    boolean zChangedInstance = gapComposer.changedInstance(mainActivity);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == obj3) {
                        objRememberedValue = new DiskLruCache$$ExternalSyntheticLambda0((byte) 21, mainActivity);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function1 = (Function1) objRememberedValue;
                    PlayerConnection playerConnection = (PlayerConnection) mainActivity.playerConnectionSnapshot$delegate.getValue();
                    MusicDatabase musicDatabase = mainActivity.database;
                    if (musicDatabase == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("database");
                        throw null;
                    }
                    DownloadUtil downloadUtil = mainActivity.downloadUtil;
                    if (downloadUtil == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("downloadUtil");
                        throw null;
                    }
                    SyncUtils syncUtils = mainActivity.syncUtils;
                    if (syncUtils == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("syncUtils");
                        throw null;
                    }
                    int i14 = DownloadUtil.$stable << 12;
                    int i15 = SyncUtils.$r8$clinit;
                    mainActivity.MetrolistApp(str4, function1, playerConnection, musicDatabase, downloadUtil, syncUtils, gapComposer, i14 | 266752);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1295885973);
                    gapComposer.end(false);
                }
                return unit;
            case 1:
                ((Integer) obj2).getClass();
                ((PopupLayout) obj4).Content(Stack.updateChangedFlags(1), (Composer) obj);
                return unit;
            case 2:
                ((Integer) obj2).getClass();
                SQLite.DialogHost((DialogNavigator) obj4, (Composer) obj, Stack.updateChangedFlags(1));
                return unit;
            case 3:
                SnackbarHostState snackbarHostState = (SnackbarHostState) obj4;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                int i16 = MainActivity.$r8$clinit;
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    ScrimKt.SnackbarHost(snackbarHostState, null, null, gapComposer2, 6, 6);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 4:
                Integer num = (Integer) obj4;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                int i17 = MainActivity.$r8$clinit;
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    if (num == null) {
                        gapComposer3.startReplaceGroup(1245412366);
                        gapComposer3.end(false);
                        strStringResource = null;
                    } else {
                        gapComposer3.startReplaceGroup(1245412367);
                        strStringResource = MathKt.stringResource(num.intValue(), gapComposer3);
                        gapComposer3.end(false);
                    }
                    TextKt.m352TextNvy7gAk(strStringResource == null ? "" : strStringResource, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer3, 0, 0, 131070);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            case 5:
                ParametersBuilder parametersBuilder = (ParametersBuilder) obj4;
                String str5 = (String) obj;
                List list = (List) obj2;
                str5.getClass();
                list.getClass();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    parametersBuilder.append(str5, (String) it.next());
                }
                return unit;
            case 6:
                Pair pair = (Pair) obj4;
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk((String) pair.second, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262142);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
            case 7:
                OptionStats optionStats = (OptionStats) obj4;
                Composer composer5 = (Composer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                GapComposer gapComposer5 = (GapComposer) composer5;
                if (gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    int iOrdinal = optionStats.ordinal();
                    if (iOrdinal == 0) {
                        i = -631653284;
                        i2 = R.string.weeks;
                    } else if (iOrdinal == 1) {
                        i = -631650531;
                        i2 = R.string.months;
                    } else if (iOrdinal == 2) {
                        i = -631647780;
                        i2 = R.string.years;
                    } else {
                        if (iOrdinal != 3) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer5, -631655254, false);
                        }
                        i = -631644895;
                        i2 = R.string.continuous;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer5, i, i2, gapComposer5, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                } else {
                    gapComposer5.skipToGroupEnd();
                }
                return unit;
            case 8:
                YTItem yTItem = (YTItem) obj4;
                Composer composer6 = (Composer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                GapComposer gapComposer6 = (GapComposer) composer6;
                if (gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    Map map = (Map) gapComposer6.consume(MainActivityKt.LocalArtistNameAliases);
                    String strM = IntIntPair$$ExternalSyntheticOutline0.m(ServerSentEventKt.SPACE, MathKt.stringResource(R.string.and, gapComposer6), ServerSentEventKt.SPACE);
                    if (yTItem != null) {
                        if (yTItem instanceof SongItem) {
                            gapComposer6.startReplaceGroup(1139395521);
                            SongItem songItem = (SongItem) yTItem;
                            List list2 = songItem.artists;
                            boolean zChangedInstance2 = gapComposer6.changedInstance(map);
                            Object objRememberedValue2 = gapComposer6.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue2 == obj3) {
                                objRememberedValue2 = new QueueKt$$ExternalSyntheticLambda40(map, (byte) 3);
                                gapComposer6.updateRememberedValue(objRememberedValue2);
                            }
                            String strJoinToArtistString2 = UtilsKt.joinToArtistString(list2, strM, (Function1) objRememberedValue2);
                            Integer num2 = songItem.duration;
                            strJoinByBullet = UtilsKt.joinByBullet(strJoinToArtistString2, UtilsKt.makeTimeString(num2 != null ? Long.valueOf(((long) num2.intValue()) * 1000) : null));
                            gapComposer6.end(false);
                        } else if (yTItem instanceof AlbumItem) {
                            gapComposer6.startReplaceGroup(1139401964);
                            AlbumItem albumItem = (AlbumItem) yTItem;
                            List list3 = albumItem.artists;
                            if (list3 == null) {
                                gapComposer6.startReplaceGroup(961747720);
                                gapComposer6.end(false);
                                strJoinToArtistString = null;
                            } else {
                                gapComposer6.startReplaceGroup(1139402777);
                                boolean zChangedInstance3 = gapComposer6.changedInstance(map);
                                Object objRememberedValue3 = gapComposer6.rememberedValue();
                                if (zChangedInstance3 || objRememberedValue3 == obj3) {
                                    objRememberedValue3 = new QueueKt$$ExternalSyntheticLambda40(map, (byte) 4);
                                    gapComposer6.updateRememberedValue(objRememberedValue3);
                                }
                                strJoinToArtistString = UtilsKt.joinToArtistString(list3, strM, (Function1) objRememberedValue3);
                                gapComposer6.end(false);
                            }
                            Integer num3 = albumItem.year;
                            strJoinByBullet = UtilsKt.joinByBullet(strJoinToArtistString, num3 != null ? String.valueOf(num3.intValue()) : null);
                            gapComposer6.end(false);
                        } else {
                            if (yTItem instanceof ArtistItem) {
                                gapComposer6.startReplaceGroup(961897512);
                                gapComposer6.end(false);
                                str = null;
                            } else if (yTItem instanceof PlaylistItem) {
                                gapComposer6.startReplaceGroup(1139408872);
                                gapComposer6.end(false);
                                PlaylistItem playlistItem = (PlaylistItem) yTItem;
                                Artist artist = playlistItem.author;
                                if (artist != null) {
                                    ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                                    strResolve3 = ArtistNameAliases.resolve(artist.id, artist.name, map);
                                } else {
                                    strResolve3 = null;
                                }
                                strJoinByBullet = UtilsKt.joinByBullet(strResolve3, playlistItem.songCountText);
                            } else if (yTItem instanceof PodcastItem) {
                                gapComposer6.startReplaceGroup(1139413547);
                                gapComposer6.end(false);
                                PodcastItem podcastItem = (PodcastItem) yTItem;
                                Artist artist2 = podcastItem.author;
                                if (artist2 != null) {
                                    ArtistNameAliases artistNameAliases2 = ArtistNameAliases.INSTANCE;
                                    strResolve2 = ArtistNameAliases.resolve(artist2.id, artist2.name, map);
                                } else {
                                    strResolve2 = null;
                                }
                                strJoinByBullet = UtilsKt.joinByBullet(strResolve2, podcastItem.episodeCountText);
                            } else if (yTItem instanceof EpisodeItem) {
                                gapComposer6.startReplaceGroup(1139418337);
                                gapComposer6.end(false);
                                EpisodeItem episodeItem = (EpisodeItem) yTItem;
                                Artist artist3 = episodeItem.author;
                                if (artist3 != null) {
                                    ArtistNameAliases artistNameAliases3 = ArtistNameAliases.INSTANCE;
                                    strResolve = ArtistNameAliases.resolve(artist3.id, artist3.name, map);
                                } else {
                                    strResolve = null;
                                }
                                Integer num4 = episodeItem.duration;
                                strJoinByBullet = UtilsKt.joinByBullet(strResolve, UtilsKt.makeTimeString(num4 != null ? Long.valueOf(((long) num4.intValue()) * 1000) : null));
                            }
                            if (str != null) {
                                gapComposer6.startReplaceGroup(962427241);
                                StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer6, 0, 24960, 110586);
                                gapComposer6.end(false);
                            } else {
                                gapComposer6.startReplaceGroup(962687021);
                                gapComposer6.end(false);
                            }
                        }
                        str = strJoinByBullet;
                        if (str != null) {
                            gapComposer6.startReplaceGroup(962427241);
                            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                            TextKt.m352TextNvy7gAk(str, null, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal2)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal2)).typography.bodySmall, gapComposer6, 0, 24960, 110586);
                            gapComposer6.end(false);
                        } else {
                            gapComposer6.startReplaceGroup(962687021);
                            gapComposer6.end(false);
                        }
                    }
                    throw Format$$ExternalSyntheticOutline0.m(gapComposer6, 1139394911, false);
                }
                gapComposer6.skipToGroupEnd();
                return unit;
            case 9:
                Material3SettingsItem material3SettingsItem = (Material3SettingsItem) obj4;
                Composer composer7 = (Composer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                GapComposer gapComposer7 = (GapComposer) composer7;
                if (gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    material3SettingsItem.title.invoke(gapComposer7, 0);
                } else {
                    gapComposer7.skipToGroupEnd();
                }
                return unit;
            case 10:
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) obj4;
                Composer composer8 = (Composer) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                GapComposer gapComposer8 = (GapComposer) composer8;
                if (gapComposer8.shouldExecute(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    String strM2 = IntIntPair$$ExternalSyntheticOutline0.m(parcelableSnapshotMutableIntState.getIntValue(), parcelableSnapshotMutableIntState.getIntValue() >= 0 ? "+" : "", "ms");
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(strM2, null, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal3)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer8.consume(staticProvidableCompositionLocal3)).typography.bodyMedium, gapComposer8, 0, 0, 131066);
                } else {
                    gapComposer8.skipToGroupEnd();
                }
                return unit;
            case 11:
                Album album = (Album) obj4;
                Composer composer9 = (Composer) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                GapComposer gapComposer9 = (GapComposer) composer9;
                if (gapComposer9.shouldExecute(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(album.name, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer9, 0, 0, 262142);
                } else {
                    gapComposer9.skipToGroupEnd();
                }
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                AlbumEntity albumEntity = ((AlbumWithSongs) obj4).album;
                Composer composer10 = (Composer) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                GapComposer gapComposer10 = (GapComposer) composer10;
                if (gapComposer10.shouldExecute(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    FillElement fillElement = SizeKt.FillWholeMaxSize;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                    int iHashCode = Long.hashCode(gapComposer10.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer10.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer10, fillElement);
                    ComposeUiNode.Companion.getClass();
                    gapComposer10.startReusableNode();
                    if (gapComposer10.inserting) {
                        gapComposer10.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer10.useNode();
                    }
                    Stack.m390setimpl(gapComposer10, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer10, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer10, Integer.valueOf(iHashCode), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer10);
                    Stack.m390setimpl(gapComposer10, modifierMaterializeModifier, updater$$ExternalSyntheticLambda0);
                    Painter painterPainterResource = IntMath.painterResource(albumEntity.bookmarkedAt != null ? R.drawable.favorite : R.drawable.favorite_border, 0, gapComposer10);
                    if (albumEntity.bookmarkedAt != null) {
                        gapComposer10.startReplaceGroup(-49099837);
                        j = ((MaterialTheme$Values) gapComposer10.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                        gapComposer10.end(false);
                    } else {
                        gapComposer10.startReplaceGroup(-48973791);
                        j = ((MaterialTheme$Values) gapComposer10.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurface;
                        gapComposer10.end(false);
                    }
                    IconKt.m290Iconww6aTOc(painterPainterResource, (String) null, SizeKt.m151size3ABfNKs(companion, 22.0f), j, gapComposer10, 440, 0);
                    gapComposer10.end(true);
                } else {
                    gapComposer10.skipToGroupEnd();
                }
                return unit;
            case 13:
                int iIntValue11 = ((Integer) obj).intValue();
                SongItem songItem2 = (SongItem) obj2;
                songItem2.getClass();
                return ((HistoryPage.HistorySection) obj4).title + "_" + songItem2.id + "_" + iIntValue11;
            case 14:
                int iIntValue12 = ((Integer) obj).intValue();
                EventWithSong eventWithSong = (EventWithSong) obj2;
                eventWithSong.getClass();
                return ((DateAgo) obj4) + "_" + eventWithSong.event.id + "_" + iIntValue12;
            case 15:
                Listentogether.JoinRequestPayload joinRequestPayload = (Listentogether.JoinRequestPayload) obj4;
                Composer composer11 = (Composer) obj;
                int iIntValue13 = ((Integer) obj2).intValue();
                GapComposer gapComposer11 = (GapComposer) composer11;
                if (gapComposer11.shouldExecute(iIntValue13 & 1, (iIntValue13 & 3) != 2)) {
                    BiasAlignment biasAlignment = Alignment.Companion.Center;
                    FillElement fillElement2 = SizeKt.FillWholeMaxSize;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                    int iHashCode2 = Long.hashCode(gapComposer11.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer11.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer11, fillElement2);
                    ComposeUiNode.Companion.getClass();
                    gapComposer11.startReusableNode();
                    if (gapComposer11.inserting) {
                        gapComposer11.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer11.useNode();
                    }
                    Stack.m390setimpl(gapComposer11, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer11, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer11, Integer.valueOf(iHashCode2), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer11);
                    Stack.m390setimpl(gapComposer11, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda0);
                    String username = joinRequestPayload.getUsername();
                    username.getClass();
                    String upperCase = StringsKt.take(1, username).toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal4 = MaterialThemeKt._localMaterialTheme;
                    TextKt.m352TextNvy7gAk(upperCase, null, ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal4)).colorScheme.onSecondary, 0L, null, FontWeight.Bold, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer11.consume(staticProvidableCompositionLocal4)).typography.titleMedium, gapComposer11, 1572864, 0, 131002);
                    gapComposer11.end(true);
                } else {
                    gapComposer11.skipToGroupEnd();
                }
                return unit;
            case 16:
                Collator collator = (Collator) obj4;
                LocalItem localItem = (LocalItem) obj;
                LocalItem localItem2 = (LocalItem) obj2;
                if (localItem == null) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                } else {
                    boolean z = localItem instanceof Playlist;
                    if (z) {
                        i3 = 0;
                    } else if (localItem instanceof Song) {
                        i3 = 1;
                    } else if (localItem instanceof com.metrolist.music.db.entities.Artist) {
                        i3 = 2;
                    } else if (localItem instanceof com.metrolist.music.db.entities.Album) {
                        i3 = 3;
                    } else {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                    }
                    if (localItem2 != null) {
                        boolean z2 = localItem2 instanceof Playlist;
                        if (z2) {
                            i12 = 0;
                        } else if (localItem2 instanceof Song) {
                            i12 = 1;
                        } else if (!(localItem2 instanceof com.metrolist.music.db.entities.Artist)) {
                            if (localItem2 instanceof com.metrolist.music.db.entities.Album) {
                                i12 = 3;
                            } else {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                            }
                        }
                        if (i3 != i12) {
                            iCompare = Intrinsics.compare(i3, i12);
                        } else {
                            if (z) {
                                str2 = ((Playlist) localItem).playlist.name;
                            } else if (localItem instanceof Song) {
                                str2 = ((Song) localItem).song.title;
                            } else if (localItem instanceof com.metrolist.music.db.entities.Artist) {
                                str2 = ((com.metrolist.music.db.entities.Artist) localItem).artist.name;
                            } else if (localItem instanceof com.metrolist.music.db.entities.Album) {
                                str2 = ((com.metrolist.music.db.entities.Album) localItem).album.title;
                            } else {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                            }
                            if (z2) {
                                str3 = ((Playlist) localItem2).playlist.name;
                            } else if (localItem2 instanceof Song) {
                                str3 = ((Song) localItem2).song.title;
                            } else if (localItem2 instanceof com.metrolist.music.db.entities.Artist) {
                                str3 = ((com.metrolist.music.db.entities.Artist) localItem2).artist.name;
                            } else if (localItem2 instanceof com.metrolist.music.db.entities.Album) {
                                str3 = ((com.metrolist.music.db.entities.Album) localItem2).album.title;
                            } else {
                                PathKt$$ExternalSyntheticBUOutline0.m$1();
                            }
                            iCompare = collator.compare(str2, str3);
                        }
                        return Integer.valueOf(iCompare);
                    }
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                }
                return null;
            case 17:
                PlaylistItem playlistItem2 = (PlaylistItem) obj4;
                Composer composer12 = (Composer) obj;
                int iIntValue14 = ((Integer) obj2).intValue();
                GapComposer gapComposer12 = (GapComposer) composer12;
                if (gapComposer12.shouldExecute(iIntValue14 & 1, (iIntValue14 & 3) != 2)) {
                    ImageRequest.Builder builder = new ImageRequest.Builder((Context) gapComposer12.consume(AndroidCompositionLocals_androidKt.LocalContext));
                    String str6 = playlistItem2.thumbnail;
                    builder.data = str6 != null ? YouTubeUtilsKt.resize(str6, 1080, 1080) : null;
                    AsyncImageKt.m849AsyncImage10Xjiaw(builder.build(), SizeKt.FillWholeMaxSize, ContentScale.Companion.Crop, gapComposer12, 1573296, 1976);
                } else {
                    gapComposer12.skipToGroupEnd();
                }
                return unit;
            case 18:
                int iIntValue15 = ((Integer) obj).intValue();
                YTItem yTItem2 = (YTItem) obj2;
                yTItem2.getClass();
                return ((SearchSummary) obj4).title + "/" + yTItem2.getId() + "/" + iIntValue15;
            case 19:
                DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1 = (DataStoreKt$rememberPreference$1$1) obj4;
                Composer composer13 = (Composer) obj;
                int iIntValue16 = ((Integer) obj2).intValue();
                GapComposer gapComposer13 = (GapComposer) composer13;
                if (gapComposer13.shouldExecute(iIntValue16 & 1, (iIntValue16 & 3) != 2)) {
                    TextKt.m352TextNvy7gAk((String) dataStoreKt$rememberPreference$1$1.$state.getValue(), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer13, 0, 0, 262142);
                } else {
                    gapComposer13.skipToGroupEnd();
                }
                return unit;
            case 20:
                Map map2 = (Map) obj4;
                Composer composer14 = (Composer) obj;
                int iIntValue17 = ((Integer) obj2).intValue();
                GapComposer gapComposer14 = (GapComposer) composer14;
                if (gapComposer14.shouldExecute(iIntValue17 & 1, (iIntValue17 & 3) != 2)) {
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer14, 0);
                    int iHashCode3 = Long.hashCode(gapComposer14.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope3 = gapComposer14.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier3 = ZIndexModifierKt.materializeModifier(gapComposer14, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer14.startReusableNode();
                    if (gapComposer14.inserting) {
                        gapComposer14.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer14.useNode();
                    }
                    Stack.m390setimpl(gapComposer14, columnMeasurePolicy, updater$$ExternalSyntheticLambda3);
                    Stack.m390setimpl(gapComposer14, persistentCompositionLocalHashMapCurrentCompositionLocalScope3, updater$$ExternalSyntheticLambda2);
                    Stack.m390setimpl(gapComposer14, Integer.valueOf(iHashCode3), updater$$ExternalSyntheticLambda1);
                    Stack.m389reconcileimpl(gapComposer14);
                    Stack.m390setimpl(gapComposer14, modifierMaterializeModifier3, updater$$ExternalSyntheticLambda0);
                    gapComposer14.startReplaceGroup(327576195);
                    for (Map.Entry entry : map2.entrySet()) {
                        String str7 = (String) entry.getKey();
                        String str8 = (String) entry.getValue();
                        if (str8.length() > 0) {
                            gapComposer14.startReplaceGroup(78433639);
                            long j2 = ((MaterialTheme$Values) gapComposer14.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                            StringBuilder sb = new StringBuilder(16);
                            new ArrayList();
                            ArrayList arrayList = new ArrayList();
                            new ArrayList();
                            sb.append(str7 + ": ");
                            Pattern patternCompile = Pattern.compile("https?://[^\\s]+");
                            patternCompile.getClass();
                            Matcher matcher = patternCompile.matcher(str8);
                            matcher.getClass();
                            MatcherMatchResult matcherMatchResultFindNext = RegexKt.findNext(matcher, 0, str8);
                            if (matcherMatchResultFindNext != null) {
                                String value = matcherMatchResultFindNext.getValue();
                                String strSubstring = str8.substring(0, matcherMatchResultFindNext.getRange().first);
                                String strSubstring2 = str8.substring(matcherMatchResultFindNext.getRange().last + 1);
                                sb.append(strSubstring);
                                int length = sb.length();
                                sb.append(value);
                                int length2 = sb.length();
                                sb.append(strSubstring2);
                                arrayList.add(new AnnotatedString.Builder.MutableRange(new LinkAnnotation.Url(value, new TextLinkStyles(new SpanStyle(j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null), null), length, length2, null, 8));
                            } else {
                                sb.append(str8);
                            }
                            String string = sb.toString();
                            ArrayList arrayList2 = new ArrayList(arrayList.size());
                            int size = arrayList.size();
                            for (int i18 = 0; i18 < size; i18++) {
                                arrayList2.add(((AnnotatedString.Builder.MutableRange) arrayList.get(i18)).toRange(sb.length()));
                            }
                            AnnotatedString annotatedString = new AnnotatedString(string, arrayList2);
                            StaticProvidableCompositionLocal staticProvidableCompositionLocal5 = MaterialThemeKt._localMaterialTheme;
                            TextKt.m353TextZ58ophY(annotatedString, OffsetKt.m137paddingVpY3zN4$default(companion, CropImageView.DEFAULT_ASPECT_RATIO, 4.0f, 1), 0L, 0L, null, 0L, null, 0L, 0, false, 0, 0, null, null, TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer14.consume(staticProvidableCompositionLocal5)).typography.bodyMedium, ((MaterialTheme$Values) gapComposer14.consume(staticProvidableCompositionLocal5)).colorScheme.onSurface, 0L, null, null, null, null, 0L, 0L, null, null, 16777214), gapComposer14, 48, 0, 262140);
                            gapComposer14.end(false);
                        } else {
                            gapComposer14.startReplaceGroup(80972601);
                            gapComposer14.end(false);
                        }
                    }
                    gapComposer14.end(false);
                    gapComposer14.end(true);
                } else {
                    gapComposer14.skipToGroupEnd();
                }
                return unit;
            case 21:
                MusicAlarmEntry musicAlarmEntry = (MusicAlarmEntry) obj4;
                Composer composer15 = (Composer) obj;
                int iIntValue18 = ((Integer) obj2).intValue();
                GapComposer gapComposer15 = (GapComposer) composer15;
                if (gapComposer15.shouldExecute(iIntValue18 & 1, (iIntValue18 & 3) != 2)) {
                    if (musicAlarmEntry == null) {
                        i4 = 654821353;
                        i5 = R.string.alarm_new;
                    } else {
                        i4 = 654900744;
                        i5 = R.string.alarm_edit;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer15, i4, i5, gapComposer15, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer15, 0, 0, 262142);
                } else {
                    gapComposer15.skipToGroupEnd();
                }
                return unit;
            case 22:
                NavigationTab navigationTab = (NavigationTab) obj4;
                Composer composer16 = (Composer) obj;
                int iIntValue19 = ((Integer) obj2).intValue();
                GapComposer gapComposer16 = (GapComposer) composer16;
                if (gapComposer16.shouldExecute(iIntValue19 & 1, (iIntValue19 & 3) != 2)) {
                    int iOrdinal2 = navigationTab.ordinal();
                    if (iOrdinal2 == 0) {
                        i6 = -933284430;
                        i7 = R.string.home;
                    } else if (iOrdinal2 == 1) {
                        i6 = -933281548;
                        i7 = R.string.search;
                    } else {
                        if (iOrdinal2 != 2) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer16, -933286745, false);
                        }
                        i6 = -933278564;
                        i7 = R.string.filter_library;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer16, i6, i7, gapComposer16, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer16, 0, 0, 262142);
                } else {
                    gapComposer16.skipToGroupEnd();
                }
                return unit;
            case 23:
                PlayerBackgroundStyle playerBackgroundStyle = (PlayerBackgroundStyle) obj4;
                Composer composer17 = (Composer) obj;
                int iIntValue20 = ((Integer) obj2).intValue();
                GapComposer gapComposer17 = (GapComposer) composer17;
                if (gapComposer17.shouldExecute(iIntValue20 & 1, (iIntValue20 & 3) != 2)) {
                    int iOrdinal3 = playerBackgroundStyle.ordinal();
                    if (iOrdinal3 == 0) {
                        i8 = 290306478;
                        i9 = R.string.follow_theme;
                    } else if (iOrdinal3 == 1) {
                        i8 = 290309930;
                        i9 = R.string.gradient;
                    } else {
                        if (iOrdinal3 != 2) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer17, 290303785, false);
                        }
                        i8 = 290313144;
                        i9 = R.string.player_background_blur;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer17, i8, i9, gapComposer17, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer17, 0, 0, 262142);
                } else {
                    gapComposer17.skipToGroupEnd();
                }
                return unit;
            case 24:
                return invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda116(obj, obj2);
            case 25:
                return invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda133(obj, obj2);
            case 26:
                return invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda139(obj, obj2);
            case 27:
                return invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda13(obj, obj2);
            case 28:
                return invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda26(obj, obj2);
            default:
                UiStyle uiStyle = (UiStyle) obj4;
                Composer composer18 = (Composer) obj;
                int iIntValue21 = ((Integer) obj2).intValue();
                GapComposer gapComposer18 = (GapComposer) composer18;
                if (gapComposer18.shouldExecute(iIntValue21 & 1, (iIntValue21 & 3) != 2)) {
                    int iOrdinal4 = uiStyle.ordinal();
                    if (iOrdinal4 == 0) {
                        i10 = 1584074374;
                        i11 = R.string.ui_style_editorial;
                    } else {
                        if (iOrdinal4 != 1) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer18, 1584072091, false);
                        }
                        i10 = 1584077602;
                        i11 = R.string.ui_style_glass;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer18, i10, i11, gapComposer18, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer18, 0, 0, 262142);
                } else {
                    gapComposer18.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda0(Object obj, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }
}
