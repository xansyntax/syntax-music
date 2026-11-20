package androidx.media3.session.legacy;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Rating;
import android.media.browse.MediaBrowser;
import android.media.session.MediaController;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.provider.Settings;
import android.service.media.MediaBrowserService;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.provider.CallbackWrapper;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.FragmentState;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaSessionImpl$MediaPlayPauseKeyHandler;
import com.google.common.base.Splitter;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompat {
    public static final Object lock = new Object();
    public static volatile MediaBrowserCompat sessionManager;
    public Object impl;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaBrowserImplApi26 {
        public final MediaBrowser browserFwk;
        public Messenger callbacksMessenger;
        public final Context context;
        public MediaSessionCompat$Token mediaSessionToken;
        public final Bundle rootHints;
        public CallbackWrapper serviceBinderWrapper;
        public final MediaSessionImpl$MediaPlayPauseKeyHandler handler = new MediaSessionImpl$MediaPlayPauseKeyHandler(this);
        public final ArrayMap subscriptions = new ArrayMap(0);

        public MediaBrowserImplApi26(Context context, ComponentName componentName, EmojiProcessor emojiProcessor, Bundle bundle) {
            this.context = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.rootHints = bundle2;
            bundle2.putInt("extra_client_version", 1);
            bundle2.putInt("extra_calling_pid", Process.myPid());
            emojiProcessor.mMetadataRepo = this;
            MediaBrowserCompat$ConnectionCallback$ConnectionCallbackImpl mediaBrowserCompat$ConnectionCallback$ConnectionCallbackImpl = (MediaBrowserCompat$ConnectionCallback$ConnectionCallbackImpl) emojiProcessor.mSpanFactory;
            mediaBrowserCompat$ConnectionCallback$ConnectionCallbackImpl.getClass();
            this.browserFwk = new MediaBrowser(context, componentName, mediaBrowserCompat$ConnectionCallback$ConnectionCallbackImpl, bundle2);
        }
    }

    public /* synthetic */ MediaBrowserCompat(Object obj) {
        this.impl = obj;
    }

    public static MediaBrowserCompat getSessionManager(Context context) {
        MediaBrowserCompat mediaBrowserCompat;
        synchronized (lock) {
            try {
                if (sessionManager == null) {
                    Context applicationContext = context.getApplicationContext();
                    MediaBrowserCompat mediaBrowserCompat2 = new MediaBrowserCompat();
                    Splitter splitter = new Splitter();
                    splitter.trimmer = applicationContext;
                    splitter.strategy = applicationContext.getContentResolver();
                    mediaBrowserCompat2.impl = splitter;
                    sessionManager = mediaBrowserCompat2;
                }
                mediaBrowserCompat = sessionManager;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaBrowserCompat;
    }

    public boolean isTrustedForMediaControl(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo) {
        Splitter splitter = (Splitter) this.impl;
        MediaSessionManager$RemoteUserInfoImplBase mediaSessionManager$RemoteUserInfoImplBase = mediaSessionManager$RemoteUserInfo.impl;
        Context context = (Context) splitter.trimmer;
        int i = mediaSessionManager$RemoteUserInfoImplBase.uid;
        String str = mediaSessionManager$RemoteUserInfoImplBase.packageName;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                if (Build.VERSION.SDK_INT < 28) {
                    i = applicationInfo.uid;
                }
                if (i == 1000 || i == Process.myUid() || context.checkPermission("android.permission.MEDIA_CONTENT_CONTROL", mediaSessionManager$RemoteUserInfoImplBase.pid, mediaSessionManager$RemoteUserInfoImplBase.uid) == 0 || splitter.isPermissionGranted(mediaSessionManager$RemoteUserInfoImplBase, "android.permission.STATUS_BAR_SERVICE") || splitter.isPermissionGranted(mediaSessionManager$RemoteUserInfoImplBase, "android.permission.MEDIA_CONTENT_CONTROL")) {
                    return true;
                }
                String string = Settings.Secure.getString((ContentResolver) splitter.strategy, "enabled_notification_listeners");
                if (string != null) {
                    for (String str2 : string.split(ServerSentEventKt.COLON)) {
                        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str2);
                        if (componentNameUnflattenFromString != null && componentNameUnflattenFromString.getPackageName().equals(str)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.d("Package " + str + " doesn't exist");
            return false;
        }
    }

    public void onLoadChildren(Bundle bundle, String str, List list) throws RemoteException {
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", str);
        bundle2.putBundle("data_options", bundle);
        bundle2.putBundle("data_notify_children_changed_options", null);
        if (list != null) {
            bundle2.putParcelableArrayList("data_media_item_list", DatabaseDao_Impl.AnonymousClass17.convertList(list, android.support.v4.media.MediaBrowserCompat$MediaItem.CREATOR));
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.arg1 = 2;
        messageObtain.setData(bundle2);
        ((Messenger) this.impl).send(messageObtain);
    }

    public void putBitmap(String str, Bitmap bitmap) {
        Integer num = (Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str);
        if (num == null || num.intValue() == 2) {
            ((Bundle) this.impl).putParcelable(str, bitmap);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m("The ", str, " key cannot be used to put a Bitmap"));
        }
    }

    public void putLong(long j, String str) {
        Integer num = (Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str);
        if (num == null || num.intValue() == 0) {
            ((Bundle) this.impl).putLong(str, j);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m("The ", str, " key cannot be used to put a long"));
        }
    }

    public void putRating(String str, RatingCompat ratingCompat) {
        float f = ratingCompat.ratingValue;
        Integer num = (Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str);
        if (num != null && num.intValue() != 3) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m("The ", str, " key cannot be used to put a Rating"));
            return;
        }
        Bundle bundle = (Bundle) this.impl;
        Object objNewUnratedRating = ratingCompat.ratingObj;
        if (objNewUnratedRating == null) {
            boolean zIsRated = ratingCompat.isRated();
            int i = ratingCompat.ratingStyle;
            if (zIsRated) {
                switch (i) {
                    case 1:
                        objNewUnratedRating = Rating.newHeartRating(i == 1 && f == 1.0f);
                        ratingCompat.ratingObj = objNewUnratedRating;
                        break;
                    case 2:
                        objNewUnratedRating = Rating.newThumbRating(i == 2 && f == 1.0f);
                        ratingCompat.ratingObj = objNewUnratedRating;
                        break;
                    case 3:
                    case 4:
                    case 5:
                        objNewUnratedRating = Rating.newStarRating(i, ratingCompat.getStarRating());
                        ratingCompat.ratingObj = objNewUnratedRating;
                        break;
                    case 6:
                        if (i != 6 || !ratingCompat.isRated()) {
                            f = -1.0f;
                        }
                        objNewUnratedRating = Rating.newPercentageRating(f);
                        ratingCompat.ratingObj = objNewUnratedRating;
                        break;
                    default:
                        objNewUnratedRating = null;
                        break;
                }
            } else {
                objNewUnratedRating = Rating.newUnratedRating(i);
                ratingCompat.ratingObj = objNewUnratedRating;
            }
        }
        bundle.putParcelable(str, (Parcelable) objNewUnratedRating);
    }

    public void putString(String str, String str2) {
        Integer num = (Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str);
        if (num == null || num.intValue() == 1) {
            ((Bundle) this.impl).putCharSequence(str, str2);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m("The ", str, " key cannot be used to put a String"));
        }
    }

    public void putText(CharSequence charSequence, String str) {
        Integer num = (Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str);
        if (num == null || num.intValue() == 1) {
            ((Bundle) this.impl).putCharSequence(str, charSequence);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m("The ", str, " key cannot be used to put a CharSequence"));
        }
    }

    public void sendCustomAction(String str, Bundle bundle) {
        if (str != null && ((str.equals("android.support.v4.media.session.action.FOLLOW") || str.equals("android.support.v4.media.session.action.UNFOLLOW")) && (bundle == null || !bundle.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE")))) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action ", str, "."));
        } else {
            ((MediaController.TransportControls) this.impl).sendCustomAction(str, bundle);
        }
    }

    public void sendResult(Object obj) {
        MediaBrowserService.Result result = (MediaBrowserService.Result) this.impl;
        if (!(obj instanceof List)) {
            if (!(obj instanceof Parcel)) {
                result.sendResult(null);
                return;
            }
            Parcel parcel = (Parcel) obj;
            parcel.setDataPosition(0);
            result.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
            return;
        }
        List<Parcel> list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        for (Parcel parcel2 : list) {
            parcel2.setDataPosition(0);
            arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel2));
            parcel2.recycle();
        }
        result.sendResult(arrayList);
    }

    public void setPlaybackSpeed(float f) {
        if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("speed must not be zero");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", f);
        sendCustomAction("android.support.v4.media.session.action.SET_PLAYBACK_SPEED", bundle);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new FragmentState.AnonymousClass1((byte) 18);
        public final MediaDescriptionCompat description;
        public final int flags;

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (TextUtils.isEmpty(mediaDescriptionCompat.mediaId)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("description must have a non-empty media id");
                throw null;
            }
            this.flags = i;
            this.description = mediaDescriptionCompat;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "MediaItem{mFlags=" + this.flags + ", mDescription=" + this.description + '}';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.flags);
            this.description.writeToParcel(parcel, i);
        }

        public MediaItem(Parcel parcel) {
            this.flags = parcel.readInt();
            this.description = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }
}
