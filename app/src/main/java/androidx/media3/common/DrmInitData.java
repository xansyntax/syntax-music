package androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Util;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DrmInitData implements Comparator, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new StreamKey.AnonymousClass1(1);
    public int hashCode;
    public final int schemeDataCount;
    public final SchemeData[] schemeDatas;
    public final String schemeType;

    public DrmInitData(Parcel parcel) {
        this.schemeType = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        String str = Util.DEVICE_DEBUG_INFO;
        this.schemeDatas = schemeDataArr;
        this.schemeDataCount = schemeDataArr.length;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        SchemeData schemeData = (SchemeData) obj;
        SchemeData schemeData2 = (SchemeData) obj2;
        UUID uuid = C.UUID_NIL;
        if (uuid.equals(schemeData.uuid)) {
            return uuid.equals(schemeData2.uuid) ? 0 : 1;
        }
        return schemeData.uuid.compareTo(schemeData2.uuid);
    }

    public final DrmInitData copyWithSchemeType(String str) {
        return Objects.equals(this.schemeType, str) ? this : new DrmInitData(str, false, this.schemeDatas);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DrmInitData.class == obj.getClass()) {
            DrmInitData drmInitData = (DrmInitData) obj;
            if (Objects.equals(this.schemeType, drmInitData.schemeType) && Arrays.equals(this.schemeDatas, drmInitData.schemeDatas)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.schemeType;
        int iHashCode = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.schemeDatas);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.schemeType);
        parcel.writeTypedArray(this.schemeDatas, 0);
    }

    public DrmInitData(String str, boolean z, SchemeData... schemeDataArr) {
        this.schemeType = str;
        schemeDataArr = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        this.schemeDatas = schemeDataArr;
        this.schemeDataCount = schemeDataArr.length;
        Arrays.sort(schemeDataArr, this);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new StreamKey.AnonymousClass1(2);
        public final byte[] data;
        public int hashCode;
        public final String licenseServerUrl;
        public final String mimeType;
        public final UUID uuid;

        public SchemeData(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.licenseServerUrl = parcel.readString();
            String string = parcel.readString();
            String str = Util.DEVICE_DEBUG_INFO;
            this.mimeType = string;
            this.data = parcel.createByteArray();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return Objects.equals(this.licenseServerUrl, schemeData.licenseServerUrl) && Objects.equals(this.mimeType, schemeData.mimeType) && Objects.equals(this.uuid, schemeData.uuid) && Arrays.equals(this.data, schemeData.data);
        }

        public final int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            int iHashCode = this.uuid.hashCode() * 31;
            String str = this.licenseServerUrl;
            int iHashCode2 = Arrays.hashCode(this.data) + Fragment$5$$ExternalSyntheticOutline0.m((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.mimeType);
            this.hashCode = iHashCode2;
            return iHashCode2;
        }

        public final boolean matches(UUID uuid) {
            UUID uuid2 = C.UUID_NIL;
            UUID uuid3 = this.uuid;
            return uuid2.equals(uuid3) || uuid.equals(uuid3);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            UUID uuid = this.uuid;
            parcel.writeLong(uuid.getMostSignificantBits());
            parcel.writeLong(uuid.getLeastSignificantBits());
            parcel.writeString(this.licenseServerUrl);
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
        }

        public SchemeData(UUID uuid, String str, String str2, byte[] bArr) {
            uuid.getClass();
            this.uuid = uuid;
            this.licenseServerUrl = str;
            str2.getClass();
            this.mimeType = MimeTypes.normalizeMimeType(str2);
            this.data = bArr;
        }
    }
}
