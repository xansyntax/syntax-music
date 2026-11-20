package com.metrolist.innertubex;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.YouTubeClient;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerTube$playerWithSessionBound$3 extends SuspendLambda implements Function1 {
    public final /* synthetic */ YouTubeClient $client;
    public final /* synthetic */ String $encryptedHostFlags;
    public final /* synthetic */ String $poToken;
    public final /* synthetic */ InnerTube.SessionSnapshot $requestSession;
    public final /* synthetic */ String $requestVisitorData;
    public final /* synthetic */ Integer $signatureTimestamp;
    public final /* synthetic */ String $videoId;
    public boolean label;
    public final /* synthetic */ InnerTube this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerTube$playerWithSessionBound$3(InnerTube innerTube, YouTubeClient youTubeClient, String str, Integer num, String str2, String str3, InnerTube.SessionSnapshot sessionSnapshot, String str4, Continuation continuation) {
        super(1, continuation);
        this.this$0 = innerTube;
        this.$client = youTubeClient;
        this.$videoId = str;
        this.$signatureTimestamp = num;
        this.$poToken = str2;
        this.$requestVisitorData = str3;
        this.$requestSession = sessionSnapshot;
        this.$encryptedHostFlags = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InnerTube$playerWithSessionBound$3(this.this$0, this.$client, this.$videoId, this.$signatureTimestamp, this.$poToken, this.$requestVisitorData, this.$requestSession, this.$encryptedHostFlags, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((InnerTube$playerWithSessionBound$3) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        YouTubeClient youTubeClient;
        YouTubeClient youTubeClientCopy$default;
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
        this.label = true;
        InnerTube innerTube = this.this$0;
        innerTube.getClass();
        String str = this.$requestVisitorData;
        InnerTube.SessionSnapshot sessionSnapshot = this.$requestSession;
        if (str == null) {
            str = sessionSnapshot.visitorData;
        }
        String str2 = str;
        YouTubeClient youTubeClient2 = this.$client;
        if (StringsKt.contains(youTubeClient2.userAgent, "{language}", false)) {
            youTubeClient = youTubeClient2;
            youTubeClientCopy$default = YouTubeClient.copy$default(youTubeClient, null, StringsKt__StringsJVMKt.replace(youTubeClient2.userAgent, "{language}", sessionSnapshot.locale.hl, false), null, null, 33554423);
        } else {
            youTubeClient = youTubeClient2;
            youTubeClientCopy$default = youTubeClient;
        }
        Object objExecuteRequest$default = InnerTube.executeRequest$default(innerTube, Fragment$5$$ExternalSyntheticOutline0.m("player:", youTubeClient.clientName), new InnerTube$playerWithSession$2(sessionSnapshot, youTubeClient, innerTube, this.$poToken, this.$signatureTimestamp, youTubeClientCopy$default, str2, this.$videoId, this.$encryptedHostFlags, null), this, 60);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return objExecuteRequest$default == coroutineSingletons ? coroutineSingletons : objExecuteRequest$default;
    }
}
