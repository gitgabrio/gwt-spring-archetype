gwt-spring-archetype
====================
This archetype will create a simple GWT+Spring project. The generate application will show a login page.

For the client side the eventbus architecture has been used to allow component decoupling.
 
For the server side the components are managed by the Spring framework.

About the container
-------------------
The application makes use of the new Servlet 3.0 specification, i.e. it does not use web.xml but it is completely managed by annotation. 
The drawback of this approach is that (currently) it does not run inside the Jetty server (embedded with the GWT environment) so Tomcat should be used for development. 
The generated Readme.md contains instructions on how to do that.
