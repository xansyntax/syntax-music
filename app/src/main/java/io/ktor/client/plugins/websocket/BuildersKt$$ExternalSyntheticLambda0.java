package io.ktor.client.plugins.websocket;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HttpMethod;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BuildersKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ HttpMethod f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Integer f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ Function1 f$4;

    public /* synthetic */ BuildersKt$$ExternalSyntheticLambda0(HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = httpMethod;
        this.f$1 = str;
        this.f$2 = num;
        this.f$3 = str2;
        this.f$4 = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return BuildersKt.webSocketSession$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (HttpRequestBuilder) obj);
            default:
                return BuildersKt.webSocket$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (HttpRequestBuilder) obj);
        }
    }
}
