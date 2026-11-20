package androidx.media3.extractor.ogg;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import coil3.util.UtilsKt;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OggPageHeader {
    public int bodySize;
    public long granulePosition;
    public int headerSize;
    public short pageSegmentCount;
    public short type;
    public final int[] laces = new int[255];
    public final ParsableByteArray scratch = new ParsableByteArray(255);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [int, short] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int, short] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean populate(ExtractorInput extractorInput, boolean z) throws ParserException, EOFException {
        boolean zPeekFully;
        boolean zPeekFully2;
        this.type = (short) 0;
        this.granulePosition = 0L;
        this.pageSegmentCount = (short) 0;
        this.headerSize = 0;
        this.bodySize = 0;
        ParsableByteArray parsableByteArray = this.scratch;
        parsableByteArray.reset(27);
        try {
            zPeekFully = extractorInput.peekFully(parsableByteArray.data, 0, 27, z);
        } catch (EOFException e) {
            if (!z) {
                throw e;
            }
            zPeekFully = false;
        }
        if (zPeekFully && parsableByteArray.readUnsignedInt() == 1332176723) {
            if (parsableByteArray.readUnsignedByte() == 0) {
                this.type = parsableByteArray.readUnsignedByte();
                this.granulePosition = parsableByteArray.readLittleEndianLong();
                parsableByteArray.readLittleEndianUnsignedInt();
                parsableByteArray.readLittleEndianUnsignedInt();
                parsableByteArray.readLittleEndianUnsignedInt();
                ?? unsignedByte = parsableByteArray.readUnsignedByte();
                this.pageSegmentCount = unsignedByte;
                this.headerSize = unsignedByte + 27;
                parsableByteArray.reset(unsignedByte);
                try {
                    zPeekFully2 = extractorInput.peekFully(parsableByteArray.data, 0, this.pageSegmentCount, z);
                } catch (EOFException e2) {
                    if (!z) {
                        throw e2;
                    }
                    zPeekFully2 = false;
                }
                if (zPeekFully2) {
                    for (int i = 0; i < this.pageSegmentCount; i++) {
                        int unsignedByte2 = parsableByteArray.readUnsignedByte();
                        this.laces[i] = unsignedByte2;
                        this.bodySize += unsignedByte2;
                    }
                    return true;
                }
            } else if (!z) {
                throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
            }
        }
        return false;
    }

    public final boolean skipToNextPage(ExtractorInput extractorInput, long j) {
        boolean zPeekFully;
        UtilsKt.checkArgument(extractorInput.getPosition() == extractorInput.getPeekPosition());
        ParsableByteArray parsableByteArray = this.scratch;
        parsableByteArray.reset(4);
        while (true) {
            if (j != -1 && extractorInput.getPosition() + 4 >= j) {
                break;
            }
            try {
                zPeekFully = extractorInput.peekFully(parsableByteArray.data, 0, 4, true);
            } catch (EOFException unused) {
                zPeekFully = false;
            }
            if (!zPeekFully) {
                break;
            }
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readUnsignedInt() == 1332176723) {
                extractorInput.resetPeekPosition();
                return true;
            }
            extractorInput.skipFully(1);
        }
        do {
            if (j != -1 && extractorInput.getPosition() >= j) {
                break;
            }
        } while (extractorInput.skip(1) != -1);
        return false;
    }
}
