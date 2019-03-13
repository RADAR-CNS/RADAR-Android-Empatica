/*
 * Copyright 2017 The Hyve
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.radarcns.empatica

import android.Manifest.permission.*
import android.content.pm.PackageManager
import org.radarbase.android.device.DeviceServiceProvider

class E4ServiceProvider : DeviceServiceProvider<E4DeviceStatus>() {
    override val serviceClass = E4Service::class.java

    override val permissionsNeeded = listOf(ACCESS_COARSE_LOCATION, BLUETOOTH, BLUETOOTH_ADMIN)
    override val featuresNeeded = listOf(PackageManager.FEATURE_BLUETOOTH, PackageManager.FEATURE_BLUETOOTH_LE)

    override val description
        get() = radarService?.getString(R.string.empatica_e4_explanation)
    override val hasDetailView = true
    override val displayName: String
        get() = radarService?.getString(R.string.empaticaE4DisplayName) ?: "E4"

    override val isFilterable = true

    override val sourceProducer = "Empatica"
    override val sourceModel = "E4"
    override val version = BuildConfig.VERSION_NAME
}
