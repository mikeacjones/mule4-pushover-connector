package net.mikej.connectors.internal;

import net.mikej.connectors.internal.connection.PushoverConnectionProvider;
import net.mikej.connectors.internal.operations.PushoverOperations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;

@Xml(prefix = "pushover")
@Extension(name = "Pushover")
@ConnectionProviders({ PushoverConnectionProvider.class })
@Operations({ PushoverOperations.class })
public class PushoverConnector {
}