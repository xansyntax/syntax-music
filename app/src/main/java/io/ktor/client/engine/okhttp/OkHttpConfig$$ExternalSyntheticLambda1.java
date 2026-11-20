package io.ktor.client.engine.okhttp;

import kotlin.jvm.functions.Function1;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class OkHttpConfig$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Interceptor f$0;

    public /* synthetic */ OkHttpConfig$$ExternalSyntheticLambda1(Interceptor interceptor, byte b) {
        this.$r8$classId = b;
        this.f$0 = interceptor;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Interceptor interceptor = this.f$0;
        OkHttpClient.Builder builder = (OkHttpClient.Builder) obj;
        switch (b) {
            case 0:
                return OkHttpConfig.addNetworkInterceptor$lambda$0(interceptor, builder);
            default:
                return OkHttpConfig.addInterceptor$lambda$0(interceptor, builder);
        }
    }
}
