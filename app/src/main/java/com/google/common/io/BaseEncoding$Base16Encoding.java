package com.google.common.io;

import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BaseEncoding$Base16Encoding extends BaseEncoding$StandardBaseEncoding {
    public final char[] encoding;

    public BaseEncoding$Base16Encoding(BaseEncoding$Alphabet baseEncoding$Alphabet) {
        super(baseEncoding$Alphabet, (Character) null);
        this.encoding = new char[512];
        char[] cArr = baseEncoding$Alphabet.chars;
        UtilsKt.checkArgument(cArr.length == 16);
        for (int i = 0; i < 256; i++) {
            char[] cArr2 = this.encoding;
            cArr2[i] = cArr[i >>> 4];
            cArr2[i | 256] = cArr[i & 15];
        }
    }

    @Override // com.google.common.io.BaseEncoding$StandardBaseEncoding
    public final void encodeTo(StringBuilder sb, byte[] bArr, int i) {
        UtilsKt.checkPositionIndexes(0, i, bArr.length);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = bArr[i2] & 255;
            char[] cArr = this.encoding;
            sb.append(cArr[i3]);
            sb.append(cArr[i3 | 256]);
        }
    }
}
