package com.metrolist.innertube.utils;

import com.metrolist.innertube.pages.LibraryPage;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class UtilsKt$completed$3 extends ContinuationImpl {
    public int I$0;
    public List L$2;
    public LibraryPage L$3;
    public Set L$5;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objCompletedPlaylist = StringsKt__IndentKt.completedPlaylist(null, this);
        return objCompletedPlaylist == CoroutineSingletons.COROUTINE_SUSPENDED ? objCompletedPlaylist : new Result(objCompletedPlaylist);
    }
}
