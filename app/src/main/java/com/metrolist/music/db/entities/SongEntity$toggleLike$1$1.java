package com.metrolist.music.db.entities;

import com.metrolist.innertube.YouTube;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SongEntity$toggleLike$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ SongEntity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SongEntity$toggleLike$1$1(SongEntity songEntity, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = songEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        SongEntity songEntity = this.this$0;
        switch (b) {
            case 0:
                return new SongEntity$toggleLike$1$1(songEntity, continuation, (byte) 0);
            default:
                return new SongEntity$toggleLike$1$1(songEntity, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((SongEntity$toggleLike$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SongEntity songEntity = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Object obj2 = ((Result) obj).value;
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                YouTube youTube = YouTube.INSTANCE;
                String str = songEntity.id;
                boolean z2 = !songEntity.liked;
                this.label = true;
                return youTube.m1016likeVideo0E7RQCE(str, z2, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z3 = this.label;
                if (z3) {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Object obj3 = ((Result) obj).value;
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                boolean z4 = songEntity.inLibrary == null;
                YouTube youTube2 = YouTube.INSTANCE;
                String str2 = songEntity.id;
                this.label = true;
                return youTube2.m1044toggleSongLibrary0E7RQCE(str2, z4, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
