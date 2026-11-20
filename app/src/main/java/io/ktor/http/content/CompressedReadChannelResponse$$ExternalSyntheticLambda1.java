package io.ktor.http.content;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CompressedReadChannelResponse$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ CompressedReadChannelResponse$$ExternalSyntheticLambda1(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean zHeaders_delegate$lambda$0$0$0;
        String str = (String) obj;
        String str2 = (String) obj2;
        switch (this.$r8$classId) {
            case 0:
                zHeaders_delegate$lambda$0$0$0 = CompressedReadChannelResponse.headers_delegate$lambda$0$0$0(str, str2);
                break;
            default:
                zHeaders_delegate$lambda$0$0$0 = CompressedWriteChannelResponse.headers_delegate$lambda$0$0$0(str, str2);
                break;
        }
        return Boolean.valueOf(zHeaders_delegate$lambda$0$0$0);
    }
}
