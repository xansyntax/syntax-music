package com.metrolist.innertubex;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertube.YouTube$$ExternalSyntheticLambda2;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.body.GetSearchSuggestionsBody;
import com.metrolist.innertubex.models.body.GetTranscriptBody;
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
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$getTranscript$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ YouTubeClient $client;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ InnerTube.SessionSnapshot $requestSession;
    public final /* synthetic */ String $videoId;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTube$getTranscript$2(InnerTube innerTube, YouTubeClient youTubeClient, InnerTube.SessionSnapshot sessionSnapshot, String str, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.this$0 = innerTube;
        this.$client = youTubeClient;
        this.$requestSession = sessionSnapshot;
        this.$videoId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new InnerTube$getTranscript$2(this.this$0, this.$client, this.$requestSession, this.$videoId, continuation, (byte) 0);
            default:
                return new InnerTube$getTranscript$2(this.this$0, this.$client, this.$requestSession, this.$videoId, continuation, (byte) 1);
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
        return ((InnerTube$getTranscript$2) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        String str = this.$videoId;
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
                HttpClient httpClient = this.this$0.httpClient;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                httpRequestBuilder.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder, "https://music.youtube.com/youtubei/v1/get_transcript");
                UtilsKt.parameter(httpRequestBuilder, "key", "AIzaSyC9XL3ZjWddXya6X74dJoCTL-WEYFDNX30");
                HttpRequestKt.headers(httpRequestBuilder, new YouTube$$ExternalSyntheticLambda2((byte) 9));
                httpRequestBuilder.setBody(new GetTranscriptBody(this.$client.toContext(this.$requestSession.locale, null, null), Base64.encode$default(Base64.Default, StringsKt__StringsJVMKt.encodeToByteArray("\n\u000b" + str))));
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(GetTranscriptBody.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(GetTranscriptBody.class);
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
                InnerTube innerTube = this.this$0;
                HttpClient httpClient2 = innerTube.httpClient;
                HttpRequestBuilder httpRequestBuilder2 = new HttpRequestBuilder();
                httpRequestBuilder2.setMethod(HttpMethod.Post);
                HttpRequestKt.url(httpRequestBuilder2, "music/get_search_suggestions");
                YouTubeClient youTubeClient = this.$client;
                InnerTube.SessionSnapshot sessionSnapshot = this.$requestSession;
                InnerTube.ytClient$default(innerTube, httpRequestBuilder2, youTubeClient, sessionSnapshot, false, null, false, 8);
                httpRequestBuilder2.setBody(new GetSearchSuggestionsBody(youTubeClient.toContext(sessionSnapshot.locale, sessionSnapshot.visitorData, null), str));
                ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(GetSearchSuggestionsBody.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(GetSearchSuggestionsBody.class);
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
