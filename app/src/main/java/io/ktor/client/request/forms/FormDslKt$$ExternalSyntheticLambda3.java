package io.ktor.client.request.forms;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FormDslKt$$ExternalSyntheticLambda3 implements Function0 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ byte[] f$0;

    public /* synthetic */ FormDslKt$$ExternalSyntheticLambda3(Object obj) {
        this.f$0 = (byte[]) obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        byte[] bArr = this.f$0;
        switch (b) {
            case 0:
                return FormDslKt.formData$lambda$0$4(bArr);
            default:
                return MultiPartFormDataContent.rawParts$lambda$0$1(bArr);
        }
    }

    public /* synthetic */ FormDslKt$$ExternalSyntheticLambda3(byte[] bArr) {
        this.f$0 = bArr;
    }
}
