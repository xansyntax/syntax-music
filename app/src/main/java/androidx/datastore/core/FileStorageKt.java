package androidx.datastore.core;

import android.os.Parcel;
import android.os.Process;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FileStorageKt {
    public static final DataMigrationInitializer$Companion Companion = new DataMigrationInitializer$Companion();

    /* JADX INFO: renamed from: androidx.datastore.core.FileStorageKt$runFileDiagnosticsIfNotCorruption$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public File L$0;
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileStorageKt.runFileDiagnosticsIfNotCorruption(null, null, this);
        }
    }

    public static IOException attachFileSystemMessage(File file, IOException iOException) {
        StringBuilder sb = new StringBuilder("Inoperable file:");
        try {
            sb.append(" canonical[" + file.getCanonicalPath() + "] freeSpace[" + file.getFreeSpace() + ']');
        } catch (IOException unused) {
            sb.append(" failed to attach additional metadata");
        }
        return new IOException(sb.toString(), iOException);
    }

    public static IOException attachParentStacktrace(File file, IOException iOException) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return attachFileSystemMessage(file, iOException);
        }
        if (!parentFile.exists()) {
            return attachFileSystemMessage(file, iOException);
        }
        if (parentFile.isFile()) {
            if (parentFile.canRead()) {
                return parentFile.canWrite() ? attachFileSystemMessage(file, iOException) : attachFileSystemMessage(file, iOException);
            }
            return parentFile.canWrite() ? attachFileSystemMessage(file, iOException) : attachFileSystemMessage(file, iOException);
        }
        if (parentFile.canRead()) {
            return parentFile.canWrite() ? attachFileSystemMessage(file, iOException) : attachFileSystemMessage(file, iOException);
        }
        return parentFile.canWrite() ? attachFileSystemMessage(file, iOException) : attachFileSystemMessage(file, iOException);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object runFileDiagnosticsIfNotCorruption(File file, Function1 function1, ContinuationImpl continuationImpl) throws IOException {
        AnonymousClass1 anonymousClass1;
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
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                File file2 = anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            anonymousClass1.L$0 = file;
            anonymousClass1.label = 1;
            Object objInvoke = function1.invoke(anonymousClass1);
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objInvoke == obj2 ? obj2 : objInvoke;
        } catch (IOException e) {
            if (e instanceof CorruptionException) {
                throw e;
            }
            file.getClass();
            if (!file.exists()) {
                throw attachParentStacktrace(file, e);
            }
            if (file.isFile()) {
                if (file.canRead()) {
                    if (file.canWrite()) {
                        throw attachParentStacktrace(file, e);
                    }
                    throw attachParentStacktrace(file, e);
                }
                if (file.canWrite()) {
                    throw attachParentStacktrace(file, e);
                }
                throw attachParentStacktrace(file, e);
            }
            if (file.canRead()) {
                if (file.canWrite()) {
                    throw attachParentStacktrace(file, e);
                }
                throw attachParentStacktrace(file, e);
            }
            if (file.canWrite()) {
                throw attachParentStacktrace(file, e);
            }
            throw attachParentStacktrace(file, e);
        }
    }

    public static final Exception wrapExceptionIfDueToDirectBoot(String str, FileNotFoundException fileNotFoundException) {
        int i;
        boolean zEquals = false;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
            method.getClass();
            try {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.getClass();
                Process.myUserHandle().writeToParcel(parcelObtain, 0);
                parcelObtain.setDataPosition(0);
                i = parcelObtain.readInt();
            } catch (Throwable unused) {
                i = 0;
            }
            Object objInvoke = method.invoke(null, "sys.user." + i + ".ce_available", "false");
            objInvoke.getClass();
            zEquals = ((String) objInvoke).equals("true");
        } catch (Throwable th) {
            ResultKt.addSuppressed(fileNotFoundException, th);
        }
        if (zEquals || str == null) {
            return fileNotFoundException;
        }
        File file = new File(str, "siblingTestFile.txt");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            return fileNotFoundException;
        } catch (IOException unused2) {
            return new DirectBootUsageException(fileNotFoundException);
        } finally {
            file.delete();
        }
    }
}
