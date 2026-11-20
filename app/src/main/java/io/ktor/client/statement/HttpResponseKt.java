package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.charsets.EncodingKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.JobImpl;
import kotlinx.io.Source;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\"\u0010\b\u001a\u00020\u0007*\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0086@¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000e\u0010\f\"\u001e\u0010\u0012\u001a\u00020\n*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0016\u001a\u00020\u0013*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "", "complete", "(Lio/ktor/client/statement/HttpResponse;)V", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "fallbackCharset", "", "bodyAsText", "(Lio/ktor/client/statement/HttpResponse;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "bodyAsChannel", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "bodyAsBytes", "getContent", "(Lio/ktor/client/statement/HttpResponse;)Lio/ktor/utils/io/ByteReadChannel;", "getContent$annotations", "content", "Lio/ktor/client/request/HttpRequest;", "getRequest", "(Lio/ktor/client/statement/HttpResponse;)Lio/ktor/client/request/HttpRequest;", "request", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpResponseKt {

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpResponseKt$bodyAsBytes$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", l = {147}, m = "bodyAsBytes", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpResponseKt.bodyAsBytes(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", l = {147}, m = "bodyAsChannel", v = 1)
    public static final class C02931 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02931(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpResponseKt.bodyAsChannel(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpResponseKt$bodyAsText$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", l = {147}, m = "bodyAsText", v = 1)
    public static final class C02941 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C02941(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpResponseKt.bodyAsText(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object bodyAsBytes(HttpResponse httpResponse, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        TypeReference typeReferenceTypeOf;
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
        Object objBodyNullable = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objBodyNullable);
            HttpClientCall call = httpResponse.getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(byte[].class);
            try {
                typeReferenceTypeOf = Reflection.typeOf(byte[].class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            objBodyNullable = call.bodyNullable(typeInfo, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objBodyNullable == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objBodyNullable);
        }
        if (objBodyNullable != null) {
            return (byte[]) objBodyNullable;
        }
        PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type kotlin.ByteArray");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object bodyAsChannel(HttpResponse httpResponse, Continuation continuation) {
        C02931 c02931;
        TypeReference typeReferenceTypeOf;
        if (continuation instanceof C02931) {
            c02931 = (C02931) continuation;
            int i = c02931.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02931.label = i - Integer.MIN_VALUE;
            } else {
                c02931 = new C02931(continuation);
            }
        } else {
            c02931 = new C02931(continuation);
        }
        Object objBodyNullable = c02931.result;
        int i2 = c02931.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objBodyNullable);
            HttpClientCall call = httpResponse.getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ByteReadChannel.class);
            try {
                typeReferenceTypeOf = Reflection.typeOf(ByteReadChannel.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            c02931.L$0 = null;
            c02931.L$1 = null;
            c02931.I$0 = 0;
            c02931.label = 1;
            objBodyNullable = call.bodyNullable(typeInfo, c02931);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objBodyNullable == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objBodyNullable);
        }
        if (objBodyNullable != null) {
            return (ByteReadChannel) objBodyNullable;
        }
        PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type io.ktor.utils.io.ByteReadChannel");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object bodyAsText(HttpResponse httpResponse, Charset charset, Continuation continuation) {
        C02941 c02941;
        TypeReference typeReferenceTypeOf;
        CharsetDecoder charsetDecoder;
        if (continuation instanceof C02941) {
            c02941 = (C02941) continuation;
            int i = c02941.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02941.label = i - Integer.MIN_VALUE;
            } else {
                c02941 = new C02941(continuation);
            }
        } else {
            c02941 = new C02941(continuation);
        }
        Object objBodyNullable = c02941.result;
        int i2 = c02941.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objBodyNullable);
            Charset charset2 = HttpMessagePropertiesKt.charset(httpResponse);
            if (charset2 != null) {
                charset = charset2;
            }
            CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
            HttpClientCall call = httpResponse.getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Source.class);
            try {
                typeReferenceTypeOf = Reflection.typeOf(Source.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            c02941.L$0 = null;
            c02941.L$1 = null;
            c02941.L$2 = null;
            c02941.L$3 = charsetDecoderNewDecoder;
            c02941.L$4 = null;
            c02941.I$0 = 0;
            c02941.label = 1;
            objBodyNullable = call.bodyNullable(typeInfo, c02941);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objBodyNullable == coroutineSingletons) {
                return coroutineSingletons;
            }
            charsetDecoder = charsetDecoderNewDecoder;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            charsetDecoder = (CharsetDecoder) c02941.L$3;
            ResultKt.throwOnFailure(objBodyNullable);
        }
        if (objBodyNullable != null) {
            charsetDecoder.getClass();
            return EncodingKt.decode$default(charsetDecoder, (Source) objBodyNullable, 0, 2, null);
        }
        PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type kotlinx.io.Source");
        return null;
    }

    public static /* synthetic */ Object bodyAsText$default(HttpResponse httpResponse, Charset charset, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return bodyAsText(httpResponse, charset, continuation);
    }

    public static final void complete(HttpResponse httpResponse) {
        httpResponse.getClass();
        ((JobImpl) ((CompletableJob) AwaitKt.getJob(httpResponse.getCoroutineContext()))).complete$1();
    }

    public static final ByteReadChannel getContent(HttpResponse httpResponse) {
        httpResponse.getClass();
        return httpResponse.getRawContent();
    }

    public static final HttpRequest getRequest(HttpResponse httpResponse) {
        httpResponse.getClass();
        return httpResponse.getCall().getRequest();
    }

    @Deprecated
    public static /* synthetic */ void getContent$annotations(HttpResponse httpResponse) {
    }
}
