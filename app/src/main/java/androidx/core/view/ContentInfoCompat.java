package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.Locale;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentInfoCompat {
    public final Compat mCompat;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface BuilderCompat {
        ContentInfoCompat build();

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setLinkUri(Uri uri);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Compat {
        ClipData getClip();

        int getFlags();

        int getSource();

        ContentInfo getWrapped();
    }

    public ContentInfoCompat(Compat compat) {
        this.mCompat = compat;
    }

    public final String toString() {
        return this.mCompat.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CompatImpl implements BuilderCompat, Compat {
        public final /* synthetic */ byte $r8$classId = 1;
        public ClipData mClip;
        public Bundle mExtras;
        public int mFlags;
        public Uri mLinkUri;
        public byte mSource;

        public CompatImpl(CompatImpl compatImpl) {
            ClipData clipData = compatImpl.mClip;
            clipData.getClass();
            this.mClip = clipData;
            byte b = compatImpl.mSource;
            if (b < 0) {
                Locale locale = Locale.US;
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("source is out of range of [0, 5] (too low)");
                throw null;
            }
            if (b > 5) {
                Locale locale2 = Locale.US;
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("source is out of range of [0, 5] (too high)");
                throw null;
            }
            this.mSource = b;
            int i = compatImpl.mFlags;
            if ((i & 1) == i) {
                this.mFlags = i;
                this.mLinkUri = compatImpl.mLinkUri;
                this.mExtras = compatImpl.mExtras;
                return;
            }
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return this.mClip;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.mFlags;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.mSource;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return null;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            this.mExtras = bundle;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int i) {
            this.mFlags = i;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri uri) {
            this.mLinkUri = uri;
        }

        public String toString() {
            String strValueOf;
            String str;
            switch (this.$r8$classId) {
                case 0:
                    Uri uri = this.mLinkUri;
                    StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                    sb.append(this.mClip.getDescription());
                    sb.append(", source=");
                    byte b = this.mSource;
                    if (b == 0) {
                        strValueOf = "SOURCE_APP";
                    } else if (b == 1) {
                        strValueOf = "SOURCE_CLIPBOARD";
                    } else if (b == 2) {
                        strValueOf = "SOURCE_INPUT_METHOD";
                    } else if (b == 3) {
                        strValueOf = "SOURCE_DRAG_AND_DROP";
                    } else if (b != 4) {
                        strValueOf = b != 5 ? String.valueOf((int) b) : "SOURCE_PROCESS_TEXT";
                    } else {
                        strValueOf = "SOURCE_AUTOFILL";
                    }
                    sb.append(strValueOf);
                    sb.append(", flags=");
                    int i = this.mFlags;
                    sb.append((i & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i));
                    if (uri == null) {
                        str = "";
                    } else {
                        str = ", hasLinkUri(" + uri.toString().length() + ")";
                    }
                    sb.append(str);
                    return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.mExtras != null ? ", hasExtras" : "", "}");
                default:
                    return super.toString();
            }
        }

        public /* synthetic */ CompatImpl() {
        }
    }
}
