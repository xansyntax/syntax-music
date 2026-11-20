package kotlin.text;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapKeysIterator;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeKeysIterator;
import io.ktor.websocket.PingPongKt$$ExternalSyntheticLambda0;
import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.io.LinesSequence;
import kotlin.ranges.IntRange;
import kotlin.sequences.TransformingSequence;
import kotlin.sequences.TransformingSequence.AnonymousClass1;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection {
    public final /* synthetic */ byte $r8$classId;
    public final Object this$0;

    public /* synthetic */ MatcherMatchResult$groups$1(byte b, Object obj) {
        this.$r8$classId = b;
        this.this$0 = obj;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                if (obj == null ? true : obj instanceof MatchGroup) {
                    return super.contains((MatchGroup) obj);
                }
                return false;
            default:
                return ((PersistentHashMap) this.this$0).containsValue(obj);
        }
    }

    public MatchGroup get(int i) {
        Matcher matcher = ((MatcherMatchResult) this.this$0).matcher;
        IntRange intRangeUntil = UuidKt.until(matcher.start(i), matcher.end(i));
        if (intRangeUntil.first < 0) {
            return null;
        }
        String strGroup = matcher.group(i);
        strGroup.getClass();
        return new MatchGroup(strGroup, intRangeUntil);
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        byte b = this.$r8$classId;
        Object obj = this.this$0;
        switch (b) {
            case 0:
                return ((MatcherMatchResult) obj).matcher.groupCount() + 1;
            default:
                return ((PersistentHashMap) obj).size;
        }
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.$r8$classId) {
            case 0:
                return false;
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        byte b = 2;
        switch (this.$r8$classId) {
            case 0:
                return new TransformingSequence(new LinesSequence(b, CollectionsKt__IterablesKt.getIndices(this)), new PingPongKt$$ExternalSyntheticLambda0((byte) 7, (Object) this)).new AnonymousClass1();
            default:
                TrieNode trieNode = ((PersistentHashMap) this.this$0).node;
                TrieNodeBaseIterator[] trieNodeBaseIteratorArr = new TrieNodeBaseIterator[8];
                for (int i = 0; i < 8; i++) {
                    trieNodeBaseIteratorArr[i] = new TrieNodeKeysIterator((byte) 2);
                }
                return new PersistentHashMapKeysIterator(trieNode, trieNodeBaseIteratorArr);
        }
    }
}
