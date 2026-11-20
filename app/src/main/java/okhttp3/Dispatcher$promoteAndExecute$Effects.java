package okhttp3;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.text.Subtitle;
import coil3.util.UtilsKt;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.Grouping;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Dispatcher$promoteAndExecute$Effects implements Subtitle, Grouping {
    public final List callsToExecute;

    public /* synthetic */ Dispatcher$promoteAndExecute$Effects(List list) {
        this.callsToExecute = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3 */
    public List getClosedCaptionFormats(StatusLine statusLine) {
        String str;
        int i;
        List listSingletonList;
        ParsableByteArray parsableByteArray = new ParsableByteArray((byte[]) statusLine.message);
        ArrayList arrayList = this.callsToExecute;
        while (parsableByteArray.bytesLeft() > 0) {
            int unsignedByte = parsableByteArray.readUnsignedByte();
            int unsignedByte2 = parsableByteArray.position + parsableByteArray.readUnsignedByte();
            if (unsignedByte == 134) {
                arrayList = new ArrayList();
                int unsignedByte3 = parsableByteArray.readUnsignedByte() & 31;
                for (int i2 = 0; i2 < unsignedByte3; i2++) {
                    String string = parsableByteArray.readString(3, StandardCharsets.UTF_8);
                    int unsignedByte4 = parsableByteArray.readUnsignedByte();
                    boolean z = (unsignedByte4 & 128) != 0;
                    if (z) {
                        i = unsignedByte4 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte unsignedByte5 = (byte) parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    if (z) {
                        boolean z2 = (unsignedByte5 & 64) != 0;
                        byte[] bArr = CodecSpecificDataUtil.NAL_START_CODE;
                        listSingletonList = Collections.singletonList(z2 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    Format.Builder builder = new Format.Builder();
                    builder.sampleMimeType = MimeTypes.normalizeMimeType(str);
                    builder.language = string;
                    builder.accessibilityChannel = i;
                    builder.initializationData = listSingletonList;
                    arrayList.add(new Format(builder));
                }
            }
            parsableByteArray.setPosition(unsignedByte2);
            arrayList = arrayList;
        }
        return arrayList;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public List getCues(long j) {
        return j >= 0 ? this.callsToExecute : Collections.EMPTY_LIST;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public long getEventTime(int i) {
        UtilsKt.checkArgument(i == 0);
        return 0L;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // kotlin.collections.Grouping
    public String keyOf(Object obj) {
        return (String) obj;
    }

    @Override // kotlin.collections.Grouping
    public Iterator sourceIterator() {
        return this.callsToExecute.iterator();
    }
}
