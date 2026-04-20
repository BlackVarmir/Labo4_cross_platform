package ua.edu.chnu.kkn.labs.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import labo2_cross_platform.composeapp.generated.resources.Res
import labo2_cross_platform.composeapp.generated.resources.buttons
import labo2_cross_platform.composeapp.generated.resources.checkboxes
import labo2_cross_platform.composeapp.generated.resources.current_date
import labo2_cross_platform.composeapp.generated.resources.current_time
import labo2_cross_platform.composeapp.generated.resources.current_timezone
import co.touchlab.kermit.Logger
import org.jetbrains.compose.resources.stringResource
import ua.edu.chnu.kkn.labs.data.timezones.TimeZoneHelper
import ua.edu.chnu.kkn.labs.data.timezones.TimeZoneHelperImpl

@Composable
fun MainScreen(
    onButtonsClicked: () -> Unit,
    onCheckboxesClicked: () -> Unit,
) {
    val timeZoneHelper: TimeZoneHelper = remember { TimeZoneHelperImpl() }
    val currentTimeZone = remember { timeZoneHelper.currentTimeZone() }
    val currentTime = remember { timeZoneHelper.currentTime() }
    val currentDate = remember { timeZoneHelper.getDate(currentTimeZone) }

    LaunchedEffect(Unit) {
        Logger.i { "MainScreen: currentTimeZone=$currentTimeZone" }
        Logger.i { "MainScreen: currentTime=$currentTime" }
        Logger.i { "MainScreen: currentDate=$currentDate" }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(Res.string.current_timezone, currentTimeZone),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = stringResource(Res.string.current_date, currentDate),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = stringResource(Res.string.current_time, currentTime),
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                Logger.d { "MainScreen: Buttons button clicked" }
                onButtonsClicked()
            }
        ) {
            Text(stringResource(Res.string.buttons))
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                Logger.d { "MainScreen: Checkboxes button clicked" }
                onCheckboxesClicked()
            }
        ) {
            Text(stringResource(Res.string.checkboxes))
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(
        {},
    ) {}
}
