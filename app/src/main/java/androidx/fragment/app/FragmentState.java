package androidx.fragment.app;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.os.IResultReceiver;
import android.support.v4.os.IResultReceiver$Stub$Proxy;
import android.support.v4.os.ResultReceiver;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.widget.NestedScrollView;
import androidx.media3.exoplayer.offline.DownloadRequest;
import androidx.media3.exoplayer.scheduler.Requirements;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaSessionCompat$QueueItem;
import androidx.media3.session.legacy.MediaSessionCompat$Token;
import androidx.media3.session.legacy.PlaybackStateCompat;
import androidx.versionedparcelable.ParcelImpl;
import coil3.util.LifecyclesKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new AnonymousClass1(0);
    public final Bundle mArguments;
    public final String mClassName;
    public final int mContainerId;
    public final boolean mDetached;
    public final int mFragmentId;
    public final boolean mFromLayout;
    public final boolean mHidden;
    public final int mMaxLifecycleState;
    public final boolean mRemoving;
    public final boolean mRetainInstance;
    public Bundle mSavedFragmentState;
    public final String mTag;
    public final String mWho;

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Parcelable.Creator {
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ AnonymousClass1(byte b) {
            this.$r8$classId = b;
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            Bundle bundle = null;
            IResultReceiver iResultReceiver = null;
            switch (this.$r8$classId) {
                case 0:
                    return new FragmentState(parcel);
                case 1:
                    return new MediaBrowserCompat$MediaItem(parcel);
                case 2:
                    Object objCreateFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
                    if (objCreateFromParcel == null) {
                        return null;
                    }
                    MediaDescription mediaDescription = (MediaDescription) objCreateFromParcel;
                    String mediaId = MediaDescriptionCompat.Api21Impl.getMediaId(mediaDescription);
                    CharSequence title = MediaDescriptionCompat.Api21Impl.getTitle(mediaDescription);
                    CharSequence subtitle = MediaDescriptionCompat.Api21Impl.getSubtitle(mediaDescription);
                    CharSequence description = MediaDescriptionCompat.Api21Impl.getDescription(mediaDescription);
                    Bitmap iconBitmap = MediaDescriptionCompat.Api21Impl.getIconBitmap(mediaDescription);
                    Uri iconUri = MediaDescriptionCompat.Api21Impl.getIconUri(mediaDescription);
                    Bundle extras = MediaDescriptionCompat.Api21Impl.getExtras(mediaDescription);
                    if (extras != null) {
                        extras = LifecyclesKt.unparcelWithClassLoader(extras);
                    }
                    Uri mediaUri = extras != null ? (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI") : null;
                    if (mediaUri == null) {
                        bundle = extras;
                    } else if (!extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || extras.size() != 2) {
                        extras.remove("android.support.v4.media.description.MEDIA_URI");
                        extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                        bundle = extras;
                    }
                    if (mediaUri == null) {
                        mediaUri = MediaDescriptionCompat.Api23Impl.getMediaUri(mediaDescription);
                    }
                    MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, mediaUri);
                    mediaDescriptionCompat.mDescriptionFwk = mediaDescription;
                    return mediaDescriptionCompat;
                case 3:
                    return new MediaMetadataCompat(parcel);
                case 4:
                    return new RatingCompat(parcel.readInt(), parcel.readFloat());
                case 5:
                    ResultReceiver resultReceiver = new ResultReceiver();
                    IBinder strongBinder = parcel.readStrongBinder();
                    int i = ResultReceiver.MyResultReceiver.$r8$clinit;
                    if (strongBinder != null) {
                        IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(IResultReceiver.DESCRIPTOR);
                        if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IResultReceiver)) {
                            IResultReceiver$Stub$Proxy iResultReceiver$Stub$Proxy = new IResultReceiver$Stub$Proxy();
                            iResultReceiver$Stub$Proxy.mRemote = strongBinder;
                            iResultReceiver = iResultReceiver$Stub$Proxy;
                        } else {
                            iResultReceiver = (IResultReceiver) iInterfaceQueryLocalInterface;
                        }
                    }
                    resultReceiver.mReceiver = iResultReceiver;
                    return resultReceiver;
                case 6:
                    parcel.getClass();
                    return new ActivityResult(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                case 7:
                    parcel.getClass();
                    Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                    parcelable.getClass();
                    return new IntentSenderRequest((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
                case 8:
                    AppCompatSpinner.SavedState savedState = new AppCompatSpinner.SavedState(parcel);
                    savedState.mShowDropdown = parcel.readByte() != 0;
                    return savedState;
                case 9:
                    NestedScrollView.SavedState savedState2 = new NestedScrollView.SavedState(parcel);
                    savedState2.scrollPosition = parcel.readInt();
                    return savedState2;
                case 10:
                    return new BackStackRecordState(parcel);
                case 11:
                    return new BackStackState(parcel);
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    FragmentManager.LaunchedFragmentInfo launchedFragmentInfo = new FragmentManager.LaunchedFragmentInfo();
                    launchedFragmentInfo.mWho = parcel.readString();
                    launchedFragmentInfo.mRequestCode = parcel.readInt();
                    return launchedFragmentInfo;
                case 13:
                    FragmentManagerState fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.mPrimaryNavActiveWho = null;
                    fragmentManagerState.mBackStackStateKeys = new ArrayList();
                    fragmentManagerState.mBackStackStates = new ArrayList();
                    fragmentManagerState.mActive = parcel.createStringArrayList();
                    fragmentManagerState.mAdded = parcel.createStringArrayList();
                    fragmentManagerState.mBackStack = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
                    fragmentManagerState.mBackStackIndex = parcel.readInt();
                    fragmentManagerState.mPrimaryNavActiveWho = parcel.readString();
                    fragmentManagerState.mBackStackStateKeys = parcel.createStringArrayList();
                    fragmentManagerState.mBackStackStates = parcel.createTypedArrayList(BackStackState.CREATOR);
                    fragmentManagerState.mLaunchedFragments = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
                    return fragmentManagerState;
                case 14:
                    return new DownloadRequest(parcel);
                case 15:
                    return new DownloadRequest.ByteRange(parcel);
                case 16:
                    return new DownloadRequest.TimeRange(parcel);
                case 17:
                    return new Requirements(parcel.readInt());
                case 18:
                    return new MediaBrowserCompat.MediaItem(parcel);
                case 19:
                    return androidx.media3.session.legacy.MediaDescriptionCompat.fromMediaDescription((MediaDescription) MediaDescription.CREATOR.createFromParcel(parcel));
                case 20:
                    return new androidx.media3.session.legacy.MediaMetadataCompat(parcel);
                case 21:
                    return new MediaSessionCompat$QueueItem(parcel);
                case 22:
                    MediaSession.Token token = (MediaSession.Token) parcel.readParcelable(null);
                    token.getClass();
                    return new MediaSessionCompat$Token(token, null);
                case 23:
                    return new PlaybackStateCompat(parcel);
                case 24:
                    return new PlaybackStateCompat.CustomAction(parcel);
                case 25:
                    return new androidx.media3.session.legacy.RatingCompat(parcel.readInt(), parcel.readFloat());
                default:
                    return new ParcelImpl(parcel);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            switch (this.$r8$classId) {
                case 0:
                    return new FragmentState[i];
                case 1:
                    return new MediaBrowserCompat$MediaItem[i];
                case 2:
                    return new MediaDescriptionCompat[i];
                case 3:
                    return new MediaMetadataCompat[i];
                case 4:
                    return new RatingCompat[i];
                case 5:
                    return new ResultReceiver[i];
                case 6:
                    return new ActivityResult[i];
                case 7:
                    return new IntentSenderRequest[i];
                case 8:
                    return new AppCompatSpinner.SavedState[i];
                case 9:
                    return new NestedScrollView.SavedState[i];
                case 10:
                    return new BackStackRecordState[i];
                case 11:
                    return new BackStackState[i];
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return new FragmentManager.LaunchedFragmentInfo[i];
                case 13:
                    return new FragmentManagerState[i];
                case 14:
                    return new DownloadRequest[i];
                case 15:
                    return new DownloadRequest.ByteRange[i];
                case 16:
                    return new DownloadRequest.TimeRange[i];
                case 17:
                    return new Requirements[i];
                case 18:
                    return new MediaBrowserCompat.MediaItem[i];
                case 19:
                    return new androidx.media3.session.legacy.MediaDescriptionCompat[i];
                case 20:
                    return new androidx.media3.session.legacy.MediaMetadataCompat[i];
                case 21:
                    return new MediaSessionCompat$QueueItem[i];
                case 22:
                    return new MediaSessionCompat$Token[i];
                case 23:
                    return new PlaybackStateCompat[i];
                case 24:
                    return new PlaybackStateCompat.CustomAction[i];
                case 25:
                    return new androidx.media3.session.legacy.RatingCompat[i];
                default:
                    return new ParcelImpl[i];
            }
        }
    }

    public FragmentState(Parcel parcel) {
        this.mClassName = parcel.readString();
        this.mWho = parcel.readString();
        this.mFromLayout = parcel.readInt() != 0;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mRetainInstance = parcel.readInt() != 0;
        this.mRemoving = parcel.readInt() != 0;
        this.mDetached = parcel.readInt() != 0;
        this.mArguments = parcel.readBundle();
        this.mHidden = parcel.readInt() != 0;
        this.mSavedFragmentState = parcel.readBundle();
        this.mMaxLifecycleState = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.mClassName);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")}:");
        if (this.mFromLayout) {
            sb.append(" fromLayout");
        }
        int i = this.mContainerId;
        if (i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i));
        }
        String str = this.mTag;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.mRetainInstance) {
            sb.append(" retainInstance");
        }
        if (this.mRemoving) {
            sb.append(" removing");
        }
        if (this.mDetached) {
            sb.append(" detached");
        }
        if (this.mHidden) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mClassName);
        parcel.writeString(this.mWho);
        parcel.writeInt(this.mFromLayout ? 1 : 0);
        parcel.writeInt(this.mFragmentId);
        parcel.writeInt(this.mContainerId);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.mRetainInstance ? 1 : 0);
        parcel.writeInt(this.mRemoving ? 1 : 0);
        parcel.writeInt(this.mDetached ? 1 : 0);
        parcel.writeBundle(this.mArguments);
        parcel.writeInt(this.mHidden ? 1 : 0);
        parcel.writeBundle(this.mSavedFragmentState);
        parcel.writeInt(this.mMaxLifecycleState);
    }

    public FragmentState(Fragment fragment) {
        this.mClassName = fragment.getClass().getName();
        this.mWho = fragment.mWho;
        this.mFromLayout = fragment.mFromLayout;
        this.mFragmentId = fragment.mFragmentId;
        this.mContainerId = fragment.mContainerId;
        this.mTag = fragment.mTag;
        this.mRetainInstance = fragment.mRetainInstance;
        this.mRemoving = fragment.mRemoving;
        this.mDetached = fragment.mDetached;
        this.mArguments = fragment.mArguments;
        this.mHidden = fragment.mHidden;
        this.mMaxLifecycleState = fragment.mMaxState.ordinal();
    }
}
