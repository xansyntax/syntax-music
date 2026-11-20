package io.ktor.http.content;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import io.ktor.websocket.ControlFramesKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.LongRange;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.OutgoingContent$ReadChannelContent$readFrom$1", f = "OutgoingContent.kt", l = {121, ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE}, m = "invokeSuspend", v = 1)
public final class OutgoingContent$ReadChannelContent$readFrom$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ LongRange $range;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OutgoingContent.ReadChannelContent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingContent$ReadChannelContent$readFrom$1(OutgoingContent.ReadChannelContent readChannelContent, LongRange longRange, Continuation continuation) {
        super(2, continuation);
        this.this$0 = readChannelContent;
        this.$range = longRange;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        OutgoingContent$ReadChannelContent$readFrom$1 outgoingContent$ReadChannelContent$readFrom$1 = new OutgoingContent$ReadChannelContent$readFrom$1(this.this$0, this.$range, continuation);
        outgoingContent$ReadChannelContent$readFrom$1.L$0 = obj;
        return outgoingContent$ReadChannelContent$readFrom$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation continuation) {
        return ((OutgoingContent$ReadChannelContent$readFrom$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
    
        if (io.ktor.utils.io.ByteReadChannelOperationsKt.copyTo(r1, r11, r6, r10) == r5) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ByteReadChannel from;
        WriterScope writerScope = (WriterScope) this.L$0;
        int i = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            from = this.this$0.readFrom();
            long j = this.$range.first;
            this.L$0 = writerScope;
            this.L$1 = from;
            this.label = 1;
            if (ByteReadChannelOperationsKt.discard(from, j, this) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i == 1) {
            from = (ByteReadChannel) this.L$1;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        LongRange longRange = this.$range;
        long j2 = (longRange.last - longRange.first) + 1;
        ByteWriteChannel channel = writerScope.getChannel();
        this.L$0 = null;
        this.L$1 = null;
        this.J$0 = j2;
        this.label = 2;
    }
}
