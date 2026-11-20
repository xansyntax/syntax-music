package kotlinx.serialization.json.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonConfiguration;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class StringJsonLexer extends AbstractJsonLexer {
    public final String source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringJsonLexer(String str, JsonConfiguration jsonConfiguration) {
        super(jsonConfiguration);
        str.getClass();
        this.source = str;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        int i = this.currentPosition;
        if (i == -1) {
            return false;
        }
        while (true) {
            String str = this.source;
            if (i >= str.length()) {
                this.currentPosition = i;
                return false;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = i;
                return AbstractJsonLexer.isValidValueStart(cCharAt);
            }
            i++;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String consumeKeyString() {
        consumeNextToken('\"');
        int i = this.currentPosition;
        String str = this.source;
        int iIndexOf$default = StringsKt.indexOf$default(str, '\"', i, 4);
        if (iIndexOf$default == -1) {
            consumeStringLenient();
            int i2 = this.currentPosition;
            AbstractJsonLexer.fail$default(this, IntIntPair$$ExternalSyntheticOutline0.m("Expected quotation mark '\"', but had '", (i2 == str.length() || i2 < 0) ? "EOF" : String.valueOf(str.charAt(i2)), "' instead"), i2, null, 4);
            throw null;
        }
        for (int i3 = i; i3 < iIndexOf$default; i3++) {
            if (str.charAt(i3) == '\\') {
                return consumeString(str, this.currentPosition, i3);
            }
        }
        this.currentPosition = iIndexOf$default + 1;
        return str.substring(i, iIndexOf$default);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeNextToken(char c) {
        int i = this.currentPosition;
        if (i == -1) {
            unexpectedToken(c);
            throw null;
        }
        while (true) {
            String str = this.source;
            if (i >= str.length()) {
                this.currentPosition = -1;
                unexpectedToken(c);
                throw null;
            }
            int i2 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = i2;
                if (cCharAt == c) {
                    return;
                }
                unexpectedToken(c);
                throw null;
            }
            i = i2;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final CharSequence getSource() {
        return this.source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String peekLeadingMatchingValue(String str, boolean z) {
        str.getClass();
        int i = this.currentPosition;
        try {
            if (consumeNextToken() == 6 && Intrinsics.areEqual(peekString(z), str)) {
                this.peekedString = null;
                if (consumeNextToken() == 5) {
                    return peekString(z);
                }
            }
            return null;
        } finally {
            this.currentPosition = i;
            this.peekedString = null;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final int prefetchOrEof(int i) {
        if (i < this.source.length()) {
            return i;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int skipWhitespaces() {
        char cCharAt;
        int i = this.currentPosition;
        if (i == -1) {
            return i;
        }
        while (true) {
            String str = this.source;
            if (i >= str.length() || !((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
                break;
            }
            i++;
        }
        this.currentPosition = i;
        return i;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        String str;
        int i = this.currentPosition;
        while (true) {
            str = this.source;
            if (i == -1 || i >= str.length()) {
                break;
            }
            int i2 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.currentPosition = i2;
                return WriteModeKt.charToTokenClass(cCharAt);
            }
            i = i2;
        }
        this.currentPosition = str.length();
        return (byte) 10;
    }
}
