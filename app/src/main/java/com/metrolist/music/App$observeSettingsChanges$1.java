package com.metrolist.music;

import com.metrolist.innertube.YouTube;
import com.metrolist.music.db.DatabaseDao$songs$$inlined$map$1;
import com.metrolist.music.utils.UtilsKt;
import java.io.IOException;
import java.io.Serializable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class App$observeSettingsChanges$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ App this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ App$observeSettingsChanges$1(App app, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = app;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        App app = this.this$0;
        switch (b) {
            case 0:
                return new App$observeSettingsChanges$1(app, continuation, (byte) 0);
            case 1:
                return new App$observeSettingsChanges$1(app, continuation, (byte) 1);
            case 2:
                return new App$observeSettingsChanges$1(app, continuation, (byte) 2);
            case 3:
                return new App$observeSettingsChanges$1(app, continuation, (byte) 3);
            case 4:
                return new App$observeSettingsChanges$1(app, continuation, (byte) 4);
            case 5:
                return new App$observeSettingsChanges$1(app, continuation, (byte) 5);
            default:
                return new App$observeSettingsChanges$1(app, continuation, (byte) 6);
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
        }
        return ((App$observeSettingsChanges$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        App app = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        byte b2 = 1;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowDistinctUntilChanged = StateFlowKt.distinctUntilChanged(new DatabaseDao$songs$$inlined$map$1(UtilsKt.getDataStore(app).getData(), (byte) 2));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(app, (byte) 0);
                this.label = true;
                return flowDistinctUntilChanged.collect(anonymousClass2, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                DatabaseDao$songs$$inlined$map$1 databaseDao$songs$$inlined$map$1 = new DatabaseDao$songs$$inlined$map$1(UtilsKt.getDataStore(app).getData(), (byte) 1);
                this.label = true;
                Object objFirst = StateFlowKt.first(databaseDao$songs$$inlined$map$1, this);
                return objFirst == coroutineSingletons ? coroutineSingletons : objFirst;
            case 2:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowDistinctUntilChanged2 = StateFlowKt.distinctUntilChanged(new DatabaseDao$songs$$inlined$map$1(UtilsKt.getDataStore(app).getData(), (byte) 3));
                App$observeSettingsChanges$2$2 app$observeSettingsChanges$2$2 = App$observeSettingsChanges$2$2.INSTANCE;
                this.label = true;
                return flowDistinctUntilChanged2.collect(app$observeSettingsChanges$2$2, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 3:
                boolean z4 = this.label;
                if (z4) {
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowDistinctUntilChanged3 = StateFlowKt.distinctUntilChanged(new DatabaseDao$songs$$inlined$map$1(UtilsKt.getDataStore(app).getData(), (byte) 4));
                App$observeSettingsChanges$2$2 app$observeSettingsChanges$2$3 = App$observeSettingsChanges$2$2.INSTANCE$1;
                this.label = true;
                return flowDistinctUntilChanged3.collect(app$observeSettingsChanges$2$3, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 4:
                boolean z5 = this.label;
                if (z5) {
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowDistinctUntilChanged4 = StateFlowKt.distinctUntilChanged(new DatabaseDao$songs$$inlined$map$1(UtilsKt.getDataStore(app).getData(), (byte) 5));
                AnonymousClass2 anonymousClass3 = new AnonymousClass2(app, b2);
                this.label = true;
                return flowDistinctUntilChanged4.collect(anonymousClass3, this) == coroutineSingletons ? coroutineSingletons : unit;
            case 5:
                boolean z6 = this.label;
                if (z6) {
                    if (z6) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowDistinctUntilChanged5 = StateFlowKt.distinctUntilChanged(new DatabaseDao$songs$$inlined$map$1(UtilsKt.getDataStore(app).getData(), (byte) 6));
                App$observeSettingsChanges$2$2 app$observeSettingsChanges$2$4 = App$observeSettingsChanges$2$2.INSTANCE$2;
                this.label = true;
                return flowDistinctUntilChanged5.collect(app$observeSettingsChanges$2$4, this) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z7 = this.label;
                if (z7) {
                    if (z7) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowDistinctUntilChanged6 = StateFlowKt.distinctUntilChanged(new DatabaseDao$songs$$inlined$map$1(UtilsKt.getDataStore(app).getData(), (byte) 7));
                App$observeSettingsChanges$2$2 app$observeSettingsChanges$2$5 = App$observeSettingsChanges$2$2.INSTANCE$3;
                this.label = true;
                return flowDistinctUntilChanged6.collect(app$observeSettingsChanges$2$5, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.App$observeSettingsChanges$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements FlowCollector {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ App this$0;

        public /* synthetic */ AnonymousClass2(App app, byte b) {
            this.$r8$classId = b;
            this.this$0 = app;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public Object emit(String str, Continuation continuation) throws IOException {
            App$observeSettingsChanges$1$2$emit$1 app$observeSettingsChanges$1$2$emit$1;
            YouTube youTube;
            Object obj;
            YouTube youTube2;
            IOException e;
            YouTube youTube3;
            if (continuation instanceof App$observeSettingsChanges$1$2$emit$1) {
                app$observeSettingsChanges$1$2$emit$1 = (App$observeSettingsChanges$1$2$emit$1) continuation;
                int i = app$observeSettingsChanges$1$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    app$observeSettingsChanges$1$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    app$observeSettingsChanges$1$2$emit$1 = new App$observeSettingsChanges$1$2$emit$1(this, continuation);
                }
            } else {
                app$observeSettingsChanges$1$2$emit$1 = new App$observeSettingsChanges$1$2$emit$1(this, continuation);
            }
            Object obj2 = app$observeSettingsChanges$1$2$emit$1.result;
            int i2 = app$observeSettingsChanges$1$2$emit$1.label;
            String str2 = null;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                youTube = YouTube.INSTANCE;
                if (str != null) {
                    if (str.equals("null")) {
                        str = null;
                    }
                    if (str != null) {
                        str2 = str;
                    }
                    youTube.getClass();
                    YouTube.setVisitorData(str2);
                    return Unit.INSTANCE;
                }
                app$observeSettingsChanges$1$2$emit$1.L$1 = youTube;
                app$observeSettingsChanges$1$2$emit$1.label = 1;
                Serializable serializableM1048visitorDataIoAF18A = youTube.m1048visitorDataIoAF18A(app$observeSettingsChanges$1$2$emit$1);
                if (serializableM1048visitorDataIoAF18A != coroutineSingletons) {
                    obj = serializableM1048visitorDataIoAF18A;
                    youTube2 = youTube;
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                youTube2 = (YouTube) app$observeSettingsChanges$1$2$emit$1.L$1;
                ResultKt.throwOnFailure(obj2);
                obj = ((Result) obj2).value;
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                youTube3 = app$observeSettingsChanges$1$2$emit$1.L$3;
                str = (String) app$observeSettingsChanges$1$2$emit$1.L$1;
                try {
                    ResultKt.throwOnFailure(obj2);
                } catch (IOException e2) {
                    e = e2;
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                    e.printStackTrace();
                }
            }
            youTube = youTube3;
            str2 = str;
            youTube.getClass();
            YouTube.setVisitorData(str2);
            return Unit.INSTANCE;
            if (obj instanceof Result.Failure) {
                obj = null;
            }
            String str3 = (String) obj;
            if (str3 != null) {
                App app = this.this$0;
                try {
                    App$observeSettingsChanges$1$2$2$1 app$observeSettingsChanges$1$2$2$1 = new App$observeSettingsChanges$1$2$2$1(str3, null, (byte) 0);
                    app$observeSettingsChanges$1$2$emit$1.L$1 = str3;
                    app$observeSettingsChanges$1$2$emit$1.L$3 = youTube2;
                    app$observeSettingsChanges$1$2$emit$1.label = 2;
                    if (UtilsKt.safeDataStoreEdit(app, app$observeSettingsChanges$1$2$2$1, app$observeSettingsChanges$1$2$emit$1) != coroutineSingletons) {
                        youTube3 = youTube2;
                        str = str3;
                        youTube = youTube3;
                        str2 = str;
                    }
                    return coroutineSingletons;
                } catch (IOException e3) {
                    e = e3;
                    youTube3 = youTube2;
                    str = str3;
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                    e.printStackTrace();
                }
            } else {
                youTube = youTube2;
            }
            youTube.getClass();
            YouTube.setVisitorData(str2);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation continuation) throws IOException {
            switch (this.$r8$classId) {
                case 0:
                    return emit((String) obj, continuation);
                default:
                    String str = (String) obj;
                    try {
                        YouTube youTube = YouTube.INSTANCE;
                        YouTube.setCookie(str);
                        break;
                    } catch (Exception unused) {
                        Timber.Forest.getClass();
                        ConnectionPool.e$1(new Object[0]);
                        Object objForgetAccount = App.Companion.forgetAccount(this.this$0, continuation);
                        if (objForgetAccount == CoroutineSingletons.COROUTINE_SUSPENDED) {
                            return objForgetAccount;
                        }
                    }
                    return Unit.INSTANCE;
            }
        }
    }
}
