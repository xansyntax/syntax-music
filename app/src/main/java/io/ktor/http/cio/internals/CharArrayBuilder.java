package io.ktor.http.cio.internals;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.BuildConfig;
import io.ktor.utils.io.pool.ObjectPool;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001FB\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0096\u0082\u0004¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ!\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0096\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013H\u0096\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0082\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\tH\u0096\u0080\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001e\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\u001e\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010 J\u001d\u0010\u001e\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u001e\u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b%\u0010\u0012J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020(2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0005H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0005H\u0002¢\u0006\u0004\b-\u0010,J/\u00101\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\u0002¢\u0006\u0004\b1\u00102J\u001f\u00104\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u00103\u001a\u00020\tH\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\tH\u0002¢\u0006\u0004\b6\u0010\u001cR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u00107\u001a\u0004\b8\u00109R\u001e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR%\u00100\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t8\u0016@RX\u0096\u008e\b¢\u0006\f\n\u0004\b0\u0010D\u001a\u0004\bE\u0010\u001c¨\u0006G"}, d2 = {"Lio/ktor/http/cio/internals/CharArrayBuilder;", "", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Lio/ktor/utils/io/pool/ObjectPool;", "", "pool", "<init>", "(Lio/ktor/utils/io/pool/ObjectPool;)V", "", "index", "", "get", "(I)C", "getImpl", "startIndex", "endIndex", "subSequence", "(II)Ljava/lang/CharSequence;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "value", "append", "(C)Ljava/lang/Appendable;", "(Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "(Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "", BuildConfig.BUILD_TYPE, "()V", "copy", "bufferForIndex", "(I)[C", "", "throwSingleBuffer", "(I)Ljava/lang/Void;", "nonFullBuffer", "()[C", "appendNewArray", "start", "otherStart", "length", "rangeEqualsImpl", "(ILjava/lang/CharSequence;II)Z", "end", "hashCodeImpl", "(II)I", "currentPosition", "Lio/ktor/utils/io/pool/ObjectPool;", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "", "buffers", "Ljava/util/List;", "current", "[C", "stringified", "Ljava/lang/String;", "released", "Z", "remaining", "I", "getLength", "SubSequenceImpl", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CharArrayBuilder implements CharSequence, Appendable {
    private List<char[]> buffers;
    private char[] current;
    private int length;
    private final ObjectPool<char[]> pool;
    private boolean released;
    private int remaining;
    private String stringified;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u000fH\u0096\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0082\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0015\u0010\u001f\u001a\u00020\u00028VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018¨\u0006 "}, d2 = {"Lio/ktor/http/cio/internals/CharArrayBuilder$SubSequenceImpl;", "", "", "start", "end", "<init>", "(Lio/ktor/http/cio/internals/CharArrayBuilder;II)V", "index", "", "get", "(I)C", "startIndex", "endIndex", "subSequence", "(II)Ljava/lang/CharSequence;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "I", "getStart", "getEnd", "stringified", "Ljava/lang/String;", "getLength", "length", "ktor-http-cio"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class SubSequenceImpl implements CharSequence {
        private final int end;
        private final int start;
        private String stringified;

        public SubSequenceImpl(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ char charAt(int i) {
            return get(i);
        }

        public boolean equals(Object other) {
            if (!(other instanceof CharSequence)) {
                return false;
            }
            CharSequence charSequence = (CharSequence) other;
            if (charSequence.length() != length()) {
                return false;
            }
            return CharArrayBuilder.this.rangeEqualsImpl(this.start, charSequence, 0, length());
        }

        public char get(int index) {
            int i = this.start + index;
            if (index < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(index, "index is negative: "));
                return (char) 0;
            }
            if (i < this.end) {
                return CharArrayBuilder.this.getImpl(i);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(index, "index (", ") should be less than length ("), length(), ')'));
            return (char) 0;
        }

        public final int getEnd() {
            return this.end;
        }

        public int getLength() {
            return this.end - this.start;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            String str = this.stringified;
            return str != null ? str.hashCode() : CharArrayBuilder.this.hashCodeImpl(this.start, this.end);
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ int length() {
            return getLength();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int startIndex, int endIndex) {
            if (startIndex < 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(startIndex, "start is negative: "));
                return null;
            }
            if (startIndex <= endIndex) {
                int i = this.end;
                int i2 = this.start;
                if (endIndex <= i - i2) {
                    return startIndex == endIndex ? "" : CharArrayBuilder.this.new SubSequenceImpl(startIndex + i2, i2 + endIndex);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("end should be less than length ("), length(), ')'));
                return null;
            }
            throw new IllegalArgumentException(("start (" + startIndex + ") should be less or equal to end (" + endIndex + ')').toString());
        }

        @Override // java.lang.CharSequence
        public String toString() {
            String str = this.stringified;
            if (str != null) {
                return str;
            }
            String string = CharArrayBuilder.this.copy(this.start, this.end).toString();
            this.stringified = string;
            return string;
        }
    }

    public /* synthetic */ CharArrayBuilder(ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CharArrayPoolKt.getCharArrayPool() : objectPool);
    }

    private final char[] appendNewArray() {
        List list;
        char[] cArrBorrow = this.pool.borrow();
        char[] cArr = this.current;
        this.current = cArrBorrow;
        this.remaining = cArrBorrow.length;
        this.released = false;
        if (cArr != null) {
            List<char[]> list2 = this.buffers;
            if (list2 == null) {
                list = list2;
                ArrayList arrayList = new ArrayList();
                this.buffers = arrayList;
                arrayList.add(cArr);
                list = arrayList;
            }
            list = list2;
            list.add(cArrBorrow);
        }
        return cArrBorrow;
    }

    private final char[] bufferForIndex(int index) {
        List<char[]> list = this.buffers;
        if (list != null) {
            char[] cArr = this.current;
            cArr.getClass();
            return list.get(index / cArr.length);
        }
        if (index >= 2048) {
            throwSingleBuffer(index);
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return null;
        }
        char[] cArr2 = this.current;
        if (cArr2 != null) {
            return cArr2;
        }
        throwSingleBuffer(index);
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence copy(int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return "";
        }
        StringBuilder sb = new StringBuilder(endIndex - startIndex);
        for (int i = startIndex - (startIndex % 2048); i < endIndex; i += 2048) {
            char[] cArrBufferForIndex = bufferForIndex(i);
            int iMin = Math.min(endIndex - i, 2048);
            for (int iMax = Math.max(0, startIndex - i); iMax < iMin; iMax++) {
                sb.append(cArrBufferForIndex[iMax]);
            }
        }
        return sb;
    }

    private final int currentPosition() {
        char[] cArr = this.current;
        cArr.getClass();
        return cArr.length - this.remaining;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final char getImpl(int index) {
        char[] cArrBufferForIndex = bufferForIndex(index);
        char[] cArr = this.current;
        cArr.getClass();
        return cArrBufferForIndex[index % cArr.length];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int hashCodeImpl(int start, int end) {
        int impl = 0;
        while (start < end) {
            impl = (impl * 31) + getImpl(start);
            start++;
        }
        return impl;
    }

    private final char[] nonFullBuffer() {
        if (this.remaining == 0) {
            return appendNewArray();
        }
        char[] cArr = this.current;
        cArr.getClass();
        return cArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean rangeEqualsImpl(int start, CharSequence other, int otherStart, int length) {
        for (int i = 0; i < length; i++) {
            if (getImpl(start + i) != other.charAt(otherStart + i)) {
                return false;
            }
        }
        return true;
    }

    private final Void throwSingleBuffer(int index) {
        if (this.released) {
            throw new IllegalStateException("Buffer is already released");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(index);
        sb.append(" is not in range [0; ");
        throw new IndexOutOfBoundsException(IntIntPair$$ExternalSyntheticOutline0.m(sb, currentPosition(), ')'));
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence value, int startIndex, int endIndex) {
        if (value == null) {
            return this;
        }
        int i = startIndex;
        while (i < endIndex) {
            char[] cArrNonFullBuffer = nonFullBuffer();
            int length = cArrNonFullBuffer.length;
            int i2 = this.remaining;
            int i3 = length - i2;
            int iMin = Math.min(endIndex - i, i2);
            for (int i4 = 0; i4 < iMin; i4++) {
                cArrNonFullBuffer[i3 + i4] = value.charAt(i + i4);
            }
            i += iMin;
            this.remaining -= iMin;
        }
        this.stringified = null;
        this.length = (endIndex - startIndex) + length();
        return this;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public boolean equals(Object other) {
        if (!(other instanceof CharSequence)) {
            return false;
        }
        CharSequence charSequence = (CharSequence) other;
        if (length() != charSequence.length()) {
            return false;
        }
        return rangeEqualsImpl(0, charSequence, 0, length());
    }

    public char get(int index) {
        if (index < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(index, "index is negative: "));
            return (char) 0;
        }
        if (index < length()) {
            return getImpl(index);
        }
        StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(index, "index ", " is not in range [0, ");
        sbM2m.append(length());
        sbM2m.append(')');
        throw new IllegalArgumentException(sbM2m.toString().toString());
    }

    public int getLength() {
        return this.length;
    }

    public final ObjectPool<char[]> getPool() {
        return this.pool;
    }

    public int hashCode() {
        String str = this.stringified;
        return str != null ? str.hashCode() : hashCodeImpl(0, length());
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public final void release() {
        List<char[]> list = this.buffers;
        if (list != null) {
            this.current = null;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.pool.recycle(list.get(i));
            }
        } else {
            char[] cArr = this.current;
            if (cArr != null) {
                this.pool.recycle(cArr);
            }
            this.current = null;
        }
        this.released = true;
        this.buffers = null;
        this.stringified = null;
        this.length = 0;
        this.remaining = 0;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            throw new IllegalArgumentException(("startIndex (" + startIndex + ") should be less or equal to endIndex (" + endIndex + ')').toString());
        }
        if (startIndex < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(startIndex, "startIndex is negative: "));
            return null;
        }
        if (endIndex <= length()) {
            return new SubSequenceImpl(startIndex, endIndex);
        }
        StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(endIndex, "endIndex (", ") is greater than length (");
        sbM2m.append(length());
        sbM2m.append(')');
        throw new IllegalArgumentException(sbM2m.toString().toString());
    }

    @Override // java.lang.CharSequence
    public String toString() {
        String str = this.stringified;
        if (str != null) {
            return str;
        }
        String string = copy(0, length()).toString();
        this.stringified = string;
        return string;
    }

    public CharArrayBuilder(ObjectPool<char[]> objectPool) {
        objectPool.getClass();
        this.pool = objectPool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CharArrayBuilder() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // java.lang.Appendable
    public Appendable append(char value) {
        char[] cArrNonFullBuffer = nonFullBuffer();
        char[] cArr = this.current;
        cArr.getClass();
        int length = cArr.length;
        int i = this.remaining;
        cArrNonFullBuffer[length - i] = value;
        this.stringified = null;
        this.remaining = i - 1;
        this.length = length() + 1;
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence value) {
        return value == null ? this : append(value, 0, value.length());
    }
}
