rootProject.name = "SimpleBlockRegenAPI"

enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            alias("spigot16").to("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
            alias("lombok").to("org.projectlombok:lombok:1.18.24")
            alias("shibacraftLibrary").to("com.github.Skjolberg:ShibacraftLibrary:0.1.0")
        }
    }
}

