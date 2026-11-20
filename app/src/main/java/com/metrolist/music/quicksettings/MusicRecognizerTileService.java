package com.metrolist.music.quicksettings;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.metrolist.music.recognition.RecognitionLaunchActivity;
import com.yalantis.ucrop.R;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicRecognizerTileService extends TileService {
    @Override // android.service.quicksettings.TileService
    public final void onClick() {
        super.onClick();
        Intent intent = new Intent(this, (Class<?>) RecognitionLaunchActivity.class);
        intent.setFlags(268500992);
        if (Build.VERSION.SDK_INT >= 34) {
            startActivityAndCollapse(PendingIntent.getActivity(this, 0, intent, 201326592));
        } else {
            startActivityAndCollapse(intent);
        }
    }

    @Override // android.service.quicksettings.TileService
    public final void onStartListening() {
        super.onStartListening();
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            qsTile.setIcon(Icon.createWithResource(this, R.drawable.mic));
            qsTile.setState(1);
            qsTile.updateTile();
        }
    }
}
