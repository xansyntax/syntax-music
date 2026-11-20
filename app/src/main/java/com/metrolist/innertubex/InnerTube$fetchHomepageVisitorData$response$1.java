package com.metrolist.innertubex;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$fetchHomepageVisitorData$response$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ InnerTube.SessionSnapshot $requestSession;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTube$fetchHomepageVisitorData$response$1(InnerTube innerTube, InnerTube.SessionSnapshot sessionSnapshot, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.this$0 = innerTube;
        this.$requestSession = sessionSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        byte b = this.$r8$classId;
        InnerTube.SessionSnapshot sessionSnapshot = this.$requestSession;
        InnerTube innerTube = this.this$0;
        switch (b) {
            case 0:
                return new InnerTube$fetchHomepageVisitorData$response$1(innerTube, sessionSnapshot, continuation, (byte) 0);
            default:
                return new InnerTube$fetchHomepageVisitorData$response$1(innerTube, sessionSnapshot, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
        }
        return ((InnerTube$fetchHomepageVisitorData$response$1) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        InnerTube.SessionSnapshot sessionSnapshot = this.$requestSession;
        InnerTube innerTube = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
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
                HttpClient httpClient = innerTube.httpClient;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, "https://music.youtube.com");
                UtilsKt.header(httpRequestBuilder, HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0");
                UtilsKt.header(httpRequestBuilder, HttpHeaders.Accept, "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                UtilsKt.header(httpRequestBuilder, HttpHeaders.AcceptLanguage, sessionSnapshot.locale.acceptLanguageHeader$com_github_MetrolistGroup_innertubex());
                HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
                this.label = true;
                Object objExecute = httpStatementM.execute(this);
                return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
            default:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                HttpClient httpClient2 = innerTube.httpClient;
                HttpRequestBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder2, "https://www.youtube.com/sw.js_data");
                UtilsKt.header(httpRequestBuilder2, HttpHeaders.UserAgent, "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0");
                UtilsKt.header(httpRequestBuilder2, HttpHeaders.Accept, "application/json,text/plain,*/*");
                UtilsKt.header(httpRequestBuilder2, HttpHeaders.AcceptLanguage, sessionSnapshot.locale.acceptLanguageHeader$com_github_MetrolistGroup_innertubex());
                HttpStatement httpStatementM2 = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder2, HttpMethod.Get, httpRequestBuilder2, httpClient2);
                this.label = true;
                Object objExecute2 = httpStatementM2.execute(this);
                return objExecute2 == coroutineSingletons ? coroutineSingletons : objExecute2;
        }
    }
}
