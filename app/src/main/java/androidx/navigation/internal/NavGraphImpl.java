package androidx.navigation.internal;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.collection.ArraySetKt;
import androidx.collection.SparseArrayCompat;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.VorbisUtil$Mode;
import androidx.media3.extractor.VorbisUtil$VorbisIdHeader;
import androidx.media3.extractor.ts.Ac3Reader;
import androidx.media3.extractor.ts.AdtsReader;
import androidx.media3.extractor.ts.DtsReader;
import androidx.media3.extractor.ts.H262Reader;
import androidx.media3.extractor.ts.H263Reader;
import androidx.media3.extractor.ts.H264Reader;
import androidx.media3.extractor.ts.H265Reader;
import androidx.media3.extractor.ts.Id3Reader;
import androidx.media3.extractor.ts.LatmReader;
import androidx.media3.extractor.ts.MpegAudioReader;
import androidx.media3.extractor.ts.MpeghReader;
import androidx.media3.extractor.ts.PesReader;
import androidx.media3.extractor.ts.SectionPayloadReader;
import androidx.media3.extractor.ts.SectionReader;
import androidx.media3.extractor.ts.SeiReader;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.media3.extractor.ts.TsPayloadReader;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.UIntArray;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Dispatcher$promoteAndExecute$Effects;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavGraphImpl implements SectionPayloadReader {
    public final Object graph;
    public final Object nodes;
    public int startDestId;
    public Object startDestIdName;
    public Object startDestinationRoute;

    public NavGraphImpl(TsExtractor tsExtractor, int i) {
        this.startDestinationRoute = tsExtractor;
        this.graph = new VorbisBitArray(new byte[5], 5);
        this.nodes = new SparseArray();
        this.startDestIdName = new SparseIntArray();
        this.startDestId = i;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x021a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0272  */
    /* JADX WARN: Code duplicated, block: B:116:0x0300  */
    /* JADX WARN: Code duplicated, block: B:26:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:99:0x0208  */
    @Override // androidx.media3.extractor.ts.SectionPayloadReader
    public void consume(ParsableByteArray parsableByteArray) {
        SparseArray sparseArray;
        VorbisBitArray vorbisBitArray;
        int i;
        TsPayloadReader pesReader;
        TsPayloadReader pesReader2;
        int i2;
        SparseArray sparseArray2;
        SparseArray sparseArray3 = (SparseArray) this.nodes;
        SparseIntArray sparseIntArray = (SparseIntArray) this.startDestIdName;
        VorbisBitArray vorbisBitArray2 = (VorbisBitArray) this.graph;
        TsExtractor tsExtractor = (TsExtractor) this.startDestinationRoute;
        SparseArray sparseArray4 = tsExtractor.tsPayloadReaders;
        SparseBooleanArray sparseBooleanArray = tsExtractor.trackIds;
        if (parsableByteArray.readUnsignedByte() != 2) {
            return;
        }
        int i3 = 0;
        TimestampAdjuster timestampAdjuster = (TimestampAdjuster) tsExtractor.timestampAdjusters.get(0);
        if ((parsableByteArray.readUnsignedByte() & 128) == 0) {
            return;
        }
        parsableByteArray.skipBytes(1);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int i4 = 3;
        parsableByteArray.skipBytes(3);
        parsableByteArray.readBytes(vorbisBitArray2.data, 0, 2);
        vorbisBitArray2.setPosition(0);
        vorbisBitArray2.skipBits(3);
        int i5 = 13;
        tsExtractor.pcrPid = vorbisBitArray2.readBits(13);
        parsableByteArray.readBytes(vorbisBitArray2.data, 0, 2);
        vorbisBitArray2.setPosition(0);
        vorbisBitArray2.skipBits(4);
        parsableByteArray.skipBytes(vorbisBitArray2.readBits(12));
        sparseArray3.clear();
        sparseIntArray.clear();
        int iBytesLeft = parsableByteArray.bytesLeft();
        while (iBytesLeft > 0) {
            parsableByteArray.readBytes(vorbisBitArray2.data, i3, 5);
            vorbisBitArray2.setPosition(i3);
            int bits = vorbisBitArray2.readBits(8);
            vorbisBitArray2.skipBits(i4);
            int bits2 = vorbisBitArray2.readBits(i5);
            vorbisBitArray2.skipBits(4);
            int bits3 = vorbisBitArray2.readBits(12);
            int i6 = parsableByteArray.position;
            int i7 = i6 + bits3;
            String strTrim = null;
            ArrayList arrayList = null;
            int i8 = -1;
            int unsignedByte = 0;
            while (true) {
                vorbisBitArray = vorbisBitArray2;
                if (parsableByteArray.position < i7) {
                    int unsignedByte2 = parsableByteArray.readUnsignedByte();
                    int unsignedByte3 = parsableByteArray.position + parsableByteArray.readUnsignedByte();
                    if (unsignedByte3 <= i7) {
                        int i9 = iBytesLeft;
                        if (unsignedByte2 == 5) {
                            long unsignedInt = parsableByteArray.readUnsignedInt();
                            if (unsignedInt == 1094921523) {
                                i8 = 129;
                            } else if (unsignedInt == 1161904947) {
                                i8 = 135;
                            } else if (unsignedInt == 1094921524) {
                                i8 = 172;
                            } else if (unsignedInt == 1212503619) {
                                i8 = 36;
                            }
                            i2 = unsignedByte3;
                            sparseArray2 = sparseArray4;
                        } else if (unsignedByte2 == 106) {
                            i2 = unsignedByte3;
                            sparseArray2 = sparseArray4;
                            i8 = 129;
                        } else if (unsignedByte2 == 122) {
                            sparseArray2 = sparseArray4;
                            i8 = 135;
                            i2 = unsignedByte3;
                        } else if (unsignedByte2 == 127) {
                            int unsignedByte4 = parsableByteArray.readUnsignedByte();
                            if (unsignedByte4 == 21) {
                                i8 = 172;
                            } else if (unsignedByte4 == 14) {
                                i8 = 136;
                            } else if (unsignedByte4 == 33) {
                                i8 = 139;
                            }
                            i2 = unsignedByte3;
                            sparseArray2 = sparseArray4;
                        } else if (unsignedByte2 == 123) {
                            i2 = unsignedByte3;
                            sparseArray2 = sparseArray4;
                            i8 = 138;
                        } else if (unsignedByte2 == 10) {
                            strTrim = parsableByteArray.readString(3, StandardCharsets.UTF_8).trim();
                            i2 = unsignedByte3;
                            sparseArray2 = sparseArray4;
                            unsignedByte = parsableByteArray.readUnsignedByte();
                        } else {
                            int i10 = 3;
                            if (unsignedByte2 == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (parsableByteArray.position < unsignedByte3) {
                                    String strTrim2 = parsableByteArray.readString(i10, StandardCharsets.UTF_8).trim();
                                    parsableByteArray.readUnsignedByte();
                                    int i11 = unsignedByte3;
                                    byte[] bArr = new byte[4];
                                    parsableByteArray.readBytes(bArr, 0, 4);
                                    arrayList2.add(new TsPayloadReader.DvbSubtitleInfo(strTrim2, bArr));
                                    unsignedByte3 = i11;
                                    sparseArray4 = sparseArray4;
                                    i10 = 3;
                                }
                                i2 = unsignedByte3;
                                sparseArray2 = sparseArray4;
                                arrayList = arrayList2;
                                i8 = 89;
                            } else {
                                i2 = unsignedByte3;
                                sparseArray2 = sparseArray4;
                                if (unsignedByte2 == 111) {
                                    i8 = 257;
                                }
                            }
                        }
                        parsableByteArray.skipBytes(i2 - parsableByteArray.position);
                        vorbisBitArray2 = vorbisBitArray;
                        iBytesLeft = i9;
                        sparseArray4 = sparseArray2;
                    }
                }
            }
            SparseArray sparseArray5 = sparseArray4;
            int i12 = iBytesLeft;
            parsableByteArray.setPosition(i7);
            StatusLine statusLine = new StatusLine(i8, strTrim, unsignedByte, arrayList, Arrays.copyOfRange(parsableByteArray.data, i6, i7));
            String str = strTrim;
            if (bits == 6 || bits == 5) {
                bits = i8;
            }
            iBytesLeft = i12 - (bits3 + 5);
            if (sparseBooleanArray.get(bits2)) {
                i = 3;
            } else {
                Dispatcher$promoteAndExecute$Effects dispatcher$promoteAndExecute$Effects = tsExtractor.payloadReaderFactory;
                i = 3;
                if (bits == 2) {
                    pesReader = new PesReader(new H262Reader(new SeiReader(dispatcher$promoteAndExecute$Effects.getClosedCaptionFormats(statusLine), (byte) 1), "video/mp2t"));
                } else {
                    if (bits == 3 || bits == 4) {
                        pesReader2 = new PesReader(new MpegAudioReader(str, statusLine.getRoleFlags(), "video/mp2t"));
                    } else if (bits == 21) {
                        pesReader = new PesReader(new Id3Reader());
                    } else if (bits == 27) {
                        pesReader = new PesReader(new H264Reader(new SeiReader(dispatcher$promoteAndExecute$Effects.getClosedCaptionFormats(statusLine), (byte) 0), false, false));
                    } else if (bits == 36) {
                        pesReader = new PesReader(new H265Reader(new SeiReader(dispatcher$promoteAndExecute$Effects.getClosedCaptionFormats(statusLine), (byte) 0)));
                    } else if (bits == 45) {
                        pesReader = new PesReader(new MpeghReader());
                    } else if (bits == 89) {
                        pesReader = new PesReader(new Id3Reader((List) statusLine.protocol));
                    } else if (bits == 172) {
                        pesReader2 = new PesReader(new Ac3Reader(str, statusLine.getRoleFlags(), "video/mp2t", (byte) 1));
                    } else if (bits == 257) {
                        pesReader = new SectionReader(new EmojiProcessor("application/vnd.dvb.ait"));
                    } else if (bits == 138) {
                        pesReader2 = new PesReader(new DtsReader(str, statusLine.getRoleFlags(), 4096));
                    } else if (bits != 139) {
                        switch (bits) {
                            case 15:
                                pesReader2 = new PesReader(new AdtsReader(statusLine.getRoleFlags(), str, "video/mp2t", false));
                                break;
                            case 16:
                                pesReader = new PesReader(new H263Reader(new SeiReader(dispatcher$promoteAndExecute$Effects.getClosedCaptionFormats(statusLine), (byte) 1)));
                                break;
                            case 17:
                                pesReader2 = new PesReader(new LatmReader(str, statusLine.getRoleFlags()));
                                break;
                            default:
                                switch (bits) {
                                    case 128:
                                        pesReader = new PesReader(new H262Reader(new SeiReader(dispatcher$promoteAndExecute$Effects.getClosedCaptionFormats(statusLine), (byte) 1), "video/mp2t"));
                                        break;
                                    case 129:
                                        pesReader2 = new PesReader(new Ac3Reader(str, statusLine.getRoleFlags(), "video/mp2t", (byte) 0));
                                        break;
                                    case 130:
                                        pesReader = null;
                                        break;
                                    default:
                                        switch (bits) {
                                            case 134:
                                                pesReader = new SectionReader(new EmojiProcessor("application/x-scte35"));
                                                break;
                                            case 135:
                                                pesReader2 = new PesReader(new Ac3Reader(str, statusLine.getRoleFlags(), "video/mp2t", (byte) 0));
                                                break;
                                            case 136:
                                                pesReader2 = new PesReader(new DtsReader(str, statusLine.getRoleFlags(), 4096));
                                                break;
                                            default:
                                                pesReader = null;
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                    } else {
                        pesReader2 = new PesReader(new DtsReader(str, statusLine.getRoleFlags(), 5408));
                    }
                    pesReader = pesReader2;
                }
                sparseIntArray.put(bits2, bits2);
                sparseArray3.put(bits2, pesReader);
            }
            i4 = i;
            vorbisBitArray2 = vorbisBitArray;
            sparseArray4 = sparseArray5;
            i3 = 0;
            i5 = 13;
        }
        SparseArray sparseArray6 = sparseArray4;
        int size = sparseIntArray.size();
        int i13 = 0;
        while (i13 < size) {
            int iKeyAt = sparseIntArray.keyAt(i13);
            int iValueAt = sparseIntArray.valueAt(i13);
            sparseBooleanArray.put(iKeyAt, true);
            tsExtractor.trackPids.put(iValueAt, true);
            TsPayloadReader tsPayloadReader = (TsPayloadReader) sparseArray3.valueAt(i13);
            if (tsPayloadReader != null) {
                tsPayloadReader.init(timestampAdjuster, tsExtractor.output, new TsPayloadReader.TrackIdGenerator(unsignedShort, iKeyAt, 8192));
                sparseArray = sparseArray6;
                sparseArray.put(iValueAt, tsPayloadReader);
            } else {
                sparseArray = sparseArray6;
            }
            i13++;
            sparseArray6 = sparseArray;
        }
        sparseArray6.remove(this.startDestId);
        tsExtractor.remainingPmts = 0;
        tsExtractor.output.endTracks();
        tsExtractor.tracksEnded = true;
    }

    public NavDestination findNode$navigation_common_release(String str, boolean z) {
        Object next;
        NavGraph navGraph;
        NavDestination navDestination;
        str.getClass();
        Iterator it = ((ConstrainedOnceSequence) SequencesKt.asSequence(new UIntArray.Iterator((byte) 1, (SparseArrayCompat) this.nodes))).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            navDestination = (NavDestination) next;
            if (StringsKt__StringsJVMKt.equals((String) navDestination.impl.layoutNodes, str, false)) {
                break;
            }
        } while (navDestination.impl.matchRoute$navigation_common_release(str) == null);
        NavDestination navDestination2 = (NavDestination) next;
        if (navDestination2 != null) {
            return navDestination2;
        }
        if (!z || (navGraph = ((NavGraph) this.graph).parent) == null) {
            return null;
        }
        NavGraphImpl navGraphImpl = navGraph.impl;
        navGraphImpl.getClass();
        if (StringsKt.isBlank(str)) {
            return null;
        }
        return navGraphImpl.findNode$navigation_common_release(str, true);
    }

    public NavDestination findNodeComprehensive$navigation_common_release(int i, NavDestination navDestination, NavDestination navDestination2, boolean z) {
        NavGraph navGraph = (NavGraph) this.graph;
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.nodes;
        NavDestination navDestinationFindNodeComprehensive$navigation_common_release = (NavDestination) ArraySetKt.commonGet(sparseArrayCompat, i);
        if (navDestination2 != null) {
            if (Intrinsics.areEqual(navDestinationFindNodeComprehensive$navigation_common_release, navDestination2) && Intrinsics.areEqual(navDestinationFindNodeComprehensive$navigation_common_release.parent, navDestination2.parent)) {
                return navDestinationFindNodeComprehensive$navigation_common_release;
            }
            navDestinationFindNodeComprehensive$navigation_common_release = null;
        } else if (navDestinationFindNodeComprehensive$navigation_common_release != null) {
            return navDestinationFindNodeComprehensive$navigation_common_release;
        }
        if (z) {
            Iterator it = ((ConstrainedOnceSequence) SequencesKt.asSequence(new UIntArray.Iterator((byte) 1, sparseArrayCompat))).iterator();
            do {
                if (!it.hasNext()) {
                    navDestinationFindNodeComprehensive$navigation_common_release = null;
                    break;
                }
                NavDestination navDestination3 = (NavDestination) it.next();
                navDestinationFindNodeComprehensive$navigation_common_release = (!(navDestination3 instanceof NavGraph) || navDestination3.equals(navDestination)) ? null : ((NavGraph) navDestination3).impl.findNodeComprehensive$navigation_common_release(i, navGraph, navDestination2, true);
            } while (navDestinationFindNodeComprehensive$navigation_common_release == null);
        }
        if (navDestinationFindNodeComprehensive$navigation_common_release != null) {
            return navDestinationFindNodeComprehensive$navigation_common_release;
        }
        NavGraph navGraph2 = navGraph.parent;
        if (navGraph2 == null || navGraph2.equals(navDestination)) {
            return null;
        }
        NavGraph navGraph3 = navGraph.parent;
        navGraph3.getClass();
        return navGraph3.impl.findNodeComprehensive$navigation_common_release(i, navGraph, navDestination2, z);
    }

    public NavDestination.DeepLinkMatch matchDeepLinkComprehensive$navigation_common_release(NavDestination.DeepLinkMatch deepLinkMatch, NavDeepLinkRequest navDeepLinkRequest, boolean z, NavDestination navDestination) {
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive;
        NavGraph navGraph = (NavGraph) this.graph;
        ArrayList arrayList = new ArrayList();
        Iterator it = navGraph.iterator();
        while (true) {
            NavGraphImpl$iterator$1 navGraphImpl$iterator$1 = (NavGraphImpl$iterator$1) it;
            deepLinkMatchMatchDeepLinkComprehensive = null;
            if (!navGraphImpl$iterator$1.hasNext()) {
                break;
            }
            NavDestination navDestination2 = (NavDestination) navGraphImpl$iterator$1.next();
            deepLinkMatchMatchDeepLinkComprehensive = Intrinsics.areEqual(navDestination2, navDestination) ? null : navDestination2.matchDeepLink(navDeepLinkRequest);
            if (deepLinkMatchMatchDeepLinkComprehensive != null) {
                arrayList.add(deepLinkMatchMatchDeepLinkComprehensive);
            }
        }
        NavDestination.DeepLinkMatch deepLinkMatch2 = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(arrayList);
        NavGraph navGraph2 = navGraph.parent;
        if (navGraph2 != null && z && !navGraph2.equals(navDestination)) {
            deepLinkMatchMatchDeepLinkComprehensive = navGraph2.matchDeepLinkComprehensive(navDeepLinkRequest, navGraph);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(ArraysKt.filterNotNull(new NavDestination.DeepLinkMatch[]{deepLinkMatch, deepLinkMatch2, deepLinkMatchMatchDeepLinkComprehensive}));
    }

    public NavGraphImpl(VorbisUtil$VorbisIdHeader vorbisUtil$VorbisIdHeader, androidx.datastore.core.AtomicInt atomicInt, byte[] bArr, VorbisUtil$Mode[] vorbisUtil$ModeArr, int i) {
        this.graph = vorbisUtil$VorbisIdHeader;
        this.nodes = atomicInt;
        this.startDestIdName = bArr;
        this.startDestinationRoute = vorbisUtil$ModeArr;
        this.startDestId = i;
    }

    public NavGraphImpl(NavGraph navGraph) {
        this.graph = navGraph;
        this.nodes = new SparseArrayCompat(0);
    }

    @Override // androidx.media3.extractor.ts.SectionPayloadReader
    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
    }

    public NavDestination findNode$navigation_common_release(int i) {
        return findNodeComprehensive$navigation_common_release(i, (NavGraph) this.graph, null, false);
    }
}
