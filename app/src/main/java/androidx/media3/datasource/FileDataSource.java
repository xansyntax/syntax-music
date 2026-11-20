package androidx.media3.datasource;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FileDataSource extends BaseDataSource {
    public long bytesRemaining;
    public RandomAccessFile file;
    public boolean opened;
    public Uri uri;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Factory implements DataSource.Factory {
        @Override // androidx.media3.datasource.DataSource.Factory
        public final DataSource createDataSource() {
            return new FileDataSource(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FileDataSourceException extends DataSourceException {
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        this.uri = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.file;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.file = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
            } catch (IOException e) {
                throw new FileDataSourceException(e, 2000);
            }
        } catch (Throwable th) {
            this.file = null;
            if (this.opened) {
                this.opened = false;
                transferEnded();
            }
            throw th;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri getUri() {
        return this.uri;
    }

    @Override // androidx.media3.datasource.DataSource
    public final long open(DataSpec dataSpec) throws FileDataSourceException {
        Uri uri = dataSpec.uri;
        long j = dataSpec.position;
        this.uri = uri;
        transferInitializing();
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.file = randomAccessFile;
            try {
                randomAccessFile.seek(j);
                long length = dataSpec.length;
                if (length == -1) {
                    length = this.file.length() - j;
                }
                this.bytesRemaining = length;
                if (length < 0) {
                    throw new FileDataSourceException(null, null, 2008);
                }
                this.opened = true;
                transferStarted(dataSpec);
                return this.bytesRemaining;
            } catch (IOException e) {
                throw new FileDataSourceException(e, 2000);
            }
        } catch (FileNotFoundException e2) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(e2, ((e2.getCause() instanceof ErrnoException) && ((ErrnoException) e2.getCause()).errno == OsConstants.EACCES) ? 2006 : 2005);
            }
            String path2 = uri.getPath();
            String query = uri.getQuery();
            String fragment = uri.getFragment();
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=", path2, ",query=", query, ",fragment=");
            sbM.append(fragment);
            throw new FileDataSourceException(sbM.toString(), e2, 1004);
        } catch (SecurityException e3) {
            throw new FileDataSourceException(e3, 2006);
        } catch (RuntimeException e4) {
            throw new FileDataSourceException(e4, 2000);
        }
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i, int i2) throws FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.file;
            String str = Util.DEVICE_DEBUG_INFO;
            int i3 = randomAccessFile.read(bArr, i, (int) Math.min(j, i2));
            if (i3 > 0) {
                this.bytesRemaining -= (long) i3;
                bytesTransferred(i3);
            }
            return i3;
        } catch (IOException e) {
            throw new FileDataSourceException(e, 2000);
        }
    }
}
