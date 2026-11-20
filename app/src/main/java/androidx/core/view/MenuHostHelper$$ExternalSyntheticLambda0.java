package androidx.core.view;

import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LifecycleEffectKt$WhenMappings;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;
import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuHostHelper$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Serializable f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ MenuHostHelper$$ExternalSyntheticLambda0(Object obj, Serializable serializable, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = serializable;
        this.f$2 = obj2;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        byte b = this.$r8$classId;
        Lifecycle.Event event2 = null;
        Object obj = this.f$2;
        Serializable serializable = this.f$1;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                MenuHostHelper menuHostHelper = (MenuHostHelper) obj2;
                Lifecycle.State state = (Lifecycle.State) serializable;
                MenuProvider menuProvider = (MenuProvider) obj;
                menuHostHelper.getClass();
                Runnable runnable = menuHostHelper.mOnInvalidateMenuCallback;
                CopyOnWriteArrayList copyOnWriteArrayList = menuHostHelper.mMenuProviders;
                Lifecycle.Event.Companion.getClass();
                int iOrdinal = state.ordinal();
                if (iOrdinal == 2) {
                    event2 = Lifecycle.Event.ON_CREATE;
                } else if (iOrdinal == 3) {
                    event2 = Lifecycle.Event.ON_START;
                } else if (iOrdinal == 4) {
                    event2 = Lifecycle.Event.ON_RESUME;
                }
                if (event == event2) {
                    copyOnWriteArrayList.add(menuProvider);
                    runnable.run();
                } else if (event == Lifecycle.Event.ON_DESTROY) {
                    menuHostHelper.removeMenuProvider(menuProvider);
                } else if (event == Lifecycle.Event.Companion.downFrom(state)) {
                    copyOnWriteArrayList.remove(menuProvider);
                    runnable.run();
                }
                break;
            default:
                LifecycleStartStopEffectScope lifecycleStartStopEffectScope = (LifecycleStartStopEffectScope) obj2;
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) serializable;
                Function1 function1 = (Function1) obj;
                int i = LifecycleEffectKt$WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                if (i == 1) {
                    ref$ObjectRef.element = function1.invoke(lifecycleStartStopEffectScope);
                    break;
                } else if (i == 2) {
                    BackHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1 backHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1 = (BackHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1) ref$ObjectRef.element;
                    if (backHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1 != null) {
                        backHandlerKt$BackHandler$lambda$3$0$$inlined$onStopOrDispose$1.runStopOrDisposeEffect();
                    }
                    ref$ObjectRef.element = null;
                    break;
                }
                break;
        }
    }
}
