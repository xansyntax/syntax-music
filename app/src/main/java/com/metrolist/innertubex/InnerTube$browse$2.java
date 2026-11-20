package com.metrolist.innertubex;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.body.BrowseBody;
import com.metrolist.innertubex.models.body.SearchBody;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$browse$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ String $browseId;
    public final /* synthetic */ YouTubeClient $client;
    public final /* synthetic */ String $continuation;
    public final /* synthetic */ String $params;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ InnerTube.SessionSnapshot $requestSession;
    public final /* synthetic */ boolean $setLoginForRequest;
    public final /* synthetic */ String $visitorDataForRequest;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTube$browse$2(InnerTube innerTube, YouTubeClient youTubeClient, InnerTube.SessionSnapshot sessionSnapshot, boolean z, String str, String str2, String str3, String str4, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.this$0 = innerTube;
        this.$client = youTubeClient;
        this.$requestSession = sessionSnapshot;
        this.$setLoginForRequest = z;
        this.$visitorDataForRequest = str;
        this.$browseId = str2;
        this.$params = str3;
        this.$continuation = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new InnerTube$browse$2(this.this$0, this.$client, this.$requestSession, this.$setLoginForRequest, this.$visitorDataForRequest, this.$browseId, this.$params, this.$continuation, continuation, (byte) 0);
            default:
                return new InnerTube$browse$2(this.this$0, this.$client, this.$requestSession, this.$setLoginForRequest, this.$visitorDataForRequest, this.$browseId, this.$params, this.$continuation, continuation, (byte) 1);
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
        return ((InnerTube$browse$2) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        String str = this.$continuation;
        String str2 = this.$params;
        String str3 = this.$browseId;
        InnerTube innerTube = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        TypeReference typeReferenceTypeOf = null;
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
                httpRequestBuilder.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder, "browse");
                YouTubeClient youTubeClient = this.$client;
                InnerTube.SessionSnapshot sessionSnapshot = this.$requestSession;
                boolean z2 = this.$setLoginForRequest;
                String str4 = this.$visitorDataForRequest;
                InnerTube.ytClient(httpRequestBuilder, youTubeClient, sessionSnapshot, z2, str4, z2);
                httpRequestBuilder.setBody(new BrowseBody(youTubeClient.toContext(sessionSnapshot.locale, str4, z2 ? sessionSnapshot.dataSyncId : null), str3, str2, str));
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseBody.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(BrowseBody.class);
                    break;
                } catch (Throwable unused) {
                }
                Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass, false, typeReferenceTypeOf, httpRequestBuilder);
                HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Post, httpRequestBuilder, httpClient);
                this.label = true;
                Object objExecute = httpStatementM.execute(this);
                return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
            default:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                HttpClient httpClient2 = innerTube.httpClient;
                HttpRequestBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                httpRequestBuilder2.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder2, "search");
                YouTubeClient youTubeClient2 = this.$client;
                InnerTube.SessionSnapshot sessionSnapshot2 = this.$requestSession;
                boolean z4 = this.$setLoginForRequest;
                String str5 = this.$visitorDataForRequest;
                InnerTube.ytClient(httpRequestBuilder2, youTubeClient2, sessionSnapshot2, z4, str5, z4);
                httpRequestBuilder2.setBody(new SearchBody(youTubeClient2.toContext(sessionSnapshot2.locale, str5, z4 ? sessionSnapshot2.dataSyncId : null), str3, str2));
                ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(SearchBody.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(SearchBody.class);
                    break;
                } catch (Throwable unused2) {
                }
                Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass2, false, typeReferenceTypeOf, httpRequestBuilder2);
                if (str != null) {
                    UtilsKt.parameter(httpRequestBuilder2, "continuation", str);
                    UtilsKt.parameter(httpRequestBuilder2, "ctoken", str);
                }
                HttpStatement httpStatementM2 = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder2, HttpMethod.Post, httpRequestBuilder2, httpClient2);
                this.label = true;
                Object objExecute2 = httpStatementM2.execute(this);
                return objExecute2 == coroutineSingletons ? coroutineSingletons : objExecute2;
        }
    }
}
