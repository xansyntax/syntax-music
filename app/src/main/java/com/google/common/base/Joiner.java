package com.google.common.base;

import android.text.TextUtils;
import androidx.emoji2.text.EmojiProcessor;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.common.util.concurrent.FutureCallback;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class Joiner implements EmojiProcessor.EmojiProcessCallback, FutureCallback, SupportSQLiteQuery {
    public final /* synthetic */ byte $r8$classId;
    public String separator;

    public Joiner(String str) {
        this.$r8$classId = (byte) 0;
        str.getClass();
        this.separator = str;
    }

    public static Joiner parse(ParsableByteArray parsableByteArray) {
        String str;
        byte b = 2;
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i = unsignedByte >> 1;
        int unsignedByte2 = ((parsableByteArray.readUnsignedByte() >> 3) & 31) | ((unsignedByte & 1) << 5);
        if (i == 4 || i == 5 || i == 7 || i == 8) {
            str = "dvhe";
        } else if (i == 9) {
            str = "dvav";
        } else {
            if (i != 10) {
                return null;
            }
            str = "dav1";
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append(i < 10 ? ".0" : ".");
        sb.append(i);
        sb.append(unsignedByte2 < 10 ? ".0" : ".");
        sb.append(unsignedByte2);
        return new Joiner(sb.toString(), b);
    }

    public void appendTo(StringBuilder sb, Iterator it) {
        try {
            if (it.hasNext()) {
                sb.append(toString(it.next()));
                while (it.hasNext()) {
                    sb.append((CharSequence) this.separator);
                    sb.append(toString(it.next()));
                }
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.separator;
    }

    @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
    public boolean handleEmoji(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (!TextUtils.equals(charSequence.subSequence(i, i2), this.separator)) {
            return true;
        }
        typefaceEmojiRasterizer.mCache = (typefaceEmojiRasterizer.mCache & 3) | 4;
        return false;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onFailure(Throwable th) {
        Log.w("MediaNtfMng", "custom command " + this.separator + " produced an error: " + th.getMessage(), th);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onSuccess(Object obj) {
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 5:
                return Format$$ExternalSyntheticOutline0.m(new StringBuilder("<"), this.separator, '>');
            default:
                return super.toString();
        }
    }

    public /* synthetic */ Joiner(String str, byte b) {
        this.$r8$classId = b;
        this.separator = str;
    }

    @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
    public Object getResult() {
        return this;
    }

    public static CharSequence toString(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
    }
}
