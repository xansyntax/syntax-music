package com.metrolist.innertubex;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$registerStatsWithSession$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ YouTubeClient $client;
    public final /* synthetic */ String $cpn;
    public final /* synthetic */ String $origin;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ InnerTube.SessionSnapshot $requestSession;
    public final /* synthetic */ Url $statsUrl;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTube$registerStatsWithSession$2(InnerTube innerTube, Url url, YouTubeClient youTubeClient, String str, InnerTube.SessionSnapshot sessionSnapshot, String str2, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.this$0 = innerTube;
        this.$statsUrl = url;
        this.$client = youTubeClient;
        this.$origin = str;
        this.$requestSession = sessionSnapshot;
        this.$cpn = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new InnerTube$registerStatsWithSession$2(this.this$0, this.$statsUrl, this.$client, this.$origin, this.$requestSession, this.$cpn, continuation, (byte) 0);
            default:
                return new InnerTube$registerStatsWithSession$2(this.this$0, this.$statsUrl, this.$client, this.$origin, this.$requestSession, this.$cpn, continuation, (byte) 1);
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
        return ((InnerTube$registerStatsWithSession$2) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
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
                InnerTube innerTube = this.this$0;
                InnerTube$registerStatsWithSession$2 innerTube$registerStatsWithSession$2 = new InnerTube$registerStatsWithSession$2(innerTube, this.$statsUrl, this.$client, this.$origin, this.$requestSession, this.$cpn, null, (byte) 1);
                this.label = true;
                Object objExecuteRequest$default = InnerTube.executeRequest$default(innerTube, "registerPlayback", innerTube$registerStatsWithSession$2, this, 56);
                return objExecuteRequest$default == coroutineSingletons ? coroutineSingletons : objExecuteRequest$default;
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
                HttpClient httpClient = this.this$0.httpClient;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), this.$statsUrl);
                YouTubeClient youTubeClient = this.$client;
                HttpMessagePropertiesKt.userAgent(httpRequestBuilder, youTubeClient.userAgent);
                HttpRequestKt.headers(httpRequestBuilder, new UtilsKt$$ExternalSyntheticLambda0((Object) youTubeClient, (Object) this.$origin, (Object) this.$requestSession, (byte) 28));
                httpRequestBuilder.url(new MainActivity$$ExternalSyntheticLambda1((Object) youTubeClient, (Object) this.$cpn, (byte) 6));
                HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
                this.label = true;
                Object objExecute = httpStatementM.execute(this);
                return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
        }
    }
}
