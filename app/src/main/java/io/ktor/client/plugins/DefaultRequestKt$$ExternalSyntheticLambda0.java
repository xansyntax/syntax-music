package io.ktor.client.plugins;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DefaultRequestKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ DefaultRequestKt$$ExternalSyntheticLambda0(Function1 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Function1 function1 = this.f$0;
        DefaultRequest.DefaultRequestBuilder defaultRequestBuilder = (DefaultRequest.DefaultRequestBuilder) obj;
        switch (b) {
            case 0:
                return DefaultRequestKt.defaultRequest$lambda$0(function1, defaultRequestBuilder);
            case 1:
                return DefaultRequestKt.defaultRequest$lambda$1(function1, defaultRequestBuilder);
            default:
                return DefaultRequestKt.defaultRequest$lambda$2(function1, defaultRequestBuilder);
        }
    }
}
