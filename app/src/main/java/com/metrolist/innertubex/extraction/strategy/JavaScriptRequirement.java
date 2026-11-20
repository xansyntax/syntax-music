package com.metrolist.innertubex.extraction.strategy;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class JavaScriptRequirement {
    public static final /* synthetic */ JavaScriptRequirement[] $VALUES;
    public static final JavaScriptRequirement NEVER;
    public static final JavaScriptRequirement REQUIRED;
    public static final JavaScriptRequirement RESPONSE_DEPENDENT;

    static {
        JavaScriptRequirement javaScriptRequirement = new JavaScriptRequirement("NEVER", 0);
        NEVER = javaScriptRequirement;
        JavaScriptRequirement javaScriptRequirement2 = new JavaScriptRequirement("RESPONSE_DEPENDENT", 1);
        RESPONSE_DEPENDENT = javaScriptRequirement2;
        JavaScriptRequirement javaScriptRequirement3 = new JavaScriptRequirement("REQUIRED", 2);
        REQUIRED = javaScriptRequirement3;
        $VALUES = new JavaScriptRequirement[]{javaScriptRequirement, javaScriptRequirement2, javaScriptRequirement3};
    }

    public static JavaScriptRequirement valueOf(String str) {
        return (JavaScriptRequirement) Enum.valueOf(JavaScriptRequirement.class, str);
    }

    public static JavaScriptRequirement[] values() {
        return (JavaScriptRequirement[]) $VALUES.clone();
    }
}
