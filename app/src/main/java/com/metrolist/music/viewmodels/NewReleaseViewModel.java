package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.compose.foundation.MutatorMutex;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.metrolist.music.db.MusicDatabase;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/NewReleaseViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class NewReleaseViewModel extends ViewModel {
    public final StateFlowImpl _newReleaseAlbums;
    public final Context context;
    public final ReadonlyStateFlow newReleaseAlbums;

    public NewReleaseViewModel(Context context, MusicDatabase musicDatabase) {
        musicDatabase.getClass();
        this.context = context;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(EmptyList.INSTANCE);
        this._newReleaseAlbums = stateFlowImplMutableStateFlow;
        this.newReleaseAlbums = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new MutatorMutex.AnonymousClass2(musicDatabase, this, (Continuation) null), 3);
    }
}
