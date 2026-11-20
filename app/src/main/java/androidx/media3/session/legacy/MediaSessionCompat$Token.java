package androidx.media3.session.legacy;

import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentState;
import androidx.versionedparcelable.VersionedParcelable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionCompat$Token implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new FragmentState.AnonymousClass1((byte) 22);
    public IMediaSession extraBinder;
    public final MediaSession.Token inner;
    public final Object lock = new Object();
    public VersionedParcelable session2Token = null;

    public MediaSessionCompat$Token(MediaSession.Token token, IMediaSession iMediaSession) {
        this.inner = token;
        this.extraBinder = iMediaSession;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaSessionCompat$Token) {
            return this.inner.equals(((MediaSessionCompat$Token) obj).inner);
        }
        return false;
    }

    public final IMediaSession getExtraBinder() {
        IMediaSession iMediaSession;
        synchronized (this.lock) {
            iMediaSession = this.extraBinder;
        }
        return iMediaSession;
    }

    public final int hashCode() {
        return this.inner.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.inner, i);
    }
}
