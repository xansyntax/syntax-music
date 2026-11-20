package io.ktor.client.plugins.observer;

import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DelegatedCallKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ByteReadChannel f$0;

    public /* synthetic */ DelegatedCallKt$$ExternalSyntheticLambda1(ByteReadChannel byteReadChannel, byte b) {
        this.$r8$classId = b;
        this.f$0 = byteReadChannel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        ByteReadChannel byteReadChannel = this.f$0;
        HttpResponse httpResponse = (HttpResponse) obj;
        switch (b) {
            case 0:
                return DelegatedCallKt.wrapWithContent$lambda$0(byteReadChannel, httpResponse);
            case 1:
                return ResponseObserverKt$ResponseObserver$2$1.invokeSuspend$lambda$0(byteReadChannel, httpResponse);
            case 2:
                return ResponseObserverKt$ResponseObserver$2$1.invokeSuspend$lambda$1(byteReadChannel, httpResponse);
            default:
                return DelegatedCallKt.wrap$lambda$0(byteReadChannel, httpResponse);
        }
    }
}
