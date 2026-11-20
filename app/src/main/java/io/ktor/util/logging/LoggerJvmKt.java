package io.ktor.util.logging;

import kotlin.Metadata;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u0019\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0005\u001a\u00020\u0002*\u00060\u0000j\u0002`\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004*\n\u0010\u0006\"\u00020\u00002\u00020\u0000¨\u0006\u0007"}, d2 = {"Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "", "isTraceEnabled", "(Lorg/slf4j/Logger;)Z", "isDebugEnabled", "Logger", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LoggerJvmKt {
    public static final boolean isDebugEnabled(Logger logger) {
        logger.getClass();
        return logger.isDebugEnabled();
    }

    public static final boolean isTraceEnabled(Logger logger) {
        logger.getClass();
        return logger.isTraceEnabled();
    }
}
