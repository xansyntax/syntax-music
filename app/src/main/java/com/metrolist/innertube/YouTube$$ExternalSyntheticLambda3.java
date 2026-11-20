package com.metrolist.innertube;

import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import java.io.InputStream;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YouTube$$ExternalSyntheticLambda3 implements Function0 {
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ YouTube$$ExternalSyntheticLambda3(Function0 function0, long j, Function1 function1) {
        this.f$0 = function0;
        this.f$1 = j;
        this.f$2 = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new UploadProgressInputStream((InputStream) this.f$0.invoke(), this.f$1, new CodecsKt$$ExternalSyntheticLambda0(this.f$2, (byte) 13));
    }
}
