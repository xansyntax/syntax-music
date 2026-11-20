package io.ktor.util.pipeline;

import io.ktor.util.debug.ContextUtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a2\u0010\u0005\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\u0005\u0010\u0006\u001aw\u0010\u000e\u001a\u00020\u0003\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0001*\u00020\u0000*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\t\u001a\u00020\b26\b\b\u0010\r\u001a0\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f*p\b\u0000\u0010\u0010\u001a\u0004\b\u0000\u0010\u0007\u001a\u0004\b\u0001\u0010\u0001\".\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n2.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n*r\u0010\u0011\u001a\u0004\b\u0000\u0010\u0007\u001a\u0004\b\u0001\u0010\u0001\"0\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n20\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"", "TContext", "Lio/ktor/util/pipeline/Pipeline;", "", "context", "execute", "(Lio/ktor/util/pipeline/Pipeline;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TSubject", "Lio/ktor/util/pipeline/PipelinePhase;", "phase", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", "block", "intercept", "(Lio/ktor/util/pipeline/Pipeline;Lio/ktor/util/pipeline/PipelinePhase;Lkotlin/jvm/functions/Function3;)V", "PipelineInterceptorCoroutine", "PipelineInterceptor", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PipelineKt {

    /* JADX INFO: renamed from: io.ktor.util.pipeline.PipelineKt$execute$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.util.pipeline.PipelineKt$execute$2", f = "Pipeline.kt", l = {509}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function1 {
        final /* synthetic */ TContext $context;
        final /* synthetic */ Pipeline<Unit, TContext> $this_execute;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Pipeline<Unit, TContext> pipeline, TContext tcontext, Continuation continuation) {
            super(1, continuation);
            this.$this_execute = pipeline;
            this.$context = tcontext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass2(this.$this_execute, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            Unit unit = Unit.INSTANCE;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Pipeline<Unit, TContext> pipeline = this.$this_execute;
                TContext tcontext = this.$context;
                this.label = 1;
                Object objExecute = pipeline.execute(tcontext, unit, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objExecute == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return unit;
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.pipeline.PipelineKt$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "", "subject"}, k = 3, mv = {2, 3, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.util.pipeline.PipelineKt$intercept$1", f = "Pipeline.kt", l = {527}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function3 {
        final /* synthetic */ Function3 $block;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function3 function3, Continuation continuation) {
            super(3, continuation);
            this.$block = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<? extends Object, TContext> pipelineContext, Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, continuation);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Intrinsics.throwUndefinedForReified();
                throw null;
            }
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    public static final <TContext> Object execute(Pipeline<Unit, TContext> pipeline, TContext tcontext, Continuation continuation) {
        Object objInitContextInDebugMode = ContextUtilsKt.initContextInDebugMode(new AnonymousClass2(pipeline, tcontext, null), continuation);
        return objInitContextInDebugMode == CoroutineSingletons.COROUTINE_SUSPENDED ? objInitContextInDebugMode : Unit.INSTANCE;
    }

    private static final <TContext> Object execute$$forInline(Pipeline<Unit, TContext> pipeline, TContext tcontext, Continuation continuation) {
        ContextUtilsKt.initContextInDebugMode(new AnonymousClass2(pipeline, tcontext, null), continuation);
        return Unit.INSTANCE;
    }

    public static final <TSubject, TContext> void intercept(Pipeline<?, TContext> pipeline, PipelinePhase pipelinePhase, Function3 function3) {
        pipeline.getClass();
        pipelinePhase.getClass();
        function3.getClass();
        Intrinsics.throwUndefinedForReified();
        throw null;
    }
}
