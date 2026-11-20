package io.ktor.utils.io;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ByteChannelUtilsKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ByteChannel f$0;

    public /* synthetic */ ByteChannelUtilsKt$$ExternalSyntheticLambda1(ByteChannel byteChannel, byte b) {
        this.$r8$classId = b;
        this.f$0 = byteChannel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        ByteChannel byteChannel = this.f$0;
        Throwable th = (Throwable) obj;
        switch (b) {
            case 0:
                return ByteChannelUtilsKt.attachJob$lambda$0(byteChannel, th);
            case 1:
                return ByteReadChannelOperationsKt.reader$lambda$0$0(byteChannel, th);
            default:
                return ByteWriteChannelOperationsKt.writer$lambda$0$0(byteChannel, th);
        }
    }
}
