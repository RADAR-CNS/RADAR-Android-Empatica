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

package org.radarcns.empatica;

import org.radarcns.android.device.DeviceTopics;
import org.radarcns.kafka.ObservationKey;
import org.radarcns.passive.empatica.EmpaticaE4Acceleration;
import org.radarcns.passive.empatica.EmpaticaE4BatteryLevel;
import org.radarcns.passive.empatica.EmpaticaE4BloodVolumePulse;
import org.radarcns.passive.empatica.EmpaticaE4ElectroDermalActivity;
import org.radarcns.passive.empatica.EmpaticaE4InterBeatInterval;
import org.radarcns.passive.empatica.EmpaticaE4SensorStatus;
import org.radarcns.passive.empatica.EmpaticaE4Temperature;
import org.radarcns.topic.AvroTopic;

/** Topic manager for topics concerning the Empatica E4. */
public class E4Topics extends DeviceTopics {
    private final AvroTopic<ObservationKey, EmpaticaE4Acceleration> accelerationTopic;
    private final AvroTopic<ObservationKey, EmpaticaE4BatteryLevel> batteryLevelTopic;
    private final AvroTopic<ObservationKey, EmpaticaE4BloodVolumePulse> bloodVolumePulseTopic;
    private final AvroTopic<ObservationKey, EmpaticaE4ElectroDermalActivity> edaTopic;
    private final AvroTopic<ObservationKey, EmpaticaE4InterBeatInterval> interBeatIntervalTopic;
    private final AvroTopic<ObservationKey, EmpaticaE4Temperature> temperatureTopic;
    private final AvroTopic<ObservationKey, EmpaticaE4SensorStatus> sensorStatusTopic;

    private static final Object syncObject = new Object();
    private static E4Topics instance = null;

    public static E4Topics getInstance() {
        synchronized (syncObject) {
            if (instance == null) {
                instance = new E4Topics();
            }
            return instance;
        }
    }

    private E4Topics() {
        accelerationTopic = createTopic("android_empatica_e4_acceleration",
                EmpaticaE4Acceleration.getClassSchema(),
                EmpaticaE4Acceleration.class);
        batteryLevelTopic = createTopic("android_empatica_e4_battery_level",
                EmpaticaE4BatteryLevel.getClassSchema(),
                EmpaticaE4BatteryLevel.class);
        bloodVolumePulseTopic = createTopic("android_empatica_e4_blood_volume_pulse",
                EmpaticaE4BloodVolumePulse.getClassSchema(),
                EmpaticaE4BloodVolumePulse.class);
        edaTopic = createTopic("android_empatica_e4_electrodermal_activity",
                EmpaticaE4ElectroDermalActivity.getClassSchema(),
                EmpaticaE4ElectroDermalActivity.class);
        interBeatIntervalTopic = createTopic("android_empatica_e4_inter_beat_interval",
                EmpaticaE4InterBeatInterval.getClassSchema(),
                EmpaticaE4InterBeatInterval.class);
        temperatureTopic = createTopic("android_empatica_e4_temperature",
                EmpaticaE4Temperature.getClassSchema(),
                EmpaticaE4Temperature.class);
        sensorStatusTopic = createTopic("android_empatica_e4_sensor_status",
                EmpaticaE4SensorStatus.getClassSchema(),
                EmpaticaE4SensorStatus.class);
    }

    public AvroTopic<ObservationKey, EmpaticaE4Acceleration> getAccelerationTopic() {
        return accelerationTopic;
    }

    public AvroTopic<ObservationKey, EmpaticaE4BatteryLevel> getBatteryLevelTopic() {
        return batteryLevelTopic;
    }

    public AvroTopic<ObservationKey, EmpaticaE4BloodVolumePulse> getBloodVolumePulseTopic() {
        return bloodVolumePulseTopic;
    }

    public AvroTopic<ObservationKey, EmpaticaE4ElectroDermalActivity> getElectroDermalActivityTopic() {
        return edaTopic;
    }

    public AvroTopic<ObservationKey, EmpaticaE4InterBeatInterval> getInterBeatIntervalTopic() {
        return interBeatIntervalTopic;
    }

    public AvroTopic<ObservationKey, EmpaticaE4Temperature> getTemperatureTopic() {
        return temperatureTopic;
    }

    public AvroTopic<ObservationKey, EmpaticaE4SensorStatus> getSensorStatusTopic() {
        return sensorStatusTopic;
    }
}
