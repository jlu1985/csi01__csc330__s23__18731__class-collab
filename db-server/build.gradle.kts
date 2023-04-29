plugins {
   application
}

dependencies {
    implementation("org.hsqldb:hsqldb:2.7.1")
}

application{
    mainClass.set("DbServerApplication")
}