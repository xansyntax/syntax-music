package io.ktor.client.plugins.sse;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BuildersKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Integer f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ Function1 f$4;

    public /* synthetic */ BuildersKt$$ExternalSyntheticLambda0(String str, String str2, Integer num, String str3, Function1 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = num;
        this.f$3 = str3;
        this.f$4 = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return BuildersKt.serverSentEvents_1wIb_0I$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (HttpRequestBuilder) obj);
            case 1:
                return BuildersKt.serverSentEventsSession_xEWcMm4$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (HttpRequestBuilder) obj);
            case 2:
                return BuildersKt.serverSentEventsSession_tL6_L_A$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (HttpRequestBuilder) obj);
            default:
                return BuildersKt.serverSentEvents_BqdlHlk$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (HttpRequestBuilder) obj);
        }
    }
}
