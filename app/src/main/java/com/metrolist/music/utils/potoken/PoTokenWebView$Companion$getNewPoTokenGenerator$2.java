package com.metrolist.music.utils.potoken;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/metrolist/music/utils/potoken/PoTokenWebView;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
@DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenWebView$Companion$getNewPoTokenGenerator$2", f = "PoTokenWebView.kt", l = {465}, m = "invokeSuspend", v = 2)
public final class PoTokenWebView$Companion$getNewPoTokenGenerator$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref$ObjectRef $created;
    int label;

    /* JADX INFO: renamed from: com.metrolist.music.utils.potoken.PoTokenWebView$Companion$getNewPoTokenGenerator$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/metrolist/music/utils/potoken/PoTokenWebView;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
    @DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenWebView$Companion$getNewPoTokenGenerator$2$1", f = "PoTokenWebView.kt", l = {496}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ Ref$ObjectRef $created;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
            super(2, continuation);
            this.$context = context;
            this.$created = ref$ObjectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$context, this.$created, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Context context = this.$context;
            Ref$ObjectRef ref$ObjectRef = this.$created;
            this.L$0 = context;
            this.L$1 = ref$ObjectRef;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(this));
            cancellableContinuationImpl.initCancellability();
            PoTokenWebView poTokenWebView = new PoTokenWebView(context, cancellableContinuationImpl, null);
            ref$ObjectRef.element = poTokenWebView;
            poTokenWebView.loadHtmlAndObtainBotguard();
            Object result = cancellableContinuationImpl.getResult();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return result == coroutineSingletons ? coroutineSingletons : result;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PoTokenWebView$Companion$getNewPoTokenGenerator$2(Context context, Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
        this.$created = ref$ObjectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PoTokenWebView$Companion$getNewPoTokenGenerator$2(this.$context, this.$created, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PoTokenWebView$Companion$getNewPoTokenGenerator$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        HandlerContext handlerContext = MainDispatcherLoader.dispatcher;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$created, null);
        this.label = 1;
        Object objWithContext = AwaitKt.withContext(handlerContext, anonymousClass1, this);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return objWithContext == coroutineSingletons ? coroutineSingletons : objWithContext;
    }
}
