package androidx.compose.ui.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LinkAnnotation implements AnnotatedString.Annotation {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Clickable extends LinkAnnotation {
        public final TextLinkScope$$ExternalSyntheticLambda10 linkInteractionListener;
        public final TextLinkStyles styles;
        public final String tag;

        public Clickable(String str, TextLinkStyles textLinkStyles, TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda10) {
            this.tag = str;
            this.styles = textLinkStyles;
            this.linkInteractionListener = textLinkScope$$ExternalSyntheticLambda10;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Clickable)) {
                return false;
            }
            Clickable clickable = (Clickable) obj;
            return Intrinsics.areEqual(this.tag, clickable.tag) && Intrinsics.areEqual(this.styles, clickable.styles) && Intrinsics.areEqual(this.linkInteractionListener, clickable.linkInteractionListener);
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public final TextLinkScope$$ExternalSyntheticLambda10 getLinkInteractionListener() {
            return this.linkInteractionListener;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public final TextLinkStyles getStyles() {
            return this.styles;
        }

        public final int hashCode() {
            int iHashCode = this.tag.hashCode() * 31;
            TextLinkStyles textLinkStyles = this.styles;
            int iHashCode2 = (iHashCode + (textLinkStyles != null ? textLinkStyles.hashCode() : 0)) * 31;
            TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda10 = this.linkInteractionListener;
            return iHashCode2 + (textLinkScope$$ExternalSyntheticLambda10 != null ? textLinkScope$$ExternalSyntheticLambda10.hashCode() : 0);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("LinkAnnotation.Clickable(tag=", this.tag, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Url extends LinkAnnotation {
        public final TextLinkScope$$ExternalSyntheticLambda10 linkInteractionListener;
        public final TextLinkStyles styles;
        public final String url;

        public Url(String str, TextLinkStyles textLinkStyles, TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda10) {
            this.url = str;
            this.styles = textLinkStyles;
            this.linkInteractionListener = textLinkScope$$ExternalSyntheticLambda10;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Url)) {
                return false;
            }
            Url url = (Url) obj;
            return Intrinsics.areEqual(this.url, url.url) && Intrinsics.areEqual(this.styles, url.styles) && Intrinsics.areEqual(this.linkInteractionListener, url.linkInteractionListener);
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public final TextLinkScope$$ExternalSyntheticLambda10 getLinkInteractionListener() {
            return this.linkInteractionListener;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public final TextLinkStyles getStyles() {
            return this.styles;
        }

        public final int hashCode() {
            int iHashCode = this.url.hashCode() * 31;
            TextLinkStyles textLinkStyles = this.styles;
            int iHashCode2 = (iHashCode + (textLinkStyles != null ? textLinkStyles.hashCode() : 0)) * 31;
            TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda10 = this.linkInteractionListener;
            return iHashCode2 + (textLinkScope$$ExternalSyntheticLambda10 != null ? textLinkScope$$ExternalSyntheticLambda10.hashCode() : 0);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("LinkAnnotation.Url(url=", this.url, ")");
        }
    }

    public abstract TextLinkScope$$ExternalSyntheticLambda10 getLinkInteractionListener();

    public abstract TextLinkStyles getStyles();
}
