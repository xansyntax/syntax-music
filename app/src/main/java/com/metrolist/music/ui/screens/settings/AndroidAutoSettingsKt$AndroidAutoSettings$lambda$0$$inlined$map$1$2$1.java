package com.metrolist.music.ui.screens.settings;

import com.metrolist.music.utils.SyncUtils$special$$inlined$map$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SyncUtils$special$$inlined$map$1.AnonymousClass2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidAutoSettingsKt$AndroidAutoSettings$lambda$0$$inlined$map$1$2$1(SyncUtils$special$$inlined$map$1.AnonymousClass2 anonymousClass2, Continuation continuation) {
        super(continuation);
        this.this$0 = anonymousClass2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
