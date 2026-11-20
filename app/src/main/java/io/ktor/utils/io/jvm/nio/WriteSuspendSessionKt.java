package io.ktor.utils.io.jvm.nio;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.utils.io.ByteWriteChannel;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.Utf8Kt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a8\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0087@¢\u0006\u0004\b\u0007\u0010\b\u001a*\u0010\f\u001a\u00020\u0004*\u00020\u00002\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0086H¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlin/Function2;", "Lio/ktor/utils/io/jvm/nio/WriteSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "", "block", "writeSuspendSession", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "", "writeWhile", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class WriteSuspendSessionKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt$writeSuspendSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt", f = "WriteSuspendSession.kt", l = {43, 45, 45}, m = "writeSuspendSession", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WriteSuspendSessionKt.writeSuspendSession(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt$writeWhile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.nio.WriteSuspendSessionKt", f = "WriteSuspendSession.kt", l = {59}, m = "writeWhile", v = 1)
    public static final class C03681 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03681(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WriteSuspendSessionKt.writeWhile(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
    
        if (r8 == r6) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v3, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r9v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writeSuspendSession(ByteWriteChannel byteWriteChannel, Function2 function2, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        ?? r8;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                WriteSuspendSession writeSuspendSession = new WriteSuspendSession(byteWriteChannel);
                anonymousClass1.L$0 = byteWriteChannel;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 1;
                r8 = byteWriteChannel;
                if (function2.invoke(writeSuspendSession, anonymousClass1) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                r8 = byteWriteChannel2;
            } else {
                if (i2 != 2) {
                    if (i2 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Throwable th = (Throwable) anonymousClass1.L$2;
                    ResultKt.throwOnFailure(obj);
                    throw th;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
            byteWriteChannel = r8.flush(anonymousClass1);
        } catch (Throwable th2) {
            ?? r9 = byteWriteChannel;
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = th2;
            anonymousClass1.label = 3;
            if (r9.flush(anonymousClass1) != coroutineSingletons) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object writeWhile(ByteWriteChannel byteWriteChannel, Function1 function1, Continuation continuation) {
        C03681 c03681;
        int i;
        Function1 function2;
        Ref$BooleanRef ref$BooleanRef;
        if (continuation instanceof C03681) {
            c03681 = (C03681) continuation;
            int i2 = c03681.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c03681.label = i2 - Integer.MIN_VALUE;
            } else {
                c03681 = new C03681(continuation);
            }
        } else {
            c03681 = new C03681(continuation);
        }
        Object obj = c03681.result;
        int i3 = c03681.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            i = 0;
            function2 = function1;
            ref$BooleanRef = new Ref$BooleanRef();
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            int i4 = c03681.I$0;
            ref$BooleanRef = (Ref$BooleanRef) c03681.L$2;
            Function1 function3 = (Function1) c03681.L$1;
            ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) c03681.L$0;
            ResultKt.throwOnFailure(obj);
            function2 = function3;
            i = i4;
            byteWriteChannel = byteWriteChannel2;
        }
        while (!ref$BooleanRef.element) {
            Buffer buffer = byteWriteChannel.getWriteBuffer().getBuffer();
            Segment segmentWritableSegment = buffer.writableSegment(1);
            byte[] bArr = segmentWritableSegment.data;
            int i5 = segmentWritableSegment.limit;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i5, bArr.length - i5);
            byteBufferWrap.getClass();
            ref$BooleanRef.element = !((Boolean) function2.invoke(byteBufferWrap)).booleanValue();
            int iPosition = byteBufferWrap.position() - i5;
            if (iPosition == 1) {
                segmentWritableSegment.limit += iPosition;
                buffer.sizeMut += (long) iPosition;
            } else {
                if (iPosition < 0 || iPosition > segmentWritableSegment.getRemainingCapacity()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(iPosition, "Invalid number of bytes written: ", ". Should be in 0.."), segmentWritableSegment.getRemainingCapacity());
                    return null;
                }
                if (iPosition != 0) {
                    segmentWritableSegment.limit += iPosition;
                    buffer.sizeMut += (long) iPosition;
                } else if (Utf8Kt.isEmpty(segmentWritableSegment)) {
                    buffer.recycleTail();
                }
            }
            c03681.L$0 = byteWriteChannel;
            c03681.L$1 = function2;
            c03681.L$2 = ref$BooleanRef;
            c03681.I$0 = i;
            c03681.label = 1;
            Object objFlush = byteWriteChannel.flush(c03681);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objFlush == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    private static final Object writeWhile$$forInline(ByteWriteChannel byteWriteChannel, Function1 function1, Continuation continuation) {
        boolean z = false;
        while (!z) {
            Buffer buffer = byteWriteChannel.getWriteBuffer().getBuffer();
            Segment segmentWritableSegment = buffer.writableSegment(1);
            byte[] bArr = segmentWritableSegment.data;
            int i = segmentWritableSegment.limit;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, bArr.length - i);
            byteBufferWrap.getClass();
            boolean z2 = !((Boolean) function1.invoke(byteBufferWrap)).booleanValue();
            int iPosition = byteBufferWrap.position() - i;
            if (iPosition == 1) {
                segmentWritableSegment.limit += iPosition;
                buffer.sizeMut += (long) iPosition;
            } else {
                if (iPosition < 0 || iPosition > segmentWritableSegment.getRemainingCapacity()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(iPosition, "Invalid number of bytes written: ", ". Should be in 0.."), segmentWritableSegment.getRemainingCapacity());
                    return null;
                }
                if (iPosition != 0) {
                    segmentWritableSegment.limit += iPosition;
                    buffer.sizeMut += (long) iPosition;
                } else if (Utf8Kt.isEmpty(segmentWritableSegment)) {
                    buffer.recycleTail();
                }
            }
            byteWriteChannel.flush(continuation);
            z = z2;
        }
        return Unit.INSTANCE;
    }
}
