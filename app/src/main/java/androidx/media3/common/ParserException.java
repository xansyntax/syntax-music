package androidx.media3.common;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ParserException extends IOException {
    public final boolean contentIsMalformed;
    public final boolean dataType;

    /* JADX WARN: Multi-variable type inference failed */
    public ParserException(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.contentIsMalformed = z;
        this.dataType = i;
    }

    public static ParserException createForMalformedContainer(RuntimeException runtimeException, String str) {
        return new ParserException(str, runtimeException, true, 1);
    }

    public static ParserException createForUnsupportedContainerFeature(String str) {
        return new ParserException(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        StringBuilder sb = new StringBuilder(message != null ? message.concat(ServerSentEventKt.SPACE) : "");
        sb.append("{contentIsMalformed=");
        sb.append(this.contentIsMalformed);
        sb.append(", dataType=");
        return Fragment$5$$ExternalSyntheticOutline0.m(sb, this.dataType ? 1 : 0, "}");
    }
}
