package androidx.room.concurrent;

import androidx.media3.extractor.text.CueDecoder;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExclusiveLock {
    public static final CueDecoder Companion = new CueDecoder((byte) 24);
    public static final LinkedHashMap threadLocksMap = new LinkedHashMap();
    public final FileLock fileLock;
    public final ReentrantLock threadLock;

    public ExclusiveLock(String str, boolean z) {
        ReentrantLock reentrantLock;
        FileLock fileLock;
        synchronized (Companion) {
            try {
                LinkedHashMap linkedHashMap = threadLocksMap;
                Object reentrantLock2 = linkedHashMap.get(str);
                if (reentrantLock2 == null) {
                    reentrantLock2 = new ReentrantLock();
                    linkedHashMap.put(str, reentrantLock2);
                }
                reentrantLock = (ReentrantLock) reentrantLock2;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.threadLock = reentrantLock;
        if (z) {
            fileLock = new FileLock();
            fileLock.lockFilename = str.concat(".lck");
        } else {
            fileLock = null;
        }
        this.fileLock = fileLock;
    }
}
