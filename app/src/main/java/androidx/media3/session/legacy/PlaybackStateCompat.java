package androidx.media3.session.legacy;

import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.provider.CallbackWrapper;
import androidx.fragment.app.FragmentState;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new FragmentState.AnonymousClass1((byte) 23);
    public final long actions;
    public final long activeItemId;
    public final long bufferedPosition;
    public final List customActions;
    public final int errorCode;
    public final CharSequence errorMessage;
    public final Bundle extras;
    public final long position;
    public final float speed;
    public final int state;
    public PlaybackState stateFwk;
    public final long updateTime;

    public PlaybackStateCompat(Parcel parcel) {
        this.state = parcel.readInt();
        this.position = parcel.readLong();
        this.speed = parcel.readFloat();
        this.updateTime = parcel.readLong();
        this.bufferedPosition = parcel.readLong();
        this.actions = parcel.readLong();
        this.errorMessage = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        List listCreateTypedArrayList = parcel.createTypedArrayList(CustomAction.CREATOR);
        if (listCreateTypedArrayList == null) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            listCreateTypedArrayList = RegularImmutableList.EMPTY;
        }
        this.customActions = listCreateTypedArrayList;
        this.activeItemId = parcel.readLong();
        this.extras = parcel.readBundle(CallbackWrapper.class.getClassLoader());
        this.errorCode = parcel.readInt();
    }

    public static PlaybackStateCompat fromPlaybackState(PlaybackState playbackState) {
        ArrayList arrayList = null;
        if (playbackState == null) {
            return null;
        }
        List<PlaybackState.CustomAction> customActions = playbackState.getCustomActions();
        if (customActions != null) {
            arrayList = new ArrayList(customActions.size());
            for (PlaybackState.CustomAction customAction : customActions) {
                if (customAction != null) {
                    CustomAction customAction2 = new CustomAction(customAction.getAction(), customAction.getName(), customAction.getIcon(), Util.convertToNullIfInvalid(customAction.getExtras()));
                    customAction2.customActionFwk = customAction;
                    arrayList.add(customAction2);
                }
            }
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(playbackState.getState(), playbackState.getPosition(), playbackState.getBufferedPosition(), playbackState.getPlaybackSpeed(), playbackState.getActions(), 0, playbackState.getErrorMessage(), playbackState.getLastPositionUpdateTime(), arrayList, playbackState.getActiveQueueItemId(), Util.convertToNullIfInvalid(playbackState.getExtras()));
        playbackStateCompat.stateFwk = playbackState;
        return playbackStateCompat;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {state=");
        sb.append(this.state);
        sb.append(", position=");
        sb.append(this.position);
        sb.append(", buffered position=");
        sb.append(this.bufferedPosition);
        sb.append(", speed=");
        sb.append(this.speed);
        sb.append(", updated=");
        sb.append(this.updateTime);
        sb.append(", actions=");
        sb.append(this.actions);
        sb.append(", error code=");
        sb.append(this.errorCode);
        sb.append(", error message=");
        sb.append(this.errorMessage);
        sb.append(", custom actions=");
        sb.append(this.customActions);
        sb.append(", active item id=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.activeItemId, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.state);
        parcel.writeLong(this.position);
        parcel.writeFloat(this.speed);
        parcel.writeLong(this.updateTime);
        parcel.writeLong(this.bufferedPosition);
        parcel.writeLong(this.actions);
        TextUtils.writeToParcel(this.errorMessage, parcel, i);
        parcel.writeTypedList(this.customActions);
        parcel.writeLong(this.activeItemId);
        parcel.writeBundle(this.extras);
        parcel.writeInt(this.errorCode);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new FragmentState.AnonymousClass1((byte) 24);
        public final String action;
        public PlaybackState.CustomAction customActionFwk;
        public final Bundle extras;
        public final int icon;
        public final CharSequence name;

        public CustomAction(Parcel parcel) {
            String string = parcel.readString();
            string.getClass();
            this.action = string;
            CharSequence charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            charSequence.getClass();
            this.name = charSequence;
            this.icon = parcel.readInt();
            this.extras = parcel.readBundle(CallbackWrapper.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.name) + ", mIcon=" + this.icon + ", mExtras=" + this.extras;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.action);
            TextUtils.writeToParcel(this.name, parcel, i);
            parcel.writeInt(this.icon);
            parcel.writeBundle(this.extras);
        }

        public CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.action = str;
            this.name = charSequence;
            this.icon = i;
            this.extras = bundle;
        }
    }

    public PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, ArrayList arrayList, long j5, Bundle bundle) {
        List arrayList2;
        this.state = i;
        this.position = j;
        this.bufferedPosition = j2;
        this.speed = f;
        this.actions = j3;
        this.errorCode = i2;
        this.errorMessage = charSequence;
        this.updateTime = j4;
        if (arrayList == null) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            arrayList2 = RegularImmutableList.EMPTY;
        } else {
            arrayList2 = new ArrayList(arrayList);
        }
        this.customActions = arrayList2;
        this.activeItemId = j5;
        this.extras = bundle;
    }
}
