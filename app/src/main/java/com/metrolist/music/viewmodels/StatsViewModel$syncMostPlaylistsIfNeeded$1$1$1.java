package com.metrolist.music.viewmodels;

import androidx.datastore.preferences.core.MutablePreferences;
import com.metrolist.music.constants.PreferenceKeysKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ long $nowEpochMillis;
    public final /* synthetic */ boolean $shouldSyncMonthly;
    public final /* synthetic */ boolean $shouldSyncWeekly;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1(boolean z, long j, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.$shouldSyncWeekly = z;
        this.$nowEpochMillis = j;
        this.$shouldSyncMonthly = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1 statsViewModel$syncMostPlaylistsIfNeeded$1$1$1 = new StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1(this.$shouldSyncWeekly, this.$nowEpochMillis, this.$shouldSyncMonthly, continuation);
        statsViewModel$syncMostPlaylistsIfNeeded$1$1$1.L$0 = obj;
        return statsViewModel$syncMostPlaylistsIfNeeded$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1 statsViewModel$syncMostPlaylistsIfNeeded$1$1$1 = (StatsViewModel$syncMostPlaylistsIfNeeded$1$1$1) create((MutablePreferences) obj, (Continuation) obj2);
        Unit unit = Unit.INSTANCE;
        statsViewModel$syncMostPlaylistsIfNeeded$1$1$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
        ResultKt.throwOnFailure(obj);
        boolean z = this.$shouldSyncWeekly;
        long j = this.$nowEpochMillis;
        if (z) {
            mutablePreferences.set(PreferenceKeysKt.LastWeeklyMostPlaylistSyncKey, new Long(j));
        }
        if (this.$shouldSyncMonthly) {
            mutablePreferences.set(PreferenceKeysKt.LastMonthlyMostPlaylistSyncKey, new Long(j));
        }
        return Unit.INSTANCE;
    }
}
