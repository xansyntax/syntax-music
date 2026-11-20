package io.ktor.util;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\u0004\u001a/\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0082\u0004¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0082\u0004¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/util/HashFunction;", "", "input", "", "offset", "length", "digest", "(Lio/ktor/util/HashFunction;[BII)[B", "bitCount", "leftRotate", "(II)I", "", "other", "and", "(BI)I", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HashFunctionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int and(byte b, int i) {
        return b & i;
    }

    public static final byte[] digest(HashFunction hashFunction, byte[] bArr, int i, int i2) {
        hashFunction.getClass();
        bArr.getClass();
        hashFunction.update(bArr, i, i2);
        return hashFunction.digest();
    }

    public static /* synthetic */ byte[] digest$default(HashFunction hashFunction, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return digest(hashFunction, bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int leftRotate(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }
}
