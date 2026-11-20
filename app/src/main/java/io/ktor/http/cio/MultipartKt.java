package io.ktor.http.cio;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.cio.internals.CharArrayBuilder;
import io.ktor.http.cio.internals.UnsupportedMediaTypeExceptionCIO;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.StringsKt__StringsKt;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.io.bytestring.ByteString;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\u001a2\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\b\u0010\t\u001a\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@¢\u0006\u0004\b\u000b\u0010\f\u001a8\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0012\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0000H\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\u001a1\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019\u001a;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u001d\u001a;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00142\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u001f\u001a\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b!\u0010\"\u001a\u0017\u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)\"\u0014\u0010*\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010-\u001a\u00020,8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.\"\u0014\u0010/\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010+¨\u00060"}, d2 = {"Lkotlinx/io/bytestring/ByteString;", "boundary", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "limit", "parsePreambleImpl", "(Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/cio/HttpHeadersMap;", "parsePartHeadersImpl", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundaryPrefixed", "headers", "parsePartBodyImpl", "(Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/http/cio/HttpHeadersMap;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prefix", "skipIfFoundReadCount", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "maxPartSize", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lio/ktor/http/cio/MultipartEvent;", "parseMultipart", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/cio/HttpHeadersMap;J)Lkotlinx/coroutines/channels/ReceiveChannel;", "", "contentType", "contentLength", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/CharSequence;Ljava/lang/Long;J)Lkotlinx/coroutines/channels/ReceiveChannel;", "totalLength", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Long;J)Lkotlinx/coroutines/channels/ReceiveChannel;", "", "findBoundary", "(Ljava/lang/CharSequence;)I", "", "parseBoundaryInternal", "(Ljava/lang/CharSequence;)[B", "actual", "", "throwLimitExceeded", "(JJ)Ljava/lang/Void;", "CrLf", "Lkotlinx/io/bytestring/ByteString;", "", "PrefixChar", "B", "PrefixString", "ktor-http-cio"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MultipartKt {
    private static final ByteString CrLf = new ByteString(StringsKt__StringsKt.toByteArray$default(ServerSentEventKt.END_OF_LINE, null, 1, null), 0);
    private static final byte PrefixChar = 45;
    private static final ByteString PrefixString = new ByteString(new byte[]{PrefixChar, PrefixChar});

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartKt$parseMultipart$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lio/ktor/http/cio/MultipartEvent;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartKt$parseMultipart$1", f = "Multipart.kt", l = {232, 235, 238, 239, 242, 249, 253, 260, 272, 273, 280, 280, 283, 285}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ ByteString $boundaryPrefixed;
        final /* synthetic */ ByteReadChannel $input;
        final /* synthetic */ long $maxPartSize;
        final /* synthetic */ Long $totalLength;
        long J$0;
        long J$1;
        long J$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ByteReadChannel byteReadChannel, ByteString byteString, long j, Long l, Continuation continuation) {
            super(2, continuation);
            this.$input = byteReadChannel;
            this.$boundaryPrefixed = byteString;
            this.$maxPartSize = j;
            this.$totalLength = l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, this.$boundaryPrefixed, this.$maxPartSize, this.$totalLength, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope producerScope, Continuation continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:42:0x01e9 A[PHI: r0 r1 r2 r3 r5 r13
          0x01e9: PHI (r0v61 kotlinx.io.bytestring.ByteString) = 
          (r0v5 kotlinx.io.bytestring.ByteString)
          (r0v5 kotlinx.io.bytestring.ByteString)
          (r0v11 kotlinx.io.bytestring.ByteString)
          (r0v58 kotlinx.io.bytestring.ByteString)
          (r0v62 kotlinx.io.bytestring.ByteString)
         binds: [B:38:0x01c9, B:40:0x01e6, B:27:0x0151, B:56:0x024a, B:76:0x02e1] A[DONT_GENERATE, DONT_INLINE]
          0x01e9: PHI (r1v15 ??) = 
          (r1v30 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY])
          (r1v31 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY])
          (r1v0 ??)
          (r1v38 ??)
          (r1v17 ??)
         binds: [B:38:0x01c9, B:40:0x01e6, B:27:0x0151, B:56:0x024a, B:76:0x02e1] A[DONT_GENERATE, DONT_INLINE]
          0x01e9: PHI (r2v11 kotlin.coroutines.intrinsics.CoroutineSingletons) = 
          (r2v0 kotlin.coroutines.intrinsics.CoroutineSingletons)
          (r2v0 kotlin.coroutines.intrinsics.CoroutineSingletons)
          (r2v0 kotlin.coroutines.intrinsics.CoroutineSingletons)
          (r2v8 kotlin.coroutines.intrinsics.CoroutineSingletons)
          (r2v12 kotlin.coroutines.intrinsics.CoroutineSingletons)
         binds: [B:38:0x01c9, B:40:0x01e6, B:27:0x0151, B:56:0x024a, B:76:0x02e1] A[DONT_GENERATE, DONT_INLINE]
          0x01e9: PHI (r3v23 long) = (r3v1 long), (r3v1 long), (r3v3 long), (r3v20 long), (r3v24 long) binds: [B:38:0x01c9, B:40:0x01e6, B:27:0x0151, B:56:0x024a, B:76:0x02e1] A[DONT_GENERATE, DONT_INLINE]
          0x01e9: PHI (r5v29 io.ktor.utils.io.CountedByteReadChannel) = 
          (r5v6 io.ktor.utils.io.CountedByteReadChannel)
          (r5v6 io.ktor.utils.io.CountedByteReadChannel)
          (r5v10 io.ktor.utils.io.CountedByteReadChannel)
          (r5v26 io.ktor.utils.io.CountedByteReadChannel)
          (r5v30 io.ktor.utils.io.CountedByteReadChannel)
         binds: [B:38:0x01c9, B:40:0x01e6, B:27:0x0151, B:56:0x024a, B:76:0x02e1] A[DONT_GENERATE, DONT_INLINE]
          0x01e9: PHI (r13v11 long) = (r13v0 long), (r13v0 long), (r13v0 long), (r13v8 long), (r13v13 long) binds: [B:38:0x01c9, B:40:0x01e6, B:27:0x0151, B:56:0x024a, B:76:0x02e1] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:44:0x01ef  */
        /* JADX WARN: Code duplicated, block: B:47:0x020f A[PHI: r0 r1 r2 r3 r5 r8 r13
          0x020f: PHI (r0v60 kotlinx.io.bytestring.ByteString) = (r0v15 kotlinx.io.bytestring.ByteString), (r0v61 kotlinx.io.bytestring.ByteString) binds: [B:26:0x013c, B:45:0x020c] A[DONT_GENERATE, DONT_INLINE]
          0x020f: PHI (r1v14 ??) = (r1v32 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r1v39 ??) binds: [B:26:0x013c, B:45:0x020c] A[DONT_GENERATE, DONT_INLINE]
          0x020f: PHI (r2v10 kotlin.coroutines.intrinsics.CoroutineSingletons) = (r2v0 kotlin.coroutines.intrinsics.CoroutineSingletons), (r2v11 kotlin.coroutines.intrinsics.CoroutineSingletons) binds: [B:26:0x013c, B:45:0x020c] A[DONT_GENERATE, DONT_INLINE]
          0x020f: PHI (r3v22 long) = (r3v4 long), (r3v23 long) binds: [B:26:0x013c, B:45:0x020c] A[DONT_GENERATE, DONT_INLINE]
          0x020f: PHI (r5v28 io.ktor.utils.io.CountedByteReadChannel) = (r5v12 io.ktor.utils.io.CountedByteReadChannel), (r5v29 io.ktor.utils.io.CountedByteReadChannel) binds: [B:26:0x013c, B:45:0x020c] A[DONT_GENERATE, DONT_INLINE]
          0x020f: PHI (r8v39 java.lang.Object) = (r8v15 java.lang.Object), (r8v46 java.lang.Object) binds: [B:26:0x013c, B:45:0x020c] A[DONT_GENERATE, DONT_INLINE]
          0x020f: PHI (r13v10 long) = (r13v0 long), (r13v11 long) binds: [B:26:0x013c, B:45:0x020c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:49:0x0217  */
        /* JADX WARN: Code duplicated, block: B:52:0x022f A[PHI: r0 r1 r2 r3 r5 r13
          0x022f: PHI (r0v59 kotlinx.io.bytestring.ByteString) = (r0v19 kotlinx.io.bytestring.ByteString), (r0v60 kotlinx.io.bytestring.ByteString) binds: [B:25:0x0129, B:50:0x022c] A[DONT_GENERATE, DONT_INLINE]
          0x022f: PHI (r1v13 ??) = (r1v33 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r1v40 ??) binds: [B:25:0x0129, B:50:0x022c] A[DONT_GENERATE, DONT_INLINE]
          0x022f: PHI (r2v9 kotlin.coroutines.intrinsics.CoroutineSingletons) = (r2v0 kotlin.coroutines.intrinsics.CoroutineSingletons), (r2v10 kotlin.coroutines.intrinsics.CoroutineSingletons) binds: [B:25:0x0129, B:50:0x022c] A[DONT_GENERATE, DONT_INLINE]
          0x022f: PHI (r3v21 long) = (r3v5 long), (r3v22 long) binds: [B:25:0x0129, B:50:0x022c] A[DONT_GENERATE, DONT_INLINE]
          0x022f: PHI (r5v27 io.ktor.utils.io.CountedByteReadChannel) = (r5v14 io.ktor.utils.io.CountedByteReadChannel), (r5v28 io.ktor.utils.io.CountedByteReadChannel) binds: [B:25:0x0129, B:50:0x022c] A[DONT_GENERATE, DONT_INLINE]
          0x022f: PHI (r13v9 long) = (r13v0 long), (r13v10 long) binds: [B:25:0x0129, B:50:0x022c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:55:0x0244 A[PHI: r0 r1 r2 r3 r5 r8 r13
          0x0244: PHI (r0v58 kotlinx.io.bytestring.ByteString) = (r0v23 kotlinx.io.bytestring.ByteString), (r0v59 kotlinx.io.bytestring.ByteString) binds: [B:24:0x0114, B:53:0x0240] A[DONT_GENERATE, DONT_INLINE]
          0x0244: PHI (r1v12 ??) = (r1v34 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r1v41 ??) binds: [B:24:0x0114, B:53:0x0240] A[DONT_GENERATE, DONT_INLINE]
          0x0244: PHI (r2v8 kotlin.coroutines.intrinsics.CoroutineSingletons) = (r2v0 kotlin.coroutines.intrinsics.CoroutineSingletons), (r2v9 kotlin.coroutines.intrinsics.CoroutineSingletons) binds: [B:24:0x0114, B:53:0x0240] A[DONT_GENERATE, DONT_INLINE]
          0x0244: PHI (r3v20 long) = (r3v6 long), (r3v21 long) binds: [B:24:0x0114, B:53:0x0240] A[DONT_GENERATE, DONT_INLINE]
          0x0244: PHI (r5v26 io.ktor.utils.io.CountedByteReadChannel) = (r5v16 io.ktor.utils.io.CountedByteReadChannel), (r5v27 io.ktor.utils.io.CountedByteReadChannel) binds: [B:24:0x0114, B:53:0x0240] A[DONT_GENERATE, DONT_INLINE]
          0x0244: PHI (r8v32 java.lang.Object) = (r8v16 java.lang.Object), (r8v38 java.lang.Object) binds: [B:24:0x0114, B:53:0x0240] A[DONT_GENERATE, DONT_INLINE]
          0x0244: PHI (r13v8 long) = (r13v0 long), (r13v9 long) binds: [B:24:0x0114, B:53:0x0240] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:39:0x01cb, B:42:0x01e9], limit reached: 132 */
        /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r12v11 */
        /* JADX WARN: Type inference failed for: r12v12, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r12v13 */
        /* JADX WARN: Type inference failed for: r12v14, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r12v15 */
        /* JADX WARN: Type inference failed for: r12v16 */
        /* JADX WARN: Type inference failed for: r12v17 */
        /* JADX WARN: Type inference failed for: r12v18 */
        /* JADX WARN: Type inference failed for: r12v19 */
        /* JADX WARN: Type inference failed for: r12v2 */
        /* JADX WARN: Type inference failed for: r12v4 */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v6 */
        /* JADX WARN: Type inference failed for: r12v7 */
        /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r12v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Object, kotlin.jvm.internal.DefaultConstructorMarker] */
        /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v31 */
        /* JADX WARN: Type inference failed for: r1v32 */
        /* JADX WARN: Type inference failed for: r1v33 */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v35 */
        /* JADX WARN: Type inference failed for: r1v36 */
        /* JADX WARN: Type inference failed for: r1v37 */
        /* JADX WARN: Type inference failed for: r1v38 */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v4, types: [io.ktor.http.cio.HttpHeadersMap] */
        /* JADX WARN: Type inference failed for: r1v40 */
        /* JADX WARN: Type inference failed for: r1v41 */
        /* JADX WARN: Type inference failed for: r1v42 */
        /* JADX WARN: Type inference failed for: r1v43 */
        /* JADX WARN: Type inference failed for: r1v44 */
        /* JADX WARN: Type inference failed for: r1v45 */
        /* JADX WARN: Type inference failed for: r1v46 */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x024a -> B:42:0x01e9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x02d8 -> B:75:0x02de). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 1056
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartKt$parsePartBodyImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", l = {156, 157, 157, 160}, m = "parsePartBodyImpl", v = 1)
    public static final class C03111 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C03111(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.parsePartBodyImpl(null, null, null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartKt$parsePartHeadersImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", l = {137}, m = "parsePartHeadersImpl", v = 1)
    public static final class C03121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03121(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.parsePartHeadersImpl(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartKt$skipIfFoundReadCount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", l = {167}, m = "skipIfFoundReadCount", v = 1)
    public static final class C03131 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C03131(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.skipIfFoundReadCount(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0023  */
    /* JADX WARN: Code duplicated, block: B:28:0x0040  */
    private static final int findBoundary(CharSequence charSequence) {
        CharSequence charSequence2;
        int length = charSequence.length();
        int i = 0;
        char c = 0;
        int i2 = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (c == 0) {
                i = i;
                charSequence2 = charSequence;
                if (cCharAt == ';') {
                    i2 = 0;
                    c = 1;
                }
            } else if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c == 4) {
                            c = 3;
                        }
                    } else if (cCharAt == '\"') {
                        i2 = 0;
                        c = 1;
                    } else if (cCharAt == '\\') {
                        c = 4;
                    }
                } else if (cCharAt == '\"') {
                    c = 3;
                } else if (cCharAt == ',') {
                    c = 0;
                } else if (cCharAt == ';') {
                    i2 = 0;
                    c = 1;
                }
                charSequence2 = charSequence;
            } else if (cCharAt == '=') {
                c = 2;
                charSequence2 = charSequence;
            } else {
                if (cCharAt == ';') {
                    i2 = 0;
                } else if (cCharAt == ',') {
                    c = 0;
                } else if (cCharAt != ' ') {
                    if (i2 == 0) {
                        CharSequence charSequence3 = charSequence;
                        boolean zRegionMatchesImpl = StringsKt.regionMatchesImpl(charSequence3, i, "boundary=", 0, "boundary=".length(), true);
                        i = i;
                        charSequence2 = charSequence3;
                        if (zRegionMatchesImpl) {
                            return i;
                        }
                    } else {
                        i = i;
                        charSequence2 = charSequence;
                    }
                    i2++;
                }
                charSequence2 = charSequence;
            }
            CharSequence charSequence4 = charSequence2;
            i++;
            charSequence = charSequence4;
        }
        return -1;
    }

    public static final byte[] parseBoundaryInternal(CharSequence charSequence) throws IOException {
        charSequence.getClass();
        int iFindBoundary = findBoundary(charSequence);
        if (iFindBoundary == -1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Failed to parse multipart: Content-Type's boundary parameter is missing");
            return null;
        }
        byte[] bArr = new byte[74];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        parseBoundaryInternal$put(ref$IntRef, bArr, (byte) 13);
        parseBoundaryInternal$put(ref$IntRef, bArr, (byte) 10);
        parseBoundaryInternal$put(ref$IntRef, bArr, PrefixChar);
        parseBoundaryInternal$put(ref$IntRef, bArr, PrefixChar);
        int length = charSequence.length();
        char c = 0;
        for (int i = iFindBoundary + 9; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            int i2 = 65535 & cCharAt;
            if (i2 > 127) {
                CharsKt.checkRadix(16);
                String string = Integer.toString(i2, 16);
                string.getClass();
                throw new IOException("Failed to parse multipart: wrong boundary byte 0x" + string + " - should be 7bit character");
            }
            if (c != 0) {
                if (c == 1) {
                    if (cCharAt == ' ' || cCharAt == ',' || cCharAt == ';') {
                        break;
                    }
                    parseBoundaryInternal$put(ref$IntRef, bArr, (byte) i2);
                } else if (c == 2) {
                    if (cCharAt == '\"') {
                        break;
                    }
                    if (cCharAt != '\\') {
                        parseBoundaryInternal$put(ref$IntRef, bArr, (byte) i2);
                    } else {
                        c = 3;
                    }
                } else if (c == 3) {
                    parseBoundaryInternal$put(ref$IntRef, bArr, (byte) i2);
                    c = 2;
                }
            } else if (cCharAt == ' ') {
                continue;
            } else if (cCharAt == '\"') {
                c = 2;
            } else {
                if (cCharAt == ',' || cCharAt == ';') {
                    break;
                }
                parseBoundaryInternal$put(ref$IntRef, bArr, (byte) i2);
                c = 1;
            }
        }
        int i3 = ref$IntRef.element;
        if (i3 != 4) {
            return ArraysKt.copyOfRange(bArr, 0, i3);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Empty multipart boundary is not allowed");
        return null;
    }

    private static final void parseBoundaryInternal$put(Ref$IntRef ref$IntRef, byte[] bArr, byte b) throws IOException {
        int i = ref$IntRef.element;
        if (i >= bArr.length) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("Failed to parse multipart: boundary shouldn't be longer than 70 characters");
        } else {
            ref$IntRef.element = i + 1;
            bArr[i] = b;
        }
    }

    public static final ReceiveChannel parseMultipart(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, CharSequence charSequence, Long l, long j) throws UnsupportedMediaTypeExceptionCIO {
        coroutineScope.getClass();
        byteReadChannel.getClass();
        charSequence.getClass();
        if (ContentType.MultiPart.INSTANCE.contains(charSequence)) {
            return parseMultipart(coroutineScope, new ByteString(parseBoundaryInternal(charSequence), 0), byteReadChannel, l, j);
        }
        throw new UnsupportedMediaTypeExceptionCIO("Failed to parse multipart: Content-Type should be multipart/* but it is " + ((Object) charSequence));
    }

    public static /* synthetic */ ReceiveChannel parseMultipart$default(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, CharSequence charSequence, Long l, long j, int i, Object obj) {
        if ((i & 8) != 0) {
            j = Long.MAX_VALUE;
        }
        return parseMultipart(coroutineScope, byteReadChannel, charSequence, l, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x013a  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e5, code lost:
    
        if (r0 == r11) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0158, code lost:
    
        if (r5.flush(r6) == r11) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object parsePartBodyImpl(ByteString byteString, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, HttpHeadersMap httpHeadersMap, long j, Continuation continuation) throws Throwable {
        C03111 c03111;
        ByteReadChannel byteReadChannel2;
        ByteString byteString2;
        Object objCopyTo;
        ByteWriteChannel byteWriteChannel2;
        long jLongValue;
        long jLongValue2;
        long j2;
        ByteWriteChannel byteWriteChannel3 = byteWriteChannel;
        long j3 = j;
        if (continuation instanceof C03111) {
            c03111 = (C03111) continuation;
            int i = c03111.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03111.label = i - Integer.MIN_VALUE;
            } else {
                c03111 = new C03111(continuation);
            }
        } else {
            c03111 = new C03111(continuation);
        }
        C03111 c03112 = c03111;
        Object until = c03112.result;
        int i2 = c03112.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(until);
            CharSequence charSequence = httpHeadersMap.get(HttpHeaders.ContentLength);
            Long l = charSequence != null ? new Long(io.ktor.http.cio.internals.CharsKt.parseDecLong(charSequence)) : null;
            if (l == null) {
                c03112.L$0 = null;
                c03112.L$1 = null;
                c03112.L$2 = byteWriteChannel3;
                c03112.L$3 = null;
                c03112.L$4 = null;
                c03112.J$0 = j3;
                c03112.label = 1;
                until = ByteReadChannelOperationsKt.readUntil(byteReadChannel, byteString, byteWriteChannel3, j3, true, c03112);
            } else {
                byteReadChannel2 = byteReadChannel;
                long jLongValue3 = l.longValue();
                if (0 > jLongValue3 || jLongValue3 > j3) {
                    throwLimitExceeded(l.longValue(), j3);
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return null;
                }
                long jLongValue4 = l.longValue();
                byteString2 = byteString;
                c03112.L$0 = byteString2;
                c03112.L$1 = byteReadChannel2;
                c03112.L$2 = byteWriteChannel3;
                c03112.L$3 = null;
                c03112.L$4 = null;
                c03112.J$0 = j3;
                c03112.label = 2;
                objCopyTo = ByteReadChannelOperationsKt.copyTo(byteReadChannel2, byteWriteChannel3, jLongValue4, c03112);
                if (objCopyTo != coroutineSingletons) {
                    jLongValue2 = ((Number) objCopyTo).longValue();
                    c03112.L$0 = null;
                    c03112.L$1 = null;
                    c03112.L$2 = byteWriteChannel3;
                    c03112.L$3 = null;
                    c03112.L$4 = null;
                    c03112.J$0 = j3;
                    c03112.J$1 = jLongValue2;
                    c03112.label = 3;
                    until = skipIfFoundReadCount(byteReadChannel2, byteString2, c03112);
                    if (until != coroutineSingletons) {
                        byteWriteChannel2 = byteWriteChannel3;
                        j2 = jLongValue2;
                        jLongValue = ((Number) until).longValue() + j2;
                        c03112.L$0 = null;
                        c03112.L$1 = null;
                        c03112.L$2 = null;
                        c03112.L$3 = null;
                        c03112.L$4 = null;
                        c03112.J$0 = j3;
                        c03112.J$1 = jLongValue;
                        c03112.label = 4;
                    }
                }
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            long j4 = c03112.J$0;
            ByteWriteChannel byteWriteChannel4 = (ByteWriteChannel) c03112.L$2;
            ResultKt.throwOnFailure(until);
            byteWriteChannel3 = byteWriteChannel4;
            j3 = j4;
            byteWriteChannel2 = byteWriteChannel3;
            jLongValue = ((Number) until).longValue();
            c03112.L$0 = null;
            c03112.L$1 = null;
            c03112.L$2 = null;
            c03112.L$3 = null;
            c03112.L$4 = null;
            c03112.J$0 = j3;
            c03112.J$1 = jLongValue;
            c03112.label = 4;
        } else {
            if (i2 == 2) {
                long j5 = c03112.J$0;
                ByteWriteChannel byteWriteChannel5 = (ByteWriteChannel) c03112.L$2;
                ByteReadChannel byteReadChannel3 = (ByteReadChannel) c03112.L$1;
                ByteString byteString3 = (ByteString) c03112.L$0;
                ResultKt.throwOnFailure(until);
                objCopyTo = until;
                byteReadChannel2 = byteReadChannel3;
                byteWriteChannel3 = byteWriteChannel5;
                j3 = j5;
                byteString2 = byteString3;
                jLongValue2 = ((Number) objCopyTo).longValue();
                c03112.L$0 = null;
                c03112.L$1 = null;
                c03112.L$2 = byteWriteChannel3;
                c03112.L$3 = null;
                c03112.L$4 = null;
                c03112.J$0 = j3;
                c03112.J$1 = jLongValue2;
                c03112.label = 3;
                until = skipIfFoundReadCount(byteReadChannel2, byteString2, c03112);
                if (until != coroutineSingletons) {
                    byteWriteChannel2 = byteWriteChannel3;
                    j2 = jLongValue2;
                    jLongValue = ((Number) until).longValue() + j2;
                    c03112.L$0 = null;
                    c03112.L$1 = null;
                    c03112.L$2 = null;
                    c03112.L$3 = null;
                    c03112.L$4 = null;
                    c03112.J$0 = j3;
                    c03112.J$1 = jLongValue;
                    c03112.label = 4;
                }
                return coroutineSingletons;
            }
            if (i2 == 3) {
                j2 = c03112.J$1;
                j3 = c03112.J$0;
                byteWriteChannel2 = (ByteWriteChannel) c03112.L$2;
                ResultKt.throwOnFailure(until);
                jLongValue = ((Number) until).longValue() + j2;
                c03112.L$0 = null;
                c03112.L$1 = null;
                c03112.L$2 = null;
                c03112.L$3 = null;
                c03112.L$4 = null;
                c03112.J$0 = j3;
                c03112.J$1 = jLongValue;
                c03112.label = 4;
            } else {
                if (i2 != 4) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                jLongValue = c03112.J$1;
                ResultKt.throwOnFailure(until);
            }
        }
        return new Long(jLongValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object parsePartHeadersImpl(ByteReadChannel byteReadChannel, Continuation continuation) throws Throwable {
        C03121 c03121;
        Throwable th;
        CharArrayBuilder charArrayBuilder;
        if (continuation instanceof C03121) {
            c03121 = (C03121) continuation;
            int i = c03121.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03121.label = i - Integer.MIN_VALUE;
            } else {
                c03121 = new C03121(continuation);
            }
        } else {
            c03121 = new C03121(continuation);
        }
        C03121 c03122 = c03121;
        Object headers$default = c03122.result;
        int i2 = c03122.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(headers$default);
            CharArrayBuilder charArrayBuilder2 = new CharArrayBuilder(null, 1, null);
            try {
                c03122.L$0 = null;
                c03122.L$1 = charArrayBuilder2;
                c03122.label = 1;
                headers$default = HttpParserKt.parseHeaders$default(byteReadChannel, charArrayBuilder2, null, c03122, 4, null);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (headers$default == coroutineSingletons) {
                    return coroutineSingletons;
                }
                charArrayBuilder = charArrayBuilder2;
            } catch (Throwable th2) {
                th = th2;
                charArrayBuilder = charArrayBuilder2;
                charArrayBuilder.release();
                throw th;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            charArrayBuilder = (CharArrayBuilder) c03122.L$1;
            try {
                ResultKt.throwOnFailure(headers$default);
            } catch (Throwable th3) {
                th = th3;
                charArrayBuilder.release();
                throw th;
            }
        }
        HttpHeadersMap httpHeadersMap = (HttpHeadersMap) headers$default;
        if (httpHeadersMap != null) {
            return httpHeadersMap;
        }
        throw new EOFException("Failed to parse multipart headers: unexpected end of stream");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parsePreambleImpl(ByteString byteString, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation) {
        return ByteReadChannelOperationsKt.readUntil(byteReadChannel, byteString, byteWriteChannel, j, true, continuation);
    }

    public static /* synthetic */ Object parsePreambleImpl$default(ByteString byteString, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            j = Long.MAX_VALUE;
        }
        return parsePreambleImpl(byteString, byteReadChannel, byteWriteChannel, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object skipIfFoundReadCount(ByteReadChannel byteReadChannel, ByteString byteString, Continuation continuation) {
        C03131 c03131;
        if (continuation instanceof C03131) {
            c03131 = (C03131) continuation;
            int i = c03131.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03131.label = i - Integer.MIN_VALUE;
            } else {
                c03131 = new C03131(continuation);
            }
        } else {
            c03131 = new C03131(continuation);
        }
        Object objSkipIfFound = c03131.result;
        int i2 = c03131.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSkipIfFound);
            c03131.L$0 = null;
            c03131.L$1 = byteString;
            c03131.label = 1;
            objSkipIfFound = ByteReadChannelOperationsKt.skipIfFound(byteReadChannel, byteString, c03131);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objSkipIfFound == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            byteString = (ByteString) c03131.L$1;
            ResultKt.throwOnFailure(objSkipIfFound);
        }
        return new Long(((Boolean) objSkipIfFound).booleanValue() ? byteString.data.length : 0L);
    }

    private static final Void throwLimitExceeded(long j, long j2) throws IOException {
        throw new IOException(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(j, "Multipart content length exceeds limit ", " > "), j2, "; limit is defined using 'formFieldLimit' argument"));
    }

    public static /* synthetic */ ReceiveChannel parseMultipart$default(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, HttpHeadersMap httpHeadersMap, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = Long.MAX_VALUE;
        }
        return parseMultipart(coroutineScope, byteReadChannel, httpHeadersMap, j);
    }

    public static final ReceiveChannel parseMultipart(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, HttpHeadersMap httpHeadersMap, long j) throws UnsupportedMediaTypeExceptionCIO {
        coroutineScope.getClass();
        byteReadChannel.getClass();
        httpHeadersMap.getClass();
        CharSequence charSequence = httpHeadersMap.get(HttpHeaders.ContentType);
        if (charSequence != null) {
            CharSequence charSequence2 = httpHeadersMap.get(HttpHeaders.ContentLength);
            return parseMultipart(coroutineScope, byteReadChannel, charSequence, charSequence2 != null ? Long.valueOf(io.ktor.http.cio.internals.CharsKt.parseDecLong(charSequence2)) : null, j);
        }
        throw new UnsupportedMediaTypeExceptionCIO("Failed to parse multipart: no Content-Type header");
    }

    private static final ReceiveChannel parseMultipart(CoroutineScope coroutineScope, ByteString byteString, ByteReadChannel byteReadChannel, Long l, long j) {
        return HexFormatKt.produce$default(coroutineScope, null, new AnonymousClass1(byteReadChannel, byteString, j, l, null), 3);
    }
}
