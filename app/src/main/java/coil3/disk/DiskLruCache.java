package coil3.disk;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Latch;
import coil3.util.FileSystemsKt;
import com.metrolist.music.utils.SyncUtils;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.DeflaterSink;
import okio.FileSystem;
import okio.Okio__OkioKt;
import okio.Path;
import okio.Path$$ExternalSyntheticBUOutline0;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiskLruCache implements AutoCloseable {
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public final ContextScope cleanupScope;
    public boolean closed;
    public final Path directory;
    public final DiskLruCache$fileSystem$1 fileSystem;
    public boolean hasJournalErrors;
    public boolean initialized;
    public final Path journalFile;
    public final Path journalFileBackup;
    public final Path journalFileTmp;
    public RealBufferedSink journalWriter;
    public final Object lock;
    public final LinkedHashMap lruEntries;
    public final long maxSize;
    public boolean mostRecentRebuildFailed;
    public boolean mostRecentTrimFailed;
    public int operationsSinceRewrite;
    public long size;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Entry {
        public Latch currentEditor;
        public final String key;
        public int lockingSnapshotCount;
        public boolean readable;
        public boolean zombie;
        public final long[] lengths = new long[2];
        public final ArrayList cleanFiles = new ArrayList(2);
        public final ArrayList dirtyFiles = new ArrayList(2);

        public Entry(String str) {
            this.key = str;
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < 2; i++) {
                sb.append(i);
                this.cleanFiles.add(DiskLruCache.this.directory.resolve(sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(DiskLruCache.this.directory.resolve(sb.toString()));
                sb.setLength(length);
            }
        }

        public final Snapshot snapshot() {
            if (!this.readable || this.currentEditor != null || this.zombie) {
                return null;
            }
            ArrayList arrayList = this.cleanFiles;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                DiskLruCache diskLruCache = DiskLruCache.this;
                if (i >= size) {
                    this.lockingSnapshotCount++;
                    return diskLruCache.new Snapshot(this);
                }
                if (!diskLruCache.fileSystem.exists((Path) arrayList.get(i))) {
                    try {
                        diskLruCache.removeEntry(this);
                    } catch (IOException unused) {
                    }
                    return null;
                }
                i++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Snapshot implements AutoCloseable {
        public boolean closed;
        public final Entry entry;

        public Snapshot(Entry entry) {
            this.entry = entry;
        }

        @Override // java.lang.AutoCloseable
        public final void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache.lock) {
                Entry entry = this.entry;
                int i = entry.lockingSnapshotCount - 1;
                entry.lockingSnapshotCount = i;
                if (i == 0 && entry.zombie) {
                    diskLruCache.removeEntry(entry);
                }
            }
        }
    }

    public DiskLruCache(long j, FileSystem fileSystem, Path path) {
        this.directory = path;
        this.maxSize = j;
        if (j <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("maxSize <= 0");
            throw null;
        }
        this.journalFile = path.resolve("journal");
        this.journalFileTmp = path.resolve("journal.tmp");
        this.journalFileBackup = path.resolve("journal.bkp");
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        SupervisorJobImpl supervisorJobImplSupervisorJob$default = AwaitKt.SupervisorJob$default();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        CoroutineDispatcher.Key key = CoroutineDispatcher.Key;
        this.cleanupScope = AwaitKt.CoroutineScope(StringsKt__IndentKt.plus(supervisorJobImplSupervisorJob$default, defaultIoScheduler.limitedParallelism(1, null)));
        this.lock = new Object();
        this.fileSystem = new DiskLruCache$fileSystem$1(fileSystem);
    }

    public static void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.matches(str)) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("keys must match regex [a-z0-9_-]{1,120}: \"", str, "\""));
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        synchronized (this.lock) {
            try {
                if (this.initialized && !this.closed) {
                    for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[0])) {
                        Latch latch = entry.currentEditor;
                        if (latch != null) {
                            Entry entry2 = (Entry) latch.lock;
                            if (Intrinsics.areEqual(entry2.currentEditor, latch)) {
                                entry2.zombie = true;
                            }
                        }
                    }
                    trimToSize();
                    AwaitKt.cancel(this.cleanupScope, (CancellationException) null);
                    RealBufferedSink realBufferedSink = this.journalWriter;
                    realBufferedSink.getClass();
                    realBufferedSink.close();
                    this.journalWriter = null;
                    this.closed = true;
                    return;
                }
                this.closed = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0111 A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:8:0x0013, B:12:0x001a, B:14:0x0022, B:16:0x0032, B:24:0x0040, B:27:0x005a, B:29:0x0069, B:31:0x0079, B:33:0x0080, B:28:0x005e, B:37:0x00a0, B:39:0x00a7, B:42:0x00ac, B:44:0x00bd, B:47:0x00c2, B:52:0x00fd, B:54:0x0108, B:58:0x0111, B:48:0x00da, B:50:0x00ef, B:51:0x00fa, B:36:0x0090, B:61:0x0116, B:62:0x011d), top: B:65:0x0003 }] */
    public final void completeEdit(Latch latch, boolean z) {
        synchronized (this.lock) {
            Entry entry = (Entry) latch.lock;
            if (!Intrinsics.areEqual(entry.currentEditor, latch)) {
                throw new IllegalStateException("Check failed.");
            }
            if (!z || entry.zombie) {
                for (int i = 0; i < 2; i++) {
                    this.fileSystem.delete$1((Path) entry.dirtyFiles.get(i));
                }
            } else {
                for (int i2 = 0; i2 < 2; i2++) {
                    if (((boolean[]) latch.awaiters)[i2] && !this.fileSystem.exists((Path) entry.dirtyFiles.get(i2))) {
                        latch.complete(false);
                        return;
                    }
                }
                for (int i3 = 0; i3 < 2; i3++) {
                    Path path = (Path) entry.dirtyFiles.get(i3);
                    Path path2 = (Path) entry.cleanFiles.get(i3);
                    boolean zExists = this.fileSystem.exists(path);
                    DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.fileSystem;
                    if (zExists) {
                        diskLruCache$fileSystem$1.atomicMove(path, path2);
                    } else {
                        FileSystemsKt.createFile$default(diskLruCache$fileSystem$1, (Path) entry.cleanFiles.get(i3));
                    }
                    long j = entry.lengths[i3];
                    Long l = (Long) this.fileSystem.metadata(path2).size;
                    long jLongValue = l != null ? l.longValue() : 0L;
                    entry.lengths[i3] = jLongValue;
                    this.size = (this.size - j) + jLongValue;
                }
            }
            entry.currentEditor = null;
            if (entry.zombie) {
                removeEntry(entry);
                return;
            }
            this.operationsSinceRewrite++;
            RealBufferedSink realBufferedSink = this.journalWriter;
            realBufferedSink.getClass();
            if (z || entry.readable) {
                entry.readable = true;
                realBufferedSink.writeUtf8("CLEAN");
                realBufferedSink.writeByte(32);
                realBufferedSink.writeUtf8(entry.key);
                for (long j2 : entry.lengths) {
                    realBufferedSink.writeByte(32);
                    realBufferedSink.writeDecimalLong(j2);
                }
                realBufferedSink.writeByte(10);
            } else {
                this.lruEntries.remove(entry.key);
                realBufferedSink.writeUtf8("REMOVE");
                realBufferedSink.writeByte(32);
                realBufferedSink.writeUtf8(entry.key);
                realBufferedSink.writeByte(10);
            }
            realBufferedSink.flush();
            if (this.size > this.maxSize) {
                launchCleanup();
            } else if (this.operationsSinceRewrite >= 2000) {
                launchCleanup();
            }
        }
    }

    public final Latch edit(String str) {
        synchronized (this.lock) {
            if (this.closed) {
                throw new IllegalStateException("cache is closed");
            }
            validateKey(str);
            initialize();
            Entry entry = (Entry) this.lruEntries.get(str);
            if ((entry != null ? entry.currentEditor : null) != null) {
                return null;
            }
            if (entry != null && entry.lockingSnapshotCount != 0) {
                return null;
            }
            if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
                RealBufferedSink realBufferedSink = this.journalWriter;
                realBufferedSink.getClass();
                realBufferedSink.writeUtf8("DIRTY");
                realBufferedSink.writeByte(32);
                realBufferedSink.writeUtf8(str);
                realBufferedSink.writeByte(10);
                realBufferedSink.flush();
                if (this.hasJournalErrors) {
                    return null;
                }
                if (entry == null) {
                    entry = new Entry(str);
                    this.lruEntries.put(str, entry);
                }
                Latch latch = new Latch(this, entry);
                entry.currentEditor = latch;
                return latch;
            }
            launchCleanup();
            return null;
        }
    }

    public final Snapshot get(String str) {
        Snapshot snapshot;
        synchronized (this.lock) {
            if (this.closed) {
                throw new IllegalStateException("cache is closed");
            }
            validateKey(str);
            initialize();
            Entry entry = (Entry) this.lruEntries.get(str);
            if (entry != null && (snapshot = entry.snapshot()) != null) {
                boolean z = true;
                this.operationsSinceRewrite++;
                RealBufferedSink realBufferedSink = this.journalWriter;
                realBufferedSink.getClass();
                realBufferedSink.writeUtf8("READ");
                realBufferedSink.writeByte(32);
                realBufferedSink.writeUtf8(str);
                realBufferedSink.writeByte(10);
                realBufferedSink.flush();
                if (this.operationsSinceRewrite < 2000) {
                    z = false;
                }
                if (z) {
                    launchCleanup();
                }
                return snapshot;
            }
            return null;
        }
    }

    public final void initialize() {
        synchronized (this.lock) {
            try {
                if (this.initialized) {
                    return;
                }
                this.fileSystem.delete(this.journalFileTmp);
                if (this.fileSystem.exists(this.journalFileBackup)) {
                    boolean zExists = this.fileSystem.exists(this.journalFile);
                    DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.fileSystem;
                    Path path = this.journalFileBackup;
                    if (zExists) {
                        diskLruCache$fileSystem$1.delete(path);
                    } else {
                        diskLruCache$fileSystem$1.atomicMove(path, this.journalFile);
                    }
                }
                if (this.fileSystem.exists(this.journalFile)) {
                    try {
                        readJournal();
                        processJournal();
                        this.initialized = true;
                        return;
                    } catch (IOException unused) {
                        try {
                            close();
                            FileSystemsKt.deleteContents(this.fileSystem, this.directory);
                            this.closed = false;
                            writeJournal();
                            this.initialized = true;
                        } catch (Throwable th) {
                            this.closed = false;
                            throw th;
                        }
                    }
                }
                writeJournal();
                this.initialized = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void launchCleanup() {
        AwaitKt.launch$default(this.cleanupScope, null, null, new SyncUtils.AnonymousClass3(this, null, (byte) 5), 3);
    }

    public final void processJournal() {
        Iterator it = this.lruEntries.values().iterator();
        long j = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i = 0;
            if (entry.currentEditor == null) {
                while (i < 2) {
                    j += entry.lengths[i];
                    i++;
                }
            } else {
                entry.currentEditor = null;
                while (i < 2) {
                    Path path = (Path) entry.cleanFiles.get(i);
                    DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.fileSystem;
                    diskLruCache$fileSystem$1.delete$1(path);
                    diskLruCache$fileSystem$1.delete$1((Path) entry.dirtyFiles.get(i));
                    i++;
                }
                it.remove();
            }
        }
        this.size = j;
    }

    public final void readJournal() throws Throwable {
        DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.fileSystem;
        FileSystem fileSystem = diskLruCache$fileSystem$1.delegate;
        Path path = this.journalFile;
        Source source = fileSystem.source(path);
        source.getClass();
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        try {
            String utf8LineStrict = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict2 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict3 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict4 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict5 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            if (!"libcore.io.DiskLruCache".equals(utf8LineStrict) || !"1".equals(utf8LineStrict2) || !Intrinsics.areEqual(String.valueOf(3), utf8LineStrict3) || !Intrinsics.areEqual(String.valueOf(2), utf8LineStrict4) || utf8LineStrict5.length() > 0) {
                throw new IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict3 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + "]");
            }
            byte b = 0;
            int i = 0;
            while (true) {
                try {
                    readJournalLine(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
                    i++;
                } catch (EOFException unused) {
                    this.operationsSinceRewrite = i - this.lruEntries.size();
                    if (realBufferedSource.exhausted()) {
                        this.journalWriter = new RealBufferedSink(new DeflaterSink(diskLruCache$fileSystem$1.appendingSink(path), new DiskLruCache$$ExternalSyntheticLambda0(b, this)));
                    } else {
                        writeJournal();
                    }
                    try {
                        realBufferedSource.close();
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                realBufferedSource.close();
            } catch (Throwable th3) {
                ResultKt.addSuppressed(th, th3);
            }
        }
        if (th != null) {
            throw th;
        }
    }

    public final void readJournalLine(String str) throws IOException {
        String strSubstring;
        int iIndexOf$default = StringsKt.indexOf$default(str, ' ', 0, 6);
        if (iIndexOf$default == -1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3("unexpected journal line: ".concat(str));
            return;
        }
        int i = iIndexOf$default + 1;
        int iIndexOf$default2 = StringsKt.indexOf$default(str, ' ', i, 4);
        LinkedHashMap linkedHashMap = this.lruEntries;
        if (iIndexOf$default2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf$default == 6 && StringsKt__StringsJVMKt.startsWith(str, "REMOVE", false)) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf$default2);
        }
        Object entry = linkedHashMap.get(strSubstring);
        if (entry == null) {
            entry = new Entry(strSubstring);
            linkedHashMap.put(strSubstring, entry);
        }
        Entry entry2 = (Entry) entry;
        if (iIndexOf$default2 == -1 || iIndexOf$default != 5 || !StringsKt__StringsJVMKt.startsWith(str, "CLEAN", false)) {
            if (iIndexOf$default2 == -1 && iIndexOf$default == 5 && StringsKt__StringsJVMKt.startsWith(str, "DIRTY", false)) {
                entry2.currentEditor = new Latch(this, entry2);
                return;
            } else {
                if (iIndexOf$default2 == -1 && iIndexOf$default == 4 && StringsKt__StringsJVMKt.startsWith(str, "READ", false)) {
                    return;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3("unexpected journal line: ".concat(str));
                return;
            }
        }
        List listSplit$default = StringsKt.split$default(str.substring(iIndexOf$default2 + 1), new char[]{' '});
        entry2.readable = true;
        entry2.currentEditor = null;
        if (listSplit$default.size() != 2) {
            Path$$ExternalSyntheticBUOutline0.m(listSplit$default, "unexpected journal line: ");
            return;
        }
        try {
            int size = listSplit$default.size();
            for (int i2 = 0; i2 < size; i2++) {
                entry2.lengths[i2] = Long.parseLong((String) listSplit$default.get(i2));
            }
        } catch (NumberFormatException unused) {
            Path$$ExternalSyntheticBUOutline0.m(listSplit$default, "unexpected journal line: ");
        }
    }

    public final void removeEntry(Entry entry) {
        RealBufferedSink realBufferedSink;
        int i = entry.lockingSnapshotCount;
        String str = entry.key;
        if (i > 0 && (realBufferedSink = this.journalWriter) != null) {
            realBufferedSink.writeUtf8("DIRTY");
            realBufferedSink.writeByte(32);
            realBufferedSink.writeUtf8(str);
            realBufferedSink.writeByte(10);
            realBufferedSink.flush();
        }
        if (entry.lockingSnapshotCount > 0 || entry.currentEditor != null) {
            entry.zombie = true;
            return;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            this.fileSystem.delete$1((Path) entry.cleanFiles.get(i2));
            long j = this.size;
            long[] jArr = entry.lengths;
            this.size = j - jArr[i2];
            jArr[i2] = 0;
        }
        this.operationsSinceRewrite++;
        RealBufferedSink realBufferedSink2 = this.journalWriter;
        if (realBufferedSink2 != null) {
            realBufferedSink2.writeUtf8("REMOVE");
            realBufferedSink2.writeByte(32);
            realBufferedSink2.writeUtf8(str);
            realBufferedSink2.writeByte(10);
            realBufferedSink2.flush();
        }
        this.lruEntries.remove(str);
        if (this.operationsSinceRewrite >= 2000) {
            launchCleanup();
        }
    }

    public final void trimToSize() {
        while (this.size > this.maxSize) {
            for (Entry entry : this.lruEntries.values()) {
                if (!entry.zombie) {
                    removeEntry(entry);
                }
            }
            return;
        }
        this.mostRecentTrimFailed = false;
    }

    public final void writeJournal() {
        Throwable th;
        synchronized (this.lock) {
            try {
                RealBufferedSink realBufferedSink = this.journalWriter;
                if (realBufferedSink != null) {
                    realBufferedSink.close();
                }
                byte b = 0;
                RealBufferedSink realBufferedSinkBuffer = Okio__OkioKt.buffer(this.fileSystem.sink(this.journalFileTmp, false));
                try {
                    realBufferedSinkBuffer.writeUtf8("libcore.io.DiskLruCache");
                    realBufferedSinkBuffer.writeByte(10);
                    realBufferedSinkBuffer.writeUtf8("1");
                    realBufferedSinkBuffer.writeByte(10);
                    realBufferedSinkBuffer.writeDecimalLong(3L);
                    realBufferedSinkBuffer.writeByte(10);
                    realBufferedSinkBuffer.writeDecimalLong(2L);
                    realBufferedSinkBuffer.writeByte(10);
                    realBufferedSinkBuffer.writeByte(10);
                    for (Entry entry : this.lruEntries.values()) {
                        if (entry.currentEditor != null) {
                            realBufferedSinkBuffer.writeUtf8("DIRTY");
                            realBufferedSinkBuffer.writeByte(32);
                            realBufferedSinkBuffer.writeUtf8(entry.key);
                            realBufferedSinkBuffer.writeByte(10);
                        } else {
                            realBufferedSinkBuffer.writeUtf8("CLEAN");
                            realBufferedSinkBuffer.writeByte(32);
                            realBufferedSinkBuffer.writeUtf8(entry.key);
                            for (long j : entry.lengths) {
                                realBufferedSinkBuffer.writeByte(32);
                                realBufferedSinkBuffer.writeDecimalLong(j);
                            }
                            realBufferedSinkBuffer.writeByte(10);
                        }
                    }
                    try {
                        realBufferedSinkBuffer.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    try {
                        realBufferedSinkBuffer.close();
                    } catch (Throwable th4) {
                        ResultKt.addSuppressed(th3, th4);
                    }
                    th = th3;
                }
                if (th != null) {
                    throw th;
                }
                boolean zExists = this.fileSystem.exists(this.journalFile);
                DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.fileSystem;
                if (zExists) {
                    diskLruCache$fileSystem$1.atomicMove(this.journalFile, this.journalFileBackup);
                    this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    diskLruCache$fileSystem$1.atomicMove(this.journalFileTmp, this.journalFile);
                }
                this.journalWriter = new RealBufferedSink(new DeflaterSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$$ExternalSyntheticLambda0(b, this)));
                this.operationsSinceRewrite = 0;
                this.hasJournalErrors = false;
                this.mostRecentRebuildFailed = false;
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }
}
