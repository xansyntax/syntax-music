package com.metrolist.music.viewmodels;

import androidx.lifecycle.ViewModel;
import com.metrolist.music.constants.ArtistSongSortType;
import com.metrolist.music.constants.MyTopFilter;
import com.metrolist.music.db.DatabaseDao$songs$$inlined$map$3;
import com.metrolist.music.db.MusicDatabase;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.time.LocalDateTime;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
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
public final class ArtistSongsViewModel$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ MusicDatabase $database$inlined;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ FlowCollector L$0;
    public /* synthetic */ Object L$1;
    public boolean label;
    public final /* synthetic */ ViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ArtistSongsViewModel$special$$inlined$flatMapLatest$1(Continuation continuation, MusicDatabase musicDatabase, ViewModel viewModel, byte b) {
        super(3, continuation);
        this.$r8$classId = b;
        this.$database$inlined = musicDatabase;
        this.this$0 = viewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ViewModel viewModel = this.this$0;
        MusicDatabase musicDatabase = this.$database$inlined;
        FlowCollector flowCollector = (FlowCollector) obj;
        Continuation continuation = (Continuation) obj3;
        switch (b) {
            case 0:
                ArtistSongsViewModel$special$$inlined$flatMapLatest$1 artistSongsViewModel$special$$inlined$flatMapLatest$1 = new ArtistSongsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (ArtistSongsViewModel) viewModel, (byte) 0);
                artistSongsViewModel$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
                artistSongsViewModel$special$$inlined$flatMapLatest$1.L$1 = obj2;
                return artistSongsViewModel$special$$inlined$flatMapLatest$1.invokeSuspend(unit);
            default:
                ArtistSongsViewModel$special$$inlined$flatMapLatest$1 artistSongsViewModel$special$$inlined$flatMapLatest$2 = new ArtistSongsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (TopPlaylistViewModel) viewModel, (byte) 1);
                artistSongsViewModel$special$$inlined$flatMapLatest$2.L$0 = flowCollector;
                artistSongsViewModel$special$$inlined$flatMapLatest$2.L$1 = obj2;
                return artistSongsViewModel$special$$inlined$flatMapLatest$2.invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LocalDateTime localDateTimeOf;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ViewModel viewModel = this.this$0;
        MusicDatabase musicDatabase = this.$database$inlined;
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
                Triple triple = (Triple) obj2;
                Pair pair = (Pair) triple.first;
                ArtistSongsViewModel$songs$lambda$1$$inlined$map$1 artistSongsViewModel$songs$lambda$1$$inlined$map$1 = new ArtistSongsViewModel$songs$lambda$1$$inlined$map$1(musicDatabase.artistSongs(((ArtistSongsViewModel) viewModel).artistId, (ArtistSongSortType) pair.first, ((Boolean) pair.second).booleanValue()), ((Boolean) triple.second).booleanValue(), ((Boolean) triple.third).booleanValue(), (byte) 0);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector, artistSongsViewModel$songs$lambda$1$$inlined$map$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                FlowCollector flowCollector2 = this.L$0;
                Object obj3 = this.L$1;
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    Pair pair2 = (Pair) obj3;
                    MyTopFilter myTopFilter = (MyTopFilter) pair2.first;
                    boolean zBooleanValue = ((Boolean) pair2.second).booleanValue();
                    LocalDateTime localDateTimeNow = LocalDateTime.now();
                    int iOrdinal = myTopFilter.ordinal();
                    if (iOrdinal == 0) {
                        localDateTimeOf = LocalDateTime.of(1970, 1, 1, 0, 0);
                        localDateTimeOf.getClass();
                    } else if (iOrdinal == 1) {
                        localDateTimeOf = LocalDateTime.now().minusDays(1L);
                        localDateTimeOf.getClass();
                    } else if (iOrdinal == 2) {
                        localDateTimeOf = LocalDateTime.now().minusWeeks(1L);
                        localDateTimeOf.getClass();
                    } else if (iOrdinal == 3) {
                        localDateTimeOf = LocalDateTime.now().minusMonths(1L);
                        localDateTimeOf.getClass();
                    } else if (iOrdinal == 4) {
                        localDateTimeOf = LocalDateTime.now().minusMonths(12L);
                        localDateTimeOf.getClass();
                    } else {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                    }
                    int i = Integer.parseInt(((TopPlaylistViewModel) viewModel).top);
                    musicDatabase.getClass();
                    DatabaseDao$songs$$inlined$map$3 databaseDao$songs$$inlined$map$3 = new DatabaseDao$songs$$inlined$map$3(musicDatabase.$$delegate_0.mostPlayedSongs(localDateTimeOf, i, 0, localDateTimeNow), zBooleanValue, (byte) 25);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = true;
                    return StateFlowKt.emitAll(flowCollector2, databaseDao$songs$$inlined$map$3, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
