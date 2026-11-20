package androidx.room.concurrent;

import android.app.Notification;
import android.os.Bundle;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.session.DefaultActionFactory;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaNotification$Provider;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import com.google.common.collect.ImmutableList;
import com.metrolist.innertubex.extraction.PlayerConfig;
import com.metrolist.innertubex.extraction.YtConfigParserImpl;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.utils.InnerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.KTypeWrapper;
import kotlinx.serialization.internal.ParametrizedCacheEntry;
import kotlinx.serialization.internal.ParametrizedSerializerCache;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.FileMetadata;
import okio.Okio__OkioKt;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class FileLock implements SQLiteDriver, MediaNotification$Provider, ParametrizedSerializerCache {
    public Object lockChannel;
    public Object lockFilename;

    public FileLock(Function2 function2) {
        this.lockFilename = function2;
        this.lockChannel = new ConcurrentHashMap();
    }

    @Override // androidx.media3.session.MediaNotification$Provider
    public PriorityQueue createNotification(MediaLibraryService.MediaLibrarySession mediaLibrarySession, ImmutableList immutableList, DefaultActionFactory defaultActionFactory, MediaNotification$Provider.Callback callback) {
        mediaLibrarySession.getClass();
        immutableList.getClass();
        defaultActionFactory.getClass();
        PriorityQueue priorityQueueCreateNotification = ((DefaultMediaNotificationProvider) this.lockFilename).createNotification(mediaLibrarySession, immutableList, defaultActionFactory, new TextLinkScope$$ExternalSyntheticLambda10(this.lockChannel, callback, (byte) 25));
        ((MusicService) this.lockChannel).latestMediaNotification = (Notification) priorityQueueCreateNotification.array;
        return priorityQueueCreateNotification;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007f, code lost:
    
        if (r9 == r8) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchConfig(String str, boolean z, ContinuationImpl continuationImpl) {
        InnerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1 innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1;
        YtConfigParserImpl ytConfigParserImpl = (YtConfigParserImpl) this.lockChannel;
        if (continuationImpl instanceof InnerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1) {
            innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1 = (InnerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1) continuationImpl;
            int i = innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1.label = i - Integer.MIN_VALUE;
            } else {
                innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1 = new InnerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1(this, continuationImpl);
            }
        } else {
            innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1 = new InnerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1(this, continuationImpl);
        }
        InnerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1 innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2 = innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$1;
        Object objFetchConfigPage = innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.result;
        int i2 = innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.label;
        boolean z2 = true;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFetchConfigPage);
            try {
                innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.L$0 = str;
                innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.Z$0 = z;
                innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.label = 1;
                try {
                    try {
                        if (YtConfigParserImpl.SAFE_VIDEO_ID.matches(str)) {
                            z2 = z;
                            objFetchConfigPage = ytConfigParserImpl.fetchConfigPage(z2, IntIntPair$$ExternalSyntheticOutline0.m("https://www.youtube.com/watch?v=", str, "&bpctr=9999999999&has_verified=1"), "watch", null, innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2);
                        } else {
                            z2 = z;
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Invalid video ID");
                            objFetchConfigPage = null;
                        }
                        if (objFetchConfigPage != coroutineSingletons) {
                            z = z2;
                        }
                    } catch (IllegalStateException unused) {
                        z = z2;
                        innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.L$0 = null;
                        innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.Z$0 = z;
                        innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.label = 2;
                        objFetchConfigPage = ytConfigParserImpl.fetchEmbeddedConfig(str, innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2);
                    }
                } catch (IllegalStateException unused2) {
                    z2 = z;
                }
            } catch (IllegalStateException unused3) {
            }
            return coroutineSingletons;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(objFetchConfigPage);
                return (PlayerConfig) objFetchConfigPage;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        z = innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.Z$0;
        str = innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.L$0;
        try {
            ResultKt.throwOnFailure(objFetchConfigPage);
        } catch (IllegalStateException unused4) {
            innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.L$0 = null;
            innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.Z$0 = z;
            innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2.label = 2;
            objFetchConfigPage = ytConfigParserImpl.fetchEmbeddedConfig(str, innerTubeXPlayer$withEmbeddedConfigFallback$1$fetchConfig$2);
        }
        return (PlayerConfig) objFetchConfigPage;
    }

    @Override // kotlinx.serialization.internal.ParametrizedSerializerCache
    /* JADX INFO: renamed from: get-gIAlu-s, reason: not valid java name */
    public Object mo843getgIAlus(KClass kClass, ArrayList arrayList) {
        Object failure;
        Object objPutIfAbsent;
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.lockChannel;
        Class javaClass = Okio__OkioKt.getJavaClass(kClass);
        Object parametrizedCacheEntry = concurrentHashMap.get(javaClass);
        if (parametrizedCacheEntry == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(javaClass, (parametrizedCacheEntry = new ParametrizedCacheEntry()))) != null) {
            parametrizedCacheEntry = objPutIfAbsent;
        }
        ParametrizedCacheEntry parametrizedCacheEntry2 = (ParametrizedCacheEntry) parametrizedCacheEntry;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(new KTypeWrapper((KType) obj));
        }
        ConcurrentHashMap concurrentHashMap2 = parametrizedCacheEntry2.serializers;
        Object obj2 = concurrentHashMap2.get(arrayList2);
        if (obj2 == null) {
            try {
                failure = (KSerializer) ((Function2) this.lockFilename).invoke(kClass, arrayList);
            } catch (Throwable th) {
                failure = new Result.Failure(th);
            }
            Result result = new Result(failure);
            Object objPutIfAbsent2 = concurrentHashMap2.putIfAbsent(arrayList2, result);
            obj2 = objPutIfAbsent2 == null ? result : objPutIfAbsent2;
        }
        return ((Result) obj2).value;
    }

    @Override // androidx.media3.session.MediaNotification$Provider
    public CallbackWrapper getNotificationChannelInfo() {
        return ((DefaultMediaNotificationProvider) this.lockFilename).getNotificationChannelInfo();
    }

    @Override // androidx.media3.session.MediaNotification$Provider
    public void handleCustomCommand(MediaLibraryService.MediaLibrarySession mediaLibrarySession, String str, Bundle bundle) {
        bundle.getClass();
    }

    @Override // androidx.sqlite.SQLiteDriver
    public boolean hasConnectionPool() {
        return ((SQLiteDriver) this.lockFilename).hasConnectionPool();
    }

    public void lock() throws IOException {
        String str = (String) this.lockFilename;
        if (((FileChannel) this.lockChannel) != null) {
            return;
        }
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileChannel channel = new FileOutputStream(file).getChannel();
            this.lockChannel = channel;
            if (channel != null) {
                channel.lock();
            }
        } catch (Throwable th) {
            FileChannel fileChannel = (FileChannel) this.lockChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
            this.lockChannel = null;
            throw new IllegalStateException(IntIntPair$$ExternalSyntheticOutline0.m("Unable to lock file: '", str, "'."), th);
        }
    }

    @Override // androidx.sqlite.SQLiteDriver
    public SQLiteConnection open(String str) {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        str.getClass();
        FileMetadata fileMetadata = (FileMetadata) this.lockChannel;
        if (!str.equals(":memory:")) {
            str = ((DatabaseConfiguration) fileMetadata.symlinkTarget).context.getDatabasePath(str).getAbsolutePath();
            str.getClass();
        }
        boolean z = true;
        ExclusiveLock exclusiveLock = new ExclusiveLock(str, (fileMetadata.isRegularFile || fileMetadata.isDirectory || str.equals(":memory:")) ? false : true);
        ReentrantLock reentrantLock = exclusiveLock.threadLock;
        reentrantLock.lock();
        FileLock fileLock = exclusiveLock.fileLock;
        if (fileLock != null) {
            try {
                fileLock.lock();
            } catch (Throwable th) {
                th = th;
                z = false;
            }
        }
        try {
            try {
                if (fileMetadata.isDirectory) {
                    throw new IllegalStateException("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
                }
                SQLiteConnection sQLiteConnectionOpen = ((SQLiteDriver) this.lockFilename).open(str);
                if (fileMetadata.isRegularFile) {
                    FileMetadata.configureBusyTimeout(sQLiteConnectionOpen);
                    if (((DatabaseConfiguration) fileMetadata.symlinkTarget).journalMode == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
                        SQLite.execSQL(sQLiteConnectionOpen, "PRAGMA synchronous = NORMAL");
                    } else {
                        SQLite.execSQL(sQLiteConnectionOpen, "PRAGMA synchronous = FULL");
                    }
                    ((RoomOpenDelegate) fileMetadata.size).onOpen(sQLiteConnectionOpen);
                } else {
                    try {
                        fileMetadata.isDirectory = true;
                        fileMetadata.configureDatabase(sQLiteConnectionOpen);
                        fileMetadata.isDirectory = false;
                    } catch (Throwable th2) {
                        fileMetadata.isDirectory = false;
                        throw th2;
                    }
                }
                if (fileLock != null && (fileChannel2 = (FileChannel) fileLock.lockChannel) != null) {
                    try {
                        fileChannel2.close();
                        fileLock.lockChannel = null;
                    } catch (Throwable th3) {
                        fileLock.lockChannel = null;
                        throw th3;
                    }
                }
                reentrantLock.unlock();
                return sQLiteConnectionOpen;
            } catch (Throwable th4) {
                if (fileLock != null && (fileChannel = (FileChannel) fileLock.lockChannel) != null) {
                    try {
                        fileChannel.close();
                    } finally {
                        fileLock.lockChannel = null;
                    }
                }
                throw th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
        th = th5;
        try {
            if (z) {
                throw th;
            }
            throw new IllegalStateException("Unable to open database '" + str + "'. Was a proper path / name used in Room's database builder?", th);
        } catch (Throwable th6) {
            reentrantLock.unlock();
            throw th6;
        }
    }

    public FileLock(FileMetadata fileMetadata, SQLiteDriver sQLiteDriver) {
        sQLiteDriver.getClass();
        this.lockChannel = fileMetadata;
        this.lockFilename = sQLiteDriver;
    }

    public /* synthetic */ FileLock(Object obj, Object obj2) {
        this.lockFilename = obj;
        this.lockChannel = obj2;
    }
}
