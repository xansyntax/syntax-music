package kotlinx.serialization.json.internal;

import androidx.media3.common.FlagSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ComposerForUnquotedLiterals extends FlagSet.Builder {
    public final boolean forceQuoting;

    public ComposerForUnquotedLiterals(InternalJsonWriter internalJsonWriter, boolean z) {
        super(internalJsonWriter);
        this.forceQuoting = z;
    }

    @Override // androidx.media3.common.FlagSet.Builder
    public final void printQuoted(String str) {
        str.getClass();
        InternalJsonWriter internalJsonWriter = (InternalJsonWriter) this.flags;
        if (this.forceQuoting) {
            internalJsonWriter.writeQuoted(str);
        } else {
            internalJsonWriter.write(str);
        }
    }
}
