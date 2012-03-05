/*
 * Copyright 2010-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class LookandfeelGriffonPlugin {
    // the plugin version
    String version = '0.6'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '0.9.5 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [miglayout: '0.4']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-lookandfeel-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'Swing Look & Feel selector'
    String description = '''
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
|               | Metal           |
|               | Motif           |
|               | Nimbus          |
|               | System          |
'''
}