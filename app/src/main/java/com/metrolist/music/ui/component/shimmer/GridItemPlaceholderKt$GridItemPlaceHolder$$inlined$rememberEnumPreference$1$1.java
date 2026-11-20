package com.metrolist.music.ui.component.shimmer;

import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridItemPlaceholderKt$GridItemPlaceHolder$$inlined$rememberEnumPreference$1$1(MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1 mainActivity$MetrolistApp$$inlined$rememberEnumPreference$1, Continuation continuation) {
        super(continuation);
        this.this$0 = mainActivity$MetrolistApp$$inlined$rememberEnumPreference$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
