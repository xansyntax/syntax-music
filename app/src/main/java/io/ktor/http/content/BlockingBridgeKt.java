package io.ktor.http.content;

import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.scheduling.UnlimitedIoScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u001aD\u0010\t\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012$\b\u0004\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0080H¢\u0006\u0004\b\t\u0010\n\u001aP\u0010\u000f\u001a\u00020\u0006*\u00020\u00002\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\b\b\u0002\u0010\u0002\u001a\u00020\u00012$\b\u0004\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0080H¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u00020\u0004*\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0016\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/Function2;", "Ljava/io/OutputStream;", "Lkotlin/coroutines/Continuation;", "", "", "block", "withBlockingOutputStream", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Ljava/io/Writer;", "withBlockingWriter", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/charset/Charset;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nonClosing", "(Ljava/io/OutputStream;)Ljava/io/OutputStream;", "", "BLOCKING_BRIDGE_PARALLELISM_PROPERTY_NAME", "Ljava/lang/String;", "BlockingBridgeDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BlockingBridgeKt {
    private static final String BLOCKING_BRIDGE_PARALLELISM_PROPERTY_NAME = "io.ktor.blocking.bridge.parallelism";
    private static final CoroutineDispatcher BlockingBridgeDispatcher;

    /* JADX INFO: renamed from: io.ktor.http.content.BlockingBridgeKt$withBlockingOutputStream$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.http.content.BlockingBridgeKt$withBlockingOutputStream$2", f = "BlockingBridge.kt", l = {46}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $block;
        final /* synthetic */ ByteWriteChannel $this_withBlockingOutputStream;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ByteWriteChannel byteWriteChannel, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$this_withBlockingOutputStream = byteWriteChannel;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_withBlockingOutputStream, this.$block, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                OutputStream outputStreamAsOutputStream = BlockingKt.asOutputStream(this.$this_withBlockingOutputStream, AwaitKt.getJob(coroutineScope.getCoroutineContext()));
                Function2 function2 = this.$block;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 1;
                Object objInvoke = function2.invoke(outputStreamAsOutputStream, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objInvoke == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            this.$block.invoke(BlockingKt.asOutputStream(this.$this_withBlockingOutputStream, AwaitKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext())), this);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.content.BlockingBridgeKt$withBlockingWriter$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.http.content.BlockingBridgeKt$withBlockingWriter$2", f = "BlockingBridge.kt", l = {67}, m = "invokeSuspend", v = 1)
    public static final class C03142 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $block;
        final /* synthetic */ Charset $charset;
        final /* synthetic */ ByteWriteChannel $this_withBlockingWriter;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03142(ByteWriteChannel byteWriteChannel, Charset charset, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$this_withBlockingWriter = byteWriteChannel;
            this.$charset = charset;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C03142 c03142 = new C03142(this.$this_withBlockingWriter, this.$charset, this.$block, continuation);
            c03142.L$0 = obj;
            return c03142;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03142) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Closeable closeable;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                closeable = (Closeable) this.L$2;
                try {
                    ResultKt.throwOnFailure(obj);
                    CharsKt.closeFinally(closeable, null);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CharsKt.closeFinally(closeable, th);
                        throw th2;
                    }
                }
            }
            ResultKt.throwOnFailure(obj);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(BlockingBridgeKt.nonClosing(BlockingKt.asOutputStream(this.$this_withBlockingWriter, AwaitKt.getJob(coroutineScope.getCoroutineContext()))), this.$charset);
            Function2 function2 = this.$block;
            try {
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = outputStreamWriter;
                this.L$3 = null;
                this.I$0 = 0;
                this.label = 1;
                Object objInvoke = function2.invoke(outputStreamWriter, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objInvoke == coroutineSingletons) {
                    return coroutineSingletons;
                }
                closeable = outputStreamWriter;
                CharsKt.closeFinally(closeable, null);
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                th = th3;
                closeable = outputStreamWriter;
                throw th;
            }
        }

        public final Object invokeSuspend$$forInline(Object obj) throws IOException {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(BlockingBridgeKt.nonClosing(BlockingKt.asOutputStream(this.$this_withBlockingWriter, AwaitKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext()))), this.$charset);
            try {
                this.$block.invoke(outputStreamWriter, null);
                outputStreamWriter.close();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(outputStreamWriter, th);
                    throw th2;
                }
            }
        }
    }

    static {
        Integer intOrNull;
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        String property = System.getProperty(BLOCKING_BRIDGE_PARALLELISM_PROPERTY_NAME);
        int iIntValue = (property == null || (intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, property)) == null) ? 64 : intOrNull.intValue();
        defaultIoScheduler.getClass();
        BlockingBridgeDispatcher = UnlimitedIoScheduler.INSTANCE.limitedParallelism(iIntValue, "ktor-blocking-bridge");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OutputStream nonClosing(OutputStream outputStream) {
        return new NonClosingOutputStream(outputStream);
    }

    public static final Object withBlockingOutputStream(ByteWriteChannel byteWriteChannel, CoroutineDispatcher coroutineDispatcher, Function2 function2, Continuation continuation) {
        Object objWithContext = AwaitKt.withContext(coroutineDispatcher, new AnonymousClass2(byteWriteChannel, function2, null), continuation);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    private static final Object withBlockingOutputStream$$forInline(ByteWriteChannel byteWriteChannel, CoroutineDispatcher coroutineDispatcher, Function2 function2, Continuation continuation) {
        AwaitKt.withContext(coroutineDispatcher, new AnonymousClass2(byteWriteChannel, function2, null), continuation);
        return Unit.INSTANCE;
    }

    public static Object withBlockingOutputStream$default(ByteWriteChannel byteWriteChannel, CoroutineDispatcher coroutineDispatcher, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineDispatcher = BlockingBridgeDispatcher;
        }
        AwaitKt.withContext(coroutineDispatcher, new AnonymousClass2(byteWriteChannel, function2, null), continuation);
        return Unit.INSTANCE;
    }

    public static final Object withBlockingWriter(ByteWriteChannel byteWriteChannel, Charset charset, CoroutineDispatcher coroutineDispatcher, Function2 function2, Continuation continuation) {
        Object objWithContext = AwaitKt.withContext(coroutineDispatcher, new C03142(byteWriteChannel, charset, function2, null), continuation);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    private static final Object withBlockingWriter$$forInline(ByteWriteChannel byteWriteChannel, Charset charset, CoroutineDispatcher coroutineDispatcher, Function2 function2, Continuation continuation) {
        AwaitKt.withContext(coroutineDispatcher, new C03142(byteWriteChannel, charset, function2, null), continuation);
        return Unit.INSTANCE;
    }

    public static Object withBlockingWriter$default(ByteWriteChannel byteWriteChannel, Charset charset, CoroutineDispatcher coroutineDispatcher, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineDispatcher = BlockingBridgeDispatcher;
        }
        AwaitKt.withContext(coroutineDispatcher, new C03142(byteWriteChannel, charset, function2, null), continuation);
        return Unit.INSTANCE;
    }
}
