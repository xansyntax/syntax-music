package okhttp3;

import androidx.compose.foundation.pager.DefaultPagerState;
import androidx.compose.material3.carousel.CarouselState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.text.input.TextFieldValue;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.File;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Handshake$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ Handshake$$ExternalSyntheticLambda0(Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.f$0;
        switch (b) {
            case 0:
                try {
                    return (List) function0.invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return EmptyList.INSTANCE;
                }
            case 1:
                return new DefaultPagerState(0, CropImageView.DEFAULT_ASPECT_RATIO, function0);
            case 2:
                function0.invoke();
                return Boolean.TRUE;
            case 3:
                float fFloatValue = ((Number) function0.invoke()).floatValue();
                if (fFloatValue >= CropImageView.DEFAULT_ASPECT_RATIO) {
                    f = fFloatValue;
                }
                return Float.valueOf(f <= 1.0f ? f : 1.0f);
            case 4:
                float fFloatValue2 = ((Number) function0.invoke()).floatValue();
                if (fFloatValue2 >= CropImageView.DEFAULT_ASPECT_RATIO) {
                    f = fFloatValue2;
                }
                return Float.valueOf(f <= 1.0f ? f : 1.0f);
            case 5:
                function0.invoke();
                return Boolean.TRUE;
            case 6:
                return new CarouselState(0, CropImageView.DEFAULT_ASPECT_RATIO, function0);
            case 7:
                File file = (File) function0.invoke();
                file.getClass();
                String name = file.getName();
                name.getClass();
                if (!StringsKt.substringAfterLast('.', name, "").equals("preferences_pb")) {
                    PathKt$$ExternalSyntheticBUOutline0.m("File extension for file: ", file, " does not match required extension for Preferences file: preferences_pb");
                    return null;
                }
                File absoluteFile = file.getAbsoluteFile();
                absoluteFile.getClass();
                return absoluteFile;
            case 8:
                function0.invoke();
                return unit;
            case 9:
                function0.invoke();
                return unit;
            case 10:
                function0.invoke();
                return unit;
            case 11:
                function0.invoke();
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                function0.invoke();
                return unit;
            case 13:
                if (function0 != null) {
                    function0.invoke();
                }
                return unit;
            case 14:
                return Stack.mutableStateOf$default(new TextFieldValue(6, 0L, ((MediaMetadata) function0.invoke()).title));
            case 15:
                return Stack.mutableStateOf$default(new TextFieldValue(6, 0L, CollectionsKt.joinToString$default(((MediaMetadata) function0.invoke()).artists, null, null, null, new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 28), 31)));
            case 16:
                SongEntity songEntity = (SongEntity) function0.invoke();
                return new ParcelableSnapshotMutableIntState(songEntity != null ? songEntity.lyricsOffset : 0);
            case 17:
                function0.invoke();
                return unit;
            default:
                function0.invoke();
                return unit;
        }
    }
}
