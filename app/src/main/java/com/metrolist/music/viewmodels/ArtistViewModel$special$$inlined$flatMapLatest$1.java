package com.metrolist.music.viewmodels;

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
public final class ArtistViewModel$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ FlowCollector L$0;
    public /* synthetic */ Object L$1;
    public boolean label;
    public final /* synthetic */ ArtistViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ArtistViewModel$special$$inlined$flatMapLatest$1(Continuation continuation, ArtistViewModel artistViewModel, byte b) {
        super(3, continuation);
        this.$r8$classId = b;
        this.this$0 = artistViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ArtistViewModel artistViewModel = this.this$0;
        FlowCollector flowCollector = (FlowCollector) obj;
        Continuation continuation = (Continuation) obj3;
        switch (b) {
            case 0:
                ArtistViewModel$special$$inlined$flatMapLatest$1 artistViewModel$special$$inlined$flatMapLatest$1 = new ArtistViewModel$special$$inlined$flatMapLatest$1(continuation, artistViewModel, (byte) 0);
                artistViewModel$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
                artistViewModel$special$$inlined$flatMapLatest$1.L$1 = obj2;
                return artistViewModel$special$$inlined$flatMapLatest$1.invokeSuspend(unit);
            default:
                ArtistViewModel$special$$inlined$flatMapLatest$1 artistViewModel$special$$inlined$flatMapLatest$2 = new ArtistViewModel$special$$inlined$flatMapLatest$1(continuation, artistViewModel, (byte) 1);
                artistViewModel$special$$inlined$flatMapLatest$2.L$0 = flowCollector;
                artistViewModel$special$$inlined$flatMapLatest$2.L$1 = obj2;
                return artistViewModel$special$$inlined$flatMapLatest$2.invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ArtistViewModel artistViewModel = this.this$0;
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
                ArtistSongsViewModel$songs$lambda$1$$inlined$map$1 artistSongsViewModel$songs$lambda$1$$inlined$map$1 = new ArtistSongsViewModel$songs$lambda$1$$inlined$map$1(artistViewModel.database.artistSongsPreview(artistViewModel.artistId), ((Boolean) pair.first).booleanValue(), ((Boolean) pair.second).booleanValue(), (byte) 1);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector, artistSongsViewModel$songs$lambda$1$$inlined$map$1, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                DatabaseDao$songs$$inlined$map$3 databaseDao$songs$$inlined$map$3 = new DatabaseDao$songs$$inlined$map$3(artistViewModel.database.artistAlbumsPreview(artistViewModel.artistId), ((Boolean) obj3).booleanValue(), (byte) 13);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector2, databaseDao$songs$$inlined$map$3, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
