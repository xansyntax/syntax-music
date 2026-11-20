package kotlinx.serialization.json.internal;

import androidx.media3.common.FlagSet;
import kotlin.UByte;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ComposerForUnsignedNumbers extends FlagSet.Builder {
    public final boolean forceQuoting;

    public ComposerForUnsignedNumbers(InternalJsonWriter internalJsonWriter, boolean z) {
        super(internalJsonWriter);
        this.forceQuoting = z;
    }

    @Override // androidx.media3.common.FlagSet.Builder
    public final void print(short s) {
        if (this.forceQuoting) {
            printQuoted(String.valueOf(s & 65535));
            return;
        }
        String strValueOf = String.valueOf(s & 65535);
        strValueOf.getClass();
        ((InternalJsonWriter) this.flags).write(strValueOf);
    }

    @Override // androidx.media3.common.FlagSet.Builder
    public final void print(long j) {
        boolean z = this.forceQuoting;
        String unsignedString = Long.toUnsignedString(j);
        if (z) {
            printQuoted(unsignedString);
        } else {
            unsignedString.getClass();
            ((InternalJsonWriter) this.flags).write(unsignedString);
        }
    }

    @Override // androidx.media3.common.FlagSet.Builder
    public final void print(byte b) {
        boolean z = this.forceQuoting;
        String strM1868toStringimpl = UByte.m1868toStringimpl(b);
        if (z) {
            printQuoted(strM1868toStringimpl);
        } else {
            strM1868toStringimpl.getClass();
            ((InternalJsonWriter) this.flags).write(strM1868toStringimpl);
        }
    }

    @Override // androidx.media3.common.FlagSet.Builder
    public final void print(int i) {
        boolean z = this.forceQuoting;
        String unsignedString = Integer.toUnsignedString(i);
        if (z) {
            printQuoted(unsignedString);
        } else {
            unsignedString.getClass();
            ((InternalJsonWriter) this.flags).write(unsignedString);
        }
    }
}
