package kotlinx.serialization.json.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import kotlin.collections.ArrayDeque;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class CharsetReader {
    public final ByteBuffer byteBuffer;
    public final CharsetDecoder decoder;
    public boolean hasLeftoverPotentiallySurrogateChar;
    public final InputStream inputStream;
    public char leftoverChar;

    public CharsetReader(InputStream inputStream, Charset charset) {
        byte[] bArr;
        charset.getClass();
        this.inputStream = inputStream;
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetDecoder charsetDecoderOnUnmappableCharacter = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        charsetDecoderOnUnmappableCharacter.getClass();
        this.decoder = charsetDecoderOnUnmappableCharacter;
        ByteArrayPool8k byteArrayPool8k = ByteArrayPool8k.INSTANCE;
        synchronized (byteArrayPool8k) {
            ArrayDeque arrayDeque = byteArrayPool8k.arrays;
            byte[] bArr2 = (byte[]) (arrayDeque.isEmpty() ? null : arrayDeque.removeLast());
            bArr = bArr2 != null ? bArr2 : null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr == null ? new byte[8196] : bArr);
        byteBufferWrap.getClass();
        this.byteBuffer = byteBufferWrap;
        byteBufferWrap.flip();
    }

    public final int read(char[] cArr, int i, int i2) throws CharacterCodingException {
        int i3;
        CharsetDecoder charsetDecoder;
        char c;
        char c2;
        char c3;
        char c4;
        if (i2 == 0) {
            return 0;
        }
        if (i < 0 || i >= cArr.length || i2 < 0 || i + i2 > cArr.length) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m3m(i, "Unexpected arguments: ", ", ", i2, ", "), cArr.length);
            return 0;
        }
        boolean z = this.hasLeftoverPotentiallySurrogateChar;
        boolean z2 = true;
        if (z) {
            cArr[i] = this.leftoverChar;
            i++;
            i2--;
            this.hasLeftoverPotentiallySurrogateChar = false;
            if (i2 == 0) {
                return 1;
            }
            z = false;
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i2 == 1) {
            if (z) {
                this.hasLeftoverPotentiallySurrogateChar = false;
                c4 = this.leftoverChar;
            } else {
                char[] cArr2 = new char[2];
                int i4 = read(cArr2, 0, 2);
                if (i4 == -1) {
                    c = 65535;
                } else if (i4 == 1) {
                    c2 = cArr2[0];
                } else {
                    if (i4 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(i4, "Unreachable state: ");
                        return 0;
                    }
                    this.leftoverChar = cArr2[1];
                    this.hasLeftoverPotentiallySurrogateChar = true;
                    c3 = cArr2[0];
                }
            }
            if (c != 65535) {
                c = c2;
                c = c3;
                c = c4;
                cArr[i] = c;
                return i3 + 1;
            }
            if (i3 == 0) {
                return -1;
            }
            return i3;
        }
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr, i, i2);
        if (charBufferWrap.position() != 0) {
            charBufferWrap = charBufferWrap.slice();
        }
        CharBuffer charBuffer = charBufferWrap;
        boolean z3 = false;
        while (true) {
            charsetDecoder = this.decoder;
            ByteBuffer byteBuffer = this.byteBuffer;
            CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, charBuffer, z3);
            if (coderResultDecode.isUnderflow()) {
                if (z3 || !charBuffer.hasRemaining()) {
                    z2 = z3;
                    break;
                }
                byteBuffer.compact();
                try {
                    int iLimit = byteBuffer.limit();
                    int iPosition = byteBuffer.position();
                    int iRemaining = this.inputStream.read(byteBuffer.array(), byteBuffer.arrayOffset() + iPosition, iPosition <= iLimit ? iLimit - iPosition : 0);
                    if (iRemaining < 0) {
                        byteBuffer.flip();
                    } else {
                        byteBuffer.position(iPosition + iRemaining);
                        byteBuffer.flip();
                        iRemaining = byteBuffer.remaining();
                    }
                    if (iRemaining < 0) {
                        if (charBuffer.position() == 0 && !byteBuffer.hasRemaining()) {
                            break;
                        }
                        charsetDecoder.reset();
                        z3 = true;
                    } else {
                        continue;
                    }
                } catch (Throwable th) {
                    byteBuffer.flip();
                    throw th;
                }
            } else {
                if (coderResultDecode.isOverflow()) {
                    charBuffer.position();
                    z2 = z3;
                    break;
                }
                coderResultDecode.throwException();
            }
        }
        if (z2) {
            charsetDecoder.reset();
        }
        return (charBuffer.position() != 0 ? charBuffer.position() : -1) + i3;
    }
}
