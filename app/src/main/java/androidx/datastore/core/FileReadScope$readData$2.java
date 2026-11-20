package androidx.datastore.core;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.PreferencesFileSerializer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.text.CharsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FileReadScope$readData$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public Object L$0;
    public byte label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileReadScope$readData$2(Object obj, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.this$0 = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj = this.this$0;
        switch (b) {
            case 0:
                return new FileReadScope$readData$2((FileReadScope) obj, continuation, (byte) 0);
            default:
                return new FileReadScope$readData$2((DataStoreImpl) obj, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
        }
        return ((FileReadScope$readData$2) create(continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [byte] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        Throwable th;
        FileInputStream fileInputStream;
        Throwable th2;
        State readException;
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj2 = this.this$0;
        switch (b) {
            case 0:
                FileReadScope fileReadScope = (FileReadScope) obj2;
                ?? r0 = this.label;
                try {
                    try {
                        try {
                            if (r0 == 0) {
                                ResultKt.throwOnFailure(obj);
                                FileInputStream fileInputStream2 = new FileInputStream(fileReadScope.file);
                                this.L$0 = fileInputStream2;
                                this.label = (byte) 1;
                                obj = PreferencesFileSerializer.readFrom(fileInputStream2);
                                r0 = fileInputStream2;
                                if (obj == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            } else {
                                if (r0 != 1) {
                                    if (r0 != 2) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                        return null;
                                    }
                                    fileInputStream = (FileInputStream) this.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        CharsKt.closeFinally(fileInputStream, null);
                                        return obj;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        try {
                                            throw th;
                                        } catch (Throwable th4) {
                                            CharsKt.closeFinally(fileInputStream, th);
                                            throw th4;
                                        }
                                    }
                                }
                                FileInputStream fileInputStream3 = (FileInputStream) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                r0 = fileInputStream3;
                            }
                            CharsKt.closeFinally(r0, null);
                            break;
                        } catch (Throwable th5) {
                            try {
                                throw th5;
                            } catch (Throwable th6) {
                                CharsKt.closeFinally(r0, th5);
                                throw th6;
                            }
                        }
                    } catch (FileNotFoundException unused) {
                        if (!fileReadScope.file.exists()) {
                            return new MutablePreferences(true);
                        }
                        FileInputStream fileInputStream4 = new FileInputStream(fileReadScope.file);
                        try {
                            this.L$0 = fileInputStream4;
                            this.label = (byte) 2;
                            MutablePreferences from = PreferencesFileSerializer.readFrom(fileInputStream4);
                            if (from == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            obj = from;
                            fileInputStream = fileInputStream4;
                        } catch (Throwable th7) {
                            th = th7;
                            fileInputStream = fileInputStream4;
                            throw th;
                        }
                    }
                    return obj;
                } catch (Exception e) {
                    if (e instanceof FileNotFoundException) {
                        throw FileStorageKt.wrapExceptionIfDueToDirectBoot(fileReadScope.file.getParent(), (FileNotFoundException) e);
                    }
                    throw e;
                }
            default:
                DataStoreImpl dataStoreImpl = (DataStoreImpl) obj2;
                byte b2 = this.label;
                try {
                    if (b2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = (byte) 1;
                        obj = dataStoreImpl.readDataOrHandleCorruption(true, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (b2 != 1) {
                            if (b2 != 2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            th2 = (Throwable) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            readException = new ReadException(th2, ((Number) obj).intValue());
                            return new Pair(readException, Boolean.TRUE);
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    readException = (State) obj;
                    break;
                } catch (Throwable th8) {
                    SingleProcessCoordinator coordinator = dataStoreImpl.getCoordinator();
                    this.L$0 = th8;
                    this.label = (byte) 2;
                    Integer version = coordinator.getVersion();
                    if (version == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj = version;
                    th2 = th8;
                }
                return new Pair(readException, Boolean.TRUE);
        }
    }
}
