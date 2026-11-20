package io.ktor.http.cio;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "discardBlocking", "(Lio/ktor/utils/io/ByteReadChannel;)V", "ktor-http-cio"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MultipartJvmAndPosixKt {

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartJvmAndPosixKt$discardBlocking$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartJvmAndPosixKt$discardBlocking$1", f = "MultipartJvmAndPosix.kt", l = {DictionaryEntry.PRONUNCIATION}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ ByteReadChannel $this_discardBlocking;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ByteReadChannel byteReadChannel, Continuation continuation) {
            super(2, continuation);
            this.$this_discardBlocking = byteReadChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$this_discardBlocking, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            ByteReadChannel byteReadChannel = this.$this_discardBlocking;
            this.label = 1;
            Object objDiscard$default = ByteReadChannelOperationsKt.discard$default(byteReadChannel, 0L, this, 1, null);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objDiscard$default == coroutineSingletons ? coroutineSingletons : objDiscard$default;
        }
    }

    public static final void discardBlocking(ByteReadChannel byteReadChannel) throws Throwable {
        byteReadChannel.getClass();
        AwaitKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new AnonymousClass1(byteReadChannel, null));
    }
}
