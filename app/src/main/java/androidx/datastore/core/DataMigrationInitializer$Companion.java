package androidx.datastore.core;

import com.metrolist.music.discord.DiscordRpcManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataMigrationInitializer$Companion implements CoroutineContext.Key {
    public static final DataMigrationInitializer$Companion INSTANCE = new DataMigrationInitializer$Companion();

    /* JADX WARN: Code duplicated, block: B:27:0x006b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0091  */
    /* JADX WARN: Code duplicated, block: B:39:0x0094  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[LOOP:0: B:25:0x0065->B:45:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0082 -> B:25:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0085 -> B:25:0x0065). Please report as a decompilation issue!!! */
    public Object runMigrations(List list, DataStoreImpl$InitDataStore$doRun$initData$1$api$1 dataStoreImpl$InitDataStore$doRun$initData$1$api$1, ContinuationImpl continuationImpl) throws Throwable {
        DataMigrationInitializer$Companion$runMigrations$1 dataMigrationInitializer$Companion$runMigrations$1;
        List list2;
        Iterator it;
        Ref$ObjectRef ref$ObjectRef;
        Throwable th;
        Function1 function1;
        if (continuationImpl instanceof DataMigrationInitializer$Companion$runMigrations$1) {
            dataMigrationInitializer$Companion$runMigrations$1 = (DataMigrationInitializer$Companion$runMigrations$1) continuationImpl;
            int i = dataMigrationInitializer$Companion$runMigrations$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dataMigrationInitializer$Companion$runMigrations$1.label = i - Integer.MIN_VALUE;
            } else {
                dataMigrationInitializer$Companion$runMigrations$1 = new DataMigrationInitializer$Companion$runMigrations$1(this, continuationImpl);
            }
        } else {
            dataMigrationInitializer$Companion$runMigrations$1 = new DataMigrationInitializer$Companion$runMigrations$1(this, continuationImpl);
        }
        Object obj = dataMigrationInitializer$Companion$runMigrations$1.result;
        int i2 = dataMigrationInitializer$Companion$runMigrations$1.label;
        Continuation continuation = null;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            DiscordRpcManager.AnonymousClass4 anonymousClass4 = new DiscordRpcManager.AnonymousClass4((Object) list, (Object) arrayList, continuation, (byte) 3);
            dataMigrationInitializer$Companion$runMigrations$1.L$0 = arrayList;
            dataMigrationInitializer$Companion$runMigrations$1.label = 1;
            if (dataStoreImpl$InitDataStore$doRun$initData$1$api$1.updateData(anonymousClass4, dataMigrationInitializer$Companion$runMigrations$1) != obj2) {
                list2 = arrayList;
            }
            return obj2;
        }
        if (i2 == 1) {
            list2 = (List) dataMigrationInitializer$Companion$runMigrations$1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            it = dataMigrationInitializer$Companion$runMigrations$1.L$1;
            ref$ObjectRef = (Ref$ObjectRef) dataMigrationInitializer$Companion$runMigrations$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Object obj3 = ref$ObjectRef.element;
                if (obj3 == null) {
                    ref$ObjectRef.element = th2;
                } else {
                    ResultKt.addSuppressed((Throwable) obj3, th2);
                }
            }
        }
        while (it.hasNext()) {
            function1 = (Function1) it.next();
            dataMigrationInitializer$Companion$runMigrations$1.L$0 = ref$ObjectRef;
            dataMigrationInitializer$Companion$runMigrations$1.L$1 = it;
            dataMigrationInitializer$Companion$runMigrations$1.label = 2;
            if (function1.invoke(dataMigrationInitializer$Companion$runMigrations$1) == obj2) {
                return obj2;
            }
        }
        th = (Throwable) ref$ObjectRef.element;
        if (th == null) {
            return Unit.INSTANCE;
        }
        throw th;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        it = list2.iterator();
        ref$ObjectRef = ref$ObjectRef2;
        while (it.hasNext()) {
            function1 = (Function1) it.next();
            dataMigrationInitializer$Companion$runMigrations$1.L$0 = ref$ObjectRef;
            dataMigrationInitializer$Companion$runMigrations$1.L$1 = it;
            dataMigrationInitializer$Companion$runMigrations$1.label = 2;
            if (function1.invoke(dataMigrationInitializer$Companion$runMigrations$1) == obj2) {
                return obj2;
            }
        }
        th = (Throwable) ref$ObjectRef.element;
        if (th == null) {
            return Unit.INSTANCE;
        }
        throw th;
    }
}
