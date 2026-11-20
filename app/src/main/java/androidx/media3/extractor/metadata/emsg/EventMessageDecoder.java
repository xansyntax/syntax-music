package androidx.media3.extractor.metadata.emsg;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTable;
import androidx.sqlite.SQLite;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EventMessageDecoder extends SQLite {
    public final /* synthetic */ byte $r8$classId;

    @Override // androidx.sqlite.SQLite
    public final Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        switch (this.$r8$classId) {
            case 0:
                ParsableByteArray parsableByteArray = new ParsableByteArray(byteBuffer.array(), byteBuffer.limit());
                String nullTerminatedString = parsableByteArray.readNullTerminatedString();
                nullTerminatedString.getClass();
                String nullTerminatedString2 = parsableByteArray.readNullTerminatedString();
                nullTerminatedString2.getClass();
                return new Metadata(new EventMessage(nullTerminatedString, nullTerminatedString2, parsableByteArray.readLong(), parsableByteArray.readLong(), Arrays.copyOfRange(parsableByteArray.data, parsableByteArray.position, parsableByteArray.limit)));
            default:
                if (byteBuffer.get() != 116) {
                    return null;
                }
                VorbisBitArray vorbisBitArray = new VorbisBitArray(byteBuffer.array(), byteBuffer.limit());
                vorbisBitArray.skipBits(12);
                int bytePosition = (vorbisBitArray.getBytePosition() + vorbisBitArray.readBits(12)) - 4;
                vorbisBitArray.skipBits(44);
                vorbisBitArray.skipBytes(vorbisBitArray.readBits(12));
                vorbisBitArray.skipBits(16);
                ArrayList arrayList = new ArrayList();
                while (vorbisBitArray.getBytePosition() < bytePosition) {
                    vorbisBitArray.skipBits(48);
                    int bits = vorbisBitArray.readBits(8);
                    vorbisBitArray.skipBits(4);
                    int bytePosition2 = vorbisBitArray.getBytePosition() + vorbisBitArray.readBits(12);
                    String str = null;
                    String str2 = null;
                    while (vorbisBitArray.getBytePosition() < bytePosition2) {
                        int bits2 = vorbisBitArray.readBits(8);
                        int bits3 = vorbisBitArray.readBits(8);
                        int bytePosition3 = vorbisBitArray.getBytePosition() + bits3;
                        if (bits2 == 2) {
                            int bits4 = vorbisBitArray.readBits(16);
                            vorbisBitArray.skipBits(8);
                            if (bits4 == 3) {
                                while (vorbisBitArray.getBytePosition() < bytePosition3) {
                                    int bits5 = vorbisBitArray.readBits(8);
                                    Charset charset = StandardCharsets.US_ASCII;
                                    byte[] bArr = new byte[bits5];
                                    vorbisBitArray.readBytes(bArr, bits5);
                                    String str3 = new String(bArr, charset);
                                    int bits6 = vorbisBitArray.readBits(8);
                                    for (int i = 0; i < bits6; i++) {
                                        vorbisBitArray.skipBytes(vorbisBitArray.readBits(8));
                                    }
                                    str = str3;
                                }
                            }
                        } else if (bits2 == 21) {
                            Charset charset2 = StandardCharsets.US_ASCII;
                            byte[] bArr2 = new byte[bits3];
                            vorbisBitArray.readBytes(bArr2, bits3);
                            str2 = new String(bArr2, charset2);
                        }
                        vorbisBitArray.setPosition(bytePosition3 * 8);
                    }
                    vorbisBitArray.setPosition(bytePosition2 * 8);
                    if (str != null && str2 != null) {
                        arrayList.add(new AppInfoTable(bits, str.concat(str2)));
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new Metadata(arrayList);
        }
    }
}
