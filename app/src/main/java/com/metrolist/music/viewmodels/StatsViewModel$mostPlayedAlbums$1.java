package com.metrolist.music.viewmodels;

import com.metrolist.music.ui.screens.OptionStats;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsViewModel$mostPlayedAlbums$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ int I$0;
    public /* synthetic */ OptionStats L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatsViewModel$mostPlayedAlbums$1(int i, Continuation continuation, byte b) {
        super(i, continuation);
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = 3;
        OptionStats optionStats = (OptionStats) obj;
        Number number = (Number) obj2;
        switch (b) {
            case 0:
                int iIntValue = number.intValue();
                StatsViewModel$mostPlayedAlbums$1 statsViewModel$mostPlayedAlbums$1 = new StatsViewModel$mostPlayedAlbums$1(i, (Continuation) obj3, (byte) 0);
                statsViewModel$mostPlayedAlbums$1.L$0 = optionStats;
                statsViewModel$mostPlayedAlbums$1.I$0 = iIntValue;
                return statsViewModel$mostPlayedAlbums$1.invokeSuspend(unit);
            default:
                int iIntValue2 = number.intValue();
                StatsViewModel$mostPlayedAlbums$1 statsViewModel$mostPlayedAlbums$2 = new StatsViewModel$mostPlayedAlbums$1(i, (Continuation) obj3, (byte) 1);
                statsViewModel$mostPlayedAlbums$2.L$0 = optionStats;
                statsViewModel$mostPlayedAlbums$2.I$0 = iIntValue2;
                return statsViewModel$mostPlayedAlbums$2.invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                OptionStats optionStats = this.L$0;
                int i = this.I$0;
                ResultKt.throwOnFailure(obj);
                return new Pair(optionStats, new Integer(i));
            default:
                OptionStats optionStats2 = this.L$0;
                int i2 = this.I$0;
                ResultKt.throwOnFailure(obj);
                return new Pair(optionStats2, new Integer(i2));
        }
    }
}
