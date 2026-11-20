package okhttp3.internal.publicsuffix;

import com.materialkolor.quantize.QuantizerWu;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.io.LinesSequence;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class PublicSuffixDatabase {
    public static final List PREVAILING_RULE;
    public static final ByteString WILDCARD_LABEL;
    public static final PublicSuffixDatabase instance;
    public final QuantizerWu publicSuffixList;

    static {
        ByteString byteString = ByteString.EMPTY;
        WILDCARD_LABEL = new ByteString(Arrays.copyOf(new byte[]{42}, 1));
        PREVAILING_RULE = CollectionsKt__IterablesKt.listOf("*");
        instance = new PublicSuffixDatabase(new QuantizerWu((byte) 6));
    }

    public PublicSuffixDatabase(QuantizerWu quantizerWu) {
        this.publicSuffixList = quantizerWu;
    }

    public static List splitDomain(String str) {
        List listSplit$default = StringsKt.split$default(str, new char[]{'.'});
        return Intrinsics.areEqual(CollectionsKt.last(listSplit$default), "") ? CollectionsKt.dropLast(1, listSplit$default) : listSplit$default;
    }

    public final String getEffectiveTldPlusOne(String str) {
        String strBinarySearch;
        String strBinarySearch2;
        String strBinarySearch3;
        List listSplit$default;
        int size;
        int size2;
        String unicode = IDN.toUnicode(str);
        unicode.getClass();
        List listSplitDomain = splitDomain(unicode);
        QuantizerWu quantizerWu = this.publicSuffixList;
        AtomicBoolean atomicBoolean = (AtomicBoolean) quantizerWu.weights;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            try {
                ((CountDownLatch) quantizerWu.momentsR).await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z = false;
            while (true) {
                try {
                    try {
                        quantizerWu.readTheList();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z = true;
                    } catch (IOException e) {
                        quantizerWu.moments = e;
                        if (z) {
                        }
                    }
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
        if (((ByteString) quantizerWu.momentsG) == null) {
            StringBuilder sb = new StringBuilder("Unable to load ");
            sb.append(quantizerWu.cubes);
            sb.append(" resource.");
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            illegalStateException.initCause((IOException) quantizerWu.moments);
            throw illegalStateException;
        }
        int size3 = listSplitDomain.size();
        ByteString[] byteStringArr = new ByteString[size3];
        for (int i = 0; i < size3; i++) {
            ByteString byteString = ByteString.EMPTY;
            byteStringArr[i] = Path.Companion.encodeUtf8((String) listSplitDomain.get(i));
        }
        int i2 = 0;
        while (true) {
            if (i2 >= size3) {
                strBinarySearch = null;
                break;
            }
            ByteString byteString2 = (ByteString) quantizerWu.momentsG;
            if (byteString2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bytes");
                throw null;
            }
            strBinarySearch = UuidKt.binarySearch(byteString2, byteStringArr, i2);
            if (strBinarySearch != null) {
                break;
            }
            i2++;
        }
        if (size3 <= 1) {
            strBinarySearch2 = null;
            break;
        }
        ByteString[] byteStringArr2 = (ByteString[]) byteStringArr.clone();
        int length = byteStringArr2.length - 1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                strBinarySearch2 = null;
                break;
            }
            byteStringArr2[i3] = WILDCARD_LABEL;
            ByteString byteString3 = (ByteString) quantizerWu.momentsG;
            if (byteString3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bytes");
                throw null;
            }
            strBinarySearch2 = UuidKt.binarySearch(byteString3, byteStringArr2, i3);
            if (strBinarySearch2 != null) {
                break;
            }
            i3++;
        }
        if (strBinarySearch2 == null) {
            strBinarySearch3 = null;
            break;
        }
        int i4 = size3 - 1;
        int i5 = 0;
        while (true) {
            if (i5 >= i4) {
                strBinarySearch3 = null;
                break;
            }
            ByteString byteString4 = (ByteString) quantizerWu.momentsB;
            if (byteString4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("exceptionBytes");
                throw null;
            }
            strBinarySearch3 = UuidKt.binarySearch(byteString4, byteStringArr, i5);
            if (strBinarySearch3 != null) {
                break;
            }
            i5++;
        }
        if (strBinarySearch3 != null) {
            listSplit$default = StringsKt.split$default("!".concat(strBinarySearch3), new char[]{'.'});
        } else if (strBinarySearch == null && strBinarySearch2 == null) {
            listSplit$default = PREVAILING_RULE;
        } else {
            List listSplit$default2 = EmptyList.INSTANCE;
            List listSplit$default3 = strBinarySearch != null ? StringsKt.split$default(strBinarySearch, new char[]{'.'}) : listSplit$default2;
            if (strBinarySearch2 != null) {
                listSplit$default2 = StringsKt.split$default(strBinarySearch2, new char[]{'.'});
            }
            listSplit$default = listSplit$default3.size() > listSplit$default2.size() ? listSplit$default3 : listSplit$default2;
        }
        if (listSplitDomain.size() == listSplit$default.size() && ((String) listSplit$default.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listSplit$default.get(0)).charAt(0) == '!') {
            size = listSplitDomain.size();
            size2 = listSplit$default.size();
        } else {
            size = listSplitDomain.size();
            size2 = listSplit$default.size() + 1;
        }
        return SequencesKt.joinToString$default(SequencesKt.drop(new LinesSequence((byte) 2, splitDomain(str)), size - size2), ".");
    }
}
