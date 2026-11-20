package androidx.compose.ui.res;

import android.content.res.Resources;
import androidx.compose.ui.graphics.vector.ImageVector;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ImageVectorCache {
    public final HashMap map = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ImageVectorEntry {
        public final int configFlags;
        public final ImageVector imageVector;

        public ImageVectorEntry(ImageVector imageVector, int i) {
            this.imageVector = imageVector;
            this.configFlags = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ImageVectorEntry)) {
                return false;
            }
            ImageVectorEntry imageVectorEntry = (ImageVectorEntry) obj;
            return this.imageVector.equals(imageVectorEntry.imageVector) && this.configFlags == imageVectorEntry.configFlags;
        }

        public final int hashCode() {
            return Integer.hashCode(this.configFlags) + (this.imageVector.hashCode() * 31);
        }

        public final String toString() {
            return "ImageVectorEntry(imageVector=" + this.imageVector + ", configFlags=" + this.configFlags + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Key {
        public final int id;
        public final Resources.Theme theme;

        public Key(Resources.Theme theme, int i) {
            this.theme = theme;
            this.id = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return Intrinsics.areEqual(this.theme, key.theme) && this.id == key.id;
        }

        public final int hashCode() {
            return Integer.hashCode(this.id) + (this.theme.hashCode() * 31);
        }

        public final String toString() {
            return "Key(theme=" + this.theme + ", id=" + this.id + ")";
        }
    }
}
