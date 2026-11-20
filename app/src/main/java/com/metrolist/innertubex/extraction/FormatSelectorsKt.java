package com.metrolist.innertubex.extraction;

import androidx.compose.ui.semantics.SemanticsSortKt$special$$inlined$thenBy$1;
import com.metrolist.innertubex.models.response.PlayerResponse;
import com.metrolist.innertubex.sabr.ProtoTag;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FormatSelectorsKt {
    public static final SemanticsSortKt$special$$inlined$thenBy$1 highAudioFormatComparator = new SemanticsSortKt$special$$inlined$thenBy$1((byte) 5, new SemanticsSortKt$special$$inlined$thenBy$1((byte) 4, new SemanticsSortKt$special$$inlined$thenBy$1((byte) 3, new FormatSelectorsKt$special$$inlined$compareBy$1((byte) 0))));
    public static final SemanticsSortKt$special$$inlined$thenBy$1 videoFormatComparator = new SemanticsSortKt$special$$inlined$thenBy$1((byte) 7, new SemanticsSortKt$special$$inlined$thenBy$1((byte) 6, new FormatSelectorsKt$special$$inlined$compareBy$1((byte) 1)));

    public static final long audioFormatScore(PlayerResponse.StreamingData.Format format) {
        int i;
        int i2;
        if (StringsKt.contains(format.mimeType, "audio/webm", false)) {
            i = 100;
        } else {
            i = StringsKt.contains(format.mimeType, "audio/mp4", false) ? 50 : 0;
        }
        Integer num = format.audioChannels;
        if (num != null && num.intValue() == 2) {
            i2 = 50000;
        } else {
            i2 = (num != null && num.intValue() == 1) ? 0 : 25000;
        }
        long j = (((long) i) * 1000000) + ((long) i2) + ((long) format.bitrate);
        Integer num2 = format.audioSampleRate;
        return j + ((long) (UuidKt.coerceIn(num2 != null ? num2.intValue() : 0, 0, 48000) / 10));
    }

    /* JADX WARN: Code duplicated, block: B:72:0x010a  */
    /* JADX WARN: Type inference failed for: r0v43, types: [byte[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r11v7, types: [byte[], java.io.Serializable] */
    public static final PlayerResponse.StreamingData.Format selectBestAudioFormat(List list, AudioQuality audioQuality, boolean z) {
        List list2;
        Object next;
        PlayerResponse.StreamingData.Format format;
        Object next2;
        String str;
        Object failure;
        list.getClass();
        audioQuality.getClass();
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                String str2 = ((PlayerResponse.StreamingData.Format) obj).url;
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    arrayList.add(obj);
                }
            }
            list2 = arrayList;
        } else {
            list2 = list;
        }
        Object next3 = null;
        if (!list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (((PlayerResponse.StreamingData.Format) it.next()).audioTrack != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : list2) {
                        String str3 = ((PlayerResponse.StreamingData.Format) obj2).xtags;
                        if (str3 == null) {
                            str = null;
                        } else {
                            if (str3.length() > 1024) {
                                str3 = null;
                            }
                            if (str3 == null) {
                                str = null;
                            } else {
                                try {
                                    Base64.Default.getClass();
                                    PriorityQueue priorityQueue = new PriorityQueue((Serializable) Base64.decode$default(Base64.UrlSafe.withPadding(Base64.PaddingOption.ABSENT_OPTIONAL), str3, 0, 6), (byte) 11);
                                    while (true) {
                                        if (!(priorityQueue.size < ((byte[]) priorityQueue.array).length)) {
                                            failure = null;
                                            break;
                                        }
                                        ProtoTag protoTagTag = priorityQueue.tag();
                                        if (protoTagTag.field == 1 && protoTagTag.wireType == 2) {
                                            PriorityQueue priorityQueue2 = new PriorityQueue((Serializable) priorityQueue.bytes(), (byte) 11);
                                            String strDecodeToString = null;
                                            failure = null;
                                            while (true) {
                                                if (!(priorityQueue2.size < ((byte[]) priorityQueue2.array).length)) {
                                                    break;
                                                }
                                                ProtoTag protoTagTag2 = priorityQueue2.tag();
                                                int i = protoTagTag2.wireType;
                                                int i2 = protoTagTag2.field;
                                                if (i2 == 1 && i == 2) {
                                                    strDecodeToString = StringsKt__StringsJVMKt.decodeToString(priorityQueue2.bytes());
                                                } else if (i2 == 2 && i == 2) {
                                                    failure = StringsKt__StringsJVMKt.decodeToString(priorityQueue2.bytes());
                                                } else {
                                                    priorityQueue2.skip(protoTagTag2);
                                                }
                                            }
                                            if (Intrinsics.areEqual(strDecodeToString, "acont")) {
                                                break;
                                            }
                                        } else {
                                            priorityQueue.skip(protoTagTag);
                                        }
                                    }
                                } catch (Throwable th) {
                                    failure = new Result.Failure(th);
                                }
                                if (failure instanceof Result.Failure) {
                                    failure = null;
                                }
                                str = (String) failure;
                            }
                        }
                        if (Intrinsics.areEqual(str, "original")) {
                            arrayList2.add(obj2);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        arrayList2 = new ArrayList();
                        for (Object obj3 : list2) {
                            PlayerResponse.StreamingData.Format.AudioTrack audioTrack = ((PlayerResponse.StreamingData.Format) obj3).audioTrack;
                            if (audioTrack != null ? Intrinsics.areEqual(audioTrack.audioIsDefault, Boolean.TRUE) : false) {
                                arrayList2.add(obj3);
                            }
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        list2 = arrayList2;
                        break;
                    }
                    break;
                }
            }
        }
        if (list2.isEmpty()) {
            return null;
        }
        int iOrdinal = audioQuality.ordinal();
        if (iOrdinal == 0) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj4 : list2) {
                if (StringsKt.contains(((PlayerResponse.StreamingData.Format) obj4).mimeType, "audio/webm", false)) {
                    arrayList3.add(obj4);
                }
            }
            Iterator it2 = arrayList3.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    long jAudioFormatScore = audioFormatScore((PlayerResponse.StreamingData.Format) next);
                    do {
                        Object next4 = it2.next();
                        long jAudioFormatScore2 = audioFormatScore((PlayerResponse.StreamingData.Format) next4);
                        if (jAudioFormatScore < jAudioFormatScore2) {
                            next = next4;
                            jAudioFormatScore = jAudioFormatScore2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            format = (PlayerResponse.StreamingData.Format) next;
            if (format == null) {
                Iterator it3 = list2.iterator();
                if (it3.hasNext()) {
                    next3 = it3.next();
                    if (it3.hasNext()) {
                        long jAudioFormatScore3 = audioFormatScore((PlayerResponse.StreamingData.Format) next3);
                        do {
                            Object next5 = it3.next();
                            long jAudioFormatScore4 = audioFormatScore((PlayerResponse.StreamingData.Format) next5);
                            if (jAudioFormatScore3 < jAudioFormatScore4) {
                                next3 = next5;
                                jAudioFormatScore3 = jAudioFormatScore4;
                            }
                        } while (it3.hasNext());
                    }
                }
                return (PlayerResponse.StreamingData.Format) next3;
            }
        } else {
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    return (PlayerResponse.StreamingData.Format) CollectionsKt.maxWithOrNull(list2, highAudioFormatComparator);
                }
                if (iOrdinal != 3) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                ArrayList arrayList4 = new ArrayList();
                for (Object obj5 : list2) {
                    if (StringsKt.contains(((PlayerResponse.StreamingData.Format) obj5).mimeType, "audio/mp4", false)) {
                        arrayList4.add(obj5);
                    }
                }
                Iterator it4 = arrayList4.iterator();
                if (it4.hasNext()) {
                    next3 = it4.next();
                    if (it4.hasNext()) {
                        long jAudioFormatScore5 = audioFormatScore((PlayerResponse.StreamingData.Format) next3);
                        do {
                            Object next6 = it4.next();
                            long jAudioFormatScore6 = audioFormatScore((PlayerResponse.StreamingData.Format) next6);
                            if (jAudioFormatScore5 < jAudioFormatScore6) {
                                next3 = next6;
                                jAudioFormatScore5 = jAudioFormatScore6;
                            }
                        } while (it4.hasNext());
                    }
                }
                return (PlayerResponse.StreamingData.Format) next3;
            }
            ArrayList arrayList5 = new ArrayList();
            for (Object obj6 : list2) {
                if (StringsKt.contains(((PlayerResponse.StreamingData.Format) obj6).mimeType, "audio/mp4", false)) {
                    arrayList5.add(obj6);
                }
            }
            Iterator it5 = arrayList5.iterator();
            if (it5.hasNext()) {
                next2 = it5.next();
                if (it5.hasNext()) {
                    int i3 = ((PlayerResponse.StreamingData.Format) next2).bitrate;
                    do {
                        Object next7 = it5.next();
                        int i4 = ((PlayerResponse.StreamingData.Format) next7).bitrate;
                        if (i3 > i4) {
                            next2 = next7;
                            i3 = i4;
                        }
                    } while (it5.hasNext());
                }
            } else {
                next2 = null;
            }
            format = (PlayerResponse.StreamingData.Format) next2;
            if (format == null) {
                Iterator it6 = list2.iterator();
                if (it6.hasNext()) {
                    next3 = it6.next();
                    if (it6.hasNext()) {
                        int i5 = ((PlayerResponse.StreamingData.Format) next3).bitrate;
                        do {
                            Object next8 = it6.next();
                            int i6 = ((PlayerResponse.StreamingData.Format) next8).bitrate;
                            if (i5 > i6) {
                                next3 = next8;
                                i5 = i6;
                            }
                        } while (it6.hasNext());
                    }
                }
                return (PlayerResponse.StreamingData.Format) next3;
            }
        }
        return format;
    }

    public static /* synthetic */ PlayerResponse.StreamingData.Format selectBestAudioFormat$default(List list, AudioQuality audioQuality) {
        return selectBestAudioFormat(list, audioQuality, true);
    }

    public static final PlayerResponse.StreamingData.Format selectBestVideoFormat(int i, List list, boolean z) {
        int i2;
        Object next;
        List list2;
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                String str = ((PlayerResponse.StreamingData.Format) obj).url;
                if (str != null && !StringsKt.isBlank(str)) {
                    arrayList.add(obj);
                }
            }
            list = arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next2 = it.next();
            PlayerResponse.StreamingData.Format format = (PlayerResponse.StreamingData.Format) next2;
            if (format.width != null) {
                Integer num = format.height;
                if ((num != null ? num.intValue() : 0) > 0) {
                    arrayList2.add(next2);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                Integer num2 = ((PlayerResponse.StreamingData.Format) obj2).height;
                num2.getClass();
                if (num2.intValue() <= i) {
                    arrayList3.add(obj2);
                }
            }
            SemanticsSortKt$special$$inlined$thenBy$1 semanticsSortKt$special$$inlined$thenBy$1 = videoFormatComparator;
            PlayerResponse.StreamingData.Format format2 = (PlayerResponse.StreamingData.Format) CollectionsKt.maxWithOrNull(arrayList3, semanticsSortKt$special$$inlined$thenBy$1);
            if (format2 != null) {
                return format2;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size2 = arrayList2.size();
            while (i2 < size2) {
                Object obj3 = arrayList2.get(i2);
                i2++;
                Integer num3 = ((PlayerResponse.StreamingData.Format) obj3).height;
                num3.getClass();
                Object arrayList4 = linkedHashMap.get(num3);
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList();
                    linkedHashMap.put(num3, arrayList4);
                }
                ((List) arrayList4).add(obj3);
            }
            Iterator it2 = linkedHashMap.entrySet().iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    int iIntValue = ((Number) ((Map.Entry) next).getKey()).intValue();
                    do {
                        Object next3 = it2.next();
                        int iIntValue2 = ((Number) ((Map.Entry) next3).getKey()).intValue();
                        if (iIntValue > iIntValue2) {
                            next = next3;
                            iIntValue = iIntValue2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            Map.Entry entry = (Map.Entry) next;
            if (entry != null && (list2 = (List) entry.getValue()) != null) {
                return (PlayerResponse.StreamingData.Format) CollectionsKt.maxWithOrNull(list2, semanticsSortKt$special$$inlined$thenBy$1);
            }
        }
        return null;
    }

    public static /* synthetic */ PlayerResponse.StreamingData.Format selectBestVideoFormat$default(int i, List list) {
        return selectBestVideoFormat(i, list, true);
    }
}
