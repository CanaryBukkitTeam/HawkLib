/*
 * Copyright 2015 CanaryBukkit Team <https://github.com/CanaryBukkitTeam>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.canarybukkitteam.hawklib.logging;

import net.canarymod.logger.Logman;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CanaryLogger extends Logger {
    private final Logman logman;

    /**
     * Use Canary's Logman as a Logger
     * @param logman The Logman to log to.
     */
    public CanaryLogger(Logman logman) {
        super(logman.getName(), null);
        this.logman = logman;
    }

    @Override
    public final void log(Level level, String msg) {
        org.apache.logging.log4j.Level convertedLevel = null;
        if (level == Level.INFO) {
            convertedLevel = org.apache.logging.log4j.Level.INFO;
        }
        if (level == Level.SEVERE) {
            convertedLevel = org.apache.logging.log4j.Level.ERROR;
        }
        if (level == Level.WARNING) {
            convertedLevel = org.apache.logging.log4j.Level.WARN;
        }
        if (level == Level.FINE || level == Level.FINER || level == Level.FINEST) {
            convertedLevel = org.apache.logging.log4j.Level.TRACE;
        }
        getHandle().log(convertedLevel, msg);
    }

    private Logman getHandle() {
        return logman;
    }
}
