package com.metrolist.music.ui.screens.settings;

import com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1.AnonymousClass2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppearanceSettingsKt$AppearanceSettings$$inlined$rememberEnumPreference$1$2$1(SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$1.AnonymousClass2 anonymousClass2, Continuation continuation) {
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
