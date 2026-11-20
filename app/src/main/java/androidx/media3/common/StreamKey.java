package androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StreamKey implements Comparable, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new AnonymousClass1(0);
    public static final String FIELD_GROUP_INDEX;
    public static final String FIELD_PERIOD_INDEX;
    public static final String FIELD_STREAM_INDEX;
    public final int groupIndex;
    public final int periodIndex;
    public final int streamIndex;

    /* JADX INFO: renamed from: androidx.media3.common.StreamKey$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Parcelable.Creator {
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ AnonymousClass1(byte b) {
            this.$r8$classId = b;
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            switch (this.$r8$classId) {
                case 0:
                    return new StreamKey(parcel);
                case 1:
                    return new DrmInitData(parcel);
                default:
                    return new DrmInitData.SchemeData(parcel);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            switch (this.$r8$classId) {
                case 0:
                    return new StreamKey[i];
                case 1:
                    return new DrmInitData[i];
                default:
                    return new DrmInitData.SchemeData[i];
            }
        }
    }

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_PERIOD_INDEX = Integer.toString(0, 36);
        FIELD_GROUP_INDEX = Integer.toString(1, 36);
        FIELD_STREAM_INDEX = Integer.toString(2, 36);
    }

    public StreamKey(Parcel parcel) {
        this.periodIndex = parcel.readInt();
        this.groupIndex = parcel.readInt();
        this.streamIndex = parcel.readInt();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        StreamKey streamKey = (StreamKey) obj;
        int i = this.periodIndex - streamKey.periodIndex;
        return (i == 0 && (i = this.groupIndex - streamKey.groupIndex) == 0) ? this.streamIndex - streamKey.streamIndex : i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && StreamKey.class == obj.getClass()) {
            StreamKey streamKey = (StreamKey) obj;
            if (this.periodIndex == streamKey.periodIndex && this.groupIndex == streamKey.groupIndex && this.streamIndex == streamKey.streamIndex) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.periodIndex * 31) + this.groupIndex) * 31) + this.streamIndex;
    }

    public final String toString() {
        return this.periodIndex + "." + this.groupIndex + "." + this.streamIndex;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.periodIndex);
        parcel.writeInt(this.groupIndex);
        parcel.writeInt(this.streamIndex);
    }

    public StreamKey(int i, int i2, int i3) {
        this.periodIndex = i;
        this.groupIndex = i2;
        this.streamIndex = i3;
    }
}
