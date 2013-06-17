
Swing Look & Feel selector
--------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/lookandfeel](http://artifacts.griffon-framework.org/plugin/lookandfeel)


Provides a pluggable mechanism to set the Look & Feel of a Griffon application, even once the application is running.

Usage
-----

This plugin operates under the notion that Look & Feel settings can be manipulated by `griffon.lookandfeel.LookAndFeelManager`
using a pair of helper classes: `LookAndFeelProvider` (lookAndFeel) and `LookAndFeelInfo` (theme). LookAndFeelProviders are
responsible for grouping together a set of LookAndFeelInfos. For example the 'System' lookAndFeel contains the basic themes
available in all platforms. The mechanism for discovering lookAndFeels and themes is pluggable. There are several plugins that
provide additional Look & Feel settings in this way.

`LookAndFeelManager` is a singleton. It provides several useful methods to query and set a Look & Feel. The most interesting
one is **showLafDialog(GriffonApplication)**. It's responsibility is to display dialog on which the user can pick and choose
a provider/info combination.

Configuration
-------------

`LookAndFeelManager` will attempt to set a lookAndFeel/theme combination at boot time if the following flags are set in
`Config.groovy`:

 * `lookandfeel.lookAndFeel` - defaults to 'System'.
 * `lookandfeel.theme` - defaults to 'System' on MacOSX, 'Nimbus' otherwise.

Additional L&F properties can be set at app startup if `lookandfeel.props` is set.
It is also possible to define a hot key for launching the L&F selection window, just specify a String value for
`lookandfeel.keystroke` that can be parsed by Swing's KeyStroke class, for example

        lookandfeel.keystroke = 'shift meta L'

The following events are triggered by `LookAndFeelManager`

 * LookAndFeelPreview[currentLookAndFeelProvider, currentLookAndFeelInfo, previewLookAndFeelInfo] - when the 'Preview' button 
 of the L&F window is clicked
 * LookAndFeelApply[currentLookAndFeelProvider, currentLookAndFeelInfo, newLookAndFeelInfo] - when the 'OK' button of the L&F
 window is clicked
 * LookAndFeelChanged[newLookAndFeelProvider, newLookAndFeelInfo, newLookAndFeel] - when the L&F has been changed successfully

LookAndFeel and Themes
----------------------

| *LookAndFeel* | *Theme*         |
| ------------- | --------------- |
| System        | CrossPlatform   |
|               | Metal           |
|               | Motif           |
|               | Nimbus          |
|               | System          |

