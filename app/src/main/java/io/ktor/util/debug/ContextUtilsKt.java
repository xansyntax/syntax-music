package io.ktor.util.debug;

import io.ktor.util.debug.plugins.PluginName;
import io.ktor.util.debug.plugins.PluginsTrace;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a4\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006\u001a<\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\b\u001a\u00020\u00072\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0086@¢\u0006\u0004\b\t\u0010\n\u001a<\u0010\u0011\u001a\u00020\u000f\"\b\b\u0000\u0010\f*\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u0001H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "initContextInDebugMode", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "pluginName", "addToContextInDebugMode", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext$Element;", "Element", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "", "action", "useContextElementInDebugMode", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ContextUtilsKt {

    /* JADX INFO: renamed from: io.ktor.util.debug.ContextUtilsKt$addToContextInDebugMode$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.debug.ContextUtilsKt$addToContextInDebugMode$2", f = "ContextUtils.kt", l = {37}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function1 $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Function1 function1 = this.$block;
            this.label = 1;
            Object objInvoke = function1.invoke(this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.debug.ContextUtilsKt$initContextInDebugMode$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.debug.ContextUtilsKt$initContextInDebugMode$2", f = "ContextUtils.kt", l = {22}, m = "invokeSuspend", v = 1)
    public static final class C03292 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function1 $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03292(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C03292(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03292) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Function1 function1 = this.$block;
            this.label = 1;
            Object objInvoke = function1.invoke(this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
        }
    }

    public static final <T> Object addToContextInDebugMode(String str, Function1 function1, Continuation continuation) {
        return !IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected() ? function1.invoke(continuation) : AwaitKt.withContext(continuation.getContext().plus(new PluginName(str)), new AnonymousClass2(function1, null), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Object initContextInDebugMode(Function1 function1, Continuation continuation) {
        if (!IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected()) {
            return function1.invoke(continuation);
        }
        return AwaitKt.withContext(continuation.getContext().plus(new PluginsTrace(null, 1, 0 == true ? 1 : 0)), new C03292(function1, null), continuation);
    }

    public static final <Element extends CoroutineContext.Element> Object useContextElementInDebugMode(CoroutineContext.Key key, Function1 function1, Continuation continuation) {
        CoroutineContext.Element element;
        boolean zIsDebuggerConnected = IntellijIdeaDebugDetector.INSTANCE.isDebuggerConnected();
        Unit unit = Unit.INSTANCE;
        if (zIsDebuggerConnected && (element = continuation.getContext().get(key)) != null) {
            function1.invoke(element);
        }
        return unit;
    }
}
