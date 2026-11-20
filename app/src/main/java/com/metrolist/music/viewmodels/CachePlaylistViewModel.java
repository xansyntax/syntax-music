package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.datasource.cache.SimpleCache;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.DownloadUtil$getDownload$$inlined$map$1;
import com.metrolist.music.utils.UtilsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StartedWhileSubscribed;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/metrolist/music/viewmodels/CachePlaylistViewModel;", "Landroidx/lifecycle/ViewModel;", "Inputs", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class CachePlaylistViewModel extends ViewModel {
    public final ReadonlyStateFlow cachedSongs;
    public final MusicDatabase database;
    public final SimpleCache playerCache;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Inputs {
        public final List flagged;
        public final boolean hideExplicit;
        public final boolean hideVideoSongs;

        public Inputs(List list, boolean z, boolean z2) {
            list.getClass();
            this.flagged = list;
            this.hideExplicit = z;
            this.hideVideoSongs = z2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Inputs)) {
                return false;
            }
            Inputs inputs = (Inputs) obj;
            return Intrinsics.areEqual(this.flagged, inputs.flagged) && this.hideExplicit == inputs.hideExplicit && this.hideVideoSongs == inputs.hideVideoSongs;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.hideVideoSongs) + IntIntPair$$ExternalSyntheticOutline0.m(this.flagged.hashCode() * 31, this.hideExplicit, 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Inputs(flagged=");
            sb.append(this.flagged);
            sb.append(", hideExplicit=");
            sb.append(this.hideExplicit);
            sb.append(", hideVideoSongs=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.hideVideoSongs, ")");
        }
    }

    public CachePlaylistViewModel(Context context, MusicDatabase musicDatabase, SimpleCache simpleCache) {
        musicDatabase.getClass();
        simpleCache.getClass();
        this.database = musicDatabase;
        this.playerCache = simpleCache;
        DownloadUtil$getDownload$$inlined$map$1 downloadUtil$getDownload$$inlined$map$1Combine = StateFlowKt.combine(musicDatabase.$$delegate_0.cachePlaylistSongs(), StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 1)), StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 2)), CachePlaylistViewModel$cachedSongs$3.INSTANCE);
        HomeViewModel.C02082 c02082 = new HomeViewModel.C02082(this, null);
        int i = FlowKt__MergeKt.$r8$clinit;
        ChannelFlowTransformLatest channelFlowTransformLatestTransformLatest = FlowKt__MergeKt.transformLatest(downloadUtil$getDownload$$inlined$map$1Combine, new FlowKt__ZipKt$combine$1$1(c02082, (Continuation) null, (byte) 1));
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        this.cachedSongs = StateFlowKt.stateIn(StateFlowKt.flowOn(channelFlowTransformLatestTransformLatest, DefaultIoScheduler.INSTANCE), ViewModelKt.getViewModelScope(this), new StartedWhileSubscribed(5000L, Long.MAX_VALUE), EmptyList.INSTANCE);
    }

    public final void removeSongsFromCache(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.playerCache.removeResource((String) it.next());
        }
        this.database.query(new CachePlaylistViewModel$$ExternalSyntheticLambda0(list, (byte) 0));
    }
}
