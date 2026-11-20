package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.OkHttpClientStore;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.connection.RealCall;
import okio.BufferedSource;
import okio.OutputStreamSink;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapWorkerResult> {
    private static final int MAX_BITMAP_SIZE = 104857600;
    private static final String TAG = "BitmapWorkerTask";
    private final BitmapLoadCallback mBitmapLoadCallback;
    private final WeakReference<Context> mContext;
    private Uri mInputUri;
    private Uri mOutputUri;
    private final int mRequiredHeight;
    private final int mRequiredWidth;

    public BitmapLoadTask(Context context, Uri uri, Uri uri2, int i, int i2, BitmapLoadCallback bitmapLoadCallback) {
        this.mContext = new WeakReference<>(context);
        this.mInputUri = uri;
        this.mOutputUri = uri2;
        this.mRequiredWidth = i;
        this.mRequiredHeight = i2;
        this.mBitmapLoadCallback = bitmapLoadCallback;
    }

    private boolean checkSize(Bitmap bitmap, BitmapFactory.Options options) {
        if ((bitmap != null ? bitmap.getByteCount() : 0) <= MAX_BITMAP_SIZE) {
            return false;
        }
        options.inSampleSize *= 2;
        return true;
    }

    private void copyFile(Uri uri, Uri uri2) throws Throwable {
        InputStream inputStreamOpenInputStream;
        if (uri2 == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("Output Uri is null - cannot copy image");
            return;
        }
        Context context = this.mContext.get();
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                if (inputStreamOpenInputStream == null) {
                    throw new NullPointerException("InputStream for given input Uri is null");
                }
                OutputStream outputStreamOpenOutputStream = isContentUri(uri2) ? context.getContentResolver().openOutputStream(uri2) : new FileOutputStream(new File(uri2.getPath()));
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStreamOpenInputStream.read(bArr);
                    if (i <= 0) {
                        BitmapLoadUtils.close(outputStreamOpenOutputStream);
                        BitmapLoadUtils.close(inputStreamOpenInputStream);
                        this.mInputUri = this.mOutputUri;
                        return;
                    }
                    outputStreamOpenOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                th = th;
                BitmapLoadUtils.close(null);
                BitmapLoadUtils.close(inputStreamOpenInputStream);
                this.mInputUri = this.mOutputUri;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenInputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x009c  */
    private void downloadFile(Uri uri, Uri uri2) throws Throwable {
        Response responseExecute;
        OutputStreamSink outputStreamSink;
        if (uri2 == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("Output Uri is null - cannot download image");
            return;
        }
        Context context = this.mContext.get();
        if (context == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("Context is null");
            return;
        }
        OkHttpClient client = OkHttpClientStore.INSTANCE.getClient();
        BufferedSource bufferedSource = null;
        try {
            Request.Builder builder = new Request.Builder();
            builder.url(uri.toString());
            try {
                Request request = new Request(builder);
                try {
                    client.getClass();
                    responseExecute = new RealCall(client, request, false).execute();
                    try {
                        ResponseBody responseBody = responseExecute.body;
                        BufferedSource bufferedSourceSource = responseBody.source();
                        try {
                            OutputStream outputStreamOpenOutputStream = isContentUri(this.mOutputUri) ? context.getContentResolver().openOutputStream(uri2) : new FileOutputStream(new File(uri2.getPath()));
                            if (outputStreamOpenOutputStream == null) {
                                throw new NullPointerException("OutputStream for given output Uri is null");
                            }
                            outputStreamSink = new OutputStreamSink(outputStreamOpenOutputStream, new Timeout());
                            try {
                                bufferedSourceSource.readAll(outputStreamSink);
                                BitmapLoadUtils.close(bufferedSourceSource);
                                BitmapLoadUtils.close(outputStreamSink);
                                BitmapLoadUtils.close(responseBody);
                                client.dispatcher.cancelAll();
                                this.mInputUri = this.mOutputUri;
                            } catch (Throwable th) {
                                th = th;
                                bufferedSource = bufferedSourceSource;
                                BitmapLoadUtils.close(bufferedSource);
                                BitmapLoadUtils.close(outputStreamSink);
                                if (responseExecute != null) {
                                    BitmapLoadUtils.close(responseExecute.body);
                                }
                                client.dispatcher.cancelAll();
                                this.mInputUri = this.mOutputUri;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            outputStreamSink = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        outputStreamSink = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    th = th;
                    responseExecute = null;
                    outputStreamSink = null;
                    BitmapLoadUtils.close(bufferedSource);
                    BitmapLoadUtils.close(outputStreamSink);
                    if (responseExecute != null) {
                        BitmapLoadUtils.close(responseExecute.body);
                    }
                    client.dispatcher.cancelAll();
                    this.mInputUri = this.mOutputUri;
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private boolean isContentUri(Uri uri) {
        return uri.getScheme().equals("content");
    }

    private boolean isDownloadUri(Uri uri) {
        String scheme = uri.getScheme();
        return scheme.equals("http") || scheme.equals("https");
    }

    private boolean isFileUri(Uri uri) {
        return uri.getScheme().equals("file");
    }

    private void processInputUri() {
        this.mInputUri.getScheme();
        boolean zIsDownloadUri = isDownloadUri(this.mInputUri);
        Uri uri = this.mInputUri;
        if (zIsDownloadUri) {
            try {
                downloadFile(uri, this.mOutputUri);
                return;
            } catch (IOException | NullPointerException e) {
                Log.e(TAG, "Downloading failed", e);
                throw e;
            }
        }
        boolean zIsContentUri = isContentUri(uri);
        Uri uri2 = this.mInputUri;
        if (zIsContentUri) {
            try {
                copyFile(uri2, this.mOutputUri);
                return;
            } catch (IOException | NullPointerException e2) {
                Log.e(TAG, "Copying failed", e2);
                throw e2;
            }
        }
        if (isFileUri(uri2)) {
            return;
        }
        String scheme = this.mInputUri.getScheme();
        Log.e(TAG, "Invalid Uri scheme " + scheme);
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("Invalid Uri scheme", scheme));
    }

    @Override // android.os.AsyncTask
    public BitmapWorkerResult doInBackground(Void... voidArr) {
        Context context = this.mContext.get();
        if (context == null) {
            return new BitmapWorkerResult(new NullPointerException("context is null"));
        }
        if (this.mInputUri == null) {
            return new BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            processInputUri();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, this.mRequiredWidth, this.mRequiredHeight);
            boolean z = false;
            options.inJustDecodeBounds = false;
            Bitmap bitmapDecodeStream = null;
            while (!z) {
                try {
                    InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(this.mInputUri);
                    try {
                        bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                        if (options.outWidth == -1 || options.outHeight == -1) {
                            BitmapWorkerResult bitmapWorkerResult = new BitmapWorkerResult(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.mInputUri + "]"));
                            BitmapLoadUtils.close(inputStreamOpenInputStream);
                            return bitmapWorkerResult;
                        }
                        BitmapLoadUtils.close(inputStreamOpenInputStream);
                        if (!checkSize(bitmapDecodeStream, options)) {
                            z = true;
                        }
                    } catch (Throwable th) {
                        BitmapLoadUtils.close(inputStreamOpenInputStream);
                        throw th;
                    }
                } catch (IOException e) {
                    Log.e(TAG, "doInBackground: ImageDecoder.createSource: ", e);
                    return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.mInputUri + "]", e));
                } catch (OutOfMemoryError e2) {
                    Log.e(TAG, "doInBackground: BitmapFactory.decodeFileDescriptor: ", e2);
                    options.inSampleSize *= 2;
                }
            }
            Uri uri = this.mInputUri;
            if (bitmapDecodeStream == null) {
                return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + uri + "]"));
            }
            int exifOrientation = BitmapLoadUtils.getExifOrientation(context, uri);
            int iExifToDegrees = BitmapLoadUtils.exifToDegrees(exifOrientation);
            int iExifToTranslation = BitmapLoadUtils.exifToTranslation(exifOrientation);
            ExifInfo exifInfo = new ExifInfo(exifOrientation, iExifToDegrees, iExifToTranslation);
            Matrix matrix = new Matrix();
            if (iExifToDegrees != 0) {
                matrix.preRotate(iExifToDegrees);
            }
            if (iExifToTranslation != 1) {
                matrix.postScale(iExifToTranslation, 1.0f);
            }
            return !matrix.isIdentity() ? new BitmapWorkerResult(BitmapLoadUtils.transformBitmap(bitmapDecodeStream, matrix), exifInfo) : new BitmapWorkerResult(bitmapDecodeStream, exifInfo);
        } catch (IOException | NullPointerException e3) {
            return new BitmapWorkerResult(e3);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(BitmapWorkerResult bitmapWorkerResult) {
        Exception exc = bitmapWorkerResult.mBitmapWorkerException;
        BitmapLoadCallback bitmapLoadCallback = this.mBitmapLoadCallback;
        if (exc == null) {
            bitmapLoadCallback.onBitmapLoaded(bitmapWorkerResult.mBitmapResult, bitmapWorkerResult.mExifInfo, this.mInputUri, this.mOutputUri);
        } else {
            bitmapLoadCallback.onFailure(exc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public static class BitmapWorkerResult {
        Bitmap mBitmapResult;
        Exception mBitmapWorkerException;
        ExifInfo mExifInfo;

        public BitmapWorkerResult(Bitmap bitmap, ExifInfo exifInfo) {
            this.mBitmapResult = bitmap;
            this.mExifInfo = exifInfo;
        }

        public BitmapWorkerResult(Exception exc) {
            this.mBitmapWorkerException = exc;
        }
    }
}
