package androidx.datastore.core;

import androidx.datastore.preferences.core.PreferencesFileSerializer;
import com.metrolist.innertubex.InnerTube;
import com.metrolist.innertubex.InnerTube$executeMutation$2$1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.CharsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FileWriteScope$writeData$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object $value;
    public Object L$0;
    public Object L$1;
    public boolean label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriteScope$writeData$2(InnerTube innerTube, String str, Function2 function2, InnerTube.SessionSnapshot sessionSnapshot, Continuation continuation) {
        super(1, continuation);
        this.L$0 = innerTube;
        this.L$1 = str;
        this.this$0 = function2;
        this.$value = sessionSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj = this.$value;
        Object obj2 = this.this$0;
        switch (b) {
            case 0:
                return new FileWriteScope$writeData$2((FileWriteScope) obj2, obj, continuation);
            default:
                return new FileWriteScope$writeData$2((InnerTube) this.L$0, (String) this.L$1, (Function2) obj2, (InnerTube.SessionSnapshot) obj, continuation);
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
        return ((FileWriteScope$writeData$2) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        byte b = this.$r8$classId;
        Object obj2 = this.$value;
        Object obj3 = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Continuation continuation = null;
        switch (b) {
            case 0:
                File file = ((FileWriteScope) obj3).file;
                boolean z = this.label;
                Unit unit = Unit.INSTANCE;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            Buffer.C03821 c03821 = new Buffer.C03821(fileOutputStream3);
                            this.L$0 = fileOutputStream3;
                            this.L$1 = fileOutputStream3;
                            this.label = true;
                            PreferencesFileSerializer.writeTo(obj2, c03821);
                            if (unit == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            fileOutputStream = fileOutputStream3;
                            fileOutputStream2 = fileOutputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream3;
                            throw th;
                        }
                    } catch (Exception e) {
                        if (e instanceof FileNotFoundException) {
                            throw FileStorageKt.wrapExceptionIfDueToDirectBoot(file.getParent(), (FileNotFoundException) e);
                        }
                        throw e;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    fileOutputStream2 = (FileOutputStream) this.L$1;
                    fileOutputStream = (FileOutputStream) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            CharsKt.closeFinally(fileOutputStream, th);
                            throw th4;
                        }
                    }
                }
                fileOutputStream2.getFD().sync();
                CharsKt.closeFinally(fileOutputStream, null);
                return unit;
            default:
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
                InnerTube innerTube = (InnerTube) this.L$0;
                String str = (String) this.L$1;
                InnerTube$executeMutation$2$1 innerTube$executeMutation$2$1 = new InnerTube$executeMutation$2$1((Function2) obj3, (InnerTube.SessionSnapshot) obj2, continuation, (byte) 0);
                this.label = true;
                Object objExecuteRequest$default = InnerTube.executeRequest$default(innerTube, str, innerTube$executeMutation$2$1, this, 56);
                return objExecuteRequest$default == coroutineSingletons ? coroutineSingletons : objExecuteRequest$default;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriteScope$writeData$2(FileWriteScope fileWriteScope, Object obj, Continuation continuation) {
        super(1, continuation);
        this.this$0 = fileWriteScope;
        this.$value = obj;
    }
}
