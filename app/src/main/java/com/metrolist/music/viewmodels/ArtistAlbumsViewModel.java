package com.metrolist.music.viewmodels;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.music.db.MusicDatabase;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/ArtistAlbumsViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ArtistAlbumsViewModel extends ViewModel {
    public final ReadonlyStateFlow albums;
    public final ReadonlyStateFlow artist;

    public ArtistAlbumsViewModel(MusicDatabase musicDatabase, SavedStateHandle savedStateHandle) {
        musicDatabase.getClass();
        savedStateHandle.getClass();
        Object obj = savedStateHandle.get("artistId");
        obj.getClass();
        String str = (String) obj;
        Flow flowArtist = musicDatabase.$$delegate_0.artist(str);
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        StartedLazily startedLazily = SharingStarted.Companion.Lazily;
        this.artist = StateFlowKt.stateIn(flowArtist, viewModelScope, startedLazily, null);
        this.albums = StateFlowKt.stateIn(musicDatabase.artistAlbumsPreview(str), ViewModelKt.getViewModelScope(this), startedLazily, EmptyList.INSTANCE);
    }
}
