package kotlinx.serialization.json.internal;

import androidx.compose.ui.platform.WeakCache;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.datastore.preferences.protobuf.ByteString$LiteralByteString;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.util.List;
import kotlin.collections.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CharArrayPoolBase {
    public Object arrays;
    public int charsTotal;

    public CharArrayPoolBase(byte b) {
        switch (b) {
            case 2:
                break;
            default:
                this.arrays = new ArrayDeque();
                break;
        }
    }

    public abstract void checkLastTagWas(int i);

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd();

    public abstract WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list);

    public abstract WeakCache onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WeakCache weakCache);

    public abstract void popLimit(int i);

    public abstract int pushLimit(int i);

    public abstract boolean readBool();

    public abstract ByteString$LiteralByteString readBytes();

    public abstract double readDouble();

    public abstract int readEnum();

    public abstract int readFixed32();

    public abstract long readFixed64();

    public abstract float readFloat();

    public abstract int readInt32();

    public abstract long readInt64();

    public abstract int readSFixed32();

    public abstract long readSFixed64();

    public abstract int readSInt32();

    public abstract long readSInt64();

    public abstract String readString();

    public abstract String readStringRequireUtf8();

    public abstract int readTag();

    public abstract int readUInt32();

    public abstract long readUInt64();

    public void releaseImpl(char[] cArr) {
        cArr.getClass();
        synchronized (this) {
            int i = this.charsTotal;
            if (cArr.length + i < ArrayPoolsKt.MAX_CHARS_IN_POOL) {
                this.charsTotal = i + cArr.length;
                ((ArrayDeque) this.arrays).addLast(cArr);
            }
        }
    }

    public abstract boolean skipField(int i);

    public void skipMessage() throws InvalidProtocolBufferException {
        boolean zSkipField;
        do {
            int tag = readTag();
            if (tag == 0) {
                return;
            }
            int i = this.charsTotal;
            if (i >= 100) {
                throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.charsTotal = i + 1;
            zSkipField = skipField(tag);
            this.charsTotal--;
        } while (zSkipField);
    }

    public char[] take(int i) {
        char[] cArr;
        synchronized (this) {
            ArrayDeque arrayDeque = (ArrayDeque) this.arrays;
            cArr = null;
            char[] cArr2 = (char[]) (arrayDeque.isEmpty() ? null : arrayDeque.removeLast());
            if (cArr2 != null) {
                this.charsTotal -= cArr2.length;
                cArr = cArr2;
            }
        }
        return cArr == null ? new char[i] : cArr;
    }

    public CharArrayPoolBase(int i) {
        this.charsTotal = i;
    }

    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    }

    public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    }
}
