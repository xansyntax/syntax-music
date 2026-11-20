package io.ktor.client.plugins;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DoubleReceivePluginKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ DoubleReceivePluginKt$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return DoubleReceivePluginKt.LOGGER_delegate$lambda$0();
            case 1:
                return DefaultRequest$Plugin$install$1.invokeSuspend$lambda$1$0();
            default:
                return DefaultRequest.DefaultRequestBuilder.setCapability$lambda$0();
        }
    }
}
