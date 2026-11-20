package androidx.media3.extractor.metadata.id3;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CommentFrame extends Id3Frame {
    public final String description;
    public final String language;
    public final String text;

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.language = str;
        this.description = str2;
        this.text = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentFrame.class != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        return this.description.equals(commentFrame.description) && this.language.equals(commentFrame.language) && Objects.equals(this.text, commentFrame.text);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(527, 31, this.language), 31, this.description);
        String str = this.text;
        return iM + (str != null ? str.hashCode() : 0);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.id + ": language=" + this.language + ", description=" + this.description + ", text=" + this.text;
    }
}
