package androidx.media3.datasource;

import android.net.Uri;
import android.util.Base64;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import j$.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataSchemeDataSource extends BaseDataSource {
    public int bytesRemaining;
    public byte[] data;
    public DataSpec dataSpec;
    public int readPosition;

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        if (this.data != null) {
            this.data = null;
            transferEnded();
        }
        this.dataSpec = null;
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
    public final long open(DataSpec dataSpec) throws ParserException, DataSourceException {
        byte[] bArrDecode;
        transferInitializing();
        this.dataSpec = dataSpec;
        Uri uri = dataSpec.uri;
        long j = dataSpec.length;
        Uri uriNormalizeScheme = uri.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        UtilsKt.checkArgument("data".equals(scheme), "Unsupported scheme: %s", scheme);
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        String str = Util.DEVICE_DEBUG_INFO;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw new ParserException("Unexpected URI format: " + uriNormalizeScheme, null, true, 0);
        }
        String str2 = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                bArrDecode = Base64.decode(str2, 0);
                this.data = bArrDecode;
            } catch (IllegalArgumentException e) {
                throw new ParserException(Fragment$5$$ExternalSyntheticOutline0.m("Error while parsing Base64 encoded string: ", str2), e, true, 0);
            }
        } else {
            bArrDecode = URLDecoder.decode(str2, StandardCharsets.US_ASCII.name()).getBytes(StandardCharsets.UTF_8);
            this.data = bArrDecode;
        }
        long j2 = dataSpec.position;
        if (j2 > bArrDecode.length) {
            this.data = null;
            throw new DataSourceException(2008);
        }
        int i = (int) j2;
        this.readPosition = i;
        int length = bArrDecode.length - i;
        this.bytesRemaining = length;
        if (j != -1) {
            this.bytesRemaining = (int) Math.min(length, j);
        }
        transferStarted(dataSpec);
        return j != -1 ? j : this.bytesRemaining;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.bytesRemaining;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        byte[] bArr2 = this.data;
        String str = Util.DEVICE_DEBUG_INFO;
        System.arraycopy(bArr2, this.readPosition, bArr, i, iMin);
        this.readPosition += iMin;
        this.bytesRemaining -= iMin;
        bytesTransferred(iMin);
        return iMin;
    }
}
