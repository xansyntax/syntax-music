package io.ktor.http.content;

import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SafeFlow;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a8\u0010\n\u001a\u00020\u0007*\u00020\u00002\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0000H\u0087@¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/http/content/MultiPartData;", "Lkotlinx/coroutines/flow/Flow;", "Lio/ktor/http/content/PartData;", "asFlow", "(Lio/ktor/http/content/MultiPartData;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "partHandler", "forEachPart", "(Lio/ktor/http/content/MultiPartData;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "readAllParts", "(Lio/ktor/http/content/MultiPartData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MultipartKt {

    /* JADX INFO: renamed from: io.ktor.http.content.MultipartKt$asFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lio/ktor/http/content/PartData;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.content.MultipartKt$asFlow$1", f = "Multipart.kt", l = {176, 177}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ MultiPartData $this_asFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MultiPartData multiPartData, Continuation continuation) {
            super(2, continuation);
            this.$this_asFlow = multiPartData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0023  */
        /* JADX WARN: Code duplicated, block: B:14:0x0032 A[PHI: r7
          0x0032: PHI (r7v3 java.lang.Object) = (r7v2 java.lang.Object), (r7v0 java.lang.Object) binds: [B:12:0x002f, B:9:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:16:0x0036  */
        /* JADX WARN: Code duplicated, block: B:18:0x0039  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0043 -> B:11:0x0023). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                int r1 = r6.label
                r2 = 0
                r3 = 2
                r4 = 1
                kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                if (r1 == 0) goto L20
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L16
                java.lang.Object r1 = r6.L$1
                io.ktor.http.content.PartData r1 = (io.ktor.http.content.PartData) r1
                goto L20
            L16:
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r6)
                return r2
            L1c:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L32
            L20:
                kotlin.ResultKt.throwOnFailure(r7)
            L23:
                io.ktor.http.content.MultiPartData r7 = r6.$this_asFlow
                r6.L$0 = r0
                r6.L$1 = r2
                r6.label = r4
                java.lang.Object r7 = r7.readPart(r6)
                if (r7 != r5) goto L32
                goto L45
            L32:
                io.ktor.http.content.PartData r7 = (io.ktor.http.content.PartData) r7
                if (r7 != 0) goto L39
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            L39:
                r6.L$0 = r0
                r6.L$1 = r2
                r6.label = r3
                java.lang.Object r7 = r0.emit(r7, r6)
                if (r7 != r5) goto L23
            L45:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.content.MultipartKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.content.MultipartKt$readAllParts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.content.MultipartKt", f = "Multipart.kt", l = {200, 205}, m = "readAllParts", v = 1)
    public static final class C03151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03151(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.readAllParts(null, this);
        }
    }

    public static final Flow asFlow(MultiPartData multiPartData) {
        multiPartData.getClass();
        return new SafeFlow((byte) 0, new AnonymousClass1(multiPartData, null));
    }

    public static final Object forEachPart(MultiPartData multiPartData, Function2 function2, Continuation continuation) {
        Object objCollect = asFlow(multiPartData).collect(new MultipartKt$sam$kotlinx_coroutines_flow_FlowCollector$0(function2), continuation);
        return objCollect == CoroutineSingletons.COROUTINE_SUSPENDED ? objCollect : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        if (r8 == r5) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        if (r8 == r5) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:
    
        return r5;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:27:0x0074). Please report as a decompilation issue!!! */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object readAllParts(MultiPartData multiPartData, Continuation continuation) {
        C03151 c03151;
        MultiPartData multiPartData2;
        ArrayList arrayList;
        if (continuation instanceof C03151) {
            c03151 = (C03151) continuation;
            int i = c03151.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03151.label = i - Integer.MIN_VALUE;
            } else {
                c03151 = new C03151(continuation);
            }
        } else {
            c03151 = new C03151(continuation);
        }
        Object part = c03151.result;
        int i2 = c03151.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 != 0) {
            if (i2 == 1) {
                multiPartData = (MultiPartData) c03151.L$0;
                ResultKt.throwOnFailure(part);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                arrayList = (ArrayList) c03151.L$2;
                multiPartData2 = (MultiPartData) c03151.L$0;
                ResultKt.throwOnFailure(part);
            }
            PartData partData = (PartData) part;
            if (partData == null) {
                return arrayList;
            }
            arrayList.add(partData);
            c03151.L$0 = multiPartData2;
            c03151.L$1 = null;
            c03151.L$2 = arrayList;
            c03151.label = 2;
            part = multiPartData2.readPart(c03151);
        } else {
            ResultKt.throwOnFailure(part);
            c03151.L$0 = multiPartData;
            c03151.label = 1;
            part = multiPartData.readPart(c03151);
        }
        PartData partData2 = (PartData) part;
        if (partData2 == null) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(partData2);
        multiPartData2 = multiPartData;
        arrayList = arrayList2;
        c03151.L$0 = multiPartData2;
        c03151.L$1 = null;
        c03151.L$2 = arrayList;
        c03151.label = 2;
        part = multiPartData2.readPart(c03151);
    }
}
