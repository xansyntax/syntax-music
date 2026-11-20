package io.ktor.utils.io;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lio/ktor/utils/io/JvmSerializer;", "T", "Ljava/io/Serializable;", "Lio/ktor/utils/io/JvmSerializable;", "value", "", "jvmSerialize", "(Ljava/lang/Object;)[B", "jvmDeserialize", "([B)Ljava/lang/Object;", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface JvmSerializer<T> extends Serializable {
    T jvmDeserialize(byte[] value);

    byte[] jvmSerialize(T value);
}
