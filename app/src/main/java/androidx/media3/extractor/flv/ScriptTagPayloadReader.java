package androidx.media3.extractor.flv;

import androidx.media3.common.util.ParsableByteArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScriptTagPayloadReader extends TagPayloadReader {
    public long durationUs;
    public long[] keyFrameTagPositions;
    public long[] keyFrameTimesUs;

    public static Serializable readAmfData(int i, ParsableByteArray parsableByteArray) {
        if (i == 0) {
            return Double.valueOf(Double.longBitsToDouble(parsableByteArray.readLong()));
        }
        if (i == 1) {
            return Boolean.valueOf(parsableByteArray.readUnsignedByte() == 1);
        }
        if (i == 2) {
            return readAmfString(parsableByteArray);
        }
        if (i != 3) {
            if (i == 8) {
                return readAmfEcmaArray(parsableByteArray);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) Double.longBitsToDouble(parsableByteArray.readLong()));
                parsableByteArray.skipBytes(2);
                return date;
            }
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            ArrayList arrayList = new ArrayList(unsignedIntToInt);
            for (int i2 = 0; i2 < unsignedIntToInt; i2++) {
                Serializable amfData = readAmfData(parsableByteArray.readUnsignedByte(), parsableByteArray);
                if (amfData != null) {
                    arrayList.add(amfData);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String amfString = readAmfString(parsableByteArray);
            int unsignedByte = parsableByteArray.readUnsignedByte();
            if (unsignedByte == 9) {
                return map;
            }
            Serializable amfData2 = readAmfData(unsignedByte, parsableByteArray);
            if (amfData2 != null) {
                map.put(amfString, amfData2);
            }
        }
    }

    public static HashMap readAmfEcmaArray(ParsableByteArray parsableByteArray) {
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        HashMap map = new HashMap(unsignedIntToInt);
        for (int i = 0; i < unsignedIntToInt; i++) {
            String amfString = readAmfString(parsableByteArray);
            Serializable amfData = readAmfData(parsableByteArray.readUnsignedByte(), parsableByteArray);
            if (amfData != null) {
                map.put(amfString, amfData);
            }
        }
        return map;
    }

    public static String readAmfString(ParsableByteArray parsableByteArray) {
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int i = parsableByteArray.position;
        parsableByteArray.skipBytes(unsignedShort);
        return new String(parsableByteArray.data, i, unsignedShort);
    }
}
