package com.metrolist.music.ui.screens;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LoginStage {
    public static final /* synthetic */ LoginStage[] $VALUES;
    public static final LoginStage Authenticating;
    public static final LoginStage CheckingAccounts;
    public static final LoginStage Completing;
    public static final LoginStage SelectingAccount;
    public static final LoginStage SwitchingAccount;

    static {
        LoginStage loginStage = new LoginStage("Authenticating", 0);
        Authenticating = loginStage;
        LoginStage loginStage2 = new LoginStage("CheckingAccounts", 1);
        CheckingAccounts = loginStage2;
        LoginStage loginStage3 = new LoginStage("SelectingAccount", 2);
        SelectingAccount = loginStage3;
        LoginStage loginStage4 = new LoginStage("SwitchingAccount", 3);
        SwitchingAccount = loginStage4;
        LoginStage loginStage5 = new LoginStage("Completing", 4);
        Completing = loginStage5;
        $VALUES = new LoginStage[]{loginStage, loginStage2, loginStage3, loginStage4, loginStage5};
    }

    public static LoginStage valueOf(String str) {
        return (LoginStage) Enum.valueOf(LoginStage.class, str);
    }

    public static LoginStage[] values() {
        return (LoginStage[]) $VALUES.clone();
    }
}
