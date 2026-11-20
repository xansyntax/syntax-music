package io.ktor.http.cio;

import com.yalantis.ucrop.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0003R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/http/cio/HeadersData;", "", "<init>", "()V", "", "arraysCount", "()I", "subArraysCount", "", "prepare", "(I)V", "index", "at", "(I)I", "value", "set", "(II)V", "Lkotlin/sequences/Sequence;", "headersStarts", "()Lkotlin/sequences/Sequence;", BuildConfig.BUILD_TYPE, "", "", "arrays", "Ljava/util/List;", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class HeadersData {
    private List<int[]> arrays = new ArrayList();

    /* JADX INFO: renamed from: io.ktor.http.cio.HeadersData$headersStarts$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HeadersData$headersStarts$1", f = "HttpHeadersMap.kt", l = {264}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2 {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = HeadersData.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0038  */
        /* JADX WARN: Code duplicated, block: B:19:0x0069  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0038 -> B:12:0x0041). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004b -> B:18:0x0064). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = r8.L$0
                kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
                int r1 = r8.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 != r3) goto L1d
                int r1 = r8.I$1
                int r4 = r8.I$0
                java.lang.Object r5 = r8.L$2
                int[] r5 = (int[]) r5
                java.lang.Object r6 = r8.L$1
                java.util.Iterator r6 = (java.util.Iterator) r6
                kotlin.ResultKt.throwOnFailure(r9)
                r9 = r6
                goto L64
            L1d:
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r8)
                r8 = 0
                return r8
            L24:
                kotlin.ResultKt.throwOnFailure(r9)
                io.ktor.http.cio.HeadersData r9 = io.ktor.http.cio.HeadersData.this
                java.util.List r9 = io.ktor.http.cio.HeadersData.access$getArrays$p(r9)
                java.util.Iterator r9 = r9.iterator()
                r1 = r2
            L32:
                boolean r4 = r9.hasNext()
                if (r4 == 0) goto L6b
                java.lang.Object r4 = r9.next()
                int[] r4 = (int[]) r4
                r5 = r4
                r4 = r1
                r1 = r2
            L41:
                int r6 = r5.length
                if (r1 >= r6) goto L69
                io.ktor.http.cio.HeadersData r6 = io.ktor.http.cio.HeadersData.this
                int r6 = r6.at(r4)
                r7 = -1
                if (r6 == r7) goto L64
                java.lang.Integer r2 = new java.lang.Integer
                r2.<init>(r4)
                r8.L$0 = r0
                r8.L$1 = r9
                r8.L$2 = r5
                r8.I$0 = r4
                r8.I$1 = r1
                r8.label = r3
                r0.yield(r2, r8)
                kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                return r8
            L64:
                int r1 = r1 + 6
                int r4 = r4 + 6
                goto L41
            L69:
                r1 = r4
                goto L32
            L6b:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HeadersData.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final int arraysCount() {
        return this.arrays.size();
    }

    public final int at(int index) {
        return this.arrays.get(index / 768)[index % 768];
    }

    public final Sequence headersStarts() {
        return new LinesSequence((byte) 3, new AnonymousClass1(null));
    }

    public final void prepare(int subArraysCount) {
        for (int i = 0; i < subArraysCount; i++) {
            this.arrays.add((int[]) HttpHeadersMapKt.IntArrayPool.borrow());
        }
    }

    public final void release() {
        Iterator<int[]> it = this.arrays.iterator();
        while (it.hasNext()) {
            HttpHeadersMapKt.IntArrayPool.recycle(it.next());
        }
        this.arrays.clear();
    }

    public final void set(int index, int value) {
        this.arrays.get(index / 768)[index % 768] = value;
    }
}
