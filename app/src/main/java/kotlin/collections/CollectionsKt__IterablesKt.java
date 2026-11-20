package kotlin.collections;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import coil3.util.UtilsKt;
import com.materialkolor.quantize.QuantizerWu;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.constants.DimensionsKt;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.theme.UiStyleKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.File;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.builders.ListBuilder;
import kotlin.enums.EnumEntriesList;
import kotlin.jvm.internal.Reflection;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.text.HexExtensionsKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatcherMatchResult;
import kotlin.text.MatcherMatchResult$groups$1;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.Uuid;
import kotlin.uuid.UuidKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonEncoder;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CollectionsKt__IterablesKt {
    public static final void ListItemPlaceHolder(Modifier modifier, Shape shape, Composer composer, int i) {
        Modifier modifier2;
        Shape shapeM185RoundedCornerShape0680j_4;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-713478723);
        int i2 = i | 22;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            gapComposer.startDefaults();
            int i3 = i & 1;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (i3 == 0 || gapComposer.getDefaultsInvalid()) {
                SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                shapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(UiStyleKt.m1516styledRadiusi1RSzL4(16.0f, 10.0f, gapComposer));
                modifier2 = companion;
            } else {
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                shapeM185RoundedCornerShape0680j_4 = shape;
            }
            gapComposer.endDefaults();
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            SpringSpec springSpec2 = DimensionsKt.NavigationBarAnimationSpec;
            Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.m145height3ABfNKs(modifier2, 64.0f), 6.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, vertical, gapComposer, 48);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            boolean z = gapComposer.inserting;
            TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
            if (z) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m390setimpl(gapComposer, rowMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
            Integer numValueOf = Integer.valueOf(iHashCode);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m390setimpl(gapComposer, numValueOf, updater$$ExternalSyntheticLambda2);
            Stack.m389reconcileimpl(gapComposer);
            Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
            OffsetKt.Spacer(gapComposer, ImageKt.m39backgroundbw27NRU(ClipKt.clip(SizeKt.m151size3ABfNKs(OffsetKt.m135padding3ABfNKs(companion, 6.0f), 48.0f), shapeM185RoundedCornerShape0680j_4), ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceContainerHigh, ColorKt.RectangleShape));
            Modifier modifierM137paddingVpY3zN4$default2 = OffsetKt.m137paddingVpY3zN4$default(new LayoutWeightElement(1.0f, true), 6.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
            int iHashCode2 = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer, modifierM137paddingVpY3zN4$default2);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(textKt$$ExternalSyntheticLambda3);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, updater$$ExternalSyntheticLambda0);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
            IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer, updater$$ExternalSyntheticLambda2, gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
            UuidKt.m1896TextPlaceholderuFdPcIQ(null, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer, 0, 7);
            UuidKt.m1896TextPlaceholderuFdPcIQ(null, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer, 0, 7);
            gapComposer.end(true);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            shapeM185RoundedCornerShape0680j_4 = shape;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda1(modifier2, shapeM185RoundedCornerShape0680j_4, i, (byte) 15);
        }
    }

    public static final Path Path(Path path, String... strArr) {
        path.getClass();
        String string = path.toString();
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        StringBuilder sbM = Format$$ExternalSyntheticOutline0.m(string);
        for (String str : strArr2) {
            if (sbM.length() > 0) {
                char c = PathsJvmKt.SystemPathSeparator;
                if (!StringsKt.endsWith$default(sbM, c)) {
                    sbM.append(c);
                }
            }
            sbM.append(str);
        }
        String string2 = sbM.toString();
        char c2 = PathsJvmKt.SystemPathSeparator;
        return new Path(new File(string2));
    }

    public static ArrayList arrayListOf(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(objArr, true));
    }

    public static final JsonDecoder asJsonDecoder(Decoder decoder) {
        decoder.getClass();
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder != null) {
            return jsonDecoder;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Reflection.getOrCreateKotlinClass(decoder.getClass()), "This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got ");
        return null;
    }

    public static final void asJsonEncoder(Encoder encoder) {
        encoder.getClass();
        if ((encoder instanceof JsonEncoder ? (JsonEncoder) encoder : null) != null) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Reflection.getOrCreateKotlinClass(encoder.getClass()), "This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got ");
    }

    public static int binarySearch$default(ArrayList arrayList, Comparable comparable) {
        int size = arrayList.size();
        arrayList.getClass();
        rangeCheck$CollectionsKt__CollectionsKt(arrayList.size(), size);
        int i = size - 1;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            int iCompareValues = RegexKt.compareValues((Comparable) arrayList.get(i3), comparable);
            if (iCompareValues < 0) {
                i2 = i3 + 1;
            } else {
                if (iCompareValues <= 0) {
                    return i3;
                }
                i = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:47:0x0108  */
    /* JADX WARN: Code duplicated, block: B:71:0x0194  */
    /* JADX WARN: Code duplicated, block: B:72:0x019c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10, types: [io.ktor.client.statement.HttpResponse, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0159 -> B:62:0x0161). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0194 -> B:41:0x00da). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object bodyAsTextLimited(io.ktor.client.statement.HttpResponse r22, int r23, kotlin.jvm.functions.Function2 r24, kotlin.coroutines.jvm.internal.ContinuationImpl r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt__IterablesKt.bodyAsTextLimited(io.ktor.client.statement.HttpResponse, int, kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static int bottom(QuantizerWu.Box box, QuantizerWu.Direction direction, int[] iArr) {
        int i;
        int i2;
        iArr.getClass();
        int iOrdinal = direction.ordinal();
        if (iOrdinal == 0) {
            i = (-iArr[getIndex(box.r0, box.g1, box.b1)]) + iArr[getIndex(box.r0, box.g1, box.b0)] + iArr[getIndex(box.r0, box.g0, box.b1)];
            i2 = iArr[getIndex(box.r0, box.g0, box.b0)];
        } else if (iOrdinal == 1) {
            i = (-iArr[getIndex(box.r1, box.g0, box.b1)]) + iArr[getIndex(box.r1, box.g0, box.b0)] + iArr[getIndex(box.r0, box.g0, box.b1)];
            i2 = iArr[getIndex(box.r0, box.g0, box.b0)];
        } else {
            if (iOrdinal != 2) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return 0;
            }
            i = (-iArr[getIndex(box.r1, box.g1, box.b0)]) + iArr[getIndex(box.r1, box.g0, box.b0)] + iArr[getIndex(box.r0, box.g1, box.b0)];
            i2 = iArr[getIndex(box.r0, box.g0, box.b0)];
        }
        return i - i2;
    }

    public static final String boundsErrorMessage(Number number, Number number2) {
        return "Random range is empty: [" + number + ", " + number2 + ").";
    }

    public static ListBuilder build(List list) {
        list.getClass();
        ListBuilder listBuilder = (ListBuilder) list;
        listBuilder.checkIsMutable$1();
        listBuilder.isReadOnly = true;
        return listBuilder.length > 0 ? listBuilder : ListBuilder.Empty;
    }

    public static void buildTrieRecursive(long j, Buffer buffer, int i, ArrayList arrayList, int i2, int i3, ArrayList arrayList2) {
        int i4;
        int i5;
        ArrayList arrayList3;
        long j2;
        int i6;
        int i7 = i;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i2 >= i3) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
            return;
        }
        for (int i8 = i2; i8 < i3; i8++) {
            if (((ByteString) arrayList4.get(i8)).getSize$okio() < i7) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Failed requirement.");
                return;
            }
        }
        ByteString byteString = (ByteString) arrayList.get(i2);
        ByteString byteString2 = (ByteString) arrayList4.get(i3 - 1);
        if (i7 == byteString.getSize$okio()) {
            int iIntValue = ((Number) arrayList5.get(i2)).intValue();
            int i9 = i2 + 1;
            ByteString byteString3 = (ByteString) arrayList4.get(i9);
            i4 = i9;
            i5 = iIntValue;
            byteString = byteString3;
        } else {
            i4 = i2;
            i5 = -1;
        }
        if (byteString.internalGet$okio(i7) == byteString2.internalGet$okio(i7)) {
            int iMin = Math.min(byteString.getSize$okio(), byteString2.getSize$okio());
            int i10 = 0;
            for (int i11 = i7; i11 < iMin && byteString.internalGet$okio(i11) == byteString2.internalGet$okio(i11); i11++) {
                i10++;
            }
            long j3 = (buffer.size / 4) + j + 2 + ((long) i10) + 1;
            buffer.writeInt(-i10);
            buffer.writeInt(i5);
            int i12 = i7 + i10;
            while (i7 < i12) {
                buffer.writeInt(byteString.internalGet$okio(i7) & 255);
                i7++;
            }
            if (i4 + 1 == i3) {
                if (i12 == ((ByteString) arrayList4.get(i4)).getSize$okio()) {
                    buffer.writeInt(((Number) arrayList5.get(i4)).intValue());
                    return;
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
                    return;
                }
            }
            Buffer buffer2 = new Buffer();
            buffer.writeInt(((int) ((buffer2.size / 4) + j3)) * (-1));
            buildTrieRecursive(j3, buffer2, i12, arrayList4, i4, i3, arrayList5);
            buffer.writeAll(buffer2);
            return;
        }
        int i13 = 1;
        for (int i14 = i4 + 1; i14 < i3; i14++) {
            if (((ByteString) arrayList4.get(i14 - 1)).internalGet$okio(i7) != ((ByteString) arrayList4.get(i14)).internalGet$okio(i7)) {
                i13++;
            }
        }
        long j4 = (buffer.size / 4) + j + 2 + ((long) (i13 * 2));
        buffer.writeInt(i13);
        buffer.writeInt(i5);
        for (int i15 = i4; i15 < i3; i15++) {
            int iInternalGet$okio = ((ByteString) arrayList4.get(i15)).internalGet$okio(i7);
            if (i15 == i4 || iInternalGet$okio != ((ByteString) arrayList4.get(i15 - 1)).internalGet$okio(i7)) {
                buffer.writeInt(iInternalGet$okio & 255);
            }
        }
        Buffer buffer3 = new Buffer();
        int i16 = i4;
        while (i16 < i3) {
            byte bInternalGet$okio = ((ByteString) arrayList4.get(i16)).internalGet$okio(i7);
            int i17 = i16 + 1;
            int i18 = i17;
            while (true) {
                if (i18 >= i3) {
                    i18 = i3;
                    break;
                } else if (bInternalGet$okio != ((ByteString) arrayList4.get(i18)).internalGet$okio(i7)) {
                    break;
                } else {
                    i18++;
                }
            }
            if (i17 == i18 && i7 + 1 == ((ByteString) arrayList4.get(i16)).getSize$okio()) {
                buffer.writeInt(((Number) arrayList5.get(i16)).intValue());
                arrayList3 = arrayList5;
                j2 = j4;
                i6 = i18;
            } else {
                buffer.writeInt(((int) ((buffer3.size / 4) + j4)) * (-1));
                arrayList3 = arrayList5;
                j2 = j4;
                i6 = i18;
                buildTrieRecursive(j2, buffer3, i7 + 1, arrayList, i16, i6, arrayList3);
                arrayList4 = arrayList;
            }
            j4 = j2;
            i16 = i6;
            arrayList5 = arrayList3;
        }
        buffer.writeAll(buffer3);
    }

    public static byte checkedCast(long j) {
        UtilsKt.checkArgument(j, "out of range: %s", (j >> 8) == 0);
        return (byte) j;
    }

    public static int collectionSizeOrDefault(Iterable iterable, int i) {
        iterable.getClass();
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    public static ListBuilder createListBuilder() {
        return new ListBuilder(10);
    }

    public static final EnumEntriesList enumEntries(Enum[] enumArr) {
        enumArr.getClass();
        return new EnumEntriesList(enumArr);
    }

    public static final List filterExplicit(List list, boolean z) {
        list.getClass();
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!((Song) obj).song.explicit) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final List filterExplicitAlbums(List list, boolean z) {
        list.getClass();
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!((Album) obj).album.explicit) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final List filterVideoSongs(List list, boolean z) {
        list.getClass();
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!((Song) obj).song.isVideo) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final List filterYoutubeShorts(List list, boolean z) {
        list.getClass();
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            String str = ((Playlist) obj).playlist.browseId;
            if (str == null || !StringsKt__StringsJVMKt.startsWith(str, "SS", false)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static ArrayList flatten(Iterable iterable) {
        iterable.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll((Iterable) it.next(), arrayList);
        }
        return arrayList;
    }

    public static final String generateLocalId(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < 8; i++) {
            AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(Random.defaultRandom.nextInt(52)));
        }
        return sb.toString();
    }

    public static MediaType get(String str) {
        str.getClass();
        MatcherMatchResult matcherMatchResultMatchAt = MediaType.TYPE_SUBTYPE.matchAt(0, str);
        if (matcherMatchResultMatchAt == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Format$$ExternalSyntheticOutline0.m('\"', "No subtype found for: \"", str));
            return null;
        }
        String str2 = (String) ((ReversedListReadOnly) matcherMatchResultMatchAt.getGroupValues()).get(1);
        Locale locale = Locale.ROOT;
        String lowerCase = str2.toLowerCase(locale);
        lowerCase.getClass();
        String lowerCase2 = ((String) ((ReversedListReadOnly) matcherMatchResultMatchAt.getGroupValues()).get(2)).toLowerCase(locale);
        lowerCase2.getClass();
        ArrayList arrayList = new ArrayList();
        int i = matcherMatchResultMatchAt.getRange().last;
        while (true) {
            int i2 = i + 1;
            if (i2 >= str.length()) {
                return new MediaType(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
            }
            MatcherMatchResult matcherMatchResultMatchAt2 = MediaType.PARAMETER.matchAt(i2, str);
            if (matcherMatchResultMatchAt2 == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m("Parameter is not formatted correctly: \"", str.substring(i2), "\" for: \"", str, 34);
                return null;
            }
            MatcherMatchResult$groups$1 matcherMatchResult$groups$1 = matcherMatchResultMatchAt2.groups;
            MatchGroup matchGroup = matcherMatchResult$groups$1.get(1);
            String str3 = matchGroup != null ? matchGroup.value : null;
            if (str3 == null) {
                i = matcherMatchResultMatchAt2.getRange().last;
            } else {
                MatchGroup matchGroup2 = matcherMatchResult$groups$1.get(2);
                String strSubstring = matchGroup2 != null ? matchGroup2.value : null;
                if (strSubstring == null) {
                    MatchGroup matchGroup3 = matcherMatchResult$groups$1.get(3);
                    matchGroup3.getClass();
                    strSubstring = matchGroup3.value;
                } else if (StringsKt.startsWith$default(strSubstring, '\'') && StringsKt.endsWith$default((CharSequence) strSubstring, '\'') && strSubstring.length() > 2) {
                    strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                }
                arrayList.add(str3);
                arrayList.add(strSubstring);
                i = matcherMatchResultMatchAt2.getRange().last;
            }
        }
    }

    public static int getIndex(int i, int i2, int i3) {
        return (i << 10) + (i << 6) + i + (i2 << 5) + i2 + i3;
    }

    public static IntRange getIndices(Collection collection) {
        collection.getClass();
        return new IntRange(0, collection.size() - 1, 1);
    }

    public static int getLastIndex(List list) {
        list.getClass();
        return list.size() - 1;
    }

    public static List listOf(Object... objArr) {
        objArr.getClass();
        if (objArr.length <= 0) {
            return EmptyList.INSTANCE;
        }
        List listAsList = Arrays.asList(objArr);
        listAsList.getClass();
        return listAsList;
    }

    public static List listOfNotNull(Object obj) {
        return obj != null ? listOf(obj) : EmptyList.INSTANCE;
    }

    public static ArrayList mutableListOf(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(objArr, true));
    }

    public static final List optimizeReadOnlyList(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : listOf(list.get(0));
        }
        return EmptyList.INSTANCE;
    }

    public static Uuid parse(String str) {
        str.getClass();
        int length = str.length();
        int i = 0;
        if (length == 32) {
            long j = 0;
            while (i < 16) {
                long j2 = j << 4;
                char cCharAt = str.charAt(i);
                if ((cCharAt >>> '\b') == 0) {
                    long j3 = HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
                    if (j3 >= 0) {
                        j = j2 | j3;
                        i++;
                    }
                }
                UuidKt.uuidThrowUnexpectedCharacterException(i, str, "a hexadecimal digit");
                throw null;
            }
            long j4 = 0;
            for (int i2 = 16; i2 < 32; i2++) {
                long j5 = j4 << 4;
                char cCharAt2 = str.charAt(i2);
                if ((cCharAt2 >>> '\b') == 0) {
                    long j6 = HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt2];
                    if (j6 >= 0) {
                        j4 = j5 | j6;
                    }
                }
                UuidKt.uuidThrowUnexpectedCharacterException(i2, str, "a hexadecimal digit");
                throw null;
            }
            if (j != 0 || j4 != 0) {
                return new Uuid(j, j4);
            }
        } else {
            if (length != 36) {
                StringBuilder sb = new StringBuilder("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
                sb.append(str.length() <= 64 ? str : str.substring(0, 64).concat("..."));
                sb.append("\" of length ");
                sb.append(str.length());
                throw new IllegalArgumentException(sb.toString());
            }
            long j7 = 0;
            while (i < 8) {
                long j8 = j7 << 4;
                char cCharAt3 = str.charAt(i);
                if ((cCharAt3 >>> '\b') == 0) {
                    long j9 = HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt3];
                    if (j9 >= 0) {
                        j7 = j8 | j9;
                        i++;
                    }
                }
                UuidKt.uuidThrowUnexpectedCharacterException(i, str, "a hexadecimal digit");
                throw null;
            }
            if (str.charAt(8) != '-') {
                UuidKt.uuidThrowUnexpectedCharacterException(8, str, "'-' (hyphen)");
                throw null;
            }
            long j10 = 0;
            for (int i3 = 9; i3 < 13; i3++) {
                long j11 = j10 << 4;
                char cCharAt4 = str.charAt(i3);
                if ((cCharAt4 >>> '\b') == 0) {
                    long j12 = HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt4];
                    if (j12 >= 0) {
                        j10 = j11 | j12;
                    }
                }
                UuidKt.uuidThrowUnexpectedCharacterException(i3, str, "a hexadecimal digit");
                throw null;
            }
            if (str.charAt(13) != '-') {
                UuidKt.uuidThrowUnexpectedCharacterException(13, str, "'-' (hyphen)");
                throw null;
            }
            long j13 = 0;
            for (int i4 = 14; i4 < 18; i4++) {
                long j14 = j13 << 4;
                char cCharAt5 = str.charAt(i4);
                if ((cCharAt5 >>> '\b') == 0) {
                    long j15 = HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt5];
                    if (j15 >= 0) {
                        j13 = j14 | j15;
                    }
                }
                UuidKt.uuidThrowUnexpectedCharacterException(i4, str, "a hexadecimal digit");
                throw null;
            }
            if (str.charAt(18) != '-') {
                UuidKt.uuidThrowUnexpectedCharacterException(18, str, "'-' (hyphen)");
                throw null;
            }
            long j16 = 0;
            for (int i5 = 19; i5 < 23; i5++) {
                long j17 = j16 << 4;
                char cCharAt6 = str.charAt(i5);
                if ((cCharAt6 >>> '\b') == 0) {
                    long j18 = HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt6];
                    if (j18 >= 0) {
                        j16 = j17 | j18;
                    }
                }
                UuidKt.uuidThrowUnexpectedCharacterException(i5, str, "a hexadecimal digit");
                throw null;
            }
            if (str.charAt(23) != '-') {
                UuidKt.uuidThrowUnexpectedCharacterException(23, str, "'-' (hyphen)");
                throw null;
            }
            long j19 = 0;
            for (int i6 = 24; i6 < 36; i6++) {
                long j20 = j19 << 4;
                char cCharAt7 = str.charAt(i6);
                if ((cCharAt7 >>> '\b') == 0) {
                    long j21 = HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[cCharAt7];
                    if (j21 >= 0) {
                        j19 = j20 | j21;
                    }
                }
                UuidKt.uuidThrowUnexpectedCharacterException(i6, str, "a hexadecimal digit");
                throw null;
            }
            long j22 = (j7 << 32) | (j10 << 16) | j13;
            long j23 = (j16 << 48) | j19;
            if (j22 != 0 || j23 != 0) {
                return new Uuid(j22, j23);
            }
        }
        return Uuid.NIL;
    }

    public static final String presence(String str) {
        return (str == null || StringsKt.isBlank(str)) ? "missing" : "present";
    }

    public static final void rangeCheck$CollectionsKt__CollectionsKt(int i, int i2) {
        if (i2 < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i2, "fromIndex (0) is greater than toIndex (", ")."));
        } else {
            if (i2 <= i) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m(IntIntPair$$ExternalSyntheticOutline0.m(i2, "toIndex (", ") is greater than size (", i, ")."));
        }
    }

    public static final List reversed(List list, boolean z) {
        list.getClass();
        return z ? new ReversedListReadOnly(list) : list;
    }

    public static List shuffled(Iterable iterable) {
        iterable.getClass();
        List mutableList = CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }

    public static void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static int top(QuantizerWu.Box box, QuantizerWu.Direction direction, int i, int[] iArr) {
        int i2;
        int i3;
        iArr.getClass();
        int iOrdinal = direction.ordinal();
        if (iOrdinal == 0) {
            i2 = (iArr[getIndex(i, box.g1, box.b1)] - iArr[getIndex(i, box.g1, box.b0)]) - iArr[getIndex(i, box.g0, box.b1)];
            i3 = iArr[getIndex(i, box.g0, box.b0)];
        } else if (iOrdinal == 1) {
            i2 = (iArr[getIndex(box.r1, i, box.b1)] - iArr[getIndex(box.r1, i, box.b0)]) - iArr[getIndex(box.r0, i, box.b1)];
            i3 = iArr[getIndex(box.r0, i, box.b0)];
        } else {
            if (iOrdinal != 2) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return 0;
            }
            i2 = (iArr[getIndex(box.r1, box.g1, i)] - iArr[getIndex(box.r1, box.g0, i)]) - iArr[getIndex(box.r0, box.g1, i)];
            i3 = iArr[getIndex(box.r0, box.g0, i)];
        }
        return i2 + i3;
    }

    public static int volume(QuantizerWu.Box box, int[] iArr) {
        iArr.getClass();
        box.getClass();
        return ((((((iArr[getIndex(box.r1, box.g1, box.b1)] - iArr[getIndex(box.r1, box.g1, box.b0)]) - iArr[getIndex(box.r1, box.g0, box.b1)]) + iArr[getIndex(box.r1, box.g0, box.b0)]) - iArr[getIndex(box.r0, box.g1, box.b1)]) + iArr[getIndex(box.r0, box.g1, box.b0)]) + iArr[getIndex(box.r0, box.g0, box.b1)]) - iArr[getIndex(box.r0, box.g0, box.b0)];
    }

    public static List listOf(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        listSingletonList.getClass();
        return listSingletonList;
    }

    /* JADX INFO: renamed from: parse, reason: collision with other method in class */
    public static StatusLine m1870parse(String str) throws ProtocolException {
        int i;
        String strSubstring;
        boolean zStartsWith = StringsKt__StringsJVMKt.startsWith(str, "HTTP/1.", false);
        Protocol protocol = Protocol.HTTP_1_0;
        Protocol protocol2 = Protocol.HTTP_1_1;
        if (zStartsWith) {
            i = 9;
            if (str.length() >= 9 && str.charAt(8) == ' ') {
                int iCharAt = str.charAt(7) - '0';
                if (iCharAt != 0) {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(str));
                    }
                    protocol = protocol2;
                }
            } else {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
        } else if (StringsKt__StringsJVMKt.startsWith(str, "ICY ", false)) {
            i = 4;
        } else {
            if (!StringsKt__StringsJVMKt.startsWith(str, "SOURCETABLE ", false)) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i = 12;
            protocol = protocol2;
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            Integer intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, str.substring(i, i2));
            if (intOrNull != null) {
                int iIntValue = intOrNull.intValue();
                if (str.length() > i2) {
                    if (str.charAt(i2) == ' ') {
                        strSubstring = str.substring(i + 4);
                    } else {
                        throw new ProtocolException("Unexpected status line: ".concat(str));
                    }
                } else {
                    strSubstring = "";
                }
                return new StatusLine(protocol, iIntValue, strSubstring);
            }
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        throw new ProtocolException("Unexpected status line: ".concat(str));
    }
}
