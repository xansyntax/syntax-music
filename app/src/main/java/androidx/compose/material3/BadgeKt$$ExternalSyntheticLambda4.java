package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BadgeKt$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Placeable f$0;

    public /* synthetic */ BadgeKt$$ExternalSyntheticLambda4(Placeable placeable, byte b) {
        this.$r8$classId = b;
        this.f$0 = placeable;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Placeable placeable = this.f$0;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 1:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 2:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 3:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 4:
                Placeable.PlacementScope.placeWithLayer$default((Placeable.PlacementScope) obj, this.f$0, 0, 0, null, 12);
                break;
            case 5:
                Placeable.PlacementScope.placeRelative$default((Placeable.PlacementScope) obj, placeable, 0, 0);
                break;
            case 6:
                Placeable.PlacementScope.placeRelative$default((Placeable.PlacementScope) obj, placeable, 0, 0);
                break;
            case 7:
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                if (placementScope.getParentLayoutDirection() == LayoutDirection.Ltr || placementScope.getParentWidth() == 0) {
                    placementScope.handleMotionFrameOfReferencePlacement(placeable);
                    placeable.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(0L, placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, (Function1) null);
                } else {
                    long parentWidth = ((long) (placementScope.getParentWidth() - placeable.width)) << 32;
                    placementScope.handleMotionFrameOfReferencePlacement(placeable);
                    placeable.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(parentWidth, placeable.apparentToRealOffset), CropImageView.DEFAULT_ASPECT_RATIO, (Function1) null);
                }
                break;
            case 8:
                Placeable.PlacementScope.placeRelative$default((Placeable.PlacementScope) obj, placeable, 0, 0);
                break;
            case 9:
                Placeable.PlacementScope.placeRelative$default((Placeable.PlacementScope) obj, placeable, 0, 0);
                break;
            case 10:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 11:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                Placeable.PlacementScope.placeRelative$default((Placeable.PlacementScope) obj, placeable, 0, 0);
                break;
            case 13:
                Placeable.PlacementScope.placeRelative$default((Placeable.PlacementScope) obj, placeable, 0, 0);
                break;
            case 14:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 15:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 16:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 17:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 18:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 19:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 20:
                Placeable.PlacementScope.placeRelative$default((Placeable.PlacementScope) obj, placeable, 0, 0);
                break;
            case 21:
                Placeable.PlacementScope.placeRelativeWithLayer$default((Placeable.PlacementScope) obj, this.f$0, 0, 0, null, 12);
                break;
            case 22:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 23:
                ((Placeable.PlacementScope) obj).place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
            case 24:
                Placeable.PlacementScope.placeRelative$default((Placeable.PlacementScope) obj, placeable, 0, 0);
                break;
            default:
                Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                placementScope2.getClass();
                placementScope2.place(placeable, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                break;
        }
        return unit;
    }
}
