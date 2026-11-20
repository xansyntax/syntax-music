package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteReadPacketKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/utils/io/LookAheadSuspendSession;", "", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;)V", "", "skip", "atLeast", "Ljava/nio/ByteBuffer;", "request", "(II)Ljava/nio/ByteBuffer;", "min", "", "awaitAtLeast", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "count", "", "consumed", "(I)V", "Lio/ktor/utils/io/ByteReadChannel;", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LookAheadSuspendSession {
    private final ByteReadChannel channel;

    /* JADX INFO: renamed from: io.ktor.utils.io.LookAheadSuspendSession$awaitAtLeast$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.LookAheadSuspendSession", f = "LookAheadSession.kt", l = {42}, m = "awaitAtLeast", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LookAheadSuspendSession.this.awaitAtLeast(0, this);
        }
    }

    public LookAheadSuspendSession(ByteReadChannel byteReadChannel) {
        byteReadChannel.getClass();
        this.channel = byteReadChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteBuffer request$lambda$0(Source source) {
        source.getClass();
        return ByteBuffer.wrap(Utf8Kt.readByteArrayImpl(source, -1));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object awaitAtLeast(int i, Continuation continuation) {
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
        Object obj = anonymousClass1.result;
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (ByteReadPacketKt.getRemaining(this.channel.getReadBuffer()) >= i) {
                return Boolean.TRUE;
            }
            ByteReadChannel byteReadChannel = this.channel;
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 1;
            Object objAwaitContent = byteReadChannel.awaitContent(i, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAwaitContent == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boolean.valueOf(ByteReadPacketKt.getRemaining(this.channel.getReadBuffer()) >= ((long) i));
    }

    public final void consumed(int count) {
        ByteReadPacketKt.discard(this.channel.getReadBuffer(), count);
    }

    public final ByteBuffer request(int skip, int atLeast) {
        if (ByteReadPacketKt.getRemaining(this.channel.getReadBuffer()) < atLeast + skip) {
            return null;
        }
        ByteBuffer byteBuffer = (ByteBuffer) ByteReadPacketKt.preview(this.channel.getReadBuffer(), new InstantKt$$ExternalSyntheticLambda0((byte) 11));
        if (skip > 0) {
            byteBuffer.position(byteBuffer.position() + skip);
        }
        return byteBuffer;
    }
}
