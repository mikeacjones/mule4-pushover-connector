# Mule 4 Pushover Connector
![Publish package](https://github.com/mikeacjones/mule4-pushover-connector/workflows/Publish%20package/badge.svg)

This connector provides easy use of the Pushover notification service, which can be used for free by individuals. Organization use is monetized.

For more information on the connector, or to setup an account, visit [https://pushover.net](https://pushover.net). Once logged in, you can access your user key from the main page.

## Installation
You have three main options for installation:

1. Download the JAR file from the packages page and run this command: `mvn install:install-file -Dfile=<path-to-file> -DgroupId=com.mikej.connectors -DartifactId=pushover-connector -Dversion=1.0.1 -Dclassifer=mule-plugin -Dpackaging=jar`
2. Download the JAR file and the POM file and run this command: `mvn install:install-file -Dfile=<path-to-file> -DpomFile=<path-to-pomfile>`
3. Setup your maven to pull down the package using the GitHub Maven Repository:
   Generate a GitHub Token with package read scope
   In your settings.xml file add a new sever entry:
    ```xml
    <server>
      <id>github-pushover</id>
      <username>YOUR GITHUB USERNAME</username>
      <password>GITHUB TOKEN</password>
    </server>
    ```
   In your settings.xml OR in your POM.xml add a new repository
    ```xml
    <repository>
      <id>github-pushover</id>
      <name>GitHub Pushover Connector</name>
      <url>https://maven.pkg.github.com/mikeacjones/mule4-pushover-connector</url>
      <releases><enabled>true</enabled></releases>
      <snapshots><enabled>true</enabled></snapshots>
    </repository>
    ```

## Usage
Once your have your user and account tokens from pushover, you create a global config with the account token. The individual messages use the user token as the target.

Pushover supports a single opertation, to push a message.

* Message: Message content
* URL: If you would like to include a clickable link
* URL Title: By default, the URL just shows the URL but if you would like to show the link with specific text instead set the title here.
* Title: Displayed title of the message.
* Message Priority:  send as `NO_NOTIFICATION` to generate no notification/alert, `QUITE_NOTIFICATION` to always send as a quiet notification, `HIGH_PRIORITY` to display as high-priority and bypass the user's quiet hours, or `REQUIRE_CONFIRMATION` to also require confirmation from the user. Use `NORMAL` for everything else.
* Override Message Unix Timestamp: If you want to override the time that the message was created at, provide a Unix timestamp.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
