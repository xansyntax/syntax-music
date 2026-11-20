package com.metrolist.music.ui.screens;

import android.webkit.WebView;
import java.util.Map;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LoginScreenKt$LoginScreen$extractAuthData$1 extends ContinuationImpl {
    public int I$0;
    public int I$1;
    public int I$2;
    public LoginJsInterface L$0;
    public WebView L$2;
    public Ref$BooleanRef L$3;
    public Ref$BooleanRef L$4;
    public String L$5;
    public Map L$8;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AlbumScreenKt.LoginScreen$extractAuthData(null, null, this);
    }
}
