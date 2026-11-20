package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.legacy.MediaSessionCompat$MediaSessionImplApi23;
import androidx.navigation.NavDeepLinkRequest;
import com.yalantis.ucrop.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$Builder {
    public final String mChannelId;
    public PendingIntent mContentIntent;
    public CharSequence mContentText;
    public CharSequence mContentTitle;
    public final Context mContext;
    public Bundle mExtras;
    public String mGroupKey;
    public IconCompat mLargeIcon;
    public final Notification mNotification;
    public final ArrayList mPeople;
    public int mPriority;
    public NavDeepLinkRequest mStyle;
    public boolean mUseChronometer;
    public final ArrayList mActions = new ArrayList();
    public final ArrayList mPersonList = new ArrayList();
    public final ArrayList mInvisibleActions = new ArrayList();
    public boolean mShowWhen = true;
    public int mVisibility = 0;
    public byte mFgsDeferBehavior = 0;

    public NotificationCompat$Builder(Context context, String str) {
        Notification notification = new Notification();
        this.mNotification = notification;
        this.mContext = context;
        this.mChannelId = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.mPriority = 0;
        this.mPeople = new ArrayList();
    }

    public static CharSequence limitCharSequenceLength(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final void addAction(String str, PendingIntent pendingIntent) {
        this.mActions.add(new NotificationCompat$Action(null, str, pendingIntent));
    }

    public final Notification build() {
        EmojiProcessor emojiProcessor = new EmojiProcessor(this);
        NotificationCompat$Builder notificationCompat$Builder = (NotificationCompat$Builder) emojiProcessor.mMetadataRepo;
        NavDeepLinkRequest navDeepLinkRequest = notificationCompat$Builder.mStyle;
        if (navDeepLinkRequest != null) {
            Notification.Builder builder = (Notification.Builder) emojiProcessor.mSpanFactory;
            Notification.MediaStyle mediaStyle = new Notification.MediaStyle();
            MediaLibraryService.MediaLibrarySession mediaLibrarySession = (MediaLibraryService.MediaLibrarySession) navDeepLinkRequest.action;
            Notification.MediaStyle mediaSession = mediaStyle.setMediaSession(((MediaSessionCompat$MediaSessionImplApi23) mediaLibrarySession.impl.sessionLegacyStub.sessionCompat.mCallback).token.inner);
            int[] iArr = (int[]) navDeepLinkRequest.mimeType;
            if (iArr != null) {
                mediaSession.setShowActionsInCompactView(iArr);
            }
            builder.setStyle(mediaSession);
            Bundle bundle = new Bundle();
            bundle.putBundle("androidx.media3.session", mediaLibrarySession.impl.sessionToken.toBundle());
            builder.addExtras(bundle);
        }
        Notification notificationBuild = ((Notification.Builder) emojiProcessor.mSpanFactory).build();
        if (navDeepLinkRequest != null) {
            notificationCompat$Builder.mStyle.getClass();
        }
        if (navDeepLinkRequest != null) {
            Bundle bundle2 = notificationBuild.extras;
        }
        return notificationBuild;
    }

    public final void setFlag(int i, boolean z) {
        Notification notification = this.mNotification;
        int i2 = notification.flags;
        if (z) {
            notification.flags = i | i2;
        } else {
            notification.flags = (~i) & i2;
        }
    }

    public final void setLargeIcon(Bitmap bitmap) {
        IconCompat iconCompat;
        if (bitmap == null) {
            iconCompat = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = this.mContext.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
                }
            }
            PorterDuff.Mode mode = IconCompat.DEFAULT_TINT_MODE;
            bitmap.getClass();
            IconCompat iconCompat2 = new IconCompat(1);
            iconCompat2.mObj1 = bitmap;
            iconCompat = iconCompat2;
        }
        this.mLargeIcon = iconCompat;
    }

    public final void setStyle(NavDeepLinkRequest navDeepLinkRequest) {
        if (this.mStyle != navDeepLinkRequest) {
            this.mStyle = navDeepLinkRequest;
            if (((NotificationCompat$Builder) navDeepLinkRequest.uri) != this) {
                navDeepLinkRequest.uri = this;
                setStyle(navDeepLinkRequest);
            }
        }
    }
}
