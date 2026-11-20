package androidx.media3.exoplayer.source;

import androidx.media3.common.ParserException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UnrecognizedInputFormatException extends ParserException {
    public final ImmutableList sniffFailures;

    public UnrecognizedInputFormatException(String str, RegularImmutableList regularImmutableList) {
        super(str, null, false, 1);
        this.sniffFailures = ImmutableList.copyOf((Collection) regularImmutableList);
    }

    @Override // androidx.media3.common.ParserException, java.lang.Throwable
    public final String getMessage() {
        String message = super.getMessage();
        ImmutableList immutableList = this.sniffFailures;
        if (immutableList.isEmpty()) {
            return message;
        }
        return message + "\nsniff failures: " + immutableList;
    }
}
