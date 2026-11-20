package com.metrolist.innertubex;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.body.AccountMenuBody;
import com.metrolist.innertubex.models.body.AccountsListBody;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
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
public final class InnerTube$accountMenu$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ YouTubeClient $client;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ InnerTube.SessionSnapshot $requestSession;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTube$accountMenu$2(InnerTube innerTube, YouTubeClient youTubeClient, InnerTube.SessionSnapshot sessionSnapshot, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.this$0 = innerTube;
        this.$client = youTubeClient;
        this.$requestSession = sessionSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new InnerTube$accountMenu$2(this.this$0, this.$client, this.$requestSession, continuation, (byte) 0);
            default:
                return new InnerTube$accountMenu$2(this.this$0, this.$client, this.$requestSession, continuation, (byte) 1);
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
        return ((InnerTube$accountMenu$2) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
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
                InnerTube innerTube = this.this$0;
                HttpClient httpClient = innerTube.httpClient;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                httpRequestBuilder.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder, "account/account_menu");
                YouTubeClient youTubeClient = this.$client;
                InnerTube.SessionSnapshot sessionSnapshot = this.$requestSession;
                InnerTube.ytClient$default(innerTube, httpRequestBuilder, youTubeClient, sessionSnapshot, true, null, false, 24);
                httpRequestBuilder.setBody(new AccountMenuBody(youTubeClient.toContext(sessionSnapshot.locale, sessionSnapshot.visitorData, sessionSnapshot.dataSyncId)));
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(AccountMenuBody.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(AccountMenuBody.class);
                    break;
                } catch (Throwable unused) {
                }
                Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass, false, typeReferenceTypeOf, httpRequestBuilder);
                HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Post, httpRequestBuilder, httpClient);
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
                InnerTube innerTube2 = this.this$0;
                HttpClient httpClient2 = innerTube2.httpClient;
                HttpRequestBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                httpRequestBuilder2.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder2, "account/accounts_list");
                YouTubeClient youTubeClient2 = this.$client;
                InnerTube.SessionSnapshot sessionSnapshot2 = this.$requestSession;
                InnerTube.ytClient$default(innerTube2, httpRequestBuilder2, youTubeClient2, sessionSnapshot2, true, null, false, 24);
                httpRequestBuilder2.setBody(new AccountsListBody(youTubeClient2.toContext(sessionSnapshot2.locale, sessionSnapshot2.visitorData, null)));
                ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(AccountsListBody.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(AccountsListBody.class);
                    break;
                } catch (Throwable unused2) {
                }
                Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass2, false, typeReferenceTypeOf, httpRequestBuilder2);
                HttpStatement httpStatementM2 = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder2, HttpMethod.Post, httpRequestBuilder2, httpClient2);
                this.label = true;
                Object objExecute2 = httpStatementM2.execute(this);
                return objExecute2 == coroutineSingletons ? coroutineSingletons : objExecute2;
        }
    }
}
