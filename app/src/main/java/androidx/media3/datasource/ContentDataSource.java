package androidx.media3.datasource;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.util.Util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentDataSource extends BaseDataSource {
    public AssetFileDescriptor assetFileDescriptor;
    public long bytesRemaining;
    public FileInputStream inputStream;
    public boolean opened;
    public final ContentResolver resolver;
    public Uri uri;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ContentDataSourceException extends DataSourceException {
    }

    public ContentDataSource(Context context) {
        super(false);
        this.resolver = context.getContentResolver();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x000e */
    /* JADX WARN: Bottom block not found for handler: all -> 0x004e */
    @Override // androidx.media3.datasource.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void close() {
        this.uri = null;
        try {
            FileInputStream fileInputStream = this.inputStream;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.inputStream = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = this.assetFileDescriptor;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        transferEnded();
                    }
                } catch (IOException e) {
                    throw new ContentDataSourceException(e, 2000);
                }
            } catch (Throwable th) {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    transferEnded();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new ContentDataSourceException(e2, 2000);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri getUri() {
        return this.uri;
    }

    @Override // androidx.media3.datasource.DataSource
    public final long open(DataSpec dataSpec) throws ContentDataSourceException {
        int i;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        long jPosition;
        try {
            try {
                Uri uri = dataSpec.uri;
                long j = dataSpec.length;
                long j2 = dataSpec.position;
                Uri uriNormalizeScheme = uri.normalizeScheme();
                this.uri = uriNormalizeScheme;
                transferInitializing();
                boolean zEquals = Objects.equals(uriNormalizeScheme.getScheme(), "content");
                ContentResolver contentResolver = this.resolver;
                if (zEquals) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                    assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(uriNormalizeScheme, "*/*", bundle);
                } else {
                    assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uriNormalizeScheme, "r");
                }
                this.assetFileDescriptor = assetFileDescriptorOpenAssetFileDescriptor;
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    i = 2000;
                    try {
                        throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + uriNormalizeScheme), 2000);
                    } catch (IOException e) {
                        e = e;
                        throw new ContentDataSourceException(e, e instanceof FileNotFoundException ? 2005 : i);
                    }
                }
                long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                this.inputStream = fileInputStream;
                if (length != -1 && j2 > length) {
                    throw new ContentDataSourceException(null, 2008);
                }
                long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
                long jSkip = fileInputStream.skip(startOffset + j2) - startOffset;
                if (jSkip != j2) {
                    throw new ContentDataSourceException(null, 2008);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.bytesRemaining = -1L;
                        jPosition = -1;
                    } else {
                        jPosition = size - channel.position();
                        this.bytesRemaining = jPosition;
                        if (jPosition < 0) {
                            throw new ContentDataSourceException(null, 2008);
                        }
                    }
                } else {
                    jPosition = length - jSkip;
                    this.bytesRemaining = jPosition;
                    if (jPosition < 0) {
                        throw new ContentDataSourceException(null, 2008);
                    }
                }
                if (j != -1) {
                    this.bytesRemaining = jPosition == -1 ? j : Math.min(jPosition, j);
                }
                this.opened = true;
                transferStarted(dataSpec);
                return j != -1 ? j : this.bytesRemaining;
            } catch (IOException e2) {
                e = e2;
                i = 2000;
            }
        } catch (ContentDataSourceException e3) {
            throw e3;
        }
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i, int i2) throws ContentDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j != 0) {
            if (j != -1) {
                try {
                    i2 = (int) Math.min(j, i2);
                } catch (IOException e) {
                    throw new ContentDataSourceException(e, 2000);
                }
            }
            FileInputStream fileInputStream = this.inputStream;
            String str = Util.DEVICE_DEBUG_INFO;
            int i3 = fileInputStream.read(bArr, i, i2);
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
