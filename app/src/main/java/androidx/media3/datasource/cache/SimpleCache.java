package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.ConditionVariable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.compose.ui.platform.WeakCache;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.database.VersionTable;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.materialkolor.quantize.QuantizerWu;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;
import kotlin.io.FileSystemException;
import okhttp3.Cache;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleCache {
    public static final HashSet lockedCacheDirs = new HashSet();
    public final File cacheDir;
    public final QuantizerWu contentIndex;
    public final CacheEvictor evictor;
    public final CacheFileMetadataIndex fileIndex;
    public Cache$CacheException initializationException;
    public final HashMap listeners;
    public final Random random;
    public long totalSpace;
    public final boolean touchCacheSpans;
    public long uid;

    public SimpleCache(File file, CacheEvictor cacheEvictor, final StandaloneDatabaseProvider standaloneDatabaseProvider) {
        boolean zAdd;
        QuantizerWu quantizerWu = new QuantizerWu();
        quantizerWu.weights = new HashMap();
        quantizerWu.momentsR = new SparseArray();
        quantizerWu.momentsG = new SparseBooleanArray();
        quantizerWu.momentsB = new SparseBooleanArray();
        CachedContentIndex$Storage cachedContentIndex$Storage = new CachedContentIndex$Storage(standaloneDatabaseProvider) { // from class: androidx.media3.datasource.cache.CachedContentIndex$DatabaseStorage
            public static final String[] COLUMNS = {"id", "key", "metadata"};
            public final StandaloneDatabaseProvider databaseProvider;
            public String hexUid;
            public final SparseArray pendingUpdates = new SparseArray();
            public String tableName;

            {
                this.databaseProvider = standaloneDatabaseProvider;
            }

            public final void addOrUpdateRow(SQLiteDatabase sQLiteDatabase, CachedContent cachedContent) throws IOException {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                QuantizerWu.writeContentMetadata(cachedContent.metadata, new DataOutputStream(byteArrayOutputStream));
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", Integer.valueOf(cachedContent.id));
                contentValues.put("key", cachedContent.key);
                contentValues.put("metadata", byteArray);
                String str = this.tableName;
                str.getClass();
                sQLiteDatabase.replaceOrThrow(str, null, contentValues);
            }

            @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
            public final void delete() throws FileSystemException {
                StandaloneDatabaseProvider standaloneDatabaseProvider2 = this.databaseProvider;
                String str = this.hexUid;
                str.getClass();
                try {
                    String strConcat = "ExoPlayerCacheIndex".concat(str);
                    SQLiteDatabase writableDatabase = standaloneDatabaseProvider2.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        int i = VersionTable.$r8$clinit;
                        try {
                            if (Util.tableExists(writableDatabase, "ExoPlayerVersions")) {
                                writableDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(1), str});
                            }
                            writableDatabase.execSQL("DROP TABLE IF EXISTS ".concat(strConcat));
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (SQLException e) {
                            throw new FileSystemException(e);
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    throw new FileSystemException(e2);
                }
            }

            @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
            public final boolean exists() throws FileSystemException {
                try {
                    SQLiteDatabase readableDatabase = this.databaseProvider.getReadableDatabase();
                    String str = this.hexUid;
                    str.getClass();
                    return VersionTable.getVersion(readableDatabase, 1, str) != -1;
                } catch (SQLException e) {
                    throw new FileSystemException(e);
                }
            }

            @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
            public final void initialize(long j) {
                String hexString = Long.toHexString(j);
                this.hexUid = hexString;
                this.tableName = Fragment$5$$ExternalSyntheticOutline0.m("ExoPlayerCacheIndex", hexString);
            }

            public final void initializeTable(SQLiteDatabase sQLiteDatabase) throws FileSystemException {
                String str = this.hexUid;
                str.getClass();
                VersionTable.setVersion(sQLiteDatabase, 1, str, 1);
                String str2 = this.tableName;
                str2.getClass();
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(str2));
                sQLiteDatabase.execSQL("CREATE TABLE " + this.tableName + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
            }

            @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
            public final void load(HashMap map, SparseArray sparseArray) throws FileSystemException {
                StandaloneDatabaseProvider standaloneDatabaseProvider2 = this.databaseProvider;
                UtilsKt.checkState(this.pendingUpdates.size() == 0);
                try {
                    SQLiteDatabase readableDatabase = standaloneDatabaseProvider2.getReadableDatabase();
                    String str = this.hexUid;
                    str.getClass();
                    if (VersionTable.getVersion(readableDatabase, 1, str) != 1) {
                        SQLiteDatabase writableDatabase = standaloneDatabaseProvider2.getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            initializeTable(writableDatabase);
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    }
                    SQLiteDatabase readableDatabase2 = standaloneDatabaseProvider2.getReadableDatabase();
                    String str2 = this.tableName;
                    str2.getClass();
                    Cursor cursorQuery = readableDatabase2.query(str2, COLUMNS, null, null, null, null, null);
                    while (cursorQuery.moveToNext()) {
                        try {
                            int i = cursorQuery.getInt(0);
                            String string = cursorQuery.getString(1);
                            string.getClass();
                            map.put(string, new CachedContent(i, string, QuantizerWu.readContentMetadata(new DataInputStream(new ByteArrayInputStream(cursorQuery.getBlob(2))))));
                            sparseArray.put(i, string);
                        } catch (Throwable th2) {
                            if (cursorQuery == null) {
                                throw th2;
                            }
                            try {
                                cursorQuery.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                                throw th2;
                            }
                        }
                    }
                    cursorQuery.close();
                } catch (SQLiteException e) {
                    map.clear();
                    sparseArray.clear();
                    throw new FileSystemException(e);
                }
            }

            @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
            public final void onRemove(CachedContent cachedContent, boolean z) {
                int i = cachedContent.id;
                SparseArray sparseArray = this.pendingUpdates;
                if (z) {
                    sparseArray.delete(i);
                } else {
                    sparseArray.put(i, null);
                }
            }

            @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
            public final void onUpdate(CachedContent cachedContent) {
                this.pendingUpdates.put(cachedContent.id, cachedContent);
            }

            @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
            public final void storeFully(HashMap map) throws FileSystemException {
                try {
                    SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        initializeTable(writableDatabase);
                        Iterator it = map.values().iterator();
                        while (it.hasNext()) {
                            addOrUpdateRow(writableDatabase, (CachedContent) it.next());
                        }
                        writableDatabase.setTransactionSuccessful();
                        this.pendingUpdates.clear();
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } catch (SQLException e) {
                    throw new FileSystemException(e);
                }
            }

            @Override // androidx.media3.datasource.cache.CachedContentIndex$Storage
            public final void storeIncremental(HashMap map) throws FileSystemException {
                SparseArray sparseArray = this.pendingUpdates;
                if (sparseArray.size() == 0) {
                    return;
                }
                try {
                    SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        try {
                            CachedContent cachedContent = (CachedContent) sparseArray.valueAt(i);
                            if (cachedContent == null) {
                                int iKeyAt = sparseArray.keyAt(i);
                                String str = this.tableName;
                                str.getClass();
                                writableDatabase.delete(str, "id = ?", new String[]{Integer.toString(iKeyAt)});
                            } else {
                                addOrUpdateRow(writableDatabase, cachedContent);
                            }
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    sparseArray.clear();
                    writableDatabase.endTransaction();
                } catch (SQLException e) {
                    throw new FileSystemException(e);
                }
            }
        };
        File file2 = new File(file, "cached_content_index.exi");
        Cache.RealCacheRequest realCacheRequest = new Cache.RealCacheRequest();
        realCacheRequest.editor = null;
        realCacheRequest.cacheOut = null;
        realCacheRequest.body = new WeakCache(file2);
        quantizerWu.moments = cachedContentIndex$Storage;
        quantizerWu.cubes = realCacheRequest;
        CacheFileMetadataIndex cacheFileMetadataIndex = new CacheFileMetadataIndex(standaloneDatabaseProvider);
        synchronized (SimpleCache.class) {
            zAdd = lockedCacheDirs.add(file.getAbsoluteFile());
        }
        if (!zAdd) {
            PathKt$$ExternalSyntheticBUOutline0.m$1(file, "Another SimpleCache instance uses the folder: ");
            throw null;
        }
        this.cacheDir = file;
        this.evictor = cacheEvictor;
        this.contentIndex = quantizerWu;
        this.fileIndex = cacheFileMetadataIndex;
        this.listeners = new HashMap();
        this.random = new Random();
        this.touchCacheSpans = cacheEvictor.requiresCacheSpanTouches();
        this.uid = -1L;
        final ConditionVariable conditionVariable = new ConditionVariable();
        new Thread() { // from class: androidx.media3.datasource.cache.SimpleCache.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super("ExoPlayer:SimpleCacheInit");
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                synchronized (SimpleCache.this) {
                    conditionVariable.open();
                    SimpleCache.this.initialize();
                    SimpleCache.this.evictor.getClass();
                }
            }
        }.start();
        conditionVariable.block();
    }

    public static void createCacheDirectories(File file) throws Cache$CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        Log.e("SimpleCache", str);
        throw new Cache$CacheException(str);
    }

    public static long createUid(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, Long.toString(jAbs, 16) + ".uid");
        if (file2.createNewFile()) {
            return jAbs;
        }
        Path$$ExternalSyntheticBUOutline0.m(file2, "Failed to create UID file: ");
        return 0L;
    }

    public final void addSpan(SimpleCacheSpan simpleCacheSpan) {
        String str = simpleCacheSpan.key;
        this.contentIndex.getOrAdd(str).cachedSpans.add(simpleCacheSpan);
        this.totalSpace += simpleCacheSpan.length;
        ArrayList arrayList = (ArrayList) this.listeners.get(str);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((CacheEvictor) arrayList.get(size)).onSpanAdded(this, simpleCacheSpan);
            }
        }
        this.evictor.onSpanAdded(this, simpleCacheSpan);
    }

    public final synchronized void applyContentMetadataMutations(String str, CacheFileMetadataIndex cacheFileMetadataIndex) {
        checkInitialization();
        QuantizerWu quantizerWu = this.contentIndex;
        CachedContent orAdd = quantizerWu.getOrAdd(str);
        DefaultContentMetadata defaultContentMetadata = orAdd.metadata;
        DefaultContentMetadata defaultContentMetadataCopyWithMutationsApplied = defaultContentMetadata.copyWithMutationsApplied(cacheFileMetadataIndex);
        orAdd.metadata = defaultContentMetadataCopyWithMutationsApplied;
        if (!defaultContentMetadataCopyWithMutationsApplied.equals(defaultContentMetadata)) {
            ((CachedContentIndex$Storage) quantizerWu.moments).onUpdate(orAdd);
        }
        try {
            this.contentIndex.store();
        } catch (IOException e) {
            throw new Cache$CacheException(e);
        }
    }

    public final synchronized void checkInitialization() {
        Cache$CacheException cache$CacheException = this.initializationException;
        if (cache$CacheException != null) {
            throw cache$CacheException;
        }
    }

    public final synchronized long getCacheSpace() {
        return this.totalSpace;
    }

    public final synchronized long getCachedLength(long j, long j2, String str) {
        CachedContent cachedContent;
        if (j2 == -1) {
            j2 = Long.MAX_VALUE;
        }
        cachedContent = this.contentIndex.get(str);
        return cachedContent != null ? cachedContent.getCachedBytesLength(j, j2) : -j2;
    }

    public final synchronized DefaultContentMetadata getContentMetadata(String str) {
        CachedContent cachedContent;
        cachedContent = this.contentIndex.get(str);
        return cachedContent != null ? cachedContent.metadata : DefaultContentMetadata.EMPTY;
    }

    public final synchronized HashSet getKeys() {
        return new HashSet(((HashMap) this.contentIndex.weights).keySet());
    }

    public final void initialize() {
        long jCreateUid;
        QuantizerWu quantizerWu = this.contentIndex;
        File file = this.cacheDir;
        if (!file.exists()) {
            try {
                createCacheDirectories(file);
            } catch (Cache$CacheException e) {
                this.initializationException = e;
                return;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + file;
            Log.e("SimpleCache", str);
            this.initializationException = new Cache$CacheException(str);
            return;
        }
        int length = fileArrListFiles.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                jCreateUid = -1;
                break;
            }
            File file2 = fileArrListFiles[i];
            String name = file2.getName();
            if (name.endsWith(".uid")) {
                try {
                    jCreateUid = Long.parseLong(name.substring(0, name.indexOf(46)), 16);
                    break;
                } catch (NumberFormatException unused) {
                    Log.e("SimpleCache", "Malformed UID file: " + file2);
                    file2.delete();
                }
            }
            i++;
        }
        this.uid = jCreateUid;
        if (jCreateUid == -1) {
            try {
                jCreateUid = createUid(file);
                this.uid = jCreateUid;
            } catch (IOException e2) {
                String str2 = "Failed to create cache UID: " + file;
                Log.e("SimpleCache", str2, e2);
                this.initializationException = new Cache$CacheException(str2, e2);
                return;
            }
        }
        try {
            quantizerWu.initialize(jCreateUid);
            CacheFileMetadataIndex cacheFileMetadataIndex = this.fileIndex;
            if (cacheFileMetadataIndex != null) {
                cacheFileMetadataIndex.initialize(this.uid);
                HashMap all = cacheFileMetadataIndex.getAll();
                loadDirectory(file, true, fileArrListFiles, all);
                cacheFileMetadataIndex.removeAll(all.keySet());
            } else {
                loadDirectory(file, true, fileArrListFiles, null);
            }
            UnmodifiableIterator it = ImmutableSet.copyOf((Collection) ((HashMap) quantizerWu.weights).keySet()).iterator();
            while (it.hasNext()) {
                quantizerWu.maybeRemove((String) it.next());
            }
            try {
                quantizerWu.store();
            } catch (IOException e3) {
                Log.e("SimpleCache", "Storing index file failed", e3);
            }
        } catch (IOException e4) {
            String str3 = "Failed to initialize cache indices: " + file;
            Log.e("SimpleCache", str3, e4);
            this.initializationException = new Cache$CacheException(str3, e4);
        }
    }

    public final synchronized boolean isCached(long j, long j2, String str) {
        CachedContent cachedContent;
        cachedContent = this.contentIndex.get(str);
        return cachedContent != null && cachedContent.getCachedBytesLength(j, j2) >= j2;
    }

    public final void loadDirectory(File file, boolean z, File[] fileArr, Map map) {
        long j;
        long j2;
        if (fileArr == null || fileArr.length == 0) {
            if (z) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z && name.indexOf(46) == -1) {
                loadDirectory(file2, false, file2.listFiles(), map);
            } else if (!z || (!name.startsWith("cached_content_index.exi") && !name.endsWith(".uid"))) {
                CacheFileMetadata cacheFileMetadata = map != null ? (CacheFileMetadata) map.remove(name) : null;
                if (cacheFileMetadata != null) {
                    j = cacheFileMetadata.length;
                    j2 = cacheFileMetadata.lastTouchTimestamp;
                } else {
                    j = -1;
                    j2 = -9223372036854775807L;
                }
                SimpleCacheSpan simpleCacheSpanCreateCacheEntry = SimpleCacheSpan.createCacheEntry(file2, j, j2, this.contentIndex);
                if (simpleCacheSpanCreateCacheEntry != null) {
                    addSpan(simpleCacheSpanCreateCacheEntry);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public final synchronized void releaseHoleSpan(SimpleCacheSpan simpleCacheSpan) {
        CachedContent cachedContent = this.contentIndex.get(simpleCacheSpan.key);
        cachedContent.getClass();
        long j = simpleCacheSpan.position;
        ArrayList arrayList = cachedContent.lockedRanges;
        for (int i = 0; i < arrayList.size(); i++) {
            if (((CachedContent.Range) arrayList.get(i)).position == j) {
                arrayList.remove(i);
                this.contentIndex.maybeRemove(cachedContent.key);
                notifyAll();
            }
        }
        throw new IllegalStateException();
    }

    public final synchronized void removeResource(String str) {
        CachedContent cachedContent;
        synchronized (this) {
            try {
                cachedContent = this.contentIndex.get(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = ((cachedContent == null || cachedContent.cachedSpans.isEmpty()) ? new TreeSet() : new TreeSet((Collection) cachedContent.cachedSpans)).iterator();
        while (it.hasNext()) {
            removeSpanInternal((SimpleCacheSpan) it.next());
        }
    }

    public final void removeSpanInternal(SimpleCacheSpan simpleCacheSpan) {
        String str = simpleCacheSpan.key;
        File file = simpleCacheSpan.file;
        QuantizerWu quantizerWu = this.contentIndex;
        CachedContent cachedContent = quantizerWu.get(str);
        if (cachedContent == null || !cachedContent.cachedSpans.remove(simpleCacheSpan)) {
            return;
        }
        if (file != null) {
            file.delete();
        }
        this.totalSpace -= simpleCacheSpan.length;
        CacheFileMetadataIndex cacheFileMetadataIndex = this.fileIndex;
        if (cacheFileMetadataIndex != null) {
            file.getClass();
            String name = file.getName();
            try {
                ((String) cacheFileMetadataIndex.tableName).getClass();
                try {
                    ((StandaloneDatabaseProvider) cacheFileMetadataIndex.databaseProvider).getWritableDatabase().delete((String) cacheFileMetadataIndex.tableName, "name = ?", new String[]{name});
                } catch (SQLException e) {
                    throw new FileSystemException(e);
                }
            } catch (IOException unused) {
                Format$$ExternalSyntheticOutline0.m("Failed to remove file index entry for: ", name, "SimpleCache");
            }
        }
        quantizerWu.maybeRemove(cachedContent.key);
        ArrayList arrayList = (ArrayList) this.listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((CacheEvictor) arrayList.get(size)).onSpanRemoved(simpleCacheSpan);
            }
        }
        this.evictor.onSpanRemoved(simpleCacheSpan);
    }

    public final void removeStaleSpans() {
        ArrayList arrayList = new ArrayList();
        Iterator it = Collections.unmodifiableCollection(((HashMap) this.contentIndex.weights).values()).iterator();
        while (it.hasNext()) {
            for (SimpleCacheSpan simpleCacheSpan : ((CachedContent) it.next()).cachedSpans) {
                File file = simpleCacheSpan.file;
                file.getClass();
                if (file.length() != simpleCacheSpan.length) {
                    arrayList.add(simpleCacheSpan);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            removeSpanInternal((SimpleCacheSpan) arrayList.get(i));
        }
    }

    public final synchronized SimpleCacheSpan startReadWriteNonBlocking(long j, long j2, String str) {
        long j3;
        SimpleCacheSpan span;
        checkInitialization();
        CachedContent cachedContent = this.contentIndex.get(str);
        if (cachedContent != null) {
            j3 = j;
            while (true) {
                span = cachedContent.getSpan(j3, j2);
                if (!span.isCached) {
                    break;
                }
                File file = span.file;
                file.getClass();
                if (file.length() == span.length) {
                    break;
                }
                removeStaleSpans();
            }
        } else {
            j3 = j;
            span = new SimpleCacheSpan(str, j3, j2, -9223372036854775807L, null);
        }
        if (span.isCached) {
            return touchSpan(str, span);
        }
        CachedContent orAdd = this.contentIndex.getOrAdd(str);
        long j4 = span.length;
        ArrayList arrayList = orAdd.lockedRanges;
        for (int i = 0; i < arrayList.size(); i++) {
            CachedContent.Range range = (CachedContent.Range) arrayList.get(i);
            long j5 = range.position;
            if (j5 <= j3) {
                long j6 = range.length;
                if (j6 == -1 || j5 + j6 > j3) {
                    return null;
                }
            } else {
                if (j4 == -1 || j3 + j4 > j5) {
                    return null;
                }
            }
        }
        arrayList.add(new CachedContent.Range(j3, j4));
        return span;
    }

    public final SimpleCacheSpan touchSpan(String str, SimpleCacheSpan simpleCacheSpan) {
        boolean z;
        File file;
        File file2 = simpleCacheSpan.file;
        if (!this.touchCacheSpans) {
            return simpleCacheSpan;
        }
        file2.getClass();
        String name = file2.getName();
        long j = simpleCacheSpan.length;
        long jCurrentTimeMillis = System.currentTimeMillis();
        CacheFileMetadataIndex cacheFileMetadataIndex = this.fileIndex;
        if (cacheFileMetadataIndex != null) {
            try {
                cacheFileMetadataIndex.set(j, jCurrentTimeMillis, name);
            } catch (IOException unused) {
                jCurrentTimeMillis = jCurrentTimeMillis;
                Log.w("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z = false;
        } else {
            z = true;
        }
        CachedContent cachedContent = this.contentIndex.get(str);
        cachedContent.getClass();
        TreeSet treeSet = cachedContent.cachedSpans;
        UtilsKt.checkState(treeSet.remove(simpleCacheSpan));
        file2.getClass();
        if (z) {
            File parentFile = file2.getParentFile();
            parentFile.getClass();
            File cacheFile = SimpleCacheSpan.getCacheFile(parentFile, cachedContent.id, simpleCacheSpan.position, jCurrentTimeMillis);
            if (file2.renameTo(cacheFile)) {
                file = cacheFile;
            } else {
                Log.w("CachedContent", "Failed to rename " + file2 + " to " + cacheFile);
                file = file2;
            }
        } else {
            file = file2;
        }
        UtilsKt.checkState(simpleCacheSpan.isCached);
        SimpleCacheSpan simpleCacheSpan2 = new SimpleCacheSpan(simpleCacheSpan.key, simpleCacheSpan.position, simpleCacheSpan.length, jCurrentTimeMillis, file);
        treeSet.add(simpleCacheSpan2);
        ArrayList arrayList = (ArrayList) this.listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((CacheEvictor) arrayList.get(size)).onSpanTouched(this, simpleCacheSpan, simpleCacheSpan2);
            }
        }
        this.evictor.onSpanTouched(this, simpleCacheSpan, simpleCacheSpan2);
        return simpleCacheSpan2;
    }
}
