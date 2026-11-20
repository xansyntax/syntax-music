package io.ktor.util;

import com.yalantis.ucrop.UCrop;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperations_jvmKt;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001b\u0010\t\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0014\u0010\f\u001a\u00020\u0003*\u00020\u000bH\u0082@¢\u0006\u0004\b\f\u0010\r\u001a$\u0010\u0010\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0000H\u0082@¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0015\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016\u001a6\u0010\u0004\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u00132\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001aH\u0082@¢\u0006\u0004\b\u0004\u0010\u001c\u001a5\u0010\u001f\u001a\u00020\u0017*\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00132\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 \u001a5\u0010\u001f\u001a\u00020\u000b*\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u00132\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010!\"\u0014\u0010#\u001a\u00020\"8\u0000X\u0080T¢\u0006\u0006\n\u0004\b#\u0010$\"\u001a\u0010&\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,\"\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010,¨\u0006."}, d2 = {"Ljava/util/zip/Deflater;", "Ljava/nio/ByteBuffer;", "outBuffer", "", "deflateTo", "(Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;)V", "buffer", "setInputBuffer", "Ljava/util/zip/Checksum;", "updateKeepPosition", "(Ljava/util/zip/Checksum;Ljava/nio/ByteBuffer;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "putGzipHeader", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "crc", "deflater", "putGzipTrailer", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/util/zip/Checksum;Ljava/util/zip/Deflater;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function0;", "", "predicate", "deflateWhile", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "destination", "gzip", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;ZLio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "deflated", "(Lio/ktor/utils/io/ByteReadChannel;ZLio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;ZLio/ktor/utils/io/pool/ObjectPool;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteWriteChannel;", "", "GZIP_MAGIC", "S", "", "GZIP_HEADER_PADDING", "[B", "getGZIP_HEADER_PADDING", "()[B", "Lkotlinx/coroutines/CoroutineName;", "DeflateWriterCoroutineName", "Lkotlinx/coroutines/CoroutineName;", "DeflateReaderCoroutineName", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DeflaterKt {
    public static final short GZIP_MAGIC = -29921;
    private static final byte[] GZIP_HEADER_PADDING = new byte[7];
    private static final CoroutineName DeflateWriterCoroutineName = new CoroutineName("encoder-deflate-writer");
    private static final CoroutineName DeflateReaderCoroutineName = new CoroutineName("encoder-deflate-reader");

    /* JADX INFO: renamed from: io.ktor.util.DeflaterKt$deflateTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", l = {77, 82, 87, 93, UCrop.RESULT_ERROR}, m = "deflateTo", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeflaterKt.deflateTo(null, null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.DeflaterKt$deflateWhile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", l = {57}, m = "deflateWhile", v = 1)
    public static final class C03221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C03221(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeflaterKt.deflateWhile(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.DeflaterKt$deflated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.DeflaterKt$deflated$1", f = "Deflater.kt", l = {120}, m = "invokeSuspend", v = 1)
    public static final class C03231 extends SuspendLambda implements Function2 {
        final /* synthetic */ boolean $gzip;
        final /* synthetic */ ObjectPool<ByteBuffer> $pool;
        final /* synthetic */ ByteReadChannel $this_deflated;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03231(ByteReadChannel byteReadChannel, boolean z, ObjectPool<ByteBuffer> objectPool, Continuation continuation) {
            super(2, continuation);
            this.$this_deflated = byteReadChannel;
            this.$gzip = z;
            this.$pool = objectPool;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C03231 c03231 = new C03231(this.$this_deflated, this.$gzip, this.$pool, continuation);
            c03231.L$0 = obj;
            return c03231;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation continuation) {
            return ((C03231) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            WriterScope writerScope = (WriterScope) this.L$0;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ByteReadChannel byteReadChannel = this.$this_deflated;
                ByteWriteChannel channel = writerScope.getChannel();
                boolean z = this.$gzip;
                ObjectPool<ByteBuffer> objectPool = this.$pool;
                this.L$0 = null;
                this.label = 1;
                Object objDeflateTo = DeflaterKt.deflateTo(byteReadChannel, channel, z, objectPool, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objDeflateTo == coroutineSingletons) {
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
    }

    /* JADX INFO: renamed from: io.ktor.util.DeflaterKt$deflated$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.DeflaterKt$deflated$2", f = "Deflater.kt", l = {135}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ boolean $gzip;
        final /* synthetic */ ObjectPool<ByteBuffer> $pool;
        final /* synthetic */ ByteWriteChannel $this_deflated;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ByteWriteChannel byteWriteChannel, boolean z, ObjectPool<ByteBuffer> objectPool, Continuation continuation) {
            super(2, continuation);
            this.$this_deflated = byteWriteChannel;
            this.$gzip = z;
            this.$pool = objectPool;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_deflated, this.$gzip, this.$pool, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ReaderScope readerScope, Continuation continuation) {
            return ((AnonymousClass2) create(readerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ReaderScope readerScope = (ReaderScope) this.L$0;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ByteReadChannel channel = readerScope.getChannel();
                ByteWriteChannel byteWriteChannel = this.$this_deflated;
                boolean z = this.$gzip;
                ObjectPool<ByteBuffer> objectPool = this.$pool;
                this.L$0 = null;
                this.label = 1;
                Object objDeflateTo = DeflaterKt.deflateTo(channel, byteWriteChannel, z, objectPool, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objDeflateTo == coroutineSingletons) {
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
    }

    /* JADX INFO: renamed from: io.ktor.util.DeflaterKt$putGzipHeader$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", l = {42, 43, 44}, m = "putGzipHeader", v = 1)
    public static final class C03241 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03241(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeflaterKt.putGzipHeader(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.util.DeflaterKt$putGzipTrailer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", l = {48, 49}, m = "putGzipTrailer", v = 1)
    public static final class C03251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03251(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeflaterKt.putGzipTrailer(null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:58:0x016b A[Catch: all -> 0x01d5, TRY_LEAVE, TryCatch #1 {all -> 0x01d5, blocks: (B:82:0x0202, B:56:0x0165, B:58:0x016b, B:75:0x01d7, B:77:0x01dd, B:89:0x022c), top: B:94:0x0165 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0188  */
    /* JADX WARN: Code duplicated, block: B:64:0x0197 A[Catch: all -> 0x01c8, TRY_LEAVE, TryCatch #3 {all -> 0x01c8, blocks: (B:62:0x018f, B:64:0x0197), top: B:97:0x018f }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x00f0: MOVE (r1 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:241), block:B:38:0x00ef */
    /* JADX WARN: Path cross not found for [B:105:0x002c, B:42:0x0118], limit reached: 102 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v26, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v28, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object, java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r19v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23, types: [java.lang.Object, java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.lang.Object, java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21, types: [java.lang.Object, java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r4v23, types: [java.lang.Object, java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.lang.Object, java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.Object, java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23, types: [java.lang.Object, java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r5v24, types: [java.lang.Object, java.util.zip.Deflater] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object deflateTo(io.ktor.utils.io.ByteReadChannel r17, io.ktor.utils.io.ByteWriteChannel r18, boolean r19, io.ktor.utils.io.pool.ObjectPool<java.nio.ByteBuffer> r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 567
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt.deflateTo(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, boolean, io.ktor.utils.io.pool.ObjectPool, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object deflateTo$default(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, boolean z, ObjectPool objectPool, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        return deflateTo(byteReadChannel, byteWriteChannel, z, objectPool, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deflateTo$lambda$0(Deflater deflater) {
        return !deflater.needsInput();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deflateTo$lambda$2(Deflater deflater) {
        return !deflater.finished();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object deflateWhile(ByteWriteChannel byteWriteChannel, Deflater deflater, ByteBuffer byteBuffer, Function0 function0, Continuation continuation) {
        C03221 c03221;
        if (continuation instanceof C03221) {
            c03221 = (C03221) continuation;
            int i = c03221.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03221.label = i - Integer.MIN_VALUE;
            } else {
                c03221 = new C03221(continuation);
            }
        } else {
            c03221 = new C03221(continuation);
        }
        Object obj = c03221.result;
        int i2 = c03221.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Function0 function1 = (Function0) c03221.L$3;
            ByteBuffer byteBuffer2 = (ByteBuffer) c03221.L$2;
            Deflater deflater2 = (Deflater) c03221.L$1;
            ByteWriteChannel byteWriteChannel2 = (ByteWriteChannel) c03221.L$0;
            ResultKt.throwOnFailure(obj);
            function0 = function1;
            byteWriteChannel = byteWriteChannel2;
            byteBuffer = byteBuffer2;
            deflater = deflater2;
        }
        while (((Boolean) function0.invoke()).booleanValue()) {
            byteBuffer.clear();
            deflateTo(deflater, byteBuffer);
            byteBuffer.flip();
            c03221.L$0 = byteWriteChannel;
            c03221.L$1 = deflater;
            c03221.L$2 = byteBuffer;
            c03221.L$3 = function0;
            c03221.label = 1;
            Object objWriteFully = ByteWriteChannelOperations_jvmKt.writeFully(byteWriteChannel, byteBuffer, c03221);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWriteFully == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    public static final ByteReadChannel deflated(ByteReadChannel byteReadChannel, boolean z, ObjectPool<ByteBuffer> objectPool, CoroutineContext coroutineContext) {
        byteReadChannel.getClass();
        objectPool.getClass();
        coroutineContext.getClass();
        return ByteWriteChannelOperationsKt.writer((CoroutineScope) GlobalScope.INSTANCE, coroutineContext.plus(DeflateWriterCoroutineName), true, (Function2) new C03231(byteReadChannel, z, objectPool, null)).getChannel();
    }

    public static ByteReadChannel deflated$default(ByteReadChannel byteReadChannel, boolean z, ObjectPool objectPool, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        if ((i & 4) != 0) {
            coroutineContext = Dispatchers.Unconfined;
        }
        return deflated(byteReadChannel, z, (ObjectPool<ByteBuffer>) objectPool, coroutineContext);
    }

    public static final byte[] getGZIP_HEADER_PADDING() {
        return GZIP_HEADER_PADDING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007b, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeFully$default(r9, r2, 0, 0, r5, 6, null) == r8) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object putGzipHeader(ByteWriteChannel byteWriteChannel, Continuation continuation) {
        C03241 c03241;
        if (continuation instanceof C03241) {
            c03241 = (C03241) continuation;
            int i = c03241.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03241.label = i - Integer.MIN_VALUE;
            } else {
                c03241 = new C03241(continuation);
            }
        } else {
            c03241 = new C03241(continuation);
        }
        C03241 c03242 = c03241;
        Object obj = c03242.result;
        int i2 = c03242.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            short sReverseBytes = Short.reverseBytes(GZIP_MAGIC);
            c03242.L$0 = byteWriteChannel;
            c03242.label = 1;
            if (ByteWriteChannelOperationsKt.writeShort(byteWriteChannel, sReverseBytes, c03242) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            byteWriteChannel = (ByteWriteChannel) c03242.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i2 == 2) {
            byteWriteChannel = (ByteWriteChannel) c03242.L$0;
            ResultKt.throwOnFailure(obj);
            byte[] bArr = GZIP_HEADER_PADDING;
            c03242.L$0 = null;
            c03242.label = 3;
        } else {
            if (i2 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        c03242.L$0 = byteWriteChannel;
        c03242.label = 2;
        if (ByteWriteChannelOperationsKt.writeByte(byteWriteChannel, (byte) 8, c03242) != coroutineSingletons) {
            byte[] bArr2 = GZIP_HEADER_PADDING;
            c03242.L$0 = null;
            c03242.label = 3;
        }
        return coroutineSingletons;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007d, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelOperationsKt.writeInt(r8, r9, r0) == r5) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object putGzipTrailer(ByteWriteChannel byteWriteChannel, Checksum checksum, Deflater deflater, Continuation continuation) {
        C03251 c03251;
        if (continuation instanceof C03251) {
            c03251 = (C03251) continuation;
            int i = c03251.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03251.label = i - Integer.MIN_VALUE;
            } else {
                c03251 = new C03251(continuation);
            }
        } else {
            c03251 = new C03251(continuation);
        }
        Object obj = c03251.result;
        int i2 = c03251.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            int iReverseBytes = Integer.reverseBytes((int) checksum.getValue());
            c03251.L$0 = byteWriteChannel;
            c03251.L$1 = null;
            c03251.L$2 = deflater;
            c03251.label = 1;
            if (ByteWriteChannelOperationsKt.writeInt(byteWriteChannel, iReverseBytes, c03251) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            deflater = (Deflater) c03251.L$2;
            byteWriteChannel = (ByteWriteChannel) c03251.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        int iReverseBytes2 = Integer.reverseBytes(deflater.getTotalIn());
        c03251.L$0 = null;
        c03251.L$1 = null;
        c03251.L$2 = null;
        c03251.label = 2;
    }

    private static final void setInputBuffer(Deflater deflater, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("buffer need to be array-backed");
            return;
        }
        deflater.setInput(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
    }

    public static final void updateKeepPosition(Checksum checksum, ByteBuffer byteBuffer) {
        checksum.getClass();
        byteBuffer.getClass();
        if (!byteBuffer.hasArray()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("buffer need to be array-backed");
            return;
        }
        checksum.update(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
    }

    public static ByteWriteChannel deflated$default(ByteWriteChannel byteWriteChannel, boolean z, ObjectPool objectPool, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        if ((i & 4) != 0) {
            coroutineContext = Dispatchers.Unconfined;
        }
        return deflated(byteWriteChannel, z, (ObjectPool<ByteBuffer>) objectPool, coroutineContext);
    }

    public static final ByteWriteChannel deflated(ByteWriteChannel byteWriteChannel, boolean z, ObjectPool<ByteBuffer> objectPool, CoroutineContext coroutineContext) {
        byteWriteChannel.getClass();
        objectPool.getClass();
        coroutineContext.getClass();
        return ByteReadChannelOperationsKt.reader((CoroutineScope) GlobalScope.INSTANCE, coroutineContext.plus(DeflateReaderCoroutineName), true, (Function2) new AnonymousClass2(byteWriteChannel, z, objectPool, null)).getChannel();
    }

    private static final void deflateTo(Deflater deflater, ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            byteBuffer.position(byteBuffer.position() + deflater.deflate(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining()));
        }
    }
}
