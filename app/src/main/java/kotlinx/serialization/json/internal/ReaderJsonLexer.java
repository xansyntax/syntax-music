package kotlinx.serialization.json.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.json.JsonConfiguration;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class ReaderJsonLexer extends AbstractJsonLexer {
    public final char[] buffer;
    public final InternalJsonReader reader;
    public final ArrayAsSequence source;
    public int threshold;

    public ReaderJsonLexer(InternalJsonReader internalJsonReader, char[] cArr, JsonConfiguration jsonConfiguration) {
        super(jsonConfiguration);
        this.reader = internalJsonReader;
        this.buffer = cArr;
        this.threshold = 128;
        this.source = new ArrayAsSequence(cArr);
        preload(0);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final void appendRange(int i, int i2) {
        ((StringBuilder) this.escapedString).append(this.source.buffer, i, i2 - i);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        ensureHaveChars();
        int i = this.currentPosition;
        while (true) {
            int iPrefetchOrEof = prefetchOrEof(i);
            if (iPrefetchOrEof == -1) {
                this.currentPosition = iPrefetchOrEof;
                return false;
            }
            char c = this.source.buffer[iPrefetchOrEof];
            if (c != ' ' && c != '\n' && c != '\r' && c != '\t') {
                this.currentPosition = iPrefetchOrEof;
                return AbstractJsonLexer.isValidValueStart(c);
            }
            i = iPrefetchOrEof + 1;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String consumeKeyString() {
        consumeNextToken('\"');
        int i = this.currentPosition;
        ArrayAsSequence arrayAsSequence = this.source;
        int i2 = arrayAsSequence.length;
        char[] cArr = arrayAsSequence.buffer;
        int i3 = i;
        while (true) {
            if (i3 >= i2) {
                i3 = -1;
                break;
            }
            if (cArr[i3] == '\"') {
                break;
            }
            i3++;
        }
        if (i3 == -1) {
            int iPrefetchOrEof = prefetchOrEof(i);
            int i4 = this.currentPosition;
            if (iPrefetchOrEof != -1) {
                return consumeString(arrayAsSequence, i4, iPrefetchOrEof);
            }
            int i5 = i4 > 0 ? i4 - 1 : i4;
            AbstractJsonLexer.fail$default(this, IntIntPair$$ExternalSyntheticOutline0.m("Expected quotation mark '\"', but had '", (i4 == arrayAsSequence.length || i5 < 0) ? "EOF" : String.valueOf(arrayAsSequence.buffer[i5]), "' instead"), i5, null, 4);
            throw null;
        }
        for (int i6 = i; i6 < i3; i6++) {
            if (cArr[i6] == '\\') {
                return consumeString(arrayAsSequence, this.currentPosition, i6);
            }
        }
        this.currentPosition = i3 + 1;
        return StringsKt__StringsJVMKt.concatToString(cArr, i, Math.min(i3, arrayAsSequence.length));
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeNextToken(char c) {
        ensureHaveChars();
        int i = this.currentPosition;
        while (true) {
            int iPrefetchOrEof = prefetchOrEof(i);
            if (iPrefetchOrEof == -1) {
                this.currentPosition = iPrefetchOrEof;
                unexpectedToken(c);
                throw null;
            }
            int i2 = iPrefetchOrEof + 1;
            char c2 = this.source.buffer[iPrefetchOrEof];
            if (c2 != ' ' && c2 != '\n' && c2 != '\r' && c2 != '\t') {
                this.currentPosition = i2;
                if (c2 == c) {
                    return;
                }
                unexpectedToken(c);
                throw null;
            }
            i = i2;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final void ensureHaveChars() {
        int i = this.source.length - this.currentPosition;
        if (i > this.threshold) {
            return;
        }
        preload(i);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final CharSequence getSource() {
        return this.source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final int prefetchOrEof(int i) {
        ArrayAsSequence arrayAsSequence = this.source;
        if (i < arrayAsSequence.length) {
            return i;
        }
        this.currentPosition = i;
        ensureHaveChars();
        return (this.currentPosition != 0 || arrayAsSequence.length() == 0) ? -1 : 0;
    }

    public final void preload(int i) {
        ArrayAsSequence arrayAsSequence = this.source;
        char[] cArr = arrayAsSequence.buffer;
        if (i != 0) {
            int i2 = this.currentPosition;
            System.arraycopy(cArr, i2, cArr, 0, (i2 + i) - i2);
        }
        int i3 = arrayAsSequence.length;
        while (i != i3) {
            int i4 = this.reader.read(cArr, i, i3 - i);
            if (i4 == -1) {
                arrayAsSequence.length = Math.min(arrayAsSequence.buffer.length, i);
                this.threshold = -1;
                break;
            }
            i += i4;
        }
        this.currentPosition = 0;
    }

    public final void release() {
        CharArrayPoolBatchSize charArrayPoolBatchSize = CharArrayPoolBatchSize.INSTANCE;
        charArrayPoolBatchSize.getClass();
        char[] cArr = this.buffer;
        cArr.getClass();
        if (cArr.length == 16384) {
            charArrayPoolBatchSize.releaseImpl(cArr);
            return;
        }
        throw new IllegalArgumentException(("Inconsistent internal invariant: unexpected array size " + cArr.length).toString());
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int skipWhitespaces() {
        int iPrefetchOrEof;
        char c;
        int i = this.currentPosition;
        while (true) {
            iPrefetchOrEof = prefetchOrEof(i);
            if (iPrefetchOrEof == -1 || !((c = this.source.buffer[iPrefetchOrEof]) == ' ' || c == '\n' || c == '\r' || c == '\t')) {
                break;
            }
            i = iPrefetchOrEof + 1;
        }
        this.currentPosition = iPrefetchOrEof;
        return iPrefetchOrEof;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String substring(int i, int i2) {
        ArrayAsSequence arrayAsSequence = this.source;
        return StringsKt__StringsJVMKt.concatToString(arrayAsSequence.buffer, i, Math.min(i2, arrayAsSequence.length));
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        ensureHaveChars();
        int i = this.currentPosition;
        while (true) {
            int iPrefetchOrEof = prefetchOrEof(i);
            if (iPrefetchOrEof != -1) {
                int i2 = iPrefetchOrEof + 1;
                byte bCharToTokenClass = WriteModeKt.charToTokenClass(this.source.buffer[iPrefetchOrEof]);
                if (bCharToTokenClass != 3) {
                    this.currentPosition = i2;
                    return bCharToTokenClass;
                }
                i = i2;
            } else {
                this.currentPosition = iPrefetchOrEof;
                return (byte) 10;
            }
        }
    }
}
