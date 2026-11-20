package io.ktor.client.request.forms;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt__StringsKt;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fR&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R \u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00028\u0002X\u0082\u0004¢\u0006\f\n\u0004\b$\u0010\u0010\u0012\u0004\b%\u0010\u0014R(\u0010(\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lio/ktor/client/request/forms/MultiPartFormDataContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "", "Lio/ktor/http/content/PartData;", "parts", "", "boundary", "Lio/ktor/http/ContentType;", "contentType", "<init>", "(Ljava/util/List;Ljava/lang/String;Lio/ktor/http/ContentType;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "writeTo", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/List;", "getParts", "()Ljava/util/List;", "getParts$annotations", "()V", "Ljava/lang/String;", "getBoundary", "()Ljava/lang/String;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "", "BOUNDARY_BYTES", "[B", "LAST_BOUNDARY_BYTES", "", "BODY_OVERHEAD_SIZE", "I", "PART_OVERHEAD_SIZE", "Lio/ktor/client/request/forms/PreparedPart;", "rawParts", "getRawParts$annotations", "", "value", "contentLength", "Ljava/lang/Long;", "getContentLength", "()Ljava/lang/Long;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MultiPartFormDataContent extends OutgoingContent.WriteChannelContent {
    private final int BODY_OVERHEAD_SIZE;
    private final byte[] BOUNDARY_BYTES;
    private final byte[] LAST_BOUNDARY_BYTES;
    private final int PART_OVERHEAD_SIZE;
    private final String boundary;
    private Long contentLength;
    private final ContentType contentType;
    private final List<PartData> parts;
    private final List<PreparedPart> rawParts;

    /* JADX INFO: renamed from: io.ktor.client.request.forms.MultiPartFormDataContent$writeTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.request.forms.MultiPartFormDataContent", f = "FormDataContent.kt", l = {127, 128, 129, 134, 139, 143, 146, 150, 150, 150}, m = "writeTo", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultiPartFormDataContent.this.writeTo(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultiPartFormDataContent(List<? extends PartData> list, String str, ContentType contentType) throws EOFException {
        PreparedPart channelPart;
        list.getClass();
        str.getClass();
        contentType.getClass();
        this.parts = list;
        this.boundary = str;
        this.contentType = contentType;
        Long l = null;
        byte[] byteArray$default = StringsKt__StringsKt.toByteArray$default(IntIntPair$$ExternalSyntheticOutline0.m("--", str, ServerSentEventKt.END_OF_LINE), null, 1, null);
        this.BOUNDARY_BYTES = byteArray$default;
        byte[] byteArray$default2 = StringsKt__StringsKt.toByteArray$default(IntIntPair$$ExternalSyntheticOutline0.m("--", str, "--\r\n"), null, 1, null);
        this.LAST_BOUNDARY_BYTES = byteArray$default2;
        this.BODY_OVERHEAD_SIZE = byteArray$default2.length;
        this.PART_OVERHEAD_SIZE = (FormDataContentKt.RN_BYTES.length * 2) + byteArray$default.length;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (PartData partData : list) {
            Sink sinkBytePacketBuilder = BytePacketBuilderKt.BytePacketBuilder();
            for (Map.Entry<String, List<String>> entry : partData.getHeaders().entries()) {
                StringsKt__StringsKt.writeText$default(sinkBytePacketBuilder, entry.getKey() + ": " + CollectionsKt.joinToString$default(entry.getValue(), "; ", null, null, null, 62), 0, 0, (Charset) null, 14, (Object) null);
                BytePacketBuilderKt.writeFully$default(sinkBytePacketBuilder, FormDataContentKt.RN_BYTES, 0, 0, 6, null);
            }
            String str2 = partData.getHeaders().get(HttpHeaders.ContentLength);
            Long lValueOf = str2 != null ? Long.valueOf(Long.parseLong(str2)) : null;
            if (partData instanceof PartData.FileItem) {
                byte[] byteArray = Utf8Kt.readByteArray(BytePacketBuilderKt.build(sinkBytePacketBuilder));
                channelPart = new PreparedPart.ChannelPart(byteArray, ((PartData.FileItem) partData).getProvider(), lValueOf != null ? Long.valueOf(lValueOf.longValue() + ((long) this.PART_OVERHEAD_SIZE) + ((long) byteArray.length)) : null);
            } else if (partData instanceof PartData.BinaryItem) {
                byte[] byteArray2 = Utf8Kt.readByteArray(BytePacketBuilderKt.build(sinkBytePacketBuilder));
                channelPart = new PreparedPart.InputPart(byteArray2, ((PartData.BinaryItem) partData).getProvider(), lValueOf != null ? Long.valueOf(lValueOf.longValue() + ((long) this.PART_OVERHEAD_SIZE) + ((long) byteArray2.length)) : null);
            } else if (partData instanceof PartData.FormItem) {
                Buffer buffer = new Buffer();
                StringsKt__StringsKt.writeText$default(buffer, ((PartData.FormItem) partData).getValue(), 0, 0, (Charset) null, 14, (Object) null);
                byte[] byteArrayImpl = Utf8Kt.readByteArrayImpl(buffer, -1);
                FormDslKt$$ExternalSyntheticLambda3 formDslKt$$ExternalSyntheticLambda3 = new FormDslKt$$ExternalSyntheticLambda3(byteArrayImpl);
                if (lValueOf == null) {
                    StringsKt__StringsKt.writeText$default(sinkBytePacketBuilder, "Content-Length: " + byteArrayImpl.length, 0, 0, (Charset) null, 14, (Object) null);
                    BytePacketBuilderKt.writeFully$default(sinkBytePacketBuilder, FormDataContentKt.RN_BYTES, 0, 0, 6, null);
                }
                byte[] byteArray3 = Utf8Kt.readByteArray(BytePacketBuilderKt.build(sinkBytePacketBuilder));
                channelPart = new PreparedPart.InputPart(byteArray3, formDslKt$$ExternalSyntheticLambda3, Long.valueOf(byteArrayImpl.length + this.PART_OVERHEAD_SIZE + byteArray3.length));
            } else {
                if (!(partData instanceof PartData.BinaryChannelItem)) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    throw null;
                }
                byte[] byteArray4 = Utf8Kt.readByteArray(BytePacketBuilderKt.build(sinkBytePacketBuilder));
                channelPart = new PreparedPart.ChannelPart(byteArray4, ((PartData.BinaryChannelItem) partData).getProvider(), lValueOf != null ? Long.valueOf(lValueOf.longValue() + ((long) this.PART_OVERHEAD_SIZE) + ((long) byteArray4.length)) : null);
            }
            arrayList.add(channelPart);
        }
        this.rawParts = arrayList;
        Long lValueOf2 = 0L;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                l = lValueOf2;
                break;
            }
            Object obj = arrayList.get(i);
            i++;
            Long size2 = ((PreparedPart) obj).getSize();
            if (size2 == null) {
                break;
            } else if (lValueOf2 != null) {
                lValueOf2 = Long.valueOf(size2.longValue() + lValueOf2.longValue());
            } else {
                lValueOf2 = null;
            }
        }
        this.contentLength = l != null ? Long.valueOf(l.longValue() + ((long) this.BODY_OVERHEAD_SIZE)) : l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Source rawParts$lambda$0$1(byte[] bArr) {
        Buffer buffer = new Buffer();
        BytePacketBuilderKt.writeFully$default(buffer, bArr, 0, 0, 6, null);
        return buffer;
    }

    public final String getBoundary() {
        return this.boundary;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return this.contentLength;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    public final List<PartData> getParts() {
        return this.parts;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00dd A[Catch: all -> 0x01d7, TRY_LEAVE, TryCatch #7 {all -> 0x01d7, blocks: (B:47:0x00d7, B:49:0x00dd, B:99:0x01db), top: B:130:0x00d7 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:56:0x0119  */
    /* JADX WARN: Code duplicated, block: B:62:0x013c  */
    /* JADX WARN: Code duplicated, block: B:76:0x0178 A[Catch: all -> 0x00a6, TryCatch #5 {all -> 0x00a6, blocks: (B:63:0x0140, B:65:0x0144, B:69:0x016c, B:76:0x0178, B:78:0x017c, B:89:0x01c1, B:90:0x01c6, B:74:0x0174, B:75:0x0177, B:34:0x00a1, B:39:0x00b5, B:42:0x00c5, B:66:0x0151, B:29:0x008c, B:72:0x0172), top: B:127:0x0023, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x017c A[Catch: all -> 0x00a6, TRY_LEAVE, TryCatch #5 {all -> 0x00a6, blocks: (B:63:0x0140, B:65:0x0144, B:69:0x016c, B:76:0x0178, B:78:0x017c, B:89:0x01c1, B:90:0x01c6, B:74:0x0174, B:75:0x0177, B:34:0x00a1, B:39:0x00b5, B:42:0x00c5, B:66:0x0151, B:29:0x008c, B:72:0x0172), top: B:127:0x0023, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:81:0x0199  */
    /* JADX WARN: Code duplicated, block: B:86:0x01ba  */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0064: MOVE (r7 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:101), block:B:24:0x0064 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x01ba -> B:22:0x0060). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    public java.lang.Object writeTo(io.ktor.utils.io.ByteWriteChannel r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instruction units count: 592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.forms.MultiPartFormDataContent.writeTo(io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void getParts$annotations() {
    }

    private static /* synthetic */ void getRawParts$annotations() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MultiPartFormDataContent(List list, String str, ContentType contentType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        str = (i & 2) != 0 ? FormDataContentKt.generateBoundary() : str;
        this(list, str, (i & 4) != 0 ? ContentType.MultiPart.INSTANCE.getFormData().withParameter("boundary", str) : contentType);
    }
}
