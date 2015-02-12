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
package io.github.canarybukkitteam.hawklib.hook;

import io.github.lexware.unolib.Wrapper;

import java.lang.reflect.Field;

public class CancelableHook extends Wrapper<net.canarymod.hook.CancelableHook> {
    public CancelableHook(net.canarymod.hook.CancelableHook handle) {
        super(handle);
    }

    /**
     * Gets if the {@link net.canarymod.hook.Hook} has been cancelled.
     *
     * @return Is this {@link net.canarymod.hook.Hook} cancelled
     */
    public boolean isCanceled() {
        return getHandle().isCanceled();
    }

    /**
     * Sets the cancelled state of the {@link net.canarymod.hook.Hook}.
     *
     * @param cancel The new cancelled state
     */
    public void setCanceled(boolean cancel) throws NoSuchFieldException, IllegalAccessException {
        Field field = net.canarymod.hook.CancelableHook.class.getDeclaredField("isCanceled");
        field.setAccessible(true);
        field.set(getHandle(), cancel);
    }
}
