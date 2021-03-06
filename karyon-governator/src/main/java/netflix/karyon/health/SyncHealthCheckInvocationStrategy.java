/*
 * Copyright 2013 Netflix, Inc.
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package netflix.karyon.health;

import javax.inject.Inject;
import java.util.concurrent.TimeoutException;

/**
 * An implementation of {@link netflix.karyon.health.HealthCheckInvocationStrategy} that synchronously calls the underlying
 * {@link netflix.karyon.health.HealthCheckHandler}.
 *
 * @author Nitesh Kant
 */
@SuppressWarnings("unused")
public class SyncHealthCheckInvocationStrategy implements HealthCheckInvocationStrategy {

    private final HealthCheckHandler handler;

    @Inject
    public SyncHealthCheckInvocationStrategy(HealthCheckHandler handler) {
        this.handler = handler;
    }

    @Override
    public int invokeCheck() throws TimeoutException {
        return handler.getStatus();
    }

    @Override
    public HealthCheckHandler getHandler() {
        return handler;
    }
}
