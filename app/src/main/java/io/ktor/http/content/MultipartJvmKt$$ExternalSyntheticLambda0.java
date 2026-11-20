package io.ktor.http.content;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MultipartJvmKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ MultipartJvmKt$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                return MultipartJvmKt._get_streamProvider_$lambda$0((PartData.FileItem) obj);
            case 1:
                return CompressedReadChannelResponse.headers_delegate$lambda$0((CompressedReadChannelResponse) obj);
            default:
                return CompressedWriteChannelResponse.headers_delegate$lambda$0((CompressedWriteChannelResponse) obj);
        }
    }
}
