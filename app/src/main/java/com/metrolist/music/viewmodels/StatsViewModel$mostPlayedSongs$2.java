package com.metrolist.music.viewmodels;

import com.metrolist.music.ui.screens.OptionStats;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsViewModel$mostPlayedSongs$2 extends SuspendLambda implements Function4 {
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ int I$0;
    public /* synthetic */ OptionStats L$0;
    public /* synthetic */ boolean Z$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatsViewModel$mostPlayedSongs$2(int i, Continuation continuation, byte b) {
        super(i, continuation);
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = 4;
        OptionStats optionStats = (OptionStats) obj;
        Number number = (Number) obj2;
        switch (b) {
            case 0:
                int iIntValue = number.intValue();
                boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                StatsViewModel$mostPlayedSongs$2 statsViewModel$mostPlayedSongs$2 = new StatsViewModel$mostPlayedSongs$2(i, (Continuation) obj4, (byte) 0);
                statsViewModel$mostPlayedSongs$2.L$0 = optionStats;
                statsViewModel$mostPlayedSongs$2.I$0 = iIntValue;
                statsViewModel$mostPlayedSongs$2.Z$0 = zBooleanValue;
                return statsViewModel$mostPlayedSongs$2.invokeSuspend(unit);
            default:
                int iIntValue2 = number.intValue();
                boolean zBooleanValue2 = ((Boolean) obj3).booleanValue();
                StatsViewModel$mostPlayedSongs$2 statsViewModel$mostPlayedSongs$3 = new StatsViewModel$mostPlayedSongs$2(i, (Continuation) obj4, (byte) 1);
                statsViewModel$mostPlayedSongs$3.L$0 = optionStats;
                statsViewModel$mostPlayedSongs$3.I$0 = iIntValue2;
                statsViewModel$mostPlayedSongs$3.Z$0 = zBooleanValue2;
                return statsViewModel$mostPlayedSongs$3.invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                OptionStats optionStats = this.L$0;
                int i = this.I$0;
                boolean z = this.Z$0;
                ResultKt.throwOnFailure(obj);
                return new Triple(optionStats, new Integer(i), Boolean.valueOf(z));
            default:
                OptionStats optionStats2 = this.L$0;
                int i2 = this.I$0;
                boolean z2 = this.Z$0;
                ResultKt.throwOnFailure(obj);
                return new Triple(optionStats2, new Integer(i2), Boolean.valueOf(z2));
        }
    }
}
