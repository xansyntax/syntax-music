package com.metrolist.innertubex.extraction.strategy;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WebViewRequirement {
    public static final /* synthetic */ WebViewRequirement[] $VALUES;
    public static final WebViewRequirement FULL_PLAYER;
    public static final WebViewRequirement NONE;
    public static final WebViewRequirement OPTIONAL_TOKEN_MINTING;
    public static final WebViewRequirement REQUIRED_TOKEN_MINTING;

    static {
        WebViewRequirement webViewRequirement = new WebViewRequirement("NONE", 0);
        NONE = webViewRequirement;
        WebViewRequirement webViewRequirement2 = new WebViewRequirement("OPTIONAL_TOKEN_MINTING", 1);
        OPTIONAL_TOKEN_MINTING = webViewRequirement2;
        WebViewRequirement webViewRequirement3 = new WebViewRequirement("REQUIRED_TOKEN_MINTING", 2);
        REQUIRED_TOKEN_MINTING = webViewRequirement3;
        WebViewRequirement webViewRequirement4 = new WebViewRequirement("FULL_PLAYER", 3);
        FULL_PLAYER = webViewRequirement4;
        $VALUES = new WebViewRequirement[]{webViewRequirement, webViewRequirement2, webViewRequirement3, webViewRequirement4};
    }

    public static WebViewRequirement valueOf(String str) {
        return (WebViewRequirement) Enum.valueOf(WebViewRequirement.class, str);
    }

    public static WebViewRequirement[] values() {
        return (WebViewRequirement[]) $VALUES.clone();
    }
}
