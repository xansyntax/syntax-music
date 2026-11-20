package okhttp3;

import androidx.media3.exoplayer.text.CuesResolver;
import androidx.media3.extractor.text.CuesWithTiming;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import dagger.hilt.EntryPoints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.UIntArray;
import kotlin.collections.EmptyList;
import kotlin.collections.Grouping;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilCommonKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Headers implements Iterable, KMappedMarker {
    public static final Headers EMPTY = new Headers(new String[0]);
    public final String[] namesAndValues;

    public Headers(String[] strArr) {
        strArr.getClass();
        this.namesAndValues = strArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Headers) {
            return Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
        }
        return false;
    }

    public final String get(String str) {
        String[] strArr = this.namesAndValues;
        strArr.getClass();
        int length = strArr.length - 2;
        int progressionLastElement = UuidKt.getProgressionLastElement(length, 0, -2);
        if (progressionLastElement > length) {
            return null;
        }
        while (!str.equalsIgnoreCase(strArr[length])) {
            if (length == progressionLastElement) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = new Pair(EntryPoints.commonName(this, i), EntryPoints.commonValue(this, i));
        }
        return new UIntArray.Iterator(pairArr);
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final TreeMap toMultimap() {
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        comparator.getClass();
        TreeMap treeMap = new TreeMap(comparator);
        int size = size();
        for (int i = 0; i < size; i++) {
            String strCommonName = EntryPoints.commonName(this, i);
            Locale locale = Locale.US;
            locale.getClass();
            String lowerCase = strCommonName.toLowerCase(locale);
            lowerCase.getClass();
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(EntryPoints.commonValue(this, i));
        }
        return treeMap;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strCommonName = EntryPoints.commonName(this, i);
            String strCommonValue = EntryPoints.commonValue(this, i);
            sb.append(strCommonName);
            sb.append(": ");
            if (_UtilCommonKt.isSensitiveHeader(strCommonName)) {
                strCommonValue = "██";
            }
            sb.append(strCommonValue);
            sb.append("\n");
        }
        return sb.toString();
    }

    public final List values(String str) {
        str.getClass();
        int size = size();
        List listUnmodifiableList = null;
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(EntryPoints.commonName(this, i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(EntryPoints.commonValue(this, i));
            }
        }
        if (arrayList != null) {
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
            listUnmodifiableList.getClass();
        }
        return listUnmodifiableList == null ? EmptyList.INSTANCE : listUnmodifiableList;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder implements CuesResolver, Grouping {
        public final /* synthetic */ byte $r8$classId;
        public final ArrayList namesAndValues;

        public Builder(byte b) {
            this.$r8$classId = b;
            switch (b) {
                case 1:
                    this.namesAndValues = new ArrayList();
                    break;
                default:
                    this.namesAndValues = new ArrayList(20);
                    break;
            }
        }

        public void add(Object obj) {
            this.namesAndValues.add(obj);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0023  */
        @Override // androidx.media3.exoplayer.text.CuesResolver
        public boolean addCues(CuesWithTiming cuesWithTiming, long j) {
            boolean z;
            long j2 = cuesWithTiming.startTimeUs;
            UtilsKt.checkArgument(j2 != -9223372036854775807L);
            if (j2 <= j) {
                long j3 = cuesWithTiming.endTimeUs;
                if (j3 == -9223372036854775807L || j < j3) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            ArrayList arrayList = this.namesAndValues;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (j2 >= ((CuesWithTiming) arrayList.get(size)).startTimeUs) {
                    arrayList.add(size + 1, cuesWithTiming);
                    return z;
                }
                if (((CuesWithTiming) arrayList.get(size)).startTimeUs <= j) {
                    z = false;
                }
            }
            arrayList.add(0, cuesWithTiming);
            return z;
        }

        public void addLenient$okhttp(String str) {
            int iIndexOf$default = StringsKt.indexOf$default(str, ':', 1, 4);
            if (iIndexOf$default != -1) {
                EntryPoints.commonAddLenient(this, str.substring(0, iIndexOf$default), str.substring(iIndexOf$default + 1));
            } else if (str.charAt(0) == ':') {
                EntryPoints.commonAddLenient(this, "", str.substring(1));
            } else {
                EntryPoints.commonAddLenient(this, "", str);
            }
        }

        public void addSpread(Object obj) {
            if (obj == null) {
                return;
            }
            boolean z = obj instanceof Object[];
            ArrayList arrayList = this.namesAndValues;
            if (z) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    arrayList.ensureCapacity(arrayList.size() + objArr.length);
                    Collections.addAll(arrayList, objArr);
                    return;
                }
                return;
            }
            if (obj instanceof Collection) {
                arrayList.addAll((Collection) obj);
                return;
            }
            if (obj instanceof Iterable) {
                Iterator it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            } else if (obj instanceof Iterator) {
                Iterator it2 = (Iterator) obj;
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            } else {
                throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
            }
        }

        @Override // androidx.media3.exoplayer.text.CuesResolver
        public void clear() {
            this.namesAndValues.clear();
        }

        @Override // androidx.media3.exoplayer.text.CuesResolver
        public void discardCuesBeforeTimeUs(long j) {
            int indexOfCuesStartingAfter = getIndexOfCuesStartingAfter(j);
            if (indexOfCuesStartingAfter == 0) {
                return;
            }
            ArrayList arrayList = this.namesAndValues;
            long j2 = ((CuesWithTiming) arrayList.get(indexOfCuesStartingAfter - 1)).endTimeUs;
            if (j2 == -9223372036854775807L || j2 >= j) {
                indexOfCuesStartingAfter--;
            }
            arrayList.subList(0, indexOfCuesStartingAfter).clear();
        }

        public String get(String str) {
            str.getClass();
            ArrayList arrayList = this.namesAndValues;
            int size = arrayList.size() - 2;
            int progressionLastElement = UuidKt.getProgressionLastElement(size, 0, -2);
            if (progressionLastElement > size) {
                return null;
            }
            while (!str.equalsIgnoreCase((String) arrayList.get(size))) {
                if (size == progressionLastElement) {
                    return null;
                }
                size -= 2;
            }
            return (String) arrayList.get(size + 1);
        }

        @Override // androidx.media3.exoplayer.text.CuesResolver
        public ImmutableList getCuesAtTimeUs(long j) {
            int indexOfCuesStartingAfter = getIndexOfCuesStartingAfter(j);
            if (indexOfCuesStartingAfter == 0) {
                ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
                return RegularImmutableList.EMPTY;
            }
            CuesWithTiming cuesWithTiming = (CuesWithTiming) this.namesAndValues.get(indexOfCuesStartingAfter - 1);
            long j2 = cuesWithTiming.endTimeUs;
            if (j2 == -9223372036854775807L || j < j2) {
                return cuesWithTiming.cues;
            }
            ImmutableList.Itr itr2 = ImmutableList.EMPTY_ITR;
            return RegularImmutableList.EMPTY;
        }

        public int getIndexOfCuesStartingAfter(long j) {
            int i = 0;
            while (true) {
                ArrayList arrayList = this.namesAndValues;
                if (i >= arrayList.size()) {
                    return arrayList.size();
                }
                if (j < ((CuesWithTiming) arrayList.get(i)).startTimeUs) {
                    return i;
                }
                i++;
            }
        }

        @Override // androidx.media3.exoplayer.text.CuesResolver
        public long getNextCueChangeTimeUs(long j) {
            ArrayList arrayList = this.namesAndValues;
            if (arrayList.isEmpty()) {
                return Long.MIN_VALUE;
            }
            if (j < ((CuesWithTiming) arrayList.get(0)).startTimeUs) {
                return ((CuesWithTiming) arrayList.get(0)).startTimeUs;
            }
            for (int i = 1; i < arrayList.size(); i++) {
                long j2 = ((CuesWithTiming) arrayList.get(i)).startTimeUs;
                if (j < j2) {
                    long j3 = ((CuesWithTiming) arrayList.get(i - 1)).endTimeUs;
                    return (j3 == -9223372036854775807L || j3 <= j || j3 >= j2) ? j2 : j3;
                }
            }
            long j4 = ((CuesWithTiming) Maps.getLast(arrayList)).endTimeUs;
            if (j4 == -9223372036854775807L || j >= j4) {
                return Long.MIN_VALUE;
            }
            return j4;
        }

        @Override // androidx.media3.exoplayer.text.CuesResolver
        public long getPreviousCueChangeTimeUs(long j) {
            ArrayList arrayList = this.namesAndValues;
            if (arrayList.isEmpty() || j < ((CuesWithTiming) arrayList.get(0)).startTimeUs) {
                return -9223372036854775807L;
            }
            for (int i = 1; i < arrayList.size(); i++) {
                long j2 = ((CuesWithTiming) arrayList.get(i)).startTimeUs;
                if (j == j2) {
                    return j2;
                }
                if (j < j2) {
                    CuesWithTiming cuesWithTiming = (CuesWithTiming) arrayList.get(i - 1);
                    long j3 = cuesWithTiming.endTimeUs;
                    return (j3 == -9223372036854775807L || j3 > j) ? cuesWithTiming.startTimeUs : j3;
                }
            }
            CuesWithTiming cuesWithTiming2 = (CuesWithTiming) Maps.getLast(arrayList);
            long j4 = cuesWithTiming2.endTimeUs;
            return (j4 == -9223372036854775807L || j < j4) ? cuesWithTiming2.startTimeUs : j4;
        }

        @Override // kotlin.collections.Grouping
        public String keyOf(Object obj) {
            switch (this.$r8$classId) {
                case 2:
                    break;
            }
            return (String) obj;
        }

        public void removeAll(String str) {
            str.getClass();
            int i = 0;
            while (true) {
                ArrayList arrayList = this.namesAndValues;
                if (i >= arrayList.size()) {
                    return;
                }
                if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                    arrayList.remove(i);
                    arrayList.remove(i);
                    i -= 2;
                }
                i += 2;
            }
        }

        @Override // kotlin.collections.Grouping
        public Iterator sourceIterator() {
            byte b = this.$r8$classId;
            ArrayList arrayList = this.namesAndValues;
            switch (b) {
                case 2:
                    break;
            }
            return arrayList.iterator();
        }

        public Builder(int i) {
            this.$r8$classId = (byte) 4;
            this.namesAndValues = new ArrayList(i);
        }

        public /* synthetic */ Builder(ArrayList arrayList, byte b) {
            this.$r8$classId = b;
            this.namesAndValues = arrayList;
        }
    }
}
