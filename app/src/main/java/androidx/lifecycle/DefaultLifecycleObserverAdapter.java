package androidx.lifecycle;

import androidx.activity.OnBackPressedCallback$OnBackPressedEventHandler;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcher$addCallback$observer$1$WhenMappings;
import androidx.savedstate.SavedStateRegistry;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.HashMap;
import java.util.List;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements LifecycleEventObserver {
    public final /* synthetic */ byte $r8$classId;
    public final Object defaultLifecycleObserver;
    public final Object lifecycleEventObserver;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DefaultLifecycleObserverAdapter(LifecycleObserver lifecycleObserver) {
        this.$r8$classId = (byte) 3;
        this.defaultLifecycleObserver = lifecycleObserver;
        ClassesInfoCache classesInfoCache = ClassesInfoCache.sInstance;
        Class<?> cls = lifecycleObserver.getClass();
        ClassesInfoCache.CallbackInfo callbackInfo = (ClassesInfoCache.CallbackInfo) classesInfoCache.mCallbackMap.get(cls);
        this.lifecycleEventObserver = callbackInfo == null ? classesInfoCache.createInfo(cls, null) : callbackInfo;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        byte b = this.$r8$classId;
        Object obj = this.defaultLifecycleObserver;
        Object obj2 = this.lifecycleEventObserver;
        switch (b) {
            case 0:
                DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) obj;
                switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
                    case 1:
                        defaultLifecycleObserver.onCreate(lifecycleOwner);
                        break;
                    case 2:
                        defaultLifecycleObserver.onStart(lifecycleOwner);
                        break;
                    case 3:
                        defaultLifecycleObserver.onResume(lifecycleOwner);
                        break;
                    case 4:
                        defaultLifecycleObserver.onPause(lifecycleOwner);
                        break;
                    case 5:
                        defaultLifecycleObserver.onStop(lifecycleOwner);
                        break;
                    case 6:
                        defaultLifecycleObserver.onDestroy(lifecycleOwner);
                        break;
                    case 7:
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("ON_ANY must not been send by anybody");
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        break;
                }
                LifecycleEventObserver lifecycleEventObserver = (LifecycleEventObserver) obj2;
                if (lifecycleEventObserver != null) {
                    lifecycleEventObserver.onStateChanged(lifecycleOwner, event);
                }
                break;
            case 1:
                OnBackPressedCallback$OnBackPressedEventHandler onBackPressedCallback$OnBackPressedEventHandler = (OnBackPressedCallback$OnBackPressedEventHandler) obj;
                int i = OnBackPressedDispatcher$addCallback$observer$1$WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                if (i == 1) {
                    onBackPressedCallback$OnBackPressedEventHandler.setLifecycleActive(true);
                    break;
                } else if (i == 2) {
                    onBackPressedCallback$OnBackPressedEventHandler.setLifecycleActive(false);
                    break;
                } else if (i == 3) {
                    onBackPressedCallback$OnBackPressedEventHandler.remove();
                    ((Lifecycle) obj2).removeObserver(this);
                    break;
                }
                break;
            case 2:
                if (event == Lifecycle.Event.ON_START) {
                    ((Lifecycle) obj).removeObserver(this);
                    ((SavedStateRegistry) obj2).runOnNextRecreation();
                }
                break;
            default:
                LifecycleObserver lifecycleObserver = (LifecycleObserver) obj;
                HashMap map = ((ClassesInfoCache.CallbackInfo) obj2).mEventToHandlers;
                ClassesInfoCache.CallbackInfo.invokeMethodsForEvent((List) map.get(event), lifecycleOwner, event, lifecycleObserver);
                ClassesInfoCache.CallbackInfo.invokeMethodsForEvent((List) map.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, lifecycleObserver);
                break;
        }
    }

    public /* synthetic */ DefaultLifecycleObserverAdapter(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.defaultLifecycleObserver = obj;
        this.lifecycleEventObserver = obj2;
    }

    public DefaultLifecycleObserverAdapter(OnBackPressedCallback$OnBackPressedEventHandler onBackPressedCallback$OnBackPressedEventHandler, OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle) {
        this.$r8$classId = (byte) 1;
        this.defaultLifecycleObserver = onBackPressedCallback$OnBackPressedEventHandler;
        this.lifecycleEventObserver = lifecycle;
    }
}
