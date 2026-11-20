package io.ktor.client.statement;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\" \u0010\u0004\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"", "USE_ENGINE_DISPATCHER_KEY", "Ljava/lang/String;", "", "useEngineDispatcher", "Z", "getUseEngineDispatcher", "()Z", "getUseEngineDispatcher$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DispatcherSwitching_jvmKt {
    private static final String USE_ENGINE_DISPATCHER_KEY = "io.ktor.client.statement.useEngineDispatcher";
    private static final boolean useEngineDispatcher = Boolean.parseBoolean(System.getProperty(USE_ENGINE_DISPATCHER_KEY, "false"));

    public static final boolean getUseEngineDispatcher() {
        return useEngineDispatcher;
    }

    public static /* synthetic */ void getUseEngineDispatcher$annotations() {
    }
}
