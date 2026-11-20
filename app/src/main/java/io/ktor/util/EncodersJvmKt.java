package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperations_jvmKt;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0082\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u001a)\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a,\u0010\u0013\u001a\u00020\u0000*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001b\"\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"", "flag", "", "has", "(II)Z", "Lio/ktor/utils/io/ByteReadChannel;", "source", "gzip", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "inflate", "(Lio/ktor/utils/io/ByteReadChannel;ZLkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "Ljava/util/zip/Inflater;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "Ljava/nio/ByteBuffer;", "buffer", "Ljava/util/zip/Checksum;", "checksum", "inflateTo", "(Ljava/util/zip/Inflater;Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/ByteBuffer;Ljava/util/zip/Checksum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "GZIP_HEADER_SIZE", "I", "Lio/ktor/util/Encoder;", "Deflate", "Lio/ktor/util/Encoder;", "getDeflate", "()Lio/ktor/util/Encoder;", "GZip", "getGZip", "Lkotlinx/coroutines/CoroutineName;", "InflateWriterCoroutineName", "Lkotlinx/coroutines/CoroutineName;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class EncodersJvmKt {
    private static final int GZIP_HEADER_SIZE = 10;
    private static final Encoder Deflate = new Encoder() { // from class: io.ktor.util.EncodersJvmKt$Deflate$1
        @Override // io.ktor.util.Encoder
        public ByteReadChannel decode(ByteReadChannel source, CoroutineContext coroutineContext) {
            source.getClass();
            coroutineContext.getClass();
            return EncodersJvmKt.inflate(source, false, coroutineContext);
        }

        @Override // io.ktor.util.Encoder
        public ByteReadChannel encode(ByteReadChannel source, CoroutineContext coroutineContext) {
            source.getClass();
            coroutineContext.getClass();
            return DeflaterKt.deflated$default(source, false, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteWriteChannel encode(ByteWriteChannel source, CoroutineContext coroutineContext) {
            source.getClass();
            coroutineContext.getClass();
            return DeflaterKt.deflated$default(source, false, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }
    };
    private static final Encoder GZip = new Encoder() { // from class: io.ktor.util.EncodersJvmKt$GZip$1
        @Override // io.ktor.util.Encoder
        public ByteReadChannel decode(ByteReadChannel source, CoroutineContext coroutineContext) {
            source.getClass();
            coroutineContext.getClass();
            return EncodersJvmKt.inflate$default(source, false, coroutineContext, 2, null);
        }

        @Override // io.ktor.util.Encoder
        public ByteReadChannel encode(ByteReadChannel source, CoroutineContext coroutineContext) {
            source.getClass();
            coroutineContext.getClass();
            return DeflaterKt.deflated$default(source, true, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteWriteChannel encode(ByteWriteChannel source, CoroutineContext coroutineContext) {
            source.getClass();
            coroutineContext.getClass();
            return DeflaterKt.deflated$default(source, true, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }
    };
    private static final CoroutineName InflateWriterCoroutineName = new CoroutineName("encoder-inflate-writer");

    /* JADX INFO: renamed from: io.ktor.util.EncodersJvmKt$inflate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.EncodersJvmKt$inflate$1", f = "EncodersJvm.kt", l = {91, 108, 109, 119, 126, 131, 143}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ boolean $gzip;
        final /* synthetic */ ByteReadChannel $source;
        byte B$0;
        byte B$1;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        short S$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, ByteReadChannel byteReadChannel, Continuation continuation) {
            super(2, continuation);
            this.$gzip = z;
            this.$source = byteReadChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$gzip, this.$source, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:69:0x0225 A[Catch: all -> 0x0031, TRY_ENTER, TryCatch #0 {all -> 0x0031, blocks: (B:7:0x002a, B:94:0x02d6, B:96:0x02de, B:99:0x02e5, B:100:0x02ec, B:101:0x02ed, B:89:0x02b4, B:91:0x02ba, B:102:0x02ff, B:104:0x0303, B:106:0x030b, B:108:0x032b, B:111:0x0330, B:112:0x0354, B:113:0x0355, B:114:0x035c, B:115:0x035d, B:116:0x0380, B:117:0x0381, B:121:0x039b, B:122:0x03a2, B:75:0x0258, B:77:0x025e, B:79:0x0264, B:85:0x02a6, B:66:0x021b, B:69:0x0225, B:72:0x023e, B:74:0x0246, B:86:0x02ab, B:88:0x02b1, B:123:0x03a3, B:17:0x006f, B:65:0x0211), top: B:128:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:71:0x023c  */
        /* JADX WARN: Code duplicated, block: B:72:0x023e A[Catch: all -> 0x0031, PHI: r2 r3 r4 r6 r9 r10
          0x023e: PHI (r2v26 kotlin.jvm.internal.Ref$IntRef) = (r2v25 kotlin.jvm.internal.Ref$IntRef), (r2v27 kotlin.jvm.internal.Ref$IntRef) binds: [B:18:0x0072, B:70:0x023a] A[DONT_GENERATE, DONT_INLINE]
          0x023e: PHI (r3v12 java.util.zip.CRC32) = (r3v11 java.util.zip.CRC32), (r3v13 java.util.zip.CRC32) binds: [B:18:0x0072, B:70:0x023a] A[DONT_GENERATE, DONT_INLINE]
          0x023e: PHI (r4v17 java.lang.Object) = (r4v16 java.lang.Object), (r4v25 java.lang.Object) binds: [B:18:0x0072, B:70:0x023a] A[DONT_GENERATE, DONT_INLINE]
          0x023e: PHI (r6v22 java.util.zip.Inflater) = (r6v20 java.util.zip.Inflater), (r6v23 java.util.zip.Inflater) binds: [B:18:0x0072, B:70:0x023a] A[DONT_GENERATE, DONT_INLINE]
          0x023e: PHI (r9v24 java.nio.ByteBuffer) = (r9v22 java.nio.ByteBuffer), (r9v25 java.nio.ByteBuffer) binds: [B:18:0x0072, B:70:0x023a] A[DONT_GENERATE, DONT_INLINE]
          0x023e: PHI (r10v25 java.nio.ByteBuffer) = (r10v22 java.nio.ByteBuffer), (r10v26 java.nio.ByteBuffer) binds: [B:18:0x0072, B:70:0x023a] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0031, blocks: (B:7:0x002a, B:94:0x02d6, B:96:0x02de, B:99:0x02e5, B:100:0x02ec, B:101:0x02ed, B:89:0x02b4, B:91:0x02ba, B:102:0x02ff, B:104:0x0303, B:106:0x030b, B:108:0x032b, B:111:0x0330, B:112:0x0354, B:113:0x0355, B:114:0x035c, B:115:0x035d, B:116:0x0380, B:117:0x0381, B:121:0x039b, B:122:0x03a2, B:75:0x0258, B:77:0x025e, B:79:0x0264, B:85:0x02a6, B:66:0x021b, B:69:0x0225, B:72:0x023e, B:74:0x0246, B:86:0x02ab, B:88:0x02b1, B:123:0x03a3, B:17:0x006f, B:65:0x0211), top: B:128:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:74:0x0246 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:7:0x002a, B:94:0x02d6, B:96:0x02de, B:99:0x02e5, B:100:0x02ec, B:101:0x02ed, B:89:0x02b4, B:91:0x02ba, B:102:0x02ff, B:104:0x0303, B:106:0x030b, B:108:0x032b, B:111:0x0330, B:112:0x0354, B:113:0x0355, B:114:0x035c, B:115:0x035d, B:116:0x0380, B:117:0x0381, B:121:0x039b, B:122:0x03a2, B:75:0x0258, B:77:0x025e, B:79:0x0264, B:85:0x02a6, B:66:0x021b, B:69:0x0225, B:72:0x023e, B:74:0x0246, B:86:0x02ab, B:88:0x02b1, B:123:0x03a3, B:17:0x006f, B:65:0x0211), top: B:128:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:77:0x025e A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:7:0x002a, B:94:0x02d6, B:96:0x02de, B:99:0x02e5, B:100:0x02ec, B:101:0x02ed, B:89:0x02b4, B:91:0x02ba, B:102:0x02ff, B:104:0x0303, B:106:0x030b, B:108:0x032b, B:111:0x0330, B:112:0x0354, B:113:0x0355, B:114:0x035c, B:115:0x035d, B:116:0x0380, B:117:0x0381, B:121:0x039b, B:122:0x03a2, B:75:0x0258, B:77:0x025e, B:79:0x0264, B:85:0x02a6, B:66:0x021b, B:69:0x0225, B:72:0x023e, B:74:0x0246, B:86:0x02ab, B:88:0x02b1, B:123:0x03a3, B:17:0x006f, B:65:0x0211), top: B:128:0x000d }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v21 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0244 -> B:66:0x021b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0246 -> B:75:0x0258). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0284 -> B:83:0x028b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x02d3 -> B:94:0x02d6). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 972
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.EncodersJvmKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.EncodersJvmKt$inflateTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.EncodersJvmKt", f = "EncodersJvm.kt", l = {182}, m = "inflateTo", v = 1)
    public static final class C03261 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C03261(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EncodersJvmKt.inflateTo(null, null, null, null, this);
        }
    }

    public static final Encoder getDeflate() {
        return Deflate;
    }

    public static final Encoder getGZip() {
        return GZip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean has(int i, int i2) {
        return (i & i2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel inflate(ByteReadChannel byteReadChannel, boolean z, CoroutineContext coroutineContext) {
        return ByteWriteChannelOperationsKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, coroutineContext.plus(InflateWriterCoroutineName), false, (Function2) new AnonymousClass1(z, byteReadChannel, null), 2, (Object) null).getChannel();
    }

    public static /* synthetic */ ByteReadChannel inflate$default(ByteReadChannel byteReadChannel, boolean z, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return inflate(byteReadChannel, z, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object inflateTo(Inflater inflater, ByteWriteChannel byteWriteChannel, ByteBuffer byteBuffer, Checksum checksum, Continuation continuation) throws DataFormatException {
        C03261 c03261;
        int i;
        if (continuation instanceof C03261) {
            c03261 = (C03261) continuation;
            int i2 = c03261.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c03261.label = i2 - Integer.MIN_VALUE;
            } else {
                c03261 = new C03261(continuation);
            }
        } else {
            c03261 = new C03261(continuation);
        }
        Object obj = c03261.result;
        int i3 = c03261.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            byteBuffer.clear();
            int iInflate = inflater.inflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
            if (iInflate <= 0 && !inflater.needsInput() && !inflater.finished()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Inflater made no progress.");
                return null;
            }
            byteBuffer.position(byteBuffer.position() + iInflate);
            byteBuffer.flip();
            DeflaterKt.updateKeepPosition(checksum, byteBuffer);
            c03261.L$0 = null;
            c03261.L$1 = null;
            c03261.L$2 = null;
            c03261.L$3 = null;
            c03261.I$0 = iInflate;
            c03261.label = 1;
            Object objWriteFully = ByteWriteChannelOperations_jvmKt.writeFully(byteWriteChannel, byteBuffer, c03261);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWriteFully == coroutineSingletons) {
                return coroutineSingletons;
            }
            i = iInflate;
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = c03261.I$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Integer(i);
    }
}
