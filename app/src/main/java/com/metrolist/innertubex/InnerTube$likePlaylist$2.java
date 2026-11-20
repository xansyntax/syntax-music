package com.metrolist.innertubex;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.body.LikeBody;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$likePlaylist$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ YouTubeClient $client;
    public final /* synthetic */ String $playlistId;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$likePlaylist$2(InnerTube innerTube, YouTubeClient youTubeClient, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = innerTube;
        this.$client = youTubeClient;
        this.$playlistId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        InnerTube$likePlaylist$2 innerTube$likePlaylist$2 = new InnerTube$likePlaylist$2(this.this$0, this.$client, this.$playlistId, continuation);
        innerTube$likePlaylist$2.L$0 = obj;
        return innerTube$likePlaylist$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((InnerTube$likePlaylist$2) create((InnerTube.SessionSnapshot) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TypeReference typeReferenceTypeOf;
        InnerTube.SessionSnapshot sessionSnapshot = (InnerTube.SessionSnapshot) this.L$0;
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
        HttpRequestKt.url(httpRequestBuilder, "like/like");
        YouTubeClient youTubeClient = this.$client;
        InnerTube.ytClient$default(innerTube, httpRequestBuilder, youTubeClient, sessionSnapshot, true, null, false, 24);
        Context context = youTubeClient.toContext(sessionSnapshot.locale, sessionSnapshot.visitorData, sessionSnapshot.dataSyncId);
        LikeBody.Target.INSTANCE.getClass();
        String str = this.$playlistId;
        str.getClass();
        httpRequestBuilder.setBody(new LikeBody(context, new LikeBody.Target((String) null, str, 1)));
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LikeBody.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(LikeBody.class);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass, false, typeReferenceTypeOf, httpRequestBuilder);
        HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Post, httpRequestBuilder, httpClient);
        this.L$0 = null;
        this.label = true;
        Object objExecute = httpStatementM.execute(this);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return objExecute == coroutineSingletons ? coroutineSingletons : objExecute;
    }
}
