package io.quarkiverse.operatorsdk.runtime;

import java.util.List;
import java.util.Optional;

import io.quarkus.runtime.annotations.ConfigGroup;
import io.quarkus.runtime.annotations.ConfigItem;

@ConfigGroup
public class ExternalControllerConfiguration {

    /**
     * An optional list of comma-separated namespace names the controller should watch. If this
     * property is left empty then the controller will watch all namespaces.
     */
    @ConfigItem
    public Optional<List<String>> namespaces;

    /**
     * The optional name of the finalizer for the controller. If none is provided, one will be
     * automatically generated.
     */
    @ConfigItem
    public Optional<String> finalizer;

    /**
     * Whether the controller should only process events if the associated resource generation has
     * increased since last reconciliation, otherwise will process all events.
     */
    @ConfigItem(defaultValue = "true")
    public Optional<Boolean> generationAware;

    /**
     * The optional controller retry configuration
     */
    @ConfigItem
    public Optional<ExternalRetryConfiguration> retry;

    /**
     * The optional fully qualified name of a CDI event class that the controller will wait for before
     * registering with the Operator.
     */
    public Optional<String> delayRegistrationUntilEvent;
}
