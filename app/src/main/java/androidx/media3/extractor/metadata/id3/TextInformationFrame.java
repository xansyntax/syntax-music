package androidx.media3.extractor.metadata.id3;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextInformationFrame extends Id3Frame {
    public final String description;
    public final ImmutableList values;

    public TextInformationFrame(String str, String str2, RegularImmutableList regularImmutableList) {
        super(str);
        UtilsKt.checkArgument(!regularImmutableList.isEmpty());
        this.description = str2;
        ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) regularImmutableList);
        this.values = immutableListCopyOf;
    }

    public static ArrayList parseId3v2point4TimestampFrameForDate(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            }
            if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            }
            if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return this.id.equals(textInformationFrame.id) && Objects.equals(this.description, textInformationFrame.description) && this.values.equals(textInformationFrame.values);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(527, 31, this.id);
        String str = this.description;
        return this.values.hashCode() + ((iM + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public final void populateMediaMetadata(MediaMetadata.Builder builder) {
        byte b;
        switch (this.id) {
            case "TAL":
                b = 0;
                break;
            case "TCM":
                b = 1;
                break;
            case "TDA":
                b = 2;
                break;
            case "TP1":
                b = 3;
                break;
            case "TP2":
                b = 4;
                break;
            case "TP3":
                b = 5;
                break;
            case "TRK":
                b = 6;
                break;
            case "TT2":
                b = 7;
                break;
            case "TXT":
                b = 8;
                break;
            case "TYE":
                b = 9;
                break;
            case "TALB":
                b = 10;
                break;
            case "TCOM":
                b = 11;
                break;
            case "TCON":
                b = 12;
                break;
            case "TDAT":
                b = 13;
                break;
            case "TDRC":
                b = 14;
                break;
            case "TDRL":
                b = 15;
                break;
            case "TEXT":
                b = 16;
                break;
            case "TIT2":
                b = 17;
                break;
            case "TPE1":
                b = 18;
                break;
            case "TPE2":
                b = 19;
                break;
            case "TPE3":
                b = 20;
                break;
            case "TRCK":
                b = 21;
                break;
            case "TYER":
                b = 22;
                break;
            default:
                b = -1;
                break;
        }
        ImmutableList immutableList = this.values;
        try {
            switch (b) {
                case 0:
                case 10:
                    builder.albumTitle = (CharSequence) immutableList.get(0);
                    break;
                case 1:
                case 11:
                    builder.composer = (CharSequence) immutableList.get(0);
                    break;
                case 2:
                case 13:
                    String str = (String) immutableList.get(0);
                    int i = Integer.parseInt(str.substring(2, 4));
                    int i2 = Integer.parseInt(str.substring(0, 2));
                    builder.recordingMonth = Integer.valueOf(i);
                    builder.recordingDay = Integer.valueOf(i2);
                    break;
                case 3:
                case 18:
                    builder.artist = (CharSequence) immutableList.get(0);
                    break;
                case 4:
                case 19:
                    builder.albumArtist = (CharSequence) immutableList.get(0);
                    break;
                case 5:
                case 20:
                    builder.conductor = (CharSequence) immutableList.get(0);
                    break;
                case 6:
                case 21:
                    String str2 = (String) immutableList.get(0);
                    String str3 = Util.DEVICE_DEBUG_INFO;
                    String[] strArrSplit = str2.split("/", -1);
                    int i3 = Integer.parseInt(strArrSplit[0]);
                    Integer numValueOf = strArrSplit.length > 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null;
                    builder.trackNumber = Integer.valueOf(i3);
                    builder.totalTrackCount = numValueOf;
                    break;
                case 7:
                case 17:
                    builder.title = (CharSequence) immutableList.get(0);
                    break;
                case 8:
                case 16:
                    builder.writer = (CharSequence) immutableList.get(0);
                    break;
                case 9:
                case 22:
                    builder.recordingYear = Integer.valueOf(Integer.parseInt((String) immutableList.get(0)));
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    Integer numTryParse = StringsKt__IndentKt.tryParse((String) immutableList.get(0));
                    if (numTryParse != null) {
                        String strResolveV1Genre = Id3Util.resolveV1Genre(numTryParse.intValue());
                        if (strResolveV1Genre != null) {
                            builder.genre = strResolveV1Genre;
                        }
                    } else {
                        builder.genre = (CharSequence) immutableList.get(0);
                    }
                    break;
                case 14:
                    ArrayList id3v2point4TimestampFrameForDate = parseId3v2point4TimestampFrameForDate((String) immutableList.get(0));
                    int size = id3v2point4TimestampFrameForDate.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                builder.recordingDay = (Integer) id3v2point4TimestampFrameForDate.get(2);
                            }
                        }
                        builder.recordingMonth = (Integer) id3v2point4TimestampFrameForDate.get(1);
                    }
                    builder.recordingYear = (Integer) id3v2point4TimestampFrameForDate.get(0);
                    break;
                case 15:
                    ArrayList id3v2point4TimestampFrameForDate2 = parseId3v2point4TimestampFrameForDate((String) immutableList.get(0));
                    int size2 = id3v2point4TimestampFrameForDate2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                builder.releaseDay = (Integer) id3v2point4TimestampFrameForDate2.get(2);
                            }
                        }
                        builder.releaseMonth = (Integer) id3v2point4TimestampFrameForDate2.get(1);
                    }
                    builder.releaseYear = (Integer) id3v2point4TimestampFrameForDate2.get(0);
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.id + ": description=" + this.description + ": values=" + this.values;
    }
}
