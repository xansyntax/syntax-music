package com.metrolist.music.playback;

import com.metrolist.music.models.MediaMetadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerConnection$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ FlowCollector L$0;
    public /* synthetic */ Object L$1;
    public boolean label;
    public final /* synthetic */ PlayerConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlayerConnection$special$$inlined$flatMapLatest$1(byte b, PlayerConnection playerConnection, Continuation continuation) {
        super(3, continuation);
        this.$r8$classId = b;
        this.this$0 = playerConnection;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        PlayerConnection playerConnection = this.this$0;
        FlowCollector flowCollector = (FlowCollector) obj;
        Continuation continuation = (Continuation) obj3;
        switch (b) {
            case 0:
                PlayerConnection$special$$inlined$flatMapLatest$1 playerConnection$special$$inlined$flatMapLatest$1 = new PlayerConnection$special$$inlined$flatMapLatest$1((byte) 0, playerConnection, continuation);
                playerConnection$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
                playerConnection$special$$inlined$flatMapLatest$1.L$1 = obj2;
                return playerConnection$special$$inlined$flatMapLatest$1.invokeSuspend(unit);
            case 1:
                PlayerConnection$special$$inlined$flatMapLatest$1 playerConnection$special$$inlined$flatMapLatest$2 = new PlayerConnection$special$$inlined$flatMapLatest$1((byte) 1, playerConnection, continuation);
                playerConnection$special$$inlined$flatMapLatest$2.L$0 = flowCollector;
                playerConnection$special$$inlined$flatMapLatest$2.L$1 = obj2;
                return playerConnection$special$$inlined$flatMapLatest$2.invokeSuspend(unit);
            default:
                PlayerConnection$special$$inlined$flatMapLatest$1 playerConnection$special$$inlined$flatMapLatest$3 = new PlayerConnection$special$$inlined$flatMapLatest$1((byte) 2, playerConnection, continuation);
                playerConnection$special$$inlined$flatMapLatest$3.L$0 = flowCollector;
                playerConnection$special$$inlined$flatMapLatest$3.L$1 = obj2;
                return playerConnection$special$$inlined$flatMapLatest$3.invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        PlayerConnection playerConnection = this.this$0;
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
                MediaMetadata mediaMetadata = (MediaMetadata) obj2;
                Flow flowSong = playerConnection.database.$$delegate_0.song(mediaMetadata != null ? mediaMetadata.id : null);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector, flowSong, this) == coroutineSingletons ? coroutineSingletons : unit;
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
                MediaMetadata mediaMetadata2 = (MediaMetadata) obj3;
                Flow flowLyrics = playerConnection.database.$$delegate_0.lyrics(mediaMetadata2 != null ? mediaMetadata2.id : null);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector2, flowLyrics, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
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
                MediaMetadata mediaMetadata3 = (MediaMetadata) obj4;
                Flow flow = playerConnection.database.$$delegate_0.format(mediaMetadata3 != null ? mediaMetadata3.id : null);
                this.L$0 = null;
                this.L$1 = null;
                this.label = true;
                return StateFlowKt.emitAll(flowCollector3, flow, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
