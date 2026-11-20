package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a8\u0010\n\u001a\u00020\b*\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "limit", "", "toByteArray", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlin/Function1;", "", "block", "use", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function1;)V", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ReadersKt {

    /* JADX INFO: renamed from: io.ktor.util.cio.ReadersKt$toByteArray$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.cio.ReadersKt", f = "Readers.kt", l = {18}, m = "toByteArray", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadersKt.toByteArray(null, 0, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object toByteArray(ByteReadChannel byteReadChannel, int i, Continuation continuation) throws EOFException {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object buffer = anonymousClass1.result;
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(buffer);
            anonymousClass1.L$0 = null;
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 1;
            buffer = ByteReadChannelOperationsKt.readBuffer(byteReadChannel, i, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (buffer == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(buffer);
        }
        return Utf8Kt.readByteArray((Source) buffer);
    }

    public static /* synthetic */ Object toByteArray$default(ByteReadChannel byteReadChannel, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        return toByteArray(byteReadChannel, i, continuation);
    }

    public static final void use(ByteWriteChannel byteWriteChannel, Function1 function1) {
        byteWriteChannel.getClass();
        function1.getClass();
        try {
            function1.invoke(byteWriteChannel);
            ByteWriteChannelKt.close(byteWriteChannel);
        } catch (Throwable th) {
            try {
                ByteWriteChannelOperationsKt.close(byteWriteChannel, th);
                throw th;
            } catch (Throwable th2) {
                ByteWriteChannelKt.close(byteWriteChannel);
                throw th2;
            }
        }
    }
}
