package io.ktor.http.cio;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.CountedByteReadChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.io.bytestring.ByteString;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.cio.MultipartKt$parseMultipart$1$preambleData$1", f = "Multipart.kt", l = {230, 231}, m = "invokeSuspend", v = 1)
public final class MultipartKt$parseMultipart$1$preambleData$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ CountedByteReadChannel $countedInput;
    final /* synthetic */ ByteString $firstBoundary;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultipartKt$parseMultipart$1$preambleData$1(ByteString byteString, CountedByteReadChannel countedByteReadChannel, Continuation continuation) {
        super(2, continuation);
        this.$firstBoundary = byteString;
        this.$countedInput = countedByteReadChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MultipartKt$parseMultipart$1$preambleData$1 multipartKt$parseMultipart$1$preambleData$1 = new MultipartKt$parseMultipart$1$preambleData$1(this.$firstBoundary, this.$countedInput, continuation);
        multipartKt$parseMultipart$1$preambleData$1.L$0 = obj;
        return multipartKt$parseMultipart$1$preambleData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation continuation) {
        return ((MultipartKt$parseMultipart$1$preambleData$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r12.flushAndClose(r11) == r5) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MultipartKt$parseMultipart$1$preambleData$1 multipartKt$parseMultipart$1$preambleData$1;
        WriterScope writerScope = (WriterScope) this.L$0;
        int i = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                multipartKt$parseMultipart$1$preambleData$1 = this;
            } else {
                if (i != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        ByteString byteString = this.$firstBoundary;
        CountedByteReadChannel countedByteReadChannel = this.$countedInput;
        ByteWriteChannel channel = writerScope.getChannel();
        this.L$0 = writerScope;
        this.label = 1;
        multipartKt$parseMultipart$1$preambleData$1 = this;
        if (MultipartKt.parsePreambleImpl(byteString, countedByteReadChannel, channel, 8193L, multipartKt$parseMultipart$1$preambleData$1) != coroutineSingletons) {
        }
        return coroutineSingletons;
        ByteWriteChannel channel2 = writerScope.getChannel();
        multipartKt$parseMultipart$1$preambleData$1.L$0 = null;
        multipartKt$parseMultipart$1$preambleData$1.label = 2;
    }
}
