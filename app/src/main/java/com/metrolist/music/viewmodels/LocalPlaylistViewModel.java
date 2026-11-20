package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/LocalPlaylistViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class LocalPlaylistViewModel extends ViewModel {
    public final StateFlowImpl _onlinePlaylist;
    public final StateFlowImpl onlinePlaylist;
    public final ReadonlyStateFlow playlist;
    public final String playlistId;
    public final ReadonlyStateFlow playlistSongs;

    public LocalPlaylistViewModel(Context context, SavedStateHandle savedStateHandle, MusicDatabase musicDatabase) {
        musicDatabase.getClass();
        savedStateHandle.getClass();
        Object obj = savedStateHandle.get("playlistId");
        obj.getClass();
        String str = (String) obj;
        this.playlistId = str;
        DatabaseDao databaseDao = musicDatabase.$$delegate_0;
        Flow flowPlaylist = databaseDao.playlist(str);
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        StartedLazily startedLazily = SharingStarted.Companion.Lazily;
        Continuation continuation = null;
        this.playlist = StateFlowKt.stateIn(flowPlaylist, viewModelScope, startedLazily, null);
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._onlinePlaylist = stateFlowImplMutableStateFlow;
        this.onlinePlaylist = stateFlowImplMutableStateFlow;
        this.playlistSongs = StateFlowKt.stateIn(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(databaseDao.playlistSongs(str), StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 18)), new ArtistViewModel$isChannelSubscribed$1(3, continuation, (byte) 2), (byte) 0), ViewModelKt.getViewModelScope(this), startedLazily, EmptyList.INSTANCE);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DataStoreKt$get$1((Object) this, (Object) musicDatabase, continuation, (byte) 28), 3);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ArtistViewModel.AnonymousClass1(this, continuation, (byte) 8), 3);
    }
}
