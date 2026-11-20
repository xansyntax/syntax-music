package androidx.datastore.core;

import androidx.collection.internal.Lock;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda5;
import androidx.room.ObservedTableVersions;
import coil3.RealImageLoader;
import coil3.compose.AsyncImagePainter;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.metrolist.music.App;
import com.metrolist.music.utils.SyncUtils$executeLikeSong$2$1;
import io.ktor.util.cio.FileChannelsKt$$ExternalSyntheticLambda0;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataStoreImpl implements DataStore {
    public int collectorCounter;
    public StandaloneCoroutine collectorJob;
    public final SynchronizedLazyImpl coordinator$delegate;
    public final SafeFlow data;
    public final Dispatcher readAndInit;
    public final CoroutineScope scope;
    public final FileStorage storage;
    public final SynchronizedLazyImpl storageConnectionDelegate;
    public final Dispatcher writeActor;
    public final MutexImpl collectorMutex = new MutexImpl();
    public final ObservedTableVersions inMemoryCache = new ObservedTableVersions();

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$decrementCollector$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public MutexImpl L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStoreImpl.this.decrementCollector(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$handleUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00391 extends ContinuationImpl {
        public CompletableDeferredImpl L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00391(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStoreImpl.this.handleUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$incrementCollector$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00401 extends ContinuationImpl {
        public MutexImpl L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00401(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStoreImpl.this.incrementCollector(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00411 extends ContinuationImpl {
        public int I$0;
        public int label;
        public /* synthetic */ Object result;

        public C00411(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStoreImpl.this.readAndInitOrPropagateAndThrowFailure(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00421 extends ContinuationImpl {
        public State L$0;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C00421(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStoreImpl.this.readDataAndUpdateCache(false, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass4 extends SuspendLambda implements Function2 {
        public final /* synthetic */ int $cachedVersion;
        public final /* synthetic */ byte $r8$classId;
        public Object L$0;
        public /* synthetic */ boolean Z$0;
        public byte label;
        public final /* synthetic */ DataStoreImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass4(DataStoreImpl dataStoreImpl, int i, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = dataStoreImpl;
            this.$cachedVersion = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            int i = this.$cachedVersion;
            DataStoreImpl dataStoreImpl = this.this$0;
            switch (b) {
                case 0:
                    AnonymousClass4 anonymousClass4 = new AnonymousClass4(dataStoreImpl, i, continuation, (byte) 0);
                    anonymousClass4.Z$0 = ((Boolean) obj).booleanValue();
                    return anonymousClass4;
                default:
                    AnonymousClass4 anonymousClass5 = new AnonymousClass4(dataStoreImpl, i, continuation, (byte) 1);
                    anonymousClass5.Z$0 = ((Boolean) obj).booleanValue();
                    return anonymousClass5;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            Boolean bool = (Boolean) obj;
            bool.booleanValue();
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
            }
            return ((AnonymousClass4) create(bool, continuation)).invokeSuspend(unit);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0066  */
        /* JADX WARN: Code duplicated, block: B:23:0x006b  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [byte] */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Throwable th;
            State readException;
            boolean z;
            boolean z2;
            Object obj2;
            int iHashCode;
            byte b = this.$r8$classId;
            int iIntValue = this.$cachedVersion;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            DataStoreImpl dataStoreImpl = this.this$0;
            Continuation continuation = null;
            byte b2 = 1;
            switch (b) {
                case 0:
                    boolean z3 = this.label;
                    try {
                        if (z3 == 0) {
                            ResultKt.throwOnFailure(obj);
                            boolean z4 = this.Z$0;
                            this.Z$0 = z4;
                            this.label = (byte) 1;
                            obj = dataStoreImpl.readDataOrHandleCorruption(z4, this);
                            z3 = z4;
                            if (obj == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (z3 != 1) {
                                if (z3 != 2) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                boolean z5 = this.Z$0;
                                th = (Throwable) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                z3 = z5;
                                iIntValue = ((Number) obj).intValue();
                                th = th;
                                readException = new ReadException(th, iIntValue);
                                z = z3;
                                return new Pair(readException, Boolean.valueOf(z));
                            }
                            boolean z6 = this.Z$0;
                            ResultKt.throwOnFailure(obj);
                            z3 = z6;
                        }
                        readException = (State) obj;
                        z = z3;
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        if (z3 != 0) {
                            SingleProcessCoordinator coordinator = dataStoreImpl.getCoordinator();
                            this.L$0 = th;
                            this.Z$0 = z3;
                            this.label = (byte) 2;
                            Integer version = coordinator.getVersion();
                            if (version == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            obj = version;
                            th = th;
                            z3 = z3;
                        }
                        readException = new ReadException(th, iIntValue);
                        z = z3;
                        return new Pair(readException, Boolean.valueOf(z));
                    }
                    return new Pair(readException, Boolean.valueOf(z));
                default:
                    byte b3 = this.label;
                    if (b3 != 0) {
                        if (b3 == 1) {
                            z2 = this.Z$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (b3 != 2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            obj2 = this.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                        iIntValue = ((Number) obj).intValue();
                        obj = obj2;
                        if (obj != null) {
                            iHashCode = obj.hashCode();
                        } else {
                            iHashCode = 0;
                        }
                        return new Data(iHashCode, iIntValue, obj);
                    }
                    ResultKt.throwOnFailure(obj);
                    z2 = this.Z$0;
                    this.Z$0 = z2;
                    this.label = (byte) 1;
                    obj = ((FileStorageConnection) dataStoreImpl.storageConnectionDelegate.getValue()).readScope(new DataStoreImpl$data$1$5(3, continuation, b2), this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    if (z2) {
                        SingleProcessCoordinator coordinator2 = dataStoreImpl.getCoordinator();
                        this.L$0 = obj;
                        this.label = (byte) 2;
                        Integer version2 = coordinator2.getVersion();
                        if (version2 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        Object obj3 = obj;
                        obj = version2;
                        obj2 = obj3;
                        iIntValue = ((Number) obj).intValue();
                        obj = obj2;
                    }
                    if (obj != null) {
                        iHashCode = obj.hashCode();
                    } else {
                        iHashCode = 0;
                    }
                    return new Data(iHashCode, iIntValue, obj);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00431 extends ContinuationImpl {
        public int I$0;
        public Object L$0;
        public Ref$ObjectRef L$1;
        public Serializable L$2;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C00431(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStoreImpl.this.readDataOrHandleCorruption(false, this);
        }
    }

    public DataStoreImpl(FileStorage fileStorage, List list, Lock lock, CoroutineScope coroutineScope) {
        this.storage = fileStorage;
        this.scope = coroutineScope;
        Continuation continuation = null;
        final byte b = 0;
        this.data = new SafeFlow((byte) 0, new AsyncImagePainter.AnonymousClass1(this, continuation, (byte) 8));
        this.readAndInit = new Dispatcher(this, list);
        this.storageConnectionDelegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.datastore.core.DataStoreImpl$$ExternalSyntheticLambda0
            public final /* synthetic */ DataStoreImpl f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws IOException {
                byte b2 = b;
                DataStoreImpl dataStoreImpl = this.f$0;
                switch (b2) {
                    case 0:
                        FileStorage fileStorage2 = dataStoreImpl.storage;
                        File canonicalFile = ((File) fileStorage2.produceFile.invoke()).getCanonicalFile();
                        synchronized (FileStorage.activeFilesLock) {
                            String absolutePath = canonicalFile.getAbsolutePath();
                            LinkedHashSet linkedHashSet = FileStorage.activeFiles;
                            if (linkedHashSet.contains(absolutePath)) {
                                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + absolutePath + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                            }
                            absolutePath.getClass();
                            linkedHashSet.add(absolutePath);
                        }
                        return new FileStorageConnection(canonicalFile, (SingleProcessCoordinator) fileStorage2.coordinatorProducer.invoke(canonicalFile), new FileChannelsKt$$ExternalSyntheticLambda0(canonicalFile, (byte) 1));
                    default:
                        return ((FileStorageConnection) dataStoreImpl.storageConnectionDelegate.getValue()).coordinator;
                }
            }
        });
        final byte b2 = 1;
        this.coordinator$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.datastore.core.DataStoreImpl$$ExternalSyntheticLambda0
            public final /* synthetic */ DataStoreImpl f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws IOException {
                byte b3 = b2;
                DataStoreImpl dataStoreImpl = this.f$0;
                switch (b3) {
                    case 0:
                        FileStorage fileStorage2 = dataStoreImpl.storage;
                        File canonicalFile = ((File) fileStorage2.produceFile.invoke()).getCanonicalFile();
                        synchronized (FileStorage.activeFilesLock) {
                            String absolutePath = canonicalFile.getAbsolutePath();
                            LinkedHashSet linkedHashSet = FileStorage.activeFiles;
                            if (linkedHashSet.contains(absolutePath)) {
                                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + absolutePath + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                            }
                            absolutePath.getClass();
                            linkedHashSet.add(absolutePath);
                        }
                        return new FileStorageConnection(canonicalFile, (SingleProcessCoordinator) fileStorage2.coordinatorProducer.invoke(canonicalFile), new FileChannelsKt$$ExternalSyntheticLambda0(canonicalFile, (byte) 1));
                    default:
                        return ((FileStorageConnection) dataStoreImpl.storageConnectionDelegate.getValue()).coordinator;
                }
            }
        });
        this.writeActor = new Dispatcher(coroutineScope, new DiskLruCache$$ExternalSyntheticLambda0((byte) 11, this), new SaversKt$$ExternalSyntheticLambda5((byte) 22), new App.C01391((Object) this, continuation, (byte) 3));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object decrementCollector(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        MutexImpl mutexImpl;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            MutexImpl mutexImpl2 = this.collectorMutex;
            anonymousClass1.L$0 = mutexImpl2;
            anonymousClass1.label = 1;
            Object objLock = mutexImpl2.lock(anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
            mutexImpl = mutexImpl2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            mutexImpl = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            int i3 = this.collectorCounter - 1;
            this.collectorCounter = i3;
            if (i3 == 0) {
                StandaloneCoroutine standaloneCoroutine = this.collectorJob;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
                this.collectorJob = null;
            }
            return Unit.INSTANCE;
        } finally {
            mutexImpl.unlock(null);
        }
    }

    public final SingleProcessCoordinator getCoordinator() {
        return (SingleProcessCoordinator) this.coordinator$delegate.getValue();
    }

    @Override // androidx.datastore.core.DataStore
    public final Flow getData() {
        return this.data;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object handleUpdate(Message$Update message$Update, ContinuationImpl continuationImpl) {
        C00391 c00391;
        CompletableDeferredImpl completableDeferredImpl;
        if (continuationImpl instanceof C00391) {
            c00391 = (C00391) continuationImpl;
            int i = c00391.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00391.label = i - Integer.MIN_VALUE;
            } else {
                c00391 = new C00391(continuationImpl);
            }
        } else {
            c00391 = new C00391(continuationImpl);
        }
        Object failure = c00391.result;
        int i2 = c00391.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(failure);
            CompletableDeferredImpl completableDeferredImpl2 = message$Update.ack;
            try {
                CoroutineContext coroutineContextPlus = message$Update.callerContext.plus(c00391.getContext());
                SimpleActor$offer$2 simpleActor$offer$2 = new SimpleActor$offer$2(this, message$Update, continuation, (byte) 7);
                c00391.L$0 = completableDeferredImpl2;
                c00391.label = 1;
                Object objWithContext = AwaitKt.withContext(coroutineContextPlus, simpleActor$offer$2, c00391);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objWithContext == coroutineSingletons) {
                    return coroutineSingletons;
                }
                failure = objWithContext;
                completableDeferredImpl = completableDeferredImpl2;
            } catch (Throwable th) {
                th = th;
                completableDeferredImpl = completableDeferredImpl2;
                failure = new Result.Failure(th);
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            completableDeferredImpl = c00391.L$0;
            try {
                ResultKt.throwOnFailure(failure);
            } catch (Throwable th2) {
                th = th2;
                failure = new Result.Failure(th);
            }
        }
        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(failure);
        if (thM1866exceptionOrNullimpl == null) {
            completableDeferredImpl.makeCompleting$kotlinx_coroutines_core(failure);
        } else {
            completableDeferredImpl.completeExceptionally(thM1866exceptionOrNullimpl);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object incrementCollector(ContinuationImpl continuationImpl) {
        C00401 c00401;
        MutexImpl mutexImpl;
        if (continuationImpl instanceof C00401) {
            c00401 = (C00401) continuationImpl;
            int i = c00401.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00401.label = i - Integer.MIN_VALUE;
            } else {
                c00401 = new C00401(continuationImpl);
            }
        } else {
            c00401 = new C00401(continuationImpl);
        }
        Object obj = c00401.result;
        int i2 = c00401.label;
        byte b = 1;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            MutexImpl mutexImpl2 = this.collectorMutex;
            c00401.L$0 = mutexImpl2;
            c00401.label = 1;
            Object objLock = mutexImpl2.lock(c00401);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
            mutexImpl = mutexImpl2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            mutexImpl = c00401.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            int i3 = this.collectorCounter + 1;
            this.collectorCounter = i3;
            if (i3 == 1) {
                this.collectorJob = AwaitKt.launch$default(this.scope, null, null, new DataStoreImpl$readState$2(this, continuation, b), 3);
            }
            return Unit.INSTANCE;
        } finally {
            mutexImpl.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        if (r1.runIfNeeded(r0) == r4) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readAndInitOrPropagateAndThrowFailure(ContinuationImpl continuationImpl) throws Throwable {
        C00411 c00411;
        int iIntValue;
        int i;
        Throwable th;
        if (continuationImpl instanceof C00411) {
            c00411 = (C00411) continuationImpl;
            int i2 = c00411.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c00411.label = i2 - Integer.MIN_VALUE;
            } else {
                c00411 = new C00411(continuationImpl);
            }
        } else {
            c00411 = new C00411(continuationImpl);
        }
        Object version = c00411.result;
        int i3 = c00411.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(version);
                SingleProcessCoordinator coordinator = getCoordinator();
                c00411.label = 1;
                version = coordinator.getVersion();
                if (version != obj) {
                }
                return obj;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i = c00411.I$0;
                try {
                    ResultKt.throwOnFailure(version);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    this.inMemoryCache.tryUpdate(new ReadException(th, i));
                    throw th;
                }
            }
            ResultKt.throwOnFailure(version);
            Dispatcher dispatcher = this.readAndInit;
            c00411.I$0 = iIntValue;
            c00411.label = 2;
        } catch (Throwable th3) {
            i = iIntValue;
            th = th3;
            this.inMemoryCache.tryUpdate(new ReadException(th, i));
            throw th;
        }
        iIntValue = ((Number) version).intValue();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0088, code lost:
    
        if (r12 == r7) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a0, code lost:
    
        if (r12 == r7) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readDataAndUpdateCache(boolean z, Continuation continuation) {
        C00421 c00421;
        State currentState;
        Pair pair;
        State state;
        if (continuation instanceof C00421) {
            c00421 = (C00421) continuation;
            int i = c00421.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00421.label = i - Integer.MIN_VALUE;
            } else {
                c00421 = new C00421(continuation);
            }
        } else {
            c00421 = new C00421(continuation);
        }
        Object version = c00421.result;
        int i2 = c00421.label;
        ObservedTableVersions observedTableVersions = this.inMemoryCache;
        byte b = 1;
        Continuation continuation2 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(version);
            currentState = observedTableVersions.getCurrentState();
            if (currentState instanceof UnInitialized) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542");
                return null;
            }
            SingleProcessCoordinator coordinator = getCoordinator();
            c00421.L$0 = currentState;
            c00421.Z$0 = z;
            c00421.label = 1;
            version = coordinator.getVersion();
            if (version != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(version);
                pair = (Pair) version;
                state = (State) pair.first;
                if (((Boolean) pair.second).booleanValue()) {
                    observedTableVersions.tryUpdate(state);
                }
                return state;
            }
            if (i2 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(version);
            pair = (Pair) version;
            state = (State) pair.first;
            if (((Boolean) pair.second).booleanValue()) {
                observedTableVersions.tryUpdate(state);
            }
            return state;
        }
        z = c00421.Z$0;
        currentState = c00421.L$0;
        ResultKt.throwOnFailure(version);
        int iIntValue = ((Number) version).intValue();
        boolean z2 = currentState instanceof Data;
        int i3 = z2 ? ((Data) currentState).version : -1;
        if (z2 && iIntValue == i3) {
            return currentState;
        }
        if (z) {
            SingleProcessCoordinator coordinator2 = getCoordinator();
            FileReadScope$readData$2 fileReadScope$readData$2 = new FileReadScope$readData$2(this, continuation2, b);
            c00421.L$0 = null;
            c00421.label = 2;
            version = coordinator2.lock(fileReadScope$readData$2, c00421);
        } else {
            SingleProcessCoordinator coordinator3 = getCoordinator();
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this, i3, continuation2, (byte) 0);
            c00421.L$0 = null;
            c00421.label = 3;
            version = coordinator3.tryLock(anonymousClass4, c00421);
        }
        return coroutineSingletons;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007f  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d1 A[Catch: CorruptionException -> 0x0098, TryCatch #0 {CorruptionException -> 0x0098, blocks: (B:36:0x0093, B:68:0x0121, B:41:0x009d, B:65:0x0106, B:44:0x00a7, B:60:0x00eb, B:47:0x00ad, B:55:0x00d1, B:56:0x00d5, B:51:0x00b7, B:62:0x00f7), top: B:72:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x011e, code lost:
    
        if (r11 == r6) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readDataOrHandleCorruption(boolean z, ContinuationImpl continuationImpl) {
        C00431 c00431;
        int iHashCode;
        Integer version;
        Object obj;
        int i;
        CorruptionException corruptionException;
        Ref$IntRef ref$IntRef;
        Ref$ObjectRef ref$ObjectRef;
        if (continuationImpl instanceof C00431) {
            c00431 = (C00431) continuationImpl;
            int i2 = c00431.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c00431.label = i2 - Integer.MIN_VALUE;
            } else {
                c00431 = new C00431(continuationImpl);
            }
        } else {
            c00431 = new C00431(continuationImpl);
        }
        Object version2 = c00431.result;
        int i3 = c00431.label;
        byte b = 2;
        byte b2 = 1;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            switch (i3) {
                case 0:
                    ResultKt.throwOnFailure(version2);
                    int i4 = 3;
                    if (!z) {
                        SingleProcessCoordinator coordinator = getCoordinator();
                        c00431.Z$0 = z;
                        c00431.label = 3;
                        version2 = coordinator.getVersion();
                        if (version2 != coroutineSingletons) {
                            int iIntValue = ((Number) version2).intValue();
                            SingleProcessCoordinator coordinator2 = getCoordinator();
                            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this, iIntValue, continuation, b2);
                            c00431.Z$0 = z;
                            c00431.label = 4;
                            version2 = coordinator2.tryLock(anonymousClass4, c00431);
                            break;
                        }
                    } else {
                        c00431.Z$0 = z;
                        c00431.label = 1;
                        version2 = ((FileStorageConnection) this.storageConnectionDelegate.getValue()).readScope(new DataStoreImpl$data$1$5(i4, continuation, b2), c00431);
                        if (version2 != coroutineSingletons) {
                            iHashCode = version2 != null ? version2.hashCode() : 0;
                            SingleProcessCoordinator coordinator3 = getCoordinator();
                            c00431.L$0 = version2;
                            c00431.Z$0 = z;
                            c00431.I$0 = iHashCode;
                            c00431.label = 2;
                            version = coordinator3.getVersion();
                            if (version != coroutineSingletons) {
                                obj = version2;
                                version2 = version;
                                i = iHashCode;
                                return new Data(i, ((Number) version2).intValue(), obj);
                            }
                        }
                    }
                    return coroutineSingletons;
                case 1:
                    z = c00431.Z$0;
                    ResultKt.throwOnFailure(version2);
                    if (version2 != null) {
                    }
                    SingleProcessCoordinator coordinator4 = getCoordinator();
                    c00431.L$0 = version2;
                    c00431.Z$0 = z;
                    c00431.I$0 = iHashCode;
                    c00431.label = 2;
                    version = coordinator4.getVersion();
                    if (version != coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj = version2;
                    version2 = version;
                    i = iHashCode;
                    return new Data(i, ((Number) version2).intValue(), obj);
                case 2:
                    i = c00431.I$0;
                    boolean z2 = c00431.Z$0;
                    obj = c00431.L$0;
                    ResultKt.throwOnFailure(version2);
                    return new Data(i, ((Number) version2).intValue(), obj);
                case 3:
                    z = c00431.Z$0;
                    ResultKt.throwOnFailure(version2);
                    int iIntValue2 = ((Number) version2).intValue();
                    SingleProcessCoordinator coordinator5 = getCoordinator();
                    AnonymousClass4 anonymousClass5 = new AnonymousClass4(this, iIntValue2, continuation, b2);
                    c00431.Z$0 = z;
                    c00431.label = 4;
                    version2 = coordinator5.tryLock(anonymousClass5, c00431);
                    break;
                case 4:
                    boolean z3 = c00431.Z$0;
                    ResultKt.throwOnFailure(version2);
                    return (Data) version2;
                case 5:
                    boolean z4 = c00431.Z$0;
                    Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) c00431.L$2;
                    Ref$ObjectRef ref$ObjectRef3 = c00431.L$1;
                    CorruptionException corruptionException2 = (CorruptionException) c00431.L$0;
                    ResultKt.throwOnFailure(version2);
                    ref$ObjectRef2.element = version2;
                    Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                    try {
                        DataStoreImpl$transformAndWrite$2 dataStoreImpl$transformAndWrite$2 = new DataStoreImpl$transformAndWrite$2(ref$ObjectRef3, this, ref$IntRef2, (Continuation) null);
                        c00431.L$0 = corruptionException2;
                        c00431.L$1 = ref$ObjectRef3;
                        c00431.L$2 = ref$IntRef2;
                        c00431.label = 6;
                        if ((z4 ? dataStoreImpl$transformAndWrite$2.invoke(c00431) : getCoordinator().lock(new SyncUtils$executeLikeSong$2$1(dataStoreImpl$transformAndWrite$2, continuation, b), c00431)) != coroutineSingletons) {
                            ref$IntRef = ref$IntRef2;
                            ref$ObjectRef = ref$ObjectRef3;
                            Object obj2 = ref$ObjectRef.element;
                            return new Data(obj2 != null ? obj2.hashCode() : 0, ref$IntRef.element, obj2);
                        }
                        return coroutineSingletons;
                    } catch (Throwable th) {
                        th = th;
                        corruptionException = corruptionException2;
                        ResultKt.addSuppressed(corruptionException, th);
                        throw corruptionException;
                    }
                case 6:
                    ref$IntRef = (Ref$IntRef) c00431.L$2;
                    ref$ObjectRef = c00431.L$1;
                    corruptionException = (CorruptionException) c00431.L$0;
                    try {
                        ResultKt.throwOnFailure(version2);
                        Object obj3 = ref$ObjectRef.element;
                        return new Data(obj3 != null ? obj3.hashCode() : 0, ref$IntRef.element, obj3);
                    } catch (Throwable th2) {
                        th = th2;
                        ResultKt.addSuppressed(corruptionException, th);
                        throw corruptionException;
                    }
                default:
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        } catch (CorruptionException e) {
            Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            c00431.L$0 = e;
            c00431.L$1 = ref$ObjectRef4;
            c00431.L$2 = ref$ObjectRef4;
            c00431.Z$0 = z;
            c00431.label = 5;
            throw e;
        }
    }

    @Override // androidx.datastore.core.DataStore
    public final Object updateData(Function2 function2, ContinuationImpl continuationImpl) {
        UpdatingDataContextElement updatingDataContextElement = (UpdatingDataContextElement) continuationImpl.getContext().get(DataMigrationInitializer$Companion.INSTANCE);
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(this);
        }
        return AwaitKt.withContext(new UpdatingDataContextElement(updatingDataContextElement, this), new RealImageLoader.AnonymousClass2(this, function2, null, (byte) 23), continuationImpl);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object writeData$datastore_core(Object obj, boolean z, ContinuationImpl continuationImpl) {
        DataStoreImpl$writeData$1 dataStoreImpl$writeData$1;
        Ref$IntRef ref$IntRef;
        if (continuationImpl instanceof DataStoreImpl$writeData$1) {
            dataStoreImpl$writeData$1 = (DataStoreImpl$writeData$1) continuationImpl;
            int i = dataStoreImpl$writeData$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                dataStoreImpl$writeData$1.label = i - Integer.MIN_VALUE;
            } else {
                dataStoreImpl$writeData$1 = new DataStoreImpl$writeData$1(this, continuationImpl);
            }
        } else {
            dataStoreImpl$writeData$1 = new DataStoreImpl$writeData$1(this, continuationImpl);
        }
        Object obj2 = dataStoreImpl$writeData$1.result;
        int i2 = dataStoreImpl$writeData$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            FileStorageConnection fileStorageConnection = (FileStorageConnection) this.storageConnectionDelegate.getValue();
            DataStoreImpl$writeData$2 dataStoreImpl$writeData$2 = new DataStoreImpl$writeData$2(ref$IntRef2, this, obj, z, (Continuation) null);
            dataStoreImpl$writeData$1.L$0 = ref$IntRef2;
            dataStoreImpl$writeData$1.label = 1;
            Object objWriteScope = fileStorageConnection.writeScope(dataStoreImpl$writeData$2, dataStoreImpl$writeData$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWriteScope == coroutineSingletons) {
                return coroutineSingletons;
            }
            ref$IntRef = ref$IntRef2;
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ref$IntRef = dataStoreImpl$writeData$1.L$0;
            ResultKt.throwOnFailure(obj2);
        }
        return new Integer(ref$IntRef.element);
    }
}
