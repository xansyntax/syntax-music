package androidx.media3.datasource;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.media3.common.util.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AssetDataSource extends BaseDataSource {
    public final AssetManager assetManager;
    public long bytesRemaining;
    public InputStream inputStream;
    public boolean opened;
    public Uri uri;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AssetDataSourceException extends DataSourceException {
    }

    public AssetDataSource(Context context) {
        super(false);
        this.assetManager = context.getAssets();
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        this.uri = null;
        try {
            try {
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.inputStream = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
            } catch (IOException e) {
                throw new AssetDataSourceException(e, 2000);
            }
        } catch (Throwable th) {
            this.inputStream = null;
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
    public final long open(DataSpec dataSpec) throws AssetDataSourceException {
        try {
            Uri uri = dataSpec.uri;
            long j = dataSpec.position;
            this.uri = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            transferInitializing();
            InputStream inputStreamOpen = this.assetManager.open(path, 1);
            this.inputStream = inputStreamOpen;
            if (inputStreamOpen.skip(j) < j) {
                throw new AssetDataSourceException(null, 2008);
            }
            long j2 = dataSpec.length;
            if (j2 != -1) {
                this.bytesRemaining = j2;
            } else {
                long jAvailable = this.inputStream.available();
                this.bytesRemaining = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.bytesRemaining = -1L;
                }
            }
            this.opened = true;
            transferStarted(dataSpec);
            return this.bytesRemaining;
        } catch (AssetDataSourceException e) {
            throw e;
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i, int i2) throws AssetDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j != 0) {
            if (j != -1) {
                try {
                    i2 = (int) Math.min(j, i2);
                } catch (IOException e) {
                    throw new AssetDataSourceException(e, 2000);
                }
            }
            InputStream inputStream = this.inputStream;
            String str = Util.DEVICE_DEBUG_INFO;
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 != -1) {
                long j2 = this.bytesRemaining;
                if (j2 != -1) {
                    this.bytesRemaining = j2 - ((long) i3);
                }
                bytesTransferred(i3);
                return i3;
            }
        }
        return -1;
    }
}
