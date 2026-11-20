package com.metrolist.innertubex.extraction;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StreamResolveException extends IllegalStateException {
    public final StreamDiagnostics diagnostics;
    public final Reason reason;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Reason {
        public static final /* synthetic */ Reason[] $VALUES;
        public static final Reason AGE_RESTRICTED;
        public static final Reason EXPLICIT_UNSUPPORTED;
        public static final Reason NETWORK;
        public static final Reason NO_PLAYABLE_STREAM;
        public static final Reason UNAVAILABLE;

        static {
            Reason reason = new Reason("NO_PLAYABLE_STREAM", 0);
            NO_PLAYABLE_STREAM = reason;
            Reason reason2 = new Reason("EXPLICIT_UNSUPPORTED", 1);
            EXPLICIT_UNSUPPORTED = reason2;
            Reason reason3 = new Reason("UNAVAILABLE", 2);
            UNAVAILABLE = reason3;
            Reason reason4 = new Reason("AGE_RESTRICTED", 3);
            AGE_RESTRICTED = reason4;
            Reason reason5 = new Reason("NO_MUSIC_VIDEO", 4);
            Reason reason6 = new Reason("NETWORK", 5);
            NETWORK = reason6;
            $VALUES = new Reason[]{reason, reason2, reason3, reason4, reason5, reason6, new Reason("UNKNOWN", 6)};
        }

        public static Reason valueOf(String str) {
            return (Reason) Enum.valueOf(Reason.class, str);
        }

        public static Reason[] values() {
            return (Reason[]) $VALUES.clone();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamResolveException(Reason reason, String str, Throwable th, StreamDiagnostics streamDiagnostics) {
        super(str, th);
        reason.getClass();
        this.reason = reason;
        this.diagnostics = streamDiagnostics;
    }
}
