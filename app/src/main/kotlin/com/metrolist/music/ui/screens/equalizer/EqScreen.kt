package com.metrolist.music.ui.screens.equalizer

import android.annotation.SuppressLint
import android.provider.OpenableColumns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.metrolist.music.LocalNavController
import com.metrolist.music.LocalPlayerAwareWindowInsets
import com.metrolist.music.R
import com.metrolist.music.eq.audio.DetectedAudioDevice
import com.metrolist.music.eq.audio.OutputDeviceCategory
import com.metrolist.music.eq.data.FilterType
import com.metrolist.music.eq.data.SavedEQProfile
import timber.log.Timber
import java.util.Locale

@SuppressLint("LocalContextGetResourceValueCall")
@Composable
fun EqScreen(
    viewModel: EQViewModel = hiltViewModel(),
) {
    val navController = LocalNavController.current
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    var showError by remember { mutableStateOf<String?>(null) }
    var showAddMenu by remember { mutableStateOf(false) }

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                viewModel.refreshDetectedDevice()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose { lifecycleOwner.lifecycle.removeObserver(observer) }
    }

    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            try {
                val contentResolver = context.contentResolver
                var fileName = "custom_eq.txt"
                contentResolver.query(uri, null, null, null, null)?.use { cursor ->
                    if (cursor.moveToFirst()) {
                        val displayNameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                        if (displayNameIndex >= 0) {
                            val name = cursor.getString(displayNameIndex)
                            if (!name.isNullOrBlank()) {
                                fileName = name
                            }
                        }
                    }
                }

                val inputStream = contentResolver.openInputStream(uri)
                if (inputStream != null) {
                    viewModel.importCustomProfile(
                        fileName = fileName,
                        inputStream = inputStream,
                        onSuccess = {
                            Timber.d("Custom EQ profile imported successfully: $fileName")
                        },
                        onError = { error ->
                            showError = context.getString(R.string.import_error_title) + ": " + error.message
                        }
                    )
                } else {
                    showError = context.getString(R.string.error_file_read)
                }
            } catch (e: Exception) {
                showError = context.getString(R.string.error_file_open, e.message)
            }
        }
    }

    EqScreenContent(
        state = state,
        onToggle10Band = { viewModel.setCustom10BandEnabled(it) },
        onSelectBand = { viewModel.selectBandIndex(it) },
        onBandChanged = { index, gain -> viewModel.updateBandGain(index, gain) },
        onNudgeSelectedGain = { delta -> viewModel.nudgeSelectedBandGain(delta) },
        onSelectedQChanged = { q -> viewModel.updateSelectedBandQ(q) },
        onSelectedTypeChanged = { type -> viewModel.updateSelectedBandType(type) },
        onPreampChanged = { viewModel.updateTenBandPreamp(it) },
        onAutoTuneDevice = { viewModel.applyAutoTuneForCurrentDevice() },
        onResetFlat = { viewModel.resetTenBandFlat() },
        onSaveForDevice = { viewModel.saveCurrent10BandForDevice() },
        onToggleAutoSwitch = { viewModel.toggleAutoSwitchPerDevice(it) },
        onRefreshDevice = { viewModel.refreshDetectedDevice() },
        onProfileSelected = { viewModel.selectProfile(it) },
        onNavigateBack = { navController.navigateUp() },
        showAddMenu = showAddMenu,
        onAddClicked = { showAddMenu = true },
        onAddMenuDismissed = { showAddMenu = false },
        onWizardClicked = {
            showAddMenu = false
            navController.navigate("eq_wizard")
        },
        onImportClicked = {
            showAddMenu = false
            filePickerLauncher.launch("text/plain")
        },
        onDeleteProfile = { viewModel.deleteProfile(it) }
    )

    if (showError != null) {
        AlertDialog(
            onDismissRequest = { showError = null },
            title = { Text(stringResource(R.string.import_error_title)) },
            text = { Text(showError ?: "") },
            confirmButton = {
                TextButton(onClick = { showError = null }) {
                    Text(stringResource(android.R.string.ok))
                }
            }
        )
    }

    if (state.error != null) {
        AlertDialog(
            onDismissRequest = { viewModel.clearError() },
            title = { Text(stringResource(R.string.error_title)) },
            text = { Text(stringResource(R.string.error_eq_apply_failed, state.error ?: "")) },
            confirmButton = {
                TextButton(onClick = { viewModel.clearError() }) {
                    Text(stringResource(android.R.string.ok))
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EqScreenContent(
    state: EQState,
    onToggle10Band: (Boolean) -> Unit,
    onSelectBand: (Int) -> Unit,
    onBandChanged: (Int, Double) -> Unit,
    onNudgeSelectedGain: (Double) -> Unit,
    onSelectedQChanged: (Double) -> Unit,
    onSelectedTypeChanged: (FilterType) -> Unit,
    onPreampChanged: (Double) -> Unit,
    onAutoTuneDevice: () -> Unit,
    onResetFlat: () -> Unit,
    onSaveForDevice: () -> Unit,
    onToggleAutoSwitch: (Boolean) -> Unit,
    onRefreshDevice: () -> Unit,
    onProfileSelected: (String?) -> Unit,
    onNavigateBack: () -> Unit,
    showAddMenu: Boolean,
    onAddClicked: () -> Unit,
    onAddMenuDismissed: () -> Unit,
    onWizardClicked: () -> Unit,
    onImportClicked: () -> Unit,
    onDeleteProfile: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.equalizer_header)) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            painter = painterResource(R.drawable.arrow_back),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    Box {
                        IconButton(onClick = onAddClicked) {
                            Icon(
                                painter = painterResource(R.drawable.add),
                                contentDescription = stringResource(R.string.import_profile)
                            )
                        }
                        DropdownMenu(
                            expanded = showAddMenu,
                            onDismissRequest = onAddMenuDismissed
                        ) {
                            DropdownMenuItem(
                                text = { Text(stringResource(R.string.eq_wizard)) },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(R.drawable.discover_tune),
                                        contentDescription = null
                                    )
                                },
                                onClick = onWizardClicked
                            )
                            DropdownMenuItem(
                                text = { Text(stringResource(R.string.import_from_file)) },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(R.drawable.upload),
                                        contentDescription = null
                                    )
                                },
                                onClick = onImportClicked
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            contentPadding = PaddingValues(
                bottom = LocalPlayerAwareWindowInsets.current
                    .asPaddingValues().calculateBottomPadding() + 24.dp
            )
        ) {
            item {
                EqFrequencyResponseGraph(
                    bands = state.activeBands,
                    preamp = state.activePreamp
                )
            }

            item {
                DetectedDeviceCard(
                    device = state.detectedDevice,
                    autoSwitch = state.autoSwitchPerDevice,
                    onToggleAutoSwitch = onToggleAutoSwitch,
                    onAutoTuneDevice = onAutoTuneDevice,
                    onRefreshDevice = onRefreshDevice
                )
            }

            item {
                TenBandEqualizerCard(
                    enabled = state.isCustom10BandEnabled,
                    gains = state.tenBandGains,
                    qs = state.tenBandQs,
                    types = state.tenBandTypes,
                    selectedBandIndex = state.selectedBandIndex,
                    preamp = state.tenBandPreamp,
                    deviceName = state.detectedDevice.name,
                    onToggleEnabled = onToggle10Band,
                    onSelectBand = onSelectBand,
                    onBandChanged = onBandChanged,
                    onNudgeSelectedGain = onNudgeSelectedGain,
                    onSelectedQChanged = onSelectedQChanged,
                    onSelectedTypeChanged = onSelectedTypeChanged,
                    onPreampChanged = onPreampChanged,
                    onResetFlat = onResetFlat,
                    onSaveForDevice = onSaveForDevice
                )
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Saved & Device Profiles",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp)
                )
            }

            item {
                NoEqualizationItem(
                    isSelected = !state.isCustom10BandEnabled && state.activeProfileId == null,
                    onSelected = { onProfileSelected(null) }
                )
            }

            val customProfiles = state.profiles.filter { it.isCustom }
            if (customProfiles.isNotEmpty()) {
                items(customProfiles) { profile ->
                    EQProfileItem(
                        profile = profile,
                        isSelected = !state.isCustom10BandEnabled && state.activeProfileId == profile.id,
                        onSelected = { onProfileSelected(profile.id) },
                        onDelete = { onDeleteProfile(profile.id) }
                    )
                }
            }
        }
    }
}

@Composable
private fun DetectedDeviceCard(
    device: DetectedAudioDevice,
    autoSwitch: Boolean,
    onToggleAutoSwitch: (Boolean) -> Unit,
    onAutoTuneDevice: () -> Unit,
    onRefreshDevice: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(
                            id = when (device.category) {
                                OutputDeviceCategory.BLUETOOTH -> R.drawable.bluetooth
                                else -> R.drawable.graphic_eq
                            }
                        ),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "ACTIVE OUTPUT DEVICE",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = device.name,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = device.category.displayType,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                IconButton(onClick = onRefreshDevice) {
                    Icon(
                        painter = painterResource(R.drawable.refresh),
                        contentDescription = "Refresh output device"
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = device.category.recommendation,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FilledTonalButton(onClick = onAutoTuneDevice) {
                    Icon(
                        painter = painterResource(R.drawable.tune),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Auto-Tune 10-Band")
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Auto-Profile",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Switch(
                        checked = autoSwitch,
                        onCheckedChange = onToggleAutoSwitch
                    )
                }
            }
        }
    }
}

@Composable
private fun PrecisionVerticalFader(
    gainDb: Double,
    isSelected: Boolean,
    onGainChange: (Double) -> Unit,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val trackBg = MaterialTheme.colorScheme.surfaceContainerHighest
    val zeroTickColor = MaterialTheme.colorScheme.outline
    val thumbStroke = MaterialTheme.colorScheme.onPrimary

    Box(
        modifier = modifier
            .height(180.dp)
            .width(42.dp)
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    onSelect()
                    val fraction = (1f - (offset.y / size.height.toFloat())).coerceIn(0f, 1f)
                    val mapped = (fraction * 30.0) - 15.0
                    onGainChange(mapped)
                }
            }
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { onSelect() }
                ) { change, _ ->
                    change.consume()
                    val fraction = (1f - (change.position.y / size.height.toFloat())).coerceIn(0f, 1f)
                    val mapped = (fraction * 30.0) - 15.0
                    onGainChange(mapped)
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2f
            val padY = 12.dp.toPx()
            val usableHeight = size.height - (padY * 2f)
            val zeroY = padY + usableHeight / 2f

            // Major scale ticks (+15, +10, +5, 0, -5, -10, -15)
            for (step in -3..3) {
                val tickY = zeroY - (step / 3f) * (usableHeight / 2f)
                val isZero = step == 0
                val halfTick = if (isZero) 14.dp.toPx() else 8.dp.toPx()
                drawLine(
                    color = if (isZero) primaryColor.copy(alpha = 0.75f) else zeroTickColor.copy(alpha = 0.35f),
                    start = Offset(centerX - halfTick, tickY),
                    end = Offset(centerX + halfTick, tickY),
                    strokeWidth = if (isZero) 1.5.dp.toPx() else 1.dp.toPx()
                )
            }

            // Center vertical track rail
            val railWidth = 5.dp.toPx()
            drawRoundRect(
                color = trackBg,
                topLeft = Offset(centerX - railWidth / 2f, padY),
                size = Size(railWidth, usableHeight),
                cornerRadius = CornerRadius(railWidth / 2f, railWidth / 2f)
            )

            // Active gain fill from 0 dB center to thumb
            val norm = ((gainDb.coerceIn(-15.0, 15.0) + 15.0) / 30.0).toFloat()
            val thumbY = padY + (1f - norm) * usableHeight
            val fillTop = minOf(zeroY, thumbY)
            val fillHeight = kotlin.math.abs(thumbY - zeroY)
            if (fillHeight > 0.5f) {
                drawRoundRect(
                    color = primaryColor,
                    topLeft = Offset(centerX - railWidth / 2f, fillTop),
                    size = Size(railWidth, fillHeight),
                    cornerRadius = CornerRadius(railWidth / 2f, railWidth / 2f)
                )
            }

            // Precision Fader Cap (EasyEffects style horizontal bar thumb)
            val capWidth = 26.dp.toPx()
            val capHeight = 14.dp.toPx()
            drawRoundRect(
                color = if (isSelected) primaryColor else primaryColor.copy(alpha = 0.88f),
                topLeft = Offset(centerX - capWidth / 2f, thumbY - capHeight / 2f),
                size = Size(capWidth, capHeight),
                cornerRadius = CornerRadius(5.dp.toPx(), 5.dp.toPx())
            )
            // Center hairline notch on fader cap
            drawLine(
                color = thumbStroke,
                start = Offset(centerX - capWidth * 0.3f, thumbY),
                end = Offset(centerX + capWidth * 0.3f, thumbY),
                strokeWidth = 1.5.dp.toPx()
            )
        }
    }
}

@Composable
private fun TenBandEqualizerCard(
    enabled: Boolean,
    gains: List<Double>,
    qs: List<Double>,
    types: List<FilterType>,
    selectedBandIndex: Int,
    preamp: Double,
    deviceName: String,
    onToggleEnabled: (Boolean) -> Unit,
    onSelectBand: (Int) -> Unit,
    onBandChanged: (Int, Double) -> Unit,
    onNudgeSelectedGain: (Double) -> Unit,
    onSelectedQChanged: (Double) -> Unit,
    onSelectedTypeChanged: (FilterType) -> Unit,
    onPreampChanged: (Double) -> Unit,
    onResetFlat: () -> Unit,
    onSaveForDevice: () -> Unit
) {
    val selectedFreqLabel = OutputDeviceCategory.TEN_BAND_LABELS.getOrElse(selectedBandIndex) { "31Hz" }
    val selectedFreqHz = OutputDeviceCategory.TEN_BAND_FREQUENCIES.getOrElse(selectedBandIndex) { 31.25 }
    val selectedGain = gains.getOrElse(selectedBandIndex) { 0.0 }
    val selectedQ = qs.getOrElse(selectedBandIndex) { OutputDeviceCategory.DEFAULT_ISO_Q }
    val selectedType = types.getOrElse(selectedBandIndex) { FilterType.PK }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "10-Band ISO Parametric EQ",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "64-Bit Biquad DSP • 0.1 dB Precision",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Switch(
                    checked = enabled,
                    onCheckedChange = onToggleEnabled
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Preamp Slider
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Preamp",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.width(56.dp)
                )
                Slider(
                    value = preamp.toFloat(),
                    onValueChange = { onPreampChanged(it.toDouble()) },
                    valueRange = -15f..15f,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = String.format(Locale.US, "%+.1f dB", preamp),
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.End,
                    modifier = Modifier.width(64.dp)
                )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            // 10-Band Precision Faders
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                OutputDeviceCategory.TEN_BAND_LABELS.forEachIndexed { index, label ->
                    val gainValue = gains.getOrElse(index) { 0.0 }
                    val isSelected = index == selectedBandIndex
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .width(54.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.10f)
                                else Color.Transparent
                            )
                            .border(
                                width = if (isSelected) 1.dp else 0.dp,
                                color = if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.5f) else Color.Transparent,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable { onSelectBand(index) }
                            .padding(vertical = 6.dp)
                    ) {
                        Text(
                            text = String.format(Locale.US, "%+.1f", gainValue),
                            style = MaterialTheme.typography.labelSmall,
                            color = if (gainValue != 0.0 || isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.Bold
                        )

                        PrecisionVerticalFader(
                            gainDb = gainValue,
                            isSelected = isSelected,
                            onGainChange = { onBandChanged(index, it) },
                            onSelect = { onSelectBand(index) }
                        )

                        Text(
                            text = label,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // EasyEffects-style Selected Band Parametric Inspector
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surfaceContainerHigh,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Band ${selectedBandIndex + 1}: $selectedFreqLabel (${String.format(Locale.US, "%.2f", selectedFreqHz)} Hz)",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = String.format(Locale.US, "%+.1f dB", selectedGain),
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // ±0.1 dB / ±0.5 dB Fine Stepper Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        OutlinedButton(
                            onClick = { onNudgeSelectedGain(-0.5) },
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
                            modifier = Modifier.weight(1f).height(34.dp)
                        ) { Text("-0.5", style = MaterialTheme.typography.labelSmall) }

                        OutlinedButton(
                            onClick = { onNudgeSelectedGain(-0.1) },
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
                            modifier = Modifier.weight(1f).height(34.dp)
                        ) { Text("-0.1", style = MaterialTheme.typography.labelSmall) }

                        OutlinedButton(
                            onClick = { onBandChanged(selectedBandIndex, 0.0) },
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
                            modifier = Modifier.weight(1f).height(34.dp)
                        ) { Text("0 dB", style = MaterialTheme.typography.labelSmall) }

                        OutlinedButton(
                            onClick = { onNudgeSelectedGain(0.1) },
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
                            modifier = Modifier.weight(1f).height(34.dp)
                        ) { Text("+0.1", style = MaterialTheme.typography.labelSmall) }

                        OutlinedButton(
                            onClick = { onNudgeSelectedGain(0.5) },
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
                            modifier = Modifier.weight(1f).height(34.dp)
                        ) { Text("+0.5", style = MaterialTheme.typography.labelSmall) }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Q-Factor (Bandwidth) Slider
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Q-Factor",
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.width(56.dp)
                        )
                        Slider(
                            value = selectedQ.toFloat(),
                            onValueChange = { onSelectedQChanged(it.toDouble()) },
                            valueRange = 0.4f..8.0f,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = String.format(Locale.US, "%.2f", selectedQ),
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.End,
                            modifier = Modifier.width(44.dp)
                        )
                    }

                    // Filter Type Selector (PK / LSC / HSC)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Filter",
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.width(48.dp)
                        )
                        listOf(
                            FilterType.PK to "Peaking (PK)",
                            FilterType.LSC to "Low Shelf",
                            FilterType.HSC to "High Shelf"
                        ).forEach { (type, title) ->
                            FilterChip(
                                selected = selectedType == type,
                                onClick = { onSelectedTypeChanged(type) },
                                label = { Text(title, style = MaterialTheme.typography.labelSmall) }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = onResetFlat,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Reset Flat")
                }
                Button(
                    onClick = onSaveForDevice,
                    modifier = Modifier.weight(1.4f)
                ) {
                    Text(
                        text = "Save for $deviceName",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Composable
private fun NoEqualizationItem(
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    ListItem(
        headlineContent = {
            Text(
                stringResource(R.string.eq_disabled),
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
            )
        },
        leadingContent = {
            RadioButton(
                selected = isSelected,
                onClick = onSelected
            )
        },
        modifier = Modifier
            .clickable(onClick = onSelected)
            .padding(horizontal = 8.dp)
    )
}

@Composable
private fun EQProfileItem(
    profile: SavedEQProfile,
    isSelected: Boolean,
    onSelected: () -> Unit,
    onDelete: () -> Unit
) {
    var showDeleteDialog by remember { mutableStateOf(false) }

    ListItem(
        headlineContent = {
            Text(
                text = profile.deviceModel,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
            )
        },
        supportingContent = {
            Text(
                pluralStringResource(
                    id = R.plurals.band_count,
                    count = profile.bands.size,
                    profile.bands.size
                )
            )
        },
        leadingContent = {
            RadioButton(
                selected = isSelected,
                onClick = onSelected
            )
        },
        trailingContent = {
            IconButton(onClick = { showDeleteDialog = true }) {
                Icon(
                    painter = painterResource(R.drawable.delete),
                    contentDescription = stringResource(R.string.delete_profile_desc),
                    tint = MaterialTheme.colorScheme.error
                )
            }
        },
        modifier = Modifier
            .clickable(onClick = onSelected)
            .padding(horizontal = 8.dp)
    )

    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text(stringResource(R.string.delete_profile_desc)) },
            text = {
                Text(
                    stringResource(R.string.delete_profile_confirmation, profile.name)
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDelete()
                        showDeleteDialog = false
                    }
                ) {
                    Text(stringResource(android.R.string.ok))
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) {
                    Text(stringResource(android.R.string.cancel))
                }
            }
        )
    }
}
