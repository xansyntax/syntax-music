package com.metrolist.innertubex;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.YouTubeLocale;
import com.metrolist.innertubex.models.body.GetQueueBody;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import java.util.List;
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
public final class InnerTube$getQueue$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ YouTubeClient $client;
    public final /* synthetic */ String $playlistId;
    public final /* synthetic */ InnerTube.SessionSnapshot $requestSession;
    public final /* synthetic */ boolean $setLoginForRequest;
    public final /* synthetic */ List $videoIds;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$getQueue$2(InnerTube innerTube, YouTubeClient youTubeClient, InnerTube.SessionSnapshot sessionSnapshot, boolean z, List list, String str, Continuation continuation) {
        super(1, continuation);
        this.this$0 = innerTube;
        this.$client = youTubeClient;
        this.$requestSession = sessionSnapshot;
        this.$setLoginForRequest = z;
        this.$videoIds = list;
        this.$playlistId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InnerTube$getQueue$2(this.this$0, this.$client, this.$requestSession, this.$setLoginForRequest, this.$videoIds, this.$playlistId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((InnerTube$getQueue$2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z = this.label;
        TypeReference typeReferenceTypeOf = null;
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
        HttpRequestKt.url(httpRequestBuilder, "music/get_queue");
        YouTubeClient youTubeClient = this.$client;
        InnerTube.SessionSnapshot sessionSnapshot = this.$requestSession;
        boolean z2 = this.$setLoginForRequest;
        InnerTube.ytClient$default(innerTube, httpRequestBuilder, youTubeClient, sessionSnapshot, z2, null, z2, 8);
        YouTubeLocale youTubeLocale = sessionSnapshot.locale;
        String str = sessionSnapshot.visitorData;
        String str2 = sessionSnapshot.dataSyncId;
        if (!z2) {
            str2 = null;
        }
        httpRequestBuilder.setBody(new GetQueueBody(youTubeClient.toContext(youTubeLocale, str, str2), this.$playlistId, this.$videoIds));
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(GetQueueBody.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(GetQueueBody.class);
        } catch (Throwable unused) {
        }
        Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass, false, typeReferenceTypeOf, httpRequestBuilder);
        HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Post, httpRequestBuilder, httpClient);
        this.label = true;
        Object objExecute = httpStatementM.execute(this);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
    }
}
