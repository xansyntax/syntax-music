package io.ktor.http;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.compose.material3.ColorScheme;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.media3.common.Player;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.ExoPlayerImpl;
import coil3.util.LifecyclesKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.music.constants.HistorySource;
import com.metrolist.music.constants.LibraryViewType;
import com.metrolist.music.db.DatabaseDao$$ExternalSyntheticLambda0;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.AlbumWithSongs;
import com.metrolist.music.db.entities.Event;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.PlaylistSong;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.RecognitionHistory;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.lyrics.LyricsResult;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4;
import com.metrolist.music.ui.screens.library.LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6;
import com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import com.metrolist.music.viewmodels.AccountContentType;
import com.metrolist.music.viewmodels.AccountViewModel;
import com.metrolist.music.viewmodels.HistoryViewModel;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.metrolist.music.viewmodels.LocalFilter;
import com.metrolist.music.viewmodels.LocalSearchViewModel;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import com.metrolist.shazamkit.models.RecognitionResult;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.RenderScriptBlurEffect;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.contentnegotiation.ContentTypeMergeStrategy;
import io.ktor.client.plugins.sse.DefaultClientSSESession;
import io.ktor.http.cio.CIOHeaders;
import io.ktor.http.cio.MultipartEvent;
import io.ktor.network.selector.ActorSelectorManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.sequences.FlatteningSequence;
import kotlin.text.MatcherMatchResult;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MimesKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ MimesKt$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Integer intOrNull;
        Object value;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                return MimesKt.loadMimes$lambda$0$0((ContentType) obj2, (String) obj);
            case 1:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                musicDatabase.delete((Event) obj2);
                return unit;
            case 2:
                PlaylistSong playlistSong = (PlaylistSong) obj2;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                musicDatabase2.getClass();
                PlaylistSongMap playlistSongMap = playlistSong.map;
                musicDatabase2.move(playlistSongMap.position, Integer.MAX_VALUE, playlistSongMap.playlistId);
                musicDatabase2.$$delegate_0.delete(PlaylistSongMap.copy$default(playlistSong.map, Integer.MAX_VALUE, null, 23));
                return unit;
            case 3:
                PlaylistItem playlistItem = (PlaylistItem) obj2;
                MusicDatabase musicDatabase3 = (MusicDatabase) obj;
                musicDatabase3.getClass();
                String str = playlistItem.title;
                String str2 = playlistItem.id;
                String str3 = playlistItem.thumbnail;
                boolean z = playlistItem.isEditable;
                String str4 = playlistItem.songCountText;
                if (str4 != null) {
                    Pattern patternCompile = Pattern.compile("\\d+");
                    patternCompile.getClass();
                    Matcher matcher = patternCompile.matcher(str4);
                    matcher.getClass();
                    MatcherMatchResult matcherMatchResultFindNext = RegexKt.findNext(matcher, 0, str4);
                    intOrNull = matcherMatchResultFindNext != null ? StringsKt__StringsJVMKt.toIntOrNull(10, matcherMatchResultFindNext.getValue()) : null;
                } else {
                    intOrNull = null;
                }
                WatchEndpoint watchEndpoint = playlistItem.playEndpoint;
                String str5 = watchEndpoint != null ? watchEndpoint.params : null;
                WatchEndpoint watchEndpoint2 = playlistItem.shuffleEndpoint;
                String str6 = watchEndpoint2 != null ? watchEndpoint2.params : null;
                WatchEndpoint watchEndpoint3 = playlistItem.radioEndpoint;
                musicDatabase3.$$delegate_0.insert(new PlaylistEntity(null, str, str2, null, z, null, intOrNull, str5, str3, str6, watchEndpoint3 != null ? watchEndpoint3.params : null, 12377).toggleLike());
                return unit;
            case 4:
                ((MusicDatabase) obj).insert((MediaMetadata) obj2, new DatabaseDao$$ExternalSyntheticLambda0((byte) 0));
                return unit;
            case 5:
                PlayerConnection playerConnection = (PlayerConnection) obj2;
                ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
                ExoPlayerImpl playerSafe2 = playerConnection.getPlayerSafe();
                playerSafe2.verifyApplicationThread();
                playerSafe.setShuffleModeEnabled(!playerSafe2.shuffleModeEnabled);
                return unit;
            case 6:
                AccountContentType accountContentType = (AccountContentType) obj;
                accountContentType.getClass();
                StateFlowImpl stateFlowImpl = ((AccountViewModel) obj2).selectedContentType;
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, accountContentType);
                return unit;
            case 7:
                MusicDatabase musicDatabase4 = (MusicDatabase) obj;
                musicDatabase4.getClass();
                musicDatabase4.$$delegate_0.update(((AlbumWithSongs) obj2).album.toggleLike());
                return unit;
            case 8:
                HistoryViewModel historyViewModel = (HistoryViewModel) obj2;
                HistorySource historySource = (HistorySource) obj;
                historySource.getClass();
                StateFlowImpl stateFlowImpl2 = historyViewModel.historySource;
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, historySource);
                if (historySource == HistorySource.REMOTE) {
                    historyViewModel.fetchRemoteHistory();
                }
                return unit;
            case 9:
                ((HomeViewModel) obj2).toggleChip((HomePage.Chip) obj);
                return unit;
            case 10:
                Artist artist = (Artist) obj;
                artist.getClass();
                return Boolean.valueOf(Intrinsics.areEqual(artist.id, ((Artist) obj2).id));
            case 11:
                LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4) obj2;
                LibraryViewType libraryViewType = (LibraryViewType) obj;
                libraryViewType.getClass();
                libraryViewType.getClass();
                AwaitKt.launch$default(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4.$context, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$4.$key, libraryViewType, null, (byte) 15), 3);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6 libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6 = (LibraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6) obj2;
                LibraryViewType libraryViewType2 = (LibraryViewType) obj;
                libraryViewType2.getClass();
                libraryViewType2.getClass();
                AwaitKt.launch$default(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6.$coroutineScope, null, null, new SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2.AnonymousClass1(libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6.$context, libraryScreenKt$LibraryScreen$$inlined$rememberEnumPreference$6.$key, libraryViewType2, null, (byte) 16), 3);
                return unit;
            case 13:
                ((MusicDatabase) obj).deleteRecognitionHistoryById(((RecognitionHistory) obj2).id);
                return unit;
            case 14:
                RecognitionResult recognitionResult = (RecognitionResult) obj2;
                MusicDatabase musicDatabase5 = (MusicDatabase) obj;
                String trackId = recognitionResult.getTrackId();
                String title = recognitionResult.getTitle();
                String artist2 = recognitionResult.getArtist();
                String album = recognitionResult.getAlbum();
                String coverArtUrl = recognitionResult.getCoverArtUrl();
                String coverArtHqUrl = recognitionResult.getCoverArtHqUrl();
                String genre = recognitionResult.getGenre();
                String releaseDate = recognitionResult.getReleaseDate();
                String label = recognitionResult.getLabel();
                String shazamUrl = recognitionResult.getShazamUrl();
                String appleMusicUrl = recognitionResult.getAppleMusicUrl();
                String spotifyUrl = recognitionResult.getSpotifyUrl();
                String isrc = recognitionResult.getIsrc();
                String youtubeVideoId = recognitionResult.getYoutubeVideoId();
                LocalDateTime localDateTimeNow = LocalDateTime.now();
                localDateTimeNow.getClass();
                RecognitionHistory recognitionHistory = new RecognitionHistory(trackId, title, artist2, album, coverArtUrl, coverArtHqUrl, genre, releaseDate, label, shazamUrl, appleMusicUrl, spotifyUrl, isrc, youtubeVideoId, localDateTimeNow);
                musicDatabase5.getClass();
                musicDatabase5.$$delegate_0.insert(recognitionHistory);
                return unit;
            case 15:
                LocalFilter localFilter = (LocalFilter) obj;
                localFilter.getClass();
                StateFlowImpl stateFlowImpl3 = ((LocalSearchViewModel) obj2).filter;
                stateFlowImpl3.getClass();
                stateFlowImpl3.updateState(null, localFilter);
                return unit;
            case 16:
                ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) obj2;
                Context context = (Context) obj;
                context.getClass();
                final TextureView textureView = new TextureView(context);
                final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
                exoPlayerImpl.listeners.add(new Player.Listener() { // from class: com.metrolist.music.ui.screens.settings.AboutScreenKt$DevBannerVideo$2$1$1
                    @Override // androidx.media3.common.Player.Listener
                    public final void onVideoSizeChanged(VideoSize videoSize) {
                        videoSize.getClass();
                        float f = videoSize.width * videoSize.pixelWidthHeightRatio;
                        Ref$FloatRef ref$FloatRef3 = ref$FloatRef;
                        ref$FloatRef3.element = f;
                        float f2 = videoSize.height;
                        Ref$FloatRef ref$FloatRef4 = ref$FloatRef2;
                        ref$FloatRef4.element = f2;
                        AboutScreenKt.DevBannerVideo$lambda$2$0$applyCover(textureView, ref$FloatRef3, ref$FloatRef4);
                    }
                });
                textureView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.metrolist.music.ui.screens.settings.AboutScreenKt$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                        AboutScreenKt.DevBannerVideo$lambda$2$0$applyCover(textureView, ref$FloatRef, ref$FloatRef2);
                    }
                });
                exoPlayerImpl.verifyApplicationThread();
                exoPlayerImpl.removeSurfaceCallbacks();
                exoPlayerImpl.textureView = textureView;
                if (textureView.getSurfaceTextureListener() != null) {
                    Log.w("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
                }
                textureView.setSurfaceTextureListener(exoPlayerImpl.componentListener);
                SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
                if (surfaceTexture == null) {
                    exoPlayerImpl.setVideoOutputInternal(null);
                    exoPlayerImpl.maybeNotifySurfaceSizeChanged(0, 0);
                } else {
                    Surface surface = new Surface(surfaceTexture);
                    exoPlayerImpl.setVideoOutputInternal(surface);
                    exoPlayerImpl.ownedSurface = surface;
                    exoPlayerImpl.maybeNotifySurfaceSizeChanged(textureView.getWidth(), textureView.getHeight());
                }
                return textureView;
            case 17:
                ColorScheme colorScheme = (ColorScheme) obj2;
                DrawScope drawScope = (DrawScope) obj;
                drawScope.getClass();
                float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo556getSizeNHjbRc() & 4294967295L)) / 2.0f;
                DrawScope.m550drawRectnJ9OG0$default(drawScope, colorScheme.onPrimary, (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) & 4294967295L) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32), (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), CropImageView.DEFAULT_ASPECT_RATIO, 0, 120);
                float f = fIntBitsToFloat / 2.0f;
                DrawScope.m550drawRectnJ9OG0$default(drawScope, colorScheme.secondary, (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L) | (((long) Float.floatToRawIntBits(CropImageView.DEFAULT_ASPECT_RATIO)) << 32), (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), CropImageView.DEFAULT_ASPECT_RATIO, 0, 120);
                DrawScope.m550drawRectnJ9OG0$default(drawScope, colorScheme.tertiary, (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), CropImageView.DEFAULT_ASPECT_RATIO, 0, 120);
                return unit;
            case 18:
                ((DataStoreKt$rememberPreference$1$1) obj2).setValue(obj);
                return unit;
            case 19:
                LocalDateTime localDateTime = (LocalDateTime) obj2;
                localDateTime.getClass();
                return ((SongEntity) obj).withLibraryMembership(true, localDateTime);
            case 20:
                LyricsResult lyricsResult = (LyricsResult) obj;
                StateFlowImpl stateFlowImpl4 = ((LyricsMenuViewModel) obj2).results;
                do {
                    value = stateFlowImpl4.getValue();
                } while (!stateFlowImpl4.compareAndSet(value, CollectionsKt.plus(lyricsResult, (List) value)));
                return unit;
            case 21:
                DrawScope drawScope2 = (DrawScope) obj;
                drawScope2.getClass();
                LifecyclesKt.drawLayer(drawScope2, ((RenderScriptBlurEffect) obj2).contentLayer);
                return unit;
            case 22:
                return HttpClient._init_$lambda$0((HttpClientEngine) obj2, (Throwable) obj);
            case 23:
                return HttpClientConfig.installPlugin$lambda$0((HttpClientPlugin) obj2, (HttpClient) obj);
            case 24:
                return Boolean.valueOf(ContentTypeMergeStrategy.Companion.Default$lambda$0$1((FlatteningSequence) obj2, (ContentType) obj));
            case 25:
                return DefaultClientSSESession._init_$lambda$0((DefaultClientSSESession) obj2, (Throwable) obj);
            case 26:
                return CodecsKt.encodeURLPath$lambda$0$0((StringBuilder) obj2, ((Byte) obj).byteValue());
            case 27:
                return CIOHeaders.entries$lambda$0((CIOHeaders) obj2, ((Integer) obj).intValue());
            case 28:
                return MultipartEvent.MultipartPart.release$lambda$0((MultipartEvent.MultipartPart) obj2, (Throwable) obj);
            default:
                return ActorSelectorManager._init_$lambda$0((ActorSelectorManager) obj2, (Throwable) obj);
        }
    }
}
