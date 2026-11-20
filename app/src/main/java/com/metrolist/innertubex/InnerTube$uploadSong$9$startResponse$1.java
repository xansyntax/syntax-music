package com.metrolist.innertubex;

import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.metrolist.innertubex.models.YouTubeClient;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.request.forms.FormDataContent;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentDisposition;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$uploadSong$9$startResponse$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ long $contentLength;
    public final /* synthetic */ String $fileName;
    public final /* synthetic */ InnerTube.SessionSnapshot $requestSession;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$uploadSong$9$startResponse$1(InnerTube innerTube, InnerTube.SessionSnapshot sessionSnapshot, long j, String str, Continuation continuation) {
        super(1, continuation);
        this.this$0 = innerTube;
        this.$requestSession = sessionSnapshot;
        this.$contentLength = j;
        this.$fileName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InnerTube$uploadSong$9$startResponse$1(this.this$0, this.$requestSession, this.$contentLength, this.$fileName, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((InnerTube$uploadSong$9$startResponse$1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z = this.label;
        if (z) {
            if (z) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        InnerTube innerTube = this.this$0;
        HttpClient httpClient = innerTube.httpClient;
        InnerTube.SessionSnapshot sessionSnapshot = this.$requestSession;
        String strConcat = "https://upload.youtube.com/upload/usermusic/http?authuser=".concat(sessionSnapshot.authUser);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpMethod httpMethod = HttpMethod.Post;
        httpRequestBuilder.setMethod(httpMethod);
        HttpRequestKt.url(httpRequestBuilder, strConcat);
        YouTubeClient.INSTANCE.getClass();
        HttpMessagePropertiesKt.userAgent(httpRequestBuilder, YouTubeClient.WEB_REMIX.userAgent);
        HttpRequestKt.headers(httpRequestBuilder, new DiskLruCache$$ExternalSyntheticLambda0(sessionSnapshot, innerTube, (byte) 20));
        UtilsKt.header(httpRequestBuilder, "X-Goog-Upload-Command", "start");
        UtilsKt.header(httpRequestBuilder, "X-Goog-Upload-Header-Content-Length", String.valueOf(this.$contentLength));
        UtilsKt.header(httpRequestBuilder, "X-Goog-Upload-Protocol", "resumable");
        Parameters.Companion companion = Parameters.INSTANCE;
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        parametersBuilderParametersBuilder$default.append(ContentDisposition.Parameters.FileName, this.$fileName);
        httpRequestBuilder.setBody(new FormDataContent(parametersBuilderParametersBuilder$default.build()));
        httpRequestBuilder.setBodyType(null);
        httpRequestBuilder.setMethod(httpMethod);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        this.label = true;
        Object objExecute = httpStatement.execute(this);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
    }
}
