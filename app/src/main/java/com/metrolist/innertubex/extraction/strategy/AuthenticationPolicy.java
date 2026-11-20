package com.metrolist.innertubex.extraction.strategy;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AuthenticationPolicy {
    public static final /* synthetic */ AuthenticationPolicy[] $VALUES;
    public static final AuthenticationPolicy OPTIONAL;
    public static final AuthenticationPolicy REQUIRED;
    public static final AuthenticationPolicy UNSUPPORTED;

    static {
        AuthenticationPolicy authenticationPolicy = new AuthenticationPolicy("UNSUPPORTED", 0);
        UNSUPPORTED = authenticationPolicy;
        AuthenticationPolicy authenticationPolicy2 = new AuthenticationPolicy("OPTIONAL", 1);
        OPTIONAL = authenticationPolicy2;
        AuthenticationPolicy authenticationPolicy3 = new AuthenticationPolicy("REQUIRED", 2);
        REQUIRED = authenticationPolicy3;
        $VALUES = new AuthenticationPolicy[]{authenticationPolicy, authenticationPolicy2, authenticationPolicy3};
    }

    public static AuthenticationPolicy valueOf(String str) {
        return (AuthenticationPolicy) Enum.valueOf(AuthenticationPolicy.class, str);
    }

    public static AuthenticationPolicy[] values() {
        return (AuthenticationPolicy[]) $VALUES.clone();
    }
}
