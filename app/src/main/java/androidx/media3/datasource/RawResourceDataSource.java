package androidx.media3.datasource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Util;
import io.ktor.sse.ServerSentEventKt;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RawResourceDataSource extends BaseDataSource {
    public final Context applicationContext;
    public AssetFileDescriptor assetFileDescriptor;
    public long bytesRemaining;
    public DataSpec dataSpec;
    public FileInputStream inputStream;
    public boolean opened;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class RawResourceDataSourceException extends DataSourceException {
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.applicationContext = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i) {
        return Uri.parse("rawresource:///" + i);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x000e */
    /* JADX WARN: Bottom block not found for handler: all -> 0x004e */
    @Override // androidx.media3.datasource.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void close() {
        this.dataSpec = null;
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
                    throw new RawResourceDataSourceException(null, e, 2000);
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
            throw new RawResourceDataSourceException(null, e2, 2000);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri getUri() {
        DataSpec dataSpec = this.dataSpec;
        if (dataSpec != null) {
            return dataSpec.uri;
        }
        return null;
    }

    @Override // androidx.media3.datasource.DataSource
    public final long open(DataSpec dataSpec) throws RawResourceDataSourceException {
        Resources resourcesForApplication;
        int identifier;
        int i;
        Resources resources;
        long size;
        this.dataSpec = dataSpec;
        transferInitializing();
        Uri uri = dataSpec.uri;
        long j = dataSpec.length;
        long j2 = dataSpec.position;
        Uri uriNormalizeScheme = uri.normalizeScheme();
        boolean zEquals = TextUtils.equals("rawresource", uriNormalizeScheme.getScheme());
        Context context = this.applicationContext;
        if (zEquals) {
            resources = context.getResources();
            List<String> pathSegments = uriNormalizeScheme.getPathSegments();
            if (pathSegments.size() != 1) {
                throw new RawResourceDataSourceException("rawresource:// URI must have exactly one path element, found " + pathSegments.size(), null, 2000);
            }
            try {
                i = Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", uriNormalizeScheme.getScheme())) {
                throw new RawResourceDataSourceException("Unsupported URI scheme (" + uriNormalizeScheme.getScheme() + "). Only android.resource is supported.", null, 1004);
            }
            String path = uriNormalizeScheme.getPath();
            path.getClass();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            String packageName = TextUtils.isEmpty(uriNormalizeScheme.getHost()) ? context.getPackageName() : uriNormalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resourcesForApplication = context.getResources();
            } else {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e) {
                    throw new RawResourceDataSourceException("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e, 2005);
                }
            }
            if (path.matches("\\d+")) {
                try {
                    identifier = Integer.parseInt(path);
                } catch (NumberFormatException unused2) {
                    throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
                }
            } else {
                identifier = resourcesForApplication.getIdentifier(IntIntPair$$ExternalSyntheticOutline0.m(packageName, ServerSentEventKt.COLON, path), "raw", null);
                if (identifier == 0) {
                    throw new RawResourceDataSourceException("Resource not found.", null, 2005);
                }
            }
            i = identifier;
            resources = resourcesForApplication;
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resources.openRawResourceFd(i);
            if (assetFileDescriptorOpenRawResourceFd == null) {
                throw new RawResourceDataSourceException("Resource is compressed: " + uriNormalizeScheme, null, 2000);
            }
            this.assetFileDescriptor = assetFileDescriptorOpenRawResourceFd;
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(this.assetFileDescriptor.getFileDescriptor());
            this.inputStream = fileInputStream;
            try {
                if (length != -1 && j2 > length) {
                    throw new RawResourceDataSourceException(null, null, 2008);
                }
                long startOffset = this.assetFileDescriptor.getStartOffset();
                long jSkip = fileInputStream.skip(startOffset + j2) - startOffset;
                if (jSkip != j2) {
                    throw new RawResourceDataSourceException(null, null, 2008);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    if (channel.size() == 0) {
                        this.bytesRemaining = -1L;
                        size = -1;
                    } else {
                        size = channel.size() - channel.position();
                        this.bytesRemaining = size;
                        if (size < 0) {
                            throw new RawResourceDataSourceException(null, null, 2008);
                        }
                    }
                } else {
                    size = length - jSkip;
                    this.bytesRemaining = size;
                    if (size < 0) {
                        throw new DataSourceException(2008);
                    }
                }
                if (j != -1) {
                    this.bytesRemaining = size == -1 ? j : Math.min(size, j);
                }
                this.opened = true;
                transferStarted(dataSpec);
                return j != -1 ? j : this.bytesRemaining;
            } catch (RawResourceDataSourceException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RawResourceDataSourceException(null, e3, 2000);
            }
        } catch (Resources.NotFoundException e4) {
            throw new RawResourceDataSourceException(null, e4, 2005);
        }
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i, int i2) throws RawResourceDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j != 0) {
            if (j != -1) {
                try {
                    i2 = (int) Math.min(j, i2);
                } catch (IOException e) {
                    throw new RawResourceDataSourceException(null, e, 2000);
                }
            }
            FileInputStream fileInputStream = this.inputStream;
            String str = Util.DEVICE_DEBUG_INFO;
            int i3 = fileInputStream.read(bArr, i, i2);
            long j2 = this.bytesRemaining;
            if (i3 != -1) {
                if (j2 != -1) {
                    this.bytesRemaining = j2 - ((long) i3);
                }
                bytesTransferred(i3);
                return i3;
            }
            if (j2 != -1) {
                throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
            }
        }
        return -1;
    }
}
