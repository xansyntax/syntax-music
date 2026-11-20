package com.metrolist.music.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.compose.foundation.lazy.LazyListKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusRequester;
import androidx.core.provider.CallbackWrapper;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences$Key;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.navigation.internal.NavDestinationImpl$$ExternalSyntheticLambda2;
import coil3.RealImageLoader;
import coil3.SingletonImageLoader;
import coil3.UriKt;
import coil3.network.HttpException;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.base.Splitter;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.ArtistSection;
import com.metrolist.innertube.pages.BrowseResult;
import com.metrolist.innertube.pages.PlaylistPage;
import com.metrolist.music.constants.SongFilter;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.discord.DiscordRpcManager;
import com.metrolist.music.eq.data.EQProfileRepository;
import com.metrolist.music.eq.data.EQProfileRepository$deleteProfile$2;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.BottomSheetState;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda4;
import com.metrolist.music.ui.player.ThumbnailKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.screens.equalizer.EQViewModel;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardViewModel;
import com.metrolist.music.ui.screens.settings.ChangelogScreenKt;
import com.metrolist.music.viewmodels.ArtistItemsViewModel;
import com.metrolist.music.viewmodels.ArtistViewModel;
import com.metrolist.music.viewmodels.BrowseViewModel;
import com.metrolist.music.viewmodels.CachePlaylistViewModel$$ExternalSyntheticLambda0;
import com.metrolist.music.viewmodels.CommunityPlaylistItem;
import com.metrolist.music.viewmodels.HomeViewModel;
import com.metrolist.music.viewmodels.HomeViewModel$2$1;
import com.metrolist.music.viewmodels.LibraryAlbumsViewModel;
import com.metrolist.music.viewmodels.LibraryArtistsViewModel;
import com.metrolist.music.viewmodels.LibraryMixViewModel;
import com.metrolist.music.viewmodels.LibraryPodcastsViewModel;
import com.metrolist.music.viewmodels.LibrarySongsViewModel;
import com.metrolist.music.viewmodels.LibrarySongsViewModel$syncLikedSongs$1;
import com.metrolist.music.viewmodels.LocalPlaylistViewModel;
import com.metrolist.music.viewmodels.LyricsMenuViewModel;
import com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel;
import com.metrolist.music.viewmodels.OnlineSearchViewModel;
import com.metrolist.music.viewmodels.OnlineSearchViewModel$1$1;
import io.ktor.client.HttpClient$$ExternalSyntheticLambda1;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.text.Regex;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreKt$get$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $key;
    public final /* synthetic */ byte $r8$classId;
    public Object $this_get;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreKt$get$1(ArtistViewModel artistViewModel, boolean z, String str, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 21;
        this.$this_get = artistViewModel;
        this.label = z;
        this.$key = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.$key;
        switch (b) {
            case 0:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 0);
            case 1:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 1);
            case 2:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 2);
            case 3:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 3);
            case 4:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 4);
            case 5:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 5);
            case 6:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 6);
            case 7:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 7);
            case 8:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 8);
            case 9:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 9);
            case 10:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 10);
            case 11:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 11);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                return new DataStoreKt$get$1(this.label, (LibrarySongsViewModel) this.$this_get, (MutableState) obj2, continuation);
            case 13:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 13);
            case 14:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 14);
            case 15:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 15);
            case 16:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 16);
            case 17:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 17);
            case 18:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 18);
            case 19:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 19);
            case 20:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 20);
            case 21:
                return new DataStoreKt$get$1((ArtistViewModel) this.$this_get, this.label, (String) obj2, continuation);
            case 22:
                return new DataStoreKt$get$1((BrowseViewModel) obj2, continuation);
            case 23:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 23);
            case 24:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 24);
            case 25:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 25);
            case 26:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 26);
            case 27:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 27);
            case 28:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 28);
            default:
                return new DataStoreKt$get$1(this.$this_get, obj2, continuation, (byte) 29);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 1:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 2:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 3:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 4:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 5:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 6:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 7:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 8:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 9:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 10:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 11:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 13:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 14:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 15:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 16:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 17:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 18:
                ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return coroutineSingletons;
            case 19:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 20:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 21:
                ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            case 22:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 23:
                ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return coroutineSingletons;
            case 24:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 25:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            case 26:
                ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return coroutineSingletons;
            case 27:
                ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return coroutineSingletons;
            case 28:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
            default:
                return ((DataStoreKt$get$1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objFirst;
        Object objM989queue0E7RQCE$default;
        SongItem songItem;
        Object objM1524getAllReleasesgIAlus;
        Bitmap bitmapCreateFallbackBitmap;
        Object objExecute;
        byte b;
        Object obj2;
        BrowseViewModel browseViewModel;
        Object objM998artistgIAlus;
        Object objM1025playlistgIAlus;
        Object objFirst2;
        byte b2 = this.$r8$classId;
        byte b3 = 8;
        byte b4 = 10;
        byte b5 = 3;
        byte b6 = 4;
        byte b7 = 2;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj3 = this.$key;
        char c = 1;
        char c2 = 1;
        char c3 = 1;
        LocalDateTime localDateTimeNow = null;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        switch (b2) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    Flow data = ((DataStore) this.$this_get).getData();
                    this.label = true;
                    objFirst = StateFlowKt.first(data, this);
                    if (objFirst == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objFirst = obj;
                }
                return ((MutablePreferences) objFirst).get((Preferences$Key) obj3);
            case 1:
                Song song = (Song) this.$this_get;
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube = YouTube.INSTANCE;
                    List listListOf = CollectionsKt__IterablesKt.listOf(song.song.id);
                    this.label = true;
                    objM989queue0E7RQCE$default = YouTube.m989queue0E7RQCE$default(listListOf, this);
                    if (objM989queue0E7RQCE$default == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM989queue0E7RQCE$default = ((Result) obj).value;
                }
                MusicDatabase musicDatabase = (MusicDatabase) obj3;
                if ((objM989queue0E7RQCE$default instanceof Result.Failure) || (songItem = (SongItem) CollectionsKt.firstOrNull((List) objM989queue0E7RQCE$default)) == null) {
                    return unit;
                }
                musicDatabase.transaction(new SongMenuKt$$ExternalSyntheticLambda4(song, songItem, b3));
                return unit;
            case 2:
                AlbumItem albumItem = (AlbumItem) obj3;
                MusicDatabase musicDatabase2 = (MusicDatabase) this.$this_get;
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowAlbum = musicDatabase2.album(albumItem.id);
                HomeViewModel$2$1 homeViewModel$2$1 = new HomeViewModel$2$1(albumItem, musicDatabase2, (byte) 7);
                this.label = true;
                return flowAlbum.collect(homeViewModel$2$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 3:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    if (!((BottomSheetState) this.$this_get).isExpanded()) {
                        return unit;
                    }
                    this.label = true;
                    if (AwaitKt.delay(100L, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                try {
                    FocusRequester.m415requestFocus3ESFkO8$default((FocusRequester) obj3);
                    return unit;
                } catch (Exception unused) {
                    return unit;
                }
            case 4:
                State state = (State) obj3;
                boolean z5 = this.label;
                if (z5) {
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (((Number) state.getValue()).intValue() == -1) {
                    return unit;
                }
                LazyListState lazyListState = (LazyListState) this.$this_get;
                int iIntValue = ((Number) state.getValue()).intValue();
                this.label = true;
                return LazyListState.scrollToItem$default(lazyListState, iIntValue, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 5:
                PlayerConnection playerConnection = (PlayerConnection) obj3;
                boolean z6 = this.label;
                if (z6) {
                    if (z6) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                LazyListState lazyListState2 = (LazyListState) this.$this_get;
                ExoPlayerImpl playerSafe = playerConnection.getPlayerSafe();
                playerSafe.verifyApplicationThread();
                int currentMediaItemIndex = playerSafe.shuffleModeEnabled ? playerConnection.getPlayerSafe().getCurrentMediaItemIndex() : 0;
                this.label = true;
                CallbackWrapper callbackWrapper = LazyListState.Saver;
                return lazyListState2.animateScrollToItem(currentMediaItemIndex, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 6:
                boolean z7 = this.label;
                if (z7) {
                    if (z7) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowAlbumWithSongs = ((MusicDatabase) this.$this_get).albumWithSongs(((Album) ((LocalItem) obj3)).album.id);
                this.label = true;
                Object objFirst3 = StateFlowKt.first(flowAlbumWithSongs, this);
                return objFirst3 == coroutineSingletons ? coroutineSingletons : objFirst3;
            case 7:
                boolean z8 = this.label;
                if (z8) {
                    if (z8) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                SafeFlow safeFlowSnapshotFlow = Stack.snapshotFlow(new LazyListKt$$ExternalSyntheticLambda0((LazyListState) this.$this_get, b6));
                final ArtistItemsViewModel artistItemsViewModel = (ArtistItemsViewModel) obj3;
                final Object[] objArr10 = objArr == true ? 1 : 0;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt$ArtistItemsScreen$1$1$2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj4, Continuation continuation) {
                        byte b8 = objArr10;
                        ArtistItemsViewModel artistItemsViewModel2 = artistItemsViewModel;
                        Unit unit2 = Unit.INSTANCE;
                        switch (b8) {
                            case 0:
                                if (((Boolean) obj4).booleanValue()) {
                                    AwaitKt.launch$default(ViewModelKt.getViewModelScope(artistItemsViewModel2), null, null, new DiscordRpcManager.AnonymousClass4(artistItemsViewModel2, null, (byte) 12), 3);
                                }
                                break;
                            default:
                                if (((Boolean) obj4).booleanValue()) {
                                    AwaitKt.launch$default(ViewModelKt.getViewModelScope(artistItemsViewModel2), null, null, new DiscordRpcManager.AnonymousClass4(artistItemsViewModel2, null, (byte) 12), 3);
                                }
                                break;
                        }
                        return unit2;
                    }
                };
                this.label = true;
                return safeFlowSnapshotFlow.collect(flowCollector, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 8:
                boolean z9 = this.label;
                if (z9) {
                    if (z9) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                SafeFlow safeFlowSnapshotFlow2 = Stack.snapshotFlow(new ThumbnailKt$$ExternalSyntheticLambda3((LazyGridState) this.$this_get, (byte) 4));
                final ArtistItemsViewModel artistItemsViewModel2 = (ArtistItemsViewModel) obj3;
                final char c4 = c == true ? 1 : 0;
                FlowCollector flowCollector2 = new FlowCollector() { // from class: com.metrolist.music.ui.screens.artist.ArtistItemsScreenKt$ArtistItemsScreen$1$1$2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj4, Continuation continuation) {
                        byte b8 = c4;
                        ArtistItemsViewModel artistItemsViewModel3 = artistItemsViewModel2;
                        Unit unit2 = Unit.INSTANCE;
                        switch (b8) {
                            case 0:
                                if (((Boolean) obj4).booleanValue()) {
                                    AwaitKt.launch$default(ViewModelKt.getViewModelScope(artistItemsViewModel3), null, null, new DiscordRpcManager.AnonymousClass4(artistItemsViewModel3, null, (byte) 12), 3);
                                }
                                break;
                            default:
                                if (((Boolean) obj4).booleanValue()) {
                                    AwaitKt.launch$default(ViewModelKt.getViewModelScope(artistItemsViewModel3), null, null, new DiscordRpcManager.AnonymousClass4(artistItemsViewModel3, null, (byte) 12), 3);
                                }
                                break;
                        }
                        return unit2;
                    }
                };
                this.label = true;
                return safeFlowSnapshotFlow2.collect(flowCollector2, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 9:
                boolean z10 = this.label;
                if (z10) {
                    if (z10) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                EQProfileRepository eQProfileRepository = ((EQViewModel) this.$this_get).eqProfileRepository;
                this.label = true;
                eQProfileRepository.getClass();
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                Object objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new EQProfileRepository$deleteProfile$2(eQProfileRepository, (String) obj3, objArr4 == true ? 1 : 0, objArr2 == true ? 1 : 0), this);
                if (objWithContext != coroutineSingletons) {
                    objWithContext = unit;
                }
                return objWithContext == coroutineSingletons ? coroutineSingletons : unit;
            case 10:
                boolean z11 = this.label;
                if (!z11) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    if (AwaitKt.delay(300L, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z11) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ((WizardViewModel) this.$this_get).searchModels((String) obj3);
                return unit;
            case 11:
                boolean z12 = this.label;
                if (!z12) {
                    ResultKt.throwOnFailure(obj);
                    LibraryPodcastsViewModel libraryPodcastsViewModel = (LibraryPodcastsViewModel) this.$this_get;
                    this.label = true;
                    if (libraryPodcastsViewModel.refreshAll(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z12) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ((MutableState) obj3).setValue(Boolean.FALSE);
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                LibrarySongsViewModel librarySongsViewModel = (LibrarySongsViewModel) this.$this_get;
                ResultKt.throwOnFailure(obj);
                if (this.label) {
                    int iOrdinal = ((SongFilter) ((MutableState) obj3).getValue()).ordinal();
                    if (iOrdinal == 0) {
                        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(librarySongsViewModel);
                        DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                        AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new LibrarySongsViewModel$syncLikedSongs$1(librarySongsViewModel, objArr5 == true ? 1 : 0, c2 == true ? 1 : 0), 2);
                    } else if (iOrdinal == 1) {
                        CloseableCoroutineScope viewModelScope2 = ViewModelKt.getViewModelScope(librarySongsViewModel);
                        DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                        AwaitKt.launch$default(viewModelScope2, DefaultIoScheduler.INSTANCE, null, new LibrarySongsViewModel$syncLikedSongs$1(librarySongsViewModel, objArr6 == true ? 1 : 0, objArr3 == true ? 1 : 0), 2);
                    } else if (iOrdinal == 3) {
                        CloseableCoroutineScope viewModelScope3 = ViewModelKt.getViewModelScope(librarySongsViewModel);
                        DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                        AwaitKt.launch$default(viewModelScope3, DefaultIoScheduler.INSTANCE, null, new LibrarySongsViewModel$syncLikedSongs$1(librarySongsViewModel, objArr7 == true ? 1 : 0, b7), 2);
                    }
                }
                return unit;
            case 13:
                boolean z13 = this.label;
                if (!z13) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return SnackbarHostState.showSnackbar$default((SnackbarHostState) this.$this_get, (String) obj3, null, this, 14) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z13) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 14:
                boolean z14 = this.label;
                if (z14) {
                    if (!z14) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Object obj4 = ((Result) obj).value;
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                String str = ((PlaylistEntity) this.$this_get).browseId;
                if (str == null) {
                    return unit;
                }
                YouTube youTube2 = YouTube.INSTANCE;
                this.label = true;
                return youTube2.m1036renamePlaylist0E7RQCE(str, (String) obj3, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 15:
                boolean z15 = this.label;
                if (z15) {
                    if (z15) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                SafeFlow safeFlowSnapshotFlow3 = Stack.snapshotFlow(new LazyListKt$$ExternalSyntheticLambda0((LazyListState) this.$this_get, b3));
                OnlineSearchViewModel$1$1 onlineSearchViewModel$1$1 = new OnlineSearchViewModel$1$1((OnlineSearchViewModel) obj3, (byte) 1);
                this.label = true;
                return safeFlowSnapshotFlow3.collect(onlineSearchViewModel$1$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 16:
                boolean z16 = this.label;
                if (z16) {
                    if (z16) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowDebounce = StateFlowKt.debounce(Stack.snapshotFlow(new NavDestinationImpl$$ExternalSyntheticLambda2((String) this.$this_get, b7)), 300L);
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2((OnlineSearchSuggestionViewModel) obj3, objArr8 == true ? 1 : 0, b4);
                this.label = true;
                return StateFlowKt.collectLatest(flowDebounce, interruptibleKt$runInterruptible$2, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 17:
                MutableState mutableState = (MutableState) obj3;
                boolean z17 = this.label;
                if (!z17) {
                    ResultKt.throwOnFailure(obj);
                    Updater updater = Updater.INSTANCE;
                    this.label = true;
                    objM1524getAllReleasesgIAlus = updater.m1524getAllReleasesgIAlus(this);
                    if (objM1524getAllReleasesgIAlus == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z17) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1524getAllReleasesgIAlus = ((Result) obj).value;
                }
                MutableState mutableState2 = (MutableState) this.$this_get;
                if (!(objM1524getAllReleasesgIAlus instanceof Result.Failure)) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj5 : (List) objM1524getAllReleasesgIAlus) {
                        Updater updater2 = Updater.INSTANCE;
                        if (Updater.compareVersions("4.1.0", ((ReleaseInfo) obj5).tagName) >= 0) {
                            arrayList.add(obj5);
                        }
                    }
                    Regex regex = ChangelogScreenKt.markdownLinkRegex;
                    mutableState2.setValue(arrayList);
                    mutableState.setValue(Boolean.FALSE);
                }
                if (Result.m1866exceptionOrNullimpl(objM1524getAllReleasesgIAlus) == null) {
                    return unit;
                }
                Regex regex2 = ChangelogScreenKt.markdownLinkRegex;
                mutableState.setValue(Boolean.FALSE);
                return unit;
            case 18:
                boolean z18 = this.label;
                if (z18) {
                    if (!z18) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ReadonlySharedFlow readonlySharedFlow = ((ListenTogetherManager) this.$this_get).events;
                InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$3 = new InterruptibleKt$runInterruptible$2((Context) obj3, objArr9 == true ? 1 : 0, (byte) 12);
                readonlySharedFlow.getClass();
                this.label = true;
                if (StateFlowKt.collectLatest(readonlySharedFlow, interruptibleKt$runInterruptible$3, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("SharedFlow never completes, this call should never return.");
                return null;
            case 19:
                List list = (List) this.$this_get;
                boolean z19 = this.label;
                if (z19) {
                    if (z19) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (list.isEmpty()) {
                    return unit;
                }
                int size = list.size() - 1;
                this.label = true;
                CallbackWrapper callbackWrapper2 = LazyListState.Saver;
                return ((LazyListState) obj3).animateScrollToItem(size, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 20:
                MusicService musicService = (MusicService) ((Splitter) this.$this_get).trimmer;
                boolean z20 = this.label;
                try {
                    if (!z20) {
                        ResultKt.throwOnFailure(obj);
                        ImageRequest.Builder builder = new ImageRequest.Builder(musicService);
                        builder.data = (Uri) obj3;
                        ImageRequests_androidKt.allowHardware(builder);
                        ImageRequest imageRequestBuild = builder.build();
                        RealImageLoader realImageLoader = SingletonImageLoader.get(musicService);
                        this.label = true;
                        objExecute = realImageLoader.execute(imageRequestBuild, this);
                        if (objExecute == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z20) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objExecute = obj;
                    }
                    ImageResult imageResult = (ImageResult) objExecute;
                    if (imageResult == null) {
                        b = -1;
                    } else if (imageResult instanceof ErrorResult) {
                        b = 0;
                    } else {
                        b = imageResult instanceof SuccessResult ? (byte) 1 : (byte) -2;
                    }
                    if (b == 0) {
                        bitmapCreateFallbackBitmap = Splitter.createFallbackBitmap();
                    } else {
                        if (b != 1) {
                            throw new HttpException();
                        }
                        try {
                            bitmapCreateFallbackBitmap = Splitter.createIndependentCopy(UriKt.toBitmap$default(((SuccessResult) imageResult).image));
                        } catch (Exception unused2) {
                            Timber.Forest.tag("CoilBitmapLoader");
                            ConnectionPool.w$1(new Object[0]);
                            bitmapCreateFallbackBitmap = Splitter.createFallbackBitmap();
                        }
                    }
                    break;
                } catch (Exception unused3) {
                    Timber.Forest.tag("CoilBitmapLoader");
                    ConnectionPool.w$1(new Object[0]);
                    bitmapCreateFallbackBitmap = Splitter.createFallbackBitmap();
                }
                return bitmapCreateFallbackBitmap;
            case 21:
                String str2 = (String) obj3;
                boolean z21 = this.label;
                ResultKt.throwOnFailure(obj);
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                ArtistViewModel artistViewModel = (ArtistViewModel) this.$this_get;
                ReadonlyStateFlow readonlyStateFlow = artistViewModel.libraryArtist;
                MusicDatabase musicDatabase3 = artistViewModel.database;
                Artist artist = (Artist) readonlyStateFlow.$$delegate_0.getValue();
                ArtistEntity artistEntity = artist != null ? artist.artist : null;
                Objects.toString(artistEntity);
                ConnectionPool.d(new Object[0]);
                if (artistEntity != null) {
                    if (z21 && (localDateTimeNow = artistEntity.bookmarkedAt) == null) {
                        localDateTimeNow = LocalDateTime.now();
                    }
                    LocalDateTime localDateTime = localDateTimeNow;
                    ArtistEntity artistEntityCopy$default = ArtistEntity.copy$default(artistEntity, null, null, null, null, localDateTime, (z21 && artistViewModel.isPodcastChannel) ? true : artistEntity.isPodcastChannel, null, 351);
                    Objects.toString(localDateTime);
                    ConnectionPool.d(new Object[0]);
                    musicDatabase3.getClass();
                    musicDatabase3.$$delegate_0.update(artistEntityCopy$default);
                } else if (z21) {
                    ConnectionPool.d(new Object[0]);
                    ArtistPage artistPage = (ArtistPage) artistViewModel.artistPage$delegate.getValue();
                    if (artistPage != null) {
                        ArtistItem artistItem = artistPage.artist;
                        String str3 = artistViewModel.artistId;
                        ArtistNameAliases artistNameAliases = ArtistNameAliases.INSTANCE;
                        ArtistEntity artistEntity2 = new ArtistEntity(str3, ArtistNameAliases.resolve(str3, artistItem.title), artistItem.thumbnail, artistItem.channelId, LocalDateTime.now(), artistViewModel.isPodcastChannel, null, 336);
                        musicDatabase3.getClass();
                        musicDatabase3.$$delegate_0.insert(artistEntity2);
                        ConnectionPool.d(new Object[0]);
                    } else {
                        ConnectionPool.d(new Object[0]);
                    }
                } else {
                    ConnectionPool.d(new Object[0]);
                }
                ConnectionPool.d(new Object[0]);
                SyncUtils syncUtils = artistViewModel.syncUtils;
                syncUtils.getClass();
                str2.getClass();
                syncUtils.enqueue(new SyncOperation.SubscribeChannel(str2, z21));
                return unit;
            case 22:
                boolean z22 = this.label;
                if (!z22) {
                    ResultKt.throwOnFailure(obj);
                    BrowseViewModel browseViewModel2 = (BrowseViewModel) obj3;
                    String str4 = browseViewModel2.browseId;
                    if (str4 == null) {
                        return unit;
                    }
                    YouTube youTube3 = YouTube.INSTANCE;
                    this.$this_get = browseViewModel2;
                    this.label = true;
                    Object objM1001browse0E7RQCE = youTube3.m1001browse0E7RQCE(str4, null, this);
                    if (objM1001browse0E7RQCE == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj2 = objM1001browse0E7RQCE;
                    browseViewModel = browseViewModel2;
                } else {
                    if (!z22) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    browseViewModel = (BrowseViewModel) this.$this_get;
                    ResultKt.throwOnFailure(obj);
                    obj2 = ((Result) obj).value;
                }
                if (!(obj2 instanceof Result.Failure)) {
                    BrowseResult browseResult = (BrowseResult) obj2;
                    browseViewModel.title.setValue(browseResult.title);
                    List list2 = browseResult.items;
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        CollectionsKt__MutableCollectionsKt.addAll(((BrowseResult.Item) it.next()).items, arrayList2);
                    }
                    StateFlowImpl stateFlowImpl = browseViewModel.items;
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, arrayList2);
                }
                Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj2);
                if (thM1866exceptionOrNullimpl == null) {
                    return unit;
                }
                thM1866exceptionOrNullimpl.printStackTrace();
                return unit;
            case 23:
                boolean z23 = this.label;
                if (z23) {
                    if (!z23) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                HomeViewModel homeViewModel = (HomeViewModel) this.$this_get;
                ReadonlyStateFlow readonlyStateFlow2 = homeViewModel.networkConnectivity.networkStatus;
                HomeViewModel$2$1 homeViewModel$2$2 = new HomeViewModel$2$1((Ref$BooleanRef) obj3, homeViewModel, (byte) 0);
                this.label = true;
                if (readonlyStateFlow2.$$delegate_0.collect(homeViewModel$2$2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            case 24:
                Artist artist2 = (Artist) this.$this_get;
                boolean z24 = this.label;
                if (!z24) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube4 = YouTube.INSTANCE;
                    String str5 = artist2.artist.id;
                    this.label = true;
                    objM998artistgIAlus = youTube4.m998artistgIAlus(str5, this);
                    if (objM998artistgIAlus == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z24) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM998artistgIAlus = ((Result) obj).value;
                }
                List list3 = (List) obj3;
                if (objM998artistgIAlus instanceof Result.Failure) {
                    return unit;
                }
                Iterator it2 = ((ArtistPage) objM998artistgIAlus).sections.iterator();
                while (it2.hasNext()) {
                    List list4 = ((ArtistSection) it2.next()).items;
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj6 : list4) {
                        if (obj6 instanceof PlaylistItem) {
                            arrayList3.add(obj6);
                        }
                    }
                    int size2 = arrayList3.size();
                    int i = 0;
                    while (i < size2) {
                        Object obj7 = arrayList3.get(i);
                        i++;
                        PlaylistItem playlistItem = (PlaylistItem) obj7;
                        com.metrolist.innertube.models.Artist artist3 = playlistItem.author;
                        String str6 = playlistItem.id;
                        if (!Intrinsics.areEqual(artist3 != null ? artist3.name : null, "YouTube Music")) {
                            if (!Intrinsics.areEqual(artist3 != null ? artist3.name : null, "YouTube")) {
                                if (!Intrinsics.areEqual(artist3 != null ? artist3.name : null, "Playlist")) {
                                    if (!Intrinsics.areEqual(artist3 != null ? artist3.name : null, artist2.artist.name) && !StringsKt__StringsJVMKt.startsWith(str6, "RD", false) && !StringsKt__StringsJVMKt.startsWith(str6, "OLAK", false)) {
                                        list3.add(playlistItem);
                                    }
                                }
                            }
                        }
                    }
                }
                return unit;
            case 25:
                PlaylistItem playlistItem2 = (PlaylistItem) this.$this_get;
                boolean z25 = this.label;
                if (!z25) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube5 = YouTube.INSTANCE;
                    String str7 = playlistItem2.id;
                    this.label = true;
                    objM1025playlistgIAlus = youTube5.m1025playlistgIAlus(str7, this);
                    if (objM1025playlistgIAlus == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z25) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1025playlistgIAlus = ((Result) obj).value;
                }
                List list5 = (List) obj3;
                if (objM1025playlistgIAlus instanceof Result.Failure) {
                    return unit;
                }
                PlaylistPage playlistPage = (PlaylistPage) objM1025playlistgIAlus;
                List listTake = CollectionsKt.take(playlistPage.songs, 10);
                if (listTake.isEmpty()) {
                    return unit;
                }
                String str8 = playlistPage.playlist.songCountText;
                if (str8 == null) {
                    str8 = playlistItem2.songCountText;
                }
                playlistItem2.getClass();
                list5.add(new CommunityPlaylistItem(PlaylistItem.copy$default(playlistItem2, null, str8, 4087), listTake));
                return unit;
            case 26:
                boolean z26 = this.label;
                if (z26) {
                    if (!z26) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ReadonlyStateFlow readonlyStateFlow3 = ((LibraryAlbumsViewModel) this.$this_get).allAlbums;
                LibraryMixViewModel.AnonymousClass1.C00111 c00111 = new LibraryMixViewModel.AnonymousClass1.C00111((MusicDatabase) obj3, c3 == true ? 1 : 0);
                this.label = true;
                if (readonlyStateFlow3.$$delegate_0.collect(c00111, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            case 27:
                boolean z27 = this.label;
                if (z27) {
                    if (!z27) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                ReadonlyStateFlow readonlyStateFlow4 = ((LibraryArtistsViewModel) this.$this_get).allArtists;
                LibraryMixViewModel.AnonymousClass1.C00111 c00112 = new LibraryMixViewModel.AnonymousClass1.C00111((MusicDatabase) obj3, b7);
                this.label = true;
                if (readonlyStateFlow4.$$delegate_0.collect(c00112, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                return null;
            case 28:
                boolean z28 = this.label;
                if (!z28) {
                    ResultKt.throwOnFailure(obj);
                    ReadonlyStateFlow readonlyStateFlow5 = ((LocalPlaylistViewModel) this.$this_get).playlistSongs;
                    this.label = true;
                    objFirst2 = StateFlowKt.first(readonlyStateFlow5, this);
                    if (objFirst2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z28) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objFirst2 = obj;
                }
                ((MusicDatabase) obj3).transaction(new CachePlaylistViewModel$$ExternalSyntheticLambda0(CollectionsKt.sortedWith((Iterable) objFirst2, RegexKt.compareBy(new HttpClient$$ExternalSyntheticLambda1(b5), new HttpClient$$ExternalSyntheticLambda1(b6))), b7));
                return unit;
            default:
                boolean z29 = this.label;
                if (!z29) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    Object lyrics = ((LyricsMenuViewModel) this.$this_get).lyricsHelper.getLyrics((MediaMetadata) obj3, this);
                    return lyrics == coroutineSingletons ? coroutineSingletons : lyrics;
                }
                if (z29) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreKt$get$1(BrowseViewModel browseViewModel, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 22;
        this.$key = browseViewModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataStoreKt$get$1(Object obj, Object obj2, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$this_get = obj;
        this.$key = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreKt$get$1(boolean z, LibrarySongsViewModel librarySongsViewModel, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 12;
        this.label = z;
        this.$this_get = librarySongsViewModel;
        this.$key = mutableState;
    }
}
