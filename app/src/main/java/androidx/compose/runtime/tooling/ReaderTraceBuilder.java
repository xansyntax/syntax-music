package androidx.compose.runtime.tooling;

import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.GapGroupSourceInformation;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.media3.extractor.flv.TagPayloadReader;
import coil3.util.FileSystemsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ReaderTraceBuilder extends TagPayloadReader {
    public final /* synthetic */ byte $r8$classId;
    public final Object reader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReaderTraceBuilder(byte b, Object obj) {
        super((byte) 4);
        this.$r8$classId = b;
        this.reader = obj;
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final int groupKeyOf(GapAnchor gapAnchor) {
        byte b = this.$r8$classId;
        Object obj = this.reader;
        switch (b) {
            case 0:
                SlotReader slotReader = (SlotReader) obj;
                return slotReader.groupKey(slotReader.table.anchorIndex(FileSystemsKt.asGapAnchor(gapAnchor)));
            default:
                SlotWriter slotWriter = (SlotWriter) obj;
                return slotWriter.groupKey(slotWriter.anchorIndex(FileSystemsKt.asGapAnchor(gapAnchor)));
        }
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public final GapGroupSourceInformation sourceInformationOf(GapAnchor gapAnchor) {
        byte b = this.$r8$classId;
        Object obj = this.reader;
        switch (b) {
            case 0:
                SlotTable slotTable = ((SlotReader) obj).table;
                slotTable.sourceInformationOf(slotTable.anchorIndex(FileSystemsKt.asGapAnchor(gapAnchor)));
                break;
            default:
                SlotWriter slotWriter = (SlotWriter) obj;
                slotWriter.sourceInformationOf$runtime(slotWriter.anchorIndex(FileSystemsKt.asGapAnchor(gapAnchor)));
                break;
        }
        return null;
    }
}
