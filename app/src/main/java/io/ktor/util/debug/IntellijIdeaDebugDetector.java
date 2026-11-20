package io.ktor.util.debug;

import java.lang.management.ManagementFactory;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.SynchronizedLazyImpl;
import kotlin.text.StringsKt;
import kotlinx.io.SourcesJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0007\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/util/debug/IntellijIdeaDebugDetector;", "", "<init>", "()V", "", "isDebuggerConnected$delegate", "Lkotlin/Lazy;", "isDebuggerConnected", "()Z", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IntellijIdeaDebugDetector {
    public static final IntellijIdeaDebugDetector INSTANCE = new IntellijIdeaDebugDetector();

    /* JADX INFO: renamed from: isDebuggerConnected$delegate, reason: from kotlin metadata */
    private static final Lazy isDebuggerConnected = new SynchronizedLazyImpl(new SourcesJvmKt$$ExternalSyntheticLambda0((byte) 3));

    private IntellijIdeaDebugDetector() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDebuggerConnected_delegate$lambda$0() {
        try {
            return StringsKt.contains(ManagementFactory.getRuntimeMXBean().getInputArguments().toString(), "jdwp", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean isDebuggerConnected() {
        return ((Boolean) isDebuggerConnected.getValue()).booleanValue();
    }
}
