package androidx.media3.extractor.text.ttml;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Pair;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.HorizontalTextInVerticalContextSpan;
import androidx.media3.common.text.RubySpan;
import androidx.media3.common.text.TextEmphasisSpan;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import coil3.size.SizeKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TtmlNode {
    public ArrayList children;
    public final long endTimeUs;
    public final String imageId;
    public final boolean isTextNode;
    public final HashMap nodeEndsByRegion;
    public final HashMap nodeStartsByRegion;
    public final TtmlNode parent;
    public final String regionId;
    public final long startTimeUs;
    public final TtmlStyle style;
    public final String[] styleIds;
    public final String tag;
    public final String text;

    public TtmlNode(String str, String str2, long j, long j2, TtmlStyle ttmlStyle, String[] strArr, String str3, String str4, TtmlNode ttmlNode) {
        this.tag = str;
        this.text = str2;
        this.imageId = str4;
        this.style = ttmlStyle;
        this.styleIds = strArr;
        this.isTextNode = str2 != null;
        this.startTimeUs = j;
        this.endTimeUs = j2;
        str3.getClass();
        this.regionId = str3;
        this.parent = ttmlNode;
        this.nodeStartsByRegion = new HashMap();
        this.nodeEndsByRegion = new HashMap();
    }

    public static TtmlNode buildTextNode(String str) {
        return new TtmlNode(null, str.replaceAll(ServerSentEventKt.END_OF_LINE, "\n").replaceAll(" *\n *", "\n").replaceAll("\n", ServerSentEventKt.SPACE).replaceAll("[ \t\\x0B\f\r]+", ServerSentEventKt.SPACE), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static SpannableStringBuilder getRegionOutputText(String str, TreeMap treeMap) {
        if (!treeMap.containsKey(str)) {
            Cue.Builder builder = new Cue.Builder();
            builder.text = new SpannableStringBuilder();
            builder.bitmap = null;
            treeMap.put(str, builder);
        }
        CharSequence charSequence = ((Cue.Builder) treeMap.get(str)).text;
        charSequence.getClass();
        return (SpannableStringBuilder) charSequence;
    }

    public final TtmlNode getChild(int i) {
        ArrayList arrayList = this.children;
        if (arrayList != null) {
            return (TtmlNode) arrayList.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int getChildCount() {
        ArrayList arrayList = this.children;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void getEventTimes(TreeSet treeSet, boolean z) {
        String str = this.tag;
        boolean zEquals = "p".equals(str);
        boolean zEquals2 = "div".equals(str);
        if (z || zEquals || (zEquals2 && this.imageId != null)) {
            long j = this.startTimeUs;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.endTimeUs;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.children == null) {
            return;
        }
        for (int i = 0; i < this.children.size(); i++) {
            ((TtmlNode) this.children.get(i)).getEventTimes(treeSet, z || zEquals);
        }
    }

    public final boolean isActive(long j) {
        long j2 = this.startTimeUs;
        long j3 = this.endTimeUs;
        if (j2 == -9223372036854775807L && j3 == -9223372036854775807L) {
            return true;
        }
        if (j2 <= j && j3 == -9223372036854775807L) {
            return true;
        }
        if (j2 != -9223372036854775807L || j >= j3) {
            return j2 <= j && j < j3;
        }
        return true;
    }

    public final void traverseForImage(long j, String str, ArrayList arrayList) {
        String str2;
        String str3 = this.regionId;
        if (!"".equals(str3)) {
            str = str3;
        }
        if (isActive(j) && "div".equals(this.tag) && (str2 = this.imageId) != null) {
            arrayList.add(new Pair(str, str2));
            return;
        }
        for (int i = 0; i < getChildCount(); i++) {
            getChild(i).traverseForImage(j, str, arrayList);
        }
    }

    /* JADX WARN: Code duplicated, block: B:143:0x020a  */
    /* JADX WARN: Code duplicated, block: B:146:0x0218  */
    /* JADX WARN: Code duplicated, block: B:148:0x021b  */
    /* JADX WARN: Code duplicated, block: B:150:0x021e  */
    /* JADX WARN: Code duplicated, block: B:151:0x0224  */
    /* JADX WARN: Code duplicated, block: B:153:0x0237  */
    /* JADX WARN: Code duplicated, block: B:165:0x0269  */
    /* JADX WARN: Code duplicated, block: B:168:0x0281  */
    /* JADX WARN: Code duplicated, block: B:169:0x0290  */
    /* JADX WARN: Code duplicated, block: B:172:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:174:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:177:0x02be  */
    /* JADX WARN: Code duplicated, block: B:180:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:193:0x02cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x02cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:48:0x00be  */
    public final void traverseForStyle(long j, Map map, HashMap map2, String str, TreeMap treeMap) {
        Iterator it;
        int i;
        TtmlNode ttmlNode;
        int i2;
        TtmlStyle ttmlStyleResolveStyle;
        int i3;
        float f;
        float f2;
        float f3;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        RelativeSizeSpan[] relativeSizeSpanArr;
        int length;
        float sizeChange;
        int i4;
        RelativeSizeSpan relativeSizeSpan;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Map map3 = map;
        if (isActive(j)) {
            String str2 = this.regionId;
            String str3 = "".equals(str2) ? str : str2;
            Iterator it2 = this.nodeEndsByRegion.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                String str4 = (String) entry.getKey();
                HashMap map4 = this.nodeStartsByRegion;
                int iIntValue = map4.containsKey(str4) ? ((Integer) map4.get(str4)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    Cue.Builder builder = (Cue.Builder) treeMap.get(str4);
                    builder.getClass();
                    TtmlRegion ttmlRegion = (TtmlRegion) map2.get(str3);
                    ttmlRegion.getClass();
                    int i10 = ttmlRegion.verticalType;
                    TtmlStyle ttmlStyleResolveStyle2 = SizeKt.resolveStyle(this.style, this.styleIds, map3);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) builder.text;
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        builder.text = spannableStringBuilder;
                        builder.bitmap = null;
                    }
                    if (ttmlStyleResolveStyle2 != null) {
                        int i11 = ttmlStyleResolveStyle2.bold;
                        int i12 = 1;
                        if (((i11 == -1 && ttmlStyleResolveStyle2.italic == -1) ? -1 : (i11 == 1 ? (char) 1 : (char) 0) | (ttmlStyleResolveStyle2.italic == 1 ? (char) 2 : (char) 0)) != -1) {
                            int i13 = ttmlStyleResolveStyle2.bold;
                            if (i13 != -1) {
                                if (i13 == i12) {
                                    i7 = i12;
                                } else {
                                    i7 = 0;
                                }
                                if (ttmlStyleResolveStyle2.italic == i12) {
                                    i8 = 2;
                                } else {
                                    i8 = 0;
                                }
                                i9 = i7 | i8;
                            } else if (ttmlStyleResolveStyle2.italic == -1) {
                                i9 = -1;
                                i12 = 1;
                            } else {
                                i12 = 1;
                                if (i13 == i12) {
                                    i7 = i12;
                                } else {
                                    i7 = 0;
                                }
                                if (ttmlStyleResolveStyle2.italic == i12) {
                                    i8 = 2;
                                } else {
                                    i8 = 0;
                                }
                                i9 = i7 | i8;
                            }
                            StyleSpan styleSpan = new StyleSpan(i9);
                            i = 33;
                            spannableStringBuilder.setSpan(styleSpan, iIntValue, iIntValue2, 33);
                        } else {
                            i = 33;
                        }
                        if (ttmlStyleResolveStyle2.linethrough == i12) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), iIntValue, iIntValue2, i);
                        }
                        if (ttmlStyleResolveStyle2.underline == i12) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), iIntValue, iIntValue2, i);
                        }
                        if (ttmlStyleResolveStyle2.hasFontColor) {
                            if (!ttmlStyleResolveStyle2.hasFontColor) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Font color has not been defined.");
                                return;
                            }
                            DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new ForegroundColorSpan(ttmlStyleResolveStyle2.fontColor), iIntValue, iIntValue2);
                        }
                        if (ttmlStyleResolveStyle2.hasBackgroundColor) {
                            if (!ttmlStyleResolveStyle2.hasBackgroundColor) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Background color has not been defined.");
                                return;
                            }
                            DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new BackgroundColorSpan(ttmlStyleResolveStyle2.backgroundColor), iIntValue, iIntValue2);
                        }
                        if (ttmlStyleResolveStyle2.fontFamily != null) {
                            DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new TypefaceSpan(ttmlStyleResolveStyle2.fontFamily), iIntValue, iIntValue2);
                        }
                        TextEmphasis textEmphasis = ttmlStyleResolveStyle2.textEmphasis;
                        if (textEmphasis != null) {
                            int i14 = textEmphasis.markShape;
                            if (i14 == -1) {
                                i14 = (i10 == 2 || i10 == 1) ? 3 : 1;
                                i6 = 1;
                            } else {
                                i6 = textEmphasis.markFill;
                            }
                            int i15 = textEmphasis.position;
                            if (i15 == -2) {
                                i15 = 1;
                            }
                            DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new TextEmphasisSpan(i14, i6, i15), iIntValue, iIntValue2);
                        }
                        int i16 = ttmlStyleResolveStyle2.rubyType;
                        if (i16 == 2) {
                            TtmlNode ttmlNode2 = this.parent;
                            while (true) {
                                if (ttmlNode2 == null) {
                                    ttmlNode2 = null;
                                    break;
                                }
                                TtmlStyle ttmlStyleResolveStyle3 = SizeKt.resolveStyle(ttmlNode2.style, ttmlNode2.styleIds, map3);
                                if (ttmlStyleResolveStyle3 != null && ttmlStyleResolveStyle3.rubyType == 1) {
                                    break;
                                } else {
                                    ttmlNode2 = ttmlNode2.parent;
                                }
                            }
                            if (ttmlNode2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(ttmlNode2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        ttmlNode = null;
                                        break;
                                    }
                                    TtmlNode ttmlNode3 = (TtmlNode) arrayDeque.pop();
                                    TtmlStyle ttmlStyleResolveStyle4 = SizeKt.resolveStyle(ttmlNode3.style, ttmlNode3.styleIds, map3);
                                    if (ttmlStyleResolveStyle4 != null && ttmlStyleResolveStyle4.rubyType == 3) {
                                        ttmlNode = ttmlNode3;
                                        break;
                                    }
                                    for (int childCount = ttmlNode3.getChildCount() - 1; childCount >= 0; childCount--) {
                                        arrayDeque.push(ttmlNode3.getChild(childCount));
                                    }
                                }
                                if (ttmlNode != null) {
                                    if (ttmlNode.getChildCount() == 1) {
                                        i2 = 0;
                                        if (ttmlNode.getChild(0).text != null) {
                                            String str5 = ttmlNode.getChild(0).text;
                                            String str6 = Util.DEVICE_DEBUG_INFO;
                                            TtmlStyle ttmlStyleResolveStyle5 = SizeKt.resolveStyle(ttmlNode.style, ttmlNode.styleIds, map3);
                                            int i17 = ttmlStyleResolveStyle5 != null ? ttmlStyleResolveStyle5.rubyPosition : -1;
                                            if (i17 == -1 && (ttmlStyleResolveStyle = SizeKt.resolveStyle(ttmlNode2.style, ttmlNode2.styleIds, map3)) != null) {
                                                i17 = ttmlStyleResolveStyle.rubyPosition;
                                            }
                                            spannableStringBuilder.setSpan(new RubySpan(str5, i17), iIntValue, iIntValue2, 33);
                                        }
                                    } else {
                                        i2 = 0;
                                    }
                                    Log.i("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                }
                            }
                            if (ttmlStyleResolveStyle2.textCombine == 1) {
                                DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new HorizontalTextInVerticalContextSpan(), iIntValue, iIntValue2);
                            }
                            i3 = ttmlStyleResolveStyle2.fontSizeUnit;
                            f = 100.0f;
                            if (i3 != 1) {
                                it = it2;
                                f2 = 100.0f;
                                DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new AbsoluteSizeSpan((int) ttmlStyleResolveStyle2.fontSize, true), iIntValue, iIntValue2);
                            } else if (i3 != 2) {
                                it = it2;
                                f2 = 100.0f;
                                DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new RelativeSizeSpan(ttmlStyleResolveStyle2.fontSize), iIntValue, iIntValue2);
                            } else if (i3 != 3) {
                                it = it2;
                                f2 = 100.0f;
                            } else {
                                float f4 = ttmlStyleResolveStyle2.fontSize / 100.0f;
                                relativeSizeSpanArr = (RelativeSizeSpan[]) spannableStringBuilder.getSpans(iIntValue, iIntValue2, RelativeSizeSpan.class);
                                length = relativeSizeSpanArr.length;
                                int i18 = i2;
                                sizeChange = f4;
                                i4 = i18;
                                while (i4 < length) {
                                    float f5 = f;
                                    relativeSizeSpan = relativeSizeSpanArr[i4];
                                    Iterator it3 = it2;
                                    if (spannableStringBuilder.getSpanStart(relativeSizeSpan) <= iIntValue && spannableStringBuilder.getSpanEnd(relativeSizeSpan) >= iIntValue2) {
                                        sizeChange = relativeSizeSpan.getSizeChange() * sizeChange;
                                    }
                                    if (spannableStringBuilder.getSpanStart(relativeSizeSpan) == iIntValue || spannableStringBuilder.getSpanEnd(relativeSizeSpan) != iIntValue2) {
                                        i5 = i4;
                                    } else {
                                        i5 = i4;
                                        if (spannableStringBuilder.getSpanFlags(relativeSizeSpan) == 33) {
                                            spannableStringBuilder.removeSpan(relativeSizeSpan);
                                        }
                                    }
                                    i4 = i5 + 1;
                                    f = f5;
                                    it2 = it3;
                                }
                                it = it2;
                                f2 = f;
                                spannableStringBuilder.setSpan(new RelativeSizeSpan(sizeChange), iIntValue, iIntValue2, 33);
                            }
                            if ("p".equals(this.tag)) {
                                f3 = ttmlStyleResolveStyle2.shearPercentage;
                                if (f3 != Float.MAX_VALUE) {
                                    builder.shearDegrees = (f3 * (-90.0f)) / f2;
                                }
                                alignment = ttmlStyleResolveStyle2.textAlign;
                                if (alignment != null) {
                                    builder.textAlignment = alignment;
                                }
                                alignment2 = ttmlStyleResolveStyle2.multiRowAlign;
                                if (alignment2 != null) {
                                    builder.multiRowAlignment = alignment2;
                                }
                            }
                        } else if (i16 == 3 || i16 == 4) {
                            spannableStringBuilder.setSpan(new DeleteTextSpan(), iIntValue, iIntValue2, 33);
                        }
                        i2 = 0;
                        if (ttmlStyleResolveStyle2.textCombine == 1) {
                            DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new HorizontalTextInVerticalContextSpan(), iIntValue, iIntValue2);
                        }
                        i3 = ttmlStyleResolveStyle2.fontSizeUnit;
                        f = 100.0f;
                        if (i3 != 1) {
                            it = it2;
                            f2 = 100.0f;
                            DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new AbsoluteSizeSpan((int) ttmlStyleResolveStyle2.fontSize, true), iIntValue, iIntValue2);
                        } else if (i3 != 2) {
                            it = it2;
                            f2 = 100.0f;
                            DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new RelativeSizeSpan(ttmlStyleResolveStyle2.fontSize), iIntValue, iIntValue2);
                        } else if (i3 != 3) {
                            it = it2;
                            f2 = 100.0f;
                        } else {
                            float f6 = ttmlStyleResolveStyle2.fontSize / 100.0f;
                            relativeSizeSpanArr = (RelativeSizeSpan[]) spannableStringBuilder.getSpans(iIntValue, iIntValue2, RelativeSizeSpan.class);
                            length = relativeSizeSpanArr.length;
                            int i19 = i2;
                            sizeChange = f6;
                            i4 = i19;
                            while (i4 < length) {
                                float f7 = f;
                                relativeSizeSpan = relativeSizeSpanArr[i4];
                                Iterator it4 = it2;
                                if (spannableStringBuilder.getSpanStart(relativeSizeSpan) <= iIntValue) {
                                    sizeChange = relativeSizeSpan.getSizeChange() * sizeChange;
                                }
                                if (spannableStringBuilder.getSpanStart(relativeSizeSpan) == iIntValue) {
                                    i5 = i4;
                                } else {
                                    i5 = i4;
                                }
                                i4 = i5 + 1;
                                f = f7;
                                it2 = it4;
                            }
                            it = it2;
                            f2 = f;
                            spannableStringBuilder.setSpan(new RelativeSizeSpan(sizeChange), iIntValue, iIntValue2, 33);
                        }
                        if ("p".equals(this.tag)) {
                            f3 = ttmlStyleResolveStyle2.shearPercentage;
                            if (f3 != Float.MAX_VALUE) {
                                builder.shearDegrees = (f3 * (-90.0f)) / f2;
                            }
                            alignment = ttmlStyleResolveStyle2.textAlign;
                            if (alignment != null) {
                                builder.textAlignment = alignment;
                            }
                            alignment2 = ttmlStyleResolveStyle2.multiRowAlign;
                            if (alignment2 != null) {
                                builder.multiRowAlignment = alignment2;
                            }
                        }
                    }
                    it2 = it;
                }
                it = it2;
                it2 = it;
            }
            int i20 = 0;
            while (i20 < getChildCount()) {
                getChild(i20).traverseForStyle(j, map3, map2, str3, treeMap);
                i20++;
                map3 = map;
            }
        }
    }

    public final void traverseForText(long j, boolean z, String str, TreeMap treeMap) {
        HashMap map = this.nodeStartsByRegion;
        map.clear();
        HashMap map2 = this.nodeEndsByRegion;
        map2.clear();
        String str2 = this.tag;
        if ("metadata".equals(str2)) {
            return;
        }
        String str3 = this.regionId;
        String str4 = "".equals(str3) ? str : str3;
        if (this.isTextNode && z) {
            SpannableStringBuilder regionOutputText = getRegionOutputText(str4, treeMap);
            String str5 = this.text;
            str5.getClass();
            regionOutputText.append((CharSequence) str5);
            return;
        }
        if ("br".equals(str2) && z) {
            getRegionOutputText(str4, treeMap).append('\n');
            return;
        }
        if (isActive(j)) {
            for (Map.Entry entry : treeMap.entrySet()) {
                String str6 = (String) entry.getKey();
                CharSequence charSequence = ((Cue.Builder) entry.getValue()).text;
                charSequence.getClass();
                map.put(str6, Integer.valueOf(charSequence.length()));
            }
            boolean zEquals = "p".equals(str2);
            for (int i = 0; i < getChildCount(); i++) {
                getChild(i).traverseForText(j, z || zEquals, str4, treeMap);
            }
            if (zEquals) {
                SpannableStringBuilder regionOutputText2 = getRegionOutputText(str4, treeMap);
                int length = regionOutputText2.length() - 1;
                while (length >= 0 && regionOutputText2.charAt(length) == ' ') {
                    length--;
                }
                if (length >= 0 && regionOutputText2.charAt(length) != '\n') {
                    regionOutputText2.append('\n');
                }
            }
            for (Map.Entry entry2 : treeMap.entrySet()) {
                String str7 = (String) entry2.getKey();
                CharSequence charSequence2 = ((Cue.Builder) entry2.getValue()).text;
                charSequence2.getClass();
                map2.put(str7, Integer.valueOf(charSequence2.length()));
            }
        }
    }
}
