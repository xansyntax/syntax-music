package com.metrolist.music.playback;

import androidx.palette.graphics.ColorCutQuantizer;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Song;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class VoiceSearchMatcher {
    public static final Regex PUNCTUATION_REGEX = new Regex("[^\\p{L}\\p{N}\\s]");

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ScoredSong {
        public final double score;
        public final Song song;

        public ScoredSong(Song song, double d) {
            this.song = song;
            this.score = d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScoredSong)) {
                return false;
            }
            ScoredSong scoredSong = (ScoredSong) obj;
            return this.song.equals(scoredSong.song) && Double.compare(this.score, scoredSong.score) == 0;
        }

        public final int hashCode() {
            return Double.hashCode(this.score) + (this.song.hashCode() * 31);
        }

        public final String toString() {
            return "ScoredSong(song=" + this.song + ", score=" + this.score + ")";
        }
    }

    public static Song findBest(String str, List list) {
        Song song;
        Iterable iterableSortedWith;
        double d;
        double d2;
        int i;
        int i2;
        double d3;
        Object next;
        str.getClass();
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        String string = StringsKt.trim(lowerCase).toString();
        Set set = tokenize$app(string);
        if (set.isEmpty()) {
            iterableSortedWith = EmptyList.INSTANCE;
            song = null;
        } else {
            boolean z = true;
            if ((set.size() != 1 || ((String) CollectionsKt.first(set)).length() >= 4) && string.length() >= 5) {
                z = false;
            }
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Song song2 = (Song) it.next();
                String lowerCase2 = song2.song.title.toLowerCase(Locale.ROOT);
                lowerCase2.getClass();
                String string2 = StringsKt.trim(lowerCase2).toString();
                Set set2 = tokenize$app(string2);
                if (set2.equals(set) || string2.equals(string)) {
                    d = 1.0d;
                } else {
                    Set<String> mutableSet = CollectionsKt.toMutableSet(set);
                    Iterator it2 = song2.artists.iterator();
                    while (it2.hasNext()) {
                        String lowerCase3 = ((ArtistEntity) it2.next()).name.toLowerCase(Locale.ROOT);
                        lowerCase3.getClass();
                        final DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0 = new DiskLruCache$$ExternalSyntheticLambda0((byte) 24, tokenize$app(lowerCase3));
                        mutableSet.removeIf(new Predicate() { // from class: com.metrolist.music.playback.VoiceSearchMatcher$$ExternalSyntheticLambda1
                            @Override // java.util.function.Predicate
                            public final boolean test(Object obj) {
                                return ((Boolean) diskLruCache$$ExternalSyntheticLambda0.invoke(obj)).booleanValue();
                            }
                        });
                    }
                    if (mutableSet.isEmpty()) {
                        d = 0.5d;
                    } else if (set2.equals(mutableSet)) {
                        d = 0.95d;
                    } else if (z) {
                        d = 0.0d;
                    } else {
                        if (mutableSet.isEmpty() || set2.isEmpty()) {
                            d2 = 0.0d;
                        } else {
                            double d4 = 0.85d;
                            if (mutableSet.isEmpty()) {
                                i = 0;
                            } else {
                                int i3 = 0;
                                for (String str2 : mutableSet) {
                                    Set<String> set3 = set2;
                                    if (!(set3 instanceof Collection) || !set3.isEmpty()) {
                                        for (String str3 : set3) {
                                            if (Intrinsics.areEqual(str2, str3) || jaroWinkler$app(str2, str3) >= 0.85d) {
                                                i3++;
                                                if (i3 >= 0) {
                                                    break;
                                                }
                                                CollectionsKt__IterablesKt.throwCountOverflow();
                                                throw null;
                                            }
                                        }
                                    }
                                }
                                i = i3;
                            }
                            d2 = 0.0d;
                            Set<String> set4 = set2;
                            if ((set4 instanceof Collection) && set4.isEmpty()) {
                                i2 = 0;
                            } else {
                                i2 = 0;
                                for (String str4 : set4) {
                                    if (mutableSet.isEmpty()) {
                                        d3 = d4;
                                    } else {
                                        Iterator it3 = mutableSet.iterator();
                                        while (true) {
                                            if (it3.hasNext()) {
                                                d3 = d4;
                                                String str5 = (String) it3.next();
                                                if (Intrinsics.areEqual(str5, str4) || jaroWinkler$app(str5, str4) >= d3) {
                                                    i2++;
                                                    if (i2 < 0) {
                                                        CollectionsKt__IterablesKt.throwCountOverflow();
                                                        throw null;
                                                    }
                                                } else {
                                                    d4 = d3;
                                                }
                                            } else {
                                                d3 = d4;
                                            }
                                        }
                                    }
                                    d4 = d3;
                                }
                            }
                            if (i != 0 && i2 != 0) {
                                double size = ((double) i2) / ((double) set2.size());
                                double size2 = ((double) i) / ((double) mutableSet.size());
                                double d5 = size + size2;
                                if (d5 > 0.0d) {
                                    d = ((size * 2.0d) * size2) / d5;
                                }
                            }
                        }
                        d = d2;
                    }
                }
                arrayList.add(new ScoredSong(song2, d));
            }
            song = null;
            iterableSortedWith = CollectionsKt.sortedWith(arrayList, new ColorCutQuantizer.AnonymousClass1((byte) 12));
        }
        Iterator it4 = iterableSortedWith.iterator();
        do {
            if (!it4.hasNext()) {
                next = song;
                break;
            }
            next = it4.next();
        } while (((ScoredSong) next).score < 0.6d);
        ScoredSong scoredSong = (ScoredSong) next;
        return scoredSong != null ? scoredSong.song : song;
    }

    public static double jaroWinkler$app(String str, String str2) {
        int iMax;
        str.getClass();
        str2.getClass();
        if (str.equals(str2)) {
            return 1.0d;
        }
        if (str.length() == 0 || str2.length() == 0 || (iMax = (Math.max(str.length(), str2.length()) / 2) - 1) < 0) {
            return 0.0d;
        }
        boolean[] zArr = new boolean[str.length()];
        boolean[] zArr2 = new boolean[str2.length()];
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int iMax2 = Math.max(0, i2 - iMax);
            int iMin = Math.min(str2.length() - 1, i2 + iMax);
            if (iMax2 <= iMin) {
                while (true) {
                    if (!zArr2[iMax2] && str.charAt(i2) == str2.charAt(iMax2)) {
                        zArr[i2] = true;
                        zArr2[iMax2] = true;
                        i++;
                        break;
                    }
                    if (iMax2 == iMin) {
                        break;
                    }
                    iMax2++;
                }
            }
        }
        if (i == 0) {
            return 0.0d;
        }
        int length2 = str.length();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length2; i5++) {
            if (zArr[i5]) {
                while (!zArr2[i4]) {
                    i4++;
                }
                if (str.charAt(i5) != str2.charAt(i4)) {
                    i3++;
                }
                i4++;
            }
        }
        double d = i;
        double length3 = (((d - (((double) i3) / 2.0d)) / d) + ((d / ((double) str2.length())) + (d / ((double) str.length())))) / 3.0d;
        int iMin2 = Math.min(str.length(), str2.length());
        int i6 = 0;
        while (i6 < iMin2 && CharsKt.equals(str.charAt(i6), str2.charAt(i6), false)) {
            i6++;
        }
        int i7 = i6 - 1;
        if (StringsKt.hasSurrogatePairAt(i7, str) || StringsKt.hasSurrogatePairAt(i7, str2)) {
            i6--;
        }
        int length4 = str.subSequence(0, i6).toString().length();
        if (length4 > 4) {
            length4 = 4;
        }
        return length3 > 0.7d ? ((1.0d - length3) * ((double) length4) * 0.1d) + length3 : length3;
    }

    public static Set tokenize$app(String str) {
        str.getClass();
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        List listSplit$default = StringsKt.split$default(PUNCTUATION_REGEX.replace(lowerCase, ServerSentEventKt.SPACE), new String[]{ServerSentEventKt.SPACE}, 0, 6);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSplit$default) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }
}
