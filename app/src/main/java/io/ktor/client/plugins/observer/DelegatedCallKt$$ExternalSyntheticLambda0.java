package io.ktor.client.plugins.observer;

import io.ktor.client.statement.HttpResponse;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DelegatedCallKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function f$0;

    public /* synthetic */ DelegatedCallKt$$ExternalSyntheticLambda0(Function function, byte b) {
        this.$r8$classId = b;
        this.f$0 = function;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Function function = this.f$0;
        switch (b) {
            case 0:
                return DelegatedCallKt.wrapWithContent$lambda$1((Function0) function, (HttpResponse) obj);
            default:
                return ResponseObserverKt.ResponseObserver$lambda$1((Function2) function, (ResponseObserverConfig) obj);
        }
    }
}
