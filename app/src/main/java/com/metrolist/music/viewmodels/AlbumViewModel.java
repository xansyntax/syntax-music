package com.metrolist.music.viewmodels;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import coil3.compose.AsyncImagePainter;
import com.metrolist.music.db.MusicDatabase;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/AlbumViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AlbumViewModel extends ViewModel {
    public final String albumId;
    public final ReadonlyStateFlow albumWithSongs;
    public final StateFlowImpl otherVersions;
    public final StateFlowImpl playlistId;

    public AlbumViewModel(MusicDatabase musicDatabase, SavedStateHandle savedStateHandle) {
        musicDatabase.getClass();
        savedStateHandle.getClass();
        Object obj = savedStateHandle.get("albumId");
        obj.getClass();
        String str = (String) obj;
        this.albumId = str;
        this.playlistId = StateFlowKt.MutableStateFlow("");
        this.albumWithSongs = StateFlowKt.stateIn(musicDatabase.$$delegate_0.albumWithSongs(str), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.Eagerly, null);
        this.otherVersions = StateFlowKt.MutableStateFlow(EmptyList.INSTANCE);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AsyncImagePainter.AnonymousClass1(musicDatabase, this, null, (byte) 26), 3);
    }
}
