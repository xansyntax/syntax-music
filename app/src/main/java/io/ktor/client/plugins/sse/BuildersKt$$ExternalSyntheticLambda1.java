package io.ktor.client.plugins.sse;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BuildersKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ BuildersKt$$ExternalSyntheticLambda1(byte b, String str, Function1 function1) {
        this.$r8$classId = b;
        this.f$0 = str;
        this.f$1 = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return BuildersKt.serverSentEvents_pTj2aPc$lambda$1(this.f$0, this.f$1, (HttpRequestBuilder) obj);
            case 1:
                return BuildersKt.serverSentEventsSession_Mswn__c$lambda$1(this.f$0, this.f$1, (HttpRequestBuilder) obj);
            case 2:
                return BuildersKt.serverSentEvents_3bFjkrY$lambda$1(this.f$0, this.f$1, (HttpRequestBuilder) obj);
            case 3:
                return BuildersKt.serverSentEventsSession_mY9Nd3A$lambda$1(this.f$0, this.f$1, (HttpRequestBuilder) obj);
            case 4:
                return io.ktor.client.plugins.websocket.BuildersKt.webSocket$lambda$5(this.f$0, this.f$1, (HttpRequestBuilder) obj);
            case 5:
                return io.ktor.client.plugins.websocket.BuildersKt.wss$lambda$2(this.f$0, this.f$1, (HttpRequestBuilder) obj);
            default:
                return io.ktor.client.plugins.websocket.BuildersKt.webSocketSession$lambda$4(this.f$0, this.f$1, (HttpRequestBuilder) obj);
        }
    }
}
