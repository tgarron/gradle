/*
 * Copyright 2007-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle;

import org.gradle.api.initialization.Settings;
import org.gradle.api.invocation.Gradle;
import org.gradle.api.execution.TaskExecutionGraph;

/**
 * <p>A {@code BuildListener} is notified of the major lifecycle events as a {@link GradleLauncher} instance executes a
 * build.</p>
 *
 * @author Hans Dockter
 * @see org.gradle.api.invocation.Gradle#addListener(Object)
 */
public interface BuildListener {
    /**
     * <p>Called when the build is started.</p>
     *
     * @param gradle The build which is being started. Never null.
     */
    void buildStarted(Gradle gradle);

    /**
     * <p>Called when the build settings have been loaded and evaluated. The settings object is fully configured and is
     * ready to use to load the build projects.</p>
     *
     * @param settings The settings. Never null.
     */
    void settingsEvaluated(Settings settings);

    /**
     * <p>Called when the projects for the build have been created from the settings. None of the projects have been
     * evaluated.</p>
     *
     * @param gradle The build which has been loaded. Never null.
     */
    void projectsLoaded(Gradle gradle);

    /**
     * <p>Called when all projects for the build have been evaluated. The project objects are fully configured and are
     * ready to use to populate the task graph.</p>
     *
     * @param gradle The build which has been evaluated. Never null.
     */
    void projectsEvaluated(Gradle gradle);

    /**
     * <p>Called when the task graph for the build has been populated. The task graph is fully configured and is ready
     * to use to execute the tasks which make up the build.</p>
     *
     * @param graph The task graph. Never null.
     */
    void taskGraphPopulated(TaskExecutionGraph graph);

    /**
     * <p>Called when the build is completed. All selected tasks have been executed.</p>
     *
     * @param result The result of the build. Never null.
     */
    void buildFinished(BuildResult result);
}
