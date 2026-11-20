package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.text.TextUtils;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.util.LifecyclesKt;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new AnonymousClass1(0);
    public final long mActions;
    public final long mActiveItemId;
    public final long mBufferedPosition;
    public final ArrayList mCustomActions;
    public final int mErrorCode;
    public final CharSequence mErrorMessage;
    public final Bundle mExtras;
    public final long mPosition;
    public final float mSpeed;
    public final int mState;
    public final long mUpdateTime;

    /* JADX INFO: renamed from: android.support.v4.media.session.PlaybackStateCompat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Parcelable.Creator {
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ AnonymousClass1(byte b) {
            this.$r8$classId = b;
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(final Parcel parcel) {
            switch (this.$r8$classId) {
                case 0:
                    return new PlaybackStateCompat(parcel);
                case 1:
                    MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                    mediaSessionCompat$ResultReceiverWrapper.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                    return mediaSessionCompat$ResultReceiverWrapper;
                case 2:
                    return new Parcelable(parcel) { // from class: android.support.v4.media.session.MediaSessionCompat$QueueItem
                        public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new PlaybackStateCompat.AnonymousClass1(2);
                        public final MediaDescriptionCompat mDescription;
                        public final long mId;

                        {
                            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                            this.mId = parcel.readLong();
                        }

                        @Override // android.os.Parcelable
                        public final int describeContents() {
                            return 0;
                        }

                        public final String toString() {
                            StringBuilder sb = new StringBuilder("MediaSession.QueueItem {Description=");
                            sb.append(this.mDescription);
                            sb.append(", Id=");
                            return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.mId, " }");
                        }

                        @Override // android.os.Parcelable
                        public final void writeToParcel(Parcel parcel2, int i) {
                            this.mDescription.writeToParcel(parcel2, i);
                            parcel2.writeLong(this.mId);
                        }
                    };
                case 3:
                    final Parcelable parcelable = parcel.readParcelable(null);
                    return new Parcelable(parcelable) { // from class: android.support.v4.media.session.MediaSessionCompat$Token
                        public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new PlaybackStateCompat.AnonymousClass1(3);
                        public final Object mInner;
                        public final Object mLock = new Object();

                        {
                            this.mInner = parcelable;
                        }

                        @Override // android.os.Parcelable
                        public final int describeContents() {
                            return 0;
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (!(obj instanceof MediaSessionCompat$Token)) {
                                return false;
                            }
                            Object obj2 = ((MediaSessionCompat$Token) obj).mInner;
                            Object obj3 = this.mInner;
                            if (obj3 == null) {
                                return obj2 == null;
                            }
                            if (obj2 == null) {
                                return false;
                            }
                            return obj3.equals(obj2);
                        }

                        public final int hashCode() {
                            Object obj = this.mInner;
                            if (obj == null) {
                                return 0;
                            }
                            return obj.hashCode();
                        }

                        @Override // android.os.Parcelable
                        public final void writeToParcel(Parcel parcel2, int i) {
                            parcel2.writeParcelable((Parcelable) this.mInner, i);
                        }
                    };
                default:
                    ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                    parcelableVolumeInfo.volumeType = parcel.readInt();
                    parcelableVolumeInfo.controlType = parcel.readInt();
                    parcelableVolumeInfo.maxVolume = parcel.readInt();
                    parcelableVolumeInfo.currentVolume = parcel.readInt();
                    parcelableVolumeInfo.audioStream = parcel.readInt();
                    return parcelableVolumeInfo;
            }
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            switch (this.$r8$classId) {
                case 0:
                    return new PlaybackStateCompat[i];
                case 1:
                    return new MediaSessionCompat$ResultReceiverWrapper[i];
                case 2:
                    return new MediaSessionCompat$QueueItem[i];
                case 3:
                    return new MediaSessionCompat$Token[i];
                default:
                    return new ParcelableVolumeInfo[i];
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new AnonymousClass1();
        public final String mAction;
        public final Bundle mExtras;
        public final int mIcon;
        public final CharSequence mName;

        /* JADX INFO: renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class AnonymousClass1 implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i) {
                return new CustomAction[i];
            }
        }

        public CustomAction(Parcel parcel) {
            this.mAction = parcel.readString();
            this.mName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.mIcon = parcel.readInt();
            this.mExtras = parcel.readBundle(LifecyclesKt.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.mName) + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, parcel, i);
            parcel.writeInt(this.mIcon);
            parcel.writeBundle(this.mExtras);
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.mPosition = parcel.readLong();
        this.mSpeed = parcel.readFloat();
        this.mUpdateTime = parcel.readLong();
        this.mBufferedPosition = parcel.readLong();
        this.mActions = parcel.readLong();
        this.mErrorMessage = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mCustomActions = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = parcel.readLong();
        this.mExtras = parcel.readBundle(LifecyclesKt.class.getClassLoader());
        this.mErrorCode = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {state=");
        sb.append(this.mState);
        sb.append(", position=");
        sb.append(this.mPosition);
        sb.append(", buffered position=");
        sb.append(this.mBufferedPosition);
        sb.append(", speed=");
        sb.append(this.mSpeed);
        sb.append(", updated=");
        sb.append(this.mUpdateTime);
        sb.append(", actions=");
        sb.append(this.mActions);
        sb.append(", error code=");
        sb.append(this.mErrorCode);
        sb.append(", error message=");
        sb.append(this.mErrorMessage);
        sb.append(", custom actions=");
        sb.append(this.mCustomActions);
        sb.append(", active item id=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.mActiveItemId, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mPosition);
        parcel.writeFloat(this.mSpeed);
        parcel.writeLong(this.mUpdateTime);
        parcel.writeLong(this.mBufferedPosition);
        parcel.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, parcel, i);
        parcel.writeTypedList(this.mCustomActions);
        parcel.writeLong(this.mActiveItemId);
        parcel.writeBundle(this.mExtras);
        parcel.writeInt(this.mErrorCode);
    }
}
