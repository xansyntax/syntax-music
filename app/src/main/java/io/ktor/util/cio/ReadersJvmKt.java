package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperations_jvmKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a0\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0087H¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Ljava/nio/ByteBuffer;", "buffer", "Lkotlin/Function1;", "", "block", "pass", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ReadersJvmKt {

    /* JADX INFO: renamed from: io.ktor.util.cio.ReadersJvmKt$pass$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.util.cio.ReadersJvmKt", f = "ReadersJvm.kt", l = {19}, m = "pass", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return ReadersJvmKt.pass(null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0049  */
    /* JADX WARN: Code duplicated, block: B:19:0x005e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005c -> B:20:0x005f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object pass(io.ktor.utils.io.ByteReadChannel r4, java.nio.ByteBuffer r5, kotlin.jvm.functions.Function1 r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.util.cio.ReadersJvmKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.util.cio.ReadersJvmKt$pass$1 r0 = (io.ktor.util.cio.ReadersJvmKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.util.cio.ReadersJvmKt$pass$1 r0 = new io.ktor.util.cio.ReadersJvmKt$pass$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L38
            int r4 = r0.I$0
            java.lang.Object r5 = r0.L$2
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r1 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r1 = (io.ktor.utils.io.ByteReadChannel) r1
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            r4 = r1
            goto L5f
        L38:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r4)
            r4 = 0
            return r4
        L3f:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = 0
        L43:
            boolean r1 = r4.isClosedForRead()
            if (r1 != 0) goto L66
            r5.clear()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.I$0 = r7
            r0.label = r2
            java.lang.Object r1 = io.ktor.utils.io.ByteReadChannelOperations_jvmKt.readAvailable(r4, r5, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 != r3) goto L5f
            return r3
        L5f:
            r5.flip()
            r6.invoke(r5)
            goto L43
        L66:
            java.lang.Throwable r4 = r4.getClosedCause()
            if (r4 != 0) goto L6f
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L6f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.cio.ReadersJvmKt.pass(io.ktor.utils.io.ByteReadChannel, java.nio.ByteBuffer, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object pass$$forInline(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, Function1 function1, Continuation continuation) throws Throwable {
        while (!byteReadChannel.isClosedForRead()) {
            byteBuffer.clear();
            ByteReadChannelOperations_jvmKt.readAvailable(byteReadChannel, byteBuffer, continuation);
            byteBuffer.flip();
            function1.invoke(byteBuffer);
        }
        Throwable closedCause = byteReadChannel.getClosedCause();
        if (closedCause == null) {
            return Unit.INSTANCE;
        }
        throw closedCause;
    }
}
