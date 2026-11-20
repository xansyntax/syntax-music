package io.ktor.utils.io.core;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\u000b\u001a\u00020\n*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\f*\u001a\b\u0007\u0010\u0010\"\u00020\u00042\u00020\u0004B\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f¨\u0006\u0011"}, d2 = {"T", "", ContentDisposition.Parameters.Size, "Lkotlin/Function1;", "", "block", "withMemory", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "index", "value", "", "storeIntAt", "([BII)V", "Lkotlin/Deprecated;", ContentType.Message.TYPE, "ByteArray instead", "Memory", "ktor-io"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MemoryKt {
    public static final void storeIntAt(byte[] bArr, int i, int i2) {
        bArr.getClass();
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    public static final <T> T withMemory(int i, Function1 function1) {
        function1.getClass();
        return (T) function1.invoke(new byte[i]);
    }

    @Deprecated
    public static /* synthetic */ void Memory$annotations() {
    }
}
