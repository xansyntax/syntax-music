package kotlinx.serialization.json.internal;

import androidx.media3.common.FlagSet;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ComposerWithPrettyPrint extends FlagSet.Builder {
    public final Json json;
    public int level;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerWithPrettyPrint(InternalJsonWriter internalJsonWriter, Json json) {
        super(internalJsonWriter);
        json.getClass();
        this.json = json;
    }

    @Override // androidx.media3.common.FlagSet.Builder
    public final void indent() {
        this.buildCalled = true;
        this.level++;
    }

    @Override // androidx.media3.common.FlagSet.Builder
    public final void nextItem() {
        this.buildCalled = false;
        InternalJsonWriter internalJsonWriter = (InternalJsonWriter) this.flags;
        internalJsonWriter.write("\n");
        int i = this.level;
        for (int i2 = 0; i2 < i; i2++) {
            internalJsonWriter.write(this.json.configuration.prettyPrintIndent);
        }
    }

    @Override // androidx.media3.common.FlagSet.Builder
    public final void nextItemIfNotFirst() {
        if (this.buildCalled) {
            this.buildCalled = false;
        } else {
            nextItem();
        }
    }

    @Override // androidx.media3.common.FlagSet.Builder
    public final void space() {
        print(' ');
    }

    @Override // androidx.media3.common.FlagSet.Builder
    public final void unIndent() {
        this.level--;
    }
}
