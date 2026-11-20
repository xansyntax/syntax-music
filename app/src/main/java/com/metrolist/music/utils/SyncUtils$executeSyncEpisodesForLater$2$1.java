package com.metrolist.music.utils;

import com.metrolist.innertube.YouTube;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$executeSyncEpisodesForLater$2$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncUtils$executeSyncEpisodesForLater$2$1(byte b) {
        super(1, null);
        this.$r8$classId = b;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new SyncUtils$executeSyncEpisodesForLater$2$1(1, continuation, (byte) 0);
            case 1:
                return new SyncUtils$executeSyncEpisodesForLater$2$1(1, continuation, (byte) 1);
            case 2:
                return new SyncUtils$executeSyncEpisodesForLater$2$1(1, continuation, (byte) 2);
            default:
                return new SyncUtils$executeSyncEpisodesForLater$2$1(1, continuation, (byte) 3);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                return ((SyncUtils$executeSyncEpisodesForLater$2$1) create(continuation)).invokeSuspend(unit);
            case 1:
                ((SyncUtils$executeSyncEpisodesForLater$2$1) create(continuation)).invokeSuspend(unit);
                return unit;
            case 2:
                return ((SyncUtils$executeSyncEpisodesForLater$2$1) create(continuation)).invokeSuspend(unit);
            default:
                return ((SyncUtils$executeSyncEpisodesForLater$2$1) create(continuation)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM1004episodesForLaterIoAF18A;
        Object objM1038savedPodcastShowsIoAF18A;
        Object objM1013libraryPodcastChannelsIoAF18A;
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    YouTube youTube = YouTube.INSTANCE;
                    this.label = true;
                    objM1004episodesForLaterIoAF18A = youTube.m1004episodesForLaterIoAF18A(this);
                    if (objM1004episodesForLaterIoAF18A == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1004episodesForLaterIoAF18A = ((Result) obj).value;
                }
                return new Result(objM1004episodesForLaterIoAF18A);
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    throw null;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    YouTube youTube2 = YouTube.INSTANCE;
                    this.label = true;
                    objM1038savedPodcastShowsIoAF18A = youTube2.m1038savedPodcastShowsIoAF18A(this);
                    if (objM1038savedPodcastShowsIoAF18A == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1038savedPodcastShowsIoAF18A = ((Result) obj).value;
                }
                return new Result(objM1038savedPodcastShowsIoAF18A);
            default:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    YouTube youTube3 = YouTube.INSTANCE;
                    this.label = true;
                    objM1013libraryPodcastChannelsIoAF18A = youTube3.m1013libraryPodcastChannelsIoAF18A(this);
                    if (objM1013libraryPodcastChannelsIoAF18A == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z4) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1013libraryPodcastChannelsIoAF18A = ((Result) obj).value;
                }
                return new Result(objM1013libraryPodcastChannelsIoAF18A);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncUtils$executeSyncEpisodesForLater$2$1(int i, Continuation continuation, byte b) {
        super(i, continuation);
        this.$r8$classId = b;
    }
}
