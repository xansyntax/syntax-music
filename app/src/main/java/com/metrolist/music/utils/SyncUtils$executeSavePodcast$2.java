package com.metrolist.music.utils;

import com.metrolist.innertube.YouTube;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$executeSavePodcast$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $podcastId;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean $save;
    public byte label;
    public final /* synthetic */ SyncUtils this$0;

    /* JADX INFO: renamed from: com.metrolist.music.utils.SyncUtils$executeSavePodcast$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function1 {
        public final /* synthetic */ String $podcastId;
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ boolean $save;
        public boolean label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(String str, boolean z, Continuation continuation, byte b) {
            super(1, continuation);
            this.$r8$classId = b;
            this.$podcastId = str;
            this.$save = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass1(this.$podcastId, this.$save, continuation, (byte) 0);
                default:
                    return new AnonymousClass1(this.$podcastId, this.$save, continuation, (byte) 1);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Continuation continuation = (Continuation) obj;
            switch (b) {
                case 0:
                    break;
            }
            return ((AnonymousClass1) create(continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM1037savePodcast0E7RQCE;
            Object objM1043subscribeChannelBWLJW6A;
            byte b = this.$r8$classId;
            boolean z = this.$save;
            String str = this.$podcastId;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    boolean z2 = this.label;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        YouTube youTube = YouTube.INSTANCE;
                        this.label = true;
                        objM1037savePodcast0E7RQCE = youTube.m1037savePodcast0E7RQCE(str, z, this);
                        if (objM1037savePodcast0E7RQCE == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM1037savePodcast0E7RQCE = ((Result) obj).value;
                    }
                    return new Result(objM1037savePodcast0E7RQCE);
                default:
                    boolean z3 = this.label;
                    if (!z3) {
                        ResultKt.throwOnFailure(obj);
                        YouTube youTube2 = YouTube.INSTANCE;
                        this.label = true;
                        objM1043subscribeChannelBWLJW6A = youTube2.m1043subscribeChannelBWLJW6A(str, z, this);
                        if (objM1043subscribeChannelBWLJW6A == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM1043subscribeChannelBWLJW6A = ((Result) obj).value;
                    }
                    return new Result(objM1043subscribeChannelBWLJW6A);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncUtils$executeSavePodcast$2(String str, boolean z, SyncUtils syncUtils, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$podcastId = str;
        this.$save = z;
        this.this$0 = syncUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new SyncUtils$executeSavePodcast$2(this.$podcastId, this.$save, this.this$0, continuation, (byte) 0);
            default:
                return new SyncUtils$executeSavePodcast$2(this.$podcastId, this.$save, this.this$0, continuation, (byte) 1);
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
        return ((SyncUtils$executeSavePodcast$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0077  */
    /* JADX WARN: Code duplicated, block: B:26:0x0091  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:50:0x0114  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM1522withRetryBWLJW6A;
        Object objM1522withRetryBWLJW6A2;
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        String str = this.$podcastId;
        Unit unit = Unit.INSTANCE;
        boolean z = this.$save;
        SyncUtils syncUtils = this.this$0;
        byte b2 = 0;
        byte b3 = 1;
        Continuation continuation = null;
        switch (b) {
            case 0:
                byte b4 = this.label;
                if (b4 != 0) {
                    if (b4 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b4 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM1522withRetryBWLJW6A = ((Result) obj).value;
                    }
                    if (!(objM1522withRetryBWLJW6A instanceof Result.Failure)) {
                        Object obj2 = ((Result) objM1522withRetryBWLJW6A).value;
                        Timber.Forest.getClass();
                        ConnectionPool.d(new Object[0]);
                    }
                    if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A) != null) {
                        Timber.Forest.getClass();
                        ConnectionPool.e$1(new Object[0]);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                this.label = (byte) 1;
                int i = SyncUtils.$r8$clinit;
                obj = syncUtils.isLoggedIn(this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                if (((Boolean) obj).booleanValue()) {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(str, z, continuation, b2);
                    this.label = (byte) 2;
                    objM1522withRetryBWLJW6A = syncUtils.m1522withRetryBWLJW6A(3, 1000L, anonymousClass1, this);
                    if (objM1522withRetryBWLJW6A == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    if (!(objM1522withRetryBWLJW6A instanceof Result.Failure)) {
                        Object obj3 = ((Result) objM1522withRetryBWLJW6A).value;
                        Timber.Forest.getClass();
                        ConnectionPool.d(new Object[0]);
                    }
                    if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A) != null) {
                        Timber.Forest.getClass();
                        ConnectionPool.e$1(new Object[0]);
                    }
                } else {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                }
                return unit;
            default:
                byte b5 = this.label;
                if (b5 != 0) {
                    if (b5 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (b5 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objM1522withRetryBWLJW6A2 = ((Result) obj).value;
                    }
                    if (!(objM1522withRetryBWLJW6A2 instanceof Result.Failure)) {
                        Object obj4 = ((Result) objM1522withRetryBWLJW6A2).value;
                        Timber.Forest.getClass();
                        ConnectionPool.d(new Object[0]);
                        PodcastRefreshTrigger._refreshFlow.tryEmit(unit);
                    }
                    if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A2) != null) {
                        Timber.Forest.getClass();
                        ConnectionPool.e$1(new Object[0]);
                    }
                    return unit;
                }
                ResultKt.throwOnFailure(obj);
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                this.label = (byte) 1;
                int i2 = SyncUtils.$r8$clinit;
                obj = syncUtils.isLoggedIn(this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                if (((Boolean) obj).booleanValue()) {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    AnonymousClass1 anonymousClass2 = new AnonymousClass1(str, z, continuation, b3);
                    this.label = (byte) 2;
                    objM1522withRetryBWLJW6A2 = syncUtils.m1522withRetryBWLJW6A(3, 1000L, anonymousClass2, this);
                    if (objM1522withRetryBWLJW6A2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    if (!(objM1522withRetryBWLJW6A2 instanceof Result.Failure)) {
                        Object obj5 = ((Result) objM1522withRetryBWLJW6A2).value;
                        Timber.Forest.getClass();
                        ConnectionPool.d(new Object[0]);
                        PodcastRefreshTrigger._refreshFlow.tryEmit(unit);
                    }
                    if (Result.m1866exceptionOrNullimpl(objM1522withRetryBWLJW6A2) != null) {
                        Timber.Forest.getClass();
                        ConnectionPool.e$1(new Object[0]);
                    }
                } else {
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                }
                return unit;
        }
    }
}
