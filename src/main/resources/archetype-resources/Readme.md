#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
${artifactId}
==============
This software is a GWT + Spring application. It provide a simple "Login" form and makes use of events to decouple views and components.
The Spring context read run-time properties from ".properties" files inside src/main/config.
This properties are set at compile-time from the maven profile used.

Profiles
========
Maven profiles, as explained above, are used to set environment specific configuration at compile-time.
The application also use "spring" profile to choose the persistence configuration used during test. 
This is controlled by the parameter "spring.profiles.active" - possible values are "prod, dev, test".

Build
-----
The command to cleanly generate the full war is:
    
       mvn gwt:clean clean compile gwt:compile war:war (-DskipTests) -P (profile, eventually comma-separated)

Deploy and run
--------------
Generated war may be deployed in an application server (tested on Tomcat).
It is also possible to run it with the tomcat7 plugin
    
    mvn tomcat7:run-war (-DskipTests) -P (profile, eventually comma-separated)

Debug
-----
Debugging a GWT application involve debug both server-side and client-side code.
The most commonly tool used is the "gwt:debug" mode running with the embedded Jetty server. Unfortunately, the Jetty
server does not support the no-web.xml style configuration (web application configured only with java), so it can not be used.

Different options are available for server side debugging:

+ start a remote server in debug mode (catalina.sh jpda start) and connect to it
+ start the tomcat7:war goal in debug mode, and connect to it (default port:5005).

    mvnDebug tomcat7:run-war (-DskipTests) -P (profile, eventually comma-separated)

To debug client-side code, some background information could be useful.
For client-side debugging, GWT provide an internal server - the CodeServer - that usually run on port 9876. In debug mode, browser load client-side code from that server. 


"gwt:compile" goal create some files (namely ${artifactId}.devmode.js) that should be in the static directory
(/${artifactId}) provided by the server.
 
"gwt:debug" or "gwt:run" fire up the CodeServer (default to port 9876) needed for client debug. It is important that the server could read and provide the files generated
with "gwt:compile". 

The two settings involved in this are "launcherDir" and "outputDirectory": "launchedDir" is the directory read prom the CodeServer, while outputDirectory is the directory where the compiled files are written.

By default they point to the "target/${artifactId}" directory - the same used by the tomcat7-run goal.

So, if tomcat7:run-war goal is used, firing up "gwt:run" (or gwt:debug) should start the CodeServer pointing to the right directory.

If an external Tomcat is used, the two parameters should point to the (catalina_dir)/webapp/${artifactId}.<p/>
At this point, it is possible to debug the client side from the browser or, better, launch Chrome browser in debug mode (with IntelliJ, this is possible creating a "JavaScript Debug" configuration).
 
TEST
====
Testing is done using JUnit tests. To test server-side code with the initialized Spring container, all the test classes should extend
AbstractContextTest java. Tests must be done with the Maven test profile or, if started directly by the IDE,
using the Spring "test" profile (for example, IntelliJ provide a way to configure the current active profile).

