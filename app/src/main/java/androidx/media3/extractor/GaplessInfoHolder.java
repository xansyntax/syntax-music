package androidx.media3.extractor;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import com.google.common.collect.ImmutableList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GaplessInfoHolder {
    public static final Pattern GAPLESS_COMMENT_PATTERN = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int encoderDelay = -1;
    public int encoderPadding = -1;

    public final boolean setFromComment(String str) {
        Matcher matcher = GAPLESS_COMMENT_PATTERN.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            String str2 = Util.DEVICE_DEBUG_INFO;
            int i = Integer.parseInt(strGroup, 16);
            int i2 = Integer.parseInt(matcher.group(2), 16);
            if (i <= 0 && i2 <= 0) {
                return false;
            }
            this.encoderDelay = i;
            this.encoderPadding = i2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x008d  */
    public final void setFromMetadata(Metadata metadata) {
        Metadata.Entry entry;
        metadata.getClass();
        ImmutableList.Builder builder = ImmutableList.builder();
        Metadata.Entry[] entryArr = metadata.entries;
        int length = entryArr.length;
        int i = 0;
        while (true) {
            Metadata.Entry entry2 = null;
            if (i >= length) {
                break;
            }
            Metadata.Entry entry3 = entryArr[i];
            if (CommentFrame.class.isAssignableFrom(entry3.getClass())) {
                Metadata.Entry entry4 = (Metadata.Entry) CommentFrame.class.cast(entry3);
                if (((CommentFrame) entry4).description.equals("iTunSMPB")) {
                    entry2 = entry4;
                }
            }
            if (entry2 != null) {
                builder.add((Object) entry2);
            }
            i++;
        }
        ImmutableList.Itr itrListIterator = builder.build().listIterator(0);
        while (itrListIterator.hasNext()) {
            if (setFromComment(((CommentFrame) itrListIterator.next()).text)) {
                return;
            }
        }
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (Metadata.Entry entry5 : entryArr) {
            if (InternalFrame.class.isAssignableFrom(entry5.getClass())) {
                entry = (Metadata.Entry) InternalFrame.class.cast(entry5);
                InternalFrame internalFrame = (InternalFrame) entry;
                if (!(internalFrame.domain.equals("com.apple.iTunes") && internalFrame.description.equals("iTunSMPB"))) {
                    entry = null;
                }
            } else {
                entry = null;
            }
            if (entry != null) {
                builder2.add((Object) entry);
            }
        }
        ImmutableList.Itr itrListIterator2 = builder2.build().listIterator(0);
        while (itrListIterator2.hasNext() && !setFromComment(((InternalFrame) itrListIterator2.next()).text)) {
        }
    }
}
