package androidx.datastore.core;

import io.ktor.util.cio.FileChannelsKt$$ExternalSyntheticLambda0;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FileStorageConnection implements Closeable {
    public final AtomicBoolean closed;
    public final SingleProcessCoordinator coordinator;
    public final File file;
    public final FileChannelsKt$$ExternalSyntheticLambda0 onClose;
    public final MutexImpl transactionMutex;

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorageConnection$readScope$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public FileReadScope L$0;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileStorageConnection.this.readScope(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorageConnection$writeScope$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00441 extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public FileWriteScope L$2;
        public int label;
        public /* synthetic */ Object result;

        public C00441(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileStorageConnection.this.writeScope(null, this);
        }
    }

    public FileStorageConnection(File file, SingleProcessCoordinator singleProcessCoordinator, FileChannelsKt$$ExternalSyntheticLambda0 fileChannelsKt$$ExternalSyntheticLambda0) {
        singleProcessCoordinator.getClass();
        this.file = file;
        this.coordinator = singleProcessCoordinator;
        this.onClose = fileChannelsKt$$ExternalSyntheticLambda0;
        this.closed = new AtomicBoolean(false);
        this.transactionMutex = new MutexImpl();
    }

    @Override // androidx.datastore.core.Closeable
    public final void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0069 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x006b  */
    /* JADX WARN: Code duplicated, block: B:34:0x006f A[Catch: all -> 0x0070, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:34:0x006f, B:43:0x0080, B:42:0x007d, B:39:0x0078), top: B:50:0x0020, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.datastore.core.DataStoreImpl$data$1$5] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v6, types: [boolean] */
    public final Object readScope(DataStoreImpl$data$1$5 dataStoreImpl$data$1$5, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        ?? TryLock;
        Throwable th;
        FileReadScope fileReadScope;
        ?? r5;
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
        MutexImpl mutexImpl = this.transactionMutex;
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                this = anonymousClass1.Z$0;
                fileReadScope = anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    r5 = this;
                    try {
                        fileReadScope.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (th == null) {
                        throw th;
                    }
                    if (r5 != 0) {
                        mutexImpl.unlock(null);
                    }
                    return obj;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        fileReadScope.close();
                    } catch (Throwable th4) {
                        ResultKt.addSuppressed(th, th4);
                    }
                    throw th;
                }
            }
            ResultKt.throwOnFailure(obj);
            if (this.closed.get()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("StorageConnection has already been disposed.");
                return null;
            }
            TryLock = mutexImpl.tryLock();
            try {
                FileReadScope fileReadScope2 = new FileReadScope(this.file);
                try {
                    Boolean boolValueOf = Boolean.valueOf((boolean) TryLock);
                    anonymousClass1.L$0 = fileReadScope2;
                    anonymousClass1.Z$0 = TryLock;
                    anonymousClass1.label = 1;
                    Object objInvoke = dataStoreImpl$data$1$5.invoke(fileReadScope2, boolValueOf, anonymousClass1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objInvoke == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj = objInvoke;
                    r5 = TryLock == true ? 1 : 0;
                    fileReadScope = fileReadScope2;
                    fileReadScope.close();
                    th = null;
                    if (th == null) {
                        throw th;
                    }
                    if (r5 != 0) {
                        mutexImpl.unlock(null);
                    }
                    return obj;
                } catch (Throwable th5) {
                    th = th5;
                    this = TryLock == true ? 1 : 0;
                    fileReadScope = fileReadScope2;
                    fileReadScope.close();
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                if (TryLock != 0) {
                    mutexImpl.unlock(null);
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            TryLock = this;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00bc A[Catch: all -> 0x00f4, IOException -> 0x00f6, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00f4, blocks: (B:42:0x00bc, B:44:0x00c2, B:46:0x00d5, B:47:0x00f3, B:54:0x00ff, B:66:0x0116, B:68:0x011c, B:69:0x011f, B:61:0x010e, B:60:0x010b), top: B:78:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00ff A[Catch: all -> 0x00f4, IOException -> 0x00f6, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00f4, blocks: (B:42:0x00bc, B:44:0x00c2, B:46:0x00d5, B:47:0x00f3, B:54:0x00ff, B:66:0x0116, B:68:0x011c, B:69:0x011f, B:61:0x010e, B:60:0x010b), top: B:78:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.datastore.core.FileStorageConnection$writeScope$1, java.lang.Object, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object, kotlinx.coroutines.sync.MutexImpl] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.Object] */
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
    public final Object writeScope(DataStoreImpl$writeData$2 dataStoreImpl$writeData$2, ContinuationImpl continuationImpl) {
        ?? c00441;
        ?? r11;
        ?? r10;
        ?? r9;
        File file;
        FileWriteScope fileWriteScope;
        Throwable th;
        FileWriteScope fileWriteScope2;
        ?? r1;
        File file2;
        if (continuationImpl instanceof C00441) {
            C00441 c00442 = (C00441) continuationImpl;
            int i = c00442.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00442.label = i - Integer.MIN_VALUE;
                c00441 = c00442;
            } else {
                c00441 = new C00441(continuationImpl);
            }
        } else {
            c00441 = new C00441(continuationImpl);
        }
        Object obj = c00441.result;
        int i2 = c00441.label;
        File file3 = this.file;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    try {
                        try {
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj);
                                if (this.closed.get()) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("StorageConnection has already been disposed.");
                                    return null;
                                }
                                File parentFile = file3.getCanonicalFile().getParentFile();
                                if (parentFile != null) {
                                    parentFile.mkdirs();
                                    if (!parentFile.isDirectory()) {
                                        Path$$ExternalSyntheticBUOutline0.m(file3, "Unable to create parent directories of ");
                                        return null;
                                    }
                                }
                                c00441.L$0 = dataStoreImpl$writeData$2;
                                ?? r12 = this.transactionMutex;
                                c00441.L$1 = r12;
                                c00441.label = 1;
                                Object objLock = r12.lock(c00441);
                                r9 = r12;
                                r10 = dataStoreImpl$writeData$2;
                                if (objLock != coroutineSingletons) {
                                }
                                return coroutineSingletons;
                            }
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                fileWriteScope2 = c00441.L$2;
                                File file4 = (File) c00441.L$1;
                                Mutex mutex = (Mutex) c00441.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    r1 = mutex;
                                    file2 = file4;
                                    try {
                                        fileWriteScope2.close();
                                        th = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                    if (th == null) {
                                        throw th;
                                    }
                                    if (file2.exists()) {
                                        try {
                                            Files.move(file2.toPath(), file3.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                        } catch (IOException unused) {
                                            throw new IOException("Unable to rename " + file2 + " to " + file3 + ". This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
                                        }
                                    }
                                    r1.unlock(null);
                                    return Unit.INSTANCE;
                                } catch (Throwable th3) {
                                    th = th3;
                                    try {
                                        fileWriteScope2.close();
                                    } catch (Throwable th4) {
                                        ResultKt.addSuppressed(th, th4);
                                    }
                                    throw th;
                                }
                            }
                            Mutex mutex2 = (Mutex) c00441.L$1;
                            Function2 function2 = (Function2) c00441.L$0;
                            ResultKt.throwOnFailure(obj);
                            r9 = mutex2;
                            r10 = function2;
                            c00441.L$0 = r9;
                            c00441.L$1 = file;
                            c00441.L$2 = fileWriteScope;
                            c00441.label = 2;
                            if (r10.invoke(fileWriteScope, c00441) != coroutineSingletons) {
                                r1 = r9;
                                file2 = file;
                                fileWriteScope2 = fileWriteScope;
                                fileWriteScope2.close();
                                th = null;
                                if (th == null) {
                                    throw th;
                                }
                                if (file2.exists()) {
                                    Files.move(file2.toPath(), file3.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                }
                                r1.unlock(null);
                                return Unit.INSTANCE;
                            }
                            return coroutineSingletons;
                        } catch (Throwable th5) {
                            th = th5;
                            fileWriteScope2 = fileWriteScope;
                            fileWriteScope2.close();
                            throw th;
                        }
                        fileWriteScope = new FileWriteScope(file);
                    } catch (IOException e) {
                        e = e;
                        r11 = file;
                        if (!r11.exists()) {
                            throw e;
                        }
                        r11.delete();
                        throw e;
                    }
                    file = new File(file3.getAbsolutePath() + ".tmp");
                } catch (Throwable th6) {
                    c00441 = r9;
                    th = th6;
                    c00441.unlock(null);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (IOException e2) {
            e = e2;
            r11 = dataStoreImpl$writeData$2;
        }
    }
}
