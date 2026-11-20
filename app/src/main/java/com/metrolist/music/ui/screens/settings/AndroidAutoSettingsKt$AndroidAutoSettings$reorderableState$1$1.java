package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidAutoSettingsKt$AndroidAutoSettings$reorderableState$1$1 extends SuspendLambda implements Function4 {
    public final /* synthetic */ HapticFeedback $haptic;
    public final /* synthetic */ MimesKt$$ExternalSyntheticLambda0 $onSectionsChange;
    public final /* synthetic */ MutableState $sections$delegate;
    public /* synthetic */ LazyListMeasuredItem L$0;
    public /* synthetic */ LazyListMeasuredItem L$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidAutoSettingsKt$AndroidAutoSettings$reorderableState$1$1(MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, HapticFeedback hapticFeedback, MutableState mutableState, Continuation continuation) {
        super(4, continuation);
        this.$onSectionsChange = mimesKt$$ExternalSyntheticLambda0;
        this.$haptic = hapticFeedback;
        this.$sections$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        HapticFeedback hapticFeedback = this.$haptic;
        MutableState mutableState = this.$sections$delegate;
        AndroidAutoSettingsKt$AndroidAutoSettings$reorderableState$1$1 androidAutoSettingsKt$AndroidAutoSettings$reorderableState$1$1 = new AndroidAutoSettingsKt$AndroidAutoSettings$reorderableState$1$1(this.$onSectionsChange, hapticFeedback, mutableState, (Continuation) obj4);
        androidAutoSettingsKt$AndroidAutoSettings$reorderableState$1$1.L$0 = (LazyListMeasuredItem) obj2;
        androidAutoSettingsKt$AndroidAutoSettings$reorderableState$1$1.L$1 = (LazyListMeasuredItem) obj3;
        Unit unit = Unit.INSTANCE;
        androidAutoSettingsKt$AndroidAutoSettings$reorderableState$1$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LazyListMeasuredItem lazyListMeasuredItem = this.L$0;
        LazyListMeasuredItem lazyListMeasuredItem2 = this.L$1;
        ResultKt.throwOnFailure(obj);
        int i = lazyListMeasuredItem.index;
        int i2 = lazyListMeasuredItem2.index;
        if (i >= 0 && i2 >= 0) {
            MutableState mutableState = this.$sections$delegate;
            if (i < ((List) mutableState.getValue()).size() && i2 < ((List) mutableState.getValue()).size()) {
                ArrayList mutableList = CollectionsKt.toMutableList((Collection) mutableState.getValue());
                mutableList.add(i2, mutableList.remove(i));
                mutableState.setValue(mutableList);
                this.$onSectionsChange.invoke(AiSettingsKt.serializeSections((List) mutableState.getValue()));
                ((PlatformHapticFeedback) this.$haptic).m578performHapticFeedbackCdsT49E(0);
            }
        }
        return Unit.INSTANCE;
    }
}
