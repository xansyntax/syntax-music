package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.content.OutgoingContent;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UtilsKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ UtilsKt$$ExternalSyntheticLambda0(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                return UtilsKt.mergeHeaders$lambda$0((Headers) obj3, (OutgoingContent) obj2, (HeadersBuilder) obj);
            case 1:
                return HttpClientEngine.C02291.invokeSuspend$lambda$2((HttpClient) obj3, (HttpResponse) obj2, (Throwable) obj);
            default:
                return HttpClientEngineKt.AnonymousClass1.create$lambda$0((Function1) obj3, (Function1) obj2, (HttpClientEngineConfig) obj);
        }
    }
}
