package com.metrolist.music;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.collection.ArrayMap;
import androidx.collection.internal.Lock;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.Transition$animateTo$1$1$1;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.text.KeyboardActionRunner;
import androidx.compose.material3.IconKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.text.MultiParagraph$$ExternalSyntheticLambda1;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.navigation.NavHostController;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import coil3.util.FileSystemsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.Converters;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.DatabaseDao_Impl$$ExternalSyntheticLambda120;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.AlbumArtistMap;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.LyricsEntity;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongAlbumMap;
import com.metrolist.music.db.entities.SongArtistMap;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.db.entities.SongWithStats;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.lyrics.LyricsProviderRegistry;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MusicService$$ExternalSyntheticLambda7;
import com.metrolist.music.playback.alarm.MusicAlarmStore$loadBlocking$1;
import com.metrolist.music.ui.component.DraggableLyricsProviderItem;
import com.metrolist.music.ui.component.ItemsKt$$ExternalSyntheticLambda9;
import com.metrolist.music.ui.menu.AlbumMenuKt;
import com.metrolist.music.ui.menu.CustomThumbnailMenuKt$$ExternalSyntheticLambda2;
import com.metrolist.music.ui.menu.PlayerMenuKt$$ExternalSyntheticLambda67;
import com.metrolist.music.ui.menu.QueueMenuKt$QueueMenu$7$1$1$1;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3;
import com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$YouTubePlaylistMenu$lambda$35$0$$inlined$items$default$4;
import com.metrolist.music.ui.menu.YouTubeSongMenuKt$YouTubeSongMenu$8$1$1$3$1$1;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda74;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.screens.AccountScreenKt$AccountScreen$lambda$9$0$$inlined$itemsIndexed$default$4;
import com.metrolist.music.ui.screens.HomeScreenKt$$ExternalSyntheticLambda104;
import com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4;
import com.metrolist.music.ui.screens.HomeSection;
import com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$6$1$1$10$2$1$1;
import com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$lambda$56$0$0$$inlined$items$3;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1;
import com.metrolist.music.ui.screens.equalizer.EQViewModel;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$$ExternalSyntheticLambda7;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3;
import com.metrolist.music.ui.theme.UiStyle;
import com.metrolist.music.ui.utils.YouTubeUtilsKt;
import com.metrolist.music.utils.ArtistNameAliases;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import com.metrolist.music.utils.SyncOperation;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$createPlaylist$1;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.LocalPlaylistViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import io.ktor.http.LinkHeader;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal.ws.RealWebSocket$$ExternalSyntheticLambda2;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda21 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda21(State state, NavHostController navHostController, MutableState mutableState) {
        this.$r8$classId = (byte) 24;
        this.f$1 = state;
        this.f$0 = navHostController;
        this.f$2 = mutableState;
    }

    private final Object invoke$com$metrolist$music$ui$component$GlassComponentsKt$$ExternalSyntheticLambda5(Object obj) {
        State state = (State) this.f$0;
        State state2 = (State) this.f$1;
        State state3 = (State) this.f$2;
        CacheDrawScope cacheDrawScope = (CacheDrawScope) obj;
        cacheDrawScope.getClass();
        int iRoundToInt = MathKt.roundToInt(Float.intBitsToFloat((int) (cacheDrawScope.cacheParams.mo398getSizeNHjbRc() >> 32)));
        if (iRoundToInt < 1) {
            iRoundToInt = 1;
        }
        int iRoundToInt2 = MathKt.roundToInt(Float.intBitsToFloat((int) (cacheDrawScope.cacheParams.mo398getSizeNHjbRc() & 4294967295L)));
        if (iRoundToInt2 < 1) {
            iRoundToInt2 = 1;
        }
        int i = iRoundToInt / 4;
        if (i < 1) {
            i = 1;
        }
        int i2 = iRoundToInt2 / 4;
        int i3 = i2 >= 1 ? i2 : 1;
        AndroidImageBitmap androidImageBitmapM488ImageBitmapx__hDU$default = ColorKt.m488ImageBitmapx__hDU$default(i, i3, 0, 28);
        CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
        LayoutDirection layoutDirection = cacheDrawScope.cacheParams.getLayoutDirection();
        AndroidCanvas androidCanvasActualCanvas = AndroidCanvas_androidKt.ActualCanvas(androidImageBitmapM488ImageBitmapx__hDU$default);
        float f = i;
        float f2 = i3;
        int i4 = iRoundToInt2;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32);
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.drawParams;
        Density density = drawParams.density;
        LayoutDirection layoutDirection2 = drawParams.layoutDirection;
        Canvas canvas = drawParams.canvas;
        long j = drawParams.size;
        drawParams.density = cacheDrawScope;
        drawParams.layoutDirection = layoutDirection;
        drawParams.canvas = androidCanvasActualCanvas;
        drawParams.size = jFloatToRawIntBits;
        androidCanvasActualCanvas.save();
        Color color = (Color) state.getValue();
        long j2 = color.value;
        DrawScope.m549drawRectAsUm42w$default(canvasDrawScope, Lock.m10radialGradientP_VxKs$default(CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{color, new Color(0L)}), (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32), 1.15f * f), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, null, 0, 126);
        Color color2 = (Color) state2.getValue();
        long j3 = color2.value;
        DrawScope.m549drawRectAsUm42w$default(canvasDrawScope, Lock.m10radialGradientP_VxKs$default(CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{color2, new Color(0L)}), (((long) Float.floatToRawIntBits(f * 1.0f)) << 32) | (((long) Float.floatToRawIntBits(0.42f * f2)) & 4294967295L), 0.95f * f), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, null, 0, 126);
        Color color3 = (Color) state3.getValue();
        long j4 = color3.value;
        DrawScope.m549drawRectAsUm42w$default(canvasDrawScope, Lock.m10radialGradientP_VxKs$default(CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{color3, new Color(0L)}), (((long) Float.floatToRawIntBits(f2 * 1.0f)) & 4294967295L) | (((long) Float.floatToRawIntBits(0.05f * f)) << 32), 1.1f * f), 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, null, null, 0, 126);
        androidCanvasActualCanvas.restore();
        drawParams.density = density;
        drawParams.layoutDirection = layoutDirection2;
        drawParams.canvas = canvas;
        drawParams.size = j;
        return cacheDrawScope.onDrawWithContent(new CodecsKt$$ExternalSyntheticLambda0(new MultiParagraph$$ExternalSyntheticLambda1(androidImageBitmapM488ImageBitmapx__hDU$default, iRoundToInt, i4, (byte) 2), (byte) 11));
    }

    private final Object invoke$com$metrolist$music$ui$menu$PlayerMenuKt$$ExternalSyntheticLambda29(Object obj) {
        MutableState mutableState = (MutableState) this.f$0;
        MutableState mutableState2 = (MutableState) this.f$1;
        ListenTogetherManager listenTogetherManager = (ListenTogetherManager) this.f$2;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        lazyListIntervalContent.getClass();
        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -1286807175, new QueueKt$$ExternalSyntheticLambda21(mutableState, (byte) 11)), 3);
        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1395532898, 3);
        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -2137553087, new PlayerMenuKt$$ExternalSyntheticLambda67(mutableState2, listenTogetherManager, mutableState, (byte) 0)), 3);
        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.f87lambda$1375671776, 3);
        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -613790465, new PlayerMenuKt$$ExternalSyntheticLambda67(mutableState2, mutableState, listenTogetherManager)), 3);
        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$148090846, 3);
        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 909972157, new PlayerMenuKt$$ExternalSyntheticLambda67(mutableState2, listenTogetherManager, mutableState, (byte) 2)), 3);
        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, AlbumMenuKt.lambda$1671853468, 3);
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$menu$YouTubePlaylistMenuKt$$ExternalSyntheticLambda3(Object obj) {
        MutableState mutableState = (MutableState) this.f$0;
        MutableState mutableState2 = (MutableState) this.f$1;
        Map map = (Map) this.f$2;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        lazyListIntervalContent.getClass();
        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -144848943, new QueueKt$$ExternalSyntheticLambda21(mutableState, (byte) 15)), 3);
        List list = (List) mutableState2.getValue();
        lazyListIntervalContent.items(list.size(), null, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list, (byte) 13), new ComposableLambdaImpl(true, 802480018, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$lambda$35$0$$inlined$items$default$4(list, map, (byte) 0)));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$menu$YouTubeSelectionSongMenuKt$$ExternalSyntheticLambda27(Object obj) {
        ArrayList arrayList = (ArrayList) this.f$0;
        SyncUtils syncUtils = (SyncUtils) this.f$1;
        MutableState mutableState = (MutableState) this.f$2;
        MusicDatabase musicDatabase = (MusicDatabase) obj;
        musicDatabase.getClass();
        int size = arrayList.size();
        byte b = 0;
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            MediaMetadata mediaMetadata = HexFormatKt.toMediaMetadata((SongItem) obj2);
            if (!((Boolean) mutableState.getValue()).booleanValue() || ((Boolean) mutableState.getValue()).booleanValue()) {
                musicDatabase.insert(mediaMetadata, new DatabaseDao$$ExternalSyntheticLambda0(b));
                String str = mediaMetadata.id;
                String str2 = mediaMetadata.title;
                int i2 = mediaMetadata.duration;
                String str3 = mediaMetadata.thumbnailUrl;
                MediaMetadata.Album album = mediaMetadata.album;
                SongEntity songEntity = new SongEntity(str, str2, i2, str3, album != null ? album.id : null, album != null ? album.title : null, false, true, mediaMetadata.libraryAddToken, mediaMetadata.libraryRemoveToken, false, false, null, 133974976);
                musicDatabase.$$delegate_0.update(songEntity);
                syncUtils.getClass();
                syncUtils.enqueue(new SyncOperation.LikeSong(songEntity));
            }
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$menu$YouTubeSongMenuKt$$ExternalSyntheticLambda44(Object obj) {
        SongEntity songEntity;
        State state = (State) this.f$0;
        SongItem songItem = (SongItem) this.f$1;
        SyncUtils syncUtils = (SyncUtils) this.f$2;
        MusicDatabase musicDatabase = (MusicDatabase) obj;
        musicDatabase.getClass();
        Song song = (Song) state.getValue();
        if (song == null) {
            musicDatabase.insert(HexFormatKt.toMediaMetadata(songItem), YouTubeSongMenuKt$YouTubeSongMenu$8$1$1$3$1$1.INSTANCE);
            songEntity = HexFormatKt.toMediaMetadata(songItem).toSongEntity().toggleLike(true);
        } else {
            SongEntity songEntity2 = song.song.toggleLike(true);
            musicDatabase.$$delegate_0.update(songEntity2);
            songEntity = songEntity2;
        }
        syncUtils.getClass();
        syncUtils.enqueue(new SyncOperation.LikeSong(songEntity));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$HomeScreenKt$$ExternalSyntheticLambda88(Object obj) {
        HomePage.Section section = (HomePage.Section) this.f$0;
        HomeSection.HomePageSection homePageSection = (HomeSection.HomePageSection) this.f$1;
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$2;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        lazyListIntervalContent.getClass();
        List list = section.items;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (hashSet.add(((YTItem) obj2).getId())) {
                arrayList.add(obj2);
            }
        }
        lazyListIntervalContent.items(arrayList.size(), new StatsScreenKt$StatsScreen$6$1$1$10$2$1$1(new HomeScreenKt$$ExternalSyntheticLambda104(homePageSection, (byte) 0), arrayList, (byte) 12), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 19), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(arrayList, composableLambdaImpl, (byte) 6)));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$equalizer$EqScreenKt$$ExternalSyntheticLambda0(Object obj) {
        int columnIndex;
        String string;
        Context context = (Context) this.f$0;
        EQViewModel eQViewModel = (EQViewModel) this.f$1;
        MutableState mutableState = (MutableState) this.f$2;
        Uri uri = (Uri) obj;
        if (uri != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = "custom_eq.txt";
                Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst() && (columnIndex = cursorQuery.getColumnIndex("_display_name")) >= 0 && (string = cursorQuery.getString(columnIndex)) != null && !StringsKt.isBlank(string)) {
                            ref$ObjectRef.element = string;
                        }
                        cursorQuery.close();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CharsKt.closeFinally(cursorQuery, th);
                            throw th2;
                        }
                    }
                }
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                if (inputStreamOpenInputStream != null) {
                    String str = (String) ref$ObjectRef.element;
                    RealWebSocket$$ExternalSyntheticLambda2 realWebSocket$$ExternalSyntheticLambda2 = new RealWebSocket$$ExternalSyntheticLambda2(ref$ObjectRef, (byte) 2);
                    MainActivity$$ExternalSyntheticLambda21 mainActivity$$ExternalSyntheticLambda21 = new MainActivity$$ExternalSyntheticLambda21((Object) ref$ObjectRef, (Object) context, (Object) mutableState, (byte) 21);
                    str.getClass();
                    AwaitKt.launch$default(ViewModelKt.getViewModelScope(eQViewModel), null, null, new QueueMenuKt$QueueMenu$7$1$1$1((Object) inputStreamOpenInputStream, (Object) mainActivity$$ExternalSyntheticLambda21, (Object) str, (Object) eQViewModel, (Object) realWebSocket$$ExternalSyntheticLambda2, (Continuation) null, (byte) 7), 3);
                } else {
                    mutableState.setValue(context.getString(R.string.error_file_read));
                }
            } catch (Exception e) {
                mutableState.setValue(context.getString(R.string.error_file_open, e.getMessage()));
            }
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$equalizer$EqScreenKt$$ExternalSyntheticLambda21(Object obj) {
        Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) this.f$0;
        Context context = (Context) this.f$1;
        MutableState mutableState = (MutableState) this.f$2;
        Exception exc = (Exception) obj;
        exc.getClass();
        ConnectionPool connectionPool = Timber.Forest;
        Objects.toString(ref$ObjectRef.element);
        connectionPool.getClass();
        ConnectionPool.d(new Object[0]);
        mutableState.setValue(context.getString(R.string.import_error_title) + ": " + exc.getMessage());
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$library$LibraryPodcastsScreenKt$$ExternalSyntheticLambda5(Object obj) {
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$1;
        State state = (State) this.f$2;
        NavHostController navHostController = (NavHostController) this.f$0;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        lazyListIntervalContent.getClass();
        lazyListIntervalContent.item("filter", 0, new ComposableLambdaImpl(true, -981776212, new ItemsKt$$ExternalSyntheticLambda9(composableLambdaImpl, (byte) 23)));
        lazyListIntervalContent.item("channels_count", 0, new ComposableLambdaImpl(true, -1556555627, new PlayerKt$$ExternalSyntheticLambda74(state, (byte) 4)));
        List list = (List) state.getValue();
        lazyListIntervalContent.items(list.size(), new ArtistScreenKt$ArtistScreen$lambda$21$0$0$9$$inlined$items$1(new LibraryScreenKt$$ExternalSyntheticLambda7((byte) 17), list, (byte) 25), new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list, (byte) 3), new ComposableLambdaImpl(true, 2039820996, new AccountScreenKt$AccountScreen$lambda$9$0$$inlined$itemsIndexed$default$4(list, navHostController, (byte) 3)));
        if (((List) state.getValue()).isEmpty()) {
            LazyListIntervalContent.item$default(lazyListIntervalContent, "empty", null, LibraryScreenKt.lambda$1407590897, 2);
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$recognition$RecognitionHistoryScreenKt$$ExternalSyntheticLambda8(Object obj) {
        State state = (State) this.f$1;
        NavHostController navHostController = (NavHostController) this.f$0;
        MutableState mutableState = (MutableState) this.f$2;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        lazyListIntervalContent.getClass();
        List list = (List) state.getValue();
        lazyListIntervalContent.items(list.size(), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 20), list, (byte) 8), new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list, (byte) 11), new ComposableLambdaImpl(true, 802480018, new StatsScreenKt$StatsScreen$lambda$56$0$0$$inlined$items$3(list, navHostController, mutableState, (byte) 2)));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$recognition$RecognitionScreenKt$$ExternalSyntheticLambda1(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.f$0;
        MutableState mutableState = (MutableState) this.f$1;
        Context context = (Context) this.f$2;
        Boolean bool = (Boolean) obj;
        boolean zBooleanValue = bool.booleanValue();
        mutableState.setValue(bool);
        if (zBooleanValue) {
            AwaitKt.launch$default(coroutineScope, null, null, new MusicAlarmStore$loadBlocking$1(context, (Continuation) null, (byte) 2), 3);
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AlarmSettingsKt$$ExternalSyntheticLambda38(Object obj) {
        List list = (List) this.f$0;
        MutableState mutableState = (MutableState) this.f$1;
        MutableState mutableState2 = (MutableState) this.f$2;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        lazyListIntervalContent.getClass();
        lazyListIntervalContent.items(list.size(), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 5), list, (byte) 20), new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list, (byte) 0), new ComposableLambdaImpl(true, 802480018, new StatsScreenKt$StatsScreen$lambda$56$0$0$$inlined$items$3(list, mutableState, mutableState2, (byte) 3)));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda140(Object obj) {
        Function1 function1 = (Function1) this.f$0;
        Function1 function2 = (Function1) this.f$1;
        MutableState mutableState = (MutableState) this.f$2;
        UiStyle uiStyle = (UiStyle) obj;
        uiStyle.getClass();
        function1.invoke(uiStyle);
        function2.invoke(Boolean.valueOf(uiStyle == UiStyle.GLASS));
        mutableState.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$ContentSettingsKt$$ExternalSyntheticLambda96(Object obj) {
        ArrayList arrayList = (ArrayList) this.f$0;
        Function1 function1 = (Function1) this.f$1;
        Set set = (Set) this.f$2;
        List list = (List) obj;
        list.getClass();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((DraggableLyricsProviderItem) it.next()).id);
        }
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            if (!set.contains((String) obj2)) {
                arrayList3.add(obj2);
            }
        }
        Map map = LyricsProviderRegistry.providerMap;
        function1.invoke(LyricsProviderRegistry.serializeProviderOrder(CollectionsKt.plus((Iterable) arrayList3, (Collection) arrayList2)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r17v6, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r17v7, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r19v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v24, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r8v0, types: [byte] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v8, types: [int] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Exception {
        boolean z;
        String str;
        String str2;
        byte b = this.$r8$classId;
        byte b2 = 5;
        int i = 2;
        ?? r8 = 0;
        int i2 = 0;
        int i3 = 0;
        Continuation continuation = null;
        byte b3 = 1;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                NavHostController navHostController = (NavHostController) obj4;
                MainActivity mainActivity = (MainActivity) obj3;
                MusicDatabase musicDatabase = (MusicDatabase) obj2;
                String str3 = (String) obj;
                int i4 = MainActivity.$r8$clinit;
                str3.getClass();
                if (str3.length() > 0) {
                    NavHostController.navigate$default(navHostController, "search/" + Uri.encode("__metrolist_search_query__".concat(str3)));
                    if (!Intrinsics.areEqual(UtilsKt.get(UtilsKt.getDataStore(mainActivity), PreferenceKeysKt.PauseSearchHistoryKey), Boolean.TRUE)) {
                        LifecycleCoroutineScopeImpl coroutineScope = ViewModelKt.getCoroutineScope(mainActivity.getLifecycle());
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new SyncUtils$createPlaylist$1.AnonymousClass1(musicDatabase, str3, null, b2), 2);
                    }
                }
                return unit;
            case 1:
                Object obj5 = null;
                List list = (List) obj3;
                DatabaseDao_Impl databaseDao_Impl = (DatabaseDao_Impl) obj2;
                SQLiteConnection sQLiteConnection = (SQLiteConnection) obj;
                sQLiteConnection.getClass();
                SQLiteStatement sQLiteStatementPrepare = sQLiteConnection.prepare((String) obj4);
                try {
                    Iterator it = list.iterator();
                    int i5 = 1;
                    while (it.hasNext()) {
                        sQLiteStatementPrepare.bindText(i5, (String) it.next());
                        i5++;
                    }
                    int columnIndexOrThrow = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
                    int columnIndexOrThrow2 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, LinkHeader.Parameters.Title);
                    int columnIndexOrThrow3 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "duration");
                    int columnIndexOrThrow4 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "thumbnailUrl");
                    int columnIndexOrThrow5 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "albumId");
                    int columnIndexOrThrow6 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "albumName");
                    int columnIndexOrThrow7 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "explicit");
                    int columnIndexOrThrow8 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "year");
                    int columnIndexOrThrow9 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "date");
                    int columnIndexOrThrow10 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "dateModified");
                    int columnIndexOrThrow11 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "liked");
                    int columnIndexOrThrow12 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "likedDate");
                    int columnIndexOrThrow13 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "totalPlayTime");
                    int columnIndexOrThrow14 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "inLibrary");
                    int columnIndexOrThrow15 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "dateDownload");
                    int columnIndexOrThrow16 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isLocal");
                    int columnIndexOrThrow17 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "libraryAddToken");
                    int columnIndexOrThrow18 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "libraryRemoveToken");
                    int columnIndexOrThrow19 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "lyricsOffset");
                    int columnIndexOrThrow20 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "romanizeLyrics");
                    int columnIndexOrThrow21 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isDownloaded");
                    int columnIndexOrThrow22 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isUploaded");
                    int columnIndexOrThrow23 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isVideo");
                    int columnIndexOrThrow24 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isEpisode");
                    int columnIndexOrThrow25 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "playbackPosition");
                    int columnIndexOrThrow26 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "uploadEntityId");
                    int columnIndexOrThrow27 = FileSystemsKt.getColumnIndexOrThrow(sQLiteStatementPrepare, "isCached");
                    int i6 = columnIndexOrThrow12;
                    ArrayMap arrayMap = new ArrayMap(0);
                    int i7 = columnIndexOrThrow11;
                    ArrayMap arrayMap2 = new ArrayMap(0);
                    int i8 = columnIndexOrThrow10;
                    ArrayMap arrayMap3 = new ArrayMap(0);
                    int i9 = columnIndexOrThrow9;
                    ArrayMap arrayMap4 = new ArrayMap(0);
                    while (sQLiteStatementPrepare.step()) {
                        String text = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        if (!arrayMap.containsKey(text)) {
                            arrayMap.put(text, new ArrayList());
                        }
                        String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        if (!arrayMap2.containsKey(text2)) {
                            arrayMap2.put(text2, new ArrayList());
                        }
                        Object obj6 = obj5;
                        arrayMap3.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), obj6);
                        arrayMap4.put(sQLiteStatementPrepare.getText(columnIndexOrThrow), obj6);
                        columnIndexOrThrow8 = columnIndexOrThrow8;
                        obj5 = null;
                    }
                    int i10 = columnIndexOrThrow8;
                    sQLiteStatementPrepare.reset();
                    databaseDao_Impl.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection, arrayMap);
                    databaseDao_Impl.__fetchRelationshipsongArtistMapAscomMetrolistMusicDbEntitiesSongArtistMap(sQLiteConnection, arrayMap2);
                    databaseDao_Impl.__fetchRelationshipalbumAscomMetrolistMusicDbEntitiesAlbumEntity(sQLiteConnection, arrayMap3);
                    databaseDao_Impl.__fetchRelationshipformatAscomMetrolistMusicDbEntitiesFormatEntity(sQLiteConnection, arrayMap4);
                    ArrayList arrayList = new ArrayList();
                    while (sQLiteStatementPrepare.step()) {
                        String text3 = sQLiteStatementPrepare.getText(columnIndexOrThrow);
                        String text4 = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                        int i11 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow3);
                        String text5 = sQLiteStatementPrepare.isNull(columnIndexOrThrow4) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow4);
                        String text6 = sQLiteStatementPrepare.isNull(columnIndexOrThrow5) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow5);
                        String text7 = sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6);
                        boolean z2 = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7)) != 0;
                        int i12 = i10;
                        Integer numValueOf = sQLiteStatementPrepare.isNull(i12) ? null : Integer.valueOf((int) sQLiteStatementPrepare.getLong(i12));
                        int i13 = i9;
                        LocalDateTime localDateTimeFromTimestamp = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i13) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i13)));
                        int i14 = i8;
                        LocalDateTime localDateTimeFromTimestamp2 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i14) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i14)));
                        i9 = i13;
                        int i15 = i7;
                        boolean z3 = ((int) sQLiteStatementPrepare.getLong(i15)) != 0;
                        int i16 = i6;
                        LocalDateTime localDateTimeFromTimestamp3 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i16) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i16)));
                        int i17 = columnIndexOrThrow13;
                        long j = sQLiteStatementPrepare.getLong(i17);
                        int i18 = columnIndexOrThrow14;
                        LocalDateTime localDateTimeFromTimestamp4 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i18) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i18)));
                        columnIndexOrThrow14 = i18;
                        int i19 = columnIndexOrThrow15;
                        LocalDateTime localDateTimeFromTimestamp5 = Converters.fromTimestamp(sQLiteStatementPrepare.isNull(i19) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i19)));
                        columnIndexOrThrow15 = i19;
                        columnIndexOrThrow13 = i17;
                        int i20 = columnIndexOrThrow16;
                        boolean z4 = ((int) sQLiteStatementPrepare.getLong(i20)) != 0;
                        int i21 = columnIndexOrThrow17;
                        String text8 = sQLiteStatementPrepare.isNull(i21) ? null : sQLiteStatementPrepare.getText(i21);
                        int i22 = columnIndexOrThrow18;
                        String text9 = sQLiteStatementPrepare.isNull(i22) ? null : sQLiteStatementPrepare.getText(i22);
                        int i23 = columnIndexOrThrow19;
                        int i24 = (int) sQLiteStatementPrepare.getLong(i23);
                        int i25 = columnIndexOrThrow20;
                        boolean z5 = ((int) sQLiteStatementPrepare.getLong(i25)) != 0;
                        int i26 = columnIndexOrThrow21;
                        boolean z6 = ((int) sQLiteStatementPrepare.getLong(i26)) != 0;
                        int i27 = columnIndexOrThrow22;
                        int i28 = columnIndexOrThrow5;
                        boolean z7 = ((int) sQLiteStatementPrepare.getLong(i27)) != 0;
                        int i29 = columnIndexOrThrow23;
                        boolean z8 = ((int) sQLiteStatementPrepare.getLong(i29)) != 0;
                        int i30 = columnIndexOrThrow24;
                        boolean z9 = ((int) sQLiteStatementPrepare.getLong(i30)) != 0;
                        int i31 = columnIndexOrThrow25;
                        int i32 = columnIndexOrThrow26;
                        int i33 = columnIndexOrThrow27;
                        SongEntity songEntity = new SongEntity(text3, text4, i11, text5, text6, text7, z2, numValueOf, localDateTimeFromTimestamp, localDateTimeFromTimestamp2, z3, localDateTimeFromTimestamp3, j, localDateTimeFromTimestamp4, localDateTimeFromTimestamp5, z4, text8, text9, i24, z5, z6, z7, z8, z9, sQLiteStatementPrepare.isNull(i31) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(i31)), sQLiteStatementPrepare.isNull(i32) ? null : sQLiteStatementPrepare.getText(i32), ((int) sQLiteStatementPrepare.getLong(i33)) != 0);
                        Object value = MapsKt__MapsKt.getValue(arrayMap, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value.getClass();
                        List list2 = (List) value;
                        Object value2 = MapsKt__MapsKt.getValue(arrayMap2, sQLiteStatementPrepare.getText(columnIndexOrThrow));
                        value2.getClass();
                        arrayList.add(new Song(songEntity, list2, (List) value2, (AlbumEntity) arrayMap3.get(sQLiteStatementPrepare.getText(columnIndexOrThrow)), (FormatEntity) arrayMap4.get(sQLiteStatementPrepare.getText(columnIndexOrThrow))));
                        columnIndexOrThrow3 = columnIndexOrThrow3;
                        columnIndexOrThrow4 = columnIndexOrThrow4;
                        i10 = i12;
                        i8 = i14;
                        i7 = i15;
                        i6 = i16;
                        columnIndexOrThrow16 = i20;
                        columnIndexOrThrow17 = i21;
                        columnIndexOrThrow18 = i22;
                        columnIndexOrThrow19 = i23;
                        columnIndexOrThrow20 = i25;
                        columnIndexOrThrow21 = i26;
                        columnIndexOrThrow5 = i28;
                        columnIndexOrThrow22 = i27;
                        columnIndexOrThrow23 = i29;
                        columnIndexOrThrow24 = i30;
                        columnIndexOrThrow25 = i31;
                        columnIndexOrThrow26 = i32;
                        columnIndexOrThrow27 = i33;
                        columnIndexOrThrow2 = columnIndexOrThrow2;
                        break;
                    }
                    return arrayList;
                } finally {
                    sQLiteStatementPrepare.close();
                }
            case 2:
                String str4 = (String) obj4;
                String str5 = (String) obj3;
                String str6 = (String) obj2;
                SQLiteConnection sQLiteConnection2 = (SQLiteConnection) obj;
                sQLiteConnection2.getClass();
                SQLiteStatement sQLiteStatementPrepare2 = sQLiteConnection2.prepare("UPDATE song SET libraryAddToken = ?, libraryRemoveToken = ? WHERE id = ?");
                try {
                    if (str4 == null) {
                        sQLiteStatementPrepare2.bindNull(1);
                    } else {
                        sQLiteStatementPrepare2.bindText(1, str4);
                    }
                    if (str5 == null) {
                        sQLiteStatementPrepare2.bindNull(2);
                    } else {
                        sQLiteStatementPrepare2.bindText(2, str5);
                    }
                    sQLiteStatementPrepare2.bindText(3, str6);
                    sQLiteStatementPrepare2.step();
                    sQLiteStatementPrepare2.close();
                    return unit;
                } catch (Throwable th) {
                    sQLiteStatementPrepare2.close();
                    throw th;
                }
            case 3:
                DatabaseDao_Impl databaseDao_Impl2 = (DatabaseDao_Impl) obj4;
                LocalDateTime localDateTime = (LocalDateTime) obj3;
                LocalDateTime localDateTime2 = (LocalDateTime) obj2;
                SQLiteConnection sQLiteConnection3 = (SQLiteConnection) obj;
                sQLiteConnection3.getClass();
                SQLiteStatement sQLiteStatementPrepare3 = sQLiteConnection3.prepare("\n        SELECT s.id, s.title, s.thumbnailUrl, s.isVideo,\n               (SELECT name FROM artist WHERE id = sam.artistId) as artistName,\n               (SELECT COUNT(1)\n                FROM event\n                WHERE songId = s.id\n                  AND timestamp > ? AND timestamp <= ?) AS songCountListened,\n               (SELECT SUM(event.playTime)\n                FROM event\n                WHERE songId = s.id\n                  AND timestamp > ? AND timestamp <= ?) AS timeListened\n        FROM song s\n        LEFT JOIN song_artist_map sam ON s.id = sam.songId\n        JOIN (SELECT songId\n              FROM event\n              WHERE timestamp > ?\n                AND timestamp <= ?\n              GROUP BY songId\n              ORDER BY SUM(playTime) DESC\n              LIMIT ? OFFSET ?) AS top_songs ON s.id = top_songs.songId\n        GROUP BY s.id\n        ORDER BY timeListened DESC\n        ");
                try {
                    Long lDateToTimestamp = Converters.dateToTimestamp(localDateTime);
                    if (lDateToTimestamp == null) {
                        sQLiteStatementPrepare3.bindNull(1);
                    } else {
                        sQLiteStatementPrepare3.bindLong(1, lDateToTimestamp.longValue());
                    }
                    Long lDateToTimestamp2 = Converters.dateToTimestamp(localDateTime2);
                    if (lDateToTimestamp2 == null) {
                        sQLiteStatementPrepare3.bindNull(2);
                    } else {
                        sQLiteStatementPrepare3.bindLong(2, lDateToTimestamp2.longValue());
                    }
                    Long lDateToTimestamp3 = Converters.dateToTimestamp(localDateTime);
                    if (lDateToTimestamp3 == null) {
                        sQLiteStatementPrepare3.bindNull(3);
                    } else {
                        sQLiteStatementPrepare3.bindLong(3, lDateToTimestamp3.longValue());
                    }
                    Long lDateToTimestamp4 = Converters.dateToTimestamp(localDateTime2);
                    if (lDateToTimestamp4 == null) {
                        sQLiteStatementPrepare3.bindNull(4);
                    } else {
                        sQLiteStatementPrepare3.bindLong(4, lDateToTimestamp4.longValue());
                    }
                    Long lDateToTimestamp5 = Converters.dateToTimestamp(localDateTime);
                    if (lDateToTimestamp5 == null) {
                        sQLiteStatementPrepare3.bindNull(5);
                    } else {
                        sQLiteStatementPrepare3.bindLong(5, lDateToTimestamp5.longValue());
                    }
                    Long lDateToTimestamp6 = Converters.dateToTimestamp(localDateTime2);
                    if (lDateToTimestamp6 == null) {
                        sQLiteStatementPrepare3.bindNull(6);
                    } else {
                        sQLiteStatementPrepare3.bindLong(6, lDateToTimestamp6.longValue());
                    }
                    sQLiteStatementPrepare3.bindLong(7, -1L);
                    sQLiteStatementPrepare3.bindLong(8, 0L);
                    int i34 = 0;
                    ArrayMap arrayMap5 = new ArrayMap(0);
                    while (sQLiteStatementPrepare3.step()) {
                        String text10 = sQLiteStatementPrepare3.getText(i34);
                        if (!arrayMap5.containsKey(text10)) {
                            arrayMap5.put(text10, new ArrayList());
                        }
                        i34 = 0;
                    }
                    sQLiteStatementPrepare3.reset();
                    databaseDao_Impl2.__fetchRelationshipartistAscomMetrolistMusicDbEntitiesArtistEntity(sQLiteConnection3, arrayMap5);
                    ArrayList arrayList2 = new ArrayList();
                    while (sQLiteStatementPrepare3.step()) {
                        String text11 = sQLiteStatementPrepare3.getText(0);
                        String text12 = sQLiteStatementPrepare3.getText(1);
                        String text13 = sQLiteStatementPrepare3.getText(2);
                        boolean z10 = ((int) sQLiteStatementPrepare3.getLong(3)) != 0;
                        String text14 = sQLiteStatementPrepare3.isNull(4) ? null : sQLiteStatementPrepare3.getText(4);
                        int i35 = (int) sQLiteStatementPrepare3.getLong(5);
                        Long lValueOf = sQLiteStatementPrepare3.isNull(6) ? null : Long.valueOf(sQLiteStatementPrepare3.getLong(6));
                        Object value3 = MapsKt__MapsKt.getValue(arrayMap5, sQLiteStatementPrepare3.getText(0));
                        value3.getClass();
                        arrayList2.add(new SongWithStats(text11, text12, (List) value3, text13, text14, i35, lValueOf, z10));
                        break;
                    }
                    return arrayList2;
                } finally {
                    sQLiteStatementPrepare3.close();
                }
            case 4:
                DatabaseDao_Impl databaseDao_Impl3 = (DatabaseDao_Impl) obj4;
                ArtistEntity artistEntity = (ArtistEntity) obj3;
                ArtistPage artistPage = (ArtistPage) obj2;
                ((SQLiteConnection) obj).getClass();
                artistEntity.getClass();
                artistPage.getClass();
                ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                String str7 = artistEntity.id;
                ArtistItem artistItem = artistPage.artist;
                String strResolve = ArtistNameAliases.resolve(str7, artistItem.title);
                String str8 = artistItem.thumbnail;
                String strResize = str8 != null ? YouTubeUtilsKt.resize(str8, 1080, 1080) : null;
                LocalDateTime localDateTimeNow = LocalDateTime.now();
                localDateTimeNow.getClass();
                databaseDao_Impl3.update(ArtistEntity.copy$default(artistEntity, strResolve, strResize, null, localDateTimeNow, null, false, null, 489));
                return unit;
            case 5:
                DatabaseDao_Impl databaseDao_Impl4 = (DatabaseDao_Impl) obj4;
                AlbumEntity albumEntity = (AlbumEntity) obj3;
                AlbumPage albumPage = (AlbumPage) obj2;
                ((SQLiteConnection) obj).getClass();
                albumEntity.getClass();
                albumPage.getClass();
                AlbumItem albumItem = albumPage.album;
                String str9 = albumItem.browseId;
                String str10 = albumItem.playlistId;
                String str11 = albumItem.title;
                Integer num = albumItem.year;
                String str12 = albumItem.thumbnail;
                List list3 = albumPage.songs;
                int size = list3.size();
                Iterator it2 = list3.iterator();
                int iIntValue = 0;
                while (it2.hasNext()) {
                    Integer num2 = ((SongItem) it2.next()).duration;
                    iIntValue += num2 != null ? num2.intValue() : 0;
                }
                if (albumItem.explicit) {
                    z = true;
                } else {
                    if (!list3.isEmpty()) {
                        Iterator it3 = list3.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                if (((SongItem) it3.next()).explicit) {
                                    z = true;
                                }
                            }
                        }
                    }
                    z = false;
                }
                databaseDao_Impl4.update(AlbumEntity.copy$default(albumEntity, str9, str10, str11, num, str12, size, iIntValue, z, null, false, 32288));
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                Iterator it4 = list3.iterator();
                while (it4.hasNext()) {
                    arrayList3.add(HexFormatKt.toMediaMetadata((SongItem) it4.next()));
                }
                int size2 = arrayList3.size();
                int i36 = 0;
                while (i36 < size2) {
                    Object obj7 = arrayList3.get(i36);
                    i36++;
                    databaseDao_Impl4.insert((MediaMetadata) obj7, new DatabaseDao$$ExternalSyntheticLambda0(r8));
                }
                int size3 = arrayList3.size();
                int i37 = 0;
                while (i37 < size3) {
                    Object obj8 = arrayList3.get(i37);
                    i37++;
                    MediaMetadata mediaMetadata = (MediaMetadata) obj8;
                    Song songByIdBlocking = databaseDao_Impl4.getSongByIdBlocking(mediaMetadata.id);
                    if (songByIdBlocking != null) {
                        databaseDao_Impl4.update(songByIdBlocking, mediaMetadata, false, false);
                    }
                }
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
                int size4 = arrayList3.size();
                int i38 = 0;
                int i39 = 0;
                while (i39 < size4) {
                    Object obj9 = arrayList3.get(i39);
                    i39++;
                    int i40 = i38 + 1;
                    if (i38 < 0) {
                        ?? r17 = continuation;
                        CollectionsKt__IterablesKt.throwIndexOverflow();
                        throw r17;
                    }
                    arrayList4.add(new SongAlbumMap(((MediaMetadata) obj9).id, str9, i38));
                    i38 = i40;
                    continuation = continuation;
                }
                ?? r18 = continuation;
                int size5 = arrayList4.size();
                int i41 = 0;
                while (i41 < size5) {
                    Object obj10 = arrayList4.get(i41);
                    i41++;
                    databaseDao_Impl4.upsert((SongAlbumMap) obj10);
                }
                List<Artist> list4 = albumItem.artists;
                if (list4 != null) {
                    String str13 = albumEntity.id;
                    str13.getClass();
                    for (AlbumArtistMap albumArtistMap : (List) DatabaseDao_Impl.AnonymousClass17.performBlocking(databaseDao_Impl4.__db, true, true, new IconKt$$ExternalSyntheticLambda1(str13, (byte) 23))) {
                        albumArtistMap.getClass();
                        DatabaseDao_Impl.AnonymousClass17.performBlocking(databaseDao_Impl4.__db, false, true, new DatabaseDao_Impl$$ExternalSyntheticLambda120(databaseDao_Impl4, albumArtistMap, b3));
                    }
                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                    for (Artist artist : list4) {
                        ?? GenerateLocalId = artist.id;
                        String str14 = artist.name;
                        if (GenerateLocalId == 0) {
                            ArtistEntity artistEntityArtistByName = databaseDao_Impl4.artistByName(str14);
                            if (artistEntityArtistByName != null) {
                                str = artistEntityArtistByName.id;
                            } else {
                                GenerateLocalId = r18;
                            }
                            if (GenerateLocalId == 0) {
                                GenerateLocalId = str;
                                GenerateLocalId = CollectionsKt__IterablesKt.generateLocalId("LA");
                            } else {
                                GenerateLocalId = str;
                            }
                        }
                        ?? r19 = GenerateLocalId;
                        ArtistNameAliases artistNameAliases2 = ArtistNameAliases.INSTANCE;
                        arrayList5.add(new ArtistEntity(r19, ArtistNameAliases.resolve(artist.id, str14), null, null, null, false, null, 508));
                    }
                    int size6 = arrayList5.size();
                    int i42 = 0;
                    while (i42 < size6) {
                        Object obj11 = arrayList5.get(i42);
                        i42++;
                        databaseDao_Impl4.insert((ArtistEntity) obj11);
                    }
                    ?? arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10));
                    int size7 = arrayList5.size();
                    int i43 = 0;
                    int i44 = 0;
                    while (i44 < size7) {
                        Object obj12 = arrayList5.get(i44);
                        i44++;
                        int i45 = i43 + 1;
                        if (i43 < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw r18;
                        }
                        arrayList6.add(new AlbumArtistMap(str9, ((ArtistEntity) obj12).id, i43));
                        i43 = i45;
                    }
                    int size8 = arrayList6.size();
                    while (r8 < size8) {
                        databaseDao_Impl4.insert((AlbumArtistMap) arrayList6.get(r8));
                        r8++;
                    }
                }
                return unit;
            case 6:
                String str15 = (String) obj3;
                List list5 = (List) obj2;
                SQLiteConnection sQLiteConnection4 = (SQLiteConnection) obj;
                sQLiteConnection4.getClass();
                SQLiteStatement sQLiteStatementPrepare4 = sQLiteConnection4.prepare((String) obj4);
                try {
                    sQLiteStatementPrepare4.bindText(1, str15);
                    Iterator it5 = list5.iterator();
                    while (it5.hasNext()) {
                        sQLiteStatementPrepare4.bindText(i, (String) it5.next());
                        i++;
                    }
                    ArrayList arrayList7 = new ArrayList();
                    while (sQLiteStatementPrepare4.step()) {
                        arrayList7.add(sQLiteStatementPrepare4.getText(0));
                        break;
                    }
                    return arrayList7;
                } finally {
                    sQLiteStatementPrepare4.close();
                }
            case 7:
                DatabaseDao_Impl databaseDao_Impl5 = (DatabaseDao_Impl) obj4;
                MediaMetadata mediaMetadata2 = (MediaMetadata) obj3;
                Function1 function1 = (Function1) obj2;
                ((SQLiteConnection) obj).getClass();
                mediaMetadata2.getClass();
                String str16 = mediaMetadata2.id;
                function1.getClass();
                if (databaseDao_Impl5.insert((SongEntity) function1.invoke(mediaMetadata2.toSongEntity())) != -1 || databaseDao_Impl5.songArtistMap(str16).isEmpty()) {
                    for (Object obj13 : mediaMetadata2.artists) {
                        int i46 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw null;
                        }
                        MediaMetadata.Artist artist2 = (MediaMetadata.Artist) obj13;
                        String strGenerateLocalId = artist2.id;
                        if (strGenerateLocalId == null) {
                            ArtistEntity artistEntityArtistByName2 = databaseDao_Impl5.artistByName(artist2.name);
                            strGenerateLocalId = artistEntityArtistByName2 != null ? artistEntityArtistByName2.id : null;
                            if (strGenerateLocalId == null) {
                                strGenerateLocalId = CollectionsKt__IterablesKt.generateLocalId("LA");
                            }
                        }
                        String str17 = strGenerateLocalId;
                        databaseDao_Impl5.insert(new ArtistEntity(str17, artist2.name, null, artist2.id, null, false, null, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION));
                        databaseDao_Impl5.insert(new SongArtistMap(str16, str17, i3));
                        i3 = i46;
                    }
                }
                return unit;
            case 8:
                DatabaseDao_Impl databaseDao_Impl6 = (DatabaseDao_Impl) obj4;
                String str18 = (String) obj3;
                ArrayList arrayList8 = (ArrayList) obj2;
                ((SQLiteConnection) obj).getClass();
                str18.getClass();
                Iterator it6 = databaseDao_Impl6.songArtistMap(str18).iterator();
                while (it6.hasNext()) {
                    databaseDao_Impl6.delete((SongArtistMap) it6.next());
                }
                HashSet hashSet = new HashSet();
                ArrayList arrayList9 = new ArrayList();
                int size9 = arrayList8.size();
                int i47 = 0;
                while (i47 < size9) {
                    Object obj14 = arrayList8.get(i47);
                    i47++;
                    if (hashSet.add(((ArtistEntity) obj14).id)) {
                        arrayList9.add(obj14);
                    }
                }
                int size10 = arrayList9.size();
                int i48 = 0;
                while (i48 < size10) {
                    Object obj15 = arrayList9.get(i48);
                    i48++;
                    int i49 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__IterablesKt.throwIndexOverflow();
                        throw null;
                    }
                    ArtistEntity artistEntity2 = (ArtistEntity) obj15;
                    databaseDao_Impl6.insert(artistEntity2);
                    databaseDao_Impl6.insert(new SongArtistMap(str18, artistEntity2.id, i2));
                    i2 = i49;
                }
                return unit;
            case 9:
                AwaitKt.launch$default((CoroutineScope) obj4, null, null, new Transition$animateTo$1$1$1((Animatable) obj3, (Density) obj2, ((Float) obj).floatValue(), (Continuation) null), 3);
                return unit;
            case 10:
                return invoke$com$metrolist$music$ui$component$GlassComponentsKt$$ExternalSyntheticLambda5(obj);
            case 11:
                Function0 function0 = (Function0) obj3;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, -2109889665, new CustomThumbnailMenuKt$$ExternalSyntheticLambda2((Function0) obj4, function0, r8)), 3);
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 1767999784, new CustomThumbnailMenuKt$$ExternalSyntheticLambda2((Function0) obj2, function0, b3)), 3);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                String str19 = (String) obj;
                str19.getClass();
                ((MusicDatabase) obj2).query(new MainActivity$$ExternalSyntheticLambda21(obj4, (Object) str19, obj3, (byte) 13));
                return unit;
            case 13:
                String str20 = (String) obj3;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                musicDatabase2.getClass();
                String str21 = ((MediaMetadata) ((Function0) obj4).invoke()).id;
                LyricsEntity lyricsEntity = (LyricsEntity) ((Function0) obj2).invoke();
                if (lyricsEntity == null || (str2 = lyricsEntity.provider) == null) {
                    str2 = "Manual";
                }
                musicDatabase2.$$delegate_0.upsert(new LyricsEntity(str21, str20, str2));
                return unit;
            case 14:
                MusicDatabase musicDatabase3 = (MusicDatabase) obj2;
                Boolean bool = (Boolean) obj;
                boolean zBooleanValue = bool.booleanValue();
                ((MutableState) obj3).setValue(bool);
                SongEntity songEntity2 = (SongEntity) ((Function0) obj4).invoke();
                if (songEntity2 != null) {
                    musicDatabase3.query(new MusicService$$ExternalSyntheticLambda7(songEntity2, zBooleanValue, (byte) 1));
                }
                return unit;
            case 15:
                return invoke$com$metrolist$music$ui$menu$PlayerMenuKt$$ExternalSyntheticLambda29(obj);
            case 16:
                return invoke$com$metrolist$music$ui$menu$YouTubePlaylistMenuKt$$ExternalSyntheticLambda3(obj);
            case 17:
                return invoke$com$metrolist$music$ui$menu$YouTubeSelectionSongMenuKt$$ExternalSyntheticLambda27(obj);
            case 18:
                return invoke$com$metrolist$music$ui$menu$YouTubeSongMenuKt$$ExternalSyntheticLambda44(obj);
            case 19:
                return invoke$com$metrolist$music$ui$screens$HomeScreenKt$$ExternalSyntheticLambda88(obj);
            case 20:
                return invoke$com$metrolist$music$ui$screens$equalizer$EqScreenKt$$ExternalSyntheticLambda0(obj);
            case 21:
                return invoke$com$metrolist$music$ui$screens$equalizer$EqScreenKt$$ExternalSyntheticLambda21(obj);
            case 22:
                return invoke$com$metrolist$music$ui$screens$library$LibraryPodcastsScreenKt$$ExternalSyntheticLambda5(obj);
            case 23:
                PlaylistEntity playlistEntity = (PlaylistEntity) obj3;
                String str22 = (String) obj;
                str22.getClass();
                ((MusicDatabase) obj2).query(new SongMenuKt$$ExternalSyntheticLambda4((Object) playlistEntity, (Object) str22, (byte) 19));
                CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope((LocalPlaylistViewModel) obj4);
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new DataStoreKt$get$1((Object) playlistEntity, (Object) str22, continuation, (byte) 14), 2);
                return unit;
            case 24:
                return invoke$com$metrolist$music$ui$screens$recognition$RecognitionHistoryScreenKt$$ExternalSyntheticLambda8(obj);
            case 25:
                return invoke$com$metrolist$music$ui$screens$recognition$RecognitionScreenKt$$ExternalSyntheticLambda1(obj);
            case 26:
                return invoke$com$metrolist$music$ui$screens$settings$AlarmSettingsKt$$ExternalSyntheticLambda38(obj);
            case 27:
                return invoke$com$metrolist$music$ui$screens$settings$AppearanceSettingsKt$$ExternalSyntheticLambda140(obj);
            case 28:
                return invoke$com$metrolist$music$ui$screens$settings$ContentSettingsKt$$ExternalSyntheticLambda96(obj);
            default:
                ((KeyboardActionRunner) obj).getClass();
                ((Function1) obj4).invoke((String) ((MutableState) obj2).getValue());
                ((Function0) obj3).invoke();
                return unit;
        }
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda21(ComposableLambdaImpl composableLambdaImpl, MutableState mutableState, NavHostController navHostController) {
        this.$r8$classId = (byte) 22;
        this.f$1 = composableLambdaImpl;
        this.f$2 = mutableState;
        this.f$0 = navHostController;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda21(DatabaseDao_Impl databaseDao_Impl, AlbumEntity albumEntity, AlbumPage albumPage, List list) {
        this.$r8$classId = (byte) 5;
        this.f$0 = databaseDao_Impl;
        this.f$1 = albumEntity;
        this.f$2 = albumPage;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda21(MusicDatabase musicDatabase, Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$2 = musicDatabase;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda21(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }
}
