package io.ktor.utils.io.core.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0086\u0082\u0004¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0086\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u001b\u0010\u0006\u001a\u00020\u00048\u0006X\u0086\u0084\b¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lio/ktor/utils/io/core/internal/CharArraySequence;", "", "", "array", "", "offset", "length", "<init>", "([CII)V", "index", "", "get", "(I)C", "startIndex", "endIndex", "subSequence", "(II)Ljava/lang/CharSequence;", "", "toString", "()Ljava/lang/String;", "", "indexOutOfBounds", "(I)Ljava/lang/Void;", "[C", "I", "getLength", "()I", "ktor-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CharArraySequence implements CharSequence {
    private final char[] array;
    private final int length;
    private final int offset;

    public CharArraySequence(char[] cArr, int i, int i2) {
        cArr.getClass();
        this.array = cArr;
        this.offset = i;
        this.length = i2;
    }

    private final Void indexOutOfBounds(int index) {
        StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(index, "String index out of bounds: ", " > ");
        sbM2m.append(this.length);
        throw new IndexOutOfBoundsException(sbM2m.toString());
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public final char get(int index) {
        if (index < this.length) {
            return this.array[index + this.offset];
        }
        indexOutOfBounds(index);
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        return (char) 0;
    }

    public final int getLength() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int startIndex, int endIndex) {
        if (startIndex < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(startIndex, "startIndex shouldn't be negative: "));
            return null;
        }
        int i = this.length;
        if (startIndex > i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m2m(startIndex, "startIndex is too large: ", " > "), this.length);
            return null;
        }
        if (endIndex > i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m2m(endIndex, "endIndex is too large: ", " > "), this.length);
            return null;
        }
        if (endIndex >= startIndex) {
            return new CharArraySequence(this.array, this.offset + startIndex, endIndex - startIndex);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m(startIndex, endIndex, "endIndex should be greater or equal to startIndex: ", " > "));
        return null;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        char[] cArr = this.array;
        int i = this.offset;
        return StringsKt__StringsJVMKt.concatToString(cArr, i, this.length + i);
    }
}
