package androidx.media3.exoplayer.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new FragmentState.AnonymousClass1((byte) 14);
    public final ByteRange byteRange;
    public final String customCacheKey;
    public final byte[] data;
    public final String id;
    public final byte[] keySetId;
    public final String mimeType;
    public final List streamKeys;
    public final TimeRange timeRange;
    public final Uri uri;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ByteRange implements Parcelable {
        public static final Parcelable.Creator<ByteRange> CREATOR = new FragmentState.AnonymousClass1((byte) 15);
        public final long length;
        public final long offset;

        public ByteRange(Parcel parcel) {
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            UtilsKt.checkArgument(j >= 0);
            UtilsKt.checkArgument(j2 >= 0 || j2 == -1);
            this.offset = j;
            this.length = j2;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ByteRange)) {
                return false;
            }
            ByteRange byteRange = (ByteRange) obj;
            return this.offset == byteRange.offset && this.length == byteRange.length;
        }

        public final int hashCode() {
            return (((int) this.offset) * 961) + ((int) this.length);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.offset);
            parcel.writeLong(this.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TimeRange implements Parcelable {
        public static final Parcelable.Creator<TimeRange> CREATOR = new FragmentState.AnonymousClass1((byte) 16);
        public final long durationUs;
        public final long startPositionUs;

        public TimeRange(Parcel parcel) {
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            UtilsKt.checkArgument(j2 >= 0 || j2 == -9223372036854775807L);
            this.startPositionUs = j;
            this.durationUs = j2;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof TimeRange)) {
                return false;
            }
            TimeRange timeRange = (TimeRange) obj;
            return this.startPositionUs == timeRange.startPositionUs && this.durationUs == timeRange.durationUs;
        }

        public final int hashCode() {
            return (((int) this.startPositionUs) * 961) + ((int) this.durationUs);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.startPositionUs);
            parcel.writeLong(this.durationUs);
        }
    }

    public DownloadRequest(Parcel parcel) {
        String string = parcel.readString();
        String str = Util.DEVICE_DEBUG_INFO;
        this.id = string;
        this.uri = Uri.parse(parcel.readString());
        this.mimeType = parcel.readString();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = parcel.createByteArray();
        this.customCacheKey = parcel.readString();
        this.data = parcel.createByteArray();
        this.byteRange = (ByteRange) parcel.readParcelable(ByteRange.class.getClassLoader());
        this.timeRange = (TimeRange) parcel.readParcelable(TimeRange.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        return this.id.equals(downloadRequest.id) && this.uri.equals(downloadRequest.uri) && Objects.equals(this.mimeType, downloadRequest.mimeType) && this.streamKeys.equals(downloadRequest.streamKeys) && Arrays.equals(this.keySetId, downloadRequest.keySetId) && Objects.equals(this.customCacheKey, downloadRequest.customCacheKey) && Arrays.equals(this.data, downloadRequest.data) && Objects.equals(this.byteRange, downloadRequest.byteRange) && Objects.equals(this.timeRange, downloadRequest.timeRange);
    }

    public final int hashCode() {
        int iHashCode = (this.uri.hashCode() + (this.id.hashCode() * 961)) * 31;
        String str = this.mimeType;
        int iHashCode2 = (Arrays.hashCode(this.keySetId) + ((this.streamKeys.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31)) * 31;
        String str2 = this.customCacheKey;
        int iHashCode3 = (Arrays.hashCode(this.data) + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31;
        ByteRange byteRange = this.byteRange;
        int iHashCode4 = (iHashCode3 + (byteRange != null ? byteRange.hashCode() : 0)) * 31;
        TimeRange timeRange = this.timeRange;
        return iHashCode4 + (timeRange != null ? timeRange.hashCode() : 0);
    }

    public final String toString() {
        return this.mimeType + ServerSentEventKt.COLON + this.id;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.uri.toString());
        parcel.writeString(this.mimeType);
        List list = this.streamKeys;
        parcel.writeInt(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            parcel.writeParcelable((Parcelable) list.get(i2), 0);
        }
        parcel.writeByteArray(this.keySetId);
        parcel.writeString(this.customCacheKey);
        parcel.writeByteArray(this.data);
        parcel.writeParcelable(this.byteRange, 0);
        parcel.writeParcelable(this.timeRange, 0);
    }

    public DownloadRequest(String str, Uri uri, String str2, List list, byte[] bArr, String str3, byte[] bArr2, ByteRange byteRange, TimeRange timeRange) {
        int iInferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(uri, str2);
        if (iInferContentTypeForUriAndMimeType != 0 && iInferContentTypeForUriAndMimeType != 2 && iInferContentTypeForUriAndMimeType != 1) {
            this.byteRange = byteRange;
            this.timeRange = null;
        } else {
            UtilsKt.checkArgument("customCacheKey must be null for type: %s", iInferContentTypeForUriAndMimeType, str3 == null);
            this.byteRange = null;
            this.timeRange = timeRange;
        }
        this.id = str;
        this.uri = uri;
        this.mimeType = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.customCacheKey = str3;
        this.data = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : Util.EMPTY_BYTE_ARRAY;
    }
}
