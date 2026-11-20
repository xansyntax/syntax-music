package com.metrolist.music.viewmodels;

import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.DatabaseDao$songs$$inlined$map$3;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.ui.screens.OptionStats;
import java.time.LocalDateTime;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsViewModel$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ FlowCollector L$0;
    public /* synthetic */ Object L$1;
    public boolean label;
    public final /* synthetic */ StatsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatsViewModel$special$$inlined$flatMapLatest$1(byte b, StatsViewModel statsViewModel, Continuation continuation) {
        super(3, continuation);
        this.$r8$classId = b;
        this.this$0 = statsViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        StatsViewModel statsViewModel = this.this$0;
        FlowCollector flowCollector = (FlowCollector) obj;
        Continuation continuation = (Continuation) obj3;
        switch (b) {
            case 0:
                StatsViewModel$special$$inlined$flatMapLatest$1 statsViewModel$special$$inlined$flatMapLatest$1 = new StatsViewModel$special$$inlined$flatMapLatest$1((byte) 0, statsViewModel, continuation);
                statsViewModel$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
                statsViewModel$special$$inlined$flatMapLatest$1.L$1 = obj2;
                return statsViewModel$special$$inlined$flatMapLatest$1.invokeSuspend(unit);
            case 1:
                StatsViewModel$special$$inlined$flatMapLatest$1 statsViewModel$special$$inlined$flatMapLatest$2 = new StatsViewModel$special$$inlined$flatMapLatest$1((byte) 1, statsViewModel, continuation);
                statsViewModel$special$$inlined$flatMapLatest$2.L$0 = flowCollector;
                statsViewModel$special$$inlined$flatMapLatest$2.L$1 = obj2;
                return statsViewModel$special$$inlined$flatMapLatest$2.invokeSuspend(unit);
            case 2:
                StatsViewModel$special$$inlined$flatMapLatest$1 statsViewModel$special$$inlined$flatMapLatest$3 = new StatsViewModel$special$$inlined$flatMapLatest$1((byte) 2, statsViewModel, continuation);
                statsViewModel$special$$inlined$flatMapLatest$3.L$0 = flowCollector;
                statsViewModel$special$$inlined$flatMapLatest$3.L$1 = obj2;
                return statsViewModel$special$$inlined$flatMapLatest$3.invokeSuspend(unit);
            case 3:
                StatsViewModel$special$$inlined$flatMapLatest$1 statsViewModel$special$$inlined$flatMapLatest$4 = new StatsViewModel$special$$inlined$flatMapLatest$1((byte) 3, statsViewModel, continuation);
                statsViewModel$special$$inlined$flatMapLatest$4.L$0 = flowCollector;
                statsViewModel$special$$inlined$flatMapLatest$4.L$1 = obj2;
                return statsViewModel$special$$inlined$flatMapLatest$4.invokeSuspend(unit);
            case 4:
                StatsViewModel$special$$inlined$flatMapLatest$1 statsViewModel$special$$inlined$flatMapLatest$5 = new StatsViewModel$special$$inlined$flatMapLatest$1((byte) 4, statsViewModel, continuation);
                statsViewModel$special$$inlined$flatMapLatest$5.L$0 = flowCollector;
                statsViewModel$special$$inlined$flatMapLatest$5.L$1 = obj2;
                return statsViewModel$special$$inlined$flatMapLatest$5.invokeSuspend(unit);
            default:
                StatsViewModel$special$$inlined$flatMapLatest$1 statsViewModel$special$$inlined$flatMapLatest$6 = new StatsViewModel$special$$inlined$flatMapLatest$1((byte) 5, statsViewModel, continuation);
                statsViewModel$special$$inlined$flatMapLatest$6.L$0 = flowCollector;
                statsViewModel$special$$inlined$flatMapLatest$6.L$1 = obj2;
                return statsViewModel$special$$inlined$flatMapLatest$6.invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Flow safeFlow;
        Flow safeFlow2;
        byte b = this.$r8$classId;
        OptionStats optionStats = OptionStats.CONTINUOUS;
        Unit unit = Unit.INSTANCE;
        StatsViewModel statsViewModel = this.this$0;
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
                OptionStats optionStats2 = (OptionStats) triple.first;
                int iIntValue = ((Number) triple.second).intValue();
                DatabaseDao$songs$$inlined$map$3 databaseDao$songs$$inlined$map$3 = new DatabaseDao$songs$$inlined$map$3(statsViewModel.database.$$delegate_0.mostPlayedSongsStats(Okio__OkioKt.statToPeriod(optionStats2, iIntValue), (optionStats2 == optionStats || iIntValue == 0) ? LocalDateTime.now() : Okio__OkioKt.statToPeriod(optionStats2, iIntValue - 1)), ((Boolean) triple.third).booleanValue(), (byte) 24);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector, databaseDao$songs$$inlined$map$3, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
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
                Triple triple2 = (Triple) obj3;
                OptionStats optionStats3 = (OptionStats) triple2.first;
                int iIntValue2 = ((Number) triple2.second).intValue();
                DatabaseDao$songs$$inlined$map$3 databaseDao$songs$$inlined$map$4 = new DatabaseDao$songs$$inlined$map$3(DatabaseDao.mostPlayedSongs$default(statsViewModel.database, Okio__OkioKt.statToPeriod(optionStats3, iIntValue2), -1, (optionStats3 == optionStats || iIntValue2 == 0) ? LocalDateTime.now() : Okio__OkioKt.statToPeriod(optionStats3, iIntValue2 - 1), 4), ((Boolean) triple2.third).booleanValue(), (byte) 23);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector2, databaseDao$songs$$inlined$map$4, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 2:
                FlowCollector flowCollector3 = this.L$0;
                Object obj4 = this.L$1;
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
                Pair pair = (Pair) obj4;
                OptionStats optionStats4 = (OptionStats) pair.first;
                int iIntValue3 = ((Number) pair.second).intValue();
                HomeViewModel$special$$inlined$map$1 homeViewModel$special$$inlined$map$1 = new HomeViewModel$special$$inlined$map$1(DatabaseDao.mostPlayedArtists$default(statsViewModel.database, Okio__OkioKt.statToPeriod(optionStats4, iIntValue3), -1, (optionStats4 == optionStats || iIntValue3 == 0) ? LocalDateTime.now() : Okio__OkioKt.statToPeriod(optionStats4, iIntValue3 - 1), 4), (byte) 24);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector3, homeViewModel$special$$inlined$map$1, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 3:
                FlowCollector flowCollector4 = this.L$0;
                Object obj5 = this.L$1;
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
                Pair pair2 = (Pair) obj5;
                OptionStats optionStats5 = (OptionStats) pair2.first;
                int iIntValue4 = ((Number) pair2.second).intValue();
                Flow flowMostPlayedAlbums$default = DatabaseDao.mostPlayedAlbums$default(statsViewModel.database, Okio__OkioKt.statToPeriod(optionStats5, iIntValue4), -1, (optionStats5 == optionStats || iIntValue4 == 0) ? LocalDateTime.now() : Okio__OkioKt.statToPeriod(optionStats5, iIntValue4 - 1), 4);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector4, flowMostPlayedAlbums$default, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 4:
                FlowCollector flowCollector5 = this.L$0;
                Object obj6 = this.L$1;
                boolean z5 = this.label;
                if (z5) {
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj6).booleanValue()) {
                    MusicDatabase musicDatabase = statsViewModel.database;
                    musicDatabase.getClass();
                    safeFlow = musicDatabase.$$delegate_0.playlist("LP_WEEKLY_MOST");
                } else {
                    safeFlow = new SafeFlow((byte) 4, null);
                }
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector5, safeFlow, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                FlowCollector flowCollector6 = this.L$0;
                Object obj7 = this.L$1;
                boolean z6 = this.label;
                if (z6) {
                    if (z6) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj7).booleanValue()) {
                    MusicDatabase musicDatabase2 = statsViewModel.database;
                    musicDatabase2.getClass();
                    safeFlow2 = musicDatabase2.$$delegate_0.playlist("LP_MONTHLY_MOST");
                } else {
                    safeFlow2 = new SafeFlow((byte) 4, null);
                }
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector6, safeFlow2, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
