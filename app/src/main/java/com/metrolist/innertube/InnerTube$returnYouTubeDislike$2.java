package com.metrolist.innertube;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
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
public final class InnerTube$returnYouTubeDislike$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ String $videoId;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$returnYouTubeDislike$2(InnerTube innerTube, String str, Continuation continuation) {
        super(1, continuation);
        this.this$0 = innerTube;
        this.$videoId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InnerTube$returnYouTubeDislike$2(this.this$0, this.$videoId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((InnerTube$returnYouTubeDislike$2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
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
        HttpClient httpClient = this.this$0.httpClient;
        String strM = Fragment$5$$ExternalSyntheticOutline0.m("https://returnyoutubedislikeapi.com/Votes?videoId=", this.$videoId);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, strM);
        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
        HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Get, httpRequestBuilder, httpClient);
        this.label = true;
        Object objExecute = httpStatementM.execute(this);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
    }
}
