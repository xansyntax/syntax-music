package androidx.media3.extractor.metadata.vorbis;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import coil3.util.LifecyclesKt;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VorbisComment implements Metadata.Entry {
    public final String key;
    public final String value;

    public VorbisComment(String str, String str2) {
        this.key = LifecyclesKt.toUpperCase(str);
        this.value = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && VorbisComment.class == obj.getClass()) {
            VorbisComment vorbisComment = (VorbisComment) obj;
            if (this.key.equals(vorbisComment.key) && this.value.equals(vorbisComment.value)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.value.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(527, 31, this.key);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.media3.common.Metadata.Entry
    public final void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.key;
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1935137620:
                if (str.equals("TOTALTRACKS")) {
                    b = 0;
                }
                break;
            case -215998278:
                if (str.equals("TOTALDISCS")) {
                    b = 1;
                }
                break;
            case -113312716:
                if (str.equals("TRACKNUMBER")) {
                    b = 2;
                }
                break;
            case 62359119:
                if (str.equals("ALBUM")) {
                    b = 3;
                }
                break;
            case 67703139:
                if (str.equals("GENRE")) {
                    b = 4;
                }
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    b = 5;
                }
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    b = 6;
                }
                break;
            case 993300766:
                if (str.equals("DISCNUMBER")) {
                    b = 7;
                }
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    b = 8;
                }
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    b = 9;
                }
                break;
        }
        String str2 = this.value;
        switch (b) {
            case 0:
                Integer numTryParse = StringsKt__IndentKt.tryParse(str2);
                if (numTryParse != null) {
                    builder.totalTrackCount = numTryParse;
                }
                break;
            case 1:
                Integer numTryParse2 = StringsKt__IndentKt.tryParse(str2);
                if (numTryParse2 != null) {
                    builder.totalDiscCount = numTryParse2;
                }
                break;
            case 2:
                Integer numTryParse3 = StringsKt__IndentKt.tryParse(str2);
                if (numTryParse3 != null) {
                    builder.trackNumber = numTryParse3;
                }
                break;
            case 3:
                builder.albumTitle = str2;
                break;
            case 4:
                builder.genre = str2;
                break;
            case 5:
                builder.title = str2;
                break;
            case 6:
                builder.description = str2;
                break;
            case 7:
                Integer numTryParse4 = StringsKt__IndentKt.tryParse(str2);
                if (numTryParse4 != null) {
                    builder.discNumber = numTryParse4;
                }
                break;
            case 8:
                builder.albumArtist = str2;
                break;
            case 9:
                builder.artist = str2;
                break;
        }
    }

    public final String toString() {
        return "VC: " + this.key + "=" + this.value;
    }
}
