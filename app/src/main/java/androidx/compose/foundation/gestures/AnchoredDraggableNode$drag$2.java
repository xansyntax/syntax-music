package androidx.compose.foundation.gestures;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.lifecycle.ViewModel;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.viewmodels.ArtistSongsViewModel$songs$lambda$1$$inlined$map$1;
import com.metrolist.music.viewmodels.AutoPlaylistViewModel;
import com.metrolist.music.viewmodels.HistoryViewModel;
import com.metrolist.music.viewmodels.HistoryViewModel$events$lambda$1$$inlined$map$1;
import com.metrolist.music.viewmodels.OnlinePodcastViewModel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableNode$drag$2 extends SuspendLambda implements Function3 {
    public /* synthetic */ Object $forEachDelta;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableNode$drag$2(InnerTube$feedback$2 innerTube$feedback$2, AnchoredDraggableNode anchoredDraggableNode, Continuation continuation) {
        super(3, continuation);
        this.$r8$classId = (byte) 0;
        this.$forEachDelta = innerTube$feedback$2;
        this.this$0 = anchoredDraggableNode;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj4 = this.this$0;
        switch (b) {
            case 0:
                AnchoredDraggableNode$drag$2 anchoredDraggableNode$drag$2 = new AnchoredDraggableNode$drag$2((InnerTube$feedback$2) this.$forEachDelta, (AnchoredDraggableNode) obj4, (Continuation) obj3);
                anchoredDraggableNode$drag$2.L$0 = (AnchoredDraggableState$anchoredDragScope$1) obj;
                return anchoredDraggableNode$drag$2.invokeSuspend(unit);
            case 1:
                AnchoredDraggableNode$drag$2 anchoredDraggableNode$drag$3 = new AnchoredDraggableNode$drag$2((Continuation) obj3, (ViewModel) obj4, (byte) 1);
                anchoredDraggableNode$drag$3.L$0 = (FlowCollector) obj;
                anchoredDraggableNode$drag$3.$forEachDelta = obj2;
                return anchoredDraggableNode$drag$3.invokeSuspend(unit);
            case 2:
                AnchoredDraggableNode$drag$2 anchoredDraggableNode$drag$4 = new AnchoredDraggableNode$drag$2((Continuation) obj3, (ViewModel) obj4, (byte) 2);
                anchoredDraggableNode$drag$4.L$0 = (FlowCollector) obj;
                anchoredDraggableNode$drag$4.$forEachDelta = obj2;
                return anchoredDraggableNode$drag$4.invokeSuspend(unit);
            default:
                AnchoredDraggableNode$drag$2 anchoredDraggableNode$drag$5 = new AnchoredDraggableNode$drag$2((Continuation) obj3, (ViewModel) obj4, (byte) 3);
                anchoredDraggableNode$drag$5.L$0 = (FlowCollector) obj;
                anchoredDraggableNode$drag$5.$forEachDelta = obj2;
                return anchoredDraggableNode$drag$5.invokeSuspend(unit);
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x014d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Flow artistSongsViewModel$songs$lambda$1$$inlined$map$1;
        Flow safeFlow;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = (AnchoredDraggableState$anchoredDragScope$1) this.L$0;
                InnerTube$feedback$2 innerTube$feedback$2 = (InnerTube$feedback$2) this.$forEachDelta;
                BackHandlerKt$$ExternalSyntheticLambda2 backHandlerKt$$ExternalSyntheticLambda2 = new BackHandlerKt$$ExternalSyntheticLambda2((AnchoredDraggableNode) obj2, anchoredDraggableState$anchoredDragScope$1, (byte) 14);
                this.label = true;
                return innerTube$feedback$2.invoke(backHandlerKt$$ExternalSyntheticLambda2, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                AutoPlaylistViewModel autoPlaylistViewModel = (AutoPlaylistViewModel) obj2;
                MusicDatabase musicDatabase = autoPlaylistViewModel.database;
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Object obj3 = this.$forEachDelta;
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Triple triple = (Triple) obj3;
                Pair pair = (Pair) triple.first;
                boolean zBooleanValue = ((Boolean) triple.second).booleanValue();
                boolean zBooleanValue2 = ((Boolean) triple.third).booleanValue();
                SongSortType songSortType = (SongSortType) pair.first;
                boolean zBooleanValue3 = ((Boolean) pair.second).booleanValue();
                String str = autoPlaylistViewModel.playlist;
                int iHashCode = str.hashCode();
                if (iHashCode != 102974381) {
                    if (iHashCode != 1563991648) {
                        if (iHashCode == 2039141159 && str.equals("downloaded")) {
                            artistSongsViewModel$songs$lambda$1$$inlined$map$1 = new ArtistSongsViewModel$songs$lambda$1$$inlined$map$1(musicDatabase.downloadedSongs(songSortType, zBooleanValue3), zBooleanValue, zBooleanValue2, (byte) 3);
                        } else {
                            artistSongsViewModel$songs$lambda$1$$inlined$map$1 = new SafeFlow((byte) 4, EmptyList.INSTANCE);
                        }
                    } else if (str.equals("uploaded")) {
                        artistSongsViewModel$songs$lambda$1$$inlined$map$1 = new ArtistSongsViewModel$songs$lambda$1$$inlined$map$1(musicDatabase.uploadedSongs(songSortType, zBooleanValue3), zBooleanValue, zBooleanValue2, (byte) 4);
                    } else {
                        artistSongsViewModel$songs$lambda$1$$inlined$map$1 = new SafeFlow((byte) 4, EmptyList.INSTANCE);
                    }
                } else if (str.equals("liked")) {
                    artistSongsViewModel$songs$lambda$1$$inlined$map$1 = new ArtistSongsViewModel$songs$lambda$1$$inlined$map$1(musicDatabase.likedSongs(songSortType, zBooleanValue3), zBooleanValue, zBooleanValue2, (byte) 2);
                } else {
                    artistSongsViewModel$songs$lambda$1$$inlined$map$1 = new SafeFlow((byte) 4, EmptyList.INSTANCE);
                }
                this.L$0 = null;
                this.$forEachDelta = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector, artistSongsViewModel$songs$lambda$1$$inlined$map$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 2:
                HistoryViewModel historyViewModel = (HistoryViewModel) obj2;
                LocalDate localDate = historyViewModel.today;
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                Object obj4 = this.$forEachDelta;
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
                boolean zBooleanValue4 = ((Boolean) obj4).booleanValue();
                MusicDatabase musicDatabase2 = historyViewModel.database;
                LocalDateTime localDateTimeAtStartOfDay = localDate.plusDays(1L).atStartOfDay();
                localDateTimeAtStartOfDay.getClass();
                LocalDateTime localDateTimeAtStartOfDay2 = localDate.atStartOfDay();
                localDateTimeAtStartOfDay2.getClass();
                LocalDateTime localDateTimeAtStartOfDay3 = localDate.minusDays(1L).atStartOfDay();
                localDateTimeAtStartOfDay3.getClass();
                LocalDateTime localDateTimeAtStartOfDay4 = historyViewModel.thisMonday.atStartOfDay();
                localDateTimeAtStartOfDay4.getClass();
                LocalDateTime localDateTimeAtStartOfDay5 = historyViewModel.lastMonday.atStartOfDay();
                localDateTimeAtStartOfDay5.getClass();
                HistoryViewModel$events$lambda$1$$inlined$map$1 historyViewModel$events$lambda$1$$inlined$map$1 = new HistoryViewModel$events$lambda$1$$inlined$map$1(musicDatabase2.$$delegate_0.historyEvents(localDateTimeAtStartOfDay, localDateTimeAtStartOfDay2, localDateTimeAtStartOfDay3, localDateTimeAtStartOfDay4, localDateTimeAtStartOfDay5), zBooleanValue4, historyViewModel);
                this.L$0 = null;
                this.$forEachDelta = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector2, historyViewModel$events$lambda$1$$inlined$map$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                Object obj5 = this.$forEachDelta;
                boolean z4 = this.label;
                if (z4) {
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                PodcastItem podcastItem = (PodcastItem) obj5;
                if (podcastItem == null || (safeFlow = ((OnlinePodcastViewModel) obj2).database.podcast(podcastItem.id)) == null) {
                    safeFlow = new SafeFlow((byte) 4, null);
                }
                this.L$0 = null;
                this.$forEachDelta = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector3, safeFlow, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnchoredDraggableNode$drag$2(Continuation continuation, ViewModel viewModel, byte b) {
        super(3, continuation);
        this.$r8$classId = b;
        this.this$0 = viewModel;
    }
}
