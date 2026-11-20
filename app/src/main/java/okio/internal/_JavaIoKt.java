package okio.internal;

import java.util.logging.Logger;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class _JavaIoKt {
    public static final Logger logger = Logger.getLogger("okio.Okio");

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? StringsKt.contains(message, "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }
}
