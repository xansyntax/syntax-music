package androidx.palette.graphics;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import androidx.media3.exoplayer.offline.Download;
import androidx.room.util.TableInfo;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.materialkolor.quantize.QuantizerWsmeans$Distance;
import com.materialkolor.score.Score$ScoredHCT;
import com.metrolist.innertube.pages.SearchSummary;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.db.entities.PlaylistSongMap;
import com.metrolist.music.db.entities.SongArtistMap;
import com.metrolist.music.eq.data.SavedEQProfile;
import com.metrolist.music.playback.VoiceSearchMatcher;
import com.metrolist.music.playback.alarm.MusicAlarmEntry;
import dev.chrisbanes.haze.HazeArea;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Pair;
import kotlin.text.RegexKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.internal.ZipEntry;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ColorCutQuantizer {
    public static final AnonymousClass1 VBOX_COMPARATOR_VOLUME = new AnonymousClass1(0);
    public final int[] mColors;
    public final Palette.AnonymousClass1[] mFilters;
    public final int[] mHistogram;
    public final ArrayList mQuantizedColors;
    public final float[] mTempHsl = new float[3];

    /* JADX INFO: renamed from: androidx.palette.graphics.ColorCutQuantizer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Comparator {
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ AnonymousClass1(byte b) {
            this.$r8$classId = b;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:111:0x0236  */
        /* JADX WARN: Code duplicated, block: B:72:0x01ce  */
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int i;
            int i2;
            switch (this.$r8$classId) {
                case 0:
                    return ((Vbox) obj2).getVolume() - ((Vbox) obj).getVolume();
                case 1:
                    return RegexKt.compareValues((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
                case 2:
                    return RegexKt.compareValues((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
                case 3:
                    return RegexKt.compareValues(((TableInfo.Column) obj).name, ((TableInfo.Column) obj2).name);
                case 4:
                    return RegexKt.compareValues(((TableInfo.Index) obj).name, ((TableInfo.Index) obj2).name);
                case 5:
                    return RegexKt.compareValues((QuantizerWsmeans$Distance) obj, (QuantizerWsmeans$Distance) obj2);
                case 6:
                    Score$ScoredHCT score$ScoredHCT = (Score$ScoredHCT) obj;
                    Score$ScoredHCT score$ScoredHCT2 = (Score$ScoredHCT) obj2;
                    score$ScoredHCT.getClass();
                    score$ScoredHCT2.getClass();
                    return Double.valueOf(score$ScoredHCT2.score).compareTo(Double.valueOf(score$ScoredHCT.score));
                case 7:
                    switch (((SearchSummary) obj).title) {
                        case "Videos":
                            i = 2;
                            break;
                        case "Profiles":
                            i = 8;
                            break;
                        case "Episodes":
                            i = 7;
                            break;
                        case "Songs":
                            i = 1;
                            break;
                        case "Playlists":
                            i = 5;
                            break;
                        case "Podcasts":
                            i = 6;
                            break;
                        case "Artists":
                            i = 4;
                            break;
                        case "Top result":
                            i = 0;
                            break;
                        case "Albums":
                            i = 3;
                            break;
                        default:
                            i = 9;
                            break;
                    }
                    Integer numValueOf = Integer.valueOf(i);
                    switch (((SearchSummary) obj2).title) {
                        case "Videos":
                            i2 = 2;
                            break;
                        case "Profiles":
                            i2 = 8;
                            break;
                        case "Episodes":
                            i2 = 7;
                            break;
                        case "Songs":
                            i2 = 1;
                            break;
                        case "Playlists":
                            i2 = 5;
                            break;
                        case "Podcasts":
                            i2 = 6;
                            break;
                        case "Artists":
                            i2 = 4;
                            break;
                        case "Top result":
                            i2 = 0;
                            break;
                        case "Albums":
                            i2 = 3;
                            break;
                        default:
                            i2 = 9;
                            break;
                    }
                    return numValueOf.compareTo(Integer.valueOf(i2));
                case 8:
                    return Integer.valueOf(((SongArtistMap) obj).position).compareTo(Integer.valueOf(((SongArtistMap) obj2).position));
                case 9:
                    return Long.valueOf(((SavedEQProfile) obj2).addedTimestamp).compareTo(Long.valueOf(((SavedEQProfile) obj).addedTimestamp));
                case 10:
                    return Long.valueOf(((Download) ((Map.Entry) obj).getValue()).updateTimeMs).compareTo(Long.valueOf(((Download) ((Map.Entry) obj2).getValue()).updateTimeMs));
                case 11:
                    Download download = (Download) ((Pair) obj).second;
                    Long lValueOf = Long.valueOf(download != null ? download.updateTimeMs : 0L);
                    Download download2 = (Download) ((Pair) obj2).second;
                    return lValueOf.compareTo(Long.valueOf(download2 != null ? download2.updateTimeMs : 0L));
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    return Double.valueOf(((VoiceSearchMatcher.ScoredSong) obj2).score).compareTo(Double.valueOf(((VoiceSearchMatcher.ScoredSong) obj).score));
                case 13:
                    Map map = PreferenceKeysKt.LanguageCodeToName;
                    return RegexKt.compareValues((String) map.get((String) obj), (String) map.get((String) obj2));
                case 14:
                    MusicAlarmEntry musicAlarmEntry = (MusicAlarmEntry) obj;
                    MusicAlarmEntry musicAlarmEntry2 = (MusicAlarmEntry) obj2;
                    return Integer.valueOf((musicAlarmEntry.hour * 60) + musicAlarmEntry.minute).compareTo(Integer.valueOf((musicAlarmEntry2.hour * 60) + musicAlarmEntry2.minute));
                case 15:
                    return Integer.valueOf(((PlaylistSongMap) obj2).position).compareTo(Integer.valueOf(((PlaylistSongMap) obj).position));
                case 16:
                    return RegexKt.compareValues((Integer) ((Pair) obj2).second, (Integer) ((Pair) obj).second);
                case 17:
                    return RegexKt.compareValues((Double) ((Pair) obj2).second, (Double) ((Pair) obj).second);
                case 18:
                    return Float.valueOf(((HazeArea) obj).zIndex$delegate.getFloatValue()).compareTo(Float.valueOf(((HazeArea) obj2).zIndex$delegate.getFloatValue()));
                default:
                    return RegexKt.compareValues(((ZipEntry) obj).canonicalPath, ((ZipEntry) obj2).canonicalPath);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Vbox {
        public final int mLowerIndex;
        public int mMaxBlue;
        public int mMaxGreen;
        public int mMaxRed;
        public int mMinBlue;
        public int mMinGreen;
        public int mMinRed;
        public int mPopulation;
        public int mUpperIndex;

        public Vbox(int i, int i2) {
            this.mLowerIndex = i;
            this.mUpperIndex = i2;
            fitBox();
        }

        public final void fitBox() {
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.mColors;
            int[] iArr2 = colorCutQuantizer.mHistogram;
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE;
            int i4 = 0;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = this.mLowerIndex; i8 <= this.mUpperIndex; i8++) {
                int i9 = iArr[i8];
                i4 += iArr2[i9];
                int i10 = (i9 >> 10) & 31;
                int i11 = (i9 >> 5) & 31;
                int i12 = i9 & 31;
                if (i10 > i7) {
                    i7 = i10;
                }
                if (i10 < i) {
                    i = i10;
                }
                if (i11 > i2) {
                    i2 = i11;
                }
                if (i11 < i5) {
                    i5 = i11;
                }
                if (i12 > i3) {
                    i3 = i12;
                }
                if (i12 < i6) {
                    i6 = i12;
                }
            }
            this.mMinRed = i;
            this.mMaxRed = i7;
            this.mMinGreen = i5;
            this.mMaxGreen = i2;
            this.mMinBlue = i6;
            this.mMaxBlue = i3;
            this.mPopulation = i4;
        }

        public final int getVolume() {
            return ((this.mMaxBlue - this.mMinBlue) + 1) * ((this.mMaxGreen - this.mMinGreen) + 1) * ((this.mMaxRed - this.mMinRed) + 1);
        }
    }

    public ColorCutQuantizer(int[] iArr, int i, Palette.AnonymousClass1[] anonymousClass1Arr) {
        Vbox vbox;
        this.mFilters = anonymousClass1Arr;
        int[] iArr2 = new int[32768];
        this.mHistogram = iArr2;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            int iModifyWordWidth = modifyWordWidth(Color.blue(i3), 8, 5) | (modifyWordWidth(Color.red(i3), 8, 5) << 10) | (modifyWordWidth(Color.green(i3), 8, 5) << 5);
            iArr[i2] = iModifyWordWidth;
            iArr2[iModifyWordWidth] = iArr2[iModifyWordWidth] + 1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 32768; i5++) {
            if (iArr2[i5] > 0) {
                int iRgb = Color.rgb(modifyWordWidth((i5 >> 10) & 31, 5, 8), modifyWordWidth((i5 >> 5) & 31, 5, 8), modifyWordWidth(i5 & 31, 5, 8));
                float[] fArr = this.mTempHsl;
                ThreadLocal threadLocal = ColorUtils.TEMP_ARRAY;
                ColorUtils.RGBToHSL(Color.red(iRgb), Color.green(iRgb), Color.blue(iRgb), fArr);
                if (shouldIgnoreColor(fArr)) {
                    iArr2[i5] = 0;
                }
            }
            if (iArr2[i5] > 0) {
                i4++;
            }
        }
        int[] iArr3 = new int[i4];
        this.mColors = iArr3;
        int i6 = 0;
        for (int i7 = 0; i7 < 32768; i7++) {
            if (iArr2[i7] > 0) {
                iArr3[i6] = i7;
                i6++;
            }
        }
        if (i4 <= i) {
            this.mQuantizedColors = new ArrayList();
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = iArr3[i8];
                this.mQuantizedColors.add(new Palette.Swatch(Color.rgb(modifyWordWidth((i9 >> 10) & 31, 5, 8), modifyWordWidth((i9 >> 5) & 31, 5, 8), modifyWordWidth(i9 & 31, 5, 8)), iArr2[i9]));
            }
            return;
        }
        PriorityQueue<Vbox> priorityQueue = new PriorityQueue(i, VBOX_COMPARATOR_VOLUME);
        priorityQueue.offer(new Vbox(0, this.mColors.length - 1));
        while (priorityQueue.size() < i && (vbox = (Vbox) priorityQueue.poll()) != null) {
            int i10 = vbox.mUpperIndex;
            int iMin = vbox.mLowerIndex;
            if ((i10 + 1) - iMin <= 1) {
                break;
            }
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            if ((i10 + 1) - iMin <= 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Can not split a box with only 1 color");
                throw null;
            }
            int i11 = vbox.mMaxRed - vbox.mMinRed;
            int i12 = vbox.mMaxGreen - vbox.mMinGreen;
            int i13 = vbox.mMaxBlue - vbox.mMinBlue;
            int i14 = (i11 < i12 || i11 < i13) ? (i12 < i11 || i12 < i13) ? -1 : -2 : -3;
            int[] iArr4 = colorCutQuantizer.mColors;
            int[] iArr5 = colorCutQuantizer.mHistogram;
            modifySignificantOctet(i14, iMin, i10, iArr4);
            Arrays.sort(iArr4, iMin, vbox.mUpperIndex + 1);
            modifySignificantOctet(i14, iMin, vbox.mUpperIndex, iArr4);
            int i15 = vbox.mPopulation / 2;
            int i16 = 0;
            int i17 = iMin;
            while (true) {
                int i18 = vbox.mUpperIndex;
                if (i17 > i18) {
                    break;
                }
                i16 += iArr5[iArr4[i17]];
                if (i16 >= i15) {
                    iMin = Math.min(i18 - 1, i17);
                    break;
                }
                i17++;
            }
            Vbox vbox2 = colorCutQuantizer.new Vbox(iMin + 1, vbox.mUpperIndex);
            vbox.mUpperIndex = iMin;
            vbox.fitBox();
            priorityQueue.offer(vbox2);
            priorityQueue.offer(vbox);
        }
        ArrayList arrayList = new ArrayList(priorityQueue.size());
        for (Vbox vbox3 : priorityQueue) {
            ColorCutQuantizer colorCutQuantizer2 = ColorCutQuantizer.this;
            int[] iArr6 = colorCutQuantizer2.mColors;
            int[] iArr7 = colorCutQuantizer2.mHistogram;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            for (int i23 = vbox3.mLowerIndex; i23 <= vbox3.mUpperIndex; i23++) {
                int i24 = iArr6[i23];
                int i25 = iArr7[i24];
                i20 += i25;
                i19 = (((i24 >> 10) & 31) * i25) + i19;
                i21 = (((i24 >> 5) & 31) * i25) + i21;
                i22 += i25 * (i24 & 31);
            }
            float f = i20;
            Palette.Swatch swatch = new Palette.Swatch(Color.rgb(modifyWordWidth(Math.round(i19 / f), 5, 8), modifyWordWidth(Math.round(i21 / f), 5, 8), modifyWordWidth(Math.round(i22 / f), 5, 8)), i20);
            if (!shouldIgnoreColor(swatch.getHsl())) {
                arrayList.add(swatch);
            }
        }
        this.mQuantizedColors = arrayList;
    }

    public static void modifySignificantOctet(int i, int i2, int i3, int[] iArr) {
        if (i == -2) {
            while (i2 <= i3) {
                int i4 = iArr[i2];
                iArr[i2] = (i4 & 31) | (((i4 >> 5) & 31) << 10) | (((i4 >> 10) & 31) << 5);
                i2++;
            }
            return;
        }
        if (i != -1) {
            return;
        }
        while (i2 <= i3) {
            int i5 = iArr[i2];
            iArr[i2] = ((i5 >> 10) & 31) | ((i5 & 31) << 10) | (((i5 >> 5) & 31) << 5);
            i2++;
        }
    }

    public static int modifyWordWidth(int i, int i2, int i3) {
        return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
    }

    public final boolean shouldIgnoreColor(float[] fArr) {
        Palette.AnonymousClass1[] anonymousClass1Arr = this.mFilters;
        if (anonymousClass1Arr != null && anonymousClass1Arr.length > 0) {
            for (Palette.AnonymousClass1 anonymousClass1 : anonymousClass1Arr) {
                anonymousClass1.getClass();
                float f = fArr[2];
                if (f < 0.95f && f > 0.05f) {
                    float f2 = fArr[0];
                    if (f2 < 10.0f || f2 > 37.0f || fArr[1] > 0.82f) {
                    }
                }
                return true;
            }
        }
        return false;
    }
}
