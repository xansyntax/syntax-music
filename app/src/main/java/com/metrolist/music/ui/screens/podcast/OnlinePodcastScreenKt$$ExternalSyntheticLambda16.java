package com.metrolist.music.ui.screens.podcast;

import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.db.entities.PodcastEntity;
import com.metrolist.music.viewmodels.OnlinePodcastViewModel;
import dev.chrisbanes.haze.HazeSourceNode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OnlinePodcastScreenKt$$ExternalSyntheticLambda16 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ OnlinePodcastViewModel f$0;

    public /* synthetic */ OnlinePodcastScreenKt$$ExternalSyntheticLambda16(OnlinePodcastViewModel onlinePodcastViewModel, byte b) {
        this.$r8$classId = b;
        this.f$0 = onlinePodcastViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String str;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                OnlinePodcastViewModel onlinePodcastViewModel = this.f$0;
                PodcastItem podcastItem = (PodcastItem) onlinePodcastViewModel.podcast.getValue();
                if (podcastItem != null) {
                    Artist artist = podcastItem.author;
                    PodcastEntity podcastEntity = (PodcastEntity) onlinePodcastViewModel.libraryPodcast.$$delegate_0.getValue();
                    boolean z = !((podcastEntity == null || podcastEntity.bookmarkedAt == null) ? false : true);
                    String str2 = podcastItem.channelId;
                    if (str2 != null) {
                        str = str2;
                    } else if (artist != null) {
                        str2 = artist.id;
                        str = str2;
                    } else {
                        str = null;
                    }
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(onlinePodcastViewModel);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new InnerTube$feedback$2(podcastEntity, onlinePodcastViewModel, podcastItem, str, z, (Continuation) null), 2);
                } else {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                }
                break;
            default:
                OnlinePodcastViewModel onlinePodcastViewModel2 = this.f$0;
                CloseableCoroutineScope viewModelScope2 = ViewModelKt.getViewModelScope(onlinePodcastViewModel2);
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                AwaitKt.launch$default(viewModelScope2, DefaultIoScheduler.INSTANCE, null, new HazeSourceNode.AnonymousClass1(onlinePodcastViewModel2, null, (byte) 5), 2);
                break;
        }
        return unit;
    }
}
