package androidx.media3.datasource;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.view.DisplayCompat;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DataSourceBitmapLoader$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DataSourceBitmapLoader f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ DataSourceBitmapLoader$$ExternalSyntheticLambda1(DataSourceBitmapLoader dataSourceBitmapLoader, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$0 = dataSourceBitmapLoader;
        this.f$1 = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        byte b = this.$r8$classId;
        Object obj = this.f$1;
        DataSourceBitmapLoader dataSourceBitmapLoader = this.f$0;
        switch (b) {
            case 0:
                byte[] bArr = (byte[]) obj;
                boolean z = dataSourceBitmapLoader.makeShared;
                Bitmap bitmapDecode = DisplayCompat.decode(bArr, bArr.length, dataSourceBitmapLoader.maximumOutputDimension);
                return z ? DisplayCompat.makeShared(bitmapDecode) : bitmapDecode;
            default:
                Uri uri = (Uri) obj;
                DataSource dataSourceCreateDataSource = dataSourceBitmapLoader.dataSourceFactory.createDataSource();
                int i = dataSourceBitmapLoader.maximumOutputDimension;
                boolean z2 = dataSourceBitmapLoader.makeShared;
                try {
                    DataSpec dataSpec = new DataSpec(uri, 0L, 1, null, Collections.EMPTY_MAP, 0L, -1L, null, 0);
                    DefaultDataSource defaultDataSource = (DefaultDataSource) dataSourceCreateDataSource;
                    defaultDataSource.open(dataSpec);
                    byte[] bArrCopyOf = new byte[1024];
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 != -1) {
                        if (i3 == bArrCopyOf.length) {
                            bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length * 2);
                        }
                        i2 = defaultDataSource.read(bArrCopyOf, i3, bArrCopyOf.length - i3);
                        if (i2 != -1) {
                            i3 += i2;
                        }
                    }
                    byte[] bArrCopyOf2 = Arrays.copyOf(bArrCopyOf, i3);
                    Bitmap bitmapDecode2 = DisplayCompat.decode(bArrCopyOf2, bArrCopyOf2.length, i);
                    if (z2) {
                        bitmapDecode2 = DisplayCompat.makeShared(bitmapDecode2);
                        break;
                    }
                    return bitmapDecode2;
                } finally {
                    ((DefaultDataSource) dataSourceCreateDataSource).close();
                }
        }
    }
}
