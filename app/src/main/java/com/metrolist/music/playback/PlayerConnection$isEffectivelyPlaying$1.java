package com.metrolist.music.playback;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerConnection$isEffectivelyPlaying$1 extends SuspendLambda implements Function4 {
    public /* synthetic */ boolean Z$0;
    public /* synthetic */ boolean Z$1;
    public /* synthetic */ boolean Z$2;

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
        boolean zBooleanValue3 = ((Boolean) obj3).booleanValue();
        PlayerConnection$isEffectivelyPlaying$1 playerConnection$isEffectivelyPlaying$1 = new PlayerConnection$isEffectivelyPlaying$1(4, (Continuation) obj4);
        playerConnection$isEffectivelyPlaying$1.Z$0 = zBooleanValue;
        playerConnection$isEffectivelyPlaying$1.Z$1 = zBooleanValue2;
        playerConnection$isEffectivelyPlaying$1.Z$2 = zBooleanValue3;
        return playerConnection$isEffectivelyPlaying$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z = this.Z$0;
        boolean z2 = this.Z$1;
        boolean z3 = this.Z$2;
        ResultKt.throwOnFailure(obj);
        if (z2) {
            z = z3;
        }
        return Boolean.valueOf(z);
    }
}
