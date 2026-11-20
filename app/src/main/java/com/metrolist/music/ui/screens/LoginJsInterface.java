package com.metrolist.music.ui.screens;

import android.webkit.JavascriptInterface;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LoginJsInterface {
    public LoginScreenKt$$ExternalSyntheticLambda13 onAuthUserReceived;
    public LoginScreenKt$$ExternalSyntheticLambda13 onDataSyncIdReceived;
    public LoginScreenKt$$ExternalSyntheticLambda13 onVisitorDataReceived;

    @JavascriptInterface
    public final void onRetrieveAuthUser(String str) {
        LoginScreenKt$$ExternalSyntheticLambda13 loginScreenKt$$ExternalSyntheticLambda13 = this.onAuthUserReceived;
        if (loginScreenKt$$ExternalSyntheticLambda13 != null) {
            loginScreenKt$$ExternalSyntheticLambda13.invoke(str);
        }
    }

    @JavascriptInterface
    public final void onRetrieveDataSyncId(String str) {
        LoginScreenKt$$ExternalSyntheticLambda13 loginScreenKt$$ExternalSyntheticLambda13 = this.onDataSyncIdReceived;
        if (loginScreenKt$$ExternalSyntheticLambda13 != null) {
            loginScreenKt$$ExternalSyntheticLambda13.invoke(str);
        }
    }

    @JavascriptInterface
    public final void onRetrieveVisitorData(String str) {
        LoginScreenKt$$ExternalSyntheticLambda13 loginScreenKt$$ExternalSyntheticLambda13 = this.onVisitorDataReceived;
        if (loginScreenKt$$ExternalSyntheticLambda13 != null) {
            loginScreenKt$$ExternalSyntheticLambda13.invoke(str);
        }
    }
}
