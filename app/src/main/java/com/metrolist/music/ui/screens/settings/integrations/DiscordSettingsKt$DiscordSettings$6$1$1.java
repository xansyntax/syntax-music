package com.metrolist.music.ui.screens.settings.integrations;

import android.content.Context;
import com.metrolist.music.App$Companion$forgetAccount$2;
import com.metrolist.music.App$observeSettingsChanges$1$2$2$1;
import com.metrolist.music.utils.UtilsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordSettingsKt$DiscordSettings$6$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String $value;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DiscordSettingsKt$DiscordSettings$6$1$1(Context context, String str, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$context = context;
        this.$value = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        String str = this.$value;
        Context context = this.$context;
        switch (b) {
            case 0:
                return new DiscordSettingsKt$DiscordSettings$6$1$1(context, str, continuation, (byte) 0);
            case 1:
                return new DiscordSettingsKt$DiscordSettings$6$1$1(context, str, continuation, (byte) 1);
            case 2:
                return new DiscordSettingsKt$DiscordSettings$6$1$1(context, str, continuation, (byte) 2);
            case 3:
                return new DiscordSettingsKt$DiscordSettings$6$1$1(context, str, continuation, (byte) 3);
            case 4:
                return new DiscordSettingsKt$DiscordSettings$6$1$1(context, str, continuation, (byte) 4);
            case 5:
                return new DiscordSettingsKt$DiscordSettings$6$1$1(context, str, continuation, (byte) 5);
            case 6:
                return new DiscordSettingsKt$DiscordSettings$6$1$1(context, str, continuation, (byte) 6);
            case 7:
                return new DiscordSettingsKt$DiscordSettings$6$1$1(context, str, continuation, (byte) 7);
            default:
                return new DiscordSettingsKt$DiscordSettings$6$1$1(context, str, continuation, (byte) 8);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
        }
        return ((DiscordSettingsKt$DiscordSettings$6$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str = this.$value;
        Context context = this.$context;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                byte b2 = this.label;
                if (b2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$1 = new App$observeSettingsChanges$1$2$2$1(str, null, (byte) 10);
                    this.label = (byte) 1;
                    if (UtilsKt.safeDataStoreEdit(context, app$observeSettingsChanges$1$2$2$1, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b2 != 1) {
                    if (b2 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                HandlerContext handlerContext = MainDispatcherLoader.dispatcher;
                App$Companion$forgetAccount$2 app$Companion$forgetAccount$2 = new App$Companion$forgetAccount$2(2, null, (byte) 19);
                this.label = (byte) 2;
                if (AwaitKt.withContext(handlerContext, app$Companion$forgetAccount$2, this) != coroutineSingletons) {
                    return unit;
                }
                return coroutineSingletons;
            case 1:
                byte b3 = this.label;
                if (b3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$2 = new App$observeSettingsChanges$1$2$2$1(str, null, (byte) 3);
                    this.label = (byte) 1;
                    if (UtilsKt.safeDataStoreEdit(context, app$observeSettingsChanges$1$2$2$2, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b3 != 1) {
                    if (b3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                HandlerContext handlerContext2 = MainDispatcherLoader.dispatcher;
                App$Companion$forgetAccount$2 app$Companion$forgetAccount$3 = new App$Companion$forgetAccount$2(2, null, (byte) 11);
                this.label = (byte) 2;
                if (AwaitKt.withContext(handlerContext2, app$Companion$forgetAccount$3, this) != coroutineSingletons) {
                    return unit;
                }
                return coroutineSingletons;
            case 2:
                byte b4 = this.label;
                if (b4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$3 = new App$observeSettingsChanges$1$2$2$1(str, null, (byte) 4);
                    this.label = (byte) 1;
                    if (UtilsKt.safeDataStoreEdit(context, app$observeSettingsChanges$1$2$2$3, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b4 != 1) {
                    if (b4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler3 = Dispatchers.Default;
                HandlerContext handlerContext3 = MainDispatcherLoader.dispatcher;
                App$Companion$forgetAccount$2 app$Companion$forgetAccount$4 = new App$Companion$forgetAccount$2(2, null, (byte) 12);
                this.label = (byte) 2;
                if (AwaitKt.withContext(handlerContext3, app$Companion$forgetAccount$4, this) != coroutineSingletons) {
                    return unit;
                }
                return coroutineSingletons;
            case 3:
                byte b5 = this.label;
                if (b5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$4 = new App$observeSettingsChanges$1$2$2$1(str, null, (byte) 5);
                    this.label = (byte) 1;
                    if (UtilsKt.safeDataStoreEdit(context, app$observeSettingsChanges$1$2$2$4, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b5 != 1) {
                    if (b5 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler4 = Dispatchers.Default;
                HandlerContext handlerContext4 = MainDispatcherLoader.dispatcher;
                App$Companion$forgetAccount$2 app$Companion$forgetAccount$5 = new App$Companion$forgetAccount$2(2, null, (byte) 13);
                this.label = (byte) 2;
                if (AwaitKt.withContext(handlerContext4, app$Companion$forgetAccount$5, this) != coroutineSingletons) {
                    return unit;
                }
                return coroutineSingletons;
            case 4:
                byte b6 = this.label;
                if (b6 == 0) {
                    ResultKt.throwOnFailure(obj);
                    App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$5 = new App$observeSettingsChanges$1$2$2$1(str, null, (byte) 6);
                    this.label = (byte) 1;
                    if (UtilsKt.safeDataStoreEdit(context, app$observeSettingsChanges$1$2$2$5, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b6 != 1) {
                    if (b6 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler5 = Dispatchers.Default;
                HandlerContext handlerContext5 = MainDispatcherLoader.dispatcher;
                App$Companion$forgetAccount$2 app$Companion$forgetAccount$6 = new App$Companion$forgetAccount$2(2, null, (byte) 14);
                this.label = (byte) 2;
                if (AwaitKt.withContext(handlerContext5, app$Companion$forgetAccount$6, this) != coroutineSingletons) {
                    return unit;
                }
                return coroutineSingletons;
            case 5:
                byte b7 = this.label;
                if (b7 == 0) {
                    ResultKt.throwOnFailure(obj);
                    App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$6 = new App$observeSettingsChanges$1$2$2$1(str, null, (byte) 7);
                    this.label = (byte) 1;
                    if (UtilsKt.safeDataStoreEdit(context, app$observeSettingsChanges$1$2$2$6, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b7 != 1) {
                    if (b7 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler6 = Dispatchers.Default;
                HandlerContext handlerContext6 = MainDispatcherLoader.dispatcher;
                App$Companion$forgetAccount$2 app$Companion$forgetAccount$7 = new App$Companion$forgetAccount$2(2, null, (byte) 15);
                this.label = (byte) 2;
                if (AwaitKt.withContext(handlerContext6, app$Companion$forgetAccount$7, this) != coroutineSingletons) {
                    return unit;
                }
                return coroutineSingletons;
            case 6:
                byte b8 = this.label;
                if (b8 == 0) {
                    ResultKt.throwOnFailure(obj);
                    App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$7 = new App$observeSettingsChanges$1$2$2$1(str, null, (byte) 8);
                    this.label = (byte) 1;
                    if (UtilsKt.safeDataStoreEdit(context, app$observeSettingsChanges$1$2$2$7, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b8 != 1) {
                    if (b8 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler7 = Dispatchers.Default;
                HandlerContext handlerContext7 = MainDispatcherLoader.dispatcher;
                App$Companion$forgetAccount$2 app$Companion$forgetAccount$8 = new App$Companion$forgetAccount$2(2, null, (byte) 16);
                this.label = (byte) 2;
                if (AwaitKt.withContext(handlerContext7, app$Companion$forgetAccount$8, this) != coroutineSingletons) {
                    return unit;
                }
                return coroutineSingletons;
            case 7:
                byte b9 = this.label;
                if (b9 == 0) {
                    ResultKt.throwOnFailure(obj);
                    App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$8 = new App$observeSettingsChanges$1$2$2$1(str, null, (byte) 9);
                    this.label = (byte) 1;
                    if (UtilsKt.safeDataStoreEdit(context, app$observeSettingsChanges$1$2$2$8, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b9 != 1) {
                    if (b9 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler8 = Dispatchers.Default;
                HandlerContext handlerContext8 = MainDispatcherLoader.dispatcher;
                App$Companion$forgetAccount$2 app$Companion$forgetAccount$9 = new App$Companion$forgetAccount$2(2, null, (byte) 17);
                this.label = (byte) 2;
                if (AwaitKt.withContext(handlerContext8, app$Companion$forgetAccount$9, this) != coroutineSingletons) {
                    return unit;
                }
                return coroutineSingletons;
            default:
                byte b10 = this.label;
                if (b10 == 0) {
                    ResultKt.throwOnFailure(obj);
                    App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$9 = new App$observeSettingsChanges$1$2$2$1(str, null, (byte) 11);
                    this.label = (byte) 1;
                    if (UtilsKt.safeDataStoreEdit(context, app$observeSettingsChanges$1$2$2$9, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b10 != 1) {
                    if (b10 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                DefaultScheduler defaultScheduler9 = Dispatchers.Default;
                HandlerContext handlerContext9 = MainDispatcherLoader.dispatcher;
                App$Companion$forgetAccount$2 app$Companion$forgetAccount$10 = new App$Companion$forgetAccount$2(2, null, (byte) 20);
                this.label = (byte) 2;
                if (AwaitKt.withContext(handlerContext9, app$Companion$forgetAccount$10, this) != coroutineSingletons) {
                    return unit;
                }
                return coroutineSingletons;
        }
    }
}
