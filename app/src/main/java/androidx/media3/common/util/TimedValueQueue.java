package androidx.media3.common.util;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.LruCache;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.emoji2.text.EmojiCompat;
import coil3.util.UtilsKt;
import java.lang.ref.WeakReference;
import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TimedValueQueue {
    public final /* synthetic */ byte $r8$classId;
    public int first;
    public int size;
    public Object timestamps;
    public Object values;

    public TimedValueQueue(CharSequence charSequence, int i, Locale locale) {
        this.$r8$classId = (byte) 2;
        this.timestamps = charSequence;
        if (charSequence.length() < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("input start index is outside the CharSequence");
        }
        if (i < 0 || i > charSequence.length()) {
            InlineClassHelperKt.throwIllegalArgumentException("input end index is outside the CharSequence");
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
        this.values = wordInstance;
        this.first = Math.max(0, -50);
        this.size = Math.min(charSequence.length(), i + 50);
        wordInstance.setText(new CharSequenceCharacterIterator(charSequence, i));
    }

    public synchronized void add(long j, Object obj) {
        int i = this.size;
        if (i > 0) {
            if (j <= ((long[]) this.timestamps)[((this.first + i) - 1) % ((Object[]) this.values).length]) {
                synchronized (this) {
                    this.first = 0;
                    this.size = 0;
                    Arrays.fill((Object[]) this.values, (Object) null);
                }
            }
        }
        doubleCapacityIfFull();
        int i2 = this.first;
        int i3 = this.size;
        Object[] objArr = (Object[]) this.values;
        int length = (i2 + i3) % objArr.length;
        ((long[]) this.timestamps)[length] = j;
        objArr[length] = obj;
        this.size = i3 + 1;
    }

    public void callbackFailAsync(final int i) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onFontRetrievalFailed(i);
            }
        });
    }

    public void checkOffsetIsValid(int i) {
        int i2 = this.first;
        int i3 = this.size;
        boolean z = false;
        if (i <= i3 && i2 <= i) {
            z = true;
        }
        if (z) {
            return;
        }
        StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i, "Invalid offset: ", ". Valid range is [", i2, " , ");
        sbM3m.append(i3);
        sbM3m.append("]");
        InlineClassHelperKt.throwIllegalArgumentException(sbM3m.toString());
    }

    public void doubleCapacityIfFull() {
        int length = ((Object[]) this.values).length;
        if (this.size < length) {
            return;
        }
        int i = length * 2;
        long[] jArr = new long[i];
        Object[] objArr = new Object[i];
        int i2 = this.first;
        int i3 = length - i2;
        System.arraycopy((long[]) this.timestamps, i2, jArr, 0, i3);
        System.arraycopy((Object[]) this.values, this.first, objArr, 0, i3);
        int i4 = this.first;
        if (i4 > 0) {
            System.arraycopy((long[]) this.timestamps, 0, jArr, i3, i4);
            System.arraycopy((Object[]) this.values, 0, objArr, i3, this.first);
        }
        this.timestamps = jArr;
        this.values = objArr;
        this.first = 0;
    }

    public int getLength() {
        GapBuffer gapBuffer = (GapBuffer) this.values;
        String str = (String) this.timestamps;
        if (gapBuffer == null) {
            return str.length();
        }
        return (gapBuffer.capacity - gapBuffer.gapLength()) + (str.length() - (this.size - this.first));
    }

    public boolean isAfterLetterOrDigitOrEmoji(int i) {
        CharSequence charSequence = (CharSequence) this.timestamps;
        int i2 = this.first + 1;
        if (i > this.size || i2 > i) {
            return false;
        }
        if (!Character.isLetterOrDigit(Character.codePointBefore(charSequence, i))) {
            int i3 = i - 1;
            if (!Character.isSurrogate(charSequence.charAt(i3))) {
                if (!EmojiCompat.isConfigured()) {
                    return false;
                }
                EmojiCompat emojiCompat = EmojiCompat.get();
                if (emojiCompat.getLoadState() != 1 || emojiCompat.getEmojiStart(charSequence, i3) == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAfterPunctuation(int i) {
        int i2 = this.first + 1;
        if (i > this.size || i2 > i) {
            return false;
        }
        return UtilsKt.isPunctuation$ui_text(Character.codePointBefore((CharSequence) this.timestamps, i));
    }

    public boolean isBoundary(int i) {
        checkOffsetIsValid(i);
        if (!((BreakIterator) this.values).isBoundary(i)) {
            return false;
        }
        if (isOnLetterOrDigitOrEmoji(i) && isOnLetterOrDigitOrEmoji(i - 1) && isOnLetterOrDigitOrEmoji(i + 1)) {
            return false;
        }
        return i <= 0 || i >= ((CharSequence) this.timestamps).length() - 1 || !(isHiraganaKatakanaBoundary(i) || isHiraganaKatakanaBoundary(i + 1));
    }

    public boolean isHiraganaKatakanaBoundary(int i) {
        CharSequence charSequence = (CharSequence) this.timestamps;
        int i2 = i - 1;
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(charSequence.charAt(i2));
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.HIRAGANA;
        if (Intrinsics.areEqual(unicodeBlockOf, unicodeBlock) && Intrinsics.areEqual(Character.UnicodeBlock.of(charSequence.charAt(i)), Character.UnicodeBlock.KATAKANA)) {
            return true;
        }
        return Intrinsics.areEqual(Character.UnicodeBlock.of(charSequence.charAt(i)), unicodeBlock) && Intrinsics.areEqual(Character.UnicodeBlock.of(charSequence.charAt(i2)), Character.UnicodeBlock.KATAKANA);
    }

    public boolean isOnLetterOrDigitOrEmoji(int i) {
        CharSequence charSequence = (CharSequence) this.timestamps;
        int i2 = this.first;
        if (i >= this.size || i2 > i) {
            return false;
        }
        if (!Character.isLetterOrDigit(Character.codePointAt(charSequence, i)) && !Character.isSurrogate(charSequence.charAt(i))) {
            if (!EmojiCompat.isConfigured()) {
                return false;
            }
            EmojiCompat emojiCompat = EmojiCompat.get();
            if (emojiCompat.getLoadState() != 1 || emojiCompat.getEmojiStart(charSequence, i) == -1) {
                return false;
            }
        }
        return true;
    }

    public boolean isOnPunctuation(int i) {
        int i2 = this.first;
        if (i >= this.size || i2 > i) {
            return false;
        }
        return UtilsKt.isPunctuation$ui_text(Character.codePointAt((CharSequence) this.timestamps, i));
    }

    public int nextBoundary(int i) {
        checkOffsetIsValid(i);
        int iFollowing = ((BreakIterator) this.values).following(i);
        return (isOnLetterOrDigitOrEmoji(iFollowing + (-1)) && isOnLetterOrDigitOrEmoji(iFollowing) && !isHiraganaKatakanaBoundary(iFollowing)) ? nextBoundary(iFollowing) : iFollowing;
    }

    public void onFontRetrieved(final Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.first) != -1) {
            typeface = HandlerCompat$Api28Impl.create(typeface, i, (this.size & 2) != 0);
        }
        AppCompatTextHelper appCompatTextHelper = (AppCompatTextHelper) this.values;
        WeakReference weakReference = (WeakReference) this.timestamps;
        if (appCompatTextHelper.mAsyncFontPending) {
            appCompatTextHelper.mFontTypeface = typeface;
            final TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                boolean zIsAttachedToWindow = textView.isAttachedToWindow();
                final int i2 = appCompatTextHelper.mStyle;
                if (zIsAttachedToWindow) {
                    textView.post(new Runnable() { // from class: androidx.appcompat.widget.AppCompatTextHelper.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            LruCache lruCache = Api26Impl.sVariationsCache;
                            TextView textView2 = textView;
                            String fontVariationSettings = textView2.getFontVariationSettings();
                            if (!TextUtils.isEmpty(fontVariationSettings)) {
                                Api26Impl.setFontVariationSettings(textView2, null);
                            }
                            textView2.setTypeface(typeface, i2);
                            if (TextUtils.isEmpty(fontVariationSettings)) {
                                return;
                            }
                            Api26Impl.setFontVariationSettings(textView2, fontVariationSettings);
                        }
                    });
                    return;
                }
                LruCache lruCache = AppCompatTextHelper.Api26Impl.sVariationsCache;
                String fontVariationSettings = textView.getFontVariationSettings();
                if (!TextUtils.isEmpty(fontVariationSettings)) {
                    AppCompatTextHelper.Api26Impl.setFontVariationSettings(textView, null);
                }
                textView.setTypeface(typeface, i2);
                if (TextUtils.isEmpty(fontVariationSettings)) {
                    return;
                }
                AppCompatTextHelper.Api26Impl.setFontVariationSettings(textView, fontVariationSettings);
            }
        }
    }

    public synchronized Object pollFirst() {
        return this.size == 0 ? null : popFirst();
    }

    public synchronized Object pollFloor(long j) {
        Object objPopFirst;
        objPopFirst = null;
        while (this.size > 0 && j - ((long[]) this.timestamps)[this.first] >= 0) {
            objPopFirst = popFirst();
        }
        return objPopFirst;
    }

    public Object popFirst() {
        UtilsKt.checkState(this.size > 0);
        Object[] objArr = (Object[]) this.values;
        int i = this.first;
        Object obj = objArr[i];
        objArr[i] = null;
        this.first = (i + 1) % objArr.length;
        this.size--;
        return obj;
    }

    public int prevBoundary(int i) {
        checkOffsetIsValid(i);
        int iPreceding = ((BreakIterator) this.values).preceding(i);
        return (isOnLetterOrDigitOrEmoji(iPreceding) && isAfterLetterOrDigitOrEmoji(iPreceding) && !isHiraganaKatakanaBoundary(iPreceding)) ? prevBoundary(iPreceding) : iPreceding;
    }

    public void replace(int i, int i2, String str) {
        if (i > i2) {
            InlineClassHelperKt.throwIllegalArgumentException("start index must be less than or equal to end index: " + i + " > " + i2);
        }
        if (i < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start must be non-negative, but was " + i);
        }
        GapBuffer gapBuffer = (GapBuffer) this.values;
        if (gapBuffer == null) {
            int iMax = Math.max(255, str.length() + 128);
            char[] cArr = new char[iMax];
            int iMin = Math.min(i, 64);
            int iMin2 = Math.min(((String) this.timestamps).length() - i2, 64);
            String str2 = (String) this.timestamps;
            int i3 = i - iMin;
            str2.getClass();
            str2.getChars(i3, i, cArr, 0);
            String str3 = (String) this.timestamps;
            int i4 = iMax - iMin2;
            int i5 = iMin2 + i2;
            str3.getClass();
            str3.getChars(i2, i5, cArr, i4);
            str.getChars(0, str.length(), cArr, iMin);
            int length = str.length() + iMin;
            GapBuffer gapBuffer2 = new GapBuffer((byte) 0);
            gapBuffer2.capacity = iMax;
            gapBuffer2.buffer = cArr;
            gapBuffer2.gapStart = length;
            gapBuffer2.gapEnd = i4;
            this.values = gapBuffer2;
            this.first = i3;
            this.size = i5;
            return;
        }
        int i6 = this.first;
        int i7 = i - i6;
        int i8 = i2 - i6;
        if (i7 < 0 || i8 > gapBuffer.capacity - gapBuffer.gapLength()) {
            this.timestamps = toString();
            this.values = null;
            this.first = -1;
            this.size = -1;
            replace(i, i2, str);
            return;
        }
        int length2 = str.length() - (i8 - i7);
        if (length2 > gapBuffer.gapLength()) {
            int iGapLength = length2 - gapBuffer.gapLength();
            int i9 = gapBuffer.capacity;
            do {
                i9 *= 2;
            } while (i9 - gapBuffer.capacity < iGapLength);
            char[] cArr2 = new char[i9];
            System.arraycopy((char[]) gapBuffer.buffer, 0, cArr2, 0, gapBuffer.gapStart);
            int i10 = gapBuffer.capacity;
            int i11 = gapBuffer.gapEnd;
            int i12 = i10 - i11;
            int i13 = i9 - i12;
            System.arraycopy((char[]) gapBuffer.buffer, i11, cArr2, i13, (i12 + i11) - i11);
            gapBuffer.buffer = cArr2;
            gapBuffer.capacity = i9;
            gapBuffer.gapEnd = i13;
        }
        int i14 = gapBuffer.gapStart;
        if (i7 < i14 && i8 <= i14) {
            int i15 = i14 - i8;
            char[] cArr3 = (char[]) gapBuffer.buffer;
            System.arraycopy(cArr3, i8, cArr3, gapBuffer.gapEnd - i15, i15);
            gapBuffer.gapStart = i7;
            gapBuffer.gapEnd -= i15;
        } else if (i7 >= i14 || i8 < i14) {
            int iGapLength2 = gapBuffer.gapLength() + i7;
            int iGapLength3 = gapBuffer.gapLength() + i8;
            int i16 = gapBuffer.gapEnd;
            int i17 = iGapLength2 - i16;
            char[] cArr4 = (char[]) gapBuffer.buffer;
            System.arraycopy(cArr4, i16, cArr4, gapBuffer.gapStart, i17);
            i7 = gapBuffer.gapStart + i17;
            gapBuffer.gapStart = i7;
            gapBuffer.gapEnd = iGapLength3;
        } else {
            gapBuffer.gapEnd = gapBuffer.gapLength() + i8;
            gapBuffer.gapStart = i7;
        }
        str.getChars(0, str.length(), (char[]) gapBuffer.buffer, i7);
        gapBuffer.gapStart = str.length() + gapBuffer.gapStart;
    }

    public synchronized int size() {
        return this.size;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 3:
                GapBuffer gapBuffer = (GapBuffer) this.values;
                String str = (String) this.timestamps;
                if (gapBuffer == null) {
                    return str;
                }
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) str, 0, this.first);
                sb.append((char[]) gapBuffer.buffer, 0, gapBuffer.gapStart);
                char[] cArr = (char[]) gapBuffer.buffer;
                int i = gapBuffer.gapEnd;
                sb.append(cArr, i, gapBuffer.capacity - i);
                String str2 = (String) this.timestamps;
                sb.append((CharSequence) str2, this.size, str2.length());
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public void onFontRetrievalFailed(int i) {
    }

    public TimedValueQueue(byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 3:
                break;
            default:
                this.timestamps = new long[10];
                this.values = new Object[10];
                break;
        }
    }

    public TimedValueQueue(AppCompatTextHelper appCompatTextHelper, int i, int i2, WeakReference weakReference) {
        this.$r8$classId = (byte) 1;
        this.values = appCompatTextHelper;
        this.first = i;
        this.size = i2;
        this.timestamps = weakReference;
    }
}
