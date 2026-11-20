package com.metrolist.music.viewmodels;

import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.db.DatabaseDao$songs$$inlined$map$3;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryPodcastsViewModel$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ FlowCollector L$0;
    public /* synthetic */ Object L$1;
    public boolean label;
    public final /* synthetic */ LibraryPodcastsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LibraryPodcastsViewModel$special$$inlined$flatMapLatest$1(byte b, LibraryPodcastsViewModel libraryPodcastsViewModel, Continuation continuation) {
        super(3, continuation);
        this.$r8$classId = b;
        this.this$0 = libraryPodcastsViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LibraryPodcastsViewModel libraryPodcastsViewModel = this.this$0;
        FlowCollector flowCollector = (FlowCollector) obj;
        Continuation continuation = (Continuation) obj3;
        switch (b) {
            case 0:
                LibraryPodcastsViewModel$special$$inlined$flatMapLatest$1 libraryPodcastsViewModel$special$$inlined$flatMapLatest$1 = new LibraryPodcastsViewModel$special$$inlined$flatMapLatest$1((byte) 0, libraryPodcastsViewModel, continuation);
                libraryPodcastsViewModel$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
                libraryPodcastsViewModel$special$$inlined$flatMapLatest$1.L$1 = obj2;
                return libraryPodcastsViewModel$special$$inlined$flatMapLatest$1.invokeSuspend(unit);
            default:
                LibraryPodcastsViewModel$special$$inlined$flatMapLatest$1 libraryPodcastsViewModel$special$$inlined$flatMapLatest$2 = new LibraryPodcastsViewModel$special$$inlined$flatMapLatest$1((byte) 1, libraryPodcastsViewModel, continuation);
                libraryPodcastsViewModel$special$$inlined$flatMapLatest$2.L$0 = flowCollector;
                libraryPodcastsViewModel$special$$inlined$flatMapLatest$2.L$1 = obj2;
                return libraryPodcastsViewModel$special$$inlined$flatMapLatest$2.invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LibraryPodcastsViewModel libraryPodcastsViewModel = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                FlowCollector flowCollector = this.L$0;
                Object obj2 = this.L$1;
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
                Pair pair = (Pair) obj2;
                Pair pair2 = (Pair) pair.first;
                DatabaseDao$songs$$inlined$map$3 databaseDao$songs$$inlined$map$3 = new DatabaseDao$songs$$inlined$map$3(libraryPodcastsViewModel.database.downloadedPodcastEpisodes((SongSortType) pair2.first, ((Boolean) pair2.second).booleanValue()), ((Boolean) pair.second).booleanValue(), (byte) 20);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector, databaseDao$songs$$inlined$map$3, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                FlowCollector flowCollector2 = this.L$0;
                Object obj3 = this.L$1;
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
                Pair pair3 = (Pair) obj3;
                Pair pair4 = (Pair) pair3.first;
                DatabaseDao$songs$$inlined$map$3 databaseDao$songs$$inlined$map$4 = new DatabaseDao$songs$$inlined$map$3(libraryPodcastsViewModel.database.savedPodcastEpisodes((SongSortType) pair4.first, ((Boolean) pair4.second).booleanValue()), ((Boolean) pair3.second).booleanValue(), (byte) 21);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector2, databaseDao$songs$$inlined$map$4, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
