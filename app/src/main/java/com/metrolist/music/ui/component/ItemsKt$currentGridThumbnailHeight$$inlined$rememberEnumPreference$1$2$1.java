package com.metrolist.music.ui.component;

import com.metrolist.music.MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1.AnonymousClass2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemsKt$currentGridThumbnailHeight$$inlined$rememberEnumPreference$1$2$1(MainActivity$MetrolistApp$$inlined$rememberEnumPreference$1.AnonymousClass2 anonymousClass2, Continuation continuation) {
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
