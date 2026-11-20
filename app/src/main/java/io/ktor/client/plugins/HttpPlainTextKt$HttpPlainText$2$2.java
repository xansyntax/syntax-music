package io.ktor.client.plugins;

import io.ktor.client.plugins.api.TransformResponseBodyContext;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.io.Buffer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/api/TransformResponseBodyContext;", "response", "Lio/ktor/client/statement/HttpResponse;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "requestedType", "Lio/ktor/util/reflect/TypeInfo;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$2$2", f = "HttpPlainText.kt", l = {151}, m = "invokeSuspend", v = 1)
public final class HttpPlainTextKt$HttpPlainText$2$2 extends SuspendLambda implements Function5 {
    final /* synthetic */ Charset $responseCharsetFallback;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpPlainTextKt$HttpPlainText$2$2(Charset charset, Continuation continuation) {
        super(5, continuation);
        this.$responseCharsetFallback = charset;
    }

    @Override // kotlin.jvm.functions.Function5
    public final Object invoke(TransformResponseBodyContext transformResponseBodyContext, HttpResponse httpResponse, ByteReadChannel byteReadChannel, TypeInfo typeInfo, Continuation continuation) {
        HttpPlainTextKt$HttpPlainText$2$2 httpPlainTextKt$HttpPlainText$2$2 = new HttpPlainTextKt$HttpPlainText$2$2(this.$responseCharsetFallback, continuation);
        httpPlainTextKt$HttpPlainText$2$2.L$0 = httpResponse;
        httpPlainTextKt$HttpPlainText$2$2.L$1 = byteReadChannel;
        httpPlainTextKt$HttpPlainText$2$2.L$2 = typeInfo;
        return httpPlainTextKt$HttpPlainText$2$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpResponse httpResponse = (HttpResponse) this.L$0;
        ByteReadChannel byteReadChannel = (ByteReadChannel) this.L$1;
        TypeInfo typeInfo = (TypeInfo) this.L$2;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Intrinsics.areEqual(typeInfo.getType(), Reflection.getOrCreateKotlinClass(String.class))) {
                return null;
            }
            this.L$0 = httpResponse;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 1;
            obj = ByteReadChannelOperationsKt.readBuffer(byteReadChannel, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return HttpPlainTextKt.HttpPlainText$lambda$0$read(this.$responseCharsetFallback, httpResponse.getCall(), (Buffer) obj);
    }
}
