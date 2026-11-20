package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteWriteChannel;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ByteChannelsKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ByteChannelsKt$$ExternalSyntheticLambda0(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                return ByteChannelsKt.copyToBoth$lambda$0((ByteWriteChannel) obj3, (ByteWriteChannel) obj2, (Throwable) obj);
            case 1:
                return CryptoKt__CryptoJvmKt.getDigestFunction$lambda$0$CryptoKt__CryptoJvmKt((String) obj3, (Function1) obj2, (String) obj);
            case 2:
                return BufferViewJvmKt.write$lambda$0((Ref$IntRef) obj3, (WritableByteChannel) obj2, (ByteBuffer) obj);
            case 3:
                return BufferViewJvmKt.read$lambda$0((Ref$IntRef) obj3, (ReadableByteChannel) obj2, (ByteBuffer) obj);
            default:
                return ByteChannelsKt.split$lambda$0((ByteChannel) obj3, (ByteChannel) obj2, (Throwable) obj);
        }
    }
}
