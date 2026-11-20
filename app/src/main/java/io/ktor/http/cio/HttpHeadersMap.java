package io.ktor.http.cio;

import com.yalantis.ucrop.BuildConfig;
import io.ktor.http.ContentDisposition;
import io.ktor.http.cio.internals.CharArrayBuilder;
import io.ktor.http.cio.internals.CharsKt;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012¢\u0006\u0004\b\u0015\u0010\u0016J?\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010 J\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000bH\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000bH\u0007¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020\u001dH\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000b¢\u0006\u0004\b,\u0010%J\u0015\u0010-\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000b¢\u0006\u0004\b-\u0010%J\r\u0010.\u001a\u00020\u001d¢\u0006\u0004\b.\u0010(J\u0011\u0010/\u001a\u00020\tH\u0096\u0080\u0004¢\u0006\u0004\b/\u00100R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R$\u00103\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00104R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lio/ktor/http/cio/HttpHeadersMap;", "", "Lio/ktor/http/cio/internals/CharArrayBuilder;", "builder", "<init>", "(Lio/ktor/http/cio/internals/CharArrayBuilder;)V", "", "thresholdReached", "()Z", "", ContentDisposition.Parameters.Name, "", "fromIndex", "find", "(Ljava/lang/String;I)I", "", "get", "(Ljava/lang/String;)Ljava/lang/CharSequence;", "Lkotlin/sequences/Sequence;", "getAll", "(Ljava/lang/String;)Lkotlin/sequences/Sequence;", "offsets", "()Lkotlin/sequences/Sequence;", "nameHash", "valueHash", "nameStartIndex", "nameEndIndex", "valueStartIndex", "valueEndIndex", "", "put", "(IIIIII)V", "(IIII)V", "idx", "idxToOffset", "(I)I", "nameAt", "(I)Ljava/lang/CharSequence;", "valueAt", "resize", "()V", "headerOffset", "headerHasName", "(Ljava/lang/CharSequence;I)Z", "nameAtOffset", "valueAtOffset", BuildConfig.BUILD_TYPE, "toString", "()Ljava/lang/String;", "Lio/ktor/http/cio/internals/CharArrayBuilder;", "value", ContentDisposition.Parameters.Size, "I", "getSize", "()I", "headerCapacity", "Lio/ktor/http/cio/HeadersData;", "headersData", "Lio/ktor/http/cio/HeadersData;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpHeadersMap {
    private final CharArrayBuilder builder;
    private int headerCapacity;
    private HeadersData headersData;
    private int size;

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpHeadersMap$getAll$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpHeadersMap$getAll$1", f = "HttpHeadersMap.kt", l = {90}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2 {
        final /* synthetic */ String $name;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Continuation continuation) {
            super(2, continuation);
            this.$name = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = HttpHeadersMap.this.new AnonymousClass1(this.$name, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0059  */
        /* JADX WARN: Code duplicated, block: B:20:0x0077 A[LOOP:0: B:14:0x004b->B:20:0x0077, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:23:0x0065 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:24:0x007f A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int iAbs;
            int iAt;
            int i;
            boolean zHeaderHasName;
            HttpHeadersMap httpHeadersMap;
            SequenceScope sequenceScope = (SequenceScope) this.L$0;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (HttpHeadersMap.this.getSize() != 0) {
                    iAbs = Math.abs(CharsKt.hashCodeLowerCase$default(this.$name, 0, 0, 3, null));
                    iAt = iAbs % HttpHeadersMap.this.headerCapacity;
                    while (true) {
                        i = iAt * 6;
                        if (HttpHeadersMap.this.headersData.at(i) != -1) {
                            zHeaderHasName = HttpHeadersMap.this.headerHasName(this.$name, i);
                            httpHeadersMap = HttpHeadersMap.this;
                            if (zHeaderHasName) {
                                CharSequence charSequenceValueAtOffset = httpHeadersMap.valueAtOffset(i);
                                this.L$0 = sequenceScope;
                                this.I$0 = iAbs;
                                this.I$1 = iAt;
                                this.label = 1;
                                sequenceScope.yield(charSequenceValueAtOffset, this);
                                return CoroutineSingletons.COROUTINE_SUSPENDED;
                            }
                            iAt = (iAt + 1) % httpHeadersMap.headerCapacity;
                        }
                    }
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                int i3 = this.I$1;
                iAbs = this.I$0;
                ResultKt.throwOnFailure(obj);
                iAt = HttpHeadersMap.this.headersData.at((i3 * 6) + 5);
                if (iAt != -1) {
                    while (true) {
                        i = iAt * 6;
                        if (HttpHeadersMap.this.headersData.at(i) != -1) {
                            zHeaderHasName = HttpHeadersMap.this.headerHasName(this.$name, i);
                            httpHeadersMap = HttpHeadersMap.this;
                            if (zHeaderHasName) {
                                CharSequence charSequenceValueAtOffset2 = httpHeadersMap.valueAtOffset(i);
                                this.L$0 = sequenceScope;
                                this.I$0 = iAbs;
                                this.I$1 = iAt;
                                this.label = 1;
                                sequenceScope.yield(charSequenceValueAtOffset2, this);
                                return CoroutineSingletons.COROUTINE_SUSPENDED;
                            }
                            iAt = (iAt + 1) % httpHeadersMap.headerCapacity;
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public HttpHeadersMap(CharArrayBuilder charArrayBuilder) {
        charArrayBuilder.getClass();
        this.builder = charArrayBuilder;
        this.headersData = (HeadersData) HttpHeadersMapKt.HeadersDataPool.borrow();
    }

    public static /* synthetic */ int find$default(HttpHeadersMap httpHeadersMap, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return httpHeadersMap.find(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean headerHasName(CharSequence name, int headerOffset) {
        return CharsKt.equalsLowerCase(this.builder, this.headersData.at(headerOffset + 1), this.headersData.at(headerOffset + 2), name);
    }

    private final int idxToOffset(int idx) {
        if (idx < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return 0;
        }
        if (idx < this.size) {
            return ((Number) SequencesKt.last(SequencesKt.take(offsets(), idx + 1))).intValue();
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
        return 0;
    }

    private final void resize() {
        int i = this.size;
        HeadersData headersData = this.headersData;
        this.size = 0;
        this.headerCapacity = (this.headerCapacity * 2) | 128;
        HeadersData headersData2 = (HeadersData) HttpHeadersMapKt.HeadersDataPool.borrow();
        headersData2.prepare((headersData.arraysCount() * 2) | 1);
        this.headersData = headersData2;
        Iterator it = headersData.headersStarts().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            put(headersData.at(iIntValue + 1), headersData.at(iIntValue + 2), headersData.at(iIntValue + 3), headersData.at(iIntValue + 4));
        }
        HttpHeadersMapKt.HeadersDataPool.recycle(headersData);
        if (i == this.size) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
    }

    private final boolean thresholdReached() {
        return ((double) this.size) >= ((double) this.headerCapacity) * 0.75d;
    }

    @Deprecated
    public final int find(String name, int fromIndex) {
        name.getClass();
        if (this.size == 0) {
            return -1;
        }
        int iIdxToOffset = idxToOffset(fromIndex);
        while (this.headersData.at(iIdxToOffset) != -1) {
            if (headerHasName(name, iIdxToOffset)) {
                return fromIndex;
            }
            fromIndex++;
            iIdxToOffset = (iIdxToOffset / 6) % this.headerCapacity;
        }
        return -1;
    }

    public final CharSequence get(String name) {
        name.getClass();
        if (this.size == 0) {
            return null;
        }
        int iAbs = Math.abs(CharsKt.hashCodeLowerCase$default(name, 0, 0, 3, null));
        int i = this.headerCapacity;
        while (true) {
            int i2 = iAbs % i;
            int i3 = i2 * 6;
            if (this.headersData.at(i3) == -1) {
                return null;
            }
            if (headerHasName(name, i3)) {
                return valueAtOffset(i3);
            }
            iAbs = i2 + 1;
            i = this.headerCapacity;
        }
    }

    public final Sequence getAll(String name) {
        name.getClass();
        return new LinesSequence((byte) 3, new AnonymousClass1(name, null));
    }

    public final int getSize() {
        return this.size;
    }

    @Deprecated
    public final CharSequence nameAt(int idx) {
        return nameAtOffset(idxToOffset(idx));
    }

    public final CharSequence nameAtOffset(int headerOffset) {
        return this.builder.subSequence(this.headersData.at(headerOffset + 1), this.headersData.at(headerOffset + 2));
    }

    public final Sequence offsets() {
        return this.headersData.headersStarts();
    }

    public final void put(int nameStartIndex, int nameEndIndex, int valueStartIndex, int valueEndIndex) {
        int i;
        if (thresholdReached()) {
            resize();
        }
        int iAbs = Math.abs(CharsKt.hashCodeLowerCase(this.builder, nameStartIndex, nameEndIndex));
        CharSequence charSequenceSubSequence = this.builder.subSequence(nameStartIndex, nameEndIndex);
        int i2 = iAbs % this.headerCapacity;
        int i3 = -1;
        while (true) {
            i = i2 * 6;
            if (this.headersData.at(i) == -1) {
                break;
            }
            if (headerHasName(charSequenceSubSequence, i)) {
                i3 = i2;
            }
            i2 = (i2 + 1) % this.headerCapacity;
        }
        this.headersData.set(i, iAbs);
        this.headersData.set(i + 1, nameStartIndex);
        this.headersData.set(i + 2, nameEndIndex);
        this.headersData.set(i + 3, valueStartIndex);
        this.headersData.set(i + 4, valueEndIndex);
        this.headersData.set(i + 5, -1);
        if (i3 != -1) {
            this.headersData.set((i3 * 6) + 5, i2);
        }
        this.size++;
    }

    public final void release() {
        this.size = 0;
        this.headerCapacity = 0;
        HttpHeadersMapKt.HeadersDataPool.recycle(this.headersData);
        this.headersData = (HeadersData) HttpHeadersMapKt.HeadersDataPool.borrow();
    }

    public String toString() throws IOException {
        StringBuilder sb = new StringBuilder();
        HttpHeadersMapKt.dumpTo(this, "", sb);
        return sb.toString();
    }

    @Deprecated
    public final CharSequence valueAt(int idx) {
        return valueAtOffset(idxToOffset(idx));
    }

    public final CharSequence valueAtOffset(int headerOffset) {
        return this.builder.subSequence(this.headersData.at(headerOffset + 3), this.headersData.at(headerOffset + 4));
    }

    @Deprecated
    public final void put(int nameHash, int valueHash, int nameStartIndex, int nameEndIndex, int valueStartIndex, int valueEndIndex) {
        put(nameStartIndex, nameEndIndex, valueStartIndex, valueEndIndex);
    }
}
