package com.metrolist.music.ui.screens;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LoginScreenKt$LoginScreen$finalizeLogin$1 extends ContinuationImpl {
    public Context L$0;
    public MutableState L$1;
    public MutableState L$2;
    public MutableState L$3;
    public AuthData L$4;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AlbumScreenKt.LoginScreen$finalizeLogin(null, null, null, null, null, this);
    }
}
