package com.metrolist.music;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.animation.MutationPhase;
import androidx.compose.animation.SharedMutableTransformState;
import androidx.compose.animation.TransformScopeImpl;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogicImpl;
import androidx.compose.foundation.gestures.ScrollValue;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$lambda$18$0$$inlined$onDispose$1;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Latch$await$2$2;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.AndroidUriHandler;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1;
import androidx.core.provider.CallbackWrapper;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.compose.NavHostKt$NavHost$32;
import androidx.navigation.internal.NavControllerImpl;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import coil3.size.SizeKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.Thumbnail;
import com.metrolist.innertube.models.Thumbnails;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.models.response.PlayerResponse$PlaybackTracking;
import com.metrolist.innertube.models.response.PlayerResponse$PlayerConfig$AudioConfig;
import com.metrolist.innertube.models.response.PlayerResponse$StreamingData$Format;
import com.metrolist.innertube.models.response.PlayerResponse$VideoDetails;
import com.metrolist.innertube.pages.SearchSummary;
import com.metrolist.innertube.pages.SearchSummaryPage;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda2;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.FormatEntity;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.ItemsPage;
import com.metrolist.music.playback.CastConnectionHandler;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import com.metrolist.music.ui.menu.PlaylistMenuKt$$ExternalSyntheticLambda21;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3;
import com.metrolist.music.ui.menu.SongMenuKt$SongMenu$lambda$46$0$$inlined$items$default$4;
import com.metrolist.music.ui.menu.YouTubePlaylistMenuKt$YouTubePlaylistMenu$lambda$35$0$$inlined$items$default$4;
import com.metrolist.music.ui.menu.YouTubeSongMenuKt$YouTubeSongMenu$lambda$16$0$$inlined$items$default$4;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda20;
import com.metrolist.music.ui.screens.HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4;
import com.metrolist.music.ui.screens.Screens;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda6;
import com.metrolist.music.ui.screens.StatsScreenKt$StatsScreen$lambda$56$0$0$$inlined$items$3;
import com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt;
import com.metrolist.music.ui.screens.artist.ArtistScreenKt;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt;
import com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.screens.podcast.OnlinePodcastScreenKt;
import com.metrolist.music.ui.screens.recognition.RecognitionHistoryScreenKt;
import com.metrolist.music.ui.screens.recognition.RecognitionScreenKt;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt;
import com.metrolist.music.ui.screens.search.LocalSearchScreenKt$$ExternalSyntheticLambda5;
import com.metrolist.music.ui.screens.search.OnlineSearchResultKt;
import com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$handleSearch$1;
import com.metrolist.music.ui.screens.settings.AboutScreenKt;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3;
import com.metrolist.music.ui.screens.settings.RomanizationSettingsKt;
import com.metrolist.music.ui.screens.settings.ThemeScreenKt;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import com.metrolist.music.ui.screens.settings.integrations.ListenTogetherSettingsKt;
import com.metrolist.music.utils.InnerTubeXPlayer;
import com.metrolist.music.utils.InnerTubeXPlayer$$ExternalSyntheticLambda3;
import com.metrolist.music.utils.UtilsKt;
import com.metrolist.music.viewmodels.BackupRestoreViewModel;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.ClosedFloatRange;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource$Monotonic$ValueTimeMark;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.xmlpull.v1.XmlPullParserException;
import sh.calvin.reorderable.ReorderableLazyListState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda59 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda59(CastConnectionHandler castConnectionHandler, PlayerConnection playerConnection, MutableState mutableState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2) {
        this.$r8$classId = (byte) 18;
        this.f$0 = playerConnection;
        this.f$1 = mutableState;
        this.f$2 = parcelableSnapshotMutableLongState;
        this.f$4 = parcelableSnapshotMutableLongState2;
    }

    private final Object invoke$androidx$compose$foundation$text$CoreTextFieldKt$$ExternalSyntheticLambda8(Object obj) {
        LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) this.f$0;
        TextInputService textInputService = (TextInputService) this.f$1;
        TextFieldValue textFieldValue = (TextFieldValue) this.f$2;
        ImeOptions imeOptions = (ImeOptions) this.f$4;
        if (legacyTextFieldState.getHasFocus()) {
            CallbackWrapper callbackWrapper = legacyTextFieldState.processor;
            CoreTextFieldKt$$ExternalSyntheticLambda1 coreTextFieldKt$$ExternalSyntheticLambda1 = legacyTextFieldState.onValueChange;
            CoreTextFieldKt$$ExternalSyntheticLambda1 coreTextFieldKt$$ExternalSyntheticLambda2 = legacyTextFieldState.onImeActionPerformed;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            UtilsKt$$ExternalSyntheticLambda0 utilsKt$$ExternalSyntheticLambda0 = new UtilsKt$$ExternalSyntheticLambda0((Object) callbackWrapper, (Object) coreTextFieldKt$$ExternalSyntheticLambda1, (Object) ref$ObjectRef, (byte) 9);
            PlatformTextInputService platformTextInputService = textInputService.platformTextInputService;
            platformTextInputService.startInput(textFieldValue, imeOptions, utilsKt$$ExternalSyntheticLambda0, coreTextFieldKt$$ExternalSyntheticLambda2);
            TextInputSession textInputSession = new TextInputSession(textInputService, platformTextInputService);
            textInputService._currentInputSession.set(textInputSession);
            ref$ObjectRef.element = textInputSession;
            legacyTextFieldState.inputSession = textInputSession;
        }
        return new CoreTextFieldKt$CoreTextField$lambda$18$0$$inlined$onDispose$1();
    }

    private final Object invoke$androidx$navigation$internal$NavControllerImpl$$ExternalSyntheticLambda2(Object obj) {
        Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) this.f$0;
        NavControllerImpl navControllerImpl = (NavControllerImpl) this.f$1;
        NavDestination navDestination = (NavDestination) this.f$2;
        Bundle bundle = (Bundle) this.f$4;
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        navBackStackEntry.getClass();
        ref$BooleanRef.element = true;
        navControllerImpl.addEntryToBackStack(navDestination, bundle, navBackStackEntry, EmptyList.INSTANCE);
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$playback$DownloadUtil$$ExternalSyntheticLambda3(Object obj) {
        MusicDatabase musicDatabase;
        DatabaseDao databaseDao;
        String str;
        Thumbnails thumbnails;
        List list;
        Thumbnail thumbnail;
        String str2;
        Integer intOrNull;
        PlayerResponse$PlaybackTracking.VideostatsPlaybackUrl videostatsPlaybackUrl;
        Long l = (Long) this.f$0;
        String str3 = (String) this.f$2;
        PlayerResponse$StreamingData$Format playerResponse$StreamingData$Format = (PlayerResponse$StreamingData$Format) this.f$1;
        InnerTubeXPlayer.PlaybackData playbackData = (InnerTubeXPlayer.PlaybackData) this.f$4;
        PlayerResponse$VideoDetails playerResponse$VideoDetails = playbackData.videoDetails;
        MusicDatabase musicDatabase2 = (MusicDatabase) obj;
        musicDatabase2.getClass();
        DatabaseDao databaseDao2 = musicDatabase2.$$delegate_0;
        if (l != null) {
            int i = playerResponse$StreamingData$Format.itag;
            String str4 = playerResponse$StreamingData$Format.mimeType;
            String strSubstringBefore$default = StringsKt.substringBefore$default(str4, ";");
            String string = StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter(str4, "codecs=", ""), ";")).toString();
            string.getClass();
            String strRemoveSurrounding = StringsKt.removeSurrounding(string, "\"", "\"");
            int i2 = playerResponse$StreamingData$Format.bitrate;
            Integer num = playerResponse$StreamingData$Format.audioSampleRate;
            long jLongValue = l.longValue();
            PlayerResponse$PlayerConfig$AudioConfig playerResponse$PlayerConfig$AudioConfig = playbackData.audioConfig;
            Double d = playerResponse$PlayerConfig$AudioConfig != null ? playerResponse$PlayerConfig$AudioConfig.loudnessDb : null;
            Double d2 = playerResponse$PlayerConfig$AudioConfig != null ? playerResponse$PlayerConfig$AudioConfig.perceptualLoudnessDb : null;
            PlayerResponse$PlaybackTracking playerResponse$PlaybackTracking = playbackData.playbackTracking;
            String str5 = (playerResponse$PlaybackTracking == null || (videostatsPlaybackUrl = playerResponse$PlaybackTracking.videostatsPlaybackUrl) == null) ? null : videostatsPlaybackUrl.baseUrl;
            musicDatabase = musicDatabase2;
            Double d3 = d;
            Double d4 = d2;
            databaseDao = databaseDao2;
            databaseDao.upsert(new FormatEntity(str3, i, strSubstringBefore$default, strRemoveSurrounding, i2, num, jLongValue, d3, d4, str5));
        } else {
            musicDatabase = musicDatabase2;
            databaseDao = databaseDao2;
            musicDatabase.deleteFormat(str3);
        }
        Song songByIdBlocking = musicDatabase.getSongByIdBlocking(str3);
        SongEntity songEntity = songByIdBlocking != null ? songByIdBlocking.song : null;
        if (songEntity == null) {
            if (playerResponse$VideoDetails == null || (str = playerResponse$VideoDetails.title) == null) {
                str = "Unknown";
            }
            songEntity = new SongEntity(str3, str, (playerResponse$VideoDetails == null || (str2 = playerResponse$VideoDetails.lengthSeconds) == null || (intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, str2)) == null) ? 0 : intOrNull.intValue(), (playerResponse$VideoDetails == null || (thumbnails = playerResponse$VideoDetails.thumbnail) == null || (list = thumbnails.thumbnails) == null || (thumbnail = (Thumbnail) CollectionsKt.lastOrNull(list)) == null) ? null : thumbnail.url, null, null, false, false, null, null, false, false, null, 133152752);
        }
        databaseDao.upsert(songEntity);
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$component$ExpandableTextKt$$ExternalSyntheticLambda3(Object obj) {
        AnnotatedString annotatedString = (AnnotatedString) this.f$0;
        UriHandler uriHandler = (UriHandler) this.f$1;
        MutableState mutableState = (MutableState) this.f$2;
        MutableState mutableState2 = (MutableState) this.f$4;
        int iIntValue = ((Integer) obj).intValue();
        AnnotatedString.Range range = (AnnotatedString.Range) CollectionsKt.firstOrNull(annotatedString.getStringAnnotations(iIntValue, iIntValue, "URL"));
        Unit unit = Unit.INSTANCE;
        if (range != null) {
            ((AndroidUriHandler) uriHandler).openUri((String) range.item);
            return unit;
        }
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            mutableState2.setValue(Boolean.valueOf(!((Boolean) mutableState2.getValue()).booleanValue()));
        }
        return unit;
    }

    private final Object invoke$com$metrolist$music$ui$component$WavySliderKt$WavySlider$interactiveModifier$1$1$$ExternalSyntheticLambda0(Object obj) {
        PointerInputScope pointerInputScope = (PointerInputScope) this.f$0;
        ClosedFloatRange closedFloatRange = (ClosedFloatRange) this.f$1;
        Function1 function1 = (Function1) this.f$2;
        Function0 function0 = (Function0) this.f$4;
        float fCoerceIn = UuidKt.coerceIn(Float.intBitsToFloat((int) (((Offset) obj).packedValue >> 32)) / ((int) (((SuspendingPointerInputModifierNodeImpl) pointerInputScope).boundsSize >> 32)), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        float f = closedFloatRange._start;
        function1.invoke(Float.valueOf(((closedFloatRange._endInclusive - f) * fCoerceIn) + f));
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$menu$AlbumMenuKt$$ExternalSyntheticLambda10(Object obj) {
        Album album = (Album) this.f$1;
        NavHostController navHostController = (NavHostController) this.f$0;
        MutableState mutableState = (MutableState) this.f$2;
        Function0 function0 = (Function0) this.f$4;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        lazyListIntervalContent.getClass();
        List list = album.artists;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (hashSet.add(((ArtistEntity) obj2).id)) {
                arrayList.add(obj2);
            }
        }
        lazyListIntervalContent.items(arrayList.size(), new Latch$await$2$2(new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 0), arrayList, (byte) 11), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 1), new ComposableLambdaImpl(true, 802480018, new SongMenuKt$SongMenu$lambda$46$0$$inlined$items$default$4(arrayList, navHostController, mutableState, function0, (byte) 1)));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$menu$AlbumMenuKt$$ExternalSyntheticLambda41(Object obj) {
        Context context = (Context) this.f$0;
        AlbumEntity albumEntity = ((Album) this.f$1).album;
        MutableState mutableState = (MutableState) this.f$2;
        MutableState mutableState2 = (MutableState) this.f$4;
        String str = (String) obj;
        str.getClass();
        List<Song> list = (List) mutableState.getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Song song : list) {
            arrayList.add(new PlaylistSong(new PlaylistSongMap(albumEntity.id, song.song.id, 0, (String) null, 17), song));
        }
        Serializable serializableM1526exportPlaylistAsCSV0E7RQCE = str.equals("csv") ? UtilsKt.m1526exportPlaylistAsCSV0E7RQCE(context, albumEntity.title, arrayList) : str.equals("m3u") ? UtilsKt.m1527exportPlaylistAsM3U0E7RQCE(context, albumEntity.title, arrayList) : new Result.Failure(new IllegalArgumentException("Unknown format"));
        if (!(serializableM1526exportPlaylistAsCSV0E7RQCE instanceof Result.Failure)) {
            Object objSaveToPublicDocuments$default = UtilsKt.saveToPublicDocuments$default(context, (File) serializableM1526exportPlaylistAsCSV0E7RQCE, str.equals("csv") ? "text/csv" : "audio/x-mpegurl");
            if (!(objSaveToPublicDocuments$default instanceof Result.Failure)) {
                Toast.makeText(context, R.string.export_success, 0).show();
            }
            if (Result.m1866exceptionOrNullimpl(objSaveToPublicDocuments$default) != null) {
                Toast.makeText(context, R.string.export_failed, 0).show();
            }
        }
        if (Result.m1866exceptionOrNullimpl(serializableM1526exportPlaylistAsCSV0E7RQCE) != null) {
            Toast.makeText(context, R.string.export_failed, 0).show();
        }
        mutableState2.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$menu$PlaylistMenuKt$$ExternalSyntheticLambda4(Object obj) {
        Context context = (Context) this.f$0;
        Playlist playlist = (Playlist) this.f$1;
        MutableState mutableState = (MutableState) this.f$2;
        MutableState mutableState2 = (MutableState) this.f$4;
        String str = (String) obj;
        str.getClass();
        List<Song> list = (List) mutableState.getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Song song : list) {
            arrayList.add(new PlaylistSong(new PlaylistSongMap(playlist.playlist.id, song.song.id, 0, (String) null, 17), song));
        }
        Serializable serializableM1526exportPlaylistAsCSV0E7RQCE = str.equals("csv") ? UtilsKt.m1526exportPlaylistAsCSV0E7RQCE(context, playlist.playlist.name, arrayList) : str.equals("m3u") ? UtilsKt.m1527exportPlaylistAsM3U0E7RQCE(context, playlist.playlist.name, arrayList) : new Result.Failure(new IllegalArgumentException("Unknown format"));
        if (!(serializableM1526exportPlaylistAsCSV0E7RQCE instanceof Result.Failure)) {
            Object objSaveToPublicDocuments$default = UtilsKt.saveToPublicDocuments$default(context, (File) serializableM1526exportPlaylistAsCSV0E7RQCE, str.equals("csv") ? "text/csv" : "audio/x-mpegurl");
            if (!(objSaveToPublicDocuments$default instanceof Result.Failure)) {
                Toast.makeText(context, R.string.export_success, 0).show();
            }
            if (Result.m1866exceptionOrNullimpl(objSaveToPublicDocuments$default) != null) {
                Toast.makeText(context, R.string.export_failed, 0).show();
            }
        }
        if (Result.m1866exceptionOrNullimpl(serializableM1526exportPlaylistAsCSV0E7RQCE) != null) {
            Toast.makeText(context, R.string.export_failed, 0).show();
        }
        mutableState2.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$menu$PlaylistMenuKt$$ExternalSyntheticLambda6(Object obj) {
        Function0 function0 = (Function0) this.f$0;
        MusicDatabase musicDatabase = (MusicDatabase) this.f$1;
        CoroutineScope coroutineScope = (CoroutineScope) this.f$2;
        Playlist playlist = (Playlist) this.f$4;
        String str = (String) obj;
        str.getClass();
        function0.invoke();
        musicDatabase.query(new PlaylistMenuKt$$ExternalSyntheticLambda21(playlist, str, (byte) 0));
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new App.C01391(playlist, str, null, (byte) 29), 2);
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$menu$SongMenuKt$$ExternalSyntheticLambda10(Object obj) {
        Song song = (Song) this.f$1;
        NavHostController navHostController = (NavHostController) this.f$0;
        MutableState mutableState = (MutableState) this.f$2;
        Function0 function0 = (Function0) this.f$4;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        lazyListIntervalContent.getClass();
        List orderedArtists = song.getOrderedArtists();
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : orderedArtists) {
            if (hashSet.add(((ArtistEntity) obj2).id)) {
                arrayList.add(obj2);
            }
        }
        lazyListIntervalContent.items(arrayList.size(), new Latch$await$2$2(new SongMenuKt$$ExternalSyntheticLambda16((byte) 9), arrayList, (byte) 13), new AndroidPopup_androidKt$SimpleStack$1$1.AnonymousClass3(arrayList, (byte) 2), new ComposableLambdaImpl(true, 802480018, new SongMenuKt$SongMenu$lambda$46$0$$inlined$items$default$4(arrayList, navHostController, mutableState, function0, (byte) 0)));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$menu$YouTubeSongMenuKt$$ExternalSyntheticLambda9(Object obj) {
        List list = (List) this.f$1;
        NavHostController navHostController = (NavHostController) this.f$0;
        MutableState mutableState = (MutableState) this.f$2;
        Function0 function0 = (Function0) this.f$4;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        lazyListIntervalContent.getClass();
        lazyListIntervalContent.items(list.size(), null, new SongMenuKt$SongMenu$lambda$33$0$$inlined$items$default$3(list, (byte) 14), new ComposableLambdaImpl(true, 802480018, new YouTubeSongMenuKt$YouTubeSongMenu$lambda$16$0$$inlined$items$default$4(list, navHostController, mutableState, function0, (byte) 0)));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$player$PlayerKt$$ExternalSyntheticLambda30(Object obj) {
        PlayerConnection playerConnection = (PlayerConnection) this.f$0;
        MutableState mutableState = (MutableState) this.f$1;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) this.f$2;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2 = (ParcelableSnapshotMutableLongState) this.f$4;
        long jLongValue = ((Long) obj).longValue();
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            parcelableSnapshotMutableLongState.setLongValue(System.currentTimeMillis());
        } else {
            playerConnection.getPlayerSafe().seekToCurrentItem(jLongValue);
        }
        parcelableSnapshotMutableLongState2.setLongValue(jLongValue);
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$equalizer$wizard$WizardScreenKt$$ExternalSyntheticLambda15(Object obj) {
        List list = (List) this.f$0;
        String str = (String) this.f$2;
        Set set = (Set) this.f$1;
        Function1 function1 = (Function1) this.f$4;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        lazyListIntervalContent.getClass();
        LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, new ComposableLambdaImpl(true, 2034825812, new MainActivity$$ExternalSyntheticLambda7(str, (byte) 10)), 3);
        lazyListIntervalContent.items(list.size(), null, new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list, (byte) 1), new ComposableLambdaImpl(true, 802480018, new StatsScreenKt$StatsScreen$lambda$56$0$0$$inlined$items$3(list, set, function1, (byte) 1)));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$search$OnlineSearchResultKt$$ExternalSyntheticLambda24(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.f$0;
        MutableState mutableState = (MutableState) this.f$1;
        MusicDatabase musicDatabase = (MusicDatabase) this.f$4;
        String str = (String) this.f$2;
        NavOptionsBuilder navOptionsBuilder = (NavOptionsBuilder) obj;
        navOptionsBuilder.getClass();
        Continuation continuation = null;
        if (StringsKt.isBlank("search/{query}")) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Cannot pop up to an empty route");
            return null;
        }
        navOptionsBuilder.popUpToRoute = "search/{query}";
        navOptionsBuilder.popUpToId = -1;
        byte b = 1;
        navOptionsBuilder.inclusive = true;
        navOptionsBuilder.saveState = false;
        boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
        Unit unit = Unit.INSTANCE;
        if (!zBooleanValue) {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AwaitKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, null, new SearchScreenKt$SearchScreen$handleSearch$1(musicDatabase, str, continuation, b), 2);
        }
        return unit;
    }

    private final Object invoke$com$metrolist$music$ui$screens$search$OnlineSearchResultKt$$ExternalSyntheticLambda3(Object obj) {
        SearchSummaryPage searchSummaryPage = (SearchSummaryPage) this.f$0;
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$1;
        MutableState mutableState = (MutableState) this.f$2;
        State state = (State) this.f$4;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        lazyListIntervalContent.getClass();
        byte b = 12;
        byte b2 = 3;
        if (OnlineSearchResultKt.OnlineSearchResult$lambda$24(mutableState) == null) {
            if (searchSummaryPage != null) {
                for (SearchSummary searchSummary : searchSummaryPage.summaries) {
                    lazyListIntervalContent.item(Fragment$5$$ExternalSyntheticOutline0.m("header_", searchSummary.title), "search_section", new ComposableLambdaImpl(true, 1712566185, new ListItemKt$$ExternalSyntheticLambda17((byte) 19, (Object) searchSummary)));
                    List list = searchSummary.items;
                    lazyListIntervalContent.items(list.size(), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new MainActivity$$ExternalSyntheticLambda0((byte) 18, searchSummary), list, (byte) 13), new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list, (byte) 12), new ComposableLambdaImpl(true, 2039820996, new YouTubePlaylistMenuKt$YouTubePlaylistMenu$lambda$35$0$$inlined$items$default$4(list, composableLambdaImpl, b2)));
                }
            }
            if (searchSummaryPage != null && searchSummaryPage.summaries.isEmpty()) {
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, LocalSearchScreenKt.lambda$1091391228, 3);
            }
        } else {
            ItemsPage itemsPage = (ItemsPage) state.getValue();
            List list2 = itemsPage != null ? itemsPage.items : null;
            if (list2 == null) {
                list2 = EmptyList.INSTANCE;
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list2) {
                if (hashSet.add(((YTItem) obj2).getId())) {
                    arrayList.add(obj2);
                }
            }
            lazyListIntervalContent.items(arrayList.size(), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 25), arrayList, (byte) 11), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new LocalSearchScreenKt$$ExternalSyntheticLambda5((byte) 26), arrayList, b), new ComposableLambdaImpl(true, 802480018, new HomeScreenKt$HomeScreen$lambda$52$0$2$0$3$0$0$$inlined$items$default$4(composableLambdaImpl, arrayList)));
            ItemsPage itemsPage2 = (ItemsPage) state.getValue();
            if ((itemsPage2 != null ? itemsPage2.continuation : null) != null) {
                LazyListIntervalContent.item$default(lazyListIntervalContent, "loading", null, LocalSearchScreenKt.f428lambda$1398411515, 2);
            }
            ItemsPage itemsPage3 = (ItemsPage) state.getValue();
            if (itemsPage3 != null && itemsPage3.items.isEmpty()) {
                LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, LocalSearchScreenKt.lambda$65700988, 3);
            }
        }
        if ((OnlineSearchResultKt.OnlineSearchResult$lambda$24(mutableState) == null && searchSummaryPage == null) || (OnlineSearchResultKt.OnlineSearchResult$lambda$24(mutableState) != null && ((ItemsPage) state.getValue()) == null)) {
            LazyListIntervalContent.item$default(lazyListIntervalContent, null, null, LocalSearchScreenKt.f437lambda$84140072, 3);
        }
        LazyListIntervalContent.item$default(lazyListIntervalContent, "bottom_spacer", null, LocalSearchScreenKt.f429lambda$1590738426, 2);
        return Unit.INSTANCE;
    }

    private final Object invoke$com$metrolist$music$ui$screens$settings$AndroidAutoSettingsKt$$ExternalSyntheticLambda3(Object obj) {
        MutableState mutableState = (MutableState) this.f$0;
        ReorderableLazyListState reorderableLazyListState = (ReorderableLazyListState) this.f$1;
        MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) this.f$2;
        HapticFeedback hapticFeedback = (HapticFeedback) this.f$4;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        lazyListIntervalContent.getClass();
        List list = (List) mutableState.getValue();
        lazyListIntervalContent.items(list.size(), new ScrimBlurEffect$drawEffect$$inlined$withAlpha$1$1(new InnerTubeXPlayer$$ExternalSyntheticLambda3((byte) 6), list, (byte) 21), new AlarmSettingsKt$AlarmEditorDialog$lambda$27$0$0$$inlined$items$default$3(list, (byte) 13), new ComposableLambdaImpl(true, 802480018, new NavHostKt$NavHost$32(list, (Object) reorderableLazyListState, mutableState, (Object) mimesKt$$ExternalSyntheticLambda0, (Object) hapticFeedback, (byte) 7)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:200:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:99:0x0291  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$4;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        boolean z2 = false;
        z2 = false;
        z2 = false;
        z2 = false;
        int i = 1;
        switch (b) {
            case 0:
                final NavHostController navHostController = (NavHostController) obj5;
                final NavDeepLinkRequest navDeepLinkRequest = (NavDeepLinkRequest) obj4;
                final String str = (String) obj3;
                final SnackbarHostState snackbarHostState = (SnackbarHostState) obj2;
                NavGraphBuilder navGraphBuilder = (NavGraphBuilder) obj;
                int i2 = MainActivity.$r8$clinit;
                navGraphBuilder.getClass();
                navHostController.getClass();
                str.getClass();
                snackbarHostState.getClass();
                Screens.Home home = Screens.Home.INSTANCE;
                SizeKt.composable$default(navGraphBuilder, "home", null, null, null, null, null, new ComposableLambdaImpl(true, -1188662255, new HistoryScreenKt$$ExternalSyntheticLambda20((byte) 6, snackbarHostState)), 254);
                Screens.Search search = Screens.Search.INSTANCE;
                SizeKt.composable$default(navGraphBuilder, "search_input", null, null, null, null, null, AlbumScreenKt.f314lambda$1906800632, 254);
                Screens.Library library = Screens.Library.INSTANCE;
                SizeKt.composable$default(navGraphBuilder, "library", null, null, null, null, null, AlbumScreenKt.lambda$1119496585, 254);
                Screens.ListenTogether listenTogether = Screens.ListenTogether.INSTANCE;
                final byte b2 = 1;
                SizeKt.composable$default(navGraphBuilder, "listen_together", null, null, null, null, null, new ComposableLambdaImpl(true, -149173494, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b3 = b2;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b3) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b3 = 5;
                SizeKt.composable$default(navGraphBuilder, "listen_together_from_topbar", null, null, null, null, null, new ComposableLambdaImpl(true, -1417843573, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b4 = b3;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b4) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b4 = 10;
                SizeKt.composable$default(navGraphBuilder, "history", null, null, null, null, null, new ComposableLambdaImpl(true, 1608453644, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b5 = b4;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b5) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b5 = 17;
                SizeKt.composable$default(navGraphBuilder, "stats", null, null, null, null, null, new ComposableLambdaImpl(true, 339783565, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b6 = b5;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b6) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b6 = 28;
                SizeKt.composable$default(navGraphBuilder, "mood_and_genres", null, null, null, null, null, new ComposableLambdaImpl(true, -928886514, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b7 = b6;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b7) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b7 = 6;
                SizeKt.composable$default(navGraphBuilder, "account", null, null, null, null, null, new ComposableLambdaImpl(true, 2097410703, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b8 = b7;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b8) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AlbumScreen(navHostController2, null, composer, 0);
                                break;
                            case 1:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, true, composer, 48, 0);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                GapComposer gapComposer = (GapComposer) composer;
                                boolean zChangedInstance = gapComposer.changedInstance(navHostController2);
                                Object objRememberedValue = gapComposer.rememberedValue();
                                if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = new MainActivity$$ExternalSyntheticLambda2(navHostController2, (byte) 21);
                                    gapComposer.updateRememberedValue(objRememberedValue);
                                }
                                WizardScreenKt.WizardScreen(null, (Function0) objRememberedValue, gapComposer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                RecognitionScreenKt.RecognitionScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getBoolean("autoStart") : false, composer, 0);
                                break;
                            case 4:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RecognitionHistoryScreenKt.RecognitionHistoryScreen(navHostController2, composer, 0);
                                break;
                            case 5:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AndroidAutoSettings(navHostController2, composer, 0);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AccountScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.NewReleaseScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.ChartsScreen(navHostController2, null, composer, 0);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b8 = 7;
                SizeKt.composable$default(navGraphBuilder, "new_release", null, null, null, null, null, new ComposableLambdaImpl(true, 828740624, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b9 = b8;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b9) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AlbumScreen(navHostController2, null, composer, 0);
                                break;
                            case 1:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, true, composer, 48, 0);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                GapComposer gapComposer = (GapComposer) composer;
                                boolean zChangedInstance = gapComposer.changedInstance(navHostController2);
                                Object objRememberedValue = gapComposer.rememberedValue();
                                if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = new MainActivity$$ExternalSyntheticLambda2(navHostController2, (byte) 21);
                                    gapComposer.updateRememberedValue(objRememberedValue);
                                }
                                WizardScreenKt.WizardScreen(null, (Function0) objRememberedValue, gapComposer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                RecognitionScreenKt.RecognitionScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getBoolean("autoStart") : false, composer, 0);
                                break;
                            case 4:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RecognitionHistoryScreenKt.RecognitionHistoryScreen(navHostController2, composer, 0);
                                break;
                            case 5:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AndroidAutoSettings(navHostController2, composer, 0);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AccountScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.NewReleaseScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.ChartsScreen(navHostController2, null, composer, 0);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b9 = 8;
                SizeKt.composable$default(navGraphBuilder, "charts_screen", null, null, null, null, null, new ComposableLambdaImpl(true, 936089084, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b10 = b9;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b10) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AlbumScreen(navHostController2, null, composer, 0);
                                break;
                            case 1:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, true, composer, 48, 0);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                GapComposer gapComposer = (GapComposer) composer;
                                boolean zChangedInstance = gapComposer.changedInstance(navHostController2);
                                Object objRememberedValue = gapComposer.rememberedValue();
                                if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = new MainActivity$$ExternalSyntheticLambda2(navHostController2, (byte) 21);
                                    gapComposer.updateRememberedValue(objRememberedValue);
                                }
                                WizardScreenKt.WizardScreen(null, (Function0) objRememberedValue, gapComposer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                RecognitionScreenKt.RecognitionScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getBoolean("autoStart") : false, composer, 0);
                                break;
                            case 4:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RecognitionHistoryScreenKt.RecognitionHistoryScreen(navHostController2, composer, 0);
                                break;
                            case 5:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AndroidAutoSettings(navHostController2, composer, 0);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AccountScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.NewReleaseScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.ChartsScreen(navHostController2, null, composer, 0);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b10 = 0;
                SizeKt.composable$default(navGraphBuilder, "browse/{browseId}", CollectionsKt__IterablesKt.listOf(SizeKt.navArgument("browseId", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 19))), null, null, null, null, new ComposableLambdaImpl(true, -332580995, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b11 = b10;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b11) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                SizeKt.composable$default(navGraphBuilder, "search/{query}", CollectionsKt__IterablesKt.listOf(SizeKt.navArgument("query", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 15))), new StatsScreenKt$$ExternalSyntheticLambda6((byte) 16), new StatsScreenKt$$ExternalSyntheticLambda6((byte) 17), new StatsScreenKt$$ExternalSyntheticLambda6((byte) 20), new StatsScreenKt$$ExternalSyntheticLambda6((byte) 21), AlbumScreenKt.f308lambda$1601251074, 132);
                final byte b11 = 0;
                SizeKt.composable$default(navGraphBuilder, "album/{albumId}", CollectionsKt__IterablesKt.listOf(SizeKt.navArgument("albumId", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 22))), null, null, null, null, new ComposableLambdaImpl(true, 1425046143, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b12 = b11;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b12) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AlbumScreen(navHostController2, null, composer, 0);
                                break;
                            case 1:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, true, composer, 48, 0);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                GapComposer gapComposer = (GapComposer) composer;
                                boolean zChangedInstance = gapComposer.changedInstance(navHostController2);
                                Object objRememberedValue = gapComposer.rememberedValue();
                                if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = new MainActivity$$ExternalSyntheticLambda2(navHostController2, (byte) 21);
                                    gapComposer.updateRememberedValue(objRememberedValue);
                                }
                                WizardScreenKt.WizardScreen(null, (Function0) objRememberedValue, gapComposer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                RecognitionScreenKt.RecognitionScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getBoolean("autoStart") : false, composer, 0);
                                break;
                            case 4:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RecognitionHistoryScreenKt.RecognitionHistoryScreen(navHostController2, composer, 0);
                                break;
                            case 5:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AndroidAutoSettings(navHostController2, composer, 0);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AccountScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.NewReleaseScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.ChartsScreen(navHostController2, null, composer, 0);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b12 = 2;
                SizeKt.composable$default(navGraphBuilder, "artist/{artistId}?isPodcastChannel={isPodcastChannel}", CollectionsKt__IterablesKt.listOf((Object[]) new NamedNavArgument[]{SizeKt.navArgument("artistId", new QueueKt$$ExternalSyntheticLambda4((byte) 29)), SizeKt.navArgument("isPodcastChannel", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 1))}), null, null, null, null, new ComposableLambdaImpl(true, 156376064, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b13 = b12;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b13) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b13 = 3;
                SizeKt.composable$default(navGraphBuilder, "artist/{artistId}/songs", CollectionsKt__IterablesKt.listOf(SizeKt.navArgument("artistId", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 2))), null, null, null, null, new ComposableLambdaImpl(true, -1112294015, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b14 = b13;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b14) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b14 = 0;
                SizeKt.composable$default(navGraphBuilder, "artist/{artistId}/albums", CollectionsKt__IterablesKt.listOf(SizeKt.navArgument("artistId", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 3))), null, null, null, null, new ComposableLambdaImpl(true, 1914003202, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) {
                        byte b15 = b14;
                        Unit unit2 = Unit.INSTANCE;
                        NavDeepLinkRequest navDeepLinkRequest2 = navDeepLinkRequest;
                        NavHostController navHostController2 = navHostController;
                        Composer composer = (Composer) obj8;
                        Format$$ExternalSyntheticOutline0.m((Integer) obj9, (AnimatedContentScopeImpl) obj6, (NavBackStackEntry) obj7);
                        switch (b15) {
                            case 0:
                                ArtistItemsScreenKt.ArtistAlbumsScreen(navHostController2, navDeepLinkRequest2, null, composer, 0);
                                break;
                            default:
                                OnlinePodcastScreenKt.OnlinePodcastScreen(navHostController2, navDeepLinkRequest2, null, composer, 0);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b15 = 4;
                SizeKt.composable$default(navGraphBuilder, "artist/{artistId}/items?browseId={browseId}?params={params}", CollectionsKt__IterablesKt.listOf((Object[]) new NamedNavArgument[]{SizeKt.navArgument("artistId", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 4)), SizeKt.navArgument("browseId", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 5)), SizeKt.navArgument("params", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 6))}), null, null, null, null, new ComposableLambdaImpl(true, 645333123, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b16 = b15;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b16) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b16 = 6;
                SizeKt.composable$default(navGraphBuilder, "online_playlist/{playlistId}", CollectionsKt__IterablesKt.listOf(SizeKt.navArgument("playlistId", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 7))), null, null, null, null, new ComposableLambdaImpl(true, -623336956, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b17 = b16;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b17) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b17 = 1;
                SizeKt.composable$default(navGraphBuilder, "online_podcast/{podcastId}", CollectionsKt__IterablesKt.listOf(SizeKt.navArgument("podcastId", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 8))), null, null, null, null, new ComposableLambdaImpl(true, -1892007035, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) {
                        byte b18 = b17;
                        Unit unit2 = Unit.INSTANCE;
                        NavDeepLinkRequest navDeepLinkRequest2 = navDeepLinkRequest;
                        NavHostController navHostController2 = navHostController;
                        Composer composer = (Composer) obj8;
                        Format$$ExternalSyntheticOutline0.m((Integer) obj9, (AnimatedContentScopeImpl) obj6, (NavBackStackEntry) obj7);
                        switch (b18) {
                            case 0:
                                ArtistItemsScreenKt.ArtistAlbumsScreen(navHostController2, navDeepLinkRequest2, null, composer, 0);
                                break;
                            default:
                                OnlinePodcastScreenKt.OnlinePodcastScreen(navHostController2, navDeepLinkRequest2, null, composer, 0);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b18 = 7;
                SizeKt.composable$default(navGraphBuilder, "local_playlist/{playlistId}", CollectionsKt__IterablesKt.listOf(SizeKt.navArgument("playlistId", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 9))), null, null, null, null, new ComposableLambdaImpl(true, 262022299, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b19 = b18;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b19) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b19 = 8;
                SizeKt.composable$default(navGraphBuilder, "auto_playlist/{playlist}", CollectionsKt__IterablesKt.listOf(SizeKt.navArgument("playlist", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 10))), null, null, null, null, new ComposableLambdaImpl(true, -1006647780, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b19;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b20 = 9;
                SizeKt.composable$default(navGraphBuilder, "cache_playlist/{playlist}", CollectionsKt__IterablesKt.listOf(SizeKt.navArgument("playlist", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 11))), null, null, null, null, new ComposableLambdaImpl(true, 2019649437, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b20;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b21 = 11;
                SizeKt.composable$default(navGraphBuilder, "top_playlist/{top}", CollectionsKt__IterablesKt.listOf(SizeKt.navArgument("top", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 12))), null, null, null, null, new ComposableLambdaImpl(true, 750979358, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b21;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b22 = 12;
                SizeKt.composable$default(navGraphBuilder, "youtube_browse/{browseId}?params={params}", CollectionsKt__IterablesKt.listOf((Object[]) new NamedNavArgument[]{SizeKt.navArgument("browseId", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 13)), SizeKt.navArgument("params", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 14))}), null, null, null, null, new ComposableLambdaImpl(true, -517690721, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b22;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b23 = 0;
                Function4 function4 = new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b24 = b23;
                        Unit unit2 = Unit.INSTANCE;
                        Object obj10 = str;
                        NavHostController navHostController2 = navHostController;
                        switch (b24) {
                            case 0:
                                ((Integer) obj9).intValue();
                                ((AnimatedContentScopeImpl) obj6).getClass();
                                ((NavBackStackEntry) obj7).getClass();
                                AiSettingsKt.SettingsScreen(navHostController2, (String) obj10, (Composer) obj8, 0);
                                break;
                            default:
                                ((Integer) obj9).intValue();
                                ((AnimatedContentScopeImpl) obj6).getClass();
                                ((NavBackStackEntry) obj7).getClass();
                                AiSettingsKt.AppearanceSettings(navHostController2, (SnackbarHostState) obj10, (Composer) obj8, 0);
                                break;
                        }
                        return unit2;
                    }
                };
                final byte b24 = 1;
                SizeKt.composable$default(navGraphBuilder, "settings", null, null, null, null, null, new ComposableLambdaImpl(true, -1786360800, function4), 254);
                SizeKt.composable$default(navGraphBuilder, "settings/appearance", null, null, null, null, null, new ComposableLambdaImpl(true, 1239936417, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b25 = b24;
                        Unit unit2 = Unit.INSTANCE;
                        Object obj10 = snackbarHostState;
                        NavHostController navHostController2 = navHostController;
                        switch (b25) {
                            case 0:
                                ((Integer) obj9).intValue();
                                ((AnimatedContentScopeImpl) obj6).getClass();
                                ((NavBackStackEntry) obj7).getClass();
                                AiSettingsKt.SettingsScreen(navHostController2, (String) obj10, (Composer) obj8, 0);
                                break;
                            default:
                                ((Integer) obj9).intValue();
                                ((AnimatedContentScopeImpl) obj6).getClass();
                                ((NavBackStackEntry) obj7).getClass();
                                AiSettingsKt.AppearanceSettings(navHostController2, (SnackbarHostState) obj10, (Composer) obj8, 0);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b25 = 13;
                SizeKt.composable$default(navGraphBuilder, "settings/appearance/theme", null, null, null, null, null, new ComposableLambdaImpl(true, -28733662, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b25;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b26 = 14;
                SizeKt.composable$default(navGraphBuilder, "settings/content", null, null, null, null, null, new ComposableLambdaImpl(true, -1297403741, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b26;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b27 = 15;
                SizeKt.composable$default(navGraphBuilder, "settings/content/romanization", null, null, null, null, null, new ComposableLambdaImpl(true, 1728893476, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b27;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b28 = 16;
                SizeKt.composable$default(navGraphBuilder, "settings/ai", null, null, null, null, null, new ComposableLambdaImpl(true, -412044486, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b28;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b29 = 18;
                SizeKt.composable$default(navGraphBuilder, "settings/player", null, null, null, null, null, new ComposableLambdaImpl(true, -1680714565, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b29;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b30 = 19;
                SizeKt.composable$default(navGraphBuilder, "settings/storage", null, null, null, null, null, new ComposableLambdaImpl(true, 1345582652, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b30;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b31 = 20;
                SizeKt.composable$default(navGraphBuilder, "settings/privacy", null, null, null, null, null, new ComposableLambdaImpl(true, 76912573, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b31;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b32 = 21;
                SizeKt.composable$default(navGraphBuilder, "settings/backup_restore", null, null, null, null, null, new ComposableLambdaImpl(true, -1191757506, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b32;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b33 = 22;
                SizeKt.composable$default(navGraphBuilder, "settings/integrations", null, null, null, null, null, new ComposableLambdaImpl(true, 1834539711, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b33;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b34 = 23;
                SizeKt.composable$default(navGraphBuilder, "settings/integrations/discord", null, null, null, null, null, new ComposableLambdaImpl(true, 565869632, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b34;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b35 = 24;
                SizeKt.composable$default(navGraphBuilder, "settings/integrations/lastfm", null, null, null, null, null, new ComposableLambdaImpl(true, -702800447, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b35;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b36 = 25;
                SizeKt.composable$default(navGraphBuilder, "settings/integrations/listen_together", null, null, null, null, null, new ComposableLambdaImpl(true, -1971470526, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b36;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b37 = 26;
                SizeKt.composable$default(navGraphBuilder, "settings/updater", null, null, null, null, null, new ComposableLambdaImpl(true, 1054826691, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b37;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b38 = 27;
                SizeKt.composable$default(navGraphBuilder, "settings/about", null, null, null, null, null, new ComposableLambdaImpl(true, -1086111271, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b38;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b39 = 29;
                final byte b40 = 1;
                SizeKt.composable$default(navGraphBuilder, "login", null, null, null, null, null, new ComposableLambdaImpl(true, 1940185946, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b39;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                AlbumScreenKt.BrowseScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getString("browseId") : null, null, composer, 0);
                                break;
                            case 1:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, false, composer, 48);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistScreenKt.ArtistScreen(navHostController2, null, composer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistSongsScreen(navHostController2, null, composer, 0);
                                break;
                            case 4:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ArtistItemsScreenKt.ArtistItemsScreen(navHostController2, null, composer, 0);
                                break;
                            case 5:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                ListenTogetherScreenKt.ListenTogetherScreen(navHostController2, true, composer, 48);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.OnlinePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                LocalPlaylistScreenKt.LocalPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 8:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.AutoPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 9:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.CachePlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case 10:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.HistoryScreen(navHostController2, null, composer, 0);
                                break;
                            case 11:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                TopPlaylistScreenKt.TopPlaylistScreen(navHostController2, null, composer, 0);
                                break;
                            case DictionaryEntry.PRONUNCIATION /* 12 */:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.YouTubeBrowseScreen(navHostController2, null, composer, 0);
                                break;
                            case 13:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ThemeScreenKt.ThemeScreen(navHostController2, composer, 0);
                                break;
                            case 14:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.ContentSettings(navHostController2, composer, 0);
                                break;
                            case 15:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RomanizationSettingsKt.RomanizationSettings(navHostController2, composer, 0);
                                break;
                            case 16:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AiSettings(navHostController2, composer, 0);
                                break;
                            case 17:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.StatsScreen(navHostController2, null, composer, 0);
                                break;
                            case 18:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PlayerSettings(navHostController2, composer, 0);
                                break;
                            case 19:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.StorageSettings(navHostController2, composer, 0);
                                break;
                            case 20:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.PrivacySettings(navHostController2, composer, 0);
                                break;
                            case 21:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AiSettingsKt.BackupAndRestore(navHostController2, null, composer, 0);
                                break;
                            case 22:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.IntegrationScreen(navHostController2, composer, 0);
                                break;
                            case 23:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.DiscordSettings(navHostController2, composer, 0);
                                break;
                            case 24:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                LastFMSettingsKt.LastFMSettings(navHostController2, composer, 0);
                                break;
                            case 25:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                ListenTogetherSettingsKt.ListenTogetherSettings(navHostController2, composer, 0);
                                break;
                            case 26:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.UpdaterScreen(navHostController2, composer, 0);
                                break;
                            case 27:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AboutScreenKt.AboutScreen(navHostController2, composer, 0);
                                break;
                            case 28:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.MoodAndGenresScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, false, composer, 0, 2);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                SizeKt.composable$default(navGraphBuilder, "switch_channel", null, null, null, null, null, new ComposableLambdaImpl(true, 671515867, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b40;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AlbumScreen(navHostController2, null, composer, 0);
                                break;
                            case 1:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, true, composer, 48, 0);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                GapComposer gapComposer = (GapComposer) composer;
                                boolean zChangedInstance = gapComposer.changedInstance(navHostController2);
                                Object objRememberedValue = gapComposer.rememberedValue();
                                if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = new MainActivity$$ExternalSyntheticLambda2(navHostController2, (byte) 21);
                                    gapComposer.updateRememberedValue(objRememberedValue);
                                }
                                WizardScreenKt.WizardScreen(null, (Function0) objRememberedValue, gapComposer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                RecognitionScreenKt.RecognitionScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getBoolean("autoStart") : false, composer, 0);
                                break;
                            case 4:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RecognitionHistoryScreenKt.RecognitionHistoryScreen(navHostController2, composer, 0);
                                break;
                            case 5:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AndroidAutoSettings(navHostController2, composer, 0);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AccountScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.NewReleaseScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.ChartsScreen(navHostController2, null, composer, 0);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                SizeKt.composable$default(navGraphBuilder, "equalizer", null, null, null, null, null, AlbumScreenKt.f328lambda$597154212, 254);
                final byte b41 = 2;
                SizeKt.composable$default(navGraphBuilder, "eq_wizard", null, null, null, null, null, new ComposableLambdaImpl(true, -1865824291, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b41;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AlbumScreen(navHostController2, null, composer, 0);
                                break;
                            case 1:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, true, composer, 48, 0);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                GapComposer gapComposer = (GapComposer) composer;
                                boolean zChangedInstance = gapComposer.changedInstance(navHostController2);
                                Object objRememberedValue = gapComposer.rememberedValue();
                                if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = new MainActivity$$ExternalSyntheticLambda2(navHostController2, (byte) 21);
                                    gapComposer.updateRememberedValue(objRememberedValue);
                                }
                                WizardScreenKt.WizardScreen(null, (Function0) objRememberedValue, gapComposer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                RecognitionScreenKt.RecognitionScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getBoolean("autoStart") : false, composer, 0);
                                break;
                            case 4:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RecognitionHistoryScreenKt.RecognitionHistoryScreen(navHostController2, composer, 0);
                                break;
                            case 5:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AndroidAutoSettings(navHostController2, composer, 0);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AccountScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.NewReleaseScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.ChartsScreen(navHostController2, null, composer, 0);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b42 = 3;
                SizeKt.composable$default(navGraphBuilder, "recognition?autoStart={autoStart}", CollectionsKt__IterablesKt.listOf(SizeKt.navArgument("autoStart", new StatsScreenKt$$ExternalSyntheticLambda6((byte) 18))), null, null, null, null, new ComposableLambdaImpl(true, 1160472926, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b42;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AlbumScreen(navHostController2, null, composer, 0);
                                break;
                            case 1:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, true, composer, 48, 0);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                GapComposer gapComposer = (GapComposer) composer;
                                boolean zChangedInstance = gapComposer.changedInstance(navHostController2);
                                Object objRememberedValue = gapComposer.rememberedValue();
                                if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = new MainActivity$$ExternalSyntheticLambda2(navHostController2, (byte) 21);
                                    gapComposer.updateRememberedValue(objRememberedValue);
                                }
                                WizardScreenKt.WizardScreen(null, (Function0) objRememberedValue, gapComposer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                RecognitionScreenKt.RecognitionScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getBoolean("autoStart") : false, composer, 0);
                                break;
                            case 4:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RecognitionHistoryScreenKt.RecognitionHistoryScreen(navHostController2, composer, 0);
                                break;
                            case 5:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AndroidAutoSettings(navHostController2, composer, 0);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AccountScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.NewReleaseScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.ChartsScreen(navHostController2, null, composer, 0);
                                break;
                        }
                        return unit2;
                    }
                }), 252);
                final byte b43 = 4;
                SizeKt.composable$default(navGraphBuilder, "recognition_history", null, null, null, null, null, new ComposableLambdaImpl(true, -108197153, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b43;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AlbumScreen(navHostController2, null, composer, 0);
                                break;
                            case 1:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, true, composer, 48, 0);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                GapComposer gapComposer = (GapComposer) composer;
                                boolean zChangedInstance = gapComposer.changedInstance(navHostController2);
                                Object objRememberedValue = gapComposer.rememberedValue();
                                if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = new MainActivity$$ExternalSyntheticLambda2(navHostController2, (byte) 21);
                                    gapComposer.updateRememberedValue(objRememberedValue);
                                }
                                WizardScreenKt.WizardScreen(null, (Function0) objRememberedValue, gapComposer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                RecognitionScreenKt.RecognitionScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getBoolean("autoStart") : false, composer, 0);
                                break;
                            case 4:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RecognitionHistoryScreenKt.RecognitionHistoryScreen(navHostController2, composer, 0);
                                break;
                            case 5:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AndroidAutoSettings(navHostController2, composer, 0);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AccountScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.NewReleaseScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.ChartsScreen(navHostController2, null, composer, 0);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                final byte b44 = 5;
                SizeKt.composable$default(navGraphBuilder, "settings/android_auto", null, null, null, null, null, new ComposableLambdaImpl(true, -1376867232, new Function4() { // from class: com.metrolist.music.ui.screens.NavigationBuilderKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) throws XmlPullParserException, IOException {
                        byte b110 = b44;
                        Unit unit2 = Unit.INSTANCE;
                        NavHostController navHostController2 = navHostController;
                        AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj6;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj7;
                        Composer composer = (Composer) obj8;
                        Integer num = (Integer) obj9;
                        switch (b110) {
                            case 0:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AlbumScreen(navHostController2, null, composer, 0);
                                break;
                            case 1:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AlbumScreenKt.LoginScreen(navHostController2, true, composer, 48, 0);
                                break;
                            case 2:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                GapComposer gapComposer = (GapComposer) composer;
                                boolean zChangedInstance = gapComposer.changedInstance(navHostController2);
                                Object objRememberedValue = gapComposer.rememberedValue();
                                if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                                    objRememberedValue = new MainActivity$$ExternalSyntheticLambda2(navHostController2, (byte) 21);
                                    gapComposer.updateRememberedValue(objRememberedValue);
                                }
                                WizardScreenKt.WizardScreen(null, (Function0) objRememberedValue, gapComposer, 0);
                                break;
                            case 3:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
                                RecognitionScreenKt.RecognitionScreen(navHostController2, arguments$navigation_common_release != null ? arguments$navigation_common_release.getBoolean("autoStart") : false, composer, 0);
                                break;
                            case 4:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                RecognitionHistoryScreenKt.RecognitionHistoryScreen(navHostController2, composer, 0);
                                break;
                            case 5:
                                num.intValue();
                                animatedContentScopeImpl.getClass();
                                navBackStackEntry.getClass();
                                AiSettingsKt.AndroidAutoSettings(navHostController2, composer, 0);
                                break;
                            case 6:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.AccountScreen(navHostController2, null, composer, 0);
                                break;
                            case 7:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.NewReleaseScreen(navHostController2, null, composer, 0);
                                break;
                            default:
                                Format$$ExternalSyntheticOutline0.m(num, animatedContentScopeImpl, navBackStackEntry);
                                AlbumScreenKt.ChartsScreen(navHostController2, null, composer, 0);
                                break;
                        }
                        return unit2;
                    }
                }), 254);
                return unit;
            case 1:
                SharedMutableTransformState sharedMutableTransformState = (SharedMutableTransformState) obj5;
                Lazy lazy = sharedMutableTransformState.catchUpTransformOrigin$delegate;
                Lazy lazy2 = sharedMutableTransformState.catchUpScale$delegate;
                Lazy lazy3 = sharedMutableTransformState.catchUpAlpha$delegate;
                State state = (State) obj4;
                State state2 = (State) obj3;
                State state3 = (State) obj2;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                float fFloatValue = state != null ? ((Number) state.getValue()).floatValue() : 1.0f;
                TransformScopeImpl transformScopeImpl = sharedMutableTransformState.transformScope;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = transformScopeImpl._alpha;
                ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = transformScopeImpl._scale;
                sharedMutableTransformState.activeTransitionAlpha = fFloatValue;
                boolean z3 = sharedMutableTransformState.isMutating() && transformScopeImpl.isAlphaMutated();
                MutationPhase mutationPhase = MutationPhase.Mutating;
                MutationPhase mutationPhase2 = MutationPhase.MutatingCatchingUp;
                if (z3 && sharedMutableTransformState.getMutationPhase$animation() == mutationPhase2 && ((Animatable) lazy3.getValue()).isRunning()) {
                    fFloatValue = (parcelableSnapshotMutableFloatState.getFloatValue() - sharedMutableTransformState.initialManualAlpha) + ((Number) ((Animatable) lazy3.getValue()).getValue()).floatValue();
                } else if (z3 && (sharedMutableTransformState.getMutationPhase$animation() == mutationPhase2 || sharedMutableTransformState.getMutationPhase$animation() == mutationPhase)) {
                    fFloatValue = parcelableSnapshotMutableFloatState.getFloatValue();
                }
                if (sharedMutableTransformState.isMutating()) {
                    sharedMutableTransformState.lastAlpha = fFloatValue;
                }
                reusableGraphicsLayerScope.setAlpha(fFloatValue);
                float fFloatValue2 = state2 != null ? ((Number) state2.getValue()).floatValue() : 1.0f;
                sharedMutableTransformState.activeTransitionScale = fFloatValue2;
                boolean z4 = sharedMutableTransformState.isMutating() && transformScopeImpl.isScaleMutated();
                if (z4 && sharedMutableTransformState.getMutationPhase$animation() == mutationPhase2 && ((Animatable) lazy2.getValue()).isRunning()) {
                    fFloatValue2 = (parcelableSnapshotMutableFloatState2.getFloatValue() - sharedMutableTransformState.initialManualScale) + ((Number) ((Animatable) lazy2.getValue()).getValue()).floatValue();
                } else if (z4 && (sharedMutableTransformState.getMutationPhase$animation() == mutationPhase2 || sharedMutableTransformState.getMutationPhase$animation() == mutationPhase)) {
                    fFloatValue2 = parcelableSnapshotMutableFloatState2.getFloatValue();
                }
                if (sharedMutableTransformState.isMutating()) {
                    sharedMutableTransformState.lastScale = fFloatValue2;
                    if (z4) {
                        parcelableSnapshotMutableFloatState2.getFloatValue();
                    }
                    if (z4) {
                        VelocityTracker velocityTracker = sharedMutableTransformState.scaleVelocityTracker;
                        if (velocityTracker == null) {
                            velocityTracker = new VelocityTracker();
                            sharedMutableTransformState.scaleVelocityTracker = velocityTracker;
                        }
                        velocityTracker.m594addPositionUv8p0NA(Duration.m1887getInWholeMillisecondsimpl(TimeSource$Monotonic$ValueTimeMark.m1894elapsedNowUwyO8pc(sharedMutableTransformState.startTime)), (((long) Float.floatToRawIntBits(fFloatValue2)) << 32) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L));
                    }
                }
                reusableGraphicsLayerScope.setScaleX(fFloatValue2);
                reusableGraphicsLayerScope.setScaleY(fFloatValue2);
                long jTransformOrigin = state3 != null ? ((TransformOrigin) state3.getValue()).packedValue : ColorKt.TransformOrigin(0.5f, 0.5f);
                sharedMutableTransformState.activeTransitionTransformOrigin = jTransformOrigin;
                boolean z5 = sharedMutableTransformState.isMutating() && ((Boolean) transformScopeImpl.isTransformOriginMutated$delegate.getValue()).booleanValue();
                if (z5 && sharedMutableTransformState.getMutationPhase$animation() == mutationPhase2 && ((Animatable) lazy.getValue()).isRunning()) {
                    jTransformOrigin = ((TransformOrigin) ((Animatable) lazy.getValue()).getValue()).packedValue;
                } else if (z5 && (sharedMutableTransformState.getMutationPhase$animation() == mutationPhase2 || sharedMutableTransformState.getMutationPhase$animation() == mutationPhase)) {
                    jTransformOrigin = ((TransformOrigin) transformScopeImpl._transformOrigin.getValue()).packedValue;
                }
                if (sharedMutableTransformState.isMutating()) {
                    sharedMutableTransformState.lastTransformOrigin = jTransformOrigin;
                }
                reusableGraphicsLayerScope.m517setTransformOrigin__ExYCQ(jTransformOrigin);
                return unit;
            case 2:
                Animatable animatable = (Animatable) obj5;
                AnimationState animationState = (AnimationState) obj4;
                Function1 function1 = (Function1) obj3;
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) obj2;
                AnimationScope animationScope = (AnimationScope) obj;
                ArcSplineKt.updateState(animationScope, animatable.internalState);
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = animationScope.value$delegate;
                Object objClampToBounds = animatable.clampToBounds(parcelableSnapshotMutableState.getValue());
                if (!Intrinsics.areEqual(objClampToBounds, parcelableSnapshotMutableState.getValue())) {
                    animatable.internalState.value$delegate.setValue(objClampToBounds);
                    animationState.value$delegate.setValue(objClampToBounds);
                    if (function1 != null) {
                        function1.invoke(animatable);
                    }
                    animationScope.cancelAnimation();
                    ref$BooleanRef.element = true;
                } else if (function1 != null) {
                    function1.invoke(animatable);
                }
                return unit;
            case 3:
                InfiniteTransition infiniteTransition = (InfiniteTransition) obj4;
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) obj3;
                CoroutineScope coroutineScope = (CoroutineScope) obj2;
                long jLongValue = ((Long) obj).longValue();
                State state4 = (State) ((MutableState) obj5).getValue();
                long jLongValue2 = state4 != null ? ((Number) state4.getValue()).longValue() : jLongValue;
                long j = infiniteTransition.startTimeNanos;
                MutableVector mutableVector = infiniteTransition._animations;
                if (j == Long.MIN_VALUE || ref$FloatRef.element != ArcSplineKt.getDurationScale(coroutineScope.getCoroutineContext())) {
                    infiniteTransition.startTimeNanos = jLongValue;
                    Object[] objArr = mutableVector.content;
                    int i3 = mutableVector.size;
                    for (int i4 = 0; i4 < i3; i4++) {
                        ((InfiniteTransition.TransitionAnimationState) objArr[i4]).startOnTheNextFrame = true;
                    }
                    ref$FloatRef.element = ArcSplineKt.getDurationScale(coroutineScope.getCoroutineContext());
                }
                float f = ref$FloatRef.element;
                if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
                    Object[] objArr2 = mutableVector.content;
                    int i5 = mutableVector.size;
                    for (int i6 = 0; i6 < i5; i6++) {
                        InfiniteTransition.TransitionAnimationState transitionAnimationState = (InfiniteTransition.TransitionAnimationState) objArr2[i6];
                        transitionAnimationState.value$delegate.setValue(transitionAnimationState.animation.mutableTargetValue);
                        transitionAnimationState.startOnTheNextFrame = true;
                    }
                } else {
                    long j2 = (long) ((jLongValue2 - infiniteTransition.startTimeNanos) / f);
                    Object[] objArr3 = mutableVector.content;
                    int i7 = mutableVector.size;
                    boolean z6 = true;
                    for (int i8 = 0; i8 < i7; i8++) {
                        InfiniteTransition.TransitionAnimationState transitionAnimationState2 = (InfiniteTransition.TransitionAnimationState) objArr3[i8];
                        boolean zIsFinishedFromNanos = transitionAnimationState2.isFinished;
                        if (!zIsFinishedFromNanos) {
                            InfiniteTransition.this.refreshChildNeeded$delegate.setValue(Boolean.FALSE);
                            if (transitionAnimationState2.startOnTheNextFrame) {
                                transitionAnimationState2.startOnTheNextFrame = false;
                                transitionAnimationState2.playTimeNanosOffset = j2;
                            }
                            long j3 = j2 - transitionAnimationState2.playTimeNanosOffset;
                            transitionAnimationState2.value$delegate.setValue(transitionAnimationState2.animation.getValueFromNanos(j3));
                            zIsFinishedFromNanos = transitionAnimationState2.animation.isFinishedFromNanos(j3);
                            transitionAnimationState2.isFinished = zIsFinishedFromNanos;
                        }
                        if (!zIsFinishedFromNanos) {
                            z6 = false;
                        }
                    }
                    infiniteTransition.isRunning$delegate.setValue(Boolean.valueOf(!z6));
                }
                return unit;
            case 4:
                MouseWheelScrollingLogicImpl mouseWheelScrollingLogicImpl = (MouseWheelScrollingLogicImpl) obj5;
                Ref$LongRef ref$LongRef = (Ref$LongRef) obj4;
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) obj3;
                MainActivity$$ExternalSyntheticLambda59 mainActivity$$ExternalSyntheticLambda59 = (MainActivity$$ExternalSyntheticLambda59) obj2;
                AnimationScope animationScope2 = (AnimationScope) obj;
                long jM629encodesYkar0Y = mouseWheelScrollingLogicImpl.$$delegate_0.m629encodesYkar0Y(animationScope2.value$delegate.getValue());
                long j4 = ref$LongRef.element;
                ProvidableModifierLocal providableModifierLocal = mouseWheelScrollingLogicImpl.$$delegate_0;
                long jM631minusdonscBA = providableModifierLocal.m631minusdonscBA(jM629encodesYkar0Y, j4);
                if (!providableModifierLocal.m630isLowScrollingDeltasgRZ0Mg(jM631minusdonscBA)) {
                    long jM636toOffsetGbI52rc = providableModifierLocal.m636toOffsetGbI52rc(jM631minusdonscBA);
                    ScrollingLogic scrollingLogic = scrollingLogic$nestedScrollScope$1.this$0;
                    if (providableModifierLocal.m630isLowScrollingDeltasgRZ0Mg(providableModifierLocal.m631minusdonscBA(jM631minusdonscBA, providableModifierLocal.m637toScrollValueYk_gXsc(scrollingLogic.m103performScroll3eAAhYA(scrollingLogic.outerStateScope, jM636toOffsetGbI52rc, 1))))) {
                        ref$LongRef.element = providableModifierLocal.m633plusdonscBA(ref$LongRef.element, jM631minusdonscBA);
                        if (((Boolean) mainActivity$$ExternalSyntheticLambda59.invoke(new ScrollValue(ref$LongRef.element))).booleanValue()) {
                            animationScope2.cancelAnimation();
                        }
                    } else {
                        animationScope2.cancelAnimation();
                    }
                } else if (((Boolean) mainActivity$$ExternalSyntheticLambda59.invoke(new ScrollValue(ref$LongRef.element))).booleanValue()) {
                    animationScope2.cancelAnimation();
                }
                return unit;
            case 5:
                MouseWheelScrollingLogicImpl mouseWheelScrollingLogicImpl2 = (MouseWheelScrollingLogicImpl) obj5;
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj4;
                Ref$LongRef ref$LongRef2 = (Ref$LongRef) obj3;
                Ref$BooleanRef ref$BooleanRef2 = (Ref$BooleanRef) obj2;
                ScrollValue scrollValue = (ScrollValue) obj;
                BufferedChannel bufferedChannel = mouseWheelScrollingLogicImpl2.channel;
                ProvidableModifierLocal providableModifierLocal2 = mouseWheelScrollingLogicImpl2.$$delegate_0;
                MouseWheelScrollingLogicImpl.MouseWheelScrollDelta mouseWheelScrollDeltaSumOrNull = MouseWheelScrollingLogicImpl.sumOrNull(bufferedChannel);
                if (mouseWheelScrollDeltaSumOrNull != null) {
                    CallbackWrapper callbackWrapper = (CallbackWrapper) mouseWheelScrollingLogicImpl2.callbackHandler;
                    long j5 = mouseWheelScrollDeltaSumOrNull.timeMillis;
                    long j6 = mouseWheelScrollDeltaSumOrNull.value;
                    ((VelocityTracker1D) callbackWrapper.mCallback).addDataPoint(j5, Float.intBitsToFloat((int) (j6 >> 32)));
                    ((VelocityTracker1D) callbackWrapper.mExecutor).addDataPoint(j5, Float.intBitsToFloat((int) (j6 & 4294967295L)));
                    MouseWheelScrollingLogicImpl.MouseWheelScrollDelta mouseWheelScrollDeltaPlus = ((MouseWheelScrollingLogicImpl.MouseWheelScrollDelta) ref$ObjectRef.element).plus(mouseWheelScrollDeltaSumOrNull);
                    ref$ObjectRef.element = mouseWheelScrollDeltaPlus;
                    long jM637toScrollValueYk_gXsc = providableModifierLocal2.m637toScrollValueYk_gXsc(mouseWheelScrollDeltaPlus.value);
                    ref$LongRef2.element = jM637toScrollValueYk_gXsc;
                    ref$BooleanRef2.element = !providableModifierLocal2.m630isLowScrollingDeltasgRZ0Mg(providableModifierLocal2.m631minusdonscBA(jM637toScrollValueYk_gXsc, scrollValue.bits));
                }
                return Boolean.valueOf(mouseWheelScrollDeltaSumOrNull != null);
            case 6:
                return invoke$androidx$compose$foundation$text$CoreTextFieldKt$$ExternalSyntheticLambda8(obj);
            case 7:
                return new SheetState((Set) obj5, (Function0) obj4, (Function0) obj3, (SheetValue) obj, (Function1) obj2);
            case 8:
                return invoke$androidx$navigation$internal$NavControllerImpl$$ExternalSyntheticLambda2(obj);
            case 9:
                return invoke$com$metrolist$music$playback$DownloadUtil$$ExternalSyntheticLambda3(obj);
            case 10:
                return invoke$com$metrolist$music$ui$component$ExpandableTextKt$$ExternalSyntheticLambda3(obj);
            case 11:
                return invoke$com$metrolist$music$ui$component$WavySliderKt$WavySlider$interactiveModifier$1$1$$ExternalSyntheticLambda0(obj);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return invoke$com$metrolist$music$ui$menu$AlbumMenuKt$$ExternalSyntheticLambda10(obj);
            case 13:
                return invoke$com$metrolist$music$ui$menu$AlbumMenuKt$$ExternalSyntheticLambda41(obj);
            case 14:
                return invoke$com$metrolist$music$ui$menu$PlaylistMenuKt$$ExternalSyntheticLambda4(obj);
            case 15:
                return invoke$com$metrolist$music$ui$menu$PlaylistMenuKt$$ExternalSyntheticLambda6(obj);
            case 16:
                return invoke$com$metrolist$music$ui$menu$SongMenuKt$$ExternalSyntheticLambda10(obj);
            case 17:
                return invoke$com$metrolist$music$ui$menu$YouTubeSongMenuKt$$ExternalSyntheticLambda9(obj);
            case 18:
                return invoke$com$metrolist$music$ui$player$PlayerKt$$ExternalSyntheticLambda30(obj);
            case 19:
                return invoke$com$metrolist$music$ui$screens$equalizer$wizard$WizardScreenKt$$ExternalSyntheticLambda15(obj);
            case 20:
                return invoke$com$metrolist$music$ui$screens$search$OnlineSearchResultKt$$ExternalSyntheticLambda24(obj);
            case 21:
                return invoke$com$metrolist$music$ui$screens$search$OnlineSearchResultKt$$ExternalSyntheticLambda3(obj);
            case 22:
                return invoke$com$metrolist$music$ui$screens$settings$AndroidAutoSettingsKt$$ExternalSyntheticLambda3(obj);
            default:
                BackupRestoreViewModel backupRestoreViewModel = (BackupRestoreViewModel) obj5;
                Context context = (Context) obj4;
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj3;
                MutableState mutableState = (MutableState) obj2;
                Uri uri = (Uri) obj;
                if (uri != null) {
                    backupRestoreViewModel.getClass();
                    context.getClass();
                    ArrayList arrayList = new ArrayList();
                    try {
                        InputStream inputStreamOpenInputStream = context.getApplicationContext().getContentResolver().openInputStream(uri);
                        try {
                            if (inputStreamOpenInputStream != null) {
                                try {
                                    ArrayList lines = RegexKt.readLines(new BufferedReader(new InputStreamReader(inputStreamOpenInputStream, Charsets.UTF_8), 8192));
                                    if (!lines.isEmpty() && StringsKt__StringsJVMKt.startsWith((String) CollectionsKt.first((List) lines), "#EXTM3U", false)) {
                                        int size = lines.size();
                                        int i9 = 0;
                                        int i10 = 0;
                                        while (i10 < size) {
                                            Object obj6 = lines.get(i10);
                                            i10++;
                                            int i11 = i9 + 1;
                                            if (i9 < 0) {
                                                z = z2 ? 1 : 0;
                                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                                throw null;
                                            }
                                            String str2 = (String) obj6;
                                            if (StringsKt__StringsJVMKt.startsWith(str2, "#EXTINF:", z2)) {
                                                z = z2 ? 1 : 0;
                                                try {
                                                    String strSubstringAfter = StringsKt.substringAfter(str2, "#EXTINF:", str2);
                                                    String strSubstringBefore$default = StringsKt.substringBefore$default(StringsKt.substringAfter(',', strSubstringAfter, strSubstringAfter), " - ");
                                                    char[] cArr = new char[i];
                                                    cArr[z ? 1 : 0] = ';';
                                                    List listSplit$default = StringsKt.split$default(strSubstringBefore$default, cArr);
                                                    String strSubstringAfter2 = StringsKt.substringAfter(str2, "#EXTINF:", str2);
                                                    String strSubstringAfter3 = StringsKt.substringAfter(',', strSubstringAfter2, strSubstringAfter2);
                                                    SongEntity songEntity = new SongEntity("", StringsKt.substringAfter(strSubstringAfter3, " - ", strSubstringAfter3), 0, null, null, null, false, false, null, null, false, false, null, 134217724);
                                                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
                                                    Iterator it = listSplit$default.iterator();
                                                    while (it.hasNext()) {
                                                        arrayList2.add(new ArtistEntity("", (String) it.next(), null, null, null, false, null, 508));
                                                    }
                                                    arrayList.add(new Song(songEntity, arrayList2, null, 28));
                                                } catch (Throwable th) {
                                                    th = th;
                                                }
                                            } else {
                                                z = z2 ? 1 : 0;
                                            }
                                            z2 = z;
                                            i9 = i11;
                                            i = i;
                                            th = th;
                                            Throwable th2 = th;
                                            try {
                                                throw th2;
                                            } catch (Throwable th3) {
                                                CharsKt.closeFinally(inputStreamOpenInputStream, th2);
                                                throw th3;
                                            }
                                        }
                                    }
                                    z = z2;
                                    inputStreamOpenInputStream.close();
                                } catch (Throwable th4) {
                                    th = th4;
                                    z = z2;
                                }
                            } else {
                                z = false;
                            }
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                    }
                    if (arrayList.isEmpty()) {
                        Toast.makeText(context, "No songs found. Invalid file, or perhaps no song matches were found.", z ? 1 : 0).show();
                    }
                    snapshotStateList.clear();
                    snapshotStateList.addAll(arrayList);
                    if (!snapshotStateList.isEmpty()) {
                        mutableState.setValue(Boolean.TRUE);
                    }
                }
                return unit;
        }
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda59(NavHostController navHostController, NavDeepLinkRequest navDeepLinkRequest, String str, MainActivity mainActivity, SnackbarHostState snackbarHostState) {
        this.$r8$classId = (byte) 0;
        this.f$0 = navHostController;
        this.f$1 = navDeepLinkRequest;
        this.f$2 = str;
        this.f$4 = snackbarHostState;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda59(Object obj, NavHostController navHostController, MutableState mutableState, Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$1 = obj;
        this.f$0 = navHostController;
        this.f$2 = mutableState;
        this.f$4 = function0;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda59(Object obj, Object obj2, Object obj3, Object obj4, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$4 = obj4;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda59(Object obj, String str, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$2 = str;
        this.f$1 = obj2;
        this.f$4 = obj3;
    }

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda59(CoroutineScope coroutineScope, MutableState mutableState, MusicDatabase musicDatabase, String str) {
        this.$r8$classId = (byte) 20;
        this.f$0 = coroutineScope;
        this.f$1 = mutableState;
        this.f$4 = musicDatabase;
        this.f$2 = str;
    }
}
