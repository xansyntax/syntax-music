package okhttp3.internal.cache;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Latch;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.websocket.PingPongKt$$ExternalSyntheticLambda0;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.ws.RealWebSocket;
import okio.FileSystem;
import okio.ForwardingSource;
import okio.Okio__OkioKt;
import okio.Path;
import okio.Path$$ExternalSyntheticBUOutline0;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DiskLruCache implements Closeable, Flushable {
    public boolean civilizedFileSystem;
    public final TaskQueue cleanupQueue;
    public boolean closed;
    public final Path directory;
    public final DiskLruCache$fileSystem$1 fileSystem;
    public boolean hasJournalErrors;
    public boolean initialized;
    public final Path journalFile;
    public final Path journalFileBackup;
    public final Path journalFileTmp;
    public RealBufferedSink journalWriter;
    public boolean mostRecentRebuildFailed;
    public boolean mostRecentTrimFailed;
    public long nextSequenceNumber;
    public int redundantOpCount;
    public long size;
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final String REMOVE = "REMOVE";
    public static final String READ = "READ";
    public final int maxSize = 52428800;
    public final LinkedHashMap lruEntries = new LinkedHashMap(0, 0.75f, true);
    public final RealWebSocket.WriterTask cleanupTask = new RealWebSocket.WriterTask(1, this, IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder(), _UtilJvmKt.okHttpName, " Cache"));

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Entry {
        public final ArrayList cleanFiles;
        public Latch currentEditor;
        public final ArrayList dirtyFiles;
        public final String key;
        public final long[] lengths;
        public int lockingSourceCount;
        public boolean readable;
        public long sequenceNumber;
        public final /* synthetic */ DiskLruCache this$0;
        public boolean zombie;

        public Entry(DiskLruCache diskLruCache, String str) {
            str.getClass();
            this.this$0 = diskLruCache;
            this.key = str;
            diskLruCache.getClass();
            this.lengths = new long[2];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < 2; i++) {
                sb.append(i);
                this.cleanFiles.add(this.this$0.directory.resolve(sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(this.this$0.directory.resolve(sb.toString()));
                sb.setLength(length);
            }
        }

        public final Snapshot snapshot$okhttp() {
            TimeZone timeZone = _UtilJvmKt.UTC;
            if (!this.readable) {
                return null;
            }
            final DiskLruCache diskLruCache = this.this$0;
            if (!diskLruCache.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.lengths.clone();
            int i = 0;
            for (int i2 = 0; i2 < 2; i2++) {
                try {
                    final Source source = diskLruCache.fileSystem.source((Path) this.cleanFiles.get(i2));
                    if (!diskLruCache.civilizedFileSystem) {
                        this.lockingSourceCount++;
                        source = new ForwardingSource(source) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1
                            public boolean closed;

                            @Override // okio.ForwardingSource, java.io.Closeable, java.lang.AutoCloseable
                            public final void close() {
                                super.close();
                                if (this.closed) {
                                    return;
                                }
                                this.closed = true;
                                DiskLruCache diskLruCache2 = diskLruCache;
                                DiskLruCache.Entry entry = this;
                                synchronized (diskLruCache2) {
                                    int i3 = entry.lockingSourceCount - 1;
                                    entry.lockingSourceCount = i3;
                                    if (i3 == 0 && entry.zombie) {
                                        diskLruCache2.removeEntry$okhttp(entry);
                                    }
                                }
                            }
                        };
                    }
                    arrayList.add(source);
                } catch (FileNotFoundException unused) {
                    int size = arrayList.size();
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        _UtilCommonKt.closeQuietly((Source) obj);
                    }
                    try {
                        diskLruCache.removeEntry$okhttp(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            }
            return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Snapshot implements Closeable {
        public final String key;
        public final long sequenceNumber;
        public final ArrayList sources;
        public final /* synthetic */ DiskLruCache this$0;

        public Snapshot(DiskLruCache diskLruCache, String str, long j, ArrayList arrayList, long[] jArr) {
            str.getClass();
            jArr.getClass();
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j;
            this.sources = arrayList;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            ArrayList arrayList = this.sources;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                _UtilCommonKt.closeQuietly((Source) obj);
            }
        }
    }

    public DiskLruCache(FileSystem fileSystem, Path path, TaskRunner taskRunner) {
        this.directory = path;
        this.fileSystem = new DiskLruCache$fileSystem$1(fileSystem);
        this.cleanupQueue = taskRunner.newQueue();
        this.journalFile = path.resolve("journal");
        this.journalFileTmp = path.resolve("journal.tmp");
        this.journalFileBackup = path.resolve("journal.bkp");
    }

    public static void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.matches(str)) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Format$$ExternalSyntheticOutline0.m('\"', "keys must match regex [a-z0-9_-]{1,120}: \"", str));
    }

    public final synchronized void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.initialized && !this.closed) {
                Collection collectionValues = this.lruEntries.values();
                collectionValues.getClass();
                for (Entry entry : (Entry[]) collectionValues.toArray(new Entry[0])) {
                    entry.getClass();
                    Latch latch = entry.currentEditor;
                    if (latch != null) {
                        latch.detach$okhttp();
                    }
                }
                trimToSize();
                RealBufferedSink realBufferedSink = this.journalWriter;
                if (realBufferedSink != null) {
                    _UtilCommonKt.closeQuietly(realBufferedSink);
                }
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void completeEdit$okhttp(Latch latch, boolean z) {
        Entry entry = (Entry) latch.lock;
        if (!Intrinsics.areEqual(entry.currentEditor, latch)) {
            throw new IllegalStateException("Check failed.");
        }
        if (z && !entry.readable) {
            for (int i = 0; i < 2; i++) {
                boolean[] zArr = (boolean[]) latch.awaiters;
                zArr.getClass();
                if (!zArr[i]) {
                    latch.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!this.fileSystem.exists((Path) entry.dirtyFiles.get(i))) {
                    latch.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < 2; i2++) {
            Path path = (Path) entry.dirtyFiles.get(i2);
            if (!z || entry.zombie) {
                _UtilCommonKt.deleteIfExists(this.fileSystem, path);
            } else if (this.fileSystem.exists(path)) {
                Path path2 = (Path) entry.cleanFiles.get(i2);
                this.fileSystem.atomicMove(path, path2);
                long j = entry.lengths[i2];
                Long l = (Long) this.fileSystem.metadata(path2).size;
                long jLongValue = l != null ? l.longValue() : 0L;
                entry.lengths[i2] = jLongValue;
                this.size = (this.size - j) + jLongValue;
            }
        }
        entry.currentEditor = null;
        if (entry.zombie) {
            removeEntry$okhttp(entry);
            return;
        }
        this.redundantOpCount++;
        RealBufferedSink realBufferedSink = this.journalWriter;
        realBufferedSink.getClass();
        if (entry.readable || z) {
            entry.readable = true;
            realBufferedSink.writeUtf8(CLEAN);
            realBufferedSink.writeByte(32);
            realBufferedSink.writeUtf8(entry.key);
            for (long j2 : entry.lengths) {
                realBufferedSink.writeByte(32);
                realBufferedSink.writeDecimalLong(j2);
            }
            realBufferedSink.writeByte(10);
            if (z) {
                long j3 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j3;
                entry.sequenceNumber = j3;
            }
        } else {
            this.lruEntries.remove(entry.key);
            realBufferedSink.writeUtf8(REMOVE);
            realBufferedSink.writeByte(32);
            realBufferedSink.writeUtf8(entry.key);
            realBufferedSink.writeByte(10);
        }
        realBufferedSink.flush();
        if (this.size > this.maxSize || journalRebuildRequired()) {
            this.cleanupQueue.schedule(this.cleanupTask, 0L);
        }
    }

    public final synchronized Latch edit(long j, String str) {
        str.getClass();
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (j != -1 && (entry == null || entry.sequenceNumber != j)) {
            return null;
        }
        if ((entry != null ? entry.currentEditor : null) != null) {
            return null;
        }
        if (entry != null && entry.lockingSourceCount != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            RealBufferedSink realBufferedSink = this.journalWriter;
            realBufferedSink.getClass();
            realBufferedSink.writeUtf8(DIRTY);
            realBufferedSink.writeByte(32);
            realBufferedSink.writeUtf8(str);
            realBufferedSink.writeByte(10);
            realBufferedSink.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(this, str);
                this.lruEntries.put(str, entry);
            }
            Latch latch = new Latch(this, entry);
            entry.currentEditor = latch;
            return latch;
        }
        this.cleanupQueue.schedule(this.cleanupTask, 0L);
        return null;
    }

    @Override // java.io.Flushable
    public final synchronized void flush() {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            RealBufferedSink realBufferedSink = this.journalWriter;
            realBufferedSink.getClass();
            realBufferedSink.flush();
        }
    }

    public final synchronized Snapshot get(String str) {
        str.getClass();
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        Snapshot snapshotSnapshot$okhttp = entry.snapshot$okhttp();
        if (snapshotSnapshot$okhttp == null) {
            return null;
        }
        this.redundantOpCount++;
        RealBufferedSink realBufferedSink = this.journalWriter;
        realBufferedSink.getClass();
        realBufferedSink.writeUtf8(READ);
        realBufferedSink.writeByte(32);
        realBufferedSink.writeUtf8(str);
        realBufferedSink.writeByte(10);
        if (journalRebuildRequired()) {
            this.cleanupQueue.schedule(this.cleanupTask, 0L);
        }
        return snapshotSnapshot$okhttp;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0066 A[Catch: all -> 0x0027, TRY_ENTER, TryCatch #3 {all -> 0x0027, blocks: (B:4:0x0003, B:8:0x000b, B:10:0x0015, B:13:0x0023, B:16:0x002a, B:17:0x002f, B:38:0x006c, B:40:0x0078, B:50:0x00bb, B:44:0x0083, B:46:0x00b4, B:48:0x00b8, B:49:0x00ba, B:37:0x0066, B:53:0x00c2, B:28:0x0055, B:25:0x0050, B:45:0x00aa, B:19:0x0041), top: B:61:0x0003, inners: #1, #2, #4, #8 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00c2 A[Catch: all -> 0x0027, TRY_ENTER, TryCatch #3 {all -> 0x0027, blocks: (B:4:0x0003, B:8:0x000b, B:10:0x0015, B:13:0x0023, B:16:0x002a, B:17:0x002f, B:38:0x006c, B:40:0x0078, B:50:0x00bb, B:44:0x0083, B:46:0x00b4, B:48:0x00b8, B:49:0x00ba, B:37:0x0066, B:53:0x00c2, B:28:0x0055, B:25:0x0050, B:45:0x00aa, B:19:0x0041), top: B:61:0x0003, inners: #1, #2, #4, #8 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final synchronized void initialize() {
        boolean z;
        try {
            TimeZone timeZone = _UtilJvmKt.UTC;
            if (this.initialized) {
                return;
            }
            if (this.fileSystem.exists(this.journalFileBackup)) {
                boolean zExists = this.fileSystem.exists(this.journalFile);
                DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.fileSystem;
                Path path = this.journalFileBackup;
                if (zExists) {
                    diskLruCache$fileSystem$1.delete$1(path);
                } else {
                    diskLruCache$fileSystem$1.atomicMove(path, this.journalFile);
                }
            }
            DiskLruCache$fileSystem$1 diskLruCache$fileSystem$2 = this.fileSystem;
            Path path2 = this.journalFileBackup;
            byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
            diskLruCache$fileSystem$2.getClass();
            path2.getClass();
            Sink sink = diskLruCache$fileSystem$2.sink(path2, false);
            try {
                diskLruCache$fileSystem$2.delegate.delete(path2);
                if (sink != null) {
                    try {
                        sink.close();
                    } catch (Throwable unused) {
                    }
                }
                z = true;
            } catch (IOException unused2) {
                if (sink != null) {
                    try {
                        sink.close();
                    } catch (Throwable th) {
                        th = th;
                        th = th;
                        if (th != null) {
                            throw th;
                        }
                        diskLruCache$fileSystem$2.delegate.delete(path2);
                        z = false;
                        this.civilizedFileSystem = z;
                        if (this.fileSystem.exists(this.journalFile)) {
                            try {
                                readJournal();
                                processJournal();
                                this.initialized = true;
                                return;
                            } catch (IOException e) {
                                Platform platform = Platform.platform;
                                Platform.platform.log(5, "DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", e);
                                try {
                                    close();
                                    _UtilCommonKt.deleteContents(this.fileSystem, this.directory);
                                    this.closed = false;
                                    rebuildJournal$okhttp();
                                    this.initialized = true;
                                } catch (Throwable th2) {
                                    this.closed = false;
                                    throw th2;
                                }
                            }
                        }
                        rebuildJournal$okhttp();
                        this.initialized = true;
                    }
                }
                th = null;
                th = th;
                if (th != null) {
                    throw th;
                }
                diskLruCache$fileSystem$2.delegate.delete(path2);
                z = false;
            } catch (Throwable th3) {
                th = th3;
                if (sink != null) {
                    try {
                        sink.close();
                    } catch (Throwable th4) {
                        ResultKt.addSuppressed(th, th4);
                    }
                }
                if (th != null) {
                    throw th;
                }
                diskLruCache$fileSystem$2.delegate.delete(path2);
                z = false;
                this.civilizedFileSystem = z;
                if (this.fileSystem.exists(this.journalFile)) {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                }
                rebuildJournal$okhttp();
                this.initialized = true;
            }
            this.civilizedFileSystem = z;
            if (this.fileSystem.exists(this.journalFile)) {
                readJournal();
                processJournal();
                this.initialized = true;
                return;
            }
            rebuildJournal$okhttp();
            this.initialized = true;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public final boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    public final void processJournal() {
        Path path = this.journalFileTmp;
        DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.fileSystem;
        _UtilCommonKt.deleteIfExists(diskLruCache$fileSystem$1, path);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            Entry entry = (Entry) next;
            int i = 0;
            if (entry.currentEditor == null) {
                while (i < 2) {
                    this.size += entry.lengths[i];
                    i++;
                }
            } else {
                entry.currentEditor = null;
                while (i < 2) {
                    _UtilCommonKt.deleteIfExists(diskLruCache$fileSystem$1, (Path) entry.cleanFiles.get(i));
                    _UtilCommonKt.deleteIfExists(diskLruCache$fileSystem$1, (Path) entry.dirtyFiles.get(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public final void readJournal() throws Throwable {
        DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.fileSystem;
        Path path = this.journalFile;
        Source source = diskLruCache$fileSystem$1.source(path);
        source.getClass();
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        try {
            String utf8LineStrict = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict2 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict3 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict4 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            String utf8LineStrict5 = realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE);
            if (!"libcore.io.DiskLruCache".equals(utf8LineStrict) || !"1".equals(utf8LineStrict2) || !Intrinsics.areEqual(String.valueOf(201105), utf8LineStrict3) || !Intrinsics.areEqual(String.valueOf(2), utf8LineStrict4) || utf8LineStrict5.length() > 0) {
                throw new IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + ']');
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(realBufferedSource.readUtf8LineStrict(Long.MAX_VALUE));
                    i++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    if (realBufferedSource.exhausted()) {
                        RealBufferedSink realBufferedSink = this.journalWriter;
                        if (realBufferedSink != null) {
                            _UtilCommonKt.closeQuietly(realBufferedSink);
                        }
                        diskLruCache$fileSystem$1.getClass();
                        path.getClass();
                        this.journalWriter = new RealBufferedSink(new FaultHidingSink(diskLruCache$fileSystem$1.appendingSink(path), new PingPongKt$$ExternalSyntheticLambda0((byte) 13, (Object) this)));
                    } else {
                        rebuildJournal$okhttp();
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
            String str2 = REMOVE;
            if (iIndexOf$default == str2.length() && StringsKt__StringsJVMKt.startsWith(str, str2, false)) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf$default2);
        }
        Entry entry = (Entry) linkedHashMap.get(strSubstring);
        if (entry == null) {
            entry = new Entry(this, strSubstring);
            linkedHashMap.put(strSubstring, entry);
        }
        if (iIndexOf$default2 != -1) {
            String str3 = CLEAN;
            if (iIndexOf$default == str3.length() && StringsKt__StringsJVMKt.startsWith(str, str3, false)) {
                List listSplit$default = StringsKt.split$default(str.substring(iIndexOf$default2 + 1), new char[]{' '});
                entry.readable = true;
                entry.currentEditor = null;
                int size = listSplit$default.size();
                entry.this$0.getClass();
                if (size != 2) {
                    Path$$ExternalSyntheticBUOutline0.m(listSplit$default, "unexpected journal line: ");
                    return;
                }
                try {
                    int size2 = listSplit$default.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        entry.lengths[i2] = Long.parseLong((String) listSplit$default.get(i2));
                    }
                    return;
                } catch (NumberFormatException unused) {
                    Path$$ExternalSyntheticBUOutline0.m(listSplit$default, "unexpected journal line: ");
                    return;
                }
            }
        }
        if (iIndexOf$default2 == -1) {
            String str4 = DIRTY;
            if (iIndexOf$default == str4.length() && StringsKt__StringsJVMKt.startsWith(str, str4, false)) {
                entry.currentEditor = new Latch(this, entry);
                return;
            }
        }
        if (iIndexOf$default2 == -1) {
            String str5 = READ;
            if (iIndexOf$default == str5.length() && StringsKt__StringsJVMKt.startsWith(str, str5, false)) {
                return;
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3("unexpected journal line: ".concat(str));
    }

    public final synchronized void rebuildJournal$okhttp() {
        Throwable th;
        try {
            RealBufferedSink realBufferedSink = this.journalWriter;
            if (realBufferedSink != null) {
                realBufferedSink.close();
            }
            RealBufferedSink realBufferedSinkBuffer = Okio__OkioKt.buffer(this.fileSystem.sink(this.journalFileTmp, false));
            try {
                realBufferedSinkBuffer.writeUtf8("libcore.io.DiskLruCache");
                realBufferedSinkBuffer.writeByte(10);
                realBufferedSinkBuffer.writeUtf8("1");
                realBufferedSinkBuffer.writeByte(10);
                realBufferedSinkBuffer.writeDecimalLong(201105L);
                realBufferedSinkBuffer.writeByte(10);
                realBufferedSinkBuffer.writeDecimalLong(2L);
                realBufferedSinkBuffer.writeByte(10);
                realBufferedSinkBuffer.writeByte(10);
                for (Object obj : this.lruEntries.values()) {
                    obj.getClass();
                    Entry entry = (Entry) obj;
                    if (entry.currentEditor != null) {
                        realBufferedSinkBuffer.writeUtf8(DIRTY);
                        realBufferedSinkBuffer.writeByte(32);
                        realBufferedSinkBuffer.writeUtf8(entry.key);
                        realBufferedSinkBuffer.writeByte(10);
                    } else {
                        realBufferedSinkBuffer.writeUtf8(CLEAN);
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
                _UtilCommonKt.deleteIfExists(this.fileSystem, this.journalFileBackup);
            } else {
                diskLruCache$fileSystem$1.atomicMove(this.journalFileTmp, this.journalFile);
            }
            RealBufferedSink realBufferedSink2 = this.journalWriter;
            if (realBufferedSink2 != null) {
                _UtilCommonKt.closeQuietly(realBufferedSink2);
            }
            DiskLruCache$fileSystem$1 diskLruCache$fileSystem$2 = this.fileSystem;
            Path path = this.journalFile;
            diskLruCache$fileSystem$2.getClass();
            path.getClass();
            this.journalWriter = new RealBufferedSink(new FaultHidingSink(diskLruCache$fileSystem$2.appendingSink(path), new PingPongKt$$ExternalSyntheticLambda0((byte) 13, (Object) this)));
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public final void removeEntry$okhttp(Entry entry) {
        RealBufferedSink realBufferedSink;
        String str = entry.key;
        if (!this.civilizedFileSystem) {
            if (entry.lockingSourceCount > 0 && (realBufferedSink = this.journalWriter) != null) {
                realBufferedSink.writeUtf8(DIRTY);
                realBufferedSink.writeByte(32);
                realBufferedSink.writeUtf8(str);
                realBufferedSink.writeByte(10);
                realBufferedSink.flush();
            }
            if (entry.lockingSourceCount > 0 || entry.currentEditor != null) {
                entry.zombie = true;
                return;
            }
        }
        Latch latch = entry.currentEditor;
        if (latch != null) {
            latch.detach$okhttp();
        }
        for (int i = 0; i < 2; i++) {
            _UtilCommonKt.deleteIfExists(this.fileSystem, (Path) entry.cleanFiles.get(i));
            long j = this.size;
            long[] jArr = entry.lengths;
            this.size = j - jArr[i];
            jArr[i] = 0;
        }
        this.redundantOpCount++;
        RealBufferedSink realBufferedSink2 = this.journalWriter;
        if (realBufferedSink2 != null) {
            realBufferedSink2.writeUtf8(REMOVE);
            realBufferedSink2.writeByte(32);
            realBufferedSink2.writeUtf8(str);
            realBufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(str);
        if (journalRebuildRequired()) {
            this.cleanupQueue.schedule(this.cleanupTask, 0L);
        }
    }

    public final void trimToSize() {
        while (this.size > this.maxSize) {
            for (Object obj : this.lruEntries.values()) {
                obj.getClass();
                Entry entry = (Entry) obj;
                if (!entry.zombie) {
                    removeEntry$okhttp(entry);
                }
            }
            return;
        }
        this.mostRecentTrimFailed = false;
    }
}
