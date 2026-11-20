package com.metrolist.innertubex;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.innertubex.models.YouTubeLocale;
import com.metrolist.innertubex.models.body.PlayerBody;
import dagger.hilt.EntryPoints;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.text.StringsKt;
import kotlin.time.InstantJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$playerWithSession$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ YouTubeClient $client;
    public final /* synthetic */ String $encryptedHostFlags;
    public final /* synthetic */ String $poToken;
    public final /* synthetic */ YouTubeClient $requestClient;
    public final /* synthetic */ InnerTube.SessionSnapshot $requestSession;
    public final /* synthetic */ Integer $signatureTimestamp;
    public final /* synthetic */ String $videoId;
    public final /* synthetic */ String $visitorDataForRequest;
    public long J$0;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$playerWithSession$2(InnerTube.SessionSnapshot sessionSnapshot, YouTubeClient youTubeClient, InnerTube innerTube, String str, Integer num, YouTubeClient youTubeClient2, String str2, String str3, String str4, Continuation continuation) {
        super(1, continuation);
        this.$requestSession = sessionSnapshot;
        this.$client = youTubeClient;
        this.this$0 = innerTube;
        this.$poToken = str;
        this.$signatureTimestamp = num;
        this.$requestClient = youTubeClient2;
        this.$visitorDataForRequest = str2;
        this.$videoId = str3;
        this.$encryptedHostFlags = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InnerTube$playerWithSession$2(this.$requestSession, this.$client, this.this$0, this.$poToken, this.$signatureTimestamp, this.$requestClient, this.$visitorDataForRequest, this.$videoId, this.$encryptedHostFlags, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((InnerTube$playerWithSession$2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        long j;
        YouTubeClient youTubeClient;
        PlayerBody.PlaybackContext playbackContext;
        TypeReference typeReferenceTypeOf;
        Object objExecute;
        boolean z = this.label;
        InnerTube innerTube = this.this$0;
        YouTubeClient youTubeClient2 = this.$client;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            long epochMilliseconds = InstantJvmKt.systemClock.now().toEpochMilliseconds();
            InnerTube.SessionSnapshot sessionSnapshot = this.$requestSession;
            String str = sessionSnapshot.cookie;
            boolean z2 = !(str == null || StringsKt.isBlank(str));
            String str2 = sessionSnapshot.sapisid;
            boolean z3 = !(str2 == null || StringsKt.isBlank(str2));
            boolean z4 = youTubeClient2.loginSupported;
            boolean z5 = youTubeClient2.loginSupported;
            String str3 = sessionSnapshot.dataSyncId;
            boolean z6 = !(str3 == null || StringsKt.isBlank(str3));
            PathKt$$ExternalSyntheticBUOutline0 pathKt$$ExternalSyntheticBUOutline0 = innerTube.logger;
            String str4 = youTubeClient2.clientName;
            String str5 = youTubeClient2.clientVersion;
            String str6 = this.$poToken;
            boolean z7 = str6 != null;
            Integer num = this.$signatureTimestamp;
            boolean z8 = num != null;
            boolean z9 = youTubeClient2.loginRequired;
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("player request client=", str4, " version=", str5, " poToken=");
            Fragment$5$$ExternalSyntheticOutline0.m(sbM, z7, " sts=", z8, " loginSupported=");
            Fragment$5$$ExternalSyntheticOutline0.m(sbM, z5, " loginRequired=", z9, " hasCookie=");
            Fragment$5$$ExternalSyntheticOutline0.m(sbM, z2, " hasSapisid=", z3, " authEligible=");
            sbM.append(z4);
            sbM.append(" hasDataSync=");
            sbM.append(z6);
            EntryPoints.d$default(pathKt$$ExternalSyntheticBUOutline0, "InnerTube", sbM.toString(), null, 12);
            HttpClient httpClient = innerTube.httpClient;
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            httpRequestBuilder.setMethod(HttpMethod.Post);
            HttpRequestKt.url(httpRequestBuilder, "player");
            YouTubeClient youTubeClient3 = this.$requestClient;
            InnerTube.SessionSnapshot sessionSnapshot2 = this.$requestSession;
            String str7 = this.$visitorDataForRequest;
            j = epochMilliseconds;
            InnerTube.ytClient$default(innerTube, httpRequestBuilder, youTubeClient3, sessionSnapshot2, true, str7, false, 16);
            YouTubeLocale youTubeLocale = sessionSnapshot2.locale;
            String str8 = sessionSnapshot2.dataSyncId;
            youTubeClient = youTubeClient2;
            boolean z10 = youTubeClient.useMusicPlayerEndpoint;
            boolean z11 = youTubeClient.isEmbedded;
            if (!z5) {
                str8 = null;
            }
            Context context = youTubeClient3.toContext(youTubeLocale, str7, str8);
            boolean z12 = youTubeClient.useSignatureTimestamp;
            if (z12 || z11) {
                playbackContext = new PlayerBody.PlaybackContext(new PlayerBody.PlaybackContext.ContentPlaybackContext(!z10 ? "HTML5_PREF_WANTS" : null, z12 ? num : null, z11 ? this.$encryptedHostFlags : null));
            } else {
                playbackContext = null;
            }
            String str9 = this.$videoId;
            httpRequestBuilder.setBody(new PlayerBody(context, str9, playbackContext, z11 ? new PlayerBody.ThirdParty(Fragment$5$$ExternalSyntheticOutline0.m("https://www.youtube.com/embed/", str9)) : null, str6 != null ? new PlayerBody.ServiceIntegrityDimensions(str6) : null, !z10 ? Boolean.TRUE : null));
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PlayerBody.class);
            try {
                typeReferenceTypeOf = Reflection.typeOf(PlayerBody.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            Format$$ExternalSyntheticOutline0.m(orCreateKotlinClass, false, typeReferenceTypeOf, httpRequestBuilder);
            HttpMessagePropertiesKt.userAgent(httpRequestBuilder, youTubeClient3.userAgent);
            HttpStatement httpStatementM = Format$$ExternalSyntheticOutline0.m(httpRequestBuilder, HttpMethod.Post, httpRequestBuilder, httpClient);
            this.J$0 = j;
            this.label = true;
            objExecute = httpStatementM.execute(this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objExecute == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            long j2 = this.J$0;
            ResultKt.throwOnFailure(obj);
            youTubeClient = youTubeClient2;
            j = j2;
            objExecute = obj;
        }
        HttpResponse httpResponse = (HttpResponse) objExecute;
        long epochMilliseconds2 = InstantJvmKt.systemClock.now().toEpochMilliseconds() - j;
        EntryPoints.d$default(innerTube.logger, "InnerTube", "player response client=" + youTubeClient.clientName + " elapsed=" + epochMilliseconds2 + "ms", null, 12);
        return httpResponse;
    }
}
