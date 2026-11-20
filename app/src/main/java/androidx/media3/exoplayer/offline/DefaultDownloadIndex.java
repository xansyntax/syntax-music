package androidx.media3.exoplayer.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Util;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.database.VersionTable;
import coil3.util.UtilsKt;
import io.ktor.http.LinkHeader;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.FileSystemException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultDownloadIndex {
    public final StandaloneDatabaseProvider databaseProvider;
    public boolean initialized;
    public static final String WHERE_STATE_IS_TERMINAL = getStateQuery(3, 4);
    public static final String[] COLUMNS = {"id", "mime_type", "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded", "key_set_id"};
    public final String tableName = "ExoPlayerDownloads";
    public final Object initializationLock = new Object();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DownloadCursorImpl implements Closeable {
        public final Cursor cursor;

        public DownloadCursorImpl(Cursor cursor) {
            this.cursor = cursor;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.cursor.close();
        }
    }

    public DefaultDownloadIndex(StandaloneDatabaseProvider standaloneDatabaseProvider) {
        this.databaseProvider = standaloneDatabaseProvider;
    }

    public static ArrayList decodeStreamKeys(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            String str2 = Util.DEVICE_DEBUG_INFO;
            for (String str3 : str.split(",", -1)) {
                String[] strArrSplit = str3.split("\\.", -1);
                UtilsKt.checkState(strArrSplit.length == 3);
                arrayList.add(new StreamKey(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2])));
            }
        }
        return arrayList;
    }

    public static Download getDownloadForCurrentRow(Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        String string = cursor.getString(0);
        string.getClass();
        String string2 = cursor.getString(2);
        string2.getClass();
        Uri uri = Uri.parse(string2);
        String strNormalizeMimeType = MimeTypes.normalizeMimeType(cursor.getString(1));
        ArrayList arrayListDecodeStreamKeys = decodeStreamKeys(cursor.getString(3));
        if (blob.length <= 0) {
            blob = null;
        }
        DownloadRequest downloadRequest = new DownloadRequest(string, uri, strNormalizeMimeType, arrayListDecodeStreamKeys, blob, cursor.getString(4), cursor.getBlob(5), null, null);
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.bytesDownloaded = cursor.getLong(13);
        downloadProgress.percentDownloaded = cursor.getFloat(12);
        int i = cursor.getInt(6);
        return new Download(downloadRequest, i, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i == 4 ? cursor.getInt(11) : 0, downloadProgress);
    }

    public static Download getDownloadForCurrentRowV2(Cursor cursor) {
        String str;
        String string = cursor.getString(0);
        string.getClass();
        String string2 = cursor.getString(2);
        string2.getClass();
        Uri uri = Uri.parse(string2);
        String string3 = cursor.getString(1);
        if ("dash".equals(string3)) {
            str = "application/dash+xml";
        } else if ("hls".equals(string3)) {
            str = "application/x-mpegURL";
        } else {
            str = "ss".equals(string3) ? "application/vnd.ms-sstr+xml" : "video/x-unknown";
        }
        DownloadRequest downloadRequest = new DownloadRequest(string, uri, MimeTypes.normalizeMimeType(str), decodeStreamKeys(cursor.getString(3)), null, cursor.getString(4), cursor.getBlob(5), null, null);
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.bytesDownloaded = cursor.getLong(13);
        downloadProgress.percentDownloaded = cursor.getFloat(12);
        int i = cursor.getInt(6);
        return new Download(downloadRequest, i, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i == 4 ? cursor.getInt(11) : 0, downloadProgress);
    }

    public static String getStateQuery(int... iArr) {
        if (iArr.length == 0) {
            return "1";
        }
        StringBuilder sb = new StringBuilder("state IN (");
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(iArr[i]);
        }
        sb.append(')');
        return sb.toString();
    }

    public static ArrayList loadDownloadsFromVersion2(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        if (!Util.tableExists(sQLiteDatabase, "ExoPlayerDownloads")) {
            return arrayList;
        }
        Cursor cursorQuery = sQLiteDatabase.query("ExoPlayerDownloads", new String[]{"id", LinkHeader.Parameters.Title, "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded"}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(getDownloadForCurrentRowV2(cursorQuery));
            } catch (Throwable th) {
                if (cursorQuery == null) {
                    throw th;
                }
                try {
                    cursorQuery.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }
        cursorQuery.close();
        return arrayList;
    }

    public final void ensureInitialized() {
        synchronized (this.initializationLock) {
            if (this.initialized) {
                return;
            }
            try {
                int i = 0;
                int version = VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 0, "");
                if (version != 3) {
                    SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        VersionTable.setVersion(writableDatabase, 0, "", 3);
                        ArrayList arrayListLoadDownloadsFromVersion2 = version == 2 ? loadDownloadsFromVersion2(writableDatabase) : new ArrayList();
                        writableDatabase.execSQL("DROP TABLE IF EXISTS ExoPlayerDownloads");
                        writableDatabase.execSQL("CREATE TABLE ExoPlayerDownloads (id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)");
                        int size = arrayListLoadDownloadsFromVersion2.size();
                        while (i < size) {
                            Object obj = arrayListLoadDownloadsFromVersion2.get(i);
                            i++;
                            putDownloadInternal((Download) obj, writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                this.initialized = true;
            } catch (SQLException e) {
                throw new FileSystemException(e);
            }
        }
    }

    public final Cursor getCursor(String str, String[] strArr) {
        try {
            return this.databaseProvider.getReadableDatabase().query(this.tableName, COLUMNS, str, strArr, null, null, "start_time_ms ASC");
        } catch (SQLiteException e) {
            throw new FileSystemException(e);
        }
    }

    public final Download getDownload(String str) throws FileSystemException {
        ensureInitialized();
        try {
            Cursor cursor = getCursor("id = ?", new String[]{str});
            try {
                if (cursor.getCount() == 0) {
                    cursor.close();
                    return null;
                }
                cursor.moveToNext();
                Download downloadForCurrentRow = getDownloadForCurrentRow(cursor);
                cursor.close();
                return downloadForCurrentRow;
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (SQLiteException e) {
            throw new FileSystemException(e);
        }
        throw new FileSystemException(e);
    }

    public final void putDownload(Download download) {
        ensureInitialized();
        try {
            putDownloadInternal(download, this.databaseProvider.getWritableDatabase());
        } catch (SQLiteException e) {
            throw new FileSystemException(e);
        }
    }

    public final void putDownloadInternal(Download download, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = download.request.keySetId;
        if (bArr == null) {
            bArr = Util.EMPTY_BYTE_ARRAY;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", download.request.id);
        contentValues.put("mime_type", download.request.mimeType);
        contentValues.put("uri", download.request.uri.toString());
        List list = download.request.streamKeys;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            StreamKey streamKey = (StreamKey) list.get(i);
            sb.append(streamKey.periodIndex);
            sb.append('.');
            sb.append(streamKey.groupIndex);
            sb.append('.');
            sb.append(streamKey.streamIndex);
            sb.append(',');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        contentValues.put("stream_keys", sb.toString());
        contentValues.put("custom_cache_key", download.request.customCacheKey);
        contentValues.put("data", download.request.data);
        contentValues.put("state", Integer.valueOf(download.state));
        contentValues.put("start_time_ms", Long.valueOf(download.startTimeMs));
        contentValues.put("update_time_ms", Long.valueOf(download.updateTimeMs));
        contentValues.put("content_length", Long.valueOf(download.contentLength));
        contentValues.put("stop_reason", Integer.valueOf(download.stopReason));
        contentValues.put("failure_reason", Integer.valueOf(download.failureReason));
        contentValues.put("percent_downloaded", Float.valueOf(download.progress.percentDownloaded));
        contentValues.put("bytes_downloaded", Long.valueOf(download.progress.bytesDownloaded));
        contentValues.put("key_set_id", bArr);
        sQLiteDatabase.replaceOrThrow(this.tableName, null, contentValues);
    }

    public final void setDownloadingStatesToQueued() {
        ensureInitialized();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 0);
            this.databaseProvider.getWritableDatabase().update("ExoPlayerDownloads", contentValues, "state = 2", null);
        } catch (SQLException e) {
            throw new FileSystemException(e);
        }
    }

    public final void setStatesToRemoving() {
        ensureInitialized();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 5);
            contentValues.put("failure_reason", (Integer) 0);
            this.databaseProvider.getWritableDatabase().update("ExoPlayerDownloads", contentValues, null, null);
        } catch (SQLException e) {
            throw new FileSystemException(e);
        }
    }

    public final void setStopReason(int i, String str) {
        ensureInitialized();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i));
            this.databaseProvider.getWritableDatabase().update("ExoPlayerDownloads", contentValues, WHERE_STATE_IS_TERMINAL + " AND id = ?", new String[]{str});
        } catch (SQLException e) {
            throw new FileSystemException(e);
        }
    }
}
